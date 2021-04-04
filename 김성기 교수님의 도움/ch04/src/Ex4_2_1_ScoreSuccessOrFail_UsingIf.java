/**
 * [ ScoreSuccessOrFail ]: 점수 입력하여 낙제인지 아닌지 판별하여 출력
 *  
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 점수 입력하고 if 문 사용하여 낙제 여부 판단
 *       
 *   o 낙제 판정
 *     - 60점 이상: 낙제 아님
 *     - 60점 미만: 낙제임
 *
 *   o if 문
 *     - 형식: 
 *        if (조건)
 *           조건_true일_때_수행할_문장
 *         else
 *           조건_false일_때_수행할_문장
 *            
 *     - else 부분은 생략 가능
 *      
 *   o if 문 사용하여 낙제 여부 판단하고 결과 출력   
 *    
 *   o SkScanner.getIntWithPrompt(String prompt)
 *     - 입력 프롬프트 메시지 prompt 출력과 정수 입력을 한 문장으로 수행하는 편리한 메소드
 *     - 입력 작업을 훨씬 편하게 하므로 많이 활용할 것
 *     
 *     - System.out.println(" * 점수 입력하시오 > ");
 *       int score = SkScanner.getInt();
 *       
 *       ==(이 두 문장을 한 문장으로 간단히 작성)==> 
 *        
 *          int score = SkScanner.getIntWithPrompt(" * 점수 입력하시오 > ");      
 */

class Ex4_2_1_ScoreSuccessOrFail_UsingIf {
	public static void main(String[] args) {
	    int score  = SkScanner.getIntWithPrompt("\n  o 점수 입력하시오 > ");
		
		boolean isFailed = false;   // 처음에 isFailed를 false로 초기화

		if (score < 60)             // else 없는 if 문:
			isFailed = true;        //   score가 60보다 작으면 isFailed를 true로 저장

		if (isFailed)               // else 있는 if 문: isFailed의 값에 따라
			System.out.println("  * " + score + "점: 낙제 점수임");    // true일 때 수행
		else 
			System.out.println("  * " + score + "점: 낙제 점수 아님"); // false일 때 수행
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램 살펴보고 프로그램의 내용 파악하라.     
 *     
 *   2) 점수 55, 59, 60, 93 입력했을 때의 결과 확인하라.
 *   
 *   3) 처음 boolean 타입 변수에 값을 저장하는 것은 이해하기 어렵다. 
 *      또한 if 문의 조건수식에서 boolean 변수가 사용되는 것도 이해하기 어렵다.
 *      
 *      그러나 반드시 이해해야 하므로 잘 살펴보고 이해하도록 노력해야 한다.
 *      
 *
 * [ 실습과제 ]
 * 
 *   1) 이 프로그램의 처음에 << boolean isFailed = false; >>로 되어 있다. 
 *      이를 << boolean isFailed = true; >>로 변경하고 
 *      이로 인하여 반드시 변경해야할 부분 찾아 변경하라.
 *   
 *   2) 이 프로그램에서 처음에 isFailed를 false로 초기화시키는 작업을 
 *      << boolean isFailed = false; >>에서 수행한다. 
 *      
 *      isFailed 초기화 하지 않을 경우(<< boolean isFailed; >>와 같이 변수만 선언함)
 *      프로그램의 다른 부분 변경해야 한다. 변경할 부분 찾아 변경하라.  
 *
 *   3) 이 프로그램은 2개의 if 문으로 작성되어 있다. 
 *   
 *      그런데 하나의 if 문으로도 동일한 결과 출력하는 프로그램 작성이 가능하다. 
 *      하나의 if 문 사용하는 프로그램으로 변경하라.
 *      
 *   4) 점수가 90점 이상이면 "XX점: 우수 점수임", 아니면 "XX점: 우수 점수 아님"을 출력하도록 프로그램  변경하라.
 *   
 *   5) 체질량 지수 BMI 및 비만 정도 구하는 프로그램을 작성하라.   
 *      
 *      체질량 지수 BMI(body mass index)는 비만도를 나타내는 지수로, 체중과 키의 관계로 계산된다.
 *      체중이 w 킬로그램, 키가 h 미터일 때, BMI = w / (h * h)이다. 
 *      (키의 단위가 센티미터가 아닌 미터임에 유의해야 한다.)
 *      
 *      우리나라에서는 BMI가 18.5 미만이면 저체중, 18.5에서 23 미만은 정상, 
 *      23에서 25 미만이면 과체중, 25에서 30 미만은 1단계 비만(경도 비만), 
 *      30에서 35 미만은 2단계 비만(중등도 비만), 35 이상이면 고도비만으로 분류한다. 
 *      
 *      몸무게와 키 저장할 변수 선언하고 몸무게와 키 입력받아 BMI 계산하고 
 *      BMI와 BMI에 따른 비만 정도 출력하는 프로그램을 Pr4_2_1_BMI 클래스로 작성하라.       
 */
