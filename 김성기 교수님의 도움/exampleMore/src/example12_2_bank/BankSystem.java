package example12_2_bank;

import java.util.Date;
import java.util.Vector;

// BankSystem: 은행 데이터 저장하고 업무를 처리하는 메소드를 갖는 클래스
class BankSystem  {

	// Account 객체 저장소 accounts - Account 객체가 생성되면  accounts 벡터에 저장
	//    accounts 벡터는 생성된 Account 객체 전부를 저장하여 관리
	private static Vector<Account> accounts = new Vector<Account>();  // Account 객체 전부를 저장하여 관리
	
	// Transaction 객체 저장소 transactions : Transaction 객체가 생성되면  transactions 벡터에 저장
	//    transactions 벡터는 생성된 Transaction 객체 전부를 저장하여 관리
	static Vector<Transaction> transactions = new Vector<Transaction>();  // Transaction 객체 전부를 저장하여 관리
	
	// Banker 객체 저장소 bankers : Banker 객체가 생성되면  bankers 벡터에 저장
	//    bankers 벡터는 생성된 Banker 객체 전부를 저장하여 관리
	static Vector<Banker> bankers = new Vector<Banker>();  // Banker 객체 전부를 저장하여 관리
	
	private static int nextSerial[] =  { 1,  1 };  // 보통예금과 저축예금에 대한 다음 계좌번호를 할당하기 위한 정수 배열

	static String trTypeName[] =  {"", "입금", "출금", "이체출금", "이체입금" };

	// 계좌 개설
	static Account openAccount(int accType, String owner, int initAmount, int password) {

		int accno = BankSystem.getNextAccno(accType);  // 계좌 번호 결정
		Date openDate = new Date();                    // 개설일 결정

		// 계좌 객체 생성하여 accounts 벡터에 저장
		Account newAccount = new Account(accno, accType, owner, openDate, initAmount, password);
		BankSystem.addToAccounts(newAccount);

		// 작업내역 객체 생성하여 transactions 벡터에 저장
		Transaction newTr = new Transaction(newAccount, "입금", owner, initAmount, initAmount);  // 입금사항을 트랜잭션에 기록
		BankSystem.addToTransactions(newTr);

		return newAccount;
	}

	// 주어진 입금계좌에 금액만큼 입금
	public static Account deposit(Account inAcc, int amount, String customer){

		inAcc.deposit(amount);

		BankSystem.addToTransactions(new Transaction(inAcc, "입금", customer, amount, inAcc.getBalance()));

		return inAcc;	
	}

	// 주어진 입금계좌번호의 계좌에 금액만큼 입금
	public static Account deposit(int inAccno, int amount, String customer) throws Exception {

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			if (acc.accno == inAccno) {
				acc.deposit(amount);

				BankSystem.addToTransactions(new Transaction(acc, "입금", customer, amount, acc.getBalance()));

				return acc;
			}
		}

