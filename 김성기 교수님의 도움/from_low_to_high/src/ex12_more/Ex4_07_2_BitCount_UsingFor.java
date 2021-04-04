package ex12_more;
/*
 * [ BitCount_UsingFor ]: 양의 정수를 입력하여 그 정수의 1인 비트수를 나머지 연산으로 구하기
 *   
 *    o 프로그래밍 스타일 
 *      1) main() 메소드로만 클래스 구성
 *      2) 반복문 사용하지 않기
 *         - 1인 비트 개수를 최대 31까지 구함
 *           + 입력된 정수를 31번 2로 나누면서 가장 오른쪽 비트에 대해 0, 1을 검사
 *                
 *    o 1인 비트수를 구하는 방법:
 *      - 입력된 정수를 2로 나눈 나머지가 1이면 그 정수의 가장 오른쪽 비트는 1임
 *        이를 이용하여 2로 나눈 나머지를 구하여 1인지 확인함
 *         
 *      - 그 정수를 2로 나눈 몫을 구하여 그 몫에 대해 똑같은 작업을 하면
 *        바로 다음 왼쪽의 비트에 대해서도 1인지를 확인할 수 있음
 */

class Ex4_07_2_BitCount_UsingFor  {

	public static void main(String[] args)  {
		int n0, n;     // 입력된 값을 저장할 변수

		System.out.println("\n\n  ****  Getting count of 1 bits of an integer (using for stmt)****");
		n0 = n = SkScanner.getIntWithPrompt("\n  o Enter a positive number > ");

		int cnt = 0;   // 1인 비트의 개수를 저장할 변수

		for (int i = 0; i < 31; i++)  {
			if (n % 2 == 1) cnt++;  // n을 2로 나눈 나머지가 1이면 cnt 증가 
			
			// 이 문장은 프로그램 개발과정에서 확인을 위해 작성한 코드임
			System.out.println("    << for debug >> [i:" + i + "] n = " + n + ", cnt = " + cnt);  
			
			n = n / 2;              // n을 2로 나눈 몫으로 대체한 후 다시 반복
		}

		System.out.println("\n  * Count of 1 bits of " + n0 + " is " + cnt);

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
 *   3) 개발 과정에서 확인을 위해 작성한 코드의 출력 결과를 살펴보라. 특히 cnt가
 *      1 증가했을 때의 n이 짝수인지 홀수인지를 확인하라.  
 *      
 *   4) 이 프로그램을 반복문으로 작성하지 않고 반복되는 문장들을 일일이 작성한 
 *      프로그램이 BitCount2 클래스이다. 두 프로그램을 비교하여 보라.      
 *
 *
 * [ 실습과제 ]
 * 
 *   o 이 프로그램은 int 타입의 양의 정수에 대해 최대 31개의 1인 비트수를 구한다.
 *   
 *      long 타입의 양의 정수에 대해 최대 63개의 1인 비트수를 구하는 프로그램을 
 *      Pr4_7_2_BitCount_UsingFor 클래스로 작성하라. 
 *      
 *      (참고: long 타입의 값을  입력하기 위해서는 SkScanner.getLongWithPrompt() 메소드를 사용함)
 *      
  
 */
