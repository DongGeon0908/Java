package example12_2_bank;

import java.util.Date;
import java.util.Vector;

// BankSystem: ���� ������ �����ϰ� ������ ó���ϴ� �޼ҵ带 ���� Ŭ����
class BankSystem  {

	// Account ��ü ����� accounts - Account ��ü�� �����Ǹ�  accounts ���Ϳ� ����
	//    accounts ���ʹ� ������ Account ��ü ���θ� �����Ͽ� ����
	private static Vector<Account> accounts = new Vector<Account>();  // Account ��ü ���θ� �����Ͽ� ����
	
	// Transaction ��ü ����� transactions : Transaction ��ü�� �����Ǹ�  transactions ���Ϳ� ����
	//    transactions ���ʹ� ������ Transaction ��ü ���θ� �����Ͽ� ����
	static Vector<Transaction> transactions = new Vector<Transaction>();  // Transaction ��ü ���θ� �����Ͽ� ����
	
	// Banker ��ü ����� bankers : Banker ��ü�� �����Ǹ�  bankers ���Ϳ� ����
	//    bankers ���ʹ� ������ Banker ��ü ���θ� �����Ͽ� ����
	static Vector<Banker> bankers = new Vector<Banker>();  // Banker ��ü ���θ� �����Ͽ� ����
	
	private static int nextSerial[] =  { 1,  1 };  // ���뿹�ݰ� ���࿹�ݿ� ���� ���� ���¹�ȣ�� �Ҵ��ϱ� ���� ���� �迭

	static String trTypeName[] =  {"", "�Ա�", "���", "��ü���", "��ü�Ա�" };

	// ���� ����
	static Account openAccount(int accType, String owner, int initAmount, int password) {

		int accno = BankSystem.getNextAccno(accType);  // ���� ��ȣ ����
		Date openDate = new Date();                    // ������ ����

		// ���� ��ü �����Ͽ� accounts ���Ϳ� ����
		Account newAccount = new Account(accno, accType, owner, openDate, initAmount, password);
		BankSystem.addToAccounts(newAccount);

		// �۾����� ��ü �����Ͽ� transactions ���Ϳ� ����
		Transaction newTr = new Transaction(newAccount, "�Ա�", owner, initAmount, initAmount);  // �Աݻ����� Ʈ����ǿ� ���
		BankSystem.addToTransactions(newTr);

		return newAccount;
	}

	// �־��� �Աݰ��¿� �ݾ׸�ŭ �Ա�
	public static Account deposit(Account inAcc, int amount, String customer){

		inAcc.deposit(amount);

		BankSystem.addToTransactions(new Transaction(inAcc, "�Ա�", customer, amount, inAcc.getBalance()));

		return inAcc;	
	}

	// �־��� �Աݰ��¹�ȣ�� ���¿� �ݾ׸�ŭ �Ա�
	public static Account deposit(int inAccno, int amount, String customer) throws Exception {

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			if (acc.accno == inAccno) {
				acc.deposit(amount);

				BankSystem.addToTransactions(new Transaction(acc, "�Ա�", customer, amount, acc.getBalance()));

				return acc;
			}
		}

