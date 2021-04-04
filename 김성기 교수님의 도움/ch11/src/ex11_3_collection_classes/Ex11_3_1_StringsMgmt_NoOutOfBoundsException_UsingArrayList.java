package ex11_3_collection_classes;

import java.util.ArrayList;

/**
 * [ StringsMgmt_NoOutOfBoundsException_UsingArrayList Ŭ���� ]: 
 *       java.util.ArrayList Ŭ���� ����Ͽ� �ε��� �ʰ� ���� �����ϱ�
 * 
 *   o UsingArrayList Ŭ������ ���� ������ �����ϰ� �˻��ϴ� ���� ��� �����ϴ� Ŭ����
 *     - ArrayList �̿��Ͽ� ���� ������ �� ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ� ����
 *     - ��ü������ ���� ������ ���� �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ������� �߰��� Ȯ��
 *     - Vector Ŭ������ ����̳� �޼ҵ� ���� ���������� Vector�� ����ȭ �����ϴ� �ݸ�
 *       ArrayList�� ����ȭ �������� ����
 *    
 *   o ArrayList Ŭ������ ��ü ������ ����
 *     - ArrayList<����_Ŭ����> ��ü�������� = new ArrayList<����_Ŭ����>();
 *     - ArrayList Ŭ������ ���׸� Ŭ�����̹Ƿ� ������ ������ Ŭ������ ���� �� <�� > ���̿� ���
 *    
 *     - ArrayList<String> strings = new ArrayList<String>(); // <String>�� ���� Ŭ���� ǥ�� 
 *    
 *   o ArrayList Ŭ������ �ֿ� �޼ҵ�  
 *     - ���� �߰��ϴ� �޼ҵ�
 *       1) add(E element) �޼ҵ�: ������ ������ ��ġ�� ���� element ����
 *          Ư�� �̶� ������ ���� ������ �ڵ������� ���� Ȯ���Ͽ� ���� ����
 *       2) add(int index, E element) �޼ҵ�: ArrayList�� ��ġ index�� ���� element�� �߰�
 *          �߰��Ǵ� ��ġ������ ���ҵ��� �ϳ��� �ڷ� �̵���Ŵ 
 *              
 *     - ���� �� �˻� ����  �޼ҵ�
 *       1) get(int index) �޼ҵ�: ArrayList���� ��ġ index�� ���� ��ȯ
 *       2) set(int index, E element) �޼ҵ�: ArrayList�� ��ġ index�� ���Ҹ� element�� ��ü��Ŵ
 *       3) size() �޼ҵ�: ���� ����� ���� ���� ��ȯ 
 *      
 *     - ArrayList ��ü�� ����� ���� �����ϱ� ���� �޼ҵ�
 *       1) remove(int index) �޼ҵ�: index ��ġ�� ���� �����ϰ� ������ ���� ��ȯ
 *          ���� ��ġ �̺����� ���ҵ��� �ϳ��� ������ �̵���Ŵ     
 *      
 *   o main()���� ���ڿ� 5���� ArrayList ��ü�� ������ �� ����� ��� ���� ���
 */

class Ex11_3_1_StringsMgmt_NoOutOfBoundsException_UsingArrayList { 
	public static void main(String[] args) {   
		// ���ڿ��� �����ϴ� ArrayList ��ü�� �����Ͽ� strings�� �����ϰ� ��
		// <String>�� ���� Ŭ���� ǥ�� 
		ArrayList<String> strings = new ArrayList<String>(); 

		// 5���� �̸� �����ϱ� 
		strings.add("ȫ�浿");
		strings.add("�ڹ���");
		strings.add("�̸���");
		strings.add("������");
		strings.add("��û");

		System.out.print("\n  ** ArrayList�� ��� ���� ����ϱ�(for �� ���) **\n\n  * "); 
		
		for (int i = 0; i < strings.size(); i++) {  // strings�� ����� ���� ������ŭ
			String s = strings.get(i);              // �ε��� i�� ���� ���Ͽ�
			System.out.print(s + " ");              //   s ��� 
		}   
		
		System.out.print("\n\n\n  ** ArrayList�� ��� ���� ����ϱ�(for each �� ���)\n\n  * ");   
		
		for (String s : strings)                    // strings�� ����� �� ���� s�� ����
			System.out.print(s + " ");              //   s ��� 
		
		System.out.print("\n\n\n  ** ArrayList�� ��� ���� ����ϱ�(ArrayList ��ü ���)\n\n  * ");   
		System.out.print(strings);              //   strings ��� 

	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
*   
*   2) 2���� �̸��� strings�� �߰��ϵ��� ���α׷��� �����ϰ� ����� Ȯ���϶�.
*   
*   3) ArrayList�� ���� �����͸� �����ϴ� ���� �迭�� �����ϴ� �ͺ��� �ξ� ������ Ȯ���϶�.
*   
*   4) Vector�� �����͸� �����ϴ� �Ͱ� ArrayList�� �����͸� �����ϴ� ���� ���� �������� Ȯ���϶�.  
*/