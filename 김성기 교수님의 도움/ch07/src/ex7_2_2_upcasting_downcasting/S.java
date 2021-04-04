package ex7_2_2_upcasting_downcasting;

/**
 * [ C 클래스와 이의 하위 클래스 S 클래스] : 하위 클래스 객체가 상위 클래스의 객체 역할도 함을 보이는 예제
 * 
 */

// C 클래스는 Object 클래스의 하위 클래스
class C {  
	//	... C 클래스의 필드와 메소드 선언 ... 
}


// S 클래스는 C 클래스의 하위 클래스
class S extends C {  
	//  ... S 클래스의 필드와 메소드 선언 ...


	public static void main(String[] args) {
		S c;	      // C 클래스의 객체 참조변수 c 선언
		S s;          // S 클래스의 객체 참조변수 s 선언

		s = new S();  // S 클래스 객체 생성하여 S의 객체 참조변수 s에 저장
		c = ( S ) s;  // s 객체를 클래스 타입 C로 캐스트하여 c에 저장: 강제적 업캐스팅
		c = s;        // s 객체를 c에 직접 저장: 자동적 업캐스팅
		
		System.out.println("\n  * C class c = " + c);
		System.out.println("\n  * S class s = " + s);
		
	}
}
