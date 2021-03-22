package comparator;

import java.util.Comparator;

import comparator.CompareExample.Student;

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		return Integer.compare(a.sno, b.sno);
	}
}
