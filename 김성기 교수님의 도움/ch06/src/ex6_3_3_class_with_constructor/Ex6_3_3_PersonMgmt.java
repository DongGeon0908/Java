// 여기의 클래스들은 ex6_3_3_class_with_constructor 패키지에 포함되는 클래스임을 나타냄
package ex6_3_3_class_with_constructor;

/**
 * [ Person, Book, PersonMgmt 클래스 ] 
 *       "23세의 김철수가 교보문고에서 민음사에서 출판한 정가 10000원의  홍길동전을 구매하였다"라는 
 *       상황을 객체생성자 이용하여 나타내는 본격적인 Java 프로그램
 * 
 *   o 클래스 유형 3: 객체 생성자 갖는 클래스
 *     - 클래스는 객체 생성자 가지며, setter 메소드 있음
 *     - 객체 생성자: 객체를 생성하면서 수행되는 특별한 메소드
 *     - 객체 생성과 객체 필드 값 저장이 한 문장으로 이루어지므로 프로그램이 간결해짐 
 */

class Person {
	String 	name;    	      	// 이름을 저장할 필드
	int    	age;		        // 나이를 저장할 필드
	String 	currentLocation; 	// 현위치를 저장할 필드
	Book  	bookBuying;     	// 구매한 책 저장하는 필드: Book 객체를 참조함

	// 이름, 나이, 장소가 매개변수로 주어지면 이를 
	//   필드 name, age, currentLocation에 저장하는 객체 생성자
	Person(String name, int age, String location) {
		this.name = name;  	    // 매개변수 name을 this 객체의 name 필드에 저장
		this.age = age;    		// 매개변수 age를 this 객체의 age 필드에 저장
		this.currentLocation = location; // location을 currentLocation 필드에 저장
	}

	// Book 클래스의 객체가 매개변수로 주어지면 이를 
	//   필드 bookBuying에 저장하는 필드 값 저장 메소드로, setter 메소드임 
	void setBookBuying(Book book) {
		this.bookBuying = book; // 매개변수 book 객체를 this 객체의 book 필드에 저장
	}
}

class Book {
	String	title;  	             // 제목을 저장할 필드
	String 	author;                  // 저자를 저장할 필드
	String 	publisher;	             // 출판사명을 저장할 필드
	int    	price;		             // 가격을 저장할 필드

	// 제목, 저자, 출판사명, 가격이 매개변수로 주어지면 이를 필드 title, author 
	//   publisher, price에 저장하는 객체 생성자
	Book(String	 title, String 	author, String 	publisher, int price) {
		this.title = title;    		 // 매개변수 title을 title 필드에 저장
		this.author = author;  	 	 // 매개변수 author를 author 필드에 저장
		this.publisher = publisher;  // 매개변수 publisher를 publisher 필드에 저장
		this.price = price;    		 // 매개변수 price를 price 필드에 저장
	}
}

class Ex6_3_3_PersonMgmt {
	public static void main(String[] args) {
		// 객체 생성자를 호출하여 Person 객체 생성하여 p가 참조하게 함
		Person p = new Person("김철수", 23, "교보문고");

		// 객체 생성자를 호출하여 Book 객체 생성하여 b가 참조하게 함
		Book b = new Book("홍길동전", "허균", "민음사", 10000);  

		// setBookBuying() 메소드를 이용하여 김철수가 구매한 홍길동전 Book 객체를 
		//   p의 bookBuying 필드에 저장
		p.setBookBuying(b);         

		System.out.println("\n  * Person 객체 - 이름: " + p.name + ", 나이: " + p.age
				+ ", 현위치: " + p.currentLocation + ", 구매한 책: " + p.bookBuying.title);
		System.out.println("\n  * Book 객체 - 제목: " + b.title + ", 저자: " + b.author
				+ ", 출판사: " + b.publisher + ", 가격: " + b.price);
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 예제 6-3-3 프로그램을 살펴보고 정의된 클래스를 파악하라.
 *   
 *   2) Person 클래스의 객체 생성자 선언과 호출을 파악하라. 
 *   
 *   3) Book 클래스의 객체 생성자 선언과 호출을 파악하라.
 *   
 *  
 * [ 실습과제 ]
 * 
 *   1) 본인의 정보를 저장하기 위하여 Person 객체를 생성하면서 객체 생성자를 호출하고 생성된 
 *      객체를 새로운 객체 참조변수에  저장한 후 출력하는 코드를 main()에 추가 작성하라.
 *      
 *   2) 본인이 최근에 구매한 책 정보를 저장하기 위하여 Book 객체를 생성하면서 객체 생성자를 
 *      호출하고 생성된 객체를 새로운 객체 참조변수에 저장한 후 출력하는 코드를 main()에 추가 작성하라.
 *      
 *   3) 객체 초기화 메소드 갖는 클래스와 객체 생성자 갖는 클래스의 차이점이 느껴지는가?
 *   
 *   4) Person 클래스에 키와 외국인 여부를 나타내는 필드를 추가하라. 그리고 이들 필드도 
 *      초기화하도록 객체 생성자를 변경하라. 또한 main() 메소드의 객체 생성과 초기화 코드도 변경하라.
 *      
 *   5) 환자정보(환자ID, 이름, 성별, 생년월일, 주소) 저장을 위한 Patient 클래스, 
 *      진료정보(진료날짜, 진료시간(분), 진료비) 저장을 위한 Treat 클래스를  작성하라. 
 *      이들 클래스는 객체 생성자를 반드시 가져야 한다.
 *      
 *      main() 메소드를 갖는 PatientMgmt 클래스를 작성하여 Patient 클래스 객체와
 *      Treat 클래스 객체를 객체 생성자를 이용하여 생성하고 출력하라.
 *      
 *   6) 야구 선수 중 타자의 소속팀명, 이름, 연봉, 평균 안타율 등의 필드를 갖는 Hitter 클래스와  
 *      특정 경기에서의 타자 기록을 보여주는 경기날짜, 타석수, 타수수, 안타수, 포볼 회수, 몸에 맞은 볼 회수, 
 *      아웃 회수, 희생 플라이 회수 등을 필드로  갖는 GameRecord 클래스를 작성하라. 
 *      이들 클래스는 객체 생성자를 가져야 한다.
 *      
 *       단, GameRecord 클래스에는 타자를 나타내는 필드인 hitter 필드를 다음과 같이   반드시 선언한다.
 *       
 *        class GameRecord {
 *           Hitter hitter;   // 이 기록이 어느 타자의 기록인가를 나타내기 위한 필드
 *              ...           // 이 타자의 경기 기록을 나타내는 필드들 
 *       }
 *       
 *       main() 메소드를 갖는 RecordMgmt 클래스를 작성하여 한국 프로야구 선수 2명의  
 *       최근 2경기 기록을 나타내는 코드를 작성하고 결과를 출력하라.
 */
