package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.model.ClassType;
import com.lvqiao.model.ReaderType;
import com.lvqiao.model.StudentType;
import com.lvqiao.model.TeacerType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	StudentTypeDao typeDao =  new StudentTypeDao();
	private JScrollPane scrollPane;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
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
	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 985);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("");
		name.setForeground(new Color(106, 90, 205));
		name.setFont(new Font("华文隶书", Font.PLAIN, 20));
		name.setText(StuLoginView.t_name);
		name.setBounds(1538, 6, 87, 34);
		contentPane.add(name);
		
		JButton jb_exit = new JButton("");
		jb_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(null, StuLoginView.t_name+"，你确定要退出学生系统吗?", "退出?",JOptionPane.YES_NO_OPTION);
				if(n==0){
					System.exit(0);
				}
			}
		});
		jb_exit.setBounds(1635, 0, 49, 40);
		jb_exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_exit.setContentAreaFilled(false);
		contentPane.add(jb_exit);
		
		JButton jb_self = new JButton("");
		jb_self.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelfView selfView = new SelfView();
				selfView.setVisible(true);
			}
		});
		jb_self.setBounds(184, 68, 276, 93);
		jb_self.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_self.setContentAreaFilled(false);
		contentPane.add(jb_self);
		
		JButton jb_class = new JButton("");
		jb_class.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(table_3);
			}
		});
		jb_class.setBounds(484, 68, 276, 93);
		jb_class.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_class.setContentAreaFilled(false);
		contentPane.add(jb_class);
		
		JButton jb_teacher = new JButton("");
		jb_teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(table_4);
			}
		});
		jb_teacher.setBounds(784, 68, 276, 93);
		jb_teacher.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_teacher.setContentAreaFilled(false);
		contentPane.add(jb_teacher);
		
		JButton jb_mess = new JButton("");
		jb_mess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderFrom readerFrom = new ReaderFrom();
				readerFrom.setVisible(true);
			}
		});
		jb_mess.setBounds(1085, 68, 276, 93);
		jb_mess.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_mess.setContentAreaFilled(false);
		contentPane.add(jb_mess);
		
		JButton jb_clama = new JButton("");
		jb_clama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setViewportView(table_2);
			}
		});
		jb_clama.setBounds(1384, 68, 276, 93);
		jb_clama.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_clama.setContentAreaFilled(false);
		contentPane.add(jb_clama);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 447, 419, 369);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setBackground(new Color(39,61,93));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(209, 300, 1451, 473);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(45);
		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.setDefaultRenderer(Object.class, tcr);
		
		table_1.setFont(new Font("宋体", Font.PLAIN, 16));
		table_1.getTableHeader().setBackground(new Color(255,255,255));
		table_1.getTableHeader().setPreferredSize(new Dimension(1, 45));
		table_1.getTableHeader().setForeground(new Color(0));
		table_1.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_1.setBackground(new Color(242,246,250));
		//table_1.setShowGrid(false);
		//table_1.setShowHorizontalLines(false);
		table_1.setForeground(new Color(0));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u6807\u9898", "\u5185\u5BB9", "\u53D1\u9001\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel defaultreaTable = (DefaultTableModel)table_1.getModel();
		List<ReaderType> reatype = typeDao.queryreaType(null);
		for(ReaderType type: reatype){
			defaultreaTable.addRow(new Object[]{type.getId(),type.getTitle(),type.getContent(),type.getFrom_name()});
		}
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(224);
		
		
		table_2 = new JTable();
		table_2.setRowHeight(43);
		// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_2.setDefaultRenderer(Object.class, tcr);
		table_2.setFont(new Font("宋体", Font.PLAIN, 16));
		table_2.getTableHeader().setBackground(new Color(255,255,255));
		//设置表头高度
		table_2.getTableHeader().setPreferredSize(new Dimension(1, 45));
		table_2.getTableHeader().setForeground(new Color(0));
		table_2.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_2.setBackground(new Color(242,246,250));
		//table_2.setShowGrid(false);//隐藏横竖线
		//table_2.setShowVerticalLines(false);//隐藏竖线
		table_2.setForeground(new Color(0));
		//table_2.setOpaque(false);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "\u59D3\u540D", "\u5B66\u53F7", "\u8001\u5E08"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel defaultStuTable = (DefaultTableModel)table_2.getModel();
		List<StudentType> stutype = typeDao.querystuType(null);
		for(StudentType type: stutype){
			defaultStuTable.addRow(new Object[]{type.getS_id(),type.getS_name(),type.getS_cno(),type.getS_teacher()});
		}
		
		
		table_2.getColumnModel().getColumn(1).setPreferredWidth(96);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(110);
		
		
		table_3 = new JTable();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_3.setDefaultRenderer(Object.class, tcr);
		table_3.setRowHeight(43);
		table_3.setFont(new Font("宋体", Font.PLAIN, 16));
		table_3.getTableHeader().setBackground(new Color(255,255,255));
		table_3.getTableHeader().setPreferredSize(new Dimension(1, 45));
		table_3.getTableHeader().setForeground(new Color(9,9,9));
		table_3.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_3.setBackground(new Color(242,246,250));
		//table_2.setShowGrid(false);//隐藏横竖线
		//table_2.setShowVerticalLines(false);//隐藏竖线
		table_3.setForeground(new Color(0));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "\u8BFE\u7A0B\u540D", "\u4E0A\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65B9\u5F0F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel defaultclaTable = (DefaultTableModel)table_3.getModel();
		List<ClassType> clatype = typeDao.queryclaType(null);
		for(ClassType type: clatype){
			defaultclaTable.addRow(new Object[]{type.getC_id(),type.getC_name(),type.getC_time(),type.getC_teacher(),type.getC_site()});
		}	
		
		table_3.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(80);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(80);
		
		
		
		table_4 = new JTable();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_4.setDefaultRenderer(Object.class, tcr);
		table_4.setRowHeight(43);
		table_4.setFont(new Font("宋体", Font.PLAIN, 16));
		table_4.getTableHeader().setBackground(new Color(255,255,255));
		table_4.getTableHeader().setPreferredSize(new Dimension(1, 45));
		table_4.getTableHeader().setForeground(new Color(9,9,9));
		table_4.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_4.setBackground(new Color(242,246,250));
		//table_2.setShowGrid(false);//隐藏横竖线
		//table_2.setShowVerticalLines(false);//隐藏竖线
		table_4.setForeground(new Color(0));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "教师姓名", "教师联系方式", "任教课程"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		DefaultTableModel defaultteaTable = (DefaultTableModel)table_4.getModel();
		List<TeacerType> teatype = typeDao.queryteaType(null);
		for(TeacerType type: teatype){
			defaultteaTable.addRow(new Object[]{type.getTid(),type.getT_name(),type.getT_phone(),type.getT_class()});
		}
		table_4.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(StudentView.class.getResource("/images/student.png")));
		bg.setBounds(0, 0, 1680, 945);
		contentPane.add(bg);
	}
}
