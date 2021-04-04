package ex6_3_8_class_with_method_using_vector;

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
 *     - int makeMoney(int amount) : 주어진 금액만큼을 돈을 번 것을 처리하는 메소드 
 *                                   번 금액 amount만큼 보유현금을 증가시키고 보유현금을 반환함
 *     - goTo(String location) : 매개변수의 장소로 이동을 처리
 *     - buyBook(String title, String author, String publisher, int price) : 
 *          매개변수의 책 정보들로 책 객체 생성하여 구매한 것을 처리
 *     - buyBook(Book book, int cnt) : 책을 여러 권 구매하는 행동을 구현
 *
 *   o 가다, 책 구매하다 등의 행동에 대한 이력 관리
 *     - 개수 제한이 없는 이력을 관리하도록 buyBook() 메소드와 goTo() 메소드 구현
 *     - java.util.Vector 클래스를 이용하여 여러 데이터를 편리하게 관리
 *   
 *   
 *   o java.util.Vector 클래스
 *     - 배열보다 여러 데이터를 편리하게 저장하고 검색하는 기능 제공하는 클래스
 *     - Vector 객체에 저장되는  여러 데이터 중  하나를 원소라 함
 *   
 *     - 사용하기 위해서 반드시 import 해야 함
 *         import java.util.Vector;   // java.util.Vector를 반드시 import
 *   
 *     - 여러 데이터 저장하기 위한 Vector 객체 생성 및 참조변수에 저장    
 *       Vector<저장할-원소-클래스> 참조변수 = new Vector<저장할-원소-클래스>();  // 저장할 원소 클래스를 <와 > 사이에 표시함
 *     
 *       Vector<String> locs = new Vector<String>();     // 여러 위치의 문자열 저장하기 위한 vector 객체 생성하여 locs가 참조하게 함
 *       Vector<Book> booksBuying = new Vector<Book>();  // 여러 구매한 책 저장하기 위한 vector 객체 생성하여 booksBuying이 참조하게 함
 *     
 *     - 원소 저장하고 검색하기 위한 메소드
 *   
 *       void add(Object o): Vector 객체의 끝  위치에 원소 o를 저장하는 메소드
 *       Object get(int index): Vector 객체의 위치 index에 저장된 원소를 구하여 반환하는  메소드(index는 0부터 시작)
 *         
 *     - Vector 객체에 원소 저장하기  
 *       locs.add("광화문");      // "광화문"을 locs에 추가
 *       booksBuying.add(b);     // 책 객체 b를 booksBuying에 추가
 *     
 *     - Vector 객체에 저장된 i번째 위치의 원소 구하기       
 *       String loc = locs.get(0);  // locs에 저장된 원소들 중 첫 원소 구해 loc에 저장
 *       Book b = booksBuying.get(booksBuying.size() -1);  // booksBuying에 저장된 원소들 중 마지막 원소를 구해 b에 저장
 *          
 *   o 객체의 출력을 위한 메소드
 *     - public String toString() : 객체의 필드명과 필드값들을 문자열로 구성하여 반환
 *     - output(String msg) : msg와 toString()의 결과 출력
 */

class Person {
   String 	name;    	     	  // 이름
   int    	age;		     	  // 나이
   String 	currentLocation;  	  // 현위치

   //** makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드를 위한 필드들

   Vector<String> prevLocs = new Vector<String>(); // 이전 위치들 저장하는 Vector 객체 

   int  moneyHaving = 0;     // 보유현금 저장하는 필드

   Vector<Book>  booksBuying = new Vector<Book>(); // 구매한 책들 저장하는 Vector 객체 

   // 객체 생성자: 이름, 나이가 주어지면 이를 객체의 필드 값으로 저장
   Person(String name, int age) {
      this.name = name; this.age = age; 
   }

   /*
    *  makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드
    */

   // makeMoney(): 주어진 금액만큼을 돈 번 것 처리하는 메소드
   //   번 금액 amount만큼 보유현금을 증가시키고 보유현금 반환함
   int makeMoney(int amount) {
      this.moneyHaving += amount;  // 번 금액만큼 보유현금 증가

      return this.moneyHaving;     // 보유현금 반환
   }

   // goTo(): "가다" 행동 구현하는 메소드
   //   location으로 필드 currentLocation으로 변경함
   void goTo(String location) {      
      this.addToPrevLocs(this.currentLocation); // 현위치를 이전 위치에 추가함
      this.currentLocation = location;          // 현 위치를 주어진 location으로 변경
   }
 
   // buyBook(): "책을 구매하다" 행동 구현하는 메소드
   //   매개변수인 책 정보항목들로 Book 객체 생성하여 buyBook() 메소드 호출
   //   구매한 후의 보유현금을 반환
   int buyBook(String  title,  String   author,  String   publisher,  int  price) {
	   Book book = new Book(title, author, publisher, price); // 책 정보항목으로  Book 객체 생성, book이 참조
	   return this.buyBook(book);                             // book 객체를 매개변수로 하여 buyBook() 메소드 호출
   }

   // buyBook(): "책을 구매하다" 행동 구현하는 메소드
   //   보유 책권수를 1 증가하고 책 가격만큼 보유현금을 감소한 뒤 보유현금을 반환
   int buyBook(Book book) {
       this.addToBooksBuying(book);     // 구매한 책 book들에 추가시킴
       this.moneyHaving -= book.price;  // 보유현금을 책 가격 book.price만큼 감소

       return this.moneyHaving;
   }
  
