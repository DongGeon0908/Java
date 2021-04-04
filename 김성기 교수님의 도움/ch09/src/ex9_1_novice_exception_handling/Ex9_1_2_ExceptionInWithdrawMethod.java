package ex9_1_novice_exception_handling;

/**
 * [ Account, ExceptionInWithdrawMethod 클래스 ] : 
 *       출금 처리에서 초보적 예외 대처방법을 구현한 프로그램
 * 
 *   o Account 클래스에서 출금할 때의 예외를 4가지 초보적 방법으로 처리하여 문제점을 파악함
 *     - Java에서 예외 처리의 필요성을 느껴볼 것
 */

class Account {
	String exceptionMsg; // 예외 발생하면 오류 메시지 저장하는 필드

	static int nextAccountNo = 10001; // 계좌번호를 할당하기 위한 클래스 필드

	int accountNo; String ownername; int balance; // 계좌 번호, 소유자이름, 잔고

	// 객체 생성자: 계좌번호를 할당하고, 주어진 이름을 소유자 이름으로 저장함
	Account(String name) {
		// nextAccountNo를 생성된 계좌의 계좌번호로 할당하고, 다음 계좌를 위해 1 증가
		this.accountNo = nextAccountNo++;  
		this.ownername = name; 
		this.balance = 0;
	}	
 
	// 입금을 처리하는 메소드 – 주어진 금액만큼 잔액을 감소시키는 입금처리 메소드
	//                  이 메소드는 입금액이 0 이하인 경우에도 입금을 처리하도록 작성됨
	int deposit(int amount) {
		this.balance  += amount;
		return this.balance;
	}

	// withdraw1() : 출금액 음수이거나 잔액보다 큰 경우에도 출금 처리함 
	//               예외를 무시하고 예외 처리하지 않음(잔액 음수가 되는 문제 발생 가능)
	int withdraw1(int amount) {
		this.balance -= amount; // amount만큼 잔액을 감소시킴 -> 잔액 음수 가능
		return this.balance;
	}  

	// withdraw2() : 출금액이 음수이거나 출금액이 잔액보다 크면 출금하지 않음
	//               예외 발생 상황을 알리지 않는 문제가 있음
	int withdraw2(int amount) {
		if (amount > 0 && amount <= this.balance)
			this.balance -= amount;  // 출금액 0보다 크고 잔액보다 작으면 정상 출금 처리
		return this.balance;
	} 

	// withdraw3() : 출금액 음수이거나 출금액이 잔액보다 크면 출금하지 않고 
	//               오류 메시지를 출력함: 예외가 발생한 곳에서 예외 처리함
	int withdraw3(int amount) {
		if (amount > 0 && amount <= this.balance) // 출금액 0보다 크고 잔액 이하이면
			this.balance -= amount;               //   정상 출금 처리
		else if (amount <= 0)                     // 출금액이 0 이하이면 오류 메시지 출력
			System.out.println("\n  !!! 오류 - " +  "출금액이 0보다 작거나 같음: "
					+ amount);  
		else if (amount > this.balance)           // 출금액이 잔액 초과이면 오류 메시지 출력
			System.out.println("\n  !!! 오류 - " +  "잔액 " + this.balance 
					+ "보다 큰 출금액: " + amount);  

		return this.balance;
	} 

	// withdraw4() : 출금액이 음수이거나 출금액이 잔액보다 크면 출금하지 않고 예외
	//               메시지 필드에 오류 상황 정보를 저장함: 예외를 다른 곳에서 처리하게 함
	int withdraw4(int amount) {
		if (amount > 0 && this.balance >= amount) { // 출금액 0보다 크고 잔액 이하이면 
			this.balance -= amount;                 //   정상 출금 처리
		    exceptionMsg = null;                    //   예외 없으므로 exceptionMsg에 null 저장
		}
		else if (amount <= 0)                       // 출금액 0 이하이면 예외 메시지를 exceptionMsg에 저장
			exceptionMsg = "0보다 작거나 같은 출금액: " + amount;
		else if (amount >= this.balance)            // 출금액 잔액 초과이면 예외 메시지를 exceptionMsg 필드에 저장함
			exceptionMsg = "잔액 " + this.balance + "보다 큰 출금액: " + amount;  

		return this.balance;
	} 

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "계좌번호: " + this.accountNo + ", 이름: " + this.ownername 
				+ ", 잔액: " + this.balance;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	} 
}

class Ex9_1_2_ExceptionInWithdrawMethod {
	public static void main(String[] args) {
		Account acc = new Account("김철수"); // 김철수의 계좌를 생성 
		
		int amount = SkScanner.getInt("\n  <참고> 여기에서 현 잔고 0보다 큰 금액을 입력하여 예외를 발생시킴\n\n  o 출금할 금액 > ");

		acc.withdraw1(amount);  // 예외 처리 하지 않음
		acc.output("\n  * << acc.withdraw1(" + amount + "); >> 후의 김철수 계좌 - ");

		acc.deposit(amount);    // 출금한 만큼 예금하여 음수이었던 잔고를 다시 0으로 만듦

		acc.withdraw2(amount);  // 예외 발생하면 출금 않음
		acc.output("\n  * << acc.withdraw2(" + amount + "); >> 후의 김철수 계좌 - ");

		acc.withdraw3(amount);  // 예외 발생하면 출금 않고 예외 내용을 출력
		acc.output("  * << acc.withdraw3(" + amount + "); >> 후의 김철수 계좌  - ");

		acc.withdraw4(amount);  // 예외 발생하면 예외 내용을 exceptionMsg 필드에 저장  
		acc.output("\n  * << acc.withdraw4(" + amount + "); >> 후의 김철수 계좌 - ");

		// 예외가 발생하면 exceptionMsg 필드가 null 아니므로 이를 검사하여 예외 처리   
		if (acc.exceptionMsg != null) {  
			System.out.println("  !!! << acc.withdraw4(); >>에서 예외 발생: "
					+ acc.exceptionMsg);    
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 계좌 출금 메소드에서 예외 처리하는 초보적인 여러 방법을 보여준다.
 * 
 *   2) 메소드 withdraw1(), withdraw2(), withdraw3(), withdraw4()를 호출하여  
 *      출금 시 예외가 여러 방법으로 처리되게 한다. 
 *
 *   3) 프로그램의 실행 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *  
 *   o 입금액은 0보다 커야 한다. 0원 이하의 입금액이 주어지면 예외 처리하기 위한 
 *     가장 적합한 방법을 고안하여 int deposit(int amount) 메소드를 변경하라.
 */
