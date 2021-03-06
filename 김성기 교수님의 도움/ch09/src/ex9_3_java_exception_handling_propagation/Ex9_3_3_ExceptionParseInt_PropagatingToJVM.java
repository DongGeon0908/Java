package ex9_3_java_exception_handling_propagation;

/**
 * [ ExceptionPardeInt_PropagatingToJVM 클래스] :
 *       예외발생 메소드를 호출한 메소드에서 예외 처리 않고서 예외를 JVM까지 전달하는 예제
 *       
 *   o 예외 전파
 *     - 자신을 호출하는 메소드로 예외를 전파시키는 것
 *     - 아주 간단
 *     - 메소드 시그니처에 throws 키워드와 전파할 예외 종류를 나타내는 예외객체 클래스만 명시하면 됨
 *   
 *     - 예외 전파 메소드를 호출한 메소드에서 예외 처리 또는 전파해야 함
 *   
 *   o java.lang.Integer 클래스의 클래스 메소드 static int parseInt(String s) 
 *     - 주어진 문자열이 정상적인 정수 문자열이면 int로 변환한 정수 반환
 *     - 주어진 문자열이 정상적인 정수 문자열이 아니면 
 *       NumberFormatException 예외객체 생성하여 던짐
 *    
 *     - 이 메소드 호출 시 예외 처리 또는 예외 전파할 수 있음
 */

class Ex9_3_3_ExceptionParseInt_PropagatingToJVM {
	
	// 문자열 입력하여 정수로 변환하여 정수값 반환하는 메소드
	//   예외발생 메소드 호출하지만 예외 처리하지 않고 자신을 호출한 메소드로 전파
	static int inputStringConvertToInt() throws NumberFormatException {
		String s = SkScanner.getString("\n\n  o 정수 문자열 입력 > ");

		// 예외발생 메소드 호출하면서 직접 예외 탐지 및 처리하지 않음
		int n = Integer.parseInt(s);   // 예외발생 메소드 호출
		return n;      
	}

	// main() 메소드도 예외 전파할 수 있음
	//   예외발생 메소드 호출하지만 예외 처리하지 않고 JVM으로 예외 전파
	public static void main(String[] args) throws NumberFormatException {
		while(true) {
			/// 예외발생 메소드 호출하면서 직접 예외 탐지 및 처리하지 않음
			int n = inputStringConvertToInt(); // 예외발생 메소드 호출
			
			System.out.println("\n  * 입력된 문자열을 변환한 정수 = " + n);

			if (n == -1)
				break;
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 예외발생 메소드인 Integer.parseInt(s)를 inputStringConvertToInt() 메소드에서 호출한다.
 *
 *   2) inputStringConvertToInt() 메소드에서는 예외 처리를 하지 않고 예외를 호출한 메소드로 전파시킨다.
 *   
 *         static int inputStringConvertToInt() throws NumberFormatException { .... }
 *         
 * 
 *   3) 또한  inputStringConvertToInt() 메소드를  호출한 main()에서도 예외 처리를 하지 않고 예외를 호출한 메소드로 전파시킨다.
 *   
 *         public static void main(String[] args) throws NumberFormatException { ... }
 *         
 *   
 *   4) 그런데, main() 메소드를 호출한 메소드는 Java 가상기계이므로 예외 발생하면 프로그램 실행이 종료된다.
 *     
 *   5) 123, 1234, 123A, 1234A, -1 등 여러 문자열을 입력하여 그 결과를 확인하라. 
 */
