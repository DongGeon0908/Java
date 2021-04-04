package exercise07;

/**
 * [ 7�� ��������  9 ]:
 *   
 *   9. ������ ���� ���� Ŭ������ ���� ���϶�. 
 *   
 *     1) 1) LoanAccount Ŭ������ ��ӵ� �ʵ�� �޼ҵ�, �׸��� ��ü�� �ʵ�� �޼ҵ带 �����϶�. 
 *        (Object Ŭ�������� ��ӵ� Ư���� �����Ѵ�.) 
 *        
 *     2) << Account(int accno, String ownername, int balance) { ... } >>�� ���� ����Ǹ�, 
 *        ��� �ϵ��� �̷�����°��� �����Ͻÿ�.
 *        
 *     3) << Account a3 = new LoanAccount(10003, "��û", 0, 5000000); >>�� ����Ǹ� 
 *        ��� �ϵ��� �̷�������� �����϶�.
 *        
 *     4) << a3.withdraw(510000); >>�� ����Ǵ� ������ ����� �����϶�.
 *     
 *     5) LoanAccount Ŭ������ output() �޼ҵ�� LoanAccount Ŭ������ ��� �ʵ带 ����ϴ� �޼ҵ��̸�, 
 *        Account Ŭ������ output() �޼ҵ带 �������̵��� �޼ҵ��̴�. output() �޼ҵ带 �ۼ��϶�.
 *        
 *     6) ���α׷��� ��°���� ���϶�.
 */

class Account{  // ���� Ŭ����                 
	int accno;   String ownername;   int balance; // �ܰ�
	static int noAccount = 0;

	Account(int accno, String ownername, int balance) {
		this.accno = accno; this.ownername = ownername; this.balance = balance;
		++noAccount;
	}

	void output() {  
		System.out.println("\n  * accno: " + accno + ", ownerName: " + ownername
				+ ", balance: " + balance);
	} 

	int deposit(int amount) { 		 // ���� ó�� �޼ҵ� - �Ա� �ݾ׸�ŭ �ܰ� ������Ŵ
		balance = balance + amount;
		return balance;
	}

	void withdraw(int amount) {  	// ��� - �ܰ� ��� �ݾ׺��� ũ�� �ܰ� ���ҽ�Ŵ
		if (balance > amount) 
			balance = balance - amount;
	} 

}	

//���� Ŭ������ Ȯ���� ������� Ŭ����
class LoanAccount extends Account {  
	int loanLimit;     // �����ѵ�: �����ѵ���ŭ �� ����� �� ����, �ܰ� ���� ���� 

	LoanAccount(int accno,String ownerName, int balance, int loanLimit) {
		super(accno,ownerName, balance);
		this.loanLimit = loanLimit;
	} 

	void withdraw(int amount) {   			// �����ѵ��� ����Ͽ� ��� ó��
		if (balance - amount > -loanLimit)	// �����ѵ����� �ܰ� �����ص� OK
			balance = balance - amount;
	}
} 

class Exercise7_09_Bank {
	public static void main(String[] args) {
		Account a3 = new LoanAccount(10003, "��û", 0, 5000000);
		a3.deposit(10000);
		a3.withdraw(510000);
		a3.output();
		System.out.println("\n  * noAccount: " + Account.noAccount);
	}
}