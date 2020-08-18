package com.lvqiao.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.lvqiao.util.JdbcUtil;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class VerifyView extends JDialog {
	private JTextField tx_var_tname;
	private JTextField tx_var_tpsd;
	private JTextField tx_var_trepsd;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerifyView frame = new VerifyView();
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
	public VerifyView() {
		setFocusable(true);
		setResizable(true);
		//setIconImages(true);
		setModal(true);
		setTitle("绿桥管理员注册页");
		setBounds(230, 160, 970, 570);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tx_var_tname = new JTextField("");
		tx_var_tname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*tx_var_tname.setText("");
				tx_var_tpsd.setText("");
				tx_var_trepsd.setText("");*/
			}
		});
		tx_var_tname.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tname.setBounds(552, 180, 290, 38);
		tx_var_tname.setColumns(10);
		tx_var_tname.setOpaque(false);
		tx_var_tname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tname);
		tx_var_tname.setColumns(10);
		
		JButton Jb_reset = new JButton("");
		Jb_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tx_var_tname.setText("");
				tx_var_tpsd.setText("");
				tx_var_trepsd.setText("");
			}
		});
		Jb_reset.setBounds(839, 347, 67, 24);
		Jb_reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_reset.setContentAreaFilled(false);
		getContentPane().add(Jb_reset);
		
		tx_var_tpsd = new JPasswordField("");
		tx_var_tpsd.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tpsd.setColumns(10);
		tx_var_tpsd.setBounds(552, 241, 290, 38);
		tx_var_tpsd.setColumns(10);
		tx_var_tpsd.setOpaque(false);
		tx_var_tpsd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tpsd);
		
		tx_var_trepsd = new JPasswordField("");
		tx_var_trepsd.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_trepsd.setColumns(10);
		tx_var_trepsd.setBounds(552, 308, 290, 38);
		tx_var_trepsd.setColumns(10);
		tx_var_trepsd.setOpaque(false);
		tx_var_trepsd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_trepsd);
		//提交按钮
		JButton Jb_sub = new JButton("");
		Jb_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tx_var_tname.getText();
				String psd = tx_var_tpsd.getText();
				String repsd = tx_var_trepsd.getText();
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.Select(name, psd);
					if(psd.equals(repsd)){
						if(!ise){
							conn.Insert(name, psd);
							JOptionPane.showMessageDialog(VerifyView.this, "注册成功！！");
							VerifyView.this.setVisible(false);
						}else{
							
							JOptionPane.showMessageDialog(VerifyView.this, "账号已存在！！");
						}
					}else{
						JOptionPane.showMessageDialog(VerifyView.this, "两次输入的密码不一样！");
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Jb_sub.setBounds(552, 381, 283, 38);
		Jb_sub.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_sub.setContentAreaFilled(false);
		getContentPane().add(Jb_sub);
		//Jb_sub.setBackground(new Color(0, 0, 255));
//		Jb_sub.setOpaque(false);
//		Jb_sub.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
//		Jb_reset.setContentAreaFilled(false);
//		getContentPane().add(Jb_sub);
		//取消按钮
		JButton Jb_cancel = new JButton("");
		Jb_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "你确定不要注册了?", "Are You Sure?",JOptionPane.YES_NO_OPTION);
				if(n==0){
					VerifyView.this.setVisible(false);
				}
			}
		});
		Jb_cancel.setBounds(552, 445, 283, 38);
		Jb_cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_cancel.setContentAreaFilled(false);
		getContentPane().add(Jb_cancel);
		
		JLabel Jb_bg = new JLabel("");
		Jb_bg.setIcon(new ImageIcon(VerifyView.class.getResource("/images/zhuce0.png")));
		Jb_bg.setBounds(0, 0, 954, 531);
		getContentPane().add(Jb_bg);
		
		

	}

}
