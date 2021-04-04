package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ Ex11_4_7_ObjectMgmt_UsingSameVariables 클래스 ]: 
 *       제네릭 클래스의 필요성을 다시 한번 보이는 예제
 * 
 *   o 객체들을 관리하는 3개의 클래스들
 *     - IntegerMgmt: Integer 객체들 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스
 *     - StringMgmt: 문자열들 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스 
 *     - PersonMgmt: Person 객체들 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스
 *  
 *   o 공통된 기능과 동일한 변수와 메소드 가지는 유사한 클래스들
 *      - 이들 3 클래스는 그 클래스의 객체들 저장하고 추출하고 출력하는 공통되는 기능을 가짐
 *      - 타입을 제외하고 필드 이름과 메소드가 모두 동일하게 재작성됨  
 *          ==> 하나의 제네릭 클래스로 쉽게 통합될 수 있음
 *       
 *   o 유사한 클래스들의 통합 필요성
 *     - Employee 클래스의 객체 관리하려면 EmployeeMgmt 클래스를 또다시 작성해야 함
 *     - 클래스별로 관리 클래스를 작성해야 하므로 많은 클래스를 작성해야 하며, 이는 제네릭 클래스가 필요한 이유
 *    - 매개변수 없는 여러 유사한 메소드를 매개변수 갖는 하나의 메소드로 통합하는 것과 동일한 원리
 *     - 클래스를 매개변수로 가지도록 통합하여 하나의 제네릭 클래스로 작성
 */

class Mgmts {
	// IntegerMgmt: Integer 객체들 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스
	static class IntegerMgmt {   
		String title;
		Vector<Integer> objects = new Vector<Integer>(); // Integer 클래스 객체들을 저장하는 Vector 필드 

		// 주어진 title을 필드 title에 저장하는 객체 생성자
		IntegerMgmt(String title) {  
			this.title = title;
		}

		// 주어진 Integer 객체를 Vector 필드 objects에 저장하는 메소드
		void add(Integer element) {   
			objects.add(element);
		}

		// Vector 필드 objects에 저장된 i 위치의 객체 반환하는 메소드
		Integer get(int i) {     
			return objects.get(i);
		}

		// title과 objects에 저장된 객체들을 문자열로 구성하는 메소드
		public String toString() {  
			String s = title +": ";    // 타이틀을 문자열에 추가
			for (Integer element: objects)   // objects의 각 원소 element에 대해
				s = s + "[ " + element.toString() + " ] ";  //element의 문자열 구성을 [와 ] 사이에 구성

			return s;
		}

		// title과 objects에 저장된 객체들 출력하는 메소드
		void output() {  
			System.out.println(this.toString());
		}
	}

	//StringMgmt: 문자열들 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스 
	static class StringMgmt {   
		String title;
		Vector<String> objects = new Vector<String>(); // String 클래스 객체들을 저장하는 Vector 필드 

		// 주어진 title을 필드 title에 저장하는 객체 생성자
		StringMgmt(String title) {  
			this.title = title;
		}

		// 주어진 String 클래스의 객체를 Vector 필드 objects에 저장하는 메소드
		void add(String element) {   
			objects.add(element);
		}

		// Vector 필드 objects에 저장된 i 위치의 객체 반환하는 메소드
		String get(int i) {     
			return objects.get(i);
		}

		// title과 objects에 저장된 객체들을 문자열로 구성하는 메소드
		public String toString() {  
			String s = title +": ";         // 타이틀을 문자열에 추가
			for (String element: objects)         // objects의 각 원소 element에 대해
				s = s + "[ " + element.toString() + " ] ";  // element의 문자열 구성을 [와 ] 사이에 구성

			return s;
		}

		// title과 objects에 저장된 객체들을 출력하는 메소드
		void output() {  
			System.out.println(this.toString());
		}
	}

	// PersonMgmt: Person 객체들을 저장하고 추출하고 출력하는 관리 기능 제공하는 클래스
	static class PersonMgmt {   
		String title;
		Vector<Person> objects = new Vector<Person>(); // Person 클래스 객체들 저장하는 Vector 필드 

		// 주어진 title을 필드 title에 저장하는 객체 생성자
		PersonMgmt(String title) {  
			this.title = title;
		}

		// 주어진 Person 클래스의 객체를 Vector 필드 objects에 저장하는 메소드
		void add(Person element) {   
			objects.add(element);
		}

		// Vector 필드 objects에 저장된 i 위치의 객체 반환하는 메소드
		Person get(int i) {     
			return objects.get(i);
		}

