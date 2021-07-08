package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class update_thanhtoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_madatve;
	private JTextField textField_SDT;
	private JTable table;
	
	Connection con;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_thanhtoan frame = new update_thanhtoan();
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
	public update_thanhtoan() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 942, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb_cntt = new JLabel("CẬP NHẬT THANH TOÁN");
		lb_cntt.setBounds(297, 22, 420, 30);
		lb_cntt.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cntt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lb_madv = new JLabel("Mã đặt vé :");
		lb_madv.setBounds(87, 89, 96, 24);
		lb_madv.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_madatve = new JTextField();
		textField_madatve.setBounds(230, 89, 218, 24);
		textField_madatve.setColumns(10);
		
		JLabel lb_SDT = new JLabel("Số điện thoại :");
		lb_SDT.setBounds(87, 140, 121, 24);
		lb_SDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(230, 137, 218, 24);
		textField_SDT.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 290, 823, 39);

		table = new JTable();
		final DefaultTableModel model=new DefaultTableModel();
		table.setVisible(false);
		
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
		
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		
		JButton btn_timkiem = new JButton("Tìm kiếm");
		btn_timkiem.setBackground(new Color(124, 252, 0));
		btn_timkiem.setBounds(87, 219, 107, 24);
		btn_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField_madatve.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null,"Vui lòng nhập mã đặt vé");
					textField_madatve.requestFocus();
					return;
				}
				if(textField_SDT.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null,"Vui lòng nhập số điện thoại");
					textField_SDT.requestFocus();
					return;
				}
				
				try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				Statement st=con.createStatement(); 
				
				String timkiem = "select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID from HANHKHACH h, DATVEBAY d "
						+ " where h.ID=d.HANHKHACH_ID AND h.SDT='"+textField_SDT.getText()+"'AND d.ID ='"+textField_madatve.getText()+"' AND d.TINHTRANG='Chưa thanh toán'";
				
				while(model.getRowCount() > 0) 
				{									
					model.removeRow(0);
				}
				
				ResultSet rs= st.executeQuery(timkiem);
				if(rs.next()) {
					String ID =rs.getString(1);
					String vemaybayid =rs.getString(2);
					String hanhkhachid =rs.getString(3);
					String khuyenmaiid =rs.getString(4);
					String dvbtid =rs.getString(5);
					String ngaydat =rs.getString(6);
					String tongtien =rs.getString(7);
					String tinhtrang =rs.getString(8);
					String taikhoanid =rs.getString(9);

					
					System.out.print(ID+vemaybayid+hanhkhachid+khuyenmaiid+dvbtid+ngaydat+tongtien+tinhtrang+taikhoanid+"\n");
					
					model.addRow(new Object[] {ID,vemaybayid,hanhkhachid,khuyenmaiid,dvbtid,ngaydat,tongtien,tinhtrang,taikhoanid});

					table.setModel(model);
					scrollPane.setVisible(true);
					btn_timkiem.setVisible(true);
					btnNewButton.setVisible(true);

					table.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy hoặc vé không đủ điều kiện");
				}
				
			} catch (ClassNotFoundException e1) {
				 e1.printStackTrace();
			} catch (SQLException e1) {
				 e1.printStackTrace();
			}

		}
		});
		contentPane.setLayout(null);
		contentPane.add(lb_cntt);
		contentPane.add(lb_madv);
		contentPane.add(textField_madatve);
		contentPane.add(lb_SDT);
		contentPane.add(textField_SDT);
		contentPane.add(btn_timkiem);
		contentPane.add(scrollPane);
		
		
		btnNewButton = new JButton("Xác nhận thanh toán");
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setBounds(87, 428, 183, 24);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(textField_madatve.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(null,"Vui lòng nhập mã đặt vé");
						textField_madatve.requestFocus();
						return;
					}
					if(textField_SDT.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(null,"Vui lòng nhập số điện thoại");
						textField_SDT.requestFocus();
						return;
					}

					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					
					dangnhap_nhanvien dn=null;
					System.out.println("ten dang nhap: "+dn.tendn);
					
					String nv="SELECT ID FROM NHANVIEN WHERE NHIEMVU='Bán Vé' and TENDANGNHAP='"+dn.tendn+"'";
					ResultSet rsn= st.executeQuery(nv);
					if(rsn.next()) {
						String idnv1 =rsn.getString(1);	
						System.out.println("idnv: "+idnv1);
					
					String timkiem = "select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID from HANHKHACH h, DATVEBAY d "
							+ " where h.ID=d.HANHKHACH_ID AND d.ID ='"+textField_madatve.getText()+"'";
					
					while(model.getRowCount() > 0) 
					{									
						model.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(timkiem);
					if(rs.next()) {
						String ID =rs.getString(1);
						String vemaybayid =rs.getString(2);
						String hanhkhachid =rs.getString(3);
						String khuyenmaiid =rs.getString(4);
						String dvbtid =rs.getString(5);
						String ngaydat =rs.getString(6);
						String tongtien =rs.getString(7);
						String tinhtrang =rs.getString(8);
						String taikhoanid =rs.getString(9);

						
						
						model.addRow(new Object[] {ID,vemaybayid,hanhkhachid,khuyenmaiid,dvbtid,ngaydat,tongtien,tinhtrang,taikhoanid});

						table.setModel(model);
						scrollPane.setVisible(true);
						btn_timkiem.setVisible(true);
						table.setVisible(true);
						
						
						
						
						PreparedStatement pst4=con.prepareStatement("update DATVEBAY set TINHTRANG = 'Đã thanh toán', NHANVIEN_ID="+idnv1+" where ID ="+ID);		
						pst4.execute();
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						
						 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						Statement st1=con.createStatement(); 

						String search="select DV.ID, HK.SDT, DV.TONGTIEN, CB.ID, DV.TAIKHOAN_ID from DATVEBAY DV, HANHKHACH HK, VEMAYBAY VE, CHUYENBAY CB where HK.ID=DV.HANHKHACH_ID AND VE.ID=DV.VEMAYBAY_ID AND CB.ID=VE.CHUYENBAY_ID AND DV.TINHTRANG='Đã thanh toán' and DV.ID="+textField_madatve.getText()+" AND HK.SDT="+textField_SDT.getText();				
					
						ResultSet rs1= st1.executeQuery(search);
						if(rs1.next()) {
							final	String id =rs1.getString(1);
									String ttdv_update =rs.getString(3);
									String id_cb =rs1.getString(4);
									String id_taikhoan =rs1.getString(5);


						float ttdv_daupdate=Float.parseFloat(ttdv_update);

						String search1="SELECT SOLUONGVECON,SOLUONGVEBAN FROM THONGKECHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
								
								ResultSet rs4= st1.executeQuery(search1); 
								if(rs4.next()) {
									String slvc =rs4.getString(1);
									String slvb =rs4.getString(2);

									int slvecon=Integer.parseInt(slvc);
									int slveban=Integer.parseInt(slvb);
									
									int slvecon_update=slvecon-1;
									int slveban_update=slveban+1;
									//bắt đầu transaction 2
									String updatetk ="update THONGKECHUYENBAY set SOLUONGVECON="+slvecon_update+",SOLUONGVEBAN="+slveban_update+" where CHUYENBAY_ID="+id_cb+"";
									PreparedStatement pst41 = con.prepareStatement(updatetk);
									pst41= con.prepareStatement(updatetk);
									pst41.execute();  
									
									System.out.println("update thong ke thanh cong");

								}
								else {
									
									ResultSet rs5=((java.sql.Statement) st1).executeQuery("select MAX(ID) from THONGKECHUYENBAY");  						
									rs5.next();
									System.out.println(rs5.getString("MAX(ID)"));
									int idtk=6001;
									if(rs5.getString("MAX(ID)")==null) {
										idtk=6001;
									}
									else 
									{
										idtk = Integer.valueOf(rs5.getString("MAX(ID)"));
										idtk++;
									}
									
									String search2="SELECT TONGSOVE FROM CHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
									
									ResultSet rs6= st1.executeQuery(search2);
									rs6.next();
										String tongsove =rs6.getString(1);
										int tongsv=Integer.parseInt(tongsove);
										int sovecon=tongsv-1;
										
										SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
										Date date=new Date();					
										String tgString=formatter.format(date);
										String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
										
									PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"THONGKECHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"THOIGIAN\",\"SOLUONGVECON\",  \"SOLUONGVEBAN\",\"NGUOIQUANLY_ID\") values("+idtk+","+id_cb+","+ngaydatve+","+sovecon+","+1+","+0+")");		
									pst3.execute();
									System.out.println("\ninsert thong ke thanh cong");

								}		
								
								String search3="SELECT TONGTIENBANVE,TONGDOANHTHU FROM DOANHTHUCHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
								
								ResultSet rs7= st1.executeQuery(search3);
								if(rs7.next()) {
									String tongtienbanve =rs7.getString(1);
									String tongdoanhthu =rs7.getString(2);
									
									float ttbv=Float.parseFloat(tongtienbanve);
									float tongtienbanve_update=ttbv+ttdv_daupdate;
									
									float tdt=Float.parseFloat(tongdoanhthu);
									float tongdt_ud=tdt+ttdv_daupdate;
									
									String updatedt ="update DOANHTHUCHUYENBAY set TONGTIENBANVE="+tongtienbanve_update+", TONGDOANHTHU="+tongdt_ud+" where CHUYENBAY_ID="+id_cb+"";
									PreparedStatement pst41 = con.prepareStatement(updatedt);
									pst41= con.prepareStatement(updatedt);
									pst41.execute();
									System.out.println("update doanh thu thanh cong");
								}
								else {
									ResultSet rs5=((java.sql.Statement) st1).executeQuery("select MAX(ID) from DOANHTHUCHUYENBAY");  						
									rs5.next();
									System.out.println(rs5.getString("MAX(ID)"));
									int iddt=5001;
									if(rs5.getString("MAX(ID)")==null) {
										iddt=5001;
									}
									else 
									{
										iddt = Integer.valueOf(rs5.getString("MAX(ID)"));
										iddt++;
									}
										SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
									Date date=new Date();					
									String tgString=formatter.format(date);
									String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
									
									PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"DOANHTHUCHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"NGAYTINH\",\"TONGTIENBANVE\",  \"TONGPHIHOANVE\",\"TONGDOANHTHU\",\"NGUOIQUANLY_ID\") values("+iddt+","+id_cb+","+ngaydatve+","+ttdv_daupdate+","+0+","+ttdv_daupdate+","+0+")");		
									pst3.execute();
									System.out.println("insert doanh thu thanh cong");

								
								}
								
								
						
								PreparedStatement pst1=null;
								String insert_hanhkhach;
								if(id_taikhoan!=null) {
		
										String searchtkh="select TONGTIENMUAVE, ID from TAIKHOAN where ID="+id_taikhoan;					
										ResultSet rs6= st1.executeQuery(searchtkh);
										rs6.next();
											String tongtientk =rs6.getString(1);	
											String idtk =rs6.getString(2);	

											
											int tttk=Integer.parseInt(tongtientk);
											int tongtienupdate=(int) (tttk+ttdv_daupdate);
											
											int diem= (tongtienupdate/500000);
											String hang = null;
											if(diem>=30 &&diem<40) {
												hang="Hạng bạc";
											}
											else if (diem>=40&&diem<50) {
												hang="Hạng vàng";
												
											}
											else if (diem>=50) {
												hang="Hạng kim cương";
											}
											else if (diem<30) {
												hang="Hạng thường";
											}
											
											System.out.println("hạng: "+" "+"Diem: "+diem);
											PreparedStatement pst41=con.prepareStatement("update TAIKHOAN set TONGTIENMUAVE="+tongtienupdate+", DIEM="+diem+",HANG='"+hang+"' where ID="+id_taikhoan);		
											pst41.execute();

											System.out.println("update tai khoan thanh cong");
								
											
											System.out.println("lưu thông tin cập nhật thành công");
											
											
							 
						}
								//Statement st=con.createStatement(); 
								
								String timkiem1 = "select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, d.DICHVUBOTRO_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID from HANHKHACH h, DATVEBAY d "
										+ " where h.ID=d.HANHKHACH_ID AND h.SDT="+textField_SDT.getText()+"";
								
								while(model.getRowCount() > 0) 
								{									
									model.removeRow(0);
								}
								
								ResultSet rs11= st.executeQuery(timkiem1);
								if(rs11.next()) {
									String ID1 =rs11.getString(1);
									String vemaybayid1 =rs11.getString(2);
									String hanhkhachid1 =rs11.getString(3);
									String khuyenmaiid1 =rs11.getString(4);
									String dvbtid1 =rs11.getString(5);
									String ngaydat1 =rs11.getString(6);
									String tongtien1 =rs11.getString(7);
									String tinhtrang1 =rs11.getString(8);
									 String taikhoanid1 =rs11.getString(9);

									
									
									model.addRow(new Object[] {ID1,vemaybayid1,hanhkhachid1,khuyenmaiid1,dvbtid1,ngaydat1,tongtien1,tinhtrang1,taikhoanid1});

									table.setModel(model);
									
									
								}
						
					}

					
				}
					else {
						JOptionPane.showMessageDialog(null, "Thông tin không chính xác");
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "Bạn không thuộc nhiệm vụ này");
					}
				}
			
			 catch (ClassNotFoundException e1) {
				 e1.printStackTrace();
			} catch (SQLException e1) {
				 e1.printStackTrace();

			}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 928, 493);
		contentPane.add(lblNewLabel);

		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel.setIcon(scaleIcon);
		
		
	}
}




