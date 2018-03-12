import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class testgui1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHiMy;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnUseItem;
	private JButton btnUseItem_1;
	private JButton btnUseItem_2;
	private JButton btnUseItem_3;
	private JButton btnUseItem_4;
	private JButton btnUseItem_5;
	private JButton btnUseItem_6;
	private JButton btnUseItem_7;
	private JButton btnUseItem_8;
	private JButton btnUseItem_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testgui1 frame = new testgui1();
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
	public testgui1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 405);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHiMy = new JTextField();
		txtHiMy.setBounds(119, 12, 304, 20);
		contentPane.add(txtHiMy);
		txtHiMy.setColumns(10);
	
		textField_1 = new JTextField();
		textField_1.setBounds(119, 46, 304, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 80, 304, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(119, 114, 304, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 148, 304, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(119, 182, 304, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(119, 216, 304, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(119, 250, 304, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(119, 284, 304, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(119, 318, 304, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		btnUseItem = new JButton("Use Item 1");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		btnUseItem.setBounds(10, 11, 89, 23);
		contentPane.add(btnUseItem);
		
		btnUseItem_1 = new JButton("Use Item 2");
		btnUseItem_1.setBounds(10, 45, 89, 23);
		contentPane.add(btnUseItem_1);
		
		btnUseItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_2 = new JButton("Use Item 3");
		btnUseItem_2.setBounds(10, 79, 89, 23);
		contentPane.add(btnUseItem_2);
		
		btnUseItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_3 = new JButton("USe Item 4");
		btnUseItem_3.setBounds(10, 113, 89, 23);
		contentPane.add(btnUseItem_3);
		
		btnUseItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_4 = new JButton("Use Item 5");
		btnUseItem_4.setBounds(10, 147, 89, 23);
		contentPane.add(btnUseItem_4);
		
		btnUseItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_5 = new JButton("Use Item 6");
		btnUseItem_5.setBounds(10, 181, 89, 23);
		contentPane.add(btnUseItem_5);
		
		btnUseItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_6 = new JButton("Use Item 7");
		btnUseItem_6.setBounds(10, 215, 89, 23);
		contentPane.add(btnUseItem_6);
		
		btnUseItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_7 = new JButton("Use Item 8");
		btnUseItem_7.setBounds(10, 249, 89, 23);
		contentPane.add(btnUseItem_7);
		
		btnUseItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_8 = new JButton("Use Item 9");
		btnUseItem_8.setBounds(10, 283, 89, 23);
		contentPane.add(btnUseItem_8);
		
		btnUseItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
		
		btnUseItem_9 = new JButton("Use Item 10");
		btnUseItem_9.setBounds(10, 317, 89, 23);
		contentPane.add(btnUseItem_9);
		
		btnUseItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
				System.exit(0);
			}
		});
	}
}
