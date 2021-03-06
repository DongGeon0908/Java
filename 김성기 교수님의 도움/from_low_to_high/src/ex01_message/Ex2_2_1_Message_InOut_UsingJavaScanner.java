package ex01_message;

/*
 * [ Message_InOut_UsingJavaScanner ]: 문자열 메시지의 입력 및 출력
 *                       (java.util.Scanner 클래스의 nextLine() 메소드 사용)
 * 
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 문자열을 입력하여 변수에 저장하고 저장된 변수의 문자열을 출력
 *     
 *   o 문자열 변수 선언 
 *     - String 변수;
 *     - 예) 
 *         String firstMessage;
 *         String goalMessage;
 *  
 *   o 문자열 입력 
 *     - Java에서 자체적으로 제공하는 문자열 입력 수단인 java.util.Scanner 클래스의 
 *       nextLine() 메소드 사용 
 *        
 *     - java.util.Scanner 클래스의 객체를 생성한 후 문자열 입력하여 문자열 변수에 저장 가능
 *        (1) 객체 생성:  new java.util.Scanner scanner = new new java.util.Scanner(System.in);   
 *        (2) 문자열 입력: String firstMessage = scanner.nextLine();  
 *         
 *   o 프롬프트 메시지
 *     - 프롬프트 메시지는 " 이름 입력 : ", " 변환할 섭씨 온도 > " 등과 같이 입력할 값의 
 *       용도나 의미를 알려주는 문자열임
 *     - 값을 입력하기 전에 System.out.print() 메소드를 이용하여 프롬프트 메시지를 출력함
 *         
 *   o 문자열 출력
 *     - System.out.print() 또는 System.out.println() 메소드를 통해 문자열 출력
 *     
 *     - System.out.print()와 System.out.println() 메소드의 비교 
 *       (1) System.out.print()는 주어진 값을 출력한 후 줄바꿈을 하지 않으므로 
 *           다음 입출력은 같은 라인에서 이루어짐됨
 *       (2) System.out.println()은 주어진 값을 출력한 후 줄바꿈을 하므로
 *           다음 입출력은 다음 라인 첫 위치에서 이루어됨 
 *     
 */

class Ex2_2_1_Message_InOut_UsingJavaScanner {   

	// main() 메소드는 시작 메소드로 자동적으로 호출됨
	public static void main(String[] args) {  
		// java.util.Scanner 클래스의 객체 생성하여 scanner 변수에 저장
	    //   Java의 입력 수단 사용시 이 문장을 반드시 포함해야 함
		java.util.Scanner scanner = new java.util.Scanner(System.in);  
		
		String firstMessage;
		
		System.out.println();  // 공백 라인을 출력하여 줄을 바꿈
		System.out.print("  o 첫 입력 메시지 입력하시오 > "); // System.out.print() 이용하여 프롬프트 메시지 출력
		firstMessage = scanner.nextLine();                    // scanner.nextLine() 메소드로 문자열 입력하여 firstMessage 변수에 저장
		System.out.println("  * 첫 입력 메시지 : " + firstMessage);
	
		
		String goalMessage;
		
		System.out.println();
		System.out.print("  o 목표 메시지 입력하시오 > "); // 프롬프트 메시지 출력	
		goalMessage = scanner.nextLine();                  // 문자열 입력하여 goalMessage 변수에 저장
		System.out.println("  * 입력한 목표 메시지 : " + goalMessage);  // +를 이용하여 여러 문자열을 한 라인에 출력
		
		
		/*
		 * 프롬프트 메시지 없이 데이터를 입력할 때의 양상을 보여주기 위한 부분
		 *   이 부분이 수행되면 무엇을 해야할지 모르면서 마냥 기다릴 수 있음 
		 */
		String secondMessage ;
		
		secondMessage = scanner.nextLine();     // 프롬프트 메시지 없이 문자열 입력하여 secondMessage 변수에 저장
		System.out.println("  * 두번째 입력 메시지 : " + secondMessage);	 // +를 이용하여 여러 문자열을 한 라인에 출력		
				
		// 이 부분에서 4) 본인이 좋아하는 격언을 추가로 입력하여 출력하도록 수정하라.
		
		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}  

} 


