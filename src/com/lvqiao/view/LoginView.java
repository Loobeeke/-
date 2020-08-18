package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lvqiao.util.CodePicture;
import com.lvqiao.util.JdbcUtil;

import sun.util.logging.resources.logging;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField tx_login;
	private JPasswordField tx_psd;
	private JTextField tx_verify;
	public static String codes;
	private final JDesktopPane desktopPane = new JDesktopPane();
	static String t_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getPicture(JLabel Jb_verify/*,JTextField tx_verify2*/){

		Object[] obj = CodePicture.createImage();
		String code = obj[0].toString();
		System.out.println("验证码:"+code);
		ImageIcon img = new ImageIcon((BufferedImage)obj[1]);//创建图片对象
		Jb_verify.setIcon((Icon)img);
		codes=code;
		
	}
	/*
	 * 
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("绿桥管理系统管理员登录页");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 580);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*textField.setForeground(Color.blue);
		textField.setBackground(Color.TRANSLUCENT);*/
		
		desktopPane.setBounds(10, 0, 960, 540);
		contentPane.add(desktopPane);
		
		JLabel Jb_verify = new JLabel("");
		Jb_verify.setBounds(741, 317, 80, 42);
		desktopPane.add(Jb_verify);
		Jb_verify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){	
					//重新获取验证码
					getPicture(Jb_verify);

				}
			}
		});
		Jb_verify.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		getPicture(Jb_verify);
		
		tx_login = new JTextField();
		tx_login.setFont(new Font("方正姚体", Font.PLAIN, 20));
		tx_login.setForeground(new Color(204, 255, 255));
		tx_login.setBounds(609, 221, 212, 26);
		desktopPane.add(tx_login);
		tx_login.setBackground(new Color(0, 204, 255));
		tx_login.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_login.setOpaque(false);
		tx_login.setColumns(10);
		
		tx_psd = new JPasswordField();
		tx_psd.setFont(new Font("宋体", Font.PLAIN, 16));
		tx_psd.setBounds(609, 281, 212, 26);
		desktopPane.add(tx_psd);
		tx_psd.setBackground(new Color(0, 204, 255));
		tx_psd.setOpaque(false);
		tx_psd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		
		tx_verify = new JTextField();
		tx_verify.setFont(new Font("方正姚体", Font.PLAIN, 20));
		tx_verify.setForeground(new Color(204, 255, 255));
		tx_verify.setBounds(609, 331, 109, 28);
		tx_verify.setOpaque(false);
		desktopPane.add(tx_verify);
		tx_verify.setBackground(new Color(0, 204, 255));
		tx_verify.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_verify.setColumns(10);
		//注册
		JButton btn_2 = new JButton("\u6CE8\u518C");
		btn_2.setBounds(565, 421, 256, 26);
		desktopPane.add(btn_2);
		
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VerifyView verifyView = new VerifyView();
				verifyView.setVisible(true);
				
			}
		});
		btn_2.setForeground(Color.WHITE);
		btn_2.setBackground(Color.BLUE);
		btn_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		btn_2.setOpaque(false);
		
		JButton btn_1 = new JButton("\u767B\u5F55");
		btn_1.setBounds(565, 372, 256, 31);
		desktopPane.add(btn_1);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JdbcUtil conn = new JdbcUtil();
				CodePicture code = new CodePicture();
				t_name = tx_login.getText();
				String t_psd = tx_psd.getText();
				String code1 = tx_verify.getText();
				
				if(t_name==null||t_name.equals("")||t_psd==null||t_psd.equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "用户名或密码不能为空");
				}else if(t_name.length()!=0){
					try {
						if(conn.Select(t_name, t_psd)){
							
							System.out.println(code.toString());
							System.out.println(codes);
							if(code1.toUpperCase().equals(codes.toUpperCase())){
								JOptionPane.showMessageDialog(LoginView.this, "登录成功！！");
								MainView main = new MainView();
								main.setVisible(true);
								LoginView.this.setVisible(false);
							}else{
								JOptionPane.showMessageDialog(LoginView.this, "验证码错误");
							}
						}else{
							JOptionPane.showMessageDialog(LoginView.this, "账号或密码错误！");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				//更新验证码
				getPicture(Jb_verify);
			}
		});
		btn_1.setForeground(Color.WHITE);
		btn_1.setBackground(new Color(0, 0, 255));
		btn_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		btn_1.setOpaque(false);
				
				JButton Jb_stu = new JButton("");
				Jb_stu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						StuLoginView studentView = new StuLoginView();
						JOptionPane.showMessageDialog(LoginView.this, "已转到学生登录页！！");
						studentView.setVisible(true);
						LoginView.this.setVisible(false);
					}
				});
				Jb_stu.setBounds(0, 514, 98, 26);
				Jb_stu.setForeground(Color.WHITE);
				Jb_stu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				Jb_stu.setContentAreaFilled(false);
				desktopPane.add(Jb_stu);
				
				
				JLabel bgimg = new JLabel("");
				bgimg.setBounds(0, 0, 960, 540);
				desktopPane.add(bgimg);
				bgimg.setIcon(new ImageIcon(LoginView.class.getResource("/images/login1.png")));
	}
}
