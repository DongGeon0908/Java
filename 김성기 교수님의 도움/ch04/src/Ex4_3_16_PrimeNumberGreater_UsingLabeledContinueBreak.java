/**
 * [ PrimeNumberGreater_UsingLabeledContinueBreak ]: 
 *        레이블 이용한 continue 문과 break 문으로 입력된 정수보다 큰 첫 번째 소수 구하기   
 *        
 *   o 반복문에서 레이블 이용
 *     - 레이블 이용하여 특정 반복문으로 break 또는 continue 할 수 있음
 *     - 반복문 앞에 레이블 부여하여 그 위치의 반복문 벗어나거나 계속 반복하게 함
 *     
 *     - 프로그래밍 초기에는 레이블 많이 이용했지만 최근에는 사용 금지 권장
 *       (메소드 작성하면 레이블 갖는 반복문 불필요하기 때문) 
 *     
 *   o 소수: 약수의 개수가 2개인 양의 정수     
 *     - 2, 3, 5, 7, 11, 23, 27, 23 ...          
 */

class Ex4_3_16_PrimeNumberGreater_UsingLabeledContinueBreak {
	public static void main(String[] args)  {
		System.out.println("\n  ** 입력된 정수보다 큰 소수 구하기 **\n");

		int n0, n;
		n0 = SkScanner.getIntWithPrompt("  o 양의 정수 입력 > " );

		outLoop:    // 외부 for 문에 대한 레이블 명시
		for (n = n0 + 1;  ; n++) {        // 외부 for 문: 반복조건 생략되면 무한히 반복됨
		     for (int i = 2; i < n; i++)  //   내부 for 문: n이 소수인지 검사
		         if (n % i == 0)          //     1과 자신 외의 약수 있으면 소수 아니므로  
		            continue outLoop;     //     나머지 반복 문장은 수행하지 않고 outLoop를 
		                                  //     새롭게 반복함, n++는 수행됨
		     break outLoop;  // n은 소수이므로 outLoop 반복문을 벗어나 종료함
		} 
		  
		System.out.println("  * " + n0 +"보다 큰 첫 번째 소수 = "  + n);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 예제 4-3-16은 중첩된 반복문에서 break 문과 continue 문의 예를 보인다.
 *     - 레이블 이용하여 특정 반복문으로 break 또는 continue 할 수 있음
 *     - 다음에 배울 메소드 이용하면 레이블이 필요 없음
 *        ==> 레이블 이용 방식의 코딩은 하지 않도록 해야 함
 *              
 *   2) 입력된 score 값에 따른 프로그램의 실행과정을 정확히 이해하라.   
 */
