package ex11_2_store_strings_sorted;

/**
 * [ StoreStringsSorted_UsingArray Ŭ���� ]: 
 *        �迭 �̿��Ͽ� ũ������� ���ڿ� �����ϱ�
 * 
 *   o �迭 �̿��Ͽ� ũ������� ���ڿ� �����ϱ� ���� ����
 *     1) ������ ���ڿ��� ũ�� ������ �´� ���� ��ġ Ž��
 *     2) ���� ��ġ������ ���ڿ��� �ϳ��� �ڷ� �ڸ� �̵��Ͽ� ������� Ȯ��
 *     3) ������ ���ڿ��� Ȯ���� ��ġ�� ����
 *    
 *   o ���ڿ� ũ�� �񱳸� ���� �޼ҵ� int compareTo(String this, String s)
 *     - ������ ��ü this�� �Ű������� �־��� s�� ���Ͽ� ���� �� ��ȯ
 *     - ������ ��ü�� ũ�� ��� ��ȯ
 *     - ������ ��ü�� s�� ������ 0 ��ȯ   
 *     - ������ ��ü�� ������ ���� ��ȯ
 */

class Ex11_2_1_StoreStringsSorted_UsingArray { 
	static int MAXSTRINGS = 10;    // ���� ������ �ִ� ���� ������ ��Ÿ���� ����
	static String[] strings = new String[MAXSTRINGS];  
	static int cntStrings = 0;     // �迭������ ����� ���Ұ����� ��Ÿ���� ����

	// ���ڿ� s�� String �迭 strings[]�� ũ������� �����ϴ� �޼ҵ�
	static void addStringSorted(String s) {     
		int pos = getPosToAdd(s);  // s�� ũ��� ���� ��ġ Ž���Ͽ� ������ġ pos ����           
		shiftBack(pos);            // pos ��ġ���� �� �ڸ��� �ڷ� ��ġ �̵���Ŵ
		storeStringTo(pos, s) ;    // ���� Ȯ���� pos ��ġ�� s ����
	}

	// strings[] �迭���� s�� ũ������� ������ ��ġ Ž���Ͽ� ��ȯ�ϴ� �޼ҵ�
	// (strings[]���� ���ڿ����� ũ�� ������� �̹� ����Ǿ� �ִ� ������)
	static int getPosToAdd(String s) {
		int i; 
		for (i = 0; i < cntStrings; i++)     // strings[]�� �� ���ҿ� ����
			if (strings[i].compareTo(s) > 0) //   ��ġ i�� ���� ũ�Ⱑ ó������ s���� ũ��                    
				return i;                    //     �� ��ġ i�� s ���� ��ġ��

		return i;    // strings�� ���Ұ� ���ų� ������ ��ġ�� ����� ��� i ��ȯ
	}   

	// ��ġ n������ ���ҵ��� �ڷ� �ϳ��� �̵���Ű�� �޼ҵ�
	static void shiftBack(int n) {
		for (int i = cntStrings; i > n; i--) // ������ ��ġ���� ��ġ n����
			strings[i] = strings[i-1];       //   �� �ڸ��� �ڷ� �̵���Ŵ
	}

	// n ��ġ�� ���ڿ� �����ϰ� cntStrings 1 ������Ű�� �޼ҵ�
	static void storeStringTo(int n, String s) {
		strings[n] = s;
		cntStrings++;
	} 

	public static void main(String[] args) {   
		// 5���� �̸��� ũ������� �����ϱ� ���� addStringSorted() �޼ҵ� ȣ��
		addStringSorted("ȫ�浿");
		addStringSorted("�ڹ���");
		addStringSorted("�̸���");
		addStringSorted("��û");

		System.out.print("\n  ** ���ĵ� �̸��� **\n\n  * ");
		
		for (int i =0; i < cntStrings; i++) { // strings�� ����� ���� ������ŭ
			String s = strings[i];            //    �ε��� i�� ���� ���Ͽ�
			System.out.print(s + " ");        //    s ��� 
		}   
	}
}
  
/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *   
 *   2) �� ���α׷��� �̸��� ũ������� �����ϰ� ����Ѵ�. �̸� ���Ͽ� 
 *      int getPosToAdd(String s), void shiftBack(int n), 
 *      void storeStringTo(int n, String s) ���� �޼ҵ尡 �ۼ��Ǿ� �ִ�.
 *      
 *      �� �޼ҵ��� ����� ��Ȯ�� �ľ��϶�.
 *     
 *     
 * [ �ǽ����� ]
 *   
 *   o �־��� ���α׷��� �����Ͽ� ���� ������ ũ������� �����ϴ� ���α׷��� 
 *     Pr11_2_1_StoreIntsSorted_UsingArray Ŭ������ �ۼ��϶�.
 *      
 *     �̸� ���Ͽ� �ִ� ���� 20�� �����ϴ� int �迭��ü�� �����Ͽ� �迭���� ints[]�� �����ϰ�
 *     �������� ũ������� �����ϱ� ���� �ʿ��� �޼ҵ带 �߰��� �ۼ��϶�.
 *     
 *     main() �޼ҵ忡�� 10���� ������ ũ������� �����ϵ��� �ۼ��� �޼ҵ带 ȣ���ϰ� ����� ����� ����϶�.
 */