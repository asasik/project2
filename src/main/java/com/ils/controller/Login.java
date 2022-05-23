package com.ils.controller;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ils.dto.Employee;
import com.ils.model.DbModel;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String result;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee formData = new Employee();
		formData.setUsername(request.getParameter("username"));
		formData.setPassword(request.getParameter("password"));
		try {
			DbModel dbm = new DbModel();
			Employee emp = dbm.getUser(formData);
			System.out.println("database password : " + emp.getPassword());
			if (!emp.equals(null)) {
				if (emp.getPassword().equals(formData.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("name", emp.getName());
					session.setAttribute("username", emp.getUsername());
					session.setAttribute("eid", emp.getEmpId());
					session.setAttribute("email", emp.getEmail());
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/welcome.jsp");
					rd.forward(request, response);
				}
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<html>");
				out.print("<body>");
				out.print("<h1 style='color:red;'> Invalid username or password..</h1>");
				out.print("</body>");
				out.print("</html>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}

}
