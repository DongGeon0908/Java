package ex03_scores;

/*
 *  ScoresSum_NotUsingForEach.java: for-each ������ �ۼ��� ���α׷��� for ������ �����ϱ�   
 *            
 *    o for-each ������ �ۼ��� ���α׷��� for ������ ���� ��� 
 *      - for (Ÿ�� ����_������_����: �迭����)
 *	           �ݺ�_������_���� 
 *	            
 *	      ==>
 *	      
 *	      for (int i = 0; i < �迭����.length; i++) {
 *	           Ÿ�� ����_������_���� = �迭����[i];
 *	           �ݺ�_������_����;
 *	      }
 *	               
 */

class Ex4_3_8_ScoresSum_NotUsingForEach {
	public static void main(String[] args)  {
		System.out.println("\n  ** for-each ������ �ۼ��� ���α׷��� for ������ �����ϱ� **\n  ");
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for (int score : scores) 
		//    sum = sum + score; 	 
		// ==> for ������ ��ȯ�ϱ�: scores �迭�� ���� ������ŭ �ݺ���Ŵ
		for (int i = 0; i < scores.length; i++) {	// i�� 0���� (���� ���� - 1)���� �ݺ��Ͽ� 
		    int score = scores[i];  // i��° ���Ҹ� score�� ����
		    sum = sum + score;; 	// score ���� sum�� ����
		}
		
		System.out.println("  * �������� ����: " + scores.length);    
		System.out.println("  * �������� ��: " + sum); 
	}
}
