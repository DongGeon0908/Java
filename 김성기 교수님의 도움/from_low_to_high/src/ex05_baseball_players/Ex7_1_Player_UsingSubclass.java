package ex05_baseball_players;

class Ex7_1_Player_UsingSubclass { 
	public static void main(String[] args) {
		Hitter aHitter = new Hitter();
		
		aHitter.getPalyernameTeam();   // ������ �̸��� ���� �Է�
				
		aHitter.outputTitle();         // ���α׷� Ÿ��Ʋ ���
		aHitter.getPalyerRecords(3);    // 3 ��⿡���� ���� ��� �Է�
		aHitter.getPalyerRecords(2);    // 2 ��⿡���� ���� ��� �Է�

		aHitter.outputPlayerRecords(); // ������ ��� ���
	}
}

// �߱������� ���� Ŭ����
abstract class Player {
	static final int MAXNOPLAYS = 100;  // �ִ� ���� ������ ��� ����

	String playerName;  // ���� �̸�
	String teamName;    // ����
	
	int noPlays;        // ��� ��
	
	// ������ �̸��� ���� �Է��Ͽ� �����ϴ� �޼ҵ�
	void getPalyernameTeam() {   
		System.out.println("\n  **  �߱����� ���� �Է� **\n"); 
		
		System.out.print("  o �߱����� �̸� > ");  
		playerName = SkScanner.getString();     // �ʵ�� �ٷ� ��� ����   
		
		System.out.print("  o �Ҽ� �� �̸� > ");  
		teamName = SkScanner.getString();       // �ʵ�� �ٷ� ��� ����   
    }
    
	// ������ ��� ��� �Է��Ͽ� �����ϴ� abstract �޼ҵ�
	abstract void getPalyerRecords(int no); 
	
	void outputPlayerRecords() { // ������ ��� ���\  
		System.out.println("\n\n  ** �߱����� ���� ��� **\n");            
		System.out.println("  * ���� �̸�: " + playerName);  
		System.out.println("  * �Ҽ� ����: " + teamName);    
		System.out.println("  * �� ��� ��: " + noPlays);    
		System.out.println();
	}
	
	// ���α׷��� Ÿ��Ʋ ���
	void outputTitle() {
		System.out.println("\n  ****  " + playerName + " ���� ���� �� ��� ����(���� Ŭ������ ��ü ���) ****\n"); 
	}  
}

class Hitter extends Player {	
	int recordsAtBat[] = new int[MAXNOPLAYS]; 
	int recordsHits[] = new int[MAXNOPLAYS];  
	int sumRecordAtBat = 0 ;
	int sumRecordHits = 0;
	double avgHitsRatio;


	// ������  no ȸ���� ��� ��� �Է��Ͽ� �����ϴ� abstract �޼ҵ�
	void getPalyerRecords(int no) {	    	
		System.out.println("\n  **  " +  no + " ��⿡���� Ÿ���� ��Ÿ ��� �Է� **");  

		for (int i=0; i < no; i++) {
			System.out.println("\n  * " + (i + 1) + "��° ����� Ÿ�� ��ϰ� ��Ÿ ���  �Է� * ");                     
			recordsAtBat[noPlays + i] = SkScanner.getIntWithPrompt("  o Ÿ�� ��� > "); 
			recordsHits[noPlays + i] = SkScanner.getIntWithPrompt("  o ��Ÿ ��� > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[noPlays + i] ;
			sumRecordHits = sumRecordHits + recordsHits[noPlays + i];
		}

		noPlays = noPlays + no;
		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;
	} 

	
	void outputPlayerRecords() { // ������ ��� ���
		super.outputPlayerRecords();
		
		for (int i=0; i < noPlays; i++) {
			System.out.println("  * " + (i + 1) + "��° ���: " + recordsAtBat[i] + "Ÿ��  " + recordsHits[i] + "��Ÿ");  
		}

		System.out.println("\n  * �� Ÿ����: " + sumRecordAtBat + ", �� ��Ÿ��: " + sumRecordHits + ", ��� ��Ÿ��: " + avgHitsRatio);  
    }
	
	// ������ �̸��� ���� �Է��Ͽ� �����ϴ� �޼ҵ�
	void getPalyernameTeam() {   
		System.out.println("\n  **  �߱����� ���� �Է� **\n"); 
		System.out.print("  o �߱����� �̸� > ");  
		playerName = SkScanner.getString();     // �ʵ�� �ٷ� ��� ����   
		System.out.print("  o �Ҽ� �� �̸� > ");  
		teamName = SkScanner.getString();       // �ʵ�� �ٷ� ��� ����   
    }
}

/*
* [ ���α׷��� ���� �� ���� ]
*
*   1) �� ���α׷��� main() �޼ҵ忡�� Hitter Ŭ������ ��ü�� �����Ͽ� �� ��ü�� ���� �޼ҵ带 ȣ���Ѵ�.
*
*   2) Hitter Ŭ������ abstract Ŭ������ Player Ŭ������ ����  Ŭ�����̴�.
*      �̵� Ŭ������ �ʵ�� �޼ҵ��� ����� �����ϰ� �޼ҵ��� �����κ��� �ľ��϶�.
*   
*   3) ���α׷��� �����Ͽ� Ÿ��  ���� ������ 5 ����� Ÿ�� ��ϰ� ��Ÿ ����� �Է��ϰ� ����� Ȯ���϶�.
*/
