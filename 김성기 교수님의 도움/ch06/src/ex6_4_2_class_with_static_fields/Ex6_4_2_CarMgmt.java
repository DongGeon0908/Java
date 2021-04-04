package ex6_4_2_class_with_static_fields;

/**
 * [ car, CarMgmt Ŭ���� ]: ���� Ŭ���� �ʵ��� �뵵�� �����ִ� ����
 *  
 *   o Ŭ���� �ۼ� ���� 3: ��ü �����ڸ� ���� Ŭ���� 
 *  
 *   o Ŭ���� �ʵ�(static �ʵ�)
 *     - Ŭ���� �ʵ�� �ʵ忡 static Ű���尡 ���� �ʵ�
 *     - Ŭ���� �ʵ�� �� ��ü���� �����Ұ� �Ҵ���� �ʰ� Ŭ�������� �ϳ��� �Ҵ��
 *     - Ŭ���� �ʵ�� Ŭ���� ��ü�� ���õ� ���� �����ϴ� ����
 *     - Ŭ���� �ʵ�� ��ü�� �������� �ʰ��� ������ �� ������, 
 *         << Ŭ�����̸�.Ŭ�����ʵ� >> �Ǵ� << ��ü��������.Ŭ�����ʵ� >>�� ���·� ����
 *         
 *   o Ŭ���� �ʵ��� �뵵
 *     - Ŭ���� �ʵ�� ũ�� ��� ��ü�� ������ �� ����, ����Ʈ �� ����, ������ ��ü ���� ���� �뵵�� ���
 *     
 *     1) ��� ��ü�� ������ �� ����: �ִ� �ο���, ����, ���ϸ� ���� �����ϸ� �ַ� ��� ������ ������
 *     2) ����Ʈ �� ����: ��ü ���� �� �ʵ� ���� �־����� ���� ��� ������ �� ����
 *     3) ������ ��ü ����: ������ ��ü ����, ��ü ������ �迭 �� ��ü�� ������ �� �ʿ��� ���� ���� 
 */

class Car {
	// ��� ��ü�� �����ϴ� ���� �����ϴ� ������ Ŭ���� �ʵ�: �ڵ��� ������ ��Ÿ��
	static int RED=0, BLUE=1, GREEN=2, YELLOW=3, WHITE=4, BLACK=5;

	// ����Ʈ �� �����ϴ� ����Ʈ�� Ŭ���� �ʵ�: defaultNoDoors�� ����Ʈ ���� 4	
	static final int defaultNoDoors = 4;    

	// ��ü���� �ο��� �� �����ϴ� ��ü ������ Ŭ���� �ʵ�: ��ü �����Ǹ� 1�� ����
	static int carCount = 0;  

	int carID;		// �ڵ��� ID
	String maker;	// ����ȸ��
	String model;	// ����
	int    color;	// ����
	int    noDoors;	// �� ����

	// �Ű����� ���� ��ü ������: carID�� �ʱ�ȭ��Ŵ
	Car() { 
		// Ŭ���� �ʵ� carCount�� �������� carID�� ����
		this.carID = ++Car.carCount;  	
	}

	// ����ȸ��, ����, ������ �־����� �ʵ带 �ʱ�ȭ�ϴ� ��ü ������, �� ������ ����Ʈ ������ �ʱ�ȭ
	Car(String maker, String model, int color) {
		this(); // �Ű����� ���� ��ü ������ ȣ��

		this.maker = maker;
		this.model = model;
		this.color = color;
		this.noDoors = Car.defaultNoDoors;  // �� ������ ����Ʈ ������ �ʱ�ȭ
	}

	// ����ȸ��, ����, ����, �� ������ �־����� �ʵ带 �ʱ�ȭ�ϴ� ��ü ������
	Car(String maker, String model, int color, int noDoors) {
		this(maker, model, color); // �Ű����� �ִ� ��ü ������ ȣ���Ͽ� ����ȸ��, ����, ���� �ʱ�ȭ

		this.noDoors = noDoors;    // �� ������ �־��� ������ �ʱ�ȭ
	}

	public String toString() {
		return "carID:" + carID + ", maker:" + maker + ", model:" + model +
				", color:" + color + ", noDoors:" + noDoors; 
	}
}

class Ex6_4_2_CarMgmt {
	// ������ Car ��ü�� �����Ͽ� �����ϱ� ���� ��ü ������ Ŭ���� �ʵ�
	static Car[] cars = new Car[100]; // 100���� Car ��ü�� ������ �� �ִ� �迭

	public static void main(String[] args) {
		// Car ��ü�� �����Ͽ� cars[] �迭�� ����
		cars[0] = new Car("�����ڵ���", "�ҳ�Ÿ", Car.WHITE);
		cars[1] = new Car("����ڵ���", "������", Car.YELLOW, 5);

		System.out.println("\n  * Ŭ���� �ʵ� - YELLOW:" + Car.YELLOW + 
				", defaultNoDoors:" + Car.defaultNoDoors + 
				", carCount:" + Car.carCount );
		System.out.println("\n  * car[0] - " + cars[0].toString());
		System.out.println("\n  * car[1] - " + cars[1].toString()); 
	}
}
	
/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� �뵵��  Ŭ���� �ʵ带 �����ϰ� �� Ŭ���� �ʵ带 �����Ѵ�.  
 *      Ŭ���� �ʵ尡 ����� �κа� ������ �κ��� �� ���캸��.
 *      
 *   2) ���� �뵵�� Ŭ���� �ʵ尡 �ʿ信 ���� ������ Ȯ���϶�.
 *   
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   1) Car ��ü�� �߰��� �����Ͽ� cars[2]�� �����ϰ� ������ car ��ü�� ����϶�.
 *      
 *   2) 1)�� ������ ���� Ŭ����, �迭��ü, ������ car ��ü�� �����ִ� �׸��� �׷���.
 */
