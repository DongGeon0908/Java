package ex6_4_3_static_init_block;

/**
 * [ FibonacciNumber 클래스 ]: 스태틱 초기화 블록을 보여주는 예제
 * 
 *   o 피보나치 수(Fibonacci number): 다음 수가 앞 두 수의 합으로 이루어지는 수열
 *      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
 *       
 *   o 스태틱 초기화 블록
 *     - 클래스 필드를 단순히 변수 초기화로만으로 초기화할 수 없을 때 작성
 *     - 키워드 static 다음의 블록 내에 수행될 작업들 명시      
 *    
 *     - static 초기화 블록은 클래스가 처음 사용되어 로드될 때 수행
 */

class FibonacciNumber {
	// 93은 long 타입으로 구할 수 있는 피보나치 수의 최대 개수 
	static final int NOFIBONACCIS = 93; 

	// 미리 구한 피보나치 수를 저장하는 배열
	static long[] fibonaccis = new long[NOFIBONACCIS]; 

	// 피보나치 수를 미리 구하여 fibonaccis[] 배열에 저장하는 스태틱 초기화 블록
	static { // 스태틱 초기화 블록의 시작
		fibonaccis[0] = 0;  // 0번째 피보나치 수
		fibonaccis[1] = 1;  // 1번째 피보나치 수
		
		// 2번째부터 NOFIBONACCIS-1 번째까지의 피보나치 수를 구하여 배열에 저장
		for (int i = 2; i < NOFIBONACCIS; i++) { 
			fibonaccis[i] = fibonaccis[i - 2] + fibonaccis[i - 1];
		}
	} // 스태틱 초기화 블록의 끝

	// n 번째 피보나치 수를 반환: 배열에 구해놓은 값을 반환함
	public static long getFibonacci(int n) {
		if (n >= 0 && n < NOFIBONACCIS) // 0부터 NOFIBONACCIS-1번째인 경우 
			return fibonaccis[n];       //     배열에서 반환
		else
			return -1; // 음수번째 또는 long 범위를 벗어나는 번째이면 -1을 반환
	}
}

class Ex6_4_4_FiboApp {	
	public static void main(String[] args) {
		System.out.println("\n\n");

		for (int i=-9; i <= 100; i++) {
			System.out.print(" [" + i + "]:" + FibonacciNumber.getFibonacci(i));
			if (i % 5 == 0)
				System.out.println();
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 미리 구한 피보나치 수를 저장하는 배열 fibonaccis에 피노나치 수열들을 static 초기화를 이용하여 저장한다.
 *           
 *   2) long getFibonacci(int n) 메소드는 배열변수 필드 fibonaccis에 저장된 n번째 피보나치 수열을 반환한다.
 *   
 *   3) main()에서 -9번째부터 100번째까지 피보나치 수열을 출력한다.
 *   
 *      음수 번째와 94번째 이후는 값을 출력하지 못하므로 -1을 출력한다. 
 */
