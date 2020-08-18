package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.model.ClassType;
import com.lvqiao.model.StudentType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SelfView extends JFrame {
	private JPanel contentPane;
	private JTextField s_name;
	private JTextField s_cno;
	private JTextField s_phone;
	private JTextField s_teacher;
	StudentTypeDao typeDao =  new StudentTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelfView frame = new SelfView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelfView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 997, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		s_name = new JTextField();
		s_name.setFont(new Font("楷体", Font.PLAIN, 20));
		s_name.setBounds(212, 206, 206, 42);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		s_cno = new JTextField();
		s_cno.setFont(new Font("楷体", Font.PLAIN, 20));
		s_cno.setBounds(212, 279, 206, 42);
		s_cno.setColumns(10);
		contentPane.add(s_cno);
		
		s_phone = new JTextField();
		s_phone.setFont(new Font("楷体", Font.PLAIN, 20));
		s_phone.setBounds(212, 351, 206, 42);
		s_phone.setColumns(10);
		contentPane.add(s_phone);
		
		s_teacher = new JTextField();
		s_teacher.setFont(new Font("楷体", Font.PLAIN, 20));
		s_teacher.setBounds(212, 424, 206, 42);
		s_teacher.setColumns(10);
		contentPane.add(s_teacher);
		
		StudentType types = typeDao.querystudentType(StuLoginView.t_name).get(0);
		s_name.setText(types.getS_name());
		s_cno.setText(types.getS_cno());
		s_phone.setText(types.getS_number());
		s_teacher.setText(types.getS_teacher());
		
		
		
		
		JButton reup = new JButton("");
		reup.setContentAreaFilled(false);
		reup.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		reup.setBounds(878, 523, 79, 23);
		reup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname = s_name.getText();
				String tcno = s_cno.getText();
				String tphone = s_phone.getText();
				String tteacher = s_teacher.getText();

				try {
					typeDao.updatestuTable(tname, tcno, tphone, tteacher);
					JOptionPane.showMessageDialog(SelfView.this, "修改成功！，请刷新查看！");
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(SelfView.this, "修改失败！");
				}
			}
		});
		contentPane.add(reup);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 988, 556);
		bg.setIcon(new ImageIcon(SelfView.class.getResource("/images/self0.png")));
		contentPane.add(bg);
	}

}
