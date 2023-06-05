import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Queries20 extends JFrame {

	private JPanel contentPane;
	private JTable table,table1,table2,table3,table4;
	DefaultTableModel model ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queries20 frame = new Queries20();
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
	public Queries20() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 25, 1300, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 321, 876, 432);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Dimension dim2 = new Dimension(20,1);
		table.setIntercellSpacing(dim2);
		int height2 = table.getRowHeight();
		table.setRowHeight(height2+10);
		table.setColumnSelectionAllowed(true);
		JTableHeader header2 = table.getTableHeader();
		header2.setBackground(Color.orange);

		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		model = new DefaultTableModel();
		//Categoriwise
		Object col1[] = {"PId","PName","Price","Category","Quantity","Admin_id"};
		Object row1[] = new Object[6];
		
		model.setColumnIdentifiers(col1);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
//-------------------------------------------------------------------------------------
		
		table1 = new JTable();
		Dimension dim1 = new Dimension(20,1);
		table1.setIntercellSpacing(dim2);
		int height1 = table1.getRowHeight();
		table1.setRowHeight(height2+10);
		table.setColumnSelectionAllowed(true);
		JTableHeader header1 = table.getTableHeader();
		header1.setBackground(Color.orange);

		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		model = new DefaultTableModel();
		
		// customer address wise
		Object col2[] = {"custId","custName","addr","phno"};
		Object row2[] = new Object[4];
		model.setColumnIdentifiers(col1);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
//----------------------------------------------------------------------------------
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(400, 0, 896, 311);
		contentPane.add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(0, 0, 378, 794);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("group by");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(10, 10, 358, 59);
		panel.add(btnNewButton);
		
		JButton btnOrderBy = new JButton("order by");
		btnOrderBy.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOrderBy.setBounds(10, 79, 358, 59);
		panel.add(btnOrderBy);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Group By Product Category");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");

					PreparedStatement ps = conn.prepareStatement("Select * from Product group by Category");
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
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnNewButton_1.setBounds(274, 23, 381, 52);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Group By Customer Address");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
					
					PreparedStatement ps = conn.prepareStatement("Select * from customer group by addr");
					ResultSet rs = ps.executeQuery();
					DefaultTableModel tm = (DefaultTableModel)table.getModel();
					tm.setRowCount(0);
					while(rs.next()) {
						Object o[] = {rs.getInt("custId"),rs.getString("custName"),rs.getString("addr"),rs.getInt("phno")};
						tm.addRow(o);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 29));
		btnNewButton_1_1.setBounds(274, 119, 381, 52);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
	}
}
