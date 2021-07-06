package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class them_chuyenbay extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID_NQL;
	private JTextField textField_tongsove;
	private JLabel lb_id;
	Connection con=null;
	private static JComboBox comboBox_noidi;
	private static JComboBox comboBox_noiden;
	private JComboBox comboBox;
	private String tsgcb;




	public them_chuyenbay() {
		initComponent();
		autoID();
		loadCombobox();
		loadCombobox1();
		loadCombobox2();
		Teststringcomparison (toString(), toString());

	}
	/**
	 * Launch the application.
	 */
	
	public static boolean Teststringcomparison (Object object, Object object2){
		object = comboBox_noidi.getSelectedItem().toString();
		object2 = comboBox_noiden.getSelectedItem().toString();
		if (object.equals(object2)) {
			System.out.println("Giống");
			return true;
		}
		System.out.println("K giống");
		return false;
		}
	
	public void loadCombobox() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noidi.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox2() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select ID from TTMAYBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public void loadCombobox1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select TENSANBAY from SANBAY");
				ResultSet rs= pst.executeQuery();
				while(rs.next()) {
					comboBox_noiden.addItem(rs.getString(1));

				}
	         

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					them_chuyenbay frame = new them_chuyenbay();
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
		setBounds(100, 170, 797, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thêm chuyến bay");
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setBounds(229, 15, 306, 34);
		contentPane.add(lb_title);
		
		JLabel lb_sbdi = new JLabel("Sân bay đi: ");
		lb_sbdi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_sbdi.setBounds(25, 133, 102, 18);
		contentPane.add(lb_sbdi);
		
		
		 comboBox_noiden = new JComboBox();
		
		comboBox_noiden.setBounds(559, 133, 151, 21);
		contentPane.add(comboBox_noiden);
		
		 comboBox_noidi = new JComboBox();
		comboBox_noidi.setBounds(172, 133, 151, 20);
		contentPane.add(comboBox_noidi);
		
		
		
		
		JLabel lb_noiden = new JLabel("Sân bay đến: ");
		lb_noiden.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_noiden.setBounds(421, 133, 102, 18);
		contentPane.add(lb_noiden);

		
		JLabel lb_ngaydi = new JLabel("Ngày-giờ hạ cánh:");
		lb_ngaydi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaydi.setBounds(421, 172, 152, 20);
		contentPane.add(lb_ngaydi);
		
		JDateChooser dateChooser_hc = new JDateChooser();
		dateChooser_hc.setBounds(559, 172, 151, 20);
		contentPane.add(dateChooser_hc);
		

		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		bt_thoat.setBackground(new Color(0, 191, 255));
		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thoat.setBounds(559, 384, 102, 23);
		contentPane.add(bt_thoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 700, 2);
		contentPane.add(separator);
		
		JLabel lb_idnql = new JLabel("ID người quản lý:");
		lb_idnql.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_idnql.setBounds(408, 260, 127, 18);
		contentPane.add(lb_idnql);
		
		textField_ID_NQL = new JTextField();
		textField_ID_NQL.setBounds(559, 260, 151, 21);
		contentPane.add(textField_ID_NQL);
		textField_ID_NQL.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(421, 210, 86, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_tongsove = new JTextField();
		
		textField_tongsove.setEditable(false);
		textField_tongsove.setBounds(559, 216, 151, 18);
		contentPane.add(textField_tongsove);
		textField_tongsove.setColumns(10);
		
		
		comboBox = new JComboBox();
		comboBox.addItemListener((ItemListener) new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	
		        	try {
		    			Class.forName("oracle.jdbc.OracleDriver");
		    			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
		                 PreparedStatement pst = con.prepareStatement("Select TONGSOGHE from TTMAYBAY where ID="+comboBox.getSelectedItem()+"");
		             	
		    				ResultSet rs= pst.executeQuery();
		    				while(rs.next()) {
		    					String tongsoghe =rs.getString(1);
		    					float tsg=Float.parseFloat(tongsoghe);
		    					int tsg_cb= (int) (tsg*1.2);
		    					 tsgcb=String.valueOf(tsg_cb);
		    					 
		    				}
		    	         

		    		} catch (ClassNotFoundException e1) {
		    			e1.printStackTrace();
		    		} catch (SQLException e1) {
		    			e1.printStackTrace();
		    		}
		    		
					textField_tongsove.setText(tsgcb);
		        }
		    }
		});
	
		comboBox.setBounds(559, 89, 152, 21);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel_2 = new JLabel("Ngày-giờ khởi hành:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 174, 136, 18);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser_kh = new JDateChooser();
		dateChooser_kh.setBounds(172, 172, 151, 20);
		contentPane.add(dateChooser_kh);
		
		JLabel lblNewLabel_3 = new JLabel("ID máy bay:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(421, 87, 114, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID chuyến bay:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(25, 86, 122, 18);
		contentPane.add(lblNewLabel_4);
		
		
		JButton bt_them = new JButton("Thêm");
		bt_them.setBackground(new Color(0, 191, 255));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(134, 384, 102, 23);
		contentPane.add(bt_them);
		
		 lb_id = new JLabel("");
		lb_id.setBounds(172, 85, 151, 18);
		contentPane.add(lb_id);
		
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Teststringcomparison(comboBox_noidi.getSelectedItem(), comboBox_noiden.getSelectedItem()) == true) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn lại nơi đến, nơi đi!");
				}
				else {
					if (textField_ID_NQL.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập ID người quản lý");
						 textField_ID_NQL.requestFocus();
						 return; 
						}
					
					try {
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						String tgString=formatter.format(dateChooser_kh.getDate());
						String ngay_khoihanh="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
		
	
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
						String tgString1=formatter1.format(dateChooser_hc.getDate());
						String ngay_hacanh="TO_DATE('"+tgString1+"','DD-MM-RR HH24:MI:SS')";
	
	
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"CHUYENBAY\"  (\"ID\", \"TTMAYBAY_ID\", \"SANBAYDI\",\"SANBAYDEN\",  \"NGAY_GIO_KH\", \"NGAY_GIO_HC\", \"TONGSOVE\",\"NGUOIQUANLY_ID\") values("+lb_id.getText()+","+comboBox.getSelectedItem()+",'"+comboBox_noidi.getSelectedItem()+"','"+comboBox_noiden.getSelectedItem()+"',"+ngay_khoihanh+","+ngay_hacanh+","+textField_tongsove.getText()+","+textField_ID_NQL.getText()+")");		
					pst.execute();	
					
	
					JOptionPane.showMessageDialog(null, "Thêm chuyến bay thành công");
					con.close();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
	
				}
				}
				
			}
				
		});

		
	}

	public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from CHUYENBAY");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("601");
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
		}
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 795, 524);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel.setIcon(scaleIcon);
		
	}
	public static boolean Teststringcomparison (){
			try {
				comboBox_noidi.getSelectedItem().equals(comboBox_noidi.getSelectedItem());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			}
	
	}
