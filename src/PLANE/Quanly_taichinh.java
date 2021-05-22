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
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Quanly_taichinh extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_taichinh frame = new Quanly_taichinh();
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
	public Quanly_taichinh() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 623, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thống kê doanh thu");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(88, 23, 432, 32);
		contentPane.add(lb_title);
		
		JButton bt_tkthang = new JButton("Thống kê theo chuyến bay");
		bt_tkthang.setBackground(new Color(135, 206, 250));
		bt_tkthang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_tkthang.setBounds(189, 162, 254, 23);
		contentPane.add(bt_tkthang);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 589, 4);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 219, 506, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lb_ngaybatdau = new JLabel("Ngày bắt đầu: ");
		lb_ngaybatdau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaybatdau.setBounds(31, 89, 99, 26);
		contentPane.add(lb_ngaybatdau);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(143, 89, 139, 26);
		contentPane.add(dateChooser1);
		
		JLabel lb_ngaykt = new JLabel("Ngày kết thúc: ");
		lb_ngaykt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaykt.setBounds(321, 88, 110, 29);
		contentPane.add(lb_ngaykt);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(432, 89, 140, 26);
		contentPane.add(dateChooser2);
	}
}