   // buyBook(): "책을 여러 권 구매하다" 행동 구현하는 메소드
   //   매개변수로 주어진 cnt 권수만큼 book 구매 처리하고 최종 보유현금 반환 
   int buyBook(Book book, int cnt) {
	   int moneyHaving = this.moneyHaving;
	   
       while(cnt-- > 0) {
    	   moneyHaving = this.buyBook(book);  // book을 구매 처리함
       }
       
       return moneyHaving;
   }
      
  /*
   * makeMoney(), goTo(), buyBook() 등 행동을 구현한 메소드를 위한 메소드  
   */

  // addToPrevLocs(): 주어진 위치를 이전 위치에 추가시키는 메소드
  void addToPrevLocs(String location) { 
     if (location == null) return;

     this.prevLocs.add(location);	// 이전 위치를 저장하는 Vector 객체 prevLocs에 loc 추가
  }

  // addToBooksBuying(): 주어진 책을 구매한 책들에 추가시키는 메소드
  void addToBooksBuying(Book book) { 
     this.booksBuying.add(book); 	// 구매한 책을  저장하는 Vector 객체 booksBuying에 book 추가     
  }

  // Vector 객체에 저장된 이전 위치들을 "[ "과 " ]" 사이의 문자열로 구성하여 반환하는 메소드
  String prevLocsToString() {
     String locs = "[ ";
     int cnt = this.prevLocs.size();
     
     for(int i = 0; i < cnt; i++)
        locs += this.prevLocs.get(i)   // get(i)는 i 위치의 원소를 구하는 메소는
              +  (( i < cnt - 1) ? ", " : "" );
     
     return locs + " ]";
  }
  
  // Vector 객체에 저장된 구매 책들의 제목들을 "[ "과 " ]" 사이의 문자열로 반환하는 메소드
  String booksBuyingToString() {
     String books = "[ ";
     int cnt = this.booksBuying.size();
     
     for(int i = 0; i < cnt; i++)
        books += this.booksBuying.get(i).title   // get(i)는 i 위치의 원소를 구하는 메소는
                               + (( i < cnt - 1) ? ", " : " ");
     return books + "]";
  }

  // toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
  public String toString() {
     return "이름:" + this.name + ", 나이:" + this.age
       + "세, 보유현금:" + this.moneyHaving 
       + "원\n        현위치:" + this.currentLocation + ", 이전 위치:" 
       + this.prevLocsToString() + ", 구매한 책:" + this.booksBuyingToString();
  }

  // output(): 객체의 필드명과 필드값 출력하는 메소드
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

   // output(): Book 객체의 필드명과 필드값 출력하는 메소드
   void output(String msg) {
     System.out.println(msg + this.toString());
   }
}

class Ex6_3_8_PersonMgmt {
  public static void main(String[] args) {
     Person p = new Person("김철수",  23);    // 23세의 김철수가 있다.
     p.goTo("광화문");                        // 김철수가 광화문에 갔다

     int moneyAfter1 = p.makeMoney(300000);  // 김철수가 30만원을 벌었다.
     p.goTo("교보문고");                       // 김철수가 교보문고에 갔다

     // 홍길동전과 스티브 잡스 자서전 책을 김철수가 구매
     int moneyAfter2 = p.buyBook("홍길동전", "허균", "민음사", 10000);
     int moneyAfter3 = p.buyBook("스티브 잡스", "월터 아이작슨", "민음사", 19800);

     p.goTo("집");                           // 김철수가 집에 갔다 

     // 김철수 객체의 모든 상태를 출력함
     p.output("\n  * 김철수 현황 - ");

     // 30만원 번 후, 홍길동전 구매 후, 스티브 자서전 구매 후의 보유현금 출력
     System.out.println("\n  * 30만원 번 후 보유현금: " + moneyAfter1 + "원");
     System.out.println("\n  * 홍길동전 구매 후 보유현금: " + moneyAfter2 + "원");
     System.out.println("\n  * 스티브 잡스 구매 후 보유현금: " + moneyAfter3 + "원");
   }
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 java.util.Vector 클래스를 이용하여 개수 제한 없이 이전 위치와 구매한 책을 저장한다. 
 *   
 *      java.util.Vector 클래스는 나중에 배울 내용이므로 개략적으로 파악할 것
 *      
 *   2) 프로그램을 실행하고 결과를 확인하라.
 *   
 *      이전 프로그램과 결과는 동일하지만 프로그램이 훨씬 간단함을 알 수 있다.
 *      
 *      
 * [ 실습 과제] (응용력 향상을 위해 도전해볼 과제)
 *  
 *   1) 본인의 가상적인 이동하기, 돈 벌기, 책 구매하기 등을 다음 예를 참고하여 자연스러운
 *      한국어 문장으로 작성하라.
 *       
 *      나 20세 홍길동은 (어제 아르바이트하여) 5만원 벌었다. (아침에) 학교로 갔다. (학교에서) 18314 강의실로 갔다. 
 *      (교보문고 홈페이지에서) 리차드 바크의 갈매기의 꿈(현문사, 11500원) 을 구매했으며, 또 다른 책 …을 구매했다.
 *       
 *   2) 1)에서 작성한 내용을 나타내고 본인 정보를 출력하는 코드를 main() 메소드에 추가 작성하라.
 *    
 *   3) 행동을 구현한 메소드의 구현 수준에 따라 프로그램 작성이 달라짐을 확실히 느껴지는가?
 */
