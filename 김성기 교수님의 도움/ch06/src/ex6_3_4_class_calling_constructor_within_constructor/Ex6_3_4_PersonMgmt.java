// 여기의 클래스들은 ex6_3_4_class_calling_constructor_within_constructor 패키지에 포함되는 클래스임을 나타냄
package ex6_3_4_class_calling_constructor_within_constructor;

/**
 * [ Person, PersonMgmt 클래스 ] :
 *       객체 생성자 내에서 객체 생성자 호출을 보여주는 프로그램
 *         
 *   o 클래스 유형 3: 객체 생성자 갖는 클래스
 *     - 객체 생성자: 객체 생성하며 수행되는 특별한 메소드
 *     - 객체 생성과 객체 필드 값 저장이 하나의 문장으로 이루어지므로 
 *       프로그램이 더욱 간결해짐 
 *     
 *   o 객체 생성자 내에서 다른 객체 생성자 호출
 *     - 객체 생성자 내에서 객체 생성자를 호출할 수 있음
 *     - 객체 생성자 내에서 객체 생성자를 호출할 때 new 연산자를 명시하지 않음
 *     - 객체 생성자 내에서 같은 클래스의 다른 객체 생성자를 호출할 때 << this(...); >>로 호출함
 */
 
class Person {
	String 	name;    	      // 이름을 저장할 필드
	int    	  age;		      // 나이를 저장할 필드
	String 	currentLocation;  // 현위치를 저장할 필드

	// 이름이 매개변수로 주어지면 이를 필드 name에 저장하는 객체 생성자
	Person(String name) {
		this.name = name;  	// 매개변수 name을 this 객체의 name 필드에 저장
	}

	// 이름, 나이가 매개변수로 주어지면 이를 필드 name, age에 저장하는 객체 생성자
	Person(String name, int age) {
		this(name);      // 이름을 저장하는 객체 생성자를 호출하여 name 저장
		this.age = age;  // 매개변수 age를 this 객체의 age 필드에 저장
	}

	// 이름, 나이, 장소가 매개변수로 주어지면 이를 해당 필드에 저장하는 객체 생성자
	Person(String name, int age, String location) {
		this(name, age);   // 이름과 나이를 저장하는 객체 생성자를 호출
		this.currentLocation = location; // location을 currentLocation 필드에 저장
	}
}

class Ex6_3_4_PersonMgmt {
	public static void main(String[] args) {
		// 이름을 저장하는 객체 생성자 호출하여 Person 객체 생성
		Person p1 = new Person("홍길동");

		// 이름, 나이를 저장하는 객체 생성자 호출하여 Person 객체 생성
		Person p2 = new Person("이몽룡", 20);

		// 이름, 나이, 현위치를 저장하는 객체 생성자 호출하여 Person 객체 생성
		Person p3 = new Person("김철수", 23, "교보문고");      

		System.out.println("\n  * p1 객체 - 이름: " + p1.name + ", 나이: " + p1.age
				+ ", 현위치: " + p1.currentLocation );
		System.out.println("\n  * p2 객체 - 이름: " + p2.name + ", 나이: " + p2.age
				+ ", 현위치: " + p2.currentLocation );
		System.out.println("\n  * p3 객체 - 이름: " + p3.name + ", 나이: " + p3.age
				+ ", 현위치: " + p3.currentLocation );
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램의 객체 생성자에서 객체 생성자 호출을 살펴보라.
 *   
 *      - 이 때, 객체 생성자 이름이 클래스 이름이 아니라 this임을 확인하라.
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.  
 *   
 *  
 * [ 실습과제 ]
 * 
 *   o 이름, 현위치가 주어지면 이를 필드에 초기화하는 Person 클래스의 객체 생성자를 작성하라.
 *     이 때, 이미 생성된 객체 생성자를 반드시 호출해야 한다.
 */
