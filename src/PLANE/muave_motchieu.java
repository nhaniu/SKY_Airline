package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class muave_motchieu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String idhv;
	public static String idcb;

	Connection con=null;
	private JComboBox comboBox_noidi;
	private JComboBox comboBox_noiden;


	public muave_motchieu() {
		initComponent();
		loadCombobox();
		loadCombobox1();

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muave_motchieu frame = new muave_motchieu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
	public void initComponent() {
		setTitle("SKY Airline");
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(new Color(240, 255, 255));
		setBounds(100, 170, 659, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_noi_di = new JLabel("Nơi đi: ");
		lb_noi_di.setBounds(10, 25, 49, 33);
		contentPane.add(lb_noi_di);
		
		JLabel lb_noi_den = new JLabel("Nơi đến:");
		lb_noi_den.setBounds(323, 34, 66, 14);
		contentPane.add(lb_noi_den);
		
		JLabel lb_ngay_di = new JLabel("Ngày đi:");
		lb_ngay_di.setBounds(10, 69, 49, 14);
		contentPane.add(lb_ngay_di);
		
		comboBox_noiden = new JComboBox();
		comboBox_noiden.setBounds(388, 30, 216, 22);
		contentPane.add(comboBox_noiden);
		
		comboBox_noidi = new JComboBox();
		comboBox_noidi.setBounds(69, 30, 216, 22);
		contentPane.add(comboBox_noidi);
		
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(69, 69, 162, 20);
		contentPane.add(dateChooser);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 214, 557, 103);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setVisible(false);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Giờ khởi hành ", "Giờ hạ cánh", "Hạng vé ", "Giá vé"
			}
			
		));
		scrollPane.setViewportView(table);
		
		
		final JButton button_chonmua = new JButton("Chọn mua ");
		button_chonmua.setForeground(new Color(0, 0, 0));
		button_chonmua.setBackground(new Color(124, 252, 0));
		button_chonmua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_chonmua.setVisible(false);
		
		JButton bt_tim_chuyen_bay = new JButton("Tìm chuyến bay");
		bt_tim_chuyen_bay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bt_tim_chuyen_bay.setBackground(new Color(0, 191, 255));
		bt_tim_chuyen_bay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DB_AIRLINE", "123");
					java.sql.Statement st = conn.createStatement();
					
					String day = new String();
					String month = new String();
					String year = new String();
					String date = new String();
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String tgString=formatter.format(dateChooser.getDate());
					day = tgString.substring(8,10);
					month = tgString.substring(5,7);
					year = tgString.substring(0,4);
					date = tgString.substring(0,10);
					
					//String texString="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";
					String sql = "select distinct c.ID, c.NGAY_GIO_KH, c.NGAY_GIO_HC, h.TENHV, h.GIA, h.ID"
							+ " from CHUYENBAY c JOIN VEMAYBAY v ON c.ID = v.CHUYENBAY_ID JOIN HANGVE h ON h.ID = v.HANGVE_ID "
							+ "where c.SANBAYDI = " + "'"+comboBox_noidi.getSelectedItem()+"'"+" and c.SANBAYDEN = "+"'"+comboBox_noiden.getSelectedItem()+"'"
							+ " and EXTRACT( DAY FROM c.NGAY_GIO_KH)= "+"'"+day+"'"+" and EXTRACT( MONTH FROM c.NGAY_GIO_KH)= "+"'"+month+"'"+" and EXTRACT(YEAR FROM c.NGAY_GIO_KH)= "+"'"+year+"'";
				
					
					System.out.println(day);
					System.out.println(month);
					System.out.println(year);
					System.out.println(date);
					System.out.println(sql);
					
			
					ResultSet rs =  ((java.sql.Statement) st).executeQuery(sql);
					while(rs.next()) 
					{
						 idcb = rs.getString(1);
						String giokh = rs.getString(2);
						String giohc = rs.getString(3);
						String hv = rs.getString(4);
						String gv = rs.getString(5);
						idhv = rs.getString(6);

						
						

						String tbData[] = {giokh, giohc, hv, gv};
							DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
							System.out.print(giokh+giohc+hv+gv);

							tblModel.addRow(tbData);
							scrollPane.setVisible(true);
							table.setVisible(true);
							button_chonmua.setVisible(true);
							
					}
					
	
						
					conn.close();
				}
				
				catch(Exception e1 )
				{
					System.out.println("Không tìm thấy chuyến bay!");
					JOptionPane.showMessageDialog(null, "Không tìm thấy chuyến bay!");
				}
				

			}
		});
		
		bt_tim_chuyen_bay.setBounds(252, 122, 137, 24);
		contentPane.add(bt_tim_chuyen_bay);
		
		

		button_chonmua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = table.getSelectedRow();
				System.out.println(i);
				 String gio_kh_di = new String();
				 String gio_hc_di = new String();
				 String h_ve_di = new String();
				 String gia_ve_di = new String();
				 String noi_di = new String();
				 String noi_den = new String();
				 String gio_kh_ve= new String();
				 String gio_hc_ve = new String();
				 String h_ve_ve = new String();
				 String gia_ve_ve = new String();
					
				TableModel model = table.getModel();
				
				noi_di = comboBox_noidi.getSelectedItem().toString();
				noi_den = comboBox_noiden.getSelectedItem().toString();
				gio_kh_di = model.getValueAt(i, 0).toString();
				gio_hc_di= model.getValueAt(i, 1).toString();
				h_ve_di = model.getValueAt(i, 2).toString();
				gia_ve_di = model.getValueAt(i, 3).toString();
				
				nhapthongtin_mv1chieu obj = new nhapthongtin_mv1chieu(gio_kh_di, gio_hc_di, h_ve_di, gia_ve_di, noi_di, noi_den, gio_kh_ve, gio_hc_ve, h_ve_ve, gia_ve_ve);
				obj.setVisible(true);
				dispose();
				
				
			}
		});
		JTableHeader theJTableHeader = table.getTableHeader();
		theJTableHeader.setBackground(new Color(135, 206, 250));
		
		button_chonmua.setBounds(266, 380, 122, 22);
		contentPane.add(button_chonmua);
		
	}
}
