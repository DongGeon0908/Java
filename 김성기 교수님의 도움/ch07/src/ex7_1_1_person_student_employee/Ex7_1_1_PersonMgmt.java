package ex7_1_1_person_student_employee;

/**
 * [ Person, Student, Employee Ŭ���� ]: 
 *       Person Ŭ������ ���� Ŭ������ �������� ���� Student�� Employee Ŭ����
 * 
 *   o Person Ŭ����
 *     - �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ����
 *     
 *   o Student Ŭ����
 *     - Person Ŭ������ ���� ��� �ʵ�� �޼ҵ带 ���� 
 *     - �ʵ� schoolname, grade�� �޼ҵ� goToSchool()�� output()�� ���� Ư������ ����
 *     - goToSchool() �޼ҵ忡���� goTo() �޼ҵ带 ȣ���Ͽ� ����ġ�� �б������� ����
 *     
 *   o Employee Ŭ����
 *     - Person Ŭ������ ���� ��� �ʵ�� �޼ҵ带 ����
 *     - �ʵ� empType, empno, dateHired�� �޼ҵ� goToWork(), output()�� ���� Ư������ ����
 *     - goToWork() �޼ҵ忡���� goTo() �޼ҵ带 ȣ���Ͽ� ����ġ�� "ȸ��"�� ����
 */

// Person Ŭ����
//   �ʵ� name, age, currentLocation
//   �޼ҵ� goTo(), output()�� ���� Ŭ����
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
			", ����ġ:" + this.currentLocation);
	}
}

// Student Ŭ����
//   �ʵ�: name, age, currentLocation, schoolname, grade
//   �޼ҵ�: goTo(), goToSchool(), output()
class Student {
	String name; int age; String currentLocation; 
	String schoolname;   int grade;   // �б���, �г�

	Student(String name, int age, String schoolname, int grade) {  // �̸�, ����, �б���, �г��� �ʵ忡 �����ϴ� ��ü ������
		this.name = name;  this.age = age; 
		this.schoolname = schoolname; this.grade = grade;
	}

	void goTo(String location) {      // goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�
		this.currentLocation = location;
	}

	void goToSchool() {               // goToSchool(): �л��� ��ϴ� ���� ��Ÿ���� �޼ҵ�
		goTo(this.schoolname); 
	}

	// output(): Student ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �л� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + 
				", �б���:" + this.schoolname + ", �г�:" + this.grade);
	}
}

// Employee Ŭ����
//   �ʵ�: name, age, currentLocation, empType, empno, dateHired
//   �޼ҵ�: goTo(), goToWork(), output()
class Employee {
	String name; int age; String currentLocation; 
	
	String empType;     // ��� ����: "������", "�ð���", "����" ���� �ϳ�
	int empno;          // �����ȣ 
	String dateHired;   // �Ի��� 

	// ��ü ������: �־��� �̸�, ����, �������, �����ȣ, �Ի����� �ʵ忡 ����
	Employee(String name, int age, String empType, int empno, String dateHired) {
		this.name = name;  this.age = age; 
		this.empType = empType;   this.empno = empno; 
		this.dateHired = dateHired; 
	}

	void goTo(String location) {  // goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�
		this.currentLocation = location;
	}

	// goToWork(): ����ϴٸ� ��Ÿ���� �޼ҵ� 
	//    currentLocation�� "ȸ��"�� �����ϱ� ���� goTo() �޼ҵ� ȣ��
	void goToWork() {
		goTo("ȸ��"); 
	}

	// output(): Employee ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + ", ���Ÿ��:" + this.empType +
				", �����ȣ:" + this.empno + ", �Ի���:" + this.dateHired);
	}
}

class Ex7_1_1_PersonMgmt {
	public static void main(String[] args) {
		// �迵��� �ڹ��� ��ü �����ϱ� ���� ���� ����
		Student  yhkim;
		Employee mspark;

		// 11���� �迵��� �����ʵ��б� 4�г� �л��� 
		yhkim = new Student("�迵��", 11, "�����ʵ��б�", 4);
		yhkim.goTo("�����ʵ��б�"); // �迵�� �����ʵ��б��� ��

		// 28���� �ڹ����� �����ȣ 1035, �Ի����� 20140301�� ������ �����    
		mspark = new Employee("�ڹ���", 28, "������", 1035, "20140301");
		mspark.goToWork();      // �ڹ����� �����

		// �迵��� �ڹ����� �ʵ� ���� ��� ���
		yhkim.output();
		mspark.output();
	}
}

/*
 * 
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� Person, Student, Employee Ŭ������ �ߺ��� �κ��� Ȯ���϶�.
 *   
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *    
 * [ �ǽ� ���� ]
 * 
 *   1) Person Ŭ������ �ּ� ��Ÿ���� �ʵ� addr �߰��ϴ� ��� Person, Student, Employee
 *      Ŭ�������� ������ �κ� Ȯ���ϰ� �����϶�.
 *      
 *   2) Student Ŭ������  ������ �ʵ�� �޼ҵ� �ܿ� �й� sno, �� classNo, �ݿ����� ��ȣ noInClass �ʵ�� 
 *      ���ο� output() �޼ҵ带 ����  ���л� Ŭ���� middleStudent�� �߰��� �ۼ��ϰ� PersonMgmt Ŭ������ 
 *      main()����  middleStudent ��ü�� ������ ���� �����ϰ� ����϶�.
 *     
          // 14���� �迵���� �������б� 2�г� �л�����, �й��� 20170203, ���� 2, ��ȣ�� 3��
          MiddleStudent mst = new MiddleStudent("�迵��", 14, "�������б�", 2, 20170203, 2, 3); 
          mst.output();
 */
 