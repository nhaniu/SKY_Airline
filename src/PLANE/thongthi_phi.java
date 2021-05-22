package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class thongthi_phi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongthi_phi frame = new thongthi_phi();
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
	public thongthi_phi() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 1043, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_A = new JScrollPane();
		scrollPane_A.setBounds(10, 161, 357, 87);
		contentPane.add(scrollPane_A);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"               10 kg", "        150 000"},
				{"               15 kg", "        200 000"},
				{"               20 kg", "        250 000"},
				{"               25 kg", "        300 000"},
			},
			new String[] {
				"G\u00F3i h\u00E0nh l\u00FD", "Ph\u00ED (vnd)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(116);
		scrollPane_A.setViewportView(table);
		
		JLabel lb_tieu_de = new JLabel("PHÍ VÀ LỆ PHÍ");
		lb_tieu_de.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tieu_de.setForeground(new Color(255, 0, 0));
		lb_tieu_de.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_tieu_de.setBounds(302, 11, 419, 48);
		contentPane.add(lb_tieu_de);
		
		JLabel lb_mua_truoc = new JLabel("A. Mua trước qua website/ Đại lý/ Phòng vé\r\n\r\n");
		lb_mua_truoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mua_truoc.setBounds(10, 108, 390, 31);
		contentPane.add(lb_mua_truoc);
		
		JLabel lb_mua_tai_san_bay = new JLabel("B. Mua tại sân bay\r\n");
		lb_mua_tai_san_bay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mua_tai_san_bay.setBounds(509, 112, 282, 23);
		contentPane.add(lb_mua_tai_san_bay);
		
		JScrollPane scrollPane_B = new JScrollPane();
		scrollPane_B.setBounds(509, 161, 491, 102);
		contentPane.add(scrollPane_B);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Mua t\u1EA1i khu v\u1EF1c Check-in (trong v\u00F2ng 3 gi\u1EDD tr\u01B0\u1EDBc gi\u1EDD kh\u1EDFi h\u00E0nh)", "300 000/15 kg"},
				{"Mua t\u1EA1i c\u1EEDa kh\u1EDFi h\u00E0nh", "500 000/15kg"},
				{"H\u00E0nh l\u00FD qu\u00E1 c\u01B0\u1EDBc mua t\u1EA1i khu v\u1EF1c Check-in (t\u00EDnh theo m\u1ED7i kg) (*)", "40 000"},
				{"H\u00E0nh l\u00FD qu\u00E1 c\u01B0\u1EDBc t\u1EA1i c\u1EEDa kh\u1EDFi h\u00E0nh (t\u00EDnh theo m\u1ED7i kg) (*)", "60 000"},
				{"D\u1ECBch v\u1EE5 H\u00E0nh l\u00FD qu\u00E1 kh\u1ED5 (t\u00EDnh theo 1 ki\u1EC7n) (**)", "300 000"},
			},
			new String[] {
				"G\u00F3i h\u00E0nh l\u00FD", "Ph\u00ED"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(327);
		scrollPane_B.setViewportView(table_1);
		
		JTextArea text_luu_y = new JTextArea();
		text_luu_y.setForeground(new Color(255, 0, 0));
		text_luu_y.setBackground(new Color(240, 255, 255));
		text_luu_y.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		text_luu_y.setText("*Lưu ý:\r\n\r\n(*) Chỉ áp dụng cho hành khách đã có hành lý ký gửi\r\n(**) Hành khách được ký gửi tối đa 2 kiện quá khổ/chặng bay:\r\nDịch vụ Hành lý quá khổ chỉ được áp dụng sau khi mua gói hành lý ký gửi");
		text_luu_y.setWrapStyleWord(true);
		text_luu_y.setLineWrap(true);
		text_luu_y.setBounds(509, 284, 491, 114);
		contentPane.add(text_luu_y);
		
		JScrollPane scrollPane_C = new JScrollPane();
		scrollPane_C.setBounds(10, 356, 357, 39);
		contentPane.add(scrollPane_C);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"    Ph\u1EE5 thu \u0111\u1EBFn mu\u1ED9n", "    400 000"},
			},
			new String[] {
				"Lo\u1EA1i ph\u1EE5 thu", "Ph\u00ED (vnd)"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(122);
		scrollPane_C.setViewportView(table_2);
		
		JLabel lb_denmuon = new JLabel("C. Phụ thu đến muộn");
		lb_denmuon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_denmuon.setForeground(new Color(0, 0, 0));
		lb_denmuon.setBounds(10, 312, 325, 31);
		contentPane.add(lb_denmuon);
	}

}
