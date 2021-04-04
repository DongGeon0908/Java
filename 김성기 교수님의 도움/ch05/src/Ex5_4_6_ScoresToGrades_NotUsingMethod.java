/**
 *  [ ScoresToGrades_NotUsingMethod ]: 
 *        ���� ����(score) �Է��Ͽ� �����Ǵ� ���� ���(grade)�� ����(grade point) ����ϰ�
 *        ��� ���� ����Ͽ� ���
 *
 *    o ���α׷��� ��Ÿ�� 
 *      - ���� �Է¹ް� ��ø�� if �� ����Ͽ� ���� ��ް� ���� ����
 *     
 *    o ��ø�� if ��
 *      - if �� ���� �� �ٸ� if ���� �����ȴٵ��� else �κ��� ���������� �ݺ��Ǿ����� if ��
 *      - else �κ��� ���� �����ϹǷ� ��Ȯ�� �ۼ��ؾ� ��
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

class Ex5_4_6_ScoresToGrades_NotUsingMethod {
	public static void main(String[] args)  {
		int noScores = 0;          // �Է��� ���� ���� �����ϴ� ���� 
		int score;                 // ���� �Է��Ͽ� �����ϴ� ����
		String grade;              // ���� ��� �����ϴ� ����
		double gradePoint;         // ���� �����ϴ� ����
		double sumGradePoint = 0;  // ������ �� �����ϴ� ����
		
		System.out.println("\n\n   **** ������ ���� ������� ��ȯ�ϰ� ��� ���� ���ϱ� **** ");

		while(true) {
			while(true) {
				score = SkScanner.getIntWithPrompt("\n  o 0�� 100 ���� ���� �Է�(-1 �Է� �� ����) > "); 
				if (score >= -1 && score <= 100)    // -1�� 100 ���� ���� �ԷµǸ�
					break;                          //     break ������ ���� while �� ���
			}
			
			if (score == -1)
				break;  // -1�� �ԷµǸ� break �� �̿��Ͽ� �ܺ� while �� �ݺ� ���
			
			noScores++;   // ���� ���� 1 ������Ŵ

			if (score >= 95 && score <= 100)     // ������ 95 ~ 100�̸�
				grade = "A+";                    //   ������޿� A+ ����
			else if (score >= 90 && score <= 94) // ������ 90 ~ 94�̸�
				grade = "A0";                    //   ������޿� A0 ����
			else if (score >= 85 && score <= 89) // ������ 85 ~ 89�̸�
				grade = "B+";                    //   ������޿� B+ ����
			else if (score >= 80 && score <= 84) // ������ 80 ~ 84�̸�
				grade = "B0";                    //   ������޿� B0 ����
			else if (score >= 75 && score <= 79) // ������ 75 ~ 79�̸�
				grade = "C+";                    //   ������޿� C+ ����
			else if (score >= 70 && score <= 74) // ������ 70 ~ 74�̸�
				grade = "C0";                    //   ������޿� C0 ����
			else if (score >= 65 && score <= 69) // ������ 65 ~ 69�̸�
				grade = "D+";                    //   ������޿� D+ ����
			else if (score >= 60 && score <= 64) // ������ 60 ~ 64�̸�
				grade = "D0";                    //   ������޿� D0 ����		
			else                                 // ��Ÿ �����̸�
				grade = "F";                     //   ������޿� F ����           
			
			switch(grade) {
			case "A+": 
				gradePoint = 4.5;
				break;
			case "A0": 
				gradePoint = 4;
				break;
			case "B+": 
				gradePoint = 3.5;
				break;
			case "B0": 
				gradePoint = 3;
				break;
			case "C+": 
				gradePoint = 2.5;
				break;
			case "C0": 
				gradePoint = 2;
				break;
			case "D+": 
				gradePoint = 1.5;
				break;	
			case "D0": 
				gradePoint = 1;
				break;
			case "F": 
				gradePoint = 0;
				break;	
			default:
					gradePoint = 0;
					
			}
			
			sumGradePoint = sumGradePoint + gradePoint;
			
			System.out.println("  * �Է� ���� " + score + "�� ���� ���: " + grade + ", ����: " + gradePoint);
		}

		double avgGradePoint = sumGradePoint / noScores;
		
		System.out.print("\n\n  ** �Է��� ���� " + noScores + "�� ������ ���� �� = " + sumGradePoint + ", ��� ���� = " + avgGradePoint);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ������ �۾��� main() �޼ҵ忡�� ��� ó���ϹǷ� �ſ� �����ϰ� ���α׷��� �����ȴ�.
 *      - ���α׷��� ����� ���� �ľ��ϱⰡ �ټ� �����
 *   
 *   2) ���α׷��� ������ �� ���α׷��� ����� �����ϵ��� ����غ���.
 */
