package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Dangky_taikhoan_nhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField textField_idnql;
	private JTextField textField_hoten;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField_ct;
	private JTextField textField_nv;
	private JTextField textField_tendn;
	private JTextField textField_mk;
	private JLabel lb_id;
	
	public Dangky_taikhoan_nhanvien() {
		setBackground(new Color(240, 255, 255));
		initComponents();
		autoID();
		setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangky_taikhoan_nhanvien frame = new Dangky_taikhoan_nhanvien();
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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 675, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng ký tài khoản");
		lblNewLabel.setBackground(new Color(240, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(191, 11, 307, 31);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 622, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 82, 61, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID Người quản lý:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(325, 84, 141, 18);
		contentPane.add(lblNewLabel_2);
		
		 lb_id = new JLabel("New label");
		lb_id.setBounds(129, 83, 90, 22);
		contentPane.add(lb_id);
		
		textField_idnql = new JTextField();
		textField_idnql.setBounds(476, 83, 156, 22);
		contentPane.add(textField_idnql);
		textField_idnql.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Họ & tên:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 130, 84, 22);
		contentPane.add(lblNewLabel_4);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(129, 132, 124, 22);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày sinh:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(325, 135, 110, 18);
		contentPane.add(lblNewLabel_5);
		
		JDateChooser dateChooser_ngsinh = new JDateChooser();
		dateChooser_ngsinh.setBounds(476, 132, 156, 20);
		contentPane.add(dateChooser_ngsinh);
		
		JLabel lblNewLabel_6 = new JLabel("SĐT:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(25, 176, 76, 22);
		contentPane.add(lblNewLabel_6);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(129, 178, 124, 22);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(325, 178, 67, 18);
		contentPane.add(lblNewLabel_7);
		
		textField_email = new JTextField();
		textField_email.setBounds(476, 179, 159, 22);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày vào làm:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(25, 231, 99, 22);
		contentPane.add(lblNewLabel_8);
		
		JDateChooser dateChooser_ngvl = new JDateChooser();
		dateChooser_ngvl.setBounds(129, 233, 124, 20);
		contentPane.add(dateChooser_ngvl);
		
		JLabel lblNewLabel_9 = new JLabel("Nơi công tác:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(325, 231, 124, 22);
		contentPane.add(lblNewLabel_9);
		
		textField_ct = new JTextField();
		textField_ct.setBounds(476, 233, 159, 22);
		contentPane.add(textField_ct);
		textField_ct.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Nhiệm vụ:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_10.setBounds(25, 275, 90, 22);
		contentPane.add(lblNewLabel_10);
		
		textField_nv = new JTextField();
		textField_nv.setBounds(129, 277, 124, 22);
		contentPane.add(textField_nv);
		textField_nv.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Tên đăng nhập:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_11.setBounds(325, 280, 110, 22);
		contentPane.add(lblNewLabel_11);
		
		textField_tendn = new JTextField();
		textField_tendn.setBounds(476, 277, 159, 22);
		contentPane.add(textField_tendn);
		textField_tendn.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Mật khẩu:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_12.setBounds(25, 323, 90, 22);
		contentPane.add(lblNewLabel_12);
		
		textField_mk = new JTextField();
		textField_mk.setBounds(129, 325, 124, 20);
		contentPane.add(textField_mk);
		textField_mk.setColumns(10);
		
		JButton bt_dangky = new JButton("Đăng ký");
		bt_dangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_idnql.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_idnql.requestFocus();
					 return; 
					}
				
				if (textField_hoten.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_hoten.requestFocus();
					 return; 
					}
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_email.requestFocus();
					 return; 
					}
				if (textField_sdt.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
						 textField_sdt.requestFocus();
						 return; 
						}
				if (textField_ct.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_ct.requestFocus();
					 return; 
					}
				
				if (textField_nv.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_nv.requestFocus();
					 return; 
					}
				if (textField_tendn.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_tendn.requestFocus();
					 return; 
				}
				if (textField_mk.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_mk.requestFocus();
					 return; 
					}
				
		
			
				try {
					
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						String tgString=formatter.format(dateChooser_ngsinh.getDate());
						String ngaysinh="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
						
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						String tgString1=formatter1.format(dateChooser_ngvl.getDate());
						String ngayvaolam="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";


				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"NHANVIEN\"  (\"ID\", \"NGUOIQUANLY_ID\", \"HOTEN\",\"NGAYSINH\",  \"SDT\", \"EMAIL\", \"NGAYVAOLAM\",\"NOICONGTAC\",\"NHIEMVU\",\"TENDANGNHAP\",\"MATKHAU\") values("+lb_id.getText()+","+textField_idnql.getText()+",'"+textField_hoten.getText()+"',"+ngaysinh+","+textField_sdt.getText()+",'"+textField_email.getText()+"',"+ngayvaolam+",'"+textField_ct.getText()+"','"+textField_nv.getText()+"','"+textField_tendn.getText()+"','"+textField_mk.getText()+"')");		
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
		bt_dangky.setBounds(93, 394, 89, 23);
		contentPane.add(bt_dangky);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		//lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\nguyen thi nhan\\Downloads\\185289.jpg"));
		lblNewLabel_3.setBounds(0, 0, 673, 484);
		contentPane.add(lblNewLabel_3);
		
		ImageIcon icon=new ImageIcon("563774.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_3.setIcon(scaleIcon);
	}
	public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from NHANVIEN");  
			
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
