package ex05_baseball_players;


class Ex6_1_Player_UsingClass { 
	static final int MAXNOPLAYS = 100;  // 최대 저장 가능한 기록 개수

	String playerName;  // 선수 이름
	String teamName;    // 팀명
	
	int noPlays;        // 경기 수
	
	int recordsAtBat[] = new int[MAXNOPLAYS]; 
	int recordsHits[] = new int[MAXNOPLAYS];  
	int sumRecordAtBat = 0 ;
	int sumRecordHits = 0;
	double avgHitsRatio;

	// 프로그램의 타이틀 출력
	void outputTitle() {
		System.out.println("\n  ****  야구선수 정보 및 타수와 안타 기록 관리(클래스의 객체 사용) ****\n"); 
	}
	
	// 선수의 이름과 팀명 입력하여 저장하는 메소드
	void getPalyernameTeam() {   
		System.out.println("\n  **  야구선수 정보 입력 **\n"); 
		System.out.print("  o 야구선수 이름 > ");  
		playerName = SkScanner.getString();     // 필드는 바로 사용 가능   
		System.out.print("  o 소속 팀 이름 > ");  
		teamName = SkScanner.getString();       // 필드는 바로 사용 가능   
    }
    
	// 선수의 타수와 안타 기록 입력하여 저장하는 메소드
    void getPalyrRecords(int no) {
    	noPlays = no;
    	
		System.out.println("\n  **  " +  noPlays + " 경기에서의 타수와 안타 기록 입력 **\n");  

		for (int i=0; i < noPlays; i++) {
			System.out.println("\n  * " + (i + 1) + "번째 경기의 타수 기록과 안타 기록  입력 * ");                     
			recordsAtBat[i] = SkScanner.getIntWithPrompt("  o 타수 기록 > "); 
			recordsHits[i] = SkScanner.getIntWithPrompt("  o 안타 기록 > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[i] ;
			sumRecordHits = sumRecordHits + recordsHits[i];
		}

		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;
    }
    
    void outputPlayerRecords() { // 선수의 기록 출력\  
		System.out.println("\n\n  ** 야구선수 정보 출력 **\n");            
		System.out.println("  * 선수 이름: " + playerName);  
		System.out.println("  * 소속 팀명: " + teamName);    
		System.out.println();
		
		for (int i=0; i < noPlays; i++) {
			System.out.println("  * " + (i + 1) + "번째 경기: " + recordsAtBat[i] + "타수  " + recordsHits[i] + "안타");  
		}

		System.out.println("\n  * 총 타석수: " + sumRecordAtBat + ", 총 안타수: " + sumRecordHits + ", 평균 안타율: " + avgHitsRatio);  
    }

    
	public static void main(String[] args) {
		Ex6_1_Player_UsingClass aPlayer = new Ex6_1_Player_UsingClass();
				
		aPlayer.outputTitle();         // 프로그램 타이틀 출력
		aPlayer.getPalyernameTeam();   // 선수의 이름과 팀명 입력
		aPlayer.getPalyrRecords(5);    // 5 경기에서의 선수 기록 입력
		aPlayer.outputPlayerRecords(); // 선수의 기록 출력
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 이 프로그램은 main() 메소드에서 Ex6_1_Player_UsingClass 클래스의 객체를 생성하여 그 객체의 여러 메소드를 호출한다.
*
*   2) Ex6_1_Player_UsingClass 클래스의 필드와 메소드의 기능을 이해하고 메소드의 구현부분을 파악하라.
*      특히, 메소드 외부에 저장된 static 변수를 static 메소드 내에서 자유롭게 사용할 수 잇음을 반드시 확인하라.
*   
*   3) 프로그램을 실행하여 선수 정보와 5 경기의 타수 기록과 안타 기록을 입력하고 결과를 확인하라.
*
*
* [ 실습과제 ]
*
*   1) 지난 5일 동안 본인의 대중교통 이용 내역을 입력하여 대중교통 이용시간의 합과 이용요금의 합을 
*      구해 출력하는 프로그램을 Pr5_1_PublicTransfotation_InOut_UsingMethod 클래스로 작성하라.
*
*       (1) 대중교통의 종류(pubTransType: 버스, 지하철, 택시, 비행기), 출발지(startingPoint), 
*           목적지(destination), 이용시간(miniteTaken), 이용요금(feeTrans) 등을 이용회수만큼 
*            저장할 수 있는 static 배열 변수를 각각 선언하고 배열객체를 생성하여 저장하라.
* 			
*       (2) 대중교통 이용시간의 합과 이용요금의 합을 저자장할 static 변수를 선언하라..
*       
*       (3) 주어진 이용회수 no의 대중교통 이용내역 항목들을 입력하여 배열변수들에 저장하는 static void inputPubTrans(int no) 메소드,
*           대중교통 이용시간의 합과 이용요금의 합을 구하여 해당 변수에 저장하는  static void getTransTimeFee() 메소드, 
*           대중교통 이용시간의 합과 이용요금의 합을 출력하는   static void outputTransTimeFee() 메소드를 작성하라.
* 
*       (3) main() 메소드에서 이들 메소드를 호출하여 데이터를 입력하고 수행결과를 확인하라..
*
*       (4) 이용회수는 5회 이상으로 하여야 한다. 
*
*/
