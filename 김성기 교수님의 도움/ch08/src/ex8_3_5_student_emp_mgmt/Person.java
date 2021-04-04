package ex8_3_5_student_emp_mgmt;

class Person {
	String name;    		// 이름
	int    age;				// 나이
	String currentLocation;	// 현위치

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

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Object 클래스의 메소드를 오버라이딩
	public String toString() {
		return "이름:" + this.name + ", 나이: " + this.age 
				+ ", 현위치: " + this.currentLocation;  
	}

	// 객체의 필드들을 출력하는 메소드
	void output() {
		System.out.println("  * 사람 - " + this.toString());
	}
}
