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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;

public class quanly_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_maCB;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_ve frame = new quanly_ve();
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
	public quanly_ve() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 728, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý vé máy bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(234, 11, 273, 44);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 704, 2);
		contentPane.add(separator);
		
		JLabel lb_mcb = new JLabel("Mã chuyến bay:");
		lb_mcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mcb.setBounds(39, 127, 160, 19);
		contentPane.add(lb_mcb);
		
		textField_maCB = new JTextField();
		textField_maCB.setBounds(175, 127, 175, 19);
		contentPane.add(textField_maCB);
		textField_maCB.setColumns(10);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiem_ve();
				
			}
		});
		bt_timkiem.setBackground(new Color(255, 255, 224));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(51, 404, 116, 31);
		contentPane.add(bt_timkiem);
		bt_timkiem.setVisible(false);
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				System.out.println(SelectedRows);
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn vé cần cập nhật");
				}
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String idhv =model.getValueAt(SelectedRows, 1).toString();
				String idcb= model.getValueAt(SelectedRows, 2).toString();
				
				System.out.println("trc loi");

				update_ve update= new update_ve(id,idhv,idcb);
				update.setVisible(true);
			}
		});
		bt_capnhat.setBackground(new Color(255, 255, 224));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(519, 404, 107, 31);
		contentPane.add(bt_capnhat);
		bt_capnhat.setVisible(false);
		
		table = new JTable();
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setVisible(false);
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_ve();
			}
		});

	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 208, 626, 135);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
	
		table.setBackground(new Color(255, 255, 255));
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID Vé");
		tableModel.addColumn("ID hạng vé");
		tableModel.addColumn("ID chuyến bay");
		scrollPane.setViewportView(table);
		table.setVisible(false);
		
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (textField_maCB.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã chuyến bay");
						 textField_maCB.requestFocus();
						 return; 
						}
					
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select * from VEMAYBAY where CHUYENBAY_ID="+textField_maCB.getText()+" ";					
										
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String hangveid =rs.getString(2);
						String chuyenbayid =rs.getString(3);
						
						System.out.print(ID+hangveid+chuyenbayid+"\n");
						
						tableModel.addRow(new Object[] {ID, hangveid, chuyenbayid});

						table.setModel(tableModel);
						scrollPane.setVisible(true);
						bt_capnhat.setVisible(true);
						bt_them.setVisible(true);
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
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(499, 125, 127, 23);
		contentPane.add(btnNewButton);
		
		
		bt_them.setBackground(new Color(255, 255, 224));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(294, 404, 116, 31);
		contentPane.add(bt_them);
		
		JLabel lblNewLabel = new JLabel("(Ví dụ: 601)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(360, 128, 116, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel_1.setBounds(0, 0, 727, 474);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
