package project_files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees_db", "root", "root");

            String query = "SELECT * FROM employeedata";
            
            PreparedStatement ps = con.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();

            PrintWriter out = response.getWriter();

            // ⭐ HTML START
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>All Employees</title>");

            // ⭐ CSS START
            
            out.println("<style>");

            out.println("body { font-family: Poppins, sans-serif; background:#f8efe8; padding:20px; }");

            out.println(".styled-table {"
                    + "border-collapse: collapse;"
                    + "margin: 20px auto;"
                    + "font-size: 15px;"
                    + "width: 95%;"
                    + "border-radius: 8px;"
                    + "overflow: hidden;"
                    + "box-shadow: 0 0 10px rgba(0,0,0,0.1);"
                    + "}");

            out.println(".styled-table thead tr {"
                    + "background-color: #f4c7a5;"
                    + "color: #3c3633;"
                    + "text-align: left;"
                    + "font-weight: 600;"
                    + "}");                    

            out.println(".styled-table th, .styled-table td { padding: 12px 15px; }");

            out.println(".styled-table tbody tr { border-bottom: 1px solid #ddd; }");

            out.println(".styled-table tbody tr:nth-of-type(even) { background-color: #f9f5f3; }");

            out.println(".styled-table tbody tr:hover { background-color: #f4e1d3; cursor: pointer; }");

            // ⭐ Update/Delete Button Styles
            
            out.println(".action-btn {"
                    + "padding: 8px 15px;"
                    + "border-radius: 6px;"
                    + "text-decoration: none;"
                    + "color: white;"
                    + "font-weight: 500;"
                    + "}");
            out.println(".update-btn { background-color: #4CAF50; }");  
            out.println(".delete-btn { background-color: #E74C3C; }");
            out.println(".action-btn:hover { opacity: 0.8; }");
            
            out.println(".log-btn {"
                    + "display: inline-block;"           // treat as block for padding
                    + "padding: 10px 25px;"              // bigger padding for nice button
                    + "border-radius: 8px;"
                    + "text-decoration: none;"
                    + "color: white;"
                    + "background-color: black;"
                    + "font-weight: bold;"
                    + "font-size: 16px;"
                    + "text-align: center;"
                    + "cursor: pointer;"
                    + "transition: 0.3s;"                // smooth hover
                    + "}"
                    + ".log-btn:hover {"
                    + "background-color: #333;"          // hover effect
                    + "}");


            out.println("</style>");
            
            // ⭐ CSS END

            out.println("</head>");
            out.println("<body>");

            out.println("<h2 style='text-align:center; color:#3c3633;'>All Employee Data</h2>");

            out.println("<table class='styled-table'>");

            // ⭐ TABLE HEADER
            
            out.println("<thead><tr>"
                    + "<th>ID</th>"
                    + "<th>First Name</th>"
                    + "<th>Last Name</th>"
                    + "<th>Mobile</th>"
                    + "<th>Email</th>"
                    + "<th>Password</th>"
                    + "<th>Gender</th>"
                    + "<th>Update</th>"
                    + "<th>Delete</th>"
                    + "</tr></thead>");

            out.println("<tbody>");

            // ⭐ FETCH & DISPLAY ROWS
            
            while (rs.next()) {
            	
            	int id = rs.getInt("employee_id");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + rs.getString("first_name") + "</td>");
                out.println("<td>" + rs.getString("last_name") + "</td>");
                out.println("<td>" + rs.getString("mobileNumber") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");

                // ⭐ Update/Delete Links
                
                out.println("<td><a href='html/update.html?id=" + rs.getInt("employee_id") + "' class='action-btn update-btn'>Update</a></td>");
                out.println("<td><a href='Delete?email=" + rs.getString("email") + "' class='action-btn delete-btn'>Delete</a></td>");

                out.println("</tr>");
            }

            out.println("</tbody>");
            
            out.println("</table>");
            
            out.println("<div style='display: flex; justify-content: center; align-items: center; height: 100%;'>"
                    + "<a href='./html/login.html' class='log-btn'>BACK TO LOGIN PAGE</a>"
                    + "</div>");
            
            out.println("</body></html>");

        } catch (Exception e) {
            
        	e.printStackTrace();
            
        	response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
