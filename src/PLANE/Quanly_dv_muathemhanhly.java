package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Quanly_dv_muathemhanhly extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_dv_muathemhanhly frame = new Quanly_dv_muathemhanhly();
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
	public Quanly_dv_muathemhanhly() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 526, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý dịch vụ bổ trợ");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(98, 19, 302, 48);
		contentPane.add(lb_title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 475, 155);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Nội dung");
		tableModel.addColumn("Giá tiền");
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		table.setVisible(false);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setVisible(false);
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_dvbt();
			
			}
		});
		bt_them.setBackground(new Color(255, 255, 224));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(62, 313, 99, 23);
		contentPane.add(bt_them);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 67, 452, 2);
		contentPane.add(separator);
		

		
		JButton bt_sua = new JButton("Cập nhật");
		bt_sua.setVisible(false);
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				System.out.println(SelectedRows);
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn dịch vụ cần cập nhật");
				}
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String noidung =model.getValueAt(SelectedRows, 1).toString();
				String gia= model.getValueAt(SelectedRows, 2).toString();
				

				update_dvbt update= new update_dvbt(id,noidung,gia);
				update.setVisible(true);
			}
		});
		bt_sua.setBackground(new Color(255, 255, 224));
		bt_sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_sua.setBounds(234, 313, 99, 23);
		contentPane.add(bt_sua);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			


			String search="select * from DICHVUBOTRO";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String ID =rs.getString(1);
				String noidung =rs.getString(2);
				String giatien =rs.getString(3);
				
		
				

				
				tableModel.addRow(new Object[] {ID,noidung,giatien});

				table.setModel(tableModel);
				scrollPane.setVisible(true);
				bt_them.setVisible(true);
				bt_sua.setVisible(true);
				table.setVisible(true);

			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	
		JButton btnNewButton = new JButton("Refresh ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					


					String search="select * from DICHVUBOTRO";				
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String noidung =rs.getString(2);
						String giatien =rs.getString(3);
						
				
						

						
						tableModel.addRow(new Object[] {ID,noidung,giatien});

						table.setModel(tableModel);


					}
					
					con.close();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(378, 314, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel.setBounds(0, 0, 526, 385);
		contentPane.add(lblNewLabel);
		
	
		
		
	}
}
