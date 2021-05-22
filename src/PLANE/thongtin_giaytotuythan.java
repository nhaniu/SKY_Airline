package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class thongtin_giaytotuythan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongtin_giaytotuythan frame = new thongtin_giaytotuythan();
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
	public thongtin_giaytotuythan() {
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 1034, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 85, 1001, 384);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1. Đối với các chuyến bay nội địa:", "", "1.1. Hành khách mang quốc tịch nước ngoài có thể sử dụng các loại giấy tờ sau:", "", "a. Hộ chiếu nước ngoài hoặc giấy thông hành, thị thực rời, thẻ thường trú, thẻ tạm trú do Việt Nam cấp (lưu ý các loại giấy tờ này phải có dấu xuất, nhập cảnh Việt ", "Nam theo quy định).", "", "b. Trong trường hợp hành khách mất hộ chiếu, phải có công hàm của cơ quan ngoại giao, lãnh sự của quốc gia hành khách mang quốc tịch hoặc công văn của sở", " ngoại vụ, cơ quan công an địa phương nơi mất xác nhận nhân thân và việc mất hộ chiếu của hành khách, có dán ảnh, dấu giáp lai. Công hàm, công văn xác nhận", "có giá trị sử dụng 30 ngày kể từ ngày xác nhận.", "", "c. Các loại chứng minh thư do cơ quan ngoại giao cấp cho thành viên cơ quan đại diện ngoại giao, cơ quan lãnh sự, cơ quan đại diện của tổ chức quốc tế như:", " Chứng minh thư ngoại giao, Chứng minh thư lãnh sự, Chứng minh thư công vụ, Chứng minh thư lãnh sự danh dự, Chứng minh thư phổ thông theo quy định tại", " Quyết định số 2771/2007/QĐ-BNG-LT ngày 07/11/2007. Loại giấy tờ này được đính chính tại Quyết định số 1281/QĐ-BGTVT ngày 26/4/2016 của Bộ GTVT.", "", "1.2. Hành khách mang quốc tịch Việt Nam dưới 14 tuổi không có hộ chiếu riêng hoặc kèm hộ chiếu của cha mẹ có thể sử dụng một trong các loại giấy tờ sau:", "", "a. Giấy khai sinh; trường hợp dưới 01 tháng tuổi chưa có giấy khai sinh thì phải có giấy chứng sinh;", "", "b. Giấy xác nhận của tổ chức xã hội đối với trẻ em do tổ chức xã hội đang nuôi dưỡng, chỉ có giá trị sử dụng trong thời gian 06 tháng kể từ ngày xác nhận.", "", "1.3. Hành khách mang quốc tịch Việt Nam từ 14 tuổi trở lên có thể sử dụng các loại giấy tờ sau:", "a. Hộ chiếu", "", "", "b. Giấy thông hành (bao gồm loại giấy thông hành đi qua các tỉnh biên giới tiếp giáp với Việt Nam)", "", "c. Thị thực rời", "", "d. Thẻ thường trú, thẻ tạm trú", "", "e. Chứng minh nhân dân, thẻ Căn cước công dân", "", "f. Giấy chứng minh, chứng nhận của các lực lượng vũ trang", "", "g. Thẻ Đại biểu Quốc hội", "", "h. Thẻ Đảng viên", "", "i. Thẻ Nhà báo", "", "j. Giấy phép lái xe ô tô", "", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("YÊU CẦU VỀ GIẤY TỜ TÙY THÂN");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(286, 31, 383, 40);
		contentPane.add(lblNewLabel);
	}

}
