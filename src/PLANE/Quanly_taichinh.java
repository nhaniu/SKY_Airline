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
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import com.bea.xml.stream.StaticAllocator;
import com.ibm.icu.impl.duration.TimeUnit;
import com.lowagie.text.pdf.codec.Base64.InputStream;
import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.ImageIcon;

public class Quanly_taichinh extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanly_taichinh frame = new Quanly_taichinh();
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
	int kt=0;
	  String id ;
	 String cbid;
	 String ngaygiokh;
	 String tongbanve;
	 String tongphihoan;
	 String tongdoanhthu;
	 int demIn=0;
	 private JTable table_1;
	 Connection con=null;
	 public static String thoigian, thoigian1;
	 public static String thoigian11, thoigian22;

	/**
	 * 
	 */
	/**
	 * 
	 */
	public Quanly_taichinh() {
	    
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 854, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Thống kê doanh thu");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(189, 23, 432, 32);
		contentPane.add(lb_title);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 59, 830, 11);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 219, 780, 128);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);
		table.setEditingRow(0);
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Chuyến bay ID");
		tableModel.addColumn("Thời gian");
		tableModel.addColumn("Tổng tiền bán vé");
		tableModel.addColumn("Tổng tiền hoàn");
		tableModel.addColumn("Doanh thu");

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		Theader.setBackground(new Color(255, 255, 224));

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 370, 780, 39);
		contentPane.add(scrollPane_1);
		scrollPane_1.setVisible(false);
		
		
		
		
		
		JLabel lb_ngaybatdau = new JLabel("Ngày:");
		lb_ngaybatdau.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaybatdau.setBounds(31, 155, 99, 26);
		contentPane.add(lb_ngaybatdau);
		lb_ngaybatdau.setVisible(false);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(94, 154, 139, 26);
		contentPane.add(dateChooser1);
		dateChooser1.setVisible(false);
		
		JLabel lb_ngaykt = new JLabel("Đến ngày: ");
		lb_ngaykt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ngaykt.setBounds(316, 154, 73, 29);
		contentPane.add(lb_ngaykt);
		lb_ngaykt.setVisible(false);
		
		JDateChooser dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(399, 154, 140, 26);
		contentPane.add(dateChooser2);
		dateChooser2.setVisible(false);
		
		JButton bt_1ngay = new JButton("1 ngày");
		bt_1ngay.setBackground(new Color(255, 255, 224));
		bt_1ngay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kt=1;
				lb_ngaybatdau.setVisible(true);
				dateChooser1.setVisible(true);
				lb_ngaykt.setVisible(false);
				dateChooser2.setVisible(false);
			
			}
		});
		bt_1ngay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_1ngay.setBounds(144, 81, 89, 23);
		contentPane.add(bt_1ngay);
		
		JButton bt_1thang = new JButton("Tùy chọn");
		bt_1thang.setBackground(new Color(255, 255, 224));
		bt_1thang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kt=2;
				lb_ngaybatdau.setVisible(true);
				dateChooser1.setVisible(true);
				lb_ngaykt.setVisible(true);
				dateChooser2.setVisible(true);
			}
		});
		bt_1thang.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_1thang.setBounds(564, 81, 125, 23);
		contentPane.add(bt_1thang);
		
		table_1 = new JTable();
		table_1.setVisible(false);
		
		JButton btnNewButton = new JButton("Xuất tổng doanh thu");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setVisible(false);
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(160, 453, 183, 23);
		contentPane.add(btnNewButton);
		
		JButton bt_xuatfile = new JButton("Xuất doanh thu theo chuyến");
		bt_xuatfile.setVisible(false);
		bt_xuatfile.setBackground(new Color(255, 255, 224));
		bt_xuatfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});


		JButton bt_thongke = new JButton("Thống kê theo chuyến bay");
		bt_thongke.addActionListener(new ActionListener() {
			private String date;
			

			public void actionPerformed(ActionEvent e) {
				
				demIn=0;

				if (kt==1) {
					try {
						
						Class.forName("oracle.jdbc.OracleDriver");
						 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						Statement st=con.createStatement(); 

						SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY");	
						System.out.println(dateChooser1.getDate());
						if (dateChooser1.getDate()==null)
						{
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
						}
						else {
							
						
						String tgString=formatter.format(dateChooser1.getDate());	
						 thoigian="TO_DATE('"+tgString+"','DD-MM-RR')";
						 thoigian1="TO_DATE('"+tgString+" 23:59:59','DD-MM-RR HH24:MI:SS')";
						
						 
						while(tableModel.getRowCount() > 0) 
						{									
							tableModel.removeRow(0);
						}									
						String search1=" SELECT DISTINCT DT.ID, CB.ID, CB.NGAY_GIO_KH, DT.TONGTIENBANVE, DT.TONGPHIHOANVE, DT.TONGDOANHTHU\r\n"
								+ "FROM  CHUYENBAY CB, DOANHTHUCHUYENBAY DT\r\n"
								+ "WHERE CB.ID= DT.CHUYENBAY_ID and CB.NGAY_GIO_KH>="+thoigian+" and  CB.NGAY_GIO_KH<="+thoigian1+"";
						ResultSet rs1= st.executeQuery(search1);
						int dem=0;
						while (rs1.next()) {							
							 id =rs1.getString(1);
							 cbid =rs1.getString(2);
							 ngaygiokh =rs1.getString(3);
							 tongbanve =rs1.getString(4);
							 tongphihoan =rs1.getString(5);
							 tongdoanhthu =rs1.getString(6);
							 dem++;
					
						tableModel.addRow(new Object[] {id,cbid,ngaygiokh,tongbanve,tongphihoan,tongdoanhthu});

						table.setModel(tableModel);
												
							// String thoigian11 = "TO_DATE('"+ngaygiokh+"','yyyy-mm-dd HH24:MI:SS')";
								btnNewButton.setVisible(true);

						bt_xuatfile.setVisible(true);
						scrollPane.setVisible(true);
						table.setVisible(true);
						scrollPane_1.setVisible(true);
						table_1.setVisible(true);
						
						}
						
						if(dem==0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin");
						}
						table_1.setVisible(true);
						scrollPane_1.setViewportView(table_1);
						final DefaultTableModel model = new DefaultTableModel();

						model.addColumn("Tổng chuyến bay");
						model.addColumn("Tổng tiền bán vé");
						model.addColumn("Tổng tiền hoàn vé");
						model.addColumn(" Tổng doanh thu");

						
						JTableHeader Theader1 = table_1.getTableHeader();
						 Theader1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
						Theader1.setBackground(new Color(255, 255, 255));
						table_1.setModel(model);
						Theader1.setBackground(new Color(255, 255, 224));

						
						while(model.getRowCount() > 0) 
						{									
							model.removeRow(0);
						}
									
						String search=" SELECT count(DISTINCT CB.ID), SUM(TONGTIENBANVE),SUM(TONGPHIHOANVE), SUM(TONGDOANHTHU)\r\n"
								+ "FROM  CHUYENBAY CB, DOANHTHUCHUYENBAY DT\r\n"
								+ "WHERE CB.ID= DT.CHUYENBAY_ID AND  CB.NGAY_GIO_KH>= "+thoigian+" AND CB.NGAY_GIO_KH<="+thoigian1+"";
						ResultSet rs= st.executeQuery(search);
						while(rs.next()) {
							String tid_chuyenbay =rs.getString(1);
							String ttienve =rs.getString(2);
							String tphihoan =rs.getString(3);							 
							String tdoanhthu =rs.getString(4);
							
			
						model.addRow(new Object[] {tid_chuyenbay,ttienve,tphihoan,tdoanhthu});

						table_1.setModel(model);
						
						
						}
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	

					
					
				
			
					
				}
				
				if(kt==2) {
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						Statement st=con.createStatement(); 
						
						if (dateChooser1.getDate()==null||dateChooser2.getDate()==null)
						{
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
						}
						else {
						
						SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-YY");		
						String tgString2=formatter2.format(dateChooser1.getDate());	
						thoigian11="TO_DATE('"+tgString2+"','DD-MM-RR')";
						
						
						SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-YY");		
						String tgString1=formatter1.format(dateChooser2.getDate());	
						thoigian22="TO_DATE('"+tgString1+" 23:59:59','DD-MM-RR HH24:MI:SS')";

						System.out.println(thoigian11);
						
						System.out.println(thoigian22);
						
						
												
						while(tableModel.getRowCount() > 0) 
						{									
							tableModel.removeRow(0);
						}
								
						String search1=" SELECT DISTINCT DT.ID, CB.ID, CB.NGAY_GIO_KH, DT.TONGTIENBANVE, DT.TONGPHIHOANVE, DT.TONGDOANHTHU\r\n"
								+ "FROM  CHUYENBAY CB, DOANHTHUCHUYENBAY DT where CB.ID= DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>="+thoigian11+" and  CB.NGAY_GIO_KH<="+thoigian22+"";
						ResultSet rs1= st.executeQuery(search1);
						int dem=0;
						while(rs1.next()) {
							
							 id =rs1.getString(1);
							 cbid =rs1.getString(2);
							 ngaygiokh =rs1.getString(3);
							 tongbanve =rs1.getString(4);
							 tongphihoan =rs1.getString(5);
							 tongdoanhthu =rs1.getString(6);
							 String thoigian33 = "TO_DATE('"+ngaygiokh+"','yyyy-mm-dd HH24:MI:SS')";
							 System.out.println(thoigian33);
							 tableModel.addRow(new Object[] {id,cbid,ngaygiokh,tongbanve,tongphihoan,tongdoanhthu});
							 table.setModel(tableModel);
									 
							 bt_xuatfile.setVisible(true);
								scrollPane.setVisible(true);
								table.setVisible(true);
								scrollPane_1.setVisible(true);
								table_1.setVisible(true);
								
								dem++;

							
							
						}
						if(dem==0) {
							JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin");
						}
						btnNewButton.setVisible(true);
						table_1.setVisible(true);
						scrollPane_1.setViewportView(table_1);
						final DefaultTableModel model = new DefaultTableModel();

						model.addColumn("Tổng chuyến bay");
						model.addColumn("Tổng tiền bán vé");
						model.addColumn("Tổng tiền hoàn vé");
						model.addColumn(" Tổng doanh thu");

						
						JTableHeader Theader1 = table_1.getTableHeader();
						 Theader1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
						Theader1.setBackground(new Color(255, 255, 255));
						table_1.setModel(model);
						Theader1.setBackground(new Color(255, 255, 224));

						
						while(model.getRowCount() > 0) 
						{									
							model.removeRow(0);
						}
									
						String search=" SELECT DISTINCT count(DISTINCT CB.ID), SUM(TONGTIENBANVE),SUM(TONGPHIHOANVE), SUM(TONGDOANHTHU)\r\n"
								+ "FROM  CHUYENBAY CB, DOANHTHUCHUYENBAY DT\r\n"
								+ "WHERE CB.ID= DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>= "+thoigian11+" AND CB.NGAY_GIO_KH<="+thoigian22+"\r\n";
						ResultSet rs= st.executeQuery(search);
						while(rs.next()) {
							String tid_chuyenbay =rs.getString(1);
							String ttienbanve =rs.getString(2);
							String tphihoan =rs.getString(3);							 
							String tdoanhthu =rs.getString(4);
							

						model.addRow(new Object[] {tid_chuyenbay,ttienbanve,tphihoan,tdoanhthu});

						table_1.setModel(model);
						}
						
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}					
				}

				
				
			}
		});
		bt_thongke.setBackground(new Color(255, 255, 224));
		bt_thongke.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thongke.setBounds(583, 157, 235, 23);
		contentPane.add(bt_thongke);
		
		bt_xuatfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kt==1) {
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					
			
					FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\Blank_A4.jrxml"));
					
					JasperDesign jd=JRXmlLoader.load(in);
					String sqlString="SELECT DISTINCT DT.ID, DT.CHUYENBAY_ID, CB.NGAY_GIO_KH, TONGTIENBANVE, TONGPHIHOANVE, TONGDOANHTHU\r\n"
							+ "from CHUYENBAY CB, DOANHTHUCHUYENBAY DT\r\n"
							+ "WHERE CB.ID=DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>="+thoigian+" and  CB.NGAY_GIO_KH<="+thoigian1+"";				

					JRDesignQuery newQuery=new JRDesignQuery();
					newQuery.setText(sqlString);
					jd.setQuery(newQuery);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					HashMap para=new HashMap();
					JasperPrint j=JasperFillManager.fillReport(jr, para,con);
					JasperViewer.viewReport(j,false);
					java.io.OutputStream os=new FileOutputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\Report"));
					JasperExportManager.exportReportToPdfStream(j, os);
					
					
		
					
					
					in.close();
					con.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
				if(kt==2) {
					try {

						Class.forName("oracle.jdbc.OracleDriver");
						 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						
				
						FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\Blank_A4.jrxml"));

						JasperDesign jd1=JRXmlLoader.load(in);
						String sql="SELECT DISTINCT DT.ID, DT.CHUYENBAY_ID, CB.NGAY_GIO_KH, TONGTIENBANVE, TONGPHIHOANVE, TONGDOANHTHU\r\n"
								+ "from CHUYENBAY CB, DOANHTHUCHUYENBAY DT\r\n"
								+ "WHERE CB.ID=DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>="+thoigian11+" and  CB.NGAY_GIO_KH<="+thoigian22+"";	
						JRDesignQuery newQuery1=new JRDesignQuery();
						newQuery1.setText(sql);
						jd1.setQuery(newQuery1);
						JasperReport jr1=JasperCompileManager.compileReport(jd1);
						HashMap para1=new HashMap();
						JasperPrint j1=JasperFillManager.fillReport(jr1, para1,con);
						JasperViewer.viewReport(j1,false);
						java.io.OutputStream os1=new FileOutputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\Report"));
						JasperExportManager.exportReportToPdfStream(j1, os1);						

				
						in.close();
						con.close();

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kt==1)
				{
				try {
				Class.forName("oracle.jdbc.OracleDriver");
				 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				
				FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\Bang.jrxml"));
				//JasperDesign jd=JRXmlLoader.load(in);

				JasperDesign jd1=JRXmlLoader.load(in);
				String sql="SELECT COUNT(CHUYENBAY_ID),SUM(TONGTIENBANVE),SUM(TONGPHIHOANVE),SUM(TONGDOANHTHU)\r\n"
						+ "FROM DOANHTHUCHUYENBAY DT, CHUYENBAY CB \r\n"
						+ "WHERE CB.ID=DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>="+thoigian+" and  CB.NGAY_GIO_KH<="+thoigian1+"";				
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
					e2.printStackTrace();
				}
				}
				if(kt==2) {

					try {
					Class.forName("oracle.jdbc.OracleDriver");
					 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					

						FileInputStream in=new FileInputStream(new File("C:\\Users\\nguyen thi nhan\\Documents\\SKY_Airline\\src\\PLANE\\Bang.jrxml"));
						//JasperDesign jd=JRXmlLoader.load(in);

						JasperDesign jd1=JRXmlLoader.load(in);
						String sql="SELECT COUNT(CHUYENBAY_ID),SUM(TONGTIENBANVE),SUM(TONGPHIHOANVE),SUM(TONGDOANHTHU)\r\n"
								+ "FROM DOANHTHUCHUYENBAY DT, CHUYENBAY CB \r\n"
								+ "WHERE CB.ID=DT.CHUYENBAY_ID AND CB.NGAY_GIO_KH>="+thoigian11+" and  CB.NGAY_GIO_KH<="+thoigian22+"";				
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
						e2.printStackTrace();
					}
				}
			}
		});
		
		bt_xuatfile.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_xuatfile.setBounds(478, 452, 235, 23);
		contentPane.add(bt_xuatfile);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("anh.jpg"));
		lblNewLabel.setBounds(-20, 11, 850, 511);
		contentPane.add(lblNewLabel);
	}
}
