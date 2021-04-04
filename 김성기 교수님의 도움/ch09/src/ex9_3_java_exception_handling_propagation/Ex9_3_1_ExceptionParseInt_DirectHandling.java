package ex9_3_java_exception_handling_propagation;

/**
 * [ ExceptionParseInt_DirectHandling 클래스] :
 *       예외발생 메소드를 호출한 메소드에서 try-catch 블록으로 예외를 직접 처리하는 예제
 * 
 *   o 예외발생 메소드를 호출한 메소드에서 예외 직접 처리하기
 *     - 예외발생 메소드를 호출한 메소드에서 try-catch 블록으로 예외 처리
 *   
 *   o java.lang.Integer 클래스의 클래스 메소드 static int parseInt(String s) 
 *     - 주어진 문자열이 정상적인 정수 문자열이면 int로 변환한 정수 반환
 *     - 주어진 문자열이 정상적인 정수 문자열이 아니면 
 *       NumberFormatException 예외객체 생성하여 던짐
 *    
 *     - 이 메소드 호출 시 예외 처리 또는 예외 전파할 수 있음
 */

class Ex9_3_1_ExceptionParseInt_DirectHandling {
	
	// 문자열 입력하여 정수로 변환하여 정수값 반환하는 메소드
	// 예외발생 메소드 호출하면서 예외 처리   
	static int inputStringConvertToInt() {
		String s = SkScanner.getString("\n  o 정수 문자열 입력 > ");

		// 예외발생 메소드를 호출하면서 직접 예외 탐지 및 처리
		try {
			int n = Integer.parseInt(s);   // 예외발생 메소드 호출
			return n;
		}
		catch(NumberFormatException e) {   // 예외객체 잡아 처리함
			System.out.print("\n  ??? parseInt()에서 예외 발생 - " + e.getMessage());

			return -1; // 잘못된 입력에 대해 -1을 반환
		}      
	}

	public static void main(String[] args) {
		while(true) {
			int n = inputStringConvertToInt();
			System.out.println("\n\n  * 입력된 문자열을 변환한 정수 = " + n);

			if (n == -1)
				break;
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 예외발생 메소드인 Integer.parseInt(s)를 inputStringConvertToInt() 
 *      메소드에서 호출한다.
 *
 *   2) inputStringConvertToInt() 메소드에서 try-catch 블록으로 예외 처리를 한다.
 * 
 *   3) 123, 1234, 123A, 1234A, -1 등 여러 문자열을 입력하여 그 결과를 확인하라.
 */
