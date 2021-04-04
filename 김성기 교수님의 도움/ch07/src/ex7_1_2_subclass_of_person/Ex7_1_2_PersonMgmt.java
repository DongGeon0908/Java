package ex7_1_2_subclass_of_person;

/**
 * [ Person 클래스의 하위 클래스들 ]: Person 클래스의 하위 클래스인 Student와 Employee
 * 
 *   o Person 클래스
 *     - 필드 name, age, currentLocation과 메소드 goTo()를 가짐
 *     
 *   o Student 클래스
 *     - Person 클래스를 확장한 하위 클래스
 *     - Person 클래스의 모든 필드와 메소드를 상속받으므로 선언되어 있지는 않지만 
 *       Person 클래스의 필드 name, age, currentLocation과 메소드 goTo()를 가짐
 *       
 *     - 필드 schoolname, grade와 메소드 goToSchool()과 output()을 고유 특성으로 가짐
 *     - goToSchool() 메소드에서는 goTo() 메소드를 호출하여 현위치를 학교명으로 변경
 *     
 *   o Employee 클래스
 *     - Person 클래스를 확장한 하위 클래스
 *     - Person 클래스의 모든 필드와 메소드를 상속받으므로 선언되어 있지는 않지만 
 *       자동적으로 Person 클래스의 필드 name, age, currentLocation과 메소드 goTo()를 가짐
 *       
 *     - 필드 empType, empno, dateHired와 메소드 goToWork(), output()을 고유 특성으로 가짐
 *     - goToWork() 메소드에서는 goTo() 메소드를 호출하여 현위치를 "회사"로 변경
 */

// Person 클래스
//  필드 name, age, currentLocation
//  메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	Person() {  // 매개변수 없는 객체 생성자
	}

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}
}

// Person 클래스의 하위 클래스인 Student의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//   고유 특성: 필드 schoolname, grade, 메소드 goToSchool()
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

	// output(): Student 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade);
	}
}

// Person 클래스의 하위 클래스인 Employee의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//   고유 특성: 필드 EmployeeType, empno, dateHired, 메소드 goToWork()
class Employee extends Person {
	String empType;    // 사원 유형: "정규직", "시간제", "인턴" 중의 하나
	int empno;         // 사원번호 
	String dateHired;  // 입사일 

	// 객체 생성자: 주어진 이름, 나이, 사원유형, 사원번호, 입사일을 필드에 저장
	Employee(String name, int age, String empType, int empno, String dateHired) {
		this.name = name;  this.age = age; 
		this.empType = empType;   this.empno = empno; 
		this.dateHired = dateHired; 
	}

	// goToWork(): 출근하다를 나타내는 메소드 
	//    currentLocation을 “회사”로 변경하기 위해 goTo() 메소드 호출
	void goToWork() {
		goTo("회사"); 
	}

	// output(): Employee 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 사원 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + ", 사원타입:" + this.empType +
				", 사원번호:" + this.empno + ", 입사일:" + this.dateHired);
	}
}

class Ex7_1_2_PersonMgmt {
	public static void main(String[] args) {
		// 김영희와 박문수 객체 참조하기 위한 변수 선언
		Student st;
		Employee emp;

		st = new Student("김영희", 11, "서울초등학교", 4); // 11살 김영희 서울초등 4학년  
		st.goTo("서울초등학교"); // 상속 메소드 호출: 김영희가 서울초등학교에 감

		// 28세인 박문수는 사원번호 1035, 입사일이 20140301인 정규직 사원임    
		emp = new Employee("박문수", 28, "정규직", 1035, "20140301");
		emp.goToWork();      // 사원의 고유 메소드 호출: 박문수가 출근함

		// 김영희와 박문수의 필드 값을 모두 출력
		st.output();          
		emp.output();
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 Student 클래스와 Employee 클래스에서 선언되지 않았지만 
 *      사용되는 필드와 메소드를 확인하라.
 *      
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) Person 클래스에 주소 나타내는 필드 addr 추가하는 경우 Person, Student, Employee
 *      클래스에서 변경할 부분 확인하고 변경하라. 
 *   
 *   2) Person 클래스가  가지는 필드와 메소드 외에 의사면허번호 licenseNo, 전공분야  major 필드와
 *      새로운 output() 메소드를 갖는  의사 클래스 Doctor를 추가로 작성하고  
 *      PersonMgmt 클래스의 main()에서 Doctor 객체를 다음과 같이 생성하고 출력하라.
 *      
           // 34세의 김영수는 의사면허번호 2010123인 내과 전공분야의 의사
           Doctor yskim = new Doctor("김영수", 34, 20100123, "내과"); 
           yskim.output();
 *      
 *   3) Person 클래스의 또다른 하위 클래스로  군인, 공무원, 요리사, 연예인 클래스 등이 있다.
 *      이들 클래스에 대한 필드를 결정하여 Person 클래스의 하위 클래스로 작성하라.
 *      
 *      각 클래스는 객체 생성자와 필드를 출력하는 새로운 output() 메소드를 작성해야 한다.
 *      PersonMgmt 클래스의 main()에서 이들 클래스의 객체를 생성하고 output() 메소드를
 *      이용하여 출력하라.     
 */
