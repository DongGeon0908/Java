package example11_2_person_mgmt;

/**
 * [ PersonMgmt3 ]: �� ���� ���Ҹ� �����ϴ� ������� Ȯ���Ͽ� �ε��� ���� �ʰ� ���� �����ϱ�
 * 
 *   o �迭�� �ִ� ���� ���� ���Һ��� �� ���� ���Ҹ� �����Ϸ� �ϸ� �ε��� ���� �ʰ� ������
 *     ArrayIndexOutOfBoundsException�� �߻��ϹǷ� �̸� ������ �� �ֵ��� ��ġ�ϴ� ����
 *    
 *   o ����� �迭 ���� ������ �����Ͽ� �� �̻� ������ ������ ������ ���ο� �迭��ü �Ҵ��Ͽ� ���� 
 *     - �迭�� ���� ������ �ִ� ���� ������ �����ϴ� ����: MAXPERSONS = 3;
 *     - �迭�� ���Ҹ� �����ϸ� ����� ���� ������ �����ϴ� ����: cntPersons
 *     - ���Ҹ� ������ �迭��ü ������ ��������: persons
 *     
 *     - ������ ������ ������(cntPersons < MAXPERSONS) ������ 
 *     - �� �̻� ������ ������ ������(cntPersons == MAXPERSONS) �߰����� ������� �Ҵ��Ͽ� ����       
 *       1) �� ���� ���� ���� ������ �迭��ü ����
 *       2) ������ ���ҵ��� ���ο� �迭��ü�� ����
 *       3) persons�� ���ο� ��ü �����ϰ� ��
 *       4) �ִ� ���� ������ ������ �ִ� ������ ����
 *    
 *   o ���� ������ �ִ� ���� ������ 3�ε� main()���� 5�� ���Ҹ� �����Ϸ� ��
 *     - 4��° ���Ҹ� persons[3]�� �����Ϸ� �ϸ� ���� ����� ���� ������ �ִ� ���� ������ �����Ƿ� 
 *       ���ο� �迭���� Ȯ���Ͽ� ������ 
 */

class Ex11_1_3_PersonMgmt3 {  
	static int MAXPERSONS = 3;   // ���� ������ �ִ� ���� ������ ��Ÿ���� ����
	static Person[] persons = new Person[MAXPERSONS];  // Person ��ü ������ �迭����
	static int cntPersons = 0;   // �迭������ ����� ���Ұ����� ��Ÿ���� ����

	// Person ��ü p�� Person �迭 persons[]�� �����ϴ� �޼ҵ�
	static void addPerson(Person p) {     
		if (cntPersons >= MAXPERSONS) {  // ���� ������ ������ ������       
			int maxNew = MAXPERSONS * 2;              // ���� �ִ� ���� 2���� 
			Person[] personsNew = new Person[maxNew]; //      ������� Ȯ��

			copyPersons(persons, personsNew); // ���ο� ������ ���� ���ҵ� ����
			persons = personsNew;             // persons[]�� ���ο� ������� ����
			MAXPERSONS = maxNew;              // �ִ� ���� ������ ����
		}

		// ������ ���� ������ ������ �׻� �ְ� �ǹǷ� 
		persons[cntPersons++] = p;  // p�� persons[]�� ����, ���Ұ��� 1 ����
	}

	// Person �迭 src[]�� ���ҵ��� ��� Person �迭 dest[]�� �����ϴ� �޼ҵ�
	static void copyPersons(Person[] src, Person[] dest) {
		for (int i = 0; i< src.length; i++)  // src[]�� ���� ������ŭ
			dest[i] = src[i];                //   src[]�� ���Ҹ� dest[]�� ���ҷ� ����
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

	// �Ż����� �ο��� �Է��Ͽ� �� �ο�����ŭ�� �Ż����� �Է��Ͽ� persons�� �����ϴ� �޼ҵ�
	static void inputPersons() {
		System.out.println("\n\n  **** �Ż����� �Է� ****");
		int no = SkScanner.getInt("\n  o �Է��� �Ż����� �ο��� > ");
		
		inputPersons(no);
	}
	
	// Person �迭 persons[]�� ����� ��� Person ��ü�� ����ϴ� �޼ҵ�
	static void outputAllPersons() {
		System.out.println("\n\n  ** " + cntPersons + "�� �Ż����� **");
		for (int i = 0; i < cntPersons; i++)    // persons.size() ������ ���ҿ� ����
			persons[i].output();	            //    �ε��� i�� ���Ҹ� ���
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
 *   3) ���� ������ �ִ� ���� ������ ����Ͽ� ��ȭ�� ���� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 *   
 *   1) ������ ���� ���� 10���� �����ϴ� int �迭��ü�� �����Ͽ�  �迭���� ints[]�� �����϶�.
 *   
 *   	static int MAXINTS = 10;   // ���� ������ �ִ� ���� ������ ��Ÿ���� ����
 *	    static ints[] ints = new int[MAXINTS];  // int �� ������ �迭����
 *	    static int cntInts = 0;   // �迭������ ����� ���� ������ ��Ÿ���� ����
 *
 *   2) ���� ������ �Է��Ͽ� ints[]�� �����ϰ� ����ϵ��� ������ �޼ҵ带 �߰��� �ۼ��϶�.
 *      
 *        static void addInts(int n)   // n�� ints[]�� ���� �����ϴ� �޼ҵ��, ����� ���� ������ �ִ� ���� ������ ������ �߰� ��������� Ȯ����
 *        static void copyInts(int[] src, int[] dest)   // int �迭 src[]�� ���ҵ��� ��� int �迭 dest[]�� �����ϴ� �޼ҵ�
 *        static void inputInts(int n) // n���� ������ �Է��Ͽ� int[]�� �����ϴ� �޼ҵ� 
 *        static void inputInts()      // ���� ������ �Է��Ͽ� �� ������ ������ �Է��� int[]�� �����ϴ� �޼ҵ�        
 *        static void outputAllInts()  // ints[]�� ����� ��� ������ ����ϴ� �޼ҵ� 
 *        
 *   3) main()���� ������ ȣ���Ͽ� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *        inputInts();   // ���⿡�� 11�� �̻� �Է��ϵ��� ��
 *        outputAllInts();      
 */