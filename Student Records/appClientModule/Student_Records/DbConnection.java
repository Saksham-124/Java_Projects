package Student_Records;

import java.sql.*;

public class DbConnection 
{
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/students_db", "root", "root");
		
	}
	
}

/* 
----------------------------------------------------------------------------------------------
Statements :-

1. Statement :-

   -> Use when SQL query is simple and fixed (no parameters).
   
   -> Good for static SQL (same query every time).
   
   -> Cannot accept parameters.
   
   -> Slower than PreparedStatement (because SQL is not precompiled).
   
2. PreparedStatement	
   
   -> Use when query is repeated OR needs input parameters.
	
	Why better?
	
	-> Allows parameters (?)
	
	-> Faster because SQL is precompiled.
	
	-> Prevents SQL Injection (very important!)
	
3. CallableStatement

	-> Use when calling stored procedures from the database.
		
	-> Stored procedures can have:

	-> IN parameters → input

	-> OUT parameters → output

	-> INOUT → both
   
----------------------------------------------------------------------------------------------

Methods :-

1. execute()	-> Executes any SQL (DDL or dynamic SQL). Returns true if ResultSet comes.

2. executeUpdate() -> For INSERT, UPDATE, DELETE → returns rows affected.

3. executeQuery() -> For SELECT → returns ResultSet.

----------------------------------------------------------------------------------------------


*/