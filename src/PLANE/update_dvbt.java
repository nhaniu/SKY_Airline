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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class update_dvbt extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nd;
	private JTextField textField_gia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_dvbt frame = new update_dvbt("1","10kg","150000");
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
	public update_dvbt(String a, String b, String c) {
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật dịch vụ bổ trợ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 383, 30);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 47, 416, 14);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 78, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setBounds(121, 76, 114, 20);
		contentPane.add(lb_id);
		lb_id.setText(a);
		
		JLabel lblNewLabel_2 = new JLabel("Nội dung dịch vụ:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(20, 115, 123, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_nd = new JTextField();
		textField_nd.setBounds(153, 116, 128, 19);
		contentPane.add(textField_nd);
		textField_nd.setColumns(10);
		textField_nd.setText(b);
		
		JLabel lblNewLabel_3 = new JLabel("Giá dịch vụ:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(20, 149, 88, 27);
		contentPane.add(lblNewLabel_3);
		
		textField_gia = new JTextField();
		textField_gia.setBounds(153, 153, 128, 20);
		contentPane.add(textField_gia);
		textField_gia.setColumns(10);
		textField_gia.setText(c);
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_nd.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập nội dung dịch vụ");
					 textField_nd.requestFocus();
					 return; 
					}
				if (textField_gia.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập giá dịch vụ");
					 textField_gia.requestFocus();
					 return; 
					}
			
				try {
					
					String update ="update DICHVUBOTRO set ID= "+lb_id.getText()+",NOIDUNGDV='"+textField_nd.getText()+"',GIADV="+textField_gia.getText()+" where ID="+lb_id.getText()+"";
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
		bt_capnhat.setBounds(35, 205, 108, 23);
		contentPane.add(bt_capnhat);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(135, 206, 250));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(239, 206, 89, 23);
		contentPane.add(bt_thoat);
	}

}
