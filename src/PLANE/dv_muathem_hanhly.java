package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ButtonGroup;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dv_muathem_hanhly extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaDC;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	public dv_muathem_hanhly() {
		initcomponents();
		//isCellEditable(ERROR, ABORT);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dv_muathem_hanhly frame = new dv_muathem_hanhly();
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
	public void initcomponents() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 819, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_MaDC = new JLabel("Mã đặt vé:");
		lb_MaDC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_MaDC.setBounds(41, 279, 99, 22);
		contentPane.add(lb_MaDC);
		
		JLabel lb_title = new JLabel("Mua thêm hành lý ký gửi");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(240, 9, 321, 36);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 785, 10);
		contentPane.add(separator);
		
		textField_MaDC = new JTextField();
		textField_MaDC.setBounds(150, 281, 143, 20);
		contentPane.add(textField_MaDC);
		textField_MaDC.setColumns(10);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(468, 66, 327, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		
		JLabel lb_tien = new JLabel("New label");
		lb_tien.setBounds(125, 291, 139, 24);
		panel_1.add(lb_tien);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(41, 86, 397, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_banggia = new JLabel("Bảng giá ");
		lb_banggia.setBounds(169, 11, 79, 24);
		lb_banggia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lb_banggia);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 35, 377, 9);
		panel.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("ID:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 214, 94, 21);
		panel_1.add(lblNewLabel_5);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setBounds(125, 215, 133, 21);
		panel_1.add(lb_id);
		
		JLabel lblNewLabel_6 = new JLabel("Dịch vụ:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 246, 110, 24);
		panel_1.add(lblNewLabel_6);
		
		JLabel lb_dv = new JLabel("New label");
		lb_dv.setBounds(125, 247, 154, 24);
		panel_1.add(lb_dv);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 55, 356, 100);
		panel.add(scrollPane);
		
		table = new JTable();
		//table.setEditable(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int i=table.getSelectedRow();
				
				lb_id.setText(model.getValueAt(i, 0).toString());
				lb_tien.setText(model.getValueAt(i, 2).toString());
				lb_dv.setText(model.getValueAt(i, 1).toString());

			}
		});
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("ID");
		tableModel.addColumn("Nội dung dịch vụ");
		tableModel.addColumn("Giá tiền");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		
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
				String id =rs.getString(1);
				String nd =rs.getString(2);
				String gia =rs.getString(3);

				
				//System.out.print(ID_NQL+sovetrong+sovedat+sovedat+tongsove+sanbayden+ngaygiohc+ngaygiokh+sanbaydi+ttmaybayid+ID+"\n");
				
				tableModel.addRow(new Object[] {id, nd,gia});

				table.setModel(tableModel);
				
			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}								

		
		JButton bt_thanhtoan = new JButton("Thanh toán");
		bt_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				if (textField_MaDC.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập mã đặt vé");
					 textField_MaDC.requestFocus();
					 return; 
					}
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 

					String search="select ID from DATVEBAY where ID="+textField_MaDC.getText()+"";				
				
					ResultSet rs= st.executeQuery(search);
					if(rs.next()) {
						 final String id =rs.getString(1);
						System.out.println(id);	
					}
					else
						JOptionPane.showMessageDialog(null, " Mã đặt vé không tồn tại");

					
					con.close();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
				
			}
		});
		bt_thanhtoan.setBackground(new Color(135, 206, 250));
		bt_thanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thanhtoan.setBounds(51, 335, 127, 22);
		contentPane.add(bt_thanhtoan);
		
		
		JLabel lblNewLabel = new JLabel("Ngân hàng:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 94, 24);
		panel_1.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Agribank", "ABC", "MB bank", "Vietcombank", "ViettinBank"}));
		comboBox.setBounds(125, 27, 139, 24);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Số tài khoản:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 68, 94, 24);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(125, 71, 139, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên chủ thẻ:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 113, 104, 24);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 116, 139, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày phát hành:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 163, 118, 21);
		panel_1.add(lblNewLabel_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(125, 164, 139, 20);
		panel_1.add(dateChooser);
		
		JLabel lblNewLabel_4 = new JLabel("Tiền dịch vụ:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 290, 104, 24);
		panel_1.add(lblNewLabel_4);
		
		
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField.requestFocus();
					 return; 
					}
				if (textField_1.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
						 textField_1.requestFocus();
						 return; 
					}
				
				
				try {
									
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
				
					String search="select TONGTIEN, TAIKHOAN_ID from DATVEBAY where ID="+textField_MaDC.getText();					
										
					ResultSet rs= st.executeQuery(search);
					rs.next() ;
						String tongtienve =rs.getString(1);
						int tongtien=Integer.parseInt(tongtienve);
						
						String tiendv=lb_tien.getText();
						int tiendvbt=Integer.parseInt(tiendv);

						int tongtiendatve=tongtien+tiendvbt;
						System.out.println("đặt vé "+tongtien+" "+tiendvbt+" "+tongtiendatve);
						
						String id_taikhoan=rs.getString(2);
						int id_tk=Integer.parseInt(id_taikhoan);
						System.out.println(id_tk);

						String update ="update DATVEBAY set DICHVUBOTRO_ID="+lb_id.getText()+",TONGTIEN="+tongtiendatve+" where ID="+textField_MaDC.getText()+"";
						PreparedStatement pst = con.prepareStatement(update);
						pst= con.prepareStatement(update);
						pst.execute();
						
						
						String C= "select DT.ID, DT.TONGTIENBANVE,DT.TONGDOANHTHU \r\n"
								+ "from DOANHTHUCHUYENBAY DT, VEMAYBAY VE, DATVEBAY DV \r\n"
								+ "WHERE   DT.CHUYENBAY_ID=VE.CHUYENBAY_ID AND VE.ID=DV.VEMAYBAY_ID AND DV.ID="+textField_MaDC.getText();
						ResultSet rs2= st.executeQuery(C);

						rs2.next();
						
					
						String id_dt =rs2.getString(1);
						String tongtienbv=rs2.getString(2);
						float ttbv=Float.parseFloat(tongtienbv);
						float tongtbv=ttbv+tiendvbt;
						
						String tongdt =rs2.getString(3);	
						float tdt=Float.parseFloat(tongdt);
						float tongdoanhthu=tdt+tiendvbt;


						
						
						PreparedStatement pst1= con.prepareStatement("update DOANHTHUCHUYENBAY set TONGTIENBANVE="+tongtbv+", TONGDOANHTHU="+tongdoanhthu+" where ID= "+id_dt+"");		
						pst1.execute();
						
						
						
						
						
						rs.close();
						pst.close();

					con.close();
					JOptionPane.showMessageDialog(null, "mua thành công");
					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "thất bại");

					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(161, 342, 118, 23);
		panel_1.add(btnNewButton);
		

	}
}
