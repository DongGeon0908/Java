/**
 * [ PrintLowerCase_UsingFor ]: for 문 이용하여 영소문자 모두 출력하기     
 *  
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) for 문 이용하여 'a'부터 'z' 까지 영소문자 모두 출력
 *         
 *   o 반복문(repetition statement)
 *      - 똑같은 문장들 또는 유사한 문장들이 반복적으로 나열되는 경우 
 *        이를 하나의 문장으로 통합적으로 구성하여 반복시킴
 *      - for 문, while 문, do-while문 등의 반복문  
 *          
 *   o for 문
 *     - 형식
 *         for (반복제어변수_초기화; 반복조건; 제어변수_변경)
 *              반복수행할_문장     
 *    
 *     - 기능: 반복 제어변수 이용하여 반복 회수 제어하는 대표적인 반복문
 *     - 구성: 반복 제어변수 초기화, 반복조건 검사, 제어변수 변경, 반복 문장 등 4 부분
 *     - 수행방법: 반복조건이 true인 동안 반복 수행될 문장을 계속 수행
 *     - 반복 제어변수 선언: for 문 외부 또는 내부에서 선언 가능
 *     
 *     - for 문 외부에서 선언한 반복 제어변수: for 문 내부와 외부에서 사용 가능하며, 
 *                                       for 문이 종료된 후에도 사용 가능함 
 *                                       
 *     - for 문 내부에서 선언한 반복 제어변수: for 문 내에서만 사용 가능 
 */

class Ex4_3_02_PrintLowerCase_UsingFor {
	public static void main(String[] args)  {
		System.out.print("\n  ** Print all lower cases using for statement **\n  ");

		for (int j = 0; j < 26; j++)     // 제어변수 j를 제어변수 초기화에서 선언
		    System.out.print((char)('a' + j) + " "); // 반복 문장이 1개이므로 블록({...}) 불필요	
		
		// 다음 문장은 오류 발생하는 문장, j 변수가 for 문 내부에서 선언되었기 때문
		//   오류 제거 방법: 1) 이 문장 제거 , 2) j를 for 문 외부에서 먼저 선언
		System.out.println("\n\n  * j = " + j);
		
		// 이 부분에 실습과제 1)을 작성하라.
		
		// 이 부분에 실습과제 2)를 작성하라.
		
		// 이 부분에 실습과제 3)를 작성하라.

	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) (char)('a' + j)는 문자 'a'로부터 j번째 문자를 구하는 수식이다.     
 *   
 *   2) for 문 내부에서 선언한 반복 제어변수 j는 for 문 내에서만 사용 가능하다.
 *   
 *   3) 오류를 주어진 2가지 방법으로 각각 제거하여 실행하고 결과 확인하라.
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램은 영소문자 모두를 차례로 출력한다.
 *      'A'부터 'Z'까지의 영대문자 모두를 출력하도록 프로그램 변경하라.
 *      
 *   2) 이 프로그램은 영소문자 모두를 차례로 출력한다.
 *      '0'부터 '9'까지의 숫자 디지트 모두를 출력하도록 프로그램 변경하라.
 *
 *   3) 이 프로그램은 영소문자 모두를 차례로 출력한다.
 *      ' '(blank)부터 100개의 문자들을 차례로 출력하도록 프로그램 변경하라.
 */
