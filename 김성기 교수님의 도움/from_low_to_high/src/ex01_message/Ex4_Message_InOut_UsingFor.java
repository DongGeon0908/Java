package ex01_message;


/*
 *  [ Message_InOut_UsingFor]: For 문을 이용한 여러 문자열 메시지의 입력 및 출력(SkScanner의 getString() 메소드 이용)
 *
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) for 문을 이용하여 여러 문자열들을 입력하여 문자열 배열 변수에 저장하고 문자열들을 출력
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
 *   o 문자열 출력
 *     - printf() 메소드를 통해 문자열 출력

 */
class Ex4_Message_InOut_UsingFor {
	// main() 메소드는 시작 메소드로 자동적으로 호출됨
	public static void main(String[] args) {

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

		String[] msgs = new String[3]; // 입력한 3개의 문자열 메시지들을 저장할 String 배열 변수	

		int i;
		for (i=0; i < 3; i++) {
			msgs[i] = SkScanner.getStringWithPrompt(inPrompts[i]);   // 프롬프트 메시지 출력하고 문자열 입력하여 배열 원소 msgs[i]에 저장

			System.out.println(outPrompts[i] +  msgs[i]);  // outPrompts[]를 이용하여 입력한 배열 원소 msgs[i] 값을 출력 
		}


		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임

	}
}


/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.
*
*      - main() 메소드가 작성되어 있다.
*
*      - main() 메소드는 for 문을 이용하여 여러 문자열들을 입력하여 문자열 배열 변수에 저장하고 문자열들을 출력한다.
* 
*      - 여러 프롬프트 메시지와 출력 양식 문자열을 배열에 저장하여 
*        입력할 때마다 다른 프롬프트 메시지와 출력 양식을 이용한다. 
*
*   2) 프로그램을 실행하여 결과를 확인하라.
*
*   3) 본인이 좋아하는 격언을 추가로 입력하여 배열 원소 msgs[3]에 
*      저장한 후 출력하도록 프로그램을 수정하라. 
*
*      이를 위해서  inPrompts[]와 outPrompts[]에 새로운 문자열을 추가하고  
*      String msgs[3];을 String msgs[4]; 로 변경해야 한다. 
*
*   4) 본인의 이름, 나이, 현위치를 나타내는 하나의 문자열을 추가로 입력하여
*      배열 원소 msgs[4]에 저장한 후 출력하도록 프로그램을 수정하라.
*
*/
