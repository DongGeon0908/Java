package ex11_4_generic_class;

/**
 * [ RightTriangle_UsingIntegratingMethod 클래스 ]: 
 *      '*'로 밑변이 5인 직각 삼각형 그리기(매개변수 갖는 메소드 사용)
 * 
 *   o 유사한 메소드들을 매개변수 갖는 메소드로 통합 
 *     - 매개변수 갖는 통합 메소드의 작성과 메소드 호출
 *     - 한 라인에 *를 매개변수에 주어진 개수만큼 출력하는 통합 메소드인 
 *           printStarInLine(int cnt) 작성 
 *            
 *     - main()에서는 주어진 개수만큼 '*'를 한 라인에 출력하는 메소드들을   
 *       반복적으로 호출하여 '*'로  밑변이 5인 직각 삼각형 그림
 */

class Ex11_4_2_RightTriangle_UsingIntegratedMethod  {
	// 매개변수를 갖는 통합 메소드 printStarInLine(int cnt)
	//    호출할 때 주어지는 매개변수 cnt 개수의 '*'를 한 라인에 출력
	static void printStarInLine(int cnt) { 
		for (int i = 0; i < cnt; i++)   
			System.out.print('*');  // '*'를 cnt 개 출력

		System.out.println();       // 줄바꿈
	}  

	public static void main(String[] args)  {  

		System.out.print("\n  ** 매개변수 갖는 메소드들 호출로 작성된 직각 삼각형 **\n");

		printStarInLine(1);  // 실매개변수 1로 호출
		printStarInLine(2);  // 실매개변수 2로  호출
		printStarInLine(3);  // 실매개변수 3으로 호출
		printStarInLine(4);  // 실매개변수 4로 호출
		printStarInLine(5);  // 실매개변수 5로 호출


		System.out.print("\n\n  ** for 문으로 매개변수 갖는 메소드들 호출하여 작성된 직각 삼각형 **\n");

		for (int i= 1; i <= 15; i++)  // for 문 이용하여 
			printStarInLine(i);       //   실매개변수 i로 호출

	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 예제 11-4-2 프로그램은 예제 11-4-1의 여러 유사한 메소드들을 매개변수를 이용하여 
 *        하나의 메소드로 통합하였다.
 *      
 *      - 통합의 결과로 메소드 이름에 있던 출력할 개수가 매개변수 int cnt로 변환됨
 *      - 매개변수 이용한 메소드 통합 원리 파악할 것 
 *
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *    
 *
 * [ 실습과제 ]
 * 
 *   1) 밑변이 '*' 10개인 직각 삼각형을 그리도록 프로그램을 수정하라.
 *      이 작업을 위해서 필요한 메소드를 호출하면 된다.
 *    
 *   2) 이 프로그램의 스타일대로 밑변이 * 50개인 직각 삼각형을 그리려면 
 *      몇 번의 메소드 호출이 필요한가?   
 *       
 *   3) printStarInLine(int cnt) 메소드를 이용하여 폭이 7, 높이가 8인 사각형을 그리는 
 *      프로그램을 Pr11_4_2_Rectangle_UsingIntegratedMethod 클래스로 작성하라.
 *       
 */