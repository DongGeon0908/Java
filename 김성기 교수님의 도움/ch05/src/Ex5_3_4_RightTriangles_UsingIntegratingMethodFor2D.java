/**
 * [ RightTriangles_UsingIntegratedMethod2D ]: 
 *       밑변이 2, 3, 4, 5인 직각 삼각형을 '*', '$', '@', '가'로 그리기(2차원 통합 메소드 사용)
 * 
 *   o 프로그래밍 스타일 
 *     - 2차원적으로 통합된 메소드를 이용한 프로그램
 *     - printCharInLine(char c, int cnt): 한 라인에 매개변수에 주어진 문자 c를 개수 cnt만큼 출력하는 메소드 
 *     - drawRightTriangle(char c, int base): 매개변수에 주어진 문자 c로 밑변 base 개수만큼의 
 *                                            직각 삼각형 그리는 메소드
 *        
 *     - main()에서는 직각 삼각형들 그리는 메소드들 호출하여 여러 삼각형 그림   
 */

class Ex5_3_4_RightTriangles_UsingIntegratingMethodFor2D  {
	public static void main(String[] args)  {	
		drawRightTriangle('*', 2); // '*'로 밑변 2인 직각 삼각형 그리기	
		drawRightTriangle('$', 3); // '$'로 밑변 3인 직각 삼각형 그리기	
		drawRightTriangle('@', 4); // '@'로 밑변 4인 직각 삼각형 그리기	
		drawRightTriangle('가', 5); // '가'로 밑변 5인 직각 삼각형 그리기		
	}

	// 매개변수를 가지는, 2차원 통합 메소드 
	//                 drawRightTriangle(char c, int base)
	// 호출시 매개변수에 주어지는 c로 밑변 base인 직각 삼각형을 그리는 메소드
	public static void drawRightTriangle(char c, int base) { 
		System.out.println("\n  * 밑변이 '" + c + "' " + base + "개인 직각 삼각형  * "); 
		
		for (int cnt = 1; cnt <= base; cnt++) // cnt가 1부터 base까지 증가하면서
			printCharInLine(c, cnt);          //   실매개변수 c와 cnt로 printCharInLine() 호출
	} 

	// 매개변수를 가지는, 2차원 통합 메소드 printCharInLine(char c, int cnt)
	//    호출시 매개변수에 주어지는 c 문자를 cnt 개수만큼 한 라인에 출력
	public static void printCharInLine(char c, int cnt) { 
		for (int i = 0; i < cnt; i++) 	
			System.out.print(c);  // c를 cnt개 출력
		
		System.out.println();     // 줄바꿈
	}       	
}

/*
 * [ 실습과제 ]
 * 
 *    1) 밑변이 'A' 10개, 'B' 11개, ..., 'Z' 35개인 직각 삼각형을 그리도록 프로그램을 수정하라.
 *    
 *    2) 밑변이 10개부터 100개까지의 직각 삼각형을 그리는데, 그릴 문자는 '!'부터 시작하여 
 *       다음 문자들로 차례대로 그리도록 프로그램을 수정하라.        
 */
