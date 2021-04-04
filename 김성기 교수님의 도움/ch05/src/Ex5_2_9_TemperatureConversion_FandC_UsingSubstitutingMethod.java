/**
 *  [ TemperatureConversion_FandC__UsingSubstitutingMethod ]: 
 *         ȭ���µ��� �����µ����� �µ� ��ȯ(��ü �޼ҵ� ���)
 *   
 *    o ���α׷��� ��Ÿ�� 
 *      - ��ü �޼ҵ� �ۼ��ϰ� �ۼ��� ��ü �޼ҵ� ȣ��
 *       
 *    o �ۼ��� ��ü �޼ҵ�
 *      - static void convertDegree_FandC(): ��ȯ ������ �Է��Ͽ� �ش� ��ȯ�� ���� �۾��� �����ϵ��� �����ϴ� �޼ҵ�
 *      - static void inputConvertOutputDegree_FtoC(): ȭ���µ� �Է��Ͽ� ������ ��ȯ�Ͽ� ����ϴ� �޼ҵ�
 *      - static void inputConvertOutputDegree_CtoF(): �����µ� �Է��Ͽ� ȭ���� ��ȯ�Ͽ� ����ϴ� �޼ҵ�
 *       
 *   o �µ� ü��
 *     1) �����µ�(Centigrade temperature: ���� C)
 *        ��� �µ�: 0, ���� �µ�: 100 (100 ��н�Ų �µ�ü��)
 *        
 *     2) ȭ���µ�(Fahrenheit temperature: ���� F)
 *        ��� �µ�: 32, ���� �µ�: 212 (180 ��н�Ų �µ�ü��)
 *        
 *     3) Ķ��µ�(Kelvin temperature: ���� K): 
 *          -273.15C�� 0K�� ����, Ķ��µ� 0K ������ �µ��� ���� �����п��� ����ϴ� ���� �µ�ü��
 *        
 *   o �µ� ��ȯ ����
 *     - ȭ���µ����� �����µ��� ��ȯ
 *         C = (F - 32) * 5 / 9
 *       
 *     - �����µ����� ȭ���µ��� ��ȯ
 *     	   F = C * 9 / 5 + 32
 *     
 *     - �����µ����� Ķ��µ��� ��ȯ
 *     	   K = F + 273.15    
 */

class Ex5_2_9_TemperatureConversion_FandC_UsingSubstitutingMethod  {
	public static void main(String[] args)  {		
		convertDegree_FandC();  // �µ� ��ȯ �޼ҵ� ȣ��
		
		main(args); // �� ������ �ݺ���Ű�� ���� ������
	}
	
	static void convertDegree_FandC() {
		int menu;

		System.out.println("\n\n  ** Conversion of Temperature **");

		System.out.println("    1) Fahrenheit temperature to Centigrade");
		System.out.println("    2) Centigrade temperature to Fahrenheit degree\n");	
		
		menu = SkScanner.getIntWithPrompt("  * Choose which > ");

		if (menu == 1) 
			inputConvertOutputTemperature_FtoC();
		else
			inputConvertOutputTemperature_CtoF();
	}	
	
	static void inputConvertOutputTemperature_FtoC() {
		// ���� 4-2-2 �����Ͽ� �� �޼ҵ带 �ۼ��϶�.
	}
	
	static void inputConvertOutputTemperature_CtoF() {
		// ���� 4-2-2 �����Ͽ� �� �޼ҵ带 �ۼ��϶�. 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *  
 *   1) �� ���α׷��� ���� 4-2-2�� ���α׷��� ��ü �޼ҵ�� ��ȯ�� ���α׷��̴�.
 *      ������ ���� 4-2-2�� ���α׷��� �� ���α׷��� ���غ��鼭 ��ü �޼ҵ��� ������ 
 *      ��ü �߻�ȭ�� ���� �����غ���.       
 *     
       ================= [���� 4-2-2] �޼ҵ� ������� ���� �µ� ��ȯ ���α׷� ===============   
        
       class Ex4_2_2_TemperatureConversion_FandC_UsingIf  {
	      public static void main(String[] args)  {
		    int menu;
		    System.out.println("\n\n  ** Conversion of Temperature **");

		    System.out.println("    1) Fahrenheit temperature to Centigrade");
		    System.out.println("    2) Centigrade temperature to Fahrenheit\n");	
		
		    menu = SkScanner.getIntWithPrompt("  * Choose which > ");

		    if (menu == 1) {
			   double F, C;   // ȭ���µ��� �����µ� ������ ����

		       F = SkScanner.getDoubleWithPrompt("\n  * Input Fahrenheit degree > ");

			   C = (F - 32) * 5 / 9;
      
			   double C1 = (int) ((C + 0.05) * 10) / 10.0; // �Ҽ��� ���� 2�ڸ����� �ݿø�
			   System.out.println("\n  o " + F + "F = " + C + "C = " + C1 + "C"); 
		    }
		    else {		
		       double F, C;   // ȭ���µ��� �����µ� ������ ����

			   C = SkScanner.getDoubleWithPrompt("\n  * Input Centigrade degree > ");					
			   F = C * 9 / 5 + 32;
			   System.out.println("\n  o " + C + "C = " + F + "F"); 
		    }

		    main(args); 
	      }	
        }     
      
        =========================================================================================
      
 *    2) ȭ���µ� 32, 55.2, 180.5, 212�� ���� �����µ��� ���ϰ�
 *       �����µ� 0, 22, 30, 100�� ���� ȭ���µ��� ���϶�.      
 *      
 *
 * [ �ǽ����� ] 
 *  
 *   1) �� ���α׷����� inputConvertOutputTemperature_FtoC()�� 
 *      inputConvertOutputTemperature_CtoF() �޼ҵ尡 �̿ϼ��̴�. �̸� �ϼ��϶�.
 *      
 *      ���α׷��� �ϼ��Ǹ� ȭ���µ� 32, 55.2, 180.5, 212�� ���� �����µ��� ���ϰ�
 *      �����µ� 0, 22, 30, 100�� ���� ȭ���µ��� ���϶�.      
 *      
 *   2) main() �޼ҵ�� �ڽ��� ȣ���Ͽ� �µ� ��ȯ �۾��� �ݺ��Ѵ�. �̸� while ���� �̿��Ͽ�
 *      �ݺ��ϵ��� �ۼ��϶�. (����: ���� �ݺ��ϵ��� �ۼ��� ����)
 *     
 *     
 * [ ������� ]
 * 
 *   1) ��κ��� ���α׷��� �ѹ� ����� �� ����ȴ�. �־��� ���α׷��� ��� �ݺ��ϴ� ���� ���� ����� 
 *      main() �޼ҵ��� ���� ���� << main(args); >> �� �߰��ϴ� ���̴�.
 *      
 *      �� ��� ���α׷��� ���� �ݺ��Ͽ� ����ȴ�. 
 */
