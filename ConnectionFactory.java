package proj1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn;
	//dont forget to force your maven properties to update to java 1.8. it won't work unless you do.
	public static Connection getConnection() {
	try {
		/*You can include this if the application can't find the Driver class on the build path. 
		 * This will tell it to locate this
		 * 
		 */
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection( 
				// This looks good for formatting purposes.
				// NOTE: we also need to add the port number and the name of our database.
				
				// HArdcoding your credentials is BAD!
				//instead, obscure the credentials by using environment variables
				//or a Properties file.
				"jdbc:postgresql://database-2.c775o0tjx8lx.us-east-2.rds.amazonaws.com:5432/richarddb",
				// host in connections settings obtained from dbeaver.
				"postgres", //hers was postgres. mine is too based on connection settings in dbeaver.
				"newsflag1"); // we want to use this one for the connection. also from dbeaver.
		/* WILL STAY COMMENTED OUT UNTIL WE GET THIS.
			conn = DriverManager.getConnection(
					System.getenv("databaseurl"),
					System.getenv("databaseusername"),
					System.getenv("databasepassword")
					);*/ 
					 // you need to set the system environment variables  in order for this to work.
		// GOOD PRACTICE: catch it here so we know what happened.
			
			// and now, you need to restart STS.
		// we need the endpoint of our database (grabbed from AWS, figure out local connection as well)
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace();
		}
	return conn;
	}

}
