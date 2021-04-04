package ex12_more;
/*
 *  PrintDiamond_Width9_UsingFor: 폭이 9인 다이아몬드 모양 출력하기
 *    o 스타일 2: 반복문 사용하여 각 라인의 blank와 *를 필요한 개수만큼 출력하기
 *     
 *    o 다이아몬드 그리기 방법
 *      - 다이아몬드는 증가 부분과 감소 부분으로 나누어짐
 *      - 다이아몬드 폭이 9이면 처음 라인은 blank 4개(폭인 9를 2로 나눈 몫), * 1개임
 *      - 증가 부분에서는 blank 1개씩 감소, * 2개씩 증가함
 *      -  blank가 0개가 되면 다음 라인부터 감소 부분임
 *      - 감소 부분에서는 blank 1개씩 증가, * 2개씩 감소함  
 */

class Ex4_08_2_PrintDiamond_Width9_UsingFor {
	public static void main(String[] args) {
	    System.out.print("\n  **** Print diamond of width 9 (style 2)****\n\n");

	    int i;
			
	    // 출력할 *가 증가하는 부분: * 2개씩 증가, blank 1개씩 감소
	    for (i = 0; i < 4; i++) System.out.print(' ');  // blank를 4개 출력
	    for (i = 0; i < 1; i++)  System.out.print('*'); // *를 1개 출력
	    System.out.println();
	    
	    for (i = 0; i < 3; i++) System.out.print(' ');  // blank를 3개 출력
	    for (i = 0; i < 3; i++)  System.out.print('*'); // *를 3개 출력
	    System.out.println();
	       
	    for (i = 0; i < 2; i++) System.out.print(' ');  // blank를 2개 출력
	    for (i = 0; i < 5; i++)  System.out.print('*'); // *를 5개 출력
	    System.out.println();
	       
	    for (i = 0; i < 1; i++) System.out.print(' ');  // blank를 1개 출력
	    for (i = 0; i < 7; i++)  System.out.print('*'); // *를 7개 출력
	    System.out.println();
	       	
	    for (i = 0; i < 0; i++) System.out.print(' ');  // blank를 0개 출력
	    for (i = 0; i < 9; i++)  System.out.print('*'); // *를 9개 출력
	    System.out.println();
	       	
	    // 출력할 *가 감소하는 부분: * 2개씩 감소, blank 1개씩 증가
	    for (i = 0; i < 1; i++) System.out.print(' ');  // blank를 1개 출력
	    for (i = 0; i < 7; i++)  System.out.print('*'); // *를 7개 출력
	    System.out.println();
	       	
	    for (i = 0; i < 2; i++) System.out.print(' ');  // blank를 2개 출력
	    for (i = 0; i < 5; i++)  System.out.print('*'); // *를 5개 출력
	    System.out.println();
	       
	    for (i = 0; i < 3; i++) System.out.print(' ');  // blank를 3개 출력
	    for (i = 0; i < 3; i++)  System.out.print('*'); // *를 3개 출력
	    System.out.println();
	       
	    for (i = 0; i < 4; i++) System.out.print(' ');  // blank를 4개 출력
	    for (i = 0; i < 1; i++)  System.out.print('*'); // *를 1개 출력
	    System.out.println();	
	}
}  

/*
 * [ 프로그램의 이해 및 실행 ]
 *  
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용를 파악하라.     
 *       
 *   2) * 대신 $로 다이아몬드를 그리도록 프로그램을 수정하라.
 * 
 *  
 *  [ 실습과제 ]
 *    1) 이 프로그램은 폭이 9인 다이아몬드를 그려준다. 이 프로그램 스타일로 
 *       폭이 15인 다이아몬드를 그리는 프로그램을 Pr4_8_2_PrintDiamond_Width15_UsingFor로 
 *       작성하라. 
 *       
 *    2) 이 프로그램 스타일로 폭이 121인 다이아몬드 또는 폭이 1221인 다이아몬드를 
 *       프로그램을 작성할 수 있다면 작성해보라. 이 역시 할 수는 있지만 엄청 
 *       수고스러운 작업이 될 것이다. 
 *       
 *    3) 이 프로그램은 *로 다이아몬드를 그린다. $ 또는 % 등의 다른 문자로 
 *       그리도록 변경하기 위한 방안을 모색하여 프로그램을 수정하라.
 *
 *
 *  [ 스스로 생각하고 고민해볼 과제 ]
 *    
 *    1) 이 프로그램은 3개의 문장이 다이아몬드 한 라인을 그리는 작업을 수행한다
 *       3개의 문장은 유사성과 규칙성을 가지고 있다. 규칙성에 대해 파악하라.
 *       
 *    2) 유사성과 규칙성을 가지는 문장은 반복문을 통해 간결하게 변환될 수 있다.
 *       이 프로그램을 간결하게 바꿀 수 있는 방안을 강구해보라.
 *        
 *    3) 다음은 유사한 문장들을 for 문을 이용하여 간결하게 뵨환하는 원리를 설명한다.
 *       a), b), c)와 같이 완전히 동일하지 않은 유사한 문장들을 a"), b"), c")와 같이
 *       하나의 for 문으로 통합하기 위해서는 a'), b'), c')와 같은 변환된 중간 과정이 필요하다.
  *        
 *       a)      ===========> a') int i = 1;     ===========>  a")  for (int i = 1; i <= 3; i++) 
 *        sum = sum + 1;          sum = sum + i;  i++;                  sum = sum + i;
 *        sum = sum + 2;          sum = sum + i;  i++; 
 *        sum = sum + 3;          sum = sum + i;  i++;
 *        (각 문장의 값이 1, 2, 3으로 1씩 증가함)
 *     
 *       b)     ===========>  b') int i = 7;     ===========>  b")  for (int i = 7; i <= 11; i=i+2) 
 *        sum = sum + 7;          sum = sum + i;  i=i+2;                sum = sum + i;
 *        sum = sum + 9;          sum = sum + i;  i=i+2; 
 *        sum = sum + 11;         sum = sum + i;  i=i+2;
 *        (각 문장의 값이 7, 9, 11로 2씩 증가함)
 *                                                                  
 *       c)    ===========>  c')  int i = 0;     ===========>  c")  int sum[] = { no0, no1, no2 };
 *        sum = sum + no0;        sum = sum + no[i];  i++;              
 *        sum = sum + no1;        sum = sum + no[i];  i++;          for (int i = 0; i < 3; i++) 
 *        sum = sum + no2;        sum = sum + no[i];  i++;               sum = sum + no[i];
 *        (각 문장의 값이 규칙성이 없는 경우 배열에 저장한 후 배열원소를 차례로 더해줌)
 *        
 *        여러 문장들이 완전히 동일하지 않지만 아주 유사하거나 규칙적으로 변할 경우 
 *        반복문을 사용하기 위하여 통합된 문장으로 작성하는 원리에 대해 고민해 보라. 
 */
