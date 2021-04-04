package ex8_1_interfaces;

/**
 * [ Person Ŭ������ ���� �������̽���  ] : ���� �������̽����� ���̴� ����
 * 
 *   o �������̽�(interface)�� �ʵ�� �޼ҵ�
 *     - �ʵ�� public static final �ʵ常 ���� �� ����
 *     - �޼ҵ�� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ� ���� �� ����
 *     
 *     - abstract �޼ҵ�: �޼ҵ� ������ ������ �޼ҵ��, �������̽������� abstract Ű���尡 ������ �޼ҵ嵵
 *                       abstract �޼ҵ�
 *     - default �޼ҵ�: ���� �κ��� ������ ��ü �޼ҵ带 �������̽������� default �޼ҵ�� ��, 
 *                      �� ������ default ���ľ ������  abstract �޼ҵ�� ȥ���Ǳ� ����
 *     - static �޼ҵ�: static Ű���尡 ���� Ŭ���� �޼ҵ��̸� �����κ��� ����
 *     
 *     - JDK 1.9���ʹ� private �޼ҵ嵵 �����ϰ� ��
 *     
 *   o �������̽�(interface)�� Ư¡
 *     - ��ü�� ������ �� ������, �����ϴ� ���� Ŭ�������� ��ü ���� ����
 *     - �������̽��� �����ϴ� ���� Ŭ������ �ݵ�� abstract �޼ҵ� �����ؾ� ��
 *     - �������̽��� Ÿ������ ���Ǿ� �������̽� ��ü �������� ������ �� ����
 *     - �������̽� ��ü ���������� ���� Ŭ������ ��ü�� ������ �� ����
 *     - �������̽��� �����ϴ� ���� ���� Ŭ�������� ��ü�� �������̽� ��ü�� �ǹǷ� ���������� ������ �� ����
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

	// output(): Person ��ü�� ��� �ʵ� ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println("  * ��� - �̸�:" + this.name + ", ����:" + this.age + 
				", ����ġ:" + this.currentLocation);
	}
}

 // ������ ��Ÿ���� �������̽�
 interface Male { 
	public static final String gender = "����"; 	//  public static final�� �����ص� ��
	
	public static String getGender() {  // ������ ��ȯ�ϴ� static �޼ҵ�
		return gender;
	};             
}		

// ������ ��Ÿ���� �������̽�
interface Female { 
	public static final String gender = "����"; 	//  public static final�� �����ص� �� 
	
	static String getGender(){            // ������ ��ȯ�ϴ� static �޼ҵ�
		return gender;
	}    
}  		

interface Adult { 
	int MINADULTAGE = 19;	        	  // ���� �ּ� ����
}  	

// �̼����ڸ� ��Ÿ���� Minor �������̽�	
interface Minor { 
	public static int MAXMINORAGE = 18;  // �̼��� �ִ� ����
}  

// Male�� ���� �������̽� Boy
interface Boy extends Male { 
}	  

// ��Ӵϸ� ��Ÿ����, Female�� ���� �������̽� MotherIF
abstract interface MotherIF extends Female { 
	public void setChild(Person p);	  // Person ��ü p�� �ڽ����� ����ϴ� �޼ҵ�
	public abstract Person[] getChildren();  // �ڳ���� Person[] �迭�� ��ȯ�ϴ� �޼ҵ�
	public int getNoChildren();    	  // �ڳ���� ��ȯ�ϴ� �޼ҵ�  
	
	default boolean isMotherOf(Person c) {  // �־��� Person ��ü c�� ��Ӵ��ΰ��� �˻��ϴ� default �޼ҵ�
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// ���� ���ڸ� ��Ÿ����, Male�� Adult�� Ȯ���� ���� �������̽� AdultMale
interface AdultMale extends Male, Adult {
}  

// ���� ���ڸ� ��Ÿ����, Female�� Adult�� Ȯ���� ���� �������̽� AdultFemale
interface AdultFemale extends Female, Adult {
} 


class Ex8_1_InterfacesMgmt {
	public static void main(String[] args) {
		
		new Male();         // �������̽��� ��ü�� ������ �� �����Ƿ� �� ������ ������ �߻���
		
		// �������̽� ��ü ��������: �̵� �������� �������̽��� ���� Ŭ���� ��ü�� �����
		Male m1;   		    // m1�� Male �������̽��� ��ü ��������
		MotherIF mo;		// mo�� MotherIF �������̽��� ��ü ��������
		AdultMale am;		// am�� AdultMale �������̽��� ��ü ��������
		
		// �������̽� �迭����: �̵� �迭�������� �������̽��� ���� Ŭ���� ��ü���� �����
		Male[] ms = new Male[20];           // ms�� Male ��ü �����ϴ� �迭����
		MotherIF[] moms = new MotherIF[20]; // moms�� MotherIF ��ü �����ϴ� �迭����
		
		// �������̽��� static �ʵ�� ��ӵ�
		System.out.println("  * Male.gender: " + Male.gender +", Female.gender: " + Female.gender);
	    System.out.println("  * Boy.gender: " + Boy.gender +", MotherIF.gender: " + MotherIF.gender);
	    
	    // �������̽��� static �޼ҵ�� ��ӵ��� ����, Boy.getGender()�� MotherIF.getGender()�� ����
		System.out.println("  * Male.gender: " + Male.getGender() + ", Female.gender: " + Female.getGender());
		System.out.println("  * Boy.gender: " + Boy.getGender() + ", MotherIF.gender: " + MotherIF.getGender());
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� �������̽��� �ۼ��Ͽ���. �� �������̽��� �ʵ带 Ȯ���϶�.
 *      - �������̽��� �ʵ�� public static final �ʵ常 �����ϴ�.
 *      - public static final�� ������ �� ������ �ʱ� ���� �ݵ�� �־����� �Ѵ�.
 *      
 *   2) �������̽��� �ۼ��� �޼ҵ带 Ȯ���϶�.
 *      - �������̽��� abstract �޼ҵ�, default �޼ҵ�, static �޼ҵ带 ���� �� �ִ�.
 *      - MotherIF �������̽��� abstract �޼ҵ带 Ȯ���϶�.
 *      - MotherIF �������̽��� default �޼ҵ带 Ȯ���϶�.      
 *      - Male, Female �������̽��� static �޼ҵ带 Ȯ���϶�.
 *      
 *   3) �������̽��� �ٸ� �������̽��� Ȯ���� �� ������ Boy, MotherIF, AdultMale, AdultFemale �������̽��� 
 *      ���� Ȯ���϶�.
 *      
 *   4) �������̽��� ���� �������̽��� Ȯ���� �� ������  AdultMale, AdultFemale �������̽��� ���� Ȯ���϶�.
 *   
 *   5) �������̽��� ��ü�� ������ �� ������ main() �޼ҵ��� << new Male(); >> ���忡�� Ȯ���϶�.
 *   
 *   6) �������̽��� ��ü�� ������ �� ������ ��ü ���� ������ �迭������ ������ �� ������  
 *      main() �޼ҵ��� << Male m1; >>, << Male[] ms = new Male[20]; >> ���忡�� Ȯ���϶�.
 *      
 *   7) ���� �������̽��� static �ʵ� gender�� ���� �������̽� Boy�� MotherIF�� ��ӵ��� Ȯ���϶�.
 *   
 *   8) ���� �������̽��� static �޼ҵ� getGender()�� ���� �������̽�  Boy�� MotherIF�� ��ӵ��� ������ Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) main()�� << new Male(); >>������ ������ ���ֱ� ���ؼ��� �������̽��� ���� Ŭ������ ��ü�� �����Ͽ��� �Ѵ�.
 *      ���� �������̽��� ���� Ŭ������ �ۼ����� �ʾ����Ƿ� ���� �߻� ������ �����Ͽ� ������ ���ֶ�.
 *     
 *   2) Boy.getGender()��  MotherIF.getGender()�� ȣ���ϴ� main()�� ������ ������ �����̴�.
 *      �̴� ���� �������̽��� static �޼ҵ�� ���� �������̽��� ��ӵ��� �ʱ� �����̴�.
 *      
 *      ������ ������ �����ϰ� ���α׷��� �����Ͽ� ��� Ȯ���϶�.
 *      
 *   3) ��ü ���������� ������� ���� �������̽��� ��ü ���������� �迭 ������ �����϶�.
 */
