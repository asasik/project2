package com.ils.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ils.controller.Login;
import com.ils.dto.Employee;

public class DbModel {
	final String DB_URL = "jdbc:mysql://localhost:3306/batch3";
	final String USER = "root";
	final String PASS = "root";
	Connection conn;
	PreparedStatement stmt;
	boolean result = false;

	public DbModel() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

	}

	public Employee getUser(Employee form) {
		Employee emp = new Employee();
		
		try {

			String getUser = "select * from employee where username=?";
			if (!conn.equals(null)) {
				stmt = conn.prepareStatement(getUser);
				stmt.setString(1, form.getUsername());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					if (rs.getString("password").equals(form.getPassword())) {
						Login.result="success";
						emp.setName(rs.getString("name"));
						emp.setUsername(rs.getString("username"));
						emp.setPassword(rs.getString("password"));
						emp.setEmail(rs.getString("email"));
						emp.setEmpId(rs.getInt("eid"));
					}
					else {
						Login.result="failed";
					}
				}
			}
		} catch (SQLException sqe) {

		} catch (Exception ex) {

		}
		return emp;
	}

	public void saveEmployee(Employee emp) throws SQLException {
		String saveQuery = "insert into employee (name,email,username,password)values(?,?,?,?)";

		if (!conn.equals(null)) {
			try {
				stmt = conn.prepareStatement(saveQuery);
				// emp.setEmpId(100);
				// stmt.setLong(1, emp.getEmpId());
				stmt.setString(1, emp.getName());
				stmt.setString(2, emp.getEmail());
				stmt.setString(3, emp.getUsername());
				stmt.setString(4, emp.getPassword());
				System.out.println("query = " + saveQuery);
				stmt.executeUpdate();

			} catch (SQLException sqe) {
				sqe.printStackTrace();
			}
		}
	}

}
