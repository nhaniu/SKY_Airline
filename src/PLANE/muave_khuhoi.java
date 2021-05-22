package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;

public class muave_khuhoi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muave_khuhoi frame = new muave_khuhoi();
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
	public muave_khuhoi() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 583, 247);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_noidi = new JLabel("Nơi đi:");
		lb_noidi.setBounds(10, 28, 49, 14);
		contentPane.add(lb_noidi);
		
		JComboBox comboBox_noidi = new JComboBox();
		comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(69, 24, 183, 22);
		contentPane.add(comboBox_noidi);
		
		JLabel lb_noiden = new JLabel("Nơi đến:");
		lb_noiden.setBounds(276, 28, 68, 14);
		contentPane.add(lb_noiden);
		
		JComboBox comboBox_noiden = new JComboBox();
		comboBox_noiden.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noiden.setBounds(342, 24, 183, 22);
		contentPane.add(comboBox_noiden);
		
		JLabel lb_ngaydi = new JLabel("Ngày đi:");
		lb_ngaydi.setBounds(10, 72, 68, 14);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 66, 140, 20);
		contentPane.add(dateChooser);
		
		JLabel lb_ngayden = new JLabel("Ngày đến:");
		lb_ngayden.setBounds(276, 72, 68, 14);
		contentPane.add(lb_ngayden);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(342, 66, 140, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lb_nguoilon = new JLabel("Người lớn:");
		lb_nguoilon.setBounds(10, 117, 68, 14);
		contentPane.add(lb_nguoilon);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(76, 113, 49, 22);
		contentPane.add(comboBox);
		
		JLabel lb_treem = new JLabel("Trẻ em: ");
		lb_treem.setBounds(168, 117, 49, 14);
		contentPane.add(lb_treem);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_1.setBounds(227, 113, 49, 22);
		contentPane.add(comboBox_1);
		
		JLabel lb_embe = new JLabel("Em bé: ");
		lb_embe.setBounds(317, 117, 49, 14);
		contentPane.add(lb_embe);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_2.setBounds(376, 113, 49, 22);
		contentPane.add(comboBox_2);
		
		JButton bt_timchuyebay = new JButton("Tìm chuyến bay");
		bt_timchuyebay.setBackground(new Color(0, 191, 255));
		bt_timchuyebay.setBounds(35, 176, 145, 23);
		contentPane.add(bt_timchuyebay);
		
		JLabel lb_12t = new JLabel(">=12 tuổi");
		lb_12t.setBounds(76, 151, 68, 14);
		contentPane.add(lb_12t);
		
		JLabel lb_2_11t = new JLabel("2-11 tuổi");
		lb_2_11t.setBounds(227, 151, 68, 14);
		contentPane.add(lb_2_11t);
		
		JLabel lb_2t = new JLabel("<2 tuổi");
		lb_2t.setBounds(376, 151, 49, 14);
		contentPane.add(lb_2t);
	}
}
