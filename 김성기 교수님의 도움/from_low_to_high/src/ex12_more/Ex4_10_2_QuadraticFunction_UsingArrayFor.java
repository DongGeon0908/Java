package ex12_more;
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
class Ex4_10_2_QuadraticFunction_UsingArrayFor {

	public static void main(String[] args) {

		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    이차 함수 f(x) = ax^2 + bx + c 의 함수값 계산    *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");

		int x;
		int y;	
		int a, b, c; // 이차 방적식의 계수

		// 이차 함수의 계수 a, b, c를 입력받아 저장
		a = SkScanner.getInt("  o 이차항 계수 a 입력 > ");
		b = SkScanner.getInt("  o 일차항 계수 b 입력 > ");
		c = SkScanner.getInt("  o 상수항 계수 c 입력 > ");

		// 결정된 이차 함수를 출력
		System.out.println("\n\n  ** 주어진 이차 함수 f(x) = ax^2 + bx + c = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c  + "\n");

		// x가 -5, -3, -1, 0, 1, 3, 5, 7, 10일 때 함수값 구하여 출력
		int xs[] = { -5, -3, -1, 0, 1, 3, 5, 7, 10 };
	
        for (int i = 0; i < xs.length; i++) {
        	x = xs[i];
	    	y = a*x*x + b*x + c;
		    System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);
        }
		
		// x를 입력하여 x에 대한  함수값 구하여 출력
		System.out.print("\n\n  ** x 값 입력하여  x에 대한 함수값 출력 ** ");
		System.out.print("\n\n  o x 값 입력 > ");
		x = SkScanner.getInt();

		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		main(args);
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
 *   2) a, b, c 계수가 0인 항을 출력되지 않도록 프로그램을 수정하라.
 *      예를 들어  b 계수가 0, c 계수가 0이면  f(x) = ax^2 + bx + c = x^2로 출력하도록 한다.
 *      
 */