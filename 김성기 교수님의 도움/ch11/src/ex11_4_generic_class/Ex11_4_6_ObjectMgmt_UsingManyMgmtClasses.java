package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ Ex11_4_6_ObjectMgmt_UsingManyMgmtClasses 클래스 ]: 
 *          제네릭 클래스의 필요성을 보이는 프로그램
 *          (특정 클래스의 객체들을 관리하는 여러 관리 클래스들을 작성함)
 * 
 *   o 객체들을 관리하는 3개의 클래스들
 *     - IntegerMgmt: Integer 객체들을 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스
 *     - StringMgmt: 문자열들 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스 
 *     - PersonMgmt: Person 객체들을 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스
 *  
 *   o 공통된 기능을 가지는 유사한 클래스들
 *      - 이들 3 클래스는 그 클래스의 객체2개까지를 저장하고 검색하는 공통되는 기능을 가짐
 *      - 필드와 메소드도 유사하게 작성되어 있음 
 *    
 *   o 유사한 클래스들의 통합의 필요성
 *     - Employee 클래스에 대해 저장하고 검색하려면 StoreEmployeeAtMost2t 클래스를 또다시 작성해야 함
 *     - 클래스별로 관리 클래스를 작성해야 하므로 많은 클래스를 작성해야 하는데, 이는 제네릭 클래스가 필요한 이유임
 *     - 매개변수 없는 여러 유사한 메소드를 매개변수 갖는 하나의 메소드로 통합하는 것과 동일한 원리임
 *     - 클래스를 매개변수로 가지도록 통합하여 여러 유사한 클래스들을 하나의 제네릭 클래스로 작성
 */

//IntegerMgmt: Integer 객체들을 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스
class IntegerMgmt {   
	String title;
	Vector<Integer> integers = new Vector<Integer>(); // Integer 클래스 객체들을 저장하는 Vector 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	IntegerMgmt(String title) {  
		this.title = title;
	}

	// 주어진 Integer 객체를 Vector 필드 integers에 저장하는 메소드
	void add(Integer i) {   
		integers.add(i);
	}

	// Vector 필드 integers에 저장된 i 위치의 객체를 반환하는 메소드
	Integer get(int i) {     
		return integers.get(i);
	}

	// title과 integers에 저장된 객체들을 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";     // 타이틀을 문자열에 추가
		for (Integer i: integers)   // integers의 각 원소  i에 대해
			s = s + "[ " + i.toString() + " ] ";  // i를 s에 추가
     
		return s;
	}

	// title과 integers에 저장된 객체들을 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

//StringMgmt: 문자열들 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스 
class StringMgmt {   
	String title;
	Vector<String> strings = new Vector<String>(); // String 클래스 객체들을 저장하는 Vector 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	StringMgmt(String title) {  
		this.title = title;
	}

	// 주어진 String 클래스의 객체를 Vector 필드 strings에 저장하는 메소드
	void add(String str) {   
		strings.add(str);
	}

	// Vector 필드 strings에 저장된 i 위치의 객체를 반환하는 메소드
	String get(int i) {     
		return strings.get(i);
	}

	// title과 strings에 저장된 객체들을 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";         // 타이틀을 문자열에 추가
		for (String str: strings)         //strings의 각 원소 str에 대해
			s = s + "[ " + str.toString() + " ] ";  // str을 s에 추가
		
		return s;
	}

	// title과 strings에 저장된 객체들을 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

// PersonMgmt: Person 객체들을 저장하고 추출하고 출력하는 관리 기능을 제공하는 클래스
class PersonMgmt {   
	String title;
	Vector<Person> persons = new Vector<Person>(); // Person 클래스 객체들을 저장하는 Vector 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	PersonMgmt(String title) {  
		this.title = title;
	}

	// 주어진 Person 클래스의 객체를 Vector 필드 persons에 저장하는 메소드
	void add(Person p) {   
		persons.add(p);
	}

	// Vector 필드 persons에 저장된 i 위치의 객체를 반환하는 메소드
	Person get(int i) {     
		return persons.get(i);
	}

	// title과 persons에 저장된 객체들을 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";           // 타이틀을 문자열에 추가
		for (Person p: persons)           // persons의 각 원소 p에 대해
			s = s + "[ " + p.toString() + " ] ";  // p의 문자열 구성을 [와 ] 사이에 추가

		return s;
	}

	// title과 persons에 저장된 객체들을 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_6_ObjectMgmt_UsingManyMgmtClasses {  
	public static void main(String[] args) {   
		// IntegerMgmt 객체 생성하여 ageMgmt가 참조하게 함 
		IntegerMgmt ageMgmt = new IntegerMgmt("나이 관리");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();        		
		
		// StringMgmt 객체 생성하여 nameMgmt가 참조하게 함 
		StringMgmt nameMgmt = new StringMgmt("이름 관리");  

		nameMgmt.add( "홍길동" ); 
		nameMgmt.add( "이몽룡" ); 
		nameMgmt.add( "김철수" ); 

		nameMgmt.output();        
		
		
		// PersonMgmt 객체 생성하여 persontMgmt가 참조하게 함 
		PersonMgmt personMgmt = new PersonMgmt("신상정보 관리");  

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
 *      이들 클래스를 하나의 클래스로 통합하면 예제 11-4-5의 제네릭 클래스가 된다. 
 *     
 *   2) 3개의 관리 클래스에 대해 다음을 정확히 파악하라.
 *      (1) 관리 클래스들의 기능적 공통점
 *      (2) 관리 클래스들의 필드와 메소드의 차이점
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
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
 *     - CharacterMgmt 클래스와 DoubleMgmt 클래스도 IntegerMgmt 클래스가 가진 필드와 메소드를 가지도록 작성하며 
 *       필드 이름이나 매개변수 이름은 필요시 달리하도록 한다.
 *      
 *   3) 매개변수가 없는 유사한 메소드를 작성할 때의 문제점과 여러 유사한 관리 클래스를 작성할 때의 문제점이 
 *      동일한 문제점인가를 생각해보라. 
 *      
 *   4) 3개의 관리 클래스에는 필드 이름, 메소드 매개변수 이름, 지역변수 이름 등이 서로 다른 것들이 몇 개 있다.
 *      이들을 모두 동일한 이름으로 변경하라(이는 이들 클래스들을 통합시키기 위해 필요한 사전 작업이다). 
 *      
 *      예를 들어, Vector 필드의 이름으로 integers, strings, persons 등 3개의 다른 이름이 사용되고 있다.
 *      이 필드 이름은 objects라는 동일한 이름을 변경하면 된다.
 *      
 *      그외, add() 메소드의 매개변수와 지역변수 이름으로 Integer i, String str, Person p 등이 있다.     
 */