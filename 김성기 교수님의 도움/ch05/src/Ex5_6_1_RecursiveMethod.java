/**
 * [ RecursiveMethod ]: 재귀 메소드의 작성과 호출
 *  
 *   o 1부터 n까지의 합을 구하는 메소드 getSum(int n)과 
 *     n 팩토리알을 구하는 getFactorial(int n)을 재귀 메소드로 작성
 *     
 *   o 재귀 메소드
 *     - 메소드 구현에서 자신을 호출하는 메소드
 *     - 재귀 메소드 호출되면 특수 조건 만족할 때가지 연속적으로 재귀 메소드 호출됨
 *     - 특수 조건에 도달하면 연쇄적으로 호출된 메소드 반환됨
 *     
 *   o 1부터 n까지의 합 sum(n)은 반복적 표현과 재귀적 표현으로 가능
 *     - 재귀적 표현: sum(n) = 1 + 2 + 3 + ... + n 
 *     - 반복적 표현: sum(n) = sum(n-1) + n (단 n이 1이면 sum(1) = 1) 
 *     
 *     - 이를 재귀 메소드로 작성한 것이 int getSum(int n) 메소드
 *         
 *   o main() 메소드에서 getSum(5) 호출 시 수행과정
 *     - 메소드 호출과 반환이 연쇄적으로 이루어짐
 *     
 *     - getSum(5) 호출되면 getSum(4), getSum(3), getSum(2), getSum(1)이 연쇄적으로 호출
 *     - getSum(1)에서 1이 getSum(2)로 반환(특수조건에 해당)
 *     - 다시 getSum(2)에서 1(반환값) + 2 = 3이 getSum(3)으로 반환
 *     - 다시 getSum(3)에서 3(반환값) + 3 = 6이 getSum(4)로 반환
 *     - 다시 getSum(4)에서 6(반환값) + 4 = 10이 getSum(5)로 반환
 *     - 최종적으로 getSum(5)에서 10(반환값) + 5 = 15가  main()으로  반환
 *   
 */

public class Ex5_6_1_RecursiveMethod {
	
	// getSum(int n): 1부터 n까지 합을 구하여 반환하는 메소드
	static int getSum(int n) {
		if (n == 1)                   // n이 특수 조건인 1이면  
			return 1;                 // 1까지의 합으로 1을 반환
		else
			return getSum(n - 1) + n; // n까지 합으로 (n - 1)까지 합 + n을 반환
	}

	// getFactorial(int n): n 팩토리알을 구하여 반환하는 메소드
	static int getFactorial(int n) {
		if (n == 0)                          // n이 특수조건인 0이면
			return  1;                       // 0!은 1을 반환
		else
			return getFactorial(n - 1) * n;  // n!로 (n - 1)! * n 반환
	}

	public static void main(String[] args) {
		int sum = getSum(5);
		int fact = getFactorial(4);

		System.out.println("\n  o 1부터 5까지의 합 = " + sum);
		System.out.println("\n  o 4! = " + fact);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1)  getSum(int n) 메소드와 getFactorial(int n) 메소드를 재귀 메소드로 작성한다.
 *      - main() 메소드에서 이들을 호출하여 결과를 출력
 *      - 재귀 메소드 호출되면 특수 조건이 만족될 때까지 연속적으로 재귀 메소드 호출
 *      - 특수 조건에 도달하면 호출된 메소드가 연쇄적으로 반환
 *     
 *   2) 프로그램을 실행하여 결과를 확인하라. 
 */
