// 여기의 클래스들은 ex6_3_1_class_with_only_field 패키지에 포함되는 클래스임을 나타냄
package ex6_3_1_class_with_only_field;

/**
 * [ Person, Book, PersonMgmt 클래스 ] : 
 *      "23세의 김철수가 교보문고에서 민음사에서 출판한 정가 10000원의 홍길동전을 구매하였다"라는 
 *      상황을 필드로만 나타내는 가장 초보적인 Java 프로그램
 * 
 *   o 클래스 유형 1: 객체 생성자와 메소드 없이 필드로만 구성되는 클래스
 *     - 객체 생성자 작성하지 않은 클래스는 항상 << new 클래스이름() >>으로 객체 생성
 *     - 생성된 객체는 그 클래스의 객체 참조변수에 저장될 수 있으며, 
 *       << 클래스이름 객체참조변수; >> 형식으로 객체 참조변수 선언
 *       
 *     - << 클래스이름 객체참조변수 = new 클래스이름(); >>은 
 *       객체 생성하여 그 객체를 객체 참조변수에 저장
 *       
 *     - 객체 생성 후 모든 필드를 << 객체참조변수.필드명 >>의 형식으로 직접 접근하여 필드 값 저장 및 이용
 *     
 *   o 필드만 갖는 클래스의 문제점
 *     - 객체의 필드에 값 저장하거나 필드 값 구하기 위해서는 필드 단위로 접근해야 함
 *        ==> 여러 필드 한꺼번에 접근할 수 없음
 *      
 *     - 객체의 행동을 필드 값의 저장으로만 표시할 수 있음
 *        ==> 객체의 행동을 직접 나타내지 못함
 *        ==> 복잡한 처리가 요구되는 행동 나타내기가 어려움
 */

class Person {
	String 	name;    	     // 이름을 저장할 필드
	int    	age;		     // 나이를 저장할 필드
	String 	currentLocation; // 현위치를 저장할 필드
	Book  	bookBuying;      // 구매한 책을 저장하는 필드: Book 객체를 참조하는 필드 
}

class Book {
	String	title;       	// 제목을 저장할 필드
	String 	author;    	    // 저자를 저장할 필드
	String 	publisher;      // 출판사명을 저장할 필드
	int    	price;		    // 가격을 저장할 필드
}

class Ex6_3_1_PersonMgmt {
	public static void main(String[] args) {
		// 김철수 Person 객체 생성하여 p가 참조하게 한 후 필드 값 직접 저장
		Person p = new Person(); 
		p.name = "김철수";  p.age = 23;  p.currentLocation = "교보문고";

		// 홍길동전 Book 객체 생성하여 b가 참조하게 한 후 필드 값 직접 저장
		Book b = new Book();     
		b.title = "홍길동전";     b.author = "허균";  
		b.publisher = "민음사";   b.price = 10000;  

		// 김철수가 구매한 홍길동전 Book 객체를 p의 bookBuying 필드에 저장
		p.bookBuying = b; 

		// 객체들의 필드 값을 직접 구하여 출력
		System.out.println("\n  * Person 객체 - 이름: " + p.name + ", 나이: " + p.age
				+ ", 현위치: " + p.currentLocation + ", 구매한 책: " + p.bookBuying.title);
		
		System.out.println("\n  * Book 객체 - 제목: " + b.title + ", 저자: " + b.author
				+ ", 출판사: " + b.publisher + ", 가격: " + b.price);
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 여기의 Person 클래스와 Book 클래스는 필드만 가지며 다른 메소드가 없다.
 *   
 *   2) 이 경우 이들 클래스의 객체를 생성한 후 직접 필드를 접근하여 필드에 값을 저장하거나 필드 값을 가져올 수 있다.
 *   
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) Person 클래스에 키와 외국인 여부를 나타내는 필드를 추가하라. 
 *      그리고 main() 메소드에서 이들 필드 값을 저장하고 출력하도록  수정하라.
 *    
 *   2) 환자정보(환자ID, 이름, 성별, 생년월일, 주소) 저장을 위한 Patient 클래스, 
 *      진료정보(진료날짜, 진료시간(분), 진료비) 저장을 위한 Treat 클래스를 작성하라.
 *       
 *      main() 메소드를 갖는 PatientMgmt 클래스를 작성하여 Patient 클래스 객체와 
 *      Treat 클래스 객체를 생성하고 필드에 값을 저장한 후 출력하라.
 *  
 *   3) 야구 선수 중 타자의 소속팀명, 이름, 연봉, 평균 안타율 등의 필드를 갖는 
 *      Hitter 클래스와 특정 경기에서의 타자 기록을 보여주는  경기날짜, 타석수, 
 *      타수수, 안타수, 포볼 회수, 몸에 맞은 볼 회수, 아웃 회수, 희생 플라이 회수 등을 필드로 갖는 
 *      GameRecord 클래스를 작성하라. 단, GameRecord 클래스에는 타자를 나타내는 필드인 
 *      hitter 필드를 다음과 같이 반드시 선언한다.
 *       
 *         class GameRecord {
 *            Hitter hitter;   // 이 기록이 어느 타자의 기록인가를 나타내기 위한 필드
 *            ...              // 이 타자의 경기 기록을 나타내는 필드들 
 *         }
 *       
 *      main() 메소드를 갖는 RecordMgmt 클래스를 작성하여 한국 프로야구 선수 2명의  
 *      최근 2경기 기록을 나타내는 코드를 작성하고 결과를 출력하라.
 */
