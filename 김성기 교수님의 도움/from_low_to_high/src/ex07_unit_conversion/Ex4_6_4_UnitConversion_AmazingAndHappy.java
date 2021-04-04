package ex07_unit_conversion;

/*
 *  [ UnitConversion_AmazingAndHappy ]: ���� ������ ������ ����(Unit of weights and measures) ���� ��ȯ�� �ϴ� ���α׷�
 *  
 *    o ���������� ��ȯ������ ������ ����
 *        1m = 1.093 yard,            1yard = 0.9144m
 *        1Km = 0.621371 mile         1mile = 1.609344Km
 *        1kg = 2.20459 pound,        1pound = 0.45359kg
 *        1g = 0.26666��,             1�� = 3.75g
 *        1m*m(��������) = 0.3025��,  1�� = 3.3058m*m(��������)
 *            
 *    o  ��ȯ�� ������ ������ �����ϰ� �Է��� ������ ���� ��ȯ�Ͽ� �����
 *    
 *    o �� ���α׷��� ���ο� �޴��� �߰��ϰų� �����ϴ� ����� ����, ������ ���� ���α׷���
 *     - ���ο� �޴��� ÷���ϴµ� �ҿ�Ǵ� �ð��� �� 30���̸�, �����ϴµ��� 10���̸� ����� 
 *     - ���� String unitNamesFrom[], unitNamesTo[], conversionFactor[] �迭��
 *       �ʿ��� �����͸� ÷���ϸ� �ڵ������� �޴��� �߰��� 
 *     - �迭���� �ش�Ǵ� �����͸� �����ϸ� �ڵ������� �޴��� ������ 
 */

class Ex4_6_4_UnitConversion_AmazingAndHappy {

	public static void main(String[] args)  {
		String unitNamesFrom[] =  // ��ȯ�� ������ �������� �����ϴ� �迭����
			{ "", "m", "yard", "Km", "mile", "kg", "pound", "g", "don", "m*m", "pyoung" };

		String unitNamesTo[] =   // ��ȯ�� ������ �������� �����ϴ� �迭����
			{ "", "yard", "m",  "mile", "Km", "pound", "kg", "don", "g", "pyoung", "m*m" };

		double conversionFactor[] = { // ��ȯ�� �� ������ �������� ��ȯ����
				0,    // �޴� ��ȣ�� ��ȯ ������ ������ ��ġ��Ű ���� ù��° ���Ҵ� �����
				1.093,      0.9144,     // m�� yard  ��ȯ����
				0.621371,   1.609344,   // km�� mile ��ȯ����
				2.20459,    0.45359,    // Kg�� pound  ��ȯ����
				0.26666,    3.75,       // g�� don(��) ��ȯ����
				0.3025,     3.3058      // m*m�� pyoung(��) ��ȯ����
		};

		// conversionFactor.length�� conversionFactor[] �迭�� ���Ұ����� ��Ÿ��
		// ���� conversionFactor[] �迭�� ���Ҵ� 11�̹Ƿ� NOMENU���� 11�� �����
		int NOMENU = conversionFactor.length ; // �޴� ������ �����ϴ� ����

		// �޴��� ����� �� �޴��� ��� ��ġ�� �����ϰ� ���߱� ���� ���Ǵ� ������
		int maxLengthOfUnitNames = 1; // ������ ������ �ִ� ���ڰ��� �����ϴ� ����
		for (int i = 0; i < NOMENU; i++) // �������� �ִ� ���� ������ ����
			if (unitNamesFrom[i].length() > maxLengthOfUnitNames)
				maxLengthOfUnitNames = unitNamesFrom[i].length();

		while(true) {
			System.out.println("\n\n     **** ������ ��ȯ **** \n");

			// �޴� ����Ʈ�� �ڵ������� �����Ͽ� ���
			for (int i = 1; i < NOMENU; i++) {
				System.out.print("    " + fillBlankHead(i, 2) +") " 
						+ fillBlankTail(unitNamesFrom[i], maxLengthOfUnitNames)  + " ==> "  
						+ fillBlankTail(unitNamesTo[i], maxLengthOfUnitNames));             

				if (i % 2 == 0) 
					System.out.println();  // �� �ٿ� 2�� �޴��� ���, 2������ �ٹٲ� ���
			}

			// ���� �޴� ��ȣ�� 2�ڸ��� ���
			System.out.println("    "+ fillBlankHead(NOMENU, 2) +") ����");    

			int menu = SkScanner.getIntWithPrompt("\n  o �޴� ���� > ");  

			if (menu == NOMENU)  {    // ���� �޴��� ���õǸ�
				System.out.println("    !!! �����մϴ�.");
				break;                // while ������ ��� ����
			}
			else if (menu <= 0 || menu > NOMENU) {    // ������ �޴��� ������ ���
				System.out.println("    !!! �߸��� �޴�: " + menu);
				continue;
			}

			double m, mConverted;   // ��ȯ ������ ���� �����ϴ� ����

			// �޴��� ���� ��ȯ�� ���� �� �Է�
			System.out.print("  o " + unitNamesFrom[menu] + "���� " + 
					unitNamesTo[menu] + " ��ȯ: " + unitNamesFrom[menu] + " �Է� > ");
			m = SkScanner.getDouble();

			// ��ȯ ������ ���Ͽ� ��ȯ�ϰ� �Ҽ��� ���� 2�ڸ����� ����
			mConverted = m * conversionFactor[menu];
			mConverted = (int)((mConverted + 0.005) * 100) / 100.0;   

			System.out.println("\n  * ��ȯ ���: "+ m + unitNamesFrom[menu] + " = " + 
					mConverted + unitNamesTo[menu]);
		}
	}

