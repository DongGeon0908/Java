package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ StoreAtMost2_UsingManyClasses 클래스 ]: 제네릭 클래스의 필요성 보이는 예제
 *       특정 클래스의 객체들 2개까지만 저장하고 검색하는 여러 클래스들 작성
 * 
 *   o 객체들을 2개까지만 저장하는 3개의 클래스들
 *     - StoreIntegerAtMost2: Integer 객체 2개까지만 저장하는 검색하는 기능 제공하는 클래스
 *     - StoreStringAtMost2: 문자열 2개까지만 저장하는 검색하는 기능 제공하는 클래스 
 *     - StorePersonAtMost2: Person 객체 2개까지만 저장하는 검색하는 기능 제공하는 클래스
 *  
 *   o 공통된 기능을 가지는 유사한 클래스들
 *     - 이들 3 클래스는 각 클래스의 객체 2개까지 저장하고 검색하는 공통되는 기능 가짐
 *     - 3개 이상이 저장되면 나중에 저장된 2개만 저장하고 앞의 것은 제거
 *     - 필드와 메소드도 유사하게 작성되어 있음 
 *    
 *   o 유사한 클래스들의 통합의 필요성
 *     - Employee 클래스에 대해 2개까지만 저장하고 검색하려면 StoreEmployeeAtMost2 클래스를 또다시 작성해야 함
 *     - 클래스별로 이러한 관리 클래스 작성해야 하므로 많은 클래스 작성해야 함 
 *         ==> 이는 제네릭 클래스가 필요한 이유임
 *         
 *     - 매개변수 없는 여러 유사한 메소드를 매개변수 갖는 하나의 메소드로 통합하는 것과 동일한 원리임
 *         ==> 매개변수 이용하여 여러 유사한 클래스들을 통합하면 하나의 제네릭 클래스로 작성됨
 */

// StoreIntegerAtMost2: Integer 객체 2개까지만 저장하고 검색하는 클래스
class StoreIntegerAtMost2 {   
	String title;
	Integer first, second; // Integer 클래스 객체 2개 저장하는 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	StoreIntegerAtMost2(String title) {  
		this.title = title;
	}

	// 주어진 Integer 객체 o를 저장하는 메소드 - 2개가 이미 저장되었으면 첫 번째 제거 
	void add(Integer o) {   
		if (first == null)        // 하나도 저장되지 않았으면 o를 first에 저장
			first = o;
		else if (second == null)  // 하나만 저장되었으면 o를 second에 저장
			second = o;
		else {                    // 이미 2개가 모두 저장되었다면 첫 번째 없애고 추가하여 저장 
			first = second;       //  second를 first에 저장
			second = o;           //  o를 second에 저장 
		}
	}

	// first에 저장된 객체 반환하는 메소드
	Integer getFirst() {     
		return first;
	}

	// second에 저장된 객체 반환하는 메소드
	Integer getSecond() {     
		return second;
	}
	
	// title과 first, second에 저장된 객체들 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";     // 타이틀을 문자열에 추가
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first를 문자열에 추가
		
		if (second != null) s = s + ", [" + second + "] "; // second를 문자열에 추가     
		
		return s;
	}

	// title과 first, second에 저장된 객체 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

//StoreStringAtMost2: 문자열 2개까지만 저장하고 검색하는 클래스
class StoreStringAtMost2 {   
	String title;
	String first, second; // String 클래스 객체 2개 저장하는 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	StoreStringAtMost2(String title) {  
		this.title = title;
	}

	// 주어진 String 객체 o를  저장하는 메소드 - 2개가 이미 저장되었으면 첫 번째 제거 
	void add(String o) {   
		if (first == null)        // 하나도 저장되지 않았으면 o를 first에 저장
			first = o;
		else if (second == null)  // 하나만 저장되었으면 o를 second에 저장
			second = o;
		else {                    // 2개가 모두 저장되었다면 첫번째 없애고 2개 저장 
			first = second;       //   두 번째를 first에 저장
			second = o;           //   o를 second에 저장 
		}
	}

	// first에 저장된 객체 반환하는 메소드
	String getFirst() {     
		return first;
	}

	// second에 저장된 객체 반환하는 메소드
	String getSecond() {     
		return second;
	}
	
	// title과 first, second에 저장된 객체들을 문자열로 구성하여 반환하는 메소드
	public String toString() {  
		String s = title +": ";     // 타이틀을 문자열에 추가
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first를 문자열에 추가
		
		if (second != null) s = s + ", [" + second + "] "; // second를 문자열에 추가    
        
		return s;
	}

	// title, first, second에 저장된 객체 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

