package ex7_2_4_object_reference_by_object_class;

/**
 * [ Person, Student, ObjectMgmt 클래스 ]: 
 *       Object 클래스의 객체 참조변수의 활용
 *  
 *   o Object 클래스
 *     - 모든 클래스의 상위 클래스이며, 상위 클래스가 없는 최상위 클래스
 *     - 상위 클래스가 명시되지 않은 클래스는 Object 클래스의 하위 클래스
 *    
 *   o Object 클래스의 객체 참조변수
 *     - 모든 타입의 객체를 업캐스팅시켜 저장할 수 있음
 *     - 그러므로 모든 객체를 참조할 수 있음
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
//  상속 특성: Person 클래스의 필드인 name, age, currentLocation, 메소드 goTo()
//  고유 특성: 필드 schoolname, grade, 메소드 goToSchool(), output()
class Student extends Person {
	String schoolname;  // 학교명
	int    grade;				  // 학년

	//이름, 나이가 주어지면 필드에 저장하는 객체 생성자
	Student(String name, int age) {
		super(name, age);  
	}

	//이름, 나이, 학교명, 학년이 주어지면 필드에 저장하는 객체 생성자
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

class Ex7_2_4_ObjectMgmt {
	public static void main(String[] args) {
		System.out.println("\n  **  Object 클래스의 객체 참조변수에 객체 저장하기 **");

		Object obj1, obj2, obj3;
		obj1 = new Student("김영희", 11, "서울초등학교", 4);  // Object 클래스의 참조변수에는Student 타입의 값도 저장 가능
		obj2 = "I like Java!";       // Object 클래스의 참조변수에는 String 타입의 값도 저장 가능
		obj3 = 1;                    // Object 클래스의 참조변수에는 기본 타입의 값인 정수 1도 저장 가능

		System.out.println("\n  * obj1 = " + obj1 + ", obj2 = " + obj2 + ", obj3 = " + obj3);
	
		
		System.out.println("\n\n  **  Object 클래스의 배열변수에 객체 저장하기 **");

		Object[] objs = new Object[10];   // 10개의 Object 객체를 저장하는 배열변수 선언 
		
		objs[0] = new Student("김영희", 11, "서울초등학교", 4);   // 원소에 Student 객체 저장
		objs[1] = "I like Java!";                            // 원소에 문자열 객체 저장
		objs[2] = 1;                                         // 원소에 정수  저장, 실제로는 정수 객체가 저장됨				

		for (int i=0; i < 3; i++)
			System.out.println("\n  * obj[" + i + "] = " + objs[i] );
	}
}

/*
* [ 프로그램 이해 및 실행 ]
* 
*   1) 예제 7-2-4 프로그램을 살펴보고 Object 클래스의 객체 참조변수에 Student 객체, String 객체, 1이 저장됨을 확인하라.
*      
*   2) Object 클래스의 배열변수 원소에 Student 객체, String 객체, 1이 저장됨을 확인하라.
*   
*   3) 프로그램을 실행하고 결과를 확인하라.
*   
*   
* [ 실습과제 ]
* 
*   o 다음을 수행하여 결과 확인하라.
*   
*      (1) main() 메소드에 자신을 나타내는 Person 객체를 생성하여 Object 객체 참조변수 obj2에 저장하라.
*      
*      (2) obj2를 배열원소 objs[3]에 저장하라.
*      
*      (3) obj2와 objs[3]을 output() 메소드를 이용하여 출력하라.
*/
