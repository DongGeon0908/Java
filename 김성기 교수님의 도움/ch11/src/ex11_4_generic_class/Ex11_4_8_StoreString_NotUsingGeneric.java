package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ storeString_NotUsingGeneric Ŭ���� ]: 
 *       ���׸� Ŭ������ Ÿ�ԸŰ������� ���� ������ ���̴� ����
 *       (Vector�� Ÿ�� �Ű����� �����Ͽ� ���ҵ� �����ϰ� ������ �۾� ���̴� ����)
 *       
 *   o Ÿ�� �Ű����� ���� ���׸� Ŭ���� ����ϱ�
 *     - ���׸� Ŭ������ JDK 1.5���� �����Ǿ����Ƿ� �������� Ÿ�� �Ű����� ������
 *     - ���ݵ� ���׸� Ŭ���� ��� �� Ÿ�� �Ű����� �����ص� ��
 *     - Ÿ�� �Ű����� �����ϸ� ��� �޽��� ��Ÿ��
 * 
 *   o Vector Ŭ������ ���� ������ ���� �� �˻� �����ϴ� ���׸� Ŭ����
 *     - ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ� ����
 *     - ��ü������ ���� ���� ����, �ʿ�� ���� ���� �߰��� Ȯ��
 *     - ���׸� Ŭ�����̹Ƿ� ���� ���� �Ǵ� ��ü ������ ȣ��� ���� Ŭ������ Ÿ�� �Ű������� �־���
 *     - Ÿ�� �Ű����� �����ص� ������, �������� ����
 *    
 *   o Ÿ�� �Ű������� ������ Vector Ŭ������ ��ü ������ ����
 *     - Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� 
 *          << vector<����Ŭ����> ��ü�������� = new Vector<����Ŭ����)() >> �������� ���
 *         
 *     - Ÿ�� �Ű����� ���� �����ϹǷ� ���׸� Ŭ���� �����ϱ� ���� ������
 *          << Vector ��ü�������� = new Vector(); >>�ε� ��� ����
 *         
 *     - Ÿ�� �Ű����� �����ϸ� 
 *          << Vector<Object> ��ü�������� = new Vector<Object)() >>�� ������ �ڵ�
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
 *          strings.add("ȫ�浿");  // String ��ü�� Vector strings�� �߰�
 *          String s = (String) strings.get(0);  // String ���Ҹ� �����ϱ� ���� �ٿ�ĳ�����ؾ���
 *
 *   o main()���� Ÿ�� �Ű������� ������ Vector ��ü�� ���ڿ��� ������ �� ����� ������ ���ڿ��� �˻��Ͽ� �����
 */

class Ex11_4_8_StoreString_NotUsingGeneric { 
	public static void main(String[] args) {   
		// Ÿ�� �Ű����� �����Ͽ� ��� ��ü �����ϴ� Vector ��ü �����Ͽ� strings�� �����ϰ� �� 
		Vector strings = new Vector(); 

		strings.add( "ȫ�浿" );     // ȫ�浿�� strings�� �߰�
		strings.add( "�̸���" );     // �̸����� strings�� �߰�
		strings.add(0, "��ö��");    // ��ö�� ���ڿ��� strings�� 0 ��ġ�� �߰� 

		for (int i = 0; i < strings.size(); i++) {  // strings�� ����� ���� ������ŭ
			String s = (String) strings.get(i);     //  ���� ���Ͽ� String���� �ٿ�ĳ�����Ͽ�
			System.out.println(s);                  //  ��� 
		}   

		strings.add(1, 3);                   // strings�� 1�� ��ġ�� 3�� ���� ������
		String s = (String) strings.get(1);  // 1 ��ġ ���� ���Ͽ� String���� �ٿ�ĳ�����ϸ�
		                                     //    ���� �� ���� �߻���                    
	}
} 

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   1) �� ���α׷��� ������ ������ ������ ��� �޽����� ���� �� ������, 
*      << Vector strings = new Vector(); >>������ ��� �޽��� ������ ������ ����.
*      
*      Vector is a raw type. References to generic type Vector<E> should be parameterized
*      
*      - �� ��� �޽����� Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� Ÿ�� �Ű������� �־����� ������ 
*        �־����� �ʾ����� ��Ÿ��
*      
*      - ���׸� Ÿ���� ��� Ÿ�� �Ű������� �־����� ������ Ÿ�� �Ű������� Object�� �����Ͽ� ó�� 
*      - << Vector persons = new Vector(); >>�� 
*        << Vector<Object> persons = new Vector<Object>(); >>�� ����
*   
*   2) << persons.add(1, "ȫ�浿"); >>���� persons�� String "ȫ�浿"�� �߰��ص� 
*      String�� Object�� ���� Ŭ�����̹Ƿ� ���� ���� ����ȴ�.
*      
*   3) << strings.add(1, 3); >>���� ���ڿ��� �ƴ� 3�� strings�� �߰��ϸ� 
*      3�� Wrapper Ŭ���� Integer�� ��ü�� �ڵ� �ڽ̵Ǿ� ���� ���� ����ȴ�.
*      
*      ���� strings�� << Vector<String> strings = new Vector<String>(); >>���� ����Ǹ�
*      strings�� 3�� �߰��� �� ����.
*      
*   4) << s = (String) strings.get(1); >>���� strings.get(1)�� ����� Integer ��ü�� ��ȯ�Ǹ�, 
*      Integer�� ��ü�� String Ŭ������ ��ü�� ĳ�����ϸ� ���� �ÿ� ���� �߻��Ѵ�.
*   
*   5) ���α׷��� �����ϰ� ����� Ȯ���϶�.
*/