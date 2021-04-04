package example11_2_person_mgmt;

import java.lang.Comparable;
 
// Person 클래스
//  필드 name, age, currentLocation
//  메소드 goTo(), output()을 갖는 클래스
class Person implements Comparable<Person> {
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
	
	// 이 메소드는 java.lang.Comparable 클래스의 추상 메소드를
	// 구현하는 메소드로서, 이름 순서로 여러 Person 객체를 저장하게 됨
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
		
	// Person 객체의 모든 필드의 값을  문자열로 구성하는 메소드
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age + 
			", 현위치:" + this.currentLocation;
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
