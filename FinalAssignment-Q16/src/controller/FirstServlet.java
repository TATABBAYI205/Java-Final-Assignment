package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 16. Create a Java servlet that uses session management to maintain the state of the
	 user across multiple requests. The servlet should store the user's name in a session
	 object and display it on multiple pages of the web application.
 */

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("age", age);

		RequestDispatcher rd = request.getRequestDispatcher("./form2.jsp");
		rd.forward(request, response);

	}

}
