/**
 * [ CountDivisors_NotUsingFor ]: 100의 약수 개수와 1237의 소수 여부 출력(메소드 미사용)   
 *            
 *   o 프로그래밍 스타일 
 *     - main() 메소드에서 모든 작업을 수행
 *     - 100의 약수 개수와 1237의 소수 여부 출력을 메소드 사용 않고서 작성
 *     - 상수를 프로그램에 직접 표기하여 변경이 다소 불편함   
 *       
 *   o 약수(divisor)와 소수(prime number)
 *     - 약수: 양의 정수 n의 약수는 1과 n 사이의 정수 중 n을 나머지 없이 나누는 수
 *     - 6의 약수: 1, 2, 3, 6
 *     - 12의 약수: 1, 2, 3, 4, 6, 12   
 *     - 약수가 2개인 정수: 2, 3, 5, 7, 11, 13, 17, ...       
 *     - 소수: 약수의 개수가 2개인 양의 정수      
 */  

class Ex5_1_1_CountDivisors_NotUsingMethod {
	public static void main(String[] args)  {

		int cntDivisorsOf100 = 0;         // 100의 약수 개수를 0으로 초기화

		for (int i = 1; i <= 100; i++)    // 내부 for 문: i가 1부터 100까지 반복
			if (100 % i == 0) 	          //    100을 i로 나누어 나머지가 0이면 
				cntDivisorsOf100++; 	  //    i는 100의 약수이므로 약수 개수 1 증가	

		System.out.println("\n  * " + 100 + "의 약수 개수: " + cntDivisorsOf100); 


		int cntDivisorsOf1237 = 0;        // 1237의 약수 개수를 0으로 초기화

		for (int i = 1; i <= 1237; i++)   // 내부 for 문: i가 1부터 1237까지 반복
			if (1237 % i == 0) 	          //    1237을 i로 나누어 나머지가 0이면 
				cntDivisorsOf1237++;      //    i는 1237의 약수이므로 약수 개수 1 증가	

		if (cntDivisorsOf1237 == 2) 
			System.out.println("\n  * " + 1237  + ": 소수임" ); 
		else 
			System.out.println("\n  * " + 1237 + ": 소수 아님" ); 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 for 문을 이용하여 100의 약수 개수와 1237의 소수 여부 출력한다.
 *  
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *     
 *   3) 프로그램이 수행하는 작업내용을 기능이라 하는데, 프로그램의 기능이 바로 파악되는가?
 */
