package exercise05;

/**
 * [ 5�� ��������  11 ]:
 *   
 *   1. for ������ �ۼ��� �޼ҵ�� ��� �޼ҵ带 �̿��ϴ� ���α׷����� �ۼ��� �� �ִ�. 
 *      ���� ���, for ���� �̿��Ͽ� n�� ������ �Է��ϴ� �޼ҵ�� ������ ���� ��� �޼ҵ�� �ۼ��� �� �ִ�.
 *      
 *      // for ������ �ۼ��� �޼ҵ�
 *      static void getInts(int[] ints, int n) {
 *         for (int i = n; i > 0; i--)
 *              ints[i-1] = SkScanner.getInt();
 *      }
 *      
 *      ==(��� �޼ҵ�� ��ȯ)==> 
 *      
 *      // ��� �޼ҵ�
 *      static void getInts(int[] ints, int n) {
 *         if (n > 0) {
 *            ints[n-1] = SkScanner.getInt();
 *            getInts(ints, n-1);
 *         }
 *      }
 */

class Exercise5_11 {
	public static void main(String[] args) {
		printLikeJava(5);

		int sum = getSumDigits(1234);
		System.out.println("\n  * sum = " + sum);
		
		int[] ints = { 20, 30, 70, 80, 40, 50, 60 };
		int max = getMax(ints, ints.length);
		System.out.println("\n  * max = " + max);
		
		int power = getPowerOf2(10) ;
		System.out.println("\n  * max = " + power);

	}

	// [1] "I like Java " n�� ����ϱ�
	static void printLikeJava(int n) {
		for (int i = 10; i > 0; i--)
			System.out.print("I like Java ");
	}

	// [2] ���� �ڸ��� �� ���ϱ�
	static int getSumDigits(int n) {
		int sum = 0;
		for ( ; n != 0; ) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	// [3] �ִ밪 ���ϱ�
	static int getMax(int[] ints, int n) {
		int max = ints[0];
		for (int i = 1; i < n; i++) 
			if (ints[i] > max)
				max = ints[i];

		return max;
	}


	// [4] 2�� ���� ���ϱ�
	static int getPowerOf2(int n) {
		int power = 1;
		for (int i = 0; i < n; i++) 
			power= power * 2;

		return power;
	}
}
