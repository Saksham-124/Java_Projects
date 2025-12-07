package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
@WebServlet("/checkLogin")

public class checkLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");
			
			String query = "SELECT * FROM employeedata WHERE email=? AND password=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, email);
			
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("email", email);
				
				session.setAttribute("password", password);
				
				request.getRequestDispatcher("WelcomePage").forward(request, response);

			}
			
			else {
				
				response.getWriter().append("<h1>Login Failed !!</h1>");
				
				response.getWriter().append("<a href='html/loginpage.html'>Login Page</a>");
				
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
