package example12_2_bank;

import java.util.Date;
import java.util.Vector;

// BankMainUsingConsole: ���� ��������� ���� ������ ó���ϴ� Ŭ����
class BankMainUsingConsole  {

	public static void main(String args[]) {
		BankSystem.initializeBank(); // �̸� ���¸� �����ϰ� ������� �����ϴ� �ʱ�ȭ �޼ҵ� ȣ��

		int menu=0;
		while(menu != 9) {
			System.out.println("\n\n<< ���� ���� ó �� �ý��� (Vector ���, ����ó�� ) >>");
			System.out.println("   1. ���� ����       \t 2. ���� ����Ʈ");
			System.out.println("   3. ���� �Ա�       \t 4. ���� ���");
			System.out.println("   5. ���� ��ü       \t 6. ������ ���� ���");
			System.out.println("   7. �۾����� ��� \t 8. ���� ��������");
			System.out.println("   9. ����");
			System.out.print("\n   * ���ϴ� �۾��� �����Ͻÿ� > ");

			menu = SkScanner.getInt() ;

			try {
				switch (menu)  {

				case 1: 
					openAccount();
					break;

				case 2:
					listAccounts();
					break;

				case 3:
					deposit();
					break;

				case 4:
					withdraw();
					break;

				case 5:	
					transfer();			
					break;

				case 6:	
					outputOwnerInfo();			
					break;

				case 7:	
					outputTransactionInfo();			
					break;

				case 8:	
					outputAccountsInfo();		
					break;

				default:
					throwException(menu + " - �߸��� �޴� �����Դϴ�.");					
				}
			}
			catch(Exception e) {
				System.out.println("\n  ** ����: "+e.getMessage()+"\n");
			}
		}
	}

	// ���� ���� -- ���� �� ������ ���� ���� ���
	public static void openAccount() throws Exception  {
		int accType;

		System.out.println("\n-- ���� ���� --");

		do {  
			System.out.print("   * ������ ���� (1. ���뿹�� 2. ���࿹��) > ");
			accType = SkScanner.getInt();
		} while (accType !=1 && accType !=2) ;

		System.out.print("   * ������ ���� > ");
		String owner = SkScanner.getString();
		System.out.print("   * �ʱ� �Աݾ� > ");
		int initAmount = SkScanner.getInt();

		if (initAmount < 0) 
			throw new Exception("�ʱ��ܾ��� 0���� �۽��ϴ�");

		System.out.print("   * ��й�ȣ > ");
	    int password = SkScanner.getInt();

		Account newAccount = BankSystem.openAccount(accType, owner, initAmount, password);  // ���� ��ü ����

		// ������ ���� �����ֱ�
		System.out.println("\n-- ���� ����  --");
		newAccount.output();
	}

	// ��� ���� ����Ʈ �޴� ó��
	public static void listAccounts() {	
		Account acc;

		System.out.println("\n-- ��� ���� ����Ʈ --");

		for(int i=0; i<BankSystem.getNumAccounts(); i++) {
			acc=BankSystem.getAccount(i);
			acc.output();
		}
	}

	// ���� �Ա� �޴� ó��
	public static void deposit() throws Exception {	
		Account acc=null;
		int amount;

		listAccounts();

		System.out.println("\n-- ���� �Ա� --");
		System.out.print("   * ���� ��ȣ > ");
		int inAccNo=SkScanner.getInt();
		System.out.print("   * �Ա� �ݾ� > ");
		amount = SkScanner.getInt();
		System.out.print("   * �� ���� > ");
		String customer = SkScanner.getString();

		acc = BankSystem.deposit(inAccNo, amount, customer);

		System.out.println("\n-- �Ա� ����  --");
		acc.output();
	}

	// ���� ��� �޴� ó�� 
	public static void withdraw() throws Exception {	
		Account acc = null;
		int amount;

		listAccounts();

		System.out.println("\n-- ���� ��� --");
		System.out.print("   * ���� ��ȣ > ");
		int outAccno = SkScanner.getInt();
		System.out.print("   * ��� �ݾ� > ");
		amount = SkScanner.getInt();
		System.out.print("   * �� ���� > ");
		String customer = SkScanner.getString();
		System.out.print("   * ��й�ȣ > ");
	    int password = SkScanner.getInt();

		acc = BankSystem.withdraw(outAccno, amount, customer, password);

		System.out.println("\n-- ��� ����  --");
		acc.output();
	}

