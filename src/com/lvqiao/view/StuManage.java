package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StuManage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuManage frame = new StuManage();
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
	public StuManage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1310, 740);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bt_add = new JButton("");
		bt_add.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_add.setContentAreaFilled(false);
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentView addStudentView = new AddStudentView();
				addStudentView.setVisible(true);
			}
		});
		bt_add.setBounds(231, 555, 259, 44);
		contentPane.add(bt_add);
		
		JButton bt_del = new JButton("");
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuDelView stuDelView = new StuDelView();
				stuDelView.setVisible(true);
			}
		});
		bt_del.setContentAreaFilled(false);
		bt_del.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_del.setBounds(529, 555, 259, 44);
		contentPane.add(bt_del);
		
		JButton bt_change = new JButton("");
		bt_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuChange stuChange = new StuChange();
				stuChange.setVisible(true);
			}
		});
		bt_change.setContentAreaFilled(false);
		bt_change.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_change.setBounds(826, 555, 259, 44);
		contentPane.add(bt_change);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(StuManage.class.getResource("/images/stuManger.png")));
		bg.setBounds(0, 5, 1289, 696);
		contentPane.add(bg);
	}

}
