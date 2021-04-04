package ex03_scores;

/*
 * [ Scores_InOut_UsingArrayFor ]: �迭�� For ������ �̿��Ͽ� 20���� ������ �Է��� �� ���� �� ���
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �迭������ ����, For ������ �̿��� ������ �Է�, ����, ���� ���
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
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o for ������ �迭�� ����ϸ� �����ϰ� ����Ʈ�� �ڵ尡 �ۼ���   
 *             
 *   o SkScanner.getInt(): ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�                                  
 */ 

class Ex2_4_3_Scores_InOut_UsingArrayFor {
	
	public static void main(String[] args) {   
		int noStudents = 20;   // �л� ���� �����ϴ� ����, �л� ����ŭ ������ �迭�� �ԷµǾ� ����� 
		
		int[] scores = new int[noStudents]; // noStudents ���� ������ ������ �迭 ��ü�� scores �迭������ ���� 

		// noStudents ���� ������ �Է��Ͽ� �迭������ �ε��� 0���� noStudents - 1������ ���ҿ� ����
		System.out.println("\n  **  " + noStudents + "���� ���� �Է� **\n");  	// �Է��� ���� Ÿ��Ʋ ���      

		// noStudents �� ������ 10���� �� ���ο� �Է��Ͽ� �迭���� ���ҿ� ����
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("  o " +(i + 1) +"��°���� " + (i + 1) + "��°���� " + 
			                     ((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "���� ���� �Է��Ͻÿ� > "); // ������Ʈ �޽��� ���			

			scores[i] = SkScanner.getInt();   // ���� �� �Է��Ͽ� scores[i] ���ҿ� ����      
		}

		// �Էµ� noStudents ���� ������ ��� ��� 
		System.out.println("\n  **  �Էµ� " + noStudents + "���� ���� **");  // ����� ���� Ÿ��Ʋ ���
		for (int i = 0; i < noStudents; i++) {
			if (i % 10 == 0)
				System.out.print("\n  * " + (i + 1) + "��°���� " + (i + 1) + "��°���� " +
			                    ((noStudents - i) >= 10 ? 10 : (noStudents - i))  + "���� ����: " );
			
			System.out.print(scores[i] + "  ");
		}
		
		// �Էµ� 10���� ���� ���� ����
		int sumScores = scores[0] + scores[1] + scores[2] + scores[3] + scores[4] 
		            + scores[5] + scores[6] + scores[7] + scores[8] + scores[9] ; 

		// ���� ���� �л����� ������ ���� ����� ����
		double avgScores = sumScores / (double) noStudents;  // �Ǽ� ����� ���ϱ� ���� noStudents��double�� ĳ��Ʈ��Ŵ

		System.out.println("\n  ** �л� ���� ��Ȳ **");
		System.out.println("  * �� �л��� = " + noStudents);
		System.out.println("  * " + noStudents + "�� �л� ���� �� = " + sumScores);
		System.out.println("  * " + noStudents + "�� �л� ���� ��� = " + avgScores);
		

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ���� ����� ���� for ������ ����Ͽ� �迭������ ������ 
 *      �����ֱ� ���� �ۼ��� ���̴�. �迭������ �ݺ����� ���յ� ���� ��Ÿ���� 
 *      ���α׷��� �ۼ��ϱ� ���� ����� �ʿ��ϴ�.      
 *      
 *   2) ���α׷��� �����Ͽ� �������� �Է��ϰ� ����� Ȯ���϶�.
 *   
 *   3) main() �Լ��� ���� �ִ� << #define NOSTUDENTS 20 >>������ 20�� 10���� �����Ͽ� �������� �� �����غ���.
 *      ���� 20�� 30���� �����Ͽ� �������� �� �����غ���. 
 *    
 *      �� ���α׷��� �Է��ϴ� �������� ������ ���� ���� ������ �� �ֵ��� �� �ۼ���
 *      ���� ���α׷��̴�.
 */
