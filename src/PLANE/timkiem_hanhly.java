package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class timkiem_hanhly extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaDC;
	private JTextField textField_hoten;
	private JTextField textField_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timkiem_hanhly frame = new timkiem_hanhly();
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
	public timkiem_hanhly() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 543, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_MaDC = new JLabel("Mã đặt chỗ: ");
		lb_MaDC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_MaDC.setBounds(30, 84, 99, 22);
		contentPane.add(lb_MaDC);
		
		JLabel lb_title = new JLabel("Tìm kiếm thông tin hành lý ký gửi");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(69, 11, 394, 36);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 759, 8);
		contentPane.add(separator);
		
		textField_MaDC = new JTextField();
		textField_MaDC.setBounds(132, 86, 143, 20);
		contentPane.add(textField_MaDC);
		textField_MaDC.setColumns(10);
		
		JLabel lb_goiHL = new JLabel("Gói hành lý: ");
		lb_goiHL.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_goiHL.setBounds(30, 231, 99, 15);
		contentPane.add(lb_goiHL);
		
		JRadioButton rdbt_5 = new JRadioButton("10 kg");
		rdbt_5.setBackground(new Color(240, 255, 255));
		rdbt_5.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbt_5.setBounds(132, 227, 64, 23);
		contentPane.add(rdbt_5);
		
		JRadioButton rdbt_10 = new JRadioButton("15 kg");
		rdbt_10.setBackground(new Color(240, 255, 255));
		rdbt_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbt_10.setBounds(225, 227, 64, 23);
		contentPane.add(rdbt_10);
		
		JRadioButton rdbt_15 = new JRadioButton("20 kg");
		rdbt_15.setBackground(new Color(240, 255, 255));
		rdbt_15.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbt_15.setHorizontalAlignment(SwingConstants.CENTER);
		rdbt_15.setBounds(318, 227, 72, 22);
		contentPane.add(rdbt_15);
		
		JRadioButton rdbt_20 = new JRadioButton("25 kg");
		rdbt_20.setBackground(new Color(240, 255, 255));
		rdbt_20.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbt_20.setBounds(430, 227, 64, 23);
		contentPane.add(rdbt_20);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbt_5);
		G.add(rdbt_10);
		G.add(rdbt_15);
		G.add(rdbt_20);
		
		JLabel lb_hoten = new JLabel("Họ tên: ");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(30, 129, 81, 20);
		contentPane.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(132, 130, 143, 19);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_email = new JLabel("Email: ");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(30, 176, 81, 22);
		contentPane.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(132, 178, 234, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JButton bt_thanhtoan = new JButton("Tìm kiếm");
		bt_thanhtoan.setBackground(new Color(135, 206, 250));
		bt_thanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thanhtoan.setBounds(69, 305, 127, 22);
		contentPane.add(bt_thanhtoan);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(135, 206, 250));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(333, 305, 89, 22);
		contentPane.add(bt_thoat);
	}
}
