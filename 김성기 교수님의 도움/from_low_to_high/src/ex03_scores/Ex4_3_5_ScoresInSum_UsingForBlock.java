package ex03_scores;

/*
 *  ScoresInSum_UsingForBlock.java: 배열에 10명의 점수를 입력하면서 합을 구해 출력하기    
 *            
 *    o for 문
 *      - 반복 제어변수를 이용하여 반복 회수를 제어함
 *      - 반복 제어변수는 for 문 외부 또는 내부에서 선언 가능
 *      
 *      - 반복 수행할 문장이 2개 이상인 경우에는 반드시 여러 문장을 블록으로 만들어야 함
 *      - 반복조건이 true인 동안 블록 내의 여러 문장들이 반복 수행됨
 *      
  */

class Ex4_3_5_ScoresInSum_UsingForBlock {
	public static void main(String[] args)  {
		System.out.println("\n  ** 10명의 점수를 입력하면서 합을 구해 출력하기 **\n  ");


		int[] scores = new int[10]; // 10개의 원소 저장할 배열객체를 scores 배열에 저장
		int sum = 0;       // 점수들을 누적시켜 합을 구할때는 반드시 0으로 초기화 해야함

		for (int i = 0; i < 10; i++) {  // 블록 시작
			scores[i] = SkScanner.getIntWithPrompt("  * " + (i + 1) + "번째 점수 > ");
		    sum = sum + scores[i];
		} // 블록 끝
		
		System.out.println("\n  * 10명의 점수 합 = " + sum); 
	}
}


/*
 * 프로그램의 이해 및 실행
 *   
 *   1) 이 프로그램은 오류가 제거되어 정상적으로 수행된다.
 *   
 *   2) 프로그램을 실행하여 결과를 확인하라.
 *    
 */
