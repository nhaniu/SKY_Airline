package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class muave_motchieu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String idhv;
	public static String idcb;

	Connection con=null;
	private static JComboBox comboBox_noidi;
	private static JComboBox comboBox_noiden;
	private String tsgcb;
	private int tongsoghe;
	private int countid;
	private int thuonggia;
	private int phothongdb;

	private int phothonglh;

	private int phothongtk;
	private int countid_ptdb;
	private int countid_ptlh;
	private int countid_pttk;




	public muave_motchieu() {
		initComponent();
		loadCombobox();
		loadCombobox1();
		Teststringcomparison(toString(), toString());

	}
	/**
	 * Launch the application.
	 */
	
	public static boolean Teststringcomparison (Object object, Object object2){
		object = comboBox_noidi.getSelectedItem().toString();
		object2 = comboBox_noiden.getSelectedItem().toString();
		if (object.equals(object2)) {
			System.out.println("Giống");
			return true;
		}
		System.out.println("K giống");
		return false;
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muave_motchieu frame = new muave_motchieu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadCombobox() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noidi.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noiden.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public void initComponent() {
		setTitle("SKY Airline");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 659, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_noi_di = new JLabel("Nơi đi: ");
		lb_noi_di.setBounds(10, 25, 49, 33);
		contentPane.add(lb_noi_di);
		
		JLabel lb_noi_den = new JLabel("Nơi đến:");
		lb_noi_den.setBounds(323, 34, 66, 14);
		contentPane.add(lb_noi_den);
		
		JLabel lb_ngay_di = new JLabel("Ngày đi:");
		lb_ngay_di.setBounds(10, 69, 49, 14);
		contentPane.add(lb_ngay_di);
		
		comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(388, 30, 216, 22);
		contentPane.add(comboBox_noiden);
		
		comboBox_noidi = new JComboBox();
		comboBox_noidi.setBounds(69, 30, 216, 22);
		contentPane.add(comboBox_noidi);
		
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 69, 162, 20);
		contentPane.add(dateChooser);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 214, 557, 103);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setVisible(false);
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Giờ khởi hành");
		tableModel.addColumn("Giờ hạ cánh");
		tableModel.addColumn("Hạng vé");
		tableModel.addColumn("Giá vé");

		
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		scrollPane.setViewportView(table);
		
		
		final JButton button_chonmua = new JButton("Chọn mua ");
		button_chonmua.setForeground(new Color(0, 0, 0));
		button_chonmua.setBackground(new Color(124, 252, 0));
		button_chonmua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_chonmua.setVisible(false);
		

		
		JButton bt_tim_chuyen_bay = new JButton("Tìm chuyến bay");
		bt_tim_chuyen_bay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bt_tim_chuyen_bay.setBackground(new Color(0, 191, 255));
		bt_tim_chuyen_bay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Timestamp date_ht = new java.sql.Timestamp(new java.util.Date().getTime());
				Date ngay_ht = new Date(date_ht.getTime());

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String tgString=formatter.format(dateChooser.getDate());
				String day = new String();
				String month = new String();
				String year = new String();
				String date = new String();
				
				day = tgString.substring(8,10);
				month = tgString.substring(5,7);
				year = tgString.substring(0,4);
				date = tgString.substring(0,10);
				
				try {
					Date ngay_kh = (Date) formatter.parse(tgString);
				if (Teststringcomparison(comboBox_noidi.getSelectedItem(), comboBox_noiden.getSelectedItem()) == true) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại nơi đến, nơi đi!");
				}
				else {
					if(ngay_kh.compareTo(ngay_ht)<0) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày khởi hành lớn hơn ngày hiện tại!");
					}
					else
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
						java.sql.Statement st = conn.createStatement();
						

						 String sql = "select distinct CB.ID, CB.NGAY_GIO_KH, CB.NGAY_GIO_HC, HV.TENHV, HV.GIA\r\n"
														+ " from CHUYENBAY CB, VEMAYBAY VE, HANGVE HV\r\n"
														+ " WHERE CB.ID=HV.CHUYENBAY_ID AND CB.ID=VE.CHUYENBAY_ID AND CB.SANBAYDI = " + "'"+comboBox_noidi.getSelectedItem()+"'"+" and CB.SANBAYDEN = "+"'"+comboBox_noiden.getSelectedItem()+"'"
														+ " and EXTRACT( DAY FROM CB.NGAY_GIO_KH)= "+"'"+day+"'"+" and EXTRACT( MONTH FROM CB.NGAY_GIO_KH)= "+"'"+month+"'"+" and EXTRACT(YEAR FROM CB.NGAY_GIO_KH)= "+"'"+year+"'";
							
						
						System.out.println(day);
						System.out.println(month);
						System.out.println(year);
						System.out.println(date);
						System.out.println(sql);
						
						ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
						
						 int dem=0;
						 
						 while(tableModel.getRowCount() > 0) 
							{									
								tableModel.removeRow(0);
							}
						while(rs.next()) 
						{
							 idcb = rs.getString(1);
							String giokh = rs.getString(2);
							String giohc = rs.getString(3);
							String hv = rs.getString(4);
							String gv = rs.getString(5);
					//		idhv = rs.getString(6);
	
							dem++;
							
	
							tableModel.addRow(new Object[] {giokh, giohc, hv, gv});
								System.out.print(giokh+giohc+hv+gv);
	
								scrollPane.setVisible(true);
								table.setVisible(true);
								button_chonmua.setVisible(true);
								
						}
						
		
						if(dem==0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến bay");
						}
						conn.close();
					}
				}
				}
					catch(Exception e1 )
					{
					
					}
					
					}
			
		});
		
		bt_tim_chuyen_bay.setBounds(252, 122, 137, 24);
		contentPane.add(bt_tim_chuyen_bay);
		

		

		button_chonmua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng thương gia' AND CHUYENBAY_ID="+idcb+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t1 =rs1.getString(1);
							countid=Integer.parseInt(t1);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông tiết kiệm' AND CHUYENBAY_ID="+idcb+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t2 =rs1.getString(1);
							countid_pttk=Integer.parseInt(t2);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông linh hoạt' AND CHUYENBAY_ID="+idcb+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t =rs1.getString(1);
							countid_ptlh=Integer.parseInt(t);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông đặc biệt' AND CHUYENBAY_ID="+idcb+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String n =rs1.getString(1);
							countid_ptdb=Integer.parseInt(n);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("Select THUONGGIA, PHOTHONGDB, PHOTHONGLH, PHOTHONGTK from CHUYENBAY  where ID="+idcb+"");
		         	
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String  TG =rs1.getString(1);
							thuonggia=Integer.parseInt(TG);
							String PTDB  =rs1.getString(2);
							phothongdb=Integer.parseInt(PTDB);
							String  PTLH =rs1.getString(3);
							phothonglh=Integer.parseInt(PTLH);
							String  PTTK =rs1.getString(4);
							phothongtk=Integer.parseInt(PTTK);

						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int a=table.getSelectedRow();								
				//String hangve = model.getValueAt(a, 2).toString();
				
				System.out.println("\nhạng vé: "+model.getValueAt(a, 2).toString());
				
				


				
				 if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông đặc biệt")&&phothongdb==countid_ptdb) {
					System.out.println("\nhạng ptdb trong ve: "+countid_ptdb);
					System.out.println("\nhạng ptdb : "+phothongdb);
					JOptionPane.showMessageDialog(null, "Hạng phổ thông đặc biệt đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông tiết kiệm")&&phothongtk==countid_pttk) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông tiết kiệm đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông linh hoạt")&&phothonglh==countid_ptlh) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông linh hoạt đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng thương gia")&&thuonggia==countid) {
					System.out.println("\nhạng thương gia: "+thuonggia);
					System.out.println("\nhạng thương gia trong ve: "+countid);
					JOptionPane.showMessageDialog(null, "Hạng thương gia đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				
				else {
				
				int i = table.getSelectedRow();
				
				 String gio_kh_di = new String();
				 String gio_hc_di = new String();
				 String h_ve_di = new String();
				 String gia_ve_di = new String();
				 String noi_di = new String();
				 String noi_den = new String();
				 String gio_kh_ve= new String();
				 String gio_hc_ve = new String();
				 String h_ve_ve = new String();
				 String gia_ve_ve = new String();
					
				TableModel model1 = table.getModel();
				
				noi_di = comboBox_noidi.getSelectedItem().toString();
				noi_den = comboBox_noiden.getSelectedItem().toString();
				gio_kh_di = model1.getValueAt(i, 0).toString();
				gio_hc_di= model1.getValueAt(i, 1).toString();
				h_ve_di = model1.getValueAt(i, 2).toString();
				gia_ve_di = model1.getValueAt(i, 3).toString();
				
				nhapthongtin_mv1chieu obj = new nhapthongtin_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve);
				obj.setVisible(true);
				dispose();
				}
				
			}
		});
		JTableHeader theJTableHeader = table.getTableHeader();
		theJTableHeader.setBackground(new Color(135, 206, 250));
		
		button_chonmua.setBounds(266, 380, 122, 22);
		contentPane.add(button_chonmua);
		
	}
}
