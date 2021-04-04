package ex11_2_store_strings_sorted;

import java.util.Vector;

/**
 * [ StoreStringsSorted_UsingVector Ŭ���� ]: 
 *       java.util.Vector �̿��Ͽ� ũ������� ���ڿ� �����ϱ�
 * 
 *   o Vector�� �̿��Ͽ� ũ������� ���ڿ� �����ϱ� ���� ����
 *     1) ������ ���ڿ��� ũ������� �´� ����� ��ġ Ž��
 *     2) ����� ��ġ�� ���ڿ��� add(int n, Object o) �޼ҵ� �̿��Ͽ� �ٷ� ����
 *     
 *   o Vector Ŭ������ void add(int pos, E e) �޼ҵ�
 *     - ������ �־��� ��ġ pos�� ���� e ����
 *     - �� ��, pos ��ġ���� ������ ���ҵ��� �ڷ� �ϳ��� �̵���
 *     - 
 *      
 *   o ���ڿ� ũ�� �񱳸� ���� �޼ҵ� int compareTo(String this, String s)
 *     - ������ ��ü this�� �Ű������� �־��� s ���Ͽ� ���� �� ��ȯ
 *     - ������ ��ü�� ũ�� ��� ��ȯ
 *     - ������ ��ü�� s�� ������ 0 ��ȯ   
 *     - ������ ��ü�� ������ ���� ��ȯ
 */

class Ex11_2_2_StoreStringsSorted_UsingVector { 
	// ���ڿ��� ���ҷ� ������ Vector ��ü �����Ͽ� strings�� �����ϰ� �� 
	static Vector<String> strings = new Vector<String>(); 

	// ���ڿ� s�� Vector ��ü strings�� ũ������� �����ϴ� �޼ҵ�
	static void addStringSorted(String s) {     
		int pos = getPosToAdd(s); // s�� ũ��� ���� ��ġ�� Ž���Ͽ� ������ġ pos ���� 
		strings.add(pos, s);       // strings�� pos ��ġ�� s ����
	}

	// strings���� s�� �̸������� ������ ��ġ�� Ž���Ͽ� ��ȯ�ϴ� �޼ҵ�
	// (strings���� ���ڿ����� �̸� ������� ����Ǿ� ����)
	static int getPosToAdd(String s) {
		int i; 
		for (i = 0; i < strings.size(); i++)     // strings�� �� ���ڿ� ���ҿ� ����
			if (strings.get(i).compareTo(s) > 0) //   ��ġ i��  ���� ũ�Ⱑ  s���� ũ��   
				return i;                        //   �� ��ġ i�� s ���� ��ġ��

		return i; // strings�� ���Ұ� ���ų� �������� ����� ���
	}

	public static void main(String[] args) {   
		// 5���� �̸��� ũ������� �����ϱ� ���� addStringSorted() �޼ҵ� ȣ��
		addStringSorted("ȫ�浿");
		addStringSorted("�ڹ���");
		addStringSorted("�̸���");
		addStringSorted("������");
		addStringSorted("��û");

		System.out.print("\n  ** ���ĵ� " + strings.size() + "�� �̸� **\n\n  * ");
		
		for (int i = 0; i < strings.size(); i++)     // strings.size() ������ ���ҿ� ����
			System.out.print(strings.get(i)+ " ");   //  i ��ġ ���Ҹ� ���
	}
}

/*
 *   
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   2) �� ���α׷��� �̸��� ũ�� ������ �����ϰ� ����ϴµ�, �迭�� ����� ���α׷����ٴ� �ξ� �����ϴ�.
 *      �� ������ �����ΰ���  �ľ��϶�.
 *      
 * [ �ǽ����� ]
 *   
 *   1) �־��� ���α׷��� �����Ͽ� ���� ������ ũ�� ������ �����ϰ� ����ϴ� ���α׷��� 
 *      Pr11_2_1_StoreIntsSorted_UsingVector Ŭ������ �ۼ��϶�.
 *      
 *      �̸� ���Ͽ� Integer ��ü�� �����ϴ� Vector ��ü�� �����Ͽ� Vector �������� ints�� ������ ��
 *      �������� ũ������� �����ϱ� ���� �ʿ��� �޼ҵ� addIntSorted(int n)�� �ۼ��϶�. 
 *      main() �޼ҵ忡�� 10���� ������ ũ������� �����ϵ��� �ۼ��� �޼ҵ带 ȣ���ϰ� ����� ����� ����϶�.
 *      
 *      
 * [ ������� ]
 *  
 *   1) Vector ��ü���� int, double �� �⺻Ÿ�� ���� �������� ���ϸ�, �⺻ Ÿ���� ���� ��ü���� �����Ͽ��� �Ѵ�. 
 *      �׷��Ƿ� int ���� �����ϱ� ���ؼ��� ������ ���� Vector ��ü ������ �������� ������ �ʿ��ϴ�.
 *           
 *      Vector<Integer> ints = new Vector<Integer>;  // int ���� ���ҷ� �����ϱ� ���� �������� ����
 *                     
 *   2) Vector���� Integer ��ü�� ��������� addIntSorted(int n) �޼ҵ��� �Ű������� int Ÿ���̴�.
 *      �� �޼ҵ��� �Ű������� �־��� n�� Vector ��ü ints�� ����Ǿ�� �Ѵ�. 
 *         
 *      Java������ �ڵ� �ڽ�(auto-boxing)�� int Ÿ���� ���� ���� Integer ��ü�� �ڵ������� ��ȯ��Ű�Ƿ�  
 *      Vector Ŭ������ add() �޼ҵ带 �̿��Ͽ� int �� n�� Vector ��ü ints�� �߰��� �� �ִ�.    
 */
