package ex12_more;
/*
 *  [ PrincipalAndInterestUsingFor_Better ]: �Էµ� ����, ���, �������� ���� �־��� ��� ������ �������� ���� ���ڷ� �����հ� ���ϱ�
 *  
 *    o ���α׷��� ��Ÿ�� 4: �������� ���� ������ �����հ� ���ϱ� 
 *                      + for �� ���
 *                      + �ʱ����, ���ڷ�, ��� ���� �Է¹���
 */

class Ex4_02_4_PrincipalAndInterestUsingFor_Better   {

	public static void main(String[] args)  {
		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");

		int initPrincipal = 2000000;  // �ʱ� ���� ������ ����
		double rate = 0.05;           // 1�Ⱓ �������� ������ ����
		int yearDuration = 10;        // ���������� ����
			                                            
		int amount = initPrincipal;    //  ó�� �־��� ����
		
		System.out.println("\n\n  ** Principal and interest  ** \n");
		System.out.println("  o Initial principal = " + amount + "(won)\n");
		
		for (int i=1; i <= yearDuration; i++) {     // �����ŭ �ݺ��Ͽ� �����հ� ���ϱ�
		    amount = (int) (amount * (1 + rate));       // �����հ踦 ������ ���ϱ� ����  �Ǽ����� ���������� ��ȯ
		    System.out.println("  o Principal and interest after " + i + "  year = " + amount + "(won)");
		}
	}
}


/*
 * [ ���α׷��� ���� �� ����  ]
 * 
 *   o �� ���α׷��� �־��� �ʱ� ����, ���̷�, ����� ���Ͽ�  �־��� ��������� �����հ踦 ���Ѵ�.
 *   
 *   o Ex4_2_3_PrincipalAndInterestUsingFor_ByNovice ���α׷����� ���� �̸��� �� �۸�Ǿ� 
 *     ���α׷��� ���س� ������ �����ϴ�.
 */


