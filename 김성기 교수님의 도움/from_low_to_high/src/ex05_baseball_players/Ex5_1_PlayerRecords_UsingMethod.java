package ex05_baseball_players;


class Ex5_1_PlayerRecords_UsingMethod { 
	int MAXNOPLAYS = 100;  // �ִ� ���� ������ ��� ����

	String playerName;  // ���� �̸�
	String teamName;    // ����
	
	int noPlays;         // ��� ��
	
	static int recordsAtBat[] = new int[MAXNOPLAYS]; 
	static int recordsHits[] = new int[MAXNOPLAYS];  
	static int sumRecordAtBat = 0 ;
	static int sumRecordHits = 0;
	static double avgHitsRatio;

	// ���α׷��� Ÿ��Ʋ ���
	static void outputTitle() {
		System.out.println("\n  ****  �߱����� ���� �� Ÿ���� ��Ÿ ��� ����(static ������ �޼ҵ� ���) ****\n"); 
	}
	
	// ������ �̸��� ���� �Է��Ͽ� �����ϴ� �޼ҵ�
	static void getPalyernameTeam() {   
		System.out.println("\n  **  �߱����� ���� �Է� **\n"); 
		System.out.print("  o �߱����� �̸� > ");  
		playerName = SkScanner.getString();     // static ������ �ٷ� ��� ����   
		System.out.print("  o �Ҽ� �� �̸� > ");  
		teamName = SkScanner.getString();       // static ������ �ٷ� ��� ����   
    }
    
	// ������ Ÿ���� ��Ÿ ��� �Է��Ͽ� �����ϴ� �޼ҵ�
    static void getPalyrRecords(int no) {
    	noPlays = no;
    	
		System.out.println("\n  **  " +  noPlays + " ��⿡���� Ÿ���� ��Ÿ ��� �Է� **\n");  

		for (int i=0; i < noPlays; i++) {
			System.out.println("\n  * " + (i + 1) + "��° ����� Ÿ�� ��ϰ� ��Ÿ ���  �Է� * ");                     
			recordsAtBat[i] = SkScanner.getIntWithPrompt("  o Ÿ�� ��� > "); 
			recordsHits[i] = SkScanner.getIntWithPrompt("  o ��Ÿ ��� > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[i] ;
			sumRecordHits = sumRecordHits + recordsHits[i];
		}

		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;
    }
    
    static void outputPlayerRecords() { // ������ ��� ���\  
		System.out.println("\n\n  ** �߱����� ���� ��� **\n");            
		System.out.println("  * ���� �̸�: " + playerName);  
		System.out.println("  * �Ҽ� ����: " + teamName);    
		System.out.println();
		
		for (int i=0; i < noPlays; i++) {
			System.out.println("  * " + (i + 1) + "��° ���: " + recordsAtBat[i] + "Ÿ��  " + recordsHits[i] + "��Ÿ");  
		}

		System.out.println("\n  * �� Ÿ����: " + sumRecordAtBat + ", �� ��Ÿ��: " + sumRecordHits + ", ��� ��Ÿ��: " + avgHitsRatio);  
    }

    
	public static void main(String [] args) {
		outputTitle();         // ���α׷� Ÿ��Ʋ ���
        getPalyernameTeam();   // ������ �̸��� ���� �Է�
        getPalyrRecords(5);    // 5 ��⿡���� ���� ��� �Է�
        outputPlayerRecords(); // ������ ��� ���
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*
*   1) �� ���α׷��� �޼ҵ带 ����Ͽ�  �����ϰ� ���α׷��� �ۼ��Ͽ���.
*
*   2) �� �޼ҵ��� ����� �����ϰ� �� ����� ���� �ۼ��� �����κ��� �ľ��϶�.
*      Ư��, �޼ҵ� �ܺο� ����� static ������ static �޼ҵ� ������ �����Ӱ� ����� �� ������ �ݵ�� Ȯ���϶�.
*   
*   3) ���α׷��� �����Ͽ� ���� ������ 5 ����� Ÿ�� ��ϰ� ��Ÿ ����� �Է��ϰ� ����� Ȯ���϶�.
*
*
* [ �ǽ����� ]
*
*   1) ���� 5�� ���� ������ ���߱��� �̿� ������ �Է��Ͽ� ���߱��� �̿�ð��� �հ� �̿����� ���� 
*      ���� ����ϴ� ���α׷��� Pr5_1_PublicTransfotation_InOut_UsingMethod Ŭ������ �ۼ��϶�.
*
*       (1) ���߱����� ����(pubTransType: ����, ����ö, �ý�, �����), �����(startingPoint), 
*           ������(destination), �̿�ð�(miniteTaken), �̿���(feeTrans) ���� �̿�ȸ����ŭ 
*            ������ �� �ִ� static �迭 ������ ���� �����ϰ� �迭��ü�� �����Ͽ� �����϶�.
* 			
*       (2) ���߱��� �̿�ð��� �հ� �̿����� ���� �������� static ������ �����϶�..
*       
*       (3) �־��� �̿�ȸ�� no�� ���߱��� �̿볻�� �׸���� �Է��Ͽ� �迭�����鿡 �����ϴ� static void inputPubTrans(int no) �޼ҵ�,
*           ���߱��� �̿�ð��� �հ� �̿����� ���� ���Ͽ� �ش� ������ �����ϴ�  static void getTransTimeFee() �޼ҵ�, 
*           ���߱��� �̿�ð��� �հ� �̿����� ���� ����ϴ�   static void outputTransTimeFee() �޼ҵ带 �ۼ��϶�.
* 
*       (3) main() �޼ҵ忡�� �̵� �޼ҵ带 ȣ���Ͽ� �����͸� �Է��ϰ� �������� Ȯ���϶�..
*
*       (4) �̿�ȸ���� 5ȸ �̻����� �Ͽ��� �Ѵ�. 
*
*/
