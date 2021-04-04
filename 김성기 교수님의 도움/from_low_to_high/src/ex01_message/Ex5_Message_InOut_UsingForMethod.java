package ex01_message;


/*
 *  [ Message_InOut_UsingForMethod]: For 문과 메소드을 이용한 여러 문자열 메시지의 입력 및 출력(SkScanner의 getString() 메소드 이용)
 *
 *   o 프로그래밍 스타일
 *     1) main() 메소드와 여러 문자열을 입력하여 출력하는 메소드로 클래스 구성
 *     2) for 문과 메소드  이용하여 여러 문자열들을 입력하여 문자열 배열 변수에 저장하고 문자열들을 출력
 *     3) 여러 프롬프트 메시지와 출력 양식 문자열을 배열에 저장하여 
 *        입력할 때마다 다른 프롬프트 메시지와 출력 양식을 이용함 
 *
 *   o for 문을 이용하여 여러 문자열 입력 및 출력을 위한 프로그램 작성 및 수정
 *     - SkScanner 클래스의 입력 메소드들을 이용하면 보다 편리한 데이터 입력이 가능함
 *     - SkScanner 클래스의의 getStringWithPrompt() 메소드를 통해 프롬프트 메시지 출력 후 문자열 입력
 *     - getStringWithPrompt() 메소드: 프롬프트 메시지 출력 후 엔터키가 타이핑될 때까지 타이핑된 모든 문자들을 입력

 *     - 입력된 문자열은 문자열 변수에 저장 가능
 *         String name = SkScanner.getStringWithPrompt("\n  o 첫 입력 메시지 입력하시오 > ");
 *
 *   o 프롬프트 메시지 출력 
 *     - 프롬프트 메시지는 " 이름 입력 : ", " 변환할 섭씨 온도 > " 등과 같이 입력할 값의
 *       용도나 의미를 알려주는 문자열임
 *     - 값을 입력하기 전에 System.out.print() 메소드를 이용하여 프롬프트 메시지를 출력하거나 
 *        프롬프트 메시지 출력 후 값 입력하는 메소드를 사용함 
 *     
 *  o 작성된 메소드
 *    - inputOutputMessages(): 입출력 프롬프트가 주어지면 이를 이용하여 메시지를 입력하고 출력하는 메소드
 *    - inputOutputMessage(): 입출력 프롬프트가 주어지면 이를 이용하여 메시지를 입력하고 출력하는 메소드
 */

class Ex5_Message_InOut_UsingForMethod{
	// main() 메소드는 시작 메소드로 자동적으로 호출됨
	public static void main(String[] args) {
		
		System.out.println("\n\n  ** 메소드를 이용한 여러 문자열 메시지 입력 및 출력 **"); 
		
		// 3번의 문자열 입력을 위한 프롬프트 메시지들을 저장하는 String 배열 변수 
		String inPrompts[] = { "\n  o 첫 입력 메시지 입력하시오 > ", 
				"\n  o 목표 메시지 입력하시오 > ",
				"\n  o 두번째 입력 메시지 입력하시오 > "
		};

		// 입력된 3개의 문자열을 출력하기 위한 출력 프롬프트 문자열들을 저장하는 String 배열 변수						  
		String outPrompts[] = { "  * 첫 입력 메시지 : ", 
				"  * 입력한 목표 메시지 : ",
				"  * 두번째 입력 메시지 : "
		};	
		
		int cnt = inPrompts.length;  // 입출력할 문자열 메세지의 개수를 구함		
		String[] msgs = new String[cnt]; // 입력한 문자열 메시지들을 저장할 String 배열 변수	

		inputOutputMessages(inPrompts, outPrompts,msgs);
		
		// 입력한 메시지만 다시 한번 출력함
		System.out.println("\n\n  ** 입력한 메시지들");
		for(String msg : msgs)
			System.out.println("  * " + msg); 
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}

	// inputOutputMessages(): 입출력 프롬프트가 주어지면 이를 이용하여 메시지를 입력하여 저장한 후  출력하는 메소드
	//   매개변수는 String 배열이 전달됨
	static void inputOutputMessages(String[] inPrompts, String[] outPrompts, String[] msgs) {
		int cnt = inPrompts.length;  // 입출력할 문자열 메세지의 개수를 구함
		
		for (int i=0; i < cnt; i++) 
			msgs[i] = inputOutputMessage(inPrompts[i], outPrompts[i]);		
	}
	
