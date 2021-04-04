package ex06_temperature;

/*
 * [ TemperatureConversionMany_SwitchMethod ]: switch ���� �޼ҵ带 �̿��ϴ� �µ� ��ȯ ���α׷�
 * 
 **
 *   o  �µ� �������� ���� �µ�, ȭ�� �µ�, �̺� �µ� ���� �ִ�.
 *      ���� �µ�(���� C): ��� �µ�: 0C, ���� �µ�: 100C (100 ��н�Ų �µ�ü��)
 *      ȭ�� �µ�(���� F): ��� �µ�: 32F, ���� �µ�: 212F (180 ��н�Ų �µ�ü��)
 *      Ķ��(Kelvin) �µ�(���� K): -273C�� 0K�� ����, ����µ� 0K ������ �µ��� ���� �����п��� ����ϴ� ���� �µ�ü��
 *     
 *    o �� ���α׷��� Ư�� ������ �µ��� �Է��ϰ� �ٸ� ������ �µ��� ��ȯ�Ͽ� ����ϴ� ���� �ݺ��Ѵ�.
 *      1) �ݺ��� < while(true) { ... } >�� ���� �ݺ��ϵ��� �Ǿ� ������, 
 *         while ��� ������ �۾� ���ᰡ ���õǸ� < break; >�� ���� ���� �ݺ��� �����.
 *         
 *      2) �ٸ� ������ �µ����� ��ȯ �۾��� �� 6������ �־�����.
 *         (�� 6�������� �ƴ°�? ����б� ���п��� ��� 3P2 = 3 * 2 = 6�̱� �����̴�. ���⿡�� P�� �����̴�)
 *         6������ �۾��� ���� ���õ� �۾��� if ������ �˻��Ͽ� ��ȯ�� �����Ѵ�.       
 *         
 *    *******************************************************************************************
 *    ���� ���α׷����� ������ ����
 *    
 *      1) ��ü ���α׷���   ���� �޼ҵ��� �����Ǿ� ���α׷��� ��������� ������
 *    
 *   *******************************************************************************************
 *
 *
 */   

class Ex5_2_TemperatureConversionMany_SwitchMethod  {
	
	public static void main(String[] args)  {
		int menu;
	    double temperatureToConvert;
	    double temperatureConverted;

		
		while(true) {			// ���ᰡ ���õ� ������ �ݺ� ����
			
			menu = displaySelectMenu();
			
			if (menu==7)  {  // ���� ���ý�
				System.out.print("\n  �����մϴ�. Bye!!!");     // ���� �޼��� ��� ��
				break;                                          // while ���� ��� ������(< return; >�� �̿��Ͽ��� ���� ȿ����)
			}		
			
			temperatureToConvert = getIntWithPrompt("\n  * ��ȯ �µ� �Է� > ");
						
			temperatureConverted = convertTemperature(menu, temperatureToConvert);
			
            outputTemperatureConverted(menu, temperatureToConvert, temperatureConverted);
		}
	}
	
	// �۾������� �޴��������� ����ϰ� �޴��� �Է��Ͽ� ��ȯ
	static int displaySelectMenu() {
		System.out.println("\n\n\n               **** �µ� ��ȯ ���α׷� *** ");
		System.out.println("  1) ���� �µ� ==> ȭ�� �µ�    2) ���� �µ� ==> Ķ�� �µ�");
		System.out.println("  3) ȭ�� �µ� ==> ���� �µ�    4) ȭ�� �µ� ==> Ķ�� �µ�");
		System.out.println("  5) Ķ�� �µ� ==> ���� �µ�    6) Ķ�� �µ� ==> ȭ�� �µ�");
		System.out.println("  7) ����");

		int menu;
		
		while (true) {
			System.out.print("\n  * �۾� ���� > ");

			menu  = SkScanner.getInt();  // SkScanner.getInt()�� �޴� ����

			if (menu >=1 &&  menu <= 7)  // �޴� ���� 1���� 7������, �ùٸ� �޴��� ������ ���
				return menu;             // �޴��� ��ȯ

			System.out.print("\n  ?? ����: �߸��� �����Դϴ�. �ٽ� �����Ͻʽÿ�.");   // ���� �޼��� ��� �� �޴� ���Է�			                                                                         // ��� �ݺ�
		}
	}
	
