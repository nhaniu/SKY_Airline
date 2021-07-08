package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.MenuBar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class thanh_toan_mv1chieu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	static String gio_kh_di = new String();
	static String gio_hc_di = new String();
	static String h_ve_di = new String();
	static String gia_ve_di = new String();
	static String noi_di = new String();
	static String noi_den = new String();
	static String gio_kh_ve= new String();
	static String gio_hc_ve = new String();
	static String h_ve_ve = new String();
	static String gia_ve_ve = new String();
	static String danh_xung = new String();
	static String hoten_hk = new String();
	static Date ngaysinh = new Date();
	static String sodt = new String();
	static String email = new String();
	static String quoctich = new String();
	static String goihanhly = new String();
	static String giatien = new String();
	static String iddvbt = new String();
	public static String idkm,idtk;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thanh_toan_mv1chieu frame = new thanh_toan_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk,  ngaysinh, sodt, email, quoctich, goihanhly, giatien, iddvbt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param giatien 
	 * @param goihanhly 
	 */
	public thanh_toan_mv1chieu(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, final String l, String m,  Date b2, String c2, String d2, String e2, String n, String o, String r) {
		gio_kh_di = a;
		gio_hc_di = b;
		h_ve_di = c;
		gia_ve_di = d;
		noi_di = e;
		noi_den = f;
		gio_kh_ve = g;
		gio_hc_ve = h;
		h_ve_ve = i;
		gia_ve_ve = k;
		danh_xung = l;
		hoten_hk = m;
		ngaysinh = b2;
		sodt = c2;
		email = d2;
		quoctich = e2;
		goihanhly = n;
		giatien = o;
		iddvbt = r;
		
		
		int p = Integer.parseInt(o.substring(0, o.length()-4));
		System.out.print(p);
		int q = Integer.parseInt(d);
		System.out.print(q);
		int t = p + q;
		String s = String.valueOf(t);
		
		System.out.print(p);
		System.out.print(q);
		System.out.print(s);
		
		setBackground(new Color(224, 255, 255));
		setTitle("SKY Airline");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1282, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(712, 58, 486, 522);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 497, 61);
		panel.add(panel_1);

		JLabel lblNewLabel_10 = new JLabel("SKY AIRLINE ");
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(255, 140, 0));
		lblNewLabel_10.setFont(new Font("Segoe UI Black", Font.ITALIC, 30));

		JLabel Tong_tien = new JLabel("Tổng tiền: ");
		Tong_tien.setForeground(new Color(255, 0, 0));
		Tong_tien.setFont(new Font("Tahoma", Font.BOLD, 24));
		Tong_tien.setBounds(74, 449, 156, 29);
		panel.add(Tong_tien);
		
		JLabel Label_Gia_ve = new JLabel("");
		Label_Gia_ve.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Gia_ve.setForeground(Color.RED);
		Label_Gia_ve.setBackground(Color.WHITE);
		Label_Gia_ve.setBounds(238, 449, 212, 29);
		panel.add(Label_Gia_ve);
		Label_Gia_ve.setText(s + " VND");
		
		JLabel Label_Ngay_Gio_kh = new JLabel("New label");
		Label_Ngay_Gio_kh.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_kh.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Ngay_Gio_kh.setBounds(238, 238, 212, 29);
		panel.add(Label_Ngay_Gio_kh);
		Label_Ngay_Gio_kh.setText(a);
		
		JLabel Label_Ngay_Gio_hc = new JLabel("New label");
		Label_Ngay_Gio_hc.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_hc.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Ngay_Gio_hc.setBounds(238, 291, 224, 29);
		panel.add(Label_Ngay_Gio_hc);
		Label_Ngay_Gio_hc.setText(b);
		
		JLabel Label_Hang_ve = new JLabel("");
		Label_Hang_ve.setForeground(new Color(210, 105, 30));
		Label_Hang_ve.setFont(new Font("Tahoma", Font.BOLD, 18));
		Label_Hang_ve.setBounds(103, 330, 318, 37);
		panel.add(Label_Hang_ve);
		Label_Hang_ve.setText(c);
		
		JLabel lblNewLabel_11 = new JLabel("Ngày giờ khởi hành: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(47, 243, 169, 19);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ngày giờ hạ cánh:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(47, 296, 156, 19);
		panel.add(lblNewLabel_12);
		
		JLabel Label_noidi = new JLabel("");
		Label_noidi.setForeground(new Color(0, 0, 205));
		Label_noidi.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_noidi.setBounds(177, 138, 310, 19);
		panel.add(Label_noidi);
		Label_noidi.setText(e);
		
		JLabel Label_noiden = new JLabel("");
		Label_noiden.setForeground(new Color(0, 0, 205));
		Label_noiden.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_noiden.setBounds(187, 190, 310, 19);
		panel.add(Label_noiden);
		Label_noiden.setText(f);
		
		JLabel noidi = new JLabel("Điểm đi:");
		noidi.setFont(new Font("Tahoma", Font.BOLD, 16));
		noidi.setBounds(47, 138, 132, 24);
		panel.add(noidi);
		
		JLabel noiden = new JLabel("Điểm đến:");
		noiden.setFont(new Font("Tahoma", Font.BOLD, 16));
		noiden.setBounds(47, 191, 94, 18);
		panel.add(noiden);
		
		
		JLabel Label_DanhXung = new JLabel("");
		Label_DanhXung.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_DanhXung.setBounds(47, 90, 94, 30);
		panel.add(Label_DanhXung);
		Label_DanhXung.setText(l);
		
		
		JLabel lblNewLabel = new JLabel("Dịch vụ bổ trợ ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(47, 391, 144, 19);
		panel.add(lblNewLabel);
		
		JLabel Label_DichvuBotro = new JLabel("");
		Label_DichvuBotro.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_DichvuBotro.setBounds(187, 391, 106, 19);
		panel.add(Label_DichvuBotro);
		Label_DichvuBotro.setText(n);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(318, 391, 144, 19);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(o );
		
		JLabel Label_Hoten_hk = new JLabel("<dynamic>");
		Label_Hoten_hk.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Hoten_hk.setBounds(177, 90, 289, 31);
		panel.add(Label_Hoten_hk);
		Label_Hoten_hk.setText(m);
		Label_Hoten_hk.setText(m.toUpperCase());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(84, 88, 454, 492);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3_1_3_1 = new JLabel("Thông tin khuyến mãi ");
		lblNewLabel_3_1_3_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1_3_1.setBounds(26, 44, 249, 19);
		panel_2.add(lblNewLabel_3_1_3_1);
		
		final JLabel lblNewLabel_3_2 = new JLabel("Mã tài khoản  ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(26, 196, 111, 19);
		panel_2.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setVisible(false);
		
		final JTextField textField_makm = new JTextField();
		textField_makm.setColumns(10);
		textField_makm.setBounds(25, 135, 238, 19);
		panel_2.add(textField_makm);
		
		
		final JTextField textField_matk = new JTextField();
		textField_matk.setColumns(10);
		textField_matk.setBounds(25, 225, 238, 19);
		panel_2.add(textField_matk);
		textField_matk.setVisible(false);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Mã khuyến mãi   ");
		lblNewLabel_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2_1.setBounds(27, 106, 159, 19);
		panel_2.add(lblNewLabel_3_2_1);
		
		JCheckBox CheckBox = new JCheckBox(" Sử dụng điểm tích lũy để giảm giá ");
		CheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblNewLabel_3_2.setVisible(true);
				textField_matk.setVisible(true);
			}
		});
		CheckBox.setBackground(new Color(135, 206, 250));
		CheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckBox.setBounds(26, 291, 268, 19);
		panel_2.add(CheckBox);
		
		JLabel lblNewLabel_21 = new JLabel("SKY Airline ");
		lblNewLabel_21.setForeground(new Color(0, 0, 255));
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_21.setBackground(new Color(0, 191, 255));
		lblNewLabel_21.setBounds(39, 55, 97, 23);
		contentPane.add(lblNewLabel_21);
		
		JButton btnXcNhn = new JButton("Xác nhận");
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
					java.sql.Statement st = conn.createStatement();
					String sql = " SELECT NGAYBD, NGAYKT FROM BKHUYENMAI WHERE ID = '"+textField_makm.getText()+"'";
					System.out.println(sql);
					
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(a); 
					Date ngaybd = new Date();
					Date ngaykt = new Date();
					ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
					while(rs.next()) {
						ngaybd = rs.getDate(1);
						ngaykt = rs.getDate(2);
						System.out.println(ngaybd);
					}
					
					if (!textField_makm.getText().toString().equals("")&&(date1.before(ngaybd) || date1.after(ngaykt)) ) {
						JOptionPane.showMessageDialog(null, "Mã khuyến mãi không hợp lệ!");
						textField_makm.setText("");
						
					}
					else {
						String makm=null;// = new String();
						String matk=null;// = new String();
						String gioitinh = new String();
						
						if (l.toString() == "Ông")
						{
							gioitinh = "NAM";
						}
						else if(l.toString() == "Bà" || l.toString() == "Cô/Chị") {
							gioitinh = "NỮ";
						}
						System.out.print(gioitinh);
								
						
						if (!textField_makm.getText().toString().equals(""))
					    {
					    	 makm = textField_makm.getText().toString();
					    }
					    else if(textField_makm.getText().toString().equals(""))
					    {
					    	makm ="null";  
					    }
					    if (!textField_matk.getText().toString().equals(""))
					    {
					    	matk = textField_matk.getText().toString();
					    }
					    else if(textField_matk.getText().toString().equals("")) {
							matk ="null";
						}
					    
					    xacnhantt_mv1chieu obj = new xacnhantt_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk,  ngaysinh, sodt, email, quoctich, goihanhly, giatien, iddvbt, makm, matk, gioitinh);
						obj.setVisible(true);
						dispose();
					}
					
					
					}
					catch(Exception e1 )
					{
					
					}
					
				
			}
		
		});
		
		   if (iddvbt.equals("null")){
		    	Label_DichvuBotro.setVisible(false);
		    	lblNewLabel_1.setVisible(false);
		    	lblNewLabel.setVisible(false);
		    }
		   
		btnXcNhn.setBackground(new Color(124, 252, 0));
		btnXcNhn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXcNhn.setBounds(175, 418, 124, 21);
		panel_2.add(btnXcNhn);
		
		JTextArea txtrKhchHngTin = new JTextArea();
		txtrKhchHngTin.setForeground(Color.RED);
		txtrKhchHngTin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txtrKhchHngTin.setWrapStyleWord(true);
		txtrKhchHngTin.setLineWrap(true);
		txtrKhchHngTin.setText("Khách hàng tiến hành thanh toán tại quầy thu ngân");
		txtrKhchHngTin.setBounds(43, 355, 366, 29);
		panel_2.add(txtrKhchHngTin);
		
	}
}
