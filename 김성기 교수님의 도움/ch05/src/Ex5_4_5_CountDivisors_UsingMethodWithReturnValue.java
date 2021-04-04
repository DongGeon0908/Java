/**
 * [ CountDivisors_UsingMethodWithReturnValue ]: 
 *       반환값 갖는 메소드 사용하여 약수 개수 출력
 *            
 *   o 프로그래밍 스타일 
 *     - main() 메소드에서 반환값 갖는 메소드 호출하여 약수 개수 구하여 출력
 *            
 *   o 반환값 갖는 메소드 호출은 수식의 일부로 사용 가능
 *     - 호출된 메소드가 수행되고 최종적으로 return 문에서 반환값을 반환
 *     - 반환값은 호출한 메소드로 전달됨
 *         ==> 이로 인해 호출한 메소드 자체는 전달된 값 갖게 됨
 *         
 *     - 이는 실매개변수의 값이 형식매개변수에 저장되는 것과 유사한 원리임
 *     - 반환된 값은 호출한 메소드에서 사용 가능
 *        ==> 반환값 갖는 메소드 호출은 수식의 한 구성요소로 사용 
 *      
 *   o 약수
 *     - 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *     - 6의 약수: 1, 2, 3, 6
 *     - 12의 약수: 1, 2, 3, 4, 6, 12   
 *     - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...      
 */  

class Ex5_4_5_CountDivisors_UsingMethodWithReturnValue {
	public static void main(String[] args) {			
		int cnt;
		cnt = getCountDivisors(1237); 	// 1237의 약수 개수 구해 이를 cnt 변수에 저장
		System.out.println("\n  * " + 1237 + "의 약수 개수: "+ cnt); 
		
		// 12347의 약수 개수 구해 출력
	    System.out.println("\n  * " + 12347 + "의 약수 개수: " + getCountDivisors(12347)); 

	}

	// 주어진 n의 약수 개수를 구해 반환하는, int 타입의 반환값 갖는 메소드
	static int getCountDivisors(int n) {
		int cntDivisors = 0;  
		for (int i = 1; i <= n; i++)  
			if (n % i == 0) 	 
				cntDivisors++;  

		return cntDivisors ;   // 구해진 약수 개수 반환 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) static int getCountDivisors(int n) 메소드는 약수 개수를 구하여 반환하는 메소드이다.
 *      - << return cntDivisors; >>에서 매개변수로 주어진 n의 구해진 약수개수를  반환
 *      - 메소드 시그니처의 반환값 타입과 반환값인 cntDivisors의 타입이 모두 int로 동일함
 *      
 *   2) main()에서 int getCountDivisors(int n) 메소드를 호출한다.
 *      - << cnt = getCountDivisors(1237); >>에서 반환값 갖는 메소드 호출됨
 *      - 실매개변수 1237의 약수 개수가 구해져 반환됨
 *      - 메소드 호출은 반환된 값 자체가 되며, 반환값은 cnt 변수에 저장됨
 *     
 *   3) 반환값 갖는 메소드 호출은 반환값을 가지므로 수식의 한 부분으로 사용됨을 확실히 이해하라.
 *     
 *     
 * [ 실습과제 ]
 * 
 *   1) main() 메소드에 12347의 약수 개수를 구해 변수에 저장하지 않고서 바로 출력하는 문장을 추가로 작성하라.
 *   
 *   2) main() 메소드에 10000부터 10100 사이에서 약수 개수가 2개인 정수 출력하도록 추가 작성하라.   
 */
