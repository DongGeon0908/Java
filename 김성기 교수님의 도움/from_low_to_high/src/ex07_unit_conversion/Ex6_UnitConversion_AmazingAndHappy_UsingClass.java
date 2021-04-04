package ex07_unit_conversion;

/*
 *  [ UnitConversion_AmazingAndHappy_UsingMethod ]: 여러 종류의 도량형 단위(Unit of weights and measures) 간의 변환을 하는 프로그램
 *  
 *    o 도량형간의 변환기준은 다음과 같음
 *        1m = 1.093 yard,            1yard = 0.9144m
 *        1Km = 0.621371 mile         1mile = 1.609344Km
 *        1kg = 2.20459 pound,        1pound = 0.45359kg
 *        1g = 0.26666돈,             1돈 = 3.75g
 *        1m*m(제곱미터) = 0.3025평,  1평 = 3.3058m*m(제곱미터)
 *            
 *    o  변환할 도량형 단위를 선택하고 입력한 도량형 값을 변환하여 출력함
 *    
 *    o 이 프로그램은 새로운 메뉴를 추가하거나 삭제하는 방법이 쉬운, 정말로 놀라운 프로그램임
 *     - 새로운 메뉴를 첨가하는데 소요되는 시간은 약 30초이며, 삭제하는데는 10초이면 충분함 
 *     - 단지 String unitNamesFrom[], unitNamesTo[], conversionFactor[] 배열에
 *       필요한 데이터만 첨가하면 자동적으로 메뉴가 추가됨 
 *     - 배열에서 해당되는 데이터만 삭제하면 자동적으로 메뉴가 삭제됨 
 */

class UnitConversion {
	String unitName;            // 변환 전의 도량형 단위
	String unitNameToConvert;   // 변환 후의 도량형 단위
	double conversionFactor;	// 변환 비율
	double measureToConvert;    // 변환 전의 도량형 단위의 값
	double measureConverted;    // 변환 후의 도량형 단위의 값
	
	// 변환 전 도형량 단위 이름, 변환 후 도형량 단위 이름, 변환비율을 변환 객체에 저장하는 객체 생성자
    UnitConversion(String unitName, String unitNameToConvert, double conversionFactor) {
		this.unitName = unitName;
		this.unitNameToConvert = unitNameToConvert ;
		this.conversionFactor = conversionFactor;
	}
    
    // 주어진 실수 값을 변환 전 도형량 단위 값으로 저장하는 메소드
    void setMeasureToConvert(double m) {
    	measureToConvert = m;
    }
    
    // 주어진 실수 값을 변환 후 도형량 단위 값으로 저장하는 메소드
    void setMeasureConverted(double m) {
    	measureConverted = m;
    }
    

    // 변환 전의 도량형 단위에 대한 값을 입력하여 measureToConvert 필드에 저장하는 메소드
	void inputMeasuretoConvert() {
		System.out.print("\n  o " + unitName + "에서 " + 
				unitNameToConvert + " 변환: " + unitName + " 입력 > ");
		
		setMeasureToConvert(SkScanner.getDouble());  // 실수 입력하여 변환 전 값으로 저장
		
	}
	
	// 변환 전의 도량형 단위에 대한 값을 변환 후의 도량형 단위의 값으로 변환하여 measureConverted 필드에 저장하는 메소드
	//  변환 값은 소수 이하 3자리에서 반올림함
	void convert() {
		// 변환 비율을 곱하여 변환하고 소수점 이하 2자리까지 구함
		double m = measureToConvert * conversionFactor;
		setMeasureConverted((int)((m + 0.005) * 100) / 100.0);   
	}
	

	// 변환 전의 도량형 단위에 대한 값과 변환 후의 도량형 단위의 값을 출력하는 메소드
	//  변환 값은 소수 이하 3자리에서 반올림함
    void outputConversion() {
		System.out.println("\n  * 변환 결과: "+ measureToConvert + unitName + " = " + 
				measureConverted + unitNameToConvert);		
		
	}
	
    // 단위 변환할 도형량 변환 객체듷을 저장하는 도향형 변환 객체 배열
	static UnitConversion[] unitConversions = {
		new UnitConversion("m", "yard", 1.093),       new UnitConversion("yard", "m", 0.9144),   
		new UnitConversion("Km", "mile", 0.621371),   new UnitConversion("mile", "km", 1.609344), 
		new UnitConversion("kg", "pound", 2.20459),   new UnitConversion("pound", "kg", 0.45359), 
		new UnitConversion("g", "don", 0.26666),      new UnitConversion("don", "g", 3.75), 
		new UnitConversion("m*m", "pyoung", 0.3025),  new UnitConversion("pyoung", "m*m", 3.3058)		
	};
	
	// unitConversions.length는 unitConversions 배열의 원소개수를 나타냄
	// 현재 unitConversions.length 배열의 원소는 10이므로 noUnits에는 10이 저장됨
	static int noUnits = unitConversions.length ; // 변환할 도량형  개수를 저장하는 변수

	// 메뉴를 출력할 때 메뉴의 출력 위치를 일정하게 맞추기 위해 사용되는 변수임
	static int maxLengthOfUnitNames = 0; // 도량형 단위명 최대 글자개수 저장하는 변수

	// 단위명의 최대 글자 개수를 구하여 maxLengthOfUnitNames 변수에 저장하는 메소드
	static void setMaxLengthOfUnitNames() {
		for (int i = 0; i < noUnits; i++) // 단위명의 최대 글자 개수를 구함
			if (unitConversions[i].unitName.length() > maxLengthOfUnitNames)
				maxLengthOfUnitNames = unitConversions[i].unitName.length();

	}
	
