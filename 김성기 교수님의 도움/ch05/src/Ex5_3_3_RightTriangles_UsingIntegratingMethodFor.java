/**
 * [ RightTriangles_UsingIntegratedMethodFor ]: 
 *       밑변이 2, 3, 4, 5인 직각 삼각형을 '*'로 그리기(통합 메소드 사용)
 * 
 *   o 프로그래밍 스타일 
 *     - 통합된 메소드를 이용한 프로그램
 *     - printCharInLine(char c, int cnt): 한 라인에 매개변수에 주어진 문자와 회수만큼 출력하는 메소드 
 *     - drawRightTriangle_BaseStar(int base): 문자 *로 밑변 base 개수만큼의 직각 삼각형 그리는 메소드
 *     - main()에서는 직각 삼각형 그리는 메소드들 호출하여 여러 삼각형 그림
 *     
 *   o 메소드 호출시 실매개변수에 상수 뿐 아니라 변수 또는 수식 사용 가능
 *     - for 문에서 반복적으로 메소드 호출 가능
 *     - 매개변수 갖는 메소드는 통합 효과뿐 아니라 활용도도 매우 증가  
 *     - 배열 또는 반복문의 활용도가 높아짐과 같은 원리
 */

class Ex5_3_3_RightTriangles_UsingIntegratingMethodFor  {

	public static void main(String[] args)  {	
		for (int i = 2; i <= 5; i++)           // 밑변이 '*' 2개부터 5개까지 
			drawRightTriangle_BaseStar(i);     //    삼각형 그리는 메소드 호출	
	}

	// 매개변수를 갖는 통합 메소드 drawRightTriangle_BaseStar(int base)
	//     밑변의 '*' 개수가 매개변수 base인 직각 삼각형 그림
	static void drawRightTriangle_BaseStar(int base) { 
		System.out.println("\n  * 밑변이 '*' " + base + "개인 직각 삼각형  *"); 
		
		for (int n = 1; n <= base; n++) // n이 1부터 cntBase까지 증가하면서
			printStarInLine(n);         //   실매개변수 n으로 printStarInLine() 호출
	} 

	// 매개변수를 갖는 통합 메소드 printStarInLine(int cnt)
	//    호출시 주어지는 매개변수 cnt 개수만큼 '*'를 한 라인에 출력
	static void printStarInLine(int cnt) { 
		for (int i = 0; i < cnt; i++) 	
			System.out.print('*');  // '*' n개 출력
		
		System.out.println();       // 줄바꿈
	}       	
}

/*
 * [ 실습과제 ]
 * 
 *    1) 밑변이 '*' 10개,  11개, ..., 36개인 직각 삼각형을 그리도록 프로그램을 수정하라.
 *    
 *    2) 밑변이 10개부터 100개까지의 직각 삼각형을 그리는데, 그릴 문자는 '!'부터 시작하여 
 *       다음 문자들로 차례대로 그리도록 프로그램을 수정하라.        
 */
