package ex9_5_java_exception;

/**
 * [ JavaExceptionHandling 클래스 ] : Java에서 제공하는 예외 클래스를 발생시켜 처리하는 예제
 * 
 *   o Java에서 제공하는 예외
 *     - 프로그램에서 자주 발생하는 예외적 상황에 대해서 자동적으로 예외를
 *       발생시키며 이를  탐지하여 처리할 수 있는 방법을 제공 
 *     - Java에서 제공하는 예외: 정해진 상황에서 시스템에 의해 자동적으로 발생하는 예외
 *     
 *   o Java에서 제공하는 예외 클래스 
 *     - Java에서 제공하는 예외에 대한 각 클래스가 java.lang 패키지에 선언되어 있음 
 *     - Throwable, Error, Exception, RunTimeException 클래스와 이들의 여러 하위 예외 클래스를 제공
 *     - unchecked 예외: Error 클래스 및 하위 클래스와 RunTimeException 클래스 및 하위 클래스는 
 *                      Java 컴파일러가 예외 처리 여부를 검사하지 않으므로 예외 처리를 하지 않아도 됨
 *     - checked 예외: 그 외의 예외 클래스들은 Java 컴파일러가 예외 처리 여부를 확인하므로 반드시 예외 처리해야하는 함
 *   
 *     - Java에서 제공하는 예외 클래스의 예
 *       . ArithmeticException: 0으로 나누기 등의 산술 연산에 대한 예외
 *       . ArrayIndexOutOfBoundsException: 배열 인덱스의 범위 초과 예외
 *       . ArrayStoreException: 배열 원소에 맞지 않는 타입의 값 저장의 예외
 *     
 *     - Java에서 제공하는 예외는 프로그램의 수행 중 자동적으로 발생하며, 프로그래머가 던질 수 없음 
 *     - Java에서 제공하는 예외는 프로그래머의 의해 탐지되고 처리될 수 있음 
 */

class Ex9_5_1_JavaExceptionHandling {
	public static void main(String[] args) {
		int i = 7, j;

		try  {
			// 예외 상황: 0으로 나누면 잘못된 나눗셈으로 
			//          ArithmeticException이 자동적으로 발생
			j = i / 0;   
		}
		catch (ArithmeticException e) {
			System.out.println("\n  * 오류: 0으로 나누기: " + e.getMessage());
		}

		int[] arr = new int[10];
		try {
			// 예외 상황: arr[20]은 존재하지 않는 배열원소로 
			//       ArrayIndexOutOfBoundsException이 자동적으로 발생
			arr[20] = 4;  
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\n  * 오류: 범위를 벗어난 배열 인덱스: " + e.getMessage());
		}
	}	
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 0으로 나누기, 인덱스 범위 초과 예외 등 Java에서 제공하는 예외를 발생시키고 이를 처리한다.
 *   
 *   2) 프로그램의 실행 결과를 확인하라.  
 */

