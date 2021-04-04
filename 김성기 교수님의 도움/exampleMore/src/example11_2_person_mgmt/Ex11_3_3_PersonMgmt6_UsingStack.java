package example11_2_person_mgmt;
import java.util.Stack;

/**
 * [ PersonMgmt6 ]: Stack Ŭ������ �̿��Ͽ�  ���� �Ż����� ����� ���
 *    
 *   o Stack Ŭ������ ���� �����͸� �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ������ 
 *     - Stack�� �̿��Ͽ� ���Ҹ� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���Ҹ� ������ ������ �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ������ �߰��� Ȯ����
 *    
 *   o push(), pop() �޼ҵ带 �̿��Ͽ� ���� �߰� �� ������ �����ϰ� ������ �� ����
 *     - push(): �־��� ���Ҹ� ž ��ġ�� �߰���
 *     - pop(): ������ ž ��ġ�� ���Ҹ� �����ϰ� ������ ���Ҹ� ��ȯ��
 *    
 */

class Ex11_3_3_PersonMgmt6_UsingStack {  

	// Person ��ü�� ���ҷ� ������ Stack ��ü �����Ͽ� persons�� �����ϰ� �� 
	static Stack<Person> persons = new Stack<Person>(); 

	// �־��� Person ��ü p�� Stack ��ü persons�� �߰��ϴ� �޼ҵ�
	static void addPerson(Person p) {     
		persons.push(p); // p�� persons�� Ǫ��(���������� ������ ���� ���� 1 ����)
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

	// Stack ��ü persons�� ����� ��� Person ��ü�� ����ϴ� �޼ҵ�
	static void outputAllPersons() {
		int n = persons.size();       // persons�� ����� ���� ������ n�� ���� 
		System.out.println("\n\n  ** " + n + "�� �Ż����� **\n");
		for (int i = 0; i < n; i++)    // persons.size() ������ ���ҿ� ����
			persons.pop().output();  //   �˽�Ų �� ���� ���Ҹ� ���
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
 *   1) ������ ���� Integer ��ü�� ������ �� �ִ� Stack ��ü�� �����Ͽ� �������� ints�� �����ϵ��� �϶�.
 *      
 *       static Stack<Integer> ints = new Stack<Integer>(); // Integer ��ü�� ������ Stack ��ü�� �����Ͽ�  ints�� �����ϰ� ��
 *       
 *   2) ���� ������ �Է��Ͽ� ints�� �����ϵ��� �߰��� �ۼ��ϱ� ���� ������ �޼ҵ带 �ۼ��϶�.
 *      
 *        static void addInts(int n)   // n�� Stack ��ü ints�� Ǫ���ϴ� �޼ҵ�
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� Stack ��ü ints�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� ints�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // Stack ��ü ints�� ����� ��� ������ �˽�Ű�鼭 ����ϴ� �޼ҵ� 
 *        
 *   3) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *         inputInts();
 *         outputAllInts();    
 */