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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.awt.event.ActionEvent;

public class them_changdung extends JFrame {

	private JPanel contentPane;
	private JTextField textField_sanbaydi;
	private JTextField textField_sanbayden;
	private JTextField textField_diadiemdung;
	private JLabel lb_id;

	public them_changdung() {
		initComponent();
		autoID();}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_changdung frame = new them_changdung();
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
		setBounds(100, 100, 443, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm chặng dừng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 387, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lb = new JLabel("ID:");
		lb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb.setBounds(39, 106, 110, 32);
		contentPane.add(lb);
		
		lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(159, 111, 163, 24);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel_2 = new JLabel("Sân bay đi:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(39, 160, 110, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sân bay đến:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(39, 227, 115, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa điểm dừng: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(39, 292, 110, 24);
		contentPane.add(lblNewLabel_4);
		
		textField_sanbaydi = new JTextField();
		textField_sanbaydi.setBounds(159, 167, 163, 24);
		contentPane.add(textField_sanbaydi);
		textField_sanbaydi.setColumns(10);
		
		textField_sanbayden = new JTextField();
		textField_sanbayden.setBounds(159, 230, 163, 24);
		contentPane.add(textField_sanbayden);
		textField_sanbayden.setColumns(10);
		
		textField_diadiemdung = new JTextField();
		textField_diadiemdung.setBounds(159, 295, 163, 21);
		contentPane.add(textField_diadiemdung);
		textField_diadiemdung.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_diadiemdung.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập địa điểm dừng");
					 textField_diadiemdung.requestFocus();
					 return; 
					}
				
				if (textField_sanbaydi.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập sân bay đi");
					 textField_sanbaydi.requestFocus();
					 return; 
					}
				if (textField_sanbayden.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập sân bay đến");
					 textField_sanbayden.requestFocus();
					 return; 
					}
			
				try {
					

				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"CHANGDUNG\"  (\"ID\",  \"NOIDI\",\"NOIDEN\",\"DIADIEMDUNG\") values("+lb_id.getText()+",'"+textField_sanbaydi.getText()+"','"+textField_sanbayden.getText()+"','"+textField_diadiemdung.getText()+"')");		
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
		bt_them.setBounds(37, 396, 89, 23);
		contentPane.add(bt_them);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(279, 397, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from CHANGDUNG");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("701");
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