	// ���� ��ü �޴� ó�� 
	public static void transfer() throws Exception {	
		int inAccno, outAccno;
		Account inAcc, outAcc;	
		int amount;

		listAccounts();

		System.out.println("\n-- ���� ��ü --");
		System.out.print("   * ��ü��� ���¹�ȣ > ");
		outAccno = SkScanner.getInt();
		System.out.print("   * ��ü�Ա� ���¹�ȣ > ");
		inAccno = SkScanner.getInt();
		System.out.print("   * ��ü �ݾ� > ");
		amount = SkScanner.getInt();
		System.out.print("   * �� ���� > ");
		String customer = SkScanner.getString();
		System.out.print("   * ��й�ȣ > ");
	    int password = SkScanner.getInt();

		outAcc = BankSystem.findAccount(outAccno);  // �־��� ��ȣ�� ���� Ž��
		if (outAcc == null) {
			throw new Exception("��ü��� ���°� �������� �ʽ��ϴ�.");
		}

		inAcc = BankSystem.findAccount(inAccno);      // �־��� ��ȣ�� ���� Ž��
		if (inAcc == null) {
			throw new Exception("��ü�Ա� ���°� �������� �ʽ��ϴ�.");
		}	

		BankSystem.transfer(outAcc, inAcc, amount, customer, password);

		System.out.println("\n-- ��ü��� ����  --");
		outAcc.output();

		System.out.println("\n-- ��ü�Ա� ����  --");
		inAcc.output();
	}

	// ������ ���� �Է��Ͽ� ������ ���� ���� ���  �޴� ó��
	public static void 	outputOwnerInfo() { 
		Account acc;

		listAccounts();

		System.out.println("\n-- ������ ���� --");
		System.out.print("   * ������ ���� > ");
		String owner = SkScanner.getString();

		int[] infos = BankSystem.getOwnerInfo(owner);

		int noAcc = infos[0];
		int totAmount = infos[1];
		System.out.println("   "+owner+"�� ���ܾ� = "+totAmount+"  ����ܾ� = "+(totAmount/noAcc));	
	}

	// �۾����� ��� �޴� ó��: ���¹�ȣ �Է��Ͽ� ���¿� ���� ���  �۾����� ���
	public static void 	outputTransactionInfo() throws Exception {
		Transaction tr;

		Account acc=null;

		listAccounts();

		System.out.println("\n-- ���� �۾�����(�Ա�, ���, ��ü ����) ��� --");
		System.out.print("   * ���� ��ȣ > ");
		int accno = SkScanner.getInt();

		acc = BankSystem.findAccount(accno);  // ���� ��ȣ�� ���¸� ã��
		
		if (acc == null) { 
			throw new Exception("���°� �������� �ʽ��ϴ�.");
		}

		System.out.println("\n  < ���� ����  >");
		acc.output();

		System.out.println("\n  < ���� �۾����� >");
		Transaction[] trs = BankSystem.getTransactionInfo(acc); // �־��� ���¿� ���� �۾��������� �迭�� ���޹��� 

		for(int i=0; i< trs.length; i++) {  // �迭�� ����� ��� �۾��������� ��� 
			trs[i].output();				
		}  
	}
	
	// ���� �������� ��� �޴� ó��: ��� ������ ���� ����, ���ܾ�, ����ܾ� �� �������� ���Ͽ� ���
	public static void 	outputAccountsInfo()  {	
		listAccounts();

		System.out.println("\n-- ���� �������� --");

		int[] infos = BankSystem.getAccountsInfo();

		int noAcc = infos[0];
		int totAmount = infos[1];
		int maxAmount = infos[2];

		System.out.println("    �� ���°��� = "+noAcc+",  ���ܾ� = "+totAmount+",  ����ܾ� = "+(totAmount/noAcc)+",  �ִ��ܾ� = "+maxAmount   );
	}
	
	// �־��� message�� ���ܸ� �߻���Ű�� �޼ҵ�
    static void throwException(String message) throws Exception {
    	throw new Exception(message);
    }
}
