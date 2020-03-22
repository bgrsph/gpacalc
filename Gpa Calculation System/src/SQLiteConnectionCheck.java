import java.sql.*;

import javax.swing.*;

public class SQLiteConnectionCheck {

		Connection conn = null;

		public static Connection dbConnector()
		{
			try{
				
				Class.forName("org.sqlite.JDBC");

				Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\blgpr\\Desktop\\SQLite\\studentData.sqlite");
				
				JOptionPane pane = new JOptionPane();
				pane.showMessageDialog(null, "Connection Succesfull");
				return conn;

			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return null;
			}


		}

	}


