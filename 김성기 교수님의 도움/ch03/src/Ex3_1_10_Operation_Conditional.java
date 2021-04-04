/**
 * [ Operation_Conditional: ���� ������ ���� ]
 *     
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ������ �����Ͽ� ��� �� ���
 *      
 *   o ���� ����
 *     - �����ڴ� ? : 
 *     - ����: ���� ? ��1 : ��2
 *     - ������ true�̸� ���� ����� ��1�� �����ϰ� false�̸� ��2�� ����� ���� 
 */

class Ex3_1_10_Operation_Conditional   {
	public static void main(String[] args)  {

		int score1 = 94;
		int score2 = 89;
		
		System.out.println("\n  ** ���� ���� ( ? : ) **\n");

		System.out.println("  * ���� �ʱⰪ: score1 = " + score1 + ", score2 = " + score2); 
		System.out.println(); 

		System.out.println("  * score1 >= 90 ? \"A\" : \"not A\"        := " + ( score1 >= 90 ? "A" : "not A" )); 
		System.out.println("  * score1 > score2 ? score1 : score2   := " + ( score1 > score2 ? score1 : score2 )); 
		System.out.println("  * score2 < 60 ? \"fail\" : \"not fail\"   := " + ( score2 < 60 ? "fail" : "not fail" )); 
		System.out.println(); 
		
		String grade;
		int maxScore;
		System.out.println("  * grade = score1 >= 90 ? \"A\" : \"not A\"         := " + ( grade = score1 >= 90 ? "A" : "not A" )); 
		System.out.println("  * maxScore = score1 > score2 ? score1 : score2 := " + ( maxScore = score1 > score2 ? score1 : score2 )); 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */