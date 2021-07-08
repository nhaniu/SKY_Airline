package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import org.apache.commons.lang.math.FloatRange;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashMap;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class mvkhuhoi_xacnhantt extends JFrame {

	private JPanel contentPane;

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
	static String makm = new String();
	static String matk = new String();
	static String gioitinh = new String();
	static String iddvbt = new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mvkhuhoi_xacnhantt frame = new mvkhuhoi_xacnhantt(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien, makm, matk, gioitinh,iddvbt);
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
	public mvkhuhoi_xacnhantt(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, String l, String m, Date b2, String c2, String d2, String e2, String n, String o, String a5, String a6, String a7,String r) {
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
		makm = a5;
		matk = a6;
		gioitinh = a7;
		iddvbt=r;
		
		

		float p = Float.parseFloat(o.substring(0, o.length()-4));
		System.out.print(p);
		float q = Float.parseFloat(d);
		System.out.print(q);
		float x = Float.parseFloat(k);
		System.out.print(r);
		float t = (float)(p + q + x);

		
		
		
		setBackground(new Color(224, 255, 255));
		setTitle("SKY Airline ");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1243, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(607, 32, 553, 567);
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
		
		JLabel label_danhxung = new JLabel("");
		label_danhxung.setForeground(Color.BLACK);
		label_danhxung.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_danhxung.setBounds(14, 67, 94, 26);
		panel.add(label_danhxung);
		label_danhxung.setText(l);
		
		JLabel label_hoten = new JLabel("");
		label_hoten.setForeground(Color.BLACK);
		label_hoten.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_hoten.setBounds(147, 67, 297, 26);
		panel.add(label_hoten);
		label_hoten.setText(m);
		label_hoten.setText(m.toUpperCase());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(49, 61, 455, 538);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_1_3_1 = new JLabel("Thông tin khuyến mãi ");
		lblNewLabel_3_1_3_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1_3_1.setBounds(36, 42, 239, 19);
		panel_2.add(lblNewLabel_3_1_3_1);
		
		final JLabel lblNewLabel_3_2 = new JLabel("Nội dung khuyến mãi ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(36, 193, 169, 19);
		panel_2.add(lblNewLabel_3_2);
		
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Số tiền được giảm ");
		lblNewLabel_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2_1.setBounds(36, 147, 169, 19);
		panel_2.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_21 = new JLabel("SKY Airline ");
		lblNewLabel_21.setForeground(new Color(0, 0, 255));
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_21.setBackground(new Color(0, 191, 255));
		lblNewLabel_21.setBounds(49, 38, 118, 23);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Số tiền được giảm ");
		lblNewLabel_3_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2_1_1.setBounds(37, 242, 168, 19);
		panel_2.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Điểm của tài khoản ");
		lblNewLabel_3_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2_1_2.setBounds(36, 98, 169, 19);
		panel_2.add(lblNewLabel_3_2_1_2);
		
		JLabel Label_diemtk = new JLabel("");
		Label_diemtk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Label_diemtk.setBounds(215, 98, 210, 19);
		panel_2.add(Label_diemtk);
		
		JLabel Label_tiengiamtk = new JLabel("");
		Label_tiengiamtk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Label_tiengiamtk.setBounds(215, 147, 210, 19);
		panel_2.add(Label_tiengiamtk);
		
		JLabel Label_noidungkm = new JLabel("");
		Label_noidungkm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Label_noidungkm.setBounds(215, 193, 210, 19);
		panel_2.add(Label_noidungkm);
		
		JLabel Label_tiengiamkm = new JLabel("");
		Label_tiengiamkm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Label_tiengiamkm.setBounds(215, 242, 210, 19);
		panel_2.add(Label_tiengiamkm);
		
	
		
		
		
		String tiengiamkm = new String();
		tiengiamkm = "0 VND";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select NOIDUNG, PHANTRAMKM from BKHUYENMAI where ID =  " + "'"+ a5 +"'";
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				String noidung = rs.getString(1);
				String phantram = rs.getString(2);
				
				float xx = Float.parseFloat(d);
				System.out.print(p);
				float x1 = Float.parseFloat(k);
				System.out.print(r);
				float x2 = Float.parseFloat(phantram);
				System.out.print(q);
				float x3 = (float)(xx + x1) * x2;
				tiengiamkm = String.valueOf(x3 + " VND");
				
					System.out.println(noidung);
					System.out.println(phantram);
					System.out.print(tiengiamkm);

					Label_noidungkm.setText(noidung);
					Label_tiengiamkm.setText(tiengiamkm);
			}
			
			
			conn.close();
		}
		
		catch(Exception e1 )
		{
			System.out.println(e1);
		}
		
		String tiengiamtk = new String();
		tiengiamtk = "0 VND";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select DIEM from TAIKHOAN where ID =  " + "'"+ a6+"'";
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				String diem = rs.getString(1);
				
				int x1 = Integer.parseInt(diem);
				System.out.print(x1);
				if (x1 >= 20 && x1 <= 30)
				{
					tiengiamtk = "50000 VND";
				}
				else if (x1 >= 31 && x1 <= 50)
				{
					tiengiamtk = "100000 VND";
				}
				else if (x1 > 50)
				{
					tiengiamtk = "150000 VND";
				}
				else if (x1 < 20)
				{
					tiengiamtk = "0 VND";
				}
				
				System.out.print(diem);
				System.out.print(tiengiamtk);
				Label_diemtk.setText(diem);
				Label_tiengiamtk.setText(tiengiamtk);
			}
			
			
			conn.close();
		}
		
		catch(Exception e1 )
		{
			System.out.println(e1);
		}
		
		float t1 = Float.parseFloat(tiengiamkm.substring(0, tiengiamkm.length()-4).toString());
		System.out.println(t1);
		float t2 = Float.parseFloat(tiengiamtk.substring(0, tiengiamtk.length()-4).toString());
		System.out.println(t2);
		float t3 = (float)(t - t1 - t2);
		String s = String.valueOf(t3);
		System.out.print(s);
		
		JLabel Label_Tongtien = new JLabel("<dynamic> VND");
		Label_Tongtien.setForeground(Color.RED);
		Label_Tongtien.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Tongtien.setBackground(Color.WHITE);
		Label_Tongtien.setBounds(243, 498, 212, 29);
		panel.add(Label_Tongtien);
		Label_Tongtien.setText(s + " VND");
		
		JButton btnNewButton = new JButton("Xuất vé");
		btnNewButton.setBackground(new Color(0, 250, 154));
		btnNewButton.setVisible(false);
		
		JButton btnXcNhnThanh = new JButton("Xác nhận thanh toán ");
		btnXcNhnThanh.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent arg0) {
				
//				try {																									
//					Class.forName("oracle.jdbc.OracleDriver");
//					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
//					PreparedStatement pst = DB_AIRLINE.prepareStatement("delete from COPYVE");
//					pst.executeUpdate();
//
//		} catch (ClassNotFoundException e11) {
//			e11.printStackTrace();
//		} catch (SQLException e12) {
//			e12.printStackTrace();
//		}

	
//				int confirm =JOptionPane.showConfirmDialog(null, "Khách hàng đã thanh toán thành công","Xác nhận",JOptionPane.YES_NO_OPTION);
//				if(confirm==JOptionPane.YES_OPTION) {
					try {
						
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			
						
						Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  	

						////Max(ID) Đặt vé bay
						ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from DATVEBAY");  						
						rs.next();
						System.out.println(rs.getString("MAX(ID)"));
						int iddv=1000;
						int iddvkh=1000;
						if(rs.getString("MAX(ID)")==null) {
							iddv=1000;
							iddvkh=1000;
						}
						else 
						{
							iddv = Integer.valueOf(rs.getString("MAX(ID)"));
							iddvkh = Integer.valueOf(rs.getString("MAX(ID)"));

							iddv++;
							iddvkh=iddvkh+2;
						}
						System.out.println("\nid đặt vé: "+iddv);
						
						//////////// Max(id) vé máy bay
						
						ResultSet rs1=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from VEMAYBAY");  						
						rs1.next();
						System.out.println(rs1.getString("MAX(ID)"));
						int idve=8000;
						int idvekh=8000;
						if(rs1.getString("MAX(ID)")==null) {
							idve=8000;
							idvekh=8000;
						}
						else 
						{
							idve = Integer.valueOf(rs1.getString("MAX(ID)"));
							idvekh = Integer.valueOf(rs1.getString("MAX(ID)"));

							idve++;
							idvekh=idvekh+2;
						}
						////////max(id) hành khách
						
						ResultSet rs2=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from HANHKHACH");  						
						rs2.next();
						System.out.println(rs2.getString("MAX(ID)"));
						int idhk=3000;
						int idhkkh=3000;

						if(rs2.getString("MAX(ID)")==null) {
							  idhk=3000;
							idhkkh=3000;
						}
						else 
						{
							idhk = Integer.valueOf(rs2.getString("MAX(ID)"));
							idhkkh = Integer.valueOf(rs2.getString("MAX(ID)"));

							idhk++;
							idhkkh=idhkkh+2;
						}
						

						muave_khuhoi khuhoi=null;
						String idcb_di=khuhoi.idcbdi;
						String idcb_ve=khuhoi.idcbve;
						String idhve_di=khuhoi.idhvdi;
						String idhve_ve=khuhoi.idhvve;
						System.out.println("\nid chuyen bay di: "+idcb_di);
						
						System.out.println("id ve di: "+idve);
						System.out.println("id ve ve: "+idvekh);
						System.out.println("id hang ve di: "+khuhoi.idhvdi);
						System.out.println("id hang ve veef: "+khuhoi.idhvve);



						 String insert_vedi="insert into \"DB_AIRLINE\".\"VEMAYBAY\"  (\"ID\",  \"HANGVE_ID\",\"CHUYENBAY_ID\") values("+idve+","+idhve_di+","+idcb_di+")";
						 PreparedStatement  pst2 = con.prepareStatement(insert_vedi);
							pst2.execute();
						String insert_veve="insert into \"DB_AIRLINE\".\"VEMAYBAY\"  (\"ID\",  \"HANGVE_ID\",\"CHUYENBAY_ID\") values("+idvekh+","+idhve_ve+","+idcb_ve+")";
						 PreparedStatement  pst3 = con.prepareStatement(insert_veve);
							pst3.execute();
							
							System.out.println("\ninsert ve thanh cong\n");
							
							Statement st=con.createStatement(); 


							DangNhap dn=null;
							String tendangnhap=dn.tendn;
							String mkhau=dn.mk;
							

							PreparedStatement pst1=null;
							String insert_hanhkhach;
						
							
							PreparedStatement pstkh=null;
							String insert_hanhkhachkh;
							

										if(tendangnhap!=null) {
											
											String searchtkh="select ID from TAIKHOAN where TENDANGNHAP='"+tendangnhap+"' and MATKHAU='"+mkhau+"'";					
											ResultSet rs9= st.executeQuery(searchtkh);
											rs9.next();
												//String tongtientk =rs9.getString(1);	
												String idtk =rs9.getString(1);	

										// hanh khách chuyen bay 1

										SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
										String tgString1=formatter1.format(ngaysinh);
										 String ngsinh = "TO_DATE('"+tgString1+"','yyyy-mm-dd HH24:MI:SS')";



										 insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+idtk+")";
										  pst1 = con.prepareStatement(insert_hanhkhach);
											pst1.execute();
											pst1.close();
											// hanh khách chuyen bay 2

										

											 insert_hanhkhachkh="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhkkh+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+idtk+")";
											  pstkh= con.prepareStatement(insert_hanhkhachkh);
												pstkh.execute();
												
											System.out.println("insert hanh khach  co tai khoan thanh cong");

								}
							else {
								// hành khách chuyến bay 1

								SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
								String tgString1=formatter1.format(ngaysinh);
								 String ngsinh = "TO_DATE('"+tgString1+"','yyyy-mm-dd HH24:MI:SS')";

								 insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+null+")";
								  pst1 = con.prepareStatement(insert_hanhkhach);
									pst1.execute();
									pst1.close();
									
									// hành khách chuyến bay 2

									

									
									 insert_hanhkhachkh="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhkkh+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+null+")";
									 pstkh = con.prepareStatement(insert_hanhkhachkh);
									 pstkh.execute();
										System.out.println("insert hanh khach khong co tai khoan thanh cong");

							}
							
							
							

							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
							Date date=new Date();					
							String tgString=formatter.format(date);
							String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
							
							
							String insert_datve;
							PreparedStatement pst=null;
							
