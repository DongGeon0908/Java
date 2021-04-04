package ex12_more;
/*
 *  [ SumDigits_UsingFor ]: 양의 정수를 입력하여 그 정수의 각 자리수의 합을 구하기
 *   
 *      o 스타일 2: 반복문 사용하기
 *                + 각 자릿수를 for 문을 이용하여 구하여 합함
 *                + 입력된 수의 10의 나머지를 구하고 10으로 나눈 몫에 대해 반복함
 *                
 *      o 정수의 각 자리수의 합 구하기
 *        - 정수 123인 경우 자리수는 1의 자리 1, 10의 자리 2, 백의 자리 3이므로 자리수 합은 1+2+3 = 6임
 *        - 입력된 정수를 10으로 나눈 나머지가 1 자리의 자리수임
 *        - 이를 이용하여 10으로 나눈 나머지를 구하여 1 자리의 자리수를 확인하고, 
 *        - 그 정수를 10으로 나눈 몫을 구하여 그 몫에 대해 똑같은 작업을 하면
 *          바로 다음 왼쪽 자리의 자리수를 확인할 수 있음
 *        - int 타입의 양의 정수의 최대 자리수는 10자리이므로 10번 반복하면 됨  
 */

class Ex4_06_1_SumDigits_UsingFor  {

	public static void main(String[] args)  {
		int n0, n;     // 입력한 값을 저장할 변수
		int sum = 0;   // 각 자리수의 합을 저장할 변수

		System.out.println("\n\n  **** Getting sum of digits of an integer (using for statement) ****");

		n0 = n = SkScanner.getIntWithPrompt("\n  o Enter a positive number > ");

		for (int i = 0; i < 10; i++)  {
			int digit = n % 10; 	// 1의 자리의 자리수를 구함
			
			System.out.println("  << 개발과정에서의 확인>> [i:" + i + "] sum = " + sum + ", n = " + n + ", digit = " + digit  + ", next n = " + n / 10);
			
			sum += digit;  			// n을 10으로 나눈 나머지를 sum에 누적시킴
			n = n / 10;       		// n을 10으로 나눈 정수 몫으로 대체한 후 다시 반복
		}

		System.out.println("\n  * sum of digits of " + n0 + " is " + sum);

		main(args);   // 이는 가장 쉽게 전체를 반복시키는 방법임
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.     
 *     
 *   2) 점수 1, 2, 127, 255, 65535, 16777215, 2147483647을 입력하여 결과를 확인하라
 *   
 *   3) << 개발과정에서의 확인>>을 위해 작성한 코드의 출력 결과를 살펴보라. 
 *      특히 n과 digit 변수의 값을 잘 살펴보라 *      1 증가했을 때의 n이 짝수인지 홀수인지를 확인하라.  
 *      
 *   4) 이 프로그램을 반복문으로 작성하지 않고 반복되는 문장들을 일일이 작성한 
 *      프로그램이 Ex4_9_3_SumDigits_NotUsingRepetition이다. 두 프로그램을 비교하여 보라.      
 *
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램은 int 타입의 양의 정수에 대해 최대 31개의 1인 비트수를 구한다.
 *   
 *      long 타입의 양의 정수 또는 음의 정수에 대해서도 각 자리수의 합을 구하는 프로그램을 
 *      Pr4_6_1_SumDigitsLong_UsingFor 클래스로 작성하라. 
 *      
 *      (참고: long 타입의 값을 입력하기 위해서는 SkScanner.getLongWithPrompt(String) 메소드를 사용함)
 *       
 */
