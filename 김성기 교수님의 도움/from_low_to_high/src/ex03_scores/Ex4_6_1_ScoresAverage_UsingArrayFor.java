package ex03_scores;

/*
 * [ ScoresAverage_UsingArrayFor ]: �迭�� for ������ �̿��Ͽ� ������ �Է��Ͽ� ��� �� ��� �̻� �ο��� ���
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �迭������ ����, for ������ �̿��� ������ ����� �� ���� ����
 *  
 *   o �л� ����ŭ�� ������ �Է��Ͽ� �迭������ ���ҿ� ����
 *            
 *     - �迭������ ����: Ÿ��[] �迭���� = new Ÿ��[������_����_����];
 *         ��: int[] scores = new int[noStudents]; // noStudents���� ���Ҹ� ������ int �迭 ��ü�� �����Ͽ� scores �迭������ ����
 *         
 *     - �Է��� ���� �迭 ���ҿ� ����: �迭������[�ε���] = SkScanner.getXxx();
 *         ��: scores[0] = SkScanner.getInt();  // �迭 ������ �ε����� 0���� ������ 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o for ������ �迭�� ����ϸ� �����ϰ� ����Ʈ�� �ڵ尡 �ۼ���   
 *             
 *   o SkScanner.getInt(): ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�                                  
 */ 

class Ex4_6_1_ScoresAverage_UsingArrayFor {
	public static void main(String[] args) {   

		int noStudents; // �л� ���� �����ϴ� ����
		System.out.println("\n  ** ���� ��Ȳ�� ���� �л��� �Է� **");  
		noStudents = SkScanner.getInt("  o �л��� �Է� > ");

		// noStudents ���� ������ ������ �迭 ��ü�� scores �迭������ ���� 
		int[] scores = new int[noStudents]; 

		/*
		 *  noStudents ���� ���� �Է��Ͽ� scores �迭������ �����ϰ� �� ����
		 */
		System.out.println("\n  **  " + noStudents + "���� ���� �Է� **");  	

		int sumScores = 0;   // ������ ���� �����ϴ� ����

		// noStudents �� �������� 10���� �� ���ο� �Է��Ͽ� ���ҿ� �����ϰ� ���� ����
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("  o " +( i + 1) +"��°���� " + 
						((noStudents - i) >= 10 ?10 : (noStudents - i)) + "���� ���� �Է� > ");

			scores[i] = SkScanner.getInt(); // ���� �� �Է��Ͽ� scores[i]�� ����    
			sumScores += scores[i];       // �Է��� scores[i]�� sum�� ������Ŵ
		}

		double avgScores = sumScores / (double) noStudents; // �Ǽ� ���� ��� ����
		int cnt = 0;  // ��� �̻� �ο����� �����ϴ� ����

		/*
		 *  �Էµ� noStudents ���� ������ ��� ��� 
		 */
		System.out.print("\n  **  �Էµ� " + noStudents + "���� ���� **");  
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "��°���� " + 
						((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "���� ����: " );

			System.out.print(scores[i] + "  ");

			if (scores[i] >= avgScores)
				cnt++;      // ������ ��� �̻��̸� cnt 1 ������Ŵ
		}

		/*
		 *  ������ ���� ��Ȳ ��� 
		 */
		System.out.println("\n\n  ** �л� ���� ��Ȳ **");
		System.out.println("  * �� �л��� = " + noStudents);
		System.out.println("  * " + noStudents + "�� ���� �� = " + sumScores);
		System.out.println("  * " + noStudents + "�� ���� ��� = " + avgScores);
		System.out.println("  * ��ü " + noStudents + "�� �� ��� �̻� �ο���: " +
				cnt);  
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� for ������ ����Ͽ� �迭������ ������ �����ֱ� ���� �ۼ��� ���̴�. 
 *      �迭������ �ݺ����� ���յ� ���� ��Ÿ���� ���α׷��� �ۼ��ϱ� ���� ����� �ʿ��ϴ�.      
 *      
 *   2) ���α׷��� �����Ͽ� �������� �Է��ϰ� ����� Ȯ���϶�.
 *   
 *   3) �� ���α׷��� �Է��ϴ� �������� ������ ���� ���� ������ �� �ֵ��� �� �ۼ���
 *      ���� ���α׷��̴�.
 */
