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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
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

public class timkiemtaikhoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiemtaikhoan frame = new timkiemtaikhoan();
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
	public timkiemtaikhoan() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 892, 332);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm tài khoản");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(251, 11, 403, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 858, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID tài khoản:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 67, 115, 22);
		contentPane.add(lblNewLabel_1);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_id.setBounds(191, 68, 131, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("(ví dụ: 401)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(367, 70, 91, 17);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 162, 838, 40);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);
		final DefaultTableModel model=new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("Tên đăng nhập");
		model.addColumn("Mật khẩu");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("SDT");
		model.addColumn("Email");
		model.addColumn("Tổng tiền mua vé");
		model.addColumn("Điểm");
		model.addColumn("Hạng");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (textField_id.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã tài khoản");
						 textField_id.requestFocus();
						 return; 
						}
					
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select* from TAIKHOAN where ID="+textField_id.getText()+" ";					
										
					while(model.getRowCount() > 0) 
					{									
						model.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
						if(rs.next()) {
							String ID =rs.getString(1);
							String tendn =rs.getString(2);
							String mk =rs.getString(3);
							String ngaybd =rs.getString(4);							
							String sdt =rs.getString(5);
							String email =rs.getString(6);
							String tongtien =rs.getString(7);
							String diem =rs.getString(8);
							String hang =rs.getString(9);
												
						model.addRow(new Object[] {ID,tendn,mk,ngaybd,sdt,email,tongtien,diem,hang});

						table.setModel(model);
						scrollPane.setVisible(true);
						table.setVisible(true);
				
						
					}
						else {
							JOptionPane.showMessageDialog(null, "Không tìm thấy tài khoản");
						}
					con.close();
					
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				}
		});
		bt_timkiem.setBackground(new Color(135, 206, 250));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(669, 68, 131, 21);
		contentPane.add(bt_timkiem);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(-11, 0, 909, 408);
		contentPane.add(lblNewLabel_3);
		
		ImageIcon icon=new ImageIcon("563774.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_3.setIcon(scaleIcon);
		
	}
}
