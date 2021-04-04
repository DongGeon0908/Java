package ex6_3_7_class_with_method_for_more_behaviors;

import java.util.Vector;   // Vector 클래스 사용하기 위해 import

/**
 * [ Person, Book, PersonMgmt 클래스 ]: 
 *       "23세의 김철수가 30만원을 벌고 광화문으로 갔다가 교보문고에 가서 출판사가 민음사이고
 *       가격이 1만원인 허균의 홍길동전과 출판사가 민음사이고 가격이 19800원인  
 *       저자 월터 아이작슨의 스티브 잡스를 구매했다"라는 상황을 나타내는 Java 프로그램
 *                
 *   o 클래스 유형 4: 행동을 구현한 메소드를 갖는 클래스
 *     - 객체의 행동이 행해지면 행동의 결과로 객체의 상태가 변화됨
 *     - 행동을 구현한 메소드는 세부 작업을 수행하여 결과적으로 필드 값을 변경함
 *     - 메소드가 잘 작성되면 객체의 행동을 자연스럽게 나타낼 수 있음 
 *     
 *   o 행동을 구현한 메소드
 *     - int makeMoney(int amount): 주어진 금액만큼을 돈을 번 것을 처리하는 메소드. 번 금액 amount만큼 보유현금을 증가시키고 보유현금을 반환함
 *     - goTo(String location) : 매개변수의 장소로 이동을 처리
 *     - buyBook(String  title,  String   author,  String   publisher,  int  price) : 매개변수의 책 구매한 것을 처리
 *     - buyBook(Book book, int cnt): 책을 여러 권 구매하는 행동을 구현
 *
 *   o 가다, 책 구매하다 등의 행동에 대한 이력 관리
 *     - 최대 20개의 이력을 관리하도록 buyBook() 메소드와 goto() 메소드 구현
 *     - addToBooksBuying(() 메소드와 addtoPrevLocs() 메소드를 추가로 작성함
 *   
 *   o 객체의 출력을 위한 메소드
 *     - public String toString() : 객체의 필드명과 필드값들을 문자열로 구성하여 반환
 *     - output(String msg) : msg와 toString()의 결과를 출력
 */

class Person {
	String 	name;    	     	  // 이름
	int    	age;		     	  // 나이
	String 	currentLocation;  	  // 현위치

	//** makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드를 위한 필드들

	int      cntPrevLocs = 0;     // 이전 위치의 개수를 저장하는 필드
	String[] prevLocs = new String[20]; // 최대 20개 이전 위치들를 저장하는 배열

	int     moneyHaving = 0;     // 보유현금을 저장하는 필드

	int     cntBooksBuying = 0;  // 구매한 책 권수를 저장하는 필드
	Book[]  booksBuying = new Book[20]; // 최대 20권 구매한 책들을 저장하는 배열  

	// 객체 생성자: 이름, 나이가 주어지면 이를 객체의 필드 값으로 저장
	Person(String name, int age) {
		this.name = name; this.age = age; 
	} 

	//** makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드

	// makeMoney(): 주어진 금액만큼을 돈을 번 것을 처리하는 메소드
	//   번 금액 amount만큼 보유현금을 증가시키고 보유현금을 반환함
	int makeMoney(int amount) {
		this.moneyHaving += amount;  // 번 금액만큼 보유현금을 증가

		return this.moneyHaving;     // 보유현금을 반환
	}

	// goTo(): 주어진 장소로 이동하는 것을 처리하는 메소드
	//   location으로 필드 currentLocation으로 변경함
	void goTo(String location) {      
		this.addToPrevLocs(this.currentLocation); // 현위치를 이전 위치에 추가함
		this.currentLocation = location;          // 현 위치를 주어진 location으로 변경
	}

	// buyBook(): 책을 구매하다라는 행동을 구현하는 메소드
	//   매개변수인 책 정보항목들로 Book 객체 생성하여 buyBook() 메소드 호출
	//   구매한 후의 보유현금을 반환
	int buyBook(String  title,  String   author,  String   publisher,  int  price) {
		Book book = new Book(title, author, publisher, price); // 책 정보항목으로  Book 객체 생성, book이 참조
		return this.buyBook(book);                             // book 객체를 메게변수로 하여 buyBook() 메소드 호출
	}

	// buyBook(): 책을 구매한 것을 처리하는 메소드
	//   보유 책권수를 1 증가하고 책 가격만큼 보유현금을 감소한 뒤 보유현금을 반환
	int buyBook(Book book) {
		this.addToBooksBuying(book);     // 구매한 책 book들에 추가시킴
		this.moneyHaving -= book.price;  // 보유현금을 책 가격 book.price만큼 감소

		return this.moneyHaving;
	}

	// buyBook(): 책을 구매한 것을 처리하는 메소드
	//   보유 책권수를 1 증가하고 책 가격만큼 보유현금을 감소한 뒤 보유현금을 반환
	int buyBook(Book book, int cnt) {
		int moneyHaving = this.moneyHaving;

		while(cnt-- > 0) {
			moneyHaving = this.buyBook(book);  // 보유현금을 책 가격 b.price만큼 감소
		}

		return moneyHaving;
	}


	/*
	 * makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드를 위한 메소드  
	 */

	// addToPrevLocs(): 주어진 위치를 이전위치에 추가시는 메소드
	void addToPrevLocs(String location) { 
		if (location == null) return;

		if (this.cntPrevLocs < 20)                  	    // 추가할 여유가 있으면
			this.prevLocs[this.cntPrevLocs++] = location;	//   이전 위치에 추가
		else {                                         	// 추가할 여유가 없으면
			this.deleteFirstFromPrevLocs();         		//    첫 이전위치 삭제
			this.prevLocs[19] = location;            		//    마지막에 추가
		}
	}

