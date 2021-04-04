/**
 * [ Operation_StringConcatenation ]: 문자열 접속 연산의 연습
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 문자열 접속 연산을 수행하여 결과 값 출력
 *       
 *   o 문자열 접속 연산 + 
 *     - 두 문자열을 하나의 문자열로 만듦
 *     - 피연산자 중 하나만 문자열이어도 다른 값을 문자열로 변환하여 접속시킨 문자열 생성
 */

class Ex3_1_08_Operation_StringConcatenation  {
	public static void main(String[] args)  {
		
		String name = "홍길동"; 
		int age = 18;
		double height = 177.7;
		boolean isKorean = true;

		System.out.println("\n  ** 문자열 접속 연산(+) **\n");

		System.out.println("  * 변수 초기값: name = " + name + ", age = " + age + ", height = " + height + ", isKorean = " + isKorean); 
		System.out.println();

		System.out.println("  * \"홍\" + \"길동\"     := " + ( "홍" + "길동" ));  // 문자열 상수와 문자열 상수의 접속
		System.out.println("  * \"이름은 \" + name   := " + ( "이름은 " + name ));  // 문자열 상수와 문자열 변수의 접속
		
		System.out.println("  * \"나이는 \" + age    := " + ( "나이는 " + age ));   // 문자열과 정수 접속: 정수가 문자열로 변환된 후 접속됨	
		System.out.println("  * height + \"의 키\"  := " + ( height + "의 키" )); // 실수와 문자열의 접속: 실수가 문자열로 변환된 후 접속됨 	
		System.out.println();
		
		System.out.println("  * age + height        := " + ( age + height ));  	      // 정수와 실수를 + 하면 문자열 접속이 아님
		System.out.println("  * \" \" + age + height  := " + ( " " + age + height )); // 문자열을 먼저 접속하고 정수와 실수를 + 하면 문자열 접속이 됨	
		System.out.println();			

		// 문자열과 boolean 값 접속: boolean 값이 문자열로 변환된 후 접속됨
		System.out.println("  * \"한국인 여부는 \" + isKorean  := " + ( "한국인 여부는 " + isKorean ));  	
		System.out.println();			
}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */
