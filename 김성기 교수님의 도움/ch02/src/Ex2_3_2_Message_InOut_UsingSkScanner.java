/**
 *  [ Message_InOut_UsingSkScanner ]: 문자열 메시지 입력 및 출력
 *        (SkScanner.getString() 메소드 이용)
 *                                   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) SkScanner 클래스의 메소드 이용하여 문자열 값을 입력하여 변수에 저장하고 출력
 *  
 *   o SkScanner 클래스의 메소드 이용하여 여러 종류별 값 입력
 *     - SkScanner 클래스 이용하면 보다 편리하게 데이터 입력 가능   
 *     - SkScanner.getString() 메소드를 통해 문자열 입력
 *         getString() 메소드: 엔터키가 타이핑될 때까지 타이핑된 모든 문자들 입력
 *         
 *     - 입력된 문자열은 문자열 변수에 저장 가능
 *         String name = SkScanner.getString();
 *         
 *   o 프롬프트 메시지
 *     - 프롬프트 메시지는 " 이름 입력 : ", " 변환할 섭씨온도 > " 등과 같이 입력할 값의 
 *       용도나 의미를 알려주는 문자열
 *     - 값 입력하기 전 System.out.print() 메소드 이용하여 프롬프트 메시지 출력
 *         
 *   o 문자열 출력
 *     - System.out.print() 또는 System.out.println() 메소드를 통해 문자열 출력
 *     
 *     - System.out.print()와 System.out.println() 메소드의 비교 
 *       (1) System.out.print()는 주어진 값을 출력한 후 줄바꿈을 하지 않으므로 
 *           다음 입출력은 같은 라인에서 이루어짐
 *       (2) System.out.println()은 주어진 값을 출력한 후 줄바꿈을 하므로
 *           다음 입출력은 다음 라인 첫 위치에서 이루어짐 
 */

class Ex2_3_2_Message_InOut_UsingSkScanner {   

