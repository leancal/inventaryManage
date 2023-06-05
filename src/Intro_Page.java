import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.Component;

public class Intro_Page extends JFrame {

	private JPanel contentPane;

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
			
			System.out.println("Database contains:");
			String query = "select * from Admin" ;
			System.out.println("");
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt("Admin_id");
				String uname=rs.getString("U_name");
				String pwd=rs.getString("Pswd");
				
				System.out.println("Id : "+id+" \nUname : "+uname+" \npwd : "+pwd);

			}
		}
		catch(Exception e) {
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro_Page frame = new Intro_Page();
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
	public Intro_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(800, 1000, 1000, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Welcome to Shopaholic.com",JLabel.CENTER);
		
    	
    	
		title.setName("title");
		title.setBounds(391,0,895,85);
        title.setFont(new Font ("Serif",Font.BOLD,48));
        title.setForeground(new Color(0, 0, 139));
        title.setOpaque(true);
        title.setBackground(new Color(255, 255, 255)); //MAGENTA , darkGray ,
		
		contentPane.add(title);
		
		ImageIcon img=new ImageIcon("Shopaholic2.jpg");
		int w=img.getIconWidth();
    	int h=img.getIconHeight();
    	setPreferredSize(new Dimension(w,h));
		JLabel i3 = new JLabel(img);
		i3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		i3.setBackground(Color.GRAY);
		i3.setBounds(0, 0, 391, 398);
		contentPane.add(i3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 396, 391, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBounds(102, 63, 208, 80);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Page1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.setBounds(102, 210, 208, 80);
		panel.add(btnUserLogin);
		btnUserLogin.setForeground(new Color(0, 0, 0));
		btnUserLogin.setBackground(new Color(255, 255, 255));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User_Crud().setVisible(true);
			}
		});
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JTextArea txtrE = new JTextArea();
		txtrE.setLineWrap(true);

		txtrE.setFont(new Font("Monospaced", Font.BOLD, 25));
		txtrE.setText("     Online Shopping Site for Electronics and Household \r\n\t\t\tGadgets.\r\n\r\n     Shopaholic brings you a variety of Products like \t\t\t\tSmart Phones \r\n\t\t\tLaptops\r\n\t\t\tWatches \r\n\t\t\tCameras \r\n\t\t\tSmart TV's\r\n\r\n\tShopaholic is a major Indian Inventory Company \r\n\theadquartered in Karvenagar, Pune, Maharashtra, \r\n\t\t\tIndia.\r\n\r\n\r\n\t      Company was founded in 2020 to sell\r\n\t\t\t products online. ");
		txtrE.setBounds(401, 95, 860, 626);
		contentPane.add(txtrE);
	}
}
