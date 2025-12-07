package Student_Records;

import java.sql.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class StudentDataFunction {

	// Insert Data
	public boolean insert(StudentInformation s) {
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String query = "INSERT INTO studentrecords VALUES (?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query); // PrepareStatement use to get parameter in SQL query.
			
			ps.setInt(1, s.studentId); // Set Parameters
			
			ps.setString(2, s.studentName); // Set Parameters
			
			ps.setString(3, s.studentCourse); // Set Parameters
			
			ps.setString(4, s.studentEmailId); // Set Parameters
			
			int row = ps.executeUpdate(); // executeUpdate return row affected.
			
			return row > 0;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
		
	}
	
	
	// Show Only One Data
	public StudentInformation showData(int studentId) {
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String query = "SELECT * FROM studentrecords WHERE sid = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, studentId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				return new StudentInformation(
						
						rs.getInt(1),
						
						rs.getString(2),
						
						rs.getString(3),
						
						rs.getString(4)
						
						);
			}
		
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	// All Data Show
	public ArrayList<StudentInformation> showAll() {
		
		ArrayList<StudentInformation> allStudent = new ArrayList<>();
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String query = "SELECT * FROM studentrecords";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				allStudent.add(new StudentInformation(
						
						rs.getInt(1),
						
						rs.getString(2),
						
						rs.getString(3),
						
						rs.getString(4)
						
						));
			}
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return allStudent;
		
	}
	
	// Data Update
	public boolean update(StudentInformation s) {
		
		try {
			
			Connection con = DbConnection.getConnection();
			
			String query = "UPDATE studentrecords SET sname = ?, scourse = ?, semail = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, s.studentName);
			
			ps.setString(2, s.studentCourse);
			
			ps.setString(3, s.studentEmailId);
			
			return ps.executeUpdate() > 0;
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
		
	}

}
