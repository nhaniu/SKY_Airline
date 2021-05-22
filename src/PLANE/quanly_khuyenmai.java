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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class quanly_khuyenmai extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_khuyenmai frame = new quanly_khuyenmai();
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
	public quanly_khuyenmai() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 727, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkm = new JLabel("Quản lý khuyến mãi");
		lb_ttkm.setBackground(new Color(218, 165, 32));
		lb_ttkm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ttkm.setBounds(233, 11, 272, 50);
		contentPane.add(lb_ttkm);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setBounds(132, 386, 102, 23);
		contentPane.add(bt_them);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.setBackground(new Color(0, 191, 255));
		bt_timkiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bt_timkiem.setBounds(506, 386, 102, 23);
		contentPane.add(bt_timkiem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 677, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 350, 667, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 111, 639, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "Ng\u00E0y k\u1EBFt th\u00FAc", "N\u1ED9i dung ", "Ph\u1EA7n tr\u0103m khuy\u1EBFn m\u00E3i"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
	}
}
