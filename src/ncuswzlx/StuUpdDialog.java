/*
 * 修改学生信息
 */
package ncuswzlx;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class StuUpdDialog extends JDialog implements ActionListener{
	//定义我需要的swing组件
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	//必须是这样的顺序
	//创建需要组件，设置布局，添加组件
	
	    //owner它的父窗口;title窗口名;model指定是模态窗口，还是非模态
	  public StuUpdDialog(Frame owner,String title,boolean modal,StuModel sm,int rowNums)
	  {
		super(owner,title,modal);//调用父类构造方法，达到模式对话框效果
		jl1=new JLabel("证件号/物品名");
		jl2=new JLabel("失主姓名");
		jl3=new JLabel("登记批数");
		jl4=new JLabel("丢失地");
		jl5=new JLabel("丢失时间登记");
		jl6=new JLabel("失主联系方式");
		
		jtf1=new JTextField();
		jtf1.setText((String)sm.getValueAt(rowNums, 0));
		//让jtf1不能修改
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText((String)sm.getValueAt(rowNums, 1));
		jtf3=new JTextField();
		jtf3.setText((String)sm.getValueAt(rowNums, 2));
		jtf4=new JTextField();
		jtf4.setText(sm.getValueAt(rowNums, 3).toString());
		jtf5=new JTextField();
		jtf5.setText((String)sm.getValueAt(rowNums, 4));
		jtf6=new JTextField();
		jtf6.setText((String)sm.getValueAt(rowNums, 5));
		
		
		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//设置布局
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
	    //添加事件监听
		
		
		
		//展现
	    this.setLocation(500, 300);
		this.setSize(400, 250);
		this.setVisible(true);
	}
  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
		
				String str = "update xzhengjian set Name = ? , Type = ? , Place = ? ,Time = ?,Now =? where Id = ?";
				String [] paras={jtf2.getText(),jtf3.getText(),
						jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
				StuModel temp = new StuModel();
				temp.updStu(str, paras);
				this.dispose();  
			
		}
		else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
     
}

