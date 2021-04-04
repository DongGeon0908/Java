package ex6_5_2_class_with_modifiers;

/**
 * [ car Ŭ���� ]: ���� ������ ��Ÿ���� ���ľ��� ���� �����ִ� ��
 *  
 *   o Ŭ���� �ۼ� ���� 3: ��ü �����ڸ� ����  Ŭ���� 
 *  
 *   o ���� ������ ���ϰ� ������ ���α׷�
 *     - ���� ������ ���� �ʵ�� �޼ҵ� ������ �޶���
 *    
 *     - public: �ٸ� Ŭ������ �޼ҵ忡���� ���� ���� 
 *     - package: ���� ��Ű���� Ŭ������ �޼ҵ忡���� ���� ����
 *     - private: Ŭ���� ���� �޼ҵ忡���� ���� ���� , �ٸ� Ŭ���������� ���� �Ҵ�
 */

// public Ŭ������ ��� �ݵ�� ������  .java ���Ͽ� �ۼ��Ǿ�� ��
public class Car {
	// ��� ��ü�� �����ϴ� ���� �����ϴ� ������ Ŭ���� �ʵ�: �ڵ��� ������ ��Ÿ��
	// public�̹Ƿ� �ٸ� Ŭ������ �޼ҵ忡���� ���� ���� 
	public static int RED=0, BLUE=1, GREEN=2, YELLOW=3, WHITE=4, BLACK=5;

	// ����Ʈ ���� �����ϴ� ����Ʈ�� Ŭ���� �ʵ�: defaultNoDoors�� ����Ʈ ���� 4	
	// public�̹Ƿ� �ٸ� Ŭ������ �޼ҵ忡���� ���� ���� 
	public static final int defaultNoDoors = 4;    

	// ��ü���� �ο��� ���� �����ϴ� ��ü ������ Ŭ���� �ʵ�: ��ü �����Ǹ� 1�� ����
	// private�̹Ƿ� Ŭ���� ���� �޼ҵ忡���� ���� ����, �ٸ� Ŭ���������� ���� �Ҵ�
	private static int carCount = 0;  

	int carID;		// �ڵ��� ID
	String maker;	// ����ȸ��
	String model;	// ����
	int    color;	// ����
	int    noDoors;	// �� ����

	// �Ű����� ���� ��ü ������: carID �ʱ�ȭ��Ŵ
	// private�̹Ƿ� Ŭ���� ���� �޼ҵ忡���� ȣ�� ����, �ٸ� Ŭ�������� ȣ�� �Ҵ�
	private Car() { 
		// Ŭ���� �ʵ� carCount�� �������� carID�� ����
		this.carID = ++Car.carCount;  	
	}

	// ����ȸ��, ����, ������ �־����� �ʵ带 �ʱ�ȭ�ϴ� ��ü ������, �� ������ ����Ʈ ������ �ʱ�ȭ
	public Car(String maker, String model, int color) {
		this(); // �Ű����� ���� ��ü ������ ȣ��

		this.maker = maker;
		this.model = model;
		this.color = color;
		this.noDoors = Car.defaultNoDoors;  // �� ������ ����Ʈ ������ �ʱ�ȭ
	}

	// ����ȸ��, ����, ����, �� ������ �־����� �ʵ带 �ʱ�ȭ�ϴ� ��ü ������
	public Car(String maker, String model, int color, int noDoors) {
		this(maker, model, color); // �Ű����� �ִ� ��ü ������ ȣ���Ͽ� ����ȸ��, ����, ���� �ʱ�ȭ

		this.noDoors = noDoors;    // �� ������ �־��� ������ �ʱ�ȭ
	}

	public String toString() {
		return "carID:" + carID + ", maker:" + maker + ", model:" + model +
				", color:" + color + ", noDoors:" + noDoors; 
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� 6-4-2�� ���� ���� ������ ���ϰ� ������ ���α׷��̴�  
 *      ���� ������ ���� �ʵ�� �޼ҵ� ������ �޶����� Ȯ�� �� �� ���α׷��� �� ���캸��.
 *      
 *   2) Public��  private ����� ���̸� �����϶�.
 */
