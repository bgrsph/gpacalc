import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	
	
	
	
	
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManMenu = new JLabel("MAIN MENU");
		lblManMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnGpaCalculator = new JButton("GPA CALCULATOR");
		Image img3 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnGpaCalculator.setIcon(new ImageIcon(img3));
		btnGpaCalculator.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnUntConverter = new JButton("UNIT CONVERTER");
		Image img4 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnUntConverter.setIcon(new ImageIcon(img4));
		btnUntConverter.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnMyToDo = new JButton("MY TO DO LIST");
		Image img5 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnMyToDo.setIcon(new ImageIcon(img5));
		btnMyToDo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		
		//Create the class 'Login' to retrieve user name and surname
		Login loginPage = new Login();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblUserNameAnd = new JLabel();
		lblUserNameAnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setText(loginPage.getCurrentUserName());
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGpaCalculator, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblManMenu)
					.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblUserNameAnd)
							.addGap(55))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(92))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUntConverter, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMyToDo, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
					.addGap(41))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblManMenu))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblUserNameAnd))))
					.addGap(40)
					.addComponent(btnGpaCalculator)
					.addGap(45)
					.addComponent(btnUntConverter)
					.addGap(47)
					.addComponent(btnMyToDo)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
