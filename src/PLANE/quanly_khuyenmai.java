package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class quanly_khuyenmai extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_slkm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_khuyenmai frame = new quanly_khuyenmai();
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
	public quanly_khuyenmai() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 870, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkm = new JLabel("Quản lý khuyến mãi");
		lb_ttkm.setBackground(new Color(218, 165, 32));
		lb_ttkm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ttkm.setBounds(279, 11, 272, 50);
		contentPane.add(lb_ttkm);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setVisible(false);
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_khuyenmai();
			}
		});
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBackground(new Color(255, 255, 224));
		bt_them.setBounds(120, 386, 102, 23);
		contentPane.add(bt_them);
		bt_them.setVisible(false);
		
		JButton bt_xoa = new JButton("Xóa");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn khuyến mãi cần xóa");
				}
				try {	
						int id=Integer.parseInt(model.getValueAt(SelectedRows, 0).toString());
						int deleteItem =JOptionPane.showConfirmDialog(null, "Xác nhận nếu bạn muốn xóa","Warning",JOptionPane.YES_NO_OPTION);
						if(deleteItem==JOptionPane.YES_OPTION) {																	

							Class.forName("oracle.jdbc.OracleDriver");
							java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
							PreparedStatement pst = DB_AIRLINE.prepareStatement("delete from BKHUYENMAI where ID=?");
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
		bt_xoa.setBounds(555, 386, 102, 23);
		contentPane.add(bt_xoa);
		bt_xoa.setVisible(false);
		

		JLabel lblNewLabel_1 = new JLabel("Số lượng khuyến mãi đã dùng:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(41, 334, 220, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_slkm = new JTextField();
		textField_slkm.setEditable(false);
		textField_slkm.setBounds(279, 335, 60, 23);
		contentPane.add(textField_slkm);
		textField_slkm.setColumns(10);
		

		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn thông tin khuyến mãi cần cập nhật");
				}
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String ngaybt =model.getValueAt(SelectedRows, 1).toString();
				String ngaykt= model.getValueAt(SelectedRows, 2).toString();
				String noidung= model.getValueAt(SelectedRows, 3).toString();
				String phantram=model.getValueAt( SelectedRows, 4).toString();
				
				String tg1 = ngaybt.substring(0, 10);
				String tg2 = ngaykt.substring(0, 10);
				System.out.println(tg1);
				System.out.println(tg2);
							
				update_khuyenmai update= new update_khuyenmai(id, tg1, tg2, noidung, phantram);
				update.setVisible(true);
				
				
			}
		});
		
		bt_capnhat.setBackground(new Color(255, 255, 224));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(327, 386, 121, 23);
		contentPane.add(bt_capnhat);
		bt_capnhat.setVisible(false);

		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 72, 807, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 116, 773, 184);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
	
		
		table = new JTable();
	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn thông tin khuyến mãi cần cập nhật");
				}
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String ngaybt =model.getValueAt(SelectedRows, 1).toString();
				String ngaykt= model.getValueAt(SelectedRows, 2).toString();
				String noidung= model.getValueAt(SelectedRows, 3).toString();
				String phantram=model.getValueAt( SelectedRows, 4).toString();
				
				String tg1 = ngaybt.substring(0, 10);
				String tg2 = ngaykt.substring(0, 10);
				System.out.println(tg1);
				System.out.println(tg2);
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					String search="SELECT COUNT(DV.KHUYENMAI_ID)\r\n"
							+ "FROM BKHUYENMAI KM, DATVEBAY DV\r\n"
							+ "WHERE KM.ID=DV.KHUYENMAI_ID AND DV.KHUYENMAI_ID="+id+"";				

					ResultSet rs= st.executeQuery(search);
					if(rs.next()) {
						String sl =rs.getString(1);
						System.out.println(sl);
						textField_slkm.setText(sl);

					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Ngày bắt đầu");
		tableModel.addColumn("Ngày kết thúc");
		tableModel.addColumn("Nội dung");
		tableModel.addColumn("Phần trăm khuyến mãi");
		table.setVisible(false);
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		//Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		Theader.setBackground(new Color(135, 206, 250));
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			

			String search="select* from BKHUYENMAI";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String id =rs.getString(1);
				String ngaybatdau =rs.getString(2);
				String ngayketthuc =rs.getString(3);
				String noidung =rs.getString(4);					
				String phantram =rs.getString(5);					

				
				tableModel.addRow(new Object[] {id,ngaybatdau,ngayketthuc,noidung,phantram});
				table.setModel(tableModel);
				table.setVisible(true);
				scrollPane.setVisible(true);
				bt_them.setVisible(true);
				bt_xoa.setVisible(true);
				bt_capnhat.setVisible(true);
				

			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		JButton btnNewButton = new JButton("Refresh ");
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					

					String search="select* from BKHUYENMAI";				
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String id =rs.getString(1);
						String ngaybatdau =rs.getString(2);
						String ngayketthuc =rs.getString(3);
						String noidung =rs.getString(4);					
						String phantram =rs.getString(5);					

						
						tableModel.addRow(new Object[] {id,ngaybatdau,ngayketthuc,noidung,phantram});
						table.setModel(tableModel);
						table.setVisible(true);
						scrollPane.setVisible(true);
						bt_them.setVisible(true);
						bt_xoa.setVisible(true);
						bt_capnhat.setVisible(true);
						

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
		btnNewButton.setBounds(724, 386, 107, 23);
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel.setBounds(-16, 0, 888, 457);
		contentPane.add(lblNewLabel);
	}
}
