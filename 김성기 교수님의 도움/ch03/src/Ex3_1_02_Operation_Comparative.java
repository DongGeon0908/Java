/**
 * [ Operation_Comparative ]: 비교 연산의 연습
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 비교 연산을 수행하여 결과 값 출력
 *       
 *   o 비교 연산은 정수와 실수에 대한 >, <, >=, <=, ==, != 등이 있음
 */

class Ex3_1_02_Operation_Comparative  {
	public static void main(String[] args)  {
		
		System.out.println("\n  ** 비교 연산(>, <, >=, <=, ==, != ) **\n");
		
		System.out.println("  * 1.5 > 6.6    := " + ( 1.5 > 6.6 ));  	//  ⇒  false: 1.5는 6.6보다 작으므로 false
		System.out.println("  * 3.3F < 3.2F  := " + ( 3.3F < 3.2F	)); //  ⇒  false  : 3.3F는 3.2F보다 크므로 false
		System.out.println();
		
		System.out.println("  * 3L >= 2L     := " + ( 3L >= 2L ));  	//  ⇒  true  : 3L은 2L보다 크므로 true
		System.out.println("  * 19 <= 5      := " + ( 19 <= 5	)); 	//  ⇒  false: 19는 5보다 크므로 false	
		System.out.println();
		
		System.out.println("  * 19.0 == 5.0  := " + ( 19.0 == 5.0 )); 	//  ⇒  false: 19.0은 5.0과 같지 않으므로 false	
		System.out.println("  * 19 != 5      := " + ( 19 != 5	));  	//  ⇒  true  : 19는 5과 같지 않으므로 true
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라. 
 *   
 */
