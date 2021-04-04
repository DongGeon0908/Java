/**
 * [ RightTriangles_UsingIntegratedMethodFor ]: 
 *       �غ��� 2, 3, 4, 5�� ���� �ﰢ���� '*'�� �׸���(���� �޼ҵ� ���)
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     - ���յ� �޼ҵ带 �̿��� ���α׷�
 *     - printCharInLine(char c, int cnt): �� ���ο� �Ű������� �־��� ���ڿ� ȸ����ŭ ����ϴ� �޼ҵ� 
 *     - drawRightTriangle_BaseStar(int base): ���� *�� �غ� base ������ŭ�� ���� �ﰢ�� �׸��� �޼ҵ�
 *     - main()������ ���� �ﰢ�� �׸��� �޼ҵ�� ȣ���Ͽ� ���� �ﰢ�� �׸�
 *     
 *   o �޼ҵ� ȣ��� �ǸŰ������� ��� �� �ƴ϶� ���� �Ǵ� ���� ��� ����
 *     - for ������ �ݺ������� �޼ҵ� ȣ�� ����
 *     - �Ű����� ���� �޼ҵ�� ���� ȿ���� �ƴ϶� Ȱ�뵵�� �ſ� ����  
 *     - �迭 �Ǵ� �ݺ����� Ȱ�뵵�� �������� ���� ����
 */

class Ex5_3_3_RightTriangles_UsingIntegratingMethodFor  {

	public static void main(String[] args)  {	
		for (int i = 2; i <= 5; i++)           // �غ��� '*' 2������ 5������ 
			drawRightTriangle_BaseStar(i);     //    �ﰢ�� �׸��� �޼ҵ� ȣ��	
	}

	// �Ű������� ���� ���� �޼ҵ� drawRightTriangle_BaseStar(int base)
	//     �غ��� '*' ������ �Ű����� base�� ���� �ﰢ�� �׸�
	static void drawRightTriangle_BaseStar(int base) { 
		System.out.println("\n  * �غ��� '*' " + base + "���� ���� �ﰢ��  *"); 
		
		for (int n = 1; n <= base; n++) // n�� 1���� cntBase���� �����ϸ鼭
			printStarInLine(n);         //   �ǸŰ����� n���� printStarInLine() ȣ��
	} 

	// �Ű������� ���� ���� �޼ҵ� printStarInLine(int cnt)
	//    ȣ��� �־����� �Ű����� cnt ������ŭ '*'�� �� ���ο� ���
	static void printStarInLine(int cnt) { 
		for (int i = 0; i < cnt; i++) 	
			System.out.print('*');  // '*' n�� ���
		
		System.out.println();       // �ٹٲ�
	}       	
}

/*
 * [ �ǽ����� ]
 * 
 *    1) �غ��� '*' 10��,  11��, ..., 36���� ���� �ﰢ���� �׸����� ���α׷��� �����϶�.
 *    
 *    2) �غ��� 10������ 100�������� ���� �ﰢ���� �׸��µ�, �׸� ���ڴ� '!'���� �����Ͽ� 
 *       ���� ���ڵ�� ���ʴ�� �׸����� ���α׷��� �����϶�.        
 */
