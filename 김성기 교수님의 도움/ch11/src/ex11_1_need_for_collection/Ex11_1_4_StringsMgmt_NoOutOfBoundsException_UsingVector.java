package ex11_1_need_for_collection;

import java.util.Vector;

/**
 * [ StringsMgmt_NoOutOfBoundsException_UsingVector Ŭ���� ]: 
 *       java.util.Vector Ŭ������ ����Ͽ� �ε��� �ʰ� ���ܸ� �����ϱ�
 * 
 *  o Vector Ŭ������ ���� ������ �����ϰ� �˻��ϴ� ���� ����� �����ϴ� Ŭ���� 
 *    - Vector �̿��Ͽ� ���� ������ �� ������ ������ �ִ� ũ�⸦ ������ ������ �ʿ� ����
 *    - ��ü������ ���� ������ ���� �����ϰ�, �� ���� ���� ����� �ʿ� ������ ������� �߰��� Ȯ��
 *    
 *  o Vector Ŭ������ ��ü ������ ����
 *    - Vector<����_Ŭ����> ��ü�������� = new Vector<����_Ŭ����>();
 *    - Vector Ŭ������ ���׸� Ŭ�����̹Ƿ� ������ ������ Ŭ���� ���� �� <�� > ���̿� ���
 *    
 *    - Vector<String> strings = new Vector<String>(); // <String>�� ���� Ŭ���� ǥ�� 
 *    
 *  o Vector Ŭ������ �ֿ� �޼ҵ�  
 *    - ���� �߰��ϴ� �޼ҵ�
 *      1) add(E element) �޼ҵ�: ������ ������ ��ġ�� ���� element ����
 *         Ư�� �̶� ������ ���� ������ �ڵ������� ���� Ȯ���Ͽ� ���� ����
 *      2) add(int index, E element) �޼ҵ�: Vector�� ��ġ index�� ���� element �߰�
 *         �߰��Ǵ� ��ġ���� ���ҵ��� �ڷ� �ϳ��� �̵���Ŵ 
 *              
 *    - ���� �� �˻��� ����  �޼ҵ�
 *      1) get(int index) �޼ҵ�: Vector���� ��ġ index�� ���� ��ȯ
 *      2) set(int index, E element) �޼ҵ�: Vector�� ��ġ index�� ���Ҹ� element�� ��ü��Ŵ
 *      3) size() �޼ҵ�: ���� ����� ���� ���� ��ȯ 
 *      
 *    - Vector ��ü�� ����� ���Ҹ� �����ϱ� ���� �޼ҵ�
 *      1) remove(int index) �޼ҵ�: index ��ġ�� ���� �����ϰ� ������ ���� ��ȯ
 *         ���� ��ġ �̺����� ���ҵ��� ������ �ϳ��� �̵���Ŵ     
 *      
 *  o main()���� ���ڿ� 5���� Vector ��ü�� ������ �� ����� ��� ���� ���
 *    
 */

class Ex11_1_4_StringsMgmt_NoOutOfBoundsException_UsingVector { 
	public static void main(String[] args) {   
		// ���ڿ� �����ϴ� Vector ��ü �����Ͽ� strings�� ����
		// <String>�� ���� Ŭ���� ǥ�� 
		Vector<String> strings = new Vector<String>(); 

		strings.add("ȫ�浿");
		strings.add("�ڹ���");
		strings.add("�̸���");
		strings.add("������");
		strings.add("��û");
		
		System.out.print("\n  ** ����� �̸���(for ������ ���) **\n\n  * ");

		for (int i =0; i < strings.size(); i++) {  // strings�� ����� ���� ������ŭ
			String s = strings.get(i);             //   �ε��� i�� ���� ���Ͽ�
			System.out.print(s + " ");             //   s ��� 
		}   
		
		System.out.print("\n\n\n  ** ����� �̸���(Vector ��ü ���) **\n\n  * ");
		System.out.print(strings);		
	}
}

/*
* [ ���α׷� ���� �� ���� ]
*   
*   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
*   
*   2) 2���� �̸��� strings�� �߰��ϵ��� ���α׷��� �����ϰ� ����� Ȯ���϶�.
*   
*   3) Vector�� ���� �����͸� �����ϴ� ���� �迭�� �����ϴ� �ͺ��� �ξ� ������ Ȯ���϶�.
*   
*   
* [ �ǽ����� ]
*   
*   1) main() �޼ҵ忡 ������ ���� Integer ��ü�� �����ϴ� Vector ��ü �����Ͽ� ��������
*     ints�� �����϶�.
*     
*       Vector<Integer> ints = new Vector<Integer>();
*       
*   2) ������ for �� �̿��Ͽ� ints.add() �޼ҵ带 10001�� ȣ���� �� �����϶�. 
*       ( add() �޼ҵ��� �Ű������� Integer ��ü������ �ڵ� �ڽ� �̷�����Ƿ� ������ ����)  
*       
*      for (int i = 0;  i < 10001; i++) 
*          ints.add(i);
*
*   3) ������ for �� �̿��Ͽ� ints�� ����� ���ҵ��� ����϶�. 
*   
*      for ( int i = 0;  i < ints.size(); i++) 
*          System.out.println(ints.get(i) + " ");
*
*   4) int capacity() �޼ҵ�� Vector�� �ִ� ���� ���� ��ȯ�Ѵ�. �ִ� ���� ���� ����Ͽ� 
*      Ȯ���϶�. (�ʱ� �ִ� ���� ���� 10������ 2�辿 �þ ����� 10 * 1024 = 10240��)
*/
