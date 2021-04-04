package example11_2_person_mgmt;

import java.util.ArrayList;

/**
 * [ PersonMgmt5 ]: ArrayList Ŭ������ �̿��Ͽ� ���� �Ż����� ����� ���
 *    
 *   o ArrayList Ŭ������ ���� �����͸� �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ������ 
 *     - ArrayList�� �̿��Ͽ� ���Ҹ� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���Ҹ� ������ ������ �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ������ �߰��� Ȯ����
 *    
 *   o add(), get(), size() �޼ҵ带 �̿��Ͽ� ���� �߰� �� �˻��� �����ϰ� ������ �� ���� 
 */

class Ex11_3_2_PersonMgmt5_UsingArrayList {  
	// Person ��ü�� ���ҷ� ������ ArrayList ��ü �����Ͽ� persons�� �����ϰ� �� 
	static ArrayList<Person> persons = new ArrayList<Person>(); 

	// �־��� Person ��ü p�� ArrayList ��ü persons�� �߰���
	static void addPerson(Person p) {     
		// ArrayList ��ü���� ���� ������ ������ �׻� �ְ� �ǹǷ� 
		persons.add(p);  // p�� persons�� ����(���������� ������ ���� ���� 1 ����)
	}

	// �־��� n���� �Ż����� �Է��� Person ��ü�� ArrayList ��ü persons�� ����
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

	// ArrayList ��ü persons�� ����� ��� Person ��ü�� ���
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
 *   1) ������ ���� Integer ��ü�� ������ �� �ִ� ArrayList ��ü�� �����Ͽ� �������� ints�� �����ϵ��� �϶�.
 *      
 *       static ArrayList<Integer> ints = new ArrayList<Integer>(); // Integer ��ü�� ������ ArrayList ��ü�� �����Ͽ�  ints�� �����ϰ� ��
 *       
 *   2) ���� ������ �Է��Ͽ� ints�� �����ϵ��� �߰��� �ۼ��ϱ� ���� ������ �޼ҵ带 �ۼ��϶�.
 *      
 *        static void addInts(int n)   // n�� ArrayList ��ü ints�� ���� �����ϴ� �޼ҵ�
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� ArrayList ��ü ints�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� ArrayList ��ü ints�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // ArrayList ��ü ints�� ����� ��� ������ ����ϴ� �޼ҵ� 
 *        
 *   3) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *         inputInts();
 *         outputAllInts();   
 */