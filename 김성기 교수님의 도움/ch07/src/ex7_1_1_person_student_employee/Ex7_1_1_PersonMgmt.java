package ex7_1_1_person_student_employee;

/**
 * [ Person, Student, Employee 클래스 ]: 
 *       Person 클래스의 하위 클래스로 선언하지 않은 Student와 Employee 클래스
 * 
 *   o Person 클래스
 *     - 필드 name, age, currentLocation과 메소드 goTo()를 가짐
 *     
 *   o Student 클래스
 *     - Person 클래스가 갖는 모든 필드와 메소드를 선언 
 *     - 필드 schoolname, grade와 메소드 goToSchool()과 output()을 고유 특성으로 가짐
 *     - goToSchool() 메소드에서는 goTo() 메소드를 호출하여 현위치를 학교명으로 변경
 *     
 *   o Employee 클래스
 *     - Person 클래스가 갖는 모든 필드와 메소드를 선언
 *     - 필드 empType, empno, dateHired와 메소드 goToWork(), output()을 고유 특성으로 가짐
 *     - goToWork() 메소드에서는 goTo() 메소드를 호출하여 현위치를 "회사"로 변경
 */

// Person 클래스
//   필드 name, age, currentLocation
//   메소드 goTo(), output()을 갖는 클래스
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
			", 현위치:" + this.currentLocation);
	}
}

// Student 클래스
//   필드: name, age, currentLocation, schoolname, grade
//   메소드: goTo(), goToSchool(), output()
class Student {
	String name; int age; String currentLocation; 
	String schoolname;   int grade;   // 학교명, 학년

	Student(String name, int age, String schoolname, int grade) {  // 이름, 나이, 학교명, 학년을 필드에 저장하는 객체 생성자
		this.name = name;  this.age = age; 
		this.schoolname = schoolname; this.grade = grade;
	}

	void goTo(String location) {      // goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드
		this.currentLocation = location;
	}

	void goToSchool() {               // goToSchool(): 학생이 등교하는 것을 나타내는 메소드
		goTo(this.schoolname); 
	}

	// output(): Student 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade);
	}
}

// Employee 클래스
//   필드: name, age, currentLocation, empType, empno, dateHired
//   메소드: goTo(), goToWork(), output()
class Employee {
	String name; int age; String currentLocation; 
	
	String empType;     // 사원 유형: "정규직", "시간제", "인턴" 중의 하나
	int empno;          // 사원번호 
	String dateHired;   // 입사일 

	// 객체 생성자: 주어진 이름, 나이, 사원유형, 사원번호, 입사일을 필드에 저장
	Employee(String name, int age, String empType, int empno, String dateHired) {
		this.name = name;  this.age = age; 
		this.empType = empType;   this.empno = empno; 
		this.dateHired = dateHired; 
	}

	void goTo(String location) {  // goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드
		this.currentLocation = location;
	}

	// goToWork(): 출근하다를 나타내는 메소드 
	//    currentLocation을 "회사"로 변경하기 위해 goTo() 메소드 호출
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

class Ex7_1_1_PersonMgmt {
	public static void main(String[] args) {
		// 김영희와 박문수 객체 참조하기 위한 변수 선언
		Student  yhkim;
		Employee mspark;

		// 11살의 김영희는 서울초등학교 4학년 학생임 
		yhkim = new Student("김영희", 11, "서울초등학교", 4);
		yhkim.goTo("서울초등학교"); // 김영희가 서울초등학교에 감

		// 28세인 박문수는 사원번호 1035, 입사일이 20140301인 정규직 사원임    
		mspark = new Employee("박문수", 28, "정규직", 1035, "20140301");
		mspark.goToWork();      // 박문수가 출근함

		// 김영희와 박문수의 필드 값을 모두 출력
		yhkim.output();
		mspark.output();
	}
}

/*
 * 
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 Person, Student, Employee 클래스에 중복된 부분을 확인하라.
 *   
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *   
 *    
 * [ 실습 과제 ]
 * 
 *   1) Person 클래스에 주소 나타내는 필드 addr 추가하는 경우 Person, Student, Employee
 *      클래스에서 변경할 부분 확인하고 변경하라.
 *      
 *   2) Student 클래스가  가지는 필드와 메소드 외에 학번 sno, 반 classNo, 반에서의 번호 noInClass 필드와 
 *      새로운 output() 메소드를 갖는  중학생 클래스 middleStudent를 추가로 작성하고 PersonMgmt 클래스의 
 *      main()에서  middleStudent 객체를 다음과 같이 생성하고 출력하라.
 *     
          // 14세의 김영수는 세종중학교 2학년 학생으로, 학번이 20170203, 반이 2, 번호가 3임
          MiddleStudent mst = new MiddleStudent("김영수", 14, "세종중학교", 2, 20170203, 2, 3); 
          mst.output();
 */
 