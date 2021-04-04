/**
 * [ RightTriangle_NotUsingMethod ]: 밑변이 * 5개인 직각 삼각형 그리기(메소드 미사용)
 * 
 *   o 프로그래밍 스타일 
 *     - 메소드를 사용하지 않고서 main() 메소드에서 모든 작업을 처리
 *     - 유사한 문장들을 직접 나열하여 직각 삼각형 출력함
 */

class Ex5_2_5_RightTriangle_NotUsingMethod  {
	public static void main(String[] args)  {
		System.out.println("\n  ** 밑변이 '*' 5개인 직각 삼각형 그리기(메소드 미사용) **");

		for (int i = 0; i < 1; i++)  // '*' 1개 출력
			System.out.print('*');
		System.out.println();        // 줄바꿈

		for (int i = 0; i < 2; i++)  // '*' 2개 출력
			System.out.print('*'); 
		System.out.println();        // 줄바꿈  

		for (int i = 0; i < 3; i++)  // '*' 3개 출력
			System.out.print('*'); 
		System.out.println();        // 줄바꿈  

		for (int i = 0; i < 4; i++)  // '*' 4개 출력
			System.out.print('*'); 
		System.out.println();        // 줄바꿈  

		for (int i = 0; i < 5; i++)  // '*' 5개 출력
			System.out.print('*');   
		System.out.println();        // 줄바꿈  
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 메소드 사용하지 않고서 밑변이 * 5개인 직각 삼각형을 그린다.
 *   
 *   2) 프로그램을 잘 살펴보고 실행하여 결과를 확인하라.
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 밑변이 * 10개인 직각 삼각형을 그리도록 프로그램을 이 스타일대로 수정하라.
 *    
 *   2) 이 프로그램을 중첩된 for 문을 사용하여 간결하게 재작성하라.
 *    
 *    
 * [ 참고사항 ]
 * 
 *   1) 이 프로그램은 대체 메소드의 예를 보여주기 위해 5 부분으로 나누어 작성됨
 *    
 *   2) 이 프로그램을 중첩된 for 문을 사용하여 간결하게 작성할 수 있으며, 
 *      실습 과제 2)를 반드시 해볼 것
 */
