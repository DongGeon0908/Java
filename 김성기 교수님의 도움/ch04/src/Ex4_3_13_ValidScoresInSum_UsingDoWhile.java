/**
 * [ ValidScoresInSum_UsingDoWhile ]: while ������ 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ�   
 *            
 *   o do-while ��
 *     - ��� ����
 *      
 *        do {
 *	                  �ݺ�_������_����
 *	      } while(�ݺ�����);
 *	           
 *     - ���: �ݺ�_������_������ �����ϰ� �ݺ������� true�̸� �ٽ� �ݺ������� ����
 *     - Ư�̻���: �ݺ�_������_������ �ּ��� �ѹ���  ����            
 */

class Ex4_3_13_ValidScoresInSum_UsingDoWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0���� 100 ���� ������ �Է��Ͽ� �� ���ϱ� ****\n");

		int score;
		int sum = 0;

		System.out.println("  ** 0���� 100 ���� ������ �Է�(-1 �Է� �� ����) **");

		do {
			score = SkScanner.getIntWithPrompt("  o 0���� 100 ������ ���� > ");
			if (score >= 0 && score <= 100)
				sum = sum + score;
			else if (score < -1 || score > 100)
				System.out.println("  ??? �Է� ����, �߸��� ����: " + score + "\n");      
		} while (score != -1);   // score�� -1�� �ƴ� ���� �ݺ�

		System.out.println("\n  * sum = " + sum); 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) do-while �� ����Ͽ�  0���� 100 ���� �Էµ� ������ ���� ���Ѵ�.
 *      - �Էµ� ������ 0���� 100 ���� �ùٸ� �����̸� �̸�  ����ϰ� �տ� ����
 *      - �߸��� ���� �ԷµǸ� ���� �޽��� ���
 *      - do-while ���� �ݺ������� n != -1�̹Ƿ� -1�� �ԷµǸ� do-while �� ����
 *      
 *      - do-while �� ���� �� ������ �� ���
 *
 *   2) �Էµ� score ���� ���� ���α׷��� ��������� ��Ȯ�� �����϶�.
 */
