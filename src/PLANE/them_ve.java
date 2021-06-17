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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;

public class them_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hv;
	private JTextField textField_cb;
	private JLabel lb_id;
	
	public them_ve() {
		initComponent();
		autoID();}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_ve frame = new them_ve();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 //
	/**
	 * Create the frame.
	 */
	public void initComponent() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 451, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thêm vé máy bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(69, 11, 273, 44);
		contentPane.add(lb_title);
		
		JLabel lb_hangve = new JLabel("ID hạng vé:");
		lb_hangve.setBackground(new Color(240, 255, 255));
		lb_hangve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hangve.setBounds(37, 139, 101, 18);
		contentPane.add(lb_hangve);
		
		JLabel lb_mave = new JLabel("Mã vé:");
		lb_mave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mave.setBounds(37, 89, 76, 18);
		contentPane.add(lb_mave);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textField_cb.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID chuyến bay");
					 textField_cb.requestFocus();
					 return; 
					}
				
				if (textField_hv.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID hạng vé");
					 textField_hv.requestFocus();
					 return; 
					}
			
				try {
					

				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"VEMAYBAY\"  (\"ID\",  \"HANGVE_ID\",\"CHUYENBAY_ID\") values("+lb_id.getText()+","+textField_hv.getText()+","+textField_cb.getText()+")");		
				pst.execute();				
				pst.close();
				Component a=null;
				JOptionPane.showMessageDialog(a, "Đã thêm thành công");

				
				con.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
			
		});
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setBounds(26, 285, 101, 23);
		contentPane.add(bt_them);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 704, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 245, 704, 2);
		contentPane.add(separator_1);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(135, 206, 250));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(296, 285, 89, 23);
		contentPane.add(bt_thoat);
		
		lb_id = new JLabel("");
		lb_id.setHorizontalAlignment(SwingConstants.CENTER);
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(123, 92, 204, 18);
		contentPane.add(lb_id);
		
		textField_hv = new JTextField();
		textField_hv.setBounds(145, 138, 159, 23);
		contentPane.add(textField_hv);
		textField_hv.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID chuyến bay:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 187, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_cb = new JTextField();
		textField_cb.setBounds(145, 185, 159, 23);
		contentPane.add(textField_cb);
		textField_cb.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 451, 339);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
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
		ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from VEMAYBAY");  
		
		rs.next();
		System.out.println(rs.getString("MAX(ID)"));
		
		if(rs.getString("MAX(ID)")==null) {
			lb_id.setText("801");
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