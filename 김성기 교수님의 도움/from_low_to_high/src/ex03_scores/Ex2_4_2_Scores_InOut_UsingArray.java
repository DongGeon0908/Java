package ex03_scores;

/*
 * [ Scores_InOut_UsingArray ]: �迭�� �̿��Ͽ� 10���� ������ �Է��� �� ���� �� ���
 * 
 *   o ���α׷��� ��Ÿ��
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �迭������ ����, �Է��Ͽ� ���ҿ� ����, ���� ���
 *  
 *   o 10���� ������ �Է��Ͽ� �迭������ ���ҿ� ����
 *    - �迭������ ����: Ÿ��[] �迭���� = new Ÿ��[������_����_����];
 *         ��: int[] scores = new int[10]; // 10���� ���Ҹ� ������ int �迭 ��ü�� �����Ͽ� scores �迭������ ����
 *         
 *     - �Է��� ���� �迭 ���ҿ� ����: �迭����[�ε���] = SkScanner.getXxx();
 *         ��: scores[0] = SkScanner.getInt();  // �迭 ������ �ε����� 0���� ������ 
 *             scores[1] = SkScanner.getInt();  
 *             scores[2] = SkScanner.getInt();
 *             
 *   o SkScanner.getInt(): ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�                 
 */ 

class Ex2_4_2_Scores_InOut_UsingArray {

	public static void main(String[] args) {     
		int[] scores = new int[10];    // 10���� ������ ������ �迭 ��ü�� scores �迭������ ������ 

		// 10���� ������ �Է��Ͽ� �迭������ �ε��� 0���� 9������ ���ҿ� ����
		System.out.println("\n  **  10���� ���� �Է� **");  // �Է��� ���� Ÿ��Ʋ ���
		System.out.print("  o 10�� ���� �Է��Ͻÿ� > ");  // ������Ʈ �޽��� ���   
		scores[0] = SkScanner.getInt();   // ���� �� �Է��Ͽ� ���ҷ� ����
		scores[1] = SkScanner.getInt();          
		scores[2] = SkScanner.getInt();    
		scores[3] = SkScanner.getInt();      
		scores[4] = SkScanner.getInt();   
		scores[5] = SkScanner.getInt();      
		scores[6] = SkScanner.getInt();     
		scores[7] = SkScanner.getInt();     
		scores[8] = SkScanner.getInt();    
		scores[9] = SkScanner.getInt();     


		//  �Էµ� 10���� ������ ��� ���
		System.out.println("\n  **  �Էµ� 10���� ���� **");  // ����� ���� Ÿ��Ʋ ���
		System.out.println("  * " + scores[0] + "  "  + scores[1] + "  "  + scores[2] + "  "
				+ scores[3] + "  "  + scores[4] + "  "  + scores[5] + "  "  + scores[6] + "  "  
				+ scores[7] + "  "  + scores[8] + "  "  + scores[9] ); 


		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
    }

}

/*
 * [ ���α׷��� ���� �� ���� ]
 *    
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *       
 *   2) ���α׷��� �����Ͽ� �������� �Է��ϰ� ����� Ȯ���϶�.
 *     
 *   
 * [ �ǽ����� ]
 *
 *   1) 20���� ������ �Է��Ͽ� �迭 ���ҿ� �����ϰ� ����ϵ��� ���α׷��� �����϶�.
 *      
 *   2) �� ���α׷��� ��Ÿ�ϴ�� 100���� ������ �Է��Ͽ� ���ҿ� �����ϰ� �̸� ����ϵ��� 
 *      ���α׷��� ������ �� �ְڴ°�? ������ �ۼ��� �� �ִ� �ִ��� ���� ������ ��ΰ�? 
 *      �ִ� �������� ������ �Է��Ͽ� �迭 ���ҿ� �����ϰ� ����ϵ��� ���α׷��� �����϶�. 
 *      �� ���α׷��� �۾��� �ܼ������� �迭�� ���� ���� ���ظ� �ϰ� �� ���̴�.
 *         
 *    
  *          
 *     
 * [ ������� ]
 * 
 *   o �ǽ������� �� ������ �־��� ���α׷��� ��Ÿ���� �̿��Ͽ� ���α׷��� �ۼ��Ͽ��� �Ѵ�. 
 *             
 */


