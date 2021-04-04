package ex7_2_6_person_with_upcasting_field;

/**
 * [ Person, Student, ObjectMgmt 클래스  ]: 업케스팅의 필요성을 보여주는  예제
 *  
 *   o 업캐스팅(upcasting)
 *     - Java에서 하위 클래스 객체는 상위 클래스의 객체 역할도 함
 *     - 업캐스팅: 하위 클래스 객체의 타입을 상위 클래스 타입으로 변환시키는 것
 *     - 업캐스팅은 하위 클래스 객체를 상위 클래스의 객체 참조변수에 저장하기 위해 필요함
 *    
 *   o Person 클래스의 친구를 나타내는 friend 필드
 *     - << Person friend; >>로 선언되므로 Person 객체 저장 가능함
 *     - 그런데, 친구는 Person 클래스 객체뿐 아니라 하위 클래스 객체도 될 수 있음
 *    
 *   o Person 클래스의 마지막 만난 사람을 나타내는 personLastMet 필드   
 *     - << Person personLastMe; >>로 선언되므로 Person 객체 저장 가능함
 *     - 그런데, 마지막 만난 사람은  Person 클래스 객체뿐 아니라 하위 클래스 객체도 될 수 있음
 *
 *   o Person 클래스의 만나다를 나타내는 메소드 << void meets(Person p) >>에서의 매개변수 p 
 *     - 매개변수 p를 personLastMet 필드 값에 저장
 *     - 매개변수 p에 Person 객체 뿐 아니라 Person의 하위 객체도 전달 가능함
 */

// Person 클래스: 필드 name, age, currentLocation과 메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;
  	Person friend;	// 친구를 참조하는 필드: 친구는 Person 클래스의 객체뿐 
                    //   아니라 하위 클래스 객체도 될 수 있음

  	Person  personLastMet;   // 마지막으로 만난 사람을 저장하는 필드:  마지막 만난 사람은 Person 클래스의 객체뿐 
                             //   아니라 하위 클래스 객체도 될 수 있음

	// 이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}
	
    void meets(Person p) {   // 만나다를 나타내는 메소드: personLastMet 필드 값에 주어진 p를 저장
        personLastMet = p;   //   매개변수 p에는 Person 객체 뿐 아니라 Person의 하위 객체도 저장  가능함
    }
	
	// output(): Person 객체의 모든 필드 값 출력하는 메소드
	void output() {
		System.out.println("\n  * 사람 - 이름:" + this.name + ", 나이:" + this.age + ", 현위치:" + this.currentLocation
				 + ", 친구 이름: " + ((this.friend != null) ? this.friend.name : "없음" ) 
				 + ", 마지막 만난 사람이름: " + ((this.personLastMet != null) ? this.personLastMet.name : "없음" ));
	}
} 

// Person 클래스의 하위 클래스인 Student의 선언
//   상속 특성: Person 클래스의 필드인 name, age, currentLocation, friend, personLastMet, 메소드 goTo()
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
		System.out.println("\n  * 학생 - 이름:" + this.name + ", 나이:" + this.age + ", 현위치:" + this.currentLocation
				 + ", 친구 이름: " + ((this.friend != null) ? this.friend.name : "없음" ) 
				 + ", 마지막 만난 사람이름: " + ((this.personLastMet != null) ? this.personLastMet.name : "없음" )
		    	 + ", 학교명:" + this.schoolname + ", 학년:" + this.grade);
	}
}

class Ex7_2_5_ObjectMgmt {
	public static void main(String[] args) {
		Person p = new Person("이몽룡", 20); // 20세 이몽룡이 있음
		Student s1 = new Student("김철수", 23, "한국대학교", 3); 
		Student s2 = new Student("감조은", 21, "한국대학교", 3); 

		// 이몽룡과 김철수는 친구 사이임을 나타내는 코드
		p.friend = s1;   // p의 friend 필드는 Student 객체인 s1을 참조(업캐스팅)
		s1.friend = p; 	 // s1의 friend 필드는 Person 객체인 p를 참조

		// 이몽룡과 감조은이 서로 만났다는 것을 나타내기 위한 코드
		p.meets(s2);    // meet() 메소드의 매개변수는 Student 객체인 s2(업캐스팅)
		s2.meets(p);    // meet() 메소드의 매개변수는 Person 객체인 p

		System.out.println("\n  * " + p.name + "의 친구: " + p.friend.name);
		System.out.println("\n  * " + s1.name + "의 친구: " + s1.friend.name);

		System.out.println("\n  * " + p.name + "의 마지막 만난 사람: "                                                                                                                    
				+ p.personLastMet.name);
		System.out.println("\n  * " + s2.name + "의 마지막 만난 사람: " 
				+ s2.personLastMet.name);

		p.output();
		s1.output();
		s2.output();
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 프로그램을 살펴보고 friend, PersonLastMet 필드와  meet() 메소드의 매개변수 p에 Person 객체 외에 
 *      Student 객체가 저장됨을 확인하라.
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 * 
 * [ 실습 과제 ]
 * 
 *   1) 다음 작업을 수행한 후 객체를 출력하라.
 *   
 *      (1) main()에서  자신을 나타내는 Student 객체와 친구인  Student 객체를 추가로 생성하라.
 *      
 *      (2) 자신과 친구 객체 사이에 친구임을  나타내도록  friend 필드에 값을 서로 저장하라.
 *      
 *      (3) 자신과 친구가 만난 것을 나타내기 meet() 메소드를 서로 호출하라.
 *      
 *      (4) 자신과 친구 객체를 출력하여 결과 확인하라.
 *      
 *   2) Person 클래스의 friend 필드에 친구 객체를 직접 저장한다. 이는 좋지 않은 코딩 기법이다.
 *      이를 개선하기 위해 다음의 작업을 수행하라.
 *      
 *      (1) Person 클래스에 친구 설정하는 메소드인  void isFriendWith(Person friend)를 작성하라.
 *      
 *      (2) main() 메소드에서 친구를 필드에 저장하는 코드를  이 메소드 호출로 변경하라.
 */
