package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.ImageIcon;

public class taikhoan_quanly extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taikhoan_quanly frame = new taikhoan_quanly();
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
	public taikhoan_quanly() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 366, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(45, 11, 277, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 65, 79, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ tên:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 96, 79, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày sinh:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 127, 79, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày vào làm:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 165, 107, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SĐT:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 197, 91, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 228, 91, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Phòng ban:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 259, 97, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tên đăng nhập:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 290, 107, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lb_mk = new JLabel("New label");
		lb_mk.setBounds(224, 294, 79, 14);
		contentPane.add(lb_mk);
		lb_mk.setVisible(false);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(122, 63, 97, 20);
		contentPane.add(lb_id);
		
		JLabel lb_hoten = new JLabel("New label");
		lb_hoten.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_hoten.setBounds(122, 97, 156, 20);
		contentPane.add(lb_hoten);
		
		JLabel lb_ngsinh = new JLabel("New label");
		lb_ngsinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_ngsinh.setBounds(122, 127, 156, 20);
		contentPane.add(lb_ngsinh);
		
		JLabel lb_ngvl = new JLabel("New label");
		lb_ngvl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_ngvl.setBounds(122, 166, 156, 20);
		contentPane.add(lb_ngvl);
		
		JLabel lb_sdt = new JLabel("New label");
		lb_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_sdt.setBounds(121, 197, 99, 20);
		contentPane.add(lb_sdt);
		
		JLabel lb_email = new JLabel("New label");
		lb_email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_email.setBounds(122, 228, 156, 20);
		contentPane.add(lb_email);
		
		JLabel lb_phongban = new JLabel("New label");
		lb_phongban.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_phongban.setBounds(122, 261, 130, 18);
		contentPane.add(lb_phongban);
		
		JLabel lb_tendn = new JLabel("New label");
		lb_tendn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tendn.setBounds(122, 291, 107, 20);
		contentPane.add(lb_tendn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 332, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(0, 0, 374, 376);
		contentPane.add(lblNewLabel_9);
		
		ImageIcon icon=new ImageIcon("anh2.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_9.getWidth(), lblNewLabel_9.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_9.setIcon(scaleIcon);
		
try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			dangnhap_quanly dn=null;
			String a = dn.tendn;
			String b=dn.mk;
			
			
			String search="select* from NGUOIQUANLY where TENDANGNHAP='"+a+"' and MATKHAU='"+b+"'";					

			
			ResultSet rs= st.executeQuery(search);
				while(rs.next()) {
					String id =rs.getString(1);
					String hoten =rs.getString(2);
					String ngsinh =rs.getString(3);	
					String ngayvl =rs.getString(4);
					String sdt =rs.getString(5);
					String email =rs.getString(6);
					String phongban =rs.getString(7);
					String tendn =rs.getString(8);
					String mk =rs.getString(9);


					lb_id.setText(id);
					lb_hoten.setText(hoten);
					lb_ngsinh.setText(ngsinh);
					lb_sdt.setText(sdt);
					lb_email.setText(email);
					lb_ngvl.setText(ngayvl);
					lb_phongban.setText(phongban);
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
