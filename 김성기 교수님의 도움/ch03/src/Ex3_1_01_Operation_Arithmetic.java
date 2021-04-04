/**
 * [ Operation_Arithmetic ]: 산술 연산의 연습
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 산술 연산을 수행하여 결과 값 출력
 *
 *   o 산술 연산은 정수와 실수에 대한 사칙 연산(+, -, *, /) 및 나머지 연산(%)이 있음
 */

class Ex3_1_01_Operation_Arithmetic  {
	public static void main(String[] args)  {

		System.out.println("\n  ** 사칙 연산(+, -, *, /) 및 나머지 연산(%) **\n");
		
		System.out.println("  * 1.5 + 6.6   := " + ( 1.5 + 6.6 ));  	//  ⇒  8.1
		System.out.println("  * 3.3F - 3.2F := " + ( 3.3F - 3.2F	)); //  ⇒  0.1F(이 경우 0.1에 근접한 값이 출력됨 확인할 것)
		System.out.println("  * 3L * 2L     := " + ( 3L * 2L	));  	//  ⇒  6L
		System.out.println();
		
		System.out.println("  * 19 / 5      := " + ( 19 / 5	)); 		//  ⇒  3	  : int 타입의 나누기의 결과는 int 값
		System.out.println("  * 19.0 / 5.0  := " + ( 19.0 / 5.0 ));  	//  ⇒  3.8 : double 타입의 나누기 결과는 double 값
		System.out.println("  * -19 / 5     := " + ( -19 / 5	));  	//  ⇒  -3  : 나누기 연산의 결과는 왼쪽 피연산자와 부호가 같음
		System.out.println();

		System.out.println("  * 19 % 5      := " + ( 19 % 5 ));  		//  ⇒  4	  : 나머지 연산의 결과는 왼쪽 피연산자와 부호가 같음
		System.out.println("  * -19 % 5     := " + ( -19 % 5	));  	//  ⇒  -4  : 나머지 연산의 결과는 왼쪽 피연산자와 부호가 같음
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 프로그램에 나타난 상수들의 타입을 확인하라.
 *  
 *   2) 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 * 
 *   3) 소수 이하 실수 값의 경우 정확한 값이 아니라 근사값 출력되는 경우가 있음을 확인하라.
 *   
 *         * 3.3F - 3.2F := 0.099999905   
 */

