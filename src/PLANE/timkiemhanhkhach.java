package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DateFormatter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class timkiemhanhkhach extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CB;
	private JTextField textField_hoten;
	private JTextField textField_quoctich;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField_taikhoan_id;
	private JTextField textField_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiemhanhkhach frame = new timkiemhanhkhach();
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
	public timkiemhanhkhach() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 907, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_timkiem = new JLabel("Quản lý hành khách");
		lb_timkiem.setBounds(232, 11, 451, 44);
		lb_timkiem.setHorizontalAlignment(SwingConstants.CENTER);
		lb_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lb_timkiem);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 66, 912, 502);
		contentPane.add(panel);
		panel.setBorder(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setLayout(null);
		
		JLabel lb_maCB = new JLabel("Mã chuyến bay:");
		lb_maCB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_maCB.setBounds(95, 11, 122, 30);
		panel.add(lb_maCB);
		
		textField_CB = new JTextField();
		textField_CB.setBounds(227, 17, 163, 20);
		panel.add(textField_CB);
		textField_CB.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 62, 785, 89);
		panel.add(scrollPane);
		scrollPane.setVisible(false);
		

		
		JPanel panel_sua = new JPanel();
		panel_sua.setBorder(null);
		panel_sua.setBackground(new Color(51, 204, 255));
		panel_sua.setBounds(188, 162, 532, 305);
		panel.add(panel_sua);
		panel_sua.setLayout(null);
		panel_sua.setVisible(false);
		

		JLabel lb_idhk = new JLabel("ID hành khách: ");
		lb_idhk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_idhk.setBounds(22, 23, 114, 20);
		panel_sua.add(lb_idhk);
		
		JLabel lb_hoten = new JLabel("Họ tên:");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(22, 54, 68, 27);
		panel_sua.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(135, 54, 128, 20);
		panel_sua.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_ngaydinh = new JLabel("Ngày sinh:");
		lb_ngaydinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydinh.setBounds(22, 82, 88, 20);
		panel_sua.add(lb_ngaydinh);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(135, 81, 128, 20);
		panel_sua.add(dateChooser);
		
		JLabel lb_quoctich = new JLabel("Quốc tịch:");
		lb_quoctich.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_quoctich.setBounds(22, 113, 88, 20);
		panel_sua.add(lb_quoctich);
		
		textField_quoctich = new JTextField();
		textField_quoctich.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textField_quoctich.setBounds(135, 115, 128, 20);
		panel_sua.add(textField_quoctich);
		textField_quoctich.setColumns(10);
		
		JLabel lb_gioitinh = new JLabel("Giới Tính:");
		lb_gioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioitinh.setBounds(22, 144, 88, 14);
		panel_sua.add(lb_gioitinh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam ", "Nữ"}));
		comboBox.setBounds(135, 143, 68, 18);
		panel_sua.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("SĐT:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 177, 49, 14);
		panel_sua.add(lblNewLabel);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(135, 171, 128, 20);
		panel_sua.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lb_email = new JLabel("Email:");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(22, 206, 49, 20);
		panel_sua.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(135, 207, 128, 20);
		panel_sua.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản ID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(22, 236, 114, 14);
		panel_sua.add(lblNewLabel_1);
		
		textField_taikhoan_id = new JTextField();
		textField_taikhoan_id.setBounds(135, 236, 128, 20);
		panel_sua.add(textField_taikhoan_id);
		textField_taikhoan_id.setColumns(10);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setBounds(135, 23, 128, 20);
		panel_sua.add(textField_ID);
		textField_ID.setColumns(10);
		

		
		
		JTable table=new JTable();
		
		table.setBackground(new Color(255, 255, 255));
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Họ tên");
		tableModel.addColumn("Ngày sinh");
		tableModel.addColumn("Quốc tịch");
		tableModel.addColumn("Giới tính");
		tableModel.addColumn("SĐT");
		tableModel.addColumn("Email");
		tableModel.addColumn("Tài khoản ID");
		scrollPane.setViewportView(table);


		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		JButton btnNewButton_2 = new JButton("Cập nhật");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int i=table.getSelectedRow();
				if(i==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thông tin cần cập nhật trong bảng");
				}
				else {
					panel_sua.setVisible(true);

				textField_ID.setText(model.getValueAt(i, 0).toString());
				textField_hoten.setText(model.getValueAt(i, 1).toString());
			
				try {
					Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((String) model.getValueAt(i, 2));
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				textField_quoctich.setText(model.getValueAt(i, 3).toString());
				comboBox.setSelectedItem(model.getValueAt(i, 4).toString());
				textField_sdt.setText(model.getValueAt(i, 5).toString());
				textField_email.setText(model.getValueAt(i, 6).toString());
				if(model.getValueAt(i, 7)!=null) {
					textField_taikhoan_id.setText(model.getValueAt(i, 7).toString());
				}
				
				}
				
				
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 224));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(765, 15, 109, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JButton bt_timkiem = new JButton("Hiển thị danh sách");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					if (textField_CB.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã chuyến bay");
						 textField_CB.requestFocus();
						 return; 
						}
//					if (textField_MaDC.getText().isEmpty()) {
//						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã đặt chỗ");
//						 textField_CB.requestFocus();
//						 return; 
//						}
//						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select hk.ID, hk.HOTEN, hk.NGAYSINH, hk.QUOCTICH, hk.GIOITINH, hk.SDT, hk.EMAIL, hk.TAIKHOAN_ID\r\n"
							+ "from VEMAYBAY v, HANHKHACH hk, DATVEBAY dv, CHUYENBAY cb\r\n"
							+ "where v.CHUYENBAY_ID=cb.ID and v.ID=dv.VEMAYBAY_ID and hk.ID=dv.HANHKHACH_ID and  cb.ID="+textField_CB.getText();// and dv.ID ='\"+textField_MaDC.getText()+\"'";					
										
					while(tableModel.getRowCount() > 0) 
					{									
						tableModel.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					int dem=0;
					while(rs.next()) {
						String ID =rs.getString(1);
						String hoten =rs.getString(2);
						String ngaysinh =rs.getString(3);
						String quoctich =rs.getString(4);
						String gioitinh =rs.getString(5);
						String sdt =rs.getString(6);
						String email =rs.getString(7);
						String taikhoanID =rs.getString(8);
						dem++;

						System.out.print(ID+hoten+ngaysinh+quoctich+gioitinh+sdt+email+taikhoanID+"\n");
						
						tableModel.addRow(new Object[] {ID, hoten, ngaysinh,quoctich, gioitinh, sdt, email,taikhoanID});

						table.setModel(tableModel);
						btnNewButton_2.setVisible(true);
						scrollPane.setVisible(true);

					}

					if(dem==0) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy hành khách");
					}
					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			}
		});
		bt_timkiem.setBackground(new Color(255, 255, 224));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(436, 16, 169, 25);
		panel.add(bt_timkiem);
		

		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập email");
					 textField_email.requestFocus();
					 return; 
					}
				if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập số điện thoại");
					 textField_sdt.requestFocus();
					 return; 
					}
				if (textField_quoctich.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập quốc tịch");
					 textField_quoctich.requestFocus();
					 return; 
					}
				if (textField_hoten.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập họ tên");
					 textField_hoten.requestFocus();
					 return; 
					}
				
