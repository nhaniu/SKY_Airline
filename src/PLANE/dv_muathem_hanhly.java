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
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class dv_muathem_hanhly extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaDC;
	private JTable table;
	private JTextField textField_sdt;
	public dv_muathem_hanhly() {
		initcomponents();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dv_muathem_hanhly frame = new dv_muathem_hanhly();
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
	public void initcomponents() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 833, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_MaDC = new JLabel("M?? ?????t v??:");
		lb_MaDC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_MaDC.setBounds(43, 273, 99, 22);
		contentPane.add(lb_MaDC);
		
		JLabel lb_title = new JLabel("????ng k?? d???ch v??? b??? tr???");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(240, 9, 321, 36);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 785, 10);
		contentPane.add(separator);
		
		textField_MaDC = new JTextField();
		textField_MaDC.setBounds(146, 275, 143, 20);
		contentPane.add(textField_MaDC);
		textField_MaDC.setColumns(10);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(468, 66, 327, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		
		JLabel lb_tien = new JLabel("New label");
		lb_tien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tien.setBounds(125, 291, 94, 24);
		panel_1.add(lb_tien);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(43, 68, 397, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_banggia = new JLabel("B???ng gi?? ");
		lb_banggia.setBounds(173, 11, 79, 24);
		lb_banggia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lb_banggia);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 35, 377, 9);
		panel.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("ID d???ch v???:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 214, 94, 21);
		panel_1.add(lblNewLabel_5);
		
		JLabel lb_id = new JLabel("New label");
		lb_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_id.setBounds(125, 215, 133, 21);
		panel_1.add(lb_id);
		
		JLabel lblNewLabel_6 = new JLabel("D???ch v???:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 246, 110, 24);
		panel_1.add(lblNewLabel_6);
		
		JLabel lb_dv = new JLabel("New label");
		lb_dv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_dv.setBounds(125, 247, 154, 24);
		panel_1.add(lb_dv);
		
		JLabel lb_madv = new JLabel("New label");
		lb_madv.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_madv.setBounds(146, 25, 133, 24);
		panel_1.add(lb_madv);
		
		JLabel lb_tenhk = new JLabel("New label");
		lb_tenhk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_tenhk.setBounds(146, 70, 133, 21);
		panel_1.add(lb_tenhk);
		
		JLabel lb_noidi = new JLabel("New label");
		lb_noidi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_noidi.setBounds(95, 113, 222, 24);
		panel_1.add(lb_noidi);
		
		JLabel lb_noiden = new JLabel("New label");
		lb_noiden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lb_noiden.setBounds(95, 160, 222, 21);
		panel_1.add(lb_noiden);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 55, 356, 100);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int i=table.getSelectedRow();
				
				lb_id.setText(model.getValueAt(i, 0).toString());
				lb_tien.setText(model.getValueAt(i, 2).toString());
				lb_dv.setText(model.getValueAt(i, 1).toString());
				
			}
		});

		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		
		tableModel.addColumn("ID");
		tableModel.addColumn("N???i dung d???ch v???");
		tableModel.addColumn("Gi?? ti???n");
		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
			Statement st=con.createStatement(); 
			
		


			String search="select * from DICHVUBOTRO";				
			while(tableModel.getRowCount() > 0) 
			{									
				tableModel.removeRow(0);
			}
			
			ResultSet rs= st.executeQuery(search);
			while(rs.next()) {
				String id =rs.getString(1);
				String nd =rs.getString(2);
				String gia =rs.getString(3);

				
				//System.out.print(ID_NQL+sovetrong+sovedat+sovedat+tongsove+sanbayden+ngaygiohc+ngaygiokh+sanbaydi+ttmaybayid+ID+"\n");
				
				tableModel.addRow(new Object[] {id, nd,gia});

				table.setModel(tableModel);
				
			}
			
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}								

		
		JButton bt_thanhtoan = new JButton("X??c nh???n th??ng tin");
		bt_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int i=table.getSelectedRow();
				
				
				if(i==-1) {
					JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ?????y ????? th??ng tin");
				}
				else {
			
				if (textField_MaDC.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui l??ng nh???p ?????y ????? th??ng tin");
					 textField_MaDC.requestFocus();
					 return; 
					}
			
				else {
					
					
		
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						Statement st=con.createStatement(); 
						
						dangnhap_nhanvien dn=null;
						System.out.println("ten dang nhap: "+dn.tendn);
						
						String nv="SELECT ID FROM NHANVIEN WHERE NHIEMVU='D???ch v??? b??? tr???' and TENDANGNHAP='"+dn.tendn+"'";
						ResultSet rsn= st.executeQuery(nv);
						if(rsn.next()) {
							String idnv1 =rsn.getString(1);	
							System.out.println("idnv: "+idnv1);
	
						String search="select DV.ID, HK.SDT from DATVEBAY DV, HANHKHACH HK where HK.ID=DV.HANHKHACH_ID AND DV.TINHTRANG='???? thanh to??n' and DV.ID="+textField_MaDC.getText()+" AND HK.SDT="+textField_sdt.getText();				
					
						ResultSet rs= st.executeQuery(search);
						if(rs.next()) {
							 final String id =rs.getString(1);
							
							String timkiem="SELECT  HK.HOTEN, CB.SANBAYDI, CB.SANBAYDEN\r\n"
									+ "FROM DATVEBAY DV, HANHKHACH HK, VEMAYBAY VE, CHUYENBAY CB\r\n"
									+ "WHERE DV.HANHKHACH_ID=HK.ID AND DV.VEMAYBAY_ID=VE.ID AND VE.CHUYENBAY_ID=CB.ID and DV.ID="+textField_MaDC.getText()+"";
							ResultSet rs1= st.executeQuery(timkiem);
							rs1.next();
							String hoten =rs1.getString(1);
							String noidi =rs1.getString(2);
							String noiden =rs1.getString(3);
							
							lb_madv.setText(id);
							lb_tenhk.setText(hoten);
							lb_noidi.setText(noidi);
							lb_noiden.setText(noiden);

							panel_1.setVisible(true);
							rs1.close();
	
						}
						else
							JOptionPane.showMessageDialog(null, " Th??ng tin nh???p kh??ng ch??nh x??c");
	
						rs.close();

						con.close();
						}
						else {
							JOptionPane.showMessageDialog(null, "B???n kh??ng thu???c nhi???m v??? n??y");
						}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}				
				}}
			}
		});
		bt_thanhtoan.setBackground(new Color(135, 206, 250));
		bt_thanhtoan.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_thanhtoan.setBounds(57, 389, 165, 22);
		contentPane.add(bt_thanhtoan);
		
		
		JLabel lblNewLabel = new JLabel("M?? ?????t v??:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 25, 94, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T??n h??nh kh??ch:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 68, 133, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N??i ??i:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 113, 104, 24);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N??i ?????n:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 163, 118, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ti???n d???ch v???:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 290, 104, 24);
		panel_1.add(lblNewLabel_4);
		
		
		
		JButton btnNewButton = new JButton("X??c nh???n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int confirm =JOptionPane.showConfirmDialog(null, "X??c nh???n mua d???ch v??? b??? tr???","X??c nh???n",JOptionPane.YES_NO_OPTION);
				if(confirm==JOptionPane.YES_OPTION) {
					try {
						
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
						Statement st=con.createStatement(); 
						
					
						String search="select TONGTIEN, TAIKHOAN_ID from DATVEBAY where ID="+textField_MaDC.getText();					
											
						ResultSet rs= st.executeQuery(search);
						rs.next() ;
							String tongtienve =rs.getString(1);
							int tongtien=Integer.parseInt(tongtienve);
							
							String tiendv=lb_tien.getText();
							int tiendvbt=Integer.parseInt(tiendv);

							int tongtiendatve=tongtien+tiendvbt;
							System.out.println("?????t v?? "+tongtien+" "+tiendvbt+" "+tongtiendatve);
							
							String id_taikhoan=rs.getString(2);
							int id_tk=0;
							if(id_taikhoan!=null) {
								if(!id_taikhoan.equals("null")) {
									 id_tk=Integer.parseInt(id_taikhoan);
									System.out.println(id_tk);
								}
								
							}
							

							String update ="update DATVEBAY set DICHVUBOTRO_ID="+lb_id.getText()+",TONGTIEN="+tongtiendatve+" where ID="+textField_MaDC.getText()+"";
							PreparedStatement pst = con.prepareStatement(update);
							pst= con.prepareStatement(update);
							pst.execute();
							
							
							String C= "select DT.ID, DT.TONGTIENBANVE,DT.TONGDOANHTHU \r\n"
									+ "from DOANHTHUCHUYENBAY DT, VEMAYBAY VE, DATVEBAY DV \r\n"
									+ "WHERE   DT.CHUYENBAY_ID=VE.CHUYENBAY_ID AND VE.ID=DV.VEMAYBAY_ID AND DV.ID="+textField_MaDC.getText();
							ResultSet rs2= st.executeQuery(C);

							rs2.next();
												
							String id_dt =rs2.getString(1);
							String tongtienbv=rs2.getString(2);
							float ttbv=Float.parseFloat(tongtienbv);
							float tongtbv=ttbv+tiendvbt;
							
							String tongdt =rs2.getString(3);	
							float tdt=Float.parseFloat(tongdt);
							float tongdoanhthu=tdt+tiendvbt;

							PreparedStatement pst1= con.prepareStatement("update DOANHTHUCHUYENBAY set TONGTIENBANVE="+tongtbv+", TONGDOANHTHU="+tongdoanhthu+" where ID= "+id_dt+"");		
							pst1.execute();
							System.out.println("update doanh thu ok");
							
							System.out.println("ok");
							
							DangNhap dNhap=null;
							String a=dNhap.tendn;
							String b=dNhap.mk;
							
							System.out.println(a+" "+b);
							if(id_taikhoan!=null) {
								
								String searchtk="select TONGTIENMUAVE from TAIKHOAN where ID="+id_tk;					
								ResultSet rs1= st.executeQuery(search);
								rs1.next();
									String tongtientk =rs1.getString(1);	
									
									int tttk=Integer.parseInt(tongtientk);
									int tongtienupdate=tttk+tiendvbt;
									
									int diem=tongtienupdate/500000;
									String hang = null;
									if(diem>=30 &&diem<40) {
										hang="H???ng b???c";
									}
									else if (diem>=40&&diem<50) {
										hang="H???ng v??ng";
										
									}
									else if (diem>=50) {
										hang="H???ng kim c????ng";
									}
									else if (diem<30) {
										hang="H???ng th?????ng";
									}
									
									System.out.println("h???ng: "+" "+"Diem: "+diem);
									PreparedStatement pst2= con.prepareStatement("update TAIKHOAN set TONGTIENMUAVE="+tongtienupdate+", DIEM="+diem+",HANG='"+hang+"' where TENDANGNHAP= '"+a+"' AND MATKHAU='"+b+"'");		
									pst2.execute();
									pst2.close();
							}
							
							JOptionPane.showMessageDialog(null, "Mua th??nh c??ng");
							
							pst1.close();
							rs2.close();
							rs.close();
							pst.close();

						con.close();
						
						
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "th???t b???i");

						e1.printStackTrace();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				else if(confirm==JOptionPane.NO_OPTION) {
					dispose();
				}
				
			
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(161, 342, 118, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("VND");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(196, 295, 59, 17);
		panel_1.add(lblNewLabel_8);
		
	
	
		
		
		JLabel lblNewLabel_9 = new JLabel("S??T: ");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(43, 319, 99, 20);
		contentPane.add(lblNewLabel_9);
		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(146, 320, 143, 19);
		contentPane.add(textField_sdt);
		textField_sdt.setColumns(10);
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBorder(new LineBorder(new Color(255, 192, 203), 3, true));
		lblNewLabel_7.setBounds(0, 0, 819, 457);
		contentPane.add(lblNewLabel_7);
		

		ImageIcon icon=new ImageIcon("anh1.jpg");
		Image imgIcon =icon.getImage();
		Image imgScale =imgIcon.getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(imgScale);
		lblNewLabel_7.setIcon(scaleIcon);
		

	}
}
