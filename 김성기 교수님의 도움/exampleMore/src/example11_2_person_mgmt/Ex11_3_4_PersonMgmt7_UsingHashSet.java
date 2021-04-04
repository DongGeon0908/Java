package example11_2_person_mgmt;

import java.util.HashSet;

/**
 * [ PersonMgmt6 ]: HashSet Ŭ������ �̿��Ͽ�  ���� �Ż����� ����� ���
 *    
 *   o HashSet Ŭ������  �ߺ����� �ʴ� ���� �����͸� �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ������ 
 *     - HashSet�� �̿��Ͽ� ���Ҹ� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���Ҹ� ������ ������ �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ������ �߰��� Ȯ����
 *    
 *   o add(), remove() �޼ҵ带 �̿��Ͽ� ���� �߰� �� ������ �����ϰ� ������ �� ����
 *     - add(E element): element�� ���ҷ� ����Ǿ� ���� ������ �߰�
 *     - remove(Object o): �־��� o�� ���ҷ� �����ϸ� true ��ȯ, �׷��� ������ false ��ȯ 
 */

class Ex11_3_4_PersonMgmt7_UsingHashSet {  

	// Person ��ü�� ���ҷ� ������ HashSet ��ü �����Ͽ� persons�� �����ϰ� �� 
	static HashSet<Person> persons = new HashSet<Person>(); 

	// �־��� Person ��ü p�� HashSet ��ü persons�� �߰��ϴ� �޼ҵ�
	static void addPerson(Person p) {     
		persons.add(p); // p�� persons�� �߰�(���������� ������ ���� ���� 1 ����)
	}

	// n���� Person ��ü �����ϰ� �Ż����� �Է��Ͽ� persons�� �����ϴ� �޼ҵ�
	static void inputPersons(int n) {
		System.out.println("\n\n  **** " + n +"�� �Ż������Է� ****");
		for (int i = 1; i <= n; i++) {
			Person p = new Person();  // Person ��ü�� ����       
			p.input("\n  ** " + i + "��° �Ż�����(�̸�, ����, ����ġ) �Է� **");
			addPerson(p);              // p�� persons�� ����
		}
	}
	
	// �Ż����� �ο��� �Է��Ͽ� �� �ο�����ŭ�� �Ż����� �Է��Ͽ� persons�� �����ϴ� �޼ҵ�
	static void inputPersons() {
		System.out.println("\n\n  **** �Ż����� �Է� ****");
		int no = SkScanner.getInt("\n  o �Է��� �Ż����� �ο��� > ");
		
		inputPersons(no);
	}

	// HashSet ��ü persons�� ����� ��� Person ��ü�� ����ϴ� �޼ҵ�
	static void outputAllPersons() {
		int n = persons.size();       // persons�� ����� ���� ������ n�� ���� 
		System.out.println("\n\n  ** " + n + "�� �Ż����� **\n");
		for (Person p : persons)  // persons�� �� ������ Person ��ü p�� ����
			p.output();           //  p�� ���
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
 *   1) ������ ���� Integer ��ü�� ������ �� �ִ� HashSet ��ü�� �����Ͽ� �������� ints�� �����ϵ��� �϶�.
 *      
 *       static HashSet<Integer> ints = new HashSet<Integer>(); // Integer ��ü�� ������ HashSet ��ü�� �����Ͽ�  ints�� �����ϰ� ��
 *       
 *   2) 11���� ������ �Է��Ͽ� ints�� �����ϵ��� �߰��� �ۼ��ϱ� ���� ������ �޼ҵ带 �ۼ��϶�.
 *      
 *        static void addInts(int n)   // n�� HashSet ��ü ints�� �����ϴ� �޼ҵ�
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� HashSet ��ü ints�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� ints�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // HashSet ��ü ints�� ����� ��� ������ ����ϴ� �޼ҵ� 
 *        
 *   3) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *         inputInts();
 *         outputAllInts(); 
 */
