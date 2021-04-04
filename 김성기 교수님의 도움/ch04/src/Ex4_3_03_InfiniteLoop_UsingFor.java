/**
 * [ InfiniteLoop_UsingFor ]: for 문에서 제어변수 초기화, 반복조건, 제어변수 변경 등의 생략     
 *                  
 *   o for 문
 *     - 기능: 반복 제어변수 이용하여 반복 회수 제어하는 대표적인 반복문
 *     - 구성: 반복 제어변수 초기화, 반복조건 검사, 제어변수 변경, 반복 문장 등 4 부분
 *     - 수행방법: 반복조건이 true인 동안 반복 수행될 문장을 계속 수행
 *     - 반복 제어변수 선언: for 문 외부 또는 내부에서 선언 가능
 *     - for 문 외부에서 선언한 반복 제어변수: for 문 내부와 외부에서 사용 가능하며, 
 *                                       for 문이 종료된 후에도 사용 가능함 
 *     - for 문 내부에서 선언한 반복 제어변수: for 문 내에서만 사용 가능 
 *      
 *   o for 문에서의 생략      
 *     - for 문에서 제어변수 초기화, 반복조건, 제어변수 변경 등은 모두 생략될 수 있음
 *     - 반복 실행문장은 생략될 수 없으며, 실행 내용 없으면 공백문(;)을 작성해야 함
 *     
 *     - 특히 반복조건이 생략되면 반복조건은 true가 되므로 for 문은 끝나지 않고 계속 반복됨 
 */

class Ex4_3_03_InfiniteLoop_UsingFor {
	public static void main(String[] args)  {
		System.out.print("\n  ** Infinite loop by for statements **\n\n");

		// forToRun 변수에 1, 2, 3, 4 입력하면 해당 무한 루프 수행
		int forToRun = SkScanner.getIntWithPrompt("  o 1부터 4 사이의 값 입력하면 해당 무한 루프 수행  > ");
		
		if (forToRun == 1)
			for ( ; ; )  		       // 제어변수 초기화, 반복조건, 제어변수 변경 모두 생략: 반복조건 생략되면 무한 루프
				System.out.println("  * This is first infinite loop - never ending!!!");

		if (forToRun == 2)
			for ( ; true; )  	       //  제어변수 초기화, 제어변수 변경 모두 생략: 반복 조건이 true이므로 무한루프
				System.out.println("  * This is second infinite loop - never ending!!!");

		if (forToRun == 3)
			for ( int i = 0; ; i++) {  // 반복조건 생략: 반복조건 생략되면 무한 루프
				System.out.println("  * This is third infinite loop - never ending!!!");
				System.out.println("    i = " + i);
			}
		
		if (forToRun == 4)  {         // 이 경우에는 for 문이 무한히 수행되지만 수행되는 내용은 없음
			System.out.println("  * Just before starting fourth infinite loop - never ending, only so profound silence !!!");
			
			for ( ; ; )  			  // 제어변수 초기화, 반복조건, 제어변수 변경 모두 생략: 반복조건 생략되면 무한 루프
				;                     // 반복수행할 문장이 없으면 공백문으로 작성해야 함
		}
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 4개의 for 문 중 하나를 수행하기 위해 forToRun 변수를 이용한다.
 *   
 *   2) forToRun 변수 값을 1, 2, 3, 4로 각각 변경하여 수행하고 결과를 확인하라.
 *   
 *   3) 반복조건이 true이거나 생략되면 무한 루프임을 확인하라.
 *   
 *   4) 4번째 for 문은 실행되는 것은 없지만 무한 루프를 돈다.
 *   
 */