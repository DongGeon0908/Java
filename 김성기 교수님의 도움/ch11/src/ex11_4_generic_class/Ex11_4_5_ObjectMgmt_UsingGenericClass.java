package ex11_4_generic_class;

import java.util.Vector;

/**
 * [ ObjectMgmt_UsingGenericClass 클래스 ]: 
 *        Vector 클래스를 사용하여 여러 Person 객체들을 저장하고 출력하는 작업을 보이는 예
 * 
 *   o 제네릭 클래스
 *     - 클래스 선언에서 타입 매개변수를 포함되는 클래스임
 *     - << class 클래스이름<타입 매개변수> { ... } >>에서 클래스 이름 다음의 <와 > 사이에 타입 매개변수가 표시
 *     - 클래스 선언에서 타입 매개변수 이름만 주어지고 타입 매개변수의 값이 주어지지 않으므로 클래스가 완전히 정의되지 않음
 *     - 클래스 사용할 때 타입 매개변수의 값으로 클래스가 주어지므로 완전한 클래스로 형성
 *         
 *   o 타입 매개변수
 *     - Java의 타입에 해당되는 클래스와 인터페이스를 값으로 갖는 매개변수
 *    
 *   o 형식 타입 매개변수(formal type parameter)
 *     - 제네릭 클래스 선언 시 주어지는 타입 매개변수
 *     - 형식 타입 매개변수 관례: 하나의 문자로 사용
 *         E(컬렉션 원소 타입)         N(숫자 타입), 
 *         K(키값을 나타내는 타입)      V(키값에 대응되는 값 타입)
 *         T(일반적 타입)             S(2번째 타입 매개변수)
 *          
 *     - class Mgmt<T> {  // <T>는 형식 타입 매개변수
 *          ...  // 형식 타입매개변수 T를 이용하여 클래스 선언
 *       }
 *         
 *   o 실 타입 매개변수(real type parameter)
 *     - 객체 참조변수 선언, 객체 생성자 호출 등 제네릭 클래스 사용할 때 주어지는 구체적인 클래스
 *     - <와 > 사이에 구체적인 클래스 또는 인터페이스가 주어짐   
 *    
 *     - Mgmt<Person> persons = Mgmt<Person>("신상정보 관리");  // <Person>은 실 타입매개변수를 나타냄
 */

// E 클래스의 객체들의 저장, 추출, 출력 등 관리기능 제공하는 제네릭 클래스
class Mgmt<E> {   
	String title;
	Vector<E> objects = new Vector<E>(); // E 클래스 객체들을 저장하는 Vector 필드 

	// 주어진 title을 필드 title에 저장하는 객체 생성자
	Mgmt(String title) {  
		this.title = title;
	}

	// 주어진 E 클래스의 객체를 Vector 필드 objects에 저장하는 메소드
	void add(E element) {   
		objects.add(element);
	}

	// Vector 필드 objects에 저장된 i 위치의 객체 반환하는 메소드
	E get(int i) {     
		return objects.get(i);
	}

	// title과 objects에 저장된 객체들을 문자열로 구성하는 메소드
	public String toString() {  
		String s = title +": ";                         // 타이틀을 문자열에 추가
		for (E element: objects)                        // objects의 element에 대해
			s = s + "[ " + element.toString() + " ] ";  //    element의 문자열 구성을 [와 ] 사이에 추가

		return s;
	}

	// title과 objects에 저장된 객체들 출력하는 메소드
	void output() {  
		System.out.println(this.toString());
	}
}

class Ex11_4_5_ObjectMgmt_UsingGenericClass {
	public static void main(String[] args) {   
		// Mgmt<Student> 객체 생성하여 students가 참조하게 함 
		Mgmt<Integer> ageMgmt = new Mgmt<Integer>("나이 관리");  

		ageMgmt.add( 18 ); 
		ageMgmt.add( 16 ); 
		ageMgmt.add( 23 ); 

		ageMgmt.output();    
		
		// Mgmt<String> 객체 생성하여 names가 참조하게 함 
		Mgmt<String> nameMgmt = new Mgmt<String>("이름 관리");  

		nameMgmt.add( "홍길동" ); 
		nameMgmt.add( "이몽룡" ); 
		nameMgmt.add( "김철수" ); 

		nameMgmt.output();      
		
		// Mgmt<Person> 객체 생성하여 persons가 참조하게 함 
		Mgmt<Person> personMgmt = new Mgmt<Person>("신상정보 관리");  

		personMgmt.add( new Person("홍길동", 18) ); 
		personMgmt.add( new Person("이몽룡", 16) );
		personMgmt.add( new Person("김철수", 23) ); 

		personMgmt.output();   
	}
}    

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) Mgmt<E> 클래스는 여러 원소들을 저장하고 출력하는 제네릭 클래스이다.
 *      - 클래스 이름 Mgmt<E>에 타입 매개변수 <E>가 표기되어 임의의 클래스의 객체를 관리하는 클래스임을 나타낸다.
 *      
 *      - 이 클래스를 사용할 때에는 항상 관리 대상 클래스를 나타내는 특정 클래스가 다음과 같이 주어져야 한다.
 *      
 *        참조변수 선언 시: Mgmt<Person> persons 
 *        객체 생성 시: new Mgmt<Person>("신상정보 관리") 
 *              
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) 한국인 성을 저장하고 추출하고 출력하는 관리 기능을 제공하는 객체를 생성하여 "홍", "이", "박", "사공"을 저장하고 출력하라.
 *       
 *   2) Double 객체를 저장하고 추출하고 출력하는 관리 기능을 제공하는 객체를 생성하여 177.7, 162.0, 172.2를 저장하고 출력하라
 *      
 *   % 참고사항 % 
 *      여기에서는 별도의 클래스를 생성할 필요가 없으며, main() 메소드에 필요한 문장을 작성하면 된다.
 *      
 *   3) 제네릭 클래스는 여러 클래스에 대해 적용 가능한 클래스이므로 프로그래밍 과정은 복잡하지만 큰 이점을 갖는다. 
 *      그 이점이 무엇인가를 다시 생각해보라.   
 */
