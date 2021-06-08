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

public class Quanly_taikhoan extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_taikhoan frame = new Quanly_taikhoan();
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
	public Quanly_taikhoan() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 1073, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 135, 1016, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		
		JLabel lblNewLabel = new JLabel("Quản lý tài khoản");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(392, 11, 325, 36);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 1027, 9);
		contentPane.add(separator);
		table.setVisible(false);
		scrollPane.setVisible(false);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.setVisible(false);
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiemtaikhoan();
			}
		});
		bt_timkiem.setBackground(new Color(135, 206, 250));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(219, 362, 130, 23);
		contentPane.add(bt_timkiem);
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String tendn =model.getValueAt(SelectedRows, 1).toString();
				String matkhau= model.getValueAt(SelectedRows, 2).toString();
				String ngaybd= model.getValueAt(SelectedRows, 3).toString();
				String sdt=model.getValueAt( SelectedRows, 4).toString();
				String email=model.getValueAt( SelectedRows, 5).toString();
				String tongtien=model.getValueAt( SelectedRows, 6).toString();				
				String tg1 = ngaybd.substring(0, 10);
			
				String diem= model.getValueAt(SelectedRows, 7).toString();
				String hang= model.getValueAt(SelectedRows, 8).toString();
				
				update_taikhoan update= new update_taikhoan(id, tendn, matkhau, tg1, sdt, email, tongtien, diem,hang);
				update.setVisible(true);
			}
		});
		bt_capnhat.setVisible(false);
		bt_capnhat.setBackground(new Color(135, 206, 250));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(779, 363, 117, 22);
		contentPane.add(bt_capnhat);
		
		JButton bt_httt = new JButton("Hiển thị danh sách");
		bt_httt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select * from TAIKHOAN ";					
										
					while(model.getRowCount() > 0) 
					{									
						model.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
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
						bt_capnhat.setVisible(true);
						bt_timkiem.setVisible(true);
					}
					rs.close();

					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		bt_httt.setBackground(new Color(135, 206, 250));
		bt_httt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_httt.setBounds(826, 71, 184, 23);
		contentPane.add(bt_httt);
		
	
		
	

	}
}
