package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		response.getWriter().println(email);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");
			
			String query = "DELETE FROM employeedata WHERE email = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			
			int rs = ps.executeUpdate();
			
			if (rs == 1) {
				
				response.sendRedirect("ShowAll");
			}
			
			else {
				
				response.getWriter().append("Data not deleted !!");
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
			
		}
	}

}
