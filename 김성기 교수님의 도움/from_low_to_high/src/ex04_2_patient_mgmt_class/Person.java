package ex04_2_patient_mgmt_class;

//Person 클래스
//필드 name, age, currentLocation
//메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;  // 현위치를 주어진 장소로 변경
	}

	// goTo(): 수신자 객체가 병원으로 가는 것을 나타내는 메소드
	void goTo(Clinic clinic) {
		this.currentLocation = clinic.clinicName; // 현위치를 주어진 병원의 이름으로 변경
	}

	void input() {
		this.name = SkScanner.getString("  o 이름 > ");
		this.age = SkScanner.getInt("  o 나이 > ");
	}

	// toString(): 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age + ", 현위치:" + this.currentLocation;
	}

	// output(): 객체 출력 메소드 - toString() 메소드 이용하여 모든 필드 값을 출력
	void output() {
		System.out.println(this.toString());
	}

	// output(): 객체 출력 메소드 - 주어진 타이틀을 출력한 후 output() 메소드로 모든 필드 값 출력
	void output(String title) {
		System.out.print(title);  // 타이틀 출력 - 이때에는 줄바꿈을 하지 않음(줄바꿈을 하려면 title에서 끝에 '\n'을 첨부해야 함)
		this.output();
	}
}


