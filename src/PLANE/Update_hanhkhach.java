//package PLANE;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.JTextField;
//import com.toedter.calendar.JDateChooser;
//import javax.swing.JComboBox;
//import javax.print.attribute.SupportedValuesAttribute;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
////import java.beans.Statement;
//import java.sql.Statement;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Level;
//import javax.swing.JSeparator;
//import java.awt.event.ActionEvent;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.JScrollPane;
//
//public class Update_hanhkhach extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField textField_hoten;
//	private JTextField textField__quoctich;
//	private JTextField textField_sdt;
//	private JTextField textField_email;
//	private JLabel lb_id;
//
//
//	
//public Update_hanhkhach() {
//	initComponent();
//	autoID();
//}	
//	
//	Connection DBA_AIRLINE;
//	PreparedStatement pst;
//	private JTextField textField_taikhoan_id;
//
//	@SuppressWarnings("unchecked")
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Update_hanhkhach frame = new Update_hanhkhach();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public void initComponent() {
//
//		JFrame frame=new JFrame();
//		setVisible(true);
//		setTitle("Sky Airline");
//		setBackground(new Color(240, 255, 255));
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		setBounds(100, 170, 454, 516);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(240, 255, 255));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lb_ttkh = new JLabel("Cập nhật hành khách");
//		lb_ttkh.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		lb_ttkh.setBounds(107, 11, 259, 42);
//		contentPane.add(lb_ttkh);
//		
//		JLabel lb_mtk = new JLabel("ID:");
//		lb_mtk.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_mtk.setBounds(29, 81, 108, 25);
//		contentPane.add(lb_mtk);
//		
//		JLabel lb_hoten = new JLabel("Họ và tên: ");
//		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_hoten.setBounds(29, 117, 96, 14);
//		contentPane.add(lb_hoten);
//		
//		textField_hoten = new JTextField();
//		textField_hoten.setBounds(141, 115, 175, 20);
//		contentPane.add(textField_hoten);
//		textField_hoten.setColumns(10);
//		
//		JLabel lb_ngsinh = new JLabel("Ngày sinh:");
//		lb_ngsinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_ngsinh.setBounds(29, 187, 84, 25);
//		contentPane.add(lb_ngsinh);
//		
//		final JDateChooser dateChooser = new JDateChooser();
//		dateChooser.setBounds(141, 187, 175, 20);
//		contentPane.add(dateChooser);
//		
//		JLabel lb_gioitinh = new JLabel("Giới tính: ");
//		lb_gioitinh.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_gioitinh.setBounds(29, 223, 84, 14);
//		contentPane.add(lb_gioitinh);
//		
//		final JComboBox comboBox = new JComboBox();
//		comboBox.setBackground(new Color(255, 255, 224));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
//		comboBox.setBounds(144, 220, 70, 22);
//		contentPane.add(comboBox);
//		
//		JLabel lb_quoctich = new JLabel("Quốc tịch: ");
//		lb_quoctich.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_quoctich.setBounds(29, 260, 84, 14);
//		contentPane.add(lb_quoctich);
//		
//		textField__quoctich = new JTextField();
//		textField__quoctich.setBounds(141, 258, 175, 20);
//		contentPane.add(textField__quoctich);
//		textField__quoctich.setColumns(10);
//		
//		JLabel lb_sdt = new JLabel("SĐT:");
//		lb_sdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_sdt.setBounds(29, 299, 49, 14);
//		contentPane.add(lb_sdt);
//		
//		textField_sdt = new JTextField();
//		textField_sdt.setBounds(141, 297, 175, 20);
//		contentPane.add(textField_sdt);
//		textField_sdt.setColumns(10);
//		
//		JLabel lb_email = new JLabel("Email: ");
//		lb_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_email.setBounds(29, 337, 49, 14);
//		contentPane.add(lb_email);
//		
//		textField_email = new JTextField();
//		textField_email.setBounds(141, 335, 175, 20);
//		contentPane.add(textField_email);
//		textField_email.setColumns(10);
//		
//		 lb_id = new JLabel("");
//		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		lb_id.setBounds(142, 85, 96, 19);
//		contentPane.add(lb_id);
//		
//		JLabel lb_taikhoan_id = new JLabel("Tài khoản ID: ");
//		lb_taikhoan_id.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lb_taikhoan_id.setBounds(29, 150, 108, 14);
//		contentPane.add(lb_taikhoan_id);
//		
//		textField_taikhoan_id = new JTextField();
//		textField_taikhoan_id.setBounds(141, 150, 175, 26);
//		contentPane.add(textField_taikhoan_id);
//		textField_taikhoan_id.setColumns(10);
//		
//		
//		
//		JButton bt_them = new JButton("Cập nhật");
//		bt_them.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				
//				try {
//				
//							
//						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
//						String tgString=formatter.format(dateChooser.getDate());
//						Date date1 = null;
//						try {
//							date1 = formatter.parse(tgString);
//						} catch (ParseException e2) {
//							e2.printStackTrace();
//						}
////						
////							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////							String date =dateFormat.format(dateChooser.getDate());
//							
//						String texString="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
//						System.out.println(texString);
//						
//						String update ="update HANHKHACH set ID= "+lb_id.getText()+", HOTEN='"+ textField_hoten.getText()+"',NGAYSINH="+texString+",QUOCTICH='"+textField__quoctich.getText()+"',GIOITINH='"+comboBox.getSelectedItem()+"',SDT="+textField_sdt.getText()+",EMAIL='"+textField_email.getText()+"',TAIKHOAN_ID="+textField_taikhoan_id.getText()+" where ID="+ lb_id.getText()+"";
//													
//							
//						Class.forName("oracle.jdbc.OracleDriver");
//						java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","1");  		
//							
//						pst= DB_AIRLINE.prepareStatement(update);
//		
//						pst.executeUpdate();
//						System.out.println("update " + update);
//		
//						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//						pst.close();
//						DB_AIRLINE.close();
//
//						Referesh();
//					} catch (ClassNotFoundException e1) {
//						JOptionPane.showMessageDialog(null, e1);						
//					} catch (SQLException e1) {
//						JOptionPane.showMessageDialog(null, e1);						
//		
//					}
//			}
//
//			private void Referesh() {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		bt_them.setBackground(new Color(135, 206, 250));
//		bt_them.setForeground(new Color(0, 0, 0));
//		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		bt_them.setBounds(66, 420, 108, 23);
//		contentPane.add(bt_them);
//		
//		JSeparator separator = new JSeparator();
//		separator.setBounds(10, 64, 560, 2);
//		contentPane.add(separator);
//		
//		JButton bt_thoat = new JButton("Thoát");
//		bt_thoat.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//
//
//		});
//		bt_thoat.setBackground(new Color(135, 206, 250));
//		bt_thoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		bt_thoat.setBounds(225, 421, 96, 25);
//		contentPane.add(bt_thoat);
//
//	}
//
//}
