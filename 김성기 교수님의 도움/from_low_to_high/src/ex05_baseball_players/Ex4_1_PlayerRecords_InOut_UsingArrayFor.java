package ex05_baseball_players;


class Ex4_1_PlayerRecords_InOut_UsingArrayFor { 
	public static void main(String[] args) {
		int MAXNOPLAYS = 100;  // �ִ� ���� ������ ��� ����

		String playerName;  // ���� �̸�
		String teamName;    // ����
		
		int noPlays;         // ��� ��
		
		int recordsAtBat[] = new int[MAXNOPLAYS]; 
		int recordsHits[] = new int[MAXNOPLAYS];  
		int sumRecordAtBat = 0 ;
		int sumRecordHits = 0;
		double avgHitsRatio;

		System.out.println("\n  ****  �߱����� ���� �� Ÿ���� ��Ÿ ��� ����(�迭, for �� ���) ****\n"); 


		System.out.println("\n  **  �߱����� ���� �Է� **\n"); 
		System.out.print("  o �߱����� �̸� > ");  
		playerName = SkScanner.getString();        
		System.out.print("  o �Ҽ� �� �̸� > ");  
		teamName = SkScanner.getString();         


		System.out.println("\n  **  " +  NOPLAYS + " ��⿡���� Ÿ���� ��Ÿ ��� �Է� **");  

		for (int i=0; i < NOPLAYS; i++) {
			System.out.println("\n  * " + (i + 1) + "��° ����� Ÿ�� ��ϰ� ��Ÿ ���  �Է� * ");                     
			recordsAtBat[i] = SkScanner.getIntWithPrompt("  o Ÿ�� ��� > "); 
			recordsHits[i] = SkScanner.getIntWithPrompt("  o ��Ÿ ��� > ");

			sumRecordAtBat = sumRecordAtBat + recordsAtBat[i] ;
			sumRecordHits = sumRecordHits + recordsHits[i];
		}

		avgHitsRatio = sumRecordHits / (double) sumRecordAtBat;

		System.out.println("\n\n  ** �߱����� ��� ���� ��� **\n");            
		System.out.println("  * ���� �̸�: " + playerName);  
		System.out.println("  * �Ҽ� ����: " + teamName);    
		System.out.println();
		
		for (int i=0; i < NOPLAYS; i++) {
			System.out.println("  * " + (i + 1) + "��° ���: " + recordsAtBat[i] + "Ÿ��  " + recordsHits[i] + "��Ÿ");  
		}

		System.out.println("\n  * �� Ÿ����: " + sumRecordAtBat + ", �� ��Ÿ��: " + sumRecordHits + ", ��� ��Ÿ��: " + avgHitsRatio);  

	}
}
