package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import java.awt.Component;

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
import java.util.Date;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class xacnhantt_mv1chieu extends JFrame {

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
	static String makm = new String();
	static String matk = new String();
	static String gioitinh = new String();
	static String iddvbt = new String();
	public static String makmm, matkk;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xacnhantt_mv1chieu frame = new xacnhantt_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk,  ngaysinh, sodt, email, quoctich, goihanhly, giatien, makm, matk, gioitinh, iddvbt);
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
	public xacnhantt_mv1chieu(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, String l, String m,  Date b2, String c2, String d2, String e2, String n, String o, String r, String a5, String a6, String a7) {
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
		makm = a5;
		matk = a6;
		gioitinh = a7;
		
		muave_motchieu mv=null;
		
		String idhve=mv.idhv;
		String id_cb=mv.idcb;
		System.out.println("\nid hạng vé: "+idhve);
		System.out.println("id chuyen bay: "+id_cb);
		
		System.out.println(m+"======================="+b2);
		System.out.println("id dvbt: "+iddvbt);
		
		
		setBackground(new Color(224, 255, 255));
		setTitle("SKY Airline");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0,0, 1230, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(650, 58, 486, 522);
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
		Tong_tien.setBounds(70, 465, 156, 29);
		panel.add(Tong_tien);
		
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
		lblNewLabel.setBounds(46, 391, 144, 19);
		panel.add(lblNewLabel);
		
		JLabel Label_DichvuBotro = new JLabel("");
		Label_DichvuBotro.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_DichvuBotro.setBounds(187, 391, 263, 19);
		panel.add(Label_DichvuBotro);
		Label_DichvuBotro.setText(n);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(187, 419, 144, 19);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(o  );
		//lblNewLabel_1.setVisible(false);
		
		JLabel Label_Hoten_hk = new JLabel("<dynamic>");
		Label_Hoten_hk.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Hoten_hk.setBounds(177, 90, 289, 31);
		panel.add(Label_Hoten_hk);
		Label_Hoten_hk.setText(m);
		Label_Hoten_hk.setText(m.toUpperCase());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(66, 58, 519, 522);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_1_3_1 = new JLabel("Thông tin khuyến mãi ");
		lblNewLabel_3_1_3_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1_3_1.setBounds(47, 53, 249, 19);
		panel_2.add(lblNewLabel_3_1_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Điểm của tài khoản  ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(47, 99, 155, 19);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Nội dung khuyến mãi   ");
		lblNewLabel_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2_1.setBounds(47, 197, 164, 19);
		panel_2.add(lblNewLabel_3_2_1);
		
		
		
		
		JLabel label_noidungkm = new JLabel("");
		label_noidungkm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_noidungkm.setBounds(235, 199, 238, 17);
		panel_2.add(label_noidungkm);
		
		JLabel label_diem = new JLabel("");
		label_diem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_diem.setBounds(235, 99, 93, 17);
		panel_2.add(label_diem);
		
		JLabel label_sotiengiamtk = new JLabel("Số tiền được giảm   ");
		label_sotiengiamtk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_sotiengiamtk.setBounds(47, 146, 135, 25);
		panel_2.add(label_sotiengiamtk);
		
		JLabel label_tiengiam_km = new JLabel(" ");
		label_tiengiam_km.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_tiengiam_km.setBounds(235, 248, 164, 19);
		panel_2.add(label_tiengiam_km);
		
		JLabel label_sotiengiamkm = new JLabel("Số tiền được giảm   ");
		label_sotiengiamkm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_sotiengiamkm.setBounds(47, 248, 135, 19);
		panel_2.add(label_sotiengiamkm);
		
		JLabel label_tiengiam_tk = new JLabel(" ");
		label_tiengiam_tk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_tiengiam_tk.setBounds(235, 149, 164, 19);
		panel_2.add(label_tiengiam_tk);
		
		
		JButton btnNewButton_1 = new JButton("Xuất vé");
		
		btnNewButton_1.setBackground(new Color(0, 250, 154));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(310, 343, 129, 25);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		  if (iddvbt.equals("null")){
		    	Label_DichvuBotro.setVisible(false);
		    	lblNewLabel_1.setVisible(false);
		    	lblNewLabel.setVisible(false);
		    }
		
		
		float p = Float.parseFloat(o.substring(0, o.length()-4));
		System.out.print(p);
		float q = Float.parseFloat(d);
		System.out.print(q);
		float t = (float)(p + q);
		
		String tiengiamkm = new String();
		tiengiamkm = "0 VND";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select ID, NOIDUNG, PHANTRAMKM from BKHUYENMAI where ID =  " + "'"+a5+"'";
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				 makmm=rs.getString(1);
				String noidung = rs.getString(2);
				String phantram = rs.getString(3);
				
				float x1 = Float.parseFloat(d);
				System.out.print(p);
				float x2 = Float.parseFloat(phantram);
				System.out.print(q);
				float x3 = (float)x1 * x2;
				tiengiamkm = String.valueOf(x3 + " VND");
				
					System.out.println(noidung);
					System.out.println(phantram);
					System.out.print(tiengiamkm);

					label_noidungkm.setText(noidung);
					label_tiengiam_km.setText(tiengiamkm );
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
			
			DangNhap dNhap=null;
			@SuppressWarnings("static-access")
			String tendn=dNhap.tendn;
			
			String sql = "select ID, DIEM from TAIKHOAN where TENDANGNHAP =  " + "'"+tendn+"'";
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				matkk = rs.getString(1);

				String diem = rs.getString(2);
				
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
				label_diem.setText(diem);
				label_tiengiam_tk.setText(tiengiamtk);
			}
			
			
			conn.close();
		}
		
		catch(Exception e1 )
		{
			System.out.println(e1);
		}
		
		JLabel lblNewLabel_2 = new JLabel("SKY Airline ");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBackground(new Color(0, 191, 255));
		lblNewLabel_2.setBounds(73, 35, 97, 23);
		contentPane.add(lblNewLabel_2);
		
		float t1 = Float.parseFloat(tiengiamkm.substring(0, tiengiamkm.length()-4).toString());
		System.out.println(t1);
		float t2 = Float.parseFloat(tiengiamtk.substring(0, tiengiamtk.length()-4).toString());
		System.out.println(t2);
		float t3 = (float)(t- t1 - t2);
		String s = String.valueOf(t3);
		System.out.print(s);
		
		
		JLabel Label_Gia_ve = new JLabel("");
		Label_Gia_ve.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Gia_ve.setForeground(Color.RED);
		Label_Gia_ve.setBackground(Color.WHITE);
		Label_Gia_ve.setBounds(238, 465, 212, 29);
		panel.add(Label_Gia_ve);
		Label_Gia_ve.setText(s + " VND");
		
		JButton btnNewButton = new JButton("Xác nhận thanh toán ");
		btnNewButton.setBackground(new Color(0, 250, 154));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(47, 343, 172, 25);
		panel_2.add(btnNewButton);
		
		JTextArea txtrKhchHngn = new JTextArea();
		txtrKhchHngn.setBackground(new Color(255, 255, 224));
		txtrKhchHngn.setForeground(new Color(255, 0, 0));
		txtrKhchHngn.setLineWrap(true);
		txtrKhchHngn.setWrapStyleWord(true);
		txtrKhchHngn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtrKhchHngn.setText("Khách hàng đến quầy thu ngân để thanh toán tiền vé\r\n");
		txtrKhchHngn.setBounds(85, 444, 354, 31);
		panel_2.add(txtrKhchHngn);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {																									
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement("delete from COPYVE");
					pst.executeUpdate();

		} catch (ClassNotFoundException e11) {
			e11.printStackTrace();
		} catch (SQLException e12) {
			e12.printStackTrace();
		}

	
				int confirm =JOptionPane.showConfirmDialog(null, "Khách hàng đã thanh toán thành công","Xác nhận",JOptionPane.YES_NO_OPTION);
				if(confirm==JOptionPane.YES_OPTION) {
					try {
						
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						//bắt đầu transaction 1
						
						Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  	
						//// lấy Max(ID) Đặt vé bay
						ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from DATVEBAY");  						
						rs.next();
						System.out.println(rs.getString("MAX(ID)"));
						int iddv=1000;
						if(rs.getString("MAX(ID)")==null) {
							iddv=1000;
						}
						else 
						{
							iddv = Integer.valueOf(rs.getString("MAX(ID)"));
							iddv++;
						}
						System.out.println("\nid đặt vé: "+iddv);
						rs.close(); // kết thúc transaction 1
						//tuy transaction 1 kết thúc nhưng biến "con" vẫn hoạt động vì mình chưa close nó 						
						//tiếp tục transaction 2
						ResultSet rs1=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from VEMAYBAY");  						
						//Lệnh executeQuery không làm kết thúc transaction 
						rs1.next();
						System.out.println(rs1.getString("MAX(ID)"));
						int idve=8000;
						if(rs1.getString("MAX(ID)")==null) {
							idve=8000;
						}
						else 
						{
							idve = Integer.valueOf(rs1.getString("MAX(ID)"));
							idve++;
						}
						////////max(id) hành khách
						
						ResultSet rs2=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from HANHKHACH");  						
						rs2.next();
						System.out.println(rs2.getString("MAX(ID)"));
						int idhk=3000;
						if(rs2.getString("MAX(ID)")==null) {
							idhk=3000;
						}
						else 
						{
							idhk = Integer.valueOf(rs2.getString("MAX(ID)"));
							idhk++;
						}
						


						 String insert_ve="insert into \"DB_AIRLINE\".\"VEMAYBAY\"  (\"ID\",  \"HANGVE_ID\",\"CHUYENBAY_ID\") values("+idve+","+idhve+","+id_cb+")";
						 PreparedStatement  pst2 = con.prepareStatement(insert_ve);
							pst2.execute();
							System.out.println("\ninsert ve thanh cong\n");

						
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						Date date=new Date();					
						String tgString=formatter.format(date);
						String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
						
						
						String insert_datve;
						PreparedStatement pst=null;
						
						
					    System.out.println(" MÃ TAI KHOAN: "+a6);

					    
					    if (iddvbt.equals("null")){
					    	Label_DichvuBotro.setVisible(false);
					    	lblNewLabel_1.setVisible(false);
					    	lblNewLabel.setVisible(false);
					    }
					    
						
						System.out.println("a5"+"---------------------"+a6);
						 if (iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Đã thanh toán',"+a6+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
							System.out.println("2");
						}
						else if (iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+s+",'Đã thanh toán',"+a6+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if(!iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
								insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Đã thanh toán',"+a6+")";

								 pst = con.prepareStatement(insert_datve);
								pst.execute();
							}
						else if(!iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+s+",'Đã thanh toán',"+a6+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if (iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
							
						insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+d+",'Đã thanh toán',"+null+")";
						 pst = con.prepareStatement(insert_datve);
						pst.execute();
					 	}
						else if (iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Đã thanh toán',"+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if(!iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+t+",'Đã thanh toán',"+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						
						else if(!iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Đã thanh toán',"+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						
						System.out.println(idhk+ " "+hoten_hk);
						System.out.println("\ninsert dat ve thanh cong\n");
						
						
						
												
						
						
						Statement st=con.createStatement(); 

						String search="SELECT TONGTIEN FROM DATVEBAY WHERE ID="+iddv+"";					
											
						ResultSet rs3= st.executeQuery(search);
						rs3.next();
							String ttdv_update =rs3.getString(1);
							float ttdv_daupdate=Float.parseFloat(ttdv_update);
							

							//bắt đầu transaction 1
							String search1="SELECT SOLUONGVECON,SOLUONGVEBAN FROM THONGKECHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
							
							ResultSet rs4= st.executeQuery(search1); 
							if(rs4.next()) {
								String slvc =rs4.getString(1);
								String slvb =rs4.getString(2);

								int slvecon=Integer.parseInt(slvc);
								int slveban=Integer.parseInt(slvb);
								
								int slvecon_update=slvecon-1;
								int slveban_update=slveban+1;
								//bắt đầu transaction 2
								String updatetk ="update THONGKECHUYENBAY set SOLUONGVECON="+slvecon_update+",SOLUONGVEBAN="+slveban_update+" where CHUYENBAY_ID="+id_cb+"";
								PreparedStatement pst4 = con.prepareStatement(updatetk);
								pst4= con.prepareStatement(updatetk);
								pst4.execute();  
								
								System.out.println("update thong ke thanh cong");

							}
							else {
								
								ResultSet rs5=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from THONGKECHUYENBAY");  						
								rs5.next();
								System.out.println(rs5.getString("MAX(ID)"));
								int idtk=6001;
								if(rs5.getString("MAX(ID)")==null) {
									idtk=6001;
								}
								else 
								{
									idtk = Integer.valueOf(rs5.getString("MAX(ID)"));
									idtk++;
								}
								
								String search2="SELECT TONGSOVE FROM CHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
								
								ResultSet rs6= st.executeQuery(search2);
								rs6.next();
									String tongsove =rs6.getString(1);
									int tongsv=Integer.parseInt(tongsove);
									int sovecon=tongsv-1;
									
								//thoigian lấy thông tin giờ hiện tại ở phía trên ngày đặt vé
									
								//con.setAutoCommit(false);   // tắt chế độ tự động commit
								PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"THONGKECHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"THOIGIAN\",\"SOLUONGVECON\",  \"SOLUONGVEBAN\",\"NGUOIQUANLY_ID\") values("+idtk+","+id_cb+","+ngaydatve+","+sovecon+","+1+","+0+")");		
								pst3.execute();
								// lúc này không được commit nên transaction 1 vẫn tiếp tục thực hiện
								System.out.println("\ninsert thong ke thanh cong");

							}		
						
							String search3="SELECT TONGTIENBANVE,TONGDOANHTHU FROM DOANHTHUCHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
							
							ResultSet rs7= st.executeQuery(search3);
							if(rs7.next()) {
								String tongtienbanve =rs7.getString(1);
								String tongdoanhthu =rs7.getString(2);
								
								float ttbv=Float.parseFloat(tongtienbanve);
								float tongtienbanve_update=ttbv+ttdv_daupdate;
								
								float tdt=Float.parseFloat(tongdoanhthu);
								float tongdt_ud=tdt+ttdv_daupdate;
								
								String updatedt ="update DOANHTHUCHUYENBAY set TONGTIENBANVE="+tongtienbanve_update+", TONGDOANHTHU="+tongdt_ud+" where CHUYENBAY_ID="+id_cb+"";
								PreparedStatement pst4 = con.prepareStatement(updatedt);
								pst4= con.prepareStatement(updatedt);
								pst4.execute();
								System.out.println("update doanh thu thanh cong");
							}
							else {
								ResultSet rs5=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from DOANHTHUCHUYENBAY");  						
								rs5.next();
								System.out.println(rs5.getString("MAX(ID)"));
								int iddt=5001;
								if(rs5.getString("MAX(ID)")==null) {
									iddt=5001;
								}
								else 
								{
									iddt = Integer.valueOf(rs5.getString("MAX(ID)"));
									iddt++;
								}
								
								PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"DOANHTHUCHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"NGAYTINH\",\"TONGTIENBANVE\",  \"TONGPHIHOANVE\",\"TONGDOANHTHU\",\"NGUOIQUANLY_ID\") values("+iddt+","+id_cb+","+ngaydatve+","+ttdv_daupdate+","+0+","+ttdv_daupdate+","+0+")");		
								pst3.execute();
								System.out.println("insert doanh thu thanh cong");

								
							}
							
							DangNhap dn=null;
							String tendangnhap=dn.tendn;
							String mkhau=dn.mk;
						
							PreparedStatement pst1=null;
							String insert_hanhkhach;
							if(tendangnhap!=null) {
	
									String searchtkh="select TONGTIENMUAVE, ID from TAIKHOAN where TENDANGNHAP='"+tendangnhap+"' and MATKHAU='"+mkhau+"'";					
									ResultSet rs6= st.executeQuery(searchtkh);
									rs6.next();
										String tongtientk =rs6.getString(1);	
										String idtk =rs6.getString(2);	

										
										int tttk=Integer.parseInt(tongtientk);
										int tongtienupdate=(int) (tttk+ttdv_daupdate);
										
										int diem= (tongtienupdate/500000);
										String hang = null;
										if(diem>=30 &&diem<40) {
											hang="Hạng bạc";
										}
										else if (diem>=40&&diem<50) {
											hang="Hạng vàng";
											
										}
										else if (diem>=50) {
											hang="Hạng kim cương";
										}
										else if (diem<30) {
											hang="Hạng thường";
										}
										
										System.out.println("hạng: "+" "+"Diem: "+diem);
										PreparedStatement pst4=con.prepareStatement("update TAIKHOAN set TONGTIENMUAVE="+tongtienupdate+", DIEM="+diem+",HANG='"+hang+"' where TENDANGNHAP= '"+tendangnhap+"' AND MATKHAU='"+mkhau+"'");		
										pst4.execute();

										System.out.println("update tai khoan thanh cong");
										
										SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
										String tgString1=formatter1.format(ngaysinh);
										 String ngsinh = "TO_DATE('"+tgString1+"','yyyy-mm-dd HH24:MI:SS')";


										
											
										 insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+idtk+")";
										  pst1 = con.prepareStatement(insert_hanhkhach);
											pst1.execute();
											System.out.println("insert hanh khach  co tai khoan thanh cong");

								}
							else {
								
									SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
									String tgString1=formatter1.format(ngaysinh);
									 String ngsinh = "TO_DATE('"+tgString1+"','yyyy-mm-dd HH24:MI:SS')";

									 insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+null+")";
									  pst1 = con.prepareStatement(insert_hanhkhach);
										pst1.execute();
										System.out.println("insert hanh khach khong co tai khoan thanh cong");
								
							}
							
							
							 String thoigiankh = "TO_DATE('"+gio_kh_di+"','yyyy-mm-dd HH24:MI:SS')";
							 String thogianhc = "TO_DATE('"+gio_hc_di+"','yyyy-mm-dd HH24:MI:SS')";

							
						PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"COPYVE\" (\"HOTEN\",\"ID\", \"CHUYENBAY_ID\", \"SANBAYDI\", \"SANBAYDEN\", \"NGAY_GIO_KH\", \"NGAY_GIO_HC\", \"NOIDUNG_DVBT\", \"HANGVE\", \"TONGTIEN\") values('"+hoten_hk+"', "+iddv+", "+id_cb+", '"+noi_di+"', '"+noi_den+"', "+thoigiankh+","+thogianhc+",'"+goihanhly+"','"+h_ve_di+"',"+ttdv_daupdate+")");		
						pst3.execute();	
						
							
							
					
						//rs8.close();
						rs4.close();
						rs3.close();
						rs2.close();
						rs1.close();
						rs.close();
						//pst1.close();
						pst2.close();
						pst.close();
						JOptionPane.showMessageDialog(null, "Mua vé thành công");
						
						btnNewButton_1.setVisible(true);
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {
									
									Class.forName("oracle.jdbc.OracleDriver");
									Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
									
															
									FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\XUAT_VE.jrxml"));
									JasperDesign jd=JRXmlLoader.load(in);
									
									
								
									String sqlString="SELECT DISTINCT *FROM COPYVE";				
									JRDesignQuery newQuery=new JRDesignQuery();
									newQuery.setText(sqlString);
									jd.setQuery(newQuery);
									JasperReport jr=JasperCompileManager.compileReport(jd);
									@SuppressWarnings("rawtypes")
									HashMap para=new HashMap();
									final JasperPrint j=JasperFillManager.fillReport(jr, para,con);
									JasperViewer.viewReport(j,false);
									java.io.OutputStream os=new FileOutputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\Report1"));
									JasperExportManager.exportReportToPdfStream(j, os);
								
							
							} catch (Exception e2) {
								//e2.printStackTrace();
							}}
						});
						con.close();


					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						Component a=null;
						e1.printStackTrace();

		
					}
				}
				else if(confirm==JOptionPane.NO_OPTION)
				{
					dispose();
				}
			}
		});
	
}	
}
