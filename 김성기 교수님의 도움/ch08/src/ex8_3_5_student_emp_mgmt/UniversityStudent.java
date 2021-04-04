package ex8_3_5_student_emp_mgmt;

// Student Ŭ������ ���� Ŭ������ ���л��� ��Ÿ���� UniversityStudent Ŭ����
class UniversityStudent extends Student {
	int sno;		// �й�
	String dept;	// �а�
	Course enrolledCourses[] = new Course[100];  	// ���������
	int cntCourses = 0;                             // �������� ����

	// ���л��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// ������û�ϴ�
		enrolledCourses[cntCourses++] = course;
	}

	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Student Ŭ������ �޼ҵ带 �������̵�
	//   ����ʵ��� name, age, cuurentLocation, schoolname, grade�� ���� �ʵ���� ���ڿ��� �����ϱ� ����  
	//   super.toString()�� �̿��Ͽ� ���� Ŭ������ toString() �޼ҵ� ȣ��
	public String toString() {
		return  super.toString() + 
				", �й�:" + this.sno + ", �а�:" + this.dept  ;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�	
	void output() {
		System.out.println("  * ���л� - " + this.toString());
	}
}

// ���л��� �����ϴ� ������ ��Ÿ���� Course Ŭ����
class Course {
	String courseNo;    // �����ȣ 
	String coursename;  // �����̸� 
	int credit;         // ������

	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}
