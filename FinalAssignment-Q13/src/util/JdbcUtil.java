package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {}
	
	static {
		//Step1. Loading and register Driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws IOException, SQLException
	{
		//Take the data from the properties file
		FileInputStream fis=new FileInputStream("src\\in\\ineuron\\properties\\applications.properties");
		Properties properties=new Properties();
		properties.load(fis);
		
		//Step2. Establish the connection
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),
						properties.getProperty("userName"), properties.getProperty("passWord"));
		System.out.println("CONNECTION Object created...");
		return connection;
	}
	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException 
	{
		//Step6. Close the Resources
		if(connection!=null) {
			connection.close();
		}
		if(statement!=null) {
			statement.close();
		}
		if(resultSet!=null) {
			resultSet.close();
		}
	}
	
	

}
