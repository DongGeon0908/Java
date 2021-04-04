package ex05_baseball_players;

/*
* [ PlayerRecords__InOut_UsingArray Ŭ���� ]: ���� ��⿡���� Ÿ�� ��ϰ� ��Ÿ ����� �Է��Ͽ� �迭������ �����ϰ� ����ϱ�
*
*   o ���α׷��� ��Ÿ��
*     1) main() �޼ҵ�θ� Ŭ���� ����
*     2) �迭������ ����, For ������ �̿��� ������ �Է�, ����, ���� ���
*
*   o �� �߱� Ÿ�ڰ� 5 ��⿡�� �����  Ÿ�� ��ϰ� ��Ÿ ����� �Է��ϰ� �����
*     - Ÿ�� ���(record at bat): �� ��⿡�� Ÿ�� ��ȸ�� ���� Ÿ�� ȸ������ ����, ���� �´º�, ���ǻ籸, ���Ÿ�� ������ ȸ��
*     - ��Ÿ ���(hits record): �� ��⿡�� 1��Ÿ, 2��Ÿ, 3��Ÿ, Ȩ�� ���� ģ ȸ��
*     - 3 ��⿡�� 3Ÿ�� 1��Ÿ, 3Ÿ�� 1��Ÿ, 4Ÿ�� 2��Ÿ�� ���� �� Ÿ���� 10Ÿ��, �� ��Ÿ���� 4��Ÿ�̹Ƿ� ��� Ÿ���� 0.4��
*     - Ÿ�� ��ϰ� ��Ÿ ����� ��� Ÿ��, ����� ���� �߿� �� �ڷḦ ���� �� �ְ� ��
*
*   o ��� ȸ����ŭ�� Ÿ�� ��ϰ� ��Ÿ ����� �Է��Ͽ� �迭������ ���ҿ� ����
*     -  ��� ȸ���� ��Ÿ���� ��ȣ ����� �����Ͽ� ���α׷��� ������ ���� ��
*        final int NOPLAYS = 65;   // ��� ȸ���� ��Ÿ���� ��ȣ ���, NOPLAYS�� 5�� ������
*
*   o �迭 
*     - �迭����: �ϳ��� ������ ���� ���� ���� ������ �� �ִ� ����
*     - �迭������ ����: �迭������ ����Ǵ� �� �ϳ�
*     - �迭������ ����: Ÿ�� �迭����[������_����_����];
*         ��: int recordsAtBat[] = new int[NOPLAYS]; // NOPLAYS ȸ���� ��⿡�� ����� Ÿ������ ������ �迭���� ����
*
*     - �Է��� ���� �迭 ���ҿ� ����: �迭������[�ε���] = SkScanner.getXxx();
*         ��: recordsAtBat[0] = SkScanner.getInt();  // �迭 ������ �ε����� 0���� ������
*             recordsAtBat[1] = SkScanner.getInt();
*             recordsAtBat[2] = SkScanner.getInt();
*
*   o ���� ����� �ʾ�������, ������ for ������ �迭�� ����ϸ� �����ϰ� ����Ʈ�� �ڵ尡 �ۼ���
*
*   o �Է��� ���� �޼ҵ�
*     - SkScanner Ŭ������ getString() �޼ҵ�: ����Ű�� �Էµ� �� ������ ���ڿ��� �Է�
*     - SkScanner Ŭ������ getInt() �޼ҵ�: ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�
*/


class Ex3_8_2_PlayerRecords_InOut_UsingArray { 

