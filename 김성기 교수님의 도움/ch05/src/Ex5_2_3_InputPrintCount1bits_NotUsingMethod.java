/**
 * [ InputPrintCount1bits_NotUsingMethod ]: 
 *       메소드 사용하지 않고서 입력한 정수의 1인 비트 개수 구하여 출력
 * 
 *   o 프로그래밍 스타일 
 *     - 메소드 작성하지 않고서 main() 메소드에서 1인 비트 개수 구하여 출력함
 */

class Ex5_2_3_InputPrintCount1bits_NotUsingMethod  {
	public static void main(String[] args) {
		int cnt = 0;
		int n0, n;
		n0 = n = SkScanner.getIntWithPrompt("\n  o 1인 비트 개수 구할 양의 정수 입력하시오 > ");

		while (n != 0) {
			if (n % 2 == 1)  cnt++;
			n = n / 2;
		}

		System.out.println("\n  * " + n0 +"의 1인 비트의 개수 = " + cnt);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 입력된 정수의 1인 비트 개수 구하여 출력한다.
 *   
 *   2) 프로그램을 잘 살펴보고 실행하여 결과 확인하라.
 *   
 * 
 * [ 참고사항 ]
 * 
 *   o 이 프로그램에서 음수 정수를 입력하면 항상 1인 비트의 개수가 0으로 출력된다.
 *     그 이유가 무엇인지를 생각해보라.
 *     
 *     Java에서 음수 정수는 2의 보수로 표현되며, 정수 -1의  1인 비트의 개수는 32개이다.
 *     
 *     음수의 경우에 1인 비트의 개수를 출력하도록 프로그램을 수정할 수 있으면 하라.
 */
