/**
 * [ ScoresInSum_UsingInfiniteWhile ]: 
 *        �ݺ������� true�̾ ������ �ݺ��Ǵ� while������ 0���� 100 ������ ������ �Է��Ͽ� �� ���ϱ�   
 *            
 *   o while ��
 *     - ��� ����: while(�ݺ�����)
 *	                               �ݺ�_������_����                         
 *	              
 *     - ���: �ݺ������� true�� ���� �ݺ�_������_������ �ݺ��ϴ� ������ false�̸� �ݺ� ����
 *     - Ư�̻���: ó�� �ݺ������� false�̸� �ݺ�_������_������ �� ���� ������� ����

 *    
 *   o while ���� ���� �ݺ�
 *     - while �� �ݺ������� �׻� true�� �Ǵ� ���
 *            while(true) ...
 *            
 *     - while(true)�� �ܰ������� ������ �ݺ��ϴ� ���� ����(infinite loop)
 *      
 *     - while �� ������ ���������� while ���� ����� ���� break �� �Ǵ� return �� ���
 *	               
 */

class Ex4_3_12_ValidScoresInSum_UsingInfiniteWhile {
	public static void main(String[] args)  {
		System.out.println("\n  **** 0���� 100 ���� ������ �Է��Ͽ� �� ���ϱ� ****\n");

		int score;
		int sum = 0;

		System.out.println("  ** 0���� 100 ���� ������ �Է�(-1 �Է� �� ����) **");
		
		while(true) {    // while ���� �ݺ������� true�̹Ƿ� ���� �ݺ���
			score = SkScanner.getIntWithPrompt("  o 0���� 100 ������ ���� > ");

			if (score >= 0 && score <= 100)  // �ùٸ� �����̸�
				sum = sum + score;           //   �տ� ���� 
			else if (score == -1)            // ������ -1�� �ݺ��� �����Ŵ
				break;                       //    break ���� �ݺ����� ����� �ϴ� ������
			else                             // ������ -1 �̸� �Ǵ� 100 �ʰ��̸� ���� ó��
				System.out.println("  ??? �Է� ����, �߸��� ����: " + score + "\n");
		}
		
		System.out.println("\n  * sum = " + sum); 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ���� �ݺ��� �̿��Ͽ� 0���� 100 ���� �Էµ� ������ ���� ���Ѵ�.
 *      - 0���� 100 ���� �����̸� �� ����
 *      - ������ -1�̸� break ������ while �� ���
 *      - -1 �̸� �Ǵ� 100 �ʰ� �����̸� ���� ó��
 *      
 *      - while �� ���� �� ������ �� ���
 *
 *   2) �Էµ� score ���� ���� ���α׷��� ������� ��Ȯ�� �����϶�.
 */
