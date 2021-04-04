 /**
 * [ ScoresAverage_NotUsingArray ]: 10���� ������ �ܼ����� �̿��Ͽ� �Է��� �� ��, ��� ���Ͽ� ��� 
 * 
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) 10���� �ܼ����� ����, ���� �Է��Ͽ� ���ҿ� ����
 *     3) ������ ��, ��� ���ϱ�
 *  
 *   o 10���� ���� �����ϴ� 10���� �ܼ����� �����ϰ� ���� �Է��Ͽ� �� ���ҿ� ����
 *     - 10���� ���� �����ϱ� ���� �ܼ����� 10�� ����
 *     - ���� 10���� ���� �Է�
 *     - ���� 10���� �հ� ��� ���ϱ�
 */ 

class Ex3_5_1_ScoresAverage_NotUsingArray {

	public static void main(String[] args) {   
		System.out.println("\n  **** 10���� ���� �Է� �� �հ� ��� ���ϱ� ****");  	// �Է��� ���� Ÿ��Ʋ ���      
		
		// 10���� ������ ������ �ܼ����� 10�� ����
		int score1, score2, score3, score4, score5, score6, score7, score8, score9, score10; 
		
		int noStudents = 10;  // �л��� ����
		int sumScores;        // ���� �� ����
		double avgScores;     // ���� ��� ����		   
		
		// 10���� ������ �Է��Ͽ� score1���� score10������ ������ ����
		System.out.println("\n  **  10�� ���� �Է� **");  	// �Է��� ���� Ÿ��Ʋ ���      
		System.out.print("  o 10�� ���� �Է��Ͻÿ� > ");       	// ������Ʈ �޽��� ���   
		
		score1 = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� ������ ���ʷ� ����
		score2 = SkScanner.getInt();          
		score3 = SkScanner.getInt();    
		score4 = SkScanner.getInt();      
		score5 = SkScanner.getInt();   
		score6 = SkScanner.getInt();      
		score7 = SkScanner.getInt();     
		score8 = SkScanner.getInt();     
		score9 = SkScanner.getInt();    
		score10 = SkScanner.getInt();     

		// �Էµ� 10�� ������ ��� ��� 
		System.out.println("\n  **  �Էµ� 10�� ���� **");  // ����� ���� Ÿ��Ʋ ���
		System.out.println("  * " + score1 + "  "  + score2 + "  "  + score3 + "  "
			     + score4 + "  "  + score5 + "  "  + score6 + "  "  + score7 + "  "  
				 + score8 + "  "  + score9 + "  "  + score10 ); 

		// �Էµ� 10���� ���� �� ����
		sumScores = score1 + score2 + score3 + score4 + score5 
				    + score6 + score7 + score8 + score9 + score10; 

		// ���� ���� �л����� ������ ���� ��� ����
		avgScores = sumScores / (double) noStudents;  // �Ǽ� ��� ���ϱ� ���� noStudents�� double�� ĳ��Ʈ

		System.out.println("\n  ** �л� ���� ��Ȳ **");
		System.out.println("  * �� �л��� = " +noStudents);
		System.out.println("  * " +noStudents + " �л� ���� �� = " + sumScores);
		System.out.println("  * " +noStudents + " �л� ���� ��� = " + avgScores);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷� ���캸�� ���α׷��� ���� �ľ��϶�.
 *   
 *      10���� �л� ���� ������ �������� �����Ͽ� ���� �Է��ϰ�  �հ� ��� ���Ͽ� ����Ѵ�.
 *      
 *   2) ���α׷� �����Ͽ� ��� Ȯ���϶�.
 *
 *
 * [ �ǽ����� ]
 *
 *   1) 20���� ���� �Է��Ͽ� �ܼ������� �����ϰ� �հ� ��� ���Ͽ� ����ϴ� ���α׷��� 
 *      Pr3_1_1_ScoresAverage_NotUsingArray Ŭ������ �ۼ��϶�.   
 *        
 *      (Ex3_8_1_ScoresAverage_NotUsingArray.java�� Pr3_1_1_ScoresAverage_NotUsingArray.java�� 
 *       ������ �� ������ ��)        
 *
 *
 * [ ������� ]
 * 
 *   1) �ǽ������� �� ������ �� Ŭ������ ���α׷��� ��Ÿ�ϰ� ������ ��Ÿ���� ���α׷��� 
 *      �ۼ��Ͽ��� �Ѵ�. 
 *      
 *   2) Pr3_1_1_ScoresAverage_NotUsingArray Ŭ���� �ۼ��� ������ ó������ ���ο� Ŭ���� �����Ͽ�
 *      main() �޼ҵ尡 ������ ���¿��� ����� �ۼ��Ͽ��� �ȴ�.
 *       
 *      �׷���, Pr3_1_1_ScoresAverage_NotUsingArray Ŭ������ �̹� �ۼ��� 
 *      Ex3_1_1_ScoresAverage_NotUsingArray Ŭ������ ������ ������ �κ��� ����. 
 *      
 *      �̷��� ��쿡�� Pr3_1_1_ScoresAverage_NotUsingArray Ŭ������  
 *      ����(Copy)�ϰ� �ٿ��ֱ�(Paste)�� �ۼ��ϴ� ���� ���ϰ� �ð��� ����ȴ�.
 *      
 *      Eclipse������ ���� �� �ٿ��ֱ� ����� �����ϸ�, �ٿ��ֱ��� Ŭ������ ���ο� 
 *      Ŭ���� �̸����� �����ϸ� �ȴ�.
 *      
 *      Ŭ���� �ٿ��ֱ� ������ ������ ����.
 *     
 *      (default package)���� ������ Ŭ������ Ŭ�� -> ���콺 ������ ��ư Ŭ�� 
 *        -> Copy -> (default package) Ŭ�� -> ���콺 ������ ��ư Ŭ�� -> Paste
 *        -> �ٿ��ֱ��� Ŭ������ ���� ���ο� �̸� �Է� -> OK ��ư Ŭ��
 *        -> (default package)�� ���ο� �ٿ��ֱ��� Ŭ������ ������
 *        -> ������ Ŭ���� ���� Ŭ�� -> Ŭ������ ���� Ȯ�� �� ����                   
 */
