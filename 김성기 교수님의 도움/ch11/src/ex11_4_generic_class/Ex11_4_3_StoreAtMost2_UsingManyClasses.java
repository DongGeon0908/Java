package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ StoreAtMost2_UsingManyClasses Ŭ���� ]: ���׸� Ŭ������ �ʿ伺 ���̴� ����
 *       Ư�� Ŭ������ ��ü�� 2�������� �����ϰ� �˻��ϴ� ���� Ŭ������ �ۼ�
 * 
 *   o ��ü���� 2�������� �����ϴ� 3���� Ŭ������
 *     - StoreIntegerAtMost2: Integer ��ü 2�������� �����ϴ� �˻��ϴ� ��� �����ϴ� Ŭ����
 *     - StoreStringAtMost2: ���ڿ� 2�������� �����ϴ� �˻��ϴ� ��� �����ϴ� Ŭ���� 
 *     - StorePersonAtMost2: Person ��ü 2�������� �����ϴ� �˻��ϴ� ��� �����ϴ� Ŭ����
 *  
 *   o ����� ����� ������ ������ Ŭ������
 *     - �̵� 3 Ŭ������ �� Ŭ������ ��ü 2������ �����ϰ� �˻��ϴ� ����Ǵ� ��� ����
 *     - 3�� �̻��� ����Ǹ� ���߿� ����� 2���� �����ϰ� ���� ���� ����
 *     - �ʵ�� �޼ҵ嵵 �����ϰ� �ۼ��Ǿ� ���� 
 *    
 *   o ������ Ŭ�������� ������ �ʿ伺
 *     - Employee Ŭ������ ���� 2�������� �����ϰ� �˻��Ϸ��� StoreEmployeeAtMost2 Ŭ������ �Ǵٽ� �ۼ��ؾ� ��
 *     - Ŭ�������� �̷��� ���� Ŭ���� �ۼ��ؾ� �ϹǷ� ���� Ŭ���� �ۼ��ؾ� �� 
 *         ==> �̴� ���׸� Ŭ������ �ʿ��� ������
 *         
 *     - �Ű����� ���� ���� ������ �޼ҵ带 �Ű����� ���� �ϳ��� �޼ҵ�� �����ϴ� �Ͱ� ������ ������
 *         ==> �Ű����� �̿��Ͽ� ���� ������ Ŭ�������� �����ϸ� �ϳ��� ���׸� Ŭ������ �ۼ���
 */

// StoreIntegerAtMost2: Integer ��ü 2�������� �����ϰ� �˻��ϴ� Ŭ����
class StoreIntegerAtMost2 {   
	String title;
	Integer first, second; // Integer Ŭ���� ��ü 2�� �����ϴ� �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	StoreIntegerAtMost2(String title) {  
		this.title = title;
	}

	// �־��� Integer ��ü o�� �����ϴ� �޼ҵ� - 2���� �̹� ����Ǿ����� ù ��° ���� 
	void add(Integer o) {   
		if (first == null)        // �ϳ��� ������� �ʾ����� o�� first�� ����
			first = o;
		else if (second == null)  // �ϳ��� ����Ǿ����� o�� second�� ����
			second = o;
		else {                    // �̹� 2���� ��� ����Ǿ��ٸ� ù ��° ���ְ� �߰��Ͽ� ���� 
			first = second;       //  second�� first�� ����
			second = o;           //  o�� second�� ���� 
		}
	}

	// first�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	Integer getFirst() {     
		return first;
	}

	// second�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	Integer getSecond() {     
		return second;
	}
	
	// title�� first, second�� ����� ��ü�� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";     // Ÿ��Ʋ�� ���ڿ��� �߰�
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first�� ���ڿ��� �߰�
		
		if (second != null) s = s + ", [" + second + "] "; // second�� ���ڿ��� �߰�     
		
		return s;
	}

	// title�� first, second�� ����� ��ü ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

//StoreStringAtMost2: ���ڿ� 2�������� �����ϰ� �˻��ϴ� Ŭ����
class StoreStringAtMost2 {   
	String title;
	String first, second; // String Ŭ���� ��ü 2�� �����ϴ� �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	StoreStringAtMost2(String title) {  
		this.title = title;
	}

	// �־��� String ��ü o��  �����ϴ� �޼ҵ� - 2���� �̹� ����Ǿ����� ù ��° ���� 
	void add(String o) {   
		if (first == null)        // �ϳ��� ������� �ʾ����� o�� first�� ����
			first = o;
		else if (second == null)  // �ϳ��� ����Ǿ����� o�� second�� ����
			second = o;
		else {                    // 2���� ��� ����Ǿ��ٸ� ù��° ���ְ� 2�� ���� 
			first = second;       //   �� ��°�� first�� ����
			second = o;           //   o�� second�� ���� 
		}
	}

	// first�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	String getFirst() {     
		return first;
	}

	// second�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	String getSecond() {     
		return second;
	}
	
	// title�� first, second�� ����� ��ü���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";     // Ÿ��Ʋ�� ���ڿ��� �߰�
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first�� ���ڿ��� �߰�
		
		if (second != null) s = s + ", [" + second + "] "; // second�� ���ڿ��� �߰�    
        
		return s;
	}

	// title, first, second�� ����� ��ü ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

