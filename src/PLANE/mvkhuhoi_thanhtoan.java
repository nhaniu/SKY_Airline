package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

public class mvkhuhoi_thanhtoan extends JFrame {

	private JPanel contentPane;

	private JTextField textField_makm;

	private JTextField textField_matk;

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

	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mvkhuhoi_thanhtoan frame = new mvkhuhoi_thanhtoan(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien,iddvbt);
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
	@SuppressWarnings("unchecked")
	public mvkhuhoi_thanhtoan(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, final String l, String m,  Date b2, String c2, String d2, String e2, String n, String o,String r) {
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
		
		setBackground(new Color(224, 255, 255));
		setTitle("SKY Airline ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1265, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(592, 32, 553, 567);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 553, 57);
		panel.add(panel_1);

		JLabel lblNewLabel_10 = new JLabel("SKY AIRLINE ");
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(255, 140, 0));
		lblNewLabel_10.setFont(new Font("Segoe UI Black", Font.ITALIC, 30));

		
		JLabel Label_Gia_ve_di = new JLabel("");
		Label_Gia_ve_di.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Gia_ve_di.setForeground(new Color(255, 0, 0));
		Label_Gia_ve_di.setBackground(Color.WHITE);
		Label_Gia_ve_di.setBounds(217, 243, 212, 29);
		panel.add(Label_Gia_ve_di);
		Label_Gia_ve_di.setText(d + " VND"); 
		
		JLabel Label_Ngay_Gio_kh = new JLabel("New label");
		Label_Ngay_Gio_kh.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_kh.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Ngay_Gio_kh.setBounds(14, 158, 212, 29);
		panel.add(Label_Ngay_Gio_kh);
		Label_Ngay_Gio_kh.setText(a);
		
		JLabel Label_Ngay_Gio_hc = new JLabel("New label");
		Label_Ngay_Gio_hc.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_hc.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Ngay_Gio_hc.setBounds(302, 158, 229, 29);
		panel.add(Label_Ngay_Gio_hc);
		Label_Ngay_Gio_hc.setText(b);
		
		JLabel Label_Hang_ve_di = new JLabel("New label");
		Label_Hang_ve_di.setForeground(new Color(210, 105, 30));
		Label_Hang_ve_di.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Hang_ve_di.setBounds(108, 197, 310, 29);
		panel.add(Label_Hang_ve_di);
		Label_Hang_ve_di.setText(c);
		
		JLabel Label_giave_di = new JLabel("Giá vé:");
		Label_giave_di.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_giave_di.setBounds(108, 248, 102, 19);
		panel.add(Label_giave_di);
		
		
		JLabel Label_noidi = new JLabel("New label");
		Label_noidi.setForeground(new Color(0, 0, 205));
		Label_noidi.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_noidi.setBounds(14, 118, 241, 19);
		panel.add(Label_noidi);
		Label_noidi.setText(e);
		
		JLabel Label_noiden = new JLabel("New label");
		Label_noiden.setForeground(new Color(0, 0, 205));
		Label_noiden.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_noiden.setBounds(302, 118, 241, 19);
		panel.add(Label_noiden);
		Label_noiden.setText(f);
		
		JLabel noiden = new JLabel("=>");
		noiden.setForeground(new Color(255, 140, 0));
		noiden.setFont(new Font("Tahoma", Font.BOLD, 15));
		noiden.setBounds(256, 118, 36, 18);
		panel.add(noiden);
		
		JLabel Label_noidi_1 = new JLabel("<dynamic>");
		Label_noidi_1.setForeground(new Color(0, 0, 205));
		Label_noidi_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_noidi_1.setBounds(312, 327, 241, 19);
		panel.add(Label_noidi_1);
		Label_noidi_1.setText(e);
		
		JLabel Label_noiden_1 = new JLabel("<dynamic>");
		Label_noiden_1.setForeground(new Color(0, 0, 205));
		Label_noiden_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_noiden_1.setBounds(14, 327, 241, 19);
		panel.add(Label_noiden_1);
		Label_noiden_1.setText(f);
		
		JLabel noiden_1 = new JLabel("=>");
		noiden_1.setForeground(new Color(255, 140, 0));
		noiden_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		noiden_1.setBounds(256, 327, 36, 18);
		panel.add(noiden_1);
		
		JLabel Label_Ngay_Gio_kh_1 = new JLabel("<dynamic>");
		Label_Ngay_Gio_kh_1.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_kh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Ngay_Gio_kh_1.setBounds(14, 368, 212, 29);
		panel.add(Label_Ngay_Gio_kh_1);
		Label_Ngay_Gio_kh_1.setText(g);
		
		JLabel Label_Ngay_Gio_hc_1 = new JLabel("<dynamic>");
		Label_Ngay_Gio_hc_1.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_hc_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Ngay_Gio_hc_1.setBounds(312, 368, 199, 29);
		panel.add(Label_Ngay_Gio_hc_1);
		Label_Ngay_Gio_hc_1.setText(h);
		
		JLabel Label_Hang_ve_ve = new JLabel("<dynamic>");
		Label_Hang_ve_ve.setForeground(new Color(210, 105, 30));
		Label_Hang_ve_ve.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Hang_ve_ve.setBounds(108, 407, 310, 29);
		panel.add(Label_Hang_ve_ve);
		Label_Hang_ve_ve.setText(i);
		
		
		JLabel Label_Gia_ve_ve = new JLabel("<dynamic> VND");
		Label_Gia_ve_ve.setForeground(Color.RED);
		Label_Gia_ve_ve.setFont(new Font("Tahoma", Font.BOLD, 14));
		Label_Gia_ve_ve.setBackground(Color.WHITE);
		Label_Gia_ve_ve.setBounds(217, 452, 212, 29);
		panel.add(Label_Gia_ve_ve);
		Label_Gia_ve_ve.setText(k + " VND");
		
		JLabel lblGiV = new JLabel("Giá vé:");
		lblGiV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiV.setBounds(108, 457, 102, 19);
		panel.add(lblGiV);
		lblGiV.setText("Giá vé");
		
		JLabel Tong_tien = new JLabel("Tổng tiền: ");
		Tong_tien.setForeground(new Color(255, 0, 0));
		Tong_tien.setFont(new Font("Tahoma", Font.BOLD, 24));
		Tong_tien.setBounds(70, 498, 156, 29);
		panel.add(Tong_tien);
		
		JLabel lblNewLabel_2 = new JLabel("~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 288, 523, 13);
		panel.add(lblNewLabel_2);
		
		float p1=Float.parseFloat(o.substring(0,o.length()-4));
		float p = Float.parseFloat(d);
		System.out.print(p);
		float q = Float.parseFloat(k);
		System.out.print(q);
		float t = p + q +p1;
		String s = String.valueOf(t);
		
		JLabel Label_Tongtien = new JLabel("<dynamic> VND");
		Label_Tongtien.setForeground(Color.RED);
		Label_Tongtien.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Tongtien.setBackground(Color.WHITE);
		Label_Tongtien.setBounds(243, 498, 212, 29);
		panel.add(Label_Tongtien);
		Label_Tongtien.setText(s + " VND");
		
		JLabel label_danhxung = new JLabel("");
		label_danhxung.setForeground(new Color(0, 0, 205));
		label_danhxung.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_danhxung.setBounds(14, 67, 94, 26);
		panel.add(label_danhxung);
		label_danhxung.setText(l);
		
		JLabel label_hoten = new JLabel("");
		label_hoten.setForeground(new Color(0, 0, 205));
		label_hoten.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_hoten.setBounds(147, 67, 297, 26);
		panel.add(label_hoten);
		label_hoten.setText(m);
		label_hoten.setText(m.toUpperCase());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(39, 77, 475, 522);
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
		
		textField_makm = new JTextField();
		textField_makm.setColumns(10);
		textField_makm.setBounds(25, 135, 238, 19);
		panel_2.add(textField_makm);
		
		textField_matk = new JTextField();
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
		
		JButton button_tttt = new JButton("Tiếp tục thanh toán ");
		button_tttt.addActionListener(new ActionListener() {
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
					
					if (date1.before(ngaybd) || date1.after(ngaykt) ) {
						JOptionPane.showMessageDialog(null, "Mã khuyến mãi không hợp lệ!");
						textField_makm.setText("");
						
					}
					else {
				
					String makm = null;
					String matk = null;
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
				    
				    mvkhuhoi_xacnhantt obj = new mvkhuhoi_xacnhantt(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien, makm, matk, gioitinh,iddvbt);
					obj.setVisible(true);
					dispose();
					}

				}
				catch(Exception e1 )
				{
				
				}
				
			}
		});
		button_tttt.setBackground(new Color(124, 252, 0));
		button_tttt.setFont(new Font("Times New Roman", Font.BOLD, 13));
		button_tttt.setBounds(175, 418, 146, 21);
		panel_2.add(button_tttt);
		

	}
}
