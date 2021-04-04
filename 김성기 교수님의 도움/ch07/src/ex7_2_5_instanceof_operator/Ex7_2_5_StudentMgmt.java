package ex7_2_5_instanceof_operator;

/**
 * [ Person Ŭ������ ���� ���� Ŭ������ ]: Ÿ�� Ȯ�� ������ instanceof Ȱ���ϴ� ����
 *  
 *   o instanceof ������
 *     - �� ���� �ǿ����� ������ ������
 *     - ����: ��ü�������� instanceof Ŭ����
 *     - ���� ���: ������ ��ü���������� ����� ��ü�� ������ Ŭ������ ��ü �Ǵ� 
 *               �� Ŭ������ ���� Ŭ���� ��ü�̸� true, �ƴϸ� false ��ȯ
 */

//Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo()��, output()�� ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): ������ ��ü�� �־��� ��ġ�� �̵��ϴ� �� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	// output(): Person ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation);
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

	// goToSchool(): �л��� ��ϴ� �� ��Ÿ���� �޼ҵ�
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

// Student Ŭ������ ���� Ŭ������ ���л��� ��Ÿ���� UniversityStudent Ŭ����
class UniversityStudent extends Student {
	int sno;		// �й�
	String dept;	// �а�
	Course enrolledCourses[] = new Course[100];  	// ���������
	int cntCourses = 0;                             // �������� ����

	// ���л� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// ������û�ϴ�
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

class Ex7_2_5_StudentMgmt {
	public static void main(String[] args) {
	
        Person p1 = new Student("�迵��", 11, "�����ʵ��б�", 4);
        if (p1 instanceof Student)	    // instanceof �������� ��: p1�� Student�� ��ü�̸� 
           ((Student) p1).goToSchool(); //    p1�� Student�� �ٿ�ĳ�����Ͽ� goToSchool() ȣ��

        Person p2 = new UniversityStudent("��ö��", 23,
        	                       "�ѱ����б�",3, 201611001, "��ǻ�Ͱ���");

        if (p2 instanceof Student)	    // instanceof �������� ��: p2�� Student�� ��ü�̸� 
           ((Student) p2).goToSchool(); //    p2�� Student�� �ٿ�ĳ�����Ͽ� goToSchool() ȣ��

        if (p2 instanceof UniversityStudent)  // p2�� UniversityStudent�� ��ü�̸� Student�� �ٿ�ĳ���� ����
           ((UniversityStudent) p2).enrolCourse(new Course("CS201", "Java ���α׷���", 3));        
 
        // �迵��, ��ö���� �ʵ� ���� ��� ���
        p1.output();
        p2.output();
    }    
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� ��ĳ���õ� ��� ���� ���� Ŭ���� ��ü�� �������   Ȯ���϶�.
 *   
 *   2) instanceof �������� ����� Ȯ���϶�.
 *   
 *      - p1 instanceof Student ==> (Student ��ü) instanceof Student ==> true
 *      
 *      - p2 instanceof Student ==> (UniversityStudent ��ü) instanceof Student 
 *                              ==> (Student ���� Ŭ���� ��ü) instanceof Student ==> true
 *                              
 *      - p2 instanceof UniversityStudent 
 *            ==> (UniversityStudent ��ü) instanceof UniversityStudent 
 *            ==> true
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   o ���� ������ ����� ���ϰ� System.out.prinln()�� �̿��Ͽ�  ����� Ȯ���϶�.
 *   
 *     - p1 instanceof Person
 *     
 *     - p1 instanceof UniversityStudent
 *     
 *     - p2 instanceof Person
 *     
 *     - p2 instanceof Object
 *     
 *     - (new Person("�ڹ���",  28)) instanceof Student
 */
