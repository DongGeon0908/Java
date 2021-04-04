package ex03_scores;

/*
 * [ ScoresAverage_UsingClass]: Ŭ������ �̿��Ͽ� 20���� ������ �Է��Ͽ� ��� �� ��� �̻� �ο��� ���
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) Score Ŭ����: ���� ������ �����ϰ� ��, ��� ���� ���� ����ϴ� �޼ҵ带 ���� Ŭ����
 *     
 *     2) main() �޼ҵ� �ܿ� Ư�� �۾��� �����ϴ� �޼ҵ带 �ۼ��Ͽ� ��ü �۾��� ������
 *  
 *   o �л� ����ŭ�� ������ �Է��Ͽ� �迭������ ���ҿ� ����
 *       - �л����� ������ ����
 *            int noStudents = 20;   // �л� ���� �����ϴ� ����
 *            
 *     - �迭������ ����: Ÿ��[] �迭���� = new Ÿ��[������_����_����];
 *         ��: int[] scores = new int[noStudents]; // noStudents���� ���Ҹ� ������ int �迭 ��ü�� �����Ͽ� scores �迭������ ����
 *         
 *     - �Է��� ���� �迭 ���ҿ� ����: �迭������[�ε���] = SkScanner.getXxx();
 *         ��: scores[0] = SkScanner.getInt();  // �迭 ������ �ε����� 0���� ������ 
 *            scores[1] = SkScanner.getInt();  
 *            scores[2] = SkScanner.getInt();
 *             
 *   o for ������ �迭�� ����ϸ� �����ϰ� ����Ʈ�� �ڵ尡 �ۼ���   
 *             
 *   o SkScanner.getInt(): ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�                                  
 */ 
class Scores {
	int[] scores;   // �������� �����ϴ� �迭 �ʵ�
	int noScores;   // ���� ������ �����ϴ� �ʵ�
	
	// �Ű����� ���� ��ü ������: ó������ �ִ� ���� 10�� ������ �迭 ��ü �����Ͽ� scores�� ����
	Scores() {
		scores = new int[10];
		noScores = 0;
	}
	
	
	// noScores �ʵ忡 ����� ������ŭ�� ������ scores �迭 �ʵ忡 �Է��ϴ� �޼ҵ�
	void getScores(int n) {
		if (n > scores.length) {
			scores = new int[n]; // n���� ������ ������ �迭 ��ü�� �����Ͽ� scores �迭������ ����
		}
		
		noScores = n;

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
	}
	
	// scores �迭 �ʵ忡 ����� noScores ������ ������ ����ϴ� �޼ҵ�
	void outputScores(String title) {

		System.out.print(title);  
		
		int n = noScores;
		
		for (int i = 0; i < n; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "��°���� " + 
						((n - i) >= 10 ? 10 : (n - i))  + "���� ����: " );

			System.out.print(scores[i] + "  ");
		}
	}	

	// scores �迭 �ʵ忡 ����Ǿ��� ��������  ���� ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	int getSum() {
		int sum = 0;        // ���� ���ϱ� ���� sum ������ �ݵ�� 0���� �ʱ�ȭ�ؾ� ��

		for (int i = 0; i < noScores; i++)
			sum += scores[i]; // �����迭  �ʵ� scores[]��  ���ҵ��� ���� ����

		return sum;
	}
	
	// scores �迭 �ʵ忡 ����Ǿ��� ��������  ����� ���� ��ȯ�ϴ� �޼ҵ�
	double getAverage() {
		int sum = getSum();
		
		return sum / (double) noScores; // �Ǽ� ��� ���Ͽ� ��ȯ
	}
	
	// scores �迭 �ʵ忡 ����Ǿ��� ������ �� ������ �־��� score �̻��� ���� ������ ���Ͽ� ��ȯ�ϴ� �޼ҵ�
	int getCountGE(double score){	
		int cnt = 0;

		for (int i = 0; i < noScores; i++) 
			if (scores[i] >= score)
				cnt++;       // ���Ұ� score �̻��̸� cnt 1 ������Ŵ
		
		return cnt;
	}
	
	
}
class Ex6_ScoresAverage_UsingClass {
	
	public static void main(String[] args) {   

		Scores scores = new Scores();
		
		System.out.println("\n  ** ���� ��Ȳ�� ���� �л��� �Է� **\n");  
		int  noStudents = SkScanner.getInt("  o �л��� �Է� > ");  // �л� ���� �Է��Ͽ� noStudents ������ ����
		
		scores.getScores(noStudents);  // noStudents ���� ������ �Է��Ͽ� ������ �迭 ��ü�� scores �迭������ ���� 

		int sumScores = scores.getSum();        // �������� ���� ���Ͽ� sumScores ������ ����
		
		double avgScores = scores.getAverage(); // �Ǽ� ���� ��� ���Ͽ� avgScores ������ ����
		
		int cntGeAverage = scores.getCountGE(avgScores);  // ��� �̻� �ο����� ���Ͽ� cnt ������ ����	

		scores.outputScores("\n  **  �Էµ� " + noStudents + "���� ���� **");
		
		outputScoresInfo(noStudents, sumScores, avgScores, cntGeAverage);

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
 *   1) �� ���α׷��� ���� ������ �����ϰ� �̸� �����ϱ� ���� �޼ҵ带 ���� Ŭ������ �ۼ���
 *   
 *   2) �迭 �ʵ带 ��ü ���ο� �����ϹǷ� �޼ҵ��� �Ű��������� �迭�� ��Ÿ���� ������ Ȯ���϶�.        
 *      
 *   3) ���α׷��� �����Ͽ� �������� �Է��ϰ� ����� Ȯ���϶�.
 *   
 *   4) �� ���α׷��� �Է��ϴ� �������� ������ ���� ���� ������ �� �ֵ��� �� �ۼ���
 *      ���� ���α׷��̴�.
 */
