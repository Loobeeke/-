package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lvqiao.util.Weather;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Siteview extends JFrame {

	private JPanel contentPane;
	static String resite = "郑州";
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Siteview frame = new Siteview();
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
	public Siteview() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 425);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("郑州");
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(371, 122, 250, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton bt_up = new JButton("");
		bt_up.setContentAreaFilled(false);
		bt_up.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_up.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				resite = textField.getText();
				Weather weather = new Weather();
				//String site1 = Siteview.textField.getText();
				System.err.println(resite);
				weather.weather(resite);
				String str = weather.site0;
				System.out.println(str);
				MainView.site.setText(str);
				MainView.time_1.setText(weather.time);
				MainView.textArea.setText(weather.real_wea);
				MainView.day1.setText(weather.day_1);
				MainView.day2.setText(weather.day_2);
				MainView.day3.setText(weather.day_3);
				MainView.day4.setText(weather.day_4);
				MainView.day1_T.setText(weather.day_1_T);
				MainView.day2_T.setText(weather.day_2_T);
				MainView.day3_T.setText(weather.day_3_T);
				MainView.day4_T.setText(weather.day_4_T);
				
				if(weather.day_1_P.equals("0.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
				}
				if(weather.day_1_P.equals("1.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
				}
				if(weather.day_1_P.equals("2.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
				}
				if(weather.day_1_P.equals("3.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
				}
				if(weather.day_1_P.equals("4.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
				}
				if(weather.day_1_P.equals("5.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
				}
				if(weather.day_1_P.equals("6.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
				}
				if(weather.day_1_P.equals("7.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
				}
				if(weather.day_1_P.equals("8.gif")){
					MainView.day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
				}
				
				if(weather.day_2_P.equals("0.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
				}
				if(weather.day_2_P.equals("1.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
				}
				if(weather.day_2_P.equals("2.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
				}
				if(weather.day_2_P.equals("3.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
				}
				if(weather.day_2_P.equals("4.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
				}
				if(weather.day_2_P.equals("5.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
				}
				if(weather.day_2_P.equals("6.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
				}
				if(weather.day_2_P.equals("7.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
				}
				if(weather.day_2_P.equals("8.gif")){
					MainView.day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
				}
				
				
				if(weather.day_3_P.equals("0.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
				}
				if(weather.day_3_P.equals("1.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
				}
				if(weather.day_3_P.equals("2.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
				}
				if(weather.day_3_P.equals("3.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
				}
				if(weather.day_3_P.equals("4.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
				}
				if(weather.day_3_P.equals("5.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
				}
				if(weather.day_3_P.equals("6.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
				}
				if(weather.day_3_P.equals("7.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
				}
				if(weather.day_3_P.equals("8.gif")){
					MainView.day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
				}
				
				if(weather.day_4_P.equals("0.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
				}
				if(weather.day_4_P.equals("1.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
				}
				if(weather.day_4_P.equals("2.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
				}
				if(weather.day_4_P.equals("3.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
				}
				if(weather.day_4_P.equals("4.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
				}
				if(weather.day_4_P.equals("5.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
				}
				if(weather.day_4_P.equals("6.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
				}
				if(weather.day_4_P.equals("7.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
				}
				if(weather.day_4_P.equals("8.gif")){
					MainView.day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
				}
				
			}
		});
		bt_up.setBounds(388, 236, 84, 36);
		contentPane.add(bt_up);
		
		JButton bt_down = new JButton("");
		bt_down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "你确定要退出?", "Are You Sure?",JOptionPane.YES_NO_OPTION);
				if(n==0){
					Siteview.this.setVisible(false);
				}
			}
		});
		bt_down.setContentAreaFilled(false);
		bt_down.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_down.setBounds(526, 236, 84, 36);
		contentPane.add(bt_down);
		
		JButton bt_null = new JButton("");
		bt_null.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		bt_null.setContentAreaFilled(false);
		bt_null.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_null.setBounds(607, 182, 42, 44);
		contentPane.add(bt_null);
		
		JLabel bg = new JLabel("");
		
		bg.setIcon(new ImageIcon(Siteview.class.getResource("/images/wea.png")));
		bg.setBounds(0, 0, 700, 376);
		contentPane.add(bg);
	}
}
