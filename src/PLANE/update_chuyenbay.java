package PLANE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class update_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID_NQL;
	private JTextField textField_tongsove;
	private JTextField textField_ID;
	private static JComboBox comboBox_noidi;
	private static JComboBox comboBox_noiden;
	Connection con;
	private JLabel lbHVTG;
	private JLabel lbPTĐB;
	private JLabel lblPTLH;
	private JLabel lblNewLabel_5;
	private JTextField txtTG;
	private JTextField txtPTĐB;
	private JTextField txtPTLH;
	private JTextField txtPTTK;
	private static JComboBox comboBox;

 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_chuyenbay frame = new update_chuyenbay();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public update_chuyenbay() {
		initComponent();
		//loadCombobox();
		//loadCombobox1();
		loadCombobox2();
		Teststringcomparison (toString(), toString());
	}
	/**
	 * Create the frame.
	 */
	public static boolean Teststringcomparison (Object object, Object object2){
		object = comboBox_noidi.getSelectedItem().toString();
		object2 = comboBox_noiden.getSelectedItem().toString();
		if (object.equals(object2)) {
			System.out.println("Giống");
			return true;
		}
		System.out.println("K giống");
		return false;
		}
	public void loadCombobox() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noidi.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noiden.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox2() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select ID from TTMAYBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
		}}
	
	public void initComponent() {
		
		
		
			quanly_chuyenbay qlcb=null;
		
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 865, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Cập nhật chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(229, 15, 306, 34);
		contentPane.add(lb_title);
		
		JLabel lb_sbdi = new JLabel("Sân bay đi: ");
		lb_sbdi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sbdi.setBounds(34, 121, 102, 18);
		contentPane.add(lb_sbdi);
		
		
		 comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(172, 154, 186, 22);
		contentPane.add(comboBox_noiden);

		
		comboBox_noiden.setSelectedItem(qlcb.sanbayden);

		
		 comboBox_noidi = new JComboBox();
		//comboBox_noidi.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội (HAN), Việt Nam", "Tp. Hồ Chí Minh (SGN), Việt Nam", "Đà Nẵng (DAD), Việt Nam", "Phú Quốc (PQC), Việt Nam", "Nha Trang (CXR), Việt Nam", "Buôn Ma Thuột (BMV), Việt Nam", "Đồng Hới (VDH), Việt Nam"}));
		comboBox_noidi.setBounds(172, 117, 186, 22);
		
		comboBox_noidi.setSelectedItem(qlcb.sanbaydi);

		
		contentPane.add(comboBox_noidi);
		
		 comboBox = new JComboBox();
			comboBox.setBounds(608, 86, 151, 22);
			contentPane.add(comboBox);
			
		
		JLabel lb_noiden = new JLabel("Sân bay đến: ");
		lb_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noiden.setBounds(34, 158, 102, 18);
		contentPane.add(lb_noiden);

		
		JLabel lb_ngaydi = new JLabel("Ngày-giờ hạ cánh:");
		lb_ngaydi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydi.setBounds(35, 232, 152, 20);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser_hc = new JDateChooser();
		dateChooser_hc.setDateFormatString("yyyy-MM-dd hh:mm:ss");
		dateChooser_hc.setBounds(173, 232, 151, 20);
		contentPane.add(dateChooser_hc);
		
		LocalDate localDate = LocalDate.parse(qlcb.tg2);
        Date date3 = (Date) Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser_hc.setDate(date3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 700, 2);
		contentPane.add(separator);
		
		JLabel lb_idnql = new JLabel("ID người quản lý:");
		lb_idnql.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_idnql.setBounds(34, 270, 127, 18);
		contentPane.add(lb_idnql);
		
		textField_ID_NQL = new JTextField();
		textField_ID_NQL.setEditable(false);
		textField_ID_NQL.setBounds(172, 268, 186, 21);
		contentPane.add(textField_ID_NQL);
		textField_ID_NQL.setColumns(10);
		
		textField_ID_NQL.setText(qlcb.idnql);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(470, 113, 86, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_tongsove = new JTextField();
		textField_tongsove.setBounds(608, 119, 151, 18);
		contentPane.add(textField_tongsove);
		textField_tongsove.setColumns(10);
		
		textField_tongsove.setText(qlcb.tongsove);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày-giờ khởi hành:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(26, 194, 136, 18);
		contentPane.add(lblNewLabel_2);
		
		
		JDateChooser dateChooser_kh = new JDateChooser();
		dateChooser_kh.setDateFormatString("yyyy-MM-dd hh:mm:ss");
		dateChooser_kh.setBounds(173, 192, 151, 20);
		contentPane.add(dateChooser_kh);
		
		LocalDate localDate1 = LocalDate.parse(qlcb.tg1);
        Date date2 = (Date) Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());;
		dateChooser_kh.setDate(date2);
			
		JLabel lblNewLabel_3 = new JLabel("ID máy bay:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(470, 86, 114, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID chuyến bay:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 86, 122, 18);
		contentPane.add(lblNewLabel_4);
		
		lbHVTG = new JLabel("Hạng vé thương gia:");
		lbHVTG.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbHVTG.setBounds(440, 153, 152, 17);
		contentPane.add(lbHVTG);
		
		lblPTLH = new JLabel("Hạng vé PTLH:");
		lblPTLH.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPTLH.setBounds(458, 215, 127, 23);
		contentPane.add(lblPTLH);
		
		lbPTĐB = new JLabel("Hạng vé PTĐB:");
		lbPTĐB.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbPTĐB.setBounds(458, 186, 131, 21);
		contentPane.add(lbPTĐB);
			
		lblNewLabel_5 = new JLabel("Hạng vé PTTK:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(458, 253, 141, 18);
		contentPane.add(lblNewLabel_5);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setBounds(172, 86, 186, 21);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_ID.setText(qlcb.id);
		
		
		txtTG = new JTextField();
		txtTG.setBounds(608, 159, 152, 18);
		contentPane.add(txtTG);
		txtTG.setColumns(10);
		txtTG.setText(qlcb.TG);
		
		System.out.print("Thương gia "+qlcb.TG);
		
		txtPTĐB = new JTextField();
		txtPTĐB.setBounds(608, 192, 152, 17);
		contentPane.add(txtPTĐB);
		txtPTĐB.setColumns(10);
		txtPTĐB.setText(quanly_chuyenbay.PTDB);
		
		txtPTLH = new JTextField();
		txtPTLH.setBounds(608, 218, 152, 18);
		contentPane.add(txtPTLH);
		txtPTLH.setColumns(10);
		txtPTLH.setText(qlcb.PTLH);
		
		txtPTTK = new JTextField();
		txtPTTK.setBounds(608, 254, 152, 18);
		contentPane.add(txtPTTK);
		txtPTTK.setColumns(10);
		txtPTTK.setText(qlcb.PTTK);
	
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.setBackground(new Color(0, 191, 255));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(164, 346, 102, 23);
		contentPane.add(bt_capnhat);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 861, 493);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel.setIcon(scaleIcon);
		
		

		
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dangnhap_quanly dn=null;
				System.out.println("ten dang nhap: "+dn.tendn);
				
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						
						String nv="SELECT ID FROM NGUOIQUANLY WHERE PHONGBAN='Quản Lí Chuyến Bay' and TENDANGNHAP='"+dn.tendn+"'";
						Statement st=(Statement) ((java.sql.Connection) con).createStatement();  	

						ResultSet rsn= st.executeQuery(nv);
						if(rsn.next()) {
							String idnql =rsn.getString(1);	
							textField_ID_NQL.setText(idnql);

							if (Teststringcomparison(comboBox_noidi.getSelectedItem(), comboBox_noiden.getSelectedItem()) == true) {
								JOptionPane.showMessageDialog(null, "Vui lòng chọn lại nơi đến, nơi đi!");
							}
								else {
									if (textField_ID_NQL.getText().isEmpty()) {
										 JOptionPane.showMessageDialog(null, "vui lòng nhập ID người quản lý");
										 textField_ID_NQL.requestFocus();
										 return; 
										}
									
									 
									else {
											int TG = Integer.parseInt(txtTG.getText());
											int PTĐB = Integer.parseInt(txtPTĐB.getText());
											int PTLH = Integer.parseInt(txtPTLH.getText());
											int PTTK = Integer.parseInt(txtPTTK.getText());
											int sum = TG + PTĐB + PTTK + PTLH;
											int tongsove = Integer.parseInt(textField_tongsove.getText());
											if(sum != tongsove)
											{
												 JOptionPane.showMessageDialog(null, "Tổng số lượng vé của các hạng vé không hợp lệ");
											} else {
								
									try {
										
										SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
										String tgString=formatter.format(dateChooser_kh.getDate());
										String ngay_khoihanh="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
						
										SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
										String tgString1=formatter1.format(dateChooser_hc.getDate());
										String ngay_hacanh="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";
										
										dangnhap_quanly ql=null;
										
										
										
										String update ="update CHUYENBAY  set TTMAYBAY_ID="+comboBox.getSelectedItem()+",SANBAYDI='"+comboBox_noidi.getSelectedItem()+"',SANBAYDEN='"+comboBox_noiden.getSelectedItem()+"',NGAY_GIO_KH="+ngay_khoihanh+",NGAY_GIO_HC="+ngay_hacanh+",TONGSOVE="+textField_tongsove.getText()+",THUONGGIA ="+txtTG.getText()+",PHOTHONGDB ="+txtPTĐB.getText()+",PHOTHONGLH ="+txtPTLH.getText()+",PHOTHONGTK ="+txtPTTK.getText()+",NGUOIQUANLY_ID="+idnql+"where ID="+ textField_ID.getText()+"";
																							
										PreparedStatement pst = con.prepareStatement(update);
										pst= con.prepareStatement(update);
										pst.execute();
									
						
										JOptionPane.showMessageDialog(null, "Cập nhật thành công");
										pst.close();
										con.close();
										setVisible(false);
					
									} catch (SQLException e1) {
										Component a=null;
					
										JOptionPane.showMessageDialog(a, e1);						
						
									}
									}
}}
					}
						else {
							JOptionPane.showMessageDialog(null, "Bạn không thuộc nhiệm vụ này");
						}
						
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
								
				
				
					
		}
				
});

		
	}
	}
