/**
 * [ inputPrintCount1bits_UsingSubstitutingMethod ]: 
 *        ��ü �޼ҵ� ����Ͽ� �Է��� ������ 1�� ��Ʈ ���� ���Ͽ� ���
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     - ��ü �߻�ȭ ������ ���� ��ü �޼ҵ� �ۼ�
 *     - �ۼ��� ��ü �޼ҵ���� main()���� ȣ���Ͽ� 1�� ��Ʈ ���� ���
 *       
 *   o �ۼ��� ��ü �޼ҵ�
 *     - ���� �Է��Ͽ� 1�� ��Ʈ ���� ����ϴ� �޼ҵ� inputPrintCount1Bits()
 */

class Ex5_2_4_inputPrintCount1bits_UsingSubstitutingMethod  {

	public static void main(String[] args) {
		inputPrintCount1Bits();  // ��ü �޼ҵ� ȣ��
	}
	
	// ���� �Է��Ͽ� 1�� ��Ʈ ���� ����ϴ� ��ü �޼ҵ�
	static void inputPrintCount1Bits() {
		int cnt = 0;
		int n0, n;
		n0 = n = SkScanner.getIntWithPrompt("\n  o 1�� ��Ʈ ���� ���� ���� ���� �Է��Ͻÿ� > ");

		while (n != 0) {
			if (n % 2 == 1)  cnt++;
			n = n / 2;
		}

		System.out.println("\n  * " + n0 +"�� 1�� ��Ʈ�� ���� = " + cnt);
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� �Էµ� ������ 1�� ��Ʈ ���� ���Ͽ� ����Ѵ�.
 *   
 *   2) ��ü �޼ҵ带 �ۼ��ϰ� �ۼ��� ��ü �޼ҵ���� main()���� ȣ���Ѵ�.
 *   
 *   3) ���α׷��� �� ���캸�� �����Ͽ� ����� Ȯ���϶�.  
 */