	public static void main(String[] args) {

		final int NOPLAYS = 65;   // ��� ȸ���� ��Ÿ���� ��ȣ ���, NOPLAYS�� 5�� ������

		String playerName; // �߱� ���� �̸��� �����ϴ� ���ڿ� ����
		String teamName;   // �߱������� �Ҽ� ������ �����ϴ� ���ڿ� ����

		int recordsAtBat[] = new int[NOPLAYS]; // NOPLAYS ȸ���� ��⿡�� ����� Ÿ������ ������ �迭���� ����
		int recordsHits[] = new int[NOPLAYS];  // NOPLAYS ȸ���� ��⿡�� ����� ��Ÿ���� ������ �迭���� ����

		System.out.println("\n  ****  �߱����� ���� �� Ÿ���� ��Ÿ ��� ���� **** \n\n");  // �Է��� ���� Ÿ��Ʋ ���

		// �߱����� ���� �Է��Ͽ� ����
		System.out.println("\n  **  �߱����� ���� �Է� ** \n");  // �Է��� ���� Ÿ��Ʋ ���
		System.out.print("  o �߱����� �̸� > ");  // ������Ʈ �޽��� ���
		playerName = SkScanner.getString();        // ���ڿ� �� �Է��Ͽ�  ����
		System.out.print("  o �Ҽ� �� �̸� > ");   // ������Ʈ �޽��� ���
		teamName = SkScanner.getString();          // ���ڿ� �� �Է��Ͽ�  ����	

		// NOPLAYS���� ��⿡���� Ÿ�� ��ϰ� ��Ÿ ����� �Է��Ͽ� ����
		System.out.println("\n  **  " + NOPLAYS + " ��⿡���� Ÿ���� ��Ÿ ��� �Է� ** \n");  // �Է��� ���� Ÿ��Ʋ ���
		System.out.print("  o 1��° ����� Ÿ�� ��ϰ� ��Ÿ ��� > ");                     // ������Ʈ �޽��� ���
		recordsAtBat[0] = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� �迭 ���ҿ� ���ʷ� ����
		recordsHits[0] = SkScanner.getInt();

		System.out.print("  o 2��° ����� Ÿ�� ��ϰ� ��Ÿ ��� > ");  // ������Ʈ �޽��� ���
		recordsAtBat[1] = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� �迭 ���ҿ� ���ʷ� ����
		recordsHits[1] = SkScanner.getInt();

		System.out.print("  o 3��° ����� Ÿ�� ��ϰ� ��Ÿ ��� > ");  // ������Ʈ �޽��� ���
		recordsAtBat[2] = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� �迭 ���ҿ� ���ʷ� ����
		recordsHits[2] = SkScanner.getInt();

		System.out.print("  o 4��° ����� Ÿ�� ��ϰ� ��Ÿ ��� > ");  // ������Ʈ �޽��� ���
		recordsAtBat[3] = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� �迭 ���ҿ� ���ʷ� ����
		recordsHits[3] = SkScanner.getInt();

		System.out.print("  o 5��° ����� Ÿ�� ��ϰ� ��Ÿ ��� > ");  // ������Ʈ �޽��� ���
		recordsAtBat[4] = SkScanner.getInt();   // ���� �� �Է��Ͽ� �� �迭 ���ҿ� ���ʷ� ����
		recordsHits[4] = SkScanner.getInt();


		// �߱����� ���� ���
		System.out.println("\n\n  ** �߱����� ���� ��� **\n");    // �߱����� ���� ����� ���� Ÿ��Ʋ ���
		System.out.println("  * ���� �̸�: " + playerName + " \n");  
		System.out.println("  * �Ҽ� ����: " + teamName + " \n");     

		// �Էµ� NOPLAYS���� ��⿡���� Ÿ�� ��ϰ� ��Ÿ ��� ��� ���
		System.out.println("\n  ** " +NOPLAYS + " ��⿡���� Ÿ���� ��Ÿ ��� **\n");             // ����� ���� Ÿ��Ʋ ���
		System.out.println("  * 1��° ���: " + recordsAtBat[0] + "Ÿ��  " + recordsHits[0] + "��Ÿ");   // 1��° �迭 ������ �ε����� 1�� �ƴ϶� 0��
		System.out.println("  * 2��° ���: " + recordsAtBat[1] + "Ÿ��  " + recordsHits[1] + "��Ÿ");  
		System.out.println("  * 3��° ���: " + recordsAtBat[2] + "Ÿ��  " + recordsHits[2] + "��Ÿ");  
		System.out.println("  * 4��° ���: " + recordsAtBat[3] + "Ÿ��  " + recordsHits[3] + "��Ÿ");  
		System.out.println("  * 5��° ���: " + recordsAtBat[4] + "Ÿ��  " + recordsHits[4] + "��Ÿ");  // 5��° �迭 ������ �ε����� 5�� �ƴ϶� 4��



		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	}
}


