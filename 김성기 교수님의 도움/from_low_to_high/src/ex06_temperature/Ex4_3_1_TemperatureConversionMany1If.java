package ex06_temperature;

/*
 *   �µ� �������� �����µ�, ȭ���µ�, �̺�µ� ���� �ִ�.
 *     �����µ�(���� C): ��� �µ�: 0C, ���� �µ�: 100C (100 ��н�Ų �µ�ü��)
 *     ȭ���µ�(���� F): ��� �µ�: 32F, ���� �µ�: 212F (180 ��н�Ų �µ�ü��)
 *     Ķ��(Kelvin) �µ�(���� K): -273C�� 0K�� ����, ����µ� 0K ������ �µ��� ���� �����п��� ����ϴ� ���� �µ�ü��
 *     
 *   �� ���α׷��� Ư�� ������ �µ��� �Է��ϰ� �ٸ� ������ �µ��� ��ȯ�Ͽ� ����ϴ� ���� �ݺ��Ѵ�.
 *      1) �ݺ��� < while(true) { ... } >�� ���� �ݺ��ϵ��� �Ǿ� ������, 
 *         while ��� ������ �۾� ���ᰡ ���õǸ� < break; >�� ���� ���� �ݺ��� �����.
 *         
 *      2) �ٸ� ������ �µ����� ��ȯ �۾��� �� 6�������̴�.
 *         (�� 6�������� �ƴ°�? ����б� ���п��� ��� 3P2 = 3 * 2 = 6�̱� �����̴�. ���⿡�� P�� �����̴�)
 *         6������ �۾��� ���� ���õ� �۾��� if ������ �˻��Ͽ� ��ȯ�� �����Ѵ�.    
 *         
 *      3) �޴��� ��� 7����(6���� ��ȯ�۾� �޴��� �����۾� �޴�)�� �����Ǹ� 
 *         �߸��� �޴��� �ԷµǸ� �ٽ� �޴��� �Է��Ѵ�.  
 *         
 *    �� ���α׷��� ������
 *    ************************************************************************************************************
 *    1) �۾��� �ݺ��ϱ� ���� while ���� ���� �ݺ��� �ùٸ� �޴� ������ ���� while ���� �����Ǿ� ���α׷��� �����ϴ�.
 *    
 *    2) �� ���α׷������� ���� if ���� true �κп��� ��ȯ �� �µ��� ��ȯ �� �µ� ��θ� ����ϴ� ������ 
 *       ���ԵǾ� �ְ� ����� ���� ��Ʈ�� �����۾��� �ټ� �����Ͽ� ���α׷��� �������� ���̴� ������ �ִ�.
 *       
 *    3) �� ���α׷��� ��� ���� �����ϴ� �۾��� ������ main() �޼ҵ��� ���μ�(��ü �� 60�� ����)�� �������� 
 *       �ѹ��� ���α׷��� ����� �����ϱ� ���������. 
 *       
 *    ===> 
 *    
 *       C ���α׷��ֿ����� �� ������ �翬�� ����Ǿ��� ���̸� �ذ�å�� ���õǾ�����, 
 *       �� �ذ�å�� �ٷ� �߻�ȭ(abstraction)�̴�. 
 *       �߻�ȭ�� �����̰�, ���α׷��ֿ��� ��� Ȱ��Ǵ°��� �����ϴ� ���� ���α׷����� ���ϱ� ���� ���� �߿���
 *       ��� �� �ϳ��̴�. �̴� C������ �Լ��̸�, Java������ �޼ҵ�, Ŭ����, ��ü ���� ���⿡ �ش�ȴ�.   
 *   *************************************************************************************************************
 */

