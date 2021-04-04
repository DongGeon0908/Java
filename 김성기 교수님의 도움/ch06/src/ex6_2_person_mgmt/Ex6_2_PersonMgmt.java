package ex6_2_person_mgmt;

/** 
 * [ Person, PersonMgmt 클래스 ] :
 *      "홍길동은 18살에 금강산으로 갔고, 20세인 이몽룡은 서울로 갔다."라는 
 *      상황 나타내는 프로그램 작성하기 
 *      
 *   o Java 프로그램은 여러 클래스로 구성
 *     - 클래스: 객체의 필드(field)와 메소드(method) 선언 
 *     - 필드: 객체의 상태(state) 나타내는 변수
 *     - 메소드: 객체의 행동(behavior) 나타내는 문장들을 메소드 이름으로 추상화
 */

class Person {
	String 	name;    	     	// 이름을 저장할 필드
	int    	age;		     	// 나이를 저장할 필드
	String 	currentLocation; 	// 현위치를 저장할 필드

	// Person 클래스의 객체 생성자: 클래스 이름과 같으면서 반환값이 없는 메소드
	//   생성된 객체를 this가 참조하고 매개변수 name을 this 객체의 필드에 저장
	Person(String name) {   
		this.name = name;      // 주어진 name을 객체 this의 name 필드에 저장
	}

	// Person 클래스의 객체 생성자: 클래스 이름과 같으면서 반환값이 없는 메소드
	//   생성된 객체를 this가 참조하고 매개변수 name과 age를 this 객체의 필드에 저장
	Person(String name, int age) {   
		this.name = name;     // 주어진 name을 객체 this의 name 필드에 저장
		this.age = age;       // 주어진 age를 객체 this의 age 필드에 저장
	}

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것을 나타내는 메소드
	//   주어진 위치로 수신자의 currentLocation 필드 값이 변경됨
	void goTo(String location) {
		this.currentLocation = location;  // 장소로 이동하면 현 위치가 변경           
	}

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "이름: " + this.name + ", 나이: " + this.age + ", 현위치: " 
				+ this.currentLocation;  
	}

	// 주어진 objectMessage와 객체의 필드들을 출력하는 메소드
	void output(String objectMessage) {
		System.out.println(objectMessage + this.toString());
	}
}

class Ex6_2_PersonMgmt {
   public static void main(String[] args) {
      Person p1;                        	// 홍길동 객체 참조할 p1 참조변수 선언
      p1 = new Person("홍길동");          	// 이름이 홍길동인 사람이 있음
                                           
      p1.age = 18;                	     	// 홍길동의 age를 18로 저장
      p1.goTo("금강산");           	     	// 홍길동이 금강산으로 감
                
      p1.output("  * 홍길동 객체 - ");        	// 홍길동 객체의 정보를 출력

      // "20세의 이몽룡이 서울로 갔다."를 나타내는 코드
      Person p2 = new Person("이몽룡", 20); 	// 이몽룡 객체 참조할 p2 참조변수 
           	                              	// 선언하고 객체 생성하여 참조하게 함                                          
      p2.goTo("서울");                     	// 이몽룡이 서울로 감
                
      p2.output("  * 이몽룡 객체 - ");        	// 이몽룡 객체의 정보를 출력      
   }
}

/* 
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 정의된 클래스를 파악하라.
 *   
 *      이 프로그램은 지금 단계에서 확실히 이해할 수 있는 프로그램이 아니라, 
 *      최종적으로 작성해야할 목표를 제시하는 프로그램이다.
 *      
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *
 *
 * [ 실습과제 ]
 *
 *   o 다음의 스토리에 대해 필요한 작업을 수행하는 문장들을 
 *     main() 메소드 아래 부분에 추가로 작성하고 각 객체를 출력하라.     
 *     (괄호 부분은 작성할 수 없으므로 문장으로 작성하지 않는다)
 *       
 *     " 서울로 간 이몽룡은  20세가 되어  (장원급제하여 암행어사가 되어 춘향을 만나러 ) 남원 춘향집으로 갔다. 
 *      (춘향이가 집에 없으니) 이몽룡은 남원 감옥으로 가서 (춘향을 만났다.)
 *         
 *      이름이 성춘향인 사람이 있다. 성춘향은 16세가 되어 광한루로 놀러가서 
 *      (이몽룡을 만났다. 서울로 가는 이몽룡을 눈물로 배웅하고) 남원 춘향집으로 돌아가서 
 *      (지내는 중 변학도의 수청을 거부하여) 남원 감옥에 가게 되었다.
 *      춘향은 18세에(이몽룡을 다시 만나) 서울로 가서 (어떻게 되었을까?)"   
 *
 *
 * [ 참고사항 ]
 * 
 *     이 실습과제는 프로그램을 이해하고서 작성하는 과제가 아니다. main() 메소드에 작성된 문장들을 
 *     보고서 유추하여 주어진 이몽룡과 성춘향의 상황을 나타낼 수 있도록 추가로 작성하는 것이다.    
 *     
 *     이 과제를 스스로 할 수 있으면 상황판단 능력과 응용력이 매우 뛰어난 것이며,
 *     할 수 없다면 하지 않아도 되지만, 한번 시도해 보기 바란다.            
 */

