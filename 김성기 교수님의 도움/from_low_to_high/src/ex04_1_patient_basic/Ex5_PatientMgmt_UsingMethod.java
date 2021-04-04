package ex04_1_patient_basic;


/*
* [ Patient_InOut ]: ȯ�� ������ ���� ������ ���� ���� ����, �� �Է��Ͽ� ����, ������ �̿��� ��� ��� �� ���
*                        (SkScanner.h�� �Է� �޼ҵ带 �̿�)
*
*   o ���α׷��� ��Ÿ��
*     1) main() �޼ҵ�θ� Ŭ���� ����
*     2) ������ ���� �Է��Ͽ� ������ �����ϰ� ����� ������ �� ���
*
*   o ���� ������ �� �Է�
*     - �������� ���� �Է��ϴ� �޼ҵ��� SkScanner Ŭ������ getXxx() �޼ҵ�
*         getString(): ����Ű�� Ÿ���ε� ������ Ÿ���ε� ��� ���ڵ��� �Է�
*         getInt():    Ÿ���ε� ���ڵ� �� ù��° ���� ���� �Է�, ������ �ƴ� ���� ��� ���õ�
*         getDouble(): Ÿ���ε� ���ڵ� �� ù��° �Ǽ� ���� �Է�, �Ǽ��� �ƴ� ���� ��� ���õ�
*         getChar():   ���� �ϳ��� �Է�
*
*     - �Էµ� ���� �ش� Ÿ���� ������ ���� ����
*         String name = SkScanner.getString();      // ���ڿ� �Է��Ͽ� String ������ ����
*         int age = SkScanner.getInt();             // ���� �Է��Ͽ� int ������ ����
*         double height = SkScanner.getDouble();    // �Ǽ� �Է��Ͽ� double ������ ����
*         char initialOfName = SkScanner.getChar(); // ���� �Է��Ͽ� char ������ ����
*
*   o ���� ������ �� ���
*     - System.out.println() �޼ҵ带 ���� �� ���
*     - System.out.println() �޼ҵ带 ���� ��� Ÿ���� ���� ���� ���� ����� �� ����
*/


class Ex5_PatientMgmt_UsingMethod { 
	/*
	 *  ȯ������(ȯ��ID, �̸�, ����, �������, �ּ�)�� ��������(���ᳯ¥, ����ð�(��))�� �����ϱ� ���� ���� ����
	 */
	static int patientID;   	// ȯ��ID: 10001������ �Ϸù�ȣ�� ������ �ο��Ǵ� �־���
	static String patientName;  // patientName: ȯ�� �̸� �����ϴ� ���ڿ� ����
	static String gender;     	// gender : "��", "��"�� �����ϴ� ���ڿ� ����
	static int dateBirth;       // dateBitrh: yyyymmdd�� ǥ���Ǵ� ������� �����ϴ� int ����
	static String addr;		    // addr:  �ּ� �����ϴ�  ���ڿ� ����

	static int[] datesTreat = new int[100];    // datesTreat: yyyymmdd�� ǥ���Ǵ� �ִ� 100ȸ�� ���ᳯ¥�� �����ϴ� int �迭����
	static int[] minitesTreat = new int[100];  // minitesTreat : �ִ� 100ȸ�� ����ð�(���� ��)�� �����ϴ� int �迭����
	static int noTreats = 0;  // ����ȸ���� �����ϴ� ������ datesTreat[]�� minitesTreat[] �迭������ �ε����� ���

	public static void main(String[] args) {

		while(true) { // ���� �޴��� ������ ������ �ݺ��� 
			/*
			 * ȯ�� ���������� ���� �޴� ��� �� �޴� ���� 
			 */int menu = displaySelectMenu();

			 if (menu == 7) {     // ���� �޴��� �����ϸ�  ���� �޼��� ��� �� ���α׷��� ������ 
				  doExitWork();
				  break;  // main()������ break �Ǵ� return ������ ���α׷��� �����Ŵ 
			 }
			 
			 doWorkForMenu(menu);
		}
		
		
		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ����
	}

