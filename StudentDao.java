package milestone1;

import java.util.*;
import java.sql.*;

public class StudentDao {
	
	public void insertStudent(Connection conn, Scanner sc) throws SQLException{
		Student s = new Student();
		s.acceptData(sc);
		String SQL = "insert into student values(?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(SQL);
		ps.setInt(1, s.getRollNo());
		ps.setString(2, s.getName());
		ps.setInt(3, s.getAge());
		ps.setInt(4, s.getMark());
		ps.setString(5, s.getDepartment());
		int result = ps.executeUpdate();
		if(result == 1)
			System.out.println("Student inserted successfully.");
		else
			System.out.println("Unable to insert student");
		ps.close();
	}
	
	public void updateStudent(Connection conn, Scanner sc) throws SQLException{
		System.out.print("Enter Student Roll No to update : ");
		int rollno = sc.nextInt();
		sc.nextLine();
		String SQL = new String();
		PreparedStatement ps;
		int result = 0;
		System.out.println("Do you want to update : \n1.Name\n2.Age\n3.Mark\n4.Department\n5.Exit");
		System.out.print("Enter your choice : ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Enter New Name : ");
			String name = sc.nextLine();
			SQL = "update student set Name = ? where RollNo = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setInt(2, rollno);
			result = ps.executeUpdate();
			if(result == 1)
				System.out.println("Name updated successfully..!");
			else
				System.out.println("Unable to update name");
			ps.close();
			break;
		case 2:
			System.out.println("Enter New Age : ");
			int age = sc.nextInt();
			sc.nextLine();			
			SQL = "update student set Age = ? where RollNo = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, age);
			ps.setInt(2, rollno);
			result = ps.executeUpdate();
			if(result == 1)
				System.out.println("Age updated successfully..!");
			else
				System.out.println("Unable to update age");
			ps.close();
			break;
		case 3:
			System.out.println("Enter New Mark : ");
			int mark = sc.nextInt();
			sc.nextLine();			
			SQL = "update student set Mark = ? where RollNo = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, mark);
			ps.setInt(2, rollno);
			result = ps.executeUpdate();
			if(result == 1)
				System.out.println("Mark updated successfully..!");
			else
				System.out.println("Unable to update mark");
			ps.close();
			break;
		case 4:
			System.out.println("Enter New Department : ");
			String department = sc.nextLine();	
			SQL = "update student set Department = ? where RollNo = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, department);
			ps.setInt(2, rollno);
			result = ps.executeUpdate();
			if(result == 1)
				System.out.println("Department updated successfully..!");
			else
				System.out.println("Unable to update Department");
			ps.close();
			break;
		case 5:
			return;
		}
	}
	
	
	public void deleteStudent(Connection conn, Scanner sc) throws SQLException{
		System.out.print("Enter Student Roll No to Delete : ");
		int rollno = sc.nextInt();
		sc.nextLine();
		String SQL = "delete from student where RollNo = ?";
		PreparedStatement ps = conn.prepareStatement(SQL);
		ps.setInt(1, rollno);
		int result = ps.executeUpdate();
		if(result == 1)
			System.out.println("Student Deleted Successfully");
		else
			System.out.println("Unable to delete student");
		ps.close();
	}
	
	public void displayStudent(Connection conn) throws SQLException{
		String SQL = "select * from student";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		boolean flag = false;
		while(rs.next()) {
			flag = true;
			Student s = new Student();
			s.setRollNo(rs.getInt("RollNo"));
			s.setName(rs.getString("Name"));
			s.setAge(rs.getInt("Age"));
			s.setMark(rs.getInt("Mark"));
			s.setDepartment(rs.getString("Department"));
			System.out.println(s);
		}
		if(flag == true)
			System.out.println("Records displayed successfully..!");
		else
			System.out.println("No records to display");
		st.close();
		rs.close();
	}
}
