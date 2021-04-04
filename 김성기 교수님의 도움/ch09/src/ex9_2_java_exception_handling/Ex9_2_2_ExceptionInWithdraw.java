package ex9_2_java_exception_handling;

/**
 * [  Account, ExceptionInWithdrawMethod 클래스 ] :
 *       계좌에서 음수 금액 또는 잔액 초과 출금의 경우 Java의 예외 처리 방법을 보여주는 예제
 *  
 *   o Java에서의 예외 처리
 *     - 메소드 수행 도중에 예외가 발생할 경우
 *       1) 예외객체 생성하여 예외 관련 정보 저장하고 이를 호출한 메소드로 던짐
 *       2) 호출한 메소드에서 던져진 예외객체 잡아 예외 처리 
 * 
 *   o Java에서의 예외 처리 예
 *     - setAge() 메소드에서 age 필드에 저장할 나이가 음수인 경우
 *       1) 이를 저장하지 않고 발생한 예외 관련 정보를 예외객체에 저장하고 예외객체 던짐
 *       2) setAge() 메소드 호출한 메소드에서 던져진 예외객를 잡아 예외 처리
 *       
 *    - withdraw() 메소드의 출금 과정에서 출금액이 0 이하 또는 잔액보다 큰 경우
 *       1) 예외객체 생성하여 예외 관련 정보를 예외객체에 저장하고 던짐
 *       2) 호출한 메소드에서 예외객체 잡아 예외 처리
 * 
 *   o Java 예외 처리의 특징: 예외 발생과 처리의 분리
 *     - 처음에 Java의 예외 처리를 접하게 되면 약간 독특하면서 어렵게 보임
 *     - 왜냐하면 예외 발생하는 곳에서 예외 처리되는 것이 아니라 다른 곳에서 예외 처리
 *     - 이는 Java의 예외 처리에서 가장 중요한 핵심사항
 *     - 예외 발생시키는 부분과 발생된 예외 탐지하고 처리하는 부분이 서로 분리됨 
 */

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

	// 입금을 처리하는 메소드 – 주어진 금액만큼 잔액을 감소시키는 입금처리 메소드
	//   이 메소드는 입금액이 0 이하인 경우에도 입금을 처리하도록 작성됨 - 오류 발생 메소드로 작성해보라
	int deposit(int amount) {
		this.balance  += amount;
		return this.balance;
	}

	/* 
	 * withdraw(): 출금액이 0 이하 또는 잔액 초과이면 출금하지 않고 예외 발생함      
	 *   예외 관련 정보를 Exception 예외객체에 저장하고 예외객체를 던짐
	 */
	int withdraw(int amount) throws Exception { // 3) 예외 클래스 명시
		if (amount > 0 && amount <= balance)
			balance -= amount;  // 출금액이 0보다 크고 잔액 이하이면 출금 처리
		else {
			if (amount <= 0) 
				// 출금액 0 이하이면 1) 예외 내용을 예외객체에 저장, 2) 예외객체를 던짐
				throw new Exception("0보다 작거나 같은 출금액: " + amount);    
			else if (amount > balance) 
				// 출금액이 잔액 초과이면 1) 예외 내용을 예외객체에 저장, 2) 예외객체를 던짐
				throw new Exception("잔액 " + balance + "보다 큰 출금액: " + amount);  
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

class Ex9_2_2_ExceptionInWithdraw {
	public static void main(String[] args) {
		Account acc = new Account("김철수"); // 김철수의 계좌를 생성 

		System.out.println("\n  <참고> 현재 잔고 " + acc.balance + "원 보다 큰 금액 입력하여 예외 발생시킴");
		int amount = SkScanner.getInt("\n  o 출금할 금액 > ");  

		// Java에서 예외 처리 방법: try-catch 블록으로 예외객체를 잡아 처리함
		try { 
			acc.withdraw(amount); // 예외 발생하면 Exception 객체를 던짐
			acc.output("\n  * << acc.withdraw(amount); >> 후의 김철수 계좌 - ");
		}
		catch(Exception e) {      // 던져진 Exception를 잡아 예외 처리함
			System.out.println("\n  * 예외객체의 예외 메시지 = '" + e.getMessage() + "'");
			acc.output("\n  * << catch(Exception e) >> 후의 김철수 계좌 - ");
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Account 클래스에서 출금할 때 출금액이 음수이거나 잔액보다 클때 예외를 발생시키고 
 *      이를 탐지하고 처리한다.
 *
 *   2) 출금액을 음수 또는 잔액보다 큰 금액으로 입력한 후 프로그램의 실행 결과를 확인하라.
 *   
 *   3) try-catch 블록을 제거한 후 어떠한 오류가 발생하는 가를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *  
 *   o 입금을 처리하는 int deposit(int amount) 메소드를 입금액이 0 이하이면 예외를 
 *     발생시키는 메소드로 작성하려 한다.
 *  
 *     1) 금액 amount가 주어지면 이를 잔고에 증가시키는 int deposit(int amount) 메소드를 예외발생 메소드로 작성하라.
 *     
 *     2) main() 메소드에서 -1000을 매개변수로 하여  deposit(-10000) 메소드를 호출한 후  acc 객체를 
 *        출력하라. 메소드 호출 할 때에는 try-catch 블록으로 예외 처리를 하라.
 */
