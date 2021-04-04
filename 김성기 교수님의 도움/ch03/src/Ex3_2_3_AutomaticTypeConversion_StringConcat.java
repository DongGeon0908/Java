/**
 * [ AutomaticTypeConversion_StringConcat ]: ���ڿ� ���� ���꿡���� �ڵ��� Ÿ�� ��ȯ
 *        
 *     o ���α׷��� ��Ÿ�� 
 *       1) main() �޼ҵ�θ� Ŭ���� ����
 *       2) �ڵ��� Ÿ�Ժ�ȯ�� �߻��ϴ� ������ ��� �� ���
 *       
 *     o �ڵ��� Ÿ�� ��ȯ�� �߻��ϴ� ���
 *       - ��� ����� �� ���꿡�� �ǿ����� Ÿ���� �ٸ� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *       - ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ ����� ���: ���� Ÿ���� ���� ���� Ÿ���� ������ ��ȯ
 *       - ���ڿ� ���� ���꿡�� ���ڿ��� ���ڿ��� �ƴ� ���� ���ӽ�ų ���: ���ڿ��� �ƴ� ���� ���ڿ��� ��ȯ
 *     
 *     o Java������ ���� Ÿ�԰� ���� Ÿ�� ���� 
 *        byte �� char/short �� int  ��  long  ��  float  ��  double  
 */

class Ex3_2_3_AutomaticTypeConversion_StringConcat  {
	public static void main(String[] args)  {

		System.out.println("\n  ** �ڵ��� Ÿ�� ��ȯ�� �����ϴ� ���ڿ� ���� ���� **\n");
		/*
		 * ���ڿ� ���� ���꿡���� �ڵ��� Ÿ�� ��ȯ
		 */
		String name = "ȫ�浿"; 
		int age = 18;
		boolean isKorean = true;
		double height = 177.7;
		
		System.out.println("  * ���� �ʱⰪ: name = " + name  + ", age = " + age + ", height = " + height + ", isKorean = " + isKorean +"\n");

		System.out.println("  * \"���̴� \" + age       := " + ( "���̴� " + age ));     // ���ڿ��� ���� ����: ������ ���ڿ��� ��ȯ�� �� ����
		System.out.println("  * height + \"�� Ű\"     := " + ( height + "�� Ű" ));    // �Ǽ��� ���ڿ� ����: �Ǽ��� ���ڿ��� ��ȯ�� �� ���� 	
		System.out.println("  * age + height        := " + ( age + height ));  	      // ������ �Ǽ��� + �ϸ� ���ڿ� ������ �ƴ� ��� ����
		System.out.println("  * \" \" + age + height  := " + ( " " + age + height )); // ���ڿ��� ���� �����ϰ� ������ �Ǽ��� ���ʷ�  + �ϸ� ���ڿ� ������ ���������� ����	
		System.out.println("  * \"�ѱ��� ���δ� \" + isKorean  := " + ( "�ѱ��� ���δ� " + isKorean ));  // ���ڿ��� boolean �� ����: boolean ���� ���ڿ��� ��ȯ�� �� ����
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
