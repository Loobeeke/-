package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lvqiao.util.CodePicture;
import com.lvqiao.util.JdbcUtil;


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


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField tx_login;
	private JPasswordField tx_psd;
	private JTextField tx_verify;
	public static String codes;
	static String t_name;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuLoginView frame = new StuLoginView();
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
	/**
	 * Create the frame.
	 */
	public StuLoginView() {
		setTitle("\u7EFF\u6865\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u5B66\u751F\u767B\u5F55\u9875");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*textField.setForeground(Color.blue);
		textField.setBackground(Color.TRANSLUCENT);*/
		
		desktopPane.setBounds(10, 0, 934, 501);
		contentPane.add(desktopPane);
		
		JLabel Jb_verify = new JLabel("");
		Jb_verify.setBounds(798, 278, 80, 42);
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
		//		ImageIcon img = new ImageIcon((BufferedImage)CodePicture.createImage()[1]);//创建图片对象
		//		Jb_verify.setIcon((Icon)img);
				getPicture(Jb_verify);
		
		tx_login = new JTextField();
		tx_login.setFont(new Font("仿宋", Font.PLAIN, 20));
		tx_login.setForeground(new Color(255, 255, 255));
		tx_login.setBounds(714, 194, 164, 26);
		desktopPane.add(tx_login);
		tx_login.setBackground(new Color(0, 204, 255));
		tx_login.setColumns(10);
		tx_login.setOpaque(false);
		tx_login.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		tx_login.setColumns(10);
		
		tx_psd = new JPasswordField();
		tx_psd.setFont(new Font("宋体", Font.PLAIN, 12));
		tx_psd.setForeground(new Color(255, 255, 255));
		tx_psd.setEchoChar('■');
		tx_psd.setBounds(714, 242, 164, 26);
		desktopPane.add(tx_psd);
		tx_psd.setBackground(new Color(0, 204, 255));
		tx_psd.setColumns(10);
		tx_psd.setOpaque(false);
		tx_psd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				
				tx_verify = new JTextField();
				tx_verify.setFont(new Font("宋体", Font.PLAIN, 20));
				tx_verify.setForeground(new Color(255, 255, 255));
				tx_verify.setBounds(714, 282, 74, 28);
				desktopPane.add(tx_verify);
				tx_verify.setBackground(new Color(0, 204, 255));
				tx_verify.setColumns(10);
				tx_verify.setOpaque(false);
				tx_verify.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				tx_verify.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				tx_verify.setColumns(10);
				
				JButton btn_1 = new JButton("");
				btn_1.setBounds(698, 330, 180, 26);
				btn_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				btn_1.setContentAreaFilled(false);
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
							JOptionPane.showMessageDialog(StuLoginView.this, "用户名或密码不能为空");
						}else if(t_name.length()!=0){
							try {
								if(conn.Selectstu(t_name, t_psd)){
									
									System.out.println(code.toString());
									System.out.println(codes);
									if(code1.toUpperCase().equals(codes.toUpperCase())){
										JOptionPane.showMessageDialog(StuLoginView.this, "登录成功！！");
										StudentView main = new StudentView();
										main.setVisible(true);
									}else{
										JOptionPane.showMessageDialog(StuLoginView.this, "验证码错误");
									}
								}else{
									JOptionPane.showMessageDialog(StuLoginView.this, "账号或密码错误！");
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
				//注册
				JButton btn_2 = new JButton("");
				btn_2.setBounds(696, 375, 182, 26);
				desktopPane.add(btn_2);
				
				btn_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						StuVerView stuverView = new StuVerView();
						//verifyView.setModal(true);
						//desktopPane.add(verifyView);
						stuverView.setVisible(true);
						//verifyView.setAlwaysOnTop(true);
						
					}
				});
				btn_2.setForeground(Color.WHITE);
				btn_2.setBackground(Color.BLUE);
				btn_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				btn_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				btn_2.setContentAreaFilled(false);
				btn_2.setOpaque(false);
				
				
				JLabel bgimg = new JLabel("");
				bgimg.setBounds(0, 0, 960, 540);
				desktopPane.add(bgimg);
				bgimg.setIcon(new ImageIcon(StuLoginView.class.getResource("/images/stulogin.png")));
	}
}
