package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class update_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_idhv;
	private JTextField textField_idcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_ve frame = new update_ve("1","2","3");
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
	public update_ve(String a, String b, String c) {
		setBackground(new Color(240, 255, 255));
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 554, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cập nhật vé máy bay");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(5, 11, 546, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(5, 63, 541, 7);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("ID vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(83, 96, 60, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lb_id = new JLabel("");
		lb_id.setBounds(235, 99, 126, 20);
		contentPane.add(lb_id);
		lb_id.setText(a);
		
		JLabel lblNewLabel_2 = new JLabel("ID hạng vé: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(86, 140, 107, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_idhv = new JTextField();
		textField_idhv.setBounds(235, 140, 126, 20);
		contentPane.add(textField_idhv);
		textField_idhv.setColumns(10);
		textField_idhv.setText(b);
		
		JLabel lblNewLabel_3 = new JLabel("ID chuyến bay:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(86, 188, 107, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_idcb = new JTextField();
		textField_idcb.setBounds(235, 188, 126, 20);
		contentPane.add(textField_idcb);
		textField_idcb.setColumns(10);
		textField_idcb.setText(c);
		
		JButton bt_capnhat = new JButton("Cập nhật");
		bt_capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
		
				if (textField_idhv.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID hạng vé");
					 textField_idhv.requestFocus();
					 return; 
					}
				if (textField_idcb.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập ID chuyến bay");
					 textField_idcb.requestFocus();
					 return; 
					}
			
				try {
					
					String update ="update VEMAYBAY set ID= "+lb_id.getText()+",HANGVE_ID="+textField_idhv.getText()+",CHUYENBAY_ID="+textField_idcb.getText()+" where ID="+lb_id.getText()+"";
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
		bt_capnhat.setBounds(55, 292, 107, 23);
		contentPane.add(bt_capnhat);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(369, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 0, 551, 355);
		contentPane.add(lblNewLabel_4);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_4.setIcon(scaleIcon);



	}
}
