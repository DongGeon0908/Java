package ex11_quadratic_function;
/*
 * [ QuadraticFunction ]: 배열과 for 문 이용하여 이차 함수(Quadratic Function)의 함수값 계산
 *    
 *     o 프로그래밍 스타일: 
 *       1) main() 메소드로만 클래스 구성
 *       2) 이차 함수 f(x) = a*x*x + b*x + c의 계수 a, b, c 입력하여  여러 x에 대한 함수값 계산하여 출력
 *       3) 배열과 for 문 이용하여  여러 x 값에 대한 함수 값 구함
 *         
 *     o 이차 함수의 함수값 계산 
 *       - 이차 함수: f(x) = ax^2 + bx + c (a != 0) 형태로 표현되는 함수
 *       - 함수값 계산: 주어진 x 값 x'에 대해 
 *            f(x') =  ax'^2 '+ bx' + c 를 계산한 결과를 구하는 것
 *            
 *         예) f(x) = ax^2 + bx + c인 이차 함수에 대해
 *            f(1) = 2*1^2+ 2*1 + 1 = 2 + 2 + 1 = 5이므로
 *            x=1일 때의 함수값은 5임
 */
class Ex5_1_QuadraticFunction_UsingMethod {

	public static void main(String[] args) {
		outputTitle();
		
		int x;       // 이차 방적식의 x값
		int y;	     // 이차 방적식의 함수값인 y값
		int a, b, c; // 이차 방적식의 계수

		// 이차 함수의 계수 a, b, c를 입력받아 저장
		System.out.print("  o 이차항 계수 a 입력 > ");
		a = SkScanner.getInt();

		System.out.print("  o 일차항 계수 b 입력 > ");
		b = SkScanner.getInt();

		System.out.print("  o 상수항 계수 c 입력 > ");
		c = SkScanner.getInt();
		
		 outputFuction(a, b, c);
		 
		
		// x가 -5, -3, -1, 0, 1, 3, 5, 7, 10일 때 함수값 구하여 출력
		int xs[] = { -5, -3, -1, 0, 1, 3, 5, 7, 10 };
	
        for (int i = 0; i < xs.length; i++) {
        	calculateOutputFuctionValue(a, b, c, xs[i]);
        }
		
		// x를 입력하여 x에 대한  함수값 구하여 출력
		System.out.print("\n\n  ** x 값 입력하여  x에 대한 함수값 출력 ** ");
		System.out.print("\n\n  o x 값 입력 > ");
		x = SkScanner.getInt();
		calculateOutputFuctionValue(a, b, c, x);       

		main(args);
 	}
	
	static void outputTitle() {
		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    이차 함수 f(x) = ax^2 + bx + c 의 함수값 계산        *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");
	}
		
	// 계수 a, b, c 결정된 이차 함수를 출력
	static void outputFuction(int a, int b, int c) {

		System.out.println("\n\n  ** 주어진 이차 함수 f(x) = ax^2 + bx + c = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + "\n");
	}
	
	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 구해 반환
	static int calculateFuctionValue(int a, int b, int c, int x) {
		return  a*x*x + b*x + c;
	}

	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 출력
	static void outputFuctionvalue(int a, int b, int c, int x, int y) {
		// 계산된 이차 함수 값 y를 출력
 		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);
	}
	
	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 구하여 출력
	static void calculateOutputFuctionValue(int a, int b, int c, int x) {
		int y = calculateFuctionValue(a, b, c, x);
		outputFuctionvalue(a, b, c, x, y);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램은 이차 함수의 계수를 입력받아 이차 함수를 구성하고 여러 x값에 대한 함수값을 출력한다.
 *      프로그램을 살펴보고 프로그램의 내용를 파악하라.     
 *      
 *   2) 여러 x 값에 대한 함수 값을 구하기 위해 xs 배열변수에 여러 값을 저장하고
 *      for 문에서 원소 하나에 대해 함수값을 구하여 출력하므로 프로그램이 훨씬 간명하다.
 *     
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램에서 이차 함수의 미지수 변수 x 및 함수값 변수 y, 계수로 사용된 변수 a, b, c는 모두 int 변수로 선언되어 있다.
 *      이 경우 미지수 x는 정수이어야 하며, 계수에 0.2, -12.4 등의 실수값은 사용할 수 없다.
 *      
 *      이 프로그램의  미지수 변수 x 및 함수값 변수 y, 계수로 사용된 변수 a, b, c를 double 변수로 변경하여 
 *      실수값 x, a, b, c에 대해  이차함수 값을 구할 수 있도록 프로그램을 변경하라.
 *      
 */