package ex07_unit_conversion;

/*
 *  [ UnitConversion_AmazingAndHappy_UsingMethod ]: ���� ������ ������ ����(Unit of weights and measures) ���� ��ȯ�� �ϴ� ���α׷�
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

class UnitConversion {
	String unitName;            // ��ȯ ���� ������ ����
	String unitNameToConvert;   // ��ȯ ���� ������ ����
	double conversionFactor;	// ��ȯ ����
	double measureToConvert;    // ��ȯ ���� ������ ������ ��
	double measureConverted;    // ��ȯ ���� ������ ������ ��
	
	// ��ȯ �� ������ ���� �̸�, ��ȯ �� ������ ���� �̸�, ��ȯ������ ��ȯ ��ü�� �����ϴ� ��ü ������
    UnitConversion(String unitName, String unitNameToConvert, double conversionFactor) {
		this.unitName = unitName;
		this.unitNameToConvert = unitNameToConvert ;
		this.conversionFactor = conversionFactor;
	}
    
    // �־��� �Ǽ� ���� ��ȯ �� ������ ���� ������ �����ϴ� �޼ҵ�
    void setMeasureToConvert(double m) {
    	measureToConvert = m;
    }
    
    // �־��� �Ǽ� ���� ��ȯ �� ������ ���� ������ �����ϴ� �޼ҵ�
    void setMeasureConverted(double m) {
    	measureConverted = m;
    }
    

    // ��ȯ ���� ������ ������ ���� ���� �Է��Ͽ� measureToConvert �ʵ忡 �����ϴ� �޼ҵ�
	void inputMeasuretoConvert() {
		System.out.print("\n  o " + unitName + "���� " + 
				unitNameToConvert + " ��ȯ: " + unitName + " �Է� > ");
		
		setMeasureToConvert(SkScanner.getDouble());  // �Ǽ� �Է��Ͽ� ��ȯ �� ������ ����
		
	}
	
	// ��ȯ ���� ������ ������ ���� ���� ��ȯ ���� ������ ������ ������ ��ȯ�Ͽ� measureConverted �ʵ忡 �����ϴ� �޼ҵ�
	//  ��ȯ ���� �Ҽ� ���� 3�ڸ����� �ݿø���
	void convert() {
		// ��ȯ ������ ���Ͽ� ��ȯ�ϰ� �Ҽ��� ���� 2�ڸ����� ����
		double m = measureToConvert * conversionFactor;
		setMeasureConverted((int)((m + 0.005) * 100) / 100.0);   
	}
	

	// ��ȯ ���� ������ ������ ���� ���� ��ȯ ���� ������ ������ ���� ����ϴ� �޼ҵ�
	//  ��ȯ ���� �Ҽ� ���� 3�ڸ����� �ݿø���
    void outputConversion() {
		System.out.println("\n  * ��ȯ ���: "+ measureToConvert + unitName + " = " + 
				measureConverted + unitNameToConvert);		
		
	}
	
    // ���� ��ȯ�� ������ ��ȯ ��ü���� �����ϴ� ������ ��ȯ ��ü �迭
	static UnitConversion[] unitConversions = {
		new UnitConversion("m", "yard", 1.093),       new UnitConversion("yard", "m", 0.9144),   
		new UnitConversion("Km", "mile", 0.621371),   new UnitConversion("mile", "km", 1.609344), 
		new UnitConversion("kg", "pound", 2.20459),   new UnitConversion("pound", "kg", 0.45359), 
		new UnitConversion("g", "don", 0.26666),      new UnitConversion("don", "g", 3.75), 
		new UnitConversion("m*m", "pyoung", 0.3025),  new UnitConversion("pyoung", "m*m", 3.3058)		
	};
	
	// unitConversions.length�� unitConversions �迭�� ���Ұ����� ��Ÿ��
	// ���� unitConversions.length �迭�� ���Ҵ� 10�̹Ƿ� noUnits���� 10�� �����
	static int noUnits = unitConversions.length ; // ��ȯ�� ������  ������ �����ϴ� ����

	// �޴��� ����� �� �޴��� ��� ��ġ�� �����ϰ� ���߱� ���� ���Ǵ� ������
	static int maxLengthOfUnitNames = 0; // ������ ������ �ִ� ���ڰ��� �����ϴ� ����

	// �������� �ִ� ���� ������ ���Ͽ� maxLengthOfUnitNames ������ �����ϴ� �޼ҵ�
	static void setMaxLengthOfUnitNames() {
		for (int i = 0; i < noUnits; i++) // �������� �ִ� ���� ������ ����
			if (unitConversions[i].unitName.length() > maxLengthOfUnitNames)
				maxLengthOfUnitNames = unitConversions[i].unitName.length();

	}
	
	// 
	static UnitConversion getUnitConversion(int n) {
		return unitConversions[n - 1];
	}
	
	static {
		setMaxLengthOfUnitNames(); // ������ ������ �ִ� ���ڰ����� maxLengthOfUnitNames ������ ����
		                           // �� �޼ҵ�� ����ƽ �ʱ�ȭ ��Ͽ��� ȣ��Ǿ� �����
	}
	
	static int displaySelectMenu() {

		while(true) {
			System.out.println("\n\n  ** ������ ��ȯ ** \n");


			// �޴� ����Ʈ�� �ڵ������� �����Ͽ� ���
			for (int i = 0; i < noUnits; i++) {
				System.out.print("   " + fillBlankHead(i + 1, 2) +") " 
						+ fillBlankTail(unitConversions[i].unitName, maxLengthOfUnitNames)  + " ==> "  
						+ fillBlankTail(unitConversions[i].unitNameToConvert, maxLengthOfUnitNames));             

				if (i % 2 == 1) 
					System.out.println();  // �� �ٿ� 2�� �޴��� ���, 2������ �ٹٲ� ���
			}

			// ���� �޴� ��ȣ�� 2�ڸ��� ���
			System.out.println("   "+ fillBlankHead(noUnits + 1, 2) +") ����");    

			int menu = SkScanner.getIntWithPrompt("\n  o ��ȯ ���� > ");  

			if (menu >= 1 && menu <= noUnits + 1)  { // ������  �޴��� ���õǸ�
					return menu;                // �޴� ��ȣ�� ��ȯ��
			}
			else  {    // ������ �޴��� ������ ���
				System.out.println("\n  !!! �߸��� ��ȯ ����: " + menu);
				continue;
			}
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

class Ex6_UnitConversion_AmazingAndHappy_UsingClass {

	public static void main(String[] args)  {
        int endMenu = UnitConversion.noUnits + 1;
        
		while(true) {
			int menu = UnitConversion.displaySelectMenu();  // �޴� ���÷�����  �� �޴��� ������
			
			if (menu == endMenu) {   // ���� �޴� ���ý� ����
				System.out.println("\n  !!! �����մϴ�.");
				break;
			}

			// �޴��� ���� ������ ���� ��ȯ ��ü ���Ͽ� uc�� ����
			UnitConversion uc = UnitConversion.getUnitConversion(menu);
			
			// ��ȯ��  ������ �� �Է�, ��ȯ, ����ϱ� 
			uc.inputMeasuretoConvert();
			uc.convert();
			uc.outputConversion();
		}
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

