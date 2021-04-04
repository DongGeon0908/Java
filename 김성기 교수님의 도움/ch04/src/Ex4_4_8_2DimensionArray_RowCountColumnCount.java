/**
 * [ 2DimensionArray_RowCountColumnCount ]: 2���� �迭�� �� ������ Ư�� ���� �� ���� ���ϱ�
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) 2���� �迭������ ����, 2���� �迭 ���� ���� �� ���� ����
 *  
 *   o 2���� �迭������ ���� �� �迭 ��ü ����
 *     - ����Ÿ��[][] �迭������ = new ����Ÿ��[�ళ��][������];
 *     
 *     - int[][] scores = new int[4][6];     // 4�� �л��� 6 ���� ���� �����ϴ� 2���� �迭
 *     - String][] names = new String[3][3]  // 3�� �Ҽ��� ���ΰ� �̸� 3���� �����ϴ� 2���� �迭
 *     
 *   o 2���� �迭�� �� ���� ���ϱ�: length �ʵ� ���
 *     - 2�����迭.length: ������ �迭������ �� ���� ����
 *     - ��) scores.length ==> 4
 *            names.length ==> 3
 *     
 *   o 2���� �迭�� Ư�� ���� �� ���� ���ϱ�: length �ʵ� ���          
 *     - 2�����迭[row].length: ������ �迭���� Ư�� ���� row�� �� ���� ����
 *     - ��) scores[0].length ==> �ε��� 0�� ���� �� ������ 6
 *           names[2].length ==> �ε��� 2�� ���� �� ������ 3
 */ 

class Ex4_4_8_2DimensionArray_RowCountColumnCount {
	public static void main(String[] args) {   
		int[] prices = new int[6];         // prices�� ���� ������ 6���� 1���� �迭
		String[] novels = new String[3];   // novels�� ���� ������ 3���� 1���� �迭

		int no = novels.length;            // 1���� �迭 novels�� ���� ���� ���Ͽ� no�� ����

		System.out.println("  * prices ���� ���� = " + prices.length);
		System.out.println("  * novels�� ���� ���� = " + no);

		
		int[][] scores = new int[4][6];      // scores�� �� ���� 4, �� ���� 6�� ������ �迭
		String[][] names = new String[3][3]; // names�� �� ���� 3, �� ���� 3�� ������ �迭
		no = names.length;                   // names ������ �迭�� �� ���� ���� ����

		System.out.println("\n  * scores �� ���� = " + scores.length
		                     + ", names�� �� ���� = " + no);

		
		int noCol0 = scores[0].length;  // ù��° ���� �� ���� ���� ����
		int noCol1 = scores[1].length;  // �ι�° ���� �� ���� ���� ����

		System.out.println("\n  * scores ù ��° ���� �� ���� = " + noCol0 
		                 + "\n  * scores �� ��° ���� �� ���� = " + noCol1
		                 + "\n  * names�� ù ��° ���� �� ���� = " + names[0].length);
		
		System.out.println();
		for (int i=0; i < scores.length; i++)
			System.out.println("  * scores " + (i + 1) + "��° ���� �� ���� = " + scores[i].length);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *     
 *   1) �� ���α׷��� 1���� �迭�� 2���� �迭�� �����ϰ� ��� ���� ������ ���ϴ� ���� �����ش�.
 *      
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   o �ѱ�, �߱�, �Ϻ� 3������ 2010����� 2019����� 10�Ⱓ ���� ������� ������ �迭 growthRate�� �����Ϸ� �Ѵ�.
 *     - �ѱ��� 2010�� ���� ������� growthRate[0][0]��, 2011�� ������� growthRate[0][1]�� ����
 *     - �߱��� 2010�� ���� ������� growthRate[1][0]��, 2011�� ������� growthRate[1][1]�� ����     
 *   
 *     (1) �̸� ���� 2���� �迭���� growthRate�� �����ϰ� �迭��ü�� �����Ͽ� �迭������ �����϶�.
 *      
 *     (2) �迭�� �� ������ ��� ���� �� ������ ����ϴ� �ڵ带 �ۼ��϶�.     
 */
