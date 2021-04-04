/**
 * [ ScoresSum_UsingForEach.java ]: for-each �� ����Ͽ� ���� 10�� �� ���ϱ�   
 *            
 *  o for-each ��
 *    - �������: for (Ÿ�� ����_������_����: �迭����)
 *	                      �ݺ�_������_����  
 *      
 *    - ���: �迭������ ��� ���Ҹ� �� ���� ����Ͽ� �ڵ������� �ݺ� �۾� �����ϴ� �ݺ���
 *    - ������: ��õ� ����_������_������ �迭 ���Ҹ� �ڵ������� �ϳ��� ������� ���� ������ŭ �ݺ� ���� 
 */

class Ex4_3_09_ScoresSum_UsingForEach {
	public static void main(String[] args)  {
		
		int[] scores = { 90, 95, 79, 83, 88, 65, 72, 83, 81, 96 };

		int sum = 0;

		// for-each ��: scores �迭������ �� ���ҿ� ���� �ڵ������� �ݺ��Ͽ� �� ����
		for (int score : scores) // scores �迭������ ���� �ϳ����� score ������ �����Ͽ�
		    sum = sum + score; 	 //    score ���� sum�� ����
		
		System.out.println("\n  ** for-each �� ����Ͽ� ���� 10�� �� ���ϱ� **\n  ");
		System.out.println("  * ������ ����: " + scores.length);    
		System.out.println("  * ������ ��: " + sum); 
				
		// for (int score : scores) 
		//    sum = sum + score; 
		//
		//    ==> for ������ ��ȯ�ϱ�: scores �迭�� ���� ������ŭ ���� �ݺ���Ŵ
		
		sum = 0;

		for (int i = 0; i < scores.length; i++) {	// i�� 0���� (���� ���� - 1)���� �ݺ��Ͽ� �� ����
		    int score = scores[i];                  //   i��° ���Ҹ� score�� ����
		    sum = sum + score;; 	                //   score ���� sum�� ����
		}
		
		System.out.println("\n\n  ** for �� ����Ͽ� ���� 10�� �� ���ϱ� **\n  ");
		System.out.println("  * ������ ����: " + scores.length);    
		System.out.println("  * ������ ��: " + sum); 
				
		// �� �κп� �ǽ� ���� �ۼ��϶�.
	}
}

/*
 * 
 * [ �ǽ����� ]
 * 
 *   o ���� ����� �̸��� �����ϴ� ���ڿ� �迭 names�� ������ ���� �����ϰ� �ʱ�ȭ �� �� 
 *     for ���� for-each ���� ���� �̿��Ͽ� ����ϴ� �ڵ带 �߰��� �ۼ��϶�.
 *      
 *       String[] names = { "ȫ�浿",  "�̸���", "���ڹ�" };  // ���� �̸� �����ϴ� �迭
 *      
 * 
 * [ ������� ]
 * 
 *   o �ʺ����� �� for-each �� ������� �ʴ� �� ����
 *   
 *   o �� ������ for ���� ������ ������ for-each ���� ���� ���� �������� �����̸�
 *     ������ for �� ������ ���� �ξ� �߿��ϱ� ������
*/
