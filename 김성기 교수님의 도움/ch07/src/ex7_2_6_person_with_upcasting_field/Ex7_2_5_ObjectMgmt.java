package ex7_2_6_person_with_upcasting_field;

/**
 * [ Person, Student, ObjectMgmt Ŭ����  ]: ���ɽ����� �ʿ伺�� �����ִ�  ����
 *  
 *   o ��ĳ����(upcasting)
 *     - Java���� ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���ҵ� ��
 *     - ��ĳ����: ���� Ŭ���� ��ü�� Ÿ���� ���� Ŭ���� Ÿ������ ��ȯ��Ű�� ��
 *     - ��ĳ������ ���� Ŭ���� ��ü�� ���� Ŭ������ ��ü ���������� �����ϱ� ���� �ʿ���
 *    
 *   o Person Ŭ������ ģ���� ��Ÿ���� friend �ʵ�
 *     - << Person friend; >>�� ����ǹǷ� Person ��ü ���� ������
 *     - �׷���, ģ���� Person Ŭ���� ��ü�� �ƴ϶� ���� Ŭ���� ��ü�� �� �� ����
 *    
 *   o Person Ŭ������ ������ ���� ����� ��Ÿ���� personLastMet �ʵ�   
 *     - << Person personLastMe; >>�� ����ǹǷ� Person ��ü ���� ������
 *     - �׷���, ������ ���� �����  Person Ŭ���� ��ü�� �ƴ϶� ���� Ŭ���� ��ü�� �� �� ����
 *
 *   o Person Ŭ������ �����ٸ� ��Ÿ���� �޼ҵ� << void meets(Person p) >>������ �Ű����� p 
 *     - �Ű����� p�� personLastMet �ʵ� ���� ����
 *     - �Ű����� p�� Person ��ü �� �ƴ϶� Person�� ���� ��ü�� ���� ������
 */

// Person Ŭ����: �ʵ� name, age, currentLocation�� �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;
  	Person friend;	// ģ���� �����ϴ� �ʵ�: ģ���� Person Ŭ������ ��ü�� 
                    //   �ƴ϶� ���� Ŭ���� ��ü�� �� �� ����

  	Person  personLastMet;   // ���������� ���� ����� �����ϴ� �ʵ�:  ������ ���� ����� Person Ŭ������ ��ü�� 
                             //   �ƴ϶� ���� Ŭ���� ��ü�� �� �� ����

	// �̸�, ���̰� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
    void meets(Person p) {   // �����ٸ� ��Ÿ���� �޼ҵ�: personLastMet �ʵ� ���� �־��� p�� ����
        personLastMet = p;   //   �Ű����� p���� Person ��ü �� �ƴ϶� Person�� ���� ��ü�� ����  ������
    }
	
	// output(): Person ��ü�� ��� �ʵ� �� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��� - �̸�:" + this.name + ", ����:" + this.age + ", ����ġ:" + this.currentLocation
				 + ", ģ�� �̸�: " + ((this.friend != null) ? this.friend.name : "����" ) 
				 + ", ������ ���� ����̸�: " + ((this.personLastMet != null) ? this.personLastMet.name : "����" ));
	}
} 

// Person Ŭ������ ���� Ŭ������ Student�� ����
//   ��� Ư��: Person Ŭ������ �ʵ��� name, age, currentLocation, friend, personLastMet, �޼ҵ� goTo()
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
		System.out.println("\n  * �л� - �̸�:" + this.name + ", ����:" + this.age + ", ����ġ:" + this.currentLocation
				 + ", ģ�� �̸�: " + ((this.friend != null) ? this.friend.name : "����" ) 
				 + ", ������ ���� ����̸�: " + ((this.personLastMet != null) ? this.personLastMet.name : "����" )
		    	 + ", �б���:" + this.schoolname + ", �г�:" + this.grade);
	}
}

class Ex7_2_5_ObjectMgmt {
	public static void main(String[] args) {
		Person p = new Person("�̸���", 20); // 20�� �̸����� ����
		Student s1 = new Student("��ö��", 23, "�ѱ����б�", 3); 
		Student s2 = new Student("������", 21, "�ѱ����б�", 3); 

		// �̸���� ��ö���� ģ�� �������� ��Ÿ���� �ڵ�
		p.friend = s1;   // p�� friend �ʵ�� Student ��ü�� s1�� ����(��ĳ����)
		s1.friend = p; 	 // s1�� friend �ʵ�� Person ��ü�� p�� ����

		// �̸���� �������� ���� �����ٴ� ���� ��Ÿ���� ���� �ڵ�
		p.meets(s2);    // meet() �޼ҵ��� �Ű������� Student ��ü�� s2(��ĳ����)
		s2.meets(p);    // meet() �޼ҵ��� �Ű������� Person ��ü�� p

		System.out.println("\n  * " + p.name + "�� ģ��: " + p.friend.name);
		System.out.println("\n  * " + s1.name + "�� ģ��: " + s1.friend.name);

		System.out.println("\n  * " + p.name + "�� ������ ���� ���: "                                                                                                                    
				+ p.personLastMet.name);
		System.out.println("\n  * " + s2.name + "�� ������ ���� ���: " 
				+ s2.personLastMet.name);

		p.output();
		s1.output();
		s2.output();
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���α׷��� ���캸�� friend, PersonLastMet �ʵ��  meet() �޼ҵ��� �Ű����� p�� Person ��ü �ܿ� 
 *      Student ��ü�� ������� Ȯ���϶�.
 *      
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 * 
 * [ �ǽ� ���� ]
 * 
 *   1) ���� �۾��� ������ �� ��ü�� ����϶�.
 *   
 *      (1) main()����  �ڽ��� ��Ÿ���� Student ��ü�� ģ����  Student ��ü�� �߰��� �����϶�.
 *      
 *      (2) �ڽŰ� ģ�� ��ü ���̿� ģ������  ��Ÿ������  friend �ʵ忡 ���� ���� �����϶�.
 *      
 *      (3) �ڽŰ� ģ���� ���� ���� ��Ÿ���� meet() �޼ҵ带 ���� ȣ���϶�.
 *      
 *      (4) �ڽŰ� ģ�� ��ü�� ����Ͽ� ��� Ȯ���϶�.
 *      
 *   2) Person Ŭ������ friend �ʵ忡 ģ�� ��ü�� ���� �����Ѵ�. �̴� ���� ���� �ڵ� ����̴�.
 *      �̸� �����ϱ� ���� ������ �۾��� �����϶�.
 *      
 *      (1) Person Ŭ������ ģ�� �����ϴ� �޼ҵ���  void isFriendWith(Person friend)�� �ۼ��϶�.
 *      
 *      (2) main() �޼ҵ忡�� ģ���� �ʵ忡 �����ϴ� �ڵ带  �� �޼ҵ� ȣ��� �����϶�.
 */
