package example12_1_temperature_conversion;

/**
 * [ DegreeConversion1_TextBased ]: 텍스트 기반의 입출력을 보이는, 화씨온도를 섭씨온도로 변환하여 출력하는 프로그램
 *        
 *     o 온도 체계
 *       1) 섭씨온도(단위 C): 어는 온도: 0, 끓는 온도: 100 (100 등분시킨 온도체계)
 *       2) 화씨온도(단위 F): 어는 온도: 32, 끓는 온도: 212 (180 등분시킨 온도체계)
 *       3) 캘빈(Kelvin)온도(단위 K): -273.15C를 0K로 설정, 캘빈온도 0K 이하의 온도가 없는 
 *                                 물리학에서 사용하는 절대 온도체계
 *       
 *     o 화씨온도에서 섭씨온도로의 변환
 *       C = (F - 32) * 5 / 9;
 */

class TemperatureConversion1_TextBased  {
	public static void main(String[] args)  {
		double F, C;   // 화씨온도와 섭씨온도 저장할 변수

		System.out.println("\n  ** Conversion of Fahrenheit to Centigrade **");		

		while(true) {
			System.out.print("\n  o Input Fahrenheit degree > ");
			F = SkScanner.getDouble();		
			C = (F - 32) * 5 / 9;
			System.out.println("  * " + F + "F = " + C + "C");
		}		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *             
 *   2) 프로그램을 수행하고 결과를 확인하라라.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력하는 텍스트 기반의 프로그램이다.
 *      반대로 섭씨온도를 입력하여 화씨온도로 변환하여 출력하는 프로그램을 
 *      TemperatureConversion_TextBased1_CtoF 클래스로 작성하라. 
 *      (섭씨온도 C를 화씨온도 F로 변환하는 공식은 F = C * 9 / 5  + 32 임)
 *   
 *   2) 이 프로그램은 화씨온도를 섭씨온도로 변환하여 출력한다. 화씨온도를 캘빈 온도로 
 *      변환하여 출력하는 프로그램을 TemperatureConversion1_TextBased_FtoK 클래스로 작성하라.  
 *      (섭씨온도 C를 캘빈온도 K로 변환하는 공식은 K = C + 273.15이며, 
 *       화씨온도에서 섭씨온도를 구한 후 다시 섭씨온도에서 캘빈온도를 구해 출력하면 됨) 
 */
