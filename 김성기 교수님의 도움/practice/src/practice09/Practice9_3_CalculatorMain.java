package practice09;

/**
 *  [ 9장 실습과제  3의 기본 프로그램 ]
 *  
 *    3. calculate() 메소드의 예외 처리 
 *    
 *       Calculator 클래스의 static 메소드인 calculate()는 왼쪽 피연산자, 연산자, 오른쪽 피연산자가 
 *       주어지면 연산자에 따른 계산을 수행하여 연산결과를 반환하는 메소드이다. 이 메소드는 연산자가 
 *       ‘+’, ‘-’, ‘*’, ‘/’, ‘%’ 중의 하나가 아니거나 연산자가 ‘/’ 또는 ‘%’일 때 오른쪽 연산자가 0이면 
 *       자체적으로 오류 처리를 수행한다.
 *       
 *       더욱 나은 예외 처리를 위하여 다음의 3가지 방법으로 예외 처리를 수행하라.
 *       
 *       1) 오류가 발생하는 경우 Calculator 클래스의 클래스 필드인 static String errorMsg에 오류 메시지를 
 *          저장한 후 Double.NaN을 반환하는 Calculator 클래스의 
 *          static double calculate1(double oprdLeft, char opr, double oprdRight) 메소드를 작성하라.
 *          
 *          이 메소드를 호출하는 main() 메소드에서 errorMsg 필드가 null이 아니면 오류를 처리하는 코드를 작성하라. 
 *          이를 위해서 Calculator 클래스에 errorMsg 필드도 선언하고 calculate1() 메소드에서 오류가 없으면 
 *          errorMsg 필드에 null을 저장한다.
 *          
 *       2) 오류가 발생하는 경우 Exception 클래스의 예외객체를 생성하여 적절한 오류 메시지를 저장한 후 예외객체를 던지는
 *          Calculator 클래스의 static double calculate2(double oprdLeft, char opr, double oprdRight) 
 *          메소드를 예외발생 메소드로 작성하라. 
 *          
 *          이 메소드를 호출하는 main() 메소드에서 예외객체를 잡아 예외 처리하는 코드를 작성하라.
 *          
 *       3) 오류가 발생하는 경우 CalculatorException 클래스의 예외객체를 생성하여 적절한 오류 메시지를 저장한 후 
 *          예외객체를 던지는 Calculator 클래스의  static double 
 *          calculate3(double oprdLeft, char opr, double oprdRight) 메소드를 예외발생 메소드로 작성하라. 
 *          
 *          이 메소드를 호출하는 main() 메소드에서 예외객체를 잡아 예외 처리하는 코드를 작성하라. 이를 위해서 CalculatorException 클래스도 작성하라.
 */

class Calculator {
	double oprdLeft;
	char opr;
	double oprdRight;

	Calculator(double oprdLeft, char opr, double oprdRight) {
		this.oprdLeft = oprdLeft;
		this.opr = opr;
		this.oprdRight = oprdRight;
	}

	// Calculator 객체에 저장된 왼쪽 피연산자, 연산자, 오른쪽 피연산자로 연산 수행하여 결과 반환하는 메소드
	double calculate() {
		return calculate(oprdLeft, opr, oprdRight);
	}

	// 왼쪽 피연산자, 연산자, 오른쪽 피연산자가 매개변수로 주어지면 연산 수행하여 결과 반환하는 메소드
	//   연산자가 '+', '-', '*', '/', '%' 일 때 연산결과를 반환
	//   연산자가 '+', '-', '*', '/', '%' 중의 하나가 아니거나 
	//   연산자가 '/' 또는 '%'일 때 오른쪽 피연산자가 0이면 오류 처리하고 Double.NaN 반환
	static double calculate(double oprdLeft, char opr, double oprdRight) { 
		switch(opr) {
		case '+': return oprdLeft + oprdRight;
		case '-': return oprdLeft - oprdRight;
		case '*': return oprdLeft * oprdRight;

		case '/': 
			if (oprdRight == 0) {
				System.out.println("\n  ??? 나누기 연산 오류: 0으로 나누기 불가함");
				return Double.NaN;
			}
			return oprdLeft / oprdRight;

		case '%': 
			if (oprdRight == 0) {
				System.out.println("\n  ??? 나머지 연산 오류: 0의 나머지 구할 수 없음");
				return Double.NaN;
			}
			return oprdLeft % oprdRight;

		default:
			System.out.println("\n  ??? 연산자 오류: '" + opr + "' - 잘못된 연산자");
			return Double.NaN;
		}	   
	}

	public String toString() {
		return "" + oprdLeft + " " + opr + " " + oprdRight + " = " + this.calculate();
	}

	void output() {
		System.out.println("  * " + this.toString());
	}
}

class Practice9_3_CalculatorMain {
	public static void main(String[] args) {
		System.out.println("\n  * 3 + 7 = " + Calculator.calculate(3, '+', 7));
		System.out.println("\n  * 3 - 7 = " + Calculator.calculate(3, '-', 7));
		System.out.println("\n  * 3 * 7 = " + Calculator.calculate(3, '*', 7));
		System.out.println("\n  * 3 / 0 = " + Calculator.calculate(3, '/', 0));
		System.out.println("\n  * 3 % 0 = " + Calculator.calculate(3, '%', 0));
		System.out.println("\n  * 3 $ 7 = " + Calculator.calculate(3, '$', 0));   

		while(true) {
			System.out.print("\n  o 연산 입력(예: 3.5 * 4.5) > ");
			double oprd1 = SkScanner.getDouble();
			char opr = SkScanner.getCharNonWhite();
			double oprd2 = SkScanner.getDouble();

			Calculator c = new Calculator(oprd1, opr, oprd2);
			c.output();			
		}
	}
}

/*
 * [ 참고사항 ]
 * 
 *   o 이 프로그램에서 연산자를 나타내는 문자를 입력하기 위해 SkScanner 클래스의 getCharNonWhite() 메소드를 
 *     이용한다. 
 *     
 *     getCharNonWhite() 메소드는 문자 중에서 white 문자(공백문자 ' ', 탭 문자 '\t', 줄바꿈 문자 '\n)는 
 *     무시하고 white 문자가 아닌 문자를 읽어 들이는 클래스 메소드이다. 
 *     
 *     getCharNonWhite() 메소드의 시그니처는 다음과 같다.
 *     
 *        static char getCharNonWhite()
 * 
 */
