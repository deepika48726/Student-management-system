package Studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	public static void updateStdt() throws SQLException {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Enter student ID to update: ");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter new student name: ");
		String name=sc.nextLine();
		
		
		System.out.print("Enter new mark: ");
		int mark=sc.nextInt();
		
		String sql="UPDATE sDB SET name=?, mark=? WHERE id=?";
		
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,name);
		pst.setInt(2, mark);
		pst.setInt(3, id);
		int rows=pst.executeUpdate();
		if(rows>0) {
			System.out.println("Student updated successfully!");
			
		}
		else {
			System.out.println("No student found with the given ID.");
		}
		//sc.close();
	}
	

}
