package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class khuyenmai_khachhang_thanthiet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khuyenmai_khachhang_thanthiet frame = new khuyenmai_khachhang_thanthiet();
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
	public khuyenmai_khachhang_thanthiet() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 729, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thông tin khuyến mãi dành cho khách hàng thân thiết");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(72, 22, 606, 38);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 77, 695, 9);
		contentPane.add(separator);
		
		JTextArea txtrViMiLn = new JTextArea();
		txtrViMiLn.setEditable(false);
		txtrViMiLn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrViMiLn.setBackground(new Color(240, 255, 255));
		txtrViMiLn.setWrapStyleWord(true);
		txtrViMiLn.setLineWrap(true);
		txtrViMiLn.setText("    Với mỗi lần thanh toán, khách hàng mua vé với số tiền 500 000vnd sẽ được tích điểm vào tài khoản với số điểm là 1 điểm.\r\n\r\n    Để đạt hạng bạc, khách hàng cần đạt từ 20-30 điểm, Nếu khách hàng đồng ý đổi điểm, khách hàng sẽ được giảm 50 000vnd cho lần mua vé tiếp theo.\r\n\r\n    Để đạt hạng vàng, khách hàng cần đạt từ 31-50 điểm, Nếu khách hàng đồng ý đổi điểm, khách hàng sẽ được giảm 100 000vnd cho lần mua vé tiếp theo.\r\n\r\n    Để đạt hạng kim cương, khách hàng cần đạt từ 51 điểm trở lên, Nếu khách hàng đồng ý đổi điểm, khách hàng sẽ được giảm 150 000vnd cho lần mua vé tiếp theo.");
		txtrViMiLn.setBounds(73, 131, 586, 248);
		contentPane.add(txtrViMiLn);
		
	}
}
