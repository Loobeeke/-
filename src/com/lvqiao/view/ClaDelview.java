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
import com.lvqiao.model.ClassType;
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

public class ClaDelview extends JFrame {
	StudentTypeDao typeDao =  new StudentTypeDao();
	private JPanel contentPane;
	private JTextField tx_query;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaDelview frame = new ClaDelview();
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
	public ClaDelview() {
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
					
					int n = JOptionPane.showConfirmDialog(null, "你确定要删除此条信息?", "删除？",JOptionPane.YES_NO_OPTION);
					if(n==0){
						int row = table.getSelectedRow();
						String tname = table.getValueAt(row, 1).toString();
						//System.out.println(tname);
						StudentTypeDao conn = new StudentTypeDao();
						conn.delcla(tname);
						JOptionPane.showMessageDialog(ClaDelview.this, "删除成功！！");
						fillTable(null);
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
						"ID", "\u8BFE\u7A0B\u540D", "\u4E0A\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u6559\u5E08", "\u4E0A\u8BFE\u65B9\u5F0F"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		DefaultTableModel defaultclaTable = (DefaultTableModel)table.getModel();
		List<ClassType> clatype = typeDao.queryclaType(null);
		for(ClassType type: clatype){
			defaultclaTable.addRow(new Object[]{type.getC_id(),type.getC_name(),type.getC_time(),type.getC_teacher(),type.getC_site()});
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(224);
		scrollPane.setViewportView(table);
		
		label = new JLabel("\u00B7\u5220\u9664\u64CD\u4F5C");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("隶书", Font.PLAIN, 30));
		label.setBounds(471, -18, 212, 101);
		contentPane.add(label);
		
		label_1 = new JLabel("\u53CC\u51FB\u5220\u9664");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("隶书", Font.PLAIN, 30));
		label_1.setBounds(1088, 47, 212, 101);
		contentPane.add(label_1);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ClaDelview.class.getResource("/images/class.png")));
		bg.setBounds(0, 0, 1300, 731);
		contentPane.add(bg);
	}
	public void fillTable(String tname) {
		DefaultTableModel defaultclaTable = (DefaultTableModel)table.getModel();
		defaultclaTable.setRowCount(0);
		List<ClassType> clatype = typeDao.queryclaType(tname);
		for(ClassType type: clatype){
			defaultclaTable.addRow(new Object[]{type.getC_id(),type.getC_name(),type.getC_time(),type.getC_teacher(),type.getC_site()});
		}
	}
}
