package exercise05;

/**
 * [ 5�� ��������  5 ]:
 *   
 *   5. ������ main() �޼ҵ� ������� ��ü �߻�ȭ ������ ���� ��ü �޼ҵ�� �ۼ��Ϸ� �Ѵ�.
 *   
 *      1) �� ���α׷��� ����� �����϶�.
 *      2) �� ���α׷��� ��ɿ� ������ ��ü �޼ҵ� �̸��� �۸��϶�.
 *      3) ��ü �޼ҵ带 �ۼ��ϰ� main()���� ��ü �޼ҵ带 ȣ���϶�.
 *   
 * [ 5�� �������� 6 ]:
 * 
 *   6. �������� 5���� �ۼ��� ��ü �޼ҵ�鿡 ���� ���� �޼ҵ带 ���� �ۼ��Ϸ� �Ѵ�.
 *   
 *      1) �ۼ��� ��ü �޼ҵ�� ������ ����� ��ü �޼ҵ� 2���� �߰��� �ۼ��϶�. 
 *         ���� ���, [1]�� ���α׷��� ���� ��ü �޼ҵ� printLikeJava_ 10Times()
 *         �� �ۼ��Ͽ����� printLikeJava_20Times(), printLikeJava_100Times()�� �ۼ��϶�.
 *         
 *      2) ������ �޼ҵ带 �����ϱ� ���� �Ű������� �����ϰ� ���� �޼ҵ带 ���� �ۼ��϶�. 
 *         ���� ���, [1]�� ���α׷��� ���� ��ü �޼ҵ� printLikeJava_ 10Times()�� �ۼ��� �� 
 *         printLikeJava_20Times() �޼ҵ��  printLike Java_100Times()�� �ۼ��ߴٸ� 
 *         ���� �޼ҵ忡 �ش�Ǵ� printLikeJava (int cnt)�� �ۼ��϶�.
 */

class Exercise5_0506 {
	public static void main(String[] args) {

		// [1]
		for (int i = 0; i < 10; i++)
			System.out.print("I like Java ");

		
		// [2]
		int cnt = 0; 
		for (int n = 1234; n != 0; n /= 10) 
			cnt ++;
		
		System.out.println("\n  * cnt = " + cnt);

		
		// [3]
		int n1, n2, n3; 

		n1 = 23;  n2 = 33;  n3 = 43; 

		int max = (n1>n2) ? ((n1>n3) 
				? n1 : n3) : ((n2>n3) ? n2 : n3);

		System.out.println("\n  * max = " + max); 
		

		// [4]
		int[] scores = new int[10]; 
		
		System.out.print("\n  o 10�� ���� �Է��Ͻÿ� > ");

		int sum = 0;     
		for (int i = 0; i < 10; i++) {
			scores[i] = SkScanner.getInt();   
			sum = sum + scores[i];
		}

		System.out.println("\n  * sum = " + sum); 
	      
	}
}
