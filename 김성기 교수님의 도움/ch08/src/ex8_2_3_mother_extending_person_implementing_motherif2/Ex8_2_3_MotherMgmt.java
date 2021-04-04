package ex8_2_3_mother_extending_person_implementing_motherif2;

/**
 * [ Person, Female, MotherIF, Mother, MotherMgmt �������̽� ��  Ŭ���� ] :
 *        Ŭ���� Ȯ���ϸ鼭 �������̽� �����ϴ� ���� Ŭ���� Mother�� �ۼ��� ����
 * 
 *   o ���� 8-2-2���� ������ �޼ҵ尡 �߰���
 *     - public String toString() �޼ҵ�: Mother Ŭ������ �߰�
 *     - void output() �޼ҵ�: Mother Ŭ������ �߰�
 * 
 *   o �������̽�(interface)�� �ʵ�� �޼ҵ�
 *     - �ʵ�δ� public static final �ʵ常 ���� �� ����
 *     - �޼ҵ�δ� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ� ���� �� ����
 *     
 *   o �������̽�(interface)�� Ư¡
 *     - ��ü ������ �� ������, �����ϴ� ���� Ŭ�������� ��ü ���� ����
 *     - �������̽� �����ϴ� ���� Ŭ������ �ݵ�� abstract �޼ҵ� �����ؾ� ��
 *     - �������̽��� Ÿ������ ���Ǿ� �������̽� ��ü ���������� ������ �� ����
 *     - �������̽� ��ü ���������� ���� Ŭ������ ��ü�� ������
 *     - �������̽� �����ϴ� ���� ���� Ŭ������ ��ü�� �������̽��� ��ü�� �ǹǷ� ���������� ������ �� ����
 *     
 *   o Ŭ���� Ȯ���ϸ鼭 �������̽� �����ϴ� ���� Ŭ����
 *     - Ŭ���� Ȯ���ϴ� ���� Ŭ������ ���� �������̽� ������ �� ����
 *     - �������̽� �����ϴ� Ŭ������ �������̽��� ���� Ŭ����, �������̽��� �� Ŭ������ ���� �������̽��� ��
 *     - �������̽� �����ϴ� ���� Ŭ������ �ݵ�� ���� �������̽��� abstract �޼ҵ� �����ؾ� ��
 *     - �������̽� �����ϴ� ���� Ŭ���� ��ü�� ���� Ŭ���� Ÿ�� �� �ƴ϶� ���� �������̽� Ÿ�Ե� ������ �ǹǷ� 
 *       ���� �������̽��� ��ü ���������� ����Ǿ� ������ �� ����  
 */

// Person Ŭ����
//   �ʵ� name, age, currentLocation
//   �޼ҵ� goTo(), output()�� ���� Ŭ����
class Person {
	String name;     int age;     String currentLocation;

	// �̸�, ����, ��Ұ� �־����� �ʵ忡 �����ϴ� ��ü ������
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): ������ ��ü�� Ư�� ��ġ�� �̵��ϴ� ���� ��Ÿ���� �޼ҵ�.
	void goTo(String location) {
		this.currentLocation = location;
	}

	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Object Ŭ������ �޼ҵ带 �������̵���Ų ����
	public String toString() {
		return "�̸�: " + this.name + ", ����: " + this.age 
				+ ", ����ġ: " + this.currentLocation;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("  * ��� - " + this.toString());
	}
}

//������ ��Ÿ���� �������̽�
interface Female { 
	public static final String gender = "����"; 	// public static final�� �����ص� �� 
	
	public default String getGender(){ // ������ ��ȯ�ϴ� default �޼ҵ�
		return gender;
	}	
}

//��Ӵϸ� ��Ÿ����, Female�� ���� �������̽� MotherIF
interface MotherIF extends Female { 
	public void setChild(Person p);	// Person ��ü p�� �ڽ����� ����ϴ� �޼ҵ�
	public Person[] getChildren();  // �ڳ���� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
	public int getNoChildren();    	// �ڳ���� ��ȯ�ϴ� �޼ҵ�  
	
