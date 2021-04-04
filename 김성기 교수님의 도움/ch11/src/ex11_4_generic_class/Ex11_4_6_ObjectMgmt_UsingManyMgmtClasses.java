package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ Ex11_4_6_ObjectMgmt_UsingManyMgmtClasses Ŭ���� ]: 
 *          ���׸� Ŭ������ �ʿ伺�� ���̴� ���α׷�
 *          (Ư�� Ŭ������ ��ü���� �����ϴ� ���� ���� Ŭ�������� �ۼ���)
 * 
 *   o ��ü���� �����ϴ� 3���� Ŭ������
 *     - IntegerMgmt: Integer ��ü���� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ����
 *     - StringMgmt: ���ڿ��� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ���� 
 *     - PersonMgmt: Person ��ü���� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ����
 *  
 *   o ����� ����� ������ ������ Ŭ������
 *      - �̵� 3 Ŭ������ �� Ŭ������ ��ü2�������� �����ϰ� �˻��ϴ� ����Ǵ� ����� ����
 *      - �ʵ�� �޼ҵ嵵 �����ϰ� �ۼ��Ǿ� ���� 
 *    
 *   o ������ Ŭ�������� ������ �ʿ伺
 *     - Employee Ŭ������ ���� �����ϰ� �˻��Ϸ��� StoreEmployeeAtMost2t Ŭ������ �Ǵٽ� �ۼ��ؾ� ��
 *     - Ŭ�������� ���� Ŭ������ �ۼ��ؾ� �ϹǷ� ���� Ŭ������ �ۼ��ؾ� �ϴµ�, �̴� ���׸� Ŭ������ �ʿ��� ������
 *     - �Ű����� ���� ���� ������ �޼ҵ带 �Ű����� ���� �ϳ��� �޼ҵ�� �����ϴ� �Ͱ� ������ ������
 *     - Ŭ������ �Ű������� �������� �����Ͽ� ���� ������ Ŭ�������� �ϳ��� ���׸� Ŭ������ �ۼ�
 */

//IntegerMgmt: Integer ��ü���� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ����
class IntegerMgmt {   
	String title;
	Vector<Integer> integers = new Vector<Integer>(); // Integer Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	IntegerMgmt(String title) {  
		this.title = title;
	}

	// �־��� Integer ��ü�� Vector �ʵ� integers�� �����ϴ� �޼ҵ�
	void add(Integer i) {   
		integers.add(i);
	}

	// Vector �ʵ� integers�� ����� i ��ġ�� ��ü�� ��ȯ�ϴ� �޼ҵ�
	Integer get(int i) {     
		return integers.get(i);
	}

	// title�� integers�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";     // Ÿ��Ʋ�� ���ڿ��� �߰�
		for (Integer i: integers)   // integers�� �� ����  i�� ����
			s = s + "[ " + i.toString() + " ] ";  // i�� s�� �߰�
     
		return s;
	}

	// title�� integers�� ����� ��ü���� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

//StringMgmt: ���ڿ��� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ���� 
class StringMgmt {   
	String title;
	Vector<String> strings = new Vector<String>(); // String Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	StringMgmt(String title) {  
		this.title = title;
	}

	// �־��� String Ŭ������ ��ü�� Vector �ʵ� strings�� �����ϴ� �޼ҵ�
	void add(String str) {   
		strings.add(str);
	}

	// Vector �ʵ� strings�� ����� i ��ġ�� ��ü�� ��ȯ�ϴ� �޼ҵ�
	String get(int i) {     
		return strings.get(i);
	}

	// title�� strings�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";         // Ÿ��Ʋ�� ���ڿ��� �߰�
		for (String str: strings)         //strings�� �� ���� str�� ����
			s = s + "[ " + str.toString() + " ] ";  // str�� s�� �߰�
		
		return s;
	}

	// title�� strings�� ����� ��ü���� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

