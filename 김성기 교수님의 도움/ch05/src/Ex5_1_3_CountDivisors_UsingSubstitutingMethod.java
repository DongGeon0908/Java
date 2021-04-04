/**
 * [ CountDivisors_UsingSubstitutingMethod ]: 
 *       100의 약수 개수와 1237의 소수 여부 출력(대체 메소드 사용)   
 *            
 *   o 프로그래밍 스타일 
 *     - 100의 약수 개수와 1237의 소수 여부 출력하는 대체 메소드 작성
 *     - main() 메소드에서 대체 메소드 호출    
 *       
 *   o 약수(divisor)와 소수(prime number)
 *     - 약수: 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *     - 6의 약수: 1, 2, 3, 6
 *     - 12의 약수: 1, 2, 3, 4, 6, 12   
 *     - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...       
 *     - 소수: 약수의 개수가 2개인 양의 정수      
 *    
 *   o 대체 메소드
 *     - 수행할 문장들을 기능 나타내는 메소드 이름으로 대체하여 작성한 메소드
 *     - 작성한 후 메소드 이름으로 호출하면 대체한 문장들이 수행
 *     - 처리과정의 기능적 추상화: 수행할 문장들의 기능 파악하여 기능 나타내는
 *       메소드 이름으로 수행할 문장들을 대체시키는 추상화로 매우 중요!!!    
 *   
 *   o 작성한 대체 메소드
 *     - printCountDivisorsOf100(): 100의 약수 개수 출력하는 대체 메소드
 *     - printWhether1237PrimeNo(): 1237의 소수 여부 출력하는 대체  메소드
 *      
 */

class Ex5_1_3_CountDivisors_UsingSubstitutingMethod {
	public static void main(String[] args) {
		printCountDivisorsOf100();      // 100의 약수 출력하는 메소드 호출    
		printWhether1237PrimeNo();      // 1237의 소수 여부 출력하는 메소드 호출
	}
	
	// 100까지의 약수 개수 출력하는 메소드
	static void printCountDivisorsOf100() {
		int n = 100;		  			// 약수 개수 구할 정수: 100
		
		int cntDivisors = 0;        	// n의 약수 개수를 0으로 초기화

		for (int i = 1; i <= n; i++) 	// for 문: i가 1부터 n까지 반복
			if (n % i == 0) 	 		//   n을 i로 나누어 나머지가 0이면 
				cntDivisors++;   	  	//   i는 n의 약수이므로 약수 개수 1 증가	

		System.out.println("\n  * " + n + "의 약수 개수: " + cntDivisors); 
	}

	// 1237의 소수 여부 출력하는 메소드
	static void printWhether1237PrimeNo( ) { 
		int n = 1237; 		  			// 소수 여부 판단할 정수: 1237
		
		int cntDivisors = 0;          	// n의 약수 개수를 0으로 초기화

		for (int i = 1; i <= n; i++)   	// for 문: i가 1부터 n까지 반복
			if (n % i == 0) 	  		//   n을 i로 나누어 나머지가 0이면 
				cntDivisors++;    	  	//   i는 n의 약수이므로 약수 개수 1 증가	

		if (cntDivisors == 2) 
			System.out.println("\n  * " + n  + ": 소수임" ); 
		else 
			System.out.println("  \n  * " + n + ": 소수 아님" );     
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 대체 메소드를 작성하고 메소드를 호출한다.
 *      - printCountDivisorsOf100(): 100의 약수 개수 출력하는 메소드
 *      - printWhether1237PrimeNo(): 1237의 소수 여부 출력하는 메소드
 *      
 *   2) 메소드를 사용하지 않은 프로그램과 비교하여 보라.
 *   
 *   =============================================================================================
     class Ex5_1_1_CountDivisors_NotUsingMethod {
	    public static void main(String[] args)  {
		
	      int n = 100;					// 약수 개수 구할 정수: 100
		  int cntDivisors = 0;         	// n의 약수 개수를 0으로 초기화

		  for (int i = 1; i <= n; i++) 	// for 문: i가 1부터 n까지 반복
			  if (n % i == 0) 			//    n을 i로 나누어 나머지가 0이면 
			 	  cntDivisors++; 		//    i는 n1의 약수이므로 약수 개수 1 증가	

		  System.out.println("\n  * " + n + "의 약수 개수: " + cntDivisors); 


		  n = 1237; 					// 소수 여부 판단할 정수: 1237
		  cntDivisors = 0;             	// n의 약수 개수를 0으로 초기화

		  for (int i = 1; i <= n; i++)  // for 문: i가 1부터 n까지 반복
			  if (n % i == 0) 	    	//    n을 i로 나누어 나머지가 0이면 
				  cntDivisors++;        //    i는 n의 약수이므로 약수 개수 1 증가	

		  if (cntDivisors == 2) 
			  System.out.println("\n  * " + n  + ": 소수임" ); 
		  else 
			  System.out.println("  \n  * " + n + ": 소수 아님" ); 

	    }
     }     
 *   =============================================================================================
 *    
 *   3) 프로그램을 실행하여 결과를 확인하라.
 *     
 *   4) 프로그램이 수행하는 작업내용을 기능이라 하는데, 프로그램의 기능이 바로 파악되는가?
 *  
 *      
 * [ 실습 과제 ]
 *  
 *   1) 10000의 약수 개수 출력하기 위한 대체 메소드를 작성하고 이를 main()에서 호출하는 코드를 추가로 작성하라.
 *    
 *   2) 1234567의 소수 여부  출력하기 위한 대체 메소드를 작성하고 이를 main()에서 호출하는 코드를 추가로 작성하라.
 *    
 *   3) 이 프로그램이 메소드 이용하지 않은 이전 프로그램보다 기능을 파악하는 것이 훨씬 쉽다고
 *      느껴지는가?
 *       
 *   4) 대체 메소드를 몇 개를 작성해야 원하는 모든 작업을 수행할 수 있는가를 생각해보라.
 */

