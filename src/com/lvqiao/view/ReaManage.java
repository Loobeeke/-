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

public class ReaManage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaManage frame = new ReaManage();
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
	public ReaManage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1310, 740);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton re = new JButton("");
		re.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		re.setContentAreaFilled(false);
		re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderResetview readerResetview = new ReaderResetview();
				readerResetview.setVisible(true);
			}
		});
		re.setBounds(230, 555, 259, 42);
		contentPane.add(re);
		
		JButton del = new JButton("");
		del.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		del.setContentAreaFilled(false);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderDelView reaManage = new ReaderDelView();
				reaManage.setVisible(true);
			}
		});
		del.setBounds(527, 555, 259, 42);
		contentPane.add(del);
		
		JButton change = new JButton("");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaChange reaChange = new ReaChange();
				reaChange.setVisible(true);
			}
		});
		change.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		change.setContentAreaFilled(false);
		change.setBounds(825, 555, 259, 42);
		contentPane.add(change);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(StuManage.class.getResource("/images/reaManger.png")));
		bg.setBounds(0, 5, 1289, 696);
		contentPane.add(bg);
	}

}
