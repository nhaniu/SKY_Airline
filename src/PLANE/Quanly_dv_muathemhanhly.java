package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quanly_dv_muathemhanhly extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_dv_muathemhanhly frame = new Quanly_dv_muathemhanhly();
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
	public Quanly_dv_muathemhanhly() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 526, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Dịch vụ hành lý kí gửi");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(91, 28, 302, 48);
		contentPane.add(lb_title);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiem_hanhly();
			}
		});
		bt_timkiem.setBackground(new Color(0, 191, 255));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(58, 130, 108, 32);
		contentPane.add(bt_timkiem);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new dv_muathem_hanhly();
			
			}
		});
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(294, 130, 99, 32);
		contentPane.add(bt_them);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 78, 452, 2);
		contentPane.add(separator);
	}

}
