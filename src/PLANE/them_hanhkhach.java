package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class them_hanhkhach extends JFrame {

	private JPanel contentPane;
	private JTextField textField_matk;
	private JTextField textField_hoten;
	private JTextField textField__quoctich;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_hanhkhach frame = new them_hanhkhach();
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
	public them_hanhkhach() {
		setVisible(true);
		setTitle("Sky Airline");
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 425, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkh = new JLabel("Thêm hành khách");
		lb_ttkh.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkh.setBounds(129, 11, 259, 42);
		contentPane.add(lb_ttkh);
		
		JLabel lb_mtk = new JLabel("ID:");
		lb_mtk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mtk.setBounds(29, 112, 108, 25);
		contentPane.add(lb_mtk);
		
		textField_matk = new JTextField();
		textField_matk.setBounds(141, 115, 175, 20);
		contentPane.add(textField_matk);
		textField_matk.setColumns(10);
		
		JLabel lb_hoten = new JLabel("Họ và tên: ");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(29, 148, 96, 14);
		contentPane.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(141, 146, 175, 20);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_ngsinh = new JLabel("Ngày sinh:");
		lb_ngsinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngsinh.setBounds(29, 187, 84, 25);
		contentPane.add(lb_ngsinh);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(141, 187, 175, 20);
		contentPane.add(dateChooser);
		
		JLabel lb_gioitinh = new JLabel("Giới tính: ");
		lb_gioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioitinh.setBounds(29, 223, 84, 14);
		contentPane.add(lb_gioitinh);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 224));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(144, 220, 70, 22);
		contentPane.add(comboBox);
		
		JLabel lb_quoctich = new JLabel("Quốc tịch: ");
		lb_quoctich.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_quoctich.setBounds(29, 260, 84, 14);
		contentPane.add(lb_quoctich);
		
		textField__quoctich = new JTextField();
		textField__quoctich.setBounds(141, 258, 175, 20);
		contentPane.add(textField__quoctich);
		textField__quoctich.setColumns(10);
		
		JLabel lb_sdt = new JLabel("SĐT:");
		lb_sdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sdt.setBounds(29, 299, 49, 14);
		contentPane.add(lb_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(141, 297, 175, 20);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lb_email = new JLabel("Email: ");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(29, 337, 49, 14);
		contentPane.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(141, 335, 175, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setBackground(new Color(135, 206, 250));
		bt_them.setForeground(new Color(0, 0, 0));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(66, 420, 108, 23);
		contentPane.add(bt_them);
		
		JLabel lb_madc = new JLabel("Mã đặt chỗ:");
		lb_madc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_madc.setBounds(29, 87, 96, 14);
		contentPane.add(lb_madc);
		
		textField = new JTextField();
		textField.setBounds(141, 84, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 560, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(225, 421, 96, 25);
		contentPane.add(btnNewButton);
	}
}
