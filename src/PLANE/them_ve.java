package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;

public class them_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenCB;
	private JTextField textField_MVE;
	private JTextField textField_giave;
	private JTextField textField_giodi;
	private JTextField textField_gioden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_ve frame = new them_ve();
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
	public them_ve() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 728, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thêm vé máy bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(234, 11, 273, 44);
		contentPane.add(lb_title);
		
		JLabel lb_maCB = new JLabel("Tên chuyến bay:");
		lb_maCB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_maCB.setBounds(368, 89, 112, 18);
		contentPane.add(lb_maCB);
		
		JLabel lb_hangve = new JLabel("Hạng vé:");
		lb_hangve.setBackground(new Color(240, 255, 255));
		lb_hangve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hangve.setBounds(37, 214, 101, 18);
		contentPane.add(lb_hangve);
		
		JComboBox comboBox_hangve = new JComboBox();
		comboBox_hangve.setBackground(new Color(135, 206, 250));
		comboBox_hangve.setModel(new DefaultComboBoxModel(new String[] {"Phổ thông tiêu chuẩn", "Hạng phổ thông linh hoạt", "Hạng phổ thông tiết kiệm", "Hạng thương gia"}));
		comboBox_hangve.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_hangve.setBounds(123, 214, 204, 27);
		contentPane.add(comboBox_hangve);
		
		textField_tenCB = new JTextField();
		textField_tenCB.setBounds(493, 87, 167, 24);
		contentPane.add(textField_tenCB);
		textField_tenCB.setColumns(10);
		
		JLabel lb_mave = new JLabel("Mã vé:");
		lb_mave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mave.setBounds(37, 89, 76, 18);
		contentPane.add(lb_mave);
		
		textField_MVE = new JTextField();
		textField_MVE.setBounds(123, 87, 169, 24);
		contentPane.add(textField_MVE);
		textField_MVE.setColumns(10);
		
		JLabel lb_giave = new JLabel("Giá vé: ");
		lb_giave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_giave.setBounds(37, 267, 65, 14);
		contentPane.add(lb_giave);
		
		textField_giave = new JTextField();
		textField_giave.setBounds(123, 263, 169, 24);
		contentPane.add(textField_giave);
		textField_giave.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setBounds(126, 348, 101, 23);
		contentPane.add(bt_them);
		
		JLabel lb_giodi = new JLabel("Giờ đi: ");
		lb_giodi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_giodi.setBounds(37, 126, 65, 28);
		contentPane.add(lb_giodi);
		
		textField_giodi = new JTextField();
		textField_giodi.setBounds(123, 128, 169, 27);
		contentPane.add(textField_giodi);
		textField_giodi.setColumns(10);
		
		JLabel lb_gioden = new JLabel("Giờ đến: ");
		lb_gioden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioden.setBounds(368, 131, 101, 18);
		contentPane.add(lb_gioden);
		
		textField_gioden = new JTextField();
		textField_gioden.setBounds(493, 128, 169, 27);
		contentPane.add(textField_gioden);
		textField_gioden.setColumns(10);
		
		JLabel lb_ngaydi = new JLabel("Ngày đi: ");
		lb_ngaydi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydi.setBounds(368, 214, 65, 18);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(493, 214, 169, 27);
		contentPane.add(dateChooser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 704, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 318, 704, 2);
		contentPane.add(separator_1);
		
		JLabel lb_noidi = new JLabel("Nơi đi: ");
		lb_noidi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noidi.setBounds(32, 175, 70, 18);
		contentPane.add(lb_noidi);
		
		JComboBox comboBox_noidi = new JComboBox();
		comboBox_noidi.setBackground(new Color(240, 255, 255));
		comboBox_noidi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(123, 174, 204, 27);
		contentPane.add(comboBox_noidi);
		
		JLabel lb_noiden = new JLabel("Nơi đến: ");
		lb_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noiden.setBounds(368, 175, 76, 18);
		contentPane.add(lb_noiden);
		
		JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setBackground(new Color(240, 255, 255));
		comboBox_noiden.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noiden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_noiden.setBounds(491, 176, 213, 27);
		contentPane.add(comboBox_noiden);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(418, 349, 89, 23);
		contentPane.add(bt_thoat);
	}
}
