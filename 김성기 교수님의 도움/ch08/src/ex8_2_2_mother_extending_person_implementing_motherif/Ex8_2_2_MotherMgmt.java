package ex8_2_2_mother_extending_person_implementing_motherif;

/**
 * [ Person, Female, MotherIF, Mother, MotherMgmt 인터페이스 및  클래스 ] :
 *        클래스 확장하면서 인터페이스 구현하는 하위 클래스 Mother를 작성한 예제
 *   
 *   o 인터페이스(interface)의 필드와 메소드
 *     - 필드로는 public static final 필드만 가질 수 있음
 *     - 메소드로는 abstract 메소드, default 메소드, static 메소드 가질 수 있음
 *     
 *   o 인터페이스(interface)의 특징
 *     - 객체 생성할 수 없으며, 구현하는 하위 클래스에서 객체 생성 가능
 *     - 인터페이스 구현하는 하위 클래스는 반드시 abstract 메소드 구현해야 함
 *     - 인터페이스는 타입으로 사용되어 인터페이스 객체 참조변수를 선언할 수 있음
 *     - 인터페이스 객체 참조변수는 하위 클래스의 객체 참조함
 *     - 인터페이스 구현하는 여러 하위 클래스들의 객체는 인터페이스의 객체도 되므로 통합적으로 관리될 수 있음
 *     
 *   o 클래스 확장하면서 인터페이스 구현하는 하위 클래스
 *     - 클래스 확장하는 하위 클래스는 여러 인터페이스 구현할 수 있음
 *     - 인터페이스 구현하는 클래스는 인터페이스의 하위 클래스, 인터페이스는 그 클래스의 상위 인터페이스가 됨
 *     - 인터페이스 구현하는 하위 클래스는 반드시 상위 인터페이스의 abstract 메소드 구현해야 함
 *     - 인터페이스 구현하는 하위 클래스 객체는 상위 클래스 타입 뿐 아니라 상위 인터페이스 타입도 가지게 되므로 
 *       상위 인터페이스의 객체 참조변수에 저장되어 참조될 수 있음
 */

// Person 클래스
//   필드 name, age, currentLocation
//   메소드 goTo(), output()을 갖는 클래스
class Person {
	String name;     int age;     String currentLocation;

	// 이름, 나이, 장소가 주어지면 필드에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  this.age = age; 
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드.
	void goTo(String location) {
		this.currentLocation = location;
	}

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Object 클래스의 메소드를 오버라이딩시킨 것임
	public String toString() {
		return "이름:" + this.name + ", 나이: " + this.age 
				+ ", 현위치: " + this.currentLocation;  
	}

	// 객체의 필드들을 출력하는 메소드
	void output() {
		System.out.println("  * 사람 - " + this.toString());
	}
}

//여성을 나타내는 인터페이스
interface Female { 
	public static final String gender = "여성"; 	// public static final은 생략해도 됨 
	
	public default String getGender(){ // 성별을 반환하는 default 메소드
		return gender;
	}	
}

//어머니를 나타내는, Female의 하위 인터페이스 MotherIF
interface MotherIF extends Female { 
	public void setChild(Person p);	// Person 객체 p를 자식으로 등록하는 메소드
	public Person[] getChildren();  // 자녀들을 Person[] 배열로 반환하는 메소드
	public int getNoChildren();    	// 자녀수를 반환하는 메소드  
	