/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 * 
 *      Ex2_2_1_Message_InOut_UsingJavaScanner 클래스가 선언되어 있으며, 
 *      클래스 내부에 main() 메소드가 작성되어 있다. 
 *     
 *      main() 메소드에는 < java.util.Scanner scanner = new java.util.Scanner(System.in); > 
 *      문장이 있으며, 이 문장은 지금은 이해할 수 없지만 반드시 포함해야 한다. 
 *    
 *      그 다음 부분에서 프롬프트 메시지인 문자열 "* 첫 입력 메시지 입력하시오 > "을 
 *      출력한 후 scanner.nextLine() 메소드를 이용하여 문자열을 입력하고 
 *      입력된 문자열을 firstMessage 변수에 저장하고 이를 출력한다.
 *    
 *      마찬가지로 목표 메시지도 입력하여 goalMessage에 저장하고 이를 출력한다. 
 *    
 *      마지막으로 두번째 메시지도 입력하여 출력하는데, 이때에는 프롬프트 메시지가 없이 입력한다.  
 *      
 *     
 *   2) 프로그램을 실행하여 결과를 확인하라.
 * 
 *   3) < secondMessage = scanner.nextLine(); >를 수행하기 전에 적절한 프롬프트 메시지를 
 *      출력하도록 프로그램을 변경하여 실행하라. 
 *      (프롬프트 메시지가 있을 때와 없을 때의 차이점을 확실히 이해를 해야 함)
 * 
 *   4) 본인이 좋아하는 격언을 추가로 입력하여 문자열 변수 favorateSaying에 
 *      저장한 후 출력하도록 프로그램을 수정하라.
 * 
 *   5) 본인의 이름, 나이, 현위치를 나타내는 하나의 문자열을 추가로 입력하여 
 *      문자열 변수 myInfo에 저장한 후 출력하도록 프로그램을 수정하라.
 * 
 *    
 * [ 참고사항 ]
 * 
 *   1) 데이터를 입력할 때에는 반드시 프롬프트 메시지를 미리 줄력하여야 한다. 그렇지 않고서 
 *      프로그램이 실행되면 입력되기를 기다리는데 사용자는 무엇을 해야할지 모르면서 막연히 
 *      기다리게 될 수 있다. 이를 방지하기 위해 반드시 입력 전에 프롬프트 메시지를 출력해야 한다.
 *     
 *      프롬프트 메시지는 " 이름 입력 : ", " 변환할 섭씨 온도 > " 등과 같이 입력할 값의 용도나 
 *      의미를 알려주는 문자열이며, System.out.print() 메소드를 이용하여 프롬프트 메시지를 출력한다.
 * 
 *   2) 한글 데이터를 입력할 때에는 반드시 Eclipse의 console 뷰(view)에서 마지막으로
 *      출력된 다음 위치에서 마우스를 클릭하여 cursor를 위치시키고 한글 데이터를 입력한다. 
 *      그렇게 하지 않을 경우 프로그램이 정지되는 경우가 있으며, 이 때에는 프로그램을
 *      다시 실행해야함. 영문 데이터나 숫자 데이터를 입력할 때에는 그럴 필요가 없다. 
 *      (실행은 run -> run as -> java application 또는 실행 버튼을 클릭할 것)
 *    
 *   3) 여기에서 사용된 입력 수단은 Java 자체에서 제공하는 것으로서, 초보자가 이해하기에는
 *      다소 어렵고 사용하기도 불편하며, 숫자를 입력해야 할 때 영문자나 특수문자를 입력하면
 *      오류도 발생한다. 그래서 본 교재에서는 문자열, 정수, 실수, boolean 값을 보다 쉽게
 *      입력할 수 있는 수단인 SkScanner 클래스를 제공한다. 
 *    
 *     앞으로의 모든 프로그램에서는 SkScanner 클래스를 이용하여 데이터를 입력한다.
 *  
 */
