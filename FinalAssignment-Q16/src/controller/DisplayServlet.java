package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Student;

@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String smobile = request.getParameter("smobile");
		String semail = request.getParameter("semail");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("smobile", smobile);
		session.setAttribute("semail", semail);
		
		RequestDispatcher rd = request.getRequestDispatcher("./display.jsp");
		rd.forward(request, response);
		
	}

}
