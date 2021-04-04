/**
 * [ TypeConversion_ErrorCorrection ]: ���� ���꿡�� �߻��� ���� Ȯ���ϰ� �����ϱ�
 *        
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ���꿡�� �߻��ϴ� ���� Ȯ�� �� ����
 *       
 *   o ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ �����ϸ� ���� �߻���
 *     - int avg = 89.4;(�Ǽ� ���� ���� ������ �����ϸ� ����)
 *     - �̴� ���� �ս��� �߻��� �� �ֱ� ����
 *     - ���� Ÿ�� ��ȯ�� ���� ���� Ÿ���� ������ ��ȯ�� �� �����ؾ� ��
 *          int avg = (int) 89.4;
 *            
 *   o ���� ���꿡�� �߻��� ������ �����ϱ� ���� ���
 *     (1) ������ ���� Ÿ�Կ� ������ ���� Ÿ������ �����ϱ�
 *     (2) ������ ���� ���� Ÿ�Կ� ������ ������ ��ȯ�ϱ�
 *          
 *    o ���� Ÿ�԰� ���� Ÿ�� ���� 
 *         byte ��  char/short �� int ��  long ��  float ��  double       
 */

class Ex3_2_5_TypeConversion_ErrorCorrection  {
	public static void main(String[] args)  {

		double avg;      // ���� avg�� double Ÿ������ ������ �Ǽ� �����ϰ� ��
		int n = 10;
		int s;           // ���� s�� int Ÿ������ ������ 4 ����Ʈ ���� ���� �����ϰ� ��
		long distance;
												
		System.out.println("\n  ** ���� ���꿡�� �߻���  ���� ���� �� Ȯ�� **\n");
				
		System.out.println("  * ���� ����: double avg;  n = 10; int s;  long distance;	\n");					
		System.out.println("  * ���Խ� ����  ����: avg = 89.4  := " + ( avg = 89.4 ));   // double ������ double �� ���尡��
		System.out.println("  * ���Խ� ����  ����: avg = 89.0  := " + ( avg = 89.0 ));   // double ������ double �� ���尡��
		
		System.out.println("\n  * ���Խ� ����  ����: s = 0x1234_5678  := " + ( s = 0x1234_5678 )); // int ������ int �� ���尡��
		System.out.println(  "  * ���Խ� ����  ����: s = n := " + ( s = n ));                      // int ������ int �� ���尡��
		System.out.println(  "  * ���Խ� ���� �ƴ�: s = 10 := " + ( s = 10 ));                     // short ���� ���� int ���� short ������ �����ϸ� ���� �ƴ�
		
     	System.out.println("\n  * ���Խ� ����  ����: distance = 9460000000000L  := " + ( distance = 9460000000000L )); // double �� 9.46E12�� long ������ ǥ��
		System.out.println(  "  * ���Խ� ����  ����: distance = (long) 9.46E12  := " + ( distance = (long) 9.46E12)); // double ���� long ������ ������ ��ȯ��Ŵ      
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ���� 3-2-4�� ������ �����ϱ� ���� ������ ��ġ�� ���캸�� ����� Ȯ���϶�.  
*/
