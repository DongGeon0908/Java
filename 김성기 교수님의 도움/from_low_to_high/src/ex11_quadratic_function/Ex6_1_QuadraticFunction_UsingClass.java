package ex11_quadratic_function;
/*
 * [ QuadraticFunction ]: 배열과 for 문 이용하여 이차 함수(Quadratic Function)의 함수값 계산
 *    
 *     o 프로그래밍 스타일: 
 *       1) main() 메소드로만 클래스 구성
 *       2) 이차 함수 f(x) = a*x*x + b*x + c의 계수 a, b, c 입력하여  여러 x에 대한 함수값 계산하여 출력
 *       3) 계수, x, y를 저장하는 필드와 필요한 메소드를 가지는 QuadraticFunction 클래스를 젖의
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

class QuadraticFunction {
	
	int x;       // 이차 방적식의 x값
	int y;	     // 이차 방적식의 함수값인 y값
	int a, b, c; // 이차 방적식의 계수
	
	QuadraticFunction() {		
	}
	
	QuadraticFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// 이차 함수의 계수 a, b, c를 입력받아 저장
	void inputCoefficients() {
		System.out.print("  o 이차항 계수 a 입력 > ");
		a = SkScanner.getInt();

		System.out.print("  o 일차항 계수 b 입력 > ");
		b = SkScanner.getInt();

		System.out.print("  o 상수항 계수 c 입력 > ");
		c = SkScanner.getInt();	
	}
	
	// 계수  a, b, c 결정된 이차 함수를 출력
	void outputFuction() {
		System.out.println("\n\n  ** 주어진 이차 함수 f(x) = ax^2 + bx + c = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + "\n");
	}
	
	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 구해 x, y를 필드에 저장하고 y를 반환
	int calculateFuctionValue(int x) {
		this.x = x;
		y = a*x*x + b*x + c;
		
		return y;
	}

	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 출력
	void outputFuctionvalue() {
		// 계산된 이차 함수 값 y를 출력
 		System.out.println("\n  * x = " + x +"일 때 f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " 
		                                + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);
	}
	
	// 계수 a, b, c에 대해 주어진 x에 대한 함수값 y를 구하여 출력
	void calculateOutputFuctionValue(int x) {
		calculateFuctionValue(x);
		outputFuctionvalue();
	}
}


class Ex6_1_QuadraticFunction_UsingClass {
	public static void main(String[] args) {
		 outputTitle();
		
		 QuadraticFunction f = new QuadraticFunction();
		 f.inputCoefficients();
		 f.outputFuction();
		 
		
		// x가 -5, -3, -1, 0, 1, 3, 5, 7, 10일 때 함수값 구하여 출력
		int xs[] = { -5, -3, -1, 0, 1, 3, 5, 7, 10 };
	
        for (int i = 0; i < xs.length; i++) {
        	f.calculateOutputFuctionValue(xs[i]);
        }
		
		// x를 입력하여 x에 대한  함수값 구하여 출력
		System.out.print("\n\n  ** x 값 입력하여  x에 대한 함수값 출력 ** ");
		
		System.out.print("\n\n  o x 값 입력 > ");
		int x = SkScanner.getInt();
		
		f.calculateOutputFuctionValue(x);       

		main(args);
 	}
	
	static void outputTitle() {
		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    이차 함수 f(x) = ax^2 + bx + c 의 함수값 계산         *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램은 이차 함수의 계수를 입력받아 이차 함수를 구성하고 여러 x값에 대한 함수값을 출력하기 위해
 *      클래스를 구성하였다.
 *      
 *      프로그램을 살펴보고 프로그램의 내용를 파악하라.     
 *      
 *   2) 게수 a, b, c와 x,y 값을 저장하기 위한 필드, 여러 메소드가 선언된 것을 잘 살펴보고 
 *      메소드를 사용한 이전 프로그램과 비교하여 보라..
 *     
 *   3) 프로그램을 실행하고 결과를 확인하라.
 *   
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램은 3개의 계수  a, b, c를 가지는 2차 함수 이차 함수에 대한 처리를 한다.
 *   
 *      4개의 계수  a, b, c, d를 가지는 3차 함수 f(x) = ax^3 + bx^2 + cx + d에 대한  처리를 하는 프로그램으로 변경하라.
 *      
 */