	static int displaySelectMenu() {
		
			while (true) { // �ùٸ� ������ ���� �޴��� ���õ� ������ �ݺ��Ͽ� ���� �޴��� ������ 
				System.out.println("\n\n");
				System.out.println("  **************************");
				System.out.println("  **   �ѽź��� ȯ�� ��������         **");
				System.out.println("  **************************\n");

				System.out.println("    1) ȯ������ ����");
				System.out.println("    2) ȯ������ ����ϱ�");
				System.out.println("    3) ȯ������ �����ϱ�");
				System.out.println("    4) ȯ�� �������� ��ü ����");
				System.out.println("    5) ȯ�� �������� �Է��ϱ�");
				System.out.println("    6) ����� ����ϱ�");
				System.out.println("    7) �����ϱ�");
				
				int menu = SkScanner.getIntWithPrompt("\n  o ������ �����Ͻÿ� > ");

				if (menu >=1 && menu <= 7) { // ������ �޴� ������ �����ϸ� �޴� ������ �Ϸ�ǹǷ� 
					return menu;		                   //     break ���� �̿��Ͽ� ���� �ݺ� while(1)�� ����� ��
				}

				else { // �߸��� �޴� ������ �����ϸ� �ٽ� �޴� ������ �Է��ϵ��� �� 
					System.out.println("\n\n  ??? ������ �߸� ���õǾ����ϴ�. �ٽ� �ùٸ� ������ �����Ͻÿ�!!!");	
				}
			}
	}
	
	// ���� ������ ó���ϱ� ���� �޼ҵ�
	static void doExitWork() {
		System.out.println("\n\n  !!!  ȯ�� ���������� �����մϴ�.");
	}
	
	// �޴��� ���� ���� ó���� ���� �޼ҵ带 ȣ���ϱ� ���� ���� ���� �޼ҵ�
	static void doWorkForMenu(int menu) {
		switch (menu) {
		case 1:
			listPatientInfo();
			break;
			
		case 2:
			enrolPatientInfo();
			break;			
			
		case 3:
			updatePatientInfo();
			break;		
			
		case 4:
			listTreatInfos();
			break;
			
		case 5:
			inputTreatInfo();
			break;				
			
		case 6:
			calculateMeducalFee();
			break;		
		}		
	}
	
	// ��ϵ� ȯ������ ����ϴ� �޼ҵ�
	static void listPatientInfo() {	
		if (patientID==0) {
			System.out.println("\n   ??? ���� ��ϵ� ȯ�������� �����ϴ�. ȯ������ �Է��Ͻʽÿ�."); 
			return;
		}
			
		System.out.println("\n\n  ** ȯ�� ���� \n");
		System.out.println("  * ȯ��ID: " + patientID + ", ȯ���̸�: " + patientName + "(" + gender + "), �������: " + dateBirth + ", �ּ�: " + addr + " \n");	
	}
	
	// ȯ������ �Է��Ͽ� ����ϴ� �޼ҵ�
	static void enrolPatientInfo() {
		if (patientID!=0) {
			System.out.println("  o ���� ��ϵ� ȯ�� ������ �ֽ��ϴ�.");
			int yesOrNo = SkScanner.getInt("    ���ο� ȯ�� ���� ����Ͻðڽ��ϱ�? (1: ��, 2: �ƴϿ�) > ") ; 
			
			if (yesOrNo  != 1)
					return;
		}
		
		/*
		 *  ȯ�������� �Է��Ͽ� �ʵ���� ������ ����
		 */

		System.out.println("\n\n  **  ȯ������ ��� ** \n");

		System.out.print("  o ȯ��ID(5�ڸ� ����) > "); // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		patientID = SkScanner.getInt();     	         // SkScanner.h�� getInt()�� �̿��Ͽ� ���� �Է��Ͽ� ����

		System.out.print("  o ȯ���̸� > ");  // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		patientName = SkScanner.getString();  // SkScanner.h�� getString()�� �̿��Ͽ� ���ڿ� �Է��Ͽ� ����

		System.out.print("  o ����(M/F) > ");  // ������Ʈ �޽��� ���
		gender = SkScanner.getString();  		 // ���ڿ� �Է��Ͽ� ����

		System.out.print("  o �������(yyyymmdd) > "); 	// ��¥�� �Է��ϱ� ���� ������Ʈ �޽��� ���(�Է� ����� �˷���) 
		dateBirth = SkScanner.getInt();  		         // ���� ������� ��¥ �Է��Ͽ� ����

		System.out.print("  o �ּ� > "); 	// ������Ʈ �޽��� ���
		addr = SkScanner.getString();  		// ���ڿ� �Է��Ͽ� ����
		
		System.out.println("\n\n  * ȯ�� ��� �Ϸ� - ȯ��ID: " + patientID + ", ȯ���̸�: " + patientName + "(" + gender + "), �������: " + dateBirth + ", �ּ�: " + addr);	

	}
	
