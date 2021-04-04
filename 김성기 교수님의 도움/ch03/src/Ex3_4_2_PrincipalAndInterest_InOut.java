/**
 * [ PrincipalAndInterest_InOut ]: 5�� ������ ���� �����հ� ���ϱ�
 * 
 *   o ���α׷��� ��Ÿ��
 *     1) ���� ��� ��Ÿ�� 1: �������� �ٸ� ������ �����հ� ���ϱ�
 *     2) ���ݰ� ������ �Է��Ͽ� 5�� ���� �����հ� ���Ͽ� ���
 *  
 *   o �����հ��� ��� 
 *     - �����հ�: ���ݰ� ���ڸ� ���� �ݾ�
 *     - ����: ���ڿ� ���ؼ��� ���ڰ� �ٴ� ���� ���޹��
 *            (���� - �ܸ�: ���ݿ� ���ؼ��� ���ڰ� �ٴ� ���)
 *     - ���� ������ �����հ�   = ���� ������ �����հ�  + (���� ������ �����հ� * 1�Ⱓ ������)   
 *                       = ���� ������ �����հ�  * (1 + 1�Ⱓ ������)
*/

class Ex3_4_2_PrincipalAndInterest_InOut {
   public static void main(String[] args) {

	   System.out.println("\n  **** Calculation of Principal and Interest " +
	   		"by Compound Interest ****\n");  	// ��ü  Ÿ��Ʋ ���      

	   int amount0;         //  �ʱ� ����
	   int amount1, amount2, amount3, amount4, amount5;  // �ų� �����հ� ���� ����
	   double ratePercent;  // �ۼ�Ʈ ������
	   double rate;         // ������

	   System.out.print("  o Input initial principal > ");
	   amount0 = SkScanner.getInt();            // �ʱ� ���� �Է¹���

	   System.out.print("  o Input interest rate per year (%) > ");  
	   ratePercent = SkScanner.getDouble();     // 1�Ⱓ �ۼ�Ʈ �������� �Է¹���
	   rate = ratePercent / 100;

	   amount1 = (int) ( amount0  + amount0 * rate );  // double ���� int ������ �����ϱ� ���� �ݵ�� ĳ��Ʈ���Ѿ���
	   amount2 = (int) ( amount1  + amount1 * rate );  //   amount1 * rate�� double Ÿ���� ��  
	   amount3 = (int) ( amount2  + amount2 * rate );  //   amount2  + amount2 * rate�� double Ÿ���� ��
	   amount4 = (int) ( amount3  + amount3 * rate );  //   double Ÿ���� ���� int ������ ������� ����
	   amount5 = (int) ( amount4  + amount4 * rate );  //   �� ĳ��Ʈ �ʿ���

	   System.out.println("\n  * Initial Principal = " + amount0 + "(won)");
	   System.out.println("  * Interest Rate     = " + rate + "\n");

	   System.out.println("  * Principal and Interest after 1 year  = " + amount1 + "(won)");
	   System.out.println("  * Principal and Interest after 2 years = " + amount2 + "(won)");
	   System.out.println("  * Principal and Interest after 3 years = " + amount3 + "(won)");
	   System.out.println("  * Principal and Interest after 4 years = " + amount4 + "(won)");
	   System.out.println("  * Principal and Interest after 5 years = " + amount5 + "(won)");
   }
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷� ���캸�� ���α׷��� ���� �ľ��϶�.
 *       
 *   2) ���α׷� �����Ͽ� ��� Ȯ���϶�.
 *
 *
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ���ݰ� �������� �ѹ��� �Է¹޾� �����հ� ����ϰ� �����Ѵ�.
 *      ���ݰ� ������ �Է�, �����հ��� ����� ���� �� �ݺ��Ͽ� ���α׷��� ������ �� �ֵ��� �����϶�. 
 *   
 *   2) �� ���α׷��� �ų� ������ �����հ踸 ����Ѵ�. 
 *      �����հ�� �ƴ϶� ���� �⵵�� ���� �⵵�� �����հ� ���̵� ����ϵ��� ���α׷����� �����϶�.
 *      
 *   3) 10�� ���� �ų⸶�� ���� ���ڸ� ���� �����հ� ���Ͽ� ����ϴ� ���α׷�����  �����϶�. 
 *   
 *      ���� 50�� ���� �Ǵ� 100�� ������ �����հ踦 ���ϴ� ���α׷����� �����Ѵٸ� 
 *      ���� �� �� �ְڴ°�? �� �� �ִٰ� �����Ǵ� �ͱ��� �����غ���.
 *      
 *      (������ ��Ȯ�ϰ� ���� �� �� �ִ� ����� �ݵ�� �͵��ؾ� ��)
 *      
 * 
 * [ ������� ]
 *
 *   o �ǽ������� �� ������ �־��� ���α׷��� ��Ÿ���� �̿��Ͽ� ���α׷��� �ۼ��Ͽ��� �Ѵ�. 
 *            
 */
