package PLANE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.print.attribute.SupportedValuesAttribute;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.invoke.VarHandle;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.beans.Statement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.xml.sax.ext.Locator2Impl;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class them_hanhkhach extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hoten;
	private JTextField textField__quoctich;
	private JTextField textField_sdt;
	private JTextField textField_email;
	private JLabel lb_id;


	
public them_hanhkhach() {
	initComponent();
	autoID();
}	
	
	
	private JTextField textField_taikhoan_id;

	@SuppressWarnings("unchecked")
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_hanhkhach frame = new them_hanhkhach();
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

	

	public void initComponent() {
		//JLabel lb_id = new JLabel("New label");

		setVisible(true);
		setTitle("Sky Airline");
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 454, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkh = new JLabel("Thêm hành khách");
		lb_ttkh.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkh.setBounds(129, 11, 259, 42);
		contentPane.add(lb_ttkh);
		
		JLabel lb_mtk = new JLabel("ID:");
		lb_mtk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mtk.setBounds(29, 81, 108, 25);
		contentPane.add(lb_mtk);
		
		JLabel lb_hoten = new JLabel("Họ và tên: ");
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hoten.setBounds(29, 117, 96, 14);
		contentPane.add(lb_hoten);
		
		textField_hoten = new JTextField();
		textField_hoten.setBounds(141, 115, 175, 20);
		contentPane.add(textField_hoten);
		textField_hoten.setColumns(10);
		
		JLabel lb_ngsinh = new JLabel("Ngày sinh:");
		lb_ngsinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngsinh.setBounds(29, 154, 84, 25);
		contentPane.add(lb_ngsinh);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(141, 154, 175, 20);
		contentPane.add(dateChooser);
		
		JLabel lb_gioitinh = new JLabel("Giới tính: ");
		lb_gioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_gioitinh.setBounds(29, 223, 84, 14);
		contentPane.add(lb_gioitinh);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 224));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox.setBounds(144, 220, 70, 22);
		contentPane.add(comboBox);
		
		JLabel lb_quoctich = new JLabel("Quốc tịch: ");
		lb_quoctich.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_quoctich.setBounds(29, 190, 84, 14);
		contentPane.add(lb_quoctich);
		
		textField__quoctich = new JTextField();
		textField__quoctich.setBounds(141, 188, 175, 20);
		contentPane.add(textField__quoctich);
		textField__quoctich.setColumns(10);
		
		JLabel lb_sdt = new JLabel("SĐT:");
		lb_sdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sdt.setBounds(29, 262, 49, 14);
		contentPane.add(lb_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(141, 260, 175, 20);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JLabel lb_email = new JLabel("Email: ");
		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_email.setBounds(29, 299, 49, 14);
		contentPane.add(lb_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(141, 297, 175, 20);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		 lb_id = new JLabel("");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(142, 85, 96, 19);
		contentPane.add(lb_id);
		
		JLabel lb_taikhoan_id = new JLabel("Tài khoản ID: ");
		lb_taikhoan_id.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_taikhoan_id.setBounds(29, 334, 108, 14);
		contentPane.add(lb_taikhoan_id);
		
		textField_taikhoan_id = new JTextField();
		textField_taikhoan_id.setBounds(141, 332, 175, 20);
		contentPane.add(textField_taikhoan_id);
		textField_taikhoan_id.setColumns(10);
		
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String gioitinh= (String) comboBox.getSelectedItem();

				
				if (textField_taikhoan_id.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập tài khoản ID");
					 textField_taikhoan_id.requestFocus();
					 return; 
					}
				if (textField_email.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập email");
					 textField_email.requestFocus();
					 return; 
					}
				if (textField_sdt.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập số điện thoại");
					 textField_sdt.requestFocus();
					 return; 
					}
				if (textField__quoctich.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập quốc tịch");
					 textField__quoctich.requestFocus();
					 return; 
					}
				if (textField_hoten.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập họ tên");
					 textField_hoten.requestFocus();
					 return; 
					}
			

			try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString=formatter.format(dateChooser.getDate());
					String texString="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";

					
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					//System.out.println(texString);
					PreparedStatement pst1 = DB_AIRLINE.prepareStatement("insert into \"DB_AIRLINE\".\"HANHKHACH\" (\"ID\", \"HOTEN\", \"NGAYSINH\", \"QUOCTICH\", \"GIOITINH\", \"SDT\", \"EMAIL\", \"TAIKHOAN_ID\") values("+lb_id.getText()+",'"+textField_hoten.getText()+"',"+texString+",'"+textField__quoctich.getText()+"','"+comboBox.getSelectedItem()+"',"+textField_sdt.getText()+",'"+textField_email.getText()+"',"+textField_taikhoan_id.getText()+")");
  
					pst1.execute();
					pst1.close();
					
					Component a=null;					
				
					DB_AIRLINE.close();
					JOptionPane.showMessageDialog(a, "Đã thêm thành công");

				} catch (ClassNotFoundException e1) {
					System.out.println(e1);
				} catch (SQLException e1) {
					System.out.println(e1);
				}
				
				
				
			}


		});
		bt_them.setBackground(new Color(135, 206, 250));
		bt_them.setForeground(new Color(0, 0, 0));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(66, 420, 108, 23);
		contentPane.add(bt_them);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 560, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}


		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(225, 421, 96, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nguyen thi nhan\\Downloads\\anh2.jpg"));
		lblNewLabel.setBounds(0, 0, 452, 490);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon=new ImageIcon("anh2.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel.setIcon(scaleIcon);
		


	}

	

	
	public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from HANHKHACH");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("301");
			}
			else 
			{
				Integer result1 = Integer.valueOf(rs.getString("MAX(ID)"));
				result1++;
				lb_id.setText(result1.toString());
			}
			
			rs.close();
			DB_AIRLINE.close();
		} catch (ClassNotFoundException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);

		}  
	}
}
