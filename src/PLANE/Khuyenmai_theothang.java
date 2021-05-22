package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;

public class Khuyenmai_theothang extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Khuyenmai_theothang frame = new Khuyenmai_theothang();
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
	public Khuyenmai_theothang() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 638, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 56, 571, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"01/01/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"02/02/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"03/03/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"04/04/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"05/05/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"06/06/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"07/07/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"08/08/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"09/09/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"10/10/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"11/11/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
				{"12/12/2021", "Khuy\u1EBFn m\u00E3i h\u00E0ng th\u00E1ng", "10%"},
			},
			new String[] {
				"Th\u1EDDi gian", "N\u1ED9i dung", "\u01AFu \u0111\u00E3i"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
		table.getColumnModel().getColumn(1).setPreferredWidth(206);
		scrollPane.setViewportView(table);
		
		JTextArea textarea_luuy = new JTextArea();
		textarea_luuy.setBackground(new Color(240, 255, 255));
		textarea_luuy.setForeground(new Color(255, 0, 0));
		textarea_luuy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textarea_luuy.setWrapStyleWord(true);
		textarea_luuy.setLineWrap(true);
		textarea_luuy.setText("* Lưu ý:\r\n - Khuyến mãi chỉ áp dụng cho hạng thương gia và hạng phổ thông đặc biệt");
		textarea_luuy.setBounds(30, 298, 558, 78);
		contentPane.add(textarea_luuy);
	}
}