// StorePersonAtMost2: Person ��ü 2�������� �����ϰ� �˻��ϴ� Ŭ����
class StorePersonAtMost2 {   
	String title;
	Person first, second;   // Person Ŭ���� ��ü 2���� �����ϴ� �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	StorePersonAtMost2(String title) {  
		this.title = title;
	}

	// �־��� Person ��ü o�� �����ϴ� �޼ҵ� - 2���� �̹� ����Ǿ����� ù ��° ���� 
	void add(Person o) {   
		if (first == null)        // �ϳ��� ������� �ʾ����� o�� first�� ����
			first = o;
		else if (second == null)  // �ϳ��� ����Ǿ����� o�� second�� ����
			second = o;
		else {                    // �̹� 2���� ��� ����Ǿ��ٸ� ù ��° ���ְ� 2�� ���� 
			first = second;       //  second�� first�� ����
			second = o;           //  o�� second�� ���� 
		}
	}

	// first�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	Person getFirst() {     
		return first;
	}

	// second�� ����� ��ü ��ȯ�ϴ� �޼ҵ�
	Person getSecond() {     
		return second;
	}
	
	// title�� first, second�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title + ": ";     // Ÿ��Ʋ�� ���ڿ��� �߰�
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first�� ���ڿ��� �߰�
		
		if (second != null) s = s + ", [" + second + "] "; // second�� ���ڿ��� �߰�   
        
		return s;
	}

	// title�� first, second�� ����� ��ü���� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_3_StoreAtMost2_UsingManyClasses {  
	public static void main(String[] args) {   
		// StoreIntegerAtMost2 ��ü�� �����Ͽ� ageAtMost2�� �����ϰ� �� 
		StoreIntegerAtMost2 ageAtMost2 = new StoreIntegerAtMost2("���� ����");  

		ageAtMost2.add( 18 );                // 18�� ageAtMost2�� �߰�
		ageAtMost2.output();        
		
		
		// StoreStringAtMost2 ��ü�� �����Ͽ� nameAtMost2�� �����ϰ� �� 
		StoreStringAtMost2 nameAtMost2 = new StoreStringAtMost2("�̸� ����");  

		nameAtMost2.add( "ȫ�浿" );         // �̸� ȫ�浿�� nameAtMost2�� �߰�
		nameAtMost2.add( "�̸���" );         // �̸� �̸����� nameAtMost2�� �߰�
		nameAtMost2.output();        
		
		
		// StorePersonAtMost2 ��ü�� �����Ͽ� personAtMost2�� �����ϰ� �� 
		StorePersonAtMost2 personAtMost2 = new StorePersonAtMost2("�Ż����� ����");  

		personAtMost2.add( new Person("ȫ�浿", 18) ); // ȫ�浿 ��ü�� personMgmt�� �߰�
		personAtMost2.add( new Person("�̸���", 16) ); // �̸��� ��ü�� personMgmt�� �߰�
		personAtMost2.add( new Person("��ö��", 23) ); // ��ö�� ��ü�� personMgmt�� �߰� 
		personAtMost2.output();  
	}
} 

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� 2�������� ��ü �����ϴ� 3�� Ŭ���� ������ �ۼ��ϰ�
 *      main() �޼ҵ忡�� �̵� Ŭ���� ��ü �����Ͽ� ageAtMost2, nameAtMost2, 
 *      person AtMost2�� �����ϰ� �ϸ�, 1��, 2��, 3�� ��ü�� ���� �����Ѵ�.
 *     
 *   2) 3���� ������ Ŭ������ ���� ������ ��Ȯ�� �ľ��϶�.
 *      (1) ������ Ŭ�������� ����� ������
 *      (2) ������ Ŭ�������� �ڵ� ������
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) Character ��ü�� 2������ ����, ����, ����ϴ� ����� �����ϴ� Ŭ������ 
 *      StoreCharacterAtMost2�� �ۼ��Ͽ� �� Ŭ������ ��ü�� �����Ͽ� 'ȫ', '��', '��'�� �߰��ϰ� ����϶�.
 *       
 *   2) Double ��ü�� 2������ ����, ����, ����ϴ� ����� �����ϴ� Ŭ������ 
 *      StoreDoubleAtMost2�� �ۼ��ϰ�  �� Ŭ������ ��ü�� �����Ͽ� 177.7, 162.0, 172.2�� �߰��ϰ� ����϶�
 *      
 *   % ������� % 
 *      StoreCharacterAtMost2 Ŭ������StoreDoubleAtMost2 Ŭ������ 
 *      StoreIntegerAtMost2 Ŭ������ ���� �ʵ�� �޼ҵ带 �������� �ۼ��ϸ� 
 *      �ʵ� �̸��̳� ���� �̸��� �����ϰ� �ϵ��� �Ѵ�.
 *      
 *   3) �Ű������� ���� ������ �޼ҵ带 �ۼ��� ���� �������� ���� ������ Ŭ������ �ۼ��� ���� �������� 
 *      �������� �����غ���.     
 */