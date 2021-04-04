/**
 * [ TemperatureConversion_UsingMethodWithReturnValue ]: 
 *        ȭ���µ��� �����µ����� �µ� ��ȯ(��ü �޼ҵ�, �Ű����� �� ��ȯ�� ���� �޼ҵ� ���)
 *   
 *   o ���α׷��� ��Ÿ�� 
 *     - ��ü �޼ҵ�, �Ű����� �� ��ȯ�� ���� �޼ҵ带 �ۼ��ϰ� �ۼ��� �޼ҵ� ȣ��
 *       
 *   o �ۼ��� ��ü �޼ҵ�
 *     - static void convertTemperature(): ��ȯ ���� �Է��Ͽ� �ش� ��ȯ�� ���� �۾� �����ϵ��� �����ϴ� �޼ҵ�
 *     - static void displayMenus()
 *     - static void inputConvertOutputDegree_FtoC(): ȭ���µ� �Է��Ͽ� ������ ��ȯ�Ͽ� ����ϴ� �޼ҵ�
 *     - static void inputConvertOutputDegree_CtoF(): �����µ� �Է��Ͽ� ȭ���� ��ȯ�Ͽ� ����ϴ� �޼ҵ�
 *       
 *   o �ۼ��� �Ű����� �� ��ȯ�� ���� �޼ҵ�
 *     - static int getMenu(int min, int max, String promptMsg, String errorMsg)
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

class Ex5_4_8_TemperatureConversion_UsingMethodWithReturnValue  {
	public static void main(String[] args)  {		
		convertTemperature();  // �µ� ��ȯ �޼ҵ� ȣ��
	}

	static void convertTemperature() {	
		while(true) {
			displayMenus();  // �޴� ���
			int menu = getMenu(1, 3, "\n  * Choose which > ", "\n  ??? Wrong task selected. Try again");

			if (menu == 1) 
				inputConvertOutputTemperature_FtoC();
			else if (menu == 2) 
				inputConvertOutputTemperature_CtoF();
			else if (menu == 3)
				break; 
		}
	}

	// �۾��� ���� �޴��� ����ϴ� �޼ҵ�
	static void displayMenus() {
		System.out.println("\n\n  ** Conversion of Temperature **");

		System.out.println("    1) Fahrenheit Temperature to Centigrade Temperature");
		System.out.println("    2) Centigrade Temperature to Fahrenheit Temperature");
		System.out.println("    3) End");
	}

	// promptMsg ����� �� min�� max ������ ���� �Է��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// min�� max ������ ������ �ƴ� ��� errorMsg ����ϰ� �ٽ� �Է� ����
	static int getMenu(int min, int max, String promptMsg, String errorMsg) {
		while(true) {
			int menu = SkScanner.getIntWithPrompt(promptMsg);
			if (menu >= min &&menu <= max)     //  min�� max ������ ���� �Է��ϸ� 
				return menu;                   //    �Է��� ���� ��ȯ
			else                               // min�� max ������ ������ �ƴ� ��� 
				System.out.println(errorMsg);  //    errorMsg�� ����ϰ� while �� �ݺ�
		}

	}

	static void inputConvertOutputTemperature_FtoC() {
		double F, C;   // ȭ���µ��� �����µ� ������ ����: �޼ҵ� ������ ���� ������ 

		F = SkScanner.getDoubleWithPrompt("\n  o Input Fahrenheit degree > ");

		C = (F - 32) * 5 / 9;

		double C1 = (int) ((C + ((C>0) ? 0.05 : -0.05)) * 10) / 10.0; // �Ҽ��� ���� 2�ڸ����� �ݿø�
		System.out.println("\n  * " + F + "F = " + C + "C = " + C1 + "C"); 
	}

	static void inputConvertOutputTemperature_CtoF() {
		// �� �޼ҵ带 �ۼ��϶�. 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *  
 *   1) �� ���α׷��� ���� 5-2-9�� ���α׷��� ������ ���α׷��̴�.
 *   
 *      5-2-9�� ���α׷��� �� ���α׷��� ���غ��鼭 �Ű������� ���� �޼ҵ��
 *      ��ȯ�� ���� �޼ҵ��� ������ �����϶�.
 *      
 *   2) ȭ���µ� 32, 55.2, 180.5, 212�� ���� �����µ��� ���ϰ�
 *      �����µ� 0, 22, 30, 100�� ���� ȭ���µ��� ���϶�.    
 *        
 *
 *  [ �ǽ����� ] 
 *  
 *   1) inputConvertOutputDegree_CtoF() �޼ҵ尡 �̿ϼ��̴�. �̸� �ϼ��϶�.
 *      
 *   2) �����µ��� Ķ��µ��� ��ȯ�ϰ� Ķ��µ��� �����µ��� ��ȯ�ϴ� �۾��� �޴� 3���� 4������ �߰��ϰ� 
 *      inputConvertOutputTemperature_CtoK()�� inputConvertOutputTemperature_KtoC() �޼ҵ带 
 *      �߰� �ۼ��϶�.
 */