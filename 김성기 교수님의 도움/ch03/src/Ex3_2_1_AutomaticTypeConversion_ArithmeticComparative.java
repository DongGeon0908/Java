/**
 * [ AutomaticTypeConversion_ArithmeticComparative ]: ��Ģ ����� �� ���꿡���� �ڵ��� Ÿ�� ��ȯ
 *        
 *     o ���α׷��� ��Ÿ�� 
 *       1) main() �޼ҵ�θ� Ŭ���� ����
 *       2) �ڵ��� Ÿ�Ժ�ȯ�� �߻��ϴ� ��Ģ ����� �� ������ ��� �� ���
 *       
 *     o �ڵ��� Ÿ�Ժ�ȯ �߻��ϴ� ���
 *       - ��� ����� �� ���꿡�� �ǿ����� Ÿ�� �ٸ� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ �ڵ� ��ȯ
 *          (��, byte, char, short Ÿ���� ��� �׻� int Ÿ�� ������ ��ȯ�Ǿ� int ��� ����)
 *       - ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ ����� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ �ڵ� ��ȯ
 *       - ���ڿ� ���� ���꿡�� ���ڿ��� ���ڿ��� �ƴ� ���� ���ӽ�ų ���: ���ڿ��� �ƴ� ���� ���ڿ��� �ڵ� ��ȯ
 *     
 *     o Java������ ���� Ÿ�԰� ���� Ÿ�� ���� 
 *        byte ��  char/short ��  int ��  long ��  float ��  double      
 */

class Ex3_2_1_AutomaticTypeConversion_ArithmeticComparative  {
	public static void main(String[] args)  {

		System.out.println("\n  ** �ڵ��� Ÿ�� ��ȯ�� �����ϴ� ��Ģ ����� �� ���� **\n");
		
		/*
		 * ��Ģ ����� �� ���꿡���� �ڵ��� Ÿ�� ��ȯ
		 */		
		byte b = 6; 
		short s = -8; 
		float f = 2.5F;
												
		System.out.println("  * ���� �ʱⰪ: b = " + b + ", s = " + s + ", f = " + f); 
		System.out.println();
	
		System.out.println("  * 177.7 + 8 := " + ( 177.7 + 8 )); // int Ÿ���� 8�� double 8.0���� ��ȯ
		System.out.println("  * f - 3     := " + ( f - 3 ));     // int Ÿ���� 3�� float 3.0F�� ��ȯ
		System.out.println("  * b * 2L    := " + ( b * 2L ));    // b�� byte 6�� long 6L�� ��ȯ
		System.out.println("  * s % b     := " + ( s % b ));     // s�� short -8�� b�� byte 6�� ��� int -8�� 6���� ��ȯ, ��� Ÿ�� int
		System.out.println();
		
		System.out.println("  * f == 2.5  := " + ( f == 2.5 )); // f�� float 2.5F�� double 2.5�� ��ȯ
		System.out.println("  * f >= 2    := " + ( f >= 2 ));   // int 2�� float 2.0F�� ��ȯ
		System.out.println("  * s <= -10  := " + ( s < -10 ));  // s�� short -8�� int -8�� ��ȯ
		System.out.println("  * s != b    := " + ( s != b ));   // s�� short -8�� b�� byte 6�� ��� int -8�� 6���� ��ȯ
		System.out.println();		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ��� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   o �ڵ��� Ÿ�Ժ�ȯ�� �߻��Ǵ� ���� �����϶�.
 *  
 */