		throw new Exception("입금계좌가 존재하지 않습니다.");			
	}

	// 계좌 출금
	public static Account withdraw(Account outAcc, int amount, String customer, int password) throws Exception {

		if (! outAcc.isValidPassword(password))
			throw new Exception("비밀번호가 일치하지 않습니다.");

		if(outAcc.getBalance() >= amount) {
			outAcc.withdraw(amount);

			BankSystem.addToTransactions(new Transaction(outAcc, "출금", customer, amount, outAcc.getBalance()));

			return outAcc;
		}
		else  { 
			throw new Exception("잔액이 부족합니다.");
		}			
	}

	// 계좌 출금
	public static Account withdraw(int outAccno, int amount, String customer, int password) throws Exception {

		for(int i=0; i<getNumAccounts(); i++) {
			Account acc = getAccount(i);
			if (acc.accno == outAccno) {
				withdraw(acc, amount, customer, password);
				return acc;
			}
		}

		throw new Exception("출금 계좌가 존재하지 않습니다.");
	}

	// 계좌 이체
	static void transfer(Account outAcc, Account inAcc, int amount, String customer, int password) throws Exception  {
		if (! outAcc.isValidPassword(password))
			throw new Exception("이체출금 계좌의 비밀번호가 일치하지 않습니다.");

		if(outAcc.getBalance() >= amount) {   // 잔고가 이체금액보다 많은가를 확인
			outAcc.withdraw(amount);
			inAcc.deposit(amount);

			BankSystem.addToTransactions(new Transaction(outAcc, "이체출금", customer, amount, outAcc.getBalance()));
			BankSystem.addToTransactions(new Transaction(inAcc, "이체입금", customer, amount, inAcc.getBalance()));
		}
		else throw new Exception("잔액이 부족합니다.");
	}

	// 소유자 정보 구하기
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

	// 모든 계좌의 종합 정보를 구하여 배열로 반환
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

	// 주어진 계좌의 모든 작업내역을 작업내역 배열에 저장하여 반환
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

	// 주어진 종류의 계좌에 대해 다음 계좌번호를 생성하는 메소드
	// 계좌종류(1. 보통예금 2. 저축예금)
	static int getNextAccno(int accType)  {
		int accno;
		accno = accType * 100000 + nextSerial[accType-1];
		nextSerial[accType-1]++;
		
		return accno;
	}

	// 모든 계좌를 Account 배열에 저장하여 반환
	static Account[] getAllAccounts() {
		int size = accounts.size();

		Account[] accs = new Account[size];

		for (int i = 0; i < size; i++) 
			accs[i] = getAccount(i);

		return accs;
	}
	
	// 모든 계좌 번호를  String 배열에 저장하여 반환
	static String[] getAllAccnos() {
		int size = accounts.size();

		String[] accnos = new String[size];

		for (int i = 0; i < size; i++) 
			accnos[i] = "" + getAccount(i).accno;

		return accnos;
	}

	// 계좌를 accounts 벡터에 저장하는 메소드
	static void addToAccounts(Account acc) {
		accounts.add(acc);
	}

	// 현재의 계좌 개수를 반환하는 메소드
	public static int getNumAccounts() {
		return accounts.size();
	}

	//주어진 순번의 계좌를 반환(순번은 0부터)하는 메소드
	public static Account getAccount(int which) {
		return accounts.elementAt(which);  // 또는 get(which)
	}

	// 주어진 계좌번호의 계좌를 찾아 반환하는 메소드
	public static Account findAccount(int accno)  {
		for(int i=0; i< getNumAccounts(); i++) {
			if (accno == getAccount(i).accno)
				return ( getAccount(i) );				
		}

		return null;
	}

	// 현재의 작업내역 개수를 반환하는 메소드
	public static int getNumTransactions() {
		return transactions.size();
	}

	static void addToTransactions(Transaction tr) {
		transactions.add(tr);
	}

	//주어진 순번의 작업내역을 반환(순번은 0부터)하는 메소드
	public static Transaction getTransaction(int which) {
		return transactions.elementAt(which);
	}

	// 주어진 계좌번호의 계좌 작업내역들을 찾아 벡터로 반환하는 메소드
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
	
	// 은행원 등록하는 메소드
	static Banker enrolBanker(String bankerType, String bname, String ID, char[] password, String branch) {
		int bno = BankSystem.getNextBno(bankerType);            // 은행원 번호 - 정규직과 비정규직에 따라 다르게 번호 부여
		Date dateHired = new Date();     // 입사일
		
		Banker banker = new Banker(bankerType, bno, bname, ID, password, dateHired, branch);
		
		bankers.add(banker);
		
		return banker;
	}

	// 주어진 은행원 ID가 기존의 은행원 ID와 중복되는가를 검사하여 중복되면 true, 아니면 false를 반환
	public static boolean isThereSameID(String ID) {
		for (Banker b : bankers)
			if (b.ID.equals(ID))  // 기존 banker와 ID가 중복되면 false 반환
				return true;
		
		return false;
	}

	static int nextBno[] = { 1, 1 };

	// 정규직, 비정규직 또는 보통예금, 저축예금에 대한 순서번호를 할당
	static int getNextBno(String bankerType) {
		int next = 0;


		if (bankerType.equals("정규직"))  // 10000 + next
			next = nextBno[0]++ + 10000;
		else
			next = nextBno[1]++ + 20000;		

		return next;

	}

	// 초기 계좌와 작업내역 생성을 위한 초기화 부분
	public static void initializeBank() {
		try {
			Account acc1 = openAccount(1, "홍길동", 10000, 1234);  // 보통예금 개설
			deposit(acc1, 1000000, "심청");
			deposit(acc1.getAccno(), 2500000, "심청");
			withdraw(acc1, 1000, "홍길동", 1234);

			Account acc2 = openAccount(2, "박문수", 2000, 1234);  // 저축예금 개설
			deposit(acc2, 5000, "심청");
			deposit(acc2.getAccno(), 7500, "홍길동");
			withdraw(acc2, 1000, "박문수", 1234);
			transfer(acc1, acc2, 50000, "홍길동", 1234);

		}
		catch(Exception e) {
			System.out.println(" --- error: " + e.getMessage());
		}
	}
}
