package ex7_3_1_method_overriding;

/**
 * [ ex7_3_1_MethodOverriding 패키지 ]: 메소드 오버라이딩을 보여주는  예제
 *  
 *   o 메소드 오버라이딩
 *     - 하위 클래스를 선언할 때 상위 클래스의 메소드를 대체할 수 있는 메소드를 재정의하는 것
 *     - 상위 클래스에 선언된 메소드와 이름, 매개변수, 반환 타입이 모두 동일하면서 
 *       메소드의 구현이 다른 메소드 선언 
 *     - 메소드 오버라이딩 기능: 상위 클래스의 메소드 처리내용을 하위 클래스의 상황에 맞도록 변경할 수 있게 함
 *    
 *   o 메소드 오버라이딩의 예: Person 클래스의 output() 메소드
 *     - name, age, currentLocation 필드를 출력하는 메소드
 *     - Student 클래스에서 이를 상속받아 그대로 사용하면 Student의 고유 필드인 schoolname과 grade 필드를 
 *       출력할 수 없게 됨
 *     - Student 클래스의 모든 필드를 출력하기 위해서는 상위 클래스인 Person의 output() 메소드로는 충분하지 않음
 *     - schoolname과 grade 필드를 추가로 출력하기 위해 Student 클래스에서 output() 메소드를 재작성하여야 함
 */

// Person 클래스: 필드 name, age, currentLocation과 메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;    		// 이름
	int    age;				// 나이
	String currentLocation;	// 현위치

	// 매개변수 없는 객체 생성자
	Person() {
	}

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}
	
	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}

	// 객체의 필드들 출력하는 메소드
	void output() {
		System.out.println("\n  * 사람 - 이름: " + this.name + ", 나이: " + this.age 
				+ ", 현위치: " + this.currentLocation);
	}
}

// Person 클래스의 하위 클래스인 Student의 선언
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age, String schoolname, int grade) {
		this.name = name;  this.age = age; 
		this.schoolname = schoolname;       this.grade = grade;
	}
	
	// goToSchool(): 학생이 등교하는 것을 나타내는 메소드
	//    currentLocation을 schoolname으로 변경하기 위해 goTo() 메소드 호출
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// 객체의 필드들 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩시킨 것임
	void output() {
		System.out.println("\n  * 학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade);
	}
}

class Ex7_3_1_PersonMgmt {
	public static void main(String[] args) {

		// 18세의 홍길동
		Person p1 = new Person("홍길동", 18); 
		p1.goTo("금강산");

		// 김영희는 11살의 서울초등학교 4학년 학생
		Student s1 = new Student("김영희", 11, "서울초등학교", 4);
		s1.goToSchool();

		// 김철수는 21세의 한국대학교 2학년 학생
		Person p2= new Student("김철수", 21, "한국대학교", 2); // 업캐스팅하여 Person 변수에 저장
		p2.goTo ("도서관");

		// 홍길동, 김영희, 김철수의 신상정보를 output() 메소드로 출력
		p1.output();   // Person 클래스의 output() 메소드 호출
		s1.output();   // Student 클래스의 output() 메소드 호출

		p2.output();   // Person 클래스의 output() 메소드 호출(실제 수행되는 메소드는 ?)       

		System.out.println("\n  * 홍길동 - " + p1); // 홍길동, 김영희, 김철수 객체를  system.out.println 메소드로 출력
		System.out.println("\n  * 김영희 - " + s1); 
		System.out.println("\n  * 김철수 - " + p2); 
   }
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 동일한 output() 메소드가 Person 클래스와 Student 클래스에 
 *      모두 작성되었음을 확인하라.
 *      
 *   2) << Person p2 = new Student("김철수", 23, "한국대학교", 2); >>에서
 *      p2에는 Student 객체가 업캐스팅되어 저장되어 있다.
 *       
 *      이 경우 오버라이딩 메소드 p2.output()의 호출 결과가 person의 output()인지 Student의
 *      output()인지 수행결과로 확인할 수 있다
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *      오버라이딩 메소드 p2.output()의 호출로 수행되는 메소드가 Student의 output() 메소드임을 반드시 확인하라.
 * 
 */
