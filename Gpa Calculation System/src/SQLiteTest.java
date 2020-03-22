

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {


	private static Connection con;
	private static boolean hasData = false;


	public ResultSet displayUsers() throws ClassNotFoundException, SQLException {

		if(con == null) {
			getConnection();
		}



		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT fname, lname FROM user");

		return res;

	}


	private void getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\blgpr\\Desktop\\SQLite\\studentData.sqlite");
		initialise();



	}


	private void initialise() throws SQLException {
		if( !hasData) {
			hasData = true;

			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'user'");

			if( !res.next()) { 
				System.out.println("Building the User table with prepopulated values.");
				//new to build the table
				Statement state2 = con.createStatement();
				state.execute("CREATE TABLE user(id integer," + "fName varchar(60)," + ""
						+ "lName varchar(60)," + "primary key(id));" );


				//inserting some sample data
				PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep.setString(2, "John");
				prep.setString(3, "McNeil");
				prep.execute();

				PreparedStatement prep2 = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep.setString(2, "Paul");
				prep.setString(3, "Smith");
				prep.execute();


			}

		}



	}

	public void addUser(String firstName, String lastName) throws ClassNotFoundException, SQLException {
		
		if( con == null){
			getConnection();
		}
		
		PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
		prep.setString(2, firstName);
		prep.setString(3, lastName);
		prep.execute();
	}








}

