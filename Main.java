package milestone1;

import java.util.*;
import java.sql.*;

public class Main {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("message");
		
		String url = rb.getString("url");
		String user = rb.getString("username");
		String password = rb.getString("password");
		
		Scanner sc = new Scanner(System.in);
		StudentDao s = new StudentDao();
		
		try(Connection conn = DriverManager.getConnection(url, user, password)){
			while(true) {
				System.out.println("MENU");
				System.out.println("1.Insert");
				System.out.println("2.Update");
				System.out.println("3.Delete");
				System.out.println("4.Display");
				System.out.println("5.Exit");
				
				System.out.print("Enter choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1:
					s.insertStudent(conn, sc);
					break;
				case 2:
					s.updateStudent(conn, sc);
					break;
				case 3:
					s.deleteStudent(conn, sc);
					break;
				case 4:
					s.displayStudent(conn);
					break;
				case 5:
					System.out.println("Program exited.");
					sc.close();
					System.exit(0);
					break;
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