	// ȯ������ �����Ͽ� �����ϴ� �޼ҵ�
	static void updatePatientInfo() {
		if (patientID==0) {
			System.out.println("\n   ??? ���� ��ϵ� ȯ�������� �����ϴ�. ȯ������ �Է��Ͻʽÿ�."); 
			return;
		}
		
		/*
		 *  ȯ������ �� ������ �׸��� �����Ͽ� �����ϴ� �޼ҵ�
		 */
		int item = chooseUpdateItem();
		
		String[] itemNames = { "",  "�̸�", "����", "�������", "�ּ�"};   
		System.out.println("\n  **  ȯ������ �� " + itemNames[item] + " ���� ** \n");

		switch(item) {
		case 1: 
			String nameOld = patientName;

			System.out.print("  o ȯ���̸� > ");  // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
			patientName = SkScanner.getString();  // SkScanner.h�� getString()�� �̿��Ͽ� ���ڿ� �Է��Ͽ� ����
			System.out.println("\n\n  * ȯ������ ���� �Ϸ� - " + nameOld + " ȯ���� �̸��� " + patientName + "(��)�� ����Ǿ����ϴ�");
			break;

		case 2:
			String genderOld = gender;
			
			System.out.print("  o ����(M/F) > ");  // ������Ʈ �޽��� ���
			gender = SkScanner.getString();  		 // ���ڿ� �Է��Ͽ� ����
			System.out.println("\n\n  * ȯ������ ���� �Ϸ� - " + patientName + " ȯ���� ���� " + genderOld + " ������ " + gender + "(��)�� ����Ǿ����ϴ�");
			break;

		case 3:
			int dateBirthOld = dateBirth;
			
			System.out.print("  o �������(yyyymmdd) > "); 	// ��¥�� �Է��ϱ� ���� ������Ʈ �޽��� ���(�Է� ����� �˷���) 
			dateBirth = SkScanner.getInt();  		         // ���� ������� ��¥ �Է��Ͽ� ����
			System.out.println("\n\n  * ȯ������ ���� �Ϸ� - " + patientName + " ȯ���� ���� " + dateBirthOld + " ��������� " + dateBirth + "(��)�� ����Ǿ����ϴ�");
			break;

		case 4:
			String addrOld = addr;
			
			System.out.print("  o �ּ� > "); 	// ������Ʈ �޽��� ���
			addr = SkScanner.getString();  		// ���ڿ� �Է��Ͽ� ����
			System.out.println("\n\n  * ȯ������ ���� �Ϸ� - " + patientName + " ȯ���� ���� " + addrOld + " �ּҰ� " + addr + "(��)�� ����Ǿ����ϴ�");
		}
	}
	
