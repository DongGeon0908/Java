package ex9_3_java_exception_handling_propagation;

/**
 * [ ExceptionParseInt_DirectHandling Ŭ����] :
 *       ���ܹ߻� �޼ҵ带 ȣ���� �޼ҵ忡�� try-catch ������� ���ܸ� ���� ó���ϴ� ����
 * 
 *   o ���ܹ߻� �޼ҵ带 ȣ���� �޼ҵ忡�� ���� ���� ó���ϱ�
 *     - ���ܹ߻� �޼ҵ带 ȣ���� �޼ҵ忡�� try-catch ������� ���� ó��
 *   
 *   o java.lang.Integer Ŭ������ Ŭ���� �޼ҵ� static int parseInt(String s) 
 *     - �־��� ���ڿ��� �������� ���� ���ڿ��̸� int�� ��ȯ�� ���� ��ȯ
 *     - �־��� ���ڿ��� �������� ���� ���ڿ��� �ƴϸ� 
 *       NumberFormatException ���ܰ�ü �����Ͽ� ����
 *    
 *     - �� �޼ҵ� ȣ�� �� ���� ó�� �Ǵ� ���� ������ �� ����
 */

class Ex9_3_1_ExceptionParseInt_DirectHandling {
	
	// ���ڿ� �Է��Ͽ� ������ ��ȯ�Ͽ� ������ ��ȯ�ϴ� �޼ҵ�
	// ���ܹ߻� �޼ҵ� ȣ���ϸ鼭 ���� ó��   
	static int inputStringConvertToInt() {
		String s = SkScanner.getString("\n  o ���� ���ڿ� �Է� > ");

		// ���ܹ߻� �޼ҵ带 ȣ���ϸ鼭 ���� ���� Ž�� �� ó��
		try {
			int n = Integer.parseInt(s);   // ���ܹ߻� �޼ҵ� ȣ��
			return n;
		}
		catch(NumberFormatException e) {   // ���ܰ�ü ��� ó����
			System.out.print("\n  ??? parseInt()���� ���� �߻� - " + e.getMessage());

			return -1; // �߸��� �Է¿� ���� -1�� ��ȯ
		}      
	}

	public static void main(String[] args) {
		while(true) {
			int n = inputStringConvertToInt();
			System.out.println("\n\n  * �Էµ� ���ڿ��� ��ȯ�� ���� = " + n);

			if (n == -1)
				break;
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���ܹ߻� �޼ҵ��� Integer.parseInt(s)�� inputStringConvertToInt() 
 *      �޼ҵ忡�� ȣ���Ѵ�.
 *
 *   2) inputStringConvertToInt() �޼ҵ忡�� try-catch ������� ���� ó���� �Ѵ�.
 * 
 *   3) 123, 1234, 123A, 1234A, -1 �� ���� ���ڿ��� �Է��Ͽ� �� ����� Ȯ���϶�.
 */
