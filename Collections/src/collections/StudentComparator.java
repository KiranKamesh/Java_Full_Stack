package collections;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
	
	@Override
	public int compare(Student s1,Student s2) {
		if(s1.getStudentGrade() == s2.getStudentGrade()){
			return 0;
		}else if(s1.getStudentGrade()>s2.getStudentGrade()){
			return 1;
		}else{
			return -1;
		}
		
	}

}
