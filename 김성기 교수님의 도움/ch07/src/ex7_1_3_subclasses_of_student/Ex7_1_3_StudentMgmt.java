package ex7_1_3_subclasses_of_student;

/**
 * [ Student Ŭ������ ���� ���� Ŭ���� ]: 
 *       Person Ŭ������ ���� Ŭ������ Student Ŭ������ ���� ���� Ŭ������ ����
 *  
 *   o ���� Ŭ������ �� �ٸ� ���� Ŭ������ ���� �� ����
 *    
 *   o Person Ŭ������ ���� Ŭ������ Student Ŭ������ ���� ���� Ŭ��������
 *     PrimaryStudent, MiddleHighStudent, UniversityStudent ����
 *      
 *     - �̵� Student Ŭ������ ���� ���� Ŭ�������� Student Ŭ������ �ʵ�� �޼ҵ带 ��ӹ���
 *     - ���� �ʵ�� ���� �޼ҵ带 ���� �� ����    
 */

// Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo(), output()��  ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}
}

// Person Ŭ������ ���� Ŭ������ Student�� ����
//   ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//   ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), output()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age) {
		super(name, age);  
	}

	// �̸�, ����, �б���, �г��� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);  // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): �л��� ��ϴ� ���� ��Ÿ���� �޼ҵ�
	//  currentLocation�� schoolname���� �����ϱ� ���� goTo() �޼ҵ� ȣ��
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// output(): Student ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �л� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + 
				", �б���:" + this.schoolname + ", �г�:" + this.grade);
	}
}

// Student Ŭ������ ���� Ŭ������ �ʵ��л��� ��Ÿ���� PrimaryStudent Ŭ����
class PrimaryStudent extends Student {
	int classNo;    // ��
	int noInClass;  // �ݿ����� ��ȣ

	// �ʵ��л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		super(name, age, schoolname, grade);  // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	
	// output(): ������ ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �ʵ��л�-  �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", ��:" + this.classNo + ", ��ȣ:" + this.noInClass);
	}
}

// Student Ŭ������ ���� Ŭ������ �߰���л��� ��Ÿ���� MiddleHighStudent Ŭ����
class MiddleHighStudent extends Student {
	int sno;		// �й�
	int classNo;  	// ��
	int noInClass;  // �ݿ����� ��ȣ

	// �߰�� �л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	MiddleHighStudent(String name, int age, String schoolname, int grade, int sno, int classNo, int noInClass) {
		super(name, age, schoolname, grade);   // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.sno = sno;    this.classNo = classNo;    this.noInClass = noInClass;
	}

	void output() {
		System.out.println("\n  * �߰���л� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", �й�:" + this.sno + 
				", ��:" + this.classNo + ", ��ȣ:" + this.noInClass);
	}
}

// Student Ŭ������ ���� Ŭ������ ���л��� ��Ÿ���� UniversityStudent Ŭ����
class UniversityStudent extends Student {
	int sno;		// �й�
	String dept;	// �а�
	Course[] enrolledCourses = new Course[100];  // ���������
	int cntCourses = 0;                          // �������� ����

	// ���л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) { // ������û�ϴ�
		enrolledCourses[cntCourses++] = course;
	}

	// output(): ������ ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ���л� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", �й�:" + this.sno + ", �а�:" + this.dept );
	}
}

// ���л��� �����ϴ� ������ ��Ÿ���� Course Ŭ����
class Course {
	String courseNo;    // �����ȣ 
	String coursename;  // �����̸� 
	int credit;         // ������

	// ���� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_1_3_StudentMgmt {
	public static void main(String[] args) {
        PrimaryStudent  ps;
        MiddleHighStudent ms;
        UniversityStudent us;
	
        // 11���� �迵��� �����ʵ��б� 4�г� 2�� 12�� �ʵ��л��� 
        ps = new PrimaryStudent("�迵��", 11, "�����ʵ��б�", 4, 2, 12);
        ps.goTo("�����ʵ��б�"); // �迵�� �����ʵ��б��� �� 

        // 14���� �迵���� �������б� �л�����, �й��� 20170203, ���� 2, ��ȣ�� 3��
        ms = new MiddleHighStudent("�迵��", 14, "�������б�", 2, 20170203, 2, 3);
        ms.goToSchool();     // �迵���� ���

        // 21���� ��ö���� �ѱ����б� ��ǻ�Ͱ��а� 3�г� ���л���
        us = new UniversityStudent("��ö��", 21, "�ѱ����б�",3, 201611001, "��ǻ�Ͱ���");
        us.goToSchool();     // ��ö���� ���

        Course co = new Course("CS201", "Java ���α׷���", 3);
        us.enrolCourse(co);  // ��ö���� Java ���α׷��� ������ ����

        // �迵��, �迵��, ��ö���� �ʵ� ���� ��� ���
        ps.output();
        ms.output();
        us.output();
    }    
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� Student Ŭ������ ���� Ŭ������ �ʵ�� �޼ҵ忡 ���� �ľ��϶�.
 *   
 *   2) UniversityStudent Ŭ������ enrolCourse() �޼ҵ带 ���캸�� ����� �����϶�.
 *   
 *   3) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   1) UniversityStudent Ŭ������ output() �޼ҵ忡�� ���� �����̸��� ������ �߰���
 *      ����ϵ��� �����϶�. ��� ����� ������ �����϶�.
 *      
 *          ���������: [ Java ���α׷���, 3 ] [ �ڷᱸ��, 3 ] ...
 *      
 *   2) �л��� �Ǵٸ� ���� Ŭ������ ���п����� �ִ�.
 *      ���п����� �߰����� �ʵ�� �޼ҵ尡 ������ �ִ°��� ã�ƺ��� ���п����� 
 *      ��Ÿ���� Ŭ������ GraduateStudent Ŭ������ �ۼ��϶�.
 *     
 *      main() �޼ҵ忡�� ���п��� ��ü�� ������ �� output() �޼ҵ带 �̿��Ͽ� ����϶�.
 */
