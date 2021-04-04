package ex7_6_1_sale_and_stock_mgmt;

/**
 * [ Appliance, TV, ApplianceMain Ŭ���� ] : ������ǰ �Ǹſ� ��� ������ ���� Ŭ������
 * 
 *   o Appliance Ŭ������ ���� ���� Ŭ������  TV Ŭ����
 *     - ������ǰ�� ��ǰ��, ������, ����, �ּ������, ����� ���� �ʵ� ����
 *     - TV�� ȭ��ũ��� �ػ� �ʵ带 �߰��� ����
 *     - ��ǰ�� �Ǹ��ϱ� ���� ������� �ǸŰ������� ������  �Ǹ� ���� �̻��� ��� Ȯ�� 
 *     - �Ǹ� �� ������� �ּ� ��������� ������ �߰��� ��� Ȯ���ϴ� �� ��� ������ ��
 *  
 *     - sale(int cnt) �޼ҵ�: ��ǰ�� �־��� ������ŭ �Ǹ��ϴ� �޼ҵ��  
 *       �Ǹ� �� ��� Ȯ���ϸ� �Ǹ� �Ŀ� ��� Ȯ���� �ǽ��� 
 *   
 *   o �� ���α׷����� ������ ������ ������ ��� ���� ������
 *     1) Appliance Ŭ������ ��� ����
 *        - ��ǰ���� �ּ� ������� �����ϰ� ��� ������ �� �̻� �����ϵ��� ��
 *        - ��ü ���� �� �ּ� �������ŭ ��� Ȯ���Ͽ� �Ǹ��ϰ� ��
 *             this.secureStock(minCntStock); 
 *             
 *        - ��ǰ �Ǹ� �� ��� �ּ� ��������� ������ �ּ� ������� 3�踸ŭ ��� Ȯ���ϸ�, 
 *          �̴� secureStock() �޼ҵ忡 ���� ó��
 *          
 *        - ���� , ��ǰ �Ǹ��� �������� ��� �����ϸ� �Ǹ��� ������ŭ ��� Ȯ���ϸ�, 
 *          �̴� secureStock(int cnt) �޼ҵ忡 ���� ó��
 *        
 *     2) TV Ŭ������ ��� ����
 *        - ��ǰ ���ݿ� ���� ���Ȯ�� ��å�� �޸��� �� �ֵ��� secureStock() �޼ҵ带 �������̵�
 *        - ��� �ּ� ��������� ������ 100���� �̻��� �� ��ǰ�� �ּ� ������� 2�踸ŭ ��� Ȯ���ϵ��� ����
 *        - 100���� �̻��� �� ��ǰ�� �ƴ� ��� ������ ��� Ȯ�� ��å�� ������ ���� super.secureStock() �޼ҵ� ȣ��
 */

class Appliance {  
	String pname, producer;               // ��ǰ��, ������ 
	int price, minCntStock, cntStock;     // ����, �ּ������, �����

	// ��ǰ��, ������, ����, �ּ� ������� �־��� ������ �ʱ�ȭ�ϴ� ��ü ������
	public Appliance(String pname, String producer, int price, int minCntStock) {
		this.pname = pname; this.producer = producer; 
		this.price = price;  this.minCntStock = minCntStock;

		this.secureStock(minCntStock);    // �ǸŸ� ���� �ʱ� ��� minCntStock��ŭ Ȯ����
	}

	// �־��� ������ŭ �Ǹ��ϴ� �޼ҵ�: �Ǹűݾ��� ��ȯ
	public int sale(int cnt) {
		if (this.hasStock(cnt) == false)  // ��� �����ϸ� 
			this.secureStock(cnt);        //   ��� Ȯ����

		int amount = this.price * cnt;    //   �Ǹűݾ��� ����

		System.out.println("  o " + this.pname + " �Ǹ� - ����: " + this.price + ", �ǸŰ���: " + cnt
				+ ", �Ǹűݾ�: " + amount + ", �����: "+ (this.cntStock - cnt));

		this.decreaseStock(cnt);          //   �Ǹ� ������ŭ ������� ����

		return amount;     
	}

	// ��� �־��� ������ŭ �ִ°��� Ȯ���ϴ� �޼ҵ�
	private boolean hasStock(int cnt) {
		return this.cntStock >= cnt;
	}

	// ������� �־��� ������ŭ �����ϴ� �޼ҵ�
	private void decreaseStock(int cnt) {
		this.cntStock = this.cntStock - cnt;  // ��� ����

		this.secureStock();  // �Ǹ� �� ��� �ּ� ��������� ������ ��� Ȯ����
	} 

	// �Ǹ� �� �ּ� ��������� ������� ������ �ּ� ������� 3�踸ŭ ��� Ȯ���ϴ� �޼ҵ�
	void secureStock() {
		if (this.cntStock >= this.minCntStock) 
			return;

		System.out.println("  o " + this.pname + " �Ǹ� �� ��� Ȯ�� - �ּ� �����: " + this.minCntStock
				+ ", ���� ���: " + this.cntStock + ", �߰� Ȯ�� ���: " + this.minCntStock * 3
				+ ", Ȯ�� �� ���: " + (this.cntStock + this.minCntStock * 3));

		this.cntStock = this.cntStock + this.minCntStock * 3;
	}

