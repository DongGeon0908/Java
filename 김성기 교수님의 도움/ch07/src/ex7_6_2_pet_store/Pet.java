package ex7_6_2_pet_store;

/**
 * [ �־��� ��Ȳ ] 
 * 
 *   o ȫ�浿�� CEO�� �갡���� �곪��� ���� ã�ƿ��� ȯ���ϰ� 
 *     ��ī��(�� ���̵�, �̸�, �ּ�, ��ȭ��ȣ) �ۼ��Ͽ� ������ ����
 *     
 * [ ���� ���� ] 
 * 
 *   o ���� �湮�� ������ �湮ȸ�� ���
 *   o ������ ������ �� �Ǹ��ϸ�, �Ǹ�ȸ���� ������ �� ���
 *   o ����  ����̵�, ���̸�, ����, ����, ���� ���� ���� ����
 *   o ���� ���� ���� ���� �����ϱ� ���� �迭 ���
 *    
 * [ Pet Ŭ���� ]
 * 
 *   o ���� ��Ÿ���� Ŭ����
 *     - �ʵ�: �� ������ �����ϱ� ���� �ʵ��
 *     - �޼ҵ�: ��ü ������, toString(), output()
 *   
 * [ Pet�� ���� Ŭ������ ]
 * 
 *   o ������, ����, ��� �� ������ ���� ��Ÿ���� ���� Ŭ������
 *     - MammalPet
 *     - BirdPet
 *     - FishPet
 *     
 *   o ���� Ŭ�������� ���ο� �ʵ带 ������, ��ü �����ڵ� �޶���
 */

class Pet {
	static int nextPetID = 1001;  // �� ���̵� �Ҵ��ϱ� ���� static ����

	int petID;
	String petname;
	String kind;
	int age;
	int price;

	Pet() {		
	}

	// �� �̸�, ����, ����, ������ �־����� �� ��ü�� �����ϴ� ��ü ������
	Pet(String petname,String kind, int age, int price) {
		this.petID = nextPetID++;  // nextPetID�� ����̵� �Ҵ��ϰ� nextPetID 1 ����
		this.petname = petname ;
		this.kind = kind;
		this.age = age;
		this.price = price;
	}

	public String toString() {
		return "���̵�: " + this.petID + "\t ���̸�: " + this.petname + "\t ����: " + this.kind + "\t ����: " 
	           + this.age + "\t ����: " + this.price;
		
	}
	
	void output(String leadingMsg) {
		System.out.println(leadingMsg + this.toString() + "\n");
	}
	
	void output() {
		output("  * �� ");
	}	
}

class MammalPet extends Pet {
	// MammalPet Ŭ������ ������, �ӽűⰣ �ʵ带 �߰��� ����
	double weight;
	int pregnancyPeriod;
	
	MammalPet(String petname, String kind, int age, int price, double weight, int pregnancyPeriod) {
		super(petname, kind,  age,  price);
		this.weight = weight; 
        this.pregnancyPeriod = pregnancyPeriod;
	}
}

class BirdPet extends Pet {
	// BirdPet Ŭ������ ���� �ʵ带 �߰��� ����
	String color;
	
	BirdPet(String petname, String kind, int age, int price, String color) {
		super(petname, kind,  age,  price);
		this.color = color; 
	}
}

class FishPet extends Pet {
   // FishPet Ŭ������ ����, �������� �ʵ带 �߰��� ����
	String color;
	int optimumTemperature; 
	
	FishPet(String petname, String kind, int age, int price, String color, int optimumTemperature) {
		super(petname, kind,  age,  price);
		this.color = color; 
		this.optimumTemperature = optimumTemperature;
	}
}

/*
 * [ ���α׷� ���캸�� �� ���α׷� ���� ]
 * 
 *    1) MammalPet Ŭ������ Pet Ŭ������ ���� Ŭ������ Pet Ŭ������ �ʵ� �ܿ� ������, �ӽűⰣ  �ʵ带 �߰��� ���´�.
 *           
 *    2) BirdPet Ŭ������ Pet Ŭ������ ���� Ŭ������ Pet Ŭ������ �ʵ� �ܿ� ���� �ʵ带 �߰��� ���´�.
 *    
 *    3) FishPet Ŭ������ Pet Ŭ������ ���� Ŭ������ Pet Ŭ������ �ʵ� �ܿ� ����, �������� �ʵ带 �߰��� ���´�.
 *    
 *      
 *  [ �ǽ� ���� ]
 *  
 *    1) MammalPet Ŭ������ ��� �ʵ� ���� ���ڿ��� �����ϴ� toString() �޼ҵ带 �ۼ��϶�. 
 *       �̶��� ���� Ŭ������ toString()�� ȣ���ؾ� �Ѵ�.
 *       
 *    2) BirdPet Ŭ������ ��� �ʵ� ���� ���ڿ��� �����ϴ� toString() �޼ҵ带 �ۼ��϶�. 
 *       �̶��� ���� Ŭ������ toString()�� ȣ���ؾ� �Ѵ�.
 *       
 *    3) FishPet Ŭ������ ��� �ʵ� ���� ���ڿ��� �����ϴ� toString() �޼ҵ带 �ۼ��϶�. 
 *       �̶��� ���� Ŭ������ toString()�� ȣ���ؾ� �Ѵ�.
 */
 