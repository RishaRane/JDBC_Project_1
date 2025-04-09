package milestone1;

import java.util.*;

public class Student {
	protected int rollNo;
	protected String name;
	protected int age;
	protected int mark;
	protected String department;
	
	public Student(){
		name = new String("");
		department = new String("");
	}

	public Student(int rollNo, String name, int age, int mark, String department) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.department = department;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getMark() {
		return mark;
	}
	
	public String getDepartment() {
		return department;
	}
	
	@Override
	public String toString() {
		return String.format("Roll No : %03d, Name : %s, Age : %d, Mark : %d, Department : %s", rollNo, name, age, mark, department);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rollNo);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(getClass() != o.getClass())
			return false;
		Student other = (Student) o;
		return rollNo == other.rollNo;
	}
	
	public void acceptData(Scanner sc) {
		System.out.print("Enter Roll No : ");
		rollNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name : ");
		name = sc.nextLine();
		System.out.print("Enter Age : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Mark : ");
		mark = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Department : ");
		department = sc.nextLine();
	}
}
