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
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
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

public class mvkhuhoi_dvbotro extends JFrame {

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
					mvkhuhoi_dvbotro frame = new mvkhuhoi_dvbotro(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich );
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
	public mvkhuhoi_dvbotro(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k, String l, String m, Date b2, String c2, String d2, String e2) {
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
		
		JLabel lblNewLabel = new JLabel("D???ch v??? b??? tr??? ");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(30, 10, 176, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Qu?? kh??ch l???a ch???n d???ch v??? b??? tr??? ????? ti???n l???i h??n cho chuy???n ??i c???a m??nh v?? ng?????i th??n ");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(30, 41, 648, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H??nh l?? tr??? tr?????c l?? d???ch v??? mua h??nh l?? qu?? c?????c v?? thanh to??n ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(39, 296, 428, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("tr?????c ????? h?????ng m???c gi?? ??u ????i h??n so v???i gi?? mua t???i s??n bay");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(38, 321, 404, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ph?? H??nh l?? tr??? tr?????c ???? mua s??? kh??ng ???????c ph??p ho??n.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(39, 343, 386, 23);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 102, 287, 85);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "G\u00F3i h\u00E0nh l\u00FD", "Gi\u00E1 ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(533, 102, 271, 259);
		contentPane.add(lblNewLabel_5);
		
		ImageIcon icon1=new ImageIcon("h??nh l??.jpg");
		Image imgIcon1 =icon1.getImage();
		
		Image imgScale1 =imgIcon1.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon1=new ImageIcon(imgScale1);
		lblNewLabel_5.setIcon(scaleIcon1);   
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select ID,NOIDUNGDV, GIADV from DICHVUBOTRO";
			
			
			System.out.println(sql);
			
	
			ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
			while(rs.next()) 
			{
				iddvbt = rs.getString(1);
				String goihl = rs.getString(2);
				String giatien = rs.getString(3);

				 
				
				String tbData[] = {iddvbt,goihl, giatien};
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					System.out.print(goihl);
					System.out.print(giatien);

					tblModel.addRow(tbData);
					
			}
			
			
			conn.close();
		}
		
		catch(Exception e1 )
		{
			System.out.println("Kh??ng t??m th???y chuy???n bay!");
			JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y chuy???n bay!");
		}
		

		
		JButton btnTieptuc = new JButton("Ti???p t???c ");
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
					goihanhly="null";
					iddvbt="null";
					int khongchon =JOptionPane.showConfirmDialog(null, "B???n kh??ng ch???n d???ch v??? b??? tr???, b???n c?? mu???n ti???p t???c ?","Warning",JOptionPane.YES_NO_OPTION);
					if(khongchon==JOptionPane.YES_OPTION) {
						mvkhuhoi_thanhtoan obj = new mvkhuhoi_thanhtoan(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien,iddvbt);
						obj.setVisible(true);
						dispose();
					}
				}
					
				else
				{
					iddvbt=model.getValueAt(i, 0).toString();

					goihanhly = model.getValueAt(i, 1).toString();
					giatien = model.getValueAt(i, 2).toString() + " VND";
					mvkhuhoi_thanhtoan ob = new mvkhuhoi_thanhtoan(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich, goihanhly, giatien,iddvbt);
					ob.setVisible(true);
					dispose();
				}
				
				
			}

			private mvkhuhoi_thanhtoan mvkhuhoi_thanhtoan(String gio_kh_di, String gio_hc_di, String h_ve_di,
					String gia_ve_di, String noi_di, String noi_den, String gio_kh_ve, String gio_hc_ve, String h_ve_ve,
					String gia_ve_ve, String danh_xung, String hoten_hk, Date ngaysinh, String sodt, String email,
					String quoctich, String goihanhly, String giatien) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		JTableHeader theJTableHeader = table.getTableHeader();
		theJTableHeader.setBackground(new Color(135, 206, 250));
		
		btnTieptuc.setBounds(159, 226, 93, 27);
		contentPane.add(btnTieptuc);
		
	}
}

