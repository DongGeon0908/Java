package ex03_scores;

/*
 * [ ScoresAverage_UsingMethod ]: �޼ҵ带 �̿��Ͽ�  ������ �Է��Ͽ� ��� �� ��� �̻� �ο��� ���
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ� �ܿ� Ư�� �۾��� �����ϴ� �޼ҵ带 �ۼ��Ͽ� ��ü �۾��� ������
 *     2) �迭������ ����, For ������ �̿��� ������ ����� �� ���� ����
 *  
 *   o �л� ����ŭ�� ������ �Է��Ͽ� �迭������ ���ҿ� ����            
 *     - �迭������ ����: Ÿ��[] �迭���� = new Ÿ��[������_����_����];
 *         ��: int[] scores = new int[noStudents]; // noStudents���� ���Ҹ� ������ int �迭 ��ü�� �����Ͽ� scores �迭������ ����
 *         
 *     - �Է��� ���� �迭 ���ҿ� ����: �迭������[�ε���] = SkScanner.getXxx();
 *         ��: scores[0] = SkScanner.getInt();  // �迭 ������ �ε����� 0���� ������ 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o �迭�� �Ű������� �����ϴ� �޼ҵ�
 *     - ȣ��� ������ �迭 ���Ұ� ����Ǹ� ȣ���� �������� ����� ����� ����
 *   
 *   O �迭�� ��ȯ������ ��ȯ�ϴ� �޼ҵ�
 *      - ȣ��� �޼ҵ忡�� �迭 ��ü �����Ͽ� ���� �����Ͽ� ��ȯ
 *      - C ������ ȣ��� �Լ����� �迭 ������ �� ���� ������ �� ��ȯ�ϸ� �ȵ�
 *        (C�� �迭������ �ý��� ���ÿ� �Ҵ�Ǳ� ������ �Լ��� ����Ǹ� �迭������ �����Ұ� �������� ������)                                   
 */ 

class Ex5_1_ScoresAverage_UsingMethod {
	
	public static void main(String[] args) {   

		System.out.println("\n  ** ���� ��Ȳ�� ���� �л��� �Է� **");  
		int  noStudents = SkScanner.getInt("  o �л��� �Է� > ");  // �л� ���� �Է��Ͽ� noStudents ������ ����
		
		int[] scores = getScores(noStudents);  // noStudents ���� ������ �Է��Ͽ� ������ �迭 ��ü�� scores �迭������ ���� 

		int sumScores = getSum(scores);        // �������� ���� ���Ͽ� sumScores ������ ����		
		double avgScores = getAverage(sumScores, noStudents); // �Ǽ� ���� ��� ���Ͽ� avgScores ������ ����		
		int cntGeAverage = getCountGE(scores, avgScores);  // ��� �̻� �ο����� ���Ͽ� cntGeAverage ������ ����

		outputScores(scores, "\n  **  �Էµ� " + noStudents + "���� ���� **");	
		outputScoresInfo(noStudents, sumScores, avgScores, cntGeAverage);

	}
	
	// �־��� n���� ������ �Է��Ͽ� �迭�� ������ �� �迭�� ��ȯ
	static int[] getScores(int n) {
		int[] scores = new int[n]; // n���� ������ ������ �迭 ��ü�� �����Ͽ� scores �迭������ ����

		/*
		 *  n���� ���� �Է��Ͽ� scores �迭������ �����ϰ� �� ����
		 */
		System.out.println("\n  **  " + n + "���� ���� �Է� **");  	

		// n ���� �������� 10���� �� ���ο� �Է��Ͽ� ���ҿ� �����ϰ� ���� ����
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("  o " + ( i + 1) +"��°���� " + 
						((n - i) >= 10 ? 10 : (n - i)) + "�� ���� �Է� > ");

			scores[i] = SkScanner.getInt(); // ���� �� �Է��Ͽ� scores[i]�� ����    
		}
		
		return scores;
	}
	
	// scores �迭�� ��� ���ҵ���  Ÿ��Ʋ�� �Բ� ���
	static void outputScores(int[] scores, String title) {
		System.out.print(title);  
		
		int n = scores.length;
		
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "��°���� " + 
						((n - i) >= 10 ? 10 : (n - i))  + "���� ����: " );

			System.out.print(scores[i] + "  ");
		}
	}	

	// �־��� �����迭 ints[]�� ��� ������ ���� ���Ͽ� ��ȯ
	static int getSum(int[] ints) {
		int sum = 0;        // ���� ���ϱ� ���� sum ������ �ݵ�� 0���� �ʱ�ȭ�ؾ� ��

		for (int n : ints)  // �����迭 ints[]�� ��� ���Ұ� �ڵ������� n�� �ѹ��� ����Ǿ� 
			sum += n;       //   sum = sum + n;�� �ݺ� �����

		return sum;
	}
	
	// �հ� ������ �־����� �Ǽ� ����� ���� ��ȯ�ϴ� �޼ҵ�
	static double getAverage(int sum, int n) {
		return sum / (double) n; // �Ǽ� ��� ���Ͽ� ��ȯ
	}
	
	// ���� �迭�� ������ �־����� ���� �̻��� ���� ������ ���Ͽ� ��ȯ
	static int getCountGE(int[] ints, double score){	
		int cnt = 0;

		for (int i = 0; i < ints.length; i++) 
			if (ints[i] >= score)
				cnt++;       // ���Ұ� score �̻��̸� cnt 1 ������Ŵ
		
		return cnt;
	}

	static void outputScoresInfo(int no, int sum, double avg, int cntGeAverage) {

		System.out.println("\n\n  ** �л� ���� ��Ȳ **");
		System.out.println("  * �� �л��� = " + no);
		System.out.println("  * " + no + "�� ���� �� = " + sum);
		System.out.println("  * " + no + "�� ���� ��� = " + avg);
		System.out.println("  * ��ü " + no + "�� �� ��� �̻� �ο���: " + cntGeAverage);  
	}

}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ���� �迭�� ���õ� �޼ҵ带 ����Ͽ� �迭������ �ٷ�� ���α׷��̴�.
 *      �迭����, �ݺ���, �޼ҵ� ���� ���յ� ���� ��Ÿ���� 
 *      ���α׷��� �ۼ��ϱ� ���� ����� �ʿ��ϴ�.      
 *      
 *   2) ���α׷��� �����Ͽ� �������� �Է��ϰ� ����� Ȯ���϶�.
 *   
 *   3) �� ���α׷��� �Է��ϴ� �������� ������ ���� ���� ������ �� �ֵ��� �� �ۼ���
 *      ���� ���α׷��̴�.
 */
