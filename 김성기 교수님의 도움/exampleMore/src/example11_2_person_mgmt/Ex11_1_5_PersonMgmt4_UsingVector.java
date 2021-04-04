package example11_2_person_mgmt;

import java.util.Vector;

/**
 * [ PersonMgmt4 ]: Vector Ŭ������ �̿��Ͽ� �ε��� ���� �ʰ� ���� �����ϱ�
 * 
 *   o �迭�� ���� ������ �ִ� ���� �������� �� ���� ���Ҹ� �����Ϸ� �ϸ� �ε��� ���� �ʰ� ������
 *     ArrayIndexOutOfBoundsException�� �߻��ϹǷ� �̸� ������ �� �ֵ��� ��ġ�ϴ� ����
 *    
 *   o Vector Ŭ������ ���� �����͸� �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ������ 
 *     - Vector�� �̿��Ͽ� ���Ҹ� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���Ҹ� ������ ������ �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ������ �߰��� Ȯ����
 *    
 *   o add(), get(), size() �޼ҵ带 �̿��Ͽ� ���� �߰� �� �˻��� �����ϰ� ������ �� ����
 *    
 */

class Ex11_1_5_PersonMgmt4_UsingVector {  
	// Person ��ü�� ���ҷ� ������ Vector ��ü �����Ͽ� persons�� �����ϰ� �� 
	static Vector<Person> persons = new Vector<Person>(); 

	// �־��� Person ��ü p�� Vector ��ü persons�� �߰���
	static void addPerson(Person p) {     
		// Vector ��ü���� ���� ������ ������ �׻� �ְ� �ǹǷ� 
		persons.add(p);  // p�� persons�� ����(���������� ������ ���� ���� 1 ����)
	}

	// �־��� n���� �Ż����� �Է��� Person ��ü�� Vector ��ü persons�� ����
	static void inputPersons(int n) {
		System.out.println("\n\n  **** " + n +"�� �Ż����� �Է� ****");
		for (int i = 1; i <= n; i++) {
			Person p = new Person();     // Person ��ü�� ����	 	
			p.input("\n  ** " + i + "��° �Ż�����(�̸�, ����, ����ġ) �Է� **");
			addPerson(p);                // p�� persons�� ����
		}
	}
	
	// �Ż����� �ο��� �Է��Ͽ� �� �ο�����ŭ�� �Ż����� �Է��Ͽ� persons�� �����ϴ� �޼ҵ�
	static void inputPersons() {
		System.out.println("\n\n  **** �Ż����� �Է� ****");
		int no = SkScanner.getInt("\n  o �Է��� �Ż����� �ο��� > ");
		
		inputPersons(no);
	}	

	// Vector ��ü persons�� ����� ��� Person ��ü�� ���
	static void outputAllPersons() {
		int n = persons.size();        // persons�� ����� ���� ������ n�� ���� 
		System.out.println("\n\n  ** " + n + "�� �Ż����� **\n");
		for (int i = 0; i < n; i++)    // persons.size() ������ ���ҿ� ����
			persons.get(i).output();   //    �ε��� i�� ���Ҹ� get(i)�� ���� ���
	}

	public static void main(String[] args) {	
		inputPersons(5);
		outputAllPersons();		
	}
}  

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   2) �� ���α׷��� ���ܸ� �߻���Ű���� ������, 5���� Person ��ü�� ��� ������� Ȯ���� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 *   
 *   1) ������ ���� Integer ��ü�� ������ �� �ִ� Vector ��ü�� �����Ͽ� �������� ints�� �����ϵ��� �϶�.
 *      
 *       static Vector<Integer> ints = new Vector<Integer>(); // Integer ��ü�� ������ Vector ��ü�� �����Ͽ�  ints�� �����ϰ� ��
 *       
 *   2) ���� ������ �Է��Ͽ� ints�� �����ϵ��� �߰��� �ۼ��ϱ� ���� ������ �޼ҵ带 �ۼ��϶�.
 *      
 *        static void addInts(int n)   // n�� Vector ��ü ints�� ���� �����ϴ� �޼ҵ�
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� Vector ��ü ints�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� ints�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // Vector ��ü ints�� ����� ��� ������ ����ϴ� �޼ҵ� 
 *        
 *   3) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *         inputInts();
 *         outputAllInts();      
 */