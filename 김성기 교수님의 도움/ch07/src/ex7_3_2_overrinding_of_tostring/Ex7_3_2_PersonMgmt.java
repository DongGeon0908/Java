package ex7_3_2_overrinding_of_tostring;

/**
 * [ Person, Student, PersonMgmt 클래스 ]: toString() 메소드 오버라이딩을 보여주는  예제
 * 
 *   o 메소드 오버라이딩
 *     - 하위 클래스를 선언할 때 상위 클래스의 메소드를 대체할 수 있는 메소드를 재정의하는 것
 *     - 상위 클래스에 선언된 메소드와 이름, 매개변수, 반환 타입이 모두 동일하면서 
 *       메소드의 구현이 다른 메소드 선언 
 *     - 메소드 오버라이딩 기능: 상위 클래스의 메소드 처리내용을 하위 클래스의 상황에 맞도록 변경할 수 있게 함
 *    
 *   o Object 클래스의 toString() 메소드
 *     - Java에서 오버라이딩되는 가장 대표적인 메소드
 *     - 모든 클래스는 toString() 메소드를 오버라이딩하도록 권장함
 *    
 *   o toString() 메소드 주요사항
 *     - 메소드 시그니처: public String toString() 
 *     - 메소드 기능: 객체 정보를 문자열로 구성하여 반환하는 메소드
 *     - 모든 클래스는 Object 클래스의 하위 클래스이므로 모든 객체는 toString() 메소드  호출할 수 있음
 *     - Object 클래스의 toString() 메소드를 하위 클래스에서 오버라이딩하지 않으면  toString() 메소드는 
 *       객체의 클래스이름, @ 문자, 16진수 해시코드를 문자열로 구성하여 결과 반환
 *      
 *     - System.out.print() 또는 System.out.println() 메소드에서 객체  출력하면  
 *       객체의 toString() 결과 출력됨
 *     - 모든 클래스에서는 toString() 메소드를 클래스의 상황에 적합하게 오버라이딩하는  것 권장함
 *     - 오버라이딩할 때 메소드 시그니처는 반드시 << public String toString() >>으로  작성해야함
 */

// Person 클래스
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
  
	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Object 클래스의 메소드를 오버라이딩시킨 것임
	public String toString() {
		return "이름:" + this.name + ", 나이: " + this.age 
				+ ", 현위치: " + this.currentLocation;  
	}

	// 객체의 필드들 출력하는 메소드
	void output() {
		System.out.println("\n  * 사람 - " + this.toString());
	}
}

// Person 클래스의 하위 클래스인 Student의 선언
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 매개변수 없는 객체 생성자
	Student() {
	}

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

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩시킨 것임
	public String toString() {
		return  "이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade;  
	}

	// 객체의 필드들 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩 시킨 것임
	void output() {
		System.out.println("\n  * 학생 - " + this.toString());
	}

}

class Ex7_3_2_PersonMgmt {
	public static void main(String[] args) {

		// 18세의 홍길동
		Person p1 = new Person("홍길동", 18); 
		p1.goTo("금강산");

		// 김영희는 11살의 서울초등학교 4학년 학생
		Student s1 = new Student("김영희", 11, "서울초등학교", 4);
		s1.goToSchool();

		// 김철수는 21세의 한국대학교 2학년 학생
		Person p2 = new Student("김철수", 21, "한국대학교", 2);   // 업캐스팅하여 Person 변수에 저장
		p2.goTo ("도서관");

		// 홍길동, 김영희, 김철수의 신상정보를 output() 메소드로 출력
		System.out.println("\n\n  ** 홍길동, 김영희, 김철수의 신상정보를 output() 메소드로 출력 **");
		p1.output();   // Person 클래스의 output() 메소드 호출
		s1.output();   // Student 클래스의 output() 메소드 호출
		p2.output();   // Person 클래스의 output() 메소드 호출(?)       

		System.out.println("\n\n  ** 홍길동, 김영희, 김철수의 신상정보를 System.out.println() 메소드로 출력 **");
		System.out.println("\n  * 홍길동 - " + p1); 
		System.out.println("\n  * 김영희 - " + s1); 
		System.out.println("\n  * 김철수 - " + p2); 
		
		System.out.println("\n\n  ** 홍길동, 김영희, 김철수의 신상정보를 toString() 메소드로 출력 **");
		System.out.println("\n  * 홍길동 - " + p1.toString()); 
		System.out.println("\n  * 김영희 - " + s1.toString()); 
		System.out.println("\n  * 김철수 - " + p2.toString()); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 필드 값을 문자열로 반환하는 toString() 메소드가 Person 클래스와 Student 클래스에 
 *      모두 작성되었음을 확인하라.
 *      
 *   2) output() 메소드는  toString() 메소드를 호출하여 필드들 출력함을 확인하라. 
 *      
 *   3) << System.out.println("\n  * 김영희 - " + s1); >>에서 s1을 println()에서 출력하면 
 *      toString() 메소드의 결과가 출력됨을 확인하라.
 *           
 *   4) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   5) toString() 메소드를 제거한 후 프로그램의 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o Student 클래스의 하위 클래스인 UniversityStudent 클래스의  toString() 메소드를 오버라이딩하여
 *     작성하고 output() 메소드에서 ToString()을 호출하여 객체 출력하라.
 *     
 *      main()에서   UniversityStudent 클래스 객체를 본인으로 생성하고 output() 메소드로 출력하여 결과를 확인하라.
 */
