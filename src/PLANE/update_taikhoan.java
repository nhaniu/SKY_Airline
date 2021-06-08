package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;

public class update_taikhoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_mk;
	private JTextField textField_sdt;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_taikhoan frame = new update_taikhoan("1","2","3","4","5","6","7","8","9");
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
	public update_taikhoan(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 707, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật tài khoản");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(153, 11, 380, 37);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 656, 9);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 87, 92, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(126, 87, 126, 22);
		contentPane.add(lb_id);
		lb_id.setText(a);
		
		JLabel lblNewLabel_3 = new JLabel("Tên đăng nhập:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(338, 87, 119, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lb_tendn = new JLabel("New label");
		lb_tendn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tendn.setBounds(467, 88, 137, 22);
		contentPane.add(lb_tendn);
		lb_tendn.setText(b);
		
		JLabel lblNewLabel_4 = new JLabel("Mật khẩu:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(34, 134, 92, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_mk = new JTextField();
		textField_mk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_mk.setBounds(126, 136, 119, 20);
		contentPane.add(textField_mk);
		textField_mk.setColumns(10);
		textField_mk.setText(c);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(338, 139, 126, 22);
		contentPane.add(lblNewLabel_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(467, 136, 186, 20);
		contentPane.add(dateChooser);
		
		LocalDate localDate1 = LocalDate.parse(d);
        Date date2 = (Date) Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());;
		dateChooser.setDate(date2); 
		
		JLabel lblNewLabel_6 = new JLabel("SĐT:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(34, 181, 49, 22);
		contentPane.add(lblNewLabel_6);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(126, 183, 119, 22);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		textField_sdt.setText(e);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(338, 182, 75, 22);
		contentPane.add(lblNewLabel_7);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_email.setBounds(467, 183, 186, 22);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		textField_email.setText(f);
		
		JLabel lblNewLabel_8 = new JLabel("Tổng tiền mua vé:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(34, 234, 137, 22);
		contentPane.add(lblNewLabel_8);
		
		JLabel lb_tongtienve = new JLabel("New label");
		lb_tongtienve.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tongtienve.setBounds(164, 235, 137, 20);
		contentPane.add(lb_tongtienve);
		lb_tongtienve.setText(g);
		
		JLabel lblNewLabel_9 = new JLabel("Điểm:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(338, 227, 97, 22);
		contentPane.add(lblNewLabel_9);
		
		JLabel lb_diem = new JLabel("New label");
		lb_diem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_diem.setBounds(467, 232, 103, 17);
		contentPane.add(lb_diem);
		lb_diem.setText(h);
		
		JLabel lblNewLabel_10 = new JLabel("Hạng:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_10.setBounds(34, 283, 75, 22);
		contentPane.add(lblNewLabel_10);
		
		JLabel lb_hang = new JLabel("New label");
		lb_hang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_hang.setBounds(126, 283, 126, 22);
		contentPane.add(lb_hang);
		lb_hang.setText(i);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_email.requestFocus();
					 return; 
					}
				
				if (textField_mk.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_mk.requestFocus();
					 return; 
					}
				if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_sdt.requestFocus();
					 return; 
					}
				
			
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser.getDate());
					String ngaybd="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
					
					String update ="update TAIKHOAN set ID= "+lb_id.getText()+",TENDANGNHAP='"+lb_tendn.getText()+"',MATKHAU='"+textField_mk.getText()+"',NGAYBATDAU="+ngaybd+",SDT="+textField_sdt.getText()+",EMAIL='"+textField_email.getText()+"',TONGTIENMUAVE="+lb_tongtienve.getText()+",DIEM="+lb_diem.getText()+", HANG='"+lb_hang.getText()+"'where ID="+ lb_id.getText()+"";
																		
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
					pst= DB_AIRLINE.prepareStatement(update);
					pst.execute();
	
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
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(100, 358, 108, 22);
		contentPane.add(btnNewButton);
		
		JButton bt_capnhat = new JButton("Thoát");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_capnhat.setBackground(new Color(135, 206, 250));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bt_capnhat.setBounds(456, 358, 89, 23);
		contentPane.add(bt_capnhat);
		

	
		
	}
}
