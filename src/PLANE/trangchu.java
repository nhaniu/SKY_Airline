package PLANE;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.crypto.BadPaddingException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Taskbar.State;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;


import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.SystemColor;

public class trangchu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trangchu frame = new trangchu();
					frame.setVisible(true);
					ImageIcon icon=new ImageIcon("logo.png");
					Image imgIcon =icon.getImage();
					frame.setIconImage(imgIcon);
					
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}
//
	/**
	 * Create the frame.
	 */
	final JButton bt_logout = new JButton("");	
	final JMenu menu_dangnhap = new JMenu("Đăng Nhập");
	final JMenu menu_NV = new JMenu("Nhân viên");
	final JMenu menu_NQL = new JMenu("Người quản lý");
	JButton bt_user = new JButton("");
	
    private int itemChoser=0;
    private String a=null,b=null;
	public trangchu() {		
		setTitle("SKY Airline");
		setBackground(new Color(240, 255, 255));
		getContentPane().setLayout(null);
		this.setSize(1297,701);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1400, 97);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_tieude = new JLabel("Sky Airline");
		lb_tieude.setSize(new Dimension(1, 0));
		lb_tieude.setBackground(new Color(144, 238, 144));
		lb_tieude.setFont(new Font("UTM French Vanilla", Font.BOLD, 40));
		lb_tieude.setBounds(93, 14, 207, 61);
		panel.add(lb_tieude);
		
		JLabel lb_logo = new JLabel("");
		lb_logo.setBounds(10, 14, 60, 55);
		panel.add(lb_logo);
		
		ImageIcon icon1=new ImageIcon("iconplane.png");
		Image imgIcon1 =icon1.getImage();
		Image imgScale1 =imgIcon1.getScaledInstance(lb_logo.getWidth(), lb_logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon1=new ImageIcon(imgScale1);
		lb_logo.setIcon(scaleIcon1);
		
		JLabel lblNewLabel = new JLabel("Cùng Sky Airline - Bay vào tương lai");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("UTM French Vanilla", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(571, 26, 463, 44);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(60, 96, 1400, 42);
		menuBar.setBackground(new Color(255, 255, 224));
		contentPane.add(menuBar);
		
		
		bt_logout.setVisible(false);
		bt_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_NV.setVisible(false);
				menu_NQL.setVisible(false);
				menu_dangnhap.setVisible(true);
				bt_logout.setVisible(false);
				bt_user.setVisible(false);
				
			}
		});
		bt_logout.setBackground(new Color(0, 191, 255));
		bt_logout.setBounds(1213, 30, 42, 42);
		panel.add(bt_logout);
		ImageIcon icon_logout=new ImageIcon("logout.png");
		Image imgIcon_logout =icon_logout.getImage();
		Image imgScale_logout =imgIcon_logout.getScaledInstance(38,38, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon_logout=new ImageIcon(imgScale_logout);
		bt_logout.setIcon(scaleIcon_logout);
		
		
		
		
		JMenu menu_muave = new JMenu("Mua vé");
		menu_muave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_muave.setBorder(new EmptyBorder(1, 1, 1, 1));
		menu_muave.setHorizontalAlignment(SwingConstants.CENTER);
		menu_muave.setBackground(new Color(255, 255, 224));
		menu_muave.setBounds(76, 72, 113, 27);
		menuBar.add(menu_muave);

		
		JMenuItem item_motchieu = new JMenuItem("Một chiều");
		item_motchieu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_motchieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new muave_motchieu();}
		});
		menu_muave.add(item_motchieu);
		
		JMenuItem item_khuhoi = new JMenuItem("Khứ hồi");
		item_khuhoi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_khuhoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				new muave_khuhoi();
			}
		});
		menu_muave.add(item_khuhoi);
		
