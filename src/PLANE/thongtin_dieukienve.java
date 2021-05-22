package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class thongtin_dieukienve extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lb_tieu_de;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongtin_dieukienve frame = new thongtin_dieukienve();
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
	public thongtin_dieukienve() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 811, 292);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 110, 762, 73);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"H\u00E0nh l\u00FD x\u00E1ch tay", "12 kg", "7 kg", "7 kg", "7 kg"},
				{"H\u00E0nh l\u00FD k\u00FD g\u1EEDi", "30 kg", "20 kg", "20 kg", "\u00E1p d\u1EE5ng( thu ph\u00ED )"},
				{"H\u1EE7y v\u00E9", "\u00E1p d\u1EE5ng( thu ph\u00ED )", "\u00E1p d\u1EE5ng( thu ph\u00ED )", "\u00E1p d\u1EE5ng( thu ph\u00ED )", "\u00E1p d\u1EE5ng( thu ph\u00ED )"},
			},
			new String[] {
				"Lo\u1EA1i v\u00E9", "H\u1EA1ng th\u01B0\u01A1ng gia", "H\u1EA1ng ph\u1ED5 th\u00F4ng \u0111\u1EB7c bi\u1EC7t", "Ph\u1ED5 th\u00F4ng ti\u00EAu chu\u1EA9n", "H\u1EA1ng ph\u1ED5 th\u00F4ng ti\u1EBFt ki\u1EC7m"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(137);
		table.getColumnModel().getColumn(3).setPreferredWidth(124);
		table.getColumnModel().getColumn(4).setPreferredWidth(139);
		
		lb_tieu_de = new JLabel("ĐIỀU KIỆN VÉ");
		lb_tieu_de.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tieu_de.setForeground(new Color(255, 0, 0));
		lb_tieu_de.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_tieu_de.setBounds(140, 24, 487, 48);
		contentPane.add(lb_tieu_de);
	}
}
