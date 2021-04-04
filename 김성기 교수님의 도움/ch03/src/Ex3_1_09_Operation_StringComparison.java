/**
 * [ Operation_StringComparison ]: 문자열 비교의 연습
 *     
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 문자열 비교 연산을 수행하여 결과 값 출력
 *      
 *   o 문자열 비교 연산은 동등 비교인 == 이며, 이는 equals() 메소드와 비슷하지만 다름
 *     - == 연산: 객체 자체가 동일한 객체인가를 검사
 *     - equals() 메소드: 객체 내에 저장된 문자열이 같은 문자열인가를 검사
 *     - 문자열 비교에서는 equals() 메소드 사용하는 것이 좋음
 *     
 *   o 그 외 비교는 compareTo() 메소드를 이용함
 */

class Ex3_1_09_Operation_StringComparison  {
	public static void main(String[] args)  {

		String name = "홍길동"; 
		
		System.out.println("\n  ** 문자열 동등 비교 연산(==) 및 equals(), compareTo() 메소드 **\n");

		System.out.println("  * 변수 초기값: name = " + name); 
		System.out.println(); 

		// 문자열 상수와 문자열 상수의 동등 비교
		System.out.println("  * \"홍길동\" == \"홍길동\"      := " + ( "홍길동" == "홍길동" )); 
		System.out.println("  * \"홍길동\".equals(\"홍길동\") := " + ( "홍길동".equals("홍길동") )); 
		System.out.println(); 
		
		// 문자열 변수와 문자열 상수의 동등  비교
		System.out.println("  * name == \"홍길동\"      := " + ( name == "홍길동" )); 
		System.out.println("  * name.equals(\"홍길동\") := " + ( name.equals("홍" + "길동") )); 
		System.out.println(); 

		// 문자열 변수와 문자열 상수의 동등 비교
		System.out.println("  * name == \"홍길서\"      := " + ( name == "홍길서" )); 
		System.out.println("  * name.equals(\"홍길서\") := " + ( name.equals("홍길서") )); 
		System.out.println(); 

		// 문자열 사전 순서상 크기 비교
		System.out.println("  * \"홍길동\".compareTo(\"홍길동\") := " + ( "홍길동".compareTo("홍길동") )); // 크기가 같으므로 0
		System.out.println("  * \"홍길동\".compareTo(\"홍길서\") := " + ( "홍길동".compareTo("홍길서") )); // "홍길동"이 "홍길서"보다 작으므로 음수
		System.out.println("  * name.compareTo(\"홍길남\")    := " + ( name.compareTo("홍길남") ));  // "홍길동"이 "홍길남"보다 크므로 양수
		System.out.println(); 

		System.out.println("  * \"Java\".compareTo(\"C\"))        := " + ( "Java".compareTo("C") )); // "Java"가 "C"보다 크므로 양수
		System.out.println("  * \"JDK1.7\".compareTo(\"JDK1.8\")) := " + ( "JDK1.7".compareTo("JDK1.8") )); // "JDK1.7"가 "JDK1.8"보다 작으므로 음수

	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *   
 *   
 * [ 참고사항 ]
 *  
 *   o 문자열 상수는 객체 생성 없이 쉽게 다룰 수 있는 장점이 있지만  Java에서 문자열 상수와 
 *     new String()을 통해 생성된 문자열 객체는 다르게 관리되므로 주의를 요한다.
 *     
 *     - 예를 들어, 문자열 상수와 문자열 객체를 다음과 같이 == 연산자로 비교하면 이는 서로 다른 객체이므로 false이다.
 *        "홍길동" == new String("홍길동") ==> false      // 문자열 상수와 new를 통해 생성된 문자열 객체는 다른 객체
 *        
 *     - 문자열 상수와 문자열 객체를 다음과 같이 equals() 메소드로 비교하면 이는 서로 동일한 내용의 문자열이므로 true이다.
 *        "홍길동".equals(new String("홍길동")) ==> true  // equals(_)메소드는 문자열 내용이 동일하면 true
 *        
 *     - 그러므로 문자열을 비교할 때에는 == 연산자보다 equals() 메소드를 사용하는 것이 좋다.   
 */
