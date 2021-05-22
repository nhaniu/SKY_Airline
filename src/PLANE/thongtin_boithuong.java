package PLANE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;


public class thongtin_boithuong extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongtin_boithuong frame = new thongtin_boithuong();
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
	public thongtin_boithuong() {
		setTitle("SKY Airline");
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 873, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
        setVisible(true);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 88, 839, 367);
		contentPane.add(scrollPane);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JList list = new JList();
        list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        list.setModel(new AbstractListModel() {
        	String[] values = new String[] {"", "", "1. Áp dụng: Đối với các chuyến bay xuất phát từ Việt Nam.", "", "2. Chúng tôi được miễn trừ nghĩa vụ bồi thường ứng trước không hoàn lại trong trường hợp hủy chuyến bay hoặc chuyến bay bị", " chậm kéo dài vì một trong các lý do sau đây:", "", "a. Điều kiện thời tiết ảnh hưởng đến khai thác an toàn chuyến bay.", "", "b. Nguy cơ an ninh ảnh hưởng đến khai thác an toàn chuyến bay.", "", "c. Chuyến bay không thể thực hiện hoặc bị chậm kéo dài theo quyết định của cơ quan nhà nước có thẩm quyền.", "", "d. Do những vấn đề về y tế của hành khách (bị ốm nặng hoặc chết sau khi đã lên tàu bay).", "", "e. Tàu bay theo lịch dự kiến để khai thác chuyến bay bị phá hoại hoặc đội tàu bay bị phá hoại.", "", "f. Do xung đột vũ trang, mất ổn định chính trị, đình công làm ảnh hưởng đến chuyến bay.", "", "g. Trong trường hợp kết cấu hạ tầng hàng không, dịch vụ bảo đảm hoạt động bay không đảm bảo cho việc thực hiện chuyến bay.", "", "", "i. Hành khách không có mặt làm thủ tục hàng không tại cảng hàng không hoặc địa điểm khác theo thỏa thuận với Chúng tôi.", "", "k. Hành khách tự nguyện từ bỏ xác nhận chỗ.", "3. Hình thức bồi thường:", "", "a. Tiền mặt", "", "b. Chuyển khoản ngân hàng hoặc thông qua các dịch vụ trung gian thanh toán phù hợp khác trong tường hợp khách yêu cầu", "", "c. Vé miễn cước, chứng từ bồi hoàn để sử dụng tiếp dịch vụ của người vận chuyển hoặc các dịch vụ miễn phí khác trong trường", " hợp khách chấp thuận.", "", " ", "", "4. Địa điểm nhận bồi thường:", "", "a. Tại Cảng hàng không nơi hủy chuyến bay hoặc nơi cất, hạ cánh.", "", "b. Tại chi nhánh hoặc văn phòng đại diện của người vận chuyển được người vận chuyển", "", "chỉ định.", "", "c. Vào tài khoản do hành khách cung cấp.", "", " "};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        scrollPane.setViewportView(list);
        
        JTextArea txtrBiThngng = new JTextArea();
        txtrBiThngng.setEditable(false);
        txtrBiThngng.setForeground(new Color(255, 0, 0));
        txtrBiThngng.setBackground(new Color(240, 255, 255));
        txtrBiThngng.setWrapStyleWord(true);
        txtrBiThngng.setFont(new Font("Times New Roman", Font.BOLD, 18));
        txtrBiThngng.setLineWrap(true);
        txtrBiThngng.setText("BỒI THƯỜNG ỨNG TRƯỚC KHÔNG HOÀN LẠI TRONG TRƯỜNG HỢP HỦY CHUYẾN, CHẬM KÉO DÀI");
        txtrBiThngng.setBounds(10, 23, 839, 59);
        contentPane.add(txtrBiThngng);
			
		}
	}

