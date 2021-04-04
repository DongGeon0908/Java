/**
 *  [ ScoresToGrades_UsingMethodWithReturnValue ]: 
 *         ��ȯ�� ���� �޼ҵ带 �̿��Ͽ� ���� ����(score)�� �Է��Ͽ� 
 *         �����Ǵ� ���� ���(grade)�� ����(grade point) ����ϰ� ��� ���� ����Ͽ� ���
 *
 *    o ���α׷��� ��Ÿ�� 
 *       - ��ȯ�� ���� �޼ҵ带 �̿�
 *       - ������ �۾��� �����ϴ� ���α׷��� ��������� �� �ۼ��Ǿ� ���� ��Ÿ���� ���α׷� 
 *             
 *    o ��ȯ���� ��ȯ�ϴ� �޼ҵ�
 *      - int getIntBtw(int min, int max, String promptMsg): 
 *          ������Ʈ �޽��� promptMsg�� ����� ��  min�� max ������ ������ �Է��Ͽ� ��ȯ 
 *      - String getGrade(int score): ���� score�� ���� ������� ��ȯ�Ͽ� ��ȯ
 *      - double getGradePoint(String grade): ������� grade�� ��������  ��ȯ�Ͽ� ��ȯ
 *       
 *    o ���� ������ ���� ���
 *        95~100: A+, 90~94: A0, 85~90: B+, 80~84: B0, 
 *        75~80 : C+, 70~74: C0, 65~70: D+, 60~65: D0, 
 *        60 �̸�: F 
 *     
 *    o ���� ��޿� ���� ����
 *        A+: 4.5, A0: 4.0, B+: 3.5, B0: 3.0, 
 *        C+: 2.5  C0: 2.0, D+: 1.5, D0: 1.0, f: 0
 *
 *    o if ���� ������ ���� �� ����Ͽ� ������ ���� ������� ��ȯ
 *    
 *    o switch ���� �̿��Ͽ� ���� ����� �������� ��ȯ
 */

class Ex5_4_7_ScoresToGrades_UsingMethodWithReturnValue {
	public static void main(String[] args)  {
		int noScores = 0;       // �Է��� ���� ���� �����ϴ� ���� 
		int score;              // ���� �Է��Ͽ� �����ϴ� ����
		String grade;           // ���� ��� �����ϴ� ����
		double gradePoint;      // ���� �����ϴ� ����
		double sumGradePoint = 0;  // ������ ���� �����ϴ� ����

		System.out.println("\n\n  **** ������ ���� ������� ��ȯ�ϰ� ��� ���� ���ϱ� **** ");

		while(true) {
			score = getIntBtw(-1, 100, "\n  o 0�� 100 ������ ���� �Է� (-1�̸� ����) > "); 
			if (score == -1)
				break;

			noScores++;                         // ���� ������ 1 ������Ŵ
			grade = getGrade(score);            // ������ ��������� ����
			gradePoint = getGradePoint(grade);  // ��������� ������ ����

			sumGradePoint = sumGradePoint + gradePoint;  // ������ ����

			System.out.println("  * �Է� ���� " + score + "�� ���� ���: " + grade + ", ����: " + gradePoint);
		}

		double avgGradePoint = sumGradePoint / noScores;  // ���� ����� ����

		System.out.print("\n\n  ** �Է��� ���� " + noScores + "�� ������ ���� �� = " + sumGradePoint + ", ��� ���� = " + avgGradePoint);
	}

	// �־��� ������Ʈ �޽��� promptMsg�� ����� ��  min��  max ������ ������ �Է��Ͽ� ��ȯ�ϴ�  �޼ҵ�
	// �Է��� ������ min��  max ������ ������ �ƴϸ� ��� �ݺ� �Է���
	static int getIntBtw(int min, int max, String promptMsg)  {
		while(true) {
			int n = SkScanner.getIntWithPrompt(promptMsg);  // ������Ʈ �޽��� promptMsg�� ���
			if (n >= min && n <= max)                       // min��  max ������ ������ �Է��ϸ�
				return n;                                   //  �̸� ��ȯ
		}
	}

	// �־��� ���� score�� ���� ������� ��ȯ�Ͽ� ��ȯ�ϴ�  �޼ҵ�
	static String getGrade(int score)  {
		if (score >= 95 && score <= 100) 	 // ������ 95 ~ 100�̸�
			return "A+";                     //   A+ ��ȯ 
		else if (score >= 90 && score <= 94) // ������ 90 ~ 94�̸�
			return "A";                      //   A ��ȯ        
		else if (score >= 85 && score <= 89) // ������ 85 ~ 89�̸�
			return "B+";                     //   B+ ��ȯ
		else if (score >= 80 && score <= 84) // ������ 80 ~ 84�̸�
			return "B0";                     //   B0  ��ȯ
		else if (score >= 75 && score <= 79) // ������ 75 ~ 79�̸�
			return "C+";                     //   B+ ��ȯ
		else if (score >= 70 && score <= 74) // ������ 70 ~ 74�̸�
			return  "C0";                    //   B+ ��ȯ
		else if (score >= 65 && score <= 69) // ������ 65 ~ 69�̸�
			return "D+";                     //   B+ ��ȯ
		else if (score >= 60 && score <= 64) // ������ 60 ~ 64�̸�
			return "D0";                     //   D0 ��ȯ  
		else                                 // ��Ÿ �����̸�
			return "F";                      //   F ��ȯ
	}

	// �־��� ������� grade�� ��������  ��ȯ�Ͽ� ��ȯ�ϴ�  �޼ҵ�
	static double getGradePoint(String grade)  {
		switch(grade) {
		case "A+": 
			return 4.5;
		case "A": 
			return  4;
		case "B+": 
			return 3.5;
		case "B": 
			return 3;
		case "C+": 
			return 2.5;
		case "C": 
			return  2;
		case "D+": 
			return 1.5;	
		case "D": 
			return 1;
		case "F": 
			return  0;

		default:
			return 0;
		}
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� 5-4-6 ���α׷��� ��ȯ�� ���� �޼ҵ带 �̿��Ͽ� �籸���� ���α׷��̴�.
 *      - main() �޼ҵ尡  �޼ҵ� ȣ��� �ۼ��Ǿ��� ������� ���α׷����� �� �ۼ���
 *      - ���α׷��� ��Ÿ���� ���� ���� ���α׷��� 
 *     
 *   2) ���α׷��� �����ϱ� �� ���α׷� �б� �����Ͽ� ����� ������ �� ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 */
