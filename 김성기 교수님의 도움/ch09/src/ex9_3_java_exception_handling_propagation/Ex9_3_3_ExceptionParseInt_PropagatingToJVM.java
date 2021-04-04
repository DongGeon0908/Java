package ex9_3_java_exception_handling_propagation;

/**
 * [ ExceptionPardeInt_PropagatingToJVM Ŭ����] :
 *       ���ܹ߻� �޼ҵ带 ȣ���� �޼ҵ忡�� ���� ó�� �ʰ� ���ܸ� JVM���� �����ϴ� ����
 *       
 *   o ���� ����
 *     - �ڽ��� ȣ���ϴ� �޼ҵ�� ���ܸ� ���Ľ�Ű�� ��
 *     - ���� ����
 *     - �޼ҵ� �ñ״�ó�� throws Ű����� ������ ���� ������ ��Ÿ���� ���ܰ�ü Ŭ������ ����ϸ� ��
 *   
 *     - ���� ���� �޼ҵ带 ȣ���� �޼ҵ忡�� ���� ó�� �Ǵ� �����ؾ� ��
 *   
 *   o java.lang.Integer Ŭ������ Ŭ���� �޼ҵ� static int parseInt(String s) 
 *     - �־��� ���ڿ��� �������� ���� ���ڿ��̸� int�� ��ȯ�� ���� ��ȯ
 *     - �־��� ���ڿ��� �������� ���� ���ڿ��� �ƴϸ� 
 *       NumberFormatException ���ܰ�ü �����Ͽ� ����
 *    
 *     - �� �޼ҵ� ȣ�� �� ���� ó�� �Ǵ� ���� ������ �� ����
 */

class Ex9_3_3_ExceptionParseInt_PropagatingToJVM {
	
	// ���ڿ� �Է��Ͽ� ������ ��ȯ�Ͽ� ������ ��ȯ�ϴ� �޼ҵ�
	//   ���ܹ߻� �޼ҵ� ȣ�������� ���� ó������ �ʰ� �ڽ��� ȣ���� �޼ҵ�� ����
	static int inputStringConvertToInt() throws NumberFormatException {
		String s = SkScanner.getString("\n\n  o ���� ���ڿ� �Է� > ");

		// ���ܹ߻� �޼ҵ� ȣ���ϸ鼭 ���� ���� Ž�� �� ó������ ����
		int n = Integer.parseInt(s);   // ���ܹ߻� �޼ҵ� ȣ��
		return n;      
	}

	// main() �޼ҵ嵵 ���� ������ �� ����
	//   ���ܹ߻� �޼ҵ� ȣ�������� ���� ó������ �ʰ� JVM���� ���� ����
	public static void main(String[] args) throws NumberFormatException {
		while(true) {
			/// ���ܹ߻� �޼ҵ� ȣ���ϸ鼭 ���� ���� Ž�� �� ó������ ����
			int n = inputStringConvertToInt(); // ���ܹ߻� �޼ҵ� ȣ��
			
			System.out.println("\n  * �Էµ� ���ڿ��� ��ȯ�� ���� = " + n);

			if (n == -1)
				break;
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���ܹ߻� �޼ҵ��� Integer.parseInt(s)�� inputStringConvertToInt() �޼ҵ忡�� ȣ���Ѵ�.
 *
 *   2) inputStringConvertToInt() �޼ҵ忡���� ���� ó���� ���� �ʰ� ���ܸ� ȣ���� �޼ҵ�� ���Ľ�Ų��.
 *   
 *         static int inputStringConvertToInt() throws NumberFormatException { .... }
 *         
 * 
 *   3) ����  inputStringConvertToInt() �޼ҵ带  ȣ���� main()������ ���� ó���� ���� �ʰ� ���ܸ� ȣ���� �޼ҵ�� ���Ľ�Ų��.
 *   
 *         public static void main(String[] args) throws NumberFormatException { ... }
 *         
 *   
 *   4) �׷���, main() �޼ҵ带 ȣ���� �޼ҵ�� Java �������̹Ƿ� ���� �߻��ϸ� ���α׷� ������ ����ȴ�.
 *     
 *   5) 123, 1234, 123A, 1234A, -1 �� ���� ���ڿ��� �Է��Ͽ� �� ����� Ȯ���϶�. 
 */
