package ex11_quadratic_function;
/*
 * [ QuadraticFunction ]: �迭�� for �� �̿��Ͽ� ���� �Լ�(Quadratic Function)�� �Լ��� ���
 *    
 *     o ���α׷��� ��Ÿ��: 
 *       1) main() �޼ҵ�θ� Ŭ���� ����
 *       2) ���� �Լ� f(x) = a*x*x + b*x + c�� ��� a, b, c �Է��Ͽ�  ���� x�� ���� �Լ��� ����Ͽ� ���
 *       3) �迭�� for �� �̿��Ͽ�  ���� x ���� ���� �Լ� �� ����
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
class Ex5_1_QuadraticFunction_UsingMethod {

	public static void main(String[] args) {
		outputTitle();
		
		int x;       // ���� �������� x��
		int y;	     // ���� �������� �Լ����� y��
		int a, b, c; // ���� �������� ���

		// ���� �Լ��� ��� a, b, c�� �Է¹޾� ����
		System.out.print("  o ������ ��� a �Է� > ");
		a = SkScanner.getInt();

		System.out.print("  o ������ ��� b �Է� > ");
		b = SkScanner.getInt();

		System.out.print("  o ����� ��� c �Է� > ");
		c = SkScanner.getInt();
		
		 outputFuction(a, b, c);
		 
		
		// x�� -5, -3, -1, 0, 1, 3, 5, 7, 10�� �� �Լ��� ���Ͽ� ���
		int xs[] = { -5, -3, -1, 0, 1, 3, 5, 7, 10 };
	
        for (int i = 0; i < xs.length; i++) {
        	calculateOutputFuctionValue(a, b, c, xs[i]);
        }
		
		// x�� �Է��Ͽ� x�� ����  �Լ��� ���Ͽ� ���
		System.out.print("\n\n  ** x �� �Է��Ͽ�  x�� ���� �Լ��� ��� ** ");
		System.out.print("\n\n  o x �� �Է� > ");
		x = SkScanner.getInt();
		calculateOutputFuctionValue(a, b, c, x);       

		main(args);
 	}
	
	static void outputTitle() {
		System.out.println("\n\n  **********************************************");
		System.out.println("  *                                            *");
		System.out.println("  *    ���� �Լ� f(x) = ax^2 + bx + c �� �Լ��� ���        *");
		System.out.println("  *                                            *");
		System.out.println("  **********************************************\n");
	}
		
	// ��� a, b, c ������ ���� �Լ��� ���
	static void outputFuction(int a, int b, int c) {

		System.out.println("\n\n  ** �־��� ���� �Լ� f(x) = ax^2 + bx + c = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + "\n");
	}
	
	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���� ��ȯ
	static int calculateFuctionValue(int a, int b, int c, int x) {
		return  a*x*x + b*x + c;
	}

	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���
	static void outputFuctionvalue(int a, int b, int c, int x, int y) {
		// ���� ���� �Լ� �� y�� ���
 		System.out.println("\n  * x = " + x +"�� �� f(" + x + ") = " + (a==1 ? "" : a) + "x^2 + " + (b==1 ? "" : b) + "x + " + c + " = "+ (a==1 ? "" : a + "*") +  x + "^2 + " + (b==1 ? "" : b + "*") + x + " + " + c + " = " + y);
	}
	
	// ��� a, b, c�� ���� �־��� x�� ���� �Լ��� y�� ���Ͽ� ���
	static void calculateOutputFuctionValue(int a, int b, int c, int x) {
		int y = calculateFuctionValue(a, b, c, x);
		outputFuctionvalue(a, b, c, x, y);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���� �Լ��� ����� �Է¹޾� ���� �Լ��� �����ϰ� ���� x���� ���� �Լ����� ����Ѵ�.
 *      ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.     
 *      
 *   2) ���� x ���� ���� �Լ� ���� ���ϱ� ���� xs �迭������ ���� ���� �����ϰ�
 *      for ������ ���� �ϳ��� ���� �Լ����� ���Ͽ� ����ϹǷ� ���α׷��� �ξ� �����ϴ�.
 *     
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *
 * [ �ǽ����� ]
 * 
 *   1) �� ���α׷����� ���� �Լ��� ������ ���� x �� �Լ��� ���� y, ����� ���� ���� a, b, c�� ��� int ������ ����Ǿ� �ִ�.
 *      �� ��� ������ x�� �����̾�� �ϸ�, ����� 0.2, -12.4 ���� �Ǽ����� ����� �� ����.
 *      
 *      �� ���α׷���  ������ ���� x �� �Լ��� ���� y, ����� ���� ���� a, b, c�� double ������ �����Ͽ� 
 *      �Ǽ��� x, a, b, c�� ����  �����Լ� ���� ���� �� �ֵ��� ���α׷��� �����϶�.
 *      
 */