		throw new Exception("�Աݰ��°� �������� �ʽ��ϴ�.");			
	}

	// ���� ���
	public static Account withdraw(Account outAcc, int amount, String customer, int password) throws Exception {

		if (! outAcc.isValidPassword(password))
			throw new Exception("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");

		if(outAcc.getBalance() >= amount) {
			outAcc.withdraw(amount);

			BankSystem.addToTransactions(new Transaction(outAcc, "���", customer, amount, outAcc.getBalance()));

			return outAcc;
		}
		else  { 
			throw new Exception("�ܾ��� �����մϴ�.");
		}			
	}

	// ���� ���
	public static Account withdraw(int outAccno, int amount, String customer, int password) throws Exception {

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			if (acc.accno == outAccno) {
				withdraw(acc, amount, customer, password);
				return acc;
			}
		}

		throw new Exception("��� ���°� �������� �ʽ��ϴ�.");
	}

	// ���� ��ü
	static void transfer(Account outAcc, Account inAcc, int amount, String customer, int password) throws Exception  {
		if (! outAcc.isValidPassword(password))
			throw new Exception("��ü��� ������ ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");

		if(outAcc.getBalance() >= amount) {   // �ܰ� ��ü�ݾ׺��� �������� Ȯ��
			outAcc.withdraw(amount);
			inAcc.deposit(amount);

			BankSystem.addToTransactions(new Transaction(outAcc, "��ü���", customer, amount, outAcc.getBalance()));
			BankSystem.addToTransactions(new Transaction(inAcc, "��ü�Ա�", customer, amount, inAcc.getBalance()));
		}
		else throw new Exception("�ܾ��� �����մϴ�.");
	}

	// ������ ���� ���ϱ�
	static int[] getOwnerInfo(String owner) {
		int noAcc = 0;
		int totAmount = 0;

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			if (acc.owner.equals(owner)) {
				noAcc++;
				totAmount += acc.getBalance();
			}
		}

		int[] arr = {noAcc,  totAmount};

		return arr;
	}

	// ��� ������ ���� ������ ���Ͽ� �迭�� ��ȯ
	static int[] getAccountsInfo() {

		int noAcc = 0;
		int totAmount = 0;
		int maxAmount = -1;

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			noAcc++;
			totAmount += acc.getBalance();
			if (acc.getBalance() > maxAmount)
				maxAmount = acc.getBalance();
		}

		int[] arr = {noAcc, totAmount, maxAmount };

		return arr;
	}

	// �־��� ������ ��� �۾������� �۾����� �迭�� �����Ͽ� ��ȯ
	static Transaction[] getTransactionInfo(Account acc) {

		Vector<Transaction> trs = new Vector<Transaction>();

		for(int i=0; i< getNumTransactions(); i++) {
			Transaction tr = getTransaction(i);
			if (acc == tr.trAccount)
				trs.add(tr);				
		}  

		Transaction[] trArr = new Transaction[trs.size()];

		for (int i=0; i < trs.size(); i++)
			trArr[i] = trs.get(i);

		return trArr;
	}

	// �־��� ������ ���¿� ���� ���� ���¹�ȣ�� �����ϴ� �޼ҵ�
	// ��������(1. ���뿹�� 2. ���࿹��)
	static int getNextAccno(int accType)  {
		int accno;
		accno = accType * 100000 + nextSerial[accType-1];
		nextSerial[accType-1]++;
		
		return accno;
	}

	// ��� ���¸� Account �迭�� �����Ͽ� ��ȯ
	static Account[] getAllAccounts() {
		int size = accounts.size();

		Account[] accs = new Account[size];

		for (int i = 0; i < size; i++) 
			accs[i] = getAccount(i);

		return accs;
	}
	
	// ��� ���� ��ȣ��  String �迭�� �����Ͽ� ��ȯ
	static String[] getAllAccnos() {
		int size = accounts.size();

		String[] accnos = new String[size];

		for (int i = 0; i < size; i++) 
			accnos[i] = "" + getAccount(i).accno;

		return accnos;
	}

	// ���¸� accounts ���Ϳ� �����ϴ� �޼ҵ�
	static void addToAccounts(Account acc) {
		accounts.add(acc);
	}

	// ������ ���� ������ ��ȯ�ϴ� �޼ҵ�
	public static int getNumAccounts() {
		return accounts.size();
	}

	//�־��� ������ ���¸� ��ȯ(������ 0����)�ϴ� �޼ҵ�
	public static Account getAccount(int which) {
		return accounts.elementAt(which);  // �Ǵ� get(which)
	}

	// �־��� ���¹�ȣ�� ���¸� ã�� ��ȯ�ϴ� �޼ҵ�
	public static Account findAccount(int accno)  {
		for(int i=0; i< getNumAccounts(); i++) {
			if (accno == getAccount(i).accno)
				return ( getAccount(i) );				
		}

		return null;
	}

	// ������ �۾����� ������ ��ȯ�ϴ� �޼ҵ�
	public static int getNumTransactions() {
		return transactions.size();
	}

	static void addToTransactions(Transaction tr) {
		transactions.add(tr);
	}

	//�־��� ������ �۾������� ��ȯ(������ 0����)�ϴ� �޼ҵ�
	public static Transaction getTransaction(int which) {
		return transactions.elementAt(which);
	}

	// �־��� ���¹�ȣ�� ���� �۾��������� ã�� ���ͷ� ��ȯ�ϴ� �޼ҵ�
	public static Vector<Transaction> findTransactions(int accno)  {
		Vector<Transaction>  trs = new Vector<Transaction> ();
		Transaction tr;

		for(int i=0; i< getNumTransactions(); i++) {
			tr = getTransaction(i);
			if (accno == tr.getAccount().accno)
				trs.add( tr );				
		}

		return trs;
	}
	
	// ����� ����ϴ� �޼ҵ�
	static Banker enrolBanker(String bankerType, String bname, String ID, char[] password, String branch) {
		int bno = BankSystem.getNextBno(bankerType);            // ����� ��ȣ - �������� ���������� ���� �ٸ��� ��ȣ �ο�
		Date dateHired = new Date();     // �Ի���
		
		Banker banker = new Banker(bankerType, bno, bname, ID, password, dateHired, branch);
		
		bankers.add(banker);
		
		return banker;
	}

	// �־��� ����� ID�� ������ ����� ID�� �ߺ��Ǵ°��� �˻��Ͽ� �ߺ��Ǹ� true, �ƴϸ� false�� ��ȯ
	public static boolean isThereSameID(String ID) {
		for (Banker b : bankers)
			if (b.ID.equals(ID))  // ���� banker�� ID�� �ߺ��Ǹ� false ��ȯ
				return true;
		
		return false;
	}

	static int nextBno[] = { 1, 1 };

	// ������, �������� �Ǵ� ���뿹��, ���࿹�ݿ� ���� ������ȣ�� �Ҵ�
	static int getNextBno(String bankerType) {
		int next = 0;


		if (bankerType.equals("������"))  // 10000 + next
			next = nextBno[0]++ + 10000;
		else
			next = nextBno[1]++ + 20000;		

		return next;

	}

	// �ʱ� ���¿� �۾����� ������ ���� �ʱ�ȭ �κ�
	public static void initializeBank() {
		try {
			Account acc1 = openAccount(1, "ȫ�浿", 10000, 1234);  // ���뿹�� ����
			deposit(acc1, 1000000, "��û");
			deposit(acc1.getAccno(), 2500000, "��û");
			withdraw(acc1, 1000, "ȫ�浿", 1234);

			Account acc2 = openAccount(2, "�ڹ���", 2000, 1234);  // ���࿹�� ����
			deposit(acc2, 5000, "��û");
			deposit(acc2.getAccno(), 7500, "ȫ�浿");
			withdraw(acc2, 1000, "�ڹ���", 1234);
			transfer(acc1, acc2, 50000, "ȫ�浿", 1234);

		}
		catch(Exception e) {
			System.out.println(" --- error: " + e.getMessage());
		}
	}
}
