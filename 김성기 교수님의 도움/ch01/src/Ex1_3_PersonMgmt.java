/**
 * [ Person, PersonMgmt ]: "홍길동은 18살에 금강산으로 갔다."라는 
 *                          상황 나타내는 클래스들 작성하기 
 * 
 *   o 프로그래밍 스타일 
 *     1) 여러 클래스로 구성되며, 한 클래스는 여러 필드와 여러 메소드로 구성
 *     2) 객체가 생성되어 활동함
 */

/*
 * Person 클래스: Person 객체의 상태와 행동을 나타내기 위한 클래스
 */
class Person {
	String name;    		// 이름 필드
	int    age;				// 나이 필드
	String currentLocation;	// 현위치 필드

	// 매개변수 name이 주어지면 필드 name을 초기화하는 생성자
	Person(String name) {	
		this.name = name;  
	}

	// 매개변수 age가 주어지면 필드 age를 저장하는 메소드	
	void setAge(int age) {
		this.age = age;
	}  

	// goTo(): 수신자 객체가 특정 위치로 이동하는 것 나타내는 메소드
	//   주어진 위치로 수신자의 currentLocation 필드 값이 변경
	void goTo(String location) {
		this.currentLocation = location;  // 특정 장소로 이동하면 현 위치 변경

	}

	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//  이 메소드는 아주 중요한 메소드이므로 꼭 기억하도록 할 것!
	public String toString() {
		return "이름: " + this.name + ", 나이: " + this.age + ", 현위치: " + this.currentLocation;  
	}

	// 주어진 objectMessage 출력하고 객체의 필드들 출력하는 메소드
	void output(String objectMessage) {
		System.out.println(objectMessage + this.toString());
	}
}

/*
 * Ex1_3_PersonMgmt 클래스: Person 객체 생성하고 메소드 호출하여 행동하게 하는 클래스
 */
class Ex1_3_PersonMgmt {
	public static void main(String[] args) {

		System.out.println("\n\n  ** Person Management **\n");

		// "홍길동이라는 이름의 사람이 18세에 금강산으로 갔다"를 나타내는 코드
		Person hgd;                 	// 홍길동 객체 저장할 hgd 참조변수 선언
		hgd = new Person("홍길동");  	    // 이름이 홍길동인 사람이 있음

		hgd.setAge(18);              	// 홍길동의 age를 18로 지정함
		hgd.goTo("금강산");           	// 홍길동이 금강산으로 감

		hgd.output("  * 홍길동 객체 - ");   // 홍길동 객체의 정보 출력

		// 이 부분에 아래 이몽룡의 상황 나타내는 코드를 작성할 수 있으면 해보라.

		// 이 부분에 아래 성춘향의 상황 나타내는 코드를 작성할 수 있으면 해보라.

	}
}

/* 
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *   
 *      이 프로그램은 지금 단계에 이해할 수 있는 프로그램이 아니라, 
 *      최종적으로 작성할 목표를 제시하는 프로그램이다.
 *      
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *
 *
 * [ 실습과제 ]
 *
 *   o 다음의 스토리에 대해 필요한 작업을 수행하는 문장들을 Ex1_3_PersonMgmt 클래스의 
 *     main() 메소드 아래 부분에 추가로 작성하고 각 객체를 출력하라.     
 *     (괄호 부분은 작성할 수 없으므로 문장으로 작성하지 않는다)
 *       
 *     "이름이 이몽룡인 사람이 있다. 이몽룡은 서울로 갔다. 
 *      20세가 되어 이몽룡은 (장원급제하여 암행어사가 되어 춘향을 만나러) 남원 춘향집으로 갔다. 
 *      (춘향이가 집에 없으니) 이몽룡은 남원 감옥으로 가 (춘향을 만났다.)
 *         
 *      이름이 성춘향인 사람이 있다. 성춘향은 16세가 되어 광한루로 놀러가 
 *      (이몽룡을 만났다. 서울로 가는 이몽룡을 눈물로 배웅하고) 춘향집으로 돌아가 
 *      (지내는 중 변학도의 수청을 거부하여) 남원 감옥에 가게 되었다.
 *      춘향은 18세에(이몽룡을 다시 만나) 서울로 가 (어떻게 되었을까?)"   
 *
 *
 * [ 참고사항 ]
 * 
 *     이 실습과제는 프로그램을 이해하고 작성하는 과제가 아니다. main() 메소드에 작성된 문장들을 
 *     보고 유추하여 주어진 이몽룡과 성춘향의 상황 나타낼 수 있도록 추가로 작성하는 것이다.    
 *     
 *     이 과제 할 수 있는 경우 상황판단 능력과 응용력이 매우 뛰어난 것이며,
 *     할 수 없다면 하지 않아도 무방하나 한번 시도해 보기 바란다.            
 */
