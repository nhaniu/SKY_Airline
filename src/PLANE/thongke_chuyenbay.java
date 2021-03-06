package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class thongke_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongke_chuyenbay frame = new thongke_chuyenbay();
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
	public thongke_chuyenbay() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 636, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê chuyến bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(71, 11, 492, 30);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 41, 607, 11);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 602, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("ID chuyến bay");
		tableModel.addColumn("Thời gian");
		tableModel.addColumn("Số lượng vé còn");
		tableModel.addColumn("Số lượng vé bán");
		tableModel.addColumn("ID người quản lý");

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nguyen thi nhan\\Downloads\\488401.jpg"));
		lblNewLabel_1.setBounds(0, 0, 638, 306);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon=new ImageIcon("anh.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_1.setIcon(scaleIcon);
		quanly_chuyenbay ql=null;


		if(ql.kt==1) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				Statement st=con.createStatement(); 
				


				String search="Select TK.ID, TK.CHUYENBAY_ID, CB.NGAY_GIO_KH, TK.SOLUONGVECON, TK.SOLUONGVEBAN, TK.NGUOIQUANLY_ID\r\n"
						+ "from THONGKECHUYENBAY TK, CHUYENBAY CB\r\n"
						+ "WHERE TK.CHUYENBAY_ID=CB.ID and NGAY_GIO_KH>="+ql.thoigian+" and  NGAY_GIO_KH<"+ql.thoigian1+" ";				
				while(tableModel.getRowCount() > 0) 
				{									
					tableModel.removeRow(0);
				}
				
				ResultSet rs= st.executeQuery(search);
				while(rs.next()) {
					String ID =rs.getString(1);
					String id_cb =rs.getString(2);
					String thoigian =rs.getString(3);
					String slvecon =rs.getString(4);
					String slveban =rs.getString(5);
					String ID_NQL =rs.getString(6);

								
					tableModel.addRow(new Object[] {ID,id_cb,thoigian,slvecon,slveban,ID_NQL});

					table.setModel(tableModel);

				}
				
				con.close();
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(ql.kt==2) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				Statement st=con.createStatement(); 
				


				String search="Select TK.ID, TK.CHUYENBAY_ID, CB.NGAY_GIO_KH, TK.SOLUONGVECON, TK.SOLUONGVEBAN, TK.NGUOIQUANLY_ID\r\n"
						+ "from THONGKECHUYENBAY TK, CHUYENBAY CB\r\n"
						+ "WHERE TK.CHUYENBAY_ID=CB.ID and NGAY_GIO_KH>="+ql.thoigian+" and  NGAY_GIO_KH<"+ql.thoigian1+" ";				
				while(tableModel.getRowCount() > 0) 
				{									
					tableModel.removeRow(0);
				}
				
				ResultSet rs= st.executeQuery(search);
				while(rs.next()) {
					String ID =rs.getString(1);
					String id_cb =rs.getString(2);
					String thoigian =rs.getString(3);
					String slvecon =rs.getString(4);
					String slveban =rs.getString(5);
					String ID_NQL =rs.getString(6);

								
					tableModel.addRow(new Object[] {ID,id_cb,thoigian,slvecon,slveban,ID_NQL});

					table.setModel(tableModel);

				}
				
				con.close();
				
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		
	}
}
