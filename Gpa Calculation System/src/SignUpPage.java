import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SignUpPage extends JFrame{

	private JFrame frame;
	private JTextField username_field;
	private JPasswordField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	Connection connection = null;
	private JTextField name_field;
	private JTextField surname_field;
	public SignUpPage() {
		initialize();
		
		//Connect With Database
		connection = SQLiteConnectionCheck.dbConnector();
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel username_Field = new JLabel("USERNAME");
		username_Field.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel password_Field = new JLabel("PASSWORD");
		password_Field.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		username_field = new JTextField();
		username_field.setColumns(10);
		
		password_field = new JPasswordField();
		
		
		
		
		JButton signUpButton = new JButton("SIGN UP");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  //SIGN UP BUTTON EVENT HANDLER :
			
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
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "You Signed Up !");
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
		});
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblSurname = new JLabel("SURNAME");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		name_field = new JTextField();
		name_field.setColumns(10);
		
		surname_field = new JTextField();
		surname_field.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(username_Field)
							.addComponent(password_Field))
						.addComponent(lblSurname)
						.addComponent(lblName))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(signUpButton)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(password_field, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
									.addComponent(username_field, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
									.addComponent(surname_field, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addComponent(name_field, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
							.addGap(220))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(name_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSurname)
						.addComponent(surname_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(username_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(username_Field))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password_Field)
						.addComponent(password_field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(78)
					.addComponent(signUpButton)
					.addGap(61))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
