package ex12_more;
/*
 * [ PrincipalAndInterestUsingFor_ByNovice ]: 0.05 �������� ���� ���ڷ� 10������� �����հ� ���ϱ� 
 *  
 *    o ���α׷��� ��Ÿ�� 3: �������� ���� ������ �����հ� ���ϱ� 
 *                      + for �� ���
 *     
 *    o �� ���α׷��� ���� ���α׷��� ��Ÿ���� �𸣴� �ʺ��ڰ� �ۼ��� ������ ���α׷���
 *      ( �̷��� ���α׷��� �ۼ��ϸ� ���� �ȵ�, �ƹ��� ������ ���α׷��̶� �ϴ���
 *        ������, �޼ҵ��, Ŭ������ ���� ����� �۸�Ǿ�� �ϸ�, good styling programmer 
 *        ������ ���߱� ���� ����ؾ� �� )  
 */

class Ex4_02_3_PrincipalAndInterestUsingFor_ByNovice  {
	public static void main(String[] args)  {

		int a = 2000000; 
		System.out.println(a);

		for (int i=1; i <= 10; i++) {   
			a = (int) (a * 1.05);
			System.out.println(i + ": " + a);
		}
	}
}
     
 /*
  * [  ���α׷��� ���� �� ����]
  *  
  *  o �� ���α׷��� ��������
  *    1) i�� for �� �����������, a ������ ��� �뵵�� ���Ǵ��� �� �� ����.
  *    2) < a = 2000000; >���� a ������ 2000000�� �����ϴ� ������ �˱� ��ƴ�.
  *    3) < a * 1.05 >���� 1.05�� ���ϴ� ������ �� �� ����.
  *    4) < a = (int) (a * 1.05) >�� 10�� �ݺ� �����Ͽ� ��� �����ϴ� ������ �������� �˱� ��ƴ�.
  *         Ư��, (int)�� ���� Ÿ�Ժ�ȯ cast�� �����ϴ� ������ �� �� ����.
  *    5) < System.out.println("  "+ i + ":" + a); >�� ����ϴ� ������ �����ΰ��� ����ؾ� �Ѵ�.
  *    6) �� ���α׷��� �ܼ��� cast, for ���� �����ϴ� ���α׷����� ���δ�.
  *    7) ����, ������, ��� ���� �����Ϸ� �ϸ� ���α׷��� Ư�� �κ����� ã�ư� �����ؾ� �Ѵ�.
  *       ( �� ���α׷��� ���μ��� ���� ������, ���� ���μ��� 200���� ���� �Ǵ� ���α׷��̶��
  *         �� �κ��� ã�Ⱑ ���� ���� �� ���� )

  *  o �� �ۼ��� ���α׷�
  *    - ������ �� �ۼ��� ������ ���α׷��� �ʺ��ڰ� �ۼ��� ���α׷��� ��� �������� �ذ��Ѵ�
  *    - �̷��� ��Ÿ���� �ۼ��ϵ��� ����ؾ� ��
  *     
    class Ex4_2_4_PrincipalAndInterestUsingFor_Better  {
   	  public static void main(String[] args)  {
   		System.out.print("\n   **** Calculation of Principal and Interest by Compound Interest ****\n");
   		
   		int initPrincipal = 2000000;  // �ʱ� ���� ������ ����
   		double ratePercent = 0.05;    // 1�Ⱓ �������� ������ ����
   		int yearDuration = 10;        // ���������� ����
   		                                            
   		int amount = initPrincipal;    //  ó�� �־��� ����
   
   		System.out.println("\n\n  ** Principal and interest  ** \n");
   		System.out.println("  o Initial principal = " + amount + "(won)\n");
    
   		for (int i=1; i <= yearDuration; i++) {     // �����ŭ �ݺ��Ͽ� �����հ� ���ϱ�
   			amount = (int) (amount * (1 + rate));          // �����հ踦 ������ ���ϱ� ����  �Ǽ����� ���������� ��ȯ
   			System.out.println("  o Principal and interest after " + i + "  year = " + amount + "(won)");
   	    }
      }
    }
  *  
  */