	// ȯ������ �׸� �� ������ �׸��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	static int chooseUpdateItem() {
		while (true) { // �ùٸ� ���� �׸��� ���õ� ������ �ݺ��Ͽ� ���� �׸� ������ 
			System.out.println("\n\n  **   ������ ȯ������ �׸� ���� **\n");
			System.out.println("    1) ȯ�� �̸�    2) ����     3) �������     4) �ּ�   ");

			int choise = SkScanner.getIntWithPrompt("\n  o ������ �׸��� �����Ͻʽÿ� > ");

			if (choise >=1 && choise <= 4) { // ������ �޴� ������ �����ϸ� �޴� ������ �Ϸ�ǹǷ� 
				return choise;		                   //     break ���� �̿��Ͽ� ���� �ݺ� while(1)�� ����� ��
			}
			else { // �߸��� �׸��� �����ϸ� �ٽ� ������ �׸��� �Է��ϵ��� �� 
				System.out.println("\n\n  ??? ������ �׸��� �߸� ���õǾ����ϴ�. �ٽ� �ùٸ� �׸��� �����Ͻÿ�!!!");	
			}
		}
	}

	// ȯ�� �������� �Է��Ͽ� �����ϴ� �޼ҵ�
	static void inputTreatInfo() {
		if (patientID==0) {
			System.out.println("\n   ??? ���� ��ϵ� ȯ�������� �����ϴ�. ȯ������ ����Ͻʽÿ�."); 
			return;
		}

		System.out.println("\n  **  " + patientName + " ȯ���� �������� �Է� ** \n");

		System.out.print("  o ���ᳯ¥(yyyymmdd) > ");  // ��¥�� �Է��ϱ� ���� ������Ʈ �޽��� ���(�Է� ����� �˷���) 
		datesTreat[noTreats] = SkScanner.getInt();  	// ���� ������� ��¥ �Է��Ͽ� ����

		System.out.print("  o ����ð�(��) > ");        // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		minitesTreat[noTreats] = SkScanner.getInt();    // getInt()�� �̿��Ͽ� ���� �Է��Ͽ� ����
		
		noTreats++; // ���������� �ԷµǸ� ����ȸ���� 1 ������Ŵ

	}
		
	// ȯ�� �������� �Է��Ͽ� �����ϴ� �޼ҵ�
	static void listTreatInfos() {
		if (noTreats < 1) {
			System.out.println("\n   ??? ���� ���������� �����ϴ�. �������� �Է��Ͻʽÿ�."); 
			return;
		}
		
		System.out.println("\n  **  �������� ����Ʈ ** \n");

	    for (int i=0; i < noTreats; i++) {
	    	System.out.println("  * ȯ��ID: " + patientID + ", ���ᳯ¥ " + datesTreat + ", ����ð�: " + minitesTreat + "��");	
	    }
	}
	
	// ����� ����Ͽ� ����ϴ� �޼ҵ�
	static void calculateMeducalFee() {
		if (noTreats < 1) {
			System.out.println("\n   ??? ���� ���������� �����ϴ�. �������� �Է� �� ����� ����Ͻʽÿ�."); 
			return;
		}
			
		System.out.println("\n  **  ����� ��� ** \n");

	    System.out.println("  * ȯ��ID: " + patientID + ", ���ᳯ¥ " + datesTreat[noTreats-1] + ", ����ð�: " + minitesTreat[noTreats-1] + "��");	
	    System.out.println("  * �����: " + (3000 + minitesTreat[noTreats-1] * 200) + "��");	

		
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*
*   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
*
*      - �Ѹ��� ȯ�ڿ� ���� ȯ�������� ���� ���������� ������ �� �ִ� �޼ҵ���� �ۼ��Ǿ� �ִ�.
*
*   2) �ڽ��� ȯ�ڷ� �����Ͽ� ȯ�������� ���������� �Է��Ͽ� ����� Ȯ���϶�.
*
*
* [ �ǽ����� ]
*
*   1) �� ����ȸ��, �� ����ð�, �� �����, ����� ��� ���� ���Ͽ� ����ϴ� �޴��� 7�� "���� �������� ����" �޴���
*      ÷���ϵ��� ���α׷��� �����϶�.
*      
*      �̸� ���Ͽ� static void listTotalTreatInfo() �޼ҵ带 �ۼ��ϰ�, main(), displaySelectMenu(), doWorkForMenu() �޼ҵ带 �����϶�.
*
*
* [ ������ �����ϰ� ����غ� ���� ]
*
*   o �� ���α׷��� ���������� �ʵ带 �̿��ϹǷ� ���� �޼ҵ忡�� �ʵ带 ������ �� �ִ�. 
*     �� ��� �޼ҵ带 ȣ���� �� �Ű������� �̿��Ͽ� ������ ������ �ʿ䰡 �����Ƿ�
*     ��κ��� �޼ҵ尡 �Ű������� ���� �޼ҵ�� �ۼ��Ǿ���.
*
*     �׷��� doWork() �޼ҵ�� �Ű������� ������, displaySelectMenu() �޼ҵ�, chooseUpdateItem() �޼ҵ�� 
*     ��ȯ���� ���� �޼ҵ�� �ۼ��Ǿ���.�̵� �޼ҵ尡 �Ű����� �Ǵ� ��ȯ���� ���ԵǴ� ������ ������ �����غ���. 
*/
