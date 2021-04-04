package ex9_4_account_exception;

/**
* [ AccountException, Account, AccountExceptionWithdraw Ŭ���� ] : 
*      ���¿� ���� ���� ó���ϱ� ���� ����� �ۼ� ���� Ŭ������ �����Ͽ� ���� ���� ó���� �����ִ� ����
*      
*   o AccountException Ŭ����: Account Ŭ������ ���� ó���� ���� ���� Ŭ���� 
*     - Account Ŭ�������� ���ܰ� �߻��ϸ� ���ܰ�ü�� �����ϱ� ���� Ŭ����
*     - Exception Ŭ������ ���� Ŭ����
*     - ���� Ŭ������ Ŭ���� ��ü�� ������ ������ ��Ÿ����, ��ü �����ڸ� ����
*/

// ����� �ۼ� ���� Ŭ������ ��ü �����ڸ� �ۼ��ϸ� ��
class AccountException extends Exception {   
   public AccountException() {  // �Ű����� ���� ��ü ������
       super();
   }

   // ���� ���� ������ ��ü�� �����ϴ� ��ü �����ڷ�, �� ������ ���� ó������ ����
   public AccountException(String msg) { 
       super(msg); // ���� Ŭ���� Exception�� ��ü �����ڸ� ȣ���Ͽ� msg�� ����
   }
}

class Account {		 
	static int nextAccountNo = 10001; // ���¹�ȣ�� �Ҵ��ϱ� ���� Ŭ���� �ʵ�

	int accountNo; String ownername; int balance; // ���� ��ȣ, �������̸�, �ܰ�

	// ��ü ������: ���¹�ȣ�� �Ҵ��ϰ�, �־��� �̸��� ������ �̸����� ������
	Account(String name) {
		// nextAccountNo�� ������ ������ ���¹�ȣ�� �Ҵ��ϰ�, ���� ���¸� ���� 1 ����
		this.accountNo = nextAccountNo++;  
		this.ownername = name; 
		this.balance = 0;
	}

	// �Ա��� ó���ϴ� �޼ҵ� - �־��� �ݾ׸�ŭ �ܾ��� ���ҽ�Ű�� �Ա�ó�� �޼ҵ�
	//   �� �޼ҵ�� �Աݾ��� 0 ������ ��쿡�� �Ա��� ó���ϵ��� �ۼ���
	int deposit(int amount) {
		this.balance  += amount;
		return this.balance;
	}

	/* 
	 * withdraw(): ��ݾ��� 0 ���� �Ǵ� �ܾ� �ʰ��̸� ������� �ʰ� ���� �߻���      
	 *   ���� ���� ������ Exception ���ܰ�ü�� �����ϰ� ���ܰ�ü�� ����
	 */
	int withdraw(int amount) throws AccountException { // 3) ���� Ŭ���� ���
		if (amount > 0 && amount <= balance)
			balance -= amount;  // ��ݾ��� 0���� ũ�� �ܾ� �����̸� ��� ó��
		else {
			if (amount <= 0) 
				// ��ݾ� 0 �����̸� 1) ���� ������ ���ܰ�ü�� ����, 2) ���ܰ�ü�� ����
				throw new AccountException("0���� �۰ų� ���� ��ݾ�: " + amount);    
			else if (amount > this.balance) 
				// ��ݾ��� �ܾ� �ʰ��̸� 1) ���� ������ ���ܰ�ü�� ����, 2) ���ܰ�ü�� ����
				throw new AccountException("�ܾ� " + balance + "���� ū ��ݾ�: " + amount);  
		} 
		return balance;
	} 

	// toString(): ��ü�� �ʵ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "���¹�ȣ: " + accountNo + ", �̸�: " + this.ownername 
				+ ", �ܾ�: " + this.balance;
	}

	// output(): ��ü�� �ʵ��� �ʵ尪�� ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + this.toString());
	} 
}

class Ex9_4_AccountExceptionWithdraw {
	public static void main(String[] args) {
		Account acc = new Account("��ö��"); // ��ö���� ���¸� ����, �ʱ� �ܰ� 0��
		acc.output("\n  * ��� �� ��ö�� ���� - ");
        
		// <����> ���⿡�� �ܰ��� ū 1000�� �Է��Ͽ� ���ܸ� �߻���Ŵ
		int amount = SkScanner.getInt("\n  o ����� �ݾ� > ");  

		// Java���� ���� ó�� ���: try-catch ������� ���ܰ�ü�� ��� ó����
		try { 
			acc.withdraw(amount); // ���� �߻��ϸ� AccountException ��ü�� ����
			acc.output("\n  * << acc.withdraw(amount); >> ���� ��ö�� ���� - ");
		}
		catch(AccountException  e) {  // ������ AccountException ��ü�� ��� e�� �����Ͽ� ���� ó����
			System.out.println("\n  ??? ���ܰ�ü�� ���� �޽��� = '" + e.getMessage() + "'");
		}

		acc.output("\n  * ��ö�� ���� - ");

	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Account Ŭ�������� ����� �� ��ݾ��� �����̰ų� �ܾ׺��� Ŭ ��
 *      AccountException Ŭ������ ���ܰ�ü�� �����Ͽ� ���ܸ� �߻���Ű�� 
 *      �̸� Ž���ϰ� ó���Ѵ�.
 *
 *   2) ��ݾ��� ���� �Ǵ� �ܾ׺��� ū �ݾ����� �Է��� �� ���α׷��� ���� ����� Ȯ���϶�.
 *   

 * [ �ǽ����� ]
 *  
 *   o int deposit(int amount) �޼ҵ�� �Աݾ��� 0 ������ ��쿡�� �Ա� ó���� �Ѵ�.
 *   
 *     �������� �Ա��� �Աݾ��� 0���� Ŀ�� �Ѵ�. 0�� ������ �Աݾ��� �־����� ���� ó���� �ϵ���
 *     int deposit(int amount) �޼ҵ带 ���ܹ߻� �޼ҵ�� �����϶�. 
 *     
 *     deposit(int amount) �޼ҵ��  AccountException ���ܰ�ü�� ������ 
 *     main()���� �� �޼ҵ带 ȣ���ϸ鼭 ���� Ž�� �� ó���Ѵ�. 
 */
