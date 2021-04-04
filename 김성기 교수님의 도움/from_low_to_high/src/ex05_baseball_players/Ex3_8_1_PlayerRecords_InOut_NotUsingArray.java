package ex05_baseball_players;

/*
* [ PlayerRecords_InOut_NotUsingArray 클래스 ]: 배열변수 이용 않고서 여러 경기에서의 타수 기록과 안타 기록을 입력하여 저장하고 출력하기
*
*   o 프로그래밍 스타일
*     1) main() 메소드로만 구성
*     2) 10개의 단순변수 선언, 입력하여 변수에 저장, 출력
*
*   o 한 야구 타자가 5 경기에서 기록한  타수 기록과 안타 기록을 입력하고 출력함
*     - 타수 기록(record at bat): 한 경기에서 타격 기회를 갖는 타석 회수에서 볼넷, 몸에 맞는볼, 고의사구, 희생타를 제외한 회수
*     - 안타 기록(hits record): 한 경기에서 1루타, 2루타, 3루타, 홈런 등을 친 회수
*     - 3 경기에서 3타수 1안타, 3타수 1안타, 4타수 2안타인 경유 총 타수는 10타수, 총 안타수는 4안타이므로 평균 타율은 0.4임
*     - 타수 기록과 안타 기록은 평균 타율, 출루율 등의 중요 평가 자료를 구할 수 있게 됨
*
*   o 입력을 위한 메소드
*     - SkScanner 클래스의 getString() 메소드: 엔터키가 입력될 때 까지의 문자열을 입력
*     - SkScanner 클래스의 getInt() 메소드: 정수 값을 입력, 정수가 아닌 것은 모두 무시됨
*/


