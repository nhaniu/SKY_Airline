package PLANE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class quanly_changdung extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quanly_changdung frame = new quanly_changdung();
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
	public quanly_changdung() {
		setVisible(true);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 653, 272);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_title = new JLabel("Quản lý chặng dừng");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setBounds(97, 11, 451, 43);
		contentPane.add(lb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 629, 15);
		contentPane.add(separator);
		
		JButton bt_them = new JButton("Thêm chặng dừng");
		bt_them.setBackground(new Color(135, 206, 250));
		bt_them.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_them.setBounds(29, 100, 163, 29);
		contentPane.add(bt_them);
		
		JButton bt_sua = new JButton("Sửa chặng dừng");
		bt_sua.setBackground(new Color(135, 206, 250));
		bt_sua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_sua.setBounds(230, 104, 173, 25);
		contentPane.add(bt_sua);
		
		JButton bt_xoa = new JButton("Xóa chặng dừng");
		bt_xoa.setBackground(new Color(135, 206, 250));
		bt_xoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bt_xoa.setBounds(445, 104, 146, 25);
		contentPane.add(bt_xoa);
	}

}
