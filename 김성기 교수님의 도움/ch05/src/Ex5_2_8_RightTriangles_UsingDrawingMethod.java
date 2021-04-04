/**
 * [ RightTriangles_UsingDrawingMethod ]: 
 *        �غ��� '*' 2, 3, 4, 5���� ���� �ﰢ�� �׸���(��ü �޼ҵ带 �̿��� ��ü �޼ҵ�� �̿��ϱ�)
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     - ��ü �߻�ȭ�� ������ �޼ҵ��� �ۼ��� �̵� �޼ҵ� �̿��� �޼ҵ��� �ۼ� 
 *   
 *   o �ۼ��� ��ü �޼ҵ�
 *     1) �� ���ο� *�� Ư�� ������ŭ ����ϴ� 5�� �޼ҵ�� 
 *          printStar1InLine(), ..., printStar5InLine()
 *           
 *     2) �̵� �޼ҵ� �̿��Ͽ� �غ��� '*' Ư�� ������ ���� �ﰢ�� ����ϴ� 4���� �޼ҵ��
 *          drawRightTriangle_BaseStar2(), ..., drawRightTriangle_BaseStar5() 
 *           
 *   o main()������ ���� �ﰢ�� �׸��� �޼ҵ�� ȣ���Ͽ� ���� ���� �ﰢ�� �׸�    
 */

class Ex5_2_8_RightTriangles_UsingDrawingMethod  {
	public static void main(String[] args)  {	
		System.out.println("\n  ** �غ��� '*' 2, 3, 4, 5���� ���� �ﰢ�� �׸���(�ﰢ�� �׸��� ��ü �޼ҵ� �̿�) **"); 
		
		// ���� �ﰢ�� �׸��� ��ü �޼ҵ�� ȣ��
		drawRightTriangle_BaseStar2(); 
		drawRightTriangle_BaseStar3(); 
		drawRightTriangle_BaseStar4(); 
		drawRightTriangle_BaseStar5(); 
	}

	/*
	 *  �غ��� '*' n���� ���� �ﰢ���� �׸��� �޼ҵ��
	 */

	static void drawRightTriangle_BaseStar2() { 
		System.out.println("\n  * �غ��� '*' 2���� ���� �ﰢ��  * "); 
		
		printStar1InLine();  // printStar1InLine() �޼ҵ� ȣ��
		printStar2InLine();  // printStar2InLine() �޼ҵ� ȣ��
	} 
	static void drawRightTriangle_BaseStar3() { 
		System.out.println("\n  * �غ��� '*' 3���� ���� �ﰢ��  * "); 
		
		printStar1InLine();  // printStar1InLine() �޼ҵ� ȣ��
		printStar2InLine();  // printStar2InLine() �޼ҵ� ȣ��
		printStar3InLine();  // printStar3InLine() �޼ҵ� ȣ��
	}
	static void drawRightTriangle_BaseStar4() { 
		System.out.println("\n  * �غ��� '*' 4���� ���� �ﰢ��  * "); 
		
		printStar1InLine();  // printStar1InLine() �޼ҵ� ȣ��
		printStar2InLine();  // printStar2InLine() �޼ҵ� ȣ��
		printStar3InLine();  // printStar3InLine() �޼ҵ� ȣ��
		printStar4InLine();  // printStar4InLine() �޼ҵ� ȣ��
	}  
	static void drawRightTriangle_BaseStar5() { 
		System.out.println("\n  * �غ��� '*' 5���� ���� �ﰢ��  * "); 
		
		printStar1InLine();  // printStar1InLine() �޼ҵ� ȣ��
		printStar2InLine();  // printStar2InLine() �޼ҵ� ȣ��
		printStar3InLine();  // printStar3InLine() �޼ҵ� ȣ��
		printStar4InLine();  // printStar4InLine() �޼ҵ� ȣ��
		printStar5InLine();  // printStar5InLine() �޼ҵ� ȣ��
	} 

	/*
	 * �� ���ο� '*' n���� ����ϴ� �޼ҵ��
	 */

	// printStar1InLine() �޼ҵ�: �� ���ο� '*' 1�� ���
	public static void printStar1InLine() { 
		for (int i = 0; i < 1; i++)  // '*' 1�� ���
			System.out.print('*');  
		
		System.out.println();        // �ٹٲ�
	}
	
	// printStar2InLine() �޼ҵ�: �� ���ο� '*' 2�� ���
	public static void printStar2InLine() {  
		for (int i = 0; i < 2; i++)  // '*' 2�� ���
			System.out.print('*');  
		
		System.out.println();        // �ٹٲ�
	}
	
	// printStar3InLine() �޼ҵ�: �� ���ο� '*' 3�� ���
	public static void printStar3InLine() { 
		for (int i = 0; i < 3; i++) // '*' 3�� ���
			System.out.print('*');  
		
		System.out.println();       // �ٹٲ�
	}
	
	// printStar4InLine() �޼ҵ�: �� ���ο� '*' 4�� ���
	public static void printStar4InLine() {
		for (int i = 0; i < 4; i++) // '*' 4�� ���	
			System.out.print('*'); 
		
		System.out.println();       // �ٹٲ�
	}
	
