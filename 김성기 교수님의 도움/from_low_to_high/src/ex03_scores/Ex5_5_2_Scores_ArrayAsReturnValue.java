package ex03_scores;
/* 
 * [ Scores_ArrayAsReturnValue ]: �迭�� �޼ҵ��� ��ȯ������ ����ϱ�
 * 
 *  o �迭�� �޼ҵ��� ��ȯ������ ���
 *    - ȣ��� �޼ҵ忡�� �迭 ��ü �����Ͽ� �� �迭�� ��ȯ������ ��ȯ�� �� ����
 *    - �迭�� ��ȯ������ ��ȯ�Ǹ� ȣ���� �޼ҵ忡���� ��ȯ�� �迭�� ��� ���Ҹ� �����ϰų� �����Ҽ� ����
 */

class Ex5_5_2_Scores_ArrayAsReturnValue {
	public static void main(String[] args) { 
		// inputInts()���� �Էµ� ���Ұ� ����� �迭�� ��ȯ�޾� ���
		int[] scores = inputInts(10, "\n  o 10�� ���� �Է��Ͻÿ� > ");  
		outputInts(scores, "\n  ** scores �迭�� ����� ������ **\n  * ");  
	}

	// prompt �޽��� ��� �� n���� ������ �Է��Ͽ� ������ �迭�� �����ϰ� �迭�� ��ȯ
	static int[] inputInts(int n, String prompt) {
		int[] ints = new int[n];  // n�� ���� ������ �迭��ü �����Ͽ� ints �迭������ ����

		System.out.print(prompt);      // prompt ���

		for (int i = 0; i < n; i++) 
			ints[i] = SkScanner.getInt(); // ���� �Է��Ͽ� ints �迭 ���ҷ� ����

		outputInts(ints, "\n  ** ints �迭�� �ԷµǾ� ����� ���ҵ� **\n  * "); // �迭�� �Ű������� �����Ͽ� ��� ���� ���

		return ints;  // ints[] �迭�� ��ȯ
	}

	// title�� ���� �迭���� ints�� ����� ��� ���Ҹ� �� ���ο� ����ϴ� �޼ҵ�
	//   ����� ������ ������ �־����� ���� ��� �迭�� length �ʵ带 �̿��Ͽ� ���� ������ ����
	static void outputInts(int[] ints, String title) {
		System.out.print(title);               // title ���

		for (int i = 0; i < ints.length; i++) 
			System.out.print(ints[i]  + "  ");   // ints �迭�� �� ���Ҹ� ���

		System.out.println();     
	}
}