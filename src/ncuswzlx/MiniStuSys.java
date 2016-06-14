/*
 * 一个迷你版的学生管理系统
 * 72讲10分
 * model2模式
 *  
 */
package ncuswzlx;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;

import java.io.*;

public class MiniStuSys extends JFrame implements ActionListener{

	Image titleIcon;
	//定义组件
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;
	JTable jt;
	JScrollPane jsp;
	JTextField jtf;
	StuModel sm ;
 
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        MiniStuSys stu = new MiniStuSys();
	}
	public MiniStuSys()
	{		
		//创建组件
		//查询学生信息GUI模块
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
	
		
		jp1 = new JPanel();
        
		jl1 = new JLabel("请输入查询条件:");
		//定义一个文本框，参数为文本框数入文本的最大长度
		jtf = new JTextField(20);
		jb1 = new JButton("证件号查询");
		//对查询按钮进行事件监听
		jb1.setBackground(Color.white);
        jb1.addActionListener(this);
        
        jb5 = new JButton("名字查询");
        jb5.addActionListener(this);
        
        jb6 = new JButton("丢失地点查询");
        jb6.addActionListener(this);
        
        jb7 = new JButton("拾到时间查询");
        jb7.addActionListener(this);
        
        jb8 = new JButton("按登记批数查询");
        jb8.addActionListener(this);
        
		//将查询相关的三个组件添加到第一块面板中
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb5);
		jp1.add(jb6);
		jp1.add(jb7);
		jp1.add(jb8);
		
		//增删修改学生信息GUI模块
		jp2=new JPanel();
		jb2 = new JButton("添加");
		//对添加按钮进行事件监听
		jb2.addActionListener(this);
		jb3 = new JButton("修改");
		//对修改按钮进行事件监听
		jb3.addActionListener(this);
		jb4 = new JButton("删除");
		//对删除按钮进行事件监听
		jb4.addActionListener(this);
	
		//把与更新数据有关的组件放到一个面板中
	    jp2.add(jb2);
	    jp2.add(jb3);
	    jp2.add(jb4);
	    
	    //实例化一个表模型对象
	    
	    StuModel sm = new StuModel();
	    //把对象放入到JTable中，就是把数据传到里面
	    jt = new JTable(sm);
	    jsp = new JScrollPane(jt);
		
	    //设置三个模块布局
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		//设置主窗口属性
		this.setTitle("南昌大学证件类失物管理系统（失物信息数据库）");
		this.setSize(w,h-30);
		this.setLocation(0, 0);
		this.setIconImage(titleIcon);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//事件处理
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1)
		{
		    //System.out.print("用户希望查询");
		    //查询数据库，更新JTable
			//因为把对标的数据封装到了StuModel中，查询得以实现
			String id = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Id = '"+id+"'";
		
		    //新的数据模型类
			sm = new StuModel(sql);
			//更新表中数据
			jt.setModel(sm);
		}
		
		else if(e.getSource()==jb5)
		{
		    //System.out.print("用户希望查询");
		    //查询数据库，更新JTable
			//因为把对标的数据封装到了StuModel中，查询得以实现
			String name = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Name = '"+name+"'";
		
		    //新的数据模型类
			sm = new StuModel(sql);
			//更新表中数据
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb6)
		{
		    //System.out.print("用户希望查询");
		    //查询数据库，更新JTable
			//因为把对标的数据封装到了StuModel中，查询得以实现
			String place = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Place = '"+place+"'";
		
		    //新的数据模型类
			sm = new StuModel(sql);
			//更新表中数据
			jt.setModel(sm);
		}
		else if(e.getSource()==jb7)
		{
			String time = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Time = '"+time+"'";
		
		    //新的数据模型类
			sm = new StuModel(sql);
			//更新表中数据
			jt.setModel(sm);
			
		}
		
		else if(e.getSource() == jb8)
		{
			String type = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Type = '"+type+"'";
		
		    //新的数据模型类
			sm = new StuModel(sql);
			//更新表中数据
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb3)
		{
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showConfirmDialog(this, "请选择一行");
				return;
			}
			
			sm=new StuModel();
			new StuUpdDialog(this,"修改学生信息",true,sm,rowNum);
			sm=new StuModel();
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb2)
		{
		    //用模式对话框
			StuAddDialog sa = new StuAddDialog(this,"添加学生",true);
		   
			//更新数据显示
			sm=new StuModel();
		    jt.setModel(sm);	    
		}
		else if(e.getSource()==jb4)
		{
			//用户要删除记录
			//得到学生ID
			//getSelectedRow返回用户点中的行
			//没选返回-1
			int rowNum = this.jt.getSelectedRow();
		    if(rowNum==-1)
		    {
		    	JOptionPane.showMessageDialog(this,"请选择一行");
		        return;
		    }
		    //得到学生ID
		    sm=new StuModel();
		    String stuId = (String)sm.getValueAt(rowNum, 0);
		    //创建一个sql语句
		    String sql="delete from xzhengjian where Id=?";
		    String[] paras = {stuId};
		    StuModel temp = new StuModel();
		    temp.updStu(sql, paras);
		    
		    sm=new StuModel();
		    jt.setModel(sm);
		}	
           		
	}

}
