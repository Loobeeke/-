package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.lvqiao.util.CalendarPanel;
import com.lvqiao.util.JdbcUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddClassView extends JFrame {
	JdbcUtil jdbcUtil = new JdbcUtil();
	private JPanel contentPane;
	private JTextField tx_tea ;
	private JTextField tx_time;
	private JTextField tx_site;
	private JTextField tx_ver_cno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassView frame = new AddClassView();
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
	public AddClassView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 984, 571);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextField tx_var_tname = new JTextField("");
		
		tx_var_tname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*tx_var_tname.setText("");
				tx_time.setText("");
				tx_site.setText("");*/
			}
		});
		tx_var_tname.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tname.setBounds(550, 131, 290, 38);
		tx_var_tname.setOpaque(false);
		tx_var_tname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tname);
		tx_var_tname.setColumns(10);
		
		tx_time = new JTextField("");
		tx_time.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				tx_time.setText(myfmt.format(new java.util.Date()).toString());
			}
		});
		tx_time.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_time.setColumns(10);
		tx_time.setOpaque(false);
		
		//(contentPane).getContentPane().add(p);
		tx_time.setBounds(550, 187, 290, 38);
		tx_time.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_time);
		
		tx_site = new JTextField("");
		tx_site.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_site.setColumns(10);
		tx_site.setOpaque(false);
		tx_site.setBounds(550, 302, 290, 38);
		tx_site.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_site);
		
		JButton Jb_reset = new JButton("");
		Jb_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tx_var_tname.setText("");
				tx_time.setText("");
				tx_site.setText("");
				tx_ver_cno.setText("");
			}
		});
		Jb_reset.setBounds(835, 357, 66, 20);
		Jb_reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_reset.setContentAreaFilled(false);
		getContentPane().add(Jb_reset);
		//提交按钮
		JButton Jb_sub = new JButton("");
		Jb_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tx_var_tname.getText();
				String time = tx_time.getText();
				String site = tx_site.getText();
				String tea = tx_tea.getText();
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.SelectCla(name);
						if(!ise){
							conn.Insertclass(name, time, tea,site);
							JOptionPane.showMessageDialog(AddClassView.this, "添加成功！！");
							AddClassView.this.setVisible(false);
							//MainView.stu_num.setText(Integer.toString(jdbcUtil.stucount()));
							//MainView.cla_num.setText(Integer.toString(jdbcUtil.classcount()));
							//MainView.reader_num.setText(Integer.toString(jdbcUtil.mescount()));
						}else{
							
							JOptionPane.showMessageDialog(AddClassView.this, "课程已存在！！");
						}
					} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Jb_sub.setBounds(550, 387, 290, 38);
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
				int n = JOptionPane.showConfirmDialog(null, "你确定不要添加了?", "提示",JOptionPane.YES_NO_OPTION);
				if(n==0){
					AddClassView.this.setVisible(false);
				}
			}
		});
		Jb_cancel.setBounds(550, 451, 290, 38);
		Jb_cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_cancel.setContentAreaFilled(false);
		getContentPane().add(Jb_cancel);
		
		tx_tea = new JTextField("");
		tx_tea.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_tea.setColumns(10);
		tx_tea.setOpaque(false);
		tx_tea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_tea.setBounds(550, 235, 290, 38);
		getContentPane().add(tx_tea);
		
		
		
		
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(AddClassView.class.getResource("/images/cla_add.png")));
		bg.setBounds(0, 0, 968, 540);
		contentPane.add(bg);
	}

}