	// �Ǹ� �� �ǸŰ��� cnt���� ������� ������ cnt ���� ��� �߰���  Ȯ���ϴ� �޼ҵ�
	void secureStock(int cnt) {
		if (this.cntStock >= cnt) 
			return;

		System.out.println("  o " + this.pname + " �Ǹ� �� ��� Ȯ�� - �䱸 ����: " + cnt
				+ ", ���� ���: " + this.cntStock + ", �߰� Ȯ�� ���: " + cnt
				+ ", Ȯ�� ��  ���: " + (this.cntStock + cnt));

		this.cntStock = this.cntStock  + cnt;
	}

	public String toString() {
		return "��ǰ��: " + this.pname + ", ������: " + this.producer 
				+ " , ����: " + this.price + ", ���: " + this.cntStock;
	}

	void output(String msg) {
		System.out.println("\n" + msg + this.toString());
	}
}

// Appliance Ŭ������ ���� Ŭ������ TV�� ��Ÿ���� Ŭ����
class TV extends Appliance { 
	int screenSize; String resolution; // ȭ�� ũ��(��ġ), �ػ�(���� �ȼ���*���� �ȼ���)  

	TV(String pname, String producer, int price, int minCntStock, int screenSize, 
			String resolution) {
		super(pname, producer, price, minCntStock);
		this.screenSize = screenSize; this.resolution = resolution;
	}

	// ��Ұ����� Ȯ���ϴ� �������̵� �޼ҵ�
	//   �� ��ǰ�� ��� �ּ� ������� 2�踸ŭ�� Ȯ���ϵ��� ������
	void secureStock() {
		if (this.cntStock >= this.minCntStock) 
			return;

		if (this.price >= 1000000) { // �� ��ǰ�̸� �ּ� ������� 2�踸ŭ ���Ȯ��
			System.out.println("  o " + this.pname + " �Ǹ� �� ��� Ȯ�� - �ּ� �����: " + this.minCntStock
					+ ", ���� ���: " + this.cntStock + ", �߰� Ȯ�� ���: " + this.minCntStock * 2
					+ ", Ȯ�� ��  ���: " + (this.cntStock + this.minCntStock * 2));

			this.cntStock = this.cntStock + this.minCntStock * 2;
		}
		else
			super.secureStock() ;   // �� ��ǰ �ƴϸ� �Ϲ� ������ǰ�� ������� ��� Ȯ��
	}

	public String toString() {
		return super.toString() + ", ȭ��ũ��: " + this.screenSize + ", �ػ�: " 
				+ this.resolution;
	}  
}

class Ex7_6_1_ApplianceMain {
	public static void main(String[] args)  {
		Appliance tv45 = new TV("SSled45", "�Ｚ����", 800000, 3, 45, "1920*1080" );

		int totalSale = tv45.sale(3);   
		totalSale = totalSale + tv45.sale(4);  
		totalSale = totalSale + tv45.sale(2);
		tv45.output("  * 45��ġ TV - ");  
		System.out.println("  * 45��ġ TV �� �Ǹűݾ� : " + totalSale  +"\n\n");

		Appliance tv55 = new TV("SSled55", "�Ｚ����", 1200000, 3, 55, "1920*1080" );

		totalSale = tv55.sale(3);   
		totalSale = totalSale + tv55.sale(4);  
		totalSale = totalSale + tv55.sale(2);

		tv55.output("  * 55��ġ TV - ");  
		System.out.println("  * 55��ġ TV �� �Ǹűݾ� : " + totalSale +"\n\n");
	}
}
	
/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) ���� 7-6-1 ���α׷� ���캸�� �Ǹ� �޼ҵ�, �Ǹ��� ��� Ȯ�� �޼ҵ�, �Ǹ� �� ��� Ȯ�� �޼ҵ带 �����϶�.
 *      
 *   2) ���α׷� �����ϰ� ��� Ȯ���϶�.
 *   
 *   3) ���α׷� ������� SSled45�� SSled55 ��ǰ�� ���� ������ ������ �ǸŰ� �̷�������� 
 *      ��� Ȯ���� ��Ȳ�� �ٸ� �� �ľ��϶�. 
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   1) TV Ŭ������ secureStock() �޼ҵ忡�� ����ǰ ������ 100�������� �����Ǿ� �����Ƿ� ���뼺�� ��������.
 *      TV ��ǰ�� ����ǰ ������ �����ϱ� ���� ��� ����Ͽ� �̸� �����϶�.
 *      
 *      (����ǰ ������ �����ϴ� static �ʵ� �߰��ϰ� ����ǰ ���� �����ϴ� static �޼ҵ� �ۼ��ϴ� �͵� 
 *       �ϳ��� �����)
 *       
 *   2) �� ���α׷������� �� ��ǰ�� �Ǹ� �̷��� ������� �ʴ´�. �Ǹ� �̷� �����ϰ� ����� �� �ֵ��� ���α׷� �����϶�.
 *     
 *   3) int sale(int cnt) �޼ҵ�� ������ �Ǹ��ϴ� �޼ҵ��̴�. 
 *      ���� �����Ͽ� �Ǹ��ϴ� �޼ҵ� int sale(int cnt, int salePercent) �ۼ��ϰ� main(0���� �̸� ȣ���϶�.
 */
