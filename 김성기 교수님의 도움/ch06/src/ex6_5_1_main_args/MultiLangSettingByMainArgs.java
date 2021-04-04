package ex6_5_1_main_args;

/**
 * [ MultiLangSettingByMainArgs 클래스 ]: 
 *       외부에서 main() 메소드로 전달된 정보 이용하여 다국어 처리하기
 *   
 *   o main() 메소드의 args[] 배열변수
 *     - Java 프로그램을 수행할 때 Java 프로그램에게 문자열 정보를 전달하기 위한 수단
 *     
 *     - 외부에서 프로그램으로 문자열 정보 전달 방법
 *       1) 명령어 라인에서 전달하기: java 클래스이름 문자열1 문자열2 문자열3 ...
 *       
 *          예: java MultiLangSettingByMainArgs -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" 
 *                                              -lang JAP  in "Seoul Korea"
 *                                                     
 *           
 *       2) Eclipse에서 전달하기: Run -> Run Configurations 클릭한 후
 *           (x)= argument 탭을 클릭하여 program arguments 입력창에 전달할 문자열 입력
 *           
 *           -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" -lang JAP  in "Seoul Korea"
 *           
 *     - 참고사항
 *       1) 문자열은 "와 " 사이에 표시할 수 있거나 " 생략해도 됨 
 *       2) blank, tab 등의 화이트 스페이스 문자가 문자열에 포함될 경우 반드시 "와 " 사이에 문자열 표시해야 함
 *        
 *   o main() 메소드의 args[] 배열변수의 활용
 *     - 외부에서 전달된 정보는 주로 프로그램의 초기 설정에 사용되며, 
 *       이들은 프로그램 옵션 설정사항에 해당됨
 *       
 *     - 예를 들어, 다국어 지원이 가능한 프로그램인 경우 여러 언어 중에서 특정 언어 정보를 
 *       main() 메소드의 args[]로 전달받아 설정할 수 있음 
 *       
 *     - 이 프로그램에서 args[]의 실매개변수로 "-lang" 다음에 "KOR", "ENG", "JAP" 중 하나가 주어지면  
 *       출력이 한국어, 영어, 일본어로 됨
 */

class MultiLangSettingByMainArgs {
	static int KOR = 0;
	static int ENG = 1;
	static int JAP = 2;
 
	public static void main(String[] args) {
		int lang = KOR;

		// 명령어 라인의 첫 매개변수가 "-lang"이고 다음 매개변수가 "KOR", "ENG", "JAP" 중 하나이면
		// 해당 언어로 설정
		if (args.length >= 2 && args[0].equals("-lang")) {
			if (args[1].equals("KOR"))
				lang = KOR;
			else  if (args[1].equals("ENG"))
				lang = ENG;
			else if (args[1].equals("JAP"))
				lang = JAP;
	    }

		if (args.length == 0) { // args.length는 args[] 배열의 원소 개수 저장하는 필드
			if (lang == KOR)
				System.out.println("  * 외부 명령어 라인에서 전달된 문자열 정보가 없음");
			else  if (lang == ENG)
				System.out.println("  * No program arguments passed to from command-line ");
			else  if (lang == JAP)
				System.out.println("  * 外部コマンド ラインから 渡された 文字列情報がないこと");      	 
		}
		else {
			if (lang == KOR)
				System.out.println("\n\n  ** 외부에서 전달된 문자열 정보 개수: " + args.length + " ** \n");
			else  if (lang == ENG)
				System.out.println("\n\n  ** The number of program arguments passed to from command-line: " + args.length + " ** \n");
			else  if (lang == JAP)
				System.out.println("\n\n  ** 外部コマンド ラインから 渡された 文字列情報カウント: " + args.length + " ** \n"); 


			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-lang") && args.length > (i + 1)) {
					switch(args[i+1]) {
					case "KOR" : 
						lang = KOR;
						System.out.println("\n  ** 언어 설정: 언어가 한국어로 설정됨 ** \n");
						break;
					case "ENG" : 
						lang = ENG;
						System.out.println("\n  ** Language setting: The language is set to English **\n");
						break;
					case "JAP" : 
						lang = JAP;
						System.out.println("\n  ** 言語設定: 言語が日本語に設定されて **\n");
						break;
					}		  
				}

				if (lang == KOR)
					System.out.println("  * " + (i + 1) + "번째 전달된 문자열 정보: " + args[i]);
				else  if (lang == ENG)
					System.out.println("  * " + (i + 1) + "-th passed string information: " + args[i]);
				else  if (lang == JAP)
					System.out.println("  * " + (i + 1) + "つ目渡された文字列情報: " + args[i]);      	 
			}
		}
	}
} 

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 프로그램 외부에서 전달된 문자열 정보를 main() 메소드의 args[] 배열변수로 전달받아
 *      출력하면서 -lang ENG, -lang KOR, -lang JAP이 포함되면 해당 언어로 출력 메시지를 변경한다.
 *      
 *      예를 들어, -lang ENG  Hi! "My name" -lang KOR  is "Hong Gildong" -lang JAP  in "Seoul Korea"를 전달하면 
 *      이들 문자열 개수와 문자열들을 차례로 출력한다.
 *      
 *   2) Eclipse에서 프로그램으로 문자열 정보 전달하는 방법
 *   
 *      Eclipse의 Run -> Run Configurations... ->
 *        -> Main 탭에서  << Main class: >> 오른쪽의 search 클릭하여 MultiLangSettingByMainArgs 찾아 클릭
 *        ->(x)= arguments 탭 클릭 
 *        -> Program arguments: 창에  -lang JAP  Hi! "My name" is "Hong Gildong" in "Seoul Korea" 입력
 *        -> Run 클릭하면 실행결과가 console 뷰에 출력됨
 *          
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) Program arguments: 창에  -lang ENG  Hi! "My name" is "Hong Gildong" in "Seoul Korea" 
 *      입력 변경한 후 프로그램을 실행하여 결과 확인하라.
 *   
 *   2) Program arguments: 창에  -lang KOR  Hi! "My name" is "Hong Gildong" in "Seoul Korea" 
 *      입력 변경한 후 프로그램을 실행하여 결과 확인하라.
 */
