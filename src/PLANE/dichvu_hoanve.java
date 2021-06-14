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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class dichvu_hoanve extends JFrame {

	private JPanel contentPane;
	private JTextField textField_madatcho;
	private JTextField textField_lido;
	private JTable table;
	private JLabel lb_id;

	public dichvu_hoanve() {
		initcomponents();
		autoID();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dichvu_hoanve frame = new dichvu_hoanve();
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
		setTitle("SKY Airline");
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 644, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_ma_dat_cho = new JLabel("Mã đặt chỗ:");
		lb_ma_dat_cho.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_ma_dat_cho.setBounds(23, 136, 90, 34);
		contentPane.add(lb_ma_dat_cho);
		
		textField_madatcho = new JTextField();
		textField_madatcho.setBounds(123, 141, 103, 22);
		contentPane.add(textField_madatcho);
		textField_madatcho.setColumns(10);
		
		JLabel lb_lido = new JLabel("Lí do:");
		lb_lido.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb_lido.setBounds(23, 181, 49, 16);
		contentPane.add(lb_lido);
		
		textField_lido = new JTextField();
		textField_lido.setBounds(123, 179, 189, 22);
		contentPane.add(textField_lido);
		textField_lido.setColumns(10);
		
		
		
		JLabel bt_exit = new JLabel("HOÀN VÉ");
		bt_exit.setForeground(Color.BLACK);
		bt_exit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		bt_exit.setHorizontalAlignment(SwingConstants.CENTER);
		bt_exit.setBounds(227, 14, 189, 39);
		contentPane.add(bt_exit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 610, 14);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 109, 49, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phí hoàn:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 219, 90, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("20 % tiền vé");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(123, 219, 103, 22);
		contentPane.add(lblNewLabel_2);
		
		 lb_id = new JLabel("New label");
		lb_id.setBounds(123, 109, 103, 22);
		contentPane.add(lb_id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 271, 588, 39);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		final DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("ID đặt vé");
		tableModel.addColumn("Lí do");
		tableModel.addColumn("Ngày hoàn");
		tableModel.addColumn("Phí hoàn");
		tableModel.addColumn("Tiền hoàn");
		table.setVisible(false);

		
		JTableHeader Theader = table.getTableHeader();
		 Theader.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Theader.setBackground(new Color(255, 255, 255));
		table.setModel(tableModel);
		
		
		JButton bt_gui = new JButton("Gửi");
		bt_gui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField_lido.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_lido.requestFocus();
					 return; 
					}
				
				if (textField_madatcho.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "vui lòng nhập đầy đủ thông tin");
					 textField_madatcho.requestFocus();
					 return; 
					}
			
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
					Date date=new Date();					
					String tgString=formatter.format(date);
					String ngayhoan="TO_DATE('"+tgString+"','DD-MM-RR HH24:MI:SS')";

				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
				Statement st=con.createStatement(); 
	
				String b= "select TONGTIEN from DATVEBAY   WHERE  DATVEBAY.ID="+textField_madatcho.getText();
				ResultSet rs= st.executeQuery(b);
				
				rs.next();
				String tien =rs.getString(1);				
				System.out.println("tong tien: "+tien);				
				float tongtien=Integer.parseInt(tien);
				float phihv=(float)(0.2*tongtien);
				float tienhoan=tongtien-phihv;
				

				PreparedStatement pst= con.prepareStatement("insert into \"DB_AIRLINE\".\"HOANVEBAY\"  (\"ID\", \"DATVEBAY_ID\", \"LIDO\",\"NGAYHOAN\",  \"PHIHV\", \"TIENHV\", \"NHANVIEN_ID\") values("+lb_id.getText()+","+textField_madatcho.getText()+",'"+textField_lido.getText()+"',"+ngayhoan+","+phihv+","+tienhoan+","+0+")");		
				pst.execute();
				
				
				String C= "select DT.ID, DT.TONGPHIHOANVE,DT.TONGDOANHTHU \r\n"
						+ "from DOANHTHUCHUYENBAY DT, VEMAYBAY VE, DATVEBAY DV \r\n"
						+ "WHERE   DT.CHUYENBAY_ID=VE.CHUYENBAY_ID AND VE.ID=DV.VEMAYBAY_ID AND DV.ID="+textField_madatcho.getText();
				ResultSet rs2= st.executeQuery(C);

				rs2.next();
				String tonghoanve =rs2.getString(2);				
				System.out.println("tong tien hoàn vé trong db"+tonghoanve);				
				float tongtienhoan=Float.parseFloat(tonghoanve);
				float updatetth=tongtienhoan+tienhoan;
				System.out.println("update "+updatetth );
				String id_dt =rs2.getString(1);	
				String tongdt =rs2.getString(3);	
				float tdt=Float.parseFloat(tongdt);
				float tongdoanhthu=tdt-tienhoan;

				PreparedStatement pst1= con.prepareStatement("update DOANHTHUCHUYENBAY set TONGPHIHOANVE="+updatetth+", TONGDOANHTHU="+tongdoanhthu+" where ID= "+id_dt+"");		
				pst1.execute();
				
				
				Component a=null;
				JOptionPane.showMessageDialog(a, "Thêm thành công");
				
				rs2.close();
				rs.close();
				pst.close();
				
				String search="select ID, DATVEBAY_ID,LIDO, NGAYHOAN, PHIHV, TIENHV from HOANVEBAY where ID="+lb_id.getText();					
				
				while(tableModel.getRowCount() > 0) 
				{									
					tableModel.removeRow(0);
				}
				
				ResultSet rs1= st.executeQuery(search);
				while(rs1.next()) {
					String id =rs1.getString(1);
					String id_datve =rs1.getString(2);
					String lido =rs1.getString(3);
					String ngayhoanve =rs1.getString(4);
					String phihoan =rs1.getString(5);
					String tienhoanve =rs1.getString(6);
					
					System.out.println(id+" "+id_datve+" "+lido+" "+ ngayhoanve+" "+phihoan+" "+tienhoanve);									
					tableModel.addRow(new Object[] {id, id_datve, lido, ngayhoanve,phihoan,tienhoanve});

					table.setModel(tableModel);
					table.setVisible(true);
					scrollPane.setVisible(true);

				}
				rs1.close();				
				con.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
				
			}
		});
		bt_gui.setBackground(new Color(0, 191, 255));
		bt_gui.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_gui.setBounds(434, 159, 81, 22);
		contentPane.add(bt_gui);
		
		
		
	}
public void autoID() {
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
			
			Statement stmt=(Statement) ((java.sql.Connection) DB_AIRLINE).createStatement();  	
			ResultSet rs=((java.sql.Statement) stmt).executeQuery("select MAX(ID) from HOANVEBAY");  
			
			rs.next();
			System.out.println(rs.getString("MAX(ID)"));
			
			if(rs.getString("MAX(ID)")==null) {
				lb_id.setText("301");
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
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(them_hanhkhach.class.getName()).log(Level.SEVERE,null,e);

		}  
	}
}
