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
import java.text.DateFormat;
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
	//public static int idve,iddv,idhk;
	
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
		System.out.println("\nid h???ng v??: "+idhve);
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

		JLabel Tong_tien = new JLabel("T???ng ti???n: ");
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
		
		JLabel lblNewLabel_11 = new JLabel("Ng??y gi??? kh???i h??nh: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(47, 243, 169, 19);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ng??y gi??? h??? c??nh:");
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
		
		JLabel noidi = new JLabel("??i???m ??i:");
		noidi.setFont(new Font("Tahoma", Font.BOLD, 16));
		noidi.setBounds(47, 138, 132, 24);
		panel.add(noidi);
		
		JLabel noiden = new JLabel("??i???m ?????n:");
		noiden.setFont(new Font("Tahoma", Font.BOLD, 16));
		noiden.setBounds(47, 191, 94, 18);
		panel.add(noiden);
		
		
		JLabel Label_DanhXung = new JLabel("");
		Label_DanhXung.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_DanhXung.setBounds(47, 90, 94, 30);
		panel.add(Label_DanhXung);
		Label_DanhXung.setText(l);
		
		
		JLabel lblNewLabel = new JLabel("D???ch v??? b??? tr??? ");
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
		
		JLabel lblNewLabel_3_1_3_1 = new JLabel("Th??ng tin khuy???n m??i ");
		lblNewLabel_3_1_3_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1_3_1.setBounds(47, 53, 249, 19);
		panel_2.add(lblNewLabel_3_1_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("??i???m c???a t??i kho???n  ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(47, 99, 155, 19);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("N???i dung khuy???n m??i   ");
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
		
		JLabel label_sotiengiamtk = new JLabel("S??? ti???n ???????c gi???m   ");
		label_sotiengiamtk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_sotiengiamtk.setBounds(47, 146, 135, 25);
		panel_2.add(label_sotiengiamtk);
		
		JLabel label_tiengiam_km = new JLabel(" ");
		label_tiengiam_km.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_tiengiam_km.setBounds(235, 248, 164, 19);
		panel_2.add(label_tiengiam_km);
		
		JLabel label_sotiengiamkm = new JLabel("S??? ti???n ???????c gi???m   ");
		label_sotiengiamkm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_sotiengiamkm.setBounds(47, 248, 135, 19);
		panel_2.add(label_sotiengiamkm);
		
		JLabel label_tiengiam_tk = new JLabel(" ");
		label_tiengiam_tk.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_tiengiam_tk.setBounds(235, 149, 164, 19);
		panel_2.add(label_tiengiam_tk);
		
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
			
			String sql = "select ID, DIEM from TAIKHOAN where ID =  " + "'"+a6+"'";
			
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
		
		JButton btnNewButton = new JButton("Xu???t m?? ?????t v??");
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
		txtrKhchHngn.setText("Kh??ch h??ng ?????n qu???y thu ng??n ????? thanh to??n ti???n v??\r\n");
		txtrKhchHngn.setBounds(85, 444, 354, 31);
		panel_2.add(txtrKhchHngn);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				int confirm =JOptionPane.showConfirmDialog(null, "Kh??ch h??ng ???? thanh to??n th??nh c??ng","X??c nh???n",JOptionPane.YES_NO_OPTION);
//				if(confirm==JOptionPane.YES_OPTION) {
					try {
						
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						
						Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  	
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
						System.out.println("\nid ?????t v??: "+iddv);
						rs.close(); // k???t th??c transaction 1
						//tuy transaction 1 k???t th??c nh??ng bi???n "con" v???n ho???t ?????ng v?? m??nh ch??a close n?? 						
						//ti???p t???c transaction 2
						ResultSet rs1=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from VEMAYBAY");  						
						//L???nh executeQuery kh??ng l??m k???t th??c transaction 
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
						////////max(id) h??nh kh??ch
						
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
						
						System.out.println("\nID H??NH KH??CH "+idhk);

						 String insert_ve="insert into \"DB_AIRLINE\".\"VEMAYBAY\"  (\"ID\",  \"HANGVE_ID\",\"CHUYENBAY_ID\") values("+idve+","+idhve+","+id_cb+")";
						 PreparedStatement  pst2 = con.prepareStatement(insert_ve);
							pst2.execute();
							System.out.println("\ninsert ve thanh cong\n");

						
//						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
//						Date date=new Date();					
//						String tgString=formatter.format(date);
//						String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
//						
						DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
						Date date = new java.sql.Timestamp(new java.util.Date().getTime());				
						String tgString=df2.format(date);
						String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24-MI-SS')";
						
						
						String insert_datve;
						PreparedStatement pst=null;
						
						
					    System.out.println(" M?? TAI KHOAN: "+a6);

					    
					    if (iddvbt.equals("null")){
					    	Label_DichvuBotro.setVisible(false);
					    	lblNewLabel_1.setVisible(false);
					    	lblNewLabel.setVisible(false);
					    }
					    
						
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						String tgString1=formatter1.format(ngaysinh);
						String ngsinh = "TO_DATE('"+tgString1+"','yyyy-mm-dd HH24:MI:SS')";

					 	DangNhap dn=null;
						String tendangnhap=dn.tendn;
						String mkhau=dn.mk;
						PreparedStatement pst1=null;
						String insert_hanhkhach;
						if(tendangnhap!=null) {		
							Statement st=con.createStatement(); 

							String searchtkh="select ID from TAIKHOAN where TENDANGNHAP='"+tendangnhap+"' and MATKHAU='"+mkhau+"'";					
							ResultSet rs6= st.executeQuery(searchtkh);
							rs6.next();
								String idtk =rs6.getString(1);	
									
							  insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+idtk+")";
							  PreparedStatement  pst11 = con.prepareStatement(insert_hanhkhach);
							  pst11.execute();
							  System.out.println("insert hanh khach  co tai khoan thanh cong");

						}
					else {

							 insert_hanhkhach="insert into \"DB_AIRLINE\".\"HANHKHACH\"(\"ID\", \"HOTEN\", \"NGAYSINH\",\"QUOCTICH\",  \"GIOITINH\", \"SDT\", \"EMAIL\",\"TAIKHOAN_ID\") values( "+idhk+", '"+hoten_hk+"',"+ngsinh+",'"+quoctich+"','"+gioitinh+"',"+sodt+",'"+email+"',"+null+")";
							  pst1 = con.prepareStatement(insert_hanhkhach);
								pst1.execute();
								System.out.println("insert hanh khach khong co tai khoan thanh cong");
						
					}
					
					    
						
						System.out.println("a5"+"---------------------"+a6);
						 if (iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+a6+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
							System.out.println("2");
						}
						else if (iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+a6+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if(!iddvbt.equals("null")&&!a5.equals("null")&&!a6.equals("null")) {
								insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+a6+","+null+")";

								 pst = con.prepareStatement(insert_datve);
								pst.execute();
							}
						else if(!iddvbt.equals("null")&&a5.equals("null")&&!a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+a6+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if (iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
							
						insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+null+","+ngaydatve+","+d+",'Ch??a thanh to??n',"+null+","+null+")";
						 pst = con.prepareStatement(insert_datve);
						pst.execute();
					 	}
						else if (iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+null+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+null+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						else if(!iddvbt.equals("null")&&a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+null+","+iddvbt+","+ngaydatve+","+t+",'Ch??a thanh to??n',"+null+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						
						else if(!iddvbt.equals("null")&&!a5.equals("null")&&a6.equals("null")) {
							insert_datve="insert into \"DB_AIRLINE\".\"DATVEBAY\"(\"ID\", \"VEMAYBAY_ID\", \"HANHKHACH_ID\",\"KHUYENMAI_ID\",  \"DICHVUBOTRO_ID\", \"NGAYDAT\", \"TONGTIEN\",\"TINHTRANG\",\"TAIKHOAN_ID\",\"NHANVIEN_ID\") values("+iddv+","+idve+","+idhk+","+a5+","+iddvbt+","+ngaydatve+","+s+",'Ch??a thanh to??n',"+null+","+null+")";
							 pst = con.prepareStatement(insert_datve);
							pst.execute();
						}
						
						System.out.println("\n-----"+idhk+ " -----"+iddv+"------"+idve);
						System.out.println("\ninsert dat ve thanh cong\n");
						

						rs2.close();
						rs1.close();
						rs.close();
						//pst1.close();
						pst2.close();
						pst.close();

						JOptionPane.showMessageDialog(null, "               M?? ?????t v?? c???a b???n l??: "+iddv+"\n B???n vui l??ng ?????n qu???y nh??n vi??n ????? ti???n h??nh thanh to??n v?? in v??");
					
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();


			}
				
			}
		});
	
}	
		}
