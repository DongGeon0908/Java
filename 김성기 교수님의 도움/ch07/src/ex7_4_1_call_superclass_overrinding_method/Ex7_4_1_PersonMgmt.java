package ex7_4_1_call_superclass_overrinding_method;

/**
 * [ Person, Student, PersonMgmt 클래스 ] :
 *       상위 클래스의 오버라이딩 메소드와 상위 클래스 객체 생성자 호출하기
 *      
 *   o 오버라이딩된 상위 클래스 메소드 호출하기
 *     - 상위 클래스의 메소드를 오버라이딩하면 오버라이딩된 상위 클래스의 메소드를 하위 클래스에서 직접 호출할 수 없음
 *     - 그런데, 가끔 상위 클래스의 오버라이딩된 메소드를 호출해야할 경우가 있음
 *     - 이때에는 수신자를 super로 하여 오버라이딩 메소드를 호출
 *         ==> 상위 클래스의 오버라이딩 메소드가 호출되어 수행
 *        
 *   o 오버라이딩된 상위 클래스의 메소드를 호출해야하는 대표적인 경우
 *     - 하위 클래스에서 상위 클래스의 toString() 메소드 호출  
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
	//  여기에서 상속받은 필드인 이름, 나이를 초기화하기 위해 상위 클래스의 객체 생성자를 호출
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);     // Person의 객체 생성자 호출하여 상속 필드 초기화 
		this.schoolname = schoolname;  this.grade = grade;
	}
	
	// goToSchool(): 학생이 등교하는 것을 나타내는 메소드
	//    currentLocation을 schoolname으로 변경하기 위해 goTo() 메소드 호출
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩시킨 것이며, 
	//   상속필드인 name, age, currentLocation에 대해 필드들의 문자열을 구성하기 위해  
	//   super.toString()을 이용하여 상위 클래스의 toString() 메소드 호출함
	public String toString() {
		return  super.toString() + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade;  
	}

	// 객체의 필드들 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩시킨 것
	void output() {
		System.out.println("\n  * 학생 - " + this.toString());
	}
}

class Ex7_4_1_PersonMgmt {
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
		p1.output();   //  Person 클래스의 output() 메소드 호출
		s1.output();   //  Student 클래스의 output() 메소드 호출
		p2.output();   //  Person 클래스의 output() 메소드 호출(?)       

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
 *   1) 프로그램을 살펴보고 필드 값을 문자열로 반환하는 toString() 메소드가
 *      Person 클래스와 Student 클래스에 모두 작성되었음 확인하라.
 *      
 *   2) Student 클래스의 toString() 메소드는 Person 클래스의 toString() 메소드를 호출하기
 *      위해 super.toString()을 호출함 확인하라.
 *      
 *   3) 프로그램 실행하고 결과 확인하라.
 *   
 *   4) Student 클래스의 toString() 메소드를 제거한 후 프로그램의 결과 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o 이 패키지에의 별도의 파일로 작성되어 있는 PrimaryStudent 클래스를 변경하라.
 *   
 *      - PrimaryStudent 클래스의 상속 필드는 Student의 toString()을 호출하여 문자열로 
 *        구성하고 고유 필드는 자체에서 문자열로 구성하도록  toString() 메소드를 작성하라. 
 *        
 *      - output() 메소드는 PrimaryStudent 클래스의 toString() 메소드 호출하도록 변경하라.
 *   
 *      - PrimaryStudent 클래스의  상속 필드는 Student의 객체 생성자 호출하여 초기화하도록 객체 생성자를 변경하라. 
 *      
 *      - main()에서 PrimaryStudent 클래스의 객체를 하나 생성하고 output() 메소드로 출력하라.
 */
