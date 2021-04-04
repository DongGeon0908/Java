/**
 * [ RightTriangles_UsingDrawingMethod ]: 
 *        밑변이 '*' 2, 3, 4, 5개인 직각 삼각형 그리기(대체 메소드를 이용한 대체 메소드들 이용하기)
 * 
 *   o 프로그래밍 스타일 
 *     - 대체 추상화를 적용한 메소드의 작성과 이들 메소드 이용한 메소드의 작성 
 *   
 *   o 작성한 대체 메소드
 *     1) 한 라인에 *를 특정 개수만큼 출력하는 5개 메소드들 
 *          printStar1InLine(), ..., printStar5InLine()
 *           
 *     2) 이들 메소드 이용하여 밑변이 '*' 특정 개수인 직각 삼각형 출력하는 4개의 메소드들
 *          drawRightTriangle_BaseStar2(), ..., drawRightTriangle_BaseStar5() 
 *           
 *   o main()에서는 직각 삼각형 그리는 메소드들 호출하여 여러 직각 삼각형 그림    
 */

class Ex5_2_8_RightTriangles_UsingDrawingMethod  {
	public static void main(String[] args)  {	
		System.out.println("\n  ** 밑변이 '*' 2, 3, 4, 5개인 직각 삼각형 그리기(삼각형 그리는 대체 메소드 이용) **"); 
		
		// 직각 삼각형 그리는 대체 메소드들 호출
		drawRightTriangle_BaseStar2(); 
		drawRightTriangle_BaseStar3(); 
		drawRightTriangle_BaseStar4(); 
		drawRightTriangle_BaseStar5(); 
	}

	/*
	 *  밑변이 '*' n개인 직각 삼각형을 그리는 메소드들
	 */

	static void drawRightTriangle_BaseStar2() { 
		System.out.println("\n  * 밑변이 '*' 2개인 직각 삼각형  * "); 
		
		printStar1InLine();  // printStar1InLine() 메소드 호출
		printStar2InLine();  // printStar2InLine() 메소드 호출
	} 
	static void drawRightTriangle_BaseStar3() { 
		System.out.println("\n  * 밑변이 '*' 3개인 직각 삼각형  * "); 
		
		printStar1InLine();  // printStar1InLine() 메소드 호출
		printStar2InLine();  // printStar2InLine() 메소드 호출
		printStar3InLine();  // printStar3InLine() 메소드 호출
	}
	static void drawRightTriangle_BaseStar4() { 
		System.out.println("\n  * 밑변이 '*' 4개인 직각 삼각형  * "); 
		
		printStar1InLine();  // printStar1InLine() 메소드 호출
		printStar2InLine();  // printStar2InLine() 메소드 호출
		printStar3InLine();  // printStar3InLine() 메소드 호출
		printStar4InLine();  // printStar4InLine() 메소드 호출
	}  
	static void drawRightTriangle_BaseStar5() { 
		System.out.println("\n  * 밑변이 '*' 5개인 직각 삼각형  * "); 
		
		printStar1InLine();  // printStar1InLine() 메소드 호출
		printStar2InLine();  // printStar2InLine() 메소드 호출
		printStar3InLine();  // printStar3InLine() 메소드 호출
		printStar4InLine();  // printStar4InLine() 메소드 호출
		printStar5InLine();  // printStar5InLine() 메소드 호출
	} 

	/*
	 * 한 라인에 '*' n개를 출력하는 메소드들
	 */

	// printStar1InLine() 메소드: 한 라인에 '*' 1개 출력
	public static void printStar1InLine() { 
		for (int i = 0; i < 1; i++)  // '*' 1개 출력
			System.out.print('*');  
		
		System.out.println();        // 줄바꿈
	}
	
	// printStar2InLine() 메소드: 한 라인에 '*' 2개 출력
	public static void printStar2InLine() {  
		for (int i = 0; i < 2; i++)  // '*' 2개 출력
			System.out.print('*');  
		
		System.out.println();        // 줄바꿈
	}
	
	// printStar3InLine() 메소드: 한 라인에 '*' 3개 출력
	public static void printStar3InLine() { 
		for (int i = 0; i < 3; i++) // '*' 3개 출력
			System.out.print('*');  
		
		System.out.println();       // 줄바꿈
	}
	