	// 
	static UnitConversion getUnitConversion(int n) {
		return unitConversions[n - 1];
	}
	
	static {
		setMaxLengthOfUnitNames(); // 도량형 단위명 최대 글자개수를 maxLengthOfUnitNames 변수에 저장
		                           // 이 메소드는 스태틱 초기화 블록에서 호출되어 수행됨
	}
	
	static int displaySelectMenu() {

		while(true) {
			System.out.println("\n\n  ** 도량형 변환 ** \n");


			// 메뉴 리스트를 자동적으로 생성하여 출력
			for (int i = 0; i < noUnits; i++) {
				System.out.print("   " + fillBlankHead(i + 1, 2) +") " 
						+ fillBlankTail(unitConversions[i].unitName, maxLengthOfUnitNames)  + " ==> "  
						+ fillBlankTail(unitConversions[i].unitNameToConvert, maxLengthOfUnitNames));             

				if (i % 2 == 1) 
					System.out.println();  // 한 줄에 2개 메뉴를 출력, 2개마다 줄바꿈 출력
			}

			// 종료 메뉴 번호를 2자리로 출력
			System.out.println("   "+ fillBlankHead(noUnits + 1, 2) +") 종료");    

			int menu = SkScanner.getIntWithPrompt("\n  o 변환 선택 > ");  

			if (menu >= 1 && menu <= noUnits + 1)  { // 정상적  메뉴가 선택되면
					return menu;                // 메뉴 번호를 반환함
			}
			else  {    // 질못된 메뉴를 선택할 경우
				System.out.println("\n  !!! 잘못된 변환 선택: " + menu);
				continue;
			}
		}
	}
	
	// 필요시 문자열의 뒤쪽에 ' '(blank)를 채워 문자 개수를 len으로 만든 문자열을 반환
	static String fillBlankTail(String s, int len) {
		int slen = s.length();    // 문자열의 문자 길이를 구함

		if (len - slen > 0)       // 요구되는 길이가 문자열의 길이보다 길면 
			for (int i=0; i < len - slen; i++)    // 필요한 개수만큼
				s = s + " ";                      // 뒤쪽에 blank를 채움

		return s;
	}

	// 필요시 뒤쪽에 ' '를 채워 정수를 주어진 길이의 문자열로 반환하는 메소드
	static String fillBlankTail(int i, int len) {
		return fillBlankTail(i + "", len);  // i를 문자열로 바꾸어 fillBlankTail() 호출
	}


	// 필요시 문자열의 앞쪽에 ' '(blank)를 채워 문자 개수를 len으로 만든 문자열을 반환
	static String fillBlankHead(String s, int len) {
		int slen = s.length();   // 문자열의 문자 길이를 구함

		if (len - slen > 0)      // 요구되는 길이가 문자열의 길이보다 길면 
			for (int i=0; i < len - slen; i++)  // 필요한 개수만큼
				s = " " + s;                    // 앞쪽에 blank를 채움

		return s;
	}

	// 필요시 앞쪽에 ' '를 채워 정수를 주어진 길이의 문자열로 반환하는 메소드
	static String fillBlankHead(int i, int len) {
		return fillBlankHead(i+"", len);   // i를 문자열로 바꾸어 fillBlankHead() 호출
	}

}

class Ex6_UnitConversion_AmazingAndHappy_UsingClass {

	public static void main(String[] args)  {
        int endMenu = UnitConversion.noUnits + 1;
        
		while(true) {
			int menu = UnitConversion.displaySelectMenu();  // 메뉴 디스플레이한  후 메뉴를 선택함
			
			if (menu == endMenu) {   // 종료 메뉴 선택시 종료
				System.out.println("\n  !!! 종료합니다.");
				break;
			}

			// 메뉴에 따른 도형량 단위 변환 객체 구하여 uc에 저장
			UnitConversion uc = UnitConversion.getUnitConversion(menu);
			
			// 변환할  단위의 값 입력, 변환, 출력하기 
			uc.inputMeasuretoConvert();
			uc.convert();
			uc.outputConversion();
		}
	}
}

/*
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램에 cm와 inch를 서로 변환하는 메뉴를 5번과 6번 메뉴에 첨가하도록 
 *      프로그램을 변환해보라. cm와 inch 변환비율은 0.3937, 2.54이다. 
 *      (프로그램을 충분히 파악하지 못해도 웬만하면 30초 이내에 변경할 수 있다) 
 *      
 *   2) 이 프로그램에서 메뉴 3번과 4번 메뉴를 삭제해보라.
 *      (프로그램을 충분히 파악하지 못해도 웬만하면 10초 이내에 변경할 수 있다)
 *   
 *   3) 메뉴 2개를 추가할 경우에 전체 프로그램의 라인 개수가 얼마나 늘어나겠는가?
 *       
 *      
 * [ 스스로 생각하고 고민해볼 과제 ]
 *   
 *   1) 이 프로그램과 네이버 또는 다음 사이트의 도량형 변환 홈페이지와 비교해 보시오.
 *      어떠한 차이가 있는지 살펴보고, 프로그램의 개선을 위해 필요한 사항이 무엇인지 고려해보시오.
 *   
 *   2) 도량형에는 크게 길이, 넓이, 무게, 부피 등 여러 종류가 있으며 각 종류별로 다양한 단위가 있다. 
 *      예를 들어 길이 단위에는 13가지 단위가 있고, 넓이 단위에는 11개 정도가 있다.
 *      같은 종류별 단위간 값을 서로 변환하는 프로그램을 만들기 위해서는 
 *      메뉴를 어떻게 구성해야 할 것인지를 함께 의논해 보시오.
 *       
 */

