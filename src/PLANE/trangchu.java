package PLANE;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.crypto.BadPaddingException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;

public class trangchu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_email;

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

	/**
	 * Create the frame.
	 */
	final JButton bt_logout = new JButton("");	
	final JMenu menu_dangnhap = new JMenu("Đăng Nhập");
	final JMenu menu_NV = new JMenu("Nhân viên");
	final JMenu menu_NQL = new JMenu("Người quản lý");
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
		lblNewLabel.setBounds(625, 25, 463, 44);
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
		
		JMenuItem item_nhieuchang = new JMenuItem("Nhiều chặng");
		item_nhieuchang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new muave_nhieuchang();
			}
		});
		item_nhieuchang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_muave.add(item_nhieuchang);
		
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
		menu_thongtin.add(item_quydinh);
		
		JMenu mnDchV = new JMenu("Dịch vụ ");
		mnDchV.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnDchV.setBounds(295, 72, 113, 27);
		menuBar.add(mnDchV);
		
		JMenuItem item_hoanve = new JMenuItem("Hoàn vé");
		item_hoanve.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_hoanve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new dichvu_hoanve();
			}
		});
		mnDchV.add(item_hoanve);
		
		JMenuItem item_muahanhly = new JMenuItem("Mua thêm hành lý");
		item_muahanhly.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_muahanhly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new dv_muathem_hanhly();
			}
		});
		mnDchV.add(item_muahanhly);
		
		JMenu menu_khuyenmai = new JMenu("Khuyến mãi");
		menu_khuyenmai.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_khuyenmai.setBounds(189, 110, 113, 27);
		menuBar.add(menu_khuyenmai);
		
		JMenuItem item_theothang = new JMenuItem("Khuyến mãi theo tháng");
		item_theothang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item_theothang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Khuyenmai_theothang();
			}
		});
		menu_khuyenmai.add(item_theothang);
		
		JMenuItem item_kh_thanthiet = new JMenuItem("Khuyến mãi cho khách hàng thân thiết");
		item_kh_thanthiet.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_khuyenmai.add(item_kh_thanthiet);
		
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
				new DangKy_khachhang();
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
		
		JRadioButton RadioButton_dk_nhantin = new JRadioButton("Đăng ký nhận thông tin");
		RadioButton_dk_nhantin.setBackground(new Color(255, 255, 224));
		RadioButton_dk_nhantin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		RadioButton_dk_nhantin.setForeground(new Color(0, 0, 0));
		RadioButton_dk_nhantin.setBounds(63, 109, 236, 23);
		panel_chamsockhachhang.add(RadioButton_dk_nhantin);
		
		JLabel lb_email = new JLabel("Email: ");
		lb_email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_email.setBounds(37, 151, 43, 14);
		panel_chamsockhachhang.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(90, 149, 186, 20);
		panel_chamsockhachhang.add(textField_email);
		textField_email.setColumns(10);
		
		JButton bt_dangky = new JButton("Đăng ký");
		bt_dangky.setBackground(new Color(255, 218, 185));
		bt_dangky.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bt_dangky.setBounds(119, 190, 89, 23);
		panel_chamsockhachhang.add(bt_dangky);
		
		JTextArea lb_tt_cskh = new JTextArea();
		lb_tt_cskh.setBackground(new Color(255, 255, 224));
		lb_tt_cskh.setForeground(new Color(178, 34, 34));
		lb_tt_cskh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lb_tt_cskh.setLineWrap(true);
		lb_tt_cskh.setWrapStyleWord(true);
		lb_tt_cskh.setText("Để đặt chỗ và nhận các thông tin cần thiết");
		lb_tt_cskh.setBounds(38, 80, 238, 22);
		panel_chamsockhachhang.add(lb_tt_cskh);
		
		
		menu_NV.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_NV.setBounds(509, 108, 113, 27);
		menuBar.add(menu_NV);
		
		menu_NV.setVisible(false);
		
		JMenuItem menuItem_qlttkh = new JMenuItem("Quản lý thông tin hành khách");
		menuItem_qlttkh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLy_hanhkhach();
			}
		});
		menuItem_qlttkh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_qlttkh);
		
		JMenuItem menuItem_QLVE = new JMenuItem("Quản lý vé");
		menuItem_QLVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new nv_quanlyve();
			}
		});
		
		JMenuItem menu_qly_datve = new JMenuItem("Quản lý đặt vé");
		menu_qly_datve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLy_DatVe();
			}
		});
		menu_qly_datve.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menu_qly_datve);
		menuItem_QLVE.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NV.add(menuItem_QLVE);
		
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
		
		JMenuItem menuItem_QLCD = new JMenuItem("Quản lý chặng dừng");
		menuItem_QLCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new quanly_changdung();
			}
		});
		menuItem_QLCD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(menuItem_QLCD);
		
		JMenuItem menuItem_QLTC = new JMenuItem("Quản lý tài chính");
		menuItem_QLTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quanly_taichinh();
			}
		});
		menuItem_QLTC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu_NQL.add(menuItem_QLTC);
		
		JLabel lb = new JLabel("");
		lb.setBounds(0, 136, 960, 435);
		contentPane.add(lb);
		
		
		ImageIcon icon=new ImageIcon("phongcanh.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(958, 449, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lb.setIcon(scaleIcon);
		
		
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
		
		
		menu_dangnhap.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menu_dangnhap.setBounds(407, 96, 93, 40);
		
				JMenuItem item_nhanvien = new JMenuItem("Nhân viên");
				item_nhanvien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				item_nhanvien.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new DangNhap(1,menu_NV, null,menu_dangnhap,bt_logout);
						
							
					}
				});
				menu_dangnhap.add(item_nhanvien);
				
				JMenuItem item_khachhang = new JMenuItem("Khách hàng");
				item_khachhang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				item_khachhang.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new DangNhap(0,null, null, menu_dangnhap,bt_logout);
					}
				});
				menu_dangnhap.add(item_khachhang);
				
				JMenuItem item_quanly = new JMenuItem("Quản lý");
				item_quanly.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				item_quanly.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new DangNhap(2,menu_NQL,menu_NV,menu_dangnhap,bt_logout);
					}
				});
				menu_dangnhap.add(item_quanly);
				
				JMenu menu_changdung = new JMenu("Chặng dừng ");
				menuBar.add(menu_changdung);
				menu_changdung.setFont(new Font("Segoe UI", Font.BOLD, 15));
				menu_changdung.setBounds(264, 96, 103, 42);
				
				JMenuItem menu_tracuuCD = new JMenuItem("tra cứu");
				menu_tracuuCD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new tracuu_changdung();
					}
					
				});
				menu_tracuuCD.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				menu_tracuuCD.setHorizontalAlignment(SwingConstants.CENTER);
				menu_changdung.add(menu_tracuuCD);
		

;
		
		

	}
}
