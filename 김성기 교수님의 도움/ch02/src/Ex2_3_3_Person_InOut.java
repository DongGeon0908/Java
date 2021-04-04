/**
 * [ Person_InOut ]: 신상정보를 위한 변수 선언, 값 입력 후 저장, 출력
 *                   (SkScanner 클래스의 입력 메소드를 이용)
 *                          
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) SkScanner 클래스의 메소드 이용하여 종류별 값을 입력하여 변수에 저장하고 저장된 변수의 값 출력
 *  
 *   o SkScanner 클래스의 메소드 이용하여 여러 종류별 값 입력
 *     - 종류별로 값을 입력하는 메소드인 SkScanner.getXxx() 
 *         SkScanner.getString():   엔터키가 타이핑될 때까지 타이핑된 모든 문자들 입력
 *         SkScanner.getInt():      타이핑된 문자들 중 첫번째 정수 값 입력, 정수가 아닌 것은 모두 무시
 *         SkScanner.getDouble():   타이핑된 문자들 중 첫번째 실수 값 입력, 실수가 아닌 것은 모두 무시
 *         SkScanner.getChar():     문자 하나 입력
 *         SkScanner.getBoolean():  true 또는 false를 boolean 값으로 입력, true 또는 false가 아닌 것은 모두 무시
 *         
 *     - 입력된 값은 해당 타입의 변수에 저장 가능
 *         String name = SkScanner.getString();      // 문자열 입력하여 String 변수에 저장
 *         int age = SkScanner.getInt();             // 정수 입력하여 int 변수에 저장
 *         double height = SkScanner.getDouble();    // 실수 입력하여 double 변수에 저장
 *         char initialOfName = SkScanner.getChar(); // 문자 입력하여  char 변수에  저장
 *         isKorean = SkScanner.getBoolean();        // boolean 값 입력하여 boolean 변수에 저장
 *         
 *   o 여러 종류별 값 출력
 *     - System.out.print() 또는 System.out.println() 메소드를 통해 값 출력
 *     
 *     - System.out.print(): 출력 후 줄바꿈 하지 않아 다음 입출력이 현재 라인에서 이루어짐
 *     - System.out.println(): 출력 후 줄바꿈 하여 다음 입출력이 다음 라인에서 이루어짐
 *         
 *     - 출력할 여러 값들을 + 로 접속하여 출력  가능
 */ 

class Ex2_3_3_Person_InOut {