		// title과 objects에 저장된 객체들을 문자열로 구성하는 메소드
		public String toString() {  
			String s = title +": ";              // 타이틀을 문자열에 추가
			for (Person element: objects)           // objects의 각 원소 element에 대해
				s = s + "[ " + element.toString() + " ] ";  // element의 문자열 구성을 [와 ] 사이에 구성

			return s;
		}

		// title과 objects에 저장된 객체들을 출력하는 메소드
		void output() {  
			System.out.println(this.toString());
		}
	}
}
	
class Ex11_4_7_ObjectMgmt_UsingSameVariables {  
	public static void main(String[] args) {   
		// IntegerMgmt 객체 생성하여 ageMgmt가 참조하게 함 
		Mgmts.IntegerMgmt ageMgmt = new Mgmts.IntegerMgmt("나이 관리");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();        


		// StringMgmt 객체 생성하여 nameMgmt가 참조하게 함 
		Mgmts.StringMgmt nameMgmt = new Mgmts.StringMgmt("이름 관리");  

		nameMgmt.add( "홍길동" ); 
		nameMgmt.add( "이몽룡" ); 
		nameMgmt.add( "김철수" ); 

		nameMgmt.output();        


		// PersonMgmt 객체 생성하여 persontMgmt가 참조하게 함 
		Mgmts.PersonMgmt personMgmt = new Mgmts.PersonMgmt("신상정보 관리");  

		personMgmt.add( new Person("홍길동", 18) ); 
		personMgmt.add( new Person("이몽룡", 16) ); 
		personMgmt.add( new Person("김철수", 23) ); 

		personMgmt.output();  
	}
} 


/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 3개의 관리 클래스를 별도로 작성하고 main() 메소드에서 관리 클래스 객체를 생성하고
 *      클래스별 객체를 관리 객체에 추가하고 출력한다.
 *      
 *      3개의 클래스는 타입명만 다르며 모든 변수와 메소드  이름이 동일하므로 바로 제네릭 클래스로 변환될 수 있다.
 *     
 *   2) 3개의 관리 클래스에 대해 다음을 정확히 파악하라.
 *      (1) 관리 클래스들의 기능적인 공통점
 *      (2) 관리 클래스들의 필드와 메소드에서의 차이점
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *  
 * [ 참고사항 ]
 *  
 *   o 이 프로그램에서 IntegerMgmt, StringMgmt, PersonMgmt 클래스는 
 *     예제 11-4-6의 클래스 이름이 동일하므로 사용할 수 없는 이름이다. 
 *     
 *     왜냐하면 하나의 패키지에서 클래스 이름은 서로 달라야 하기 때문이다.
 *     
 *   o 그러므로 이 프로그램에서의 IntegerMgmt, StringMgmt, PersonMgmt 클래스는 
 *     외부 클래스(outer class)인 Mgmt 클래스의 내부 클래스(inner class)로 작성되어 있다.
 *     
 *   o 내부 클래스는 그 클래스를 포함하는 외부 클래스의 내부에서 작성되는 클래스로서,
 *     내부 클래스는 작성된 클래스 내부에서만 사용되거나  << 외부클래스.내부클래스 >> 의 형식으로 사용된다.
 *     
 *   o main() 메소드의 << Mgmts.IntegerMgmt ageMgmt = new Mgmts.IntegerMgmt("나이 관리"); >>이
 *     << 외부클래스.내부클래스 >> 의 형식으로 사용된 예이다.
 *     
 *   o 내부 클래스는 GUI 프로그래밍에서 이벤트 리스너 클래스 작성 시 다시 소개되며,
 *     내부 클래스에 대해 스스로 학습하기 바란다.
 *     
 *     
 * [ 실습 과제 ]
 * 
 *   1) Character 객체를 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스인 CharacterMgmt를 작성하여
 *      이 클래스의 객체를 생성하여 '홍', '이', '박'을 저장하고 출력하라.
 *       
 *   2) Double 객체를 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스인 DoubleMgmt를 작성하고
 *      이 클래스의 객체를 생성하여 177.7, 162.0, 172.2를 저장하고 출력하라
 *      
 *   ※ 참고사항: 
 *     CharacterMgmt 클래스와 DoubleMgmt 클래스도 IntegerMgmt 클래스가 가진 필드와 메소드를 가지도록 작성하며 
 *     필드 이름이나 매개변수 이름은  IntegerMgmt 클래스와 동일하게 작성한다.
 *      
 *   3) 매개변수가 없는 유사한 메소드를 작성할 때의 문제점과 여러 유사한 관리 클래스를 작성할 때의 문제점이 
 *      동일한 문제점인가를 생각해보라.      
 */