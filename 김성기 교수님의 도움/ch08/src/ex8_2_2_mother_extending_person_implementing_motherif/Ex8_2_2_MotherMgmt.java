package ex8_2_2_mother_extending_person_implementing_motherif;

/**
 * [ Person, Female, MotherIF, Mother, MotherMgmt �������̽� ��  Ŭ���� ] :
 *        Ŭ���� Ȯ���ϸ鼭 �������̽� �����ϴ� ���� Ŭ���� Mother�� �ۼ��� ����
 *   
 *   o �������̽�(interface)�� �ʵ�� �޼ҵ�
 *     - �ʵ�δ� public static final �ʵ常 ���� �� ����
 *     - �޼ҵ�δ� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ� ���� �� ����
 *     
 *   o �������̽�(interface)�� Ư¡
 *     - ��ü ������ �� ������, �����ϴ� ���� Ŭ�������� ��ü ���� ����
 *     - �������̽� �����ϴ� ���� Ŭ������ �ݵ�� abstract �޼ҵ� �����ؾ� ��
 *     - �������̽��� Ÿ������ ���Ǿ� �������̽� ��ü ���������� ������ �� ����
 *     - �������̽� ��ü ���������� ���� Ŭ������ ��ü ������
 *     - �������̽� �����ϴ� ���� ���� Ŭ�������� ��ü�� �������̽��� ��ü�� �ǹǷ� ���������� ������ �� ����
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
		return "�̸�:" + this.name + ", ����: " + this.age 
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
	
	public String toString() {
		return null; // �� �޼ҵ带 �ۼ��϶�.
	}
	
	public void output() {
		// �� �޼ҵ带 �ۼ��϶�.
	}
} 

class Ex8_2_2_MotherMgmt {
	public static void main(String[] args) {
		Mother scMom = new Mother("��û����", 20);
		scMom.setChild(new Person("��û", 1));
		System.out.println("\n  * ��û���� �ڳ��: " + scMom.getNoChildren());
		
		// Mother ��ü�� MotherIF ��ü ���������� ���� ������
		MotherIF pdMom = new Mother("�������", 22);
		pdMom.setChild(new Person("����", 3));
		pdMom.setChild(new Person("����", 1));
		System.out.println("\n  * ������� �ڳ��: " + pdMom.getNoChildren());   	

		// Mother ��ü�� Person ��ü ���������� ���� ������
		Person chMom = new Mother("����", 20);
		((Mother) chMom).setChild(new Person("����", 1));  // �ٿ�ĳ�����Ͽ� ���� Ŭ���� �޼ҵ� ȣ��
		System.out.println("\n  * ���� �ڳ��: " + ((Mother) chMom).getNoChildren());   	
		
		MotherIF[] moms = new MotherIF[10];  // MotherIF �迭���� ����
		moms[0] = scMom;                     // ��û������ 0 ��ġ�� ����
		moms[1] = pdMom;                     // ������̸� 1 ��ġ�� ����     
		moms[2] = (MotherIF) chMom;          // ���� ������ �ٿ�ĳ�����Ͽ� 2 ��ġ�� ����   
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷���  Female, MotherIF �������̽��� �ۼ��Ͽ�����, MotherIF �������̽��� �����ϸ鼭 Person Ŭ������ Ȯ���ϴ� 
 *      Mother Ŭ������  �ۼ��Ͽ���.
 *      
 *   2) MotherIF �������̽��� abstract �޼ҵ尡 ���  Mother Ŭ�������� �����Ǿ����� Ȯ���϶�.
 *      abstract �޼ҵ带 ���� �߰��� �ʵ�鵵 Ȯ���϶�.
 *      
 *   3) Mother Ŭ������ ��� Ư��, ��ü������, �ʵ�, �޼ҵ带 Ȯ���϶�.
 *   
 *   4) �������̽��� ������ Ŭ������ ��ü�� ������ �� ������ main() �޼ҵ��� 
 *      << Mother scMom = new Mother("��û����", 20); >> ���忡�� Ȯ���϶�.
 *   
 *   5) �������̽��� ������ Ŭ������ ��ü�� �������̽� Ÿ���� �����Ƿ� �������̽��� ��ü ���������� ������ �� ������  
 *      main() �޼ҵ���  << MotherIF pdMom = new Mother("�������", 22); >> ���忡�� Ȯ���϶�.
 *   
 *   6) ���� Ŭ������ ��ü�� ���� Ŭ���� Ÿ���� �����Ƿ� ���� Ŭ������ ��ü ���������� ����� �� ������  
 *      main() �޼ҵ��� << Person chMom = new Mother("����", 20); >> ���忡�� Ȯ���϶�.
 *   
 *   7) �������̽��� ������ Ŭ������ ��ü�� �������̽� Ÿ���� �����Ƿ� �������̽��� �迭������ ������ �� ������
 *      main() �޼ҵ��� << moms[0] = scMom;  >> ���忡�� Ȯ���϶�.
 *      
 *   8) ���α׷� �����ϰ� ��� Ȯ���϶�.
 *      
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) GrandMotherIF �������̽��� MotherIF �������̽��� ���� �������̽��̸� �߰������� ������ �޼ҵ带 ������.
 *   
 *       	public void setGrandChild(Person p);	// Person ��ü p�� ���ڷ� ����ϴ� �޼ҵ�
 *   	    public Person[] geGrandChildren();      // ���ڵ��� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
 *          public int getNoGrandChildren();    	// ���ڼ��� ��ȯ�ϴ� �޼ҵ�  
 *          
 *          default boolean isGrandMotherOf(Person c) { ... }  // �־��� Person ��ü c�� �ҸӴ� ���� �˻��ϴ� default �޼ҵ�	
    
 *      
 *      (1) GrandMotherIF �������̽��� �ۼ��϶�.
 *      
 *      (2) Person Ŭ���� Ȯ���ϸ鼭 GrandMotherIF �������̽��� �����ϴ� GrandMother Ŭ������ 
 *          Mother Ŭ������ �����Ͽ� �ۼ��϶�.
 *      
 *      (3) main() �޼ҵ忡�� ��û �ҸӴϿ� ���� �ҸӴϸ� ��Ÿ����  GrandMother Ŭ������ ��ü 2���� �����Ͽ� 
 *          �̸�  GrandMother ��ü ���������� GrandMotherIF ��ü ���������� �����ϰ�  
 *          ������ ��û�� ������ ������ �� ��ü�� ����϶�.
 *      
 *      (4) main() �޼ҵ忡�� GrandMotherIF �������̽��� �迭 ������ �����ϰ�
 *          ������ 2 ��ü�� �� �迭�� ���ҷ� �����ϰ� �迭 ���Ҹ� ���  ����϶�.
 */