//				if(textField_taikhoan_id.equals("")) {
//					textField_taikhoan_id.setText("");
//				}
				try {
										
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser.getDate());						
					String texString="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
					System.out.println(texString);
					String update;
					if(textField_taikhoan_id.getText().equals("")) {
						 update ="update HANHKHACH set ID= "+textField_ID.getText()+", HOTEN='"+ textField_hoten.getText()+"',NGAYSINH="+texString+",QUOCTICH='"+textField_quoctich.getText()+"',GIOITINH='"+comboBox.getSelectedItem()+"',SDT="+textField_sdt.getText()+",EMAIL='"+textField_email.getText()+"',TAIKHOAN_ID="+null+" where ID="+textField_ID.getText()+"";					
					}
					else 
					{
							 update ="update HANHKHACH set HOTEN='"+ textField_hoten.getText()+"',NGAYSINH="+texString+",QUOCTICH='"+textField_quoctich.getText()+"',GIOITINH='"+comboBox.getSelectedItem()+"',SDT="+textField_sdt.getText()+",EMAIL='"+textField_email.getText()+"',TAIKHOAN_ID="+textField_taikhoan_id.getText()+" where ID="+ textField_ID.getText()+"";					
					}
					System.out.println(update);
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
					pst= DB_AIRLINE.prepareStatement(update);
					
					pst.execute();
					System.out.println(11111111);
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					pst.close();
					DB_AIRLINE.close();

				} catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
	
				}
		}
				
			
		});
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(368, 82, 114, 23);
		panel_sua.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(368, 141, 114, 23);
		panel_sua.add(btnNewButton_1);
		
		JButton bt_Sua = new JButton("Cập nhật");
		bt_Sua.setBounds(497, 61, 115, 23);
		//panel.add(bt_Sua);
		bt_Sua.setVisible(false);
		bt_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bt_Sua.setBackground(new Color(255, 255, 224));
		bt_Sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiem_1hanhkhach();
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 224));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(626, 16, 109, 23);
		panel.add(btnNewButton_3);
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(new Color(255, 255, 224));
		lblNewLabel_3.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel_3.setBounds(0, 0, 912, 491);
		panel.add(lblNewLabel_3);
		
	
		
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 64, 889, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel_2.setBounds(0, 0, 912, 488);
		contentPane.add(lblNewLabel_2);
		
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				DefaultTableModel model=(DefaultTableModel)table.getModel();
//				int i=table.getSelectedRow();
//				
//				textField_ID.setText(model.getValueAt(i, 0).toString());
//				textField_hoten.setText(model.getValueAt(i, 1).toString());
//			
//				try {
//					Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((String) model.getValueAt(i, 2));
//					dateChooser.setDate(date);
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
//				
//				textField_quoctich.setText(model.getValueAt(i, 3).toString());
//				comboBox.setSelectedItem(model.getValueAt(i, 4).toString());
//				textField_sdt.setText(model.getValueAt(i, 5).toString());
//				textField_email.setText(model.getValueAt(i, 6).toString());
//				if(model.getValueAt(i, 7)!=null) {
//					textField_taikhoan_id.setText(model.getValueAt(i, 7).toString());
//				}
//				
//
//			}
//		});

				
	}
}