// PersonMgmt: Person ��ü���� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ����
class PersonMgmt {   
	String title;
	Vector<Person> persons = new Vector<Person>(); // Person Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	PersonMgmt(String title) {  
		this.title = title;
	}

	// �־��� Person Ŭ������ ��ü�� Vector �ʵ� persons�� �����ϴ� �޼ҵ�
	void add(Person p) {   
		persons.add(p);
	}

	// Vector �ʵ� persons�� ����� i ��ġ�� ��ü�� ��ȯ�ϴ� �޼ҵ�
	Person get(int i) {     
		return persons.get(i);
	}

	// title�� persons�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";           // Ÿ��Ʋ�� ���ڿ��� �߰�
		for (Person p: persons)           // persons�� �� ���� p�� ����
			s = s + "[ " + p.toString() + " ] ";  // p�� ���ڿ� ������ [�� ] ���̿� �߰�

		return s;
	}

	// title�� persons�� ����� ��ü���� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_6_ObjectMgmt_UsingManyMgmtClasses {  
	public static void main(String[] args) {   
		// IntegerMgmt ��ü �����Ͽ� ageMgmt�� �����ϰ� �� 
		IntegerMgmt ageMgmt = new IntegerMgmt("���� ����");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();        		
		
		// StringMgmt ��ü �����Ͽ� nameMgmt�� �����ϰ� �� 
		StringMgmt nameMgmt = new StringMgmt("�̸� ����");  

		nameMgmt.add( "ȫ�浿" ); 
		nameMgmt.add( "�̸���" ); 
		nameMgmt.add( "��ö��" ); 

		nameMgmt.output();        
		
		
		// PersonMgmt ��ü �����Ͽ� persontMgmt�� �����ϰ� �� 
		PersonMgmt personMgmt = new PersonMgmt("�Ż����� ����");  

		personMgmt.add( new Person("ȫ�浿", 18) ); 
		personMgmt.add( new Person("�̸���", 16) ); 
		personMgmt.add( new Person("��ö��", 23) ); 

		personMgmt.output();  
	}
} 

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� 3���� ���� Ŭ������ ������ �ۼ��ϰ� main() �޼ҵ忡�� ���� Ŭ���� ��ü�� �����ϰ�
 *      Ŭ������ ��ü�� ���� ��ü�� �߰��ϰ� ����Ѵ�.
 *      
 *      �̵� Ŭ������ �ϳ��� Ŭ������ �����ϸ� ���� 11-4-5�� ���׸� Ŭ������ �ȴ�. 
 *     
 *   2) 3���� ���� Ŭ������ ���� ������ ��Ȯ�� �ľ��϶�.
 *      (1) ���� Ŭ�������� ����� ������
 *      (2) ���� Ŭ�������� �ʵ�� �޼ҵ��� ������
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) Character ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ������ CharacterMgmt�� �ۼ��Ͽ�
 *      �� Ŭ������ ��ü�� �����Ͽ� 'ȫ', '��', '��'�� �����ϰ� ����϶�.
 *       
 *   2) Double ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� Ŭ������ DoubleMgmt�� �ۼ��ϰ�
 *      �� Ŭ������ ��ü�� �����Ͽ� 177.7, 162.0, 172.2�� �����ϰ� ����϶�
 *  
 *     - CharacterMgmt Ŭ������ DoubleMgmt Ŭ������ IntegerMgmt Ŭ������ ���� �ʵ�� �޼ҵ带 �������� �ۼ��ϸ� 
 *       �ʵ� �̸��̳� �Ű����� �̸��� �ʿ�� �޸��ϵ��� �Ѵ�.
 *      
 *   3) �Ű������� ���� ������ �޼ҵ带 �ۼ��� ���� �������� ���� ������ ���� Ŭ������ �ۼ��� ���� �������� 
 *      ������ �������ΰ��� �����غ���. 
 *      
 *   4) 3���� ���� Ŭ�������� �ʵ� �̸�, �޼ҵ� �Ű����� �̸�, �������� �̸� ���� ���� �ٸ� �͵��� �� �� �ִ�.
 *      �̵��� ��� ������ �̸����� �����϶�(�̴� �̵� Ŭ�������� ���ս�Ű�� ���� �ʿ��� ���� �۾��̴�). 
 *      
 *      ���� ���, Vector �ʵ��� �̸����� integers, strings, persons �� 3���� �ٸ� �̸��� ���ǰ� �ִ�.
 *      �� �ʵ� �̸��� objects��� ������ �̸��� �����ϸ� �ȴ�.
 *      
 *      �׿�, add() �޼ҵ��� �Ű������� �������� �̸����� Integer i, String str, Person p ���� �ִ�.     
 */