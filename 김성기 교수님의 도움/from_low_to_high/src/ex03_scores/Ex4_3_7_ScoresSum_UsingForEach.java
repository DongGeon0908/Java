package ex03_scores;

/*
 *  ScoresSum_UsingForEach.java: for-each ���� ����Ͽ� 10�� ������ �� ���ϱ�   
 *            
 *    o for-each ��
 *      - �������: for (Ÿ�� ����_������_����: �迭����)
	                     �ݺ�_������_����  
 *      
 *      - �迭������ ��� ���Ҹ� �� ���� ����Ͽ� �ڵ������� �ݺ� �۾��� �����ϴ� �ݺ���
 *      - ��õ� ����_������_������ �迭 ���Ҹ� �ڵ������� ������� ���� ������ŭ �ڵ������� �ݺ� ���� 
 */

class Ex4_3_7_ScoresSum_UsingForEach {
	public static void main(String[] args)  {
		System.out.println("\n  ** for-each ���� ����Ͽ� 10�� ������ �� ���ϱ� **\n  ");
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for-each ��: scores �迭������ �� ���ҿ� ���� �ڵ������� �ݺ���Ŵ
		for (int score : scores) // scores �迭������ ���� �ϳ����� score ������ �����Ͽ�
		    sum = sum + score; 	 //     score ���� sum�� ����

		System.out.println("  * �������� ����: " + scores.length);    
		System.out.println("  * �������� ��: " + sum); 
	}
}
