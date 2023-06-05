import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_Crud extends JFrame {

	private JPanel contentPane;
	private JTextField pid;
	private JTextField pname;
	private JTextField price;
	private JTextField category;
	private JTextField quantity;
	private JTextField adminid;
	private static JTable table;
	DefaultTableModel model ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Crud frame = new Admin_Crud();
					frame.setVisible(true);
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
						Object o[] = {rs.getInt("PId"),rs.getString("PName"),rs.getInt("Price"),rs.getString("Category"),rs.getInt("Quantity"),rs.getInt("Admin_id")};
						tm.addRow(o);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Crud() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrator Operations ");
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 70));
		lblNewLabel.setBounds(357, 10, 702, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(35, 125, 108, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(35, 182, 140, 37);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(35, 249, 108, 37);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Category");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(35, 319, 108, 37);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1.setBounds(35, 378, 108, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Admin ID");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1_1.setBounds(35, 442, 108, 37);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		pid = new JTextField();
		pid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pid.setBounds(188, 128, 198, 37);
		contentPane.add(pid);
		pid.setColumns(10);
		
		pname = new JTextField();
		pname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pname.setColumns(10);
		pname.setBounds(188, 182, 198, 37);
		contentPane.add(pname);
		
		price = new JTextField();
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setColumns(10);
		price.setBounds(188, 249, 198, 37);
		contentPane.add(price);
		
		category = new JTextField();
		category.setFont(new Font("Tahoma", Font.PLAIN, 16));
		category.setColumns(10);
		category.setBounds(188, 319, 198, 37);
		contentPane.add(category);
		
		quantity = new JTextField();
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quantity.setColumns(10);
		quantity.setBounds(188, 378, 198, 37);
		contentPane.add(quantity);
		
		adminid = new JTextField();
		adminid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adminid.setColumns(10);
		adminid.setBounds(188, 442, 198, 37);
		contentPane.add(adminid);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(135, 206, 235));
		scrollPane_1.setBounds(437, 125, 816, 476);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JTableHeader header2 = table.getTableHeader();
		header2.setBackground(Color.orange);
		Dimension dim2 = new Dimension(20,1);
		table.setIntercellSpacing(dim2);
		int height2 = table.getRowHeight();
		table.setRowHeight(height2+10);
		table.setColumnSelectionAllowed(true);
		model = new DefaultTableModel();
		Object col[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		Object row[] = new Object[6];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		//Add data in jtable
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(50, 205, 50));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(pid.getText()==null ||
						pname.getText()==""||
						price.getText()==""||
						category.getText()==""||
						quantity.getText()==""||
						adminid.getText()=="") {
					JOptionPane.showMessageDialog(null,"Complete The Information !!");
				}
				DefaultTableModel tm2 = (DefaultTableModel)table.getModel();
				if(tm2.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"Table is Empty !!");
				}
				else if(pid.getText()==""||pname.getText()==""||category.getText()==""||quantity.getText()==""||
						adminid.getText()=="" || price.getText()==""){
					JOptionPane.showMessageDialog(null,"Complete the Information !!");
				}
				else {
					//If table is not Empty then perform insertion
					String pid2,pname2,price2,category2,quantity2,adid2;
					
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
						
							pid2 = pid.getText();
							pname2 = pname.getText();
							price2 = price.getText();
							category2 = category.getText();
							quantity2 = quantity.getText();
							adid2 = adminid.getText();
							
							String query = "Insert into Product(PId,PName,Price,Category,Quantity,Admin_id) values(?,?,?,?,?,?)";
							PreparedStatement ps2 = conn.prepareStatement(query);
							ps2.setString(1,pid2);
							ps2.setString(2,pname2);
							ps2.setString(3,price2);
							ps2.setString(4,category2);
							ps2.setString(5,quantity2);
							ps2.setString(6,adid2);
							
							ps2.execute();
							
						JOptionPane.showMessageDialog(null,"Data Inserted Successfully !!");
						
					}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null,"Check values again !!\nThis Id is already in use");
						e3.printStackTrace();
					}
				
				}     
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(51, 527, 140, 63);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(50, 205, 50));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pid.getText()==""||
						pname.getText()==" "||
						price.getText()==""||
						category.getText()==""||
						quantity.getText()==""||
						adminid.getText()=="") {
					JOptionPane.showMessageDialog(null,"Complete The Information !!");
				}
				
				else {
				String pid2,pname2,price2,category2,quantity2,adid2;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					if(pid.getText()==" ") {
						JOptionPane.showMessageDialog(null,"Complete The Information !!");
						
					}else {
						
						String query = "Update Product Set PId ='"+pid.getText()+"',PName='"+pname.getText()+"',Price='"+price.getText()+"', Category='"+category.getText()+"', Quantity='"+quantity.getText()+"',Admin_id='"+adminid.getText()+"' where PId = '"+pid.getText()+"' ";
						PreparedStatement ps2 = conn.prepareStatement(query);
						try {
							ps2.executeUpdate();
							JOptionPane.showMessageDialog(null,"Data Updated Successfully !!");
						}
					
					catch(Exception e67) {
						e67.printStackTrace();
					}
					}
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(null,"Unable to Update !!\n\nPlease check data again..");
					e3.printStackTrace();
				}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(230, 527, 140, 63);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid2,pname2,price2,category2,quantity2,adid2;
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					
					String query = "";
					if(pid.getText()=="") {
							JOptionPane.showMessageDialog(null,"Complete The Information !!");
					}
					else {
						
						try {
							query = "delete from Product where PId = '"+pid.getText()+"' ";
							PreparedStatement ps2 = conn.prepareStatement(query);
			
							ps2.execute();
						
							JOptionPane.showMessageDialog(null,"Data Deleted Successfully !!");
						}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null,"Unable to Delete !!\n\nPlease check data again..");
						e3.printStackTrace();
					}
					}
				}
				catch(Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(51, 622, 140, 61);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("CLEAR");
		btnNewButton_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pid.setText("");
				pname.setText("");
				price.setText("");
				category.setText("");
				quantity.setText("");
				adminid.setText("");
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1.setBounds(230, 622, 140, 61);
		contentPane.add(btnNewButton_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 182, 236, 233);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1_1_1_1 = new JButton("LOAD DATA");
		btnNewButton_1_1_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1_1_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					
					PreparedStatement ps = conn.prepareStatement("Select * from Product");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
						Object o[] = {rs.getInt("PId"),rs.getString("PName"),rs.getInt("Price"),rs.getString("Category"),rs.getInt("Quantity"),rs.getInt("Admin_id")};
						tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1_1.setBounds(677, 645, 170, 56);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("BACK");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Intro_Page().setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1_1_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1_1_1_1_1.setBounds(881, 645, 170, 56);
		contentPane.add(btnNewButton_1_1_1_1_1);
	}
}
