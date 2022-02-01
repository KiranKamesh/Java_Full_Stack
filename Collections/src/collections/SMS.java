package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SMS {

	Scanner sc = new Scanner(System.in);
	Student s = null;
	ArrayList<Student> studentList = new ArrayList<Student>();

	public void addStudent(Student s) {
		System.out.println("List of students");
		studentList.add(s);
	}

	public void showStudents() {
		System.out.println("List of students");
		System.out.println("id"+" "+"name"+" "+"grade");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getStudentId() + " " + studentList.get(i).getStudentName() + " "
					+ studentList.get(i).getStudentGrade());
		}
	}
	
	public Student readStudentDetails(Student s){
		System.out.println("Enter the student details");
		System.out.println("Enter the id");
		s.setStudentId(sc.nextInt());
		System.out.println("Enter the student name");
		sc.nextLine();
		s.setStudentName(sc.nextLine());
		System.out.println("Enter the student grade");
		s.setStudentGrade(sc.nextInt());
		return s;
		
	}
	public Student findStudentById(int sid){
		Student s1 = new Student();
		for(int i = 0;i<studentList.size(); i++){
			if(studentList.get(i).getStudentId() == sid){
				s1 = studentList.get(i);
			}
		}
		return s1;
	}
	
	public 	String removeStudent(Student s){
		if(studentList.remove(s)){
			return "Student removed";
		}else{
			return "no student found";
		}
	}
	public void studentsByGrade(){
		Collections.sort(studentList, new StudentComparator());
		System.out.println("List of students");
		System.out.println("id"+" "+"name"+" "+"grade");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getStudentId() + " " + studentList.get(i).getStudentName() + " "
					+ studentList.get(i).getStudentGrade());
		}
	}
	
	public void showStudentOperations(){
		char ch = 'y';
		while(ch=='y'){
			System.out.println("enter the name of the operation");
			System.out.println("1. to add students");
			System.out.println("2. list all students");
			System.out.println("3. to delete a student");
			System.out.println("4. to sort students by grade");
			
			int op  = sc.nextInt();
			switch(op){
			case 1:
				s = new Student();
				addStudent(readStudentDetails(s));
				break;
			case 2:
				showStudents();
				break;
			case 4:
				studentsByGrade();
			default:
				break;
			}
			
			System.out.println("Do you still want to continue");
			sc.next().charAt(0);
		}
	}
}
