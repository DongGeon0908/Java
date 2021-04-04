package ex12_more;
/*
 * [ PrincipalAndInterest_InOut_MonoVar ]: 5�� ������ ���� �����հ� ���ϱ�
 * 
 *   o ���α׷��� ��Ÿ�� 2
 *     1) ���� ��� ��Ÿ��: �������� �����հ踦 ������ ���� �ϳ��� ���
 *     2) ���ݰ� �������� �Է��Ͽ� 5�⵿�� �����հ� ���Ͽ� ���
 *    
 *  
 *   o  �����հ��� ��� 
 *      - �����հ�: ���ݰ� ���ڸ� ���� �ݾ�
 *      - ����: ���ڿ� ���ؼ��� ���ڰ� �ٴ� ���� ���޹��
 *              (���� - �ܸ�: ���ݿ� ���ؼ��� ���ڰ� �ٴ� ���)
 *      - ���� ������ �����հ� = ���� ������ �����հ� + (���� ������ �����հ� * 1�Ⱓ ������)   
*/

class Ex4_02_2_PrincipalAndInterest_InOut_MonoVar {
   public static void main(String[] args)  {

	   System.out.println("\n  **** Calculation of Principal and Interest by Compound Interest ****\n");  	// �Է��� ���� Ÿ��Ʋ ���      

	   int amount;        // �ʱ� ���ݰ� �� �⸻�� �����հ踦 �����ϴ� ����
	   int ratePercent;   // % ������
	   double rate;       // ������ = % ������ / 100.0

	   System.out.print("  o Input initial Principal > ");
	   amount = SkScanner.getInt();  // �ʱ� ���� �Է¹���

	   System.out.print("\n  o Input interest rate per year(%) > ");  
	   ratePercent = SkScanner.getInt();  // 1�Ⱓ �������� %�� �Է¹���
	   rate = ratePercent / 100.0;        // % �������� �Ǽ� �������� ��ȯ

	   System.out.println("\n  * Initial Principal = " + amount + "(won)");
	   System.out.println("  * Interest Rate     = " + rate + "\n");

	   amount = (int) ( amount  + amount * rate );  // double ���� int ������ �����ϱ� ���� �ݵ�� ĳ��Ʈ���Ѿ���
	   System.out.println("  * Principal and Interest after 1 year  = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate );  
	   System.out.println("  * Principal and Interest after 2 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate );  
	   System.out.println("  * Principal and Interest after 3 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate ); 
	   System.out.println("  * Principal and Interest after 4 years = " + amount + "(won)");

	   amount = (int) ( amount  + amount * rate ); 
	   System.out.println("  * Principal and Interest after 5 years = " + amount + "(won)");

   }
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.
 *      
 *   2) ���α׷��� �����Ͽ� ���ݰ� �������� �Է��Ͽ� ����� Ȯ���϶�.
 *   
 *   3) ���ο� �����հ�� �������� ���� ���� �� �ݺ��Ͽ� ���α׷��� ������ �� �ֵ��� �����϶�.
 *
 *
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ���ݰ� �������� �ѹ��� �Է¹޾� �����հԸ� ����ϰ� �����Ѵ�.
 *      ���ݰ� ������ �Է�, �����հ��� ����� ���� �� �ݺ��Ͽ� ���α׷��� ������ �� �ֵ��� �����϶�. 
 *   
 *   2) �� ���α׷��� �ų� ������ �����հ踸�� ����Ѵ�. �׷��� �����հ�� �ƴ϶�
 *      ���� �⵵�� ���� �⵵�� �����հ� ���̵� ����ϵ���  ���α׷����� �����϶�.
 *      
 *      �̸� ���ؼ��� ���� �⵵�� �����հԸ� ���ϱ� ���� ���� �⵵�� �����հ踦 �ٸ� ������ �����Ͽ��� �Ѵ�. 
 *      
 *   3) 15�� ���� �ų⸶�� ���� ���ڸ� ���� �����հ� ���Ͽ� ����ϴ� ���α׷����� 
 *      �����϶�. 
 *   
 *      ���� 50�� ���� �Ǵ� 100�� ������ �����հ踦 ���ϴ� ���α׷����� �����Ѵٸ� 
 *      ���� �� �� �ְڴ°�? �� �� �ִٰ� �����Ǵ� �ͱ��� �����غ���.
 *      
 *      (������ ��Ȯ�ϸ鼭 ���� �� �� �ִ� ����� �ݵ�� �͵��ؾ� ��)
 * 
 *      
 * [ ������� ]
 * 
 *   o �ǽ������� �� ������ �־��� ���α׷��� ��Ÿ���� �̿��Ͽ� ���α׷��� �ۼ��Ͽ��� �Ѵ�. 
 *   
 *   
 *  [ ������ �����ϰ� ����غ� ���� ] 
 *  
 *    o �� ���α׷������� ����, ������, �⵵ ���� �Է¹ޱ� ���� �κ��� ��� 
 *      (1) ������Ʈ �޽����� ����ϴ� ���� (2) getInt() �޼ҵ�� �Է��Ͽ� ������ �����ϴ� ���� 
 *      �� 2���� �������� �ۼ��Ǿ� �ִ�. ��, �ʿ��� ���� �Է��ϱ� ���ؼ��� �׻� 2 ������ �ۼ��ؾ� �Ѵ�.
 *     
 *      ���� ������Ʈ �޽��� ����ϴ� ������ �����ϴ� ������ ����ȭ��Ű�� ��� �ǰڴ°�?
 *        
 *    o  �̷��� �Է� �۾��� ���� ���ϰ� �� �� �ִ� ����� �ְڴ°�?  �� ����� ����غ��ÿ�.(�̰��� ������ �ƴ�)
 *       ���� �ذ�å�� ������ �ٸ� ���α׷������� �̸� Ȱ�� ���θ� ����غ��ÿ�.
 *          
 *            
 */


    