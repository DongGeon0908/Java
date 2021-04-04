package practice09;

/**
 *  [ 9�� �ǽ�����  2�� �⺻ ���α׷� ]
 *  
 *    2. inputScore() �޼ҵ��� ���� ó�� 
 *    
 *       Score Ŭ������ ������ �����ϴ� int score�� �ʵ�� ������. inputScore() �޼ҵ�� min����
 *       max ���� ������ �Է��Ͽ� score �ʵ忡 �����ϴ� �޼ҵ��̸�, �Էµ� ���� ������ ����� 
 *       ��ü������ ���� ó���� �����Ѵ�. main() �޼ҵ忡�� �־��� ������ �Էµ� ������ ����Ѵ�.
 *       
 *       ���� ���� ���� ó���� ���Ͽ� ������ 3���� ������� ���� ó���� �����ϵ��� ���α׷��� �߰��� �ۼ��϶�.
 *       
 *       1) Score Ŭ������ errorMsg �ʵ嵵 �����϶�. �Էµ� ���� ������ ����� errorMsg �ʵ忡 
 *          ���� �޽����� �����ϰ�, �Է� ���� ������ ������ errorMsg �ʵ忡 null�� �����ϰ� �Էµ� ������ 
 *          score �ʵ忡 �����ϴ� void inputScore1(int min, int max, String prompt) �޼ҵ带 �ۼ��϶�. 
 *         
 *          main() �޼ҵ忡�� �� �޼ҵ带 ȣ���Ͽ� errorMsg �ʵ尡 null�� �ƴϸ� ������ ó���ϰ�, 
 *          errorMsg �ʵ尡 null�̸� �Էµ� ������ ����ϴ� �ڵ带 �ۼ��϶�. 
 *         
 *       2) �Էµ� ���� ������ ����� Exception Ŭ������ ���ܰ�ü�� �����Ͽ� ���� �޽��� 
 *          "�����Է� ����: ������ ��� ����"�� ������ �� ���ܰ�ü�� ������, �Է� ���� ������ ������ 
 *          �Էµ� ������ score �ʵ忡 �����ϴ� void inputScore2(int min, int max, String prompt) 
 *          �޼ҵ带 ���ܹ߻� �޼ҵ�� �ۼ��϶�. 
 *         
 *          �� �޼ҵ带 ȣ���ϴ� main() �޼ҵ忡�� ���ܰ�ü�� ��� ���� ó���ϴ� �ڵ带 �ۼ��϶�.
 *         
 *       3) �Էµ� ���� ������ ����� ScoreException Ŭ������ ���ܰ�ü�� �����Ͽ� ���� �޽���
 *          "�����Է� ����: ������ ��� ����"�� ������ �� ���ܰ�ü�� ������, �Է� ���� ������ ������ �Էµ� ������ 
 *          score �ʵ忡 �����ϴ� void inputScore3(int min, int max, String prompt) �޼ҵ带 
 *          ���ܹ߻� �޼ҵ�� �ۼ��϶�. 
 *         
 *          �� �޼ҵ带 ȣ���ϴ� main() �޼ҵ忡�� ���ܰ�ü�� ��� ���� ó���ϴ� �ڵ带 �ۼ��϶�. 
 *          �̸� ���ؼ� ScoreException Ŭ������ �ۼ��϶�
 */

class Score {
	int score;  // ������ �����ϴ� �ʵ�

	// min���� max ������ ������ �Է��Ͽ� ��ȯ�ϴ� �޼ҵ�
	//    ������ ����� ������ �ԷµǸ� ���� �޽��� ����ϰ� �ٽ� ������ �Է���
	boolean inputScore(int min, int max, String prompt, String errorMsg) { 
		int score = SkScanner.getInt(prompt); // ������Ʈ �޽��� ��� �� ���� �Է�
		if (score >= min && score <= max) {   // �Է� ������ min�� max �����̸� 
			this.score = score;                   //   �Է� ������ ����
			return true;
		} else {
			System.out.println(errorMsg);        // ���޵� ���� �޽����� ���
			return false;
		}
	}
}

class Practice9_2_ScoreMain {
	public static void main(String[] args) {
		Score sc = new Score();

		while(true) 
			if (sc.inputScore(0, 100, "\n  o 0�� 100 ���� ���� �Է� > ", 
					"\n  ??? �߸��� ���� �Էµ�"))
				break;

		System.out.println("\n  * �Էµ� ����: " + sc.score);
	}  
}


