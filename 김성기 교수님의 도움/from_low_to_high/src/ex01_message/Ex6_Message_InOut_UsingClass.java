package ex01_message;


/*
 *  [ Message_InOut_UsingClass]: 클래스의 객체를  이용한 여러 문자열 메시지의 입력 및 출력(SkScanner의 getString() 메소드 이용)
 *
 *   o 프로그래밍 스타일
 *     1) 입력 프롬프트 필드, 출력 프롬프트 필드, 입력 메시지 저장 필드를 갖는 
 *        클래스를 작성하여 여러 메시지를 입력하고 입력된 메시지를 출력하는  클래스 구성
 *     2) 여러 문자열 메시지들을 입력하여객체의 필드에 저장하고 출력
 *     3) 여러 프롬프트 메시지와 출력 양식 문자열을 배열에 저장하여 
 *        입력할 때마다 다른 프롬프트 메시지와 출력 양식을 이용함 
 *
 *   o 문자열 입력
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
 *   o 문자열 출력
 *     - printf() 메소드를 통해 문자열 출력
 */

class Message {
	String inPrompt;   // 메시지 입력을 위한 입력 프롬프트
	String outPrompt;  // 메시지 출력을 위한 출력 프롬프트
	String msg;
	
	// 입출력 프롬프트가 주어지면 이를 입출력 프롬프트 필드에 저장하는 객체 생성자
	Message(String inPrompt, String outPrompt) {
		this.inPrompt = inPrompt;
		this.outPrompt = outPrompt;
	}
	
	// 입력 프롬프트를  출력한 후 메시지를 입력하여 msg 필드에 저장하는 메소드 
	void inputMessage() {
       this.msg = SkScanner.getStringWithPrompt(inPrompt);   // 입력 프롬프트 메시지 출력하고 문자열 입력하여 msg 필드에 저장
	}
	
	
	// 출력 프롬프트와 msg 필드를 출력하는 메소드 
	void outputMessage() {
		System.out.println(outPrompt + msg);  //  출력 프롬프트와 msg 필드를 출력			
	}
	
	// 입력 프롬프트를  출력한 후 메시지를 입력하여 msg 필드에 저장하고 입력된 msg를 출력 프롬프트와 함께 출력하는  메소드 
	void inputOutputMessage() {
		inputMessage();
		outputMessage();
	}

}
class Ex6_Message_InOut_UsingClass{
	// main() 메소드는 시작 메소드로 자동적으로 호출됨
	public static void main(String[] args) {
		
		System.out.println("\n\n  ** 클래스를 이용한 여러 문자열 메시지 입력 및 출력 **"); 
		
		// 3번의 문자열 메시지 입력을 위한 Message 배열  생성하여 msgs 배열에 저장 
		Message[] msgs =  { 
				new Message("\n  o 첫 입력 메시지 입력하시오 > ",    "  * 첫 입력 메시지 : "),
				new Message("\n  o 목표 메시지 입력하시오 > ",      "  * 입력한 목표 메시지 : "),
				new Message("\n  o 두번째 입력 메시지 입력하시오 > ", "  * 두번째 입력 메시지 : ")
		};
 
		inputOutputMessages(msgs);
	}

	// inputOutputMessages(): Message 배열 msgs가 주어지면 이를 이용하여 여러 메시지를 입력하고 출력하는 메소드
	static void inputOutputMessages(Message[] msgs) {
		int cnt = msgs.length;  // 입출력할 문자열 메세지의 개수를 구함
				
		int i;
		for (i=0; i < cnt; i++)
			msgs[i].inputOutputMessage();

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
 *
 *      - Message 클래스
 *        . inPrompt, outPrompt, msg: 입력 프롬프트 필드, 출력 프롬프트 필드, 입력한 메시지 저장할 필드
 *        . Message(String inPrompt, String outPrompt): 입력 프롬프트와 출력 프롬프트를 저장하는 객체 생성자
 *        . inputMessage(): 메시지를 입력하는 메소드 
 *        . outputMessage()메시지륵 출력하는 메소드
 *        . inputOutputMessage()메시지를 입력하고 출력하는 메소드
 *        
 *      - main() 메소드
 *        . Message 객체들을 생성하여 mads 배열에 저장
 *        . nputOutputMessages(Message[] msgs) 메소드 호출하여 여러 메시지를 입력하고 출력
 *        
 *      - main() 메소드는 inputOutputMessage() 메소드를 호출하여 문자열 메시지를 입력하고 출력함
 *
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *
 *
 * [실습 과제 ]
 * 
 *   1) 본인이 좋아하는 격언을 추가로 입력하여 출력하도록 프로그램을 수정하라. 
 *
 *      이를 위해서  Message[] msgs의 배열 초기화 부분에 새로운 배열객체를 생성하여 추가하기만 하면 됨  
 *
 *   2) 본인의 이름, 나이, 현위치를 추가로 입력하여 출력하도록 프로그램을 수정하라.
 *   
 *   3) 이 프로그램은 문자열 메시지을 입력하고 문자열을 바로 출력한다.
 *      이와 달리 여러 문자열을 입력하여 Message 객체에 저장한 후 입력된 문자열을 한꺼번에 출력하도록 
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
 *       (1) Message 배열 msgs가 주어지면  msgs 배열 원소의 입력 프롬프트들을 출력하고 메시지를 입력하여 msgs 배열 원소에 각각 저장하는 
 *           static void inputMessages(Message[] msgs) 메소드
 *           
 *       (2) Message 배열 msgs가  주어지면 msgs 배열 원소의 출력 프롬프트와  메시지를 출력하여    
 *           static void outputMessages(Message[] msgs) 메소드           
 *           
 *        main() 메소드에서는 inputMessages(Message[] msgs) 메소드와  
 *        static void outputMessages(Message[] msgs) 메소드를 호출한다.
 *             
 *
 */
