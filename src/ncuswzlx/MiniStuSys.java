/*
 * һ��������ѧ������ϵͳ
 * 72��10��
 * model2ģʽ
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
	//�������
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
		//�������
		//��ѯѧ����ϢGUIģ��
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
	
		
		jp1 = new JPanel();
        
		jl1 = new JLabel("�������ѯ����:");
		//����һ���ı��򣬲���Ϊ�ı��������ı�����󳤶�
		jtf = new JTextField(20);
		jb1 = new JButton("֤���Ų�ѯ");
		//�Բ�ѯ��ť�����¼�����
		jb1.setBackground(Color.white);
        jb1.addActionListener(this);
        
        jb5 = new JButton("���ֲ�ѯ");
        jb5.addActionListener(this);
        
        jb6 = new JButton("��ʧ�ص��ѯ");
        jb6.addActionListener(this);
        
        jb7 = new JButton("ʰ��ʱ���ѯ");
        jb7.addActionListener(this);
        
        jb8 = new JButton("���Ǽ�������ѯ");
        jb8.addActionListener(this);
        
		//����ѯ��ص����������ӵ���һ�������
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb5);
		jp1.add(jb6);
		jp1.add(jb7);
		jp1.add(jb8);
		
		//��ɾ�޸�ѧ����ϢGUIģ��
		jp2=new JPanel();
		jb2 = new JButton("���");
		//����Ӱ�ť�����¼�����
		jb2.addActionListener(this);
		jb3 = new JButton("�޸�");
		//���޸İ�ť�����¼�����
		jb3.addActionListener(this);
		jb4 = new JButton("ɾ��");
		//��ɾ����ť�����¼�����
		jb4.addActionListener(this);
	
		//������������йص�����ŵ�һ�������
	    jp2.add(jb2);
	    jp2.add(jb3);
	    jp2.add(jb4);
	    
	    //ʵ����һ����ģ�Ͷ���
	    
	    StuModel sm = new StuModel();
	    //�Ѷ�����뵽JTable�У����ǰ����ݴ�������
	    jt = new JTable(sm);
	    jsp = new JScrollPane(jt);
		
	    //��������ģ�鲼��
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		//��������������
		this.setTitle("�ϲ���ѧ֤����ʧ�����ϵͳ��ʧ����Ϣ���ݿ⣩");
		this.setSize(w,h-30);
		this.setLocation(0, 0);
		this.setIconImage(titleIcon);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//�¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb1)
		{
		    //System.out.print("�û�ϣ����ѯ");
		    //��ѯ���ݿ⣬����JTable
			//��Ϊ�ѶԱ�����ݷ�װ����StuModel�У���ѯ����ʵ��
			String id = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Id = '"+id+"'";
		
		    //�µ�����ģ����
			sm = new StuModel(sql);
			//���±�������
			jt.setModel(sm);
		}
		
		else if(e.getSource()==jb5)
		{
		    //System.out.print("�û�ϣ����ѯ");
		    //��ѯ���ݿ⣬����JTable
			//��Ϊ�ѶԱ�����ݷ�װ����StuModel�У���ѯ����ʵ��
			String name = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Name = '"+name+"'";
		
		    //�µ�����ģ����
			sm = new StuModel(sql);
			//���±�������
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb6)
		{
		    //System.out.print("�û�ϣ����ѯ");
		    //��ѯ���ݿ⣬����JTable
			//��Ϊ�ѶԱ�����ݷ�װ����StuModel�У���ѯ����ʵ��
			String place = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Place = '"+place+"'";
		
		    //�µ�����ģ����
			sm = new StuModel(sql);
			//���±�������
			jt.setModel(sm);
		}
		else if(e.getSource()==jb7)
		{
			String time = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Time = '"+time+"'";
		
		    //�µ�����ģ����
			sm = new StuModel(sql);
			//���±�������
			jt.setModel(sm);
			
		}
		
		else if(e.getSource() == jb8)
		{
			String type = this.jtf.getText().trim();
		    String sql=" select*from xzhengjian where Type = '"+type+"'";
		
		    //�µ�����ģ����
			sm = new StuModel(sql);
			//���±�������
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb3)
		{
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1)
			{
				JOptionPane.showConfirmDialog(this, "��ѡ��һ��");
				return;
			}
			
			sm=new StuModel();
			new StuUpdDialog(this,"�޸�ѧ����Ϣ",true,sm,rowNum);
			sm=new StuModel();
			jt.setModel(sm);
			
		}
		else if(e.getSource()==jb2)
		{
		    //��ģʽ�Ի���
			StuAddDialog sa = new StuAddDialog(this,"���ѧ��",true);
		   
			//����������ʾ
			sm=new StuModel();
		    jt.setModel(sm);	    
		}
		else if(e.getSource()==jb4)
		{
			//�û�Ҫɾ����¼
			//�õ�ѧ��ID
			//getSelectedRow�����û����е���
			//ûѡ����-1
			int rowNum = this.jt.getSelectedRow();
		    if(rowNum==-1)
		    {
		    	JOptionPane.showMessageDialog(this,"��ѡ��һ��");
		        return;
		    }
		    //�õ�ѧ��ID
		    sm=new StuModel();
		    String stuId = (String)sm.getValueAt(rowNum, 0);
		    //����һ��sql���
		    String sql="delete from xzhengjian where Id=?";
		    String[] paras = {stuId};
		    StuModel temp = new StuModel();
		    temp.updStu(sql, paras);
		    
		    sm=new StuModel();
		    jt.setModel(sm);
		}	
           		
	}

}
