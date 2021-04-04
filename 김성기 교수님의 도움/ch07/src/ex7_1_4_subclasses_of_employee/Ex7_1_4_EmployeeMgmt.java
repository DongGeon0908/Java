package ex7_1_4_subclasses_of_employee;

/**
 * [ Employee Ŭ������ ���� ���� Ŭ���� ]: 
 *       Employee Ŭ������ ���� ���� Ŭ������ ����
 *  
 *   o ���� Ŭ������ �� �ٸ� ���� Ŭ������ ���� �� ����
 *    
 *   o Person Ŭ������ ���� Ŭ������ Employee Ŭ������ ���� ���� Ŭ������ ����
 *      
 *     - �̵� Student Ŭ������ ���� ���� Ŭ�������� Student Ŭ������ �ʵ�� �޼ҵ带 ��ӹ���
 *     - ���� �ʵ�� ���� �޼ҵ带 ���� �� ����
 */

// Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ���� Ŭ����
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

// Person Ŭ������ ���� Ŭ������ Employee�� ����
//  ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//  ���� Ư��: �ʵ� EmployeeType, empno, dateHired, �޼ҵ� goToWork()
class Employee extends Person {
	String empType;      // ��� ����: "������", "�ð���", "����" ���� �ϳ�
	int empno;           // �����ȣ 
	String dateHired;	 // �Ի��� 
	
	// ��ü ������: �־��� �̸�, ����, �������, �����ȣ, �Ի����� �ʵ忡 ����
	Employee(String name, int age, String empType, int empno, String dateHired) {
		super(name, age);   // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
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

// ������ ����� ��Ÿ���� Ŭ����
class RegularEmployee extends Employee {
	int annualSalary;  // ����(����: ����)
	int bonus;        // ���ʽ�(����: ����)

	// ������ ��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	RegularEmployee(String name, int age, int empno, String dateHired, int annualSalary, int bonus) {
		super(name, age, "������", empno, dateHired);  

		this.annualSalary = annualSalary;  this.bonus = bonus;
	}

	// getSalary(): ���޿��� ���Ͽ� ��ȯ�ϴ� �޼ҵ� 
	int getSalary() {
		return (this.annualSalary + bonus) / 12  * 10000;  // ���޿� = (���� + ���ʽ� ) /12
	}

	// output(): RegularEmployee ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ������ ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + ", ���Ÿ��:" + this.empType +
				", �����ȣ:" + this.empno + ", �Ի���:" + this.dateHired +
				"\n            ����: " + this.annualSalary + "����, ���ʽ�:" + this.bonus +
				", ���� : " + this.getSalary() + "��" );   
	}
}

// �ð��� ����� ��Ÿ���� Ŭ����
class PartTimeEmployee extends Employee {
	int payPerHour;		// �ð��� ����(����: ��)
	int hoursWork;  	// �ٹ��ð�

	// �ð��� ��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	PartTimeEmployee(String name, int age, int empno, String dateHired, int payPerHour) {
		super(name, age, "�ð���", empno, dateHired);  

		this.payPerHour = payPerHour; 
	}

	// setHoursWork((): �ٹ��ð��� �����ϴ� �޼ҵ�
	void setHoursWork(int hours) {
		this.hoursWork = hours;
	}

	// getSalary(): ���޿��� ���Ͽ� ��ȯ�ϴ� �޼ҵ�:  
	int getSalary() {
		return this.payPerHour * this.hoursWork; // ���޿� = �ð��� ���� * �ٹ��ð�
	}

	// output(): PartTimeEmployee ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * �ð��� ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + ", ���Ÿ��:" + this.empType +
				", �����ȣ:" + this.empno + ", �Ի���:" + this.dateHired +
				"\n            �ð��� ����: " + this.payPerHour + "��, �ٹ��ð�:" + this.hoursWork +
				", ���� : " + this.getSalary() + "��" );  
	}
}

// ���� ����� ��Ÿ���� Ŭ����
class Intern extends Employee {
	int monthsIntern;  // ���� ������
	int payIntern;     // ���ϼ���(����: ����)

	// ���� ��� ������ �־����� �ʵ忡 �����ϴ� ��ü ������
	Intern(String name, int age, int empno, String dateHired, int monthsIntern, int payIntern) {
		super(name, age, "����", empno, dateHired);  

		this.monthsIntern = monthsIntern;    this.payIntern = payIntern; 
	}

	// getSalary(): ���޿��� ���Ͽ� ��ȯ�ϴ� �޼ҵ� 
	int getSalary() {
		return this.payIntern / this.monthsIntern * 10000;// // ���޿� = ���ϼ��� / ���Ͽ���
	}

	// output(): PartTimeEmployee ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ���� ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + ", ���Ÿ��:" + this.empType +
				", �����ȣ:" + this.empno + ", �Ի���:" + this.dateHired +
				"\n            ���Ͽ���: " + this.monthsIntern + ", ���ϼ���:" + this.payIntern +
				"����, ���� : " + this.getSalary() + "��" );  
	}
}

class Ex7_1_4_EmployeeMgmt {
	
	public static void main(String[] args) {
		RegularEmployee rEmp;   // ������ ��� �ڹ����� ������ ��������
		PartTimeEmployee pEmp;  // �ð��� ��� ����� ������ ��������
		Intern iEmp;            // ���� ��� ��ö���� ������ ��������

		// 28���� �ڹ����� �����ȣ 1035, �Ի����� 20140301, ���� 4000����, ���ʽ� 800������ ������ �����
		rEmp = new RegularEmployee("�ڹ���", 28, 035, "20140301", 4000, 800);
		rEmp.goToWork();       // ���� Ŭ������ ����� �޼ҵ� ȣ��: �ڹ����� �����

		// 26���� ����� �����ȣ 1044, �Ի����� 20150301, �ð��� ���� 12000���� �ð��� �����
		pEmp = new PartTimeEmployee("���", 26, 2023, "20140301", 12000);
		pEmp.setHoursWork(200); // ���� �޼ҵ� ȣ��: ����� �̹� �޿� 200�ð� ����

		// 23���� ��ö���� �����ȣ 3018, �Ի����� 20160101, ���ϰ����� 2����, ���ϼ��� 200������ ���� �����
		iEmp = new Intern("��ö��", 23, 3018, "201160101", 2, 200);
		
		// �ڹ���, ���, ��ö���� �ʵ� ���� ��� ���
		rEmp.output();
		pEmp.output();
		iEmp.output();
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� Employee Ŭ������ ���� Ŭ������ �ʵ�� �޼ҵ忡 ���� �ľ��϶�.
 *   
 *   2) ������ ���, �ð��� ���, ���� � ���� ���޿��� ����ϱ� ���� �ʵ�� �޿� ������� �ٸ���. 
 *      �� ����� ���޿��� ���� �ʿ��� ��ҵ��� �����ϰ� ���� Ŭ��������  getSalary() �޼ҵ带 ���캸��.
 *   
 *   3) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   o �ڽ��� ������, �ð���, ���� ��� �� �ϳ��� �����Ͽ� main() �޼ҵ忡��  ��ü�� ������ �� 
 *     output() �޼ҵ带 �̿��Ͽ� ����϶�.
 */
