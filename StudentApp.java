package Studentpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class StudentApp {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/studentDB";
		String user="root";
		String password="deepika";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Connection Successful!");
			while(true) {
				System.out.println("\n Choose an option");
				System.out.println("1. View all students");
				System.out.println("2. Insert new student");
				System.out.println("3. Update Student name");
				System.out.println("4. Delete Student");
				System.out.println("5. Search student by ID");
				System.out.println("6. Export all students to file");
				System.out.println("7. Exit");
				
				System.out.println();
				
				System.out.print("Enter your choice: ");
				int choice=sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1:
					View.viewStdt();
					break;
				case 2:
					Insert.insertStdt();
					break;
				case 3:
					Update.updateStdt();
					break;
				case 4:
					Delete.deleteStdt();
					break;
				case 5:
					Search.searchStdt();
					break;
				case 6:
					Export.exportStdt();
					break;
				case 7:
			        System.out.println("Exiting...");
			        con.close();
			        sc.close();
			        return;
				default:
					System.out.println("Invalid choice! Try again...");
				
				
				}
				con.close();
				//sc.close();
			}

		}
		 catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
