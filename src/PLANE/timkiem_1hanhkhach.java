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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class timkiem_1hanhkhach extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiem_1hanhkhach frame = new timkiem_1hanhkhach();
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
	public timkiem_1hanhkhach() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 653, 364);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm hành khách");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(177, 26, 301, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID đặt vé: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 114, 111, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(158, 118, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(395, 117, 128, 24);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 221, 523, 40);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		
		table.setBackground(new Color(255, 255, 255));
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Họ tên");
		tableModel.addColumn("Ngày sinh");
		tableModel.addColumn("Quốc tịch");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("SĐT");
		tableModel.addColumn("Email");
		tableModel.addColumn("Tài khoản ID");
		scrollPane.setViewportView(table);


		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 224));
		table.setModel(tableModel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-16, 0, 666, 338);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("anh.jpg"));
		contentPane.add(lblNewLabel_2);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					if (textField.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập ID đặt vé");
						 textField.requestFocus();
						 return; 
						}

					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select hk.ID, hk.HOTEN, hk.NGAYSINH, hk.QUOCTICH, hk.GIOITINH, hk.SDT, hk.EMAIL, hk.TAIKHOAN_ID\r\n"
							+ "from VEMAYBAY v, HANHKHACH hk, DATVEBAY dv, CHUYENBAY cb\r\n"
							+ "where v.CHUYENBAY_ID=cb.ID and v.ID=dv.VEMAYBAY_ID and hk.ID=dv.HANHKHACH_ID and  dv.ID="+textField.getText();// and dv.ID ='\"+textField_MaDC.getText()+\"'";					
										
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					
				
					if(rs.next()) {
						String ID =rs.getString(1);
						String hoten =rs.getString(2);
						String ngaysinh =rs.getString(3);
						String quoctich =rs.getString(4);
						String gioitinh =rs.getString(5);
						String sdt =rs.getString(6);
						String email =rs.getString(7);
						String taikhoanID =rs.getString(8);

						System.out.print(ID+hoten+ngaysinh+quoctich+gioitinh+sdt+email+taikhoanID+"\n");
						
						tableModel.addRow(new Object[] {ID, hoten, ngaysinh,quoctich, gioitinh, sdt, email,taikhoanID});

						table.setModel(tableModel);
						scrollPane.setVisible(true);

					}
					else {
						JOptionPane.showMessageDialog(null, "ID đặt vé không tồn tại");

					}
				
					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
}
