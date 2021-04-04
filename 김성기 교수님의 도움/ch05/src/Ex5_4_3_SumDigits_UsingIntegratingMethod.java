/**
 * [ SumDigits_UsingIntegratingMethod ]: 
 *       매개변수 갖는 통합메소드로 작성한 자리수 합 관련 프로그램
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
 *   o 프로그램의 작업
 *    - 1234의 자리수 합 구하여 출력
 *    - 100부터 200까지 정수 중 자리수 합이 10의 배수인 정수와 합 구하여 출력
 */

class Ex5_4_3_SumDigits_UsingIntegratingMethod  {	
	public static void main(String[] args) {
		printSumDigits(1234);   // 1234의 자리수 합 구하여 출력하는 메소드  호출
		
		// 100부터 200까지 정수 중 자리수 합이 10의 배수인 정수와 합 구하여 출력하는 메소드  호출
		printIfSumDigitsMultipleOf_FromTo(100, 200, 10);  
	}
	
	// 주어진 정수의 자리수 합을 구하여 출력하는 메소드
	static void printSumDigits(int n) {
		int n0 = n;
		
		int sumDigits = 0;
		while (n !=  0) {                    // 합 구할 정수가 0이 아닌 동안 반복
			sumDigits = sumDigits + n % 10;  //   마지막 자리수를 구해 sumDigits에 더함
			n = n / 10;                      //   n의 일자리 디지트 제거하여 전체  자리수 하나 줄임
		}
		
		System.out.println("\n  * " + n0 +"의 자리수 합 = " + sumDigits);
	}

	// from부터 to까지의 정수 중 자리수 합이 m의 배수인  정수와 자리수 합  출력하는 메소드
	static void printIfSumDigitsMultipleOf_FromTo(int from, int to, int m) {
		System.out.println("\n  ** " + from + "부터 " + to + "까지 자리수 합이 " + m + "의 배수인 정수  **\n"); 

		for (int i = from; i <= to; i++) {
			int n = i;
			
			int sumDigits = 0;
			while (n !=  0) {                    // 합 구할 정수가 0이 아닌 동안 반복
				sumDigits = sumDigits + n % 10;  //   마지막 자리수 구해 sumDigits에 더함
				n = n / 10;                      //   n의 일자리 디지트 제거하여 전체  자리수 하나 줄임
			}

			if (sumDigits % m == 0)              // 자리수 합이 m의 배수이면  정수 n과 자리수 합 출력
				System.out.println("  * " + i +"의 자리수 합 " + sumDigits + ": " + m + "의 배수");
		}
	}
}  

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 매개변수를 갖는 통합 메소드를 작성한 그리 나쁘지 않은 프로그램이다.
 *   
 *   2) 그러나, 반환값 타입이 void인 통합 메소드만으로 좋은 프로그램을 작성할 수 없다.
 *   
 *   3) 이 프로그램은 반환값 없는 메소드로만 작성하였으므로 다음의 문제점이 있음을 확인하라.
 *      (1) 동일한 코드가 여러 메소드에서 중복 작성
 *      (2) 호출된 메소드는 작업 완료해야 하므로 대개 처리 결과 출력 후 종료
 *      (3) 호출한 메소드에서는 호출된 메소드의 처리 결과 활용 불가하여 메소드 활용성 부족
 *     
 *     
 * [ 실습과제 ]
 * 
 *   1) 1부터 100000까지의 정수 중 자리수 합이 3의 배수인 정수의 개수를 구하여 출력하려 한다.
 *   
 *      이를 위해 from부터 to까지의 정수 중 자리수 합이 m의 배수인  정수의 개수를 출력하는 메소드인
 *      static void printCountSumDigitsMultipleOf_FromTo(int from, int to, int m)
 *      을 작성하고 이를 main()에서 호출하라.
 *      (참고: 자리수 합이 3의 배수인 정수는 3의 배수이므로 자리수 합이 3의 배수인 정수 개수는
 *            3의 배수인 정수 개수와 동일함.  개수 = 100000 / 3 = 33333개임)
 *            
 *   2) 이 메소드를 작성하면서 반환값 없는 메소드로만 작성할 때의 문제점을 어느 정도 느꼈는가?
 */