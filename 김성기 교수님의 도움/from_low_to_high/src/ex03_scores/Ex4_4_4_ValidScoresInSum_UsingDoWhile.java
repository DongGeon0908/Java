package ex03_scores;

/*
 *  [ ValidScoresInSum_UsingDoWhile ]: while ������ 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ�   
 *            
 *    o do-while ��
 *      - do {
	           �ݺ�_������_����
	      } while(�ݺ�����);
	           
 *      - �ݺ�_������_������ �����ϰ� �ݺ������� true�̸� �ٽ� �ݺ������� ����
 *	               
 */

class Ex4_4_4_ValidScoresInSum_UsingDoWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ� ****\n");
		
		int score;
		int sum = 0;

		System.out.println("  ** 0���� 100 ������ ������ �Է�(-1 �Է½� ����) **");

		do {
			   score = SkScanner.getIntWithPrompt("  o 0���� 100 ������ ���� > ");
			   if (score > 0 && score <= 100)
			      sum = sum + score;
			   else if (score < -1 || score > 100)
			      	System.out.println("  ?? �Է� ����, �߸��� ����: " + score + "\n");      
			} while (score != -1);   

		System.out.println("\n  * sum = " + sum); 
	}
}
