package ex11_4_generic_class;

/**
 * [ StoreAtMost2_UsingGenericClass ]: 제네릭 클래스의 필요성 보이는 예제
 *       임의 클래스의 객체들을 2개까지만 저장하고 검색하는 제네릭 클래스 작성
 * 
 *   o 제네릭 클래스
 *     - 클래스 선언에서 타입 매개변수를 포함되는 클래스
 *     - << class 클래스이름< 타입_매개변수 > { ...  } >>에서 클래스 이름 다음의 <와 > 사이에 타입 매개변수 표시
 *     - 클래스 선언에서는 타입 매개변수 이름만 주어지고 타입 매개변수의 값이 주어지지 않으므로 클래스가 완전히 정의되지 않음
 *     - 클래스 사용할 때 타입 매개변수의 값으로 클래스가 주어지므로 완전한 클래스로 형성
 *         
 *   o 타입 매개변수
 *     - Java의 타입에 해당되는 클래스와 인터페이스를 값으로 갖는 매개변수
 */

// StoreAtMost2<T>: 클래스 T의 객체 2개까지만 저장하고 검색하는 기능을 제공하는 제네릭 클래스
class StoreAtMost2<T> {   
	String title;
	T first, second; // T 클래스 객체 2개를 저장하는 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	StoreAtMost2(String title) {  
		this.title = title;
	}

	// 주어진 T 객체 o를 저장하는 메소드 - 2개가 이미 저장되었으면 첫 번째 제거 
	void add(T o) {   
		if (first == null)  // 하나도 저장되지 않았으면 o를 first에 저장
			first = o;
		else if (second == null)  // 하나만o를 second에 저장
			second = o;
		else {              // 이미 2개가 모두 저장되었다면 첫 번째 없애고 2개 저장 
			first = second; //  second를 first에 저장
			second = o;     //  o를 second에 저장 
		}
	}

	// first에 저장된 객체를 반환하는 메소드
	T getFirst() {     
		return first;
	}

	// second에 저장된 객체를 반환하는 메소드
	T getSecond() {     
		return second;
	}
	
	// title과 first, second에 저장된 객체들 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";     // 타이틀을 문자열에 추가
		if (first != null) s = s + "[" + first + "]";      // first를 문자열에 추가
		
		if (second != null) s = s + ", [" + second + "] "; // second를 문자열에 추가      
		
		return s;
	}

	// title과 first, second에 저장된 객체들 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_4_StoreAtMost2_UsingGenericClass {  
	public static void main(String[] args) {   
		
		// StoreAtMost2<Integer> 객체 생성하여 ageAtMost2가 참조하게 함 
		StoreAtMost2<Integer> ageAtMost2 = new StoreAtMost2<Integer>("나이  저장");  

		ageAtMost2.add( 18 ); // 18을 ageAtMost2에 추가
		ageAtMost2.output();        

		// StoreAtMost2<String> 객체 생성하여 nameAtMost2가 참조하게 함 
		StoreAtMost2<String> nameAtMost2 = new StoreAtMost2<String>("이름 저장");  

		nameAtMost2.add( "홍길동" ); // 이름 홍길동을 nameAtMost2에 추가
		nameAtMost2.add( "이몽룡" ); // 이름 이몽룡을 nameAtMost2에 추가
		nameAtMost2.output();        

		// StoreAtMost2<Person> 객체 생성하여 personAtMost2가 참조하게 함 
		StoreAtMost2<Person> personAtMost2 = new StoreAtMost2<Person>("신상정보 저장");  

		personAtMost2.add( new Person("홍길동", 18) ); // 이몽룡 객체를 추가
		personAtMost2.add( new Person("이몽룡", 16) ); // 이몽룡 객체를 추가
		personAtMost2.add( new Person("김철수", 23) ); // 김철수 객체를 추가 
		personAtMost2.output();  
		
	}
} 

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 예제 11-4-3의 2개까지 객체를 저장하는 3개의 유사한 클래스를 
 *      하나의 제네릭 클래스 StoreAtMost2<T>로 작성하고 
 *      main() 메소드에서 3개의 객체를 생성하여 ageAtMost2, nameAtMost2, PersonAtMost2가
 *      참조하게 한다. 
 *      
 *      객체 참조변수 선언과 객체 생성 시에는 <와 > 사이에 저장할 원소의 타입을 명시한다.
 *     
 *   2) 작성된 제네릭 클래스에 대해 다음을 개략적으로 파악하라.
 *      (1) 타입 매개변수를 이용하여 범용적인 클래스 정의하는 방법
 *      (2) 정의된 제네릭 클래스를 사용하는 방법
 *          . 제네릭 클래스의 참조변수 선언 방법
 *          . 제네릭 클래스의 객체 생성 방법
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) Character 객체를 2개까지 저장하고 출력하기 위하여 필요한 코드를 main() 메소드에 작성하라. 
 *      '홍', '이', '박'을   추가하고 출력된 결과를 확인하라.
 *       
 *   2) Double 객체를 2개까지 저장하고 출력하기 위하여 필요한 코드를 main() 메소드에 작성하라. 
 *       177.7, 162.0, 172.2를 추가하고 출력된 결과를 확인하라.
 *       
 *   3) nameAtMost2 객체에 Person 객체를 저장하면 어떻게 되는가를 확인하라.
 *      또한 personAtMost2 객체에 문자열을 저장하면 어떻게 되는가를 확인하라.
 *      
 *      
 * [ 참고사항  ] 
 *    
 *    o 여기에서는 제네릭 클래스를 작성하였으므로 별도의 클래스를 작성할 필요는 없다.     
 */