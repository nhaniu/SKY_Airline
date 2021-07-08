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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Capnhat_hangve_giave extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	Connection con;
	private JTable table;
	private JTextField textField_gia;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Capnhat_hangve_giave frame = new Capnhat_hangve_giave();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Capnhat_hangve_giave() {
		init();
		loadCombobox1();

		loadCombobox();
	}

	public void loadCombobox() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select ID from CHUYENBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select distinct TENHV from HANGVE  ");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_1.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	/**
	 * Create the frame.
	 */
	public void init() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 637, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật thông tin hạng vé");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(135, 23, 387, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chuyến bay:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 110, 126, 23);
		contentPane.add(lblNewLabel_1);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(145, 111, 96, 23);
		contentPane.add(comboBox);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 166, 410, 91);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();

				String id= model.getValueAt(SelectedRows, 0).toString();
				String ten =model.getValueAt(SelectedRows, 1).toString();
				String gia= model.getValueAt(SelectedRows, 2).toString();
				String idcb= model.getValueAt(SelectedRows, 3).toString();
						
				comboBox.setSelectedItem(idcb);
				textField_gia.setText(gia);
				comboBox_1.setSelectedItem(ten);

			}
		});
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();

		tableModel.addColumn("ID");
		tableModel.addColumn("Tên hạng vé");
		tableModel.addColumn("Giá vé");
		tableModel.addColumn("ID chuyến bay");


		
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					String search="select * from HANGVE WHERE CHUYENBAY_ID="+comboBox.getSelectedItem()+"";					
			
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
						String ID =rs.getString(1);
						String tenhangve =rs.getString(2);
						String gia =rs.getString(3);
						String idcb =rs.getString(4);
						
						tableModel.addRow(new Object[] {ID, tenhangve,gia,idcb});

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
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(460, 110, 126, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textField_gia.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập giá hạng vé");
					 textField_gia.requestFocus();
					 return; 
					}				
				try {
					dangnhap_quanly dn=null;
					System.out.println("ten dang nhap: "+dn.tendn);
					
					String nv="SELECT ID FROM NGUOIQUANLY WHERE PHONGBAN='Quản Lí Chuyến Bay' and TENDANGNHAP='"+dn.tendn+"'";
					Statement st=(Statement) ((java.sql.Connection) con).createStatement();  	

					ResultSet rsn= st.executeQuery(nv);
					if(rsn.next()) {
						
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						
						Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  	
						ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from HANGVE");  						
						rs.next();
	
						System.out.println(rs.getString("MAX(ID)"));
						int idhv=9000;
						if(rs.getString("MAX(ID)")==null) {
							idhv=9000;
						}
						else 
						{
							idhv = Integer.valueOf(rs.getString("MAX(ID)"));
							idhv++;
						}
						
						ResultSet rs1=((java.sql.Statement) stmt).executeQuery("select TENHV from HANGVE WHERE CHUYENBAY_ID="+comboBox.getSelectedItem()+" and TENHV='"+comboBox_1.getSelectedItem()+"'");  						
						rs1.next();
						String tenhv =rs1.getString(1);
	
						if(comboBox_1.getSelectedItem().equals(tenhv)) {
							JOptionPane.showMessageDialog(null, "hạng vé của chuyến bay đã tồn tại");
						}
						else {
						
						 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"HANGVE\"  (\"ID\", \"TENHV\", \"GIA\",\"CHUYENBAY_ID\") values("+idhv+",'"+comboBox_1.getSelectedItem()+"',"+textField_gia.getText()+",'"+comboBox.getSelectedItem()+"')");		
						pst.execute();				
						pst.close();
						Component a=null;
						JOptionPane.showMessageDialog(a, "Đã thêm thành công");
						
						}						
					}
					else {
						JOptionPane.showMessageDialog(null, "Bạn không thuộc nhiệm vụ này");
					}
					
				}
					 catch (ClassNotFoundException e1) {
						} catch (SQLException e1) {
						}
				
				
			}
				
			
			
		});
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(460, 176, 126, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cập nhật");
		btnNewButton_2.setBackground(new Color(255, 255, 224));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				
				
				
				if(SelectedRows==-1) {
					JOptionPane.showMessageDialog(null, "Chọn thông tin hạng vé cần cập nhật");
				}
				else {
				
				String id= model.getValueAt(SelectedRows, 0).toString();
	

				if (textField_gia.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập giá dịch vụ");
					 textField_gia.requestFocus();
					 return; 
					}
			
				try {
					dangnhap_quanly dn=null;
					System.out.println("ten dang nhap: "+dn.tendn);
					
					String nv="SELECT ID FROM NGUOIQUANLY WHERE PHONGBAN='Quản Lí Chuyến Bay' and TENDANGNHAP='"+dn.tendn+"'";
					Statement st=(Statement) ((java.sql.Connection) con).createStatement();  	

					ResultSet rsn= st.executeQuery(nv);
					if(rsn.next()) {
					
						String update ="update HANGVE set TENHV='"+comboBox_1.getSelectedItem()+"',GIA="+textField_gia.getText()+", CHUYENBAY_ID="+comboBox.getSelectedItem()+" where ID="+id+"";
						Class.forName("oracle.jdbc.OracleDriver");
						java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
						PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
						pst= DB_AIRLINE.prepareStatement(update);
						pst.execute();
		
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						pst.close();
						DB_AIRLINE.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Bạn không thuộc nhiệm vụ này");
					}
					
				} catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
	
				}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(456, 239, 132, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Tên hạng vé:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 299, 102, 23);
		contentPane.add(lblNewLabel_2);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setBounds(145, 300, 198, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Giá vé:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(23, 350, 102, 23);
		contentPane.add(lblNewLabel_3);
		
		textField_gia = new JTextField();
		textField_gia.setBounds(145, 353, 198, 20);
		contentPane.add(textField_gia);
		textField_gia.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 0, 623, 448);
		contentPane.add(lblNewLabel_4);

		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_4.setIcon(scaleIcon);
		
		
	}
}