	// �ʿ�� ���ڿ��� ���ʿ� ' '(blank)�� ä�� ���� ������ len���� ���� ���ڿ��� ��ȯ
	static String fillBlankTail(String s, int len) {
		int slen = s.length();    // ���ڿ��� ���� ���̸� ����

		if (len - slen > 0)       // �䱸�Ǵ� ���̰� ���ڿ��� ���̺��� ��� 
			for (int i=0; i < len - slen; i++)    // �ʿ��� ������ŭ
				s = s + " ";                      // ���ʿ� blank�� ä��

		return s;
	}

	// �ʿ�� ���ʿ� ' '�� ä�� ������ �־��� ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	static String fillBlankTail(int i, int len) {
		return fillBlankTail(i + "", len);  // i�� ���ڿ��� �ٲپ� fillBlankTail() ȣ��
	}


	// �ʿ�� ���ڿ��� ���ʿ� ' '(blank)�� ä�� ���� ������ len���� ���� ���ڿ��� ��ȯ
	static String fillBlankHead(String s, int len) {
		int slen = s.length();   // ���ڿ��� ���� ���̸� ����

		if (len - slen > 0)      // �䱸�Ǵ� ���̰� ���ڿ��� ���̺��� ��� 
			for (int i=0; i < len - slen; i++)  // �ʿ��� ������ŭ
				s = " " + s;                    // ���ʿ� blank�� ä��

		return s;
	}

	// �ʿ�� ���ʿ� ' '�� ä�� ������ �־��� ������ ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	static String fillBlankHead(int i, int len) {
		return fillBlankHead(i+"", len);   // i�� ���ڿ��� �ٲپ� fillBlankHead() ȣ��
	}
}

/*
 * [ �ǽ����� ]
 * 
 *   1) �� ���α׷��� cm�� inch�� ���� ��ȯ�ϴ� �޴��� 5���� 6�� �޴��� ÷���ϵ��� 
 *      ���α׷��� ��ȯ�غ���. cm�� inch ��ȯ������ 0.3937, 2.54�̴�. 
 *      (���α׷��� ����� �ľ����� ���ص� �����ϸ� 30�� �̳��� ������ �� �ִ�) 
 *      
 *   2) �� ���α׷����� �޴� 3���� 4�� �޴��� �����غ���.
 *      (���α׷��� ����� �ľ����� ���ص� �����ϸ� 10�� �̳��� ������ �� �ִ�)
 *   
 *   3) �޴� 2���� �߰��� ��쿡 ��ü ���α׷��� ���� ������ �󸶳� �þ�ڴ°�?
 *       
 *      
 * [ ������ �����ϰ� ����غ� ���� ]
 *   
 *   1) �� ���α׷��� ���̹� �Ǵ� ���� ����Ʈ�� ������ ��ȯ Ȩ�������� ���� ���ÿ�.
 *      ��� ���̰� �ִ��� ���캸��, ���α׷��� ������ ���� �ʿ��� ������ �������� ����غ��ÿ�.
 *   
 *   2) ���������� ũ�� ����, ����, ����, ���� �� ���� ������ ������ �� �������� �پ��� ������ �ִ�. 
 *      ���� ��� ���� �������� 13���� ������ �ְ�, ���� �������� 11�� ������ �ִ�.
 *      ���� ������ ������ ���� ���� ��ȯ�ϴ� ���α׷��� ����� ���ؼ��� 
 *      �޴��� ��� �����ؾ� �� �������� �Բ� �ǳ��� ���ÿ�.
 *       
 */

