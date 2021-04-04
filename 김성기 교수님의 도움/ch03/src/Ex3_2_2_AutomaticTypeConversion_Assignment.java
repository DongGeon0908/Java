/**
 * [ AutomaticTypeConversion_Assignment ]: ���� ���꿡���� �ڵ��� Ÿ�Ժ�ȯ
 *        
 *     o ���α׷��� ��Ÿ�� 
 *       1) main() �޼ҵ�θ� Ŭ���� ����
 *       2) �ڵ��� Ÿ�Ժ�ȯ�� �߻��ϴ� ���� ������ ��� �� ���
 *       
 *     o �ڵ��� Ÿ�� ��ȯ�� �߻��ϴ� ���
 *       - ��� ����� �� ���꿡�� �ǿ����� Ÿ���� �ٸ� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *       - ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ ����� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *       - ���ڿ� ���� ���꿡�� ���ڿ��� ���ڿ��� �ƴ� ���� ���ӽ�ų ���: ���ڿ��� �ƴ� ���� ���ڿ��� ��ȯ
 *     
 *     o Java������ ���� Ÿ�԰� ���� Ÿ�� ���� 
 *        byte ��  char/short ��  int ��  long ��  float ��  double       
 */

class Ex3_2_2_AutomaticTypeConversion_Assignment  {
	public static void main(String[] args)  {

		System.out.println("\n  ** �ڵ��� Ÿ�� ��ȯ�� �����ϴ� ���� **\n");
		
		/*
		 * ���� ���꿡���� �ڵ��� Ÿ�� ��ȯ
		 */
		double height;
		long distanceToSun;	
		
		System.out.println("  * ���� ����: double height;  long distanceToSun;	\n");		
		
		System.out.println("  * height = 177 	       := " + ( height = 177 ));                  // int 177�� double�� ��ȯ 
		System.out.println("  * distanceToSun = 149600000  := " + ( distanceToSun = 149600000 )); // int 149600000�� long���� ��ȯ       
		System.out.println();		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   o �ڵ��� Ÿ�Ժ�ȯ�� �߻��Ǵ� ���� �����϶�.
 *   
 */

