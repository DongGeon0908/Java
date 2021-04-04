package ex12_more;
/*
 *  [ Print_IlikeJavaAny_UsingSwitch ]: "I Like Java "를 입력한 회수만큼  출력하기
 *  
 *   o 스타일 6: 반복문 사용하지 않기
 *           + switch 문과 메소드 이용하여 "I Like Java "를 출력
 *      
 *   o 똑같은 작업을 반복하는 프로그램을 반복문을 사용하지 않고서 직접 작성해보는 것은 
 *     반복문의 중요성을 이해하기 위해 매우 중요하다.
 *        
 *   o 반복문을 사용하지 않고서 직접 반복문장을 나열하는 것은 반복 회수에 따라 난이도가 달라진다. 
 *     반복회수가 작을 때는 때에는 대수롭지 않다가, 회수가 많아지면 점점 어려워져 
 *     회수가 아주 많아지면 거의 불가능해 보이기도 한다. 
 *     1221번은 직접 할 수 있으나 12321번, 1234321번 등의 가능할까?
 *       
 *   ************************************************************************************
  *    o 반복문 쓰지 않고 1221번 또는 그 이상을 출력하는 프로그램 작성하기
  *    
 *       - 네번째 방법: switch 문과  메소드를 작성하고 이를 호출
 *       
 *       - 지금까지의 프로그램은 특정 회수의 "I Like Java "를 반복문 사용하지 않고서  출력하는 방법을 살펴봄
 *       
 *       - 가징 어려운 방법이 반복문과 재귀 메소드를 사용하지 않고서 입력된 회수만큼
 *         "I Like Java "를  출력하는 문제이다.
 *       
 *       - 이 문제에 대한 가장 좋다고 생각되는 해답이 switch 문을 사용하는 것이며
 *         작성된 프고그램은 99999번까지의 회수를 커버한다.
 *         (10만 또는 100번 이상의 회수를 출력하려면 더 많은 메소드 작성해야 함)
 *           
 *   **************************************************************************************
 */

public class Ex4_04_8_Print_IlikeJavaAny_UsingSwitch {
	public static void main(String[] args)  {
		int cnt = SkScanner.getIntWithPrompt("\n\n  o Input count to print(maximun 99999) > ");
		
		print_IlikeJava_AnyTimes(cnt);
	}
	
	static void print_IlikeJava_AnyTimes(int cnt) {
		int cnt10000 = cnt / 10000 % 10;   // 입력된 정수의 만 자리 디지트 구함
		int cnt1000 = cnt / 1000 % 10;     // 입력된 정수의 천 자리 디지트 구함
		int cnt100 = cnt / 100 % 10;	   // 입력된 정수의 백 자리 디지트 구함
		int cnt10 = cnt / 10 % 10;         // 입력된 정수의 십 자리 디지트 구함
		int cnt1 = cnt % 10;               // 입력된 정수의 일 자리 디지트 구함
		
		printLikeJava10000Digit( cnt10000 );  // 만 단위의  회수를 출력
		printLikeJava1000Digit( cnt1000 );    // 천 단위의  회수를 출력
		printLikeJava100Digit( cnt100 );      // 백 단위의  회수를 출력
		printLikeJava10Digit( cnt10 );        // 십 단위의  회수를 출력
		printLikeJava1Digit( cnt1 );          // 일 단위의  회수를 출력
	}

	// 일 단위의  회수가 cnt에 주어지면 이 회수만큼 "I Like Java "를 출력
	//  예를 들어, cnt가 9이면 9번 출력
	static void printLikeJava1Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike1Times();
		case 8:
			printLike1Times();				
		case 7:
			printLike1Times();			
		case 6:
			printLike1Times();	
		case 5:
			printLike1Times();
		case 4:
			printLike1Times();				
		case 3:
			printLike1Times();			
		case 2:
			printLike1Times();	
		case 1:
			printLike1Times();
		}
	}

	// 십 단위의  회수가 cnt에 주어지면 이 회수만큼 "I Like Java "를 출력
	//  예를 들어, cnt가 9이면 90번 출력
	static void printLikeJava10Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike10Times();
		case 8:
			printLike10Times();				
		case 7:
			printLike10Times();			
		case 6:
			printLike10Times();	
		case 5:
			printLike10Times();
		case 4:
			printLike10Times();				
		case 3:
			printLike10Times();			
		case 2:
			printLike10Times();	
		case 1:
			printLike10Times();
		}
	}

	// 백 단위의  회수가 cnt에 주어지면 이 회수만큼 "I Like Java "를 출력
	//  예를 들어, cnt가 9이면 900번 출력
	static void printLikeJava100Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike100Times();
		case 8:
			printLike100Times();				
		case 7:
			printLike100Times();			
		case 6:
			printLike100Times();	
		case 5:
			printLike100Times();
		case 4:
			printLike100Times();				
		case 3:
			printLike100Times();			
		case 2:
			printLike100Times();	
		case 1:
			printLike100Times();
		}
	}
	
	// 천 단위의  회수가 cnt에 주어지면 이 회수만큼 "I Like Java "를 출력
	//  예를 들어, cnt가 9이면 9000번 출력
	static void printLikeJava1000Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike1000Times();
		case 8:
			printLike1000Times();				
		case 7:
			printLike1000Times();			
		case 6:
			printLike1000Times();	
		case 5:
			printLike1000Times();
		case 4:
			printLike1000Times();				
		case 3:
			printLike1000Times();			
		case 2:
			printLike1000Times();	
		case 1:
			printLike1000Times();
		}
	}

	// 만 단위의  회수가 cnt에 주어지면 이 회수만큼 "I Like Java "를 출력
	//  예를 들어, cnt가 9이면 90000번 출력
	static void printLikeJava10000Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike10000Times();
		case 8:
			printLike10000Times();				
		case 7:
			printLike10000Times();			
		case 6:
			printLike10000Times();	
		case 5:
			printLike10000Times();
		case 4:
			printLike10000Times();				
		case 3:
			printLike10000Times();			
		case 2:
			printLike10000Times();	
		case 1:
			printLike10000Times();
		}
	}
	
	/*
	 * 반복문을 사용하지 않고서 "I Like Java "를 출력하기 위해 작성한 메소드들
	 * 1번, 10번, 100번, 10000번, 100000번 출력하는 메소드를 작성
	 */
	// "I Like Java "를 1번 출력
	public static void printLike1Times() {
		System.out.print("I Like Java ");
	}

	// "I Like Java "를 10번 출력
	public static void printLike10Times() {
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
	}

	// "I Like Java "를 100번 출력
	public static void printLike100Times() {
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
	}

	// "I Like Java "를 1000번 출력
	public static void printLike1000Times() {
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
	}


	// "I Like Java "를 10000번 출력
	public static void printLike10000Times() {
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
	}
}