	default boolean isMotherOf(Person c) {  // �־��� Person ��ü c�� ��� ���� �˻��ϴ� default �޼ҵ�
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// Person Ŭ���� Ȯ���ϸ鼭 MotherIF �������̽� ���ÿ� �����ϴ� Mother Ŭ����
//   ���� Ŭ������ Person Ŭ������ �ʵ�� �޼ҵ� ��ӹ���
//   ���� �������̽��� MotherIF�� abstract �޼ҵ带 ��� ������
class Mother extends Person implements MotherIF { 

	Mother(String name, int age) {
		super(name, age);  // ���� Ŭ���� Person�� ��ü ������ ȣ��
	}	

	/*
	 * MotherIF �������̽��� abstract �޼ҵ带 �����ϱ� ���� �ڵ�
	 */

	Person[] children = new Person[20]; // �ִ� 20���� �ڳฦ ������ �� �ִ� �迭
	int noChildren = 0;

	// MotherIF�� abstract �޼ҵ� setChild()�� ����
	//   �־��� Person ��ü�� �ڳ�� �����ϴ� �޼ҵ�
	public void setChild(Person p) {
		children[noChildren++] = p;
	}

	// MotherIF�� abstract �޼ҵ� getChildren()�� ����
	//   �ڳ���� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
	public Person[] getChildren() {
		Person[] cs = new Person[noChildren];  // �ڳ�� ������ Person �迭 cs ����

		for (int i= 0; i < noChildren; i++)    // ��� �ڳ� ��ü�� cs[]�� ����
			cs[i] = children[i];

		return cs;
	}

	// MotherIF�� abstract �޼ҵ� getNoChildren()�� ����
	//   �ڳ���� ��ȯ�ϴ� �޼ҵ�
	public int getNoChildren() {
		return noChildren;
	}	
		
	// Mother Ŭ������ ��� �ʵ带 ���ڿ��� ��ȯ�ϴ� �������̵� �޼ҵ�
	//   �ڳ�� ������ [ �ڳ�1 ] [ �ڳ�2 ] ���� �������� ���ڿ��� ������
	public String toString() {
		int no = getNoChildren();    // �ڳ���� no ������ ����
		
		String s = super.toString(); // Person Ŭ������ ��� �ʵ带 ���ڿ��� ����
		
		s = s + ", ����: " + getGender();  // ������ ���ڿ��� ����(Mother ��ü�� ������ �׻� "����"��) 
		s = s + ", �ڳ��: " + no      // �ڳ���� ���ڿ��� ����
		           + (no == 0 ? "" : no == 1 ? ", �ڳ�: " : ", �ڳ��: "); // �ڳ���� ���� �ȳ� ���ڿ� ����
		
		for (int i = 0; i < no; i++) // �ڳ���� Person ��ü���� ���ڿ��� ����
		   s = s + "[" + children[i].toString() + "] ";  // �ڳ� ������ "[ �ڳ� ���ڿ� ]" �������� ���� 
		
		return s;
	}
	
	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("\n  * ��Ӵ� - " + this.toString());
	}

} 

class Ex8_2_3_MotherMgmt {
	public static void main(String[] args) {
		Mother scMom = new Mother("��û����", 20);
		scMom.setChild(new Person("��û", 1));
		scMom.output();
		
		// Mother ��ü�� MotherIF ��ü ���������� ���� ������
		MotherIF pdMom = new Mother("�������", 22);
		pdMom.setChild(new Person("����", 3));
		pdMom.setChild(new Person("����", 1));
		((Mother) pdMom).output();

		// Mother ��ü�� Person ��ü ���������� ���� ������
		Person chMom = new Mother("����", 20);
		((Mother) chMom).setChild(new Person("����", 1));  // �ٿ�ĳ�����Ͽ� ���� Ŭ���� �޼ҵ� ȣ��
		((Mother) chMom).output();                        // �ٿ�ĳ�����Ͽ� ���� Ŭ���� �޼ҵ� ȣ��
		
		MotherIF[] moms = new MotherIF[10];  // MotherIF �迭���� ����
		moms[0] = scMom;                     // ��û������ 0 ��ġ�� ����
		moms[1] = pdMom;                     // ������̸� 1 ��ġ�� ����     
		moms[2] = (MotherIF) chMom;          // ���� ������ �ٿ�ĳ�����Ͽ� 2 ��ġ�� ����   
		
		System.out.println("\n\n  ** moms[] �迭�� ���ҵ� ** "); 
		for (int i = 0; i < 3; i++)
			((Mother) moms[i]).output();     // �ٿ�ĳ�����Ͽ� ���� Ŭ���� �޼ҵ� ȣ��
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷���  Female, MotherIF �������̽��� �ۼ��Ͽ�����, MotherIF �������̽��� �����ϸ鼭 
 *      Person Ŭ������ Ȯ���ϴ�  Mother Ŭ������  �ۼ��Ͽ���.
 *      
 *   2) �� ���α׷������� Mother Ŭ������ �ʵ� ���� ��� ����ϴ� public toString() �޼ҵ�� 
 *      void output() �޼ҵ尡 �ۼ��Ǿ���, �� �޼ҵ带 �̿��Ͽ� Mother Ŭ���� ��ü���� ����Ͽ���. 
 *      �� ������ �ڳ��, �ڳ���� �̸�, ����, ����ġ � �Բ� ��µȴ�.
 *      
 *      �ۼ��� toString()�� output() �޼ҵ带 �� ���캸�� �����϶�.
 *      
 *   3) ���α׷� �����ϰ� ��� Ȯ���϶�.
 */