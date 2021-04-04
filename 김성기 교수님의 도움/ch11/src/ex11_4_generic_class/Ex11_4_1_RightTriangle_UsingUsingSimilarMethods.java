package ex11_4_generic_class;

/**
 * [ RightTriangle_UsingSimilarMethods 클래스 ]: 
 *      유사한 기능의 메소드들을 이용하여 직각 삼각형 그리기 
 * 
 *   o 유사한 여러 메소드들 작성
 *     - 한 라인에 *를 특정 개수만큼 출력하는 5개의 메소드들 
 *       printStar1InLine(), ..., printStar5InLine()
 *         
 *   o 유사한 메소드의 통합의 필요성
 *     - 유사한 메소드가 반복적으로 작성되면 코드가 중복되고 낭비적 요소가 발생함 
 *     - 매개변수 이용하여 하나의 메소드로 작성 가능
 *      
 */

class Ex11_4_1_RightTriangle_UsingUsingSimilarMethods  {
	
	static void printStar1InLine() { 
		for (int i = 0; i < 1; i++)   
			System.out.print('*');  // '*' 1개 출력
		
		System.out.println();       // 줄바꿈
	}
	
	static void printStar2InLine() {  
		for (int i = 0; i < 2; i++)   
			System.out.print('*');  // '*' 2개 출력
		
		System.out.println();       // 줄바꿈
	}  
	
	static void printStar3InLine() {  
		for (int i = 0; i < 3; i++)   
			System.out.print('*');  // '*' 3개 출력
		
		System.out.println();       // 줄바꿈
	}   
	
	static void printStar4InLine() {  
		for (int i = 0; i < 4; i++)   
			System.out.print('*');  // '*' 4개 출력
		
		System.out.println();       // 줄바꿈
	}
	
	static void printStar5InLine() {  
		for (int i = 0; i < 5; i++)   
			System.out.print('*');  // '*' 5개 출력
		
		System.out.println();       // 줄바꿈
	}

	public static void main(String[] args)  {  
		System.out.print("\n  ** 매개변수 없는 메소드들 호출로 작성된 직각 삼각형 **\n");

		printStar1InLine(); 
		printStar2InLine();  
		printStar3InLine();  
		printStar4InLine();  
		printStar5InLine();  		
	}
}

/*
 * [ 실습과제 ]
 * 
 *   1) 밑변이 * 10개인 직각 삼각형을 그리도록 프로그램을 이 스타일대로 수정하라.
 *      이 작업을 위해서 필요한 메소드를 더 작성하고 main() 메소드에서 이를 호출하면 된다.
 *      
 *      이미 작성된 메소드들과 아주 비슷하므로 어렵지 않을 것이다.
 *    
 *   2) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리려면 
 *      몇 개의 메소드가 필요한가 계산하라.       
 */
