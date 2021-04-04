/**
 * [ TypeConversion_ErrorAssignment ]: ���� ���꿡���� ���� Ȯ���ϱ�
 *        
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� ���꿡�� �߻��ϴ� ���� Ȯ�� �� ����
 *       
 *   o ���� ���꿡�� ���� Ÿ���� ���� ���� Ÿ���� ������ �����ϸ� ���� �߻�
 *     - int avg = 89.4;  (�Ǽ� ���� ���� ������ �����ϸ� ����)
 *     - �̴� ���� �ս��� �߻��� �� �ֱ� ����
 *     - ���� Ÿ�� ��ȯ�� ���� ���� Ÿ���� ������ ��ȯ�� �� �����ؾ� ��
 *           int avg = ( int ) 89.4;
 *             
 *   o ���� ���꿡�� �߻��� ������ �����ϱ� ���� ���
 *     (1) ������ ���� Ÿ�Կ� ������ ���� Ÿ������ �����ϱ�
 *     (2) ������ ���� ���� Ÿ�Կ� ������ ������ ��ȯ�ϱ�            
 *          
 *   o ���� Ÿ�԰� ���� Ÿ�� ���� 
 *        byte �� char/short �� int  ��   long ��  float ��  double       
 */

class Ex3_2_4_TypeConversion_ErrorAssignment  {
	public static void main(String[] args)  {

		int avg;
		int n = 10;
		short s;
		long distance;
												
		System.out.println("\n  ** ���� ���꿡���� ���� Ȯ�� **\n");
				
		System.out.println("  * ���� ����: int avg;  short s;  int n = 10; long distance; \n");	
		
		System.out.println("  * ���Խ� ����: avg = 89.4	  := " + ( avg = 89.4 ));      // double ���� int ������ �����ϸ� ���� 
		System.out.println("  * ���Խ� ����: avg = 89.0	  := " + ( avg = 89.0 ));      // double ���� int ������ �����ϸ� ����
		
		System.out.println("  * ���Խ� ����: s = 0x1234_5678  := " + ( s = 0x1234_5678 ));  // int ���� short ������ �����ϸ� ����        
		System.out.println("  * ���Խ� ����: s = n   := " + ( s = n ));                     // int ���� ���� short ������ �����ϸ� ����    
		System.out.println("  * ���Խ� ���� �ƴ�: s = 10   := " + ( s = 10 ));               // short ���� ���� int ��� ���� short ������ �����ϸ� ���� �ƴ�
		
		System.out.println("  * ���Խ� ����: distance = 9.46E12 := " + ( distance = 9.46E12 )); // double ���� long ������ �����ϸ� ����      
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) ������ �ִ� ������ ���ʿ� �Ӱ� ǥ�õ� ���� ǥ�ø� Ŭ���Ͽ� ���� �޽����� Ȯ���϶�.
 *     - Type mismatch: can not convert from double to int
 *     - Type mismatch: can not convert from double to int
 *     - Type mismatch: can not convert from int to short
 *     - Type mismatch: can not convert from int to short
 *     - Type mismatch: can not convert from long to int
 *     
 *   2) ������ �����ϱ� ���� ���� Ÿ���� �����ϰų� ������ Ÿ�Ժ�ȯ�� ĳ��Ʈ�� ������� 
 *      ������ ������ �� ����� Ȯ���϶�.  
 */

