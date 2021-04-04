package ex9_5_java_exception;

/**
 * [ Ex9_5_2_JavaExceptionNotHandling 클래스 ] : 
 *      Java에서 제공하는 예외 클래스를 발생시켜 이를 처리하지 않을 때의 결과를 보이는 예제
 * 
 *   o Java에서 제공하는 예외
 *     - 프로그램에서 자주 발생하는 예외적 상황에 대해 자동적으로 예외를 발생시키며 
 *       이를 탐지하여 처리할 수 있는 방법을 제공 
 *     - Java에서 제공하는 예외: 정해진 상황에서 시스템에 의해 자동적으로 발생하는 예외
 *     
 *   o Java에서 제공하는 예외 클래스 
 *     - Java에서 제공하는 예외에 대한 각 클래스가 java.lang 패키지에 정의되어 있음 
 *     - Throwable, Error, Exception, RunTimeException 클래스와 이들의 여러 하위 예외 클래스를 제공
 *     
 *     - unchecked 예외: Error 클래스 및 하위 클래스와 RunTimeException 클래스 및 하위 클래스는 
 *       Java 컴파일러가 예외 처리 여부를 검사하지 않으므로 예외 처리를 하지 않아도 됨
 *       
 *     - checked 예외: 그 외의 예외 클래스들은 Java 컴파일러가 예외 처리 여부를 확인하므로 반드시 
 *       예외 처리해야하는 함
 *   
 *     - Java에서 제공하는 예외 클래스의 예
 *       . ArithmeticException: 0으로 나누기 등의 산술 연산에 대한 예외
 *       . ArrayIndexOutOfBoundsException: 배열 인덱스의 범위 초과 예외
 *       . ArrayStoreException: 배열 원소에 맞지 않는 타입의 값 저장의 예외
 *       
 *     - Java에서 제공하는 예외는 프로그램 수행 중 자동적으로 발생하며, 
 *       프로그래머가 던질 수 없음 
 *     - Java에서 제공하는 예외는 프로그래머에 의해 탐지되고 처리될 수 있음 
 *     
 *     - Java에서 제공하는 예외가 발생했을 때 이를  처리하지 않을 경우 main()까지 복귀되고
 *       예외 정보가 출력된 후 프로그램이 종료됨 
 */

class Ex9_5_2_JavaExceptionNotHandling {
	// 0으로 나누기 예외를 발생시키는 메소드 - 예외 발생하지만 처리하지 않음
	static void evokeArithmeticException() {  
		int i = 7, j;
		j = i / 0;   
	}

	// 인덱스 범위 초과 예외를 발생시키는 메소드 - 예외 발생하지만 처리하지 않음
	static void evokeArrayIndexOutOfBoundsException() { 
		int[] arr = new int[10];
		arr[20] = 4;  
	}

	// 예외를 발생시키는 메소드 2개를 호출하는 메소드
	static void evoke2Exceptions() {
		evokeArithmeticException();
		evokeArrayIndexOutOfBoundsException();
	}

	public static void main(String[] args) {
		evoke2Exceptions();
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 0으로 나누기, 인덱스 범위 초과 예외 등 Java에서 제공하는 예외를 
 *      발생시키지만 이를 처리하지는 않는다.
 *   
 *   2) Java에서 제공하는 예외가 발생했지만 이를 처리하지 않으면 최종적으로 
 *      Java 가상기계가 예외 처리하고 프로그램을 종료한다.
 *   
 *   3) 프로그램의 실행 결과를 확인하라.
 *   
 *   4) 발생한 예외 처리하지 않으면 첫 번째 예외 발생했을 때 프로그램이 종료되므로
 *      이 프로그램은  ava.lang.ArithmeticException 예외 처리 후 종료된다.
 *      
 *      다른 예외 발생을 확인하기 위해 << evokeArithmeticException(); >> 부분을 
 *      주석 처리한 후 실행하여 실핼 결과를 확인하라.
 */