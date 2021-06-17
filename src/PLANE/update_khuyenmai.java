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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class update_khuyenmai extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ptkm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_khuyenmai frame = new update_khuyenmai("1", "21-01-2021", "30-01-2021", "lễ tết", "10");
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
	public update_khuyenmai(String a, String b, String c, String d, String e) {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 498, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật khuyến mãi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(34, 11, 438, 36);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 578, 10);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khuyến mãi:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 89, 137, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(179, 89, 137, 19);
		contentPane.add(lb_id);
		lb_id.setText(a);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 127, 113, 19);
		contentPane.add(lblNewLabel_3);
		

		JDateChooser dateChooser_NBD = new JDateChooser();
		dateChooser_NBD.setBounds(179, 126, 145, 20);
		contentPane.add(dateChooser_NBD);
		
		LocalDate localDate = LocalDate.parse(b);
        Date date3 = (Date) Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dateChooser_NBD.setDate(date3);
		
		
		JLabel lblNewLabel_4 = new JLabel("Ngày kết thúc:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 168, 113, 19);
		contentPane.add(lblNewLabel_4);
		
		
		JDateChooser dateChooser_NKT = new JDateChooser();
		dateChooser_NKT.setBounds(179, 167, 145, 20);
		contentPane.add(dateChooser_NKT);
		
		LocalDate localDate1 = LocalDate.parse(c);
        Date date2 = (Date) Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());;
		dateChooser_NKT.setDate(date2);
		
		JLabel lblNewLabel_5 = new JLabel("Nội dung:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 210, 113, 20);
		contentPane.add(lblNewLabel_5);
		
		JTextField textField_noidung = new JTextField();
		textField_noidung.setBounds(179, 211, 260, 19);
		contentPane.add(textField_noidung);
		textField_noidung.setColumns(10);
		textField_noidung.setText(d);
		
		JLabel lblNewLabel_6 = new JLabel("Phần trăm khuyến mãi:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 260, 172, 19);
		contentPane.add(lblNewLabel_6);
		
		textField_ptkm = new JTextField();
		textField_ptkm.setBounds(179, 260, 145, 19);
		contentPane.add(textField_ptkm);
		textField_ptkm.setColumns(10);
		textField_ptkm.setText(e);
		
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_noidung.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập nội dung");
					 textField_noidung.requestFocus();
					 return; 
					}
				
				if (textField_ptkm.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập phần trăm khuyến mãi");
					 textField_ptkm.requestFocus();
					 return; 
					}
			
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser_NBD.getDate());
					String ngay_batdau="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
	
					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString1=formatter1.format(dateChooser_NKT.getDate());
					String ngay_ketthuc="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";
					
					String update ="update BKHUYENMAI set ID= "+lb_id.getText()+",NGAYBD="+ngay_batdau+",NGAYKT="+ngay_ketthuc+",NOIDUNG='"+textField_noidung.getText()+"',PHANTRAMKM="+textField_ptkm.getText()+"where ID="+ lb_id.getText()+"";
																		
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
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(34, 327, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(313, 328, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 0, 498, 409);
		contentPane.add(lblNewLabel_2);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_2.setIcon(scaleIcon);
	}
}
