package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/Update")

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("employeeId"));
		
		
		
		String update_firstName = request.getParameter("update_firstName");
		
		
		
		String update_lastName = request.getParameter("update_lastName");
		
		
		
		String update_mobileNumber = request.getParameter("update_mobile");
		
		
		
		String update_email = request.getParameter("update_email");
		
		
		
		String update_password = request.getParameter("update_password");
		
		
		
		String update_gender = request.getParameter("update_gender");
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");
			
			String query = "UPDATE employeedata SET first_name=?, last_name=?, mobileNumber=?, email=?, password=?, gender=? WHERE employee_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, update_firstName);
			
			ps.setString(2, update_lastName);
			
			ps.setString(3, update_mobileNumber);
			
			ps.setString(4, update_email);
			
			ps.setString(5, update_password);
			
			ps.setString(6, update_gender);
			
			ps.setInt(7, id);
			
			int row = ps.executeUpdate();
			
			if (row > 0)
			{
				response.sendRedirect("ShowAll");
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
			response.getWriter().println("Error: " + e.getMessage());
		}
	}

}
