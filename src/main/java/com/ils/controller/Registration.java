package com.ils.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ils.dto.Employee;
import com.ils.model.DbModel;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		Employee emp = new Employee();
		DbModel dbm = new DbModel();
		emp.setName(request.getParameter("name"));
		emp.setEmail(request.getParameter("email"));
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		dbm.saveEmployee(emp);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h1 style='color:green';>Hello "+emp.getName()+" your registration completed successfully</h1>");
		out.write("</body>");
		out.write("</html>");
		
		request.getRequestDispatcher("index.jsp").include(request,response);
		
	
		}
		catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		catch(ClassNotFoundException cne) {
			cne.printStackTrace();
		}
	}

}
