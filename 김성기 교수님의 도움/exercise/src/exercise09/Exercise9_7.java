package exercise09;

/**
 * [ 9장 연습문제 7 ]
 * 
 *   7. 한 은행에서 계좌를 생성할 때 계좌번호, 소유자 이름, 이체한도가 주어지면 그 정보의 계좌를 생성한다. 
 *      계좌에서 다른 계좌로 이체할 때 이체 금액이 0보다 크고 잔고보다 작거나 같아야 한다. 
 *      또한, 이체 금액이 이체 한도보다 적어야 한다. 한 계좌 객체에서 다른 계좌 객체로 이체송금을 하려고 
 *      다음의 프로그램을 작성했으며, 여기에서 이체에 대한 예외 처리가 되지 않은 상태이다.
 *      
 *      1) 프로그램의 실행결과를 보여라. 
 *      
 *      2) transferTo() 메소드의 문제점을 설명하라. 
 *      
 *      3) transferTo() 메소드에서 예외 상황이 발생하면 예외 메시지를 이 메소드에서 직접 출력하도록 메소드를 변경하라. 
 *        (예외 상황이 발생하면 이체를 수행하지 않고 예외 메시지만 출력 )
 *        
 *      4) transferTo() 메소드에서 예외 상황이 발생하면 예외객체를 생성하여 던지고, 호출한 main() 메소드에서 
 *         이를 탐지하고 처리하도록 프로그램을 변경하라. (필요한 부분만 변경하면 됨) 
 */

class Account {
	// 계좌번호, 소유자, 잔고, 이체한도
	int accno; String owner; int balance, transferLimit; 

	Account(int accno, String owner, int transferLimit) {
		this.accno = accno;                   this.owner = owner;   
		this.transferLimit = transferLimit;   this.balance = 0;
	}

	void deposit(int amount) {  // 입금 메소드
		balance += amount;
	}

	// 이 계좌에서 주어진 accountTo 계좌로 이체하는 메소드
	void transferTo(Account accountTo, int amount) {
		this.balance -= amount;
		accountTo.balance += amount;
	}
}

class Exercise9_7 {

	public static void main(String[] args) {
		Account acc1 = new Account(10001, "홍길동", 10000);
		Account acc2 = new Account(10002, "박문수", 10000);
		acc1.deposit(50000);
		acc1.transferTo(acc2, 80000);

		System.out.println("acc1의 잔고 = " + acc1.balance 
				+ ", acc2의 잔고 = "  + acc2.balance);
	}  
}     