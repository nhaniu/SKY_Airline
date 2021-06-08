package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.security.auth.login.LoginContext;
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
import java.awt.Toolkit;

public class dangnhap_quanly extends JFrame {

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
					dangnhap_quanly frame = new dangnhap_quanly(0,null,null,null,null,null);
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
	public dangnhap_quanly(final int n, final JMenu Mn,  final JMenu Mn1, final JMenu mndn, final JButton bt, final JButton bt_user) {
		
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setTitle("SKY Airline");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 387, 269);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_taikhoan = new JLabel("Tài khoản:");
		lb_taikhoan.setBounds(56, 67, 70, 29);
		contentPane.add(lb_taikhoan);
		
		textField_taikhoan = new JTextField();
		textField_taikhoan.setBounds(171, 71, 132, 20);
		contentPane.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);
		
		JLabel lb_matkhau = new JLabel("Mật khẩu:");
		lb_matkhau.setBounds(56, 107, 70, 14);
		contentPane.add(lb_matkhau);
		
		passwordField_matkhau = new JPasswordField();
		passwordField_matkhau.setBounds(171, 104, 132, 20);
		contentPane.add(passwordField_matkhau);
		
		JButton bt_dangnhap = new JButton("Đăng nhập");
		bt_dangnhap.setBackground(new Color(0, 191, 255));
		bt_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					String search="select TENDANGNHAP,MATKHAU from NGUOIQUANLY where TENDANGNHAP='"+textField_taikhoan.getText()+"' and MATKHAU='"+passwordField_matkhau.getText()+"'";						
					
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
		bt_dangnhap.setBounds(56, 176, 100, 23);
		contentPane.add(bt_dangnhap);
		
		JButton bt_exit = new JButton("Thoát");
		bt_exit.setBackground(new Color(0, 191, 255));
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLogin = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLogin, "Xác nhận nếu bạn muốn thoát", "LoginContext System", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)					
					setVisible(false);

			}
		});
		bt_exit.setBounds(223, 176, 80, 23);
		contentPane.add(bt_exit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 150, 353, 2);
		contentPane.add(separator);
		
		JLabel lb_title = new JLabel("Đăng nhập");
		lb_title.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(105, 11, 142, 20);
		contentPane.add(lb_title);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 47, 353, 2);
		contentPane.add(separator_1);
		
	}
}
