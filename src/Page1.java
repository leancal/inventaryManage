import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Page1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Connection conn=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		PreparedStatement pst=null;
		JTable table;
		Statement stmt = null;
		
		try {
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
			System.out.println("Connection Succeded..............................");
			stmt=conn.createStatement();
			
		}
		catch(Exception e) {
			
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 frame = new Page1();
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
	public Page1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setName("Frame 1");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setSize(new Dimension(10, 0));
		lblNewLabel.setBounds(438, 296, 159, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setSize(new Dimension(10, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(438, 363, 142, 35);
		contentPane.add(lblNewLabel_1_1);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf1.setBounds(626, 295, 217, 40);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(tf1.getText().equals("Aishwarya") && tf2.getText().equals("123")){
					new Intro_Page().setVisible(true);
					JOptionPane.showMessageDialog(null, "Success");
				}*/
				
				ResultSet rs=null;
				ResultSet rs1=null;
	
				try {
					
//					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					//System.out.println("Connection Succeded..............................");
					Statement stmt=conn.createStatement();
					
					String unm = tf1.getText();
					String pwd = tf2.getText();
					String query = "Select * from Admin where U_name = '"+unm+"' and Pswd = '"+pwd+"'";
		            rs1 = stmt.executeQuery(query);
		            if(rs1.next()) {
		            	JOptionPane(this,"Success");
		            	new Admin_Crud().setVisible(true);
		            }
		            else {
		            	JOptionPane(this,"Username or pswd wrong...");
		            	tf1.setText("");
		            	tf2.setText("");
		            }
		            
				}
				catch(Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(330, 524, 187, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(576, 524, 187, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("BACK");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(818, 524, 187, 57);
		contentPane.add(btnNewButton_1_1);
		
		ImageIcon icon=new ImageIcon("holic.jpg");
		JLabel logo = new JLabel(icon);
		logo.setBounds(0,0,175,115);
		contentPane.add(logo);
		
		JLabel l1 = new JLabel("	Shopaholic.com");
		contentPane.add(l1);
    	l1.setBounds(175,0,1250,115);
    	l1.setFont(new Font ("Serif",Font.BOLD,52));
        l1.setForeground(Color.white);
        l1.setOpaque(true);
        l1.setBackground(Color.darkGray);
        
        tf2 = new JPasswordField();
        tf2.setBounds(626, 366, 217, 40);
        contentPane.add(tf2);
        
        JLabel lblAdminLogin = new JLabel("Admin Login");
        lblAdminLogin.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 70));
        lblAdminLogin.setBounds(481, 125, 567, 90);
        contentPane.add(lblAdminLogin);
        
	}

	protected void JOptionPane(ActionListener actionListener, String string) {
		// TODO Auto-generated method stub
		
	}
}
