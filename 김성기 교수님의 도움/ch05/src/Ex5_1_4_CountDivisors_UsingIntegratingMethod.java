/**
 * [ CountDivisors_UsingIntegratingMethod ]
 *       100과 10000의 약수 개수, 1237과 1234567의 소수 여부 출력(매개변수 갖는 통합 메소드 사용)   
 *            
 *   o 프로그래밍 스타일 
 *     - 주어진 매개변수에 대해 약수 개수와 소수 여부 출력하는, 매개변수 갖는 통합 메소드 작성
 *     - main() 메소드에서  통합 메소드 호출    
 *       
 *  o 약수(divisor)와 소수(prime number)
 *    - 약수: 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *    - 6의 약수: 1, 2, 3, 6
 *    - 12의 약수: 1, 2, 3, 4, 6, 12   
 *    - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...       
 *    - 소수: 약수의 개수가 2개인 양의 정수      
 *    
 *  o 대체 메소드를 매개변수 갖는 메소드로 통합
 *    - 유사한 대체 메소드들을 매개변수 이용하여 하나로 통합
 *    - 메소드 이름에 나타난 데이터 요소를 매개변수로 작성 
 *         printStar4InLine()  ==>  printStarInLine(int cnt)
 *         
 *    - 메소드 호출할 때 실제 매개변수 전달
 *         printStar4InLine();  ==>  printStarInLine(4);
 *         
 *  o 작성된 통합 메소드
 *    - printCountDivisorsOf(int n): n의 약수 개수 출력하는 메소드
 *    - printWhetherPrimeNo(int n): n의 소수 여부 출력하는 메소드     
 */

class Ex5_1_4_CountDivisors_UsingIntegratingMethod {
	public static void main(String[] args) {
		printCountDivisorsOf(100);      // 100을 매개변수로  약수 개수 출력하는 메소드 호출    
		printCountDivisorsOf(10000);    // 10000을 매개변수로 약수 개수 출력하는 메소드 호출    
		
		printWhetherPrimeNo(1237);      // 1237을 매개변수로  소수 여부 출력하는 메소드 호출
		printWhetherPrimeNo(1234567);   // 1234567을 매개변수로  소수 여부 출력하는 메소드 호출
	}
	
	// 매개변수로 주어지는 n의 약수 개수 출력하는 메소드
	static void printCountDivisorsOf(int n) {
		int cntDivisors = 0;         	// n의 약수 개수를 0으로 초기화

		for (int i = 1; i <= n; i++) 	// for 문: i가 1부터 n까지 반복
			if (n % i == 0) 	 		//      n을 i로 나누어 나머지가 0이면 
				cntDivisors++;   	  	//      i는 n의 약수이므로 약수 개수 1 증가	

		System.out.println("\n  * " + n + "의 약수 개수: " + cntDivisors); 
	}

	// 매개변수로 주어지는 n의 소수 여부 출력하는 메소드
	static void printWhetherPrimeNo(int n ) { 
		int cntDivisors = 0;          	// n의 약수 개수를 0으로 초기화

		for (int i = 1; i <= n; i++)   	// for 문: i가 1부터 n까지 반복
			if (n % i == 0) 	  		//      n을 i로 나누어 나머지가 0이면 
				cntDivisors++;    	  	//      i는 n의 약수이므로 약수 개수 1 증가	

		if (cntDivisors == 2) 
			System.out.println("\n  * " + n  + ": 소수임" ); 
		else 
			System.out.println("  \n  * " + n + ": 소수 아님" );     
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 통합 메소드를 작성하고 메소드를 호출한다.
 *   
 *   2) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 *   
 *   1) 오늘 날짜 8자리 정수(YYYYMMDD)의 약수 개수를 구하여 출력하라.
 *   
 *   2) 10000부터 11000까지의 정수에 대해 약수 개수 출력하도록 프로그램을 변경하라.
 *   
 *   3) 매개변수를 갖는 통합 메소드의 강력함이 느껴지는가?
 */
