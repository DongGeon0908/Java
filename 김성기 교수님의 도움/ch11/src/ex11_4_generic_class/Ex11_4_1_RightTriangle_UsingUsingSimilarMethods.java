package ex11_4_generic_class;

/**
 * [ RightTriangle_UsingSimilarMethods Ŭ���� ]: 
 *      ������ ����� �޼ҵ���� �̿��Ͽ� ���� �ﰢ�� �׸��� 
 * 
 *   o ������ ���� �޼ҵ�� �ۼ�
 *     - �� ���ο� *�� Ư�� ������ŭ ����ϴ� 5���� �޼ҵ�� 
 *       printStar1InLine(), ..., printStar5InLine()
 *         
 *   o ������ �޼ҵ��� ������ �ʿ伺
 *     - ������ �޼ҵ尡 �ݺ������� �ۼ��Ǹ� �ڵ尡 �ߺ��ǰ� ������ ��Ұ� �߻��� 
 *     - �Ű����� �̿��Ͽ� �ϳ��� �޼ҵ�� �ۼ� ����
 *      
 */

class Ex11_4_1_RightTriangle_UsingUsingSimilarMethods  {
	
	static void printStar1InLine() { 
		for (int i = 0; i < 1; i++)   
			System.out.print('*');  // '*' 1�� ���
		
		System.out.println();       // �ٹٲ�
	}
	
	static void printStar2InLine() {  
		for (int i = 0; i < 2; i++)   
			System.out.print('*');  // '*' 2�� ���
		
		System.out.println();       // �ٹٲ�
	}  
	
	static void printStar3InLine() {  
		for (int i = 0; i < 3; i++)   
			System.out.print('*');  // '*' 3�� ���
		
		System.out.println();       // �ٹٲ�
	}   
	
	static void printStar4InLine() {  
		for (int i = 0; i < 4; i++)   
			System.out.print('*');  // '*' 4�� ���
		
		System.out.println();       // �ٹٲ�
	}
	
	static void printStar5InLine() {  
		for (int i = 0; i < 5; i++)   
			System.out.print('*');  // '*' 5�� ���
		
		System.out.println();       // �ٹٲ�
	}

	public static void main(String[] args)  {  
		System.out.print("\n  ** �Ű����� ���� �޼ҵ�� ȣ��� �ۼ��� ���� �ﰢ�� **\n");

		printStar1InLine(); 
		printStar2InLine();  
		printStar3InLine();  
		printStar4InLine();  
		printStar5InLine();  		
	}
}

/*
 * [ �ǽ����� ]
 * 
 *   1) �غ��� * 10���� ���� �ﰢ���� �׸����� ���α׷��� �� ��Ÿ�ϴ�� �����϶�.
 *      �� �۾��� ���ؼ� �ʿ��� �޼ҵ带 �� �ۼ��ϰ� main() �޼ҵ忡�� �̸� ȣ���ϸ� �ȴ�.
 *      
 *      �̹� �ۼ��� �޼ҵ��� ���� ����ϹǷ� ����� ���� ���̴�.
 *    
 *   2) �� ���α׷��� ��Ÿ�ϴ�� �غ��� * 50���� ���� �ﰢ���� �׸����� 
 *      �� ���� �޼ҵ尡 �ʿ��Ѱ� ����϶�.       
 */
