package ex9_4_account_exception;

/**
* [ AccountException, Account, AccountExceptionWithdraw 클래스 ] : 
*      계좌에 대한 예외 처리하기 위한 사용자 작성 예외 클래스를 정의하여 계좌 예외 처리를 보여주는 예제
*      
*   o AccountException 클래스: Account 클래스의 예외 처리를 위한 예외 클래스 
*     - Account 클래스에서 예외가 발생하면 예외객체를 생성하기 위한 클래스
*     - Exception 클래스의 하위 클래스
*     - 예외 클래스는 클래스 자체가 예외의 종류를 나타내며, 객체 생성자만 선언
*/

// 사용자 작성 예외 클래스는 객체 생성자만 작성하면 됨
class AccountException extends Exception {   
   public AccountException() {  // 매개변수 없는 객체 생성자
       super();
   }

   // 예외 관련 정보를 객체에 저장하는 객체 생성자로, 이 정보가 예외 처리에서 사용됨
   public AccountException(String msg) { 
       super(msg); // 상위 클래스 Exception의 객체 생성자를 호출하여 msg를 저장
   }
}

class Account {		 
	static int nextAccountNo = 10001; // 계좌번호를 할당하기 위한 클래스 필드

	int accountNo; String ownername; int balance; // 계좌 번호, 소유자이름, 잔고

	// 객체 생성자: 계좌번호를 할당하고, 주어진 이름을 소유자 이름으로 저장함
	Account(String name) {
		// nextAccountNo를 생성된 계좌의 계좌번호로 할당하고, 다음 계좌를 위해 1 증가
		this.accountNo = nextAccountNo++;  
		this.ownername = name; 
		this.balance = 0;
	}

	// 입금을 처리하는 메소드 - 주어진 금액만큼 잔액을 감소시키는 입금처리 메소드
	//   이 메소드는 입금액이 0 이하인 경우에도 입금을 처리하도록 작성됨
	int deposit(int amount) {
		this.balance  += amount;
		return this.balance;
	}

	/* 
	 * withdraw(): 출금액이 0 이하 또는 잔액 초과이면 출금하지 않고 예외 발생함      
	 *   예외 관련 정보를 Exception 예외객체에 저장하고 예외객체를 던짐
	 */
	int withdraw(int amount) throws AccountException { // 3) 예외 클래스 명시
		if (amount > 0 && amount <= balance)
			balance -= amount;  // 출금액이 0보다 크고 잔액 이하이면 출금 처리
		else {
			if (amount <= 0) 
				// 출금액 0 이하이면 1) 예외 내용을 예외객체에 저장, 2) 예외객체를 던짐
				throw new AccountException("0보다 작거나 같은 출금액: " + amount);    
			else if (amount > this.balance) 
				// 출금액이 잔액 초과이면 1) 예외 내용을 예외객체에 저장, 2) 예외객체를 던짐
				throw new AccountException("잔액 " + balance + "보다 큰 출금액: " + amount);  
		} 
		return balance;
	} 

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "계좌번호: " + accountNo + ", 이름: " + this.ownername 
				+ ", 잔액: " + this.balance;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	} 
}

class Ex9_4_AccountExceptionWithdraw {
	public static void main(String[] args) {
		Account acc = new Account("김철수"); // 김철수의 계좌를 생성, 초기 잔고 0원
		acc.output("\n  * 출금 전 김철수 계좌 - ");
        
		// <참고> 여기에서 잔고보다 큰 1000을 입력하여 예외를 발생시킴
		int amount = SkScanner.getInt("\n  o 출금할 금액 > ");  

		// Java에서 예외 처리 방법: try-catch 블록으로 예외객체를 잡아 처리함
		try { 
			acc.withdraw(amount); // 예외 발생하면 AccountException 객체를 던짐
			acc.output("\n  * << acc.withdraw(amount); >> 후의 김철수 계좌 - ");
		}
		catch(AccountException  e) {  // 던져진 AccountException 객체를 잡아 e에 저장하여 예외 처리함
			System.out.println("\n  ??? 예외객체의 예외 메시지 = '" + e.getMessage() + "'");
		}

		acc.output("\n  * 김철수 계좌 - ");

	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Account 클래스에서 출금할 때 출금액이 음수이거나 잔액보다 클 때
 *      AccountException 클래스의 예외객체를 생성하여 예외를 발생시키고 
 *      이를 탐지하고 처리한다.
 *
 *   2) 출금액을 음수 또는 잔액보다 큰 금액으로 입력한 후 프로그램의 실행 결과를 확인하라.
 *   

 * [ 실습과제 ]
 *  
 *   o int deposit(int amount) 메소드는 입금액이 0 이하인 경우에도 입금 처리를 한다.
 *   
 *     정상적인 입금은 입금액이 0보다 커야 한다. 0원 이하의 입금액이 주어지면 예외 처리를 하도록
 *     int deposit(int amount) 메소드를 예외발생 메소드로 변경하라. 
 *     
 *     deposit(int amount) 메소드는  AccountException 예외객체를 던지고 
 *     main()에서 이 메소드를 호출하면서 예외 탐지 및 처리한다. 
 */
