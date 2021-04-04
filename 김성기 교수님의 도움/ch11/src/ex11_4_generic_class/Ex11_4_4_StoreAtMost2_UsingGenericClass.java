package ex11_4_generic_class;

/**
 * [ StoreAtMost2_UsingGenericClass ]: ���׸� Ŭ������ �ʿ伺 ���̴� ����
 *       ���� Ŭ������ ��ü���� 2�������� �����ϰ� �˻��ϴ� ���׸� Ŭ���� �ۼ�
 * 
 *   o ���׸� Ŭ����
 *     - Ŭ���� ���𿡼� Ÿ�� �Ű������� ���ԵǴ� Ŭ����
 *     - << class Ŭ�����̸�< Ÿ��_�Ű����� > { ...  } >>���� Ŭ���� �̸� ������ <�� > ���̿� Ÿ�� �Ű����� ǥ��
 *     - Ŭ���� ���𿡼��� Ÿ�� �Ű����� �̸��� �־����� Ÿ�� �Ű������� ���� �־����� �����Ƿ� Ŭ������ ������ ���ǵ��� ����
 *     - Ŭ���� ����� �� Ÿ�� �Ű������� ������ Ŭ������ �־����Ƿ� ������ Ŭ������ ����
 *         
 *   o Ÿ�� �Ű�����
 *     - Java�� Ÿ�Կ� �ش�Ǵ� Ŭ������ �������̽��� ������ ���� �Ű�����
 */

// StoreAtMost2<T>: Ŭ���� T�� ��ü 2�������� �����ϰ� �˻��ϴ� ����� �����ϴ� ���׸� Ŭ����
class StoreAtMost2<T> {   
	String title;
	T first, second; // T Ŭ���� ��ü 2���� �����ϴ� �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	StoreAtMost2(String title) {  
		this.title = title;
	}

	// �־��� T ��ü o�� �����ϴ� �޼ҵ� - 2���� �̹� ����Ǿ����� ù ��° ���� 
	void add(T o) {   
		if (first == null)  // �ϳ��� ������� �ʾ����� o�� first�� ����
			first = o;
		else if (second == null)  // �ϳ���o�� second�� ����
			second = o;
		else {              // �̹� 2���� ��� ����Ǿ��ٸ� ù ��° ���ְ� 2�� ���� 
			first = second; //  second�� first�� ����
			second = o;     //  o�� second�� ���� 
		}
	}

	// first�� ����� ��ü�� ��ȯ�ϴ� �޼ҵ�
	T getFirst() {     
		return first;
	}

	// second�� ����� ��ü�� ��ȯ�ϴ� �޼ҵ�
	T getSecond() {     
		return second;
	}
	
	// title�� first, second�� ����� ��ü�� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";     // Ÿ��Ʋ�� ���ڿ��� �߰�
		if (first != null) s = s + "[" + first + "]";      // first�� ���ڿ��� �߰�
		
		if (second != null) s = s + ", [" + second + "] "; // second�� ���ڿ��� �߰�      
		
		return s;
	}

	// title�� first, second�� ����� ��ü�� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_4_StoreAtMost2_UsingGenericClass {  
	public static void main(String[] args) {   
		
		// StoreAtMost2<Integer> ��ü �����Ͽ� ageAtMost2�� �����ϰ� �� 
		StoreAtMost2<Integer> ageAtMost2 = new StoreAtMost2<Integer>("����  ����");  

		ageAtMost2.add( 18 ); // 18�� ageAtMost2�� �߰�
		ageAtMost2.output();        

		// StoreAtMost2<String> ��ü �����Ͽ� nameAtMost2�� �����ϰ� �� 
		StoreAtMost2<String> nameAtMost2 = new StoreAtMost2<String>("�̸� ����");  

		nameAtMost2.add( "ȫ�浿" ); // �̸� ȫ�浿�� nameAtMost2�� �߰�
		nameAtMost2.add( "�̸���" ); // �̸� �̸����� nameAtMost2�� �߰�
		nameAtMost2.output();        

		// StoreAtMost2<Person> ��ü �����Ͽ� personAtMost2�� �����ϰ� �� 
		StoreAtMost2<Person> personAtMost2 = new StoreAtMost2<Person>("�Ż����� ����");  

		personAtMost2.add( new Person("ȫ�浿", 18) ); // �̸��� ��ü�� �߰�
		personAtMost2.add( new Person("�̸���", 16) ); // �̸��� ��ü�� �߰�
		personAtMost2.add( new Person("��ö��", 23) ); // ��ö�� ��ü�� �߰� 
		personAtMost2.output();  
		
	}
} 

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ���� 11-4-3�� 2������ ��ü�� �����ϴ� 3���� ������ Ŭ������ 
 *      �ϳ��� ���׸� Ŭ���� StoreAtMost2<T>�� �ۼ��ϰ� 
 *      main() �޼ҵ忡�� 3���� ��ü�� �����Ͽ� ageAtMost2, nameAtMost2, PersonAtMost2��
 *      �����ϰ� �Ѵ�. 
 *      
 *      ��ü �������� ����� ��ü ���� �ÿ��� <�� > ���̿� ������ ������ Ÿ���� ����Ѵ�.
 *     
 *   2) �ۼ��� ���׸� Ŭ������ ���� ������ ���������� �ľ��϶�.
 *      (1) Ÿ�� �Ű������� �̿��Ͽ� �������� Ŭ���� �����ϴ� ���
 *      (2) ���ǵ� ���׸� Ŭ������ ����ϴ� ���
 *          . ���׸� Ŭ������ �������� ���� ���
 *          . ���׸� Ŭ������ ��ü ���� ���
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) Character ��ü�� 2������ �����ϰ� ����ϱ� ���Ͽ� �ʿ��� �ڵ带 main() �޼ҵ忡 �ۼ��϶�. 
 *      'ȫ', '��', '��'��   �߰��ϰ� ��µ� ����� Ȯ���϶�.
 *       
 *   2) Double ��ü�� 2������ �����ϰ� ����ϱ� ���Ͽ� �ʿ��� �ڵ带 main() �޼ҵ忡 �ۼ��϶�. 
 *       177.7, 162.0, 172.2�� �߰��ϰ� ��µ� ����� Ȯ���϶�.
 *       
 *   3) nameAtMost2 ��ü�� Person ��ü�� �����ϸ� ��� �Ǵ°��� Ȯ���϶�.
 *      ���� personAtMost2 ��ü�� ���ڿ��� �����ϸ� ��� �Ǵ°��� Ȯ���϶�.
 *      
 *      
 * [ �������  ] 
 *    
 *    o ���⿡���� ���׸� Ŭ������ �ۼ��Ͽ����Ƿ� ������ Ŭ������ �ۼ��� �ʿ�� ����.     
 */