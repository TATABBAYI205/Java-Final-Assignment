package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import util.JdbcUtil;

public class BatchUpdate {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			String postgresSqlInsertQuery = "INSERT INTO employee(ename, eage, address, salary, desg) VALUES (?, ?, ?, ?, ?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(postgresSqlInsertQuery );
			}
			
			if(pstmt != null) 
			{
				scanner =new Scanner(System.in);
				
				while(true) {
					System.out.print("Enter the location of data file to insert record :: ");
					String location =scanner.next();
					
					FileInputStream file = new FileInputStream(location);
					Properties properties = new Properties();
					properties.load(file);
					
					pstmt.setString(1, properties.getProperty("ename"));
					pstmt.setInt(2, Integer.parseInt(properties.getProperty("eage")));
					pstmt.setString(3, properties.getProperty("address"));
					pstmt.setInt(4, Integer.parseInt(properties.getProperty("salary")));
					pstmt.setString(5, properties.getProperty("desg"));
					
					//query added to the batch file
					pstmt.addBatch();
					
					System.out.println("Do you want to insert one more record[Yes/No]");
					String option = scanner.next();
					
					if(option.equalsIgnoreCase("no")) {
						break;
					}
				}	
				
				//executing the queries present in the batch file
				pstmt.executeBatch();
				
				System.out.println("Record inserted successfully.....");
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
