package example12_2_bank;

import java.util.Date;
import java.util.Vector;

// BankMainUsingConsole: 컨솔 입출력으로 은행 업무를 처리하는 클래스
class BankMainUsingConsole  {

	public static void main(String args[]) {
		BankSystem.initializeBank(); // 미리 계좌를 생성하고 입출금을 수행하는 초기화 메소드 호출

		int menu=0;
		while(menu != 9) {
			System.out.println("\n\n<< 은행 업무 처 리 시스템 (Vector 사용, 예외처리 ) >>");
			System.out.println("   1. 계좌 개설       \t 2. 계좌 리스트");
			System.out.println("   3. 계좌 입금       \t 4. 계좌 출금");
			System.out.println("   5. 계좌 이체       \t 6. 소유자 정보 출력");
			System.out.println("   7. 작업내역 출력 \t 8. 계좌 종합정보");
			System.out.println("   9. 종료");
			System.out.print("\n   * 원하는 작업을 선택하시오 > ");

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
					throwException(menu + " - 잘못된 메뉴 선택입니다.");					
				}
			}
			catch(Exception e) {
				System.out.println("\n  ** 오류: "+e.getMessage()+"\n");
			}
		}
	}

	// 계좌 개설 -- 개설 후 개설된 계좌 정보 출력
	public static void openAccount() throws Exception  {
		int accType;

		System.out.println("\n-- 계좌 개설 --");

		do {  
			System.out.print("   * 계좌의 종류 (1. 보통예금 2. 저축예금) > ");
			accType = SkScanner.getInt();
		} while (accType !=1 && accType !=2) ;

		System.out.print("   * 소유자 성명 > ");
		String owner = SkScanner.getString();
		System.out.print("   * 초기 입금액 > ");
		int initAmount = SkScanner.getInt();

		if (initAmount < 0) 
			throw new Exception("초기잔액이 0보다 작습니다");

		System.out.print("   * 비밀번호 > ");
	    int password = SkScanner.getInt();

		Account newAccount = BankSystem.openAccount(accType, owner, initAmount, password);  // 계좌 객체 생성

		// 개설된 계좌 보여주기
		System.out.println("\n-- 개설 계좌  --");
		newAccount.output();
	}

	// 모든 계좌 리스트 메뉴 처리
	public static void listAccounts() {	
		Account acc;

		System.out.println("\n-- 모든 계좌 리스트 --");

		for(int i=0; i<BankSystem.getNumAccounts(); i++) {
			acc=BankSystem.getAccount(i);
			acc.output();
		}
	}

	// 계좌 입금 메뉴 처리
	public static void deposit() throws Exception {	
		Account acc=null;
		int amount;

		listAccounts();

		System.out.println("\n-- 계좌 입금 --");
		System.out.print("   * 계좌 번호 > ");
		int inAccNo=SkScanner.getInt();
		System.out.print("   * 입금 금액 > ");
		amount = SkScanner.getInt();
		System.out.print("   * 고객 성명 > ");
		String customer = SkScanner.getString();

		acc = BankSystem.deposit(inAccNo, amount, customer);

		System.out.println("\n-- 입금 계좌  --");
		acc.output();
	}

	// 계좌 출금 메뉴 처리 
	public static void withdraw() throws Exception {	
		Account acc = null;
		int amount;

		listAccounts();

		System.out.println("\n-- 계좌 출금 --");
		System.out.print("   * 계좌 번호 > ");
		int outAccno = SkScanner.getInt();
		System.out.print("   * 출금 금액 > ");
		amount = SkScanner.getInt();
		System.out.print("   * 고객 성명 > ");
		String customer = SkScanner.getString();
		System.out.print("   * 비밀번호 > ");
	    int password = SkScanner.getInt();

		acc = BankSystem.withdraw(outAccno, amount, customer, password);

		System.out.println("\n-- 출금 계좌  --");
		acc.output();
	}

	// 계좌 이체 메뉴 처리 
	public static void transfer() throws Exception {	
		int inAccno, outAccno;
		Account inAcc, outAcc;	
		int amount;

		listAccounts();

		System.out.println("\n-- 계좌 이체 --");
		System.out.print("   * 이체출금 계좌번호 > ");
		outAccno = SkScanner.getInt();
		System.out.print("   * 이체입금 계좌번호 > ");
		inAccno = SkScanner.getInt();
		System.out.print("   * 이체 금액 > ");
		amount = SkScanner.getInt();
		System.out.print("   * 고객 성명 > ");
		String customer = SkScanner.getString();
		System.out.print("   * 비밀번호 > ");
	    int password = SkScanner.getInt();

		outAcc = BankSystem.findAccount(outAccno);  // 주어진 번호의 계좌 탐색
		if (outAcc == null) {
			throw new Exception("이체출금 계좌가 존재하지 않습니다.");
		}

		inAcc = BankSystem.findAccount(inAccno);      // 주어진 번호의 계좌 탐색
		if (inAcc == null) {
			throw new Exception("이체입금 계좌가 존재하지 않습니다.");
		}	

		BankSystem.transfer(outAcc, inAcc, amount, customer, password);

		System.out.println("\n-- 이체출금 계좌  --");
		outAcc.output();

		System.out.println("\n-- 이체입금 계좌  --");
		inAcc.output();
	}

	// 소유자 성명 입력하여 소유자 계좌 정보 출력  메뉴 처리
	public static void 	outputOwnerInfo() { 
		Account acc;

		listAccounts();

		System.out.println("\n-- 소유자 정보 --");
		System.out.print("   * 소유자 성명 > ");
		String owner = SkScanner.getString();

		int[] infos = BankSystem.getOwnerInfo(owner);

		int noAcc = infos[0];
		int totAmount = infos[1];
		System.out.println("   "+owner+"의 총잔액 = "+totAmount+"  평균잔액 = "+(totAmount/noAcc));	
	}

	// 작업내역 출력 메뉴 처리: 계좌번호 입력하여 계좌에 대한 모든  작업내역 출력
	public static void 	outputTransactionInfo() throws Exception {
		Transaction tr;

		Account acc=null;

		listAccounts();

		System.out.println("\n-- 계좌 작업내역(입금, 출금, 이체 정보) 출력 --");
		System.out.print("   * 계좌 번호 > ");
		int accno = SkScanner.getInt();

		acc = BankSystem.findAccount(accno);  // 계좌 번호의 계좌를 찾음
		
		if (acc == null) { 
			throw new Exception("계좌가 존재하지 않습니다.");
		}

		System.out.println("\n  < 계좌 정보  >");
		acc.output();

		System.out.println("\n  < 계좌 작업내역 >");
		Transaction[] trs = BankSystem.getTransactionInfo(acc); // 주어진 계좌에 대한 작업내역들을 배열로 전달받음 

		for(int i=0; i< trs.length; i++) {  // 배열에 저장된 모든 작업내역들을 출력 
			trs[i].output();				
		}  
	}
	
	// 계좌 종합정보 출력 메뉴 처리: 모든 계좌의 계좌 개수, 총잔액, 평균잔액 등 종합정보 구하여 출력
	public static void 	outputAccountsInfo()  {	
		listAccounts();

		System.out.println("\n-- 계좌 종합정보 --");

		int[] infos = BankSystem.getAccountsInfo();

		int noAcc = infos[0];
		int totAmount = infos[1];
		int maxAmount = infos[2];

		System.out.println("    총 계좌개수 = "+noAcc+",  총잔액 = "+totAmount+",  평균잔액 = "+(totAmount/noAcc)+",  최대잔액 = "+maxAmount   );
	}
	
	// 주어진 message의 예외를 발생시키는 메소드
    static void throwException(String message) throws Exception {
    	throw new Exception(message);
    }
}
