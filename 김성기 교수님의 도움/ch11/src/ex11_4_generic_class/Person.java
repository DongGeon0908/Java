package ex11_4_generic_class;

// Person 클래스
//   필드 name, age, currentLocation
//   메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	// 매개변수 없는 객체 생성자
	Person() {
	}
	
	// 이름, 나이, 장소가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	// Person 객체의 모든 필드의 값을  문자열로 구성하는 메소드
	public String toString() {
		return "이름: " + this.name + ", 나이: " + this.age + 
				(this.currentLocation != null ? ", 현위치: " + this.currentLocation : "");
	}
 
	// output(): Person 객체의 모든 필드의 값을 출력하는 메소드
	void output() {
		System.out.println("  * 사람 - " + toString());
	} 
	
	// input(): Person 객체의 모든 필드의 값을 입력하는 메소드
	void input(String prompt) {
		System.out.println(prompt);
		name = SkScanner.getString("  o 이름 > ");
		age = SkScanner.getInt("  o 나이 > ");
		currentLocation = SkScanner.getString("  o 현위치 > ");
	}	
}

// Person 클래스의 하위 클래스인 Student의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//   고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), outputState()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;		// 학년

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age) {
		super(name, age);  // 상위 클래스 객체 생성자 이용하여 초기화
	}

	// 이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age, String schoolname, int grade) {
		this(name, age);  
		this.schoolname = schoolname;       this.grade = grade;
	}

	// goToSchool(): 학생이 등교하는 것을 나타내는 메소드
	//    currentLocation을 schoolname으로 변경하기 위해 goTo() 메소드 호출
	void goToSchool() {
		goTo(this.schoolname); 
	}

	// Person 객체의 모든 필드의 값을  문자열로 구성하는 메소드
	public String toString() {
		return super.toString() + ", 학교명:" + this.schoolname + ", 학년:" + this.grade;
	}

	// output(): Student 객체의 모든 필드의 값을 출력하는 메소드
	void output() {
		System.out.println("  * 학생 - " + toString());
	}
}
