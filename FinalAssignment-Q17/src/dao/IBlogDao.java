package dao;

import dto.Blog;

public interface IBlogDao {
	public String insertBlog(Blog blog);
	
	public Blog searchBlog(String blogTitle);
}
