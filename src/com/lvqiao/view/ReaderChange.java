package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.model.ClassType;
import com.lvqiao.model.ReaderType;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReaderChange extends JFrame {
	StudentTypeDao typeDao =  new StudentTypeDao();
	private JPanel contentPane;
	private JTextField tx_query;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField tea;
	private JTextField time;
	private JTextField site;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderChange frame = new ReaderChange();
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
	public ReaderChange() {
		setTitle("课程信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1310, 751);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		tx_query = new JTextField();
		tx_query.setBounds(1106, 92, 143, 27);
		contentPane.add(tx_query);
		tx_query.setColumns(10);
		
		JButton bt_query = new JButton("");
		bt_query.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_query.setContentAreaFilled(false);
		bt_query.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tname = tx_query.getText();
					fillTable(tname);
				
				
			}
		});
		bt_query.setBounds(1259, 92, 26, 23);
		contentPane.add(bt_query);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 137, 987, 565);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setBackground(new Color(39,61,93));
		scrollPane.setOpaque(false);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String tid = table.getValueAt(row, 0).toString();
				String tname = table.getValueAt(row, 1).toString();
				String ttime = table.getValueAt(row, 2).toString();
				String tteacher = table.getValueAt(row, 3).toString();
				String tsite = table.getValueAt(row, 4).toString();
				id.setText(tid);
				name.setText(tname);
				time.setText(ttime);
				site.setText(tsite);
				tea.setText(tteacher);
				id.setHorizontalAlignment(JTextField.CENTER);
				name.setHorizontalAlignment(JTextField.CENTER);
				tea.setHorizontalAlignment(JTextField.CENTER);
				time.setHorizontalAlignment(JTextField.CENTER);
				site.setHorizontalAlignment(JTextField.CENTER);
			}
		});
		table.setRowHeight(30);
		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.getTableHeader().setBackground(new Color(39,61,93));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table.setBackground(new Color(242,247,255));
		//table.setShowGrid(false);
		//table.setShowHorizontalLines(false);
		table.setForeground(new Color(0, 30, 0));
		table.setModel(new DefaultTableModel(
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
		
		DefaultTableModel defaultreaTable = (DefaultTableModel)table.getModel();
		List<ReaderType> reatype = typeDao.queryreaType(null);
		for(ReaderType type: reatype){
			defaultreaTable.addRow(new Object[]{type.getId(),type.getTitle(),type.getContent(),type.getFrom_name()});
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(224);
		scrollPane.setViewportView(table);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.PLAIN, 20));
		id.setBounds(72, 278, 114, 27);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("宋体", Font.PLAIN, 20));
		name.setColumns(10);
		name.setBounds(44, 357, 169, 27);
		contentPane.add(name);
		
		tea = new JTextField();
		tea.setFont(new Font("宋体", Font.PLAIN, 20));
		tea.setColumns(10);
		tea.setBounds(44, 516, 169, 27);
		contentPane.add(tea);
		
		time = new JTextField();
		time.setFont(new Font("宋体", Font.PLAIN, 20));
		time.setColumns(10);
		time.setBounds(10, 437, 235, 27);
		contentPane.add(time);
				
				site = new JTextField();
				site.setFont(new Font("宋体", Font.PLAIN, 20));
				site.setColumns(10);
				site.setBounds(44, 596, 169, 27);
				contentPane.add(site);
				
				JButton reset = new JButton("");
				reset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				reset.setContentAreaFilled(false);
				reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
				reset.setBounds(10, 660, 235, 42);
				contentPane.add(reset);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(ReaderChange.class.getResource("/images/readerchange.png")));
				lblNewLabel.setBounds(0, 0, 1300, 735);
				contentPane.add(lblNewLabel);
	}
	public void fillTable(String tname) {
		DefaultTableModel defaultreaTable = (DefaultTableModel)table.getModel();
		defaultreaTable.setRowCount(0);
		List<ReaderType> reatype = typeDao.queryreaType(tname);
		for(ReaderType type: reatype){
			defaultreaTable.addRow(new Object[]{type.getId(),type.getTitle(),type.getContent(),type.getFrom_name()});
		}
	}
}
