/**
 * [ Operation_Comparative ]: �� ������ ����
 *   
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �� ������ �����Ͽ� ��� �� ���
 *       
 *   o �� ������ ������ �Ǽ��� ���� >, <, >=, <=, ==, != ���� ����
 */

class Ex3_1_02_Operation_Comparative  {
	public static void main(String[] args)  {
		
		System.out.println("\n  ** �� ����(>, <, >=, <=, ==, != ) **\n");
		
		System.out.println("  * 1.5 > 6.6    := " + ( 1.5 > 6.6 ));  	//  ��  false: 1.5�� 6.6���� �����Ƿ� false
		System.out.println("  * 3.3F < 3.2F  := " + ( 3.3F < 3.2F	)); //  ��  false  : 3.3F�� 3.2F���� ũ�Ƿ� false
		System.out.println();
		
		System.out.println("  * 3L >= 2L     := " + ( 3L >= 2L ));  	//  ��  true  : 3L�� 2L���� ũ�Ƿ� true
		System.out.println("  * 19 <= 5      := " + ( 19 <= 5	)); 	//  ��  false: 19�� 5���� ũ�Ƿ� false	
		System.out.println();
		
		System.out.println("  * 19.0 == 5.0  := " + ( 19.0 == 5.0 )); 	//  ��  false: 19.0�� 5.0�� ���� �����Ƿ� false	
		System.out.println("  * 19 != 5      := " + ( 19 != 5	));  	//  ��  true  : 19�� 5�� ���� �����Ƿ� true
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����. 
 *   
 */
