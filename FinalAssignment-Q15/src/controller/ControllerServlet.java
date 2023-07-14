package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

/*
 15. Write a Java servlet that reads the data from a MySQL database table and displays it
	 in an HTML table on the web page. The servlet should use JDBC to connect to the
	 database and retrieve the data.
 */
 
@WebServlet("/search")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService service = StudentServiceFactory.getStudentService();
		
		String sid = request.getParameter("sid");
		
		Student student = service.searchStudent(Integer.parseInt(sid));
		
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
		rd.forward(request, response);
	}

}
