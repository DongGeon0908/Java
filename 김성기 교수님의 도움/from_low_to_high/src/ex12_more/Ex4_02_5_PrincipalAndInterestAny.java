package ex12_more;
/*
 *  [ PrincipalAndInterestAny ]: �Էµ� ����, ���, �������� ���� �־��� ��� ������ �������� ���� ���ڷ� �����հ� ���ϱ�
 *    
 *     o ��Ÿ�� 5: �������� ���� ������ �����հ� ���ϱ� 
 *               + for �� ���
 *               + �ʱ����, ���ڷ�, ��� ���� �Է¹���
 */

class Ex4_02_5_PrincipalAndInterestAny   {

	public static void main(String[] args)  {
		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");
		
		int initPrincipal;  // �ʱ� ���� ������ ����
		int ratePercent;    // 1�Ⱓ �������� %�� ������ ����
		int yearDuration;   // ���������� ����
		
		initPrincipal = SkScanner.getIntWithPrompt("\n   o Input initil Principal > ");  // �ʱ� ���� �Է¹���
        ratePercent = SkScanner.getIntWithPrompt("   o Input interest rate per year(%) > ");  // 1�Ⱓ �������� %�� �Է¹���
        yearDuration = SkScanner.getInt("   o Input year duration > ");   // ������ �Է¹���

		double rate = (100 + ratePercent) / 100.0;  // �ۼ�Ʈ�� �־��� ���� �������� 1�� ���� �����հ� ������ ����(�� 100.0�� �����°�?) 
		                                            
		int amount = initPrincipal;    //  ó�� �־��� ����

		System.out.println("\n\n  ** Principal and interest  ** \n");
		System.out.println("  * Initial principal = " + amount + "(won)");
		System.out.println("  * Interest rate     = " + rate);
		System.out.println("  * Year duration     = " + yearDuration + "\n");

		for (int i=1; i <= yearDuration; i++) {     // �����ŭ �ݺ��Ͽ� �����հ� ���ϱ�
			amount = (int) (amount * rate);         // �����հ踦 ������ ���ϱ� ����  �Ǽ����� ���������� ��ȯ
			System.out.println("  * Principal and interest after " + i + "  year = " + amount + "(won)");
		}
	}
}

/*
 * [ �ǽ����� ]
 *   
 *   o �� ���α׷��� �ʱ� ����, ���̷�, ����� �Է��Ͽ� �־��� ��������� �����հ踦 ���Ѵ�.
 *   
 *   o �ʱ����, ���ڷ�, �׸��� ���ϴ� �ݾ��� �Է��Ͽ� ���ϴ� �ݾ��� ���� �� �ִ� ���� 
 *     �ּ� ��� ���ΰ��� ����ϵ��� �� ���α׷��� ������ ���α׷��� 
 *     Pr4_2_5__PrincipalAndInterestHowLongYears Ŭ������  �ۼ��϶�.
 *    
 */


