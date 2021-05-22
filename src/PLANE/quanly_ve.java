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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class quanly_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_ve frame = new quanly_ve();
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
	public quanly_ve() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 728, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thông tin vé máy bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(234, 11, 273, 44);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 704, 2);
		contentPane.add(separator);
		
		JLabel lb_mcb = new JLabel("Mã chuyến bay:");
		lb_mcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mcb.setBounds(39, 127, 160, 19);
		contentPane.add(lb_mcb);
		
		textField = new JTextField();
		textField.setBounds(175, 127, 175, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 208, 626, 166);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "CHUYENBAY_ID", "HANGVE_ID", "GIA"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(418, 126, 127, 23);
		contentPane.add(btnNewButton);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new them_ve();
			}
		});
		bt_them.setBackground(new Color(135, 206, 250));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(136, 404, 116, 31);
		contentPane.add(bt_them);
		
		JButton btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(467, 408, 127, 23);
		contentPane.add(btnNewButton_1);
	}
}
