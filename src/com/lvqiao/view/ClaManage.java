package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClaManage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaManage frame = new ClaManage();
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
	public ClaManage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1310, 740);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClassView addClassView = new AddClassView();
				addClassView.setVisible(true);
			}
		});
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(231, 552, 258, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClaDelview claDelview = new ClaDelview();
				claDelview.setVisible(true);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		btnNewButton_1.setBounds(529, 552, 258, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClaChange claChange = new ClaChange();
				claChange.setVisible(true);
			}
		});
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		btnNewButton_2.setBounds(825, 552, 258, 48);
		contentPane.add(btnNewButton_2);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(StuManage.class.getResource("/images/claManger.png")));
		bg.setBounds(0, 5, 1289, 696);
		contentPane.add(bg);
	}

}
