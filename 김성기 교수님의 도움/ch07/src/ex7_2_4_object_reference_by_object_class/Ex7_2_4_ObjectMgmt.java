package ex7_2_4_object_reference_by_object_class;

/**
 * [ Person, Student, ObjectMgmt Ŭ���� ]: 
 *       Object Ŭ������ ��ü ���������� Ȱ��
 *  
 *   o Object Ŭ����
 *     - ��� Ŭ������ ���� Ŭ�����̸�, ���� Ŭ������ ���� �ֻ��� Ŭ����
 *     - ���� Ŭ������ ��õ��� ���� Ŭ������ Object Ŭ������ ���� Ŭ����
 *    
 *   o Object Ŭ������ ��ü ��������
 *     - ��� Ÿ���� ��ü�� ��ĳ���ý��� ������ �� ����
 *     - �׷��Ƿ� ��� ��ü�� ������ �� ����
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
//  ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, �޼ҵ� goTo()
//  ���� Ư��: �ʵ� schoolname, grade, �޼ҵ� goToSchool(), output()
class Student extends Person {
	String schoolname;  // �б���
	int    grade;				  // �г�

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

class Ex7_2_4_ObjectMgmt {
	public static void main(String[] args) {
		System.out.println("\n  **  Object Ŭ������ ��ü ���������� ��ü �����ϱ� **");

		Object obj1, obj2, obj3;
		obj1 = new Student("�迵��", 11, "�����ʵ��б�", 4);  // Object Ŭ������ ������������Student Ÿ���� ���� ���� ����
		obj2 = "I like Java!";       // Object Ŭ������ ������������ String Ÿ���� ���� ���� ����
		obj3 = 1;                    // Object Ŭ������ ������������ �⺻ Ÿ���� ���� ���� 1�� ���� ����

		System.out.println("\n  * obj1 = " + obj1 + ", obj2 = " + obj2 + ", obj3 = " + obj3);
	
		
		System.out.println("\n\n  **  Object Ŭ������ �迭������ ��ü �����ϱ� **");

		Object[] objs = new Object[10];   // 10���� Object ��ü�� �����ϴ� �迭���� ���� 
		
		objs[0] = new Student("�迵��", 11, "�����ʵ��б�", 4);   // ���ҿ� Student ��ü ����
		objs[1] = "I like Java!";                            // ���ҿ� ���ڿ� ��ü ����
		objs[2] = 1;                                         // ���ҿ� ����  ����, �����δ� ���� ��ü�� �����				

		for (int i=0; i < 3; i++)
			System.out.println("\n  * obj[" + i + "] = " + objs[i] );
	}
}

/*
* [ ���α׷� ���� �� ���� ]
* 
*   1) ���� 7-2-4 ���α׷��� ���캸�� Object Ŭ������ ��ü ���������� Student ��ü, String ��ü, 1�� ������� Ȯ���϶�.
*      
*   2) Object Ŭ������ �迭���� ���ҿ� Student ��ü, String ��ü, 1�� ������� Ȯ���϶�.
*   
*   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
*   
*   
* [ �ǽ����� ]
* 
*   o ������ �����Ͽ� ��� Ȯ���϶�.
*   
*      (1) main() �޼ҵ忡 �ڽ��� ��Ÿ���� Person ��ü�� �����Ͽ� Object ��ü �������� obj2�� �����϶�.
*      
*      (2) obj2�� �迭���� objs[3]�� �����϶�.
*      
*      (3) obj2�� objs[3]�� output() �޼ҵ带 �̿��Ͽ� ����϶�.
*/
