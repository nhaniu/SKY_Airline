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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class timkiem_datve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_maDV;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiem_datve frame = new timkiem_datve();
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
	public timkiem_datve() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 789, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm đặt vé máy bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(173, 11, 389, 42);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 730, 14);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Mã đặt vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 107, 94, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_maDV = new JTextField();
		textField_maDV.setBounds(146, 112, 144, 20);
		contentPane.add(textField_maDV);
		textField_maDV.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("(Ví dụ: 1001)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(312, 107, 104, 28);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 188, 713, 40);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		table = new JTable();
		final DefaultTableModel model=new DefaultTableModel();
		table.setVisible(false);
		
		model.addColumn("ID");
		model.addColumn("ID vé máy bay ");
		model.addColumn("ID hành khách");
		model.addColumn("ID khuyến mãi");
		model.addColumn("ID dịch vụ bổ trợ");
		model.addColumn("Ngày đặt");
		model.addColumn("Tổng tiền");
		model.addColumn("Tình trạng");
		model.addColumn("Tài khoản ID");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(135, 206, 250));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(528, 289, 104, 23);
		contentPane.add(bt_thoat);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					if (textField_maDV.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã chuyến bay");
						 textField_maDV.requestFocus();
						 return; 
						}
					
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select* from DATVEBAY where ID="+textField_maDV.getText()+" ";					
										
					while(model.getRowCount() > 0) 
					{									
						model.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String vemaybayid =rs.getString(2);
						String hanhkhachid =rs.getString(3);
						String khuyenmaiid =rs.getString(4);
						String dvbtid =rs.getString(5);
						String ngaydat =rs.getString(6);
						String tongtien =rs.getString(7);
						String tinhtrang =rs.getString(8);
						String taikhoanid =rs.getString(9);

						
						System.out.print(ID+vemaybayid+hanhkhachid+khuyenmaiid+dvbtid+ngaydat+tongtien+tinhtrang+taikhoanid+"\n");
						
						model.addRow(new Object[] {ID,vemaybayid,hanhkhachid,khuyenmaiid,dvbtid,ngaydat,tongtien,tinhtrang,taikhoanid});

						table.setModel(model);
						scrollPane.setVisible(true);
						bt_timkiem.setVisible(true);
						table.setVisible(true);

					}
					
					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			
			}
				
			
		});
		bt_timkiem.setBackground(new Color(135, 206, 250));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(558, 111, 122, 23);
		contentPane.add(bt_timkiem);
	}
}
