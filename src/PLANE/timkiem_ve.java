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

public class timkiem_ve extends JFrame {

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
					timkiem_ve frame = new timkiem_ve();
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
	public timkiem_ve() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 652, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã vé:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 100, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm vé máy bay");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(132, 11, 351, 41);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 618, 14);
		contentPane.add(separator);
		
		textField_id = new JTextField();
		textField_id.setBounds(170, 98, 128, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 168, 591, 40);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
		Theader.setBackground(new Color(135, 206, 250));
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					if (textField_id.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã vé");
						 textField_id.requestFocus();
						 return; 
						}
					
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select * from VEMAYBAY where ID="+textField_id.getText();					
										
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					
					if(rs.next()) {
						String ID =rs.getString(1);
						String hangveid =rs.getString(2);
						String chuyenbayid =rs.getString(3);
						
						System.out.print(ID+hangveid+chuyenbayid+"\n");
						
						tableModel.addRow(new Object[] {ID, hangveid, chuyenbayid});

						table.setModel(tableModel);
						scrollPane.setVisible(true);
						table.setVisible(true);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Vé không tồn tại");
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
		bt_timkiem.setBounds(462, 96, 110, 23);
		contentPane.add(bt_timkiem);
		
		JLabel lblNewLabel_2 = new JLabel("(ví dụ: 8001)");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(319, 100, 100, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(-14, 0, 672, 356);
		contentPane.add(lblNewLabel_3);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_3.setIcon(scaleIcon);
	}
}
