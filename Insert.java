package Studentpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Insert {
	public static void insertStdt() {
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter Student name: ");
			String name = sc.nextLine();
			System.out.print("Enter student id: ");
			int id = sc.nextInt();
			System.out.print("Enter student mark: ");
			int mark = sc.nextInt();
			String sql = "INSERT INTO sDB (name,id,mark) VALUES (?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setInt(2, id);
			pst.setInt(3, mark);
			pst.executeUpdate();
			System.out.println("Information stored successfully!");
			con.close();
			//sc.close();
		}
		 catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

}
