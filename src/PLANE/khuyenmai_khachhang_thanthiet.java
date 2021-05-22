package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class khuyenmai_khachhang_thanthiet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khuyenmai_khachhang_thanthiet frame = new khuyenmai_khachhang_thanthiet();
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
	public khuyenmai_khachhang_thanthiet() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 729, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thông tin khuyến mãi dành cho khách hàng thân thiết");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(72, 22, 606, 38);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 77, 695, 9);
		contentPane.add(separator);
		
	}
}
