package ex7_2_1_object_as_superclass_object;

/**
 * [ Person 클래스와 이의 하위 클래스들 ]: 
 *       상위 클래스의 객체 참조변수에 하위 클래스 객체가 저장되는 업캐스팅의 예
 *  
 *   o 업캐스팅(upcasting)
 *     - Java에서 하위 클래스 객체는 상위 클래스의 객체 역할도 함
 *     - 업캐스팅: 하위 클래스 객체의 타입을 상위 클래스 타입으로 변환시키는 것
 *     - 업캐스팅은 하위 클래스 객체를 상위 클래스의 객체 참조변수에 저장하기 위해 필요함
 *    
 *   o 업캐스팅은 하위 클래스에서 상속, 오버라이딩과 함께 가장 중요한 개념
 *     - 하위 클래스 객체들을 상위 클래스 객체처럼 사용할 수 있게 하여 많은 이점을 제공
 */

// Person 클래스: 필드 name, age, currentLocation과 메소드 goTo(), output()을 갖는 클래스
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

// Person 클래스의 하위 클래스인 Student의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//   고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), output()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;	    // 학년

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

//Student 클래스의 하위 클래스인 초등학생을 나타내는 PrimaryStudent 클래스
class PrimaryStudent extends Student {
	int classNo;    // 반
	int noInClass;  // 반에서의 번호

	// 초등학생 정보가 주어지면 필드에 저장하는 객체 생성자
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		super(name, age, schoolname, grade);
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	// output(): 수신자 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 초등학생 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 반:" + this.classNo + ", 번호:" + this.noInClass);
	}
}

class MiddleHighStudent extends Student {
	int sno;		// 학번
	int classNo;  	// 반
	int noInClass;  // 반에서의 번호

	// 중고등 학생 정보가 주어지면 필드에 저장하는 객체 생성자
	MiddleHighStudent(String name, int age, String schoolname, int grade, int sno, int classNo, int noInClass) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.classNo = classNo;    this.noInClass = noInClass;
	}

	void output() {
		System.out.println("\n  * 중고등학생 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 학번:" + this.sno + 
				", 반:" + this.classNo + ", 번호:" + this.noInClass);
	}
}

class UniversityStudent extends Student {
	int sno;		// 학번
	String dept;	// 학과
	Course enrolledCourses[] = new Course[100];  	// 수강과목들
	int cntCourses = 0;                             // 수강과목 개수

	// 대학생 정보가 주어지면 필드에 저장하는 객체 생성자
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	  // 수강신청하다
		enrolledCourses[cntCourses++] = course;
	}

	// output(): 수신자 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 대학생 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 학번:" + this.sno + ", 학과:" + this.dept );
	}
}

//대학생이 수강하는 과목을 나타내는 Course 클래스
class Course {
	String courseNo;    // 과목번호 
	String coursename;  // 과목이름 
	int credit;         // 학점수

	// 과목 정보가 주어지면 필드에 저장하는 객체 생성자
	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_2_1_StudentMgmt {

	public static void main(String[] args) {
        Student yskim  = new Student("김영수", 14, "세종중학교", 2);
        yskim.goToSchool(); // 김영수가 등교함

		// Student 객체 생성하여 Person 객체 참조변수에 저장(업캐스팅) 
		Person p = new Student("김영희", 11, "서울초등학교", 4);  
		p.goTo("서울초등학교"); // 김영희가 서울초등학교에 감

		// UniversityStudent 객체 생성하여 Student 객체 참조변수에 저장(업캐스팅)
		Student s = new UniversityStudent("김철수", 23, "한국대학교", 3, 201611001, "컴퓨터공학");

		s.goToSchool();     // 김철수가 등교함
 
		// 김영수, 김영희, 김철수의 필드 값을 모두 출력
		yskim.output();
		p.output();
		s.output(); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 상위 클래스의 객체 참조변수에 하위 클래스 객체가 저장된 것을 확인하라.
 *   
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 * 
 * [ 실습 과제 ]
 * 
 *   o main() 메소드에서 상위 클래스의 참조변수에 하위 클래스 객체 저장하기
 *     - 자신을 나타내는 UniversityStudent 객체 생성하여 Person 객체 참조변수 p1에 저장하라.
 *     - 친구를 나타내는 UniversityStudent 객체 생성하여 Student 객체 참조변수 s1에 저장하라.
 *    
 *     - output() 메소드를 이용하여 p1과 s1 출력하여 출력 결과들을 살펴보고
 *       어느 필드가 출력되었는지 확인하라.
 */
