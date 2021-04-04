package ex07_unit_conversion;

	/*
	 * [ UnitConversion_Simple]: 도량형 단위(Unit of weights and measures)의 변환
	 *  
	 *   o 도량형간의 변환기준은 다음과 같음
	 *      - 1m = 1.093 yard,          	1yard = 0.9144m
	 *      - 1kg = 2.20459 pound,       	1pound = 0.45359kg
	 *      - 1m2(제곱미터) = 0.3025평,  	1평 = 3.3058m2(제곱미터)
	 *      
	 *   o 변환할 도량형 단위를 선택하고 입력한 도량형 값을 변환하여 출력함    
	 */
class Ex4_6_3_UnitConversion_Simple {
	public static void main(String[] args)  {

		while(true) {
			System.out.println("\n\n  **** 도량형 변환 ****");

			// 메뉴 리스트 출력
			System.out.println("    1) m ==> yard         2) yard ==> m");
			System.out.println("    3) kg ==> pound       4) pound ==> kg");
			System.out.println("    5) m*m ==> 평         6) 평 ==> m*m");
			System.out.println("    7) 종료");

			int menu = SkScanner.getInt("\n  o 메뉴 선택 > "); // 메뉴 입력

			double m, mConverted;  // 변환 전후의 값을 저장하는 변수

			// 메뉴별 값 입력, 변환, 결과 출력
			if (menu==1) { // 미터에서 야드로 변환
				m = SkScanner.getDouble("\n  o m에서 yard 변환: m 입력 > ");

				// 변환 비율을 곱하여 변환하고 소수점 이하 2자리까지 구함
				mConverted = m * 1.093;
				mConverted = (int) ((mConverted + 0.005) * 100) / 100.0; 

				System.out.println("\n  * " + m + "m" + " ==> " + mConverted + "yard");
			}
			else if (menu==2) { // 야드에서 미터로 변환
				m = SkScanner.getDouble("\n  o yard에서 m 변환:  yard 입력 > ");

				mConverted = m * 0.9144;  
				mConverted = (int)((mConverted + 0.005) * 100) / 100.0;  

				System.out.println("\n  * " + m +" yard" +" ==> " + mConverted + "m");
			}

			// 나머지 부분을 직접 작성해보라
			else if (menu==3) {  }  	// kg에서 파운드로 변환
			else if (menu==4) {  }  	// 파운드에서 kg으로 변환
			else if (menu==5) {  }		// 제곱미터에서 평으로 변환
			else if (menu==6) {  }		// 평에서 제곱미터으로 변환
			else if (menu == 7)
				break;
		}
		
		
		System.out.println("\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}
}

/*
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램은 메뉴 개수가 6가지인데 2가지만 구현되어 있다. 나머지 4가지를 완성하라.
 *   
 *   2) 메뉴 개수가 12가지로 확대되면 main() 메소드의 문장 개수가 얼마나 늘어나겠는가?
 *   
 *   3) 우리나라에서 금의 무게 단위로 돈을 사용하며, 1돈은 1돈은 3.75g이다. 돈을 그램으로 변경하는 
 *      메뉴를 메뉴 7로 추가하고 종료 메뉴를 8로 변경하도록 프로그램을 수정하라.  
 *    
 *      
 * [ 스스로 생각하고 고민해볼 과제 ]    
 *     
 *   o 이 프로그램에 새로운 변환 메뉴를 추가하기 위한 과정은 다음과 같다.
 *     a) 메뉴 리스트를 출력하는 부분에서의 새로운 메뉴 첨가
 *     b) 변환할 값 입력, 변환, 결과 출력 등을 위한 문장들을 작성하여 새로운 메뉴 기능 추가
 *        (특정 단위 값 입력을 위한 메세지 출력 및 입력, 변환 값 계산,  소수 2자리까지로 변환, 
 *         결과 출력 등 4개의 문장이 추가됨 ) 
 *            
 *   o 새로운 메뉴를 추가하거나 삭제하는 좋은 방법이 있는가를 고민해보라.(이것은 과제가 아님)
 *          
 *   o 이를 위해서는 각 메뉴 처리부분을 비교해보면서 공통점과 차이점을 잘 분석하여 좋은 방법을 구상하여야 한다. 
 *      
 *   ( 다음 예제 프로그램에서 정말 놀라운 프로그램이 제시될 것인데, 그 프로그램은 예상하는 것과는 
 *     아주 다르게 작성되어 있으며, 배열을 활용한다.)
 *       
 */
