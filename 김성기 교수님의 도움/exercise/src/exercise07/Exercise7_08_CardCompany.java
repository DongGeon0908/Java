package exercise07;

/**
 * [ 7장 연습문제 8 ]:
 *   
 *   8. 다음의 신용카드 관련 클래스에 대해 답하라. 
 *   
 *     1) CreditCardWCS 클래스의 상속된 필드와 메소드, 그리고 자체의 필드와 메소드를 나열하라. 
 *        (Object 클래스에서 상속된 특성은 무시한다)
 *        
 *     2) << CreditCard(long cardNo, String owner, int amountMaxUnpaid) { ... } >>은 
 *        언제 수행되며, 어떠한 일들이 이루어지는가를 설명하라.
 *        
 *     3) << c2.useCreditCard("CGV", 27000); >>에서 메소드가 호출되고 수행되는 과정, 
 *        수행되는 내용, 결과를 설명하라.
 *        
 *     4) << CreditCard c3 = new CreditCardWCS(4321003, "심청", 500000, 200000); >>이 
 *        수행되면 어떠한 일들이 이루어지는지 설명하라.
 *        
 *     5) CreditCardWCS 클래스의 boolean useCashService(int amount) 메소드는 
 *        주어진 금액 amount 만큼의 현금서비스를 제공하는 메소드이다. 미결제 현금서비스 금액과 요구된 amount의 합이 
 *        최대 현금서비스 금액 이하이면 미결제 현금서비스 금액을 증가시킨 후 true를 반환하여 현금 서비스를 허용하고, 
 *        합이 최대 현금서비스 금액을 초과하면 단순히 false를 반환하여 불허하는 이 메소드를 작성하라.
 *        
 *     6) 프로그램의 출력결과를 구하라.
 */

class CreditCard {    
	long cardNo; 					// 카드번호
	String owner;  					// 소유자
	int amountMaxUnpaid; 			// 미결제 최대 사용한도

	int amountUnpaid = 0;    		// 미결제 사용금액: 결제하면 감소
	int amountTotalUse = 0;  		// 총 사용금액 
	String storesUsed = "";   		// 사용처들을 모두 저장하는 필드

	CreditCard(long cardNo, String owner, int amountMaxUnpaid) {
		this.cardNo = cardNo; this.owner = owner; 
		this.amountMaxUnpaid= amountMaxUnpaid;
	}

	void useCreditCard(String store, int amount) {  // 카드 사용 처리 메소드
		if (amountUnpaid + amount <= amountMaxUnpaid) {
			amountUnpaid = amountUnpaid + amount;			   
			amountTotalUse = amountTotalUse + amount;		   
			storesUsed = storesUsed + store + " ";
		}		
	}	

	void payCreditCardBill(int amount) {  			// 카드금액 결제 메소드
		amountUnpaid = amountUnpaid - amount;
	}	

	public String toString() {
		return cardNo + " 카드 - 소유자: " + owner + ", 사용처들: "+storesUsed  
				+ ", 미결제금액: "+amountUnpaid;
	}

	void output() {
		System.out.println("\n  * " + this.toString());
	}
}

// 현금 서비스 가능 신용카드 클래스: CreditCardWCS는 CreditCardWithCashService 줄임
class CreditCardWCS extends CreditCard {	  
	int amountMaxCashService;  // 미결제 최대 현금 서비스 한도

	int amountCashService;     // 미결제 현금 서비스 금액

	CreditCardWCS(long cardNo, String owner, int amountMaxUnpaid, 
			int amountMaxCashService) {
		super(cardNo, owner, amountMaxUnpaid);
		this.amountMaxCashService = amountMaxCashService;
	}

	boolean useCashService(int amount) {  	// 현금 서비스 사용 처리 메소드
		return true; // << 작성하라  >>			
	}	

	void payCashService(int amount) {  		// 현금 서비스 결제 처리 메소드
		amountCashService = amountCashService - amount;
	}

	public String toString() {
		return super.toString() + ", 미결제 현금서비스 금액: " + amountCashService;
	}	

	void output() {
		System.out.println("\n  * " + this.toString());
	}
}

class Exercise7_08_CardCompany {
	public static void main(String[] args) {
		CreditCard c1 = new CreditCard(4321001, "홍길동", 500000);
		c1.useCreditCard("CGV", 18000);
		c1.useCreditCard("DREAM", 2500);

		CreditCardWCS c2 = new CreditCardWCS(4321002, "박문수", 700000, 90000);
		c2.useCreditCard("CGV", 27000);
		c2.useCreditCard("한국식당", 13000);
		c2.useCashService(50000);

		CreditCard c3 = new CreditCardWCS(4321003, "심청", 500000, 200000);
		c3.useCreditCard("북경반점", 15000);

		c1.output(); 
		c2.output();   
		c3.output();
	}
}
