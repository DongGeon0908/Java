/**
 * [ RightTriangle_UsingDrawingMethod ]: 
 *       밑변이 '*' 5개인 직각 삼각형 그리기(대체 메소드 이용한 대체 메소드 이용)
 * 
 *   o 프로그래밍 스타일 
 *     - 메소드를 사용하여 직각 삼각형 그리는 대체 메소드 작성      
 *     - main()에서는 직각 삼각형을 그리는 메소드 호출하여 삼각형 그림
 *         
 *   o 대체 메소드
 *     - 수행할 문장들을 기능 나타내는 메소드 이름으로 대체하여 작성한 메소드
 *     - 작성한 후 메소드 이름으로 호출하면 대체한 문장들이 수행
 *     - 처리과정의 기능적 추상화: 수행할 문장들의 기능 파악하여 기능 나타내는
 *       메소드 이름으로 수행할 문장들을 대체시키는 추상화로 매우 중요!!!    
 *   
 *   o 작성한 대체 메소드
 *     1) 한 라인에 *를 특정 개수만큼 출력하는 5개의 메소드들 
 *           printStar1InLine(), ..., printStar5InLine() 
 *            
 *     2) 이들 메소드를 이용하여 밑변이 '*' 5개인 직각 삼각형 출력하는 메소드
 *           drawRightTriangle_BaseStar5()             
 */

class Ex5_2_7_RightTriangle_UsingDrawingMethod  {
	public static void main(String[] args)  {	
		System.out.println("\n  ** 밑변이 '*' 5개인 직각 삼각형 그리기(삼각형 그리는 대체 메소드 이용) **"); 
		
		drawRightTriangle_BaseStar5(); // 밑변 '*' 5개인 직각 삼각형 그리는 메소드 호출
	}

	// 밑변이 '*' 5개인 직각 삼각형 그리는 메소드
    static void drawRightTriangle_BaseStar5() { 
    	
    	// printStar1InLine()부터 printStar5InLine()까지 호출
		printStar1InLine();  
		printStar2InLine();  
		printStar3InLine();  
		printStar4InLine();  
		printStar5InLine();  
	} 

	/*
	 * 한 라인에 '*' n개 출력하는 메소드들
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
 *   1) 이 프로그램은 메소드 사용하여 밑변이 * 5개인 직각 삼각형을 그리는 대체 메소드
 *      drawRightTriangle_BaseStar5()를 작성하고 호출한다.
 *   
 *   2) 이 프로그램을 살펴보고 대체 메소드를 작성하는 원리가 무엇인지를 확실히 파악하라.
 *   
 *   3) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *   
 * 
 * [ 실습과제 ]
 * 
 *   1) 밑변이 '*' 10개인 직각 삼각형을 그리도록 이 스타일대로 프로그램을 수정하라.
 *      이 작업을 위해서 필요한 메소드를 더 작성하고 main() 메소드에서 이를 호출하면 된다.
 *      이미 작성한 메소드들과 아주 비슷하므로 어렵지 않을 것이다.
 *   
 *   2) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리려면 
 *      몇 개의 메소드가 필요한가를 계산해보라
 *       
 *   3) 프로그램의 마지막 부분에 한 라인에 '가' 5개 출력하는 print가5InLine() 메소드가 작성되어 있다.
 *      (1) 이와 유사한 기능을 수행하는 한 라인에 '가' 1개, 2개, 3개, 4개, 6개를 출력하는 메소드를 각각 작성하라.
 *      (2) 밑변이 '가' 6개인 직각 삼각형 그리는 drawRightTriangle_Base가6() 메소드를 작성하라. 
 *      (3) main() 메소드에서 drawRightTriangle_Base가6() 메소드를 호출하고 결과를 확인하라.
 *          
 *          
 * [ 스스로 생각하고 고민해볼 과제 ]
 * 
 *   o '*'를 특정 개수만큼 출력하는 메소드들은 작성하기는 아주 쉬우나 효용성이 부족하며, 
 *     이러한 메소드는 허접한 메소드이다. 
 *     
 *     - 마찬가지로 밑변이 '*' 특정개수인 직각 삼각형을 그리는 메소드도 작성하기는 쉬우나 
 *       효용성이 부족한 허접한 메소드이다.       
 *     
 *       (그럼에도 불구하고 이러한 메소드들을 작성한 이유는 대체 추상화를 이해하기 위함이며
 *        스마트 메소드의 중요성을 강조하기 위함)
 *       
 *     - 허접한 메소드들은 반드시 스마트 메소드로 재작성되어야 한다. 여기에서 작성한 5개의 
 *       메소드와 작성되지 않았지만 필요시 작성해야할 수천 개의 허접한 메소드를 통합하여 
 *       하나의 스마트 메소드로 재작성하기 위한 방안에 대해 미리 조사해보라. 
 *       
 *     - 이는 유사한 여러 문장들을 통합하여 반복문으로 작성하는 것과 같은 맥락이다.  
 */
