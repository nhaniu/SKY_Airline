package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class muave_khuhoi extends JFrame {

	private JPanel contentPane;
	private JTable table_di;
	private JTable table_ve;
	public static String idhvdi;
	public static String idcbdi;
	public static String idhvve;
	public static String idcbve;
	private int tongsoghe;
	private int thuonggia;
	private int phothongdb;

	private int phothonglh;

	private int phothongtk;
	private int countid_ptdb;
	private int countid_ptlh;
	private int countid_pttk;
	private int countid;
	
	private int thuonggiakh;
	private int phothongdbkh;

	private int phothonglhkh;

	private int phothongtkkh;
	private int countid_ptdbkh;
	private int countid_ptlhkh;
	private int countid_pttkkh;
	private int countidkh;
    private int demKt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muave_khuhoi frame = new muave_khuhoi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con=null;
	private static JComboBox comboBox_noidi;
	private static JComboBox comboBox_noiden;


	public  muave_khuhoi()  {
		initComponent();
		loadCombobox();
		loadCombobox1();
		Teststringcomparison(toString(), toString());

	}
	
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
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 832, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_noidi = new JLabel("Nơi đi:");
		lb_noidi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_noidi.setBounds(41, 28, 49, 19);
		contentPane.add(lb_noidi);
		
		 comboBox_noidi = new JComboBox();
		//comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(100, 25, 183, 22);
		contentPane.add(comboBox_noidi);
		
		JLabel lb_noiden = new JLabel("Nơi đến:");
		lb_noiden.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_noiden.setBounds(354, 28, 68, 18);
		contentPane.add(lb_noiden);
		
		 comboBox_noiden = new JComboBox();
		//comboBox_noiden.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noiden.setBounds(419, 25, 204, 22);
		contentPane.add(comboBox_noiden);
		
		JLabel lb_ngaydi = new JLabel("Ngày đi:");
		lb_ngaydi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_ngaydi.setBounds(41, 70, 56, 18);
		contentPane.add(lb_ngaydi);
		
		final JDateChooser dateChooser_ngaydi = new JDateChooser();
		dateChooser_ngaydi.setBounds(100, 66, 140, 20);
		contentPane.add(dateChooser_ngaydi);
		
		JLabel lb_ngayden = new JLabel("Ngày về:");
		lb_ngayden.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_ngayden.setBounds(354, 68, 61, 22);
		contentPane.add(lb_ngayden);
		
		final JDateChooser dateChooser_ngayve = new JDateChooser();
		dateChooser_ngayve.setBounds(419, 66, 140, 20);
		contentPane.add(dateChooser_ngayve);
		
		final JScrollPane scrollPane_di = new JScrollPane();
		scrollPane_di.setBounds(82, 233, 576, 91);
		contentPane.add(scrollPane_di);
		scrollPane_di.setVisible(false);
		
		table_di = new JTable();
		table_di.setBackground(new Color(255, 255, 255));
		table_di.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_di.setVisible(false);
		
		final DefaultTableModel tableModeldi = new DefaultTableModel();
		tableModeldi.addColumn("Giờ khởi hành");
		tableModeldi.addColumn("Giờ hạ cánh");
		tableModeldi.addColumn("Hạng vé");
		tableModeldi.addColumn("Giá vé");

		table_di.setModel(tableModeldi);

		
		JTableHeader Theader = table_di.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		scrollPane_di.setViewportView(table_di);
		
		final JScrollPane scrollPane_ve = new JScrollPane();
		scrollPane_ve.setBounds(83, 382, 575, 101);
		contentPane.add(scrollPane_ve);
		scrollPane_ve.setVisible(false);
		
		table_ve = new JTable();
		table_ve.setBackground(new Color(255, 255, 255));
		table_ve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
	//	table_di.setVisible(false);
		
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Giờ khởi hành");
		tableModel.addColumn("Giờ hạ cánh");
		tableModel.addColumn("Hạng vé");
		tableModel.addColumn("Giá vé");

		table_ve.setModel(tableModel);

		
		JTableHeader Theader1 = table_ve.getTableHeader();
		 Theader1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader1.setBackground(new Color(255, 255, 255));
		
		scrollPane_ve.setViewportView(table_ve);
		
		final JLabel Label_ngaydi = new JLabel("Ngày đi ");
		Label_ngaydi.setForeground(new Color(255, 140, 0));
		Label_ngaydi.setFont(new Font("Tahoma", Font.BOLD, 12));
		Label_ngaydi.setBounds(81, 203, 76, 19);
		contentPane.add(Label_ngaydi);
		Label_ngaydi.setVisible(false);
		
		final JLabel Label_ngayve = new JLabel("Ngày về ");
		Label_ngayve.setFont(new Font("Tahoma", Font.BOLD, 12));
		Label_ngayve.setForeground(new Color(255, 140, 0));
		Label_ngayve.setBounds(82, 352, 68, 19);
		contentPane.add(Label_ngayve);
		Label_ngayve.setVisible(false);
		
		final JButton button_chonmua = new JButton("Chọn mua ");
		button_chonmua.setBackground(new Color(124, 252, 0));
		button_chonmua.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button_chonmua.setBounds(330, 505, 93, 21);
		contentPane.add(button_chonmua);
		button_chonmua.setVisible(false);
		
		JButton bt_timchuyebay = new JButton("Tìm chuyến bay");
		bt_timchuyebay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bt_timchuyebay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Teststringcomparison(comboBox_noidi.getSelectedItem(), comboBox_noiden.getSelectedItem()) == true) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại nơi đến, nơi đi!");
				}
				else {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
						java.sql.Statement st = conn.createStatement();
						
						String day = new String();
						String month = new String();
						String year = new String();
						String date = new String();
						
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String tgString=formatter.format(dateChooser_ngaydi.getDate());
						day = tgString.substring(8,10);
						month = tgString.substring(5,7);
						year = tgString.substring(0,4);
						date = tgString.substring(0,10);
						
						//String texString="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
						String sql = "select distinct c.NGAY_GIO_KH, c.NGAY_GIO_HC, h.TENHV, h.GIA, h.ID, c.ID"
								+ " from CHUYENBAY c JOIN VEMAYBAY v ON c.ID = v.CHUYENBAY_ID JOIN HANGVE h ON h.ID = v.HANGVE_ID "
								+ "where c.SANBAYDI = " + "'"+comboBox_noidi.getSelectedItem()+"'"+" and c.SANBAYDEN = "+"'"+comboBox_noiden.getSelectedItem()+"'"
								+ " and EXTRACT( DAY FROM c.NGAY_GIO_KH)= "+"'"+day+"'"+" and EXTRACT( MONTH FROM c.NGAY_GIO_KH)= "+"'"+month+"'"+" and EXTRACT(YEAR FROM c.NGAY_GIO_KH)= "+"'"+year+"'";
					
						
						System.out.println(day);
						System.out.println(month);
						System.out.println(year);
						System.out.println(date);
						System.out.println(sql);
						
						int dem=0;
	
						ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
						 while(tableModeldi.getRowCount() > 0) 
							{									
								tableModeldi.removeRow(0);
							}
						while(rs.next()) 
						{
							String giokh = rs.getString(1);
							String giohc = rs.getString(2);
							String hv = rs.getString(3);
							String gv = rs.getString(4);
							//idhvdi = rs.getString(5);
							idcbdi = rs.getString(6);
						//	System.out.println(idhvdi+" huhu");

	
							 dem++;
								tableModeldi.addRow(new Object[] {giokh, giohc, hv, gv});
	
	
								scrollPane_di.setVisible(true);
								table_di.setVisible(true);
								button_chonmua.setVisible(true);
								Label_ngaydi.setVisible(true);
	
								
						}
						
						if(dem==0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến bay đi");
						}
						conn.close();
					}
					
					catch(Exception e1 )
					{
						System.out.println(e1);
						
					}
					
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
						java.sql.Statement st = conn.createStatement();
						
						String day = new String();
						String month = new String();
						String year = new String();
						String date = new String();
						
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String tgString=formatter.format(dateChooser_ngayve.getDate());
						day = tgString.substring(8,10);
						month = tgString.substring(5,7);
						year = tgString.substring(0,4);
						date = tgString.substring(0,10);
						
						// Chuyen ve
						String sql = "select distinct c.NGAY_GIO_KH, c.NGAY_GIO_HC, h.TENHV, h.GIA,h.ID, c.ID"
								+ " from CHUYENBAY c JOIN VEMAYBAY v ON c.ID = v.CHUYENBAY_ID JOIN HANGVE h ON h.ID = v.HANGVE_ID "
								+ "where c.SANBAYDI = " + "'"+comboBox_noiden.getSelectedItem()+"'"+" and c.SANBAYDEN = "+"'"+comboBox_noidi.getSelectedItem()+"'"
								+ " and EXTRACT( DAY FROM c.NGAY_GIO_KH)= "+"'"+day+"'"+" and EXTRACT( MONTH FROM c.NGAY_GIO_KH)= "+"'"+month+"'"+" and EXTRACT(YEAR FROM c.NGAY_GIO_KH)= "+"'"+year+"'";
					
						
						System.out.println(day);
						System.out.println(month);
						System.out.println(year);
						System.out.println(date);
						System.out.println(sql);
						
				
						ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
						 while(tableModel.getRowCount() > 0) 
							{									
								tableModel.removeRow(0);
							}
						 int dem=0;
						while(rs.next()) 
						{
							String giokh = rs.getString(1);
							String giohc = rs.getString(2);
							String hv = rs.getString(3);
							String gv = rs.getString(4);
							//idhvve = rs.getString(5);
							idcbve = rs.getString(6);
							//System.out.println(idhvve+" huhu");

							 dem++;
							
							tableModel.addRow(new Object[] {giokh, giohc, hv, gv});
	
	
								scrollPane_ve.setVisible(true);
								table_ve.setVisible(true);
								button_chonmua.setVisible(true);
								Label_ngayve.setVisible(true);
								
						}
						if(dem==0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến bay về");
						}

							System.out.println("\nidcbve"+idcbve);
						conn.close();
					}
					
					catch(Exception e1 )
					{
						System.out.println(e1);
						
					}
				}
				
				
				
			}
		});
		bt_timchuyebay.setBackground(new Color(0, 191, 255));
		bt_timchuyebay.setBounds(270, 149, 145, 23);
		contentPane.add(bt_timchuyebay);
		
		JTableHeader theJTableHeader = table_di.getTableHeader();
		theJTableHeader.setBackground(new Color(135, 206, 250));
		
		JTableHeader theJTableHeader1 = table_ve.getTableHeader();
		theJTableHeader1.setBackground(new Color(135, 206, 250));
		
	

		button_chonmua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//chuyến đi
				 demKt=0;

				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng thương gia' AND CHUYENBAY_ID="+idcbdi+" ");
		            
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông tiết kiệm' AND CHUYENBAY_ID="+idcbdi+" ");
		            
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông linh hoạt' AND CHUYENBAY_ID="+idcbdi+" ");
		            
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông đặc biệt' AND CHUYENBAY_ID="+idcbdi+" ");
		            
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
		             PreparedStatement pst = con.prepareStatement("Select THUONGGIA, PHOTHONGDB, PHOTHONGLH, PHOTHONGTK from CHUYENBAY  where ID="+idcbdi+"");
		         	
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

				//chuyen ve
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("SELECT COUNT(VE.CHUYENBAY_ID)\r\n"
		             		+ "    FROM VEMAYBAY VE, HANGVE HV\r\n"
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng thương gia' AND CHUYENBAY_ID="+idcbve+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t1 =rs1.getString(1);
							countidkh=Integer.parseInt(t1);
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông tiết kiệm' AND CHUYENBAY_ID="+idcbve+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t2 =rs1.getString(1);
							countid_pttkkh=Integer.parseInt(t2);
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông linh hoạt' AND CHUYENBAY_ID="+idcbve+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String t =rs1.getString(1);
							countid_ptlhkh=Integer.parseInt(t);
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
		             		+ "        WHERE VE.HANGVE_ID=HV.ID AND TENHV='Hạng phổ thông đặc biệt' AND CHUYENBAY_ID="+idcbve+" ");
		            
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String n =rs1.getString(1);
							countid_ptdbkh=Integer.parseInt(n);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("Select THUONGGIA, PHOTHONGDB, PHOTHONGLH, PHOTHONGTK from CHUYENBAY  where ID="+idcbve+"");
		         	
						ResultSet rs1= pst.executeQuery();
						while(rs1.next()) {
							String  TG =rs1.getString(1);
							thuonggiakh=Integer.parseInt(TG);
							String PTDB  =rs1.getString(2);
							phothongdbkh=Integer.parseInt(PTDB);
							String  PTLH =rs1.getString(3);
							phothonglhkh=Integer.parseInt(PTLH);
							String  PTTK =rs1.getString(4);
							phothongtkkh=Integer.parseInt(PTTK);

						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				//chuyen di
				
				DefaultTableModel model=(DefaultTableModel)table_di.getModel();
				int a=table_di.getSelectedRow();								
				//String hangve = model.getValueAt(a, 2).toString();
				
				System.out.println("\nhạng ve: "+model.getValueAt(a, 2).toString());
      			boolean kt;
				//if(kt=true) {

				
				if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông đặc biệt")&&phothongdb==countid_ptdb) {
					System.out.println("\nhạng ptdb trong ve: "+countid_ptdb);
					System.out.println("\nhạng ptdb : "+phothongdb);
					JOptionPane.showMessageDialog(null, "Hạng phổ thông đặc biệt chuyến đi đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông tiết kiệm")&&phothongtk==countid_pttk) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông tiết kiệm chuyến đi đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng phổ thông linh hoạt")&&phothonglh==countid_ptlh) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông linh hoạt chuyến đi đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model.getValueAt(a, 2).toString().equals("Hạng thương gia")&&thuonggia==countid) {
					System.out.println("\nhạng thương gia: "+thuonggia);
					System.out.println("\nhạng thương gia trong ve: "+countid);
					JOptionPane.showMessageDialog(null, "Hạng thương gia chuyến đi đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else {
					demKt++;
				}
				
				//chuyen ve
				DefaultTableModel model1=(DefaultTableModel)table_ve.getModel();
				int a1=table_ve.getSelectedRow();								
				//String hangve = model.getValueAt(a, 2).toString();
				
				System.out.println("\nhạng ve: "+model1.getValueAt(a1, 2).toString());
				
				


				
				 if(model1.getValueAt(a1, 2).toString().equals("Hạng phổ thông đặc biệt")&&phothongdbkh==countid_ptdbkh) {
					System.out.println("\nhạng ptdb trong ve: "+countid_ptdbkh);
					System.out.println("\nhạng ptdb : "+phothongdbkh);
					JOptionPane.showMessageDialog(null, "Hạng phổ thông đặc biệt chuyến về đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model1.getValueAt(a1, 2).toString().equals("Hạng phổ thông tiết kiệm")&&phothongtkkh==countid_pttkkh) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông tiết kiệm chuyến về đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model1.getValueAt(a1, 2).toString().equals("Hạng phổ thông linh hoạt")&&phothonglhkh==countid_ptlhkh) {
					JOptionPane.showMessageDialog(null, "Hạng phổ thông linh hoạt chuyến về đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				else if(model1.getValueAt(a1, 2).toString().equals("Hạng thương gia")&&thuonggiakh==countidkh) {
					System.out.println("\nhạng thương gia: "+thuonggiakh);
					System.out.println("\nhạng thương gia trong ve: "+countidkh);
					JOptionPane.showMessageDialog(null, "Hạng thương gia chuyến về đã hết vé, xin quý khách chọn chuyến bay khác");
				}
				
				else {
			    demKt++;
				int id = table_di.getSelectedRow();
				
				System.out.println(id);
				String gio_kh_di= new String();
				String gio_hc_di = new String();
				String h_ve_di = new String();
				String gia_ve_di = new String();
				String noi_di = new String();
				String noi_den = new String();
				TableModel model11 = table_di.getModel();
				
				noi_di = comboBox_noidi.getSelectedItem().toString();
				noi_den = comboBox_noiden.getSelectedItem().toString();
				gio_kh_di = model11.getValueAt(id, 0).toString();
				gio_hc_di = model11.getValueAt(id, 1).toString();
				h_ve_di = model11.getValueAt(id, 2).toString();
				gia_ve_di = model11.getValueAt(id, 3).toString();
				
				int iv = table_ve.getSelectedRow();
				System.out.println(iv);
				String gio_kh_ve= new String();
				String gio_hc_ve = new String();
				String h_ve_ve = new String();
				String gia_ve_ve = new String();
				TableModel model111 = table_ve.getModel();
				
				
				gio_kh_ve = model111.getValueAt(iv, 0).toString();
				gio_hc_ve = model111.getValueAt(iv, 1).toString();
				h_ve_ve = model111.getValueAt(iv, 2).toString();
				gia_ve_ve = model111.getValueAt(iv, 3).toString();
				
				
				System.out.println("id hạng vé đi: "+idhvdi);
				System.out.println("id hạng vé về: "+idhvve);
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("Select ID from HANGVE  where TENHV='"+h_ve_di+"'");
		         	
						ResultSet rs1= pst.executeQuery();
						if(rs1.next()) {
							idhvdi =rs1.getString(1);
						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		             PreparedStatement pst = con.prepareStatement("Select ID from HANGVE  where TENHV='"+h_ve_ve+"'");
		         	
						ResultSet rs1= pst.executeQuery();
						if(rs1.next()) {
							idhvve =rs1.getString(1);
							

						}

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println(idhvdi+" huhuhu "+idhvve);


				if (table_ve.getSelectionModel().isSelectionEmpty() || table_di.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showConfirmDialog(null, "Xin vui lòng chọn chuyến bay!","Warning",JOptionPane.YES_OPTION);
					table_di.requestFocus();
					table_ve.requestFocus();
					return;
				}
				if(demKt==2)
				{
					nhapthongtin_mvkhuhoi obj = new nhapthongtin_mvkhuhoi(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve);
					obj.setVisible(true);
					dispose();}
				}
				}
			
				
		});
		
		
	}
}
