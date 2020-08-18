package com.lvqiao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.model.ReaderType;
import com.lvqiao.model.StudentType;
import com.lvqiao.util.JdbcUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderResetview extends JFrame {
	StudentTypeDao typeDao =  new StudentTypeDao();
	private JPanel contentPane;
	private JTextField tx_query;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;
	private JLabel label_1;
	static String rtitle;
	static String rcontent;
	static String rname ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderResetview frame = new ReaderResetview();
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
	public ReaderResetview() {
		setTitle("留言信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1310, 751);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tx_query = new JTextField();
		tx_query.setBounds(367, 90, 143, 27);
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
		bt_query.setBounds(520, 92, 26, 23);
		contentPane.add(bt_query);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 137, 987, 565);
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
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					rtitle = table.getValueAt(row, 1).toString();
					rcontent = table.getValueAt(row, 2).toString();
					rname = table.getValueAt(row, 3).toString();
					int n = JOptionPane.showConfirmDialog(null, "你确定要回复"+rname+"发送的此条信息?", "删除？",JOptionPane.YES_NO_OPTION);
					if(n==0){
						
						ReaderReset readerReset = new ReaderReset();
						readerReset.setVisible(true);
					}
					} 
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
		
		label = new JLabel("\u00B7\u56DE\u590D\u7559\u8A00");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("隶书", Font.PLAIN, 30));
		label.setBounds(471, -18, 212, 101);
		contentPane.add(label);
		
		label_1 = new JLabel("\u53CC\u51FB\u56DE\u590D\u7559\u8A00");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("隶书", Font.PLAIN, 30));
		label_1.setBounds(1088, 47, 212, 101);
		contentPane.add(label_1);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ReaderResetview.class.getResource("/images/reader.png")));
		bg.setBounds(0, 0, 1300, 731);
		contentPane.add(bg);
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
