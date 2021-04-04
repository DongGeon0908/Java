package ex05_baseball_players;

class Ex7_1_Player_UsingSubclass { 
	public static void main(String[] args) {
		Hitter aHitter = new Hitter();
		
		aHitter.getPalyernameTeam();   // 선수의 이름과 팀명 입력
				
		aHitter.outputTitle();         // 프로그램 타이틀 출력
		aHitter.getPalyerRecords(3);    // 3 경기에서의 선수 기록 입력
		aHitter.getPalyerRecords(2);    // 2 경기에서의 선수 기록 입력

		aHitter.outputPlayerRecords(); // 선수의 기록 출력
	}
}

// 야구선수를 위한 클래스
abstract class Player {
	static final int MAXNOPLAYS = 100;  // 최대 저장 가능한 기록 개수

	String playerName;  // 선수 이름
	String teamName;    // 팀명
	
	int noPlays;        // 경기 수
	
	// 선수의 이름과 팀명 입력하여 저장하는 메소드
	void getPalyernameTeam() {   
		System.out.println("\n  **  야구선수 정보 입력 **\n"); 
		
		System.out.print("  o 야구선수 이름 > ");  
		playerName = SkScanner.getString();     // 필드는 바로 사용 가능   
		
		System.out.print("  o 소속 팀 이름 > ");  
		teamName = SkScanner.getString();       // 필드는 바로 사용 가능   
    }
    
	// 선수의 경기 기록 입력하여 저장하는 abstract 메소드
	abstract void getPalyerRecords(int no); 
	
	void outputPlayerRecords() { // 선수의 기록 출력\  
		System.out.println("\n\n  ** 야구선수 정보 출력 **\n");            
		System.out.println("  * 선수 이름: " + playerName);  
		System.out.println("  * 소속 팀명: " + teamName);    
		System.out.println("  * 총 경기 수: " + noPlays);    
		System.out.println();
	}
	
	// 프로그램의 타이틀 출력
	void outputTitle() {
		System.out.println("\n  ****  " + playerName + " 선수 정보 및 기록 관리(하위 클래스의 객체 사용) ****\n"); 
	}  
}

class Hitter extends Player {	
	int recordsAtBat[] = new int[MAXNOPLAYS]; 
	int recordsHits[] = new int[MAXNOPLAYS];  
	int sumRecordAtBat = 0 ;
	int sumRecordHits = 0;
	double avgHitsRatio;


	// 선수의  no 회수의 경기 기록 입력하여 저장하는 abstract 메소드
	void getPalyerRecords(int no) {	    	
		System.out.println("\n  **  " +  no + " 경기에서의 타수와 안타 기록 입력 **");  

		for (int i=0; i < no; i++) {
			System.out.println("\n  * " + (i + 1) + "번째 경기의 타수 기록과 안타 기록  입력 * ");                     
			recordsAtBat[noPlays + i] = SkScanner.getIntWithPrompt("  o 타수 기록 > "); 
			recordsHits[noPlays + i] = SkScanner.getIntWithPrompt("  o 안타 기록 > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[noPlays + i] ;
			sumRecordHits = sumRecordHits + recordsHits[noPlays + i];
		}

		noPlays = noPlays + no;
		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;
	} 

	
	void outputPlayerRecords() { // 선수의 기록 출력
		super.outputPlayerRecords();
		
		for (int i=0; i < noPlays; i++) {
			System.out.println("  * " + (i + 1) + "번째 경기: " + recordsAtBat[i] + "타수  " + recordsHits[i] + "안타");  
		}

		System.out.println("\n  * 총 타석수: " + sumRecordAtBat + ", 총 안타수: " + sumRecordHits + ", 평균 안타율: " + avgHitsRatio);  
    }
	
	// 선수의 이름과 팀명 입력하여 저장하는 메소드
	void getPalyernameTeam() {   
		System.out.println("\n  **  야구선수 정보 입력 **\n"); 
		System.out.print("  o 야구선수 이름 > ");  
		playerName = SkScanner.getString();     // 필드는 바로 사용 가능   
		System.out.print("  o 소속 팀 이름 > ");  
		teamName = SkScanner.getString();       // 필드는 바로 사용 가능   
    }
}

/*
* [ 프로그램의 이해 및 실행 ]
*
*   1) 이 프로그램은 main() 메소드에서 Hitter 클래스의 객체를 생성하여 그 객체의 여러 메소드를 호출한다.
*
*   2) Hitter 클래스는 abstract 클래스인 Player 클래스의 하위  클래스이다.
*      이들 클래스의 필드와 메소드의 기능을 이해하고 메소드의 구현부분을 파악하라.
*   
*   3) 프로그램을 실행하여 타자  선수 정보와 5 경기의 타수 기록과 안타 기록을 입력하고 결과를 확인하라.
*/
