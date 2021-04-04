/**
 * [ TypeConversion_CastInExpression ]: ���Ŀ����� ������ Ÿ�� ��ȯ
 *        
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ������ Ÿ�� ��ȯ�� �����ϴ� ������ ��� �� ���
 *       
 *   o ������ Ÿ�� ��ȯ�� �ʿ��� ���
 *     - �����ڸ� Ư�� Ÿ�Կ� ���� �����ڷ� �۵���ų ��� 
 *     - �ǵ����� ���� �ս��� �����ϴ� ���(���� Ÿ���� ���� ���� Ÿ�� ������, �ǵ��� �Ҽ��� ���� ���� ��)
 *     
 *   o Java������ ���� Ÿ�԰� ���� Ÿ�� ���� 
 *       byte �� char/short �� int  ��  long  ��  float  ��  double      
 *       
 *   o ���Ŀ����� ������ Ÿ�Ժ�ȯ 
 *     - ������ Ÿ�Ժ�ȯ �ʿ��� ��� ���� �߻�
 *     - �� ��� ĳ��Ʈ ���� ����Ͽ� Ÿ�Ժ�ȯ �ǽ�
 */

class Ex3_3_3_TypeConversion_CastInExpression  {
	public static void main(String[] args)  {

		System.out.println("\n  ** ������ Ÿ�� ��ȯ�� �����ϴ� ���� **\n");
		
		/*
		 * �����ڸ� Ư�� Ÿ�Կ� ���� �����ڷ� �۵���ų ����� ĳ��Ʈ ��
		 */
		int sum = 894;
		int n = 10;
		double avg;
		System.out.println("  * ���� �ʱⰪ: sum = " + sum + ", n = " + n); 
		System.out.println("  * avg = sum / (double) n  := " + (  avg = sum / (double) n ));      // n�� int ���� double ������ ��ȯ�Ͽ� �Ǽ� ������ ����
		System.out.println();
		
		/*
		 * �ǵ����� ���� �ս��� �����ϴ� ����� ĳ��Ʈ ��
		 */
		int amount = 1000000;
		double rate = 0.04;   
		System.out.println("  * ���� �ʱⰪ: amount = " + amount + ", rate = " + rate); 

		System.out.println("  * amount = (int) ( amount * (1 + rate) )     := " + ( amount = (int) ( amount * (1 + rate) ) ));      // �Ǽ� ���� ���� ������ �����ϱ�
		System.out.println("  * amount = amount + (int) ( amount * rate )) := " + ( amount = amount + (int) ( amount * rate ) ));   //   ���� �ǵ��� ���� �ս� ����
		System.out.println();

		double pi = 3.141592;		
		System.out.println("  * ���� �ʱⰪ: pi = " + pi); 

		System.out.println("  * (int) ( (pi + 0.005) * 100 ) / 100.0   := " + ( (int) ( (pi + 0.005) * 100 ) / 100.0 ));  // �ݿø� ���� �ǵ��� ���� �ս� ����
		System.out.println();
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   2) ���Ŀ��� ������ Ÿ�� ��ȯ�� �ʿ伺�� �����϶�.
 *  
 */
