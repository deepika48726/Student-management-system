package Studentpackage;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Export {
	public static void exportStdt() throws SQLException {
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		Connection con=DriverManager.getConnection(url,user,password);
	
		String query="SELECT * FROM sDB";
		try(Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(query);
				FileWriter writer=new FileWriter("students.txt")){
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int mark=rs.getInt("mark");
				writer.write(id+" - "+name+" - "+mark+System.lineSeparator());;
			}
			System.out.println("Students exported successfully to student.txt");
		}catch(SQLException | IOException e) {
			System.out.println("Error exporting students: "+e.getMessage());
		}
		//con.close();
	}

}
