package exercise05;

/**
 * [ 5장 연습문제  11 ]:
 *   
 *   1. for 문으로 작성된 메소드는 재귀 메소드를 이용하는 프로그램으로 작성될 수 있다. 
 *      예를 들어, for 문을 이용하여 n개 정수를 입력하는 메소드는 다음과 같이 재귀 메소드로 작성할 수 있다.
 *      
 *      // for 문으로 작성된 메소드
 *      static void getInts(int[] ints, int n) {
 *         for (int i = n; i > 0; i--)
 *              ints[i-1] = SkScanner.getInt();
 *      }
 *      
 *      ==(재귀 메소드로 변환)==> 
 *      
 *      // 재귀 메소드
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

	// [1] "I like Java " n번 출력하기
	static void printLikeJava(int n) {
		for (int i = 10; i > 0; i--)
			System.out.print("I like Java ");
	}

	// [2] 정수 자리수 합 구하기
	static int getSumDigits(int n) {
		int sum = 0;
		for ( ; n != 0; ) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	// [3] 최대값 구하기
	static int getMax(int[] ints, int n) {
		int max = ints[0];
		for (int i = 1; i < n; i++) 
			if (ints[i] > max)
				max = ints[i];

		return max;
	}


	// [4] 2의 제곱 구하기
	static int getPowerOf2(int n) {
		int power = 1;
		for (int i = 0; i < n; i++) 
			power= power * 2;

		return power;
	}
}
