package practice09;

/**
 *  [ 9�� �ǽ�����  3�� �⺻ ���α׷� ]
 *  
 *    3. calculate() �޼ҵ��� ���� ó�� 
 *    
 *       Calculator Ŭ������ static �޼ҵ��� calculate()�� ���� �ǿ�����, ������, ������ �ǿ����ڰ� 
 *       �־����� �����ڿ� ���� ����� �����Ͽ� �������� ��ȯ�ϴ� �޼ҵ��̴�. �� �޼ҵ�� �����ڰ� 
 *       ��+��, ��-��, ��*��, ��/��, ��%�� ���� �ϳ��� �ƴϰų� �����ڰ� ��/�� �Ǵ� ��%���� �� ������ �����ڰ� 0�̸� 
 *       ��ü������ ���� ó���� �����Ѵ�.
 *       
 *       ���� ���� ���� ó���� ���Ͽ� ������ 3���� ������� ���� ó���� �����϶�.
 *       
 *       1) ������ �߻��ϴ� ��� Calculator Ŭ������ Ŭ���� �ʵ��� static String errorMsg�� ���� �޽����� 
 *          ������ �� Double.NaN�� ��ȯ�ϴ� Calculator Ŭ������ 
 *          static double calculate1(double oprdLeft, char opr, double oprdRight) �޼ҵ带 �ۼ��϶�.
 *          
 *          �� �޼ҵ带 ȣ���ϴ� main() �޼ҵ忡�� errorMsg �ʵ尡 null�� �ƴϸ� ������ ó���ϴ� �ڵ带 �ۼ��϶�. 
 *          �̸� ���ؼ� Calculator Ŭ������ errorMsg �ʵ嵵 �����ϰ� calculate1() �޼ҵ忡�� ������ ������ 
 *          errorMsg �ʵ忡 null�� �����Ѵ�.
 *          
 *       2) ������ �߻��ϴ� ��� Exception Ŭ������ ���ܰ�ü�� �����Ͽ� ������ ���� �޽����� ������ �� ���ܰ�ü�� ������
 *          Calculator Ŭ������ static double calculate2(double oprdLeft, char opr, double oprdRight) 
 *          �޼ҵ带 ���ܹ߻� �޼ҵ�� �ۼ��϶�. 
 *          
 *          �� �޼ҵ带 ȣ���ϴ� main() �޼ҵ忡�� ���ܰ�ü�� ��� ���� ó���ϴ� �ڵ带 �ۼ��϶�.
 *          
 *       3) ������ �߻��ϴ� ��� CalculatorException Ŭ������ ���ܰ�ü�� �����Ͽ� ������ ���� �޽����� ������ �� 
 *          ���ܰ�ü�� ������ Calculator Ŭ������  static double 
 *          calculate3(double oprdLeft, char opr, double oprdRight) �޼ҵ带 ���ܹ߻� �޼ҵ�� �ۼ��϶�. 
 *          
 *          �� �޼ҵ带 ȣ���ϴ� main() �޼ҵ忡�� ���ܰ�ü�� ��� ���� ó���ϴ� �ڵ带 �ۼ��϶�. �̸� ���ؼ� CalculatorException Ŭ������ �ۼ��϶�.
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

	// Calculator ��ü�� ����� ���� �ǿ�����, ������, ������ �ǿ����ڷ� ���� �����Ͽ� ��� ��ȯ�ϴ� �޼ҵ�
	double calculate() {
		return calculate(oprdLeft, opr, oprdRight);
	}

	// ���� �ǿ�����, ������, ������ �ǿ����ڰ� �Ű������� �־����� ���� �����Ͽ� ��� ��ȯ�ϴ� �޼ҵ�
	//   �����ڰ� '+', '-', '*', '/', '%' �� �� �������� ��ȯ
	//   �����ڰ� '+', '-', '*', '/', '%' ���� �ϳ��� �ƴϰų� 
	//   �����ڰ� '/' �Ǵ� '%'�� �� ������ �ǿ����ڰ� 0�̸� ���� ó���ϰ� Double.NaN ��ȯ
	static double calculate(double oprdLeft, char opr, double oprdRight) { 
		switch(opr) {
		case '+': return oprdLeft + oprdRight;
		case '-': return oprdLeft - oprdRight;
		case '*': return oprdLeft * oprdRight;

		case '/': 
			if (oprdRight == 0) {
				System.out.println("\n  ??? ������ ���� ����: 0���� ������ �Ұ���");
				return Double.NaN;
			}
			return oprdLeft / oprdRight;

		case '%': 
			if (oprdRight == 0) {
				System.out.println("\n  ??? ������ ���� ����: 0�� ������ ���� �� ����");
				return Double.NaN;
			}
			return oprdLeft % oprdRight;

		default:
			System.out.println("\n  ??? ������ ����: '" + opr + "' - �߸��� ������");
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
			System.out.print("\n  o ���� �Է�(��: 3.5 * 4.5) > ");
			double oprd1 = SkScanner.getDouble();
			char opr = SkScanner.getCharNonWhite();
			double oprd2 = SkScanner.getDouble();

			Calculator c = new Calculator(oprd1, opr, oprd2);
			c.output();			
		}
	}
}

/*
 * [ ������� ]
 * 
 *   o �� ���α׷����� �����ڸ� ��Ÿ���� ���ڸ� �Է��ϱ� ���� SkScanner Ŭ������ getCharNonWhite() �޼ҵ带 
 *     �̿��Ѵ�. 
 *     
 *     getCharNonWhite() �޼ҵ�� ���� �߿��� white ����(���鹮�� ' ', �� ���� '\t', �ٹٲ� ���� '\n)�� 
 *     �����ϰ� white ���ڰ� �ƴ� ���ڸ� �о� ���̴� Ŭ���� �޼ҵ��̴�. 
 *     
 *     getCharNonWhite() �޼ҵ��� �ñ״�ó�� ������ ����.
 *     
 *        static char getCharNonWhite()
 * 
 */