class Ex3_8_1_PlayerRecords_InOut_NotUsingArray { 
	public static void main(String [] args) {

		String playerName; // 야구 선수 이름을 저장하는 문자열 변수
		String teamName;   // 야구선수의 소속 팀명을 저장하는 무자열 변수

		// 5번 경기에서의 타수 기록과 안타 기록을 저장할 단순변수 선언
		int recordAtBat1, recordAtBat2, recordAtBat3, recordAtBat4, recordAtBat5; // 5번의 타수 기록을 저장할 변수
		int recordHits1, recordHits2, recordHits3, recordHits4, recordHits5;  // 5번의 안타 기록을 저장할 변수

		System.out.println("\n  ****  야구선수 정보 및 타수와 안타 기록 관리 **** \n");  // 입력을 위한 타이틀 출력

		// 야구선수 정보 입력하여 저장
		System.out.println("\n  **  야구선수 정보 입력 ** \n");  // 입력을 위한 타이틀 출력
		System.out.print("  o 야구선수 이름 > ");  // 프롬프트 메시지 출력
		playerName = SkScanner.getString();        // 문자열 값 입력하여 저장
		System.out.print("  o 소속 팀 이름 > ");   // 프롬프트 메시지 출력
		teamName = SkScanner.getString();          // 문자열 값 입력하여 저장

		// 5번의 경기에서의 타수 기록과 안타 기록을 입력하여 저장
		System.out.println("\n  **  5 경기에서의 타수와 안타 기록 입력 ** \n"); // 입력을 위한 타이틀 출력
		System.out.print("  o 1번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordAtBat1 = SkScanner.getInt();    // 정수 값 입력하여 각 변수에 차례로 저장
		recordHits1 = SkScanner.getInt();

		System.out.print("  o 2번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordAtBat2 = SkScanner.getInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		recordHits2 = SkScanner.getInt();

		System.out.print("  o 3번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordAtBat3 = SkScanner.getInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		recordHits3 = SkScanner.getInt();

		System.out.print("  o 4번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordAtBat4 = SkScanner.getInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		recordHits4 = SkScanner.getInt();

		System.out.print("  o 5번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordAtBat5 = SkScanner.getInt();   // 정수 값 입력하여 각 변수에 차례로 저장
		recordHits5 = SkScanner.getInt();

		// 야구선수 정보 출력
		System.out.println("\n\n  ** 야구선수 정보 출력 **\n");  // 야구선수 정보 출력을 위한 타이틀 출력
		System.out.println("  * 선수 이름: " + playerName); 
		System.out.println("  * 소속 팀명: " + teamName);   

		// 입력된 5번의 경기에서의 타수 기록과 안타 기록 모두 출력
		System.out.println("\n  ** 5 경기에서의 타수와 안타 기록 **\n");   // 출력을 위한 타이틀 출력
		System.out.println("  * 1번째 경기: " + recordAtBat1 + "타수  " + recordHits1 + "안타");   
		System.out.println("  * 2번째 경기: " + recordAtBat2 + "타수  " + recordHits2 + "안타"); 
		System.out.println("  * 3번째 경기: " + recordAtBat3 + "타수  " + recordHits3 + "안타"); 
		System.out.println("  * 4번째 경기: " + recordAtBat4 + "타수  " + recordHits4 + "안타"); 
		System.out.println("  * 5번째 경기: " + recordAtBat5 + "타수  " + recordHits5 + "안타"); 
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임

	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
*
*     - PlayerRecords_InOut_NotUsingArray 클래스 파일에 main() 메소드가 작성되어 있다.
*
*     - main() 메소드는 단순변수 선언 및 변수에 값 입력하여 저장, 변수의 출력 
*       등을 수행하는 여러 문장들로 구성되어 있다.
*
*   2) 프로그램을 실행하여 한국 프로야구팀에서 유명한 선수 한명의 정보를 인터넷에서 탐색하여 
*      선수 정보와 5 경기의 타수 기록과 안타 기록들을 입력하고 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 안타 기록의 합을 타수 기록의 합으로 나누면 평균 안타율 기록이다. 
*      타수 기록의 합, 안타 기록의 합, 평균 안타율을 다음과 같이 구한다.
* 
        int sumRecordAtBat = recordAtBat1 + recordAtBat2 + recordAtBat3 +
                           recordAtBat4 + recordAtBat5; 
                            
        int sumRecordHits = recordHits1 + recordHits2 + recordHits3 +
                            recordHits4 + recordHits5; 
   
        double avgHitsRatio = sumRecordHits / sumRecordAtBat;
*
*      평균 안타율을 구하여 출력하도록 프로그램을 수정하고 출력 결과를 확인하라. 
*      출력 결과에  문제가 없는가? 문제가 있으면 그 원인이 무엇인지를 알아보라. 
*  
*   2) 10 경기에서의 타수 기록과 안타 기록을 저장할 단순변수를 선언한 후 기록을 입력하여 저장한 후 출력하고
*      평균 안타율 기록을 출력하는 프로그램을 Pr3_8_1_PlayerRecords10_InOut_NotUsingArray 클래스로 작성하라.
*
*   3) 한국 프로야구의 경우 2015년 1년동안 구단당 144경기를 치루었다. 이 프로그램의 스타일대로 
*      144 경기 모두 출전한 프로야구 선수의 경기 기록을 모두 입력하여 출력하고
*      평균 안타율 기록을 출력하기 위한 프로그램의 문장 개수를 계산하라.
*       
*   4) 144 경기 작기 기록을 모두 입력하여 출력하고 평균 안타율 기록을 출력하는 
*      프로그램을 이 프로그램의 스타일대로 작성할 수 있는 학생은 본인이 직접 작성해보라. 
*
*      직접 작성하는 학생에게는 교수가 본인 작성 여부를 확인한 후 
*      가산점을 부여할 것이다.
*
*
* [ 참고사항 ]
*
*   1) 실습과제를 할 때에는 주어진 프로그래밍 스타일을 이용하여 프로그램을 작성하여야 한다.
*
*  
* [ 스스로 생각하고 고민할 과제 ]
*
*   1) 여러 경기에서의 타수 기록과 안타 기록은 평균 타율, 출루율 등의 자료를 구하는 기본자료가 된다.
*      야구에서의 중요한 기록이 무엇이 있는지를 조사해보라.
*
*   2) 전문 프로그래머는 프로그램을 개발할 분야에 대한 전문직인 지식을 가져야 한한다. 예를 들어, 금융 프로그램을 
*      개발하는 경우 금융에 대한 많은 지식을 필요로 한다. 그러므로 특정 분야의 전문 프로그래머가 되려면
*      그 분야의 전문지식도 함께 배우고 익혀야 한다. 
*
*      본인이 프로그래밍하고 싶은 분야가 있는지를 생각해보라.
*      그리고 그 분야의 전문적인 지식을 습득하기 위해 무엇을 해야할 것인지를 고민해보라.
*
*/
