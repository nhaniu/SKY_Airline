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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Dangky_taikhoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tendn;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JLabel lb_id;
	private JPasswordField passwordField;

	public Dangky_taikhoan() {
		initComponents();
		setVisible(true);
		autoID();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangky_taikhoan frame = new Dangky_taikhoan();
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
	public void initComponents() {
		setVisible(true);
		
		setBackground(new Color(240, 255, 255));
		setBounds(100, 100, 395, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký tài khoản");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 18, 319, 41);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 70, 343, 15);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 96, 51, 34);
		contentPane.add(lblNewLabel_1);
		
		 lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(149, 103, 135, 21);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(34, 141, 110, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_tendn = new JTextField();
		textField_tendn.setBounds(159, 141, 158, 22);
		contentPane.add(textField_tendn);
		textField_tendn.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mật khẩu:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(34, 183, 101, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("SĐT:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(34, 228, 108, 21);
		contentPane.add(lblNewLabel_5);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(159, 228, 158, 22);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(34, 272, 83, 15);
		contentPane.add(lblNewLabel_6);
		
		textField_email = new JTextField();
		textField_email.setBounds(159, 270, 158, 21);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 184, 158, 22);
		contentPane.add(passwordField);
		
		JButton bt_dangky = new JButton("Đăng ký");
		bt_dangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 passwordField.requestFocus();
					 return; 
					}
				
				if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_sdt.requestFocus();
					 return; 
					}
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_email.requestFocus();
					 return; 
					}
				if (textField_tendn.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
						 textField_tendn.requestFocus();
						 return; 
						}
		
			
				try {
					
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						Date date = new Date(); 
						String tgString=formatter.format(date);
						String ngay_batdau="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
						System.out.println(ngay_batdau);


				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"TAIKHOAN\"  (\"ID\", \"TENDANGNHAP\", \"MATKHAU\",\"NGAYBATDAU\",  \"SDT\", \"EMAIL\", \"TONGTIENMUAVE\",\"DIEM\",\"HANG\") values("+lb_id.getText()+",'"+textField_tendn.getText()+"','"+passwordField.getText()+"',"+ngay_batdau+","+textField_sdt.getText()+",'"+textField_email.getText()+"',"+0+","+0+",'"+""+"')");		
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
		bt_dangky.setBackground(new Color(135, 206, 250));
		bt_dangky.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_dangky.setBounds(76, 345, 89, 23);
		contentPane.add(bt_dangky);

	}
public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from TAIKHOAN");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("401");
			}
			else 
			{
				Integer result1 = Integer.valueOf(rs.getString("MAX(ID)"));
				result1++;
				lb_id.setText(result1.toString());
			}
			
			rs.close();
			DB_AIRLINE.close();
		} catch (ClassNotFoundException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);

		}  
	}
}
