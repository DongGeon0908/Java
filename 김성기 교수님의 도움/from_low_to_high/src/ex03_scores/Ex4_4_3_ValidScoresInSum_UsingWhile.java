package ex03_scores;

/*
 *  [ ScoresInSum_UsingWhile2 ]: while ������ 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ�   
 *            
 *    o while ��
 *      - while(�ݺ�����)
	              �ݺ�_������_����
	              
 *      - �ݺ������� true�� ���� �ݺ�_������_������ �ݺ�
 *	               
 */

class Ex4_4_3_ValidScoresInSum_UsingWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ� ****\n");
		
		int score;
		int sum = 0;

		System.out.println("  ** 0���� 100 ������ ������ �Է�(-1 �Է½� ����) **");
		score = SkScanner.getInt("  o 0���� 100 ������ ���� > ");     // ���� �Է�

		while(true) {
		  if (score == -1)
			  break;
		  
		   if (score > 0 && score <= 100)  // ������ 0���� 100������ �ùٸ� �����̸�
		      sum = sum + score;           //   �տ� ����

		   score = SkScanner.getInt("  o 0���� 100 ������ ���� > ");  // ���� �Է�
		}

		System.out.println("\n  * sum = " + sum); 
	}
}
