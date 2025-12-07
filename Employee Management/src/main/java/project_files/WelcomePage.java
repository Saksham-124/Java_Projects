package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;
import java.sql.*;

@WebServlet("/WelcomePage")

public class WelcomePage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		
		String password = (String)session.getAttribute("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");
			
			String query = "SELECT * FROM employeedata WHERE email=? AND password=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				request.setAttribute("employee_id", rs.getString("employee_id"));
				
				request.setAttribute("first_name", rs.getString("first_name"));
				
				request.setAttribute("last_name", rs.getString("last_name"));
				
				request.setAttribute("mobileNumber", rs.getString("mobileNumber"));
				
				request.setAttribute("email", rs.getString("email"));
				
				request.setAttribute("password", rs.getString("password"));
				
				request.setAttribute("gender", rs.getString("gender"));
				
				request.getRequestDispatcher("html/profile.jsp").forward(request, response);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
