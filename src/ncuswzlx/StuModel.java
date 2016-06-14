/*
 * 这是一个STU表模型
 * 
 */

package ncuswzlx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;

public class StuModel extends AbstractTableModel{

	//rowData用来存放行数据
			//columnNames用来存放列名

	         Vector rowData,columnNames;

		     PreparedStatement ps = null;
		     Connection ct = null;
		     ResultSet rs = null;
	//得到共有多少行
    //做一个构造函数，用于初始化数据模型
		     String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ncuswzl";
		     String user="sa";
		     String passwd="33269456";
		     String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		     
		     //添加学生（增，删，改）都可以由这个函数
		     public boolean updStu(String sql,String []paras)
		     {
		    	 boolean b = true;
		    	 
		    	 try {
		    		 //加载驱动
		    		 Class.forName(driver);
		    		 //得到连接
		             ct=DriverManager.getConnection(url,user,passwd);
		             
		             ps=ct.prepareStatement(sql);
		    		 
		    		 for(int i = 0;i<paras.length;i++)
		    		 {
		    			 ps.setString(i+1, paras[i]);
		    		 }
		    		 if(ps.executeUpdate()!=1)
		    		 {
		    			 b=false; 
		    		 }
		    			 
		             
		    	 }catch(Exception e){
		    		 b=false;
		    		 e.printStackTrace();
		    		 
		    	 }finally{
			 		  try
		 			  {
		 			    if(rs!=null) rs.close();
		 			    if(ps!=null) ps.close();
		 			    if(ct!=null) ct.close();
		 			    
		 			  }catch(Exception e)
		 			{
		 				b=false;
		 				e.printStackTrace();
		 			}
		    		 
		    	 }
		    	 return b;
		     }
		     
		     
		     public void init(String sql)
		     {
		    	   if(sql.equals(""))
		    	   {
		    		   sql="select * from xzhengjian";
		    	   }
		    	   
		    	    //存储列名的向量表
			 		columnNames=new Vector();
			 		//存储行数据的向量表
			 		rowData = new Vector();
			 		
			 		//设置列明
			 		columnNames.add("证件号/物品名");
			 		columnNames.add("失主姓名");
			 		columnNames.add("登记批数");
			 		columnNames.add("丢失地");
			 		columnNames.add("丢失时间登记");
			 		columnNames.add("失主联系方式");
			 		
			 		try{
			 			//加载驱动
			 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ncuswzl","sa","33269456");
			 			ps=ct.prepareStatement(sql);
			 			rs=ps.executeQuery();
			 			
			 			while(rs.next())
			 			{
			 				Vector hang = new Vector();
			 				hang.add(rs.getString(1));
			 				hang.add(rs.getString(2));
			 				hang.add(rs.getString(3));
			 				hang.add(rs.getString(4));
			 				hang.add(rs.getString(5));
			 				hang.add(rs.getString(6));
			 				
			 				rowData.add(hang);
			 				
			 			}
			 			
			 		}catch(Exception e)
			 		{
			 			e.printStackTrace();
			 			
			 		}finally{
			 		  try
			 			  {
			 			    if(rs!=null) rs.close();
			 			    if(ps!=null) ps.close();
			 			    if(ct!=null) ct.close();
			 			    
			 			  }catch(Exception e)
			 			{
			 				e.printStackTrace();
			 			}
			 		}
			    	 
		     }
		     
		     public StuModel(String sql)
		     {
		    	 
			    	this.init(sql); 
		     }

		     public StuModel()
		     {
		    	    this.init("");
		     }
		     
		     
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//得到共有多少列
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
   
	//得到某行某列数据
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		
		return ((Vector)this.rowData.get(row)).get(column);
	}


	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) this.columnNames.get(column);
	}
    
}
