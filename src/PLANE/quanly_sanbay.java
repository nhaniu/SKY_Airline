package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class quanly_sanbay extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_sanbay frame = new quanly_sanbay();
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
	public quanly_sanbay() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 626, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý sân bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(138, 25, 334, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 127, 480, 177);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID sân bay");
		tableModel.addColumn("Tên sân bay");

		
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			String search="select * from SANBAY";					
	
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String ID =rs.getString(1);
				String tensanbay =rs.getString(2);
				
				
				tableModel.addRow(new Object[] {ID, tensanbay});

				table.setModel(tableModel);
			

			}
			
			con.close();

			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		
		
		
		JButton btnNewButton_1 = new JButton("Refresh ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					while(tableModel.getRowCount() > 0) 
						{									
							tableModel.removeRow(0);
						}
					String search="select * from SANBAY";					
			
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String tensanbay =rs.getString(2);
						
						
						tableModel.addRow(new Object[] {ID, tensanbay});

						table.setModel(tableModel);					

					}
					
					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(402, 371, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sân bay:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 438, 136, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(138, 442, 220, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		lblNewLabel_1.setVisible(false);
		textField.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Xác nhận");
		
		btnNewButton_2.setBackground(new Color(255, 255, 224));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(422, 443, 116, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);

		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_1.setVisible(true);
				btnNewButton_2.setVisible(true);
				textField.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(91, 370, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 623, 523);
		contentPane.add(lblNewLabel_2);
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_2.setIcon(scaleIcon);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");

					java.sql.Statement stmt = con.createStatement();

					ResultSet rs6=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from SANBAY");  						
					rs6.next();
					System.out.println(rs6.getString("MAX(ID)"));
					int idsb=10000;
					if(rs6.getString("MAX(ID)")==null) {
						idsb=10000;
					}
					else 
					{
						idsb = Integer.valueOf(rs6.getString("MAX(ID)"));
						idsb++;
					}


					PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"SANBAY\"  (\"ID\", \"TENSANBAY\") values("+idsb+",'"+textField.getText()+"')");		
					pst.execute();				
					pst.close();
					Component a=null;
					JOptionPane.showMessageDialog(a, "Đã thêm thành công");

					
					con.close();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}