	// inputOutputMessage(): 입출력 프롬프트가 주어지면 이를 이용하여 메시지를 입력하고 출력하는 메소드
	//   매개변수는 String 배열이 전달됨
	static String inputOutputMessage(String inPrompts, String outPrompt) {

		String msg; // 입력한 문자열 메시지들을 저장할 String 배열 변수	

		msg = SkScanner.getStringWithPrompt(inPrompts);   // 프롬프트 메시지 출력하고 문자열 입력하여 배열 원소 msgs[i]에 저장

		System.out.println(outPrompt + msg);  // outPrompts[]를 이용하여 입력한 배열 원소 msgs[i] 값을 출력 
		
		return msg;
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *
 *      - main() 메소드가 작성되어 있다.
 *
 *      - main() 메소드는 inputOutputMessage() 메소드를 호출하여 문자열 메시지를 입력하고 출력함
 *      
 *      - inputOutputMessage() 메소드는 String 배열이 매개변수로 전달되며,
 *        for 문을 이용하여 여러 문자열들을 입력하여 문자열 배열 변수에 저장하고 문자열들을 출력한다.
 * 
 *      - 여러 프롬프트 메시지와 출력 양식 문자열을 배열에 저장하여 
 *        입력할 때마다 다른 프롬프트 메시지와 출력 양식을 이용한다. 
 *
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *
 * [실습 과제 ]
 * 
 *   1) 본인이 좋아하는 격언을 추가로 입력하여 출력하도록 프로그램을 수정하라. 
 *
 *      이를 위해서  inPrompts[]와 outPrompts[]에 새로운 프롬프트 문자열을 추가하기만 하면 됨  
 *
 *   2) 본인의 이름, 나이, 현위치를 추가로 입력하여 출력하도록 프로그램을 수정하라.
 *   
 *   3) 이 프로그램은 문자열 메시지를 입력하고 문자열을 바로 출력한다.
 *      이와 달리 여러 문자열 메시지를 입력하여저장한 후 입력된 문자열 메시지들을 한꺼번에 출력하도록 
 *      프로그램을 변경하라.
 *       
 *      예를 들어, 변경된 프로그램의 입출력은 다음과 같다.
 *      ================================
        
        ** 메소드를 이용한 여러 문자열 메시지 입력 및 출력 **

        o 첫 입력 메시지 입력하시오 > 첫 프로그램
        o 목표 메시지 입력하시오 > Java 전문가
        o 두번째 입력 메시지 입력하시오 > good       
        
        * 첫 입력 메시지 : 첫 프로그램
        * 입력한 목표 메시지 : Java 전문가
        * 두번째 입력 메시지 : good

   
        ^^ Well done! Have a good time!!! ^^
 *      ================================
 *              
 *     이를 위하여  다음의 메소드를 작성하라.
 *     
 *       (1) 입력 프롬프트들이 주어지면 입력 프롬프트들을 출력하고  메시지들을 입력하여 mags 배열에 저장하여 반환하는 
 *           static String[] inputMessages(String[] inPrompts, String[] msgs) 메소드
 *           
 *       (2) 출력  프롬프트 메시지들과  메시지들이 주어지면 이들을 출력하는   
 *           static void outputMessages(String[] outPprompts, String[] Msgs) 메소드
 *           
 *       (3) 입력 프롬프트 메시지가 주어지면 이 메시지들을 출력하고 문자열을 입력하여 반환하는    
 *           static String inputMessage(String inPrompt) 메소드
 *           
 *       (4) 출력  프롬프트 메시지와 출력 메시지가 주어지면  이들을 출력하는   
 *           static void outputMessage(String outPrompt, String Msg) 메소드
 *           
 *        main() 메소드에서는 inputMessages(String[] inPrompts, String[] msgs) 메소드와  
 *        outputMessages(String[] outPprompts, String[] Msgs) 메소드를 호출한다.
 *             
 *
 */
