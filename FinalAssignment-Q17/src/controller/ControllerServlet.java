package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Blog;
import service.IBlogService;
import servicefactory.BlogServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().endsWith("write")) {
			String title = request.getParameter("title");
			String blogDesc = request.getParameter("blogDesc");
			char[] blogContent = request.getParameter("blogContent").toCharArray();
			
			System.out.println("ControllerServlet.doProcess()");
			
			IBlogService service = BlogServiceFactory.getBlogService();
			
			Blog blog = new Blog();
			blog.setBlogTitle(title);
			blog.setBlogDesc(blogDesc);
			blog.setBlogContent(blogContent);
			
			String status = service.insertBlog(blog);
			
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("/insertStatus.jsp");
			rd.forward(request, response);
			
			System.out.println("Status :: " + status);
			
		}
		
		if (request.getRequestURI().endsWith("read")) {
			String title = request.getParameter("title");
			System.out.println("ControllerServlet.doProcess()");

			IBlogService service = BlogServiceFactory.getBlogService();

			Blog blog = service.searchBlog(title);
			String locationOfContentFile = blog.getLocation();
			
			FileReader fr=new FileReader(locationOfContentFile);
			BufferedReader br=new BufferedReader(fr);
			
			String line= br.readLine();
			String data = " ";
			
			while(line!=null)
			{
				data = data + line;
				line=br.readLine();
			}
			br.close();
			
			System.out.println( "From Controller Data data is  :: "+data);
			blog.setBlogContentForRetrival(data);

			request.setAttribute("blog", blog);
			request.setAttribute("location", response);
			RequestDispatcher rd = request.getRequestDispatcher("/searchStatus.jsp");
			rd.forward(request, response);

			System.out.println("Blog is :: " + blog);

		}

	}

}
