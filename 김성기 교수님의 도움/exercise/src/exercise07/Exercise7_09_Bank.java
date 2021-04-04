package exercise07;

/**
 * [ 7장 연습문제  9 ]:
 *   
 *   9. 다음의 계좌 관련 클래스에 대해 답하라. 
 *   
 *     1) 1) LoanAccount 클래스의 상속된 필드와 메소드, 그리고 자체의 필드와 메소드를 나열하라. 
 *        (Object 클래스에서 상속된 특성은 무시한다.) 
 *        
 *     2) << Account(int accno, String ownername, int balance) { ... } >>는 언제 수행되며, 
 *        어떠한 일들이 이루어지는가를 설명하시오.
 *        
 *     3) << Account a3 = new LoanAccount(10003, "심청", 0, 5000000); >>이 수행되면 
 *        어떠한 일들이 이루어지는지 설명하라.
 *        
 *     4) << a3.withdraw(510000); >>이 수행되는 과정과 결과를 설명하라.
 *     
 *     5) LoanAccount 클래스의 output() 메소드는 LoanAccount 클래스의 모든 필드를 출력하는 메소드이며, 
 *        Account 클래스의 output() 메소드를 오버라이딩한 메소드이다. output() 메소드를 작성하라.
 *        
 *     6) 프로그램의 출력결과를 구하라.
 */

class Account{  // 계좌 클래스                 
	int accno;   String ownername;   int balance; // 잔고
	static int noAccount = 0;

	Account(int accno, String ownername, int balance) {
		this.accno = accno; this.ownername = ownername; this.balance = balance;
		++noAccount;
	}

	void output() {  
		System.out.println("\n  * accno: " + accno + ", ownerName: " + ownername
				+ ", balance: " + balance);
	} 

	int deposit(int amount) { 		 // 예금 처리 메소드 - 입금 금액만큼 잔고를 증가시킴
		balance = balance + amount;
		return balance;
	}

	void withdraw(int amount) {  	// 출금 - 잔고가 출금 금액보다 크면 잔고 감소시킴
		if (balance > amount) 
			balance = balance - amount;
	} 

}	

//계좌 클래스를 확장한 대출계좌 클래스
class LoanAccount extends Account {  
	int loanLimit;     // 대출한도: 대출한도만큼 더 출금할 수 있음, 잔고 음수 가능 

	LoanAccount(int accno,String ownerName, int balance, int loanLimit) {
		super(accno,ownerName, balance);
		this.loanLimit = loanLimit;
	} 

	void withdraw(int amount) {   			// 대출한도를 고려하여 출금 처리
		if (balance - amount > -loanLimit)	// 대출한도까지 잔고가 부족해도 OK
			balance = balance - amount;
	}
} 

class Exercise7_09_Bank {
	public static void main(String[] args) {
		Account a3 = new LoanAccount(10003, "심청", 0, 5000000);
		a3.deposit(10000);
		a3.withdraw(510000);
		a3.output();
		System.out.println("\n  * noAccount: " + Account.noAccount);
	}
}