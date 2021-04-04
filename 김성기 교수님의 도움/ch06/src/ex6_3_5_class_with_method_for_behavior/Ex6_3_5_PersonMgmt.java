package ex6_3_5_class_with_method_for_behavior;

/**
 * [ Person, Book, PersonMgmt 클래스 ] :
 *      "23세의 김철수가 교보문고에 가서 출판사가 민음사이고 가격이 1만원인 
 *       허균의 홍길동전을 구매하였다."라는 상황을 나타내는Java 프로그램
 *         
 *   o 클래스 작성 유형 4: 객체 행동을 구현한 메소드 갖는 클래스
 *     - 객체 행동이 수행되면 행동의 결과로 객체 상태가 변화됨
 *     - 행동을 구현한 메소드는 세부 작업을 수행하여 결과적으로 필드값 변경
 *     - 메소드가 잘 작성되면 객체 행동을 자연스럽게 나타낼 수 있음 
 *   
 *   o 객체 행동을 메소드로 구현하기
 *     - 객체 상태 나타내는 필드 작성: 타입과 이름만 선언하면 되므로 그리 어렵지 않음
 *     - 객체 행동 나타내는 메소드 작성
 *       . 행동에 의해 수행할 세부 작업, 작업과 연관된 필드, 필드 변경내용 파악해야 함
 *       . 경우에 따라 세부 작업이 복잡할 수도 있으며, 여러 다른 메소드 호출할 수도 있음
 *           ==> 메소드는 그 메소드 통해 수행할 작업, 관련된 필드, 필드의 변경 내용  등 명확히
 *               파악한 후 작성해야 함 
 *           
 *   o 행동을 구현한 메소드
 *     - goTo(String location) : 매개변수의 장소로 이동함을 처리
 *     - buyBook(Book book) : 매개변수의 책을 구매한 것을 처리
 *     - String toString() : 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
 *     - output(String msg): 객체의 필드명과 필드값을 msg와 함께 출력하는 메소드
 *     
 *   o 행동을 구현한 메소드가 잘 작성되면 main() 메소드 작성이 용이함
 */

class Person {
	String 	name;    	      	
	int    	age;		      
	String 	currentLocation; 		  
	Book  	bookBuying;     	          // 구매한 책 저장하는 필드: Book 객체 참조

	// 이름, 나이가 매개변수로 주어지면 이를 필드 name, age에 저장하는 객체 생성자
	Person(String name, int age) {
		this.name = name;  		
		this.age = age;    		
	}

	// goTo(String location): "가다" 행동을 구현하는 메소드
	// 매개변수로 주어진 location을 currentLocation 필드에 저장
	void goTo(String location) {
		this.currentLocation = location;  // 현 위치를 주어진 location으로 변경
	}

	// buyBook(Book book): "책을 구매하다" 행동을 구현하는 메소드
	// 책을 구매하면 구매한 책은 그 책이 되므로 
	// 매개변수인 Book 클래스 객체를 bookBuying 필드에 저장
	void buyBook(Book book) {
		this.bookBuying = book;           // 매개변수 book 객체를 bookBuying 필드에 저장
	}

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	// 이 메소드는 반드시 작성해야 하는 메소드 중의 하나임
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age + "세, 현위치:"
				+ this.currentLocation + ", 구매한 책 제목:" + this.bookBuying.title;
	}

	// output(String msg): 객체의 필드명과 필드값을 msg와 함께 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Book {
	String	title;  	
	String 	author;  		
	String 	publisher;		
	int    	price;			 

	// 제목, 저자, 출판사명, 가격이 매개변수로 주어지면 이를 필드 title, author 
	// publisher, price에 저장하는 객체 생성자
	Book(String title, String 	author, String 	publisher, int price) {
		this.title = title;    		 
		this.author = author;  		 
		this.publisher = publisher;  
		this.price = price;    		 
	}

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	// 이 메소드는 반드시 작성해야 하는 메소드 중의 하나임
	public String toString() {
		return "제목: " + this.title + ", 저자: " + this.author + ", 출판사: " 
				+ this.publisher + ", 가격: " + this.price;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Ex6_3_5_PersonMgmt {
	public static void main(String[] args) {

		Person p = new Person("김철수", 23);	// 23세의 김철수가 있다
		p.goTo("교보문고");                   // 김철수가 교보문고로 갔다

		// 출판사가 민음사이고 가격이 1만원인 허균의 홍길동전 책이 있다
		Book b = new Book("홍길동전", "허균", "민음사", 10000);  

		p.buyBook(b);                       // 김철수가 홍길동전을 구매한다 

		p.output("\n * 김철수 객체 - ");       	// 김철수 객체를 출력한다
		b.output("\n * 홍길동전 객체 - ");     	// 홍길동전 객체를 출력한다
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램을 살펴보고 클래스의 메소드를 파악하라.
 *   
 *     -  Person 클래스의 goTo(), buyBook(), toString(), output() 메소드
 *     -  Book 클래스의 toString(), output() 메소드
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
 *   3) 객체 생성자 갖는 클래스와 행동 구현한 메소드 갖는 클래스의 차이점이 확실히 느껴지는가?     
 */
