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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class QuanLy_DatVe extends JFrame {

	private JPanel contentPane;
	private JTextField textField_maCB;
	private JTable table;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public QuanLy_DatVe() {
		setBackground(new Color(240, 255, 255));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 170, 928, 501);
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
		
		textField_maCB = new JTextField();
		textField_maCB.setBounds(214, 127, 111, 19);
		contentPane.add(textField_maCB);
		textField_maCB.setColumns(10);
		
	
		
		JButton bt_sua = new JButton("Cập nhật");
		bt_sua.setVisible(false);
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int SelectedRows=table.getSelectedRow();
				System.out.println(SelectedRows);
				
				String id= model.getValueAt(SelectedRows, 0).toString();
				String vemaybayid =model.getValueAt(SelectedRows, 1).toString();
				String hanhkhachid= model.getValueAt(SelectedRows, 2).toString();
				String khuyenmaiid =model.getValueAt(SelectedRows, 3).toString();
				String dvbtid =model.getValueAt(SelectedRows, 4).toString();
				String ngaydat =model.getValueAt(SelectedRows, 5).toString();
				String tg1 = ngaydat.substring(0, 10);

				String tongtien =model.getValueAt(SelectedRows, 6).toString();
				String tinhtrang =model.getValueAt(SelectedRows, 7).toString();
				String taikhoanid =model.getValueAt(SelectedRows, 8).toString();


				update_datve update= new update_datve(id,vemaybayid,hanhkhachid,khuyenmaiid,dvbtid,tg1,tongtien,tinhtrang,taikhoanid);
				update.setVisible(true);
			}
		});
		bt_sua.setBackground(new Color(135, 206, 250));
		bt_sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_sua.setBounds(660, 408, 111, 23);
		contentPane.add(bt_sua);
		
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.setVisible(false);
		bt_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new timkiem_datve();
			}
		});
		bt_timkiem.setBackground(new Color(135, 206, 250));
		bt_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timkiem.setBounds(151, 408, 117, 23);
		contentPane.add(bt_timkiem);
		
		JLabel lblNewLabel = new JLabel("(Ví dụ: 601)");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel.setBounds(362, 127, 86, 19);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 208, 821, 166);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(255, 255, 255));
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
		table.setVisible(false);

		
		scrollPane.setViewportView(table);
		
		JButton bt_timcb = new JButton("Tìm kiếm");
		bt_timcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (textField_maCB.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "vui lòng nhập mã chuyến bay");
						 textField_maCB.requestFocus();
						 return; 
						}
					
						
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");
					Statement st=con.createStatement(); 
					
					String search="select dv.ID,dv.VEMAYBAY_ID, dv.HANHKHACH_ID, dv.KHUYENMAI_ID, dv.DICHVUBOTRO_ID, dv.NGAYDAT, dv.TONGTIEN, dv.TINHTRANG, dv.TAIKHOAN_ID\r\n"
							+ "from DATVEBAY dv, CHUYENBAY cb, VEMAYBAY ve\r\n"
							+ "where dv.VEMAYBAY_ID=ve.ID and ve.CHUYENBAY_ID=cb.ID and ve.CHUYENBAY_ID="+textField_maCB.getText()+" ";					
										
					while(model.getRowCount() > 0) 
					{									
						model.removeRow(0);
					}
					
					ResultSet rs= st.executeQuery(search);
					while(rs.next()) {
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
						bt_timkiem.setVisible(true);
						bt_sua.setVisible(true);
						table.setVisible(true);

					}
					
					con.close();

					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

			
			}
				
			
		});
		bt_timcb.setBackground(new Color(135, 206, 250));
		bt_timcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_timcb.setBounds(701, 125, 127, 23);
		contentPane.add(bt_timcb);
		
	}
}
