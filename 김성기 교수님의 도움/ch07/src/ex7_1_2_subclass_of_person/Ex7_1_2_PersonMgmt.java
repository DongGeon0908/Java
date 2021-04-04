package ex7_1_2_subclass_of_person;

/**
 * [ Person Ŭ������ ���� Ŭ������ ]: Person Ŭ������ ���� Ŭ������ Student�� Employee
 * 
 *   o Person Ŭ����
 *     - �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ����
 *     
 *   o Student Ŭ����
 *     - Person Ŭ������ Ȯ���� ���� Ŭ����
 *     - Person Ŭ������ ��� �ʵ�� �޼ҵ带 ��ӹ����Ƿ� ����Ǿ� ������ ������ 
 *       Person Ŭ������ �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ����
 *       
 *     - �ʵ� schoolname, grade�� �޼ҵ� goToSchool()�� output()�� ���� Ư������ ����
 *     - goToSchool() �޼ҵ忡���� goTo() �޼ҵ带 ȣ���Ͽ� ����ġ�� �б������� ����
 *     
 *   o Employee Ŭ����
 *     - Person Ŭ������ Ȯ���� ���� Ŭ����
 *     - Person Ŭ������ ��� �ʵ�� �޼ҵ带 ��ӹ����Ƿ� ����Ǿ� ������ ������ 
 *       �ڵ������� Person Ŭ������ �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ����
 *       
 *     - �ʵ� empType, empno, dateHired�� �޼ҵ� goToWork(), output()�� ���� Ư������ ����
 *     - goToWork() �޼ҵ忡���� goTo() �޼ҵ带 ȣ���Ͽ� ����ġ�� "ȸ��"�� ����
 */

// Person Ŭ����
//  �ʵ� name, age, currentLocation
//  �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;

	Person() {  // �Ű����� ���� ��ü ������
	}

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
//   ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

	// �̸�, ����, �б���, �г��� �־����� �ʵ忡 �����ϴ� ��ü ������
	Student(String name, int age, String schoolname, int grade) {
		this.name = name;  this.age = age; 
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): �л��� ��ϴ� ���� ��Ÿ���� �޼ҵ�
	//    currentLocation�� schoolname���� �����ϱ� ���� goTo() �޼ҵ� ȣ��
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

// Person Ŭ������ ���� Ŭ������ Employee�� ����
//   ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//   ���� Ư��: �ʵ� EmployeeType, empno, dateHired, �޼ҵ� goToWork()
class Employee extends Person {
	String empType;    // ��� ����: "������", "�ð���", "����" ���� �ϳ�
	int empno;         // �����ȣ 
	String dateHired;  // �Ի��� 

	// ��ü ������: �־��� �̸�, ����, �������, �����ȣ, �Ի����� �ʵ忡 ����
	Employee(String name, int age, String empType, int empno, String dateHired) {
		this.name = name;  this.age = age; 
		this.empType = empType;   this.empno = empno; 
		this.dateHired = dateHired; 
	}

	// goToWork(): ����ϴٸ� ��Ÿ���� �޼ҵ� 
	//    currentLocation�� ��ȸ�硱�� �����ϱ� ���� goTo() �޼ҵ� ȣ��
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

class Ex7_1_2_PersonMgmt {
	public static void main(String[] args) {
		// �迵��� �ڹ��� ��ü �����ϱ� ���� ���� ����
		Student st;
		Employee emp;

		st = new Student("�迵��", 11, "�����ʵ��б�", 4); // 11�� �迵�� �����ʵ� 4�г�  
		st.goTo("�����ʵ��б�"); // ��� �޼ҵ� ȣ��: �迵�� �����ʵ��б��� ��

		// 28���� �ڹ����� �����ȣ 1035, �Ի����� 20140301�� ������ �����    
		emp = new Employee("�ڹ���", 28, "������", 1035, "20140301");
		emp.goToWork();      // ����� ���� �޼ҵ� ȣ��: �ڹ����� �����

		// �迵��� �ڹ����� �ʵ� ���� ��� ���
		st.output();          
		emp.output();
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� Student Ŭ������ Employee Ŭ�������� ������� �ʾ����� 
 *      ���Ǵ� �ʵ�� �޼ҵ带 Ȯ���϶�.
 *      
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) Person Ŭ������ �ּ� ��Ÿ���� �ʵ� addr �߰��ϴ� ��� Person, Student, Employee
 *      Ŭ�������� ������ �κ� Ȯ���ϰ� �����϶�. 
 *   
 *   2) Person Ŭ������  ������ �ʵ�� �޼ҵ� �ܿ� �ǻ�����ȣ licenseNo, �����о�  major �ʵ��
 *      ���ο� output() �޼ҵ带 ����  �ǻ� Ŭ���� Doctor�� �߰��� �ۼ��ϰ�  
 *      PersonMgmt Ŭ������ main()���� Doctor ��ü�� ������ ���� �����ϰ� ����϶�.
 *      
           // 34���� �迵���� �ǻ�����ȣ 2010123�� ���� �����о��� �ǻ�
           Doctor yskim = new Doctor("�迵��", 34, 20100123, "����"); 
           yskim.output();
 *      
 *   3) Person Ŭ������ �Ǵٸ� ���� Ŭ������  ����, ������, �丮��, ������ Ŭ���� ���� �ִ�.
 *      �̵� Ŭ������ ���� �ʵ带 �����Ͽ� Person Ŭ������ ���� Ŭ������ �ۼ��϶�.
 *      
 *      �� Ŭ������ ��ü �����ڿ� �ʵ带 ����ϴ� ���ο� output() �޼ҵ带 �ۼ��ؾ� �Ѵ�.
 *      PersonMgmt Ŭ������ main()���� �̵� Ŭ������ ��ü�� �����ϰ� output() �޼ҵ带
 *      �̿��Ͽ� ����϶�.     
 */
