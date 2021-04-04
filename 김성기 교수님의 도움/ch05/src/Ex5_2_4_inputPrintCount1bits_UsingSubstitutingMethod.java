/**
 * [ inputPrintCount1bits_UsingSubstitutingMethod ]: 
 *        대체 메소드 사용하여 입력한 정수의 1인 비트 개수 구하여 출력
 * 
 *   o 프로그래밍 스타일 
 *     - 대체 추상화 과정을 통해 대체 메소드 작성
 *     - 작성한 대체 메소드들을 main()에서 호출하여 1인 비트 개수 출력
 *       
 *   o 작성한 대체 메소드
 *     - 정수 입력하여 1인 비트 개수 출력하는 메소드 inputPrintCount1Bits()
 */

class Ex5_2_4_inputPrintCount1bits_UsingSubstitutingMethod  {

	public static void main(String[] args) {
		inputPrintCount1Bits();  // 대체 메소드 호출
	}
	
	// 정수 입력하여 1인 비트 개수 출력하는 대체 메소드
	static void inputPrintCount1Bits() {
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
 *   2) 대체 메소드를 작성하고 작성한 대체 메소드들을 main()에서 호출한다.
 *   
 *   3) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.  
 */
