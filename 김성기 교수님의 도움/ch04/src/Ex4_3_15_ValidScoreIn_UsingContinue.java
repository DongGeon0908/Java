/**
 * [ ValidScoreIn_UsingContinue ]: 
 *        continue 문을 이용하여 1부터의 100 사이의 올바른 첫번째 점수 입력하기   
 *            
 *   o while 문
 *     - while(반복조건)
 *	              반복_수행할_문장
 *	              
 *     - 반복조건이 true인 동안 반복_수행할_문장 반복     
 *      
 *   o break 문  
 *     - 반복문 내에서 반복 문장 수행하지 않고서 반복 벗어나게 함 
 *     
 *   o continue 문  
 *     - 반복문 내에서 남은 반복 문장 수행하지 않고서 새로운 반복을 계속하게 함         
 */

class Ex4_3_15_ValidScoreIn_UsingContinue {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1부터의 100 사이 올바른 점수 입력하기 **\n");

		int score;

		// 0부터 100 사이 점수가 입력될 때까지 반복하여 유효한 점수만 입력하게 함
		while(true) {
			score = SkScanner.getIntWithPrompt("  o 0부터 100 사이 점수 > ");

			if (score < 0 || score > 100)  {   // 잘못된 점수가 입력된 경우 
				System.out.println("  ?? 입력 오류, 잘못된 점수: " + score + "\n"); 
				continue;                      //   나머지 반복 부분을 무시하고 반복을 새로이 시작하게 함
			}

			break;                             // 올바른 점수 입력 시 무한 반복 벗어남
		}

		System.out.println("  * 입력된 올바른 점수: " + score);
	}
}


/*
 * 
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) continue 문의 예를 보인다.
 *     - 잘못된 점수 입력한 경우 입력된 점수 무시하고서  다시 점수 입력하기 위해  
 *       남은 반복 부분(break문)을 무시하고 새로이 반복 진행하게 함
 *                
 *   2) break 문의 예도 보인다.
 *     - 올바른 점수 입력한 경우 while 문 끝내기 위해 break 문 사용
 *   
 *   3) 입력된 score 값에 따른 프로그램의 실행과정을 정확히 이해하라.       
 * 
 * 
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램의 if 문에서 조건을 달리하면 continue 문을 사용하지 않고
 *      break 문만 사용하여 올바른 점수를 입력할 수 있다.
 *      
 *      이 프로그램을 break 문만 사용하는 프로그램으로 변경하라.
 *      (힌트: 0과 100 사이의 점수가 입력되면 while 문을 벗어나고
 *            아니면 오류 메시지를 출력 후 다시 반복하도록 수정)
 *   
 *   2) 이 프로그램은 0부터 100 사이 점수 하나를 입력하여 출력한다.
 *      0부터 100 사이 점수 10개를 입력하여 출력하도록 수정한 프로그램을 
 *      Pr4_3_15_ValidScore10In_UsingContinue 클래스로 작성하라.
 *      (힌트: while 문 외부에 for 문을 작성) 
 */