package ex05_baseball_players;

/*
* [ PlayerRecords__InOut_UsingArray 클래스 ]: 여러 경기에서의 타수 기록과 안타 기록을 입력하여 배열변수에 저장하고 출력하기
*
*   o 프로그래밍 스타일
*     1) main() 메소드로만 클래스 구성
*     2) 배열변수의 선언, For 문장을 이용한 간결한 입력, 저장, 원소 출력
*
*   o 한 야구 타자가 5 경기에서 기록한  타수 기록과 안타 기록을 입력하고 출력함
*     - 타수 기록(record at bat): 한 경기에서 타격 기회를 갖는 타석 회수에서 볼넷, 몸에 맞는볼, 고의사구, 희생타를 제외한 회수
*     - 안타 기록(hits record): 한 경기에서 1루타, 2루타, 3루타, 홈런 등을 친 회수
*     - 3 경기에서 3타수 1안타, 3타수 1안타, 4타수 2안타인 경유 총 타수는 10타수, 총 안타수는 4안타이므로 평균 타율은 0.4임
*     - 타수 기록과 안타 기록은 평균 타율, 출루율 등의 중요 평가 자료를 구할 수 있게 됨
*
*   o 경기 회수만큼의 타수 기록과 안타 기록을 입력하여 배열변수의 원소에 저장
*     -  경기 회수를 나타내는 기호 상수를 정의하여 프로그램의 수정을 쉽게 함
*        final int NOPLAYS = 65;   // 경기 회수를 나타내는 기호 상수, NOPLAYS는 5와 동일함
*
*   o 배열 
*     - 배열변수: 하나의 변수에 여러 개의 값을 저장할 수 있는 변수
*     - 배열변수의 원소: 배열변수에 저장되는 값 하나
*     - 배열변수의 선언: 타입 배열변수[저장할_원소_개수];
*         예: int recordsAtBat[] = new int[NOPLAYS]; // NOPLAYS 회수의 경기에서 기록한 타수들을 저장할 배열변수 선언
*
*     - 입력한 값을 배열 원소에 저장: 배열변수명[인덱스] = SkScanner.getXxx();
*         예: recordsAtBat[0] = SkScanner.getInt();  // 배열 원소의 인덱스는 0부터 시작함
*             recordsAtBat[1] = SkScanner.getInt();
*             recordsAtBat[2] = SkScanner.getInt();
*
*   o 아직 배우진 않았지나만, 나중의 for 문에서 배열을 사용하면 간결하고 스마트한 코드가 작성됨
*
*   o 입력을 위한 메소드
*     - SkScanner 클래스의 getString() 메소드: 엔터키가 입력될 때 까지의 문자열을 입력
*     - SkScanner 클래스의 getInt() 메소드: 정수 값을 입력, 정수가 아닌 것은 모두 무시됨
*/


class Ex3_8_2_PlayerRecords_InOut_UsingArray { 

