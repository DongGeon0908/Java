package ex8_3_5_student_emp_mgmt;

// Person 클래스의 하위 클래스인 Student의 선언
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 매개변수 없는 객체 생성자
	Student() {
	}

	// 이름, 나이, 학교명, 학년, 장소가 주어지면 필드에 저장하는 객체 생성자
	//  여기에서 상속받은 필드인 이름, 나이를 초기화하기 위해 상위 클래스의 객체 생성자 호출
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
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩
	//   상속필드인 name, age, cuurentLocation에 대해 필드들의 문자열을 구성하기 위해  
	//   super.toString()을 이용하여 상위 클래스의 toString() 메소드 호출
	public String toString() {
		return  super.toString() + 
				", 학교명:" + this.schoolname + ", 학년:" + this.grade;  
	}

	// 객체의 필드들을 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩
	void output() {
		System.out.println("  * 학생 - " + this.toString());
	}
}
