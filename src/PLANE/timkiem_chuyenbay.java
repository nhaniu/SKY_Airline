package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class timkiem_chuyenbay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiem_chuyenbay frame = new timkiem_chuyenbay();
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
	public timkiem_chuyenbay() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 917, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nơi đi");
		lblNewLabel.setBounds(38, 110, 69, 14);
		contentPane.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("Nơi đến:");
		lblNewLabel_1.setBounds(477, 110, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(603, 106, 191, 22);
		contentPane.add(comboBox_noiden);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày đi:");
		lblNewLabel_2.setBounds(38, 164, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	
		dateChooser.setBounds(135, 158, 212, 20);
		contentPane.add(dateChooser);
		
		JComboBox comboBox_noidi=new JComboBox();
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(135, 106, 212, 22);
		contentPane.add(comboBox_noidi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 62, 821, 14);
		contentPane.add(separator);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 238, 793, 119);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm chuyến bay");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(279, 11, 315, 40);
		contentPane.add(lblNewLabel_3);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Thông tin máy bay ID");
		tableModel.addColumn("Sân bay đi");
		tableModel.addColumn("Sân bay đến");
		tableModel.addColumn("Ngày -giờ khởi hành");
		tableModel.addColumn("Ngày-giờ hạ cánh");
		tableModel.addColumn("Tổng số vé");
		tableModel.addColumn("ID người quản lý");

		
		table.setVisible(false);

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
//					String day = new String();
//					String month = new String();
//					String year = new String();
//					
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					String tgString=formatter.format(dateChooser.getDate());
//					day = tgString.substring(8,10);
//					month = tgString.substring(5,7);
//					year = tgString.substring(0,4);
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY");		
					String tgString=formatter.format(dateChooser.getDate());	
					 String thoigian="TO_DATE('"+tgString+"','DD-MM-RR')";
					 String thoigian1="TO_DATE('"+tgString+" 23:59:59','DD-MM-RR HH24:MI:SS')";
					
				//	System.out.println(day+month+year);
					//String search="select *	from CHUYENBAY where SANBAYDI = 'Hà Nội (HAN), Việt Nam' and SANBAYDEN='Tp. Hồ Chí Minh (SGN), Việt Nam' AND and EXTRACT(DAY FROM DATE '2021-01-01'"+"'"+day+"'"+" and EXTRACT(MONTH FROM DATE '2021-01-01'"+"'"+month+"'"+" and EXTRACT(YEAR FROM DATE '2021-01-01'"+"'"+year+"'";			
					String search="select * from CHUYENBAY where SANBAYDI = '"+comboBox_noidi.getSelectedItem()+"' and SANBAYDEN ='"+comboBox_noiden.getSelectedItem()+"' AND NGAY_GIO_KH>="+thoigian+" and  NGAY_GIO_KH<"+thoigian1+"";		
				
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					if(!rs.next()) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến bay");
	

					}
					while(rs.next()) {
						String ID =rs.getString(1);
						String ttmaybayid =rs.getString(2);
						String sanbaydi =rs.getString(3);
						String sanbayden =rs.getString(4);
						String ngaygiokh =rs.getString(5);
						String ngaygiohc =rs.getString(6);
						String tongsove=rs.getString(7);
						String ID_NQL =rs.getString(8);



						

						System.out.print(ID+ttmaybayid+sanbaydi+sanbayden+ngaygiokh+ngaygiohc+tongsove+ID_NQL+"\n");
						
						tableModel.addRow(new Object[] {ID,ttmaybayid,sanbaydi,sanbayden,ngaygiokh,ngaygiohc,tongsove,ID_NQL});

						table.setModel(tableModel);
						scrollPane.setVisible(true);
						table.setVisible(true);
					
					}
					
					
					con.close();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(603, 159, 105, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		//lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\nguyen thi nhan\\Downloads\\444575.jpg"));
		lblNewLabel_4.setBounds(0, 0, 919, 451);
		contentPane.add(lblNewLabel_4);

		ImageIcon icon=new ImageIcon("anh3.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_4.setIcon(scaleIcon);

		
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

	}
}
