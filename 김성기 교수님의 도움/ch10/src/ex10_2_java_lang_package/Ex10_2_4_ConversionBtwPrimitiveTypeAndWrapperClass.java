package ex10_2_java_lang_package;

/**
 * [ ConversionBtwPrimitiveTypeAndWrapperClass Ŭ���� ]: 
 *       �⺻ Ÿ���� ���� Wrapper Ŭ���� ��ü�� ��ȯ�ϰ� Wrapper Ŭ���� ��ü�� �� ����ϱ�
 *        
 *   o Wrapper Ŭ����
 *     - �⺻ Ÿ���� ���� ���������� ���� ��ü�� �����Ͽ� �⺻ Ÿ���� ���� ������� ���ϰ� 
 *       �ݵ�� ��ü�� ����ؾ� �� ��쿡 ��ó�ϰ� ��
 *     - Wrapper Ŭ������ �Ҹ��� ������ �� Ŭ������ ��ü�� �⺻ Ÿ���� ���� �ѷ��α�(wrapping) ����
 *     - Wrapper Ŭ������ �� �⺻ Ÿ�Ը��� ����
 *     - int Ÿ�԰� char Ÿ���� Wrapper Ŭ������ Integer�� Character
 *     - �� ���� Wrapper Ŭ���� �̸��� �⺻ Ÿ���� ù ���ڸ� �빮�ڷ� ������ �̸��� ���
 *    
 *   o Wrapper Ŭ������ ������
 *     - �⺻ Ÿ���� ���� �־����� �̸� Wrapper Ŭ������ ��ü�� ����
 *    
 *   o �⺻ Ÿ�԰� Wrapper Ŭ�������� ��ȯ �޼ҵ�
 *     - ��� Wrapper Ŭ������ �⺻ Ÿ���� ���� �־����� Wrapper Ŭ���� ��ü�� ��ȯ�ϴ� 
 *       Ŭ���� �޼ҵ� valueOf() �޼ҵ� ����
 *     - Wrapper ��ü�� ����� ���� �⺻ Ÿ������ ��ȯ�ϴ� ��ü �޼ҵ嵵 ���� 
 *    
 *   o Wrapper Ŭ������ ��ü�� System.out.println()���� ���
 *     - Wrapper Ŭ���� ��ü�� ����� �⺻ Ÿ���� ���� ���
 *     - Wrapper Ŭ������ toString() �޼ҵ带 ����� �⺻ Ÿ���� ���� ��ȯ�ϵ��� 
 *       Object Ŭ������ toString() �޼ҵ带 �������̵��߱� ����
 */
  
class Ex10_2_4_ConversionBtwPrimitiveTypeAndWrapperClass {  
	public static void main(String[] args) {

		Integer I = new Integer(23);
		int i = I.intValue();
		System.out.println("  * I = " + I + ", i = " + i);

		Double D = new Double(177.7);
		double d = D.doubleValue();
		System.out.println("  * D = " + D + ", d = " + d);

		Character C = Character.valueOf('H');
		char c = C.charValue();
		System.out.println("  * C = " + C + ", c = " + c);

		Boolean B = Boolean.valueOf(true);
		boolean b = B.booleanValue();
		System.out.println("  * B = " + B + ", b= " + b);

		Object obj = Integer.valueOf(23);  // Integer ��ü�� Object ���������� ����
		i = ((Integer) obj).intValue();    // obj�� �ٿ�ĳ�����Ͽ� ���� ������ i�� ����
		System.out.println("  * obj = " + obj + ", i = " + i); 
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� Wrapper Ŭ���� ��ü�� �����ϸ鼭 ���� ������ ��  
 *      ��ü�� ��ü�� ����� �⺻ Ÿ���� ���� ���ϴ� ����Ѵ�.
 *  
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�. �̶� Wrapper ��ü�� ����ϸ�  
 *      Wrapper ��ü�� ����� �⺻ Ÿ���� ���� ��µ��� �ݵ�� Ȯ���϶�.
 *   
 *      �̴� Wrapper Ŭ������ �⺻ Ÿ���� ���� ����ϵ��� toString() �޼ҵ带 
 *      �������̵��߱� �����̴�.  
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 */
