package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tracuu_changdung extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tracuu_changdung frame = new tracuu_changdung();
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
	public tracuu_changdung() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 707, 266);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_noidi = new JLabel("Nơi đi: ");
		lb_noidi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noidi.setBounds(24, 86, 150, 36);
		contentPane.add(lb_noidi);
		
		JLabel lb_title = new JLabel("Tra cứu chặng dừng");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(110, 10, 451, 45);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 673, 20);
		contentPane.add(separator);
		
//		Hà Nội (HAN), Việt Nam
//		Tp. Hồ Chí Minh (SGN), Việt Nam
//		Đà Nẵng (DAD), Việt Nam
//		Phú Quốc (PQC), Việt Nam
//		Nha Trang (CXR), Việt Nam
//		Buôn Ma Thuột (BMV), Việt Nam
//		Đồng Hới (VDH), Việt Nam
//		
		final JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_noiden.setBounds(431, 94, 232, 22);
		contentPane.add(comboBox_noiden);
		
		final JComboBox comboBox_noidi = new JComboBox();
		comboBox_noidi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox_noidi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(90, 94, 232, 20);
		contentPane.add(comboBox_noidi);
		
		JLabel lblNewLabel_noiden = new JLabel("Nơi đến: ");
		lblNewLabel_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_noiden.setBounds(357, 98, 77, 16);
		contentPane.add(lblNewLabel_noiden);
		
		
		
		JButton bt_tracuu = new JButton("Tra cứu");
		bt_tracuu.setBackground(new Color(135, 206, 250));
		bt_tracuu.setForeground(new Color(0, 0, 0));
		bt_tracuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_tracuu.setBounds(110, 154, 116, 30);
		contentPane.add(bt_tracuu);
	}
}
