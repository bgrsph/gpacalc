import java.awt.EventQueue;


import java.sql.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * @wbp.nonvisual location=-157,654
	 */
	private final JLabel label = new JLabel("New label");
	private JPasswordField passwordField;
	private JTextField usernameField;
	/**
	 * @wbp.nonvisual location=-117,144
	 */
	private final JPanel panel = new JPanel();


	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SQLiteConnectionCheck.dbConnector();
	}

	public String getCurrentUserName(){


		return usernameField.getText();
	}






	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblEnterYourUsername = new JLabel("USERNAME\r\n\r\n");
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));

		passwordField = new JPasswordField();

		usernameField = new JTextField();
		usernameField.setColumns(10);










		JButton btnLogn = new JButton("LOGIN");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogn.setIcon(new ImageIcon(img2));

		btnLogn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				try{
					String query = "SELECT * FROM StudentsInfo WHERE username = ? AND password = ?;" ;
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,usernameField.getText());
					pst.setString(2,passwordField.getText());
					int count = 0;
					ResultSet rs = pst.executeQuery();
					while(rs.next()){
						count++;


					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "Username and password is correct");

						

					}
					else if(count >1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and password is not correct");

					}
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);

				}




			}
		});
		btnLogn.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel lblWelcomeToThe = new JLabel("Welcome To The Students Tools Program");
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));

		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sign = new SignUp();
				sign.setVisible(true);
				frame.dispose();
			}
		});


		Image img3 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		//SILINEBÝLÝR

		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(lblWelcomeToThe)
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblEnterYourUsername))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnLogn, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(9)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEnterYourUsername)
								.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogn)
								.addComponent(btnNewButton))))
					.addGap(84))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
