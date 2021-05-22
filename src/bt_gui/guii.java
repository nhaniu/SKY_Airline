package bt_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class guii extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_kq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guii frame = new guii();
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
	public guii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số hạng 1:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(31, 54, 82, 18);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(109, 54, 128, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Số hạng 2: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 102, 70, 21);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(109, 103, 128, 18);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phép tính: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(288, 24, 91, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kết quả: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(31, 188, 70, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_kq = new JTextField();
		textField_kq.setHorizontalAlignment(SwingConstants.CENTER);
		textField_kq.setBounds(109, 188, 128, 18);
		contentPane.add(textField_kq);
		textField_kq.setColumns(10);
		
		final JRadioButton rdbt1 = new JRadioButton("+");
		rdbt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbt1.setBounds(298, 53, 111, 23);
		contentPane.add(rdbt1);
		
		final JRadioButton rdbt2 = new JRadioButton("-");
		rdbt2.setBounds(298, 86, 111, 23);
		contentPane.add(rdbt2);
		
		final JRadioButton rdbt3 = new JRadioButton("*");
		rdbt3.setBounds(298, 123, 111, 23);
		contentPane.add(rdbt3);
		
		final JRadioButton rdbt4 = new JRadioButton("/");
		rdbt4.setBounds(298, 164, 111, 23);
		contentPane.add(rdbt4);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbt1);
		G.add(rdbt2);
		G.add(rdbt3);
		G.add(rdbt4);
		
		
		
		JButton btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try 
            	{
	            	int i1 = Integer.parseInt(textField_1.getText());
	                int i2 = Integer.parseInt(textField_2.getText());
	                if(rdbt1.isSelected())
	                {
	                    int kq=i1+i2;
	                    textField_kq.setText(String.valueOf(kq)); 
	                }
					else if(rdbt2.isSelected()) {
						int kq=i1-i2;
						textField_kq.setText(String.valueOf(kq));
					}
					else if(rdbt3.isSelected()) {
						int kq=i1*i2;
						textField_kq.setText(String.valueOf(kq));
					}
					else if (rdbt4.isSelected()) {
						double kq=(double)i1/i2;
						textField_kq.setText(String.valueOf(kq));
					}
            	} catch (Exception e1) {
            		 JFrame f=new JFrame();  
            		    JOptionPane.showMessageDialog(f,"Dữ liệu đầu vào đã để trống hoặc nhập sai");  

				}
            	
            }
        });

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setBounds(109, 144, 128, 21);
		contentPane.add(btnNewButton);
	
}}
