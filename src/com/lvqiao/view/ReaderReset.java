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

public class ReaderReset extends JFrame {
	private String content1;
	private JPanel contentPane;
	private JTextField title;
	private JTextArea content;
	StudentTypeDao typeDao =  new StudentTypeDao();
	private String title1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea content_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderReset frame = new ReaderReset();
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
	public ReaderReset() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1209, 718);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bt_reset = new JButton("");
		bt_reset.addActionListener(new ActionListener() {
			

			private String to_name;

			public void actionPerformed(ActionEvent e) {
				title1 = title.getText();
				content1 = content.getText();
				System.err.println(content1);
				String from_name = LoginView.t_name;
				String to_name = textField.getText();
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.SelectReRea(title1);
					
						if(!ise){
							conn.InsertRereader(title1, content1, from_name, to_name);
							JOptionPane.showMessageDialog(ReaderReset.this, "回复成功！！");
//							ReaderFrom.this.setVisible(false);
							
						}else{
							
							JOptionPane.showMessageDialog(ReaderReset.this, "标题重复！！");
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
		content.setBounds(240, 300, 230, 139);
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
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.PLAIN, 25));
		textField.setText(ReaderResetview.rname);
		textField.setEditable(false);
		textField.setBounds(261, 449, 178, 37);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText(ReaderResetview.rtitle);
		textField_1.setFont(new Font("黑体", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(749, 187, 232, 37);
		contentPane.add(textField_1);
		
		JTextArea content_1 = new JTextArea();
		content_1.setEditable(false);
		content_1.setFont(new Font("华文中宋", Font.PLAIN, 20));
		content_1.setText(ReaderResetview.rcontent);
		content_1.setBounds(751, 254, 230, 137);
		contentPane.add(content_1);
		
		content_2 = new JTextArea();
	
		content_2.setEnabled(false);
		content_2.setEditable(false);
		content_2.setFont(new Font("华文中宋", Font.PLAIN, 15));
		content_2.setBounds(663, 432, 353, 137);
		contentPane.add(content_2);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ReaderReset.class.getResource("/images/readerreset.png")));
		bg.setBounds(0, 0, 1189, 679);
		contentPane.add(bg);
	}
}
