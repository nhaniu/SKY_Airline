package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangKy_khachhang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hoten;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField_taikhoan;
	private JPasswordField passwordField_matkhau;
	private JPasswordField passwordField_nhaplai_mk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy_khachhang frame = new DangKy_khachhang();
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
	public DangKy_khachhang() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setTitle("SKY Airline");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 620, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_hoten = new JLabel("Họ tên: ");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(10, 88, 72, 32);
		contentPane.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(92, 97, 152, 20);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_ngaysinh = new JLabel("Ngày sinh: ");
		lb_ngaysinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaysinh.setBounds(287, 94, 85, 20);
		contentPane.add(lb_ngaysinh);
		
		JDateChooser dateChooser_gioitinh = new JDateChooser();
		dateChooser_gioitinh.setBounds(382, 94, 152, 20);
		contentPane.add(dateChooser_gioitinh);
		
		JLabel lb_gioitinh = new JLabel("Giới tính: ");
		lb_gioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioitinh.setBounds(10, 147, 72, 14);
		contentPane.add(lb_gioitinh);
		
		JComboBox comboBox_gioitinh = new JComboBox();
		comboBox_gioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox_gioitinh.setBounds(92, 144, 60, 22);
		contentPane.add(comboBox_gioitinh);
		
		JLabel lb_quoctich = new JLabel("Quốc tịch: ");
		lb_quoctich.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_quoctich.setBounds(287, 141, 85, 26);
		contentPane.add(lb_quoctich);
		
		JComboBox comboBox_quoctich = new JComboBox();
		comboBox_quoctich.setModel(new DefaultComboBoxModel(new String[] {"Việt Nam", "Lao"}));
		comboBox_quoctich.setBounds(382, 142, 85, 24);
		contentPane.add(comboBox_quoctich);
		
		JLabel lb_sdt = new JLabel("SĐT: ");
		lb_sdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sdt.setBounds(10, 198, 49, 14);
		contentPane.add(lb_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(92, 192, 152, 20);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lb_email = new JLabel("Email: ");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(287, 195, 49, 20);
		contentPane.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(382, 192, 157, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lb_taikhoan = new JLabel("Tài khoản: ");
		lb_taikhoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_taikhoan.setBounds(10, 239, 85, 20);
		contentPane.add(lb_taikhoan);
		
		textField_taikhoan = new JTextField();
		textField_taikhoan.setBounds(92, 237, 152, 20);
		contentPane.add(textField_taikhoan);
		textField_taikhoan.setColumns(10);
		
		JLabel lb_matkhau = new JLabel("Mật khẩu:");
		lb_matkhau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_matkhau.setBounds(287, 236, 72, 26);
		contentPane.add(lb_matkhau);
		
		passwordField_matkhau = new JPasswordField();
		passwordField_matkhau.setBounds(382, 240, 157, 20);
		contentPane.add(passwordField_matkhau);
		
		JLabel lb_nhaplai_mk = new JLabel("Nhập lại mật khẩu: ");
		lb_nhaplai_mk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_nhaplai_mk.setBounds(10, 284, 132, 32);
		contentPane.add(lb_nhaplai_mk);
		
		passwordField_nhaplai_mk = new JPasswordField();
		passwordField_nhaplai_mk.setBounds(138, 291, 106, 20);
		contentPane.add(passwordField_nhaplai_mk);
		
		JButton bt_dangky = new JButton("Đăng ký");
		bt_dangky.setBackground(new Color(0, 191, 255));
		bt_dangky.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_dangky.setBounds(92, 353, 89, 23);
		contentPane.add(bt_dangky);
		
		JButton bt_exit = new JButton("Thoát");
		bt_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_exit.setBackground(new Color(0, 191, 255));
		bt_exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_exit.setBounds(369, 353, 89, 23);
		contentPane.add(bt_exit);
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(175, 11, 250, 32);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 699, 2);
		contentPane.add(separator);
	}
}
