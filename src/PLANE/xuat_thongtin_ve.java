package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class xuat_thongtin_ve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaDC;
	private JTextField textField_sdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xuat_thongtin_ve frame = new xuat_thongtin_ve();
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
	public xuat_thongtin_ve() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 350, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xuất vé");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(54, 11, 235, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã đặt vé:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 78, 104, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_MaDC = new JTextField();
		textField_MaDC.setBounds(134, 78, 128, 21);
		contentPane.add(textField_MaDC);
		textField_MaDC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SĐT:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 112, 104, 20);
		contentPane.add(lblNewLabel_2);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(134, 113, 133, 21);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		JButton bt_xuatve = new JButton("Xuất vé");
		bt_xuatve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 

					String search="select DV.ID, HK.SDT, DV.TONGTIEN, CB.ID, DV.TAIKHOAN_ID from DATVEBAY DV, HANHKHACH HK, VEMAYBAY VE, CHUYENBAY CB where HK.ID=DV.HANHKHACH_ID AND VE.ID=DV.VEMAYBAY_ID AND CB.ID=VE.CHUYENBAY_ID AND DV.TINHTRANG='Đã thanh toán' and DV.ID="+textField_MaDC.getText()+" AND HK.SDT="+textField_sdt.getText();				
				
					ResultSet rs= st.executeQuery(search);
					if(rs.next()) {
						 final String id =rs.getString(1);
							//String ttdv_update =rs.getString(3);
							String id_cb =rs.getString(4);
							String id_taikhoan =rs.getString(5);


		//					float ttdv_daupdate=Float.parseFloat(ttdv_update);
							//bắt đầu transaction 1
//							String search1="SELECT SOLUONGVECON,SOLUONGVEBAN FROM THONGKECHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
//							
//							ResultSet rs4= st.executeQuery(search1); 
//							if(rs4.next()) {
//								String slvc =rs4.getString(1);
//								String slvb =rs4.getString(2);
//
//								int slvecon=Integer.parseInt(slvc);
//								int slveban=Integer.parseInt(slvb);
//								
//								int slvecon_update=slvecon-1;
//								int slveban_update=slveban+1;
//								//bắt đầu transaction 2
//								String updatetk ="update THONGKECHUYENBAY set SOLUONGVECON="+slvecon_update+",SOLUONGVEBAN="+slveban_update+" where CHUYENBAY_ID="+id_cb+"";
//								PreparedStatement pst4 = con.prepareStatement(updatetk);
//								pst4= con.prepareStatement(updatetk);
//								pst4.execute();  
//								
//								System.out.println("update thong ke thanh cong");
//
//							}
//							else {
//								
//								ResultSet rs5=((java.sql.Statement) st).executeQuery("select MAX(ID) from THONGKECHUYENBAY");  						
//								rs5.next();
//								System.out.println(rs5.getString("MAX(ID)"));
//								int idtk=6001;
//								if(rs5.getString("MAX(ID)")==null) {
//									idtk=6001;
//								}
//								else 
//								{
//									idtk = Integer.valueOf(rs5.getString("MAX(ID)"));
//									idtk++;
//								}
//								
//								String search2="SELECT TONGSOVE FROM CHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
//								
//								ResultSet rs6= st.executeQuery(search2);
//								rs6.next();
//									String tongsove =rs6.getString(1);
//									int tongsv=Integer.parseInt(tongsove);
//									int sovecon=tongsv-1;
//									
//									SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
//									Date date=new Date();					
//									String tgString=formatter.format(date);
//									String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
//									
//								PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"THONGKECHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"THOIGIAN\",\"SOLUONGVECON\",  \"SOLUONGVEBAN\",\"NGUOIQUANLY_ID\") values("+idtk+","+id_cb+","+ngaydatve+","+sovecon+","+1+","+0+")");		
//								pst3.execute();
//								System.out.println("\ninsert thong ke thanh cong");
//
//							}		
//							
//							String search3="SELECT TONGTIENBANVE,TONGDOANHTHU FROM DOANHTHUCHUYENBAY WHERE CHUYENBAY_ID="+id_cb+"";					
//							
//							ResultSet rs7= st.executeQuery(search3);
//							if(rs7.next()) {
//								String tongtienbanve =rs7.getString(1);
//								String tongdoanhthu =rs7.getString(2);
//								
//								float ttbv=Float.parseFloat(tongtienbanve);
//								float tongtienbanve_update=ttbv+ttdv_daupdate;
//								
//								float tdt=Float.parseFloat(tongdoanhthu);
//								float tongdt_ud=tdt+ttdv_daupdate;
//								
//								String updatedt ="update DOANHTHUCHUYENBAY set TONGTIENBANVE="+tongtienbanve_update+", TONGDOANHTHU="+tongdt_ud+" where CHUYENBAY_ID="+id_cb+"";
//								PreparedStatement pst4 = con.prepareStatement(updatedt);
//								pst4= con.prepareStatement(updatedt);
//								pst4.execute();
//								System.out.println("update doanh thu thanh cong");
//							}
//							else {
//								ResultSet rs5=((java.sql.Statement) st).executeQuery("select MAX(ID) from DOANHTHUCHUYENBAY");  						
//								rs5.next();
//								System.out.println(rs5.getString("MAX(ID)"));
//								int iddt=5001;
//								if(rs5.getString("MAX(ID)")==null) {
//									iddt=5001;
//								}
//								else 
//								{
//									iddt = Integer.valueOf(rs5.getString("MAX(ID)"));
//									iddt++;
//								}
//								
//								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
//								Date date=new Date();					
//								String tgString=formatter.format(date);
//								String ngaydatve="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
//								
//								PreparedStatement pst3= con.prepareStatement("insert into \"DB_AIRLINE\".\"DOANHTHUCHUYENBAY\"  (\"ID\", \"CHUYENBAY_ID\", \"NGAYTINH\",\"TONGTIENBANVE\",  \"TONGPHIHOANVE\",\"TONGDOANHTHU\",\"NGUOIQUANLY_ID\") values("+iddt+","+id_cb+","+ngaydatve+","+ttdv_daupdate+","+0+","+ttdv_daupdate+","+0+")");		
//								pst3.execute();
//								System.out.println("insert doanh thu thanh cong");
//
//								
//							}
//							
//							
//						
//							PreparedStatement pst1=null;
//							String insert_hanhkhach;
//							if(id_taikhoan!=null) {
//	
//									String searchtkh="select TONGTIENMUAVE, ID from TAIKHOAN where ID="+id_taikhoan;					
//									ResultSet rs6= st.executeQuery(searchtkh);
//									rs6.next();
//										String tongtientk =rs6.getString(1);	
//										String idtk =rs6.getString(2);	
//
//										
//										int tttk=Integer.parseInt(tongtientk);
//										int tongtienupdate=(int) (tttk+ttdv_daupdate);
//										
//										int diem= (tongtienupdate/500000);
//										String hang = null;
//										if(diem>=30 &&diem<40) {
//											hang="Hạng bạc";
//										}
//										else if (diem>=40&&diem<50) {
//											hang="Hạng vàng";
//											
//										}
//										else if (diem>=50) {
//											hang="Hạng kim cương";
//										}
//										else if (diem<30) {
//											hang="Hạng thường";
//										}
//										
//										System.out.println("hạng: "+" "+"Diem: "+diem);
//										PreparedStatement pst4=con.prepareStatement("update TAIKHOAN set TONGTIENMUAVE="+tongtienupdate+", DIEM="+diem+",HANG='"+hang+"' where ID="+id_taikhoan);		
//										pst4.execute();
//
//										System.out.println("update tai khoan thanh cong");
//									
										
										System.out.println("lưu thông tin cập nhật thành công");
										
										
										try {
											Class.forName("oracle.jdbc.OracleDriver");
											 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
											

												FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\xuatve.jrxml"));

												JasperDesign jd1=JRXmlLoader.load(in);
												String sql="SELECT DV.ID, HK.HOTEN, CB.SANBAYDI, CB.SANBAYDEN, HV.TENHV,  DVBT.NOIDUNGDV, DV.TONGTIEN\r\n"
														+ "FROM CHUYENBAY CB, VEMAYBAY VE,DATVEBAY DV,HANGVE HV, HANHKHACH HK, DICHVUBOTRO DVBT\r\n"
														+ "WHERE CB.ID=VE.CHUYENBAY_ID AND VE.ID=DV.VEMAYBAY_ID and HV.ID=VE.HANGVE_ID AND HK.ID=DV.HANHKHACH_ID AND DVBT.ID=DV.DICHVUBOTRO_ID AND DV.ID="+id+"";				
												JRDesignQuery newQuery1=new JRDesignQuery();
												newQuery1.setText(sql);
												jd1.setQuery(newQuery1);
												JasperReport jr1=JasperCompileManager.compileReport(jd1);
												HashMap para1=new HashMap();
												JasperPrint j1=JasperFillManager.fillReport(jr1, para1,con);
												JasperViewer.viewReport(j1,false);
												java.io.OutputStream os1=new FileOutputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\Report"));
												JasperExportManager.exportReportToPdfStream(j1, os1);

											} catch (Exception e2) {
											}
										
										

										con.close();
						 
					}
					else {
						JOptionPane.showMessageDialog(null, "Thông tin không chính xác");
					}
					
			}
			
			 catch (ClassNotFoundException e1) {
				 e1.printStackTrace();
			} catch (SQLException e1) {
				 e1.printStackTrace();

			}}
		});
		bt_xuatve.setBounds(92, 191, 89, 23);
		contentPane.add(bt_xuatve);
		setVisible(true);
	}
}
