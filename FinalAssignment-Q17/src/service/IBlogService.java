package service;

import dto.Blog;

public interface IBlogService {
	public String insertBlog(Blog blog);

	public Blog searchBlog(String blogTitle);
}
