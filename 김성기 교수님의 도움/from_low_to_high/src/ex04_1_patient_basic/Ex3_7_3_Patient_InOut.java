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

class Ex3_7_3_Patient_InOut { 
	public static void main(String[] args) {

		/*
		 *  ȯ������(ȯ��ID, �̸�, ����, �������, �ּ�)�� ��������(���ᳯ¥, ����ð�(��))�� �����ϱ� ���� ���� ����
		 */
		int patientID;   	// ȯ��ID: 10001������ �Ϸù�ȣ�� ������ �ο��Ǵ� �־���
		String patientName; // patientName: ȯ�� �̸� �����ϴ� ���ڿ� ����
		String gender;     	// gender : "��", "��"�� �����ϴ� ���ڿ� ����
		int dateBirth;      // dateBitrh: yyyymmdd�� ǥ���Ǵ� ������� �����ϴ� int ����
		String addr;		// addr:  �ּ� �����ϴ�  ���ڿ� ����

		int dateTreat;      // dateTreat: yyyymmdd�� ǥ���Ǵ� ���ᳯ¥�� �����ϴ� int ����
		int minitesTreat;   // minitesTreat : ����ð�(���� ��)�� �����ϴ� int ����


		/*
		 *  ȯ�������� ���������� �Է��Ͽ� �������� ������ ����
		 */

		System.out.println("\n  **  ȯ������ �Է� ** \n");

		System.out.print("  o ȯ��ID(5�ڸ� ����) > "); // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		patientID = SkScanner.getInt();     	         // SkScanner.h�� getInt()�� �̿��Ͽ� ���� �Է��Ͽ� ����

		System.out.print("  o ȯ���̸� > ");  // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		patientName = SkScanner.getString();  // SkScanner.h�� getString()�� �̿��Ͽ� ���ڿ� �Է��Ͽ� ����

		System.out.print("  o ����(��/��) > ");  // ������Ʈ �޽��� ���
		gender = SkScanner.getString();  		 // ���ڿ� �Է��Ͽ� ����

		System.out.print("  o �������(yyyymmdd) > "); 	// ��¥�� �Է��ϱ� ���� ������Ʈ �޽��� ���(�Է� ����� �˷���) 
		dateBirth = SkScanner.getInt();  		         // ���� ������� ��¥ �Է��Ͽ� ����

		System.out.print("  o �ּ� > "); 	// ������Ʈ �޽��� ���
		addr = SkScanner.getString();  		// ���ڿ� �Է��Ͽ� ����


		System.out.println("\n  **  �������� �Է� ** \n");

		System.out.print("  o ���ᳯ¥(yyyymmdd) > ");  // ��¥�� �Է��ϱ� ���� ������Ʈ �޽��� ���(�Է� ����� �˷���) 
		dateTreat = SkScanner.getInt();  				// ���� ������� ��¥ �Է��Ͽ� ����

		System.out.print("  o ����ð�(��) > "); // System.out.println() �̿��Ͽ� ������Ʈ �޽��� ���
		minitesTreat = SkScanner.getInt();       // SgetInt()�� �̿��Ͽ� ���� �Է��Ͽ� ����


		/*
		 *  �������� ���� ����� ���
		 */
		System.out.println("\n\n  **** ȯ�� ���� �� ���� ���� **** \n");  // ��� Ÿ��Ʋ ���
		System.out.println("  ** ȯ�� ���� \n");
		System.out.println("  * ȯ��ID: " + patientID + ", ȯ���̸�: " + patientName + "(" + gender + "), �������: " + dateBirth + ", \n    �ּ�: " + addr + " \n");	

		System.out.println("  ** ���� ���� \n");
		System.out.println("  * ȯ��ID: " + patientID + ", ���ᳯ¥ " + dateTreat + ", ����ð�: " + minitesTreat + "��");	

		System.out.println("\n\n  ^^ Well done! Have a good time!!! ^^\n\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������


		main(args); // �� ������ ��ü ���α׷��� ��� �ݺ��Ͽ� �����ϱ� ���� �ۼ��� ����
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*
*   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
*
*      - Patient_InOut�� main() �޼ҵ尡 �ۼ��Ǿ� �ִ�.
*
*      - main() �޼ҵ�� ���� ����, �� �Է� �� ����, �� ��� ���� �����ϴ�
*         ���� ������ �����Ǿ� �ִ�.
*
*      - main() �޼ҵ��� ������ < main(); > ������ ������, �� ������ ��ü ���α׷��� 
*        ��� �ݺ��Ͽ� �����ϵ��� �Ѵ�.
*
*   2) �ڽ��� ȯ�ڷ� �����Ͽ� ȯ�������� ���������� �Է��Ͽ� ����� Ȯ���϶�.
*
*
* [ �ǽ����� ]
*
*   1) ������ �⺻������ ����ð��� ���Ͽ� �ΰ��Ǵ� ����ð� ������ �����ȴ�.
       �⺻������ 20000��, 1�д� ����� 200���� ��� ����ð��� 10���̸�
       
