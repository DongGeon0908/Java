/**
 * [ RightTriangles_UsingIntegratedMethod2D ]: 
 *       �غ��� 2, 3, 4, 5�� ���� �ﰢ���� '*', '$', '@', '��'�� �׸���(2���� ���� �޼ҵ� ���)
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     - 2���������� ���յ� �޼ҵ带 �̿��� ���α׷�
 *     - printCharInLine(char c, int cnt): �� ���ο� �Ű������� �־��� ���� c�� ���� cnt��ŭ ����ϴ� �޼ҵ� 
 *     - drawRightTriangle(char c, int base): �Ű������� �־��� ���� c�� �غ� base ������ŭ�� 
 *                                            ���� �ﰢ�� �׸��� �޼ҵ�
 *        
 *     - main()������ ���� �ﰢ���� �׸��� �޼ҵ�� ȣ���Ͽ� ���� �ﰢ�� �׸�   
 */

class Ex5_3_4_RightTriangles_UsingIntegratingMethodFor2D  {
	public static void main(String[] args)  {	
		drawRightTriangle('*', 2); // '*'�� �غ� 2�� ���� �ﰢ�� �׸���	
		drawRightTriangle('$', 3); // '$'�� �غ� 3�� ���� �ﰢ�� �׸���	
		drawRightTriangle('@', 4); // '@'�� �غ� 4�� ���� �ﰢ�� �׸���	
		drawRightTriangle('��', 5); // '��'�� �غ� 5�� ���� �ﰢ�� �׸���		
	}

	// �Ű������� ������, 2���� ���� �޼ҵ� 
	//                 drawRightTriangle(char c, int base)
	// ȣ��� �Ű������� �־����� c�� �غ� base�� ���� �ﰢ���� �׸��� �޼ҵ�
	public static void drawRightTriangle(char c, int base) { 
		System.out.println("\n  * �غ��� '" + c + "' " + base + "���� ���� �ﰢ��  * "); 
		
		for (int cnt = 1; cnt <= base; cnt++) // cnt�� 1���� base���� �����ϸ鼭
			printCharInLine(c, cnt);          //   �ǸŰ����� c�� cnt�� printCharInLine() ȣ��
	} 

	// �Ű������� ������, 2���� ���� �޼ҵ� printCharInLine(char c, int cnt)
	//    ȣ��� �Ű������� �־����� c ���ڸ� cnt ������ŭ �� ���ο� ���
	public static void printCharInLine(char c, int cnt) { 
		for (int i = 0; i < cnt; i++) 	
			System.out.print(c);  // c�� cnt�� ���
		
		System.out.println();     // �ٹٲ�
	}       	
}

/*
 * [ �ǽ����� ]
 * 
 *    1) �غ��� 'A' 10��, 'B' 11��, ..., 'Z' 35���� ���� �ﰢ���� �׸����� ���α׷��� �����϶�.
 *    
 *    2) �غ��� 10������ 100�������� ���� �ﰢ���� �׸��µ�, �׸� ���ڴ� '!'���� �����Ͽ� 
 *       ���� ���ڵ�� ���ʴ�� �׸����� ���α׷��� �����϶�.        
 */
