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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Quanly_Hoanve extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_iddatve;
	private JTextField textField_idnhanvien;
	private JTextField textField_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_Hoanve frame = new Quanly_Hoanve();
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
	public Quanly_Hoanve() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 728, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý hoàn vé");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 11, 362, 39);
		contentPane.add(lblNewLabel);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(10, 299, 675, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(427, 69, 126, 22);
		panel.add(comboBox);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đã hoàn", "Đã thanh toán", "Chưa thanh toán"}));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 75, 646, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("ID đặt vé");
		tableModel.addColumn("Lí do");
		tableModel.addColumn("Ngày hoàn");
		tableModel.addColumn("Phí hoàn");
		tableModel.addColumn("Tiền hoàn");
		tableModel.addColumn("ID nhân viên");
		tableModel.addColumn("Tình trạng");


		//table.setVisible(false);

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JButton bt_capnhat = new JButton("Cập nhật ");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null, "Chọn vé cần cập nhật");
				}
				
				textField_id.setText(model.getValueAt(i, 0).toString());
				textField_iddatve.setText(model.getValueAt(i, 1).toString());
				textField_idnhanvien.setText(model.getValueAt(i, 6).toString());
				comboBox.setSelectedItem(model.getValueAt(i, 7).toString());

				
				panel.setVisible(true);
			}
		});
		bt_capnhat.setBackground(new Color(255, 255, 224));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(526, 250, 104, 29);
		contentPane.add(bt_capnhat);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID đặt vé:");
		lblNewLabel_1.setBounds(313, 22, 93, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textField_iddatve = new JTextField();
		textField_iddatve.setBounds(425, 26, 104, 22);
		panel.add(textField_iddatve);
		textField_iddatve.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID nhân viên:");
		lblNewLabel_3.setBounds(20, 69, 104, 22);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textField_idnhanvien = new JTextField();
		textField_idnhanvien.setBounds(119, 70, 104, 22);
		panel.add(textField_idnhanvien);
		textField_idnhanvien.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tình trạng:");
		lblNewLabel_2.setBounds(312, 69, 86, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
	
		textField_id = new JTextField();
		textField_id.setBounds(119, 26, 104, 22);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		try {			
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		Statement st=con.createStatement(); 
		String search="select HV.ID, HV.DATVEBAY_ID, HV.LIDO,HV.NGAYHOAN,HV.PHIHV,HV.TIENHV,HV.NHANVIEN_ID, DV.TINHTRANG from HOANVEBAY HV, DATVEBAY DV WHERE HV.DATVEBAY_ID=DV.ID";					
		
		while(tableModel.getRowCount() > 0) 
		{									
			tableModel.removeRow(0);
		}
		
		ResultSet rs1= st.executeQuery(search);
		while(rs1.next()) {
			String id =rs1.getString(1);
			String id_datve =rs1.getString(2);
			String lido =rs1.getString(3);
			String ngayhoanve =rs1.getString(4);
			String phihoan =rs1.getString(5);
			String tienhoanve =rs1.getString(6);
			String idnhanvien =rs1.getString(7);
			String tinhtrang =rs1.getString(8);


			
			System.out.println(id+" "+id_datve+" "+lido+" "+ ngayhoanve+" "+phihoan+" "+tienhoanve+" "+tinhtrang);									
			tableModel.addRow(new Object[] {id, id_datve, lido, ngayhoanve,phihoan,tienhoanve,idnhanvien,tinhtrang});

			table.setModel(tableModel);
			table.setVisible(true);
			scrollPane.setVisible(true);

		}
		rs1.close();				
		con.close();
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		JButton bt_xacnhan = new JButton("Xác nhận");
		bt_xacnhan.setBackground(new Color(255, 255, 224));
		bt_xacnhan.setBounds(522, 114, 104, 27);
		panel.add(bt_xacnhan);
		bt_xacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String update ="update HOANVEBAY set DATVEBAY_ID= "+textField_iddatve.getText()+",NHANVIEN_ID="+textField_idnhanvien.getText()+" where ID="+textField_id.getText()+"";
					String update1 ="update DATVEBAY set TINHTRANG='"+comboBox.getSelectedItem()+"' where ID="+textField_iddatve.getText()+"";

					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = con.prepareStatement(update);
					pst= con.prepareStatement(update);
					pst.execute();
					
					PreparedStatement pst1 = con.prepareStatement(update1);
					pst1= con.prepareStatement(update1);
					pst1.execute();
	
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					pst.close();
					
					Statement st=con.createStatement(); 
					String search="select HV.ID, HV.DATVEBAY_ID, HV.LIDO,HV.NGAYHOAN,HV.PHIHV,HV.TIENHV,HV.NHANVIEN_ID, DV.TINHTRANG from HOANVEBAY HV, DATVEBAY DV WHERE HV.DATVEBAY_ID=DV.ID";					
					
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs1= st.executeQuery(search);
					while(rs1.next()) {
						String id =rs1.getString(1);
						String id_datve =rs1.getString(2);
						String lido =rs1.getString(3);
						String ngayhoanve =rs1.getString(4);
						String phihoan =rs1.getString(5);
						String tienhoanve =rs1.getString(6);
						String idnhanvien =rs1.getString(7);
						String tinhtrang =rs1.getString(8);


						
						System.out.println(id+" "+id_datve+" "+lido+" "+ ngayhoanve+" "+phihoan+" "+tienhoanve+" "+tinhtrang);									
						tableModel.addRow(new Object[] {id, id_datve, lido, ngayhoanve,phihoan,tienhoanve,idnhanvien,tinhtrang});
					}
					con.close();


				} catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
	
				}
			}
		});
		bt_xacnhan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(23, 25, 86, 22);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 56, 679, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel_5.setBounds(0, 0, 726, 473);
		contentPane.add(lblNewLabel_5);

	}
}