	// main() 메소드는 시작 메소드로 자동적으로 호출
	public static void main(String[] args) {
		/*
		 *  신상정보(이름, 나이, 현위치, 키, 이름 첫 글자, 한국인 여부) 저장을 위한 변수 선언
		 */
		String name;             // String 타입의 변수 
		int age;                 // 18int 타입의 변수 
		String currentLocation;  // String 타입의 변수

		double height;           // double 타입의 변수 
		char initialOfName;	     // char 타입 변수 
		boolean isKorean;        // boolean 타입 변수 

		/*
		 *  신상정보를 입력하여 변수들의 값으로 저장
		 */
		System.out.println();  // 공백 라인을 출력하여 줄 바꿈
		System.out.println("  ** 신상정보 입력 **");
		System.out.println();  // 공백 라인을 출력하여 줄 바꿈

		System.out.print("  o 이름 > ");  // System.out.print() 이용하여 프롬프트 메시지 출력   
		name = SkScanner.getString();   // SkScanner.getString() 이용하여 문자열 입력하여 저장
 
		System.out.print("  o 나이 > ");  // 프롬프트 메시지 출력	     
		age = SkScanner.getInt();       // 정수 입력하여 저장

		System.out.print("  o 현위치 > ");          // 프롬프트 메시지 출력	
		currentLocation = SkScanner.getString();  // 문자열 입력하여 저장

		System.out.print("  o 키 > ");    // 프롬프트 메시지 출력	     
		height = SkScanner.getDouble();  // 실수 입력하여 저장

		System.out.print("  o 이름 첫 글자 > ");  // 프롬프트 메시지 출력	
		initialOfName = SkScanner.getChar();  // 문자 입력하여 저장

		System.out.print("  o 한국인 여부(true 또는 false 입력) > ");   // 프롬프트 메시지 출력	
		isKorean = SkScanner.getBoolean();                       // boolean 값인 true 또는 false 입력하여 저장
		/*
		 *  여러 개의 값을 한 라인에 출력, 출력할 값들을 + 로 접속하여 출력
		 */
		System.out.println();  // 공백 라인을 출력하여 줄 바꿈
		System.out.println();
		System.out.println("  ** " + name + "의 신상정보 ** ");
		System.out.println();
		System.out.println("  * " + name + "의 나이는 " + age + "세이고 "  + currentLocation  + "에 있음");
		System.out.println("  * " + name + "의 키는 " + height + "cm이고 이름 첫 글자는 " + initialOfName  + "임");
		System.out.println("  * " + name + "의 한국인 여부는 " + isKorean + "임");

		
		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램 종료를 나타내는 문장
				
		main(args); // 이 문장은 전체 프로그램을 계속 반복하여 실행하기 위해 작성된 것
	}

}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.
 *   
 *      - Ex2_3_3_Person_InOut 클래스가 선언되어 있으며, 클래스 내부에  main() 메소드가 작성되어 있다.
 *      
 *      - main() 메소드는 변수 선언, 값 입력 및 저장, 값 출력 등을 수행하는  여러 문장들로 구성되어 있다.      
 *       
 *      - main() 메소드의 끝에는 << main(args); >> 문장이 있으며, 이 문장은 전체 
 *        프로그램을 계속 반복하여 실행하도록 한다.
 *       
 *   2) 홍길동에 대한 신상정보를 입력하여 결과를 확인하라.
 *  
 *   3) 이몽룡에 대한 신상정보를 입력하여 결과를 확인하라.
 *      (이몽룡의 정보는 춘향전을 최대한 참고하여 적절히 설정함) 
 *   
 *   4) 본인에 대한 신상정보를 입력하여 결과를 확인하라.
 *     
 *   5) 외국인 한 사람을 설정하여 신상정보를 입력하여 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 SkScanner 클래스를 이용하여 데이터를 입력한다.
 *      java.util.Scanner 클래스를 이용하여 데이터를 입력하는 프로그램으로 변경하라.
 *      
 *   2) 본인이 좋아하는 책의 제목, 저자, 출판사, 가격, 페이지수 등의 책 정보 항목들을  
 *      저장하기 위한 변수를 각각 선언하고 각각의 변수에 값을 입력하여 저장한 후 
 *      출력하는 프로그램을 Pr2_3_3_Book_InOut 클래스로 작성하라.
 *      
 *      (변수 이름은 영어 단어로 작성할 것이며, 영어 단어를 모르면 인터넷 한영사전을 참조하라.
 *       또한 책 정보는 인터넷 서점에서 정확한 정보를 구하여 변수에 저장할 것)
 *   
 *   3) 본인이 좋아하는 영화에 대한 정보 항목들을 저장하기 위한 변수를 각각 선언하고 
 *      각각의 변수에 값을 입력하여 저장한 후 출력하는 프로그램을 Pr2_3_3_Movie_InOut 클래스로 작성하라.
 *      
 *      (영화의 영화 제목, 장르, 감독, 제작사 등의 정보 항목은 본인이 결정할 것)
 *      
 *       
 * [ 참고사항 ]
 *
 *   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을 
 *      작성하여야 한다. 예를 들어, Pr2_3_3_Book_InOut 클래스를 작성할 때에는 main() 메소드로만 
 *      클래스 구성하고, 책 정보 항목 하나하나를 입력하여 저장하기 위한 변수들을 선언하여야 한다.
 *      
 *   2) 한글 데이터를 입력할 때에는 반드시 Eclipse의 console 뷰(view)에서 마지막으로
 *      출력된 다음 위치에서 마우스를 클릭하여 cursor를 위치시키고 한글 데이터를 입력한다. 
 *      그렇게 하지 않을 경우 프로그램이 정지되는 경우가 있으며, 이 때에는 프로그램을
 *      다시 실행해야함.
 *      (실행은 run -> run as -> java application 또는 실행 버튼을 클릭할 것)
 *      
 *   3) SkScanner.java 파일을 Eclipse 프로젝트의 (default package)에 복사하여 저장해 
 *      놓으면 SkScanner.getString(), SkScanner.getInt(), SkScanner.getDouble(), 
 *      SkScanner.getBoolean() 메소드를 이용하여 쉽게 문자열, 정수, 실수, boolean 
 *      값을 입력할 수 있다.   
 *    
 *   4) 프로그램은 한번 실행된 후 종료된다. 주어진 프로그램을 계속 반복하는 가장 쉬운 방법이 
 *      main() 메소드의 끝에 문장 << main(args); >> 을 추가하는 것이다.
 *      
 *      이 경우 프로그램을 계속 반복하여 실행되게 된다. 또 다른 방법은 다음에 소개될 것이다.    
 *      
 *        
 * [ 스스로 생각하고 고민할 과제 ]  
 *  
 *   o Ex2_1_1_Person_Out 클래스의 프로그램과 같이 값을 직접 변수에 저장할 경우 
 *     처리 대상이 바뀌면 변수의 값을 바꾸어 저장해야 하므로 프로그램이 변경되어야 한다. 
 *       
 *     그런데, Ex2_3_3_Person_InOut 클래스의 프로그램과 같이 값을 입력하여 변수에 저장할 경우
 *     처리 대상이 바뀌어도 프로그램은 변경되지 않는다. 
 *      
 *     그 차이점을 반드시 이해하고 그 이유가 무엇인가를 생각해보라. 
 */
