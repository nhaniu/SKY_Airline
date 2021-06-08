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
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
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

public class them_dvbt extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nd;
	private JTextField textField_giadv;
	private JLabel lb_id;
	public them_dvbt() {
		initComponent();
		autoID();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_dvbt frame = new them_dvbt();
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
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 413, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm dịch vụ bổ trợ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 391, 37);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 487, 8);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 90, 75, 21);
		contentPane.add(lblNewLabel_1);
		
		lb_id = new JLabel("New label");
		lb_id.setBounds(142, 91, 90, 21);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel_3 = new JLabel("Nội dung dịch vụ:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(29, 132, 127, 21);
		contentPane.add(lblNewLabel_3);
		
		textField_nd = new JTextField();
		textField_nd.setBounds(152, 133, 104, 20);
		contentPane.add(textField_nd);
		textField_nd.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Giá dịch vụ:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(29, 173, 82, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_giadv = new JTextField();
		textField_giadv.setBounds(152, 174, 104, 21);
		contentPane.add(textField_giadv);
		textField_giadv.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_giadv.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập giá dịch vụ");
					 textField_giadv.requestFocus();
					 return; 
					}
				
				if (textField_nd.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập nội dung dịch vụ");
					 textField_nd.requestFocus();
					 return; 
					}
			
				try {
					
				


				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"DICHVUBOTRO\"  (\"ID\", \"NOIDUNGDV\", \"GIADV\") values("+lb_id.getText()+",'"+textField_nd.getText()+"',"+textField_giadv.getText()+")");		
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
		bt_them.setBackground(new Color(135, 206, 250));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(47, 258, 89, 23);
		contentPane.add(bt_them);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(244, 259, 89, 23);
		contentPane.add(btnNewButton);
	}
public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from DICHVUBOTRO");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("4001");
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
