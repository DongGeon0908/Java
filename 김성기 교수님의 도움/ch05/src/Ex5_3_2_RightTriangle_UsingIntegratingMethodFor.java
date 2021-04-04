/**
 * [ RightTriangle_UsingIntegratingMethodFor ]: 
 *       밑변이'*' 5개인 직각 삼각형 그리기(통합 메소드와 for 문 사용하기)
 * 
 *   o 프로그래밍 스타일 
 *     - 통합 추상화를 이용한 메소드의 작성과 메소드 호출
 *     - 한 라인에 '*'를 매개변수에 주어진 회수만큼 출력하는 메소드(printStarInLine(int cnt)) 작성 
 *     - main()에서 for 문을 이용하여 이 메소드를 반복 호출하여 직각 삼각형 그림
 *       
 *  o 대체 메소드를 매개변수 갖는 메소드로 통합
 *    - 유사한 대체 메소드들을 매개변수 이용하여 하나로 통합
 *    - 메소드 이름에 나타난 데이터 요소를 매개변수로 작성 
 *         printStar4InLine()  ==>  printStarInLine(int  cnt)
 *         
 *    - 메소드 호출할 때 실제 매개변수 전달
 *         printStar4InLine();  ==>  printStarInLine(4);
 *         
 *   o 매개변수
 *     - 호출하는 메소드에서 호출되는 메소드로 값을 전달하는 수단
 *     - 메소드 작성할 때에는 값이 주어지지 않지만 메소드 호출할 때 값이 주어짐
 *     - 매개변수로 주어지는 값에 따라 다른 수행 결과를 낳게 됨
 *      
 *   o 매개변수의 종류
 *     - 형식매개변수(formal parameter)
 *       . 작성하는 메소드 시그니처에서 선언하는 변수
 *       . 작성할 때에는 값이 없지만 메소드 호출할 때 실매개변수 값을 전달하여 형식매개변수에 저장
 *       
 *     - 실매개변수(actual parameter)
 *       . 메소드를 호출할 때 주는 값으로, 이 값을 형식매개변수에 전달
 *       . 상수, 변수의 값 또는 수식의 계산 결과가 실매개변수가 됨
 *
 *   o 매개변수와 관련된 중요사항
 *     - 매개변수는 호출하는 메소드에서 호출되는 메소드로 정보 전달하는 수단
 *     - 매개변수가 있는 메소드 호출할 때에는 실매개변수를 반드시 주어야 함 
 *     - 호출된 메소드에서는 실매개변수 값 전달받아 형식매개변수에 저장한 후 메소드 수행
 */

class Ex5_3_2_RightTriangle_UsingIntegratingMethodFor  {
	public static void main(String[] args)  {	
		System.out.println("\n  ** 밑변이 '*' 5개인 직각 삼각형 그리기(매개변수 갖는 메소드와 for 문 이용) **");
		
		for (int i = 1; i <= 5; i++)     // i가 1부터 5까지 증가하면서
			printStarInLine(i);          //   매개변수 i로 printStarInLine() 호출
	} 

	// 매개변수를 가지는 통합된 메소드 printStarInLine(int cnt)
	//    호출할 때 주어지는 매개변수 cnt 개수의 *를 한 라인에 출력
	public static void printStarInLine(int cnt) { 
		for (int i = 0; i < cnt; i++)  // '*' cnt개 출력
			System.out.print('*');  
		System.out.println();          // 줄바꿈
	} 
}

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 예제 5-3-2 프로그램은 매개변수를 갖는 메소드를 for 문을 이용하여 연속적으로 
 *      호출하여 main() 메소드를 간단하게 작성한다.
 *  
 *   2) 예제 5-3-1 프로그램의 main()과 예제 5-3-2 프로그램의 main()을 비교해보라.
 *  
 * 
 * [ 실습과제 ]
 * 
*    1) 밑변이 '*' 10개인 직각 삼각형 그리도록 프로그램을 수정하라.
 *      이 작업을 위해서 필요한 메소드를 더 작성하지 않아도 되며,
 *      main() 메소드를 수정하면 된다.
 *    
 *   2) 이 프로그램의 스타일대로 밑변이 '*' 50개인 직각 삼각형 그리려면 
 *      어떻게 하면 될 것인가?
 *      
 *   3) printStarInLine(int cnt) 메소드를 이용하여 폭이 7, 높이가 8인 사각형 그리는 
 *       프로그램을 Pr5_3_2_Rectangle_UsingIntegratedMethodFor 클래스로 작성하라.
 */
