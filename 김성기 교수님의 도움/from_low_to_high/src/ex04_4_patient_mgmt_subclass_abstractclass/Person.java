package ex04_4_patient_mgmt_subclass_abstractclass;

//Person 클래스
//  - ClassForPatientMgmt 클래스의 하위 클래스
//  - ClassForPatientMgmt 클래스에서 객체 출력을 위한 output() 메소드를 상속받음
//  - 필드 name, age, currentLocation
//  - 메소드 goTo()을 갖는 클래스
class Person  extends ClassForPatientMgmt{
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
}


