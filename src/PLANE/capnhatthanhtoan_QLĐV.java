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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class capnhatthanhtoan_QLĐV extends JFrame {

	private JPanel contentPane;
	private JTextField textField_madatve;
	private JTextField textField_SDT;
	private JTable table;
	
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					capnhatthanhtoan_QLĐV frame = new capnhatthanhtoan_QLĐV();
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
	public capnhatthanhtoan_QLĐV() {
		//setVisible(rootPaneCheckingEnabled);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 689, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb_cntt = new JLabel("CẬP NHẬT THANH TOÁN");
		lb_cntt.setBounds(184, 21, 350, 30);
		lb_cntt.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cntt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lb_madv = new JLabel("Mã đặt vé :");
		lb_madv.setBounds(10, 89, 96, 24);
		lb_madv.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField_madatve = new JTextField();
		textField_madatve.setBounds(171, 91, 146, 24);
		textField_madatve.setColumns(10);
		
		JLabel lb_SDT = new JLabel("Số điện thoại :");
		lb_SDT.setBounds(10, 140, 156, 24);
		lb_SDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(171, 142, 146, 24);
		textField_SDT.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 655, 131);

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
		
		JButton btn_timkiem = new JButton("Tìm kiếm");
		btn_timkiem.setBounds(10, 183, 115, 33);
		btn_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
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
				
				String timkiem = "select d.ID, d.VEMAYBAY_ID, d.HANHKHACH_ID, d.KHUYENMAI_ID, d.DVBT_ID, d.NGAYDAT, d.TONGTIEN, d.TINHTRANG, d.TAIKHOAN_ID from HANHKHACH h, DATVEBAY d "
						+ " where h.ID=d.HANHKHACH_ID AND h.SDT='"+textField_SDT.getText()+"'AND d.ID ='"+textField_madatve.getText()+"'";
				
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
					table.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
				}
				con.close();
				
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
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
		
		
		JButton btnNewButton = new JButton("Xác nhận thanh toán");
		btnNewButton.setBounds(10, 379, 209, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String update ="update DATVEBAY set TINHTRANG = 'Đã thanh toán' where ID ='"+textField_madatve.getText()+"'";
					
					Class.forName("oracle.jdbc.OracleDriver");
					java.sql.Connection DB_AIRLINE= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DB_AIRLINE","123");  		
					PreparedStatement pst = DB_AIRLINE.prepareStatement(update);
					pst= DB_AIRLINE.prepareStatement(update);
					pst.execute();
				
	
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					pst.close();
					DB_AIRLINE.close();
				}  catch (ClassNotFoundException a) {
					a.printStackTrace();
				} catch (SQLException b) {
					b.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
	}
}
