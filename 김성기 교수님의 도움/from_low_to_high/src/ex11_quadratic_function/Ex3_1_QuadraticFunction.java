package ex11_quadratic_function;
/*
 * [ QuadraticFunction ]: 이차 함수(Quadratic Function)의 함수값 계산
 *    
 *     o 프로그래밍 스타일: 
 *       1) main() 메소드로만 클래스 구성
 *       2) 이차 함수 f(x) = a*x*x + b*x + c의 계수 a, b, c 입력하여  여러 x에 대한 함수값 계산하여 출력
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
class Ex3_1_QuadraticFunction {

	public static void main(String[] args) {

		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    이차 함수 f(x) = ax^2 + bx + c 의 함수값 계산    *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");

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

		// 결정된 이차 함수를 출력
		System.out.println("\n\n  ** 주어진 이차 함수 f(x) = ax^2 + bx + c = " + a + "x^2 + " + b + "x + " + c);

		// x가 -5일 때 함수값 구하여 출력
		x = -5; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);
		System.out.println("\n  * (참고: 계수 a, b가 1일 때  간단 표현방법)  x = " + x +"일 때 f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);

		// x가 -3일 때 함수값 구하여 출력
		x = -3; 	
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 -1일 때 함수값 구하여 출력
		x = -1; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 0일 때 함수값 구하여 출력
		x = 0; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 1일 때 함수값 구하여 출력
		x = 1; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 3일 때 함수값 구하여 출력
		x = 3; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 5일 때 함수값 구하여 출력
		x = 5; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 7일 때 함수값 구하여 출력
		x = 7; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		// x가 10일 때 함수값 구하여 출력
		x = 10; 
		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		
		// x를 입력하여 x에 대한  함수값 구하여 출력
		System.out.print("\n\n  ** x 값 입력하여  x에 대한 함수값 출력 ** ");
		System.out.print("\n\n  o x 값 입력 > ");
		x = SkScanner.getInt();

		y = a*x*x + b*x + c;
		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + a + "x^2 + " + b + "x + " + c + " = "+ a + "*" +  x + "^2 + " + b + "*" + x + " + " + c + " = " + y);

		main(args);
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램은 이차 함수의 계수를 입력받아 이차 함수를 구성하고 여러 x값에 대한 함수값을 출력한다.
 *      프로그램을 살펴보고 프로그램의 내용를 파악하라.     
 *   
 *   2) 이 프로그램에서는 이차 함수의 함수값 계산과정을 보여주기 위해 println()에서 복잡한 문자열 연산이 사용된다.
 *      println()에서 문자열 구성이 어떻게 출력 결과를 생성하는지 잘 살펴보라.
 *     
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램에서 계수로 사용된 변수 a, b, c의 값에 상수 1이 입력된면
 *      출력에서 << ** 주어진 이차 함수 f(x) = ax^2 + bx + c = 1x^2 + 1x + 1 >>로 출력된다.
 *      
 *      그런데 이 경우에는 << ** 주어진 이차 함수 f(x) = ax^2 + bx + c = x^2 + x + 1 >>로 출력하는 것이 바람직하다.
 *      즉, 2차항과 1차항의 계수가 1이면 계수를 생략한다.
 *      
 *      2차항과 1차항의 계수가 1이면 출력되는 이차함수에서 계수를 생략하도록 프로그램을 변경하라. 
 *      (이 때에는 조건 연산 ? : 을 사용하면 간단히 해결 가능함)
 *      
 *   2) 이 프로그램에서 이차 함수의 미지수 변수 x 및 함수값 변수 y, 계수로 사용된 변수 a, b, c는 모두 int 변수로 선언되어 있다.
 *      이 경우 미지수 x는 정수이어야 하며, 계수에 0.2, -12.4 등의 실수값은 사용할 수 없다.
 *      
 *      이 프로그램의  미지수 변수 x 및 함수값 변수 y, 계수로 사용된 변수 a, b, c를 double 변수로 변경하여 
 *      실수값 x, a, b, c에 대해  이차함수 값을 구할 수 있도록 프로그램을 변경하라.
 *      
 */