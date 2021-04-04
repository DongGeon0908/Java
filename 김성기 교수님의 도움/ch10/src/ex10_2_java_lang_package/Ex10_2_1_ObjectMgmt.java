package ex10_2_java_lang_package;

import java.lang.*;  // java.lang 패키지의 멤버 전체를 import, 생략해도 됨

/**
 * [ Ex10_2_1_ObjectMgmt 클래스]: Object 클래스의 여러 메소드 활용하기
 *  
 *   o Object 클래스
 *     - 모든 클래스의 상위 클래스가 되는 최상위 클래스
 *     
 *     - Object 클래스에는 모든 객체에게 필요한 메소드인 
 *       toString(), hashCode(), equals(), getClass() 등의 메소드들이 정의되어 있음
 *     - Object 클래스의 메소드는  모든 클래스로 상속
 *     - 모든 클래스의 객체가 Object 클래스의 메소드 호출 가능
 *     
 *     - 메소드 toString(), equals()는 하위 클래스에서 오버라이딩하도록 권장
 */

class Ex10_2_1_ObjectMgmt {  
	public static void main(String[] args) {

		Object obj = new Object(); // Object() 객체 생성하여 obj에 저장

		System.out.println("\n  * obj = " + obj );  // obj 출력
		System.out.println("  * obj.toString() = " + obj.toString() );     

		System.out.println("  * obj.getClass() = " + obj.getClass() );  
		System.out.println("  * obj.hashCode() = " + obj.hashCode() );  

		System.out.println("  * obj.equals(obj) = " + obj.equals(obj) );  

		Object s ="홍길동";  // 문자열 "홍길동"을 업캐스팅하여  Object 객체 참조변수 s에 저장
		System.out.println("\n  * s.toString() = " + s.toString() );     

		System.out.println("  * s.getClass() = " + s.getClass() );  
		System.out.println("  * s.hashCode() = " + s.hashCode() );  

		System.out.println("  * s.equals(\"홍길동1\") = " + s.equals("홍길동1") );
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Object 클래스 객체와 String 클래스 객체를 Object 클래스의 
 *      객체 참조변수에 저장하고 Object 클래스의 메소드를 호출한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.   
 *           
 *   3) Object 객체의 toString() 반환값과 String 객체의 toString() 반환값이 다른 것을
 *      확인하고 그 이유가 무엇인지를 생각해보라.    
 *      
 * [ 실습 과제 ]
 * 
 *   1) 다음의 패키지에 클래스가 정의되어 있다. 각 클래스의 객체를 생성하고 
 *      이를 Object 클래스의 객체 참조변수에 저장하고 Object 클래스의 메소드를 호출하고 그 결과를 확인하라.
 *      (객체 생성성은 모두 매개변수 없는 객체 생성자 이용)
 *       
 *     (1) java.util 패키지의 Vector 클래스
 *     (2) java.awt 패키지의 Button 클래스
 *     (3) java.text 패키지의 SimpleDateFormat 클래스
 *     
 *   2) Person 클래스의 객체를 생성하고 이를 Object 클래스의 객체 참조변수에 저장하고 
 *      Object 클래스의 메소드를 호출하고 그 결과를 확인하라.
 *      
 *      Person 클래스를 사용하기 위해 Person 클래스를 이 패키지의 클래스로 복사하여야 한다.        
 */