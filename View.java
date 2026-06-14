package Studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class View {
	public static void viewStdt() throws SQLException {
	Scanner sc=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/studentDB";
	String user="root";
	String password="deepika";
	Connection con=DriverManager.getConnection(url,user,password);
	String query="SELECT * FROM sDB";

	try{
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
			System.out.println("\nStudents: ");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getInt("mark"));
			}
		
	}
	 catch (Exception e) {
         e.printStackTrace();
     }

	}
}
