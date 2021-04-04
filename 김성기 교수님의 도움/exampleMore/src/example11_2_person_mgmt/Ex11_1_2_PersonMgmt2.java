package example11_2_person_mgmt;

/**
 * [ PersonMgmt2 ]: �迭�� ���� ������ �ִ� ���� �������� �� ���� ���Ҹ� �������� �ʵ��� �Ͽ� �ε��� ���� �ʰ� ���� �����ϱ�
 * 
 *   o �迭�� ���� ������ �ִ� ���� �������� �� ���� ���Ҹ� �����Ϸ� �ϸ� �ε��� ���� �ʰ� ������
 *     ArrayIndexOutOfBoundsException�� �߻��ϹǷ� �̸� ������ �� �ֵ��� ��ġ�ϴ� ����
 *    
 *   o ����� �迭 ���� ������ �����Ͽ� �� �̻� ������ ������ ������ �������� �ʰ� ������ 
 *     - �迭�� ���� ������ �ִ� ���� �����ϴ� ����: MAXPERSONS = 3;
 *     - �迭�� ���Ҹ� �����ϸ� ����� ���� ���� �����ϴ� ����: cntPersons
 *     - ���Ҹ� ������ �迭����: persons
 *     
 *     - ������ ������ ������(cntPersons < MAXPERSONS) ���� 
 *     - �� �̻� ������ ������ ������(cntPersons >= MAXPERSONS) �������� ����    
 *    
 *   o ���� ������ �ִ� ���� ������ 3�ε� main()���� 5�� ���Ҹ� �����Ϸ� ��
 *     - �� ������ �ִ� ���� ���� ���� ������ 3�ε� 5���� ���Ҹ� �����Ϸ� ��
 *     - 4��° ���ҿ� 5��° ���Ҹ� persons[3]�� �����Ϸ� �ϸ� ���� ����� ���� ������ �ִ� ���� ������ �����Ƿ� 
 *       �迭�� �������� ����
 */

class Ex11_1_2_PersonMgmt2 {  
	static int MAXPERSONS = 3;   // �ִ� ���� ������ ��Ÿ���� ����
	static Person[] persons = new Person[MAXPERSONS];  // Person ��ü ������ �迭����
	static int cntPersons = 0;   // �迭������ ����� ���Ұ����� ��Ÿ���� ����

	// Person ��ü p�� Person �迭 persons[]�� �����ϴ� �޼ҵ�	
	static void addPerson(Person p) {
		// ÷���� ���� ������ ������ �����ϰ� ������ �������� ����
		if (cntPersons < MAXPERSONS)
			persons[cntPersons++] = p; // p�� persons[]�� �����ϰ� ���Ұ��� 1 ����
	}

	// n���� Person ��ü �����ϰ� �Ż����� �Է��Ͽ� Person �迭 persons[]�� �����ϴ� �޼ҵ�
	static void inputPersons(int n) {
		System.out.println("\n\n  **** " + n +"�� �Ż����� �Է� ****");
		for (int i = 1; i <= n; i++) {
			Person p = new Person();	  // Person ��ü�� ����	 	
			p.input("\n  ** " + i + "��° �Ż�����(�̸�, ����, ����ġ) �Է� **");
			addPerson(p);                 // p�� persons�� ����
		}
	}
	
	// �Ż����� �ο��� �Է��Ͽ� �ο����� Person ��ü �����ϰ� �Ż����� �Է��Ͽ� persons�� �����ϴ� �޼ҵ�
	static void inputPersons() {
		System.out.println("\n\n  **** �Ż����� �Է� ****");
		int no = SkScanner.getInt("\n  o �Է��� �Ż����� �ο��� > ");
		
		inputPersons(no);
	}

	// Person �迭 persons[]�� ����� ��� Person ��ü�� ����ϴ� �޼ҵ�
	static void outputAllPersons() {
		System.out.println("\n\n  ** " + cntPersons + "�� �Ż����� **");
		for (int i = 0; i < cntPersons; i++)    // persons.size() ������ ���ҿ� ����
			persons[i].output();	           //    �ε��� i�� ���Ҹ� ���
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
 *   2) �� ���α׷��� ���ܸ� �߻���Ű���� ������  5���� Person ��ü �߿��� 3���� ����ǰ� 2���� �������
 *      ������ Ȯ���� Ȯ���϶�.
 *   
 * [ �ǽ����� ]
 *   
 *   1) �ִ� ���� 10���� �����ϴ� int �迭��ü�� �����Ͽ� �迭���� ints[]�� �����ϰ�
 *      11���� ������ �Է��Ͽ� ints[]�� �����ϵ��� �߰��� �ۼ��ϱ� ���� ������ �޼ҵ带 �ۼ��϶�.
 *       
 *        static void addInts(int n)   // n�� ints[]�� ���� �����ϴ� �޼ҵ�� ���� ������ �ִ� ���� ������ ������ ���̻� �������� ����
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� int[]�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� ints[]�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // ints[]�� ����� ��� ������ ����ϴ� �޼ҵ� 
 *        
 *   2) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *         inputInts();  // ���⿡�� 11�� �̻� �Է��ϵ��� ��
 *         outputAllInts();
 *      
 *   3) �� ���α׷��� ���ܸ� �߻���Ű���� ������  5���� Person ��ü �߿��� 3���� ����ǰ� 2���� �������
 *      �ʴ´�. 
 *      
 *      �̷� ���� ������ �������� �����Ͽ� ����.
 */
