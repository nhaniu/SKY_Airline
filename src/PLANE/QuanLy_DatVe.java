package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;

public class QuanLy_DatVe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox cb_machuyenbay;
	Connection con=null;
	private JButton bt_xuatve;
	private JButton bt_chuatt;
	private JButton bt_thanhtoan;
	public static String thoigian;
	public static String thoigian1;

	
	
	public QuanLy_DatVe() {
		initComponent();
		loadCombobox1();
	}


	public void loadCombobox1() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
             PreparedStatement pst = con.prepareStatement("Select ID from CHUYENBAY");
				ResultSet rs= pst.executeQuery();
				cb_machuyenbay.addItem("");
				while(rs.next()) {
					cb_machuyenbay.addItem(rs.getString(1));
					

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
					QuanLy_DatVe frame = new QuanLy_DatVe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void initComponent() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 995, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thông tin đặt vé máy bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(311, 11, 341, 44);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 881, 14);
		contentPane.add(separator);
		
		JLabel lb_mcb = new JLabel("Mã chuyến bay:");
		lb_mcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_mcb.setBounds(72, 127, 160, 19);
		contentPane.add(lb_mcb);
		

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(621, 126, 162, 20);
		contentPane.add(dateChooser);
		
		
		bt_chuatt = new JButton("Danh sách chưa thanh toán");
		bt_chuatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new ds_chuathanhtoan();
			}
		});
		bt_chuatt.setVisible(true);
		bt_chuatt.setBackground(new Color(255, 255, 224));
		bt_chuatt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_chuatt.setBounds(346, 424, 218, 29);
		contentPane.add(bt_chuatt);
		
		bt_thanhtoan = new JButton("Cập nhật thanh toán");
		bt_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new capnhat_thanhtoan();
			}
		});
		bt_thanhtoan.setBackground(new Color(255, 255, 224));
		bt_thanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thanhtoan.setBounds(51, 424, 181, 29);
		contentPane.add(bt_thanhtoan);
		bt_thanhtoan.setVisible(true);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 208, 930, 166);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		final DefaultTableModel model=new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("ID vé máy bay ");
		model.addColumn("ID hành khách");
		model.addColumn("ID khuyến mãi");
		model.addColumn("ID dịch vụ bổ trợ");
		model.addColumn("Ngày đặt");
		model.addColumn("Tổng tiền");
		model.addColumn("Tình trạng");
		model.addColumn("Tài khoản ID");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		//table.setVisible(false);

		JButton bt_timcb = new JButton("Hiển thị");
		bt_timcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				 dateChooser.setVisible(true);
				 thoigian = "";
				 String idcb = (String) cb_machuyenbay.getItemAt(cb_machuyenbay.getSelectedIndex());
				 if(dateChooser.getDate() == null)
				 {
					 thoigian = "";
				 }else {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY");		
					String tgString = formatter.format(dateChooser.getDate());	
					  thoigian="TO_DATE('"+tgString+"','DD-MM-RR')";					
						System.out.println(thoigian);
				 }
						if(idcb == "" && thoigian != "") {
						 try {
								Class.forName("oracle.jdbc.OracleDriver");
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
								Statement st=con.createStatement(); 
								
								String search="select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID,"
										+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID"
										+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID where NGAYDAT="+thoigian+"";					
													
								while(model.getRowCount() > 0) 
								{									
									model.removeRow(0);
								}
								ResultSet rs= st.executeQuery(search);
								while(rs.next()) {
									String ID =rs.getString(1);
									String vemaybay_id =rs.getString(2);
									String hanhkhach_id =rs.getString(3);
									String khuyenmai_id =rs.getString(4);
									String dichvubotro_id = rs.getString(5);
									String ngaydat =rs.getString(6);
									String tongtien =rs.getString(7);
									String tinhtrang=rs.getString(8);
									String taikhoan_id =rs.getString(9);
									
									
									model.addRow(new Object[] {ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,tongtien,tinhtrang,taikhoan_id});

									table.setModel(model);
									scrollPane.setVisible(true);
								}
								con.close();
								
							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							} catch (SQLException e2) {
								e2.printStackTrace();
							}		
						}
			
				 else if (idcb != "" && thoigian == "") {
					 try {
							Class.forName("oracle.jdbc.OracleDriver");
							Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
							Statement st=con.createStatement(); 
							
							String search="select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID,"
									+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID"
									+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID INNER JOIN CHUYENBAY c ON V.CHUYENBAY_ID = c.ID where c.ID="+idcb+"";					
												
							while(model.getRowCount() > 0) 
							{									
								model.removeRow(0);
							}
							
							ResultSet rs= st.executeQuery(search);
							while(rs.next()) {
								String ID =rs.getString(1);
								String vemaybay_id =rs.getString(2);
								String hanhkhach_id =rs.getString(3);
								String khuyenmai_id =rs.getString(4);
								String dichvubotro_id = rs.getString(5);
								String ngaydat =rs.getString(6);
								String tongtien =rs.getString(7);
								String tinhtrang=rs.getString(8);
								String taikhoan_id =rs.getString(9);
								
								
								model.addRow(new Object[] {ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,tongtien,tinhtrang,taikhoan_id});

								table.setModel(model);
								scrollPane.setVisible(true);
							}
							con.close();
							
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}			
					}
				 else if (idcb != "" && thoigian != "") {
					 try {
							Class.forName("oracle.jdbc.OracleDriver");
							Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
							Statement st=con.createStatement(); 
							
							String search="select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID,"
									+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID"
									+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID where v.CHUYENBAY_ID="+cb_machuyenbay.getSelectedItem()+"and NGAYDAT="+thoigian+"";					
												
							while(model.getRowCount() > 0) 
							{									
								model.removeRow(0);
							}
							ResultSet rs= st.executeQuery(search);
							while(rs.next()) {
								String ID =rs.getString(1);
								String vemaybay_id =rs.getString(2);
								String hanhkhach_id =rs.getString(3);
								String khuyenmai_id =rs.getString(4);
								String dichvubotro_id = rs.getString(5);
								String ngaydat =rs.getString(6);
								String tongtien =rs.getString(7);
								String tinhtrang=rs.getString(8);
								String taikhoan_id =rs.getString(9);
								
								
								model.addRow(new Object[] {ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,tongtien,tinhtrang,taikhoan_id});

								table.setModel(model);
								scrollPane.setVisible(true);
							}
							con.close();
							
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}			
					}
				 else if (idcb == "" && thoigian.equals("")) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập thông tin để tìm danh sách");
				 }
				}
			});
		bt_timcb.setBackground(new Color(255, 255, 224));
		bt_timcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timcb.setBounds(716, 175, 127, 23);
		contentPane.add(bt_timcb);
		
		cb_machuyenbay = new JComboBox();
		cb_machuyenbay.setBounds(187, 127, 148, 21);
		contentPane.add(cb_machuyenbay);
		
		JLabel lblNewLabel = new JLabel("Ngày");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(565, 122, 127, 29);
		contentPane.add(lblNewLabel);
		
		bt_xuatve = new JButton("Xuất vé");
		bt_xuatve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new xuat_thongtin_ve();
			}
		});
		bt_xuatve.setBackground(new Color(255, 255, 224));
		bt_xuatve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_xuatve.setBounds(676, 424, 181, 29);
		contentPane.add(bt_xuatve);
		bt_xuatve.setVisible(true);
		
		JLabel lblNewLabel2 = new JLabel("New label");
		lblNewLabel2.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel2.setBounds(10, 0, 1051, 543);
		contentPane.add(lblNewLabel2);
		
		
	}
}