/*
* [ ���α׷��� ���� �� ���� ]
*
*   1) �� ���α׷��� for ������ ������� �����Ƿ� ���α׷��� �ۼ��� �迭������ 
       ������� ���� �Ͱ� ����ϴ�. �׷��� �迭�� �����ϱ� ���� ���� ���α׷��̹Ƿ� 
	   �� ���캸�ƾ� �Ѵ�.
*
*   2) ���α׷��� �����Ͽ� ���� ������ 5 ����� Ÿ�� ��ϰ� ��Ÿ ����� �Է��ϰ� ����� Ȯ���϶�.
*
*
* [ �ǽ����� ]
*
*   1) ��Ÿ ����� ���� Ÿ�� ����� ������ ������ ��� ��Ÿ�� ����̴�. 
*      Ÿ�� ����� ��, ��Ÿ ����� ��, ��� ��Ÿ���� ������ ���� ���Ѵ�.
* 
        int sumRecordAtBat = recordAtBat[0] + recordAtBat[1] + recordAtBat[2] +
                             recordAtBat[3] + recordAtBat[4];  
                            
        int sumRecordHits = recordHits[0] + recordHits[1] + recordHits[2] +
                            recordHits[3] + recordHits[4]; 
   
        double avgHitsRatio = sumRecordHits / sumRecordAtBat;
*
*      ��� ��Ÿ���� ���Ͽ� ����ϵ��� ���α׷��� �����ϰ� ��� ����� Ȯ���϶�. 
*      ��� ����� ������ ���°�? ������ ������ �� ������ ���������� �˾ƺ���. 
*
*   2) 10 ��⿡���� Ÿ�� ��ϰ� ��Ÿ ����� ������ �迭������ ������ �� ����� �Է��Ͽ� �����ϰ� 
*      ����ϴ� ���α׷��� Pr3_8_2_PlayerRecords10_InOut_UsingArray Ŭ���� ���Ϸ� �ۼ��϶�.
*
*   3) ���� 5�� ���� ������ ���߱��� �̿� ������ �Է��Ͽ� ���߱��� �̿�ð��� �հ� �̿����� ���� 
*      ���� ����ϴ� ���α׷��� Pr3_8_2_PublicTransfotation_InOut_UsingArray Ŭ������ �ۼ��϶�.
*
*       (1) ���߱����� ����(pubTransType: ����, ����ö, �ý�, �����), �����(startingPoint), 
*           ������(destination), �̿�ð�(miniteTaken), �̿���(feeTrans) ���� �̿�ȸ����ŭ 
*            ������ �� �ִ� �迭 ������ �����϶�.
* 			
*       (2) ������ �� �迭������ ���ҿ� ���߱��� �̿볻�� �׸���� �Է��ϴ� ������� �ۼ��϶�.
* 
*       (3) ���߱��� �̿�ð��� �հ� �̿����� ���� ���Ͽ� ������ �����϶�.
*
*       (4) �Է��� ������ ���� ���߱��� �̿�ð��� �հ� �̿����� ���� ����ϴ� ������� �ۼ��϶�. 
* 
*       (5) �̿�ȸ���� 5ȸ �̻����� �ۼ��ؾ� �Ѵ�. 
*
*/