	   ����� = 2000��(�⺻����� ) + 200��(1�д� �����) * 10��(����ð�) = 2000�� + 2000�� = 4000���̴�.
	    
*      ����� ��Ÿ���� ���� medicalFee �߰������� �����ϰ� ����� ���Ͽ� ����ϵ���
*      ���α׷��� �����϶�.
*
*      ������ �Ϸ�Ǹ� ȯ�������� ���������� �Է��Ͽ� ����� Ȯ���϶�.
*
*   2) �� ���α׷������� ������ϰ� ���ᳯ¥�� ���� ��¥�� yyyymmdd ������ 8�ڸ� ������ �Է¹޴´�.
*      ��¥�� ����, ����, ���� �� 3������ ������ �Է¹޾�  dateBirth ������  dateTreat ������ �����ϵ���
*      ������ ���α׷��� Pr3_7_3_Patient_InOut�� �ۼ��϶�. 
*	   
*	   �̸� ���� ������� �Է��� ���, birthYear, birthMonth, birthDay ������ �����ϰ� 
*      �̵� ������ ����, ����, ������ �Է¹��� �� 
*       << birthDate = birthYear * 10000 + birthMonth * 100 + birthDay; >>�� �����Ѵ�.
*
*
*   3) ���� 100m, 200m, 400m, 800m �޸��� ����ű���� 9.58��, 19.19��, 43.18��, 100.91���̸�,
*      ��� �����ڴ� 100m "Usain Bolt", 200m "Usain Bolt", 400m "Michael Johnson",
*      800m "David Rudisha"�̴�.
*
*      ������ �䱸�� ������Ű�� ���α׷��� Pr3_7_3_WorldRecord__InOut Ŭ������ �ۼ��϶�.
*
*    (1)�̵� ����ű���� �����ϱ� ���� ���� worldRecord100m, worldRecord200m, worldRecord400m,
*         worldRecord800m�� ����ű�� �����ڸ� �����ϱ� ���� ���� worldRecordHolder100m,
*        worldRecordHolder200m, worldRecordHolder400m, worldRecordHolder800m��
*       �����ϰ� ������ ������ ���� �Է��Ͽ� ������ �� ����Ѵ� 
*       
*    (2) �̵� 4���� �����Ͽ� ���� m ������ �ʼ�, m ������ �м�, km ������ �ü��� 
*        �� ����Ѵ�.
*		
*    (3) ����¾���� Pr3_7_1_WorldRecord_Out�� ����¾�İ� Pr3_7_2_WorldRecord_Initialization_Out�� 
*        ����¾�� �߿��� �� ���� ���� �����Ѵ�.
*
*
* [ ������� ]
*
*   1) �ǽ������� �� ������ �� Ŭ������ ���α׷��� ��Ÿ�ϰ� ������ ��Ÿ���� ���α׷���
*      �ۼ��Ͽ��� �Ѵ�. 
*
*   2) ���α׷��� �ѹ� ����� �� ����ȴ�. �־��� ���α׷��� ��� �ݺ��ϴ� ���� ���� �����
*      main() �޼ҵ��� ���� ���� << main(); >> �� �߰��ϴ� ���̴�.
*      �� ��� ���α׷��� ��� �ݺ��Ͽ� ����ǰ� �ȴ�. �� �ٸ� ����� ������ �Ұ��� ���̴�.
*
*/
