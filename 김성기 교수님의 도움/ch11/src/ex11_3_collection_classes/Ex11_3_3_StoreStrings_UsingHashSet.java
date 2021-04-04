package ex11_3_collection_classes;

import java.util.*;

/**
 * [ StoreStrings_UsingHashSet Ŭ���� ]: 
 *      java.util.HashSet Ŭ������ ��ü�� ���� �����ϰ� ���ҵ� ����ϱ�
 *      
 *  o HashSet Ŭ����
 *    - �ߺ����� �ʴ� ���� ������ �����ϰ� �˻��ϴ� ���� ��� �����ϴ� Ŭ���� 
 *    - HashSet �̿��Ͽ� ���� ������ ������ ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ䰡 ����
 *    - ��ü������ ���� ������ ���� �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ���� �߰��� Ȯ����
 *    - ����� ��ġ ������ �� ������ �ߺ��� ���� ������ �� ���� ������ �����ϴ� Ŭ����
 *         
 *  o HashSet Ŭ������ �ֿ� �޼ҵ�
 *     - boolean add(E element) �޼ҵ�: ���� element ����
 *         Ư�� �̶� ������ ������ ������ �ڵ������� ���� Ȯ���Ͽ� ���� ����
 *     - boolean contains(Object o)  �޼ҵ�: ��ü o�� ���ҿ� ���ԵǸ� true ��ȯ, 
 *         �׷��� ������ false ��ȯ
 *     - size() �޼ҵ�: ���� ����� ���� ���� ��ȯ     
 *     - remove(Object o) �޼ҵ�: ��ü o�� ���ҿ� ���ԵǸ� �̸� �����ϰ� true ��ȯ, 
 *         �׷��� ������ false ��ȯ   
 *      
 *  o main()���� �̸� 5���� HashSet ��ü�� ������ �� ���
 */

class Ex11_3_3_StoreStrings_UsingHashSet {  
	public static void main(String[] args) {   
		// ���ڿ��� ���ҷ� ������ HashSet ��ü �����Ͽ�  strings�� �����ϰ� �� 
		HashSet<String> strings = new HashSet<String>(); 

		// 5�� �̸� 6�� �����ϱ� 
		strings.add("ȫ�浿");
		strings.add("�ڹ���");
		strings.add("�̸���");
		strings.add("������");
		strings.add("��û");
		strings.add("��û");

		System.out.print("\n  ** HashSet�� ��� ���� ����ϱ�(for each �� ���) **\n\n  * "); 

		for (String s : strings)          // strings�� �� ������ ���ڿ� s�� ����
			System.out.print(s + " ");    //   s ���  
				
		System.out.print("\n\n\n  ** HashSet�� ��� ���� ����ϱ�(iterator() �޼ҵ� ���) **\n\n  * "); 

		Iterator<String> it = strings.iterator(); // hashSet ��ü�� Iterator ��ü�� ��ȯ�Ͽ� 
		while(it.hasNext())                       // ���� ���Ұ� ������ 
			System.out.print(it.next() + " ");    //   ���� ���� ���  
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
*   
*   2) 2���� �̸��� strings�� �߰��Ͽ� �����ϵ��� ���α׷��� �����ϰ� ����� Ȯ���϶�.
*   
*   3) ��µ� ����� �� ���캸�� ����� ������ ��µǴ� ������ ������谡 ������ Ȯ���϶�.
*   
*   4) ��û�� 2�� ����Ǿ����� ����� �ѹ��� �Ǿ� ������ ���Ҵ� �ѹ��� ������� Ȯ���϶�.
*/