	// �־��� ������Ʈ �޼����� ����� �� ������ �о� ��ȯ
	static int getIntWithPrompt(String promptMsg) {
		System.out.print(promptMsg);    // ������Ʈ �޼����� ����� �� 
		
		return SkScanner.getInt();  	// SkScanner.getInt()�� ���� �Է��ϰ� ��ȯ��Ŵ
	}
	
	
	static double convertTemperature(int menu, double temperatureToConvert) {
		
		switch (menu) {
		case 1:  // 1) ���� �µ� ==> ȭ�� �µ�
			return temperatureToConvert * 9 / 5 + 32;

		case 2:  // 2) ���� �µ� ==> Ķ�� �µ�
			return temperatureToConvert + 273;  // Ķ�� �µ��� ���� �µ��� 273�� ������

		case 3:  // 3) ȭ�� �µ� ==> ���� �µ�
			return (temperatureToConvert -32) * 5 / 9;  // ȭ�� �µ��� ���� �µ��� �ٲٴ� ����

		case 4:  // 4) ȭ�� �µ� ==> Ķ�� �µ�
			return (temperatureToConvert -32) * 5 / 9   +   273;  // ȭ�� �µ��� ���� �µ��� �ٲ� �� 273�� ������

		case 5:  // 5) Ķ�� �µ� ==> ���� �µ�    
			return temperatureToConvert - 273;                    // ���� �µ��� Ķ�� �µ����� 273�� ����

		case 6:  // 6) Ķ�� �µ� ==> ȭ�� �µ�
			return (temperatureToConvert - 273) * 9 / 5 + 32;    // Ķ�� �µ��� ���� �µ��� �ٲ� �� ȭ���� �ٲ�
		}
		
		return 0;
	}
	
	static void outputTemperatureConverted(int menu, double temperatureToConvert, double temperatureConverted) {
		String msgOutput = "";
		
		switch (menu) {
		case 1:  // 1) ���� �µ� ==> ȭ�� �µ�
			msgOutput = "\n    ���� �µ� " + temperatureToConvert +"C ==> ȭ�� �µ� " + temperatureConverted + "F";
			break;

		case 2:  // 2) ���� �µ� ==> Ķ�� �µ�
			msgOutput = "\n    ���� �µ� " + temperatureToConvert +"C ==> Ķ�� �µ� " + temperatureConverted + "K";	    	
			break;
			
		case 3:  // 3) ȭ�� �µ� ==> ���� �µ�
			msgOutput = "\n    ȭ�� �µ� " + temperatureToConvert +"F ==> ���� �µ� " + temperatureConverted + "C";	    	
			break;

		case 4:  // 4) ȭ�� �µ� ==> Ķ�� �µ�
			msgOutput = "\n    ȭ�� �µ� " + temperatureToConvert +"F ==> Ķ�� �µ� " + temperatureConverted + "K";		

		case 5:  // 5) Ķ�� �µ� ==> ���� �µ�    
			msgOutput = "\n    Ķ�� �µ� " + temperatureToConvert +"K ==> ���� �µ� " + temperatureConverted + "C";	    	
			break;

		case 6:  // 6) Ķ�� �µ� ==> ȭ�� �µ�
			msgOutput = "\n    Ķ�� �µ� " + temperatureToConvert +"K ==> ȭ�� �µ� " + temperatureConverted + "F";		
			break;
		}	
		
		System.out.print(msgOutput);
	}
}

/*
 * �ǽ�����:
 *       
 * ������ �����ϰ� ����غ� ����:  
 *      
 *       C ���α׷��ֿ����� �� ������ �翬�� ����Ǿ��� ���̸� �ذ�å�� ���õǾ�����, 
 *       �� �ذ�å�� �ٷ� �߻�ȭ(abstraction)�̴�. 
 *       �߻�ȭ�� �����̰�, ���α׷��ֿ��� ��� Ȱ��Ǵ°��� �����ϴ� ���� ���α׷����� ���ϱ� ���� ���� �߿���
 *       ��� �� �ϳ��̴�. �̴� C������ �Լ��̸�, java������ �޼ҵ�, Ŭ����, ��ü ���� ���⿡ �ش�ȴ�.   
 *       
 *       
 */
