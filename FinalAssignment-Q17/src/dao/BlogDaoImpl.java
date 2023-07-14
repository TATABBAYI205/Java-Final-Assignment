package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import dto.Blog;
import util.JdbcUtil;

public class BlogDaoImpl implements IBlogDao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String insertBlog(Blog blog) {
		System.out.println("BlogDaoImpl.insertBlog()");

		String sqlInsertQuery = "INSERT INTO blog(`title`,`description`,`content`)VALUES(?,?,?)";
		String status = "";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {

				File file = new File("BlogFile"+ new Random().nextInt(100)+".txt");
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(blog.getBlogContent());
				
				bw.flush();
				bw.close();

				pstmt.setString(1, blog.getBlogTitle());
				pstmt.setString(2, blog.getBlogDesc());
				pstmt.setCharacterStream(3, new FileReader(file));

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					status = "success";
				} else {
					status = "failure";
				}

			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Blog searchBlog(String blogTitle) {
		System.out.println("BlogDaoImpl.searchBlog()");
		String sqlSelectQuery ="SELECT title, description, content FROM blog WHERE title = ?";
		Blog blog = null;
		List<char[]> li = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				pstmt.setString(1, blogTitle);
			}
			
			if(pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet != null) {
				
				if(resultSet.next()){
					blog = new Blog();
					
					//Copying resultSet data to student object
					blog.setBlogTitle(resultSet.getString(1));
					blog.setBlogDesc(resultSet.getString(2));
					Reader reader = resultSet.getCharacterStream(3);

					BufferedReader br=new BufferedReader(reader);
					String line = br.readLine();
					
					File file = new File("E:\\Final Assignment\\Question17\\src\\main\\java\\","BlogFile.txt");
					FileWriter fw = new FileWriter(file,false);
					BufferedWriter bw = new BufferedWriter(fw);
					
					String location = file.getAbsolutePath();
					System.out.println(location);
					
					blog.setLocation(location);
					
					while(line != null) {
						System.out.println(line);
						char[] ch = line.toCharArray();
						bw.write(ch);
						bw.newLine();
						line = br.readLine();
					}
					br.close();
					System.out.println("BlogDaoImpl.searchBlog()");
					
					bw.flush();
					bw.close();
				}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return blog;
	}

}
