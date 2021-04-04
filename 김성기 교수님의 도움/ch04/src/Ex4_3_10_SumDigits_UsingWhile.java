/**
 * [ SumDigits_UsingWhile ]: while 문 이용하여 입력된 정수의 디지트들 합 구하기   
 *            
 *   o while 문
 *     - 사용 형식:  while(반복조건)
 *	                                   반복_수행할_문장
 *	              
 *     - 기능: 반복조건이 true인 동안 반복_수행할_문장을 반복하다 조건이 false이면 반복 종료
 *     - 특이사항: 처음 반복조건이 false이면 반복_수행할_문장이 한 번도 수행되지 않음
 *	               
 *   o 입력한 정수의 디지트들 합 구하기
 *     - 10의 나머지를 각 자리에 대해 구해 더하면 됨
 *     - while 이용하여 10의 나머지 구한 후 10의 몫이 0이 될 때까지 다시 반복
 */

class Ex4_3_10_SumDigits_UsingWhile {
	public static void main(String[] args)  {
		int n0, n;  // 입력된 정수를 저장할 변수
		int sumDigits = 0;

		System.out.println("\n  ** 정수 입력하여 디지트들 합 구하기 **\n");
		
		n0 = n = SkScanner.getIntWithPrompt("  o 디지트들 합 구할 정수 > ");

		if (n < 0)   // 음수의 경우 
		  n = -n;    //   양수로 바꾸어 디지트들 합을 구하게 함

		while(n != 0) {                      // n이 0이 아닌 동안 
		   sumDigits = sumDigits + n % 10;   //   n의 1자리 디지트 구해 합에 누적
		   
		   // 이 문장은 수행되는 과정 확인하기 위해 작성한 문장: 나중에는 제거 또는 주석으로 만들어야 함
		   System.out.println("    < for debug > n = " + n + ", last digit = " 
		                                  + (n % 10) +", sumDigits = " + sumDigits);

		   n = n / 10;                       //    n을 10으로 나누어 자리수를 하나 줄임
		}

		System.out.println("\n  * " + n0 + "의 디지트들의 합 =  " + sumDigits);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 예제 4-3-10은 while 문 사용하여 입력된 정수의 디지트들 합 구한다.
 *      - while 문의 반복조건이 n != 0이므로 n이 0 아닌 동안 while 문 계속 반복
 *      - n이 10으로 계속 나누어지므로 어느 순간 0 되며, 그때에 while 문 종료
 *      - n의 10 나머지 구하여 합에 누적하고 n을 10으로 나눈 후 계속 반복하면 
 *         각 자리수들 합 구해짐 
 *         
 *   2) 입력된 n의 값에 따른 프로그램 실행과정을 정확히 이해해야 한다.
 *      - n이 변하는 과정 살펴보며 프로그램 이해하라.   
 */
