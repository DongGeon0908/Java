package ex6_5_1_main_args;

/**
 * [ PrintMainArgs 클래스 ]: 외부에서 main() 메소드로 전달된 정보 처리하기
 *   
 *   o main() 메소드의 args[] 배열변수
 *     - Java 프로그램을 수행할 때 Java 프로그램에게 문자열 정보를 전달하기 위한 수단
 *     
 *     - 프로그램으로 문자열 정보 전달 방법
 *       1) 외부의 명령어 라인에서 전달하기: java 클래스이름 문자열1 문자열2 문자열3 ...
 *           예: java PrintMainArgs Hi! "My name" is "Hong Gildong " in "Seoul Korea" // 6개의 문자열이 전달됨
 *           
 *       2) Eclipse에서 전달하기: Run -> Run Configurations 클릭한 후
 *           (x)= argument 탭을 클릭하여 program arguments 입력창에 문자열 입력
 *           
 *     - 참고사항
 *       1) 문자열은 "와 " 사이에 표시할 수 있거나 " 생략해도 됨 
 *       2) blank, tab 등의 화이트 스페이스 문자가 문자열에 포함될 경우 반드시 "와 " 사이에 문자열 표시해야 함
 */

class Ex6_5_1_PrintMainArgs {
	public static void main(String[] args) {

		if (args.length == 0) // args.length는 args[] 배열의 원소 개수를 저장하는 필드
			System.out.println("\n  ** 외부에서 전달된 문자열 정보가 없음 **\n");
		else {
			System.out.println("\n  ** 외부에서 전달된 문자열 정보 개수: " + args.length  + " ** \n");

			for (int i = 0; i < args.length; i++)
				System.out.println("  * " + (i + 1) + "번째 전달된 정보: " + args[i]);
		}
	}
} 

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 프로그램 외부에서 전달된 문자열 정보를 main() 메소드의 args[] 배열변수로 전달받아
 *      출력한다.
 *      
 *      예를 들어, Hi! "My name" is "Hong Gildong " in "Seoul Korea"를 전달하면 
 *      이들 문자열 개수와 문자열들을 차례로 출력한다.
 *      
 *   2) Eclipse에서 프로그램으로 문자열 정보 전달하는 방법
 *      Eclipse의 Run -> Run Configurations... ->
 *        -> Main 탭에서  << Main class: >> 오른쪽의 search 클릭하여 ex6_5_1_MainArgs.PrintMainArgs 찾아 클릭
 *        ->(x)= arguments 탭 클릭 
 *        -> Program arguments: 창에   Hi! "My name" is "Hong Gildong" in "Seoul Korea" 입력
 *        -> Run 클릭하면 실행결과가 console 뷰에 출력됨
 *          
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 * 
 *   o Program arguments 문자들을 자신의 이름으로 변경한 후 프로그램을 실행하여 결과 확인하라.
 */
