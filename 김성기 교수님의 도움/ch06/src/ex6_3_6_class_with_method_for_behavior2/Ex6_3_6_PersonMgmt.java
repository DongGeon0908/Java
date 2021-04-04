package ex6_3_6_class_with_method_for_behavior2;

/** 
 * [ Person, Book, PersonMgmt 클래스 ] :
 *      "23세의 김철수가 교보문고에 가서 출판사가 민음사이고 가격이 1만원인 
 *      허균의 홍길동전을 구매하였다."라는 상황을 나타내는Java 프로그램
 *                 
 *   o 클래스 유형 4: 행동을 구현한 메소드를 갖는 클래스
 *     - 객체의 행동이 행해지면 행동의 결과로 객체의 상태가 변화됨
 *     - 행동을 구현한 메소드는 세부 작업을 수행하여 결과적으로 필드 값을 변경함
 *     - 메소드가 잘 작성되면 객체의 행동을 자연스럽게 나타낼 수 있음 
 *
 *   o 행동을 구현한 메소드
 *     - goTo(String location) : 매개변수의 장소로 이동을 처리
 *     - buyBook(String title, String author, String publisher, int price) : 
 *         매개변수의 책 정보들로 책 객체 생성하여 구매한 것을 처리
 *
 *   o 객체의 출력을 위한 메소드
 *     - public String toString() : 객체의 필드명과 필드값들을 문자열로 구성하여 반환
 *     - output(String msg) : msg와 toString()의 결과를 출력
 *     - outputBookBuying(String msg) : msg와 구매한 책 정보를 출력
 *   
 *   o 행동을 구현한 메소드가 잘 작성되면 main() 메소드 작성이 용이함
 */

class Person {
	String 	name;    	       
	int    	age;		         
	String 	currentLocation;  
	Book  	bookBuying;     	 

	// 이름, 나이가 매개변수로 주어지면 이를 필드 name, age에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  	 
		this.age = age;    	 
	}

	// goTo(): "가다" 행동을 구현하는 메소드
	//   주어진 장소로 가면 그 장소가 현위치가 되므로 
	//   매개변수 location을 필드 currentLocation에 저장
	void goTo(String location)  {
		this.currentLocation = location;  // 현 위치를 주어진 location으로 변경
	}

	// buyBook(): "책을 구매하다" 행동을 구현하는 메소드
	//   매개변수인 책 정보항목들로 Book 객체 생성하여 bookBuying 필드에 저장
	void buyBook(String  title,  String   author,  String   publisher,  int  price) {
		Book book = new Book(title, author, publisher, price); // 책 정보항목으로  Book 객체 생성, book이 참조
		this.bookBuying = book;                                // 생성된  book 객체를 bookBuying 필드에 저장
	}


	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	//    이 메소드는 반드시 작성되어야 하는 메소드 중의 하나임
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age + "세, 현위치:"
				+ this.currentLocation + ", 구매한 책 제목:" + this.bookBuying.title;
	}

	// output(): 객체의 필드명과 필드값을 주어진 msg와 함께 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}

	// bookBuying 필드의 구매한 책을 msg와 함께 출력하는 메소드: 작성해 놓으면 구매한 책 객체 출력 용이함
	void outputBookBuying(String msg) {
		this.bookBuying.output(msg);  // 구매한 책 정보를 Book 클래스의 output() 메소드로 출력
	}
}

class Book {
	String	title;      
	String 	author;  	
	String 	publisher;	
	int    	price;		

	// 제목, 저자, 출판사명, 가격이 매개변수로 주어지면 이를 필드 title, author 
	//   publisher, price에 저장하는 객체 생성자
	Book(String title, String 	author, String 	publisher, int price) {
		this.title = title;    		
		this.author = author;  	    
		this.publisher = publisher; 
		this.price = price;    		
	}

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	// 이 메소드는 반드시 작성되어야 하는 메소드 중의 하나임
	public String toString() {
		return "제목: " + this.title + ", 저자: " + this.author + ", 출판사: " 
				+ this.publisher + ", 가격: " + this.price;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Ex6_3_6_PersonMgmt {
	public static void main(String[] args) {

		Person p = new Person("김철수", 23);          // 23세의 김철수가 있다
		p.goTo("교보문고");                           // 김철수가 교보문고로 갔다

		// 민음사 출판사의 가격 1만원인 허균의 홍길동전 책을 김철수가 구매
		p.buyBook("홍길동전", "허균", "민음사", 10000); 

		p.output("\n  * 김철수 객체 - ");                // 김철수 객체 출력
		p.outputBookBuying("\n  * 김철수 구매한 책 - ");  // 김철수가 구매한 책 출력
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램을 살펴보고 클래스의 메소드를 파악하라.
 *   
 *      - Person 클래스에서 변경되고 추가된 buyBook(), outputBookBuying()
 *        메소드 파악
 *
 *      - buyBook() 메소드에서는 매개변수로 주어진 책 정보 이용하여 책 객체 생성하고 
 *        구매한 책으로 저장 확인(Book 객체는 Person의 내부에서만 관리됨)
 *        
 *      - outputBookBuying()에서는 구매한 책 정보를 구매자가 출력하게 함
 *   
 *   2) 프로그램을 실행하고 결과를 확인하라.  
 *   
 *  
 * [ 실습과제 ]
 * 
 *   1) 본인의 이동정보와 책 구매정보를 다음 예를 참고하여 자연스러운 한국어 문장으로 작성하라.
 *   
 *       나 20세 홍길동은 (아침에) 학교로 갔다. (학교에서) 18314 강의실로 갔다.
 *       나는 (교보문고 홈페이지에서) 리차드 바크의 갈매기의 꿈(현문사, 11500원)에 구매했다.
 *       
 *   2) 1)에서 작성한 내용을 나타내고 본인 정보와 책 정보 출력하는 코드를 main() 메소드에 
 *      추가 작성하라.
 *      
 *   3) 행동 구현한 메소드를 잘 작성한 경우의 차이점이 확실히 느껴지는가?     
 */
