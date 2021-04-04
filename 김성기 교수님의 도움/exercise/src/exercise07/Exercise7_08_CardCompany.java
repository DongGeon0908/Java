package exercise07;

/**
 * [ 7�� �������� 8 ]:
 *   
 *   8. ������ �ſ�ī�� ���� Ŭ������ ���� ���϶�. 
 *   
 *     1) CreditCardWCS Ŭ������ ��ӵ� �ʵ�� �޼ҵ�, �׸��� ��ü�� �ʵ�� �޼ҵ带 �����϶�. 
 *        (Object Ŭ�������� ��ӵ� Ư���� �����Ѵ�)
 *        
 *     2) << CreditCard(long cardNo, String owner, int amountMaxUnpaid) { ... } >>�� 
 *        ���� ����Ǹ�, ��� �ϵ��� �̷�����°��� �����϶�.
 *        
 *     3) << c2.useCreditCard("CGV", 27000); >>���� �޼ҵ尡 ȣ��ǰ� ����Ǵ� ����, 
 *        ����Ǵ� ����, ����� �����϶�.
 *        
 *     4) << CreditCard c3 = new CreditCardWCS(4321003, "��û", 500000, 200000); >>�� 
 *        ����Ǹ� ��� �ϵ��� �̷�������� �����϶�.
 *        
 *     5) CreditCardWCS Ŭ������ boolean useCashService(int amount) �޼ҵ�� 
 *        �־��� �ݾ� amount ��ŭ�� ���ݼ��񽺸� �����ϴ� �޼ҵ��̴�. �̰��� ���ݼ��� �ݾװ� �䱸�� amount�� ���� 
 *        �ִ� ���ݼ��� �ݾ� �����̸� �̰��� ���ݼ��� �ݾ��� ������Ų �� true�� ��ȯ�Ͽ� ���� ���񽺸� ����ϰ�, 
 *        ���� �ִ� ���ݼ��� �ݾ��� �ʰ��ϸ� �ܼ��� false�� ��ȯ�Ͽ� �����ϴ� �� �޼ҵ带 �ۼ��϶�.
 *        
 *     6) ���α׷��� ��°���� ���϶�.
 */

class CreditCard {    
	long cardNo; 					// ī���ȣ
	String owner;  					// ������
	int amountMaxUnpaid; 			// �̰��� �ִ� ����ѵ�

	int amountUnpaid = 0;    		// �̰��� ���ݾ�: �����ϸ� ����
	int amountTotalUse = 0;  		// �� ���ݾ� 
	String storesUsed = "";   		// ���ó���� ��� �����ϴ� �ʵ�

	CreditCard(long cardNo, String owner, int amountMaxUnpaid) {
		this.cardNo = cardNo; this.owner = owner; 
		this.amountMaxUnpaid= amountMaxUnpaid;
	}

	void useCreditCard(String store, int amount) {  // ī�� ��� ó�� �޼ҵ�
		if (amountUnpaid + amount <= amountMaxUnpaid) {
			amountUnpaid = amountUnpaid + amount;			   
			amountTotalUse = amountTotalUse + amount;		   
			storesUsed = storesUsed + store + " ";
		}		
	}	

	void payCreditCardBill(int amount) {  			// ī��ݾ� ���� �޼ҵ�
		amountUnpaid = amountUnpaid - amount;
	}	

	public String toString() {
		return cardNo + " ī�� - ������: " + owner + ", ���ó��: "+storesUsed  
				+ ", �̰����ݾ�: "+amountUnpaid;
	}

	void output() {
		System.out.println("\n  * " + this.toString());
	}
}

// ���� ���� ���� �ſ�ī�� Ŭ����: CreditCardWCS�� CreditCardWithCashService ����
class CreditCardWCS extends CreditCard {	  
	int amountMaxCashService;  // �̰��� �ִ� ���� ���� �ѵ�

	int amountCashService;     // �̰��� ���� ���� �ݾ�

	CreditCardWCS(long cardNo, String owner, int amountMaxUnpaid, 
			int amountMaxCashService) {
		super(cardNo, owner, amountMaxUnpaid);
		this.amountMaxCashService = amountMaxCashService;
	}

	boolean useCashService(int amount) {  	// ���� ���� ��� ó�� �޼ҵ�
		return true; // << �ۼ��϶�  >>			
	}	

	void payCashService(int amount) {  		// ���� ���� ���� ó�� �޼ҵ�
		amountCashService = amountCashService - amount;
	}

	public String toString() {
		return super.toString() + ", �̰��� ���ݼ��� �ݾ�: " + amountCashService;
	}	

	void output() {
		System.out.println("\n  * " + this.toString());
	}
}

class Exercise7_08_CardCompany {
	public static void main(String[] args) {
		CreditCard c1 = new CreditCard(4321001, "ȫ�浿", 500000);
		c1.useCreditCard("CGV", 18000);
		c1.useCreditCard("DREAM", 2500);

		CreditCardWCS c2 = new CreditCardWCS(4321002, "�ڹ���", 700000, 90000);
		c2.useCreditCard("CGV", 27000);
		c2.useCreditCard("�ѱ��Ĵ�", 13000);
		c2.useCashService(50000);

		CreditCard c3 = new CreditCardWCS(4321003, "��û", 500000, 200000);
		c3.useCreditCard("�ϰ����", 15000);

		c1.output(); 
		c2.output();   
		c3.output();
	}
}
