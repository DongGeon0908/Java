package ex09_draw_diamond;
/*
 * [ PrintDiamond_Width9 ]: 폭이 9인 다이아몬드 모양 출력하기
 *  
 *    o 스타일 1: 반복문 사용하지 않고서 각 라인의 문자열을 출력하기
 *     
 *    o 다이아몬드 그리기 방법
 *      - 다이아몬드는 증가 부분과 감소 부분으로 나누어짐
 *      - 다이아몬드 폭이 9이면 처음 라인은 blank 4개(폭인 9를 2로 나눈 몫), * 1개임
 *      - 증가 부분에서는 blank 1개씩 감소, * 2개씩 증가함
 *      -  blank가 0개가 되면 다음 라인부터 감소부분임
 *      - 감소 부분에서는 blank 1개씩 증가, * 2개씩 감소함       
 */

class Ex4_1_PrintDiamond_Width9 {
	public static void main(String[] args) {
		System.out.print("\n  **** Print diamond of width 9 (style 1) ****\n\n");

		System.out.println("    *");     // blank 4개, *를 1개 출력
		System.out.println("   ***");    // blank 3개, *를 3개 출력
		System.out.println("  *****");   // blank 2개, *를 5개 출력
		System.out.println(" *******");  // blank 1개, *를 7개 출력
		System.out.println("*********"); // blank 0개, *를 9개 출력
		System.out.println(" *******");  // blank 1개, *를 7개 출력
		System.out.println("  *****");   // blank 2개, *를 5개 출력
		System.out.println("   ***");    // blank 3개, *를 3개 출력
		System.out.println("    *");     // blank 4개, *를 1개 출력
	}
}  

/*
 *  [ 실습과제 ]
 *  
 *    1) 이 프로그램은 폭이 9인 다이아몬드를 그려준다. 이 프로그램 스타일로 
 *       폭이 15인 다이아몬드를 그리는 프로그램을 Pr4_1_PrintDiamond_Width15로 
 *       작성하라. 
 *       
 *    2) 이 프로그램 스타일로 폭이 121인 다이아몬드 또는 폭이 1221인 다이아몬드를 
 *       프로그램을 작성할 수 있다면 작성해보라. 이 역시 할 수는 있지만 엄청 
 *       수고스러운 작업이 될 것이다. 
 *       
 *       
 *  [ 스스로 생각하고 고민해볼 과제 ]
 *  
 *    1) 프로그램이 특정한 작업만을 수행할 경우 프로그램의 효용성이 작다. 
 *       이 프로그램도 효용성이 아주 작은 프로그램이다. 이 프로그램이 
 *       효용성이 작은 이류에 대해 생각해보라.
 *    2) 다이아몬드 폭을 변경하기도 어렵지만 * 대신에 $나 %로 다이아몬드를 
 *       그릴 경우 얼마나 많은 노력이 들 것인지 생각해보라. 
 *       
 *    3) 이 프로그램도 유사한 문장들이 반복되므로 이를 통합하여 반복문으로 변경할 수 있다.
 *       유사한 부분과 변경되는 규칙을 살펴 반복으로 변환할 수 있으면 스스로 해 보라.
 *       
 *      변환된 프로그램은 다음과 같다.
 *      
 *   ***********************************************************
    	String[] linesDiamond = { 
    	        "    *",       // blank 4개, *를 1개인 문자열
                "   ***",      // blank 3개, *를 3개인 문자열
                "  *****",     // blank 2개, *를 5개인 문자열
                " *******",    // blank 1개, *를 7개인 문자열
                "*********"    // blank 0개, *를 9개인 문자열
        };
    	
    	for (int i=0; i <=4; i++)
    		System.out.println( linesDiamond[i]);

    	for (int i=3; i >=0; i--)
    		System.out.println( linesDiamond[i]);
 *   *************************************************************   	                   
		
 */
