package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;

public class them_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tencb;
	private JTextField textField_mamb;
	private JTextField textField_giodi;
	private JTextField textField_gioden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_chuyenbay frame = new them_chuyenbay();
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
	public them_chuyenbay() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 733, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thêm chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(229, 15, 306, 34);
		contentPane.add(lb_title);
		
		JLabel lb_maCB = new JLabel("Tên chuyến bay: ");
		lb_maCB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_maCB.setBounds(35, 85, 127, 21);
		contentPane.add(lb_maCB);
		
		textField_tencb = new JTextField();
		textField_tencb.setBounds(172, 86, 151, 21);
		contentPane.add(textField_tencb);
		textField_tencb.setColumns(10);
		
		JLabel lb_maMB = new JLabel("Mã máy bay: ");
		lb_maMB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_maMB.setBounds(370, 85, 102, 21);
		contentPane.add(lb_maMB);
		
		textField_mamb = new JTextField();
		textField_mamb.setBounds(482, 86, 151, 20);
		contentPane.add(textField_mamb);
		textField_mamb.setColumns(10);
		
		JLabel lb_sbdi = new JLabel("Sân bay đi: ");
		lb_sbdi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sbdi.setBounds(35, 135, 102, 18);
		contentPane.add(lb_sbdi);
		
		JComboBox comboBox_noidi = new JComboBox();
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(172, 135, 151, 20);
		contentPane.add(comboBox_noidi);
		
		JLabel lb_noiden = new JLabel("Sân bay đến: ");
		lb_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noiden.setBounds(370, 138, 102, 18);
		contentPane.add(lb_noiden);
		
		JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noiden.setBounds(482, 134, 151, 21);
		contentPane.add(comboBox_noiden);
		
		JLabel lb_ngaydi = new JLabel("Ngày đi: ");
		lb_ngaydi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydi.setBounds(35, 176, 75, 20);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(172, 176, 151, 20);
		contentPane.add(dateChooser);
		
		JLabel lb_giodi = new JLabel("Giờ đi: ");
		lb_giodi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_giodi.setBounds(35, 220, 57, 14);
		contentPane.add(lb_giodi);
		
		JLabel lb_gioden = new JLabel("Giờ đến:");
		lb_gioden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioden.setBounds(370, 218, 83, 21);
		contentPane.add(lb_gioden);
		
		textField_giodi = new JTextField();
		textField_giodi.setBounds(172, 218, 151, 21);
		contentPane.add(textField_giodi);
		textField_giodi.setColumns(10);
		
		textField_gioden = new JTextField();
		textField_gioden.setBounds(482, 218, 151, 20);
		contentPane.add(textField_gioden);
		textField_gioden.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(112, 314, 102, 23);
		contentPane.add(bt_them);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(468, 314, 102, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 700, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 285, 700, 2);
		contentPane.add(separator_1);
	}
}
