package ex7_2_2_upcasting_downcasting;

/**
 * [ Person 클래스와 이의 하위 클래스들 ]: 업캐스팅된 객체를 다운캐스팅하는 예제
 *  
 *   o 업캐스팅(upcasting)
 *     - Java에서 하위 클래스 객체는 상위 클래스의 객체 역할도 함
 *     - 업캐스팅: 하위 클래스 객체의 타입을 상위 클래스 타입으로 변환시키는 것
 *     - 업캐스팅은 하위 클래스 객체를 상위 클래스의 객체 참조변수에 저장하기 위해 필요
 *    
 *   o 업캐스팅은 하위 클래스에서 상속, 오버라이딩과 함께 가장 중요한 개념
 *     - 하위 클래스 객체들을 상위 클래스 객체처럼 사용할 수 있게 하여 많은 이점을 제공
 *    
 *   o 업캐스팅의 제약점
 *     - 업캐스팅에 의해 객체 참조변수에 하위 클래스 객체가 저장되면(이 경우 명시적  참조 클래스와 실제적 
 *       참조 클래스가 다름) 실제적 참조 클래스의 고유 필드나 고유  메소드를 접근할 수 없음
 *     - 그러나 가끔 실제적 참조 클래스의 고유특성을 접근할 필요가 있을 수 있음
 *     - 이를 위하여 Java에서는 업캐스팅된 객체 참조변수를 하위 타입으로 타입변환할 수  있도록 허용하며, 
 *       이를 다운캐스팅이라 함
 *    
 *   o 다운캐스팅(downcasting)
 *     - 업캐스팅된 객체를 저장하는 객체 참조변수를 하위 클래스 타입으로 강제적으로  타입변환시키는 것
 *     - << (다운캐스팅할_ 클래스_타입) 객체참조변수 >> 형식으로, 괄호 속에 캐스트하고자  하는 클래스 타입을 명시
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
// 상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
// 고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), output()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age) {
		super(name, age);  
	}

	// 이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
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
	int classNo;   // 반
	int noInClass; // 반에서의 번호

	// 초등학생의 정보가 주어지면 필드에 저장하는 객체 생성자
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

	// 중고등 학생의 정보가 주어지면 필드에 저장하는 객체 생성자
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

	// 대학생의 정보가 주어지면 필드에 저장하는 객체 생성자
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// 수강신청하다
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

class Course {
	String courseNo;    // 과목번호 
	String coursename;  // 과목이름 
	int credit;         // 학점수

	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}

class Ex7_2_2_PersonMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ****  객체 참조변수의 참조 클래스 확인하기 ****");

		// 명시적 참조 클래스와 실제적 참조 클래스가 같은 경우:
		//   Person 객체 생성하여 Person 객체 참조변수에 저장 
		Person p1 = new Person("홍길동", 18);
		p1.goTo("금강산");
		p1.output();

		// 명시적 참조 클래스와 실제적 참조 클래스가 같은 경우:
		//   Student 객체 생성하여 Student 객체 참조변수에 저장 
		Student s1 = new Student("김영희", 11, "서울초등학교", 4);
		s1.goTo("집");
		s1.goToSchool();
		s1.output();
		
		// p2의 명시적 참조 클래스와 실제적 참조 클래스가 같지 않은 경우:
		//   업캐스팅: 하위 클래스 객체를 상위 클래스 타입으로 타입변환
		//   Student 객체 생성하여 Person 객체 참조변수 p2에 저장함
		//   p2의 명시적 참조 클래스: Person, 실제적 참조 클래스: Student
		Person p2 = new Student("김철수", 23, "한국대학교", 2);
		p2.goTo("광화문");
		p2.output();
		
		// 다운캐스팅: 상위 클래스의 객체 참조변수를 하위 클래스 타입으로 강제 타입변환
		((Student) p2).goToSchool(); // p2를 Student 타입으로 캐스트하여 goToSchool() 메소드 호출
		
		// 다운캐스팅: 상위 클래스의 객체 참조변수를 하위 클래스 타입으로 강제 타입변환
		Student s2 = (Student) p2;  // p2를 Student로 다운캐스팅하여 s2에 저장
		s2.goToSchool();            // s2의 명시적 참조 클래스인 Student의 goToSchool() 호출
		s2.output();
		
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고  상위 클래스의 객체 참조변수에 하위 클래스 객체가 저장된 것 확인하라.
 *   
 *   2) 업캐스팅된 객체 참조변수를 다운캐스팅한 것과 하위 클래스의 메소드 호출 확인하라.
 *   
 *       ((Student) p2).goToSchool();  // p2를 Student로 다운캐스팅하여 goToSchool() 호출
 *       
 *       Student s2 =   (Student) p2;  // p2를 Student로 다운캐스팅하여 s2에 저장
 *       s2.goToSchool();              // s2의 명시적 참조 클래스 Student의 goToSchool() 호출
 *       
 *   3) 프로그램 실행하고 결과 확인하라.
 *        
 *   
 * [ 실습 과제 ]
 * 
 *   o main()에 다음 코드를 작성한 후 수행하여  업캐스팅과 다운캐스팅 다시 확인하라.
 *   
 *     - 자신을 나타내는 UniversityStudent 객체 생성하여 Person 객체 참조변수 p3에 저장
 *     
 *     - 친구를 나타내는 UniversityStudent 생성하여 Student 객체 참조변수 s3에 저장
 *     
 *     - p3과 s3을 UniversityStudent 타입으로 다운캐스팅하여  UniversityStudent 객체
 *       참조변수 us1과 us2에 저장
 *       
 *     - output() 메소드를 이용하여 us1과 us2 출력
 */