	public static void main(String[] args) {

		final int NOPLAYS = 65;   // 경기 회수를 나타내는 기호 상수, NOPLAYS는 5와 동일함

		String playerName; // 야구 선수 이름을 저장하는 문자열 변수
		String teamName;   // 야구선수의 소속 팀명을 저장하는 무자열 변수

		int recordsAtBat[] = new int[NOPLAYS]; // NOPLAYS 회수의 경기에서 기록한 타수들을 저장할 배열변수 선언
		int recordsHits[] = new int[NOPLAYS];  // NOPLAYS 회수의 경기에서 기록한 안타들을 저장할 배열변수 선언

		System.out.println("\n  ****  야구선수 정보 및 타수와 안타 기록 관리 **** \n\n");  // 입력을 위한 타이틀 출력

		// 야구선수 정보 입력하여 저장
		System.out.println("\n  **  야구선수 정보 입력 ** \n");  // 입력을 위한 타이틀 출력
		System.out.print("  o 야구선수 이름 > ");  // 프롬프트 메시지 출력
		playerName = SkScanner.getString();        // 문자열 값 입력하여  저장
		System.out.print("  o 소속 팀 이름 > ");   // 프롬프트 메시지 출력
		teamName = SkScanner.getString();          // 문자열 값 입력하여  저장	

		// NOPLAYS번의 경기에서의 타수 기록과 안타 기록을 입력하여 저장
		System.out.println("\n  **  " + NOPLAYS + " 경기에서의 타수와 안타 기록 입력 ** \n");  // 입력을 위한 타이틀 출력
		System.out.print("  o 1번째 경기의 타수 기록과 안타 기록 > ");                     // 프롬프트 메시지 출력
		recordsAtBat[0] = SkScanner.getInt();   // 정수 값 입력하여 각 배열 원소에 차례로 저장
		recordsHits[0] = SkScanner.getInt();

		System.out.print("  o 2번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordsAtBat[1] = SkScanner.getInt();   // 정수 값 입력하여 각 배열 원소에 차례로 저장
		recordsHits[1] = SkScanner.getInt();

		System.out.print("  o 3번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordsAtBat[2] = SkScanner.getInt();   // 정수 값 입력하여 각 배열 원소에 차례로 저장
		recordsHits[2] = SkScanner.getInt();

		System.out.print("  o 4번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordsAtBat[3] = SkScanner.getInt();   // 정수 값 입력하여 각 배열 원소에 차례로 저장
		recordsHits[3] = SkScanner.getInt();

		System.out.print("  o 5번째 경기의 타수 기록과 안타 기록 > ");  // 프롬프트 메시지 출력
		recordsAtBat[4] = SkScanner.getInt();   // 정수 값 입력하여 각 배열 원소에 차례로 저장
		recordsHits[4] = SkScanner.getInt();


		// 야구선수 정보 출력
		System.out.println("\n\n  ** 야구선수 정보 출력 **\n");    // 야구선수 정보 출력을 위한 타이틀 출력
		System.out.println("  * 선수 이름: " + playerName + " \n");  
		System.out.println("  * 소속 팀명: " + teamName + " \n");     

		// 입력된 NOPLAYS번의 경기에서의 타수 기록과 안타 기록 모두 출력
		System.out.println("\n  ** " +NOPLAYS + " 경기에서의 타수와 안타 기록 **\n");             // 출력을 위한 타이틀 출력
		System.out.println("  * 1번째 경기: " + recordsAtBat[0] + "타수  " + recordsHits[0] + "안타");   // 1번째 배열 원소의 인덱스는 1이 아니라 0임
		System.out.println("  * 2번째 경기: " + recordsAtBat[1] + "타수  " + recordsHits[1] + "안타");  
		System.out.println("  * 3번째 경기: " + recordsAtBat[2] + "타수  " + recordsHits[2] + "안타");  
		System.out.println("  * 4번째 경기: " + recordsAtBat[3] + "타수  " + recordsHits[3] + "안타");  
		System.out.println("  * 5번째 경기: " + recordsAtBat[4] + "타수  " + recordsHits[4] + "안타");  // 5번째 배열 원소의 인덱스는 5사 아니라 4임



		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	}
}


/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 이 프로그램은 for 문장을 사용하지 않으므로 프로그램의 작성이 배열변수를 
       사용하지 않은 것과 비슷하다. 그러나 배열을 이해하기 위한 좋은 프로그램이므로 
	   잘 살펴보아야 한다.
*
*   2) 프로그램을 실행하여 선수 정보와 5 경기의 타수 기록과 안타 기록을 입력하고 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 안타 기록의 합을 타수 기록의 합으로 나누면 평균 안타율 기록이다. 
*      타수 기록의 합, 안타 기록의 합, 평균 안타율을 다음과 같이 구한다.
* 
        int sumRecordAtBat = recordAtBat[0] + recordAtBat[1] + recordAtBat[2] +
                             recordAtBat[3] + recordAtBat[4];  
                            
        int sumRecordHits = recordHits[0] + recordHits[1] + recordHits[2] +
                            recordHits[3] + recordHits[4]; 
   
        double avgHitsRatio = sumRecordHits / sumRecordAtBat;
*
*      평균 안타율을 구하여 출력하도록 프로그램을 수정하고 출력 결과를 확인하라. 
*      출력 결과에 문제가 없는가? 문제가 있으면 그 원인이 무엇인지를 알아보라. 
*
*   2) 10 경기에서의 타수 기록과 안타 기록을 저장할 배열변수를 선언한 후 기록을 입력하여 저장하고 
*      출력하는 프로그램을 Pr3_8_2_PlayerRecords10_InOut_UsingArray 클래스 파일로 작성하라.
*
*   3) 지난 5일 동안 본인의 대중교통 이용 내역을 입력하여 대중교통 이용시간의 합과 이용요금의 합을 
*      구해 출력하는 프로그램을 Pr3_8_2_PublicTransfotation_InOut_UsingArray 클래스로 작성하라.
*
*       (1) 대중교통의 종류(pubTransType: 버스, 지하철, 택시, 비행기), 출발지(startingPoint), 
*           목적지(destination), 이용시간(miniteTaken), 이용요금(feeTrans) 등을 이용회수만큼 
*            저장할 수 있는 배열 변수를 선언하라.
* 			
*       (2) 선언한 각 배열변수의 원소에 대중교통 이용내역 항목들을 입력하는 문장들을 작성하라.
* 
*       (3) 대중교통 이용시간의 합과 이용요금의 합을 구하여 변수에 저장하라.
*
*       (4) 입력한 정보와 구한 대중교통 이용시간의 합과 이용요금의 합을 출력하는 문장들을 작성하라. 
* 
*       (5) 이용회수는 5회 이상으로 작성해야 한다. 
*
*/
