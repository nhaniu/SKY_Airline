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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class quanly_changdung extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_changdung frame = new quanly_changdung();
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
	public quanly_changdung() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 844, 499);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý chặng dừng");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(185, 6, 451, 43);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 810, 15);
		contentPane.add(separator);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 144, 773, 182);
		contentPane.add(scrollPane);
		
		table = new JTable();
		//table.setEditingRow(0);
		scrollPane.setViewportView(table);
		
		
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Sân bay đi");
		tableModel.addColumn("Sân bay đến");
		tableModel.addColumn("Địa điểm dừng");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		Theader.setBackground(new Color(135, 206, 250));
		
		table.setVisible(false);
		scrollPane.setVisible(false);

		
		
		JButton bt_them = new JButton("Thêm chặng dừng");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_changdung();
			}
		});
		bt_them.setBackground(new Color(255, 255, 224));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(91, 386, 163, 29);
		contentPane.add(bt_them);
		
		JButton bt_xoa = new JButton("Xóa chặng dừng");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model =(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn chặng dừng cần xóa");
				}
				
				try {	
						int id=Integer.parseInt(model.getValueAt(SelectedRows, 0).toString());
						int deleteItem =JOptionPane.showConfirmDialog(null, "Xác nhận nếu bạn muốn xóa","Warning",JOptionPane.YES_NO_OPTION);
						if(deleteItem==JOptionPane.YES_OPTION) {
												
					

																											
							Class.forName("oracle.jdbc.OracleDriver");
							java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","1");  		
							PreparedStatement pst = DB_AIRLINE.prepareStatement("delete from CHANGDUNG where ID=?");
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
		bt_xoa.setBounds(568, 388, 146, 25);
		contentPane.add(bt_xoa);
		bt_them.setVisible(false);
		bt_xoa.setVisible(false);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			

			String search="select * from CHANGDUNG";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String ID =rs.getString(1);
				String sanbaydi =rs.getString(2);
				String sanbayden =rs.getString(3);
				String diadiemdung =rs.getString(4);					
				
				tableModel.addRow(new Object[] {ID,sanbaydi,sanbayden,diadiemdung});
				table.setModel(tableModel);
				table.setVisible(true);
				scrollPane.setVisible(true);
				bt_them.setVisible(true);
				bt_xoa.setVisible(true);

			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel.setBounds(0, 0, 830, 476);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
	}
}
