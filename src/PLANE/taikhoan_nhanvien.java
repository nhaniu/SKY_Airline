package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JSeparator;

public class taikhoan_nhanvien extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taikhoan_nhanvien frame = new taikhoan_nhanvien();
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
	public taikhoan_nhanvien() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 450, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(85, 11, 341, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 76, 44, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("lb_id");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(97, 77, 179, 21);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel_3 = new JLabel("ID người quản lý:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 108, 135, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lb_idnql = new JLabel("New label");
		lb_idnql.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_idnql.setBounds(155, 109, 166, 21);
		contentPane.add(lb_idnql);
		
		JLabel lblNewLabel_4 = new JLabel("Họ tên:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 150, 116, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lb_hoten = new JLabel("New label");
		lb_hoten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_hoten.setBounds(99, 151, 135, 21);
		contentPane.add(lb_hoten);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày sinh:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 192, 94, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lb_ngsinh = new JLabel("New label");
		lb_ngsinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_ngsinh.setBounds(97, 193, 116, 21);
		contentPane.add(lb_ngsinh);
		
		JLabel lblNewLabel_6 = new JLabel("SĐT:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 224, 74, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lb_Sdt = new JLabel("New label");
		lb_Sdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_Sdt.setBounds(97, 224, 116, 21);
		contentPane.add(lb_Sdt);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 256, 74, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lb_email = new JLabel("New label");
		lb_email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_email.setBounds(97, 257, 125, 21);
		contentPane.add(lb_email);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày vào làm:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 297, 116, 21);
		contentPane.add(lblNewLabel_8);
		
		JLabel lb_ngvl = new JLabel("New label");
		lb_ngvl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_ngvl.setBounds(118, 298, 116, 21);
		contentPane.add(lb_ngvl);
		
		JLabel lblNewLabel_10 = new JLabel("Nơi công tác:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 340, 99, 21);
		contentPane.add(lblNewLabel_10);
		
		JLabel lb_noict = new JLabel("New label");
		lb_noict.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_noict.setBounds(117, 343, 159, 21);
		contentPane.add(lb_noict);
		
		JLabel lblNewLabel_12 = new JLabel("Nhiệm vụ:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 382, 88, 21);
		contentPane.add(lblNewLabel_12);
		
		JLabel lb_nv = new JLabel("New label");
		lb_nv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_nv.setBounds(118, 383, 116, 21);
		contentPane.add(lb_nv);
		
		JLabel lblNewLabel_9 = new JLabel("Tên đăng nhập:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 425, 116, 27);
		contentPane.add(lblNewLabel_9);
		
		JLabel lb_tendn = new JLabel("New label");
		lb_tendn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tendn.setBounds(118, 429, 94, 21);
		contentPane.add(lb_tendn);
		
		JLabel lb_mk = new JLabel("New label");
		lb_mk.setBounds(199, 432, 77, 14);
		contentPane.add(lb_mk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 416, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 453, 494);
		contentPane.add(lblNewLabel_2);
		lb_mk.setVisible(false);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_2.setIcon(scaleIcon);
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			dangnhap_nhanvien dn=null;
			String a = dn.tendn;
			String b=dn.mk;
			
			
			String search="select* from NHANVIEN where TENDANGNHAP='"+a+"' and MATKHAU='"+b+"'";					

			
			ResultSet rs= st.executeQuery(search);
				while(rs.next()) {
					String id =rs.getString(1);
					String idnql =rs.getString(2);
					String hoten =rs.getString(3);
					String ngsinh =rs.getString(4);							
					String sdt =rs.getString(5);
					String email =rs.getString(6);
					String ngayvl =rs.getString(7);
					String noict =rs.getString(8);
					String nhiemvu =rs.getString(9);
					String tendn =rs.getString(10);
					String mk =rs.getString(11);


					lb_id.setText(id);
					lb_idnql.setText(idnql);
					lb_hoten.setText(hoten);
					lb_ngsinh.setText(ngsinh);
					lb_Sdt.setText(sdt);
					lb_email.setText(email);
					lb_ngvl.setText(ngayvl);
					lb_noict.setText(noict);
					lb_nv.setText(nhiemvu);
					lb_tendn.setText(tendn);
					lb_mk.setText(mk);

										

				
			}
			con.close();
			
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
	}
}
