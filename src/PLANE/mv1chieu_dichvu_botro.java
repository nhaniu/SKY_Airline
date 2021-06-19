package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.apache.commons.lang.text.StrSubstitutor;
import org.springframework.ui.Model;


import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class mv1chieu_dichvu_botro extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
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
	public static String iddvbt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mv1chieu_dichvu_botro frame = new mv1chieu_dichvu_botro(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich );
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
	public mv1chieu_dichvu_botro(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, String l, String m, Date b2, String c2, String d2, String e2) {
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
		hoten_hk =  m;
		ngaysinh = b2;
		sodt = c2;
		email = d2;
		quoctich = e2;
		
		setTitle("SKY ");
		setBackground(new Color(224, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 884, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dịch vụ bổ trợ ");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 10, 176, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quý khách lựa chọn dịch vụ bổ trợ để tiện lợi hơn cho chuyến đi của mình và người thân ");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(30, 41, 648, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hành lý trả trước là dịch vụ mua hành lý quá cước và thanh toán ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(39, 296, 428, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("trước để hưởng mức giá ưu đãi hơn so với giá mua tại sân bay");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 321, 404, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phí Hành lý trả trước đã mua sẽ không được phép hoàn.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(39, 343, 386, 23);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 102, 322, 85);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "G\u00F3i h\u00E0nh l\u00FD", "Gi\u00E1 ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(533, 102, 271, 259);
		contentPane.add(lblNewLabel_5);
		
		ImageIcon icon1=new ImageIcon("hành lý.jpg");
		Image imgIcon1 =icon1.getImage();
		
		Image imgScale1 =imgIcon1.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon1=new ImageIcon(imgScale1);
		lblNewLabel_5.setIcon(scaleIcon1);   
		// String iddvbt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select ID, NOIDUNGDV, GIADV from DICHVUBOTRO";
			
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				iddvbt =rs.getString(1);
				String goihl = rs.getString(2);
				String giatien = rs.getString(3);   
				
				String tbData[] = { goihl, giatien};  
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					System.out.print(goihl);
					System.out.print(giatien);

					tblModel.addRow(tbData);
					
			}
			
			
			conn.close();
		}
		
		catch(Exception e1 )
		{
			System.out.println(e1);
		}
		

		
		JButton btnTieptuc = new JButton("Tiếp tục ");
		btnTieptuc.setBackground(new Color(127, 255, 0));
		btnTieptuc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTieptuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				System.out.println(i);
				
				String goihanhly = new String();
				String giatien = new String();
				
				TableModel model = table.getModel();
				
				
				if (table.getSelectionModel().isSelectionEmpty()) {
					giatien = "0 VND";
					int khongchon =JOptionPane.showConfirmDialog(null, "Bạn không chọn dịch vụ bổ trợ, bạn có muốn tiếp tục ?","Warning",JOptionPane.YES_NO_OPTION);
					if(khongchon==JOptionPane.YES_OPTION) {
						thanh_toan_mv1chieu ob = new thanh_toan_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien, iddvbt);
						ob.setVisible(true);
						dispose();
					}
				}
					
				else
					
				{  
					goihanhly = model.getValueAt(i, 0).toString();
					giatien = model.getValueAt(i, 1).toString() + " VND";
					thanh_toan_mv1chieu ob = new thanh_toan_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien, iddvbt);
					ob.setVisible(true);
					dispose();
				}
				
				
			}
		});
		JTableHeader theJTableHeader = table.getTableHeader();
		theJTableHeader.setBackground(new Color(135, 206, 250));
		
		btnTieptuc.setBounds(159, 226, 93, 27);
		contentPane.add(btnTieptuc);
		
	}
}
