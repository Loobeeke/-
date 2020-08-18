package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.util.JdbcUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ReaderFrom extends JFrame {
	private String content1;
	private JPanel contentPane;
	private JTextField title;
	private JComboBox comboBox;
	private JTextArea content;
	StudentTypeDao typeDao =  new StudentTypeDao();
	private String title1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderFrom frame = new ReaderFrom();
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
	public ReaderFrom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1209, 718);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bt_reset = new JButton("");
		bt_reset.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				title1 = title.getText();
				content1 = content.getText();
				String from_name = StuLoginView.t_name;
				String to_name = comboBox.getSelectedItem().toString(); ;
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.SelectRea(title1);
					
						if(!ise){
							conn.Insertreader(title1, content1, from_name, to_name);
							JOptionPane.showMessageDialog(ReaderFrom.this, "发送成功！！");
//							ReaderFrom.this.setVisible(false);
							
						}else{
							
							JOptionPane.showMessageDialog(ReaderFrom.this, "标题重复！！");
						}
					
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		bt_reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_reset.setContentAreaFilled(false);
		bt_reset.setBounds(261, 504, 178, 31);
		contentPane.add(bt_reset);
		
		JButton bt_cancle = new JButton("");
		bt_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_cancle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_cancle.setContentAreaFilled(false);
		bt_cancle.setBounds(261, 552, 178, 31);
		contentPane.add(bt_cancle);
		
		content = new JTextArea();
		content.setFont(new Font("华文中宋", Font.PLAIN, 15));
		content.setBounds(238, 300, 232, 139);
		contentPane.add(content);
		
		JButton bt_res = new JButton("");
		bt_res.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_res.setContentAreaFilled(false);
		bt_res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				title.setText("");
				content.setText("");
			}
		});
		bt_res.setBounds(480, 480, 87, 23);
		contentPane.add(bt_res);
		
		title = new JTextField();
		title.setFont(new Font("黑体", Font.PLAIN, 20));
		title.setBounds(238, 240, 232, 37);
		contentPane.add(title);
		title.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("楷体", Font.PLAIN, 25));
		comboBox.setBackground(Color.white);
		//遍历数据库
		/*for(){
			
		}*/
		comboBox.addItem("郝老师");
		comboBox.addItem("坏老师");
		comboBox.addItem("徐大");
		comboBox.addItem("好老师");
		comboBox.setBounds(261, 449, 178, 42);
		contentPane.add(comboBox);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ReaderFrom.class.getResource("/images/torea.png")));
		bg.setBounds(0, 0, 1189, 679);
		contentPane.add(bg);
	}
}