	default boolean isMotherOf(Person c) {  // 주어진 Person 객체 c의 어마니 여부 검사하는 default 메소드
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// Person 클래스 확장하면서 MotherIF 인터페이스 동시에 구현하는 Mother 클래스
//   상위 클래스인 Person 클래스의 필드와 메소드 상속받음
//   상위 인터페이스인 MotherIF의 abstract 메소드를 모두 구현함
class Mother extends Person implements MotherIF { 

	Mother(String name, int age) {
		super(name, age);  // 상위 클래스 Person의 객체 생성자 호출
	}
	
	/*
	 * MotherIF 인터페이스의 abstract 메소드를 구현하기 위한 코드
	 */

	Person[] children = new Person[20]; // 최대 20명의 자녀를 저장할 수 있는 배열
	int noChildren = 0;

	// MotherIF의 abstract 메소드 setChild()의 구현
	//   주어진 Person 객체를 자녀로 지정하는 메소드
	public void setChild(Person p) {
		children[noChildren++] = p;
	}

	// MotherIF의 abstract 메소드 getChildren()의 구현
	//   자녀들을 Person[] 배열로 반환하는 메소드
	public Person[] getChildren() {
		Person[] cs = new Person[noChildren];  // 자녀들 저장할 Person 배열 cs 생성

		for (int i= 0; i < noChildren; i++)    // 모든 자녀 객체를 cs[]에 복사
			cs[i] = children[i];

		return cs;
	}

	// MotherIF의 abstract 메소드 getNoChildren()의 구현
	//   자녀수를 반환하는 메소드
	public int getNoChildren() {
		return noChildren;
	}	
	
	public String toString() {
		return null; // 이 메소드를 작성하라.
	}
	
	public void output() {
		// 이 메소드를 작성하라.
	}
} 

class Ex8_2_2_MotherMgmt {
	public static void main(String[] args) {
		Mother scMom = new Mother("심청엄마", 20);
		scMom.setChild(new Person("심청", 1));
		System.out.println("\n  * 심청엄마 자녀수: " + scMom.getNoChildren());
		
		// Mother 객체는 MotherIF 객체 참조변수에 저장 가능함
		MotherIF pdMom = new Mother("뺑덕어미", 22);
		pdMom.setChild(new Person("뺑덕", 3));
		pdMom.setChild(new Person("뺑순", 1));
		System.out.println("\n  * 뺑덕어미 자녀수: " + pdMom.getNoChildren());   	

		// Mother 객체는 Person 객체 참조변수에 저장 가능함
		Person chMom = new Mother("월매", 20);
		((Mother) chMom).setChild(new Person("춘향", 1));  // 다운캐스팅하여 하위 클래스 메소드 호출
		System.out.println("\n  * 월매 자녀수: " + ((Mother) chMom).getNoChildren());   	
		
		MotherIF[] moms = new MotherIF[10];  // MotherIF 배열변수 선언
		moms[0] = scMom;                     // 심청엄마를 0 위치에 저장
		moms[1] = pdMom;                     // 뺑덕어미를 1 위치에 저장     
		moms[2] = (MotherIF) chMom;          // 춘향 엄마를 다운캐스팅하여 2 위치에 저장   
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은  Female, MotherIF 인터페이스를 작성하였으며, MotherIF 인터페이스를 구현하면서 Person 클래스를 확장하는 
 *      Mother 클래스를  작성하였다.
 *      
 *   2) MotherIF 인터페이스의 abstract 메소드가 모두  Mother 클래스에서 구현되었음을 확인하라.
 *      abstract 메소드를 위해 추가된 필드들도 확인하라.
 *      
 *   3) Mother 클래스의 상속 특성, 객체생성자, 필드, 메소드를 확인하라.
 *   
 *   4) 인터페이스를 구현한 클래스는 객체를 생성할 수 있음을 main() 메소드의 
 *      << Mother scMom = new Mother("심청엄마", 20); >> 문장에서 확인하라.
 *   
 *   5) 인터페이스를 구현한 클래스의 객체는 인터페이스 타입을 가지므로 인터페이스의 객체 참조변수에 저장할 수 있음을  
 *      main() 메소드의  << MotherIF pdMom = new Mother("뺑덕어미", 22); >> 문장에서 확인하라.
 *   
 *   6) 하위 클래스의 객체는 상위 클래스 타입을 가지므로 상위 클래스의 객체 참조변수에 저장될 수 있음을  
 *      main() 메소드의 << Person chMom = new Mother("월매", 20); >> 문장에서 확인하라.
 *   
 *   7) 인터페이스를 구현한 클래스의 객체는 인터페이스 타입을 가지므로 인터페이스의 배열변수에 저장할 수 있음을
 *      main() 메소드의 << moms[0] = scMom;  >> 문장에서 확인하라.
 *      
 *   8) 프로그램 실행하고 결과 확인하라.
 *      
 *   
 * [ 실습 과제 ]
 * 
 *   1) GrandMotherIF 인터페이스는 MotherIF 인터페이스의 하위 인터페이스이며 추가적으로 다음의 메소드를 가진다.
 *   
 *       	public void setGrandChild(Person p);	// Person 객체 p를 손자로 등록하는 메소드
 *   	    public Person[] geGrandChildren();      // 손자들을 Person[] 배열로 반환하는 메소드
 *          public int getNoGrandChildren();    	// 손자수를 반환하는 메소드  
 *          
 *          default boolean isGrandMotherOf(Person c) { ... }  // 주어진 Person 객체 c의 할머니 여부 검사하는 default 메소드	
    
 *      
 *      (1) GrandMotherIF 인터페이스를 작성하라.
 *      
 *      (2) Person 클래스 확장하면서 GrandMotherIF 인터페이스를 구현하는 GrandMother 클래스를 
 *          Mother 클래스를 참조하여 작성하라.
 *      
 *      (3) main() 메소드에서 심청 할머니와 뺑덕 할머니를 나타내는  GrandMother 클래스의 객체 2개를 생성하여 
 *          이를  GrandMother 객체 참조변수와 GrandMotherIF 객체 참조변수에 저장하고  
 *          손자인 심청과 뺑덕을 저정한 후 객체를 출력하라.
 *      
 *      (4) main() 메소드에서 GrandMotherIF 인터페이스의 배열 변수를 선언하고
 *          생성된 2 객체를 이 배열의 원소로 저장하고 배열 원소를 모두  출력하라.
 */
