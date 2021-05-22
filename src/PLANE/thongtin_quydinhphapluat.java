package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class thongtin_quydinhphapluat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongtin_quydinhphapluat frame = new thongtin_quydinhphapluat();
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
	public thongtin_quydinhphapluat() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 797, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 0, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea text_quydinh = new JTextArea();
		text_quydinh.setEditable(false);
		text_quydinh.setBackground(new Color(240, 255, 255));
		text_quydinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		text_quydinh.setText("Luật Hàng không dân dụng Việt Nam.\r\n\r\nThông tư số 36/2014/TT-BGTVT ngày 29/8/2014 của Bộ Giao thông vận tải quy định chất lượng dịch vụ hành khách tại cảng hàng không.\r\n\r\nThông tư số 81/2014/TT-BGTVT ngày 30/12/2014 của Bộ Giao thông vận tải quy định về việc vận chuyển hàng không và hoạt động hàng không chung.\r\n\r\nThông tư số 14/2015/TT-BGTVT ngày 27/4/2015 của Bộ Giao thông vận tải quy định về việc bồi thường ứng trước không hoàn lại trong vận chuyển hành khách bằng đường hàng không.\r\n\r\nThông tư số 27/2017/TT-BGTVT ngày 25/8/2017 của Bộ Giao thông vận tải quy định về việc sửa đổi, bổ sung một số điều của Thông tư 36/2014/TT-BGTVT ngày 29/8/2014 của Bộ Giao thông vận tải quy định chất lượng dịch vụ hành khách tại cảng hàng không và Thông tư số 14/2015/TT-BGTVT ngày 27/4/2015 của Bộ Giao thông vận tải quy định về việc bồi thường ứng trước không hoàn lại trong vận chuyển hành khách bằng đường hàng không.");
		text_quydinh.setWrapStyleWord(true);
		text_quydinh.setLineWrap(true);
		text_quydinh.setBounds(30, 108, 713, 304);
		contentPane.add(text_quydinh);
		
		JLabel lb_tieude = new JLabel("CÁC QUY ĐỊNH PHÁP LUẬT LIÊN QUAN");
		lb_tieude.setForeground(new Color(255, 0, 0));
		lb_tieude.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lb_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lb_tieude.setBounds(123, 31, 520, 52);
		contentPane.add(lb_tieude);
	}

}
