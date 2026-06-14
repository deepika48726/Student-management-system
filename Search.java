package Studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search {
	public static void searchStdt() {
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter student id to search: ");
			int id = sc.nextInt();
			String sql = "SELECT * FROM sDB WHERE id=?";
		
	
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			try(ResultSet rs=pst.executeQuery()){
				if(rs.next()) {
					System.out.println("Student found: ");
					System.out.println("ID: "+rs.getInt("id"));
					System.out.println("Name: "+rs.getString("name"));
					System.out.println("Mark: "+rs.getInt("mark"));
				}
				else {
					System.out.println("No student found with the given ID.");
				}
			}
			//sc.close();
		}
		 catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

}
