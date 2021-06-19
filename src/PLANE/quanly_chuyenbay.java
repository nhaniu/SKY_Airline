package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class quanly_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_ID;
	private JTextField textField_IDmb;
	private JTextField textField_tongsove;
	private JTextField textField_ID_NQL;
	private JComboBox comboBox_noidi;
	private JComboBox comboBox_noiden;
	private JDateChooser dateChooser_kh;
	private JDateChooser dateChooser_hc;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_chuyenbay frame = new quanly_chuyenbay();
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
	public quanly_chuyenbay() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 1075, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(397, 15, 306, 34);
		contentPane.add(lb_title);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 136, 1041, 200);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setEditingRow(0);
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

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_chuyenbay();
				
			}
		});
		bt_them.setBackground(new Color(255, 255, 224));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(256, 398, 102, 23);
		contentPane.add(bt_them);
		bt_them.setVisible(false);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiem_chuyenbay();
			}
		});
		bt_timkiem.setBackground(new Color(255, 255, 224));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(56, 398, 102, 23);
		contentPane.add(bt_timkiem);
		bt_timkiem.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 1027, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 368, 1051, 2);
		contentPane.add(separator_1);
		
		
		JButton bt_sua = new JButton("Cập nhật");
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn chuyến bay cần cập nhật");
				}
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String idmb =model.getValueAt(SelectedRows, 1).toString();
				String sanbaydi= model.getValueAt(SelectedRows, 2).toString();
				String sanbayden= model.getValueAt(SelectedRows, 3).toString();
				String ngaykh=model.getValueAt( SelectedRows, 4).toString();
				String ngayhc=model.getValueAt( SelectedRows, 5).toString();
				
				String tg1 = ngaykh.substring(0, 10);
				String tg2 = ngayhc.substring(0, 10);
				System.out.println(tg1);
				System.out.println(tg2);
								
				String tongsove= model.getValueAt(SelectedRows, 6).toString();
				String idnql= model.getValueAt(SelectedRows, 7).toString();
				
				update_chuyenbay update= new update_chuyenbay(id, idmb, sanbaydi, sanbayden, tg1, tg2, tongsove, idnql);
				update.setVisible(true);
				
				
			}
		});
		
		
		bt_sua.setBackground(new Color(255, 255, 224));
		bt_sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_sua.setBounds(450, 398, 102, 23);
		contentPane.add(bt_sua);
		bt_sua.setVisible(false);
		
		JButton bt_xoa = new JButton("Xóa");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn chuyến bay cần xóa");
				}
				try {	
						int id=Integer.parseInt(model.getValueAt(SelectedRows, 0).toString());
						int deleteItem =JOptionPane.showConfirmDialog(null, "Xác nhận nếu bạn muốn xóa","Warning",JOptionPane.YES_NO_OPTION);
						if(deleteItem==JOptionPane.YES_OPTION) {
																											
							Class.forName("oracle.jdbc.OracleDriver");
							java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
							PreparedStatement pst = DB_AIRLINE.prepareStatement("delete from CHUYENBAY where ID=?");
							pst.setInt(1, id);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Xóa thành công");
						
						
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		bt_xoa.setBackground(new Color(255, 255, 224));
		bt_xoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_xoa.setBounds(676, 398, 89, 23);
		contentPane.add(bt_xoa);
		bt_xoa.setVisible(false);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			String search="select * from CHUYENBAY";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String ID =rs.getString(1);
				String ttmaybayid =rs.getString(2);
				String sanbaydi =rs.getString(3);
				String sanbayden =rs.getString(4);
				String ngaygiokh =rs.getString(5);
				String ngaygiohc =rs.getString(6);
				String tongsove=rs.getString(7);
				String ID_NQL =rs.getString(8);

				tableModel.addRow(new Object[] {ID,ttmaybayid,sanbaydi,sanbayden,ngaygiokh,ngaygiohc,tongsove,ID_NQL});

				table.setModel(tableModel);
				scrollPane.setVisible(true);
				bt_them.setVisible(true);
				bt_sua.setVisible(true);
				bt_timkiem.setVisible(true);
				bt_xoa.setVisible(true);
			}			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		scrollPane.setVisible(true);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			


			String search="select * from CHUYENBAY";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String ID =rs.getString(1);
				String ttmaybayid =rs.getString(2);
				String sanbaydi =rs.getString(3);
				String sanbayden =rs.getString(4);
				String ngaygiokh =rs.getString(5);
				String ngaygiohc =rs.getString(6);
				String tongsove=rs.getString(7);
				String ID_NQL =rs.getString(8);
				
				
				tableModel.addRow(new Object[] {ID,ttmaybayid,sanbaydi,sanbayden,ngaygiokh,ngaygiohc,tongsove,ID_NQL});

				table.setModel(tableModel);
				scrollPane.setVisible(true);
				bt_them.setVisible(true);
				bt_sua.setVisible(true);
				bt_timkiem.setVisible(true);
				bt_xoa.setVisible(true);
			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}					
		JButton bt_hienthidanhsachchuyenbay = new JButton("Hiển thị danh sách chuyến bay");
		bt_hienthidanhsachchuyenbay.setBackground(new Color(255, 255, 224));
		bt_hienthidanhsachchuyenbay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scrollPane.setVisible(true);
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					


					String search="select * from CHUYENBAY";				
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String ttmaybayid =rs.getString(2);
						String sanbaydi =rs.getString(3);
						String sanbayden =rs.getString(4);
						String ngaygiokh =rs.getString(5);
						String ngaygiohc =rs.getString(6);
						String tongsove=rs.getString(7);
						String ID_NQL =rs.getString(8);
						
						//System.out.print(ID_NQL+sovetrong+sovedat+sovedat+tongsove+sanbayden+ngaygiohc+ngaygiokh+sanbaydi+ttmaybayid+ID+"\n");
						
						tableModel.addRow(new Object[] {ID,ttmaybayid,sanbaydi,sanbayden,ngaygiokh,ngaygiohc,tongsove,ID_NQL});

						table.setModel(tableModel);
						scrollPane.setVisible(true);
						bt_them.setVisible(true);
						bt_sua.setVisible(true);
						bt_timkiem.setVisible(true);
						bt_xoa.setVisible(true);
					}
					
					con.close();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}					
			}
		});
		bt_hienthidanhsachchuyenbay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_hienthidanhsachchuyenbay.setBounds(740, 94, 244, 28);
		contentPane.add(bt_hienthidanhsachchuyenbay);
		
		JButton bt_thongke = new JButton("Thống kê");
		bt_thongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new thongke_chuyenbay();
				
			}
		});
		bt_thongke.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thongke.setBackground(new Color(255, 255, 224));
		bt_thongke.setBounds(870, 399, 114, 23);
		contentPane.add(bt_thongke);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel.setBounds(10, 0, 1051, 461);
		contentPane.add(lblNewLabel);
	}
}
