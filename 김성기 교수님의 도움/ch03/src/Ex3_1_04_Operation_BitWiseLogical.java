/**
 * [ Operation_BitWiseLogical ]: ��Ʈ�� �� ������ ����
 *   
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ���� ���� ��Ʈ�� �� ������ �����Ͽ� ��� �� ���
 *     
 *   o ��Ʈ�� �� ������ boolean ���� ���� &, |, ^, ~�� ����
 */

class Ex3_1_04_Operation_BitWiseLogical  {
	public static void main(String[] args)  {

		int bits1 = 0b1111_0000_1100_0011;
		int bits2 = 0b1100_0011_0101_1010;

		System.out.println("\n  ** ������ ���� ��Ʈ�� �� ����(&, |, ^, ~) **\n");
		
		System.out.printf("  * ���� �ʱⰪ: bits1 = 0x%x \n", bits1);
		System.out.printf("  * ���� �ʱⰪ: bits2 = 0x%x \n", bits2);
		System.out.println();
		
		System.out.printf("  * bits1 & bits2  := 0x%x \n", ( bits1 & bits2 )); 	
		System.out.printf("  * bits1 | bits2  := 0x%x \n", ( bits1 | bits2 )); 	
		System.out.printf("  * bits1 ^ bits2  := 0x%x \n", ( bits1 ^ bits2 )); 
		System.out.println();

		System.out.printf("  * ~ bits1 := 0x%x \n", ( ~ bits1 )); 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   
 * [ ������� ]
 *  
 *   o �� ���α׷������� System.out.printf() �޼ҵ带 ����Ͽ� ���� ����� 16������ ����Ѵ�. 
 *   
 *     - printf() �Լ��� C ���� ����ϴ� �Լ��̸�, Java������ ����� �� �ִ�. 
 *     
 *     - printf() �޼ҵ��  C ������ ���� ù��° ���ڿ� �� % ���� ���� ���ڿ� ���� ���� ��ġ�� �־����� ������ 
 *       ���� ���ڰ� �����ϴ� ������� ����Ѵ�. 
 *     
 *     - ���� ���α׷��� << System.out.printf("  * ���� �ʱⰪ: bits1 = 0x%x \n", bits1); >>���� 
 *       ù��° ���ڿ� �� % ���� ���� ���� x�� 16���� ������� ����ϰ� �ϹǷ� bits1�� 16������ ��µȴ�.
 *     
 *     - printf() �޼ҵ��� ������ println()�� ���� �ټ� �����ѵ�, ������ Java ���α׷����� 
 *       �����ϸ� ������ ���� �� �����Ƿ� �� �̻� ���������� �ʴ´�.
 */
