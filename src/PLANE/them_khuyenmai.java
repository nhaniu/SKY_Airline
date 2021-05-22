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
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class them_khuyenmai extends JFrame {

	private JPanel contentPane;
	private JTextField textField_makm;
	private JTextField textField_htkm;
	private JTextField textField_ndung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_khuyenmai frame = new them_khuyenmai();
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
	public them_khuyenmai() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 540, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkm = new JLabel("Thêm khuyến mãi");
		lb_ttkm.setBackground(new Color(218, 165, 32));
		lb_ttkm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ttkm.setBounds(143, 11, 272, 50);
		contentPane.add(lb_ttkm);
		
		JLabel lb_makm = new JLabel("Mã khuyến mãi: ");
		lb_makm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_makm.setBounds(30, 94, 130, 25);
		contentPane.add(lb_makm);
		
		textField_makm = new JTextField();
		textField_makm.setBounds(212, 96, 203, 22);
		contentPane.add(textField_makm);
		textField_makm.setColumns(10);
		
		JLabel lb_hthuckm = new JLabel("Hình thức khuyến mãi: ");
		lb_hthuckm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hthuckm.setBounds(30, 145, 172, 14);
		contentPane.add(lb_hthuckm);
		
		textField_htkm = new JTextField();
		textField_htkm.setBounds(212, 142, 203, 22);
		contentPane.add(textField_htkm);
		textField_htkm.setColumns(10);
		
		JLabel lb_ngayBD = new JLabel("Ngày bắt đầu: ");
		lb_ngayBD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngayBD.setBounds(30, 185, 118, 22);
		contentPane.add(lb_ngayBD);
		
		JDateChooser dateChooser_NBD = new JDateChooser();
		dateChooser_NBD.setBounds(212, 185, 203, 22);
		contentPane.add(dateChooser_NBD);
		
		JLabel lb_ngayKT = new JLabel("Ngày kết thúc:");
		lb_ngayKT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngayKT.setBounds(30, 230, 118, 25);
		contentPane.add(lb_ngayKT);
		
		JDateChooser dateChooser_NKT = new JDateChooser();
		dateChooser_NKT.setBounds(212, 233, 203, 22);
		contentPane.add(dateChooser_NKT);
		
		JLabel lb_noidung = new JLabel("Nội dung: ");
		lb_noidung.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noidung.setBounds(30, 283, 92, 18);
		contentPane.add(lb_noidung);
		
		textField_ndung = new JTextField();
		textField_ndung.setBounds(212, 282, 203, 22);
		contentPane.add(textField_ndung);
		textField_ndung.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setBounds(63, 386, 102, 23);
		contentPane.add(bt_them);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(331, 386, 102, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 582, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 350, 592, 2);
		contentPane.add(separator_1);
	}
}
