package ex7_6_1_sale_and_stock_mgmt;

/**
 * [ Appliance, TV, ApplianceMain 클래스 ] : 가전제품 판매와 재고 관리를 위한 클래스들
 * 
 *   o Appliance 클래스와 이의 하위 클래스인  TV 클래스
 *     - 가전제품은 제품명, 제조사, 가격, 최소재고개수, 재고개수 등의 필드 가짐
 *     - TV는 화면크기와 해상도 필드를 추가로 가짐
 *     - 제품을 판매하기 전에 재고개수가 판매개수보다 적으면  판매 개수 이상의 재고 확보 
 *     - 판매 후 재고개수가 최소 재고개수보다 적으면 추가로 재고를 확보하는 등 재고 관리를 함
 *  
 *     - sale(int cnt) 메소드: 제품을 주어진 개수만큼 판매하는 메소드로  
 *       판매 전 재고 확인하며 판매 후에 재고 확인을 실시함 
 *   
 *   o 이 프로그램에서 유의할 사항은 다음의 재고 관련 사항임
 *     1) Appliance 클래스의 재고 관리
 *        - 제품마다 최소 재고개수를 설정하고 재고 개수를 그 이상 유지하도록 함
 *        - 객체 생성 시 최소 재고개수만큼 재고 확보하여 판매하게 함
 *             this.secureStock(minCntStock); 
 *             
 *        - 제품 판매 후 재고가 최소 재고개수보다 작으면 최소 재고개수의 3배만큼 재고를 확보하며, 
 *          이는 secureStock() 메소드에 의해 처리
 *          
 *        - 한편 , 제품 판매할 시점에서 재고가 부족하면 판매할 개수만큼 재고를 확보하며, 
 *          이는 secureStock(int cnt) 메소드에 의해 처리
 *        
 *     2) TV 클래스의 재고 관리
 *        - 제품 가격에 따라 재고확보 정책을 달리할 수 있도록 secureStock() 메소드를 오버라이딩
 *        - 재고가 최소 재고개수보다 작으면 100만원 이상의 고가 제품은 최소 재고개수의 2배만큼 재고를 확보하도록 변경
 *        - 100만원 이상의 고가 제품이 아닌 경우 기존의 재고 확보 정책을 따르기 위해 super.secureStock() 메소드 호출
 */

class Appliance {  
	String pname, producer;               // 제품명, 제조사 
	int price, minCntStock, cntStock;     // 가격, 최소재고개수, 재고개수

	// 제품명, 제조사, 가격, 최소 재고개수를 주어진 값으로 초기화하는 객체 생성자
	public Appliance(String pname, String producer, int price, int minCntStock) {
		this.pname = pname; this.producer = producer; 
		this.price = price;  this.minCntStock = minCntStock;

		this.secureStock(minCntStock);    // 판매를 위한 초기 재고를 minCntStock만큼 확보함
	}

	// 주어진 개수만큼 판매하는 메소드: 판매금액을 반환
	public int sale(int cnt) {
		if (this.hasStock(cnt) == false)  // 재고가 부족하면 
			this.secureStock(cnt);        //   재고를 확보함

		int amount = this.price * cnt;    //   판매금액을 구함

		System.out.println("  o " + this.pname + " 판매 - 가격: " + this.price + ", 판매개수: " + cnt
				+ ", 판매금액: " + amount + ", 재고개수: "+ (this.cntStock - cnt));

		this.decreaseStock(cnt);          //   판매 개수만큼 재고개수를 감소

		return amount;     
	}

	// 재고가 주어진 개수만큼 있는가를 확인하는 메소드
	private boolean hasStock(int cnt) {
		return this.cntStock >= cnt;
	}

	// 재고개수를 주어진 개수만큼 감소하는 메소드
	private void decreaseStock(int cnt) {
		this.cntStock = this.cntStock - cnt;  // 재고를 감소

		this.secureStock();  // 판매 후 재고가 최소 재고개수보다 작으면 재고를 확보함
	} 

	// 판매 후 최소 재고개수보다 재고개수가 작으면 최소 재고개수의 3배만큼 재고 확보하는 메소드
	void secureStock() {
		if (this.cntStock >= this.minCntStock) 
			return;

		System.out.println("  o " + this.pname + " 판매 후 재고 확보 - 최소 재고개수: " + this.minCntStock
				+ ", 현재 재고: " + this.cntStock + ", 추가 확보 재고: " + this.minCntStock * 3
				+ ", 확보 후 재고: " + (this.cntStock + this.minCntStock * 3));

		this.cntStock = this.cntStock + this.minCntStock * 3;
	}

