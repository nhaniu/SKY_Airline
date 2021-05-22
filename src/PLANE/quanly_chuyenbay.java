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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class quanly_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_chuyenbay frame = new quanly_chuyenbay();
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
	public quanly_chuyenbay() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 733, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(229, 15, 306, 34);
		contentPane.add(lb_title);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_chuyenbay();
			}
		});
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(112, 314, 102, 23);
		contentPane.add(bt_them);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.setBackground(new Color(0, 191, 255));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(468, 314, 102, 23);
		contentPane.add(bt_timkiem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 700, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 285, 700, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 97, 626, 140);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
