package ex10_2_java_lang_package;

/** 
 * [ StringMethods 클래스 ]: 문자열 생성과 문자열 처리 메소드들
 * 
 *   o String 클래스
 *     - 문자열 비교, 문자열에서의 문자 검사, 문자열 부분 탐색, 문자열 부분 추출, 대소문자 변환, 
 *       문자열 복사 등을 위한  다양한 메소드 제공
 *     - 한편 문자열 접속을 위한 연산자인 + 연산자 제공
 *     - 특히 다른 모든 클래스의 객체들을 문자열로 변환할 수 있도록 toString() 메소드가 Object 클래스에 제공

 *   o 중요 메소드들
 *     - equals(): 두 문자열이 같으면 true, 아니면 false 반환
 *     - compareTo(): 두 문자열 중 앞쪽이 크면 양수, 같으면 0, 작으면 음수 반환
 *     - length(): 문자열 길이 반환
 *     - charAt(), startsWith(), substring() 메소드도 빈번하게 사용되는 메소드임
 */

class Ex10_2_6_StringMethods {  
	public static void main(String[] args) {

		String s = "Java";
		String s1 = new String("Java");

		byte[] b = { 'J', 'a', 'v', 'a' };
		String s2 = new String(b);

		char[] c = { 'J', 'a', 'v', 'a' };
		String s3 = new String(c);   

		char[] c1 = { 'A', 'J', 'a', 'v', 'a' };
		String s4 = new String(c1, 1, 4);  // c1의 인덱스 1 위치 4 문자를 문자열로

		System.out.println(" * s = \"" + s + "\"");  
		System.out.println(" * s1 = \"" + s1 + "\"");  
		System.out.println(" * s2 = \"" + s2 + "\"");  
		System.out.println(" * s3 = \"" + s3 + "\"");  
		System.out.println(" * s4 = \"" + s4 + "\"");
		System.out.println();
		
		System.out.println(" * s1.toString() = \"" + s1.toString() + "\"");       
		System.out.println();
		
		System.out.println(" * s1.equals(s1) = " + s1.equals(s1) );  
		System.out.println(" * s1.equals(s2) = " + s1.equals(s2) );  
		System.out.println(" * s1.equals(\"C\") = " + s1.equals("C") );  
		System.out.println();
		
		System.out.println(" * \"홍길동\".length() = " + "홍길동".length() ); 
		System.out.println(" * s1.length() = " + s1.length() );  
		System.out.println();
		
		System.out.println(" * s1.charAt(2) = " + s1.charAt(2) );  
		System.out.println();
		
		System.out.println(" * s1.compareTo(s2) = " + s1.compareTo(s2) );  
		System.out.println(" * s1.compareTo(\"Java\") = " + s1.compareTo("Java") );  
		System.out.println(" * s1.compareTo(\"C\") = " + s1.compareTo("C") );  
		System.out.println();
		
		System.out.println(" * s1.concat(\" and C\") = " + s1.concat(" and C") );  
		System.out.println();
		
		System.out.println(" * s1.indexOf('v') = " + s1.indexOf('v') );  
		System.out.println(" * s1.indexOf('b') = " + s1.indexOf('b') );  

		System.out.println(" * s1.startsWith(\"Ja\") = " + s1.startsWith("Ja") );  
		System.out.println(" * s1.startsWith(\"ja\") = " + s1.startsWith("ja") );  

		System.out.println(" * s1.substring(1) = " + s1.substring(1) );  
		System.out.println(" * s1.substring(2) = " + s1.substring(2) );  
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 문자열을 생성하는 방법과 여러 문자열 메소드 호출을 보여준다.
 *   
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.   
 */
