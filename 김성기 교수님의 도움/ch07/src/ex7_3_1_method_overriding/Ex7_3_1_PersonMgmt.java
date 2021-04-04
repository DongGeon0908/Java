package ex7_3_1_method_overriding;

/**
 * [ ex7_3_1_MethodOverriding ��Ű�� ]: �޼ҵ� �������̵��� �����ִ�  ����
 *  
 *   o �޼ҵ� �������̵�
 *     - ���� Ŭ������ ������ �� ���� Ŭ������ �޼ҵ带 ��ü�� �� �ִ� �޼ҵ带 �������ϴ� ��
 *     - ���� Ŭ������ ����� �޼ҵ�� �̸�, �Ű�����, ��ȯ Ÿ���� ��� �����ϸ鼭 
 *       �޼ҵ��� ������ �ٸ� �޼ҵ� ���� 
 *     - �޼ҵ� �������̵� ���: ���� Ŭ������ �޼ҵ� ó�������� ���� Ŭ������ ��Ȳ�� �µ��� ������ �� �ְ� ��
 *    
 *   o �޼ҵ� �������̵��� ��: Person Ŭ������ output() �޼ҵ�
 *     - name, age, currentLocation �ʵ带 ����ϴ� �޼ҵ�
 *     - Student Ŭ�������� �̸� ��ӹ޾� �״�� ����ϸ� Student�� ���� �ʵ��� schoolname�� grade �ʵ带 
 *       ����� �� ���� ��
 *     - Student Ŭ������ ��� �ʵ带 ����ϱ� ���ؼ��� ���� Ŭ������ Person�� output() �޼ҵ�δ� ������� ����
 *     - schoolname�� grade �ʵ带 �߰��� ����ϱ� ���� Student Ŭ�������� output() �޼ҵ带 ���ۼ��Ͽ��� ��
 */

// Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
	String name;    		// �̸�
	int    age;				// ����
	String currentLocation;	// ����ġ

	// �Ű����� ���� ��ü ������
	Person() {
	}

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}
	
	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}

	// ��ü�� �ʵ�� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��� - �̸�: " + this.name + ", ����: " + this.age 
				+ ", ����ġ: " + this.currentLocation);
	}
}

// Person Ŭ������ ���� Ŭ������ Student�� ����
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

	// ��ü�� �ʵ�� ����ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵���Ų ����
	void output() {
		System.out.println("\n  * �л� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation + 
				", �б���:" + this.schoolname + ", �г�:" + this.grade);
	}
}

class Ex7_3_1_PersonMgmt {
	public static void main(String[] args) {

		// 18���� ȫ�浿
		Person p1 = new Person("ȫ�浿", 18); 
		p1.goTo("�ݰ���");

		// �迵��� 11���� �����ʵ��б� 4�г� �л�
		Student s1 = new Student("�迵��", 11, "�����ʵ��б�", 4);
		s1.goToSchool();

		// ��ö���� 21���� �ѱ����б� 2�г� �л�
		Person p2= new Student("��ö��", 21, "�ѱ����б�", 2); // ��ĳ�����Ͽ� Person ������ ����
		p2.goTo ("������");

		// ȫ�浿, �迵��, ��ö���� �Ż������� output() �޼ҵ�� ���
		p1.output();   // Person Ŭ������ output() �޼ҵ� ȣ��
		s1.output();   // Student Ŭ������ output() �޼ҵ� ȣ��

		p2.output();   // Person Ŭ������ output() �޼ҵ� ȣ��(���� ����Ǵ� �޼ҵ�� ?)       

		System.out.println("\n  * ȫ�浿 - " + p1); // ȫ�浿, �迵��, ��ö�� ��ü��  system.out.println �޼ҵ�� ���
		System.out.println("\n  * �迵�� - " + s1); 
		System.out.println("\n  * ��ö�� - " + p2); 
   }
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� ������ output() �޼ҵ尡 Person Ŭ������ Student Ŭ������ 
 *      ��� �ۼ��Ǿ����� Ȯ���϶�.
 *      
 *   2) << Person p2 = new Student("��ö��", 23, "�ѱ����б�", 2); >>����
 *      p2���� Student ��ü�� ��ĳ���õǾ� ����Ǿ� �ִ�.
 *       
 *      �� ��� �������̵� �޼ҵ� p2.output()�� ȣ�� ����� person�� output()���� Student��
 *      output()���� �������� Ȯ���� �� �ִ�
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *      �������̵� �޼ҵ� p2.output()�� ȣ��� ����Ǵ� �޼ҵ尡 Student�� output() �޼ҵ����� �ݵ�� Ȯ���϶�.
 * 
 */