// StorePersonAtMost2: Person 객체 2개까지만 저장하고 검색하는 클래스
class StorePersonAtMost2 {   
	String title;
	Person first, second;   // Person 클래스 객체 2개를 저장하는 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	StorePersonAtMost2(String title) {  
		this.title = title;
	}

	// 주어진 Person 객체 o를 저장하는 메소드 - 2개가 이미 저장되었으면 첫 번째 제거 
	void add(Person o) {   
		if (first == null)        // 하나도 저장되지 않았으면 o를 first에 저장
			first = o;
		else if (second == null)  // 하나만 저장되었으면 o를 second에 저장
			second = o;
		else {                    // 이미 2개가 모두 저장되었다면 첫 번째 없애고 2개 저장 
			first = second;       //  second를 first에 저장
			second = o;           //  o를 second에 저장 
		}
	}

	// first에 저장된 객체 반환하는 메소드
	Person getFirst() {     
		return first;
	}

	// second에 저장된 객체 반환하는 메소드
	Person getSecond() {     
		return second;
	}
	
	// title과 first, second에 저장된 객체들을 문자열로 구성하는 메소드
	public String toString() {  
		String s = title + ": ";     // 타이틀을 문자열에 추가
		if (first == null) s = s + "[]";
		else if (first != null) s = s + "[" + first + "]"; // first를 문자열에 추가
		
		if (second != null) s = s + ", [" + second + "] "; // second를 문자열에 추가   
        
		return s;
	}

	// title과 first, second에 저장된 객체들을 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_3_StoreAtMost2_UsingManyClasses {  
	public static void main(String[] args) {   
		// StoreIntegerAtMost2 객체를 생성하여 ageAtMost2가 참조하게 함 
		StoreIntegerAtMost2 ageAtMost2 = new StoreIntegerAtMost2("나이 저장");  

		ageAtMost2.add( 18 );                // 18을 ageAtMost2에 추가
		ageAtMost2.output();        
		
		
		// StoreStringAtMost2 객체를 생성하여 nameAtMost2가 참조하게 함 
		StoreStringAtMost2 nameAtMost2 = new StoreStringAtMost2("이름 저장");  

		nameAtMost2.add( "홍길동" );         // 이름 홍길동을 nameAtMost2에 추가
		nameAtMost2.add( "이몽룡" );         // 이름 이몽룡을 nameAtMost2에 추가
		nameAtMost2.output();        
		
		
		// StorePersonAtMost2 객체를 생성하여 personAtMost2가 참조하게 함 
		StorePersonAtMost2 personAtMost2 = new StorePersonAtMost2("신상정보 저장");  

		personAtMost2.add( new Person("홍길동", 18) ); // 홍길동 객체를 personMgmt에 추가
		personAtMost2.add( new Person("이몽룡", 16) ); // 이몽룡 객체를 personMgmt에 추가
		personAtMost2.add( new Person("김철수", 23) ); // 김철수 객체를 personMgmt에 추가 
		personAtMost2.output();  
	}
} 

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 2개까지의 객체 저장하는 3개 클래스 별도로 작성하고
 *      main() 메소드에서 이들 클래스 객체 생성하여 ageAtMost2, nameAtMost2, 
 *      person AtMost2가 참조하게 하며, 1개, 2개, 3개 객체를 각각 저장한다.
 *     
 *   2) 3개의 유사한 클래스에 대해 다음을 정확히 파악하라.
 *      (1) 유사한 클래스들의 기능적 공통점
 *      (2) 유사한 클래스들의 코드 차이점
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) Character 객체를 2개까지 저장, 추출, 출력하는 기능을 제공하는 클래스인 
 *      StoreCharacterAtMost2를 작성하여 이 클래스의 객체를 생성하여 '홍', '이', '박'을 추가하고 출력하라.
 *       
 *   2) Double 객체를 2개까지 저장, 추출, 출력하는 기능을 제공하는 클래스인 
 *      StoreDoubleAtMost2를 작성하고  이 클래스의 객체를 생성하여 177.7, 162.0, 172.2를 추가하고 출력하라
 *      
 *   % 참고사항 % 
 *      StoreCharacterAtMost2 클래스와StoreDoubleAtMost2 클래스도 
 *      StoreIntegerAtMost2 클래스가 가진 필드와 메소드를 가지도록 작성하며 
 *      필드 이름이나 변수 이름을 동일하게 하도록 한다.
 *      
 *   3) 매개변수가 없는 유사한 메소드를 작성할 때의 문제점과 여러 유사한 클래스를 작성할 때의 문제점이 
 *      동일한지 생각해보라.     
 */