package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.security.auth.login.LoginContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class dangnhap_nhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField textField_taikhoan;
	private JPasswordField passwordField_matkhau;
	public static String tendn;
	public static String mk;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap_nhanvien frame = new dangnhap_nhanvien(0,null,null,null,null,null,null);
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
	public dangnhap_nhanvien(final int n, final JMenu Mn,  final JMenu Mn1, final JMenu mndn, final JButton bt, final JButton bt_user, final JMenu dichvu) {
		
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setTitle("SKY Airline");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 498, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_taikhoan = new JLabel("Tài khoản:");
		lb_taikhoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_taikhoan.setBounds(69, 132, 81, 29);
		contentPane.add(lb_taikhoan);
		
		textField_taikhoan = new JTextField();
		textField_taikhoan.setBounds(160, 136, 158, 20);
		contentPane.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);
		
		JLabel lb_matkhau = new JLabel("Mật khẩu:");
		lb_matkhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_matkhau.setBounds(69, 191, 81, 20);
		contentPane.add(lb_matkhau);
		
		passwordField_matkhau = new JPasswordField();
		passwordField_matkhau.setBounds(160, 188, 158, 20);
		contentPane.add(passwordField_matkhau);
		
		JButton bt_dangnhap = new JButton("Đăng nhập");
		bt_dangnhap.setBackground(new Color(255, 228, 225));
		bt_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					String search="select TENDANGNHAP,MATKHAU from NHANVIEN where TENDANGNHAP='"+textField_taikhoan.getText()+"' and MATKHAU='"+passwordField_matkhau.getText()+"'";						
					
					ResultSet rs= st.executeQuery(search);

						
						if(rs.next())
						{
							tendn=rs.getString(1);
							mk=rs.getString(2);
							System.out.println(tendn);

							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							if(n!=0)
							{
								Mn.setVisible(true);
								
							}
							if(n==2) {
								Mn1.setVisible(true);

							}
							mndn.setVisible(false);
							setVisible(false);
							bt.setVisible(true);
							bt_user.setVisible(true);
							dichvu.setVisible(true);

						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng nhập không hợp lệ","Login Error",JOptionPane.ERROR_MESSAGE);
							textField_taikhoan.setText(null);
							passwordField_matkhau.setText(null);
							setVisible(false);
						
					}
						
						
				} catch (Exception e2) {
				}
				
				
				
					
			}
		});
		bt_dangnhap.setBounds(160, 268, 158, 23);
		contentPane.add(bt_dangnhap);
		
		JLabel lb_title = new JLabel("Đăng nhập");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(176, 76, 142, 29);
		contentPane.add(lb_title);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(347, 190, 32, 25);
		contentPane.add(lblNewLabel);
		ImageIcon icon=new ImageIcon("icons8-lock-500.png");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel.setIcon(scaleIcon);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(347, 134, 32, 27);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon1=new ImageIcon("icons8-male-user-250.png");
		Image imgIcon1 =icon1.getImage();
		Image imgScale1 =imgIcon1.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon1=new ImageIcon(imgScale1);
		lblNewLabel_1.setIcon(scaleIcon1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(null, 1, true));
		lblNewLabel_2.setBounds(43, 52, 389, 288);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(211, 11, 49, 41);
		contentPane.add(lblNewLabel_3);
		ImageIcon icon12=new ImageIcon("icons8-male-user-144.png");
		Image imgIcon12 =icon12.getImage();
		Image imgScale12 =imgIcon12.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon12=new ImageIcon(imgScale12);
		lblNewLabel_3.setIcon(scaleIcon12);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 531, 414);
		contentPane.add(lblNewLabel_4);
		ImageIcon icon123=new ImageIcon("563774.jpg");
		Image imgIcon123 =icon123.getImage();
		Image imgScale123 =imgIcon123.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon123=new ImageIcon(imgScale123);
		lblNewLabel_4.setIcon(scaleIcon123);
		
	}
}
