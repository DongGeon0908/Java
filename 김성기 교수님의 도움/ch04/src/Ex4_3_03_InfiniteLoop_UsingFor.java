/**
 * [ InfiniteLoop_UsingFor ]: for ������ ����� �ʱ�ȭ, �ݺ�����, ����� ���� ���� ����     
 *                  
 *   o for ��
 *     - ���: �ݺ� ����� �̿��Ͽ� �ݺ� ȸ�� �����ϴ� ��ǥ���� �ݺ���
 *     - ����: �ݺ� ����� �ʱ�ȭ, �ݺ����� �˻�, ����� ����, �ݺ� ���� �� 4 �κ�
 *     - ������: �ݺ������� true�� ���� �ݺ� ����� ������ ��� ����
 *     - �ݺ� ����� ����: for �� �ܺ� �Ǵ� ���ο��� ���� ����
 *     - for �� �ܺο��� ������ �ݺ� �����: for �� ���ο� �ܺο��� ��� �����ϸ�, 
 *                                       for ���� ����� �Ŀ��� ��� ������ 
 *     - for �� ���ο��� ������ �ݺ� �����: for �� �������� ��� ���� 
 *      
 *   o for �������� ����      
 *     - for ������ ����� �ʱ�ȭ, �ݺ�����, ����� ���� ���� ��� ������ �� ����
 *     - �ݺ� ���๮���� ������ �� ������, ���� ���� ������ ���鹮(;)�� �ۼ��ؾ� ��
 *     
 *     - Ư�� �ݺ������� �����Ǹ� �ݺ������� true�� �ǹǷ� for ���� ������ �ʰ� ��� �ݺ��� 
 */

class Ex4_3_03_InfiniteLoop_UsingFor {
	public static void main(String[] args)  {
		System.out.print("\n  ** Infinite loop by for statements **\n\n");

		// forToRun ������ 1, 2, 3, 4 �Է��ϸ� �ش� ���� ���� ����
		int forToRun = SkScanner.getIntWithPrompt("  o 1���� 4 ������ �� �Է��ϸ� �ش� ���� ���� ����  > ");
		
		if (forToRun == 1)
			for ( ; ; )  		       // ����� �ʱ�ȭ, �ݺ�����, ����� ���� ��� ����: �ݺ����� �����Ǹ� ���� ����
				System.out.println("  * This is first infinite loop - never ending!!!");

		if (forToRun == 2)
			for ( ; true; )  	       //  ����� �ʱ�ȭ, ����� ���� ��� ����: �ݺ� ������ true�̹Ƿ� ���ѷ���
				System.out.println("  * This is second infinite loop - never ending!!!");

		if (forToRun == 3)
			for ( int i = 0; ; i++) {  // �ݺ����� ����: �ݺ����� �����Ǹ� ���� ����
				System.out.println("  * This is third infinite loop - never ending!!!");
				System.out.println("    i = " + i);
			}
		
		if (forToRun == 4)  {         // �� ��쿡�� for ���� ������ ��������� ����Ǵ� ������ ����
			System.out.println("  * Just before starting fourth infinite loop - never ending, only so profound silence !!!");
			
			for ( ; ; )  			  // ����� �ʱ�ȭ, �ݺ�����, ����� ���� ��� ����: �ݺ����� �����Ǹ� ���� ����
				;                     // �ݺ������� ������ ������ ���鹮���� �ۼ��ؾ� ��
		}
	}
}


/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� 4���� for �� �� �ϳ��� �����ϱ� ���� forToRun ������ �̿��Ѵ�.
 *   
 *   2) forToRun ���� ���� 1, 2, 3, 4�� ���� �����Ͽ� �����ϰ� ����� Ȯ���϶�.
 *   
 *   3) �ݺ������� true�̰ų� �����Ǹ� ���� �������� Ȯ���϶�.
 *   
 *   4) 4��° for ���� ����Ǵ� ���� ������ ���� ������ ����.
 *   
 */