package ex7_2_2_upcasting_downcasting;

/**
 * [ Person Ŭ������ ���� ���� Ŭ������ ]: ��ĳ���õ� ��ü�� �ٿ�ĳ�����ϴ� ����
 *  
 *   o ��ĳ����(upcasting)
 *     - Java���� ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���ҵ� ��
 *     - ��ĳ����: ���� Ŭ���� ��ü�� Ÿ���� ���� Ŭ���� Ÿ������ ��ȯ��Ű�� ��
 *     - ��ĳ������ ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���������� �����ϱ� ���� �ʿ�
 *    
 *   o ��ĳ������ ���� Ŭ�������� ���, �������̵��� �Բ� ���� �߿��� ����
 *     - ���� Ŭ���� ��ü���� ���� Ŭ���� ��üó�� ����� �� �ְ� �Ͽ� ���� ������ ����
 *    
 *   o ��ĳ������ ������
 *     - ��ĳ���ÿ� ���� ��ü ���������� ���� Ŭ���� ��ü�� ����Ǹ�(�� ��� �����  ���� Ŭ������ ������ 
 *       ���� Ŭ������ �ٸ�) ������ ���� Ŭ������ ���� �ʵ峪 ����  �޼ҵ带 ������ �� ����
 *     - �׷��� ���� ������ ���� Ŭ������ ����Ư���� ������ �ʿ䰡 ���� �� ����
 *     - �̸� ���Ͽ� Java������ ��ĳ���õ� ��ü ���������� ���� Ÿ������ Ÿ�Ժ�ȯ�� ��  �ֵ��� ����ϸ�, 
 *       �̸� �ٿ�ĳ�����̶� ��
 *    
 *   o �ٿ�ĳ����(downcasting)
 *     - ��ĳ���õ� ��ü�� �����ϴ� ��ü ���������� ���� Ŭ���� Ÿ������ ����������  Ÿ�Ժ�ȯ��Ű�� ��
 *     - << (�ٿ�ĳ������_ Ŭ����_Ÿ��) ��ü�������� >> ��������, ��ȣ �ӿ� ĳ��Ʈ�ϰ���  �ϴ� Ŭ���� Ÿ���� ���
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
// ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
// ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), output()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age) {
		super(name, age);  
	}

	// �̸�, ����, �б���, �г��� �־����� �ʵ忡 �����ϴ� ��ü ������
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
	int classNo;   // ��
	int noInClass; // �ݿ����� ��ȣ

	// �ʵ��л��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
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

	// �߰�� �л��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
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

	// ���л��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// ������û�ϴ�
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

class Course {
	String courseNo;    // �����ȣ 
	String coursename;  // �����̸� 
	int credit;         // ������

	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_2_2_PersonMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ****  ��ü ���������� ���� Ŭ���� Ȯ���ϱ� ****");

		// ����� ���� Ŭ������ ������ ���� Ŭ������ ���� ���:
		//   Person ��ü �����Ͽ� Person ��ü ���������� ���� 
		Person p1 = new Person("ȫ�浿", 18);
		p1.goTo("�ݰ���");
		p1.output();

		// ����� ���� Ŭ������ ������ ���� Ŭ������ ���� ���:
		//   Student ��ü �����Ͽ� Student ��ü ���������� ���� 
		Student s1 = new Student("�迵��", 11, "�����ʵ��б�", 4);
		s1.goTo("��");
		s1.goToSchool();
		s1.output();
		
		// p2�� ����� ���� Ŭ������ ������ ���� Ŭ������ ���� ���� ���:
		//   ��ĳ����: ���� Ŭ���� ��ü�� ���� Ŭ���� Ÿ������ Ÿ�Ժ�ȯ
		//   Student ��ü �����Ͽ� Person ��ü �������� p2�� ������
		//   p2�� ����� ���� Ŭ����: Person, ������ ���� Ŭ����: Student
		Person p2 = new Student("��ö��", 23, "�ѱ����б�", 2);
		p2.goTo("��ȭ��");
		p2.output();
		
		// �ٿ�ĳ����: ���� Ŭ������ ��ü ���������� ���� Ŭ���� Ÿ������ ���� Ÿ�Ժ�ȯ
		((Student) p2).goToSchool(); // p2�� Student Ÿ������ ĳ��Ʈ�Ͽ� goToSchool() �޼ҵ� ȣ��
		
		// �ٿ�ĳ����: ���� Ŭ������ ��ü ���������� ���� Ŭ���� Ÿ������ ���� Ÿ�Ժ�ȯ
		Student s2 = (Student) p2;  // p2�� Student�� �ٿ�ĳ�����Ͽ� s2�� ����
		s2.goToSchool();            // s2�� ����� ���� Ŭ������ Student�� goToSchool() ȣ��
		s2.output();
		
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸��  ���� Ŭ������ ��ü ���������� ���� Ŭ���� ��ü�� ����� �� Ȯ���϶�.
 *   
 *   2) ��ĳ���õ� ��ü ���������� �ٿ�ĳ������ �Ͱ� ���� Ŭ������ �޼ҵ� ȣ�� Ȯ���϶�.
 *   
 *       ((Student) p2).goToSchool();  // p2�� Student�� �ٿ�ĳ�����Ͽ� goToSchool() ȣ��
 *       
 *       Student s2 =   (Student) p2;  // p2�� Student�� �ٿ�ĳ�����Ͽ� s2�� ����
 *       s2.goToSchool();              // s2�� ����� ���� Ŭ���� Student�� goToSchool() ȣ��
 *       
 *   3) ���α׷� �����ϰ� ��� Ȯ���϶�.
 *        
 *   
 * [ �ǽ� ���� ]
 * 
 *   o main()�� ���� �ڵ带 �ۼ��� �� �����Ͽ�  ��ĳ���ð� �ٿ�ĳ���� �ٽ� Ȯ���϶�.
 *   
 *     - �ڽ��� ��Ÿ���� UniversityStudent ��ü �����Ͽ� Person ��ü �������� p3�� ����
 *     
 *     - ģ���� ��Ÿ���� UniversityStudent �����Ͽ� Student ��ü �������� s3�� ����
 *     
 *     - p3�� s3�� UniversityStudent Ÿ������ �ٿ�ĳ�����Ͽ�  UniversityStudent ��ü
 *       �������� us1�� us2�� ����
 *       
 *     - output() �޼ҵ带 �̿��Ͽ� us1�� us2 ���
 */
