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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class StuVerView extends JDialog {
	private JTextField tx_var_tname;
	private JTextField tx_var_num;
	private JTextField tx_var_tea;
	private JTextField tx_ver_cno;
	private JPasswordField tx_psd;
	private JPasswordField tx_repsd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuVerView frame = new StuVerView();
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
	public StuVerView() {
		setFocusable(true);
		setResizable(true);
		//setIconImages(true);
		setModal(true);
		setTitle("绿桥学生注册页");
		setBounds(230, 160, 970, 580);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tx_var_tname = new JTextField("");
		tx_var_tname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tx_var_tname.setText("");
				tx_var_num.setText("");
				tx_var_tea.setText("");
			}
		});
		tx_var_tname.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tname.setBounds(131, 161, 228, 30);
		tx_var_tname.setOpaque(false);
		tx_var_tname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tname);
		tx_var_tname.setColumns(10);
		
		tx_var_num = new JTextField("");
		tx_var_num.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_num.setColumns(10);
		tx_var_num.setOpaque(false);
		tx_var_num.setBounds(131, 317, 228, 27);
		tx_var_num.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_num);
		
		tx_var_tea = new JTextField("");
		tx_var_tea.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tea.setColumns(10);
		tx_var_tea.setOpaque(false);
		tx_var_tea.setBounds(131, 357, 228, 30);
		tx_var_tea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tea);
		
		JButton Jb_reset = new JButton("");
		Jb_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tx_var_tname.setText("");
				tx_var_num.setText("");
				tx_var_tea.setText("");
				tx_psd.setText("");
				tx_repsd.setText("");
				tx_ver_cno.setText("");
			}
		});
		Jb_reset.setBounds(362, 378, 66, 20);
		Jb_reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_reset.setContentAreaFilled(false);
		getContentPane().add(Jb_reset);
		//提交按钮
		JButton Jb_sub = new JButton("");
		Jb_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tx_var_tname.getText();
				String psd = tx_psd.getText();
				String repsd = tx_repsd.getText();
				String cno = tx_ver_cno.getText();
				String num = tx_var_num.getText();
				String tea = tx_var_tea.getText();
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.Select(name, psd);
					if(psd.equals(repsd)){
						if(!ise){
							conn.Insertstu(name, psd,cno, num,tea);
							JOptionPane.showMessageDialog(StuVerView.this, "注册成功！！");
							StuVerView.this.setVisible(false);
						}else{
							
							JOptionPane.showMessageDialog(StuVerView.this, "账号已存在！！");
						}
					}else{
						JOptionPane.showMessageDialog(StuVerView.this, "两次输入的密码不一样！");
					}
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Jb_sub.setBounds(122, 406, 237, 38);
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
				int n = JOptionPane.showConfirmDialog(null, "你确定不要注册了?", "提示",JOptionPane.YES_NO_OPTION);
				if(n==0){
					StuVerView.this.setVisible(false);
				}
			}
		});
		Jb_cancel.setBounds(122, 456, 237, 38);
		Jb_cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_cancel.setContentAreaFilled(false);
		getContentPane().add(Jb_cancel);
		
		tx_ver_cno = new JTextField("");
		tx_ver_cno.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_ver_cno.setColumns(10);
		tx_ver_cno.setOpaque(false);
		tx_ver_cno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_ver_cno.setBounds(131, 281, 228, 30);
		getContentPane().add(tx_ver_cno);
		
		tx_psd = new JPasswordField();
		tx_psd.setColumns(10);
		tx_psd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_psd.setOpaque(false);
		tx_psd.setBounds(131, 201, 228, 30);
		getContentPane().add(tx_psd);
		
		tx_repsd = new JPasswordField();
		tx_repsd.setColumns(10);
		tx_repsd.setOpaque(false);
		tx_repsd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_repsd.setBounds(131, 241, 228, 30);
		getContentPane().add(tx_repsd);
		
		JLabel Jb_bg = new JLabel("");
		Jb_bg.setIcon(new ImageIcon(StuVerView.class.getResource("/images/stuver.png")));
		Jb_bg.setBounds(0, 0, 960, 540);
		getContentPane().add(Jb_bg);

	}
}
