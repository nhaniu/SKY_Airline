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
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
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

public class them_khuyenmai extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ptkm;
	private JTextField textField_ndung;
	private JLabel lb_id;
	public them_khuyenmai() {
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
					them_khuyenmai frame = new them_khuyenmai();
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
		setBounds(100, 170, 540, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ttkm = new JLabel("Thêm khuyến mãi");
		lb_ttkm.setBackground(new Color(218, 165, 32));
		lb_ttkm.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_ttkm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_ttkm.setBounds(133, 11, 272, 50);
		contentPane.add(lb_ttkm);
		
		JLabel lb_makm = new JLabel("Mã khuyến mãi: ");
		lb_makm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_makm.setBounds(30, 94, 130, 25);
		contentPane.add(lb_makm);
		
		JLabel lb_hthuckm = new JLabel("Phần trăm khuyến mãi: ");
		lb_hthuckm.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_hthuckm.setBounds(30, 308, 172, 14);
		contentPane.add(lb_hthuckm);
		
		textField_ptkm = new JTextField();
		textField_ptkm.setBounds(212, 305, 203, 22);
		contentPane.add(textField_ptkm);
		textField_ptkm.setColumns(10);
		
		JLabel lb_ngayBD = new JLabel("Ngày bắt đầu: ");
		lb_ngayBD.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngayBD.setBounds(30, 149, 118, 22);
		contentPane.add(lb_ngayBD);
		
		JDateChooser dateChooser_NBD = new JDateChooser();
		dateChooser_NBD.setBounds(212, 149, 203, 22);
		contentPane.add(dateChooser_NBD);
		
		JLabel lb_ngayKT = new JLabel("Ngày kết thúc:");
		lb_ngayKT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngayKT.setBounds(30, 200, 118, 25);
		contentPane.add(lb_ngayKT);
		
		JDateChooser dateChooser_NKT = new JDateChooser();
		dateChooser_NKT.setBounds(212, 200, 203, 22);
		contentPane.add(dateChooser_NKT);
		
		JLabel lb_noidung = new JLabel("Nội dung: ");
		lb_noidung.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noidung.setBounds(32, 255, 92, 18);
		contentPane.add(lb_noidung);
		
		textField_ndung = new JTextField();
		textField_ndung.setBounds(212, 254, 203, 22);
		contentPane.add(textField_ndung);
		textField_ndung.setColumns(10);
		
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (textField_ndung.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập nội dung");
					 textField_ndung.requestFocus();
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
					String ngaybatdau="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
	

					SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					String tgString1=formatter1.format(dateChooser_NKT.getDate());
					String ngayketthuc="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";


				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"BKHUYENMAI\"  (\"ID\", \"NGAYBD\", \"NGAYKT\",\"NOIDUNG\",  \"PHANTRAMKM\") values("+lb_id.getText()+","+ngaybatdau+","+ngayketthuc+",'"+textField_ndung.getText()+"',"+textField_ptkm.getText()+")");		
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
		bt_them.setBounds(63, 386, 102, 23);
		contentPane.add(bt_them);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(331, 386, 102, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 582, 2);
		contentPane.add(separator);
		
		 lb_id = new JLabel("New label");
		lb_id.setBounds(212, 94, 203, 25);
		contentPane.add(lb_id);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 541, 462);
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
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from BKHUYENMAI");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("2001");
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
			JOptionPane.showMessageDialog(null, e);		
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
		}  }
}
