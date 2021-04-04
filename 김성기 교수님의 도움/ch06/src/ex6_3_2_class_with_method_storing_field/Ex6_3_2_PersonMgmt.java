// 여기의 클래스들은 ex6_3_2_class_with_method_storing_field 패키지에 포함되는 클래스임을 나타냄
package ex6_3_2_class_with_method_storing_field;

/**
 * [ Person, Book, PersonMgmt 클래스 ] :
 *       "23세의 김철수가 교보문고에서 민음사에서 출판한 정가 10000원의 
 *       홍길동전을 구매하였다"라는 상황을 나타내는 초보적인 Java 프로그램
 *     
 *   o 클래스 유형 2: 필드 값 저장 메소드 갖는 클래스
 *     - 필드 값 저장 메소드는 필드 값 초기화 메소드와 setter 메소드가 있음
 *     - 객체 생성 후 필드 값 저장 메소드를 이용하여 편리하게 필드에 값 저장 
 *     
 *   o 필드 초기화 메소드
 *     - 객체 생성 직후 매개변수로 주어지는 값들을 필드값들로 저장하는 메소드
 *     - initialize 또는 initializePerson 등 초기화 나타내는 메소드 이름 사용
 *     - 한 클래스에서 여러 필드 초기화 메소드 작성 가능
 *   
 *   o setter 메소드
 *     - 매개변수로 주어지는 하나의 값을 필드값으로 저장하는 메소드
 *     - setName, setAge 등과 같이 ≪ set+필드명 ≫의 메소드 이름 사용
 *     - 한편, setter 메소드의 반대 기능인 필드 값 반환하는 getter 메소드도 있음
 *     - 모든 필드에 대해 setter 메소드 작성할 수 도 있으며, 특정 필드에 대해서만
 *       setter 메소드 작성할 수도 있음
 */

class Person {
	String 	name;    	     // 이름을 저장할 필드
	int    	age;		     // 나이를 저장할 필드
	String 	currentLocation; // 현위치를 저장할 필드
	Book  	bookBuying;      // 구매한 책 저장하는 필드: Book 객체를 참조하는 필드

	// 이름, 나이, 장소가 매개변수로 주어지면 이를 
	//   필드 name, age, currentLocation에 저장하는  필드 값 저장 메소드, 필드 초기화 메소드임
	void initializePerson(Person this, String name, int age, String location) {
		this.name = name;  // 매개변수 name을 this 객체의 name 필드에 저장
		this.age = age;    // 매개변수 age를 this 객체의 age 필드에 저장
		this.currentLocation = location; // location을 currentLocation 필드에 저장
	}

	// Book 클래스의 객체가 매개변수로 주어지면 이를 
	//   필드 bookBuying에 저장하는 필드 값 저장 메소드, setter 메소드임 
	void setBookBuying(Book book) {
		this.bookBuying = book;   // 매개변수 book 객체를 this 객체의 book 필드에 저장
	}
}

class Book {
	String		title;  // 제목을 저장할 필드
	String 	author;    	// 저자를 저장할 필드
	String 	publisher;  // 출판사명을 저장할 필드
	int    	price;		// 가격을 저장할 필드

	// 제목, 저자, 출판사명, 가격이 매개변수로 주어지면  
	//   이를 필드 title, author, publisher, price에 저장하는 필드 값 저장 메소드, 필드 초기화 메소드임
	void initializeBook(String	 title, String 	author, String 	publisher, int price) {
		this.title = title;    // 매개변수 title을 title 필드에 저장
		this.author = author;  // 매개변수 author를 author 필드에 저장
		this.publisher = publisher; // 매개변수 publisher를 publisher 필드에 저장
		this.price = price;    // 매개변수 price를 price 필드에 저장
	}
}

class Ex6_3_2_PersonMgmt {
	public static void main(String[] args) {
		
		// Person 객체 생성하여 p가 참조하게 하고 여러 필드 값 저장
		Person p = new Person(); 
		p.initializePerson("김철수", 23, "교보문고");

		// Book 객체 생성하여 b가 참조하게 하고 여러 필드 값 저장
		Book b = new Book();     
		b.initializeBook("홍길동전", "허균", "민음사", 10000);  

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
 *   1) 여기의 Person 클래스와 Book 클래스는 필드 초기화 메소드와 setter 메소드만 가지au,
 *      다른 메소드는 없다.
 *   
 *   2) 이 경우 이들 클래스의 객체를 생성한 이들 필드값 저장 메소드를 이용하여 필드에 값을 저장할 수 있다.
 *   
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) Person 클래스에 키와 외국인 여부를 나타내는 필드를 첨가하고 필드 초기화 메소드와 main() 메소드를 수정하라.
 *    
 *   2) 환자정보(환자ID, 이름, 성별, 생년월일, 주소) 저장을 위한 Patient 클래스, 
 *      진료정보(진료날짜, 진료시간(분), 진료비) 저장을 위한 Treat 클래스를 작성하라.
 *       
 *      main() 메소드를 갖는 PatientMgmt 클래스를 작성하여 Patient 클래스 객체와 Treat 클래스 객체를 생성하고 
 *      필드 값 저장 메소드를 이용하여 필드 값 저장한 후 출력하라.
 *  
 *   3) 야구 선수 중 타자의 소속팀명, 이름, 년봉, 평균 안타율 등의 필드를 갖는 Hitter 클래스와 
 *      특정 경기에서의 타자 기록을 보여주는 경기날짜, 타석수, 타수수, 안타수, 포볼 회수, 몸에 맞은 볼 회수, 아웃 회수, 
 *      희생 플라이 회수 등을 필드로 갖는 GameRecord 클래스를 작성하라.
 *       
 *      main() 메소드를 갖는 RecordMgmt 클래스를 작성하여 추신수 선수와 박병호 선수에 대한 최근상황을 나타내는 
 *      코드를 작성하고 결과를 출력하라.
 */
