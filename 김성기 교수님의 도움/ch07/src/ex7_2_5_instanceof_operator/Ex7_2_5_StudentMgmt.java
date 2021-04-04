package ex7_2_5_instanceof_operator;

/**
 * [ Person 클래스와 이의 하위 클래스들 ]: 타입 확인 연산자 instanceof 활용하는 예제
 *  
 *   o instanceof 연산자
 *     - 두 개의 피연산자 가지는 연산자
 *     - 형식: 객체참조변수 instanceof 클래스
 *     - 연산 결과: 왼쪽의 객체참조변수에 저장된 객체가 오른쪽 클래스의 객체 또는 
 *               그 클래스의 하위 클래스 객체이면 true, 아니면 false 반환
 */

//Person 클래스: 필드 name, age, currentLocation과 메소드 goTo()를, output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 주어진 위치로 이동하는 것 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	// output(): Person 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 사람 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation);
	}
}

// Person 클래스의 하위 클래스인 Student의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//   고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), output()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age) {
		super(name, age);  
	}

	// 이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age, String schoolname, int grade) {
		super(name, age);  // 상위 클래스 객체 생성자 이용하여 초기화
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): 학생이 등교하는 것 나타내는 메소드
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

// Student 클래스의 하위 클래스인 대학생을 나타내는 UniversityStudent 클래스
class UniversityStudent extends Student {
	int sno;		// 학번
	String dept;	// 학과
	Course enrolledCourses[] = new Course[100];  	// 수강과목들
	int cntCourses = 0;                             // 수강과목 개수

	// 대학생 정보가 주어지면 필드에 저장하는 객체 생성자
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // 상위 클래스 객체 생성자 이용하여 초기화
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// 수강신청하다
		enrolledCourses[cntCourses++] = course;
	}

	// output(): 수신자 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 대학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 학번:" + this.sno + ", 학과:" + this.dept );
	}
}

// 대학생이 수강하는 과목을 나타내는 Course 클래스
class Course {
	String courseNo;    // 과목번호 
	String coursename;  // 과목이름 
	int credit;         // 학점수

	// 과목 정보가 주어지면 필드에 저장하는 객체 생성자
	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_2_5_StudentMgmt {
	public static void main(String[] args) {
	
        Person p1 = new Student("김영희", 11, "서울초등학교", 4);
        if (p1 instanceof Student)	    // instanceof 연산자의 예: p1이 Student의 객체이면 
           ((Student) p1).goToSchool(); //    p1을 Student로 다운캐스팅하여 goToSchool() 호출

        Person p2 = new UniversityStudent("김철수", 23,
        	                       "한국대학교",3, 201611001, "컴퓨터공학");

        if (p2 instanceof Student)	    // instanceof 연산자의 예: p2가 Student의 객체이면 
           ((Student) p2).goToSchool(); //    p2를 Student로 다운캐스팅하여 goToSchool() 호출

        if (p2 instanceof UniversityStudent)  // p2가 UniversityStudent의 객체이면 Student로 다운캐스팅 가능
           ((UniversityStudent) p2).enrolCourse(new Course("CS201", "Java 프로그래밍", 3));        
 
        // 김영희, 김철수의 필드 값을 모두 출력
        p1.output();
        p2.output();
    }    
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 업캐스팅된 경우 실제 하위 클래스 객체가 저장됨을   확인하라.
 *   
 *   2) instanceof 연산자의 결과를 확인하라.
 *   
 *      - p1 instanceof Student ==> (Student 객체) instanceof Student ==> true
 *      
 *      - p2 instanceof Student ==> (UniversityStudent 객체) instanceof Student 
 *                              ==> (Student 하위 클래스 객체) instanceof Student ==> true
 *                              
 *      - p2 instanceof UniversityStudent 
 *            ==> (UniversityStudent 객체) instanceof UniversityStudent 
 *            ==> true
 *   
 *   
 * [ 실습과제 ]
 * 
 *   o 다음 연산의 결과를 구하고 System.out.prinln()을 이용하여  결과를 확인하라.
 *   
 *     - p1 instanceof Person
 *     
 *     - p1 instanceof UniversityStudent
 *     
 *     - p2 instanceof Person
 *     
 *     - p2 instanceof Object
 *     
 *     - (new Person("박문수",  28)) instanceof Student
 */
