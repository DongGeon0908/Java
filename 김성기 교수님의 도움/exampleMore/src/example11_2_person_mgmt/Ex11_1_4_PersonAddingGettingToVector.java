package example11_2_person_mgmt;

import java.util.Vector;

/**
 * [ PersonAddingGettingToVector ]: Vector Ŭ������ ����Ͽ� ���� �����͸� �����ϰ� ������ �۾��� ���̴� ��
 * 
 *   o Vector Ŭ������ ���� �����͸� �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ������ 
 *     - Vector�� �̿��Ͽ� ���Ҹ� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���Ҹ� ������ ������ �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ������ �߰��� Ȯ����
 *    
 *   o Vector Ŭ������ ��ü ������ ����
 *     - Vector<����_Ŭ����> ��ü�������� = new Vector<����_Ŭ����>();
 *     - Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� ������ ��ü�� Ŭ������ ����� <�� > ���̿� �����
 *    
 *     - Vector<Person> persons = new Vector<Person>(); // <Person>�� ���� Ŭ���� ǥ�� 
 *    
 *   o Vector Ŭ������ �ֿ� �޼ҵ�  
 *     - ���Ҹ� �߰��ϴ� �޼ҵ�� add(E element)��  add(int index, E element)
 *       1) add(E element) �޼ҵ�: ������ ������ ��ġ�� ���� element�� ����
 *          Ư�� �̶��� ������ ������ ������ �ڵ������� ������ Ȯ���Ͽ� ���� ����
 *       2) add(int index, E element) �޼ҵ�: Vector�� ��ġ inex�� ���� element�� �߰�
 *          �߰��Ǵ� ��ġ������ ���ҵ��� �ڷ� �ϳ��� �̵���Ŵ 
 *         
 *     - Vector ��ü�� ����� ���Ҹ� �����ϱ� ���� �޼ҵ�
 *       1) remove(int index) �޼ҵ�: index ��ġ�� ���Ҹ� �����ϰ� ������ ���Ҹ� ��ȯ
 *          ���� ��ġ �̺����� ���ҵ��� ������ �ϳ��� �̵���Ŵ
 *         
 *     - ���� �� �˻��� ����  �޼ҵ�
 *       1) get(int index) �޼ҵ�: Vector���� ��ġ inex�� ���Ҹ� ��ȯ
 *       2) set(int index, E element) �޼ҵ�: Vector�� ��ġ inex�� ���Ҹ� element�� ��ü��Ŵ
 *       3) size() �޼ҵ�: ���� ����� ���� ������ ��ȯ 
 *      
 *   o main()���� Person ��ü 3���� �����Ͽ� Vector ��ü�� ������ �� ����� ��� ���Ҹ� ����� 
 */

class Ex11_1_4_PersonAddingGettingToVector {  

	public static void main(String[] args) {	
		// Person ��ü�� �����ϴ� Vector ��ü�� �����Ͽ� persons�� �����ϰ� ��
		// <Person>�� ���� Ŭ���� ǥ�� 
		Vector<Person> persons = new Vector<Person>(); 

		persons.add( new Person("ȫ�浿", 18) ); // ȫ�浿 ��ü�� persons�� �߰�
		persons.add( new Person("�̸���", 16) ); // �̸��� ��ü�� persons�� �߰�
		Person p = new Person("��ö��", 23);
		persons.add(0, p);                     // ��ö�� Person ��ü�� persons�� 0 ��ġ�� �߰� 

		for (int i =0; i < persons.size(); i++) {  // persons�� ����� ���� ������ŭ
			p = persons.get(i);                    //   �ε��� i�� ���� ���Ͽ�
			p.output();                            //   ��� 
		}	
		
		p = new Person("��û", 19);
		persons.add(1, p);		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   2) 2���� Person ��ü�� �����Ͽ� persons�� �߰��ϰ� ����� Ȯ���϶�.
 */