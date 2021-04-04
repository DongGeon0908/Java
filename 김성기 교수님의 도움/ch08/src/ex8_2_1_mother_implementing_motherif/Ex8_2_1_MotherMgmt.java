package ex8_2_1_mother_implementing_motherif;

/**
 * [ Person, Female, MotherIF, Mother, MotherMgmt �������̽� ��  Ŭ����  ] 
 *        motherIF �������̽� �����ϴ� ���� Ŭ���� Mother 
 *
 *   o �������̽�(interface)
 *     - �ʵ�δ� public static final �ʵ常 ���� �� ����
 *     - �޼ҵ�δ� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ� ���� �� ����
 *     - ��ü�� ������ �� ������, �����ϴ� ���� Ŭ�������� ��ü ���� ����
 *     
 *     - �������̽��� �����ϴ� ���� Ŭ������ �ݵ��  abstract �޼ҵ� �����ؾ� ��
 *     - �������̽��� Ÿ������ ���Ǿ� �������̽� ��ü �������� ������ �� ������,
 *       �������̽� ��ü ���������� ���� Ŭ������ ��ü ������
 *     - �������̽��� �����ϴ� ���� ���� Ŭ�������� ��ü�� �������̽� ��ü�� �ǹǷ� ���������� ������ �� ����
 *     
 *   o �������̽� �����ϴ� ���� Ŭ����
 *     - �� Ŭ������ ���� �������̽��� ������ �� ����
 *     - �������̽� �����ϴ� Ŭ������ �������̽��� ���� Ŭ����, �������̽��� �� Ŭ������ ���� �������̽��� ��
 *     - �������̽� �����ϴ� ���� Ŭ������ �ݵ�� ���� �������̽���  abstract �޼ҵ� �����ؾ� ��
 *     - �������̽� �����ϴ� ���� Ŭ���� ��ü�� ���� �������̽� Ÿ�Ե� ������ �ǹǷ� 
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

// ������ ��Ÿ���� �������̽�
interface Female { 
	public static final String gender = "����"; 	// public static final�� �����ص� �� 
	
	public default String getGender(){  // ������ ��ȯ�ϴ� default �޼ҵ�
		return gender;
	}	
}  		

// ��Ӵϸ� ��Ÿ����, Female�� ���� �������̽� MotherIF
interface MotherIF extends Female { 
	public void setChild(Person p);	// Person ��ü p�� �ڽ����� ����ϴ� �޼ҵ�
	public Person[] getChildren();  // �ڳ���� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
	public int getNoChildren();    	// �ڳ���� ��ȯ�ϴ� �޼ҵ�  
	
	// �־��� Person ��ü c�� ��� ���� �˻��ϴ� default �޼ҵ�
	default boolean isMotherOf(Person c) {  
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// MotherIF �������̽� �����ϴ� Mother Ŭ����
//   Mother Ŭ������ Person�� ���� Ŭ������ ����Ǿ�� ������ 
//   �� ���α׷������� ���� Ŭ������ �������� �����Ƿ� Person Ŭ������ �ʵ�� �޼ҵ带 ��� ������ 
class Mother implements MotherIF { 
	String name;  int age; String currentLocation;

	Mother(String name, int age) {
		this.name = name; this.age = age;
	}
	
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	public String toString() {
		return null; // �� �޼ҵ带 �ۼ��϶�.
	}
	
	public void output() {
		// �� �޼ҵ带 �ۼ��϶�.
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
} 

class Ex8_2_1_MotherMgmt {
	public static void main(String[] args) {
		
		// �������̽��� ������ Ŭ������ ��ü ����
		Mother scMom = new Mother("��û����", 20);
		
		// ��û�� ��û������ ���� ���
		Person sc = new Person("��û", 1);
		scMom.setChild(sc);
		System.out.println("\n  * ��û���� �ڳ��: " + scMom.getNoChildren());
		

		// Mother ��ü�� MotherIF ��ü ���������� ���� ������
		MotherIF pdMom = new Mother("�������", 22);
		
		// ������ ������ �R������� ���� ���
		Person pd, ps;
		pdMom.setChild(pd = new Person("����", 3));
		pdMom.setChild(ps = new Person("����", 1));
		System.out.println("\n  * ������� �ڳ��: " + pdMom.getNoChildren());   	
		
		// MotherIF �������̽��� default �޼ҵ� ȣ��
		System.out.println("\n  * ��û������ ��û ��Ӵ� ���� : " + scMom.isMotherOf(sc));
		System.out.println("\n  * ��û������ ���� ��Ӵ� ���� : " + scMom.isMotherOf(pd));
		System.out.println("\n  * ���������  ���� ��Ӵ� ���� : " + pdMom.isMotherOf(ps));
		
		// Female �������̽��� default �޼ҵ� ȣ��
		System.out.println("\n  * ��û������ ���� : " + scMom.getGender());
		
        // Mother ��ü�� MotherIF �迭�� ���ҷ� ���� ������
		MotherIF[] moms = new MotherIF[10];  // MotherIF �迭���� ����
		moms[0] = scMom;                     // ��û������ 0 ��ġ�� ����
		moms[1] = pdMom;                     // ������̸� 1 ��ġ�� ����     		
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Female, MotherIF �������̽��� �ۼ��Ͽ�����, MotherIF �������̽��� �����ϴ� 
 *      Mother Ŭ������  �ۼ��Ͽ���.
 *      
 *   2) Female �������̽��� �ʵ带 Ȯ���϶�.
 *      - �������̽��� �ʵ�� public static final �ʵ常 �����ϴ�.
 *      - public static final�� ������ �� ������ �ʱ� ���� �ݵ�� �־�� �Ѵ�.
 *      
 *   3) �������̽��� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ带 ���� �� �ִ�.
 *      - MotherIF �������̽��� abstract �޼ҵ带 Ȯ���϶�.
 *      - MotherIF �������̽��� default �޼ҵ带 Ȯ���϶�.      
 *      - Female �������̽��� default �޼ҵ带 Ȯ���϶�.
 *        
 *   4) MotherIF �������̽��� abstract �޼ҵ尡 ���  Mother Ŭ�������� �����Ǿ����� Ȯ���϶�.
 *      abstract �޼ҵ� ������ ���� �߰��� �ʵ�鵵 Ȯ���϶�.
 *      
 *   5) Mother Ŭ������ ������ �������̽��� ������ ��ü������, �ʵ�, �޼ҵ带 ������ Ȯ���϶�.
 *   
 *   6) �������̽��� ������ Ŭ������ ��ü�� ������ �� ������ main() �޼ҵ��� 
 *      << Mother scMom = new Mother("��û����", 20); >> ���忡�� Ȯ���϶�.
 *   
 *   7) �������̽��� ������ Ŭ������ ��ü�� �������̽� Ÿ���� �����Ƿ� �������̽��� ��ü ���������� ������ �� ������  
 *      main() �޼ҵ��� << MotherIF pdMom = new Mother("�������", 22); >> ���忡�� Ȯ���϶�.
 *   
 *   8) �������̽��� ������ Ŭ������ ��ü�� �������̽� Ÿ���� �����Ƿ� �������̽��� �迭������ ������ �� ������
 *      main() �޼ҵ��� << moms[0] = scMom;  >> ���忡�� Ȯ���϶�.
 *      
 *   9) �������̽��� �ۼ��� default �޼ҵ�� static �޼ҵ� ȣ���� �� ������ Ȯ���϶�.
 *   
 *   10) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) Person Ŭ������ �����Ͽ�  Mother Ŭ������ �ʵ� ���� ���ڿ��� �����ϰ� ����ϴ� public toString() �޼ҵ�� 
 *      void output() �޼ҵ带 �ۼ��ϰ� �� �޼ҵ带 �̿��Ͽ� ������ Mother Ŭ���� ��ü���� ����϶�. 
 *      �̶�  gender, �ڳ��, �ڳ���� �̸�, ����, ����ġ � ��µǾ�� �Ѵ�.
 *      
 *      moms �迭�� �����  Mother Ŭ���� ��ü���� for ���� output() �޼ҵ带 �̿��Ͽ� ��� ����϶�.
 *   
 *   2) default boolean isMale() �޼ҵ�� ������ �����̸� true�� ��ȯ�ϴ� default �޼ҵ��̸�, 
 *      default boolean isFemale()�� ������ �����̸� true�� ��ȯ�ϴ� default �޼ҵ��̴�.
 *      
 *      Female �������̽��� �̵� �޼ҵ带 �ۼ��ϰ� ��û������ ���� ���ο� ���������� ���� ���θ� �̵� �޼ҵ带 �̿��Ͽ� 
 *      ����϶�.
 *          
 *   3) GrandMotherIF �������̽��� Female �������̽��� ���� �������̽��̸�, �߰��� ������ �޼ҵ带 ������.
 *   
 *       	public void setGrandChild(Person p);	// Person ��ü p�� ���ڷ� ����ϴ� �޼ҵ�
 *   	    public Person[] getGrandChildren();     // ���ڵ��� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
 *          public int getNoGrandChildren();    	// ���ڼ��� ��ȯ�ϴ� �޼ҵ� 
 *          
 *          default boolean isGrandMotherOf(Person c) { ... }  // �־��� Person ��ü c�� �ҸӴ� ���� �˻��ϴ� default �޼ҵ�	
 *      
 *      (1) GrandMotherIF �������̽��� �ۼ��϶�.
 *      
 *      (2) GrandMotherIF �������̽��� �����ϴ� GrandMother Ŭ������ Mother Ŭ������ �����Ͽ�
 *          �ۼ��϶�.
 *      
 *      (3) main() �޼ҵ忡�� ��û �ҸӴϿ� ���� �ҸӴϸ� ��Ÿ����  GrandMother Ŭ������ ��ü 2���� �����ϰ� 
 *          �̸�  GrandMother ��ü ���������� GrandMotherIF ��ü ���������� �����ϰ�  
 *          ������ ��û�� ������ ������ �� ��ü�� ����϶�.
 *      
 *      (4) main() �޼ҵ忡�� GrandMotherIF �������̽��� �迭 ������ �����ϰ�
 *          ������ 2 ��ü�� �� �迭�� ���ҷ� �����ϰ� �迭 ���Ҹ� ���  ����϶�.
 */
