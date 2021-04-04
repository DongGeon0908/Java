package practice09;

/**
 *  [ 9장 실습과제  2의 기본 프로그램 ]
 *  
 *    2. inputScore() 메소드의 예외 처리 
 *    
 *       Score 클래스는 점수를 저장하는 int score를 필드로 가진다. inputScore() 메소드는 min에서
 *       max 사이 점수를 입력하여 score 필드에 저장하는 메소드이며, 입력된 값이 범위를 벗어나면 
 *       자체적으로 오류 처리를 수행한다. main() 메소드에서 주어진 범위의 입력된 점수를 출력한다.
 *       
 *       더욱 나은 예외 처리를 위하여 다음의 3가지 방법으로 예외 처리를 수행하도록 프로그램을 추가로 작성하라.
 *       
 *       1) Score 클래스에 errorMsg 필드도 선언하라. 입력된 값이 범위를 벗어나면 errorMsg 필드에 
 *          오류 메시지를 저장하고, 입력 값의 오류가 없으면 errorMsg 필드에 null을 저장하고 입력된 점수를 
 *          score 필드에 저장하는 void inputScore1(int min, int max, String prompt) 메소드를 작성하라. 
 *         
 *          main() 메소드에서 이 메소드를 호출하여 errorMsg 필드가 null이 아니면 오류를 처리하고, 
 *          errorMsg 필드가 null이면 입력된 점수를 출력하는 코드를 작성하라. 
 *         
 *       2) 입력된 값이 범위를 벗어나면 Exception 클래스의 예외객체를 생성하여 오류 메시지 
 *          "점수입력 오류: 범위를 벗어난 점수"를 저장한 후 예외객체를 던지고, 입력 값의 오류가 없으면 
 *          입력된 점수를 score 필드에 저장하는 void inputScore2(int min, int max, String prompt) 
 *          메소드를 예외발생 메소드로 작성하라. 
 *         
 *          이 메소드를 호출하는 main() 메소드에서 예외객체를 잡아 예외 처리하는 코드를 작성하라.
 *         
 *       3) 입력된 값이 범위를 벗어나면 ScoreException 클래스의 예외객체를 생성하여 오류 메시지
 *          "점수입력 오류: 범위를 벗어난 점수"를 저장한 후 예외객체를 던지고, 입력 값의 오류가 없으면 입력된 점수를 
 *          score 필드에 저장하는 void inputScore3(int min, int max, String prompt) 메소드를 
 *          예외발생 메소드로 작성하라. 
 *         
 *          이 메소드를 호출하는 main() 메소드에서 예외객체를 잡아 예외 처리하는 코드를 작성하라. 
 *          이를 위해서 ScoreException 클래스도 작성하라
 */

class Score {
	int score;  // 점수를 저장하는 필드

	// min에서 max 사이의 점수를 입력하여 반환하는 메소드
	//    범위를 벗어나는 점수가 입력되면 오류 메시지 출력하고 다시 점수를 입력함
	boolean inputScore(int min, int max, String prompt, String errorMsg) { 
		int score = SkScanner.getInt(prompt); // 프롬프트 메시지 출력 후 정수 입력
		if (score >= min && score <= max) {   // 입력 점수가 min과 max 사이이면 
			this.score = score;                   //   입력 점수를 저장
			return true;
		} else {
			System.out.println(errorMsg);        // 전달된 오류 메시지를 출력
			return false;
		}
	}
}

class Practice9_2_ScoreMain {
	public static void main(String[] args) {
		Score sc = new Score();

		while(true) 
			if (sc.inputScore(0, 100, "\n  o 0과 100 사이 점수 입력 > ", 
					"\n  ??? 잘못된 점수 입력됨"))
				break;

		System.out.println("\n  * 입력된 점수: " + sc.score);
	}  
}


