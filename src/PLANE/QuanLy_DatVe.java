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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
import java.awt.SystemColor;

//import jdk.internal.net.http.frame.DataFrame;

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
	DefaultTableModel model;
	private JScrollPane scrollPane;
	ResultSet rs;
	private int result = -2;

	
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
		setBounds(100, 100, 1063, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Th??ng tin ?????t v?? m??y bay");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(311, 11, 341, 44);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 66, 881, 14);
		contentPane.add(separator);
		
		JLabel lb_mcb = new JLabel("M?? chuy???n bay");
		lb_mcb.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lb_mcb.setBounds(51, 119, 160, 19);
		contentPane.add(lb_mcb);
		

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(621, 119, 162, 27);
		contentPane.add(dateChooser);
		
		System.out.println("HIIIIIIIIIIIIIIIIIIII");

		bt_chuatt = new JButton("Danh s??ch ch??a thanh to??n");
		bt_chuatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s = model.getRowCount();
				for (int i = s - 1; i >= 0; i--) {
				String tinhtrang = model.getValueAt(i, 8).toString();
				System.out.print(i + tinhtrang);
				if (tinhtrang.equals("???? thanh to??n") || (tinhtrang.equals("???? ho??n v??"))) {
					model.removeRow(i);
			}
		}
			}
		});
		bt_chuatt.setVisible(true);
		bt_chuatt.setBackground(new Color(255, 255, 224));
		bt_chuatt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_chuatt.setBounds(243, 424, 248, 29);
		contentPane.add(bt_chuatt);
		
		bt_thanhtoan = new JButton("C???p nh???t thanh to??n");
		bt_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new update_thanhtoan();
			}
		});
		bt_thanhtoan.setBackground(new Color(255, 255, 224));
		bt_thanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thanhtoan.setBounds(28, 424, 181, 29);
		contentPane.add(bt_thanhtoan);
		bt_thanhtoan.setVisible(true);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 1039, 166);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		model=new DefaultTableModel();
		model.addColumn("ID chuy???n bay");
		model.addColumn("ID ?????t v??");
		model.addColumn("ID v?? m??y bay ");
		model.addColumn("ID h??nh kh??ch");
		model.addColumn("ID khuy???n m??i");
		model.addColumn("ID d???ch v??? b??? tr???");
		model.addColumn("Ng??y ?????t");
		model.addColumn("Ng??y kh???i h??nh");
		model.addColumn("T???ng ti???n");
		model.addColumn("T??nh tr???ng");
		model.addColumn("T??i kho???n ID");

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		//table.setVisible(false);

		JButton bt_timcb = new JButton("Hi???n th???");
		bt_timcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				 dateChooser.setVisible(true);
				 thoigian = "";
				 String idcb = (String) cb_machuyenbay.getItemAt(cb_machuyenbay.getSelectedIndex());
				 if(dateChooser.getDate() == null)
				 {
					 thoigian = "";
				 }
				 else {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY");		
					String tgString = formatter.format(dateChooser.getDate());	
					  thoigian="TO_DATE('"+tgString+"','DD-MM-RR')";	
					  thoigian1="TO_DATE('"+tgString+" 23:59:59','DD-MM-RR HH24:MI:SS')";
						System.out.println(thoigian);
				 }
						if(idcb == "" && thoigian != "") {
						 try {
								Class.forName("oracle.jdbc.OracleDriver");
								Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
								Statement st=con.createStatement(); 
								
								String search="select v.CHUYENBAY_ID, d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, C.NGAY_GIO_KH,"
										+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID, d.NHANVIEN_ID"
										+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID INNER JOIN CHUYENBAY C ON C.ID=v.CHUYENBAY_ID where  NGAYDAT>="+thoigian+" and NGAYDAT<"+thoigian1+"";					
								while(model.getRowCount() > 0) 
								{									
									model.removeRow(0);
								}
								rs= st.executeQuery(search);
								while(rs.next()) {
									String chuyenbay_ID =rs.getString(1);
									String ID =rs.getString(2);
									String vemaybay_id =rs.getString(3);
									String hanhkhach_id =rs.getString(4);
									String khuyenmai_id =rs.getString(5);
									String dichvubotro_id = rs.getString(6);
									String ngaydat =rs.getString(7);
									String tongtien =rs.getString(8);
									String tinhtrang=rs.getString(9);
									String taikhoan_id =rs.getString(10);
									String ngaykh =rs.getString(11);

									
									
									model.addRow(new Object[] {chuyenbay_ID,ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,ngaykh,tongtien ,tinhtrang,taikhoan_id});

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
							
							String search="select v.CHUYENBAY_ID, d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID,c.NGAY_GIO_KH, "
									+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID"
									+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID INNER JOIN CHUYENBAY c ON v.CHUYENBAY_ID = c.ID where c.ID="+idcb+"";					
												
							while(model.getRowCount() > 0) 
							{									
								model.removeRow(0);
							}
							
							rs= st.executeQuery(search);
							while(rs.next()) {
								String chuyenbay_ID =rs.getString(1);
								String ID =rs.getString(2);
								String vemaybay_id =rs.getString(3);
								String hanhkhach_id =rs.getString(4);
								String khuyenmai_id =rs.getString(5);
								String dichvubotro_id = rs.getString(6);
								String ngaydat =rs.getString(7);
								String tongtien =rs.getString(8);
								String tinhtrang=rs.getString(9);
								String taikhoan_id =rs.getString(10);
								String ngaykh =rs.getString(11);

								
								
								model.addRow(new Object[] {chuyenbay_ID,ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,ngaykh,tongtien,tinhtrang,taikhoan_id});

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
							
							String search="select v.CHUYENBAY_ID, d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, C.NGAY_GIO_KH,"
									+ "d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID, d.NHANVIEN_ID"
									+ " from DATVEBAY d INNER JOIN VEMAYBAY v ON d.VEMAYBAY_ID = v.ID INNER JOIN CHUYENBAY C ON C.ID=v.CHUYENBAY_ID  where v.CHUYENBAY_ID="+cb_machuyenbay.getSelectedItem()+"and NGAYDAT>="+thoigian+"and NGAYDAT<"+thoigian1+"";					
							while(model.getRowCount() > 0) 
							{									
								model.removeRow(0);
							}
							rs= st.executeQuery(search);
							while(rs.next()) {
								String chuyenbay_ID =rs.getString(1);
								String ID =rs.getString(2);
								String vemaybay_id =rs.getString(3);
								String hanhkhach_id =rs.getString(4);
								String khuyenmai_id =rs.getString(5);
								String dichvubotro_id = rs.getString(6);
								String ngaydat =rs.getString(7);
								String tongtien =rs.getString(8);
								String tinhtrang=rs.getString(9);
								String taikhoan_id =rs.getString(10);
								String ngaykh =rs.getString(11);

								
								model.addRow(new Object[] {chuyenbay_ID,ID,vemaybay_id,hanhkhach_id,khuyenmai_id,dichvubotro_id,ngaydat,ngaykh,tongtien,tinhtrang,taikhoan_id});

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
					 JOptionPane.showMessageDialog(null, "vui l??ng nh???p th??ng tin ????? t??m danh s??ch");
				 }
				}
			});
		bt_timcb.setBackground(new Color(255, 255, 224));
		bt_timcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timcb.setBounds(621, 173, 127, 23);
		contentPane.add(bt_timcb);
		
		cb_machuyenbay = new JComboBox();
		cb_machuyenbay.setBounds(187, 119, 150, 27);
		contentPane.add(cb_machuyenbay);
		
		JLabel lblNewLabel = new JLabel("Ng??y");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(563, 114, 127, 29);
		contentPane.add(lblNewLabel);
		
		bt_xuatve = new JButton("Xu???t v??");
		bt_xuatve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new xuat_thongtin_ve();
			}
		});
		bt_xuatve.setBackground(SystemColor.info);
		bt_xuatve.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_xuatve.setBounds(774, 424, 181, 29);
		contentPane.add(bt_xuatve);
		bt_xuatve.setVisible(true);
		
		
		
		JButton btnNewButton = new JButton("X??a V?? ?????t");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   int i = table.getSelectedRow();	
				 SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	
				String search2 = new String();
				String date_KH = null;
				if(i == -1 ) {
					JOptionPane.showMessageDialog(null, "Ch???n v?? ???? ?????t c???n x??a");
				}
				else {
					String tinhtrang = model.getValueAt(i, 8).toString();  	
					String idcb1 = table.getValueAt(i, 0).toString();
				 String iddv = table.getValueAt(i, 1).toString();

				   try {
						Class.forName("oracle.jdbc.OracleDriver");
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						java.sql.Statement st=con.createStatement();
						Statement st1=con.createStatement(); 
							search2="select NGAY_GIO_KH from CHUYENBAY where ID = "+idcb1+"";
							ResultSet rs3 = st1.executeQuery(search2);
							System.out.println(search2);
							while (rs3.next())
							{
								date_KH =rs3.getString(1);
							}
							
						con.close();
						   System.out.println("Ng??y kh???i h??nh "+date_KH);

								 
					} catch (ClassNotFoundException e1) {
						//e1.printStackTrace();
					} catch (SQLException e1) {
						//e1.printStackTrace();
					} 					
									
				         java.util.Date date1 = null;				         				     
						 Date date = new java.sql.Timestamp(new java.util.Date().getTime());
						 	SimpleDateFormat readFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
						    SimpleDateFormat writeFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
						    Date date3 = null;
						    try {
						       date3 = readFormat.parse(date_KH);
						    } catch ( ParseException e1 ) {
						        e1.printStackTrace();
						    }

						    String formattedDate = "";
						    if( date3 != null ) {
						    formattedDate = writeFormat.format( date3 );
						    }

						    System.out.println(formattedDate);
						// Date date3 = formatter1.parse(date_KH);
							   result = date.compareTo(date3); 

						  System.out.println(result);
				   System.out.println("Ng??y kh???i h??nh "+date3);
				   System.out.println("Ng??y h??? th???ng "+date);
				   
				   if(tinhtrang.equals("Ch??a thanh to??n") && result > 0){
					   System.out.println("???? kh???i h??nh");
					int deleteItem =JOptionPane.showConfirmDialog(null, "X??c nh???n n???u b???n mu???n x??a","Warning",JOptionPane.YES_NO_OPTION);
					if(deleteItem==JOptionPane.YES_OPTION) {
					 try {
							Class.forName("oracle.jdbc.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");		
							PreparedStatement pst = con.prepareStatement("delete from  DATVEBAY where ID=?");
							pst.setString(1, iddv);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "X??a th??nh c??ng");
							
							con.close();
						} catch (ClassNotFoundException e1) {
							//e1.printStackTrace();
						} catch (SQLException e2) {
							//e2.printStackTrace();
						}			
				}				 
			} else {
				
				JOptionPane.showMessageDialog(null, "V?? kh??ng th??? x??a");
			}
				   
		}
	}
});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(535, 425, 185, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel2 = new JLabel("New label");
		lblNewLabel2.setBackground(SystemColor.info);
		lblNewLabel2.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel2.setBounds(0, 0, 1076, 543);
		contentPane.add(lblNewLabel2);
		
		
	}
	
}
