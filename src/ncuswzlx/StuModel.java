/*
 * ����һ��STU��ģ��
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

	//rowData�������������
			//columnNames�����������

	         Vector rowData,columnNames;

		     PreparedStatement ps = null;
		     Connection ct = null;
		     ResultSet rs = null;
	//�õ����ж�����
    //��һ�����캯�������ڳ�ʼ������ģ��
		     String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ncuswzl";
		     String user="sa";
		     String passwd="33269456";
		     String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		     
		     //���ѧ��������ɾ���ģ����������������
		     public boolean updStu(String sql,String []paras)
		     {
		    	 boolean b = true;
		    	 
		    	 try {
		    		 //��������
		    		 Class.forName(driver);
		    		 //�õ�����
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
		    	   
		    	    //�洢������������
			 		columnNames=new Vector();
			 		//�洢�����ݵ�������
			 		rowData = new Vector();
			 		
			 		//��������
			 		columnNames.add("֤����/��Ʒ��");
			 		columnNames.add("ʧ������");
			 		columnNames.add("�Ǽ�����");
			 		columnNames.add("��ʧ��");
			 		columnNames.add("��ʧʱ��Ǽ�");
			 		columnNames.add("ʧ����ϵ��ʽ");
			 		
			 		try{
			 			//��������
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

	//�õ����ж�����
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
   
	//�õ�ĳ��ĳ������
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
