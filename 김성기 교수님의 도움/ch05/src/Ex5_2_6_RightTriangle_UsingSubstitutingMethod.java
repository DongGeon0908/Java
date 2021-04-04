/**
 * [ RightTriangle_UsingSubstitutingMethod ]: 
 *       밑변이 * 5개인 직각 삼각형 그리기(대체 메소드 사용)
 * 
 *   o 프로그래밍 스타일 
 *     - 대체 추상화 과정을 통해 대체 메소드들 작성
 *     - 작성한 대체 메소드들을 main()에서 호출하여 직각 삼각형 출력
 *       
 *   o 대체 메소드
 *     - 수행할 문장들을 기능 나타내는 메소드 이름으로 대체하여 작성한 메소드
 *     - 작성한 후 메소드 이름으로 호출하면 대체한 문장들이 수행
 *     - 처리과정의 기능적 추상화: 수행할 문장들의 기능 파악하여 기능 나타내는
 *       메소드 이름으로 수행할 문장들을 대체시키는 추상화로 매우 중요!!!    
 *   
 *   o 작성한 대체 메소드
 *     - 한 라인에 *를 특정 개수만큼 출력하는 5개의 메소드들 
 *         printStar1InLine(), ..., printStar5InLine()
 */

class Ex5_2_6_RightTriangle_UsingSubstitutingMethod  {
	public static void main(String[] args)  {
		System.out.println("\n  ** 밑변이 '*' 5개인 직각 삼각형 그리기(대체 메소드 사용) **");

		// 작성한 대체 메소드들 호출
		printStar1InLine(); 
		printStar2InLine();  
		printStar3InLine();  
		printStar4InLine();  
		printStar5InLine();  
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
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 대체 메소드를 작성하고 이들을 호출하여 밑변이 * 5개인 직각 삼각형을 그린다.
 *      - 이 프로그램은 예제 5-2-5 프로그램을 대체 메소드로 변경하여 작성한 것
 *      
 *   2) 이 프로그램을 살펴보고 대체 메소드를 작성하는 원리가 무엇인지를 다시 한 번 파악하라.
 *   
 *   3) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *   
 * 
 * [ 실습과제 ]
 * 
 *   1) 밑변이 * 10개인 직각 삼각형을 그리도록 프로그램을 이 스타일대로 수정하라.
 *      이 작업을 위해서 필요한 메소드를 더 작성하고 main() 메소드에서 이를 호출하면 된다.
 *      이미 작성한 메소드들과 아주 비슷하므로 어렵지 않을 것이다.
 *    
 *   2) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리려면 
 *      몇 개의 메소드가 필요한가를 계산해보라.   
 *      
 *   3) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리려면 
 *      얼마의 시간이 소요되겠는가. 예상 소요시간을 계산해보라.
 *      
 *      예상 시간은 기존의 대체 메소드를 복사하여 붙여넣기한 후 적절히 수정하는데 소용되는 시간과  
 *      main()에서  기존의 메소드 호출을 복사하여 붙여넣기한 후 적절히 수정하는데 
 *      소요되는 시간을 예측하면 된다.
 *      
 *   4) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리는 대체 메소드를 작성하고
 *      main()에서 이들을 호출하는 코드를 추가로 작성하라. 
 *       
 *      그리고 반드시 작성에 소요된 시간을 측정하여 3)에서 예상한 시간과 비교하라. 
 */