	// printStar4InLine() 메소드: 한 라인에 '*' 4개 출력
	public static void printStar4InLine() {
		for (int i = 0; i < 4; i++) // '*' 4개 출력	
			System.out.print('*'); 
		
		System.out.println();       // 줄바꿈
	}
	
	// printStar5InLine() 메소드: 한 라인에 '*' 5개 출력
	public static void printStar5InLine() {  
		for (int i = 0; i < 5; i++) // '*' 5개 출력	
			System.out.print('*'); 
		
		System.out.println();       // 줄바꿈
	}

	// print가5InLine() 메소드: 한 라인에 '가' 5개 출력
	//   메소드 이름에 한글 글자가 포함되어도 됨 
	public static void print가5InLine() {  
		for (int i = 0; i < 5; i++) // '가'를 5개 출력	
			System.out.print('가'); 
		
		System.out.println();       // 줄바꿈
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 직각 삼각형을 그리는 대체 메소드를 이용하여  밑변이 * 2개부터 5개인 
 *      직각 삼각형 5개를 을 그린다.
 *   
 *   2) 예제 5-2-8 프로그램을 살펴보고 간단한 대체 메소드를 이용하여  복잡한 기능의 대체 메소드를 
 *      작성하는 원리를 파악하라.
 *      
 *   3) 작성된 한 메소드가 여러 번 호출될 수 있음을 확인하라.
 *      - printStar1InLine()의 경우 4번, printStar2InLine()의 경우 3번 호출됨
 *      
 *   4) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *    
 * 
 * [ 실습과제 ]
 * 
 *   1) 밑변이 '*' 2, 3, 4, 5, 6, 7, 8, 9, 10개인 직각 삼각형들을 모두 그리도록 프로그램을 수정하라.
 *      이 작업을 위해서 필요한 메소드를 더 작성하고 main() 메소드에서 이를 호출하면 된다.
 *      이미 작성한 메소드들과 아주 비슷하므로 어렵지 않을 것이다.
 *    
 *   2) 이 프로그램의 스타일대로 밑변이 '*' 1개부터 50개인 직각 삼각형을 모두 그리려면 
 *      몇 개의 메소드가 필요한가를 계산해보라.      
 *      
 *   3) 밑변이 '*' 3개인 직각 삼각형 그리는 static void drawRightTriangle_BaseStar3() 메소드는
 *      drawRightTriangle_BaseStar2()를 이용하여 다음과 같이 작성할 수 있다.
 *      
 *	      static void drawRightTriangle_BaseStar3() { 
 *		     System.out.println("\n  * 밑변이 '*' 3개인 직각 삼각형  * "); 
 *		
 *		     drawRightTriangle_BaseStar2()  // 밑변이 '*' 2개인 직각 삼각형 그리는 메소드 호출
 *           printStar3InLine();            // printStar3InLine() 메소드 호출
 *	      }
 *
 *      drawRightTriangle_BaseStar4()와 void drawRightTriangle_BaseStar5() 메소드도
 *      마찬가지로 직각 삼각형 그리는 메소드 호출로 보다 간단하게 작성될 수 있다. 
 *      
 *      직각 삼각형 그리는 메소드 호출로 메소드들을 변경하고 실행하여 결과를 확인하라. 
 *          
 *          
 * [ 스스로 생각하고 고민해볼 과제 ] 
 * 
 *   1) '*'를 특정 개수만큼 출력하는 메소드들은 작성하기는 아주 쉬우나 효용성이 부족하며, 
 *      이러한 메소드는 허접한 메소드이다. 
 *       
 *      - 마찬가지로 밑변이 '*' 특정 개수인 직각 삼각형을 그리는 메소드도 작성하기는 쉬우나 
 *        효용성이 부족한 허접한 메소드이다.       
 *      
 *        (그럼에도 불구하고 이러한 메소드들을 작성한 이유는 대체 추상화를 이해하기 위함이며
 *         스마트 메소드의 중요성을 강조하기 위함)
 *       
 *      - 허접한 메소드들은 반드시 스마트 메소드로 재작성되어야 한다. 여기에서 작성한 5개의 
 *        메소드 그리고 작성되지 않았지만 필요시 작성해야할 수천 개의 허접한 메소드를 통합하여 
 *        하나의 스마트 메소드로 재작성하기 위한 방안에 대해 미리 조사해보라. 
 *       
 *      - 이는 유사한 여러 문장들을 통합하여 반복문으로 작성하는 것과 같은 맥락이다.  
 */