//							mvkhuhoi_dvbotro dvbtkh=null;
//							String dvbt=dvbtkh.iddvbt;
//							
							int dd=Integer.parseInt(d);
							int kk=Integer.parseInt(k);
							int tien=dd+kk;
							////Chuyến đi
							 if (iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
									System.out.println("2");
								}
								else if (iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if(!iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
										insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";

										 pst = con.prepareStatement(insert_datve);
										pst.execute();
									}
								else if(!iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if (iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
									
								insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+tien+",'Chưa thanh toán',"+null+","+null+")";
								 pst = con.prepareStatement(insert_datve);
								pst.execute();
							 	}
								else if (iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if(!iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+t+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								
								else if(!iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								
							
							
						
							
							////Chuyến khứ hồi
							
							 if (iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+a5+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
									System.out.println("2");
								}
								else if (iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+null+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if(!iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
										insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";

										 pst = con.prepareStatement(insert_datve);
										pst.execute();
									}
								else if(!iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+null+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+a6+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if (iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
									
								insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+null+","+null+","+ngaydatve+","+tien+",'Chưa thanh toán',"+null+","+null+")";
								 pst = con.prepareStatement(insert_datve);
								pst.execute();
							 	}
								else if (iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+a5+","+null+","+ngaydatve+","+s+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								else if(!iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+null+","+iddvbt+","+ngaydatve+","+t+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								
								else if(!iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
									insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddvkh+","+idvekh+","+idhkkh+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Chưa thanh toán',"+null+","+null+")";
									 pst = con.prepareStatement(insert_datve);
									pst.execute();
								}
								
							
							
							
							System.out.println(idhk+ " "+hoten_hk);
							System.out.println("\ninsert dat ve thanh cong\n");
							
							
						
									
									
									 String thoigiankh = "TO_DATE('"+gio_kh_di+"','yyyy-mm-dd HH24:MI:SS')";
									 String thogianhc = "TO_DATE('"+gio_hc_di+"','yyyy-mm-dd HH24:MI:SS')";

								


									 System.out.println("---iddv--"+iddv+"-"+iddvkh+"---idhk --"+idhk+"-"+idhkkh+"--idve--"+idve+"-"+idvekh);
										JOptionPane.showMessageDialog(null, "Mã đặt vé chuyến bay đi của bạn là: "+iddv+" và chuyến bay về là: "+iddvkh+"\nBạn vui lòng đến quầy nhân viên để thanh toán và tiến hành in vé");
							
					}

				 catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
	
				}
			}
			//}
			
		});
		btnXcNhnThanh.setBackground(new Color(0, 250, 154));
		btnXcNhnThanh.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXcNhnThanh.setBounds(10, 378, 176, 25);
		panel_2.add(btnXcNhnThanh);
		
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(249, 380, 125, 23);
		panel_2.add(btnNewButton);
		

		


	}
}