	// 판매 전 판매개수 cnt보다 재고개수가 작으면 cnt 개의 재고를 추가로  확보하는 메소드
	void secureStock(int cnt) {
		if (this.cntStock >= cnt) 
			return;

		System.out.println("  o " + this.pname + " 판매 전 재고 확보 - 요구 개수: " + cnt
				+ ", 현재 재고: " + this.cntStock + ", 추가 확보 재고: " + cnt
				+ ", 확보 후  재고: " + (this.cntStock + cnt));

		this.cntStock = this.cntStock  + cnt;
	}

	public String toString() {
		return "제품명: " + this.pname + ", 제조사: " + this.producer 
				+ " , 가격: " + this.price + ", 재고: " + this.cntStock;
	}

	void output(String msg) {
		System.out.println("\n" + msg + this.toString());
	}
}

// Appliance 클래스의 하위 클래스인 TV를 나타내는 클래스
class TV extends Appliance { 
	int screenSize; String resolution; // 화면 크기(인치), 해상도(가로 픽셀수*세로 픽셀수)  

	TV(String pname, String producer, int price, int minCntStock, int screenSize, 
			String resolution) {
		super(pname, producer, price, minCntStock);
		this.screenSize = screenSize; this.resolution = resolution;
	}

	// 재소개수를 확보하는 오버라이딩 메소드
	//   고가 제품인 경우 최소 재고개수의 2배만큼만 확보하도록 변경함
	void secureStock() {
		if (this.cntStock >= this.minCntStock) 
			return;

		if (this.price >= 1000000) { // 고가 제품이면 최소 재고개수의 2배만큼 재고확보
			System.out.println("  o " + this.pname + " 판매 후 재고 확보 - 최소 재고개수: " + this.minCntStock
					+ ", 현재 재고: " + this.cntStock + ", 추가 확보 재고: " + this.minCntStock * 2
					+ ", 확보 후  재고: " + (this.cntStock + this.minCntStock * 2));

			this.cntStock = this.cntStock + this.minCntStock * 2;
		}
		else
			super.secureStock() ;   // 고가 제품 아니면 일반 가전제품의 방식으로 재고 확보
	}

	public String toString() {
		return super.toString() + ", 화면크기: " + this.screenSize + ", 해상도: " 
				+ this.resolution;
	}  
}

class Ex7_6_1_ApplianceMain {
	public static void main(String[] args)  {
		Appliance tv45 = new TV("SSled45", "삼성전자", 800000, 3, 45, "1920*1080" );

		int totalSale = tv45.sale(3);   
		totalSale = totalSale + tv45.sale(4);  
		totalSale = totalSale + tv45.sale(2);
		tv45.output("  * 45인치 TV - ");  
		System.out.println("  * 45인치 TV 총 판매금액 : " + totalSale  +"\n\n");

		Appliance tv55 = new TV("SSled55", "삼성전자", 1200000, 3, 55, "1920*1080" );

		totalSale = tv55.sale(3);   
		totalSale = totalSale + tv55.sale(4);  
		totalSale = totalSale + tv55.sale(2);

		tv55.output("  * 55인치 TV - ");  
		System.out.println("  * 55인치 TV 총 판매금액 : " + totalSale +"\n\n");
	}
}
	
/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 예제 7-6-1 프로그램 살펴보고 판매 메소드, 판매전 재고 확보 메소드, 판매 후 재고 확보 메소드를 이해하라.
 *      
 *   2) 프로그램 실행하고 결과 확인하라.
 *   
 *   3) 프로그램 결과에서 SSled45와 SSled55 제품에 대해 동일한 개수의 판매가 이루어졌지만 
 *      재고 확보된 상황이 다른 것 파악하라. 
 *   
 *   
 * [ 실습과제 ]
 * 
 *   1) TV 클래스의 secureStock() 메소드에서 고가제품 가격이 100만원으로 고정되어 있으므로 융통성이 떨어진다.
 *      TV 제품의 고가제품 가격을 변경하기 위한 방법 고안하여 이를 구현하라.
 *      
 *      (고가제품 가격을 저장하는 static 필드 추가하고 고가제품 가격 변경하는 static 메소드 작성하는 것도 
 *       하나의 방법임)
 *       
 *   2) 이 프로그램에서는 각 제품의 판매 이력이 저장되지 않는다. 판매 이력 저장하고 출력할 수 있도록 프로그램 변경하라.
 *     
 *   3) int sale(int cnt) 메소드는 정가로 판매하는 메소드이다. 
 *      할인 적용하여 판매하는 메소드 int sale(int cnt, int salePercent) 작성하고 main(0에서 이를 호출하라.
 */
