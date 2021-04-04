/**
 * [ CountDivisors_UsingMethodWithReturnValue ]
 *         100의 약수 개수, 1237의 소수 여부 출력(매개변수 및 반환값 갖는 메소드 사용)   
 *            
 *   o 프로그래밍 스타일 
 *     - 주어진 매개변수에 대해 약수 개수와 소수 여부 출력하는 매개변수 갖는 통합 메소드 작성
 *     - 주어진 매개변수에 대해 약수 개수를 구하여 반환하는 반환값 갖는 메소드 작성
 *     - main() 메소드에서  통합 메소드 호출    
 *       
 *   o 약수(divisor)와 소수(prime number)
 *     - 약수: 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *     - 6의 약수: 1, 2, 3, 6
 *     - 12의 약수: 1, 2, 3, 4, 6, 12   
 *     - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...       
 *     - 소수: 약수의 개수가 2개인 양의 정수      
 *    
 *   o 작성된 통합 메소드
 *     - printCountDivisorsOf(int n): n의 약수 개수 출력하는 메소드
 *     - printWhetherPrimeNo(int n): n의 소수 여부 출력하는 메소드
 *      
 *   o 작성된 반환값 갖는 메소드
 *     - int getCountDivisors(int n): n의 약수 개수를 구하여 반환하는 메소드
 */

class Ex5_1_5_CountDivisors_UsingMethodWithReturnValue {

	public static void main(String[] args) {
		printCountDivisorsOf( 100 );           
		printWhetherPrimeNo( 1237 );     
	}

	// 매개변수로 주어지는 n의 약수 개수 출력하는 메소드
	static  void  printCountDivisorsOf(int n) {
		int cntDivisors =  getCountDivisors( n ); // n의 약수 개수 구해 반환하는 메소드 호출	
		
		System.out.println("\n  * " + n + "의 약수 개수: "+ cntDivisors); 
	}

	// 매개변수로 주어지는 n의 소수 여부 출력하는 메소드
	static void printWhetherPrimeNo(int n) {
		int cntDivisors =  getCountDivisors( n ); // n의 약수 개수 구해 반환하는 메소드 호출		
		
		if (cntDivisors == 2) 
			System.out.println("\n  * " + n  + ": 소수임" ); 
		else 
			System.out.println(" \n  * " + n + ": 소수 아님" );           
	}

	// 매개변수로 주어지는 n의 약수 개수를 구하여 반환하는 메소드
	static int getCountDivisors(int n)  {
		int cntDivisors = 0;  
		
		for (int i = 1; i <= n; i++)  
			if (n % i == 0) 	 
				cntDivisors++;  
		
		return cntDivisors;  // 구한 약수 개수 반환
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 이전에 중복되었던 약수 개수 구하는 코드를 반환값 갖는 메소드로 작성한 후 
 *      약수 개수가 필요하면 호출한다.
 *      
 *      - 이로 인하여 반환값 갖는 메소드 호출은  수식의 한 부분으로 사용 가능하므로 활용성이 증대함
 *   
 *   2) 매개변수를 가지면서 반환값을 갖는 통합 메소드를 자유자재로 작성하는 능력이 
 *      Java 프로그래머에게 가장 요구되는 능력 중의 하나이므로  메소드들을 
 *      마음대로 작성할 수 있는 수준이 되어야 한다.
 *         
 *   3) 매개변수를 갖는 통합 메소드와 반환값 갖는 메소드의 강력함이 느껴지는가?
 */
