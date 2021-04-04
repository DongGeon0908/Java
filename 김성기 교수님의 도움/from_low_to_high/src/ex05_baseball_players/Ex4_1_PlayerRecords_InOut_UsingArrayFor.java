package ex05_baseball_players;


class Ex4_1_PlayerRecords_InOut_UsingArrayFor { 
	public static void main(String[] args) {
		int MAXNOPLAYS = 100;  // 최대 저장 가능한 기록 개수

		String playerName;  // 선수 이름
		String teamName;    // 팀명
		
		int noPlays;         // 경기 수
		
		int recordsAtBat[] = new int[MAXNOPLAYS]; 
		int recordsHits[] = new int[MAXNOPLAYS];  
		int sumRecordAtBat = 0 ;
		int sumRecordHits = 0;
		double avgHitsRatio;

		System.out.println("\n  ****  야구선수 정보 및 타수와 안타 기록 관리(배열, for 문 사용) ****\n"); 


		System.out.println("\n  **  야구선수 정보 입력 **\n"); 
		System.out.print("  o 야구선수 이름 > ");  
		playerName = SkScanner.getString();        
		System.out.print("  o 소속 팀 이름 > ");  
		teamName = SkScanner.getString();         


		System.out.println("\n  **  " +  NOPLAYS + " 경기에서의 타수와 안타 기록 입력 **");  

		for (int i=0; i < NOPLAYS; i++) {
			System.out.println("\n  * " + (i + 1) + "번째 경기의 타수 기록과 안타 기록  입력 * ");                     
			recordsAtBat[i] = SkScanner.getIntWithPrompt("  o 타수 기록 > "); 
			recordsHits[i] = SkScanner.getIntWithPrompt("  o 안타 기록 > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[i] ;
			sumRecordHits = sumRecordHits + recordsHits[i];
		}

		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;

		System.out.println("\n\n  ** 야구선수 기록 정보 출력 **\n");            
		System.out.println("  * 선수 이름: " + playerName);  
		System.out.println("  * 소속 팀명: " + teamName);    
		System.out.println();
		
		for (int i=0; i < NOPLAYS; i++) {
			System.out.println("  * " + (i + 1) + "번째 경기: " + recordsAtBat[i] + "타수  " + recordsHits[i] + "안타");  
		}

		System.out.println("\n  * 총 타석수: " + sumRecordAtBat + ", 총 안타수: " + sumRecordHits + ", 평균 안타율: " + avgHitsRatio);  

	}
}
