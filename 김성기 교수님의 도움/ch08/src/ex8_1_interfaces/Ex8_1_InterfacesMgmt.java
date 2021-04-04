package ex8_1_interfaces;

/**
 * [ Person 클래스와 여러 인터페이스들  ] : 여러 인터페이스들을 보이는 예제
 * 
 *   o 인터페이스(interface)의 필드와 메소드
 *     - 필드로 public static final 필드만 가질 수 있음
 *     - 메소드로 abstract 메소드, default 메소드, static 메소드 가질 수 있음
 *     
 *     - abstract 메소드: 메소드 구현이 생략된 메소드로, 인터페이스에서는 abstract 키워드가 생략된 메소드도
 *                       abstract 메소드
 *     - default 메소드: 구현 부분을 가지는 객체 메소드를 인터페이스에서는 default 메소드라 함, 
 *                      그 이유는 default 수식어가 없으면  abstract 메소드와 혼동되기 때문
 *     - static 메소드: static 키워드가 붙은 클래스 메소드이며 구현부분을 가짐
 *     
 *     - JDK 1.9부터는 private 메소드도 가능하게 됨
 *     
 *   o 인터페이스(interface)의 특징
 *     - 객체를 생성할 수 없으며, 구현하는 하위 클래스에서 객체 생성 가능
 *     - 인터페이스를 구현하는 하위 클래스는 반드시 abstract 메소드 구현해야 함
 *     - 인터페이스는 타입으로 사용되어 인터페이스 객체 참조변수 선언할 수 있음
 *     - 인터페이스 객체 참조변수는 하위 클래스의 객체를 참조할 수 있음
 *     - 인터페이스를 구현하는 여러 하위 클래스들의 객체는 인터페이스 객체도 되므로 통합적으로 관리될 수 있음
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

	// output(): Person 객체의 모든 필드 값을 출력하는 메소드
	void output() {
		System.out.println("  * 사람 - 이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation);
	}
}

 // 남성을 나타내는 인터페이스
 interface Male { 
	public static final String gender = "남성"; 	//  public static final은 생략해도 됨
	
	public static String getGender() {  // 성별을 반환하는 static 메소드
		return gender;
	};             
}		

// 여성을 나타내는 인터페이스
interface Female { 
	public static final String gender = "여성"; 	//  public static final은 생략해도 됨 
	
	static String getGender(){            // 성별을 반환하는 static 메소드
		return gender;
	}    
}  		

interface Adult { 
	int MINADULTAGE = 19;	        	  // 성년 최소 나이
}  	

// 미성년자를 나타내는 Minor 인터페이스	
interface Minor { 
	public static int MAXMINORAGE = 18;  // 미성년 최대 나이
}  

// Male의 하위 인터페이스 Boy
interface Boy extends Male { 
}	  

// 어머니를 나타내는, Female의 하위 인터페이스 MotherIF
abstract interface MotherIF extends Female { 
	public void setChild(Person p);	  // Person 객체 p를 자식으로 등록하는 메소드
	public abstract Person[] getChildren();  // 자녀들을 Person[] 배열로 반환하는 메소드
	public int getNoChildren();    	  // 자녀수를 반환하는 메소드  
	
	default boolean isMotherOf(Person c) {  // 주어진 Person 객체 c의 어머니인가를 검사하는 default 메소드
		 Person[] children = getChildren();
		 for (Person p : children)
			 if (p == c)
				 return true;

		 return false;
	}
} 

// 성인 남자를 나타내는, Male과 Adult를 확장한 하위 인터페이스 AdultMale
interface AdultMale extends Male, Adult {
}  

// 성인 여자를 나타내는, Female과 Adult를 확장한 하위 인터페이스 AdultFemale
interface AdultFemale extends Female, Adult {
} 


class Ex8_1_InterfacesMgmt {
	public static void main(String[] args) {
		
		new Male();         // 인터페이스는 객체를 생성할 수 없으므로 이 문장은 오류를 발생함
		
		// 인터페이스 객체 참조변수: 이들 변수에는 인터페이스의 하위 클래스 객체가 저장됨
		Male m1;   		    // m1은 Male 인터페이스의 객체 참조변수
		MotherIF mo;		// mo는 MotherIF 인터페이스의 객체 참조변수
		AdultMale am;		// am은 AdultMale 인터페이스의 객체 참조변수
		
		// 인터페이스 배열변수: 이들 배열변수에는 인터페이스의 하위 클래스 객체들이 저장됨
		Male[] ms = new Male[20];           // ms는 Male 객체 저장하는 배열변수
		MotherIF[] moms = new MotherIF[20]; // moms는 MotherIF 객체 저장하는 배열변수
		
		// 인터페이스의 static 필드는 상속됨
		System.out.println("  * Male.gender: " + Male.gender +", Female.gender: " + Female.gender);
	    System.out.println("  * Boy.gender: " + Boy.gender +", MotherIF.gender: " + MotherIF.gender);
	    
	    // 인터페이스의 static 메소드는 상속되지 않음, Boy.getGender()와 MotherIF.getGender()는 오류
		System.out.println("  * Male.gender: " + Male.getGender() + ", Female.gender: " + Female.getGender());
		System.out.println("  * Boy.gender: " + Boy.getGender() + ", MotherIF.gender: " + MotherIF.getGender());
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 인터페이스를 작성하였다. 각 인터페이스의 필드를 확인하라.
 *      - 인터페이스의 필드는 public static final 필드만 가능하다.
 *      - public static final은 생략될 수 있으나 초기 값은 반드시 주어져야 한다.
 *      
 *   2) 인터페이스에 작성된 메소드를 확인하라.
 *      - 인터페이스는 abstract 메소드, default 메소드, static 메소드를 가질 수 있다.
 *      - MotherIF 인터페이스의 abstract 메소드를 확인하라.
 *      - MotherIF 인터페이스의 default 메소드를 확인하라.      
 *      - Male, Female 인터페이스의 static 메소드를 확인하라.
 *      
 *   3) 인터페이스도 다른 인터페이스를 확장할 수 있음을 Boy, MotherIF, AdultMale, AdultFemale 인터페이스를 
 *      통해 확인하라.
 *      
 *   4) 인터페이스는 여러 인터페이스를 확장할 수 있음을  AdultMale, AdultFemale 인터페이스를 통해 확인하라.
 *   
 *   5) 인터페이스는 객체를 생성할 수 없음을 main() 메소드의 << new Male(); >> 문장에서 확인하라.
 *   
 *   6) 인터페이스는 객체를 생성할 수 없지만 객체 참조 변수와 배열변수를 선언할 수 있음을  
 *      main() 메소드의 << Male m1; >>, << Male[] ms = new Male[20]; >> 문장에서 확인하라.
 *      
 *   7) 상위 인터페이스의 static 필드 gender는 히위 인터페이스 Boy와 MotherIF로 상속됨을 확인하라.
 *   
 *   8) 상위 인터페이스의 static 메소드 getGender()는 히위 인터페이스  Boy와 MotherIF로 상속되지 않음을 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) main()의 << new Male(); >>에서의 오류를 없애기 위해서는 인터페이스의 하위 클래스의 객체를 생성하여야 한다.
 *      현재 인터페이스의 하위 클래스가 작성되지 않았으므로 오류 발생 문장을 제거하여 오류를 없애라.
 *     
 *   2) Boy.getGender()와  MotherIF.getGender()를 호출하는 main()의 마지막 문장은 오류이다.
 *      이는 상위 인터페이스의 static 메소드는 하위 인터페이스로 상속되지 않기 때문이다.
 *      
 *      마지막 문장을 제거하고 프로그램을 실행하여 결과 확인하라.
 *      
 *   3) 객체 참조변수가 선언되지 않은 인터페이스의 객체 참조변수와 배열 변수를 선언하라.
 */