class Ex4_3_1_TemperatureConversionMany1If  {
	public static void main(String[] args)  {
		int menu;              // ���õ� �޴��� �����ϴ� ����
		double temperatureToConvert;   // ��ȯ�� �µ��� ������ ����
		double temperatureConverted;   // ��ȯ�� �µ��� ������ ����
				
		while(true) {			// ���ᰡ ���õ� ������ �ݺ� ����
			System.out.println("\n\n\n               **** �µ� ��ȯ ���α׷� *** ");
			System.out.println("  1) �����µ� ==> ȭ���µ�    2) �����µ� ==> Ķ��µ�");
			System.out.println("  3) ȭ���µ� ==> �����µ�    4) ȭ���µ� ==> Ķ��µ�");
			System.out.println("  5) Ķ��µ� ==> �����µ�    6) Ķ��µ� ==> ȭ���µ�");
			System.out.println("  7) ����");

			// 1���� 7������ �޴��� ���õ� ������ �ݺ�
			while(true) {
				System.out.print("\n  * �۾� ���� > ");

				menu  = SkScanner.getInt();   // SkScanner.getInt()�� �޴� ����

				if (menu < 1  || menu > 7)  { // �޴� ���� 1���� 7������, �߸��� �޴��� ������ ���
					System.out.print("\n  ?? ����: �߸��� �����Դϴ�. �ٽ� �����Ͻʽÿ�.");     // ���� �޼��� ��� ��
					continue;                 // < continue; >�� ���� ������ �ݺ� �κ��� �����ϰ� �ݺ��� ������ �����ϰ� ��
				}
				break;
			}
			
			if (menu==7)  {  // ���� ���ý�
				System.out.print("\n  �����մϴ�. Bye!!!");     // ���� �޼��� ��� ��
				break;                                          // while ���� ��� ������(< return; >�� �̿��Ͽ��� ���� ȿ����)
			}		
			
			System.out.print("\n  * ��ȯ  �µ� �Է� > ");
			temperatureToConvert  = SkScanner.getDouble();  	// SkScanner.getDouble()�� ��ȯ�� �µ� �Է�
			
		    if (menu==1) {       // 1) �����µ� ==> ȭ���µ� 
		    	temperatureConverted = temperatureToConvert * 9 / 5 + 32;              // �����µ��� ȭ���µ��� �ٲٴ� ����
				System.out.println("\n    �����µ� " + temperatureToConvert +"C ==> ȭ���µ� " + temperatureConverted + "F");
		    }
     	    else if (menu==2) {  // 2) �����µ� ==> Ķ��µ�
		    	temperatureConverted = temperatureToConvert + 273;                    // Ķ��µ��� �����µ��� 273�� ������
				System.out.println("\n    �����µ� " + temperatureToConvert +"C ==> Ķ��µ� " + temperatureConverted + "K");	    	
		    }
    	    else if (menu==3) {  // 3) ȭ���µ� ==> �����µ�
		    	temperatureConverted = (temperatureToConvert -32) * 5 / 9;            // ȭ���µ��� �����µ��� �ٲٴ� ����
				System.out.println("\n    ȭ���µ� " + temperatureToConvert +"F ==> �����µ� " + temperatureConverted + "C");	    	
		    }
    	    else if (menu==4) {  // 4) ȭ���µ� ==> Ķ��µ�
		    	temperatureConverted = (temperatureToConvert -32) * 5 / 9   +   273;  // ȭ���µ��� �����µ��� �ٲ� �� 273�� ������
				System.out.println("\n    ȭ���µ� " + temperatureToConvert +"F ==> Ķ��µ� " + temperatureConverted + "K");		
		    }
    	    else if (menu==5) {  // 5) Ķ��µ� ==> �����µ�    
    	    	temperatureConverted = temperatureToConvert - 273;                    // �����µ��� Ķ��µ��� 273�� ����
    	    	System.out.println("\n    Ķ��µ� " + temperatureToConvert +"K ==> �����µ� " + temperatureConverted + "C");	    	
    	    }
    	    else if (menu==6) {  // 6) Ķ��µ� ==> ȭ���µ�
    	    	temperatureConverted = (temperatureToConvert - 273)  * 9 / 5 + 32;    // Ķ��µ��� �����µ��� �ٲ� �� ȭ���� �ٲ�
    	    	System.out.println("\n    Ķ��µ� " + temperatureToConvert +"K ==> ȭ���µ� " + temperatureConverted + "F");		
    	    }
		}
	}
}

