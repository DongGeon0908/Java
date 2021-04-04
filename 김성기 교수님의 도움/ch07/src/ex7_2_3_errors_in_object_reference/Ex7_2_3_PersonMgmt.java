package ex7_2_3_errors_in_object_reference;

/**
 * [ Person, Student, Car, PersonMgmt 클래스 ]: 
 *       업캐스팅 및 다운캐스팅에서의 객체 참조 오류를 보이는 예제
 *  
 *   o 업캐스팅(upcasting)
 *     - Java에서 하위 클래스 객체는 상위 클래스의 객체 역할도 함
 *     - 업캐스팅: 하위 클래스 객체의 타입을 상위 클래스 타입으로 변환시키는 것
 *     - 업캐스팅은 하위 클래스 객체를 상위 클래스의 객체 참조변수에 저장하기 위해 필요함
 *    
 *   o 다운캐스팅(downcasting)
 *     - 업캐스팅된 객체를 저장하는 객체 참조변수를 하위 클래스 타입으로 강제적으로  타입변환시키는 것
 *     - << (다운캐스할_ 클래스_타입) 객체참조변수 >> 형식으로, 괄호 속에 캐스트하고자  하는 클래스 타입을 명시함
 *    
 *   o 업캐스팅 및 다운캐스팅에서의 객체 참조 오류 발생함
 *     - 컴파일  오류: 컴파일러가 잘못된 객체 참조를 알려줌
 *     - 실행시간 오류: 실행과정에서 잘못된 객체 참조를 알려줌
 */

//Person 클래스: 필드 name, age, currentLocation과 메소드 goTo()를 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	// output(): Person 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 사람 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation );
	}
}

//Person 클래스의 하위 클래스인 Student의 선언
//상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), output()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	//이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age) {
		super(name, age);  
	}

	//이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);  
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): 학생이 등교하는 것을 나타내는 메소드
	//  currentLocation을 schoolname으로 변경하기 위해 goTo() 메소드 호출
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// output(): Student 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade);
	}
}

class Car {
	String carNo;   // 자동자번호 
	String carname; // 자동차명 
    String owner;   // 소유자
}

class Ex7_2_3_PersonMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ****  객체 참조에서의 오류 확인하기 ****");

		Person p1 = new Car();       			// 컴파일 오류: Car 클래스는 Person의 하위 클래스 아님
		Student s1 = new Person("홍길동", 18); 	// 컴파일 오류: Person은 Student 클래스의 하위 클래스 아님

		Student s2  = new Student("김영희", 11, "서울초등학교", 4); 
		((Person) s2).goToSchool();				// 컴파일 오류: s2를 Person 타입으로 업캐스팅시켜 
												//           Student의 goToSchool() 호출 불가
		
		Person p2 = s2;            				// s2를 업캐스팅시켜 상위 클래스 참조변수 p2에 저장
		p2.goToSchool();            			// 컴파일 오류: Person p2는 goToSchool() 호출 불가

		Person p3 = new Person("박문수", 23);
		((Student) p3).goToSchool();			// 실행시간 오류: p3의 실제적 참조 클래스가 Person이므로 
												//            Student로 다운캐스팅시킬 수 없음
	}
}

/*
* [ 프로그램 이해 및 실행 ]
* 
*   1) 프로그램을 살펴보고 잘못된 부분들을 확인하고 올바른 프로그램으로 수정하라.
*   
*   2) 특히, 업캐스팅된 경우 실제 하위 객체가 저장되지만 하위 클래스의 필드나 메소드 참조가  
*      불가능함을 확인하라.
*      
*      Student s2 = new Student("김영희", 11, "집", "서울초등학교", 4); 
*      ((Person) s2).goToSchool();   // 컴파일 오류: s2를 Person 타입으로 업캐스팅시켜 
*                                    //              Student의 goToSchool() 호출 불가
*                                    
*   3) 수정된 프로그램 실행하여 오류 없이 수행됨 확인하라.
*       
*   4) p2, s1, s2 객체들을 output() 메소드를 이용하여 출력하도록 프로그램을 변경하고 실행하고 결과를 확인하라.
*/
