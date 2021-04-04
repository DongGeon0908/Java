/**
 * [ PrintRectangle_UsingNestedFor ]: 중첩된 for 문 사용하여 직사각형 출력하기    
 *             
 *   o for 문
 *     - 기능: 반복 제어변수 이용하여 반복 회수 제어하는 대표적인 반복문
 *     - 구성: 반복 제어변수 초기화, 반복조건 검사, 제어변수 변경, 반복 문장 등 4 부분
 *     - 수행방법: 반복조건이 true인 동안 반복 수행될 문장을 계속 수행
 *     
 *     - 반복 제어변수 선언: for 문 외부 또는 내부에서 선언 가능
 *     - for 문 외부에서 선언한 반복 제어변수: for 문 내부와 외부에서 사용 가능하며, 
 *                                       for 문이 종료된 후에도 사용 가능함 
 *     - for 문 내부에서 선언한 반복 제어변수: for 문 내에서만 사용 가능 
 *      
 *   o 중첩된 for 문
 *     - for 문 내에 또다시 for 문 나타남
 *     - 2개 이상의 반복 제어변수가 사용되어 반복 회수 많아지면 작업 복잡해짐 
 *     
 *     - 중첩 유형
 *       (1) 내부 반복문에서 외부 반복 제어변수 사용하지 않는 경우
 *           내부 반복문이 외부 반복문에 영향 받지 않고 수행, 덜 복잡 
 *            
 *       (2) 내부 반복문에서 외부 반복 제어변수 사용하는 경우
 *           내부 반복문이 외부 반복문에 영향 받으며 수행, 다소 복잡함
 */

class Ex4_3_06_PrintRectangle_UsingNestedFor {
	public static void main(String[] args)  {
		System.out.println("\n\n  << '*'로 그린 가로 10, 세로 5인 직사각형  >> \n");
		 
		for (int h = 0; h < 5; h++) {     // 외부 for 문: 1번 세로줄부터 5번 세로줄까지 반복
	         System.out.print("  ");      //   각 라인의 처음에 공백문자 2개 출력

		     for (int w = 0; w < 10; w++) //   내부 for 문: 가로 크기만큼 * 출력 
		    	 System.out.print('*'); 

		     System.out.println();        //   줄바꿈
		} 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 '*'로 가로 10, 세로 5인 직사각형 출력한다.
 *      - 내부 for 문에서 외부 for 문의 제어변수 사용하지 않으므로 덜 복잡한 형태의 중첩 for 문
 *      - 총 반복회수 = 외부 for 문 반복회수 * 내부 for 문 반복회수 = 5 * 10 = 50 
 *   
 *   2) 프로그램 실행하여 결과 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 *   
 *   1) 가로 크기 30, 세로 크기 100의 직사각형을 그리도록 프로그램을 수정하고 실행하여 결과 확인하라. 
 *   
 *   2) 내부 for 문에서 출력되는 '*'를 반복 제어변수 w로 변경한 후 실행하여 결과 확인하라.
 */