//		JMenuItem item_nhieuchang = new JMenuItem("Nhiều chặng");
//		item_nhieuchang.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new muave_nhieuchang();
//			}
//		});
//		item_nhieuchang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//		menu_muave.add(item_nhieuchang);
		
		JMenu menu_thongtin = new JMenu("Thông tin");
		menu_thongtin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_thongtin.setBounds(185, 72, 113, 27);
		menuBar.add(menu_thongtin);
		
		JMenuItem item_ttboithuong = new JMenuItem("Thông tin bồi thường ứng trước không hoàn lại");
		item_ttboithuong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_ttboithuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new thongtin_boithuong();
			}
			
		});
		menu_thongtin.add(item_ttboithuong);
		
		JMenuItem item_dieukienve = new JMenuItem("Điều kiện vé");
		item_dieukienve.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_dieukienve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new thongtin_dieukienve();
			}
		});
		menu_thongtin.add(item_dieukienve);
		
		JMenuItem item_lephi = new JMenuItem("Phí và lệ phí");
		item_lephi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_lephi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new thongthi_phi();
			}
		});
		menu_thongtin.add(item_lephi);
		
		JMenuItem item_giaytotuythan = new JMenuItem("Giấy tờ tùy thân");
		item_giaytotuythan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_giaytotuythan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new thongtin_giaytotuythan();
			}
		});
		menu_thongtin.add(item_giaytotuythan);
		
		JMenuItem item_quydinh = new JMenuItem("Các quy định pháp luật liên quan");
		item_quydinh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_quydinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new thongtin_quydinhphapluat();
			}
		});
		
		JMenuItem menuItem_khuyenmai_khtt = new JMenuItem("Thông tin khuyến mãi cho khách hàng thân thiết");
		menuItem_khuyenmai_khtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new khuyenmai_khachhang_thanthiet();
			}
		});
		menuItem_khuyenmai_khtt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_thongtin.add(menuItem_khuyenmai_khtt);
		menu_thongtin.add(item_quydinh);
		
		JMenu menu_dichvu = new JMenu("Dịch vụ ");
		menu_dichvu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_dichvu.setBounds(295, 72, 113, 27);
		menuBar.add(menu_dichvu);
		
		JMenuItem item_hoanve = new JMenuItem("Hoàn vé");
		item_hoanve.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_hoanve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new dichvu_hoanve();
			}
		});
		menu_dichvu.add(item_hoanve);
		
		JMenuItem item_muahanhly = new JMenuItem("Đăng ký dịch vụ bổ trợ");
		item_muahanhly.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_muahanhly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new dv_muathem_hanhly();
			}
		});
		menu_dichvu.add(item_muahanhly);
		
		JMenu menu_khuyenmai = new JMenu("Khuyến mãi");
		menu_khuyenmai.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_khuyenmai.setBounds(189, 110, 113, 27);
		menuBar.add(menu_khuyenmai);
		
		JMenuItem item_theothang = new JMenuItem("Khuyến mãi vào các dịp đặc biệt");
		item_theothang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_theothang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame1=new JFrame();
				frame1.setVisible(true);
				frame1.setBackground(new Color(240, 255, 255));
				frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame1.setBounds(100, 100, 733, 335);
				JPanel panel = new JPanel();
				panel.setBackground(new Color(240, 255, 255));
				panel.setBorder(new EmptyBorder(5, 5, 5, 5));
				frame1.getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Khuyến mãi vào các dịp lễ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
				lblNewLabel.setBounds(58, 15, 595, 30);
				panel.add(lblNewLabel);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(5, 56, 688, 14);
				panel.add(separator);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 81, 683, 184);
				panel.add(scrollPane);
				
				JTable table = new JTable();
				scrollPane.setViewportView(table);

				final DefaultTableModel tableModel = new DefaultTableModel();
				tableModel.addColumn("ID");
				tableModel.addColumn("Ngày bắt đầu");
				tableModel.addColumn("Ngày kết thúc");
				tableModel.addColumn("Nội dung");
				tableModel.addColumn("Phần trăm khuyến mãi");
				
				JTableHeader Theader = table.getTableHeader();
				 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				Theader.setBackground(new Color(255, 255, 255));
				table.setModel(tableModel);
				Theader.setBackground(new Color(135, 206, 250));
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					

					String search="select* from BKHUYENMAI";				
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String id =rs.getString(1);
						String ngaybatdau =rs.getString(2);
						String ngayketthuc =rs.getString(3);
						String noidung =rs.getString(4);					
						String phantram =rs.getString(5);					

						
						tableModel.addRow(new Object[] {id,ngaybatdau,ngayketthuc,noidung,phantram});
						table.setModel(tableModel);
						//table.setVisible(true);
						//scrollPane.setVisible(true);

					}
					
					con.close();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				

				
			}
		});
		menu_khuyenmai.add(item_theothang);
		
		JTextArea textfield_bottom = new JTextArea();
		textfield_bottom.setBounds(0, 570, 1283, 97);
		//sl_contentPane.putConstraint(SpringLayout.NORTH, textfield_bottom, 577, SpringLayout.NORTH, contentPane);
		//sl_contentPane.putConstraint(SpringLayout.WEST, textfield_bottom, 0, SpringLayout.WEST, panel);
		//sl_contentPane.putConstraint(SpringLayout.SOUTH, textfield_bottom, 1627, SpringLayout.NORTH, contentPane);
		//sl_contentPane.putConstraint(SpringLayout.EAST, textfield_bottom, 1283, SpringLayout.WEST, contentPane);
		textfield_bottom.setEditable(false);
		textfield_bottom.setLineWrap(true);
		textfield_bottom.setBackground(new Color(0, 191, 255));
		textfield_bottom.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textfield_bottom.setText("                                        Tổng công ty hàng không Việt Nam                                                                       Email: plane@uit.edu.vn\r\n                             Địa chỉ: Khu phố 6, phường Linh Trung, tp Thủ Đức                                                 facebook: facebook.com/skyairline/\r\n                                                       SĐT: 19001234                                                                           youtube: youtube.com/chanel/skyairline               \r\n  ");
		contentPane.add(textfield_bottom);
		
		
		
		JMenu menu_dangky = new JMenu("Đăng ký");
		menu_dangky.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_dangky.setBounds(409, 75, 113, 27);
		menuBar.add(menu_dangky);
		
		JMenuItem item_dk_khachhang = new JMenuItem("Khách hàng");
		item_dk_khachhang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_dk_khachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Dangky_taikhoan();
			}
		});
		menu_dangky.add(item_dk_khachhang);
		
		JButton bt_trangchu = new JButton("");
		bt_trangchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_trangchu.setBounds(10, 97, 50, 41);
		bt_trangchu.setBackground(new Color(255, 250, 250));
		ImageIcon icon_trangchu=new ImageIcon("icontrangchu.png");
		contentPane.add(bt_trangchu);
		Image imgIcon_trangchu =icon_trangchu.getImage();
		Image imgScale_trangchu =imgIcon_trangchu.getScaledInstance(50, 41, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon_trangchu=new ImageIcon(imgScale_trangchu);
		bt_trangchu.setIcon(scaleIcon_trangchu);
		bt_trangchu.setBorder(null);
		
		JPanel panel_chamsockhachhang = new JPanel();
		panel_chamsockhachhang.setBounds(959, 332, 1441, 242);
		panel_chamsockhachhang.setBorder(new EmptyBorder(2, 2, 2, 2));
		panel_chamsockhachhang.setBackground(new Color(255, 255, 224));
		contentPane.add(panel_chamsockhachhang);
		panel_chamsockhachhang.setLayout(null);
		
		JLabel lb_chamsockhachang = new JLabel("Tổng đài đặt vé và hỗ trợ khách hàng");
		lb_chamsockhachang.setForeground(new Color(255, 0, 0));
		lb_chamsockhachang.setHorizontalAlignment(SwingConstants.CENTER);
		lb_chamsockhachang.setBackground(new Color(255, 228, 225));
		lb_chamsockhachang.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb_chamsockhachang.setBounds(0, 5, 312, 27);
		panel_chamsockhachhang.add(lb_chamsockhachang);
		
		JLabel lb_gach = new JLabel("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		lb_gach.setForeground(new Color(255, 0, 0));
		lb_gach.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gach.setHorizontalAlignment(SwingConstants.CENTER);
		lb_gach.setBounds(0, 30, 324, 14);
		panel_chamsockhachhang.add(lb_gach);
		
		JLabel lb_goingay = new JLabel("Gọi ngay : 19001234");
		lb_goingay.setBackground(new Color(255, 250, 250));
		lb_goingay.setForeground(new Color(255, 0, 0));
		lb_goingay.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lb_goingay.setHorizontalAlignment(SwingConstants.CENTER);
		lb_goingay.setBounds(28, 48, 248, 27);
		panel_chamsockhachhang.add(lb_goingay);
		
		JTextArea lb_tt_cskh = new JTextArea();
		lb_tt_cskh.setBackground(new Color(255, 255, 224));
		lb_tt_cskh.setForeground(new Color(178, 34, 34));
		lb_tt_cskh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lb_tt_cskh.setLineWrap(true);
		lb_tt_cskh.setWrapStyleWord(true);
		lb_tt_cskh.setText("Để đặt chỗ và nhận các thông tin cần thiết");
		lb_tt_cskh.setBounds(38, 80, 238, 22);
		panel_chamsockhachhang.add(lb_tt_cskh);
		
		JTextArea txtrThcHinThng = new JTextArea();
		txtrThcHinThng.setBackground(SystemColor.info);
		txtrThcHinThng.setWrapStyleWord(true);
		txtrThcHinThng.setLineWrap(true);
		txtrThcHinThng.setFont(new Font("SVN-Androgyne", Font.PLAIN, 26));
		txtrThcHinThng.setText("Thực hiện thông điệp 5k để phòng chống dịch Covid\r\n");
		txtrThcHinThng.setBounds(10, 124, 302, 87);
		panel_chamsockhachhang.add(txtrThcHinThng);
		
		
		menu_NV.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_NV.setBounds(509, 108, 113, 27);
		menuBar.add(menu_NV);
		
		menu_NV.setVisible(false);
		
		JMenuItem menuItem_qlttkh = new JMenuItem("Quản lý hành khách");
		menuItem_qlttkh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiemhanhkhach();
			}
		});
		menuItem_qlttkh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_qlttkh);
		
		JMenuItem menu_qly_datve = new JMenuItem("Quản lý đặt vé");
		menu_qly_datve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLy_DatVe();
			}
		});
		
		JMenuItem menuItem_QLTK = new JMenuItem("Quản lý tài khoản");
		menuItem_QLTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quanly_taikhoan();
			}
		});
		menuItem_QLTK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_QLTK);
		menu_qly_datve.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menu_qly_datve);
		
		JMenuItem menuItem_QL_DVBT = new JMenuItem("Quản lý dịch vụ bổ trợ");
		menuItem_QL_DVBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quanly_dv_muathemhanhly();
			}
		});
		menuItem_QL_DVBT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_QL_DVBT);
		
		JMenuItem menuItem_QLKM = new JMenuItem("Quản lý khuyến mãi");
		menuItem_QLKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new quanly_khuyenmai();
			}
		});
		menuItem_QLKM.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_QLKM);
		
		
		menu_NQL.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_NQL.setBounds(648, 111, 113, 27);
		menuBar.add(menu_NQL);
		menu_NQL.setVisible(false);
		
		JMenuItem menuItem_QLCB = new JMenuItem("Quản lý chuyến bay");
		menuItem_QLCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new quanly_chuyenbay();
			}
		});
		menuItem_QLCB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(menuItem_QLCB);
		

		
		JMenuItem menuItem_QLTC = new JMenuItem("Quản lý tài chính");
		menuItem_QLTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quanly_taichinh();
			}
		});
		
		JMenuItem menuitem_dk_taikhoan_nv = new JMenuItem("Đăng ký tài khoản cho nhân viên");
		menuitem_dk_taikhoan_nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dangky_taikhoan_nhanvien();
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quản lý sân bay");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new quanly_sanbay();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cập nhật hạng vé, giá vé");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Capnhat_hangve_giave();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(mntmNewMenuItem_1);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(mntmNewMenuItem);
		menuitem_dk_taikhoan_nv.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(menuitem_dk_taikhoan_nv);
		menuItem_QLTC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(menuItem_QLTC);
		
		JLabel lb = new JLabel("");
		lb.setBounds(0, 136, 960, 435);
		contentPane.add(lb);
		
		
		ImageIcon icon3=new ImageIcon("phongcanh.jpg");
		Image imgIcon3 =icon3.getImage();
		Image imgScale3 =imgIcon3.getScaledInstance(958, 449, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon3=new ImageIcon(imgScale3);
		lb.setIcon(scaleIcon3);
		
		
		JLabel lb_dulichxuyenViet = new JLabel("Du lịch xuyên Việt cùng Sky Airline");
		lb_dulichxuyenViet.setForeground(Color.RED);
		lb.add(lb_dulichxuyenViet);
		lb_dulichxuyenViet.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lb_dulichxuyenViet.setBounds(50, 0, 492, 77);
		
		JLabel lb_anh = new JLabel("");
		lb_anh.setBounds(960, 136, 323, 194);
		contentPane.add(lb_anh);
		ImageIcon icon2=new ImageIcon("anh.png");
		Image imgIcon2 =icon2.getImage();
		Image imgScale2 =imgIcon2.getScaledInstance(323, 194, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon2=new ImageIcon(imgScale2);
		lb_anh.setIcon(scaleIcon2);
		menuBar.add(menu_dangnhap);
		menu_dichvu.setVisible(false);
		
		
		menu_dangnhap.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_dangnhap.setBounds(407, 96, 93, 40);
				
				JMenuItem item_khachhang = new JMenuItem("Khách hàng");
				item_khachhang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				item_khachhang.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					    new DangNhap(0,null, null, menu_dangnhap,bt_logout,bt_user,menu_dichvu);
						itemChoser=1;
					}
				});
				menu_dangnhap.add(item_khachhang); 
				
				JMenuItem item_quanly = new JMenuItem("Quản lý");
				item_quanly.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				item_quanly.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					   new dangnhap_quanly(2,menu_NQL,menu_NV,menu_dangnhap,bt_logout,bt_user,menu_dichvu);
					   itemChoser=3;
					}
				});
				menu_dangnhap.add(item_quanly);
				
						JMenuItem item_nhanvien = new JMenuItem("Nhân viên");
						item_nhanvien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
						item_nhanvien.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
						new dangnhap_nhanvien(1,menu_NV, null,menu_dangnhap,bt_logout,bt_user,menu_dichvu);						
						
						
						itemChoser=2;
									
							}
						});
						menu_dangnhap.add(item_nhanvien);
				bt_user.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//System.out.println(a +" "+ b);
						switch (itemChoser) {
						case 1:
						//	DangNhap tg= null;
							new taikhoan_khachhang();
							break;
						case 2:
							//dangnhap_nhanvien dv=null;

							new taikhoan_nhanvien();
							break;
						case 3:
							//dangnhap_quanly ql=null;


							new taikhoan_quanly();
						default:
							break;
						}
					}
				});
				
				

				
				bt_user.setBounds(1161, 30, 42, 42);
				panel.add(bt_user);
				

				ImageIcon icon=new ImageIcon("user.png");
				Image imgIcon =icon.getImage();
				Image imgScale =imgIcon.getScaledInstance(bt_user.getWidth(), bt_user.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon scaleIcon=new ImageIcon(imgScale);
				bt_user.setIcon(scaleIcon);
				
				JMenu menu = new JMenu("New menu");
				menu.setBounds(243, 108, 113, 27);
				contentPane.add(menu);
				bt_user.setVisible(false);

			//	bt_user.setIcon(new ImageIcon("C:\\Users\\nguyen thi nhan\\Downloads\\pngtree-office-work-user-icon-avatar-png-image_4815124.jpg"));
		
		

	}
}
