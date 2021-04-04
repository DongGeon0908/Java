package exercise09;

/**
 * [ 9�� �������� 7 ]
 * 
 *   7. �� ���࿡�� ���¸� ������ �� ���¹�ȣ, ������ �̸�, ��ü�ѵ��� �־����� �� ������ ���¸� �����Ѵ�. 
 *      ���¿��� �ٸ� ���·� ��ü�� �� ��ü �ݾ��� 0���� ũ�� �ܰ��� �۰ų� ���ƾ� �Ѵ�. 
 *      ����, ��ü �ݾ��� ��ü �ѵ����� ����� �Ѵ�. �� ���� ��ü���� �ٸ� ���� ��ü�� ��ü�۱��� �Ϸ��� 
 *      ������ ���α׷��� �ۼ�������, ���⿡�� ��ü�� ���� ���� ó���� ���� ���� �����̴�.
 *      
 *      1) ���α׷��� �������� ������. 
 *      
 *      2) transferTo() �޼ҵ��� �������� �����϶�. 
 *      
 *      3) transferTo() �޼ҵ忡�� ���� ��Ȳ�� �߻��ϸ� ���� �޽����� �� �޼ҵ忡�� ���� ����ϵ��� �޼ҵ带 �����϶�. 
 *        (���� ��Ȳ�� �߻��ϸ� ��ü�� �������� �ʰ� ���� �޽����� ��� )
 *        
 *      4) transferTo() �޼ҵ忡�� ���� ��Ȳ�� �߻��ϸ� ���ܰ�ü�� �����Ͽ� ������, ȣ���� main() �޼ҵ忡�� 
 *         �̸� Ž���ϰ� ó���ϵ��� ���α׷��� �����϶�. (�ʿ��� �κи� �����ϸ� ��) 
 */

class Account {
	// ���¹�ȣ, ������, �ܰ�, ��ü�ѵ�
	int accno; String owner; int balance, transferLimit; 

	Account(int accno, String owner, int transferLimit) {
		this.accno = accno;                   this.owner = owner;   
		this.transferLimit = transferLimit;   this.balance = 0;
	}

	void deposit(int amount) {  // �Ա� �޼ҵ�
		balance += amount;
	}

	// �� ���¿��� �־��� accountTo ���·� ��ü�ϴ� �޼ҵ�
	void transferTo(Account accountTo, int amount) {
		this.balance -= amount;
		accountTo.balance += amount;
	}
}

class Exercise9_7 {

	public static void main(String[] args) {
		Account acc1 = new Account(10001, "ȫ�浿", 10000);
		Account acc2 = new Account(10002, "�ڹ���", 10000);
		acc1.deposit(50000);
		acc1.transferTo(acc2, 80000);

		System.out.println("acc1�� �ܰ� = " + acc1.balance 
				+ ", acc2�� �ܰ� = "  + acc2.balance);
	}  
}     