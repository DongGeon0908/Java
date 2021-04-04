package ex7_2_1_object_as_superclass_object;

/**
 * [ Person Ŭ������ ���� ���� Ŭ������ ]: 
 *       ���� Ŭ������ ��ü ���������� ���� Ŭ���� ��ü�� ����Ǵ� ��ĳ������ ��
 *  
 *   o ��ĳ����(upcasting)
 *     - Java���� ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���ҵ� ��
 *     - ��ĳ����: ���� Ŭ���� ��ü�� Ÿ���� ���� Ŭ���� Ÿ������ ��ȯ��Ű�� ��
 *     - ��ĳ������ ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���������� �����ϱ� ���� �ʿ���
 *    
 *   o ��ĳ������ ���� Ŭ�������� ���, �������̵��� �Բ� ���� �߿��� ����
 *     - ���� Ŭ���� ��ü���� ���� Ŭ���� ��üó�� ����� �� �ְ� �Ͽ� ���� ������ ����
 */

// Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo(), output()�� ���� Ŭ����
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
	
	// output(): Person ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation );
	}
}

// Person Ŭ������ ���� Ŭ������ Student�� ����
//   ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//   ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), output()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;	    // �г�

	//�̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age) {
		super(name, age);  
	}

	//�̸�, ����, �б���, �г��� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);  
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

//Student Ŭ������ ���� Ŭ������ �ʵ��л��� ��Ÿ���� PrimaryStudent Ŭ����
class PrimaryStudent extends Student {
	int classNo;    // ��
	int noInClass;  // �ݿ����� ��ȣ

	// �ʵ��л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		super(name, age, schoolname, grade);
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	// output(): ������ ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �ʵ��л� �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", ��:" + this.classNo + ", ��ȣ:" + this.noInClass);
	}
}

class MiddleHighStudent extends Student {
	int sno;		// �й�
	int classNo;  	// ��
	int noInClass;  // �ݿ����� ��ȣ

	// �߰�� �л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	MiddleHighStudent(String name, int age, String schoolname, int grade, int sno, int classNo, int noInClass) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.classNo = classNo;    this.noInClass = noInClass;
	}

	void output() {
		System.out.println("\n  * �߰���л� �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", �й�:" + this.sno + 
				", ��:" + this.classNo + ", ��ȣ:" + this.noInClass);
	}
}

class UniversityStudent extends Student {
	int sno;		// �й�
	String dept;	// �а�
	Course enrolledCourses[] = new Course[100];  	// ���������
	int cntCourses = 0;                             // �������� ����

	// ���л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	  // ������û�ϴ�
		enrolledCourses[cntCourses++] = course;
	}

	// output(): ������ ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ���л� �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation +
				", �б���:" + this.schoolname + ", �г�:" + this.grade + 
				", �й�:" + this.sno + ", �а�:" + this.dept );
	}
}

//���л��� �����ϴ� ������ ��Ÿ���� Course Ŭ����
class Course {
	String courseNo;    // �����ȣ 
	String coursename;  // �����̸� 
	int credit;         // ������

	// ���� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_2_1_StudentMgmt {

	public static void main(String[] args) {
        Student yskim  = new Student("�迵��", 14, "�������б�", 2);
        yskim.goToSchool(); // �迵���� ���

		// Student ��ü �����Ͽ� Person ��ü ���������� ����(��ĳ����) 
		Person p = new Student("�迵��", 11, "�����ʵ��б�", 4);  
		p.goTo("�����ʵ��б�"); // �迵�� �����ʵ��б��� ��

		// UniversityStudent ��ü �����Ͽ� Student ��ü ���������� ����(��ĳ����)
		Student s = new UniversityStudent("��ö��", 23, "�ѱ����б�", 3, 201611001, "��ǻ�Ͱ���");

		s.goToSchool();     // ��ö���� ���
 
		// �迵��, �迵��, ��ö���� �ʵ� ���� ��� ���
		yskim.output();
		p.output();
		s.output(); 
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� ���� Ŭ������ ��ü ���������� ���� Ŭ���� ��ü�� ����� ���� Ȯ���϶�.
 *   
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 * 
 * [ �ǽ� ���� ]
 * 
 *   o main() �޼ҵ忡�� ���� Ŭ������ ���������� ���� Ŭ���� ��ü �����ϱ�
 *     - �ڽ��� ��Ÿ���� UniversityStudent ��ü �����Ͽ� Person ��ü �������� p1�� �����϶�.
 *     - ģ���� ��Ÿ���� UniversityStudent ��ü �����Ͽ� Student ��ü �������� s1�� �����϶�.
 *    
 *     - output() �޼ҵ带 �̿��Ͽ� p1�� s1 ����Ͽ� ��� ������� ���캸��
 *       ��� �ʵ尡 ��µǾ����� Ȯ���϶�.
 */
