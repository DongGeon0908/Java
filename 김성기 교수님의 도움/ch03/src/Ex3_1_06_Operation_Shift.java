/**
 * [ Operation_Shift ]: ����Ʈ ������ ���� 
 * 
 *   o ����Ʈ ������ ���� ���� ���� >>, <<, >>>�� ����
 *     
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ���� ���� ����Ʈ ������ �����Ͽ� ��� �� ��� 
 */

class Ex3_1_06_Operation_Shift  {
	public static void main(String[] args)  {
						
		int bits1 = 0b1111_0000_1100_0011;  // 0xF0C3 
		int bits2 = 0xFFFF_FFFF;   // 32��Ʈ ��ΰ� 1�� ������ -1��

		System.out.println("\n  ** ����Ʈ ����(<<, >>, >>>) **\n");

		System.out.printf("  * ���� �ʱⰪ: bits1 = 0x%x = %d \n", bits1, bits1);
		System.out.printf("  * ���� �ʱⰪ: bits2 = 0x%x = %d\n", bits2, bits2);
		System.out.println();
		
		System.out.printf("  * bits1 << 1  := 0x%x = %d \n",
				( bits1 << 1 ), ( bits1 << 1 )); // 1��Ʈ �������� �̵� �� ������ 1��Ʈ 0���� ä��
		System.out.printf("  * bits1 << 4  := 0x%x = %d \n", 
				( bits1 << 4 ), ( bits1 << 4 )); // 4��Ʈ �������� �̵� �� ������ 4��Ʈ 0���� ä��	
		System.out.printf("  * bits1 << 8  := 0x%x = %d \n", 
				( bits1 << 8 ), ( bits1 << 8 )); // 8��Ʈ �������� �̵� �� ������ 8��Ʈ 0���� ä��	
		System.out.printf("  * bits2 << 8  := 0x%x = %d \n", 
				( bits2 << 8 ), ( bits2 << 8 )); // 8��Ʈ �������� �̵� �� ������ 8��Ʈ 0���� ä��		
		System.out.printf("  * bits2 << 16 := 0x%x = %d \n", 
				( bits2 << 16 ), ( bits2 << 16 )); // 16��Ʈ �������� �̵� �� ������ 16��Ʈ 0���� ä��		
		System.out.println();
		
		System.out.printf("  * bits1 >> 4  := 0x%x = %d \n",
				( bits1 >> 4 ), ( bits1 >> 4 )); // 4��Ʈ ���������� �̵� �� ���� 4��Ʈ ��ȣ��Ʈ 0���� ä��	
		System.out.printf("  * bits1 >> 8  := 0x%x = %d \n",
				( bits1 >> 8 ), ( bits1 >> 8 )); // 8��Ʈ ���������� �̵� �� ���� 8��Ʈ ��ȣ��Ʈ 0���� ä��	

		System.out.println();
		System.out.printf("  * bits2 >> 8  := 0x%x  = %d\n", 
				( bits2 >> 8 ),  ( bits2 >> 8 )); // 8��Ʈ ���������� �̵� �� ���� 8��Ʈ ��ȣ��Ʈ 0���� ä��		
		System.out.printf("  * bits2 >>> 8 := 0x%x = %d\n", 
				( bits2 >>> 8 ), ( bits2 >>> 8 ));// 8��Ʈ ���������� �̵� �� ���� 8��Ʈ ������ 0���� ä�� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */
