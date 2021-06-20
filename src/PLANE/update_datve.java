package PLANE;

import java.awt.BorderLayout;
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

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;

public class update_datve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tinhtrang;
	private JTextField textField_idtk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_datve frame = new update_datve("1","2","3","4","5","2020-06-15 00:00:00.0","590000","Đã thanh toán","6");
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
	public update_datve(String a, String b,String c, String d, String e, String f, String g, String h,String i) {
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 485, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật thông tin đặt vé");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(5, 5, 466, 36);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 52, 446, 12);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Mã đặt vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 75, 111, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(167, 75, 99, 22);
		contentPane.add(lb_id);
		lb_id.setText(a);
		
		JLabel lblNewLabel_2 = new JLabel("ID vé máy bay:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 108, 133, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID hành khách:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(25, 141, 111, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID khuyến mãi:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 179, 132, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lb_idve = new JLabel("");
		lb_idve.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_idve.setBounds(169, 113, 111, 17);
		contentPane.add(lb_idve);
		lb_idve.setText(b);
		
		JLabel lb_idhk = new JLabel("");
		lb_idhk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_idhk.setBounds(169, 141, 111, 22);
		contentPane.add(lb_idhk);
		lb_idhk.setText(c);
		
		JLabel lblNewLabel_7 = new JLabel("ID dịch vụ BT:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(25, 212, 111, 22);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày đặt vé: ");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(25, 245, 111, 22);
		contentPane.add(lblNewLabel_8);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(167, 246, 142, 20);
		contentPane.add(dateChooser);
		
		LocalDate localDate = LocalDate.parse(f);
        Date date3 = (Date) Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser.setDate(date3);
		
		
		JLabel lblNewLabel_9 = new JLabel("Tổng tiền:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(25, 278, 111, 22);
		contentPane.add(lblNewLabel_9);
		
		JLabel lb_tongtien = new JLabel("");
		lb_tongtien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tongtien.setBounds(167, 280, 147, 20);
		contentPane.add(lb_tongtien);
		lb_tongtien.setText(g);
		
		JLabel lblNewLabel_11 = new JLabel("Tình trạng: ");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_11.setBounds(25, 311, 87, 21);
		contentPane.add(lblNewLabel_11);
		
		textField_tinhtrang = new JTextField();
		textField_tinhtrang.setBounds(167, 311, 142, 22);
		contentPane.add(textField_tinhtrang);
		textField_tinhtrang.setColumns(10);
		textField_tinhtrang.setText(h);
		
		JLabel lblNewLabel_12 = new JLabel("ID tài khoản:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_12.setBounds(25, 343, 111, 28);
		contentPane.add(lblNewLabel_12);
		
		textField_idtk = new JTextField();
		textField_idtk.setEditable(false);
		textField_idtk.setBounds(167, 344, 142, 22);
		contentPane.add(textField_idtk);
		textField_idtk.setColumns(10);
		textField_idtk.setText(i);
		
		JLabel lb_km = new JLabel("New label");
		lb_km.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_km.setBounds(164, 180, 116, 22);
		contentPane.add(lb_km);		
		lb_km.setText(d);
		
		JLabel lb_dvbt = new JLabel("New label");
		lb_dvbt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_dvbt.setBounds(167, 213, 142, 22);
		contentPane.add(lb_dvbt);
		lb_dvbt.setText(e);
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				if (textField_tinhtrang.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập tình trạng");
					 textField_tinhtrang.requestFocus();
					 return; 
					}
			
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser.getDate());
					String ngay_dat="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
	
					//String update ="update "DB_AIRLINE"."DATVEBAY" set "TAIKHOAN_ID"=409 where "ID"=1009";
					String update = null;
				    String tg1=null,tg2=null,tg3= null;
				    if (!lb_dvbt.getText().equals("null")) tg1=lb_dvbt.getText();
				    if (!lb_km.getText().equals("null")) tg2=lb_km.getText();
				    if(!textField_idtk.getText().equals("null")) tg3=textField_idtk.getText();
					update ="update DATVEBAY set TINHTRANG='"+textField_tinhtrang.getText()+"' where ID="+lb_id.getText()+"";

					System.out.println(update);
																		
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
					pst= DB_AIRLINE.prepareStatement(update);
					pst.execute();
	
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					pst.close();
					DB_AIRLINE.close();

				} catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;
					JOptionPane.showMessageDialog(a, e1);						
	
				}
		}
				
				
			
		});
		bt_capnhat.setBackground(new Color(135, 206, 250));
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBounds(43, 419, 111, 23);
		contentPane.add(bt_capnhat);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(280, 419, 99, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 0, 487, 510);
		contentPane.add(lblNewLabel_5);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_5.setIcon(scaleIcon);
		


	}
}
