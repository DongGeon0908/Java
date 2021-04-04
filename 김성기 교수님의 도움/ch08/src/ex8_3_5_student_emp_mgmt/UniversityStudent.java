package ex8_3_5_student_emp_mgmt;

// Student 클래스의 하위 클래스인 대학생을 나타내는 UniversityStudent 클래스
class UniversityStudent extends Student {
	int sno;		// 학번
	String dept;	// 학과
	Course enrolledCourses[] = new Course[100];  	// 수강과목들
	int cntCourses = 0;                             // 수강과목 개수

	// 대학생의 정보가 주어지면 필드에 저장하는 객체 생성자
	UniversityStudent(String name, int age, String schoolname, int grade, int sno, String dept) {
		super(name, age, schoolname, grade);   // 상위 클래스 객체 생성자 이용하여 초기화
		this.sno = sno;    this.dept = dept;  
	}

	void enrolCourse(Course course) {	// 수강신청하다
		enrolledCourses[cntCourses++] = course;
	}

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Student 클래스의 메소드를 오버라이딩
	//   상속필드인 name, age, cuurentLocation, schoolname, grade에 대해 필드들의 문자열을 구성하기 위해  
	//   super.toString()을 이용하여 상위 클래스의 toString() 메소드 호출
	public String toString() {
		return  super.toString() + 
				", 학번:" + this.sno + ", 학과:" + this.dept  ;  
	}

	// 객체의 필드들을 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩	
	void output() {
		System.out.println("  * 대학생 - " + this.toString());
	}
}

// 대학생이 수강하는 과목을 나타내는 Course 클래스
class Course {
	String courseNo;    // 과목번호 
	String coursename;  // 과목이름 
	int credit;         // 학점수

	Course(String cno, String cname, int credit) {
		this.courseNo = cno;   this.coursename = cname;  this.credit = credit;
	}
}
