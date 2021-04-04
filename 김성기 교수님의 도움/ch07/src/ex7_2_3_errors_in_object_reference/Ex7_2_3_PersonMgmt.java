package ex7_2_3_errors_in_object_reference;

/**
 * [ Person, Student, Car, PersonMgmt Ŭ���� ]: 
 *       ��ĳ���� �� �ٿ�ĳ���ÿ����� ��ü ���� ������ ���̴� ����
 *  
 *   o ��ĳ����(upcasting)
 *     - Java���� ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���ҵ� ��
 *     - ��ĳ����: ���� Ŭ���� ��ü�� Ÿ���� ���� Ŭ���� Ÿ������ ��ȯ��Ű�� ��
 *     - ��ĳ������ ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���������� �����ϱ� ���� �ʿ���
 *    
 *   o �ٿ�ĳ����(downcasting)
 *     - ��ĳ���õ� ��ü�� �����ϴ� ��ü ���������� ���� Ŭ���� Ÿ������ ����������  Ÿ�Ժ�ȯ��Ű�� ��
 *     - << (�ٿ�ĳ����_ Ŭ����_Ÿ��) ��ü�������� >> ��������, ��ȣ �ӿ� ĳ��Ʈ�ϰ���  �ϴ� Ŭ���� Ÿ���� �����
 *    
 *   o ��ĳ���� �� �ٿ�ĳ���ÿ����� ��ü ���� ���� �߻���
 *     - ������  ����: �����Ϸ��� �߸��� ��ü ������ �˷���
 *     - ����ð� ����: ����������� �߸��� ��ü ������ �˷���
 */

//Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo()�� ���� Ŭ����
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

//Person Ŭ������ ���� Ŭ������ Student�� ����
//��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), output()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;		// �г�

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

class Car {
	String carNo;   // �ڵ��ڹ�ȣ 
	String carname; // �ڵ����� 
    String owner;   // ������
}

class Ex7_2_3_PersonMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ****  ��ü ���������� ���� Ȯ���ϱ� ****");

		Person p1 = new Car();       			// ������ ����: Car Ŭ������ Person�� ���� Ŭ���� �ƴ�
		Student s1 = new Person("ȫ�浿", 18); 	// ������ ����: Person�� Student Ŭ������ ���� Ŭ���� �ƴ�

		Student s2  = new Student("�迵��", 11, "�����ʵ��б�", 4); 
		((Person) s2).goToSchool();				// ������ ����: s2�� Person Ÿ������ ��ĳ���ý��� 
												//           Student�� goToSchool() ȣ�� �Ұ�
		
		Person p2 = s2;            				// s2�� ��ĳ���ý��� ���� Ŭ���� �������� p2�� ����
		p2.goToSchool();            			// ������ ����: Person p2�� goToSchool() ȣ�� �Ұ�

		Person p3 = new Person("�ڹ���", 23);
		((Student) p3).goToSchool();			// ����ð� ����: p3�� ������ ���� Ŭ������ Person�̹Ƿ� 
												//            Student�� �ٿ�ĳ���ý�ų �� ����
	}
}

/*
* [ ���α׷� ���� �� ���� ]
* 
*   1) ���α׷��� ���캸�� �߸��� �κе��� Ȯ���ϰ� �ùٸ� ���α׷����� �����϶�.
*   
*   2) Ư��, ��ĳ���õ� ��� ���� ���� ��ü�� ��������� ���� Ŭ������ �ʵ峪 �޼ҵ� ������  
*      �Ұ������� Ȯ���϶�.
*      
*      Student s2 = new Student("�迵��", 11, "��", "�����ʵ��б�", 4); 
*      ((Person) s2).goToSchool();   // ������ ����: s2�� Person Ÿ������ ��ĳ���ý��� 
*                                    //              Student�� goToSchool() ȣ�� �Ұ�
*                                    
*   3) ������ ���α׷� �����Ͽ� ���� ���� ����� Ȯ���϶�.
*       
*   4) p2, s1, s2 ��ü���� output() �޼ҵ带 �̿��Ͽ� ����ϵ��� ���α׷��� �����ϰ� �����ϰ� ����� Ȯ���϶�.
*/
