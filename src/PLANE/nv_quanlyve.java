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
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nv_quanlyve extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nv_quanlyve frame = new nv_quanlyve();
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
	public nv_quanlyve() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 450, 211);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý vé");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(90, 11, 252, 30);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 416, 2);
		contentPane.add(separator);
		
		JButton bt_hoanve = new JButton("Thông tin vé");
		bt_hoanve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new quanly_ve();
			}
		});
		bt_hoanve.setBackground(new Color(135, 206, 250));
		bt_hoanve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_hoanve.setBounds(35, 106, 130, 23);
		contentPane.add(bt_hoanve);
		
		JButton bt_thongtinve = new JButton("Hoàn vé");
		bt_thongtinve.setBackground(new Color(135, 206, 250));
		bt_thongtinve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thongtinve.setBounds(281, 106, 89, 23);
		contentPane.add(bt_thongtinve);
	}
}
