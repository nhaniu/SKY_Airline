package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class taikhoan_khachhang extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private int dem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					taikhoan_khachhang frame = new taikhoan_khachhang();
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
	
	public taikhoan_khachhang() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 431, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th??ng tin t??i kho???n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(75, 12, 263, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 72, 90, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setBounds(155, 76, 122, 24);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel_3 = new JLabel("T??n ????ng nh???p:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(25, 114, 122, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lb_tendn = new JLabel("New label");
		lb_tendn.setBounds(155, 115, 132, 24);
		contentPane.add(lb_tendn);
		
		JLabel lblNewLabel_4 = new JLabel("M???t kh???u:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 364, 100, 24);
		contentPane.add(lblNewLabel_4);
		//lblNewLabel_4.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 366, 122, 22);
		contentPane.add(passwordField);
		//passwordField.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Ng??y b???t ?????u:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 149, 100, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lb_ngaybd = new JLabel("New label");
		lb_ngaybd.setBounds(155, 150, 201, 22);
		contentPane.add(lb_ngaybd);
		
		JLabel lblNewLabel_6 = new JLabel("S??T:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(25, 188, 100, 24);
		contentPane.add(lblNewLabel_6);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(155, 190, 122, 22);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(25, 223, 90, 24);
		contentPane.add(lblNewLabel_7);
		
		textField_email = new JTextField();
		textField_email.setBounds(155, 223, 122, 22);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("T???ng ti???n mua v??:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(25, 258, 122, 24);
		contentPane.add(lblNewLabel_8);
		
		JLabel lb_tongtienve = new JLabel("New label");
		lb_tongtienve.setBounds(155, 256, 122, 24);
		contentPane.add(lb_tongtienve);
		
		JLabel lblNewLabel_10 = new JLabel("??i???m:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_10.setBounds(25, 293, 122, 24);
		contentPane.add(lblNewLabel_10);
		
		JLabel lb_diem = new JLabel("New label");
		lb_diem.setBounds(155, 297, 122, 18);
		contentPane.add(lb_diem);
		
		JLabel lblNewLabel_11 = new JLabel("H???ng:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_11.setBounds(25, 328, 116, 22);
		contentPane.add(lblNewLabel_11);
		
		JLabel lb_hang = new JLabel("New label");
		lb_hang.setBounds(155, 328, 116, 24);
		contentPane.add(lb_hang);
				
		try {
							
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			
			DangNhap dn=null;
			String search="select * from TAIKHOAN where TENDANGNHAP='"+dn.tendn+"' and MATKHAU='"+dn.mk+"'";					

			
			ResultSet rs= st.executeQuery(search);
				while(rs.next()) {
					String id =rs.getString(1);
					String tendn =rs.getString(2);
					String mk =rs.getString(3);
					String ngaybd =rs.getString(4);							
					String sdt =rs.getString(5);
					String email =rs.getString(6);
					String tongtien =rs.getString(7);
					String diem =rs.getString(8);
					String hang =rs.getString(9);
					
					lb_id.setText(id);
					lb_tendn.setText(tendn);
					passwordField.setText(mk);
					lb_ngaybd.setText(ngaybd);
					textField_sdt.setText(sdt);
					textField_email.setText(email);
					lb_tongtienve.setText(tongtien);
					lb_diem.setText(diem);
					lb_hang.setText(hang);
										

				
			}
			con.close();
			
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		
		

		
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 397, 7);
		contentPane.add(separator);
		
		JButton bt_capnhat = new JButton("C???p nh???t");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui l??ng nh???p ?????y ????? th??ng tin");
					 textField_email.requestFocus();
					 return; 
					}
				if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui l??ng nh???p ?????y ????? th??ng tin");
					 textField_sdt.requestFocus();
					 
					 return; 
					}
				if (passwordField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui l??ng nh???p ?????y ????? th??ng tin");
					 passwordField.requestFocus();
					 
					 return; 
					}
				
				if(checkNumberPhone(textField_sdt.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ????ng s??? ??i???n tho???i!");
					 textField_sdt.requestFocus();
					 return;
				}
				else if(checkMail(textField_email.getText()) == false){
					JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ????ng t??i kho???n email!");
					 textField_sdt.requestFocus();
					 return;
				}
			
				try {
					
					String update ="update TAIKHOAN set MATKHAU='"+passwordField.getText()+"',SDT="+textField_sdt.getText()+",EMAIL='"+textField_email.getText()+"' where ID="+lb_id.getText()+"";
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
					pst= DB_AIRLINE.prepareStatement(update);
					pst.execute();
	
					
					JOptionPane.showMessageDialog(null, "C???p nh???t th??nh c??ng");
					pst.close();
					DB_AIRLINE.close();

				} catch (ClassNotFoundException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
				} catch (SQLException e1) {
					Component a=null;

					JOptionPane.showMessageDialog(a, e1);						
	
				}
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
			
					
					
					String search="select* from TAIKHOAN where TENDANGNHAP='"+lb_tendn.getText()+"' and MATKHAU='"+passwordField.getText()+"'";					

					
					ResultSet rs= st.executeQuery(search);
						while(rs.next()) {
							String id =rs.getString(1);
							String tendn =rs.getString(2);
							String mk =rs.getString(3);
							String ngaybd =rs.getString(4);							
							String sdt =rs.getString(5);
							String email =rs.getString(6);
							String tongtien =rs.getString(7);
							String diem =rs.getString(8);
							String hang =rs.getString(9);
							
							lb_id.setText(id);
							lb_tendn.setText(tendn);
							passwordField.setText(mk);
							lb_ngaybd.setText(ngaybd);
							textField_sdt.setText(sdt);
							textField_email.setText(email);
							lb_tongtienve.setText(tongtien);
							lb_diem.setText(diem);
							lb_hang.setText(hang);
												

						
					}
					con.close();
					
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		bt_capnhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_capnhat.setBackground(new Color(135, 206, 250));
		bt_capnhat.setBounds(209, 433, 108, 23);
		contentPane.add(bt_capnhat);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 0, 432, 498);
		contentPane.add(lblNewLabel_5);
		

		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_5.setIcon(scaleIcon);
		
	
	}
}
