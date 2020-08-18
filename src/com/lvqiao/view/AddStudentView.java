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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.lvqiao.util.JdbcUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddStudentView extends JFrame {
	private JTextField tx_var_tname;
	private JTextField tx_var_num;
	private JTextField tx_var_tea;
	private JTextField tx_ver_cno;
	private JPanel contentPane;
	JdbcUtil jdbcUtil = new JdbcUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentView frame = new AddStudentView();
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
	public AddStudentView() {
		
		
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
				tx_var_tname.setText("");
				tx_var_num.setText("");
				tx_var_tea.setText("");
			}
		});
		tx_var_tname.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tname.setBounds(556, 131, 285, 38);
		tx_var_tname.setOpaque(false);
		tx_var_tname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tname);
		tx_var_tname.setColumns(10);
		
		tx_var_num = new JTextField("");
		tx_var_num.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_num.setColumns(10);
		tx_var_num.setOpaque(false);
		tx_var_num.setBounds(556, 237, 285, 38);
		tx_var_num.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_num);
		
		tx_var_tea = new JTextField("");
		tx_var_tea.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_var_tea.setColumns(10);
		tx_var_tea.setOpaque(false);
		tx_var_tea.setBounds(556, 300, 285, 38);
		tx_var_tea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getContentPane().add(tx_var_tea);
		
		JButton Jb_reset = new JButton("");
		Jb_reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tx_var_tname.setText("");
				tx_var_num.setText("");
				tx_var_tea.setText("");
				tx_ver_cno.setText("");
			}
		});
		Jb_reset.setBounds(832, 356, 66, 20);
		Jb_reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_reset.setContentAreaFilled(false);
		getContentPane().add(Jb_reset);
		//提交按钮
		JButton Jb_sub = new JButton("");
		Jb_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tx_var_tname.getText();
				String cno = tx_ver_cno.getText();
				String num = tx_var_num.getText();
				String tea = tx_var_tea.getText();
				JdbcUtil conn = new JdbcUtil();
				try {
					boolean ise = conn.Selectadd(name);
					
						if(!ise){
							conn.Insertstudent(name, cno, num,tea);
							JOptionPane.showMessageDialog(AddStudentView.this, "添加成功！！");
							AddStudentView.this.setVisible(false);
							//MainView.stu_num.setText(Integer.toString(jdbcUtil.stucount()));
							//MainView.cla_num.setText(Integer.toString(jdbcUtil.classcount()));
							//MainView.reader_num.setText(Integer.toString(jdbcUtil.mescount()));
						}else{
							
							JOptionPane.showMessageDialog(AddStudentView.this, "学生已存在！！");
						}
					
				} catch (HeadlessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Jb_sub.setBounds(556, 386, 279, 38);
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
					AddStudentView.this.setVisible(false);
				}
			}
		});
		Jb_cancel.setBounds(556, 449, 285, 38);
		Jb_cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		Jb_cancel.setContentAreaFilled(false);
		getContentPane().add(Jb_cancel);
		
		tx_ver_cno = new JTextField("");
		tx_ver_cno.setFont(new Font("宋体", Font.PLAIN, 20));
		tx_ver_cno.setColumns(10);
		tx_ver_cno.setOpaque(false);
		tx_ver_cno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_ver_cno.setBounds(556, 184, 285, 38);
		getContentPane().add(tx_ver_cno);
		
		
		
		
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(AddStudentView.class.getResource("/images/stuadd.png")));
		bg.setBounds(0, 0, 968, 540);
		contentPane.add(bg);
	}

}
