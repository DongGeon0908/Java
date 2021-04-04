package ex11_quadratic_function;
/*
 * [ QuadraticFunction ]: �迭�� for �� �̿��Ͽ� ���� �Լ�(Quadratic Function)�� �Լ��� ���
 *    
 *     o ���α׷��� ��Ÿ��: 
 *       1) main() �޼ҵ�θ� Ŭ���� ����
 *       2) ���� �Լ� f(x) = a*x*x + b*x + c�� ��� a, b, c �Է��Ͽ�  ���� x�� ���� �Լ��� ����Ͽ� ���
 *       3) ���, x, y�� �����ϴ� �ʵ�� �ʿ��� �޼ҵ带 ������ QuadraticFunction Ŭ������ ����
 *         
 *     o ���� �Լ��� �Լ��� ��� 
 *       - ���� �Լ�: f(x) = ax^2 + bx + c (a != 0) ���·� ǥ���Ǵ� �Լ�
 *       - �Լ��� ���: �־��� x �� x'�� ���� 
 *            f(x') =  ax'^2 '+ bx' + c �� ����� ����� ���ϴ� ��
 *            
 *         ��) f(x) = ax^2 + bx + c�� ���� �Լ��� ����
 *            f(1) = 2*1^2+ 2*1 + 1 = 2 + 2 + 1 = 5�̹Ƿ�
 *            x=1�� ���� �Լ����� 5��
 */

class QuadraticFunction {
	
	int x;       // ���� �������� x��
	int y;	     // ���� �������� �Լ����� y��
	int a, b, c; // ���� �������� ���
	
	QuadraticFunction() {		
	}
	
	QuadraticFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// ���� �Լ��� ��� a, b, c�� �Է¹޾� ����
	void inputCoefficients() {
		System.out.print("  o ������ ��� a �Է� > ");
		a = SkScanner.getInt();

		System.out.print("  o ������ ��� b �Է� > ");
		b = SkScanner.getInt();

		System.out.print("  o ����� ��� c �Է� > ");
		c = SkScanner.getInt();	
	}
	
	// ���  a, b, c ������ ���� �Լ��� ���
	void outputFuction() {
		System.out.println("\n\n  ** �־��� ���� �Լ� f(x) = ax^2 + bx + c = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + "\n");
	}
	
	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���� x, y�� �ʵ忡 �����ϰ� y�� ��ȯ
	int calculateFuctionValue(int x) {
		this.x = x;
		y = a*x*x + b*x + c;
		
		return y;
	}

	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���
	void outputFuctionvalue() {
		// ���� ���� �Լ� �� y�� ���
 		System.out.println("\n  * x = " + x +"�� �� f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " 
		                                + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);
	}
	
	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���Ͽ� ���
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
		 
		
		// x�� -5, -3, -1, 0, 1, 3, 5, 7, 10�� �� �Լ��� ���Ͽ� ���
		int xs[] = { -5, -3, -1, 0, 1, 3, 5, 7, 10 };
	
        for (int i = 0; i < xs.length; i++) {
        	f.calculateOutputFuctionValue(xs[i]);
        }
		
		// x�� �Է��Ͽ� x�� ����  �Լ��� ���Ͽ� ���
		System.out.print("\n\n  ** x �� �Է��Ͽ�  x�� ���� �Լ��� ��� ** ");
		
		System.out.print("\n\n  o x �� �Է� > ");
		int x = SkScanner.getInt();
		
		f.calculateOutputFuctionValue(x);       

		main(args);
 	}
	
	static void outputTitle() {
		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    ���� �Լ� f(x) = ax^2 + bx + c �� �Լ��� ���         *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���� �Լ��� ����� �Է¹޾� ���� �Լ��� �����ϰ� ���� x���� ���� �Լ����� ����ϱ� ����
 *      Ŭ������ �����Ͽ���.
 *      
 *      ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.     
 *      
 *   2) �Լ� a, b, c�� x,y ���� �����ϱ� ���� �ʵ�, ���� �޼ҵ尡 ����� ���� �� ���캸�� 
 *      �޼ҵ带 ����� ���� ���α׷��� ���Ͽ� ����..
 *     
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *
 * [ �ǽ����� ]
 * 
 *   1) �� ���α׷��� 3���� ���  a, b, c�� ������ 2�� �Լ� ���� �Լ��� ���� ó���� �Ѵ�.
 *   
 *      4���� ���  a, b, c, d�� ������ 3�� �Լ� f(x) = ax^3 + bx^2 + cx + d�� ����  ó���� �ϴ� ���α׷����� �����϶�.
 *      
 */