	// addToBooksBuying(): 주어진 책을 구매한 책들에 추가시는 메소드
	void addToBooksBuying(Book book) { 
		if (this.cntBooksBuying < 20)                    		// 추가할 여유가 있으면
			this.booksBuying[this.cntBooksBuying++] = book; 	//    구매한 책 추가
		else {                                        			// 추가할 여유가 없으면
			this.deleteFirstFromBooksBuying();             		//     첫 구매한 책 삭제
			this.booksBuying[19] = book;                   		//     마지막에 추가
		}
	}

	// 이전 위치들 중 첫 번째를 삭제하여 새로운 이전 위치 저장할 공간 확보하는 메소드
	void deleteFirstFromPrevLocs() {  
		// 미완성된 부분: 이 부분을 완성하라.
	}

	// 구매 책들 중 첫 번째를 삭제하여 새로운구메 책 저장할 공간 확보하는 메소드
	void deleteFirstFromBooksBuying() {
		// 미완성된 부분: 이 부분을 완성하라.
	}

	// 배열에 저장된 이전 위치들을 "[ "과 " ]" 사이의 문자열로 구성하여 반환하는 메소드
	String prevLocsToString() {
		String locs = "[ ";
		for(int i = 0; i < this.cntPrevLocs; i++)
			locs += prevLocs[i] +  (( i < this.cntPrevLocs - 1) ? ", " : "" );
		return locs + " ]";
	}
	// 배열에 저장된 구매 책들의 제목들을 "[ "과 " ]" 사이의 문자열로 반환하는 메소드
	String booksBuyingToString() {
		String books = "[ ";
		for(int i =0; i < this.cntBooksBuying; i++)
			books += this.booksBuying[i].title 
			+ (( i < this.cntBooksBuying - 1) ? ", " : " ");
		return books + "]";
	}

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age
				+ "세, 보유현금:" + this.moneyHaving 
				+ "원\n        현위치:" + this.currentLocation + ", 이전 위치:" 
				+ this.prevLocsToString() + ", 구매한 책:" + this.booksBuyingToString();
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Book {
	String	title, author, publisher;  // 제목, 저자, 출판사명을 저장할 필드
	int    	price;		     		   // 가격을 저장할 필드

	// 객체 생성자: 제목, 저자, 출판사, 가격이 주어지면 이를 객체의 필드 값으로 저장
	Book(String title, String author, String publisher, int price) {
		this.title = title; this.author = author;
		this.publisher = publisher;  this.price = price;
	}

	// toString(): Book 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "제목: " + this.title + ", 저자: " + this.author + ", 출판사: " 
				+ this.publisher + ", 가격: " + this.price;
	}

	// output(): Book 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	}
}

class Ex6_3_7_PersonMgmt {
	public static void main(String[] args) {
		Person p = new Person("김철수",  23); // 23세의 김철수가 있다.
		p.goTo("광화문");         // 김철수가 광화문에 갔다

		int moneyAfter1 = p.makeMoney(300000); // 김철수가 30만원을 벌었다.
		p.goTo("교보문고");         // 김철수가 교보문고에 갔다

		// 홍길동전과 스티브 잡스 자서전 책을 김철수가 구매
		int moneyAfter2 = p.buyBook("홍길동전", "허균", "민음사", 10000);
		int moneyAfter3 = p.buyBook("스티브 잡스", "월터 아이작슨", "민음사", 19800);

		p.goTo("집");         // 김철수가 집에 갔다 

		// 김철수 객체의 모든 상태를 출력함
		p.output("  * 김철수 현황 - ");

		// 30만원 번 후, 홍길동전 구매 후, 스티브 자서전 구매 후의 보유현금 출력
		System.out.println("\n  • 30만원 번 후 보유현금: " + moneyAfter1 + "원");
		System.out.println("\n  • 홍길동전 구매 후 보유현금: " + moneyAfter2 + "원");
		System.out.println("\n  • 스티브 잡스 구매 후 보유현금: " + moneyAfter3 + "원");
	}
}


/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 가다 행동을 구현한 메소드를 이용하여 20개까지 이전 위치와 구매한 책을 저장한다. 
 *   
 *   2) 행동을 구현한 메소드가 사용된 부분을 잘 살펴보라.
 *      - Person 클래스의 addToPrevLocs(). addToBooksBuying() 메소드 파악 
 *      - 이 프로그램은 작성된 메소드 개수가 17개인 실용적인 프로그램이므로 잘 파악하여 활용할 수 있어야 함
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *      이전 프로그램에 비해 훨씬 복잡하지만 많은 정보를 기록할 수 있음을 확인하라.
 *      
 *      
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램은 최대 20개의 이전 위치와 20권의 구매한 책을 저장한다. 
 *      (1) 최대 몇 개의 이전 위치와 구매한 책을 각각 저장하는 것이 합리적인가를 생각해보라.
 *      
 *      (2) 합리적인 개수의 이전 위치와 구매한 책을 저장하도록 프로그램을 변경하라.
 *      
 *      (3) 이전 위치의 최대 저장 개수와 구매 책의 최대 저장 권수를 변경하기 쉽도록 
 *          프로그램을 수정하라.(static final int 변수를 필드로 선언하면 됨)
 *       
 *   2) 이 프로그램에는 미완성된 코드가 있다. 미완성된 부분을 완성하라.
 *   
 *   3) 행동을 구현한 메소드의 구현 수준에 따라 프로그램 작성이 달라짐을 확실히 느껴지는가?
 */