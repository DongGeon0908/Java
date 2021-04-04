/**
 * [ TypeConversion_AutomaticInExpression ]: ���Ŀ����� �ڵ��� Ÿ�Ժ�ȯ Ȯ���ϱ�
 *        
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �ڵ��� Ÿ�� ��ȯ�� �߻��ϴ� ������ ��� �� ���
 *       
 *   o �ڵ��� Ÿ�� ��ȯ�� �߻��ϴ� ���
 *     - ��� ����� �� ���꿡�� �ǿ����� Ÿ���� �ٸ� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *     - ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ ����� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *     - ���ڿ� ���� ���꿡�� ���ڿ��� ���ڿ��� �ƴ� ���� ���ӽ�ų ���: ���ڿ��� �ƴ� ���� ���ڿ��� ��ȯ
 *     
 *   o Java������ ���� Ÿ�԰� ���� Ÿ�� ���� 
 *        byte �� char/short �� int  ��  long  ��  float  ��  double
 *        
 *   o ���Ŀ������ڵ��� Ÿ�� ��ȯ
 *     - ���꿡���� �ڵ��� Ÿ�Ժ�ȯ�� ����
 *     - ������ ������ ��� �ڵ��� Ÿ�Ժ�ȯ�� ���� �� �߻� 
 */

class Ex3_3_2_TypeConversion_AutomaticInExpression  {
	public static void main(String[] args)  {

		System.out.println("\n  ** �ڵ��� Ÿ�� ��ȯ�� �����ϴ� ���� **\n");
		
		/*
		 * ��� ������ ���Ե� ���Ŀ����� �ڵ��� Ÿ�� ��ȯ
		 */		
		int amount = 1000000;
		double rate = 0.04;
		System.out.println("  * ���� �ʱⰪ: amount = " + amount + ", rate = " + rate);  
			
		System.out.println("  * amount * (1 + rate) := " + ( amount * (1 + rate) ));  // (1 + rate): ������ + �Ǽ���, ( amount * (1 + rate) ): ������ * �Ǽ���
		System.out.println();
		
		/*
		 * ���� ����� �� ������ ���Ե� ���Ŀ����� �ڵ��� Ÿ�� ��ȯ
		 */		
		int sumScores = 894,  maxScore = 99, noStudents = 10;
		double avgScores;
		System.out.println("  * ���� �ʱⰪ: sumScores = " + sumScores + ", maxScore = " + maxScore + ", noStudents = " + noStudents); 
		
		System.out.println("  * avgScores = sumScores / noStudents := " + ( avgScores = sumScores / noStudents )); // avgScores = sumScores / noStudents: �Ǽ����� = ������
		System.out.println("  * avgScores + 10 > maxScore - 10 := " + ( avgScores + 10 > maxScore - 10 )); // avgScores + 10: �Ǽ��� + ������, ( avgScores + 10 > maxScore - 10 ): �Ǽ��� > ������ 
		System.out.println();
					
		/*
		 * ���ڿ� ���� ������ ���Ե� ���Ŀ����� �ڵ��� Ÿ�� ��ȯ
		 */	
		int thisYear = 2016;
		System.out.println("  * ���� �ʱⰪ: thisYear = " + thisYear); 
		
		System.out.println("  * \"10�� ���� ������\" + (thisYear + 10) := " + ( "10�� ���� ������ " + (thisYear + 10) )); // ( "10�� ���� ������ " + (thisYear + 10): ���ڿ� + ������	
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   2) ���Ŀ��� �ڵ��� Ÿ�Ժ�ȯ�� �Ͼ�� �κ��� ��Ȯ�� �ľ��϶�. 
 *  
 */
