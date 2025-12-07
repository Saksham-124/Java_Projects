package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Employee ID Auto Increment 
		
		String first_name = request.getParameter("first_name");
		
		String last_name = request.getParameter("last_name");
		
		String mobileNumber = request.getParameter("mobile_number");
		
		String email = request.getParameter("email_id");
		
		String password = request.getParameter("password");
		
		String gender = request.getParameter("gender");
		
		String button = request.getParameter("action");
		
		if (button.equals("signup")) {
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");
				
				String query = "INSERT INTO employeedata (first_name, last_name, mobileNumber, email, password, gender) VALUES (?,?,?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(query);
				
				ps.setString(1, first_name);
				
				ps.setString(2, last_name);
				
				ps.setString(3, mobileNumber);
				
				ps.setString(4, email);
				
				ps.setString(5, password);
				
				ps.setString(6, gender);
				
				int row = ps.executeUpdate();
				
				if (row > 0) {
					
					response.sendRedirect("html/signup.html?success=1");
				}
				
				else {
		                
					response.sendRedirect("html/signup.html?error=1"); 
		        }
				
				con.close();
			} 
			
			catch (Exception e) {
				
				e.printStackTrace();
				
		        response.getWriter().println("Error: " + e.getMessage());
				
			} 
		}
		
	}

}
