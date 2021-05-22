package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;
import com.toedter.calendar.JDateChooser;

//import sun.security.krb5.internal.tools.Ktab;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

public class muave_nhieuchang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muave_nhieuchang frame = new muave_nhieuchang();
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
	Boolean kt= false;
    int n=1;
	public muave_nhieuchang() {
		setTitle("SKY Airline");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 959, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		//final JPanel panels[] = new JPanel[6];
	    JPanel panel_0 = new JPanel();
	    panel_0.setBackground(new Color(240, 255, 255));
		panel_0.setBounds(10, 162, 925, 33);
		panel_0.setLayout(null);
		
		
		JLabel lb_noi_di_0 = new JLabel("Nơi đi: ");
		lb_noi_di_0.setBounds(109, 9, 46, 13);
		panel_0.add(lb_noi_di_0);
		
		JLabel lb_noi_den_0 = new JLabel("Nơi đến:");
		lb_noi_den_0.setBounds(396, 9, 66, 13);
		panel_0.add(lb_noi_den_0);
		
		JLabel lb_ngay_di_0 = new JLabel("Ngày đi:");
		lb_ngay_di_0.setBounds(682, 9, 72, 13);
		panel_0.add(lb_ngay_di_0);
		
		JComboBox comboBox_noi_di_0 = new JComboBox();
		comboBox_noi_di_0.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noi_di_0.setBounds(165, 5, 211, 21);
		panel_0.add(comboBox_noi_di_0);
		
		JComboBox comboBox_noi_den_0 = new JComboBox();
		comboBox_noi_den_0.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noi_den_0.setBounds(462, 5, 198, 21);
		panel_0.add(comboBox_noi_den_0);
		
		JDateChooser dateChooser_0 = new JDateChooser();
		dateChooser_0.setBounds(755, 9, 140, 19);
		panel_0.add(dateChooser_0);
		
		
		
		
		JLabel lblChuynBay_0 = new JLabel("Chuyến bay 1: ");
		lblChuynBay_0.setBounds(10, 9, 89, 13);
		panel_0.add(lblChuynBay_0);
		
		JButton bt_tim_chuyen_bay = new JButton("Tìm chuyến bay");
		bt_tim_chuyen_bay.setBackground(new Color(0, 191, 255));
		bt_tim_chuyen_bay.setBounds(564, 103, 281, 21);
		contentPane.add(bt_tim_chuyen_bay);
		
		contentPane.add(panel_0);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 205, 925, 33);
		contentPane.add(panel_1);
		JLabel lb_noi_di_1 = new JLabel("Nơi đi: ");
		lb_noi_di_1.setBounds(109, 9, 46, 13);
		panel_1.add(lb_noi_di_1);
		
		JLabel lb_noi_den_1 = new JLabel("Nơi đến:");
		lb_noi_den_1.setBounds(396, 9, 66, 13);
		panel_1.add(lb_noi_den_1);
		
		JLabel lb_ngay_di_1 = new JLabel("Ngày đi:");
		lb_ngay_di_1.setBounds(682, 9, 72, 13);
		panel_1.add(lb_ngay_di_1);
		
		JComboBox comboBox_noi_di_1 = new JComboBox();
		comboBox_noi_di_1.setBounds(165, 5, 211, 21);
		comboBox_noi_di_1.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		panel_1.add(comboBox_noi_di_1);
		
		JComboBox comboBox_noi_den_1 = new JComboBox();
		comboBox_noi_den_1.setBounds(462, 5, 198, 21);
		comboBox_noi_den_1.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		panel_1.add(comboBox_noi_den_1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(755, 9, 140, 19);
		panel_1.add(dateChooser_1);
		
		JLabel lblChuynBay_1 = new JLabel("Chuyến bay 2: ");
		lblChuynBay_1.setBounds(10, 9, 89, 13);
		panel_1.add(lblChuynBay_1);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 248, 925, 33);
		contentPane.add(panel_2);
		
		JLabel lb_noi_di_2 = new JLabel("Nơi đi: ");
		lb_noi_di_2.setBounds(109, 9, 46, 13);
		panel_2.add(lb_noi_di_2);
		
		JLabel lb_noi_den_2 = new JLabel("Nơi đến:");
		lb_noi_den_2.setBounds(396, 9, 66, 13);
		panel_2.add(lb_noi_den_2);
		
		JLabel lb_ngay_di_2 = new JLabel("Ngày đi:");
		lb_ngay_di_2.setBounds(682, 9, 72, 13);
		panel_2.add(lb_ngay_di_2);
		
		JComboBox comboBox_noi_di_2 = new JComboBox();
		comboBox_noi_di_2.setBounds(165, 5, 211, 21);
		panel_2.add(comboBox_noi_di_2);
		
		JComboBox comboBox_noi_den_2 = new JComboBox();
		comboBox_noi_den_2.setBounds(462, 5, 198, 21);
		panel_2.add(comboBox_noi_den_2);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(755, 9, 140, 19);
		panel_2.add(dateChooser_2);
		
		
		JLabel lblChuynBay_2 = new JLabel("Chuyến bay 3: ");
		lblChuynBay_2.setBounds(10, 9, 89, 13);
		panel_2.add(lblChuynBay_2);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 291, 925, 33);
		contentPane.add(panel_3);
		
		JLabel lb_noi_di_3 = new JLabel("Nơi đi: ");
		lb_noi_di_3.setBounds(109, 9, 46, 13);
		panel_3.add(lb_noi_di_3);
		
		JLabel lb_noi_den_3 = new JLabel("Nơi đến:");
		lb_noi_den_3.setBounds(396, 9, 66, 13);
		panel_3.add(lb_noi_den_3);
		
		JLabel lb_ngay_di_3 = new JLabel("Ngày đi:");
		lb_ngay_di_3.setBounds(682, 9, 72, 13);
		panel_3.add(lb_ngay_di_3);
		
		JComboBox comboBox_noi_di_3 = new JComboBox();
		comboBox_noi_di_3.setBounds(165, 5, 211, 21);
		panel_3.add(comboBox_noi_di_3);
		
		JComboBox comboBox_noi_den_3 = new JComboBox();
		comboBox_noi_den_3.setBounds(462, 5, 198, 21);
		panel_3.add(comboBox_noi_den_3);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(755, 9, 140, 19);
		panel_3.add(dateChooser_3);
		
		JLabel lblChuynBay_3 = new JLabel("Chuyến bay 4: ");
		lblChuynBay_3.setBounds(10, 9, 89, 13);
		panel_3.add(lblChuynBay_3);
		
		final JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(10, 334, 925, 33);
		contentPane.add(panel_4);
		
		JLabel lb_noi_di_4 = new JLabel("Nơi đi: ");
		lb_noi_di_4.setBounds(109, 9, 46, 13);
		panel_4.add(lb_noi_di_4);
		
		JLabel lb_noi_den_4 = new JLabel("Nơi đến:");
		lb_noi_den_4.setBounds(396, 9, 66, 13);
		panel_4.add(lb_noi_den_4);
		
		JLabel lb_ngay_di_4 = new JLabel("Ngày đi:");
		lb_ngay_di_4.setBounds(682, 9, 72, 13);
		panel_4.add(lb_ngay_di_4);
		
		JComboBox comboBox_noi_di_4 = new JComboBox();
		comboBox_noi_di_4.setBounds(165, 5, 211, 21);
		panel_4.add(comboBox_noi_di_4);
		
		JComboBox comboBox_noi_den_4 = new JComboBox();
		comboBox_noi_den_4.setBounds(462, 5, 198, 21);
		panel_4.add(comboBox_noi_den_4);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(755, 9, 140, 19);
		panel_4.add(dateChooser_4);
		
		JLabel lblChuynBay_4 = new JLabel("Chuyến bay 5: ");
		lblChuynBay_4.setBounds(10, 9, 89, 13);
		panel_4.add(lblChuynBay_4);
		
		final JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 255, 255));
		panel_5.setLayout(null);
		panel_5.setBounds(10, 377, 925, 33);
		contentPane.add(panel_5);
		
		JLabel lb_noi_di_5 = new JLabel("Nơi đi: ");
		lb_noi_di_5.setBounds(109, 9, 46, 13);
		panel_5.add(lb_noi_di_5);
		
		JLabel lb_noi_den_5 = new JLabel("Nơi đến:");
		lb_noi_den_5.setBounds(396, 9, 66, 13);
		panel_5.add(lb_noi_den_5);
		
		JLabel lb_ngay_di_5 = new JLabel("Ngày đi:");
		lb_ngay_di_5.setBounds(682, 9, 72, 13);
		panel_5.add(lb_ngay_di_5);
		
		JComboBox comboBox_noi_di_5 = new JComboBox();
		comboBox_noi_di_5.setBounds(165, 5, 211, 21);
		panel_5.add(comboBox_noi_di_5);
		
		JComboBox comboBox_noi_den_5 = new JComboBox();
		comboBox_noi_den_5.setBounds(462, 5, 198, 21);
		panel_5.add(comboBox_noi_den_5);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(755, 9, 140, 19);
		panel_5.add(dateChooser_5);
		
		JLabel lblChuynBay_5 = new JLabel("Chuyến bay 6: ");
		lblChuynBay_5.setBounds(10, 9, 89, 13);
		panel_5.add(lblChuynBay_5);
		
		comboBox_noi_di_2.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_den_2.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_di_3.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_den_3.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_di_4.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_den_4.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_di_5.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		comboBox_noi_den_5.setModel(new DefaultComboBoxModel(new String[] {"Tp. Hồ Chí Minh (SGN), Việt Nam", "Hà Nội (HAN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));

		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		
		JButton btnThem = new JButton("Thêm chuyến bay");
		btnThem.setBackground(new Color(0, 191, 255));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n<5)
				{
					n++;
					switch (n) {
					case 2:
						turnOn(panel_2);
						break;
					case 3:
						turnOn(panel_3);
						break;
					case 4:
						turnOn(panel_4);
						break;
					case 5:
						turnOn(panel_5);
						break;
					}
				}
			}
		});
		btnThem.setBounds(69, 103, 158, 21);
		contentPane.add(btnThem);
		
		JButton btnBot = new JButton("Giảm chuyến bay");
		btnBot.setBackground(new Color(0, 191, 255));
		btnBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n>1)
				{
					
					switch (n) {
					case 2:
						turnOff(panel_2);
						break;
					case 3:
						turnOff(panel_3);
						break;
					case 4:
						turnOff(panel_4);
						break;
					case 5:
						turnOff(panel_5);
						break;
					}
					n--;
				}
			}
		});
		btnBot.setBounds(284, 103, 158, 21);
		contentPane.add(btnBot);
	}
	public void turnOn(JPanel a)
	{
		a.setVisible(true);
	}
	public void turnOff(JPanel a)
	{
		a.setVisible(false);
	}
}