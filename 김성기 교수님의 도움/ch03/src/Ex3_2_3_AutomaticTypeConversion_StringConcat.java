/**
 * [ AutomaticTypeConversion_StringConcat ]: 문자열 접속 연산에서의 자동적 타입 변환
 *        
 *     o 프로그래밍 스타일 
 *       1) main() 메소드로만 클래스 구성
 *       2) 자동적 타입변환이 발생하는 연산의 결과 값 출력
 *       
 *     o 자동적 타입 변환이 발생하는 경우
 *       - 산술 연산과 비교 연산에서 피연산자 타입이 다를 경우: 약한 타입의 값이 강한 타입의 값으로 변환
 *       - 대입 연산에서 약한 타입의 값이 강한 타입의 변수에 저장될 경우: 약한 타입의 값이 강한 타입의 값으로 변환
 *       - 문자열 접속 연산에서 문자열과 문자열이 아닌 값을 접속시킬 경우: 문자열이 아닌 값이 문자열로 변환
 *     
 *     o Java에서의 약한 타입과 강한 타입 관계 
 *        byte ≪ char/short ≪ int  ≪  long  ≪  float  ≪  double  
 */

class Ex3_2_3_AutomaticTypeConversion_StringConcat  {
	public static void main(String[] args)  {

		System.out.println("\n  ** 자동적 타입 변환을 수행하는 문자열 접속 연산 **\n");
		/*
		 * 문자열 접속 연산에서의 자동적 타입 변환
		 */
		String name = "홍길동"; 
		int age = 18;
		boolean isKorean = true;
		double height = 177.7;
		
		System.out.println("  * 변수 초기값: name = " + name  + ", age = " + age + ", height = " + height + ", isKorean = " + isKorean +"\n");

		System.out.println("  * \"나이는 \" + age       := " + ( "나이는 " + age ));     // 문자열과 정수 접속: 정수를 문자열로 변환한 후 접속
		System.out.println("  * height + \"의 키\"     := " + ( height + "의 키" ));    // 실수와 문자열 접속: 실수를 문자열로 변환한 후 접속 	
		System.out.println("  * age + height        := " + ( age + height ));  	      // 정수와 실수를 + 하면 문자열 접속이 아닌 산술 연산
		System.out.println("  * \" \" + age + height  := " + ( " " + age + height )); // 문자열을 먼저 접속하고 정수와 실수를 차례로  + 하면 문자열 접속을 연속적으로 수행	
		System.out.println("  * \"한국인 여부는 \" + isKorean  := " + ( "한국인 여부는 " + isKorean ));  // 문자열과 boolean 값 접속: boolean 값을 문자열로 변환한 후 접속
		System.out.println();	
	
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 *   o 자동적 타입변환이 발생되는 내용 이해하라.
 *   
 */
