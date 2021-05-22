package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.nio.channels.SelectableChannel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class muave_motchieu extends JFrame {

	private JPanel contentPane;
//	private String NoiDi=null, NoiDen=null, GiaVe=null ;
//	//private int GiaVe=0;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public muave_motchieu() {
		setTitle("SKY Airline");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 658, 693);
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
		
		final JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(388, 30, 216, 22);
		contentPane.add(comboBox_noiden);
		
		final JComboBox comboBox_noidi = new JComboBox();
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
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(69, 30, 216, 22);
		contentPane.add(comboBox_noidi);
		
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 69, 162, 20);
		contentPane.add(dateChooser);
		
		JLabel lb_nguoi_lon = new JLabel("Số lượng: ");
		lb_nguoi_lon.setBounds(10, 102, 66, 24);
		contentPane.add(lb_nguoi_lon);
		
		JComboBox comboBox_nguoi_lon = new JComboBox();
		comboBox_nguoi_lon.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_nguoi_lon.setBounds(100, 103, 49, 22);
		contentPane.add(comboBox_nguoi_lon);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 284, 581, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model= new DefaultTableModel();
		model.addColumn("Nơi đi");
		model.addColumn("Nơi đến");
		model.addColumn("Ngày đi");
		model.addColumn("Giá vé");
		table.setModel(model);
		
		JButton bt_tim_chuyen_bay = new JButton("Tìm chuyến bay");
		bt_tim_chuyen_bay.setBackground(new Color(0, 191, 255));
//		bt_tim_chuyen_bay.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try{  
//					comboBox_noidi.getSelectedItem();
//					
//					//step1 load the driver class  
//					Class.forName("oracle.jdbc.OracleDriver");  
//					  
//					//step2 create  the connection object  
//					java.sql.Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","doan","doan");  
//					
//					  String select="";
//					//step3 create the statement object  
//					Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  	
//					  
//					//step4 execute query  
//					
//					ResultSet rs=((java.sql.Statement) stmt).executeQuery(select);  
//					while(rs.next())  
//				{ 	
//					
//				
//					
//				}
//					
//					
//					//step5 close the connection object  
//					con.close();  
//					  
//					}
//					catch(Exception e1){ System.out.println(e1);}  
//					  
//					}
//			
//		});
		bt_tim_chuyen_bay.setBounds(28, 204, 134, 23);
		contentPane.add(bt_tim_chuyen_bay);
		
	}
}
