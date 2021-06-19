package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

public class nhapthongtin_mv1chieu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ho;
	private JTextField textField_sdt;
	private JTextField textField_email;

	static String gio_kh_di = new String();
	static String gio_hc_di = new String();
	static String h_ve_di = new String();
	static String gia_ve_di = new String();
	static String noi_di = new String();
	static String noi_den = new String();
	static String gio_kh_ve= new String();
	static String gio_hc_ve = new String();
	static String h_ve_ve = new String();
	static String gia_ve_ve = new String();
	
	/**
	 * Launch the application.
	 */
	
	public static boolean checkNumberPhone(String str)
    {
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)<'0' || str.charAt(i)>'9') return false;
        return true;
    }
	
	public static boolean checkMail(String str)
    {
        int idofAt=str.indexOf('@');
        if(idofAt==-1) return false;
        String temp=str.substring(idofAt,str.length());
        int idofDot = str.indexOf('.');
        if(idofDot==-1) return false;
        return true;
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhapthongtin_mv1chieu frame = new nhapthongtin_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve);
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
	@SuppressWarnings("unchecked")
	public nhapthongtin_mv1chieu(String a, String b, String c, String d, String e, String f, String g, String h, String i, String k) {
		gio_kh_di = a;
		gio_hc_di = b;
		h_ve_di = c;
		gia_ve_di = d;
		noi_di = e;
		noi_den = f;
		gio_kh_ve = g;
		gio_hc_ve = h;
		h_ve_ve = i;
		gia_ve_ve = k;
		
		setBackground(new Color(224, 255, 255));
		setTitle("SKY Airline ");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1203, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nhập thông tin hành khách ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(268, 10, 393, 41);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Danh xưng");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(66, 151, 110, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblHvdNguyn = new JLabel("Họ và tên (VD: Nguyễn Thị Nhân )");
		lblHvdNguyn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblHvdNguyn.setBounds(212, 151, 245, 30);
		contentPane.add(lblHvdNguyn);

		final JComboBox comboBox_danhxung = new JComboBox();
		comboBox_danhxung.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_danhxung.setModel(new DefaultComboBoxModel(new String[] { "Ông", "Bà", "Cô/ Chị" }));
		comboBox_danhxung.setBounds(65, 187, 96, 21);
		contentPane.add(comboBox_danhxung);

		textField_Ho = new JTextField();
		textField_Ho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Ho.setBounds(212, 187, 305, 21);
		contentPane.add(textField_Ho);
		textField_Ho.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nhập thông tin cơ bản (bắt buộc)");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(66, 88, 297, 30);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ngày sinh");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(66, 237, 180, 30);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_7 = new JLabel("Nhập thông tin liên hệ ");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(66, 407, 317, 30);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Số điện thoại ");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(66, 459, 126, 30);
		contentPane.add(lblNewLabel_8);
		

		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_sdt.setBounds(66, 491, 180, 21);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Email ");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(344, 459, 87, 30);
		contentPane.add(lblNewLabel_9);

		textField_email = new JTextField();
		textField_email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_email.setBounds(344, 491, 237, 21);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(212, 237, 156, 21);
		contentPane.add(dateChooser);
		
		JLabel label_quoctich = new JLabel("Quốc tịch ");
		label_quoctich.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		label_quoctich.setBounds(66, 279, 126, 30);
		contentPane.add(label_quoctich);
		
		final JComboBox comboBox_quoctich = new JComboBox();
		comboBox_quoctich.setModel(new DefaultComboBoxModel(new String[] {"VIỆT NAM", "ENGLAND", "OTHER"}));
		comboBox_quoctich.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_quoctich.setBounds(212, 277, 156, 21);
		contentPane.add(comboBox_quoctich);

		final JButton button_tieptuc = new JButton("Tiếp tục ");
		button_tieptuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String danh_xung = new String();
				String hoten_hk = new String();
				Date ngaysinh = new Date();
				String sodt = new String();
				String email = new String();
				String quoctich = new String();
				
				danh_xung = comboBox_danhxung.getSelectedItem().toString();
			    hoten_hk = textField_Ho.getText().toString();
			    ngaysinh = dateChooser.getDate();
			    sodt = textField_sdt.getText();
			    email = textField_email.getText();
			    quoctich = comboBox_quoctich.getSelectedItem().toString();
			    
				if (textField_Ho.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					 textField_Ho.requestFocus();
					 return; 
				}
				else if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					 textField_sdt.requestFocus();
					 return; 
				}
				else if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					 textField_email.requestFocus();
					 return; 
				}
				if(checkNumberPhone(sodt) == false) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số điện thoại!");
					 textField_sdt.requestFocus();
					 return;
				}
				else if(checkMail(email) == false){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng tài khoản email!");
					 textField_sdt.requestFocus();
					 return;
				}
				
			    mv1chieu_dichvu_botro obj = new mv1chieu_dichvu_botro(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve, danh_xung, hoten_hk, ngaysinh, sodt, email, quoctich);
				obj.setVisible(true);
				dispose();
				
			}
		});
		button_tieptuc.setBackground(new Color(173, 255, 47));
		button_tieptuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_tieptuc.setBounds(291, 567, 110, 30);
		contentPane.add(button_tieptuc);
		button_tieptuc.setVisible(false);

		Checkbox checkbox = new Checkbox("Xác nhận thông tin hành khách ");
		checkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				button_tieptuc.setVisible(true);
			}
		});
		checkbox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		checkbox.setBounds(66, 349, 237, 21);
		contentPane.add(checkbox);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(670, 88, 497, 492);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 497, 61);
		panel.add(panel_1);

		JLabel lblNewLabel_10 = new JLabel("SKY AIRLINE ");
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(255, 140, 0));
		lblNewLabel_10.setFont(new Font("Segoe UI Black", Font.ITALIC, 30));

		JLabel Tong_tien = new JLabel("Tổng tiền: ");
		Tong_tien.setForeground(new Color(255, 0, 0));
		Tong_tien.setFont(new Font("Tahoma", Font.BOLD, 24));
		Tong_tien.setBounds(70, 411, 156, 29);
		panel.add(Tong_tien);
		
		JLabel Label_Gia_ve = new JLabel("");
		Label_Gia_ve.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_Gia_ve.setForeground(Color.RED);
		Label_Gia_ve.setBackground(Color.WHITE);
		Label_Gia_ve.setBounds(227, 411, 212, 29);
		panel.add(Label_Gia_ve);
		Label_Gia_ve.setText(d + " VND"); 
		
		JLabel Label_Ngay_Gio_kh = new JLabel("New label");
		Label_Ngay_Gio_kh.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_kh.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Ngay_Gio_kh.setBounds(240, 208, 212, 29);
		panel.add(Label_Ngay_Gio_kh);
		Label_Ngay_Gio_kh.setText(a);
		
		JLabel Label_Ngay_Gio_hc = new JLabel("New label");
		Label_Ngay_Gio_hc.setForeground(new Color(0, 0, 205));
		Label_Ngay_Gio_hc.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_Ngay_Gio_hc.setBounds(240, 267, 224, 29);
		panel.add(Label_Ngay_Gio_hc);
		Label_Ngay_Gio_hc.setText(b);
		
		JLabel Label_Hang_ve = new JLabel("New label");
		Label_Hang_ve.setForeground(new Color(210, 105, 30));
		Label_Hang_ve.setFont(new Font("Tahoma", Font.BOLD, 18));
		Label_Hang_ve.setBounds(103, 330, 318, 37);
		panel.add(Label_Hang_ve);
		Label_Hang_ve.setText(c);
		
		JLabel lblNewLabel_11 = new JLabel("Ngày giờ khởi hành: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(47, 213, 169, 19);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ngày giờ hạ cánh:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(47, 272, 156, 19);
		panel.add(lblNewLabel_12);
		
		JLabel Label_noidi = new JLabel("New label");
		Label_noidi.setForeground(new Color(0, 0, 205));
		Label_noidi.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_noidi.setBounds(189, 101, 310, 19);
		panel.add(Label_noidi);
		Label_noidi.setText(e);
		
		JLabel Label_noiden = new JLabel("New label");
		Label_noiden.setForeground(new Color(0, 0, 205));
		Label_noiden.setFont(new Font("Tahoma", Font.BOLD, 16));
		Label_noiden.setBounds(189, 154, 310, 19);
		panel.add(Label_noiden);
		Label_noiden.setText(f);
		
		JLabel noidi = new JLabel("Điểm đi:");
		noidi.setFont(new Font("Tahoma", Font.BOLD, 16));
		noidi.setBounds(47, 98, 132, 24);
		panel.add(noidi);
		
		JLabel noiden = new JLabel("Điểm đến:");
		noiden.setFont(new Font("Tahoma", Font.BOLD, 16));
		noiden.setBounds(47, 154, 94, 18);
		panel.add(noiden);

	}
}
