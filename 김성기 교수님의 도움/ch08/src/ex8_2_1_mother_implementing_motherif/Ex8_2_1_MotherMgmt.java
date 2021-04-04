package ex8_2_1_mother_implementing_motherif;

/**
 * [ Person, Female, MotherIF, Mother, MotherMgmt 인터페이스 및  클래스  ] 
 *        motherIF 인터페이스 구현하는 하위 클래스 Mother 
 *
 *   o 인터페이스(interface)
 *     - 필드로는 public static final 필드만 가질 수 있음
 *     - 메소드로는 abstract 메소드, default 메소드, static 메소드 가질 수 있음
 *     - 객체를 생성할 수 없으며, 구현하는 하위 클래스에서 객체 생성 가능
 *     
 *     - 인터페이스를 구현하는 하위 클래스는 반드시  abstract 메소드 구현해야 함
 *     - 인터페이스는 타입으로 사용되어 인터페이스 객체 참조변수 선언할 수 있으며,
 *       인터페이스 객체 참조변수는 하위 클래스의 객체 참조함
 *     - 인터페이스를 구현하는 여러 하위 클래스들의 객체는 인터페이스 객체도 되므로 통합적으로 관리될 수 있음
 *     
 *   o 인터페이스 구현하는 하위 클래스
 *     - 한 클래스는 여러 인터페이스를 구현할 수 있음
 *     - 인터페이스 구현하는 클래스는 인터페이스의 하위 클래스, 인터페이스는 그 클래스의 상위 인터페이스가 됨
 *     - 인터페이스 구현하는 하위 클래스는 반드시 상위 인터페이스의  abstract 메소드 구현해야 함
 *     - 인터페이스 구현하는 하위 클래스 객체는 상위 인터페이스 타입도 가지게 되므로 
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

// 여성을 나타내는 인터페이스
interface Female { 
	public static final String gender = "여성"; 	// public static final은 생략해도 됨 
	
	public default String getGender(){  // 성별을 반환하는 default 메소드
		return gender;
	}	
}  		

// 어머니를 나타내는, Female의 하위 인터페이스 MotherIF
interface MotherIF extends Female { 
	public void setChild(Person p);	// Person 객체 p를 자식으로 등록하는 메소드
	public Person[] getChildren();  // 자녀들을 Person[] 배열로 반환하는 메소드
	public int getNoChildren();    	// 자녀수를 반환하는 메소드  
	
	// 주어진 Person 객체 c의 어마니 여부 검사하는 default 메소드
	default boolean isMotherOf(Person c) {  
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// MotherIF 인터페이스 구현하는 Mother 클래스
//   Mother 클래스는 Person의 하위 클래스로 선언되어야 하지만 
//   이 프로그램에서는 하위 클래스로 선언하지 않으므로 Person 클래스의 필드와 메소드를 모두 선언함 
class Mother implements MotherIF { 
	String name;  int age; String currentLocation;

	Mother(String name, int age) {
		this.name = name; this.age = age;
	}
	
	void goTo(String location) {
		this.currentLocation = location;
	}
	
	public String toString() {
		return null; // 이 메소드를 작성하라.
	}
	
	public void output() {
		// 이 메소드를 작성하라.
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
} 

class Ex8_2_1_MotherMgmt {
	public static void main(String[] args) {
		
		// 인터페이스를 구현한 클래스의 객체 생성
		Mother scMom = new Mother("심청엄마", 20);
		
		// 심청을 심청엄마의 딸로 등록
		Person sc = new Person("심청", 1);
		scMom.setChild(sc);
		System.out.println("\n  * 심청엄마 자녀수: " + scMom.getNoChildren());
		

		// Mother 객체는 MotherIF 객체 참조변수에 저장 가능함
		MotherIF pdMom = new Mother("뺑덕어미", 22);
		
		// 뺑덕과 뺑순을 뻉덕어미의 딸로 등록
		Person pd, ps;
		pdMom.setChild(pd = new Person("뺑덕", 3));
		pdMom.setChild(ps = new Person("뺑순", 1));
		System.out.println("\n  * 뺑덕어미 자녀수: " + pdMom.getNoChildren());   	
		
		// MotherIF 인터페이스의 default 메소드 호출
		System.out.println("\n  * 심청엄마의 심청 어머니 여부 : " + scMom.isMotherOf(sc));
		System.out.println("\n  * 심청엄마의 뺑덕 어머니 여부 : " + scMom.isMotherOf(pd));
		System.out.println("\n  * 뺑덕어미의  뺑순 어머니 여부 : " + pdMom.isMotherOf(ps));
		
		// Female 인터페이스의 default 메소드 호출
		System.out.println("\n  * 심청엄마의 성별 : " + scMom.getGender());
		
        // Mother 객체는 MotherIF 배열의 원소로 저장 가능함
		MotherIF[] moms = new MotherIF[10];  // MotherIF 배열변수 선언
		moms[0] = scMom;                     // 심청엄마를 0 위치에 저장
		moms[1] = pdMom;                     // 뺑덕어미를 1 위치에 저장     		
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Female, MotherIF 인터페이스를 작성하였으며, MotherIF 인터페이스를 구현하는 
 *      Mother 클래스를  작성하였다.
 *      
 *   2) Female 인터페이스의 필드를 확인하라.
 *      - 인터페이스의 필드는 public static final 필드만 가능하다.
 *      - public static final은 생략될 수 있으나 초기 값은 반드시 주어야 한다.
 *      
 *   3) 인터페이스는 abstract 메소드, default 메소드, static 메소드를 가질 수 있다.
 *      - MotherIF 인터페이스의 abstract 메소드를 확인하라.
 *      - MotherIF 인터페이스의 default 메소드를 확인하라.      
 *      - Female 인터페이스의 default 메소드를 확인하라.
 *        
 *   4) MotherIF 인터페이스의 abstract 메소드가 모두  Mother 클래스에서 구현되었음을 확인하라.
 *      abstract 메소드 구현을 위해 추가된 필드들도 확인하라.
 *      
 *   5) Mother 클래스는 구현한 인터페이스와 별개로 객체생성자, 필드, 메소드를 가짐을 확인하라.
 *   
 *   6) 인터페이스를 구현한 클래스는 객체를 생성할 수 있음을 main() 메소드의 
 *      << Mother scMom = new Mother("심청엄마", 20); >> 문장에서 확인하라.
 *   
 *   7) 인터페이스를 구현한 클래스의 객체는 인터페이스 타입을 가지므로 인터페이스의 객체 참조변수에 저장할 수 있음을  
 *      main() 메소드의 << MotherIF pdMom = new Mother("뺑덕어미", 22); >> 문장에서 확인하라.
 *   
 *   8) 인터페이스를 구현한 클래스의 객체는 인터페이스 타입을 가지므로 인터페이스의 배열변수에 저장할 수 있음을
 *      main() 메소드의 << moms[0] = scMom;  >> 문장에서 확인하라.
 *      
 *   9) 인터페이스에 작성된 default 메소드와 static 메소드 호출할 수 있음을 확인하라.
 *   
 *   10) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) Person 클래스를 참조하여  Mother 클래스의 필드 값을 문자열로 구성하고 출력하는 public toString() 메소드와 
 *      void output() 메소드를 작성하고 이 메소드를 이용하여 생성된 Mother 클래스 객체들을 출력하라. 
 *      이때  gender, 자녀수, 자녀들의 이름, 나이, 현위치 등도 출력되어야 한다.
 *      
 *      moms 배열에 저장된  Mother 클래스 객체들을 for 문과 output() 메소드를 이용하여 모두 출력하라.
 *   
 *   2) default boolean isMale() 메소드는 성별이 남성이면 true를 반환하는 default 메소드이며, 
 *      default boolean isFemale()는 성별이 여성이면 true를 반환하는 default 메소드이다.
 *      
 *      Female 인터페이스에 이들 메소드를 작성하고 심청엄마의 남성 여부와 뺑덕엄마의 여성 여부를 이들 메소드를 이용하여 
 *      출력하라.
 *          
 *   3) GrandMotherIF 인터페이스는 Female 인터페이스의 하위 인터페이스이며, 추가로 다음의 메소드를 가진다.
 *   
 *       	public void setGrandChild(Person p);	// Person 객체 p를 손자로 등록하는 메소드
 *   	    public Person[] getGrandChildren();     // 손자들을 Person[] 배열로 반환하는 메소드
 *          public int getNoGrandChildren();    	// 손자수를 반환하는 메소드 
 *          
 *          default boolean isGrandMotherOf(Person c) { ... }  // 주어진 Person 객체 c의 할머니 여부 검사하는 default 메소드	
 *      
 *      (1) GrandMotherIF 인터페이스를 작성하라.
 *      
 *      (2) GrandMotherIF 인터페이스를 구현하는 GrandMother 클래스를 Mother 클래스를 참조하여
 *          작성하라.
 *      
 *      (3) main() 메소드에서 심청 할머니와 뺑덕 할머니를 나타내는  GrandMother 클래스의 객체 2개를 생성하고 
 *          이를  GrandMother 객체 참조변수와 GrandMotherIF 객체 참조변수에 저장하고  
 *          손자인 심청과 뺑덕을 저장한 후 객체를 출력하라.
 *      
 *      (4) main() 메소드에서 GrandMotherIF 인터페이스의 배열 변수를 선언하고
 *          생성된 2 객체를 이 배열의 원소로 저장하고 배열 원소를 모두  출력하라.
 */
