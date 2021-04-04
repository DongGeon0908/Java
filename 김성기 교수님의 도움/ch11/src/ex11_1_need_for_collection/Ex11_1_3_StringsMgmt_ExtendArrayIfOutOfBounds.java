package ex11_1_need_for_collection;

/**
 * [ StringsMgmt_ExtendArrayIfOutOfBounds Ŭ���� ]: 
 *       �� ���� ���� �����ϴ� ������� Ȯ���Ͽ� �ε��� ���� �ʰ� ���� �����ϱ�
 * 
 *   o �迭�� �ִ� ���� ���� ���Һ��� �� ���� ���� �����ϸ� �ε��� ���� �ʰ� ������
 *     ArrayIndexOutOfBoundsException�� �߻��ϹǷ� �̸� ������ �� �ֵ��� ��ġ�ϴ� ����
 *    
 *   o ����� �迭 ���� ���� �����Ͽ� �� �̻� ������ ������ ������ �� ū �迭��ü �Ҵ��Ͽ� ���� 
 *     - �迭�� ���� ������ �ִ� ���� ������ �����ϴ� ����: MAXSTRINGS = 3;
 *     - �迭�� ���Ҹ� �����ϸ� ����� ���� ������ �����ϴ� ����: cntStrings
 *     - ���Ҹ� ������ �迭��ü ������ ��������: strings
 *     
 *     - ������ ������ ������(cntStrings < MAXSTRINGS) ������ 
 *     - �� �̻� ������ ������ ������(cntStrings == MAXSTRINGS) �߰����� ������� �Ҵ��Ͽ� ����       
 *       1) 2���� �� ���� ���� ���� ������ �迭��ü ����
 *       2) ������ ���ҵ��� ���ο� �迭��ü�� ����
 *       3) strings�� ���ο� ��ü �����ϰ� ��
 *       4) �ִ� ���� ������ ������ �ִ� ������ ����
 *    
 *   o ���� ������ �ִ� ���� ������ 3�ε� main()���� 5�� ���� �����Ϸ� ��
 *     - 4��° ���Ҹ� strings[3]�� �����Ϸ� �ϸ� ���� ����� ���� ������ �ִ� ���� ������ �����Ƿ� 
 *       ���ο� �迭���� Ȯ���ϰ� ������ ���ҵ��� ������ �� ����
 */

class Ex11_1_3_StringsMgmt_ExtendArrayIfOutOfBounds {  
	static int MAXSTRINGS = 3;       // ���� ������ �ִ� ���� ������ ��Ÿ���� ����
	static String[] strings = new String[MAXSTRINGS]; // �迭��ü �����Ͽ� �迭������ ���� 
	static int cntStrings = 0;       // �迭������ ����� ���Ұ����� ��Ÿ���� ����

	// ���ڿ� s�� String �迭 strings[]�� �����ϴ� �޼ҵ�   
	static void addString(String s) {     
		if (cntStrings >= MAXSTRINGS) {               // ���� ������ ������ ������       
			int maxNew = MAXSTRINGS * 2;              //   ���� �ִ� ���� 2���� 
			String[] stringsNew = new String[maxNew]; //   ������� Ȯ��

			copyStrings(strings, stringsNew); // ���ο� ������ ���� ���ҵ� ����
			
			strings = stringsNew;             // strings�� ���ο� ���� �����ϰ� ��
			MAXSTRINGS = maxNew;              // �ִ� ���� ���� ����
		}

		// ������ ���� ������ ������ �׻� �ְ� �ǹǷ� 
		strings[cntStrings++] = s;           // s�� strings[]�� ����, ���Ұ��� 1 ����
	}

	// String �迭 src[]�� ��� ���ҵ��� String �迭 dest[]�� �����ϴ� �޼ҵ�
	static void copyStrings(String[] src, String[] dest) {
		for (int i = 0; i< src.length; i++)  // src[]�� ���� ������ŭ
			dest[i] = src[i];                //   src[]�� ���Ҹ� dest[]�� ���ҷ� ����
	}

	public static void main(String[] args) {   
		addString("ȫ�浿");
		addString("�ڹ���");
		addString("�̸���");
		addString("������");
		addString("��û");
		
		System.out.print("\n  ** ����� �̸��� **\n\n  * ");

		for (String s : strings)             // strings �迭�� ��� ���� s�� ����
			if (s != null)                   //    s null�� �ƴϸ�
				System.out.print(s + "  ");  //       s ���    
		
		System.out.println("\n\n  * MAXSTRINGS = " + MAXSTRINGS + ", cntStrings = " + cntStrings);
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   o ���α׷��� �����Ͽ� ����� Ȯ���϶�.
*   
*   o �� ���α׷��� ���ܸ� �߻���Ű���� ������, 5���� ���ڿ��� ��� ������� Ȯ���� Ȯ���϶�.
*   
*   o ���� ������ �ִ� ���� ������ ����� ���� Ȯ���϶�.
*   
*   
* [ �ǽ����� ]
*   
*   1) ������ ���� ���� 10���� �����ϴ� int �迭��ü�� �����Ͽ�  �迭���� ints[]�� �����϶�.
*   
*   	static int MAXINTS = 10;   // ���� ������ �ִ� ���� ������ ��Ÿ���� ����
*	    static int[] ints = new int[MAXINTS];  // int �� ������ �迭����
*	    static int cntInts = 0;   // �迭������ ����� ���� ������ ��Ÿ���� ����
*
*   2) ���� ������ ints[]�� �����ϰ� ����ϵ��� ������ �޼ҵ带 �߰��� �ۼ��϶�.
*      
*        static void addInts(int n)      // n�� ints[]�� ���� �����ϴ� �޼ҵ��, ����� ���� ������ �ִ� ���� ������ ������ 
*                                        //   �߰� ��������� Ȯ���� �� ���� ���ҵ��� ������ �� ints�� �����ϰ� �ϰ� n�� ����
*        static void copyInts(int[] src, int[] dest)   // int �迭 src[]�� ���ҵ��� ��� int �迭 dest[]�� �����ϴ� �޼ҵ�
*        
*   3) main()���� addInt() �޼ҵ带 11�� ȣ���� �� ����� ������ ����ϰ�
*      MAXINTS�� cntInts ���� ����϶�.      
*/