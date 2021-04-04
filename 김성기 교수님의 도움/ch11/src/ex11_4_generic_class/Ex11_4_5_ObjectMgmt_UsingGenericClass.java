package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ ObjectMgmt_UsingGenericClass Ŭ���� ]: 
 *        Vector Ŭ������ ����Ͽ� ���� Person ��ü���� �����ϰ� ����ϴ� �۾��� ���̴� ��
 * 
 *   o ���׸� Ŭ����
 *     - Ŭ���� ���𿡼� Ÿ�� �Ű������� ���ԵǴ� Ŭ������
 *     - << class Ŭ�����̸�<Ÿ�� �Ű�����> { ... } >>���� Ŭ���� �̸� ������ <�� > ���̿� Ÿ�� �Ű������� ǥ��
 *     - Ŭ���� ���𿡼� Ÿ�� �Ű����� �̸��� �־����� Ÿ�� �Ű������� ���� �־����� �����Ƿ� Ŭ������ ������ ���ǵ��� ����
 *     - Ŭ���� ����� �� Ÿ�� �Ű������� ������ Ŭ������ �־����Ƿ� ������ Ŭ������ ����
 *         
 *   o Ÿ�� �Ű�����
 *     - Java�� Ÿ�Կ� �ش�Ǵ� Ŭ������ �������̽��� ������ ���� �Ű�����
 *    
 *   o ���� Ÿ�� �Ű�����(formal type parameter)
 *     - ���׸� Ŭ���� ���� �� �־����� Ÿ�� �Ű�����
 *     - ���� Ÿ�� �Ű����� ����: �ϳ��� ���ڷ� ���
 *         E(�÷��� ���� Ÿ��)         N(���� Ÿ��), 
 *         K(Ű���� ��Ÿ���� Ÿ��)      V(Ű���� �����Ǵ� �� Ÿ��)
 *         T(�Ϲ��� Ÿ��)             S(2��° Ÿ�� �Ű�����)
 *          
 *     - class Mgmt<T> {  // <T>�� ���� Ÿ�� �Ű�����
 *          ...  // ���� Ÿ�ԸŰ����� T�� �̿��Ͽ� Ŭ���� ����
 *       }
 *         
 *   o �� Ÿ�� �Ű�����(real type parameter)
 *     - ��ü �������� ����, ��ü ������ ȣ�� �� ���׸� Ŭ���� ����� �� �־����� ��ü���� Ŭ����
 *     - <�� > ���̿� ��ü���� Ŭ���� �Ǵ� �������̽��� �־���   
 *    
 *     - Mgmt<Person> persons = Mgmt<Person>("�Ż����� ����");  // <Person>�� �� Ÿ�ԸŰ������� ��Ÿ��
 */

// E Ŭ������ ��ü���� ����, ����, ��� �� ������� �����ϴ� ���׸� Ŭ����
class Mgmt<E> {   
	String title;
	Vector<E> objects = new Vector<E>(); // E Ŭ���� ��ü���� �����ϴ� Vector �ʵ� 

	// �־��� title�� �ʵ� title�� �����ϴ� ��ü ������
	Mgmt(String title) {  
		this.title = title;
	}

	// �־��� E Ŭ������ ��ü�� Vector �ʵ� objects�� �����ϴ� �޼ҵ�
	void add(E element) {   
		objects.add(element);
	}

	// Vector �ʵ� objects�� ����� i ��ġ�� ��ü ��ȯ�ϴ� �޼ҵ�
	E get(int i) {     
		return objects.get(i);
	}

	// title�� objects�� ����� ��ü���� ���ڿ��� �����ϴ� �޼ҵ�
	public String toString() {  
		String s = title +": ";                         // Ÿ��Ʋ�� ���ڿ��� �߰�
		for (E element: objects)                        // objects�� element�� ����
			s = s + "[ " + element.toString() + " ] ";  //    element�� ���ڿ� ������ [�� ] ���̿� �߰�

		return s;
	}

	// title�� objects�� ����� ��ü�� ����ϴ� �޼ҵ�
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_5_ObjectMgmt_UsingGenericClass {
	public static void main(String[] args) {   
		// Mgmt<Student> ��ü �����Ͽ� students�� �����ϰ� �� 
		Mgmt<Integer> ageMgmt = new Mgmt<Integer>("���� ����");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();    
		
		// Mgmt<String> ��ü �����Ͽ� names�� �����ϰ� �� 
		Mgmt<String> nameMgmt = new Mgmt<String>("�̸� ����");  

		nameMgmt.add( "ȫ�浿" ); 
		nameMgmt.add( "�̸���" ); 
		nameMgmt.add( "��ö��" ); 

		nameMgmt.output();      
		
		// Mgmt<Person> ��ü �����Ͽ� persons�� �����ϰ� �� 
		Mgmt<Person> personMgmt = new Mgmt<Person>("�Ż����� ����");  

		personMgmt.add( new Person("ȫ�浿", 18) ); 
		personMgmt.add( new Person("�̸���", 16) );
		personMgmt.add( new Person("��ö��", 23) ); 

		personMgmt.output();   
	}
}    

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) Mgmt<E> Ŭ������ ���� ���ҵ��� �����ϰ� ����ϴ� ���׸� Ŭ�����̴�.
 *      - Ŭ���� �̸� Mgmt<E>�� Ÿ�� �Ű����� <E>�� ǥ��Ǿ� ������ Ŭ������ ��ü�� �����ϴ� Ŭ�������� ��Ÿ����.
 *      
 *      - �� Ŭ������ ����� ������ �׻� ���� ��� Ŭ������ ��Ÿ���� Ư�� Ŭ������ ������ ���� �־����� �Ѵ�.
 *      
 *        �������� ���� ��: Mgmt<Person> persons 
 *        ��ü ���� ��: new Mgmt<Person>("�Ż����� ����") 
 *              
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) �ѱ��� ���� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� ��ü�� �����Ͽ� "ȫ", "��", "��", "���"�� �����ϰ� ����϶�.
 *       
 *   2) Double ��ü�� �����ϰ� �����ϰ� ����ϴ� ���� ����� �����ϴ� ��ü�� �����Ͽ� 177.7, 162.0, 172.2�� �����ϰ� ����϶�
 *      
 *   % ������� % 
 *      ���⿡���� ������ Ŭ������ ������ �ʿ䰡 ������, main() �޼ҵ忡 �ʿ��� ������ �ۼ��ϸ� �ȴ�.
 *      
 *   3) ���׸� Ŭ������ ���� Ŭ������ ���� ���� ������ Ŭ�����̹Ƿ� ���α׷��� ������ ���������� ū ������ ���´�. 
 *      �� ������ �����ΰ��� �ٽ� �����غ���.   
 */
