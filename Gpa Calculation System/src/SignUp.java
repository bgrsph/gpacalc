import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField name_field;
	private JTextField surname_field;
	private JTextField username_field;
	private JTextField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	Connection connection = null;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnNewButton;
	private JLabel lblOnceYouSign;
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		name_field = new JTextField();
		name_field.setColumns(10);
		
		surname_field = new JTextField();
		surname_field.setColumns(10);
		
		username_field = new JTextField();
		username_field.setColumns(10);
		
		password_field = new JTextField();
		password_field.setColumns(10);
		
		
		

		//Connect With Database
		connection = SQLiteConnectionCheck.dbConnector();
		
	
		JButton btnSgnUp = new JButton("SIGN UP");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnSgnUp.setIcon(new ImageIcon(img2));
		btnSgnUp.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnSgnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//Add User Info Into Table
				
				try{
					Statement state2 = connection.createStatement();
					String name = "'" + name_field.getText() + "'";
					String surname = "'" + surname_field.getText() + "'";
					String username = "'" + username_field.getText() + "'";
					String password = "'" + password_field.getText() + "'";
					
					String query = ("INSERT INTO " + "StudentsInfo" + " VALUES " + "(" + name + " , " + surname + " , " + username + " , " + password + "); "); 
					
					state2.executeQuery(query);
					
					
					
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "You Signed Up!");
					
				}
			}
		});
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblNewLabel = new JLabel("SURNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		btnNewButton = new JButton("MAIN MENU");
		Image img3 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblOnceYouSign = new JLabel("Once you signed up, you can click on Main Menu to choose the operation you want");
		lblOnceYouSign.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPassword)
								.addComponent(lblNewLabel)
								.addComponent(lblName)
								.addComponent(lblUsername))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(username_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(surname_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(password_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSgnUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(52))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblOnceYouSign)
							.addContainerGap(59, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(surname_field, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(btnSgnUp, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(username_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(password_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
					.addGap(71)
					.addComponent(lblOnceYouSign)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