	// printStar5InLine() �޼ҵ�: �� ���ο� '*' 5�� ���
	public static void printStar5InLine() {  
		for (int i = 0; i < 5; i++) // '*' 5�� ���	
			System.out.print('*'); 
		
		System.out.println();       // �ٹٲ�
	}

	// print��5InLine() �޼ҵ�: �� ���ο� '��' 5�� ���
	//   �޼ҵ� �̸��� �ѱ� ���ڰ� ���ԵǾ �� 
	public static void print��5InLine() {  
		for (int i = 0; i < 5; i++) // '��'�� 5�� ���	
			System.out.print('��'); 
		
		System.out.println();       // �ٹٲ�
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ���� �ﰢ���� �׸��� ��ü �޼ҵ带 �̿��Ͽ�  �غ��� * 2������ 5���� 
 *      ���� �ﰢ�� 5���� �� �׸���.
 *   
 *   2) ���� 5-2-8 ���α׷��� ���캸�� ������ ��ü �޼ҵ带 �̿��Ͽ�  ������ ����� ��ü �޼ҵ带 
 *      �ۼ��ϴ� ������ �ľ��϶�.
 *      
 *   3) �ۼ��� �� �޼ҵ尡 ���� �� ȣ��� �� ������ Ȯ���϶�.
 *      - printStar1InLine()�� ��� 4��, printStar2InLine()�� ��� 3�� ȣ���
 *      
 *   4) ���α׷��� �� ���캸�� �����Ͽ� ����� Ȯ���϶�.
 *    
 * 
 * [ �ǽ����� ]
 * 
 *   1) �غ��� '*' 2, 3, 4, 5, 6, 7, 8, 9, 10���� ���� �ﰢ������ ��� �׸����� ���α׷��� �����϶�.
 *      �� �۾��� ���ؼ� �ʿ��� �޼ҵ带 �� �ۼ��ϰ� main() �޼ҵ忡�� �̸� ȣ���ϸ� �ȴ�.
 *      �̹� �ۼ��� �޼ҵ��� ���� ����ϹǷ� ����� ���� ���̴�.
 *    
 *   2) �� ���α׷��� ��Ÿ�ϴ�� �غ��� '*' 1������ 50���� ���� �ﰢ���� ��� �׸����� 
 *      �� ���� �޼ҵ尡 �ʿ��Ѱ��� ����غ���.      
 *      
 *   3) �غ��� '*' 3���� ���� �ﰢ�� �׸��� static void drawRightTriangle_BaseStar3() �޼ҵ��
 *      drawRightTriangle_BaseStar2()�� �̿��Ͽ� ������ ���� �ۼ��� �� �ִ�.
 *      
 *	      static void drawRightTriangle_BaseStar3() { 
 *		     System.out.println("\n  * �غ��� '*' 3���� ���� �ﰢ��  * "); 
 *		
 *		     drawRightTriangle_BaseStar2()  // �غ��� '*' 2���� ���� �ﰢ�� �׸��� �޼ҵ� ȣ��
 *           printStar3InLine();            // printStar3InLine() �޼ҵ� ȣ��
 *	      }
 *
 *      drawRightTriangle_BaseStar4()�� void drawRightTriangle_BaseStar5() �޼ҵ嵵
 *      ���������� ���� �ﰢ�� �׸��� �޼ҵ� ȣ��� ���� �����ϰ� �ۼ��� �� �ִ�. 
 *      
 *      ���� �ﰢ�� �׸��� �޼ҵ� ȣ��� �޼ҵ���� �����ϰ� �����Ͽ� ����� Ȯ���϶�. 
 *          
 *          
 * [ ������ �����ϰ� ����غ� ���� ] 
 * 
 *   1) '*'�� Ư�� ������ŭ ����ϴ� �޼ҵ���� �ۼ��ϱ�� ���� ���쳪 ȿ�뼺�� �����ϸ�, 
 *      �̷��� �޼ҵ�� ������ �޼ҵ��̴�. 
 *       
 *      - ���������� �غ��� '*' Ư�� ������ ���� �ﰢ���� �׸��� �޼ҵ嵵 �ۼ��ϱ�� ���쳪 
 *        ȿ�뼺�� ������ ������ �޼ҵ��̴�.       
 *      
 *        (�׷����� �ұ��ϰ� �̷��� �޼ҵ���� �ۼ��� ������ ��ü �߻�ȭ�� �����ϱ� �����̸�
 *         ����Ʈ �޼ҵ��� �߿伺�� �����ϱ� ����)
 *       
 *      - ������ �޼ҵ���� �ݵ�� ����Ʈ �޼ҵ�� ���ۼ��Ǿ�� �Ѵ�. ���⿡�� �ۼ��� 5���� 
 *        �޼ҵ� �׸��� �ۼ����� �ʾ����� �ʿ�� �ۼ��ؾ��� ��õ ���� ������ �޼ҵ带 �����Ͽ� 
 *        �ϳ��� ����Ʈ �޼ҵ�� ���ۼ��ϱ� ���� ��ȿ� ���� �̸� �����غ���. 
 *       
 *      - �̴� ������ ���� ������� �����Ͽ� �ݺ������� �ۼ��ϴ� �Ͱ� ���� �ƶ��̴�.  
 */