	// main() 메소드는 시작 메소드로 자동적으로 호출
	public static void main(String[] args) {  
		
		System.out.println();  // 공백 라인을 출력하여 줄을 바꿈
		System.out.print("  o 첫 입력 메시지 입력하시오 > "); 	    // print() 메소드로 프롬프트 메시지 출력

		String firstMessage;
		firstMessage = SkScanner.getString();                   // 문자열 입력하여 firstMessage 변수에 저장
		
		System.out.println("  * 첫 입력 메시지 : " + firstMessage);  // +를 이용하여 여러 문자열을 한 라인에 출력 
			
		
		System.out.println();  // 공백 라인을 출력하여 줄을 바꿈
		System.out.print("  o 목표 메시지 입력하시오 > ");          // print() 메소드로 프롬프트 메시지 출력 

		String goalMessage;
		goalMessage = SkScanner.getString();                   // 문자열 입력하여 goalMessage 변수에 저장
		
		System.out.println("  * 입력한 목표 메시지 : " + goalMessage);  // +를 이용하여 여러 문자열을 한 라인에 출력	 

		/*
		 * 프롬프트 메시지 없이 데이터를 입력할 때의 양상을 보여주기 위한 부분
		 *   이 부분이 수행되면 무엇을 해야할지 모르면서 마냥 기다리게 됨 
		 */
		System.out.println();
		System.out.println("  * 다음의 입력에서는 입력을 위한 프롬프트가 주어지지 않습니다");
		
		String secondMessage ;
		
		secondMessage = SkScanner.getString();     // 프롬프트 메시지 없이 문자열 입력하여 secondMessage 변수에 저장
		System.out.println("  * 두번째 입력 메시지 : " + secondMessage);	
				
		System.out.println();
		System.out.println("  * 입력을 위한 프롬프트 메시지가 주어지지 않으면 무한히 기다리게 됩니다.");
		System.out.println("  * 입력을 위한 프롬프트 메시지를 반드시 출력하기 바랍니다.");		
		
	    // 이 부분에서 4) 본인이 좋아하는 격언을 문자열 변수 favoriteSaying에 입력하여 출력하도록 작성하라.
		// 입력하기 전에 반드시 입력을 위한 프롬프트 메시지를 출력하여야 함 
		
		// 이 부분에서 5) 본인의 이름, 나이, 현위치를 나타내는 정보 전체를 문자열 변수 myInfo에 입력하여 출력하도록 작성하라.
		// 입력하기 전에 반드시 입력을 위한 프롬프트 메시지를 출력하여야 함 
		
		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램 종료를 나타내는 문장
	}  

}  

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.
 * 
 *      - Ex2_3_2_Message_InOut_UsingSkScanner 클래스가 선언되어 있으며, 
 *        클래스 내부에 main() 메소드가 작성되어 있다.
 *    
 *     -  main() 메소드는 문자열 "\n * 첫 메시지 입력하시오 > "를 출력한 후 
 *        SkScanner.getString() 메소드를 이용하여 문자열을 입력하여 입력된 
 *        문자열을 firstMessage 변수에 저장하고 이를 출력한다.
 *    
 *      - 마찬가지로 목표 메시지도 입력하여 goalMessage에 저장하고 이를 출력하며,
 *        두번째 입력 메시지도 입력하여 출력한다. 
 *        
 *      - 그런데, 두 번째 입력 메시지를 입력할 때에는 프롬프트 메시지가 출력되지 않는다.
 *   
 *   2) ch02 프로젝트의 src -> (default package)에는 여러 .java 파일이 있으며,
 *      마지막 위치에 SkScanner.java 파일이 있음을 확인하라.
 *      (SkScanner.java 파일이 이 위치에 없으면 오류가 발생하며 입력이 되지 않음)
 *   
 *   3) 두번째 입력 메시지를 입력하기 위한 프롬프트 메시지를 출력하는 문장을
 *      작성한 후 프로그램을 실행하여 결과를 확인하라.
 *  
 *   4) 본인이 좋아하는 격언을 추가로 입력하여 문자열 변수 favoriteSaying에 
 *      저장한 후 출력하도록 프로그램을 변경하라.
 *   
 *   5) 본인의 이름, 나이, 현위치를 나타내는 하나의 문자열을 추가로 입력하여 
 *      문자열 변수 myInfo에 저장한 후 출력하도록 프로그램을 변경하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) 본인이 좋아하는 영화 정보 전체를 입력하여 하나의 문자열 변수에 저장한 후 
 *      출력하는 프로그램을 Pr2_3_2_MovieInfo_InOut 클래스로 작성하라.
 *      (입력하여 출력할 영화정보는 본인이 결정할 것)
 *        
 *   2) 본인이 좋아하는 책 정보 전체를 입력하여 하나의 문자열 변수에 저장한 후 
 *      출력하는 프로그램을 Pr2_3_2_BookInfo_InOut 클래스로 작성하라. 
 *      (책 정보는 인터넷 서점에서 찾아 출력할 것)    
 *  
 *      
 * [ 참고사항 ]
 *   
 *   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 
 *      프로그램을 작성하여야 한다. 예를 들어, Pr2_3_2_BookInfo_InOut 클래스에서 
 *      책 정보 전체를 입력하여 출력할 때 main() 메소드로만 클래스 구성하고, 변수 하나에 
 *      책 정보 전체를 입력하고 출력하여야 한다.
 *      
 *   2) 2019년 이전 Eclipse 버전의 경우 한글 데이터를 입력할 때
 *      반드시 Eclipse의 console 뷰(view)에서 마지막으로 출력된 다음 위치에서 
 *      마우스를 클릭하여 cursor를 위치시키고 한글 데이터를 입력한다. 
 *      
 *      그렇게 하지 않을 경우 프로그램이 정지되는 경우가 있으며, 이 때에는 
 *      프로그램을 다시 실행해야함.
 *      (실행은 run -> run as -> java application 또는 실행 버튼을 클릭할 것)
 *         
 *   3) SkScanner.java 파일을 각 프로젝트의 (default package)에 복사하여 저장해 
 *      놓으면 SkScanner.getString(), SkScanner.getInt(), SkScanner.getDouble(), 
 *      SkScanner.getBoolean() 메소드를 이용하여 쉽게 문자열, 정수, 실수, boolean 
 *      값을 입력할 수 있다.   
 */
