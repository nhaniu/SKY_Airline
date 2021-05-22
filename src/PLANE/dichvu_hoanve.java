package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dichvu_hoanve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_madatcho;
	private JTextField textField_hoten;
	private JTextField textField_email;
	private JTextField textField_lido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dichvu_hoanve frame = new dichvu_hoanve();
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
	public dichvu_hoanve() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 370, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ma_dat_cho = new JLabel("Mã đặt chỗ:");
		lb_ma_dat_cho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ma_dat_cho.setBounds(10, 82, 90, 34);
		contentPane.add(lb_ma_dat_cho);
		
		textField_madatcho = new JTextField();
		textField_madatcho.setBounds(110, 89, 103, 27);
		contentPane.add(textField_madatcho);
		textField_madatcho.setColumns(10);
		
		JLabel lb_hoten = new JLabel("Họ tên:");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(10, 143, 76, 16);
		contentPane.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(110, 137, 189, 27);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_email = new JLabel("Email:");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(10, 185, 49, 16);
		contentPane.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(110, 179, 189, 27);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lb_lido = new JLabel("Lí do:");
		lb_lido.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_lido.setBounds(10, 225, 49, 16);
		contentPane.add(lb_lido);
		
		textField_lido = new JTextField();
		textField_lido.setBounds(110, 219, 189, 27);
		contentPane.add(textField_lido);
		textField_lido.setColumns(10);
		
		JButton bt_gui = new JButton("Gửi");
		bt_gui.setBackground(new Color(0, 191, 255));
		bt_gui.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_gui.setBounds(41, 297, 81, 23);
		contentPane.add(bt_gui);
		
		JLabel bt_exit = new JLabel("HOÀN VÉ");
		bt_exit.setForeground(new Color(255, 0, 0));
		bt_exit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_exit.setHorizontalAlignment(SwingConstants.CENTER);
		bt_exit.setBounds(75, 32, 189, 23);
		contentPane.add(bt_exit);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(188, 297, 76, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 346, 14);
		contentPane.add(separator);
	}
}
