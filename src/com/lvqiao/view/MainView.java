package com.lvqiao.view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.lvqiao.dao.StudentTypeDao;
import com.lvqiao.model.ClassType;
import com.lvqiao.model.ReaderType;
import com.lvqiao.model.StudentType;
import com.lvqiao.util.JdbcUtil;
import com.lvqiao.util.Weather;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	
	private static final String DefaultTableModel = null;
	private JPanel contentPane;
	public static JLabel lb_time;
	String time;
	StudentTypeDao typeDao =  new StudentTypeDao();
	private JTable table;
	private JTable table_1;
	private TableModel model;
	private JTable table_2;
	private JTable table_3;
	private JLabel label;
	private JLabel label_1;
	static JLabel day2_img;
	static JLabel day2;
	static JLabel day2_T;
	static JLabel day1;
	static JLabel day1_T;
	static JLabel day1_img;
	static JLabel site;
	static JTextArea textArea;
	static JLabel time_1;
	static JLabel day3;
	static JLabel day3_img;
	static JLabel day3_T;
	static JLabel day4;
	static JLabel day4_img;
	static JLabel day4_T;
	private JButton bt_reader_1;
	private JButton bt_class;
	private JButton bt_stu;
	static JLabel stu_num;
	static JLabel cla_num;
	static JLabel reader_num;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1680, 945);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_time = new JLabel("");
		lb_time.setFont(new Font("华文隶书", Font.PLAIN, 22));
		
		SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		lb_time.setText(myfmt.format(new java.util.Date()).toString());
		lb_time.setForeground(Color.WHITE);
		lb_time.setBounds(10, 849, 190, 32);
		contentPane.add(lb_time);
		
		JLabel lb_name = new JLabel("");
		lb_name.setForeground(new Color(204, 255, 255));
		lb_name.setFont(new Font("华文行楷", Font.PLAIN, 40));
		lb_name.setBounds(78, 168, 122, 51);
		lb_name.setText(LoginView.t_name);
		contentPane.add(lb_name);
		
		stu_num = new JLabel("");
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		String stu = Integer.toString(jdbcUtil.stucount());
		System.out.println("学生数："+stu);
		stu_num.setText(stu);
		
		stu_num.setForeground(Color.WHITE);
		stu_num.setFont(new Font("华文琥珀", Font.PLAIN, 50));
		stu_num.setBounds(389, 168, 63, 88);
		
		contentPane.add(stu_num);
		
		cla_num = new JLabel("");
		System.out.println("课程数："+jdbcUtil.classcount());
		String cla = Integer.toString(jdbcUtil.classcount());
		cla_num.setText(cla);
		
		cla_num.setForeground(Color.WHITE);
		cla_num.setFont(new Font("华文琥珀", Font.PLAIN, 50));
		cla_num.setBounds(590, 168, 63, 88);
		contentPane.add(cla_num);
		
		reader_num = new JLabel("");
		
		System.out.println("留言数："+jdbcUtil.mescount());
		String mes = Integer.toString(jdbcUtil.mescount());
		reader_num.setText(mes);
		reader_num.setForeground(Color.WHITE);
		reader_num.setFont(new Font("华文琥珀", Font.PLAIN, 50));
		reader_num.setBounds(803, 171, 63, 88);
		contentPane.add(reader_num);
		
		JButton jb_exit = new JButton("");
		jb_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "你确定要退出?", "退出?",JOptionPane.YES_NO_OPTION);
				if(n==0){
					System.exit(0);
					
				}
			}
		});
		jb_exit.setBounds(1601, 5, 63, 39);
		jb_exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		jb_exit.setContentAreaFilled(false);
		contentPane.add(jb_exit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 447, 419, 369);
		scrollPane.setViewportBorder(null);
		scrollPane.getViewport().setOpaque(false);//将JScrollPane设置为透明
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setBackground(new Color(39,61,93));
		scrollPane.setOpaque(false);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setRowHeight(30);
		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.setDefaultRenderer(Object.class, tcr);
		
		table_1.setFont(new Font("宋体", Font.PLAIN, 16));
		table_1.getTableHeader().setBackground(new Color(39,61,93));
		table_1.getTableHeader().setForeground(new Color(255,255,255));
		table_1.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_1.setBackground(new Color(39,61,93));
		//table_1.setShowGrid(false);
		//table_1.setShowHorizontalLines(false);
		table_1.setForeground(new Color(255, 255, 255));
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
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(1227, 447, 427, 369);
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.getViewport().setOpaque(false);//将JScrollPane设置为透明
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setBackground(new Color(21,22,24));
		scrollPane_1.setOpaque(false);

		contentPane.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setRowHeight(30);
		// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_2.setDefaultRenderer(Object.class, tcr);
		table_2.setFont(new Font("宋体", Font.PLAIN, 16));
		table_2.getTableHeader().setBackground(new Color(21,22,24));
		table_2.getTableHeader().setForeground(new Color(255,255,255));
		table_2.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_2.setBackground(new Color(21,22,24));
		//table_2.setShowGrid(false);//隐藏横竖线
		//table_2.setShowVerticalLines(false);//隐藏竖线
		table_2.setForeground(new Color(255, 255, 255));
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
		scrollPane_1.setViewportView(table_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(692, 447, 498, 369);
		scrollPane_2.setViewportBorder(null);
		scrollPane_2.getViewport().setOpaque(false);//将JScrollPane设置为透明
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setBackground(new Color(42,54,71));
		scrollPane_2.setOpaque(false);
		contentPane.add(scrollPane_2);
		
		table_3 = new JTable();
		table_3.setRowHeight(30);
		
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table_3.setDefaultRenderer(Object.class, tcr);
		
		table_3.setFont(new Font("宋体", Font.PLAIN, 16));
		table_3.getTableHeader().setBackground(new Color(42,54,71));
		table_3.getTableHeader().setForeground(new Color(255,255,255));
		table_3.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 18));
		table_3.setBackground(new Color(42,54,71));
		//table_2.setShowGrid(false);//隐藏横竖线
		//table_2.setShowVerticalLines(false);//隐藏竖线
		table_3.setForeground(new Color(255, 255, 255));
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
		scrollPane_2.setViewportView(table_3);
		
		JButton bt_reader = new JButton("");
		bt_reader.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_reader.setContentAreaFilled(false);
		bt_reader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReaderMesView reaView = new ReaderMesView();
				reaView.setVisible(true);
			}
		});
		bt_reader.setBounds(267, 835, 113, 39);
		contentPane.add(bt_reader);
		
		JButton bt_stu_1 = new JButton("");
		bt_stu_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_stu_1.setContentAreaFilled(false);
		bt_stu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentMesView stuView = new StudentMesView();
				stuView.setVisible(true);
			}
		});
		bt_stu_1.setBounds(1257, 835, 113, 39);
		contentPane.add(bt_stu_1);
		
		JButton bt_class_1 = new JButton("");
		
		//按钮透明
		bt_class_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_class_1.setContentAreaFilled(false);
		bt_class_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClassMesView claView = new ClassMesView();
				claView.setVisible(true);
			}
		});
		bt_class_1.setBounds(749, 835, 113, 39);
		contentPane.add(bt_class_1);
		
		site = new JLabel("");
		site.setForeground(new Color(255, 255, 255));
		Weather weather = new Weather();
		//String site1 = Siteview.textField.getText();
		//如果无法使用，那就是服务到期了，请把Weather内id改为null
		weather.weather(Siteview.resite);
		String str = weather.site0;
		site.setText(str);
		
		site.setFont(new Font("华文隶书", Font.PLAIN, 30));
		site.setBounds(1165, 108, 63, 32);
		contentPane.add(site);
		
		label = new JLabel("\u5929\u6C14\u5B9E\u51B5");
		label.setFont(new Font("华文隶书", Font.PLAIN, 20));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(1093, 160, 85, 24);
		contentPane.add(label);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("方正姚体", Font.PLAIN, 15));
		textArea.setBounds(1064, 194, 158, 54);
		textArea.setText(weather.real_wea);
		textArea.setLineWrap(true);	//设置多行文本框自动换行
		textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		textArea.setOpaque(false);
		contentPane.add(textArea);
		
		time_1 = new JLabel("");
		time_1.setFont(new Font("黑体", Font.PLAIN, 18));
		time_1.setForeground(new Color(245, 255, 255));
		time_1.setBounds(1052, 326, 176, 24);
		
		time_1.setText(weather.time);
		contentPane.add(time_1);
		
		label_1 = new JLabel("\u66F4\u65B0\u65F6\u95F4");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		label_1.setBounds(1052, 292, 85, 24);
		contentPane.add(label_1);
		
		JButton button = new JButton("");
		//使按钮透明
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		button.setContentAreaFilled(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Siteview siteview = new Siteview();
				siteview.setVisible(true);
				
			}
		});
		button.setBounds(1581, 89, 93, 23);
		contentPane.add(button);
		
		day1 = new JLabel("");
		day1.setForeground(Color.WHITE);
		day1.setFont(new Font("方正姚体", Font.PLAIN, 20));
		day1.setBounds(1242, 108, 158, 32);
		day1.setText(weather.day_1);
		contentPane.add(day1);
		
		day1_img = new JLabel("");
		day1_img.setBounds(1287, 151, 54, 44);
		System.out.println(weather.day_1_P);
		if(weather.day_1_P.equals("0.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
		}
		if(weather.day_1_P.equals("1.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
		}
		if(weather.day_1_P.equals("2.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
		}
		if(weather.day_1_P.equals("3.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
		}
		if(weather.day_1_P.equals("4.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
		}
		if(weather.day_1_P.equals("5.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
		}
		if(weather.day_1_P.equals("6.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
		}
		if(weather.day_1_P.equals("7.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
		}
		if(weather.day_1_P.equals("8.gif")){
			day1_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
		}
		contentPane.add(day1_img);
		
		day1_T = new JLabel("");
		day1_T.setForeground(Color.WHITE);
		day1_T.setFont(new Font("华文隶书", Font.PLAIN, 22));
		day1_T.setBounds(1266, 205, 93, 32);
		day1_T.setText(weather.day_1_T);
		contentPane.add(day1_T);
		
		day2 = new JLabel((String) null);
		day2.setForeground(Color.WHITE);
		day2.setFont(new Font("方正姚体", Font.PLAIN, 20));
		day2.setText(weather.day_2);
		day2.setBounds(1471, 108, 158, 32);
		contentPane.add(day2);
		
		day2_img = new JLabel("");
		day2_img.setBounds(1522, 151, 54, 44);
		if(weather.day_2_P.equals("0.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
		}
		if(weather.day_2_P.equals("1.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
		}
		if(weather.day_2_P.equals("2.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
		}
		if(weather.day_2_P.equals("3.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
		}
		if(weather.day_2_P.equals("4.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
		}
		if(weather.day_2_P.equals("5.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
		}
		if(weather.day_2_P.equals("6.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
		}
		if(weather.day_2_P.equals("7.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
		}
		if(weather.day_2_P.equals("8.gif")){
			day2_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
		}
		contentPane.add(day2_img);
		
		day2_T = new JLabel((String) null);
		day2_T.setForeground(Color.WHITE);
		day2_T.setFont(new Font("华文隶书", Font.PLAIN, 22));
		day2_T.setBounds(1512, 205, 93, 32);
		day2_T.setText(weather.day_2_T);
		contentPane.add(day2_T);
		
		day3 = new JLabel((String) null);
		day3.setForeground(Color.WHITE);
		day3.setFont(new Font("方正姚体", Font.PLAIN, 20));
		day3.setBounds(1242, 240, 158, 32);
		day3.setText(weather.day_3);
		contentPane.add(day3);
		
		day3_img = new JLabel("");
		day3_img.setBounds(1287, 272, 54, 44);
		if(weather.day_3_P.equals("0.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
		}
		if(weather.day_3_P.equals("1.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
		}
		if(weather.day_3_P.equals("2.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
		}
		if(weather.day_3_P.equals("3.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
		}
		if(weather.day_3_P.equals("4.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
		}
		if(weather.day_3_P.equals("5.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
		}
		if(weather.day_3_P.equals("6.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
		}
		if(weather.day_3_P.equals("7.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
		}
		if(weather.day_3_P.equals("8.gif")){
			day3_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
		}
		contentPane.add(day3_img);
		
		day3_T = new JLabel((String) null);
		day3_T.setForeground(Color.WHITE);
		day3_T.setFont(new Font("华文隶书", Font.PLAIN, 22));
		day3_T.setBounds(1257, 318, 93, 32);
		day3_T.setText(weather.day_3_T);
		contentPane.add(day3_T);
		
		day4 = new JLabel((String) null);
		day4.setForeground(Color.WHITE);
		day4.setFont(new Font("方正姚体", Font.PLAIN, 20));
		day4.setBounds(1471, 240, 158, 32);
		day4.setText(weather.day_4);
		contentPane.add(day4);
		
		day4_img = new JLabel("");
		day4_img.setBounds(1536, 272, 54, 44);
		System.out.println(weather.day_4_P);
		if(weather.day_4_P.equals("0.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_0.gif")));
		}
		if(weather.day_4_P.equals("1.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_1.gif")));
		}
		if(weather.day_4_P.equals("2.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_2.gif")));
		}
		if(weather.day_4_P.equals("3.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_3.gif")));
		}
		if(weather.day_4_P.equals("4.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_4.gif")));
		}
		if(weather.day_4_P.equals("5.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_5.gif")));
		}
		if(weather.day_4_P.equals("6.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_6.gif")));
		}
		if(weather.day_4_P.equals("7.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_7.gif")));
		}
		if(weather.day_4_P.equals("8.gif")){
			day4_img.setIcon(new ImageIcon(MainView.class.getResource("/images/weather/b_8.gif")));
		}
		contentPane.add(day4_img);
		
		day4_T = new JLabel((String) null);
		day4_T.setForeground(Color.WHITE);
		day4_T.setText(weather.day_4_T);
		day4_T.setFont(new Font("华文隶书", Font.PLAIN, 22));
		day4_T.setBounds(1512, 318, 93, 32);
		contentPane.add(day4_T);
		
		bt_reader_1 = new JButton("");
		bt_reader_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaManage reaManage = new ReaManage();
				reaManage.setVisible(true);
			}
		});
		bt_reader_1.setContentAreaFilled(false);
		bt_reader_1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_reader_1.setBounds(512, 835, 113, 39);
		contentPane.add(bt_reader_1);
		
		bt_class = new JButton("");
		bt_class.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClaManage claManage = new ClaManage();
				claManage.setVisible(true);
			}
		});
		bt_class.setContentAreaFilled(false);
		bt_class.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_class.setBounds(1024, 835, 113, 39);
		contentPane.add(bt_class);
		
		bt_stu = new JButton("");
		bt_stu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuManage stuManage = new StuManage();
				stuManage.setVisible(true);
			}
		});
		bt_stu.setContentAreaFilled(false);
		bt_stu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
		bt_stu.setBounds(1510, 832, 113, 39);
		contentPane.add(bt_stu);
		
		
		
	
		JLabel bg = new JLabel("");
		bg.setFont(new Font("华文行楷", Font.PLAIN, 26));
		bg.setForeground(Color.WHITE);
		bg.setIcon(new ImageIcon(MainView.class.getResource("/images/Main1.png")));
		bg.setBounds(0, 5, 1664, 901);
		contentPane.add(bg);
	}
}
