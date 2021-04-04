package ex9_3_java_exception_handling_propagation;

/**
 * [ ExceptionParseInt_Propagating Ŭ����] :
 *       ���ܹ߻� �޼ҵ带 ȣ���� �޼ҵ忡�� ���� ó�� �ʰ� ���ܸ� ���� �����ϴ� ����
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

class Ex9_3_2_ExceptionParseInt_Propagating {
	
	// ���ڿ� �Է��Ͽ� ������ ��ȯ�Ͽ� ������ ��ȯ�ϴ� �޼ҵ�
	//   ���ܹ߻� �޼ҵ� ȣ�������� ���� ó������ �ʰ� �ڽ��� ȣ���� �޼ҵ�� ���� ����
	static int inputStringConvertToInt() throws NumberFormatException {
		String s = SkScanner.getString("\n\n  o ���� ���ڿ� �Է� > ");

		// ���ܹ߻� �޼ҵ� ȣ���ϸ鼭 ���� ���� Ž�� �� ó������ ����
		int n = Integer.parseInt(s);   // ���ܹ߻� �޼ҵ� ȣ��
		return n;      
	}

	public static void main(String[] args) {
		while(true) {
			int n = 0;

			// ���ܹ߻� �޼ҵ��� inputStringConvertToInt() ȣ���ϸ鼭 ���� ó��
			try { 
				n = inputStringConvertToInt();
				System.out.println("\n  * �Էµ� ���ڿ��� ��ȯ�� ���� = " + n);
			}
			catch(NumberFormatException e) {   // ���ܰ�ü ��� ó����
				System.out.println("\n  ??? inputStringConvertToInt()���� ���� �߻�: " + e.getMessage());
			}

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
 *   2) inputStringConvertToInt() �޼ҵ忡���� ���� ó���� ���� �ʰ� ���ܸ� ���Ľ�Ų��.
 *   
 *       static int inputStringConvertToInt() throws NumberFormatException { .... }
 *       
 * 
 *   3) inputStringConvertToInt() �޼ҵ带 ȣ���ϴ� main()���� ���� Ž�� �� ó���� �����Ѵ�.
 *   
 *   4) 123, 1234, 123A, 1234A, -1 �� ���� ���ڿ��� �Է��Ͽ� �� ����� Ȯ���϶�.
 */
