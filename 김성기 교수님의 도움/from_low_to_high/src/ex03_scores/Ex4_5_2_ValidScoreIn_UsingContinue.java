package ex03_scores;

/*
 *  [ ValidScoreIn_UsingContinue ]: continue ���� �̿��Ͽ� 1������ 100 ������ �ùٸ� ���� �Է��ϱ�   
 *            
 *    o while ��
 *      - while(�ݺ�����)
	              �ݺ�_������_����
	              
 *      - �ݺ������� true�� ���� �ݺ�_������_������ �ݺ�
 *	               
 */

class Ex4_5_2_ValidScoreIn_UsingContinue {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1������ 100 ������ �ùٸ� ���� �Է��ϱ� **\n");

		int score;

		// 0���� 100������ ������ �Էµ� ������ �ݺ��Ͽ� ��ȿ�� ������ �Է��ϰ� ��
		while(true) {
			score = SkScanner.getIntWithPrompt("  o 0���� 100������ ���� > ");

			if (score < 0 || score > 100)  {     // �߸��� ������ �Էµ� ��� 
				System.out.println("  ?? �Է� ����, �߸��� ����: " + score + "\n"); 
				continue;  // ������ �ݺ� �κ��� �����ϰ� �ݺ��� ������ �����ϰ� ��
			}

			break;   // �ùٸ� ���� �Է½� ���� �ݺ��� ���
		}

		System.out.println("  * �Էµ� �ùٸ� ����: " + score);
	}
}
