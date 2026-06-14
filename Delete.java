package Studentpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void deleteStdt() throws SQLException {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Enter student ID to delete: ");
		int id=sc.nextInt();
		sc.nextLine();

		String sql="DELETE FROM sDB WHERE id=?";
		
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		int rows=pst.executeUpdate();
		if(rows>0) {
			System.out.println("Student delete successfully!");
			
		}
		else {
			System.out.println("No student found with the given ID.");
		}
		//sc.close();
	}

}
