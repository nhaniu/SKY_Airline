package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class them_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID_NQL;
	private JTextField textField_tongsove;
	private JTextField textField_IDmb;
	private JLabel lb_id;

	public them_chuyenbay() {
		initComponent();
		autoID();}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_chuyenbay frame = new them_chuyenbay();
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
	public void initComponent() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 797, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thêm chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(229, 15, 306, 34);
		contentPane.add(lb_title);
		
		JLabel lb_sbdi = new JLabel("Sân bay đi: ");
		lb_sbdi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sbdi.setBounds(25, 133, 102, 18);
		contentPane.add(lb_sbdi);
		
		
		JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(559, 133, 151, 21);
		contentPane.add(comboBox_noiden);
		
		final JComboBox comboBox_noidi = new JComboBox();
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(172, 133, 151, 20);
		contentPane.add(comboBox_noidi);
		comboBox_noidi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_noidi.getSelectedItem().equals("Hà Nội (HAN), Việt Nam"))
				{
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");
					comboBox_noiden.addItem("Đà Nẵng (DAD), Việt Nam");
					comboBox_noiden.addItem("Phú Quốc (PQC), Việt Nam");
					comboBox_noiden.addItem("Nha Trang (CXR), Việt Nam");
					comboBox_noiden.addItem("Buôn Ma Thuột (BMV), Việt Nam");
					comboBox_noiden.addItem("Đồng Hới (VDH), Việt Nam");
					
				}
				else if (comboBox_noidi.getSelectedItem().equals("Tp. Hồ Chí Minh (SGN), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Đà Nẵng (DAD), Việt Nam");
					comboBox_noiden.addItem("Phú Quốc (PQC), Việt Nam");
					comboBox_noiden.addItem("Nha Trang (CXR), Việt Nam");
					comboBox_noiden.addItem("Buôn Ma Thuột (BMV), Việt Nam");
					comboBox_noiden.addItem("Đồng Hới (VDH), Việt Nam");
				}
				else if (comboBox_noidi.getSelectedItem().equals("Đà Nẵng (DAD), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");
					comboBox_noiden.addItem("Phú Quốc (PQC), Việt Nam");

				}
				else if (comboBox_noidi.getSelectedItem().equals("Phú Quốc (PQC), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");
					comboBox_noiden.addItem("Đà Nẵng (DAD), Việt Nam");
					comboBox_noiden.addItem("Nha Trang (CXR), Việt Nam");

				}
				else if (comboBox_noidi.getSelectedItem().equals("Nha Trang (CXR), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");
					comboBox_noiden.addItem("Đồng Hới (VDH), Việt Nam");
					comboBox_noiden.addItem("Phú Quốc (PQC), Việt Nam");

				}
				else if (comboBox_noidi.getSelectedItem().equals("Buôn Ma Thuột (BMV), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");

				}
				else if (comboBox_noidi.getSelectedItem().equals("Đồng Hới (VDH), Việt Nam")) {
					comboBox_noiden.removeAllItems();
					comboBox_noiden.setSelectedItem(null);
					comboBox_noiden.addItem("Hà Nội (HAN), Việt Nam");
					comboBox_noiden.addItem("Tp. Hồ Chí Minh (SGN), Việt Nam");
					comboBox_noiden.addItem("Nha Trang (CXR), Việt Nam");

				}
				
			}
		});
		
		JLabel lb_noiden = new JLabel("Sân bay đến: ");
		lb_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noiden.setBounds(421, 133, 102, 18);
		contentPane.add(lb_noiden);

		
		JLabel lb_ngaydi = new JLabel("Ngày-giờ hạ cánh:");
		lb_ngaydi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydi.setBounds(421, 172, 152, 20);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser_hc = new JDateChooser();
		dateChooser_hc.setBounds(559, 172, 151, 20);
		contentPane.add(dateChooser_hc);
		

		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(559, 384, 102, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 700, 2);
		contentPane.add(separator);
		
		JLabel lb_idnql = new JLabel("ID người quản lý:");
		lb_idnql.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_idnql.setBounds(408, 260, 127, 18);
		contentPane.add(lb_idnql);
		
		textField_ID_NQL = new JTextField();
		textField_ID_NQL.setBounds(559, 260, 151, 21);
		contentPane.add(textField_ID_NQL);
		textField_ID_NQL.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(421, 210, 86, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_tongsove = new JTextField();
		textField_tongsove.setBounds(559, 216, 151, 18);
		contentPane.add(textField_tongsove);
		textField_tongsove.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày-giờ khởi hành:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 174, 136, 18);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser_kh = new JDateChooser();
		dateChooser_kh.setBounds(172, 172, 151, 20);
		contentPane.add(dateChooser_kh);
		
		JLabel lblNewLabel_3 = new JLabel("ID máy bay:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(421, 87, 114, 17);
		contentPane.add(lblNewLabel_3);
		
		textField_IDmb = new JTextField();
		textField_IDmb.setBounds(559, 87, 151, 18);
		contentPane.add(textField_IDmb);
		textField_IDmb.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID chuyến bay:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 86, 122, 18);
		contentPane.add(lblNewLabel_4);
		
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(134, 384, 102, 23);
		contentPane.add(bt_them);
		
		 lb_id = new JLabel("");
		lb_id.setBounds(172, 85, 151, 18);
		contentPane.add(lb_id);
		
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_ID_NQL.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID người quản lý");
					 textField_ID_NQL.requestFocus();
					 return; 
					}
				
				if (textField_IDmb.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID máy bay");
					 textField_IDmb.requestFocus();
					 return; 
					}
			
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser_kh.getDate());
					String ngay_khoihanh="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
	

					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString1=formatter1.format(dateChooser_hc.getDate());
					String ngay_hacanh="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";


				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"CHUYENBAY\"  (\"ID\", \"TTMAYBAY_ID\", \"SANBAYDI\",\"SANBAYDEN\",  \"NGAY_GIO_KH\", \"NGAY_GIO_HC\", \"TONGSOVE\",\"NGUOIQUANLY_ID\") values("+lb_id.getText()+","+textField_IDmb.getText()+",'"+comboBox_noidi.getSelectedItem()+"','"+comboBox_noiden.getSelectedItem()+"',"+ngay_khoihanh+","+ngay_hacanh+","+textField_tongsove.getText()+","+textField_ID_NQL.getText()+")");		
				pst.execute();	
				
				int id_thongke=6000;
				Statement st=(Statement) ((java.sql.Connection) con).createStatement();  	
				ResultSet rs=((java.sql.Statement) st).executeQuery("select MAX(ID) from THONGKECHUYENBAY");  			
				rs.next();
				
				if(rs.getString("MAX(ID)")==null) {
					id_thongke=6001;
				}
				else 
				{
					id_thongke = Integer.valueOf(rs.getString("MAX(ID)"));
					id_thongke++;

				}
								
				PreparedStatement pst1= con.prepareStatement("insert into \"DB_AIRLINE\".\"THONGKECHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"THOIGIAN\",\"SOLUONGVECON\",  \"SOLUONGVEBAN\",\"NGUOIQUANLY_ID\") values("+id_thongke+","+lb_id.getText()+","+ngay_khoihanh+","+textField_tongsove.getText()+","+0+","+textField_ID_NQL.getText()+")");		
				pst1.execute();
				pst1.close();
				Component a=null;
				JOptionPane.showMessageDialog(a, "Đã thêm thành công");

				
				con.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
				
		});

		
	}

	public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from CHUYENBAY");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("601");
			}
			else 
			{
				Integer result1 = Integer.valueOf(rs.getString("MAX(ID)"));
				result1++;
				lb_id.setText(result1.toString());
			}
			
			rs.close();
			DB_AIRLINE.close();
		} catch (ClassNotFoundException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);

		}  
	}
//	public void autoID1() {
//		
//		
//		
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
//			
//			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
//			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from THONGKECHUYENBAY");  
//			
//			rs.next();
//			System.out.println(rs.getString("MAX(ID)"));
//			
//			if(rs.getString("MAX(ID)")==null) {
//				rs.getString("ID=6001");
//			}
//			else 
//			{
//				Integer result1 = Integer.valueOf(rs.getString("MAX(ID)"));
//				result1++;
//				rs.getString(result1.toString());
//				System.out.println(	rs.getString(result1.toString()));
//
//			}
//			
//			rs.close();
//			DB_AIRLINE.close();
//		} catch (ClassNotFoundException e) {
//			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
//		} catch (SQLException e) {
//			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
//
//		}  
//	}
	}
