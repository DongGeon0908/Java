/**
 * [ TemperatureConversion_TextBased ]: 
 *        ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϴ� �ؽ�Ʈ ����� ����� ����
 *        
 *   o �µ� ü��
 *     1) �����µ�(���� C): ��� �µ�: 0, ���� �µ�: 100 (100 ��н�Ų �µ�ü��)
 *     2) ȭ���µ�(���� F): ��� �µ�: 32, ���� �µ�: 212 (180 ��н�Ų �µ�ü��)
 *     3) Ķ��(Kelvin)�µ�(���� K): -273.15C�� 0K�� ����, Ķ��µ� 0K ������ �µ��� ���� 
 *                               �����п��� ����ϴ� ���� �µ�ü��
 *     
 *   o ȭ���µ����� �����µ����� ��ȯ
 *     C = (F - 32) * 5 / 9;
 */

import java.util.Scanner;
class Ex12_1_1_TemperatureConversion_TextBased  {
	public static void main(String[] args)  {
		double F, C;   // ȭ���µ��� �����µ� ������ ����

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n  ** Conversion of Fahrenheit Temperature to Centigrade **");    

		while(true) {
			System.out.print("\n  o Input Fahrenheit degree > ");
			F = scanner.nextDouble();    
			C = (F - 32) * 5 / 9;
			System.out.println("  * " + F + "F = " + C + "C");
		}    
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *             
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϴ� �ؽ�Ʈ ��� ���α׷��̴�.
 *      �ݴ�� �����µ��� �Է��Ͽ� ȭ���µ��� ��ȯ�Ͽ� ����ϴ� ���α׷��� 
 *      Pr12_1_1_TemperatureConversion_TextBased_CtoF Ŭ������ �ۼ��϶�. 
 *      (�����µ� C�� ȭ���µ� F�� ��ȯ�ϴ� ������ F = C * 9 / 5  + 32 ��)
 *   
 *   2) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����Ѵ�. ȭ���µ��� Ķ�� �µ��� 
 *      ��ȯ�Ͽ� ����ϴ� ���α׷��� Pr12_1_1_TemperatureConversion_TextBased_FtoK Ŭ������ �ۼ��϶�.  
 *      (�����µ� C�� Ķ��µ� K�� ��ȯ�ϴ� ������ K = C + 273.15�̸�, 
 *       ȭ���µ����� �����µ��� ���� �� �ٽ� �����µ����� Ķ��µ��� ���� ����ϸ� ��) 
 */
