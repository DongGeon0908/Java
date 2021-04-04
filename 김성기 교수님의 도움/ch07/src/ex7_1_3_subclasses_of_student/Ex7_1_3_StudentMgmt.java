package ex7_1_3_subclasses_of_student;

/**
 * [ Student 클래스의 여러 하위 클래스 ]: 
 *       Person 클래스의 하위 클래스인 Student 클래스의 여러 하위 클래스들 선언
 *  
 *   o 하위 클래스도 또 다른 하위 클래스를 가질 수 있음
 *    
 *   o Person 클래스의 하위 클래스인 Student 클래스의 여러 하위 클래스들인
 *     PrimaryStudent, MiddleHighStudent, UniversityStudent 선언
 *      
 *     - 이들 Student 클래스의 여러 하위 클래스들은 Student 클래스의 필드와 메소드를 상속받음
 *     - 고유 필드와 고유 메소드를 가질 수 있음    
 */

// Person 클래스: 필드 name, age, currentLocation과 메소드 goTo(), output()을  갖는 클래스
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

// Student 클래스의 하위 클래스인 초등학생을 나타내는 PrimaryStudent 클래스
class PrimaryStudent extends Student {
	int classNo;    // 반
	int noInClass;  // 반에서의 번호

	// 초등학생 정보가 주어지면 필드에 저장하는 객체 생성자
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		super(name, age, schoolname, grade);  // 상위 클래스 객체 생성자 이용하여 초기화
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	
	// output(): 수신자 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 초등학생-  이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 반:" + this.classNo + ", 번호:" + this.noInClass);
	}
}

// Student 클래스의 하위 클래스인 중고등학생을 나타내는 MiddleHighStudent 클래스
class MiddleHighStudent extends Student {
	int sno;		// 학번
	int classNo;  	// 반
	int noInClass;  // 반에서의 번호

	// 중고등 학생 정보가 주어지면 필드에 저장하는 객체 생성자
	MiddleHighStudent(String name, int age, String schoolname, int grade, int sno, int classNo, int noInClass) {
		super(name, age, schoolname, grade);   // 상위 클래스 객체 생성자 이용하여 초기화
		this.sno = sno;    this.classNo = classNo;    this.noInClass = noInClass;
	}

	void output() {
		System.out.println("\n  * 중고등학생 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 학번:" + this.sno + 
				", 반:" + this.classNo + ", 번호:" + this.noInClass);
	}
}

// Student 클래스의 하위 클래스인 대학생을 나타내는 UniversityStudent 클래스
class UniversityStudent extends Student {
	int sno;		// 학번
	String dept;	// 학과
	Course[] enrolledCourses = new Course[100];  // 수강과목들
	int cntCourses = 0;                          // 수강과목 개수

	// 대학생 정보가 주어지면 필드에 저장하는 객체 생성자
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // 상위 클래스 객체 생성자 이용하여 초기화
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) { // 수강신청하다
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

class Ex7_1_3_StudentMgmt {
	public static void main(String[] args) {
        PrimaryStudent  ps;
        MiddleHighStudent ms;
        UniversityStudent us;
	
        // 11세인 김영희는 서울초등학교 4학년 2반 12번 초등학생임 
        ps = new PrimaryStudent("김영희", 11, "서울초등학교", 4, 2, 12);
        ps.goTo("서울초등학교"); // 김영희가 서울초등학교에 감 

        // 14세인 김영수는 세종중학교 학생으로, 학번이 20170203, 반이 2, 번호가 3임
        ms = new MiddleHighStudent("김영수", 14, "세종중학교", 2, 20170203, 2, 3);
        ms.goToSchool();     // 김영수가 등교함

        // 21세인 김철수는 한국대학교 컴퓨터공학과 3학년 대학생임
        us = new UniversityStudent("김철수", 21, "한국대학교",3, 201611001, "컴퓨터공학");
        us.goToSchool();     // 김철수가 등교함

        Course co = new Course("CS201", "Java 프로그래밍", 3);
        us.enrolCourse(co);  // 김철수가 Java 프로그래밍 과목을 수강

        // 김영희, 김영수, 김철수의 필드 값을 모두 출력
        ps.output();
        ms.output();
        us.output();
    }    
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 Student 클래스의 하위 클래스의 필드와 메소드에 대해 파악하라.
 *   
 *   2) UniversityStudent 클래스의 enrolCourse() 메소드를 살펴보고 기능을 이해하라.
 *   
 *   3) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) UniversityStudent 클래스의 output() 메소드에서 수강 과목이름과 학점을 추가로
 *      출력하도록 변경하라. 출력 양식은 다음을 참고하라.
 *      
 *          수강과목들: [ Java 프로그래밍, 3 ] [ 자료구조, 3 ] ...
 *      
 *   2) 학생의 또다른 하위 클래스로 대학원생이 있다.
 *      대학원생의 추가적인 필드와 메소드가 무엇이 있는가를 찾아보고 대학원생을 
 *      나타내는 클래스인 GraduateStudent 클래스를 작성하라.
 *     
 *      main() 메소드에서 대학원생 객체를 생성한 후 output() 메소드를 이용하여 출력하라.
 */
