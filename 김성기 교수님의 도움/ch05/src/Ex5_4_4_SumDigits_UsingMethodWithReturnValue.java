/**
 * [ SumDigits_UsingMethodWithReturnValue ]: 
 *       반환값 갖는 메소드로 작성한 자리수 합 관련 프로그램
 * 
 *   o 매개변수 갖는 통합 메소드
 *     - 매개변수로 필요한 정보를 전달하여 그 정보에 따른 다양한 작업을 수행할 수 있게 하는 메소드
 *     - 메소드 호출시 반드시 실매변수 값이 주어져야 함
 *     - 실매개변수 값이 형식매개변수에 저장된 후 실행되므로 호출될 때마다 다른 처리 결과를 낳음
 *      
 *   o 반환값 없는 메소드로만 작성되는 프로그램의 문제점
 *     - 동일한 코드가 여러 메소드에서 중복 작성
 *     - 호출된 메소드는 작업 완료해야 하므로 대개 처리 결과 출력 후 종료
 *     - 호출한 메소드에서는 호출된 메소드의 처리 결과 활용 불가하여 메소드 활용성 부족
 *     
 *   o 반환값 갖는 메소드의 장점
 *     - 특정 기능을 수행하는 코드가 한번만 작성됨
 *     - 메소드를 여러 곳에서 호출하여 다양하게 활용할 수 있음
 *
 *   o 작성된 반환값 갖는 메소드
 *     - static int getSumDigits(int n): n의 자리수 합을 구하여 반환하는, 반환값 있는 메소드
 *       
 *   o 프로그램의 작업
 *     - 1234의 자리수 합 구하여 출력
 *     - 100부터 200까지 정수 중 자리수 합이 10의 배수인 정수와 합 구하여 출력
 */

class Ex5_4_4_SumDigits_UsingMethodWithReturnValue  {	
	public static void main(String[] args) {
		printSumDigits(1234);

		// 100부터 200까지 정수 중 자리수 합이 10의 배수인 정수와 합 구하여 출력하는 메소드 호출
		printIfSumDigitsMultipleOf_FromTo(100, 200, 10);     
	} 

	// 주어진 n의 자리수 합을 출력하는 메소드
	static void printSumDigits(int n) {
		int sumDigits = getSumDigits(n);  // n의 자리수 합을 getSumDigits(n) 메소드로 구하여 저장
		
		System.out.println("\n  * " + n +"의 자리수 합 = " + sumDigits);
	}

	// from부터 to까지 정수에서 자리수 합이 m의 배수인 정수와 자리수 합 출력하는 메소드
	static void printIfSumDigitsMultipleOf_FromTo(int from, int to, int m) {
		System.out.println("\n  ** " + from + "부터 " + to + "까지 자리수 합이 " + m + "의 배수인 정수  **\n"); 

		for (int i = from; i <= to; i++) {    // i가 from에서 to까지 정수에 대해
			int sumDigits = getSumDigits(i);  //   i의 자리수 합 구하여 저장

			if (sumDigits % m == 0)           //   자리수 합이 m의 배수이면 i와 자리수 합 출력
				System.out.println("  * " + i +"의 자리수 합 " + sumDigits + ": " + m + "의 배수");
		}

	}
	
	// 주어진 정수의 자리수 합을 구하여 반환하는 메소드
	static int getSumDigits(int n) {
		int sumDigits = 0; 
		
		while (n != 0) {
			sumDigits = sumDigits + n % 10;  // 일자리수를 합에 더함
			n = n / 10;                      // 자리수 하나 줄임
		}
		
		return sumDigits;   // 자리수 합 반환
	}
}  

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 반환값 갖는 메소드를 작성한 좋은 프로그램이다.
 *   
 *   2) 한번 작성된 자리수 합 반환하는 메소드가 여러 메소드에서 호출되어 활용된다.
 *   
 *   3) 이 프로그램은 반환값 없는 메소드로만 작성할 때 발생하는 문제점을 확실히 해결한다.
 *     
 *     
 * [ 실습과제 ]
 * 
 *   1) 1부터 10000 사이의 정수 중에서 자리수 합이 10의 배수인 정수의 비율을 구하여 출력하기 
 *      위해 필요한 메소드를 작성하고 main ()에서 이를 호출하라.
 *      
 *      이를 위해 printRatioOfSumDigitsMultipleOf(int from, int to, int m)을 작성하고, 
 *      이 메소드에서 getSumDigits(int n) 메소드를 활용한다.
 *      
 *   2) 이 프로그램이 반환값 갖는  메소드를 이용하지 않은 이전 프로그램보다 훨씬 좋다고 느껴지는가? 
 */
