package example11_2_person_mgmt;

import java.util.Vector;

/**
 * [ storePerson_NotUsingGeneric ]: 
 *      ���׸� Ŭ������ Ÿ�ԸŰ����� ���� ������ ���̴� ����(Vector�� Ÿ�� �Ű������� �����Ͽ� ���ҵ��� �����ϰ� ������ �۾��� ���̴� ��)
 * 
 *   o Ÿ�� �Ű������� ������ Vector Ŭ������ ��ü ������ ����
 *     - Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� 
 *         << vector<����Ŭ����> ��ü�������� = new Vector<����Ŭ����)() >> �������� ���
 *         
 *     - Ÿ�� �Ű����� ���� �����ϹǷ� ���׸� Ŭ���� �����ϱ� ���� ������
 *         << Vector ��ü�������� = new Vector(); >>�ε� ��� ����
 *         
 *     - Ÿ�� �Ű����� �����ϸ� 
 *         << Vector<Object> ��ü�������� = new Vector<Object)() >>�� ������ �ڵ�
 *         
 *     - �� ��� Vector�� ��� Ŭ������ ��ü ������ �� ������, Ư�� Ŭ������ ��ü�� ������ �� ����
 *        
 *     - Ÿ�� �Ű������� ������ ��: Vector strings = new Vector(); 
 *       �̴� << Vector<Object> strings = new Vector<Object>(); >>�� ������
 *    
 *     - Vector ��ü�� ����� ��ü�� get() �޼ҵ�� �˻��ϸ� Object Ŭ������ ��ü ��ȯ�ǹǷ�
 *       ���� Ŭ������ ��ü�� ����ϱ� ���ؼ��� �ٿ�ĳ�����ؾ� ��
 *      
 *     - �ٿ� ĳ���� ��
 *         strings.add("ȫ�浿");  // String ��ü�� Vector strings�� �߰�
 *         String s = (String) strings.get(0);  // String ���Ҹ� �����ϱ� ���� �ٿ�ĳ�����ؾ���
 *
 *  o main()���� Ÿ�� �Ű������� ������ Vector ��ü�� ���ڿ��� ������ �� ����� ������ ���ڿ��� �˻��Ͽ� �����
 *    
 */

class Ex11_4_8_StorePerson_NotUsingGeneric {  

	public static void main(String[] args) {	
		// Vector ��ü�� �����Ͽ� persons�� �����ϰ� ��(�ǵ��� Person ��ü�� �����ϱ� ������)
		Vector persons = new Vector(); 

		persons.add( new Person("ȫ�浿", 18) ); // ȫ�浿 ��ü�� persons�� �߰�
		persons.add( new Person("�̸���", 16) ); // �̸��� ��ü�� persons�� �߰�
		Person p = new Person("��ö��", 23);
		persons.add(0, p);                     // ��ö�� Person ��ü�� persons�� 0 ��ġ�� �߰� 

		for (int i =0; i < persons.size(); i++) {  // persons�� ����� ���� ������ŭ
			p = (Person) persons.get(i);           //   �ε��� i�� ���� ���Ͽ� Person���� �ٿ�ĳ�����Ͽ�
			p.output();                            //   ��� 
		}	
		
	    persons.add(1, "ȫ�浿");      // persons�� ���ڿ� "ȫ�浿"�� 1�� ��ġ�� ���� ������
	    p = (Person) persons.get(1); // 1 ��ġ�� ���� ���Ͽ� Person���� ĳ��Ʈ  - String�� Person���� ĳ�����ϹǷ� ���� �߻���		
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   1) �� ���α׷��� ������ ������ ������ ��� �޽��ڰ� ���� �� ������, ��� �޽��� ������ ������ ����.
*   
*      Vector is a raw type. References to generic type Vector<E> should be parameterized
*      
*      �� ��� �޽����� Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� Ÿ�� �Ű������� �־����� ������ �־����� �ʾҴٴ� ���� ��Ÿ����.
*      
*      ���׸� Ÿ���� ��� Ÿ�� �Ű������� �־����� ������ Ÿ�� �Ű������� Object�� �����Ͽ� ó���ϹǷ� 
*      << Vector persons = new Vector(); >>�� << Vector<Object> persons = new Vector<Object>(); >>�� �����ϴ�.
*   
*   2) ���� �̸� persons��  Persons ��ü�� �����ϴ� ������ ���Ǿ�����
*      << persons.add(1, "ȫ�浿"); >>���� persons�� String "ȫ�浿"�� �߰��ص� 
*      String�� Object�� ���� Ŭ�����̹Ƿ� ���� ���� ����ȴ�.
*      
*   3) << p = (Person) persons.get(1); >>�� persons.get(1)�� ����� String "ȫ�浿"�� ��ȯ�Ǹ�,
*      Person ��ü�� �ƴ� String "ȫ�浿"�� Person Ŭ������ ��ü�� �ٿ�ĳ�����ϸ� 
*      ������ �߻��Ѵ�.  
*/
