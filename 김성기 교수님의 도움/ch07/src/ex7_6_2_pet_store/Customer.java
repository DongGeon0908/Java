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
 * [ Customer Ŭ���� ]
 * 
 *   o ���� �����ϴ� ���� ��Ÿ���� Ŭ����
 *     - �ʵ�: �� ������ ������ pet ������ �����ϱ� ���� �ʵ��
 *     - �޼ҵ�: ��ü ������, �����ϴ�, �湮�ϴ�, toString(), output(), outputBuying() 
 */

import java.util.Date;  // ��¥�� �ð��� �����ϴ� Date ��ü�� �����ϰ� �����ϴ� Ŭ����

class Customer {
	static int nextCustID = 2001;  // �����̵� �ο��ϱ� ���� static ����
	
	int custID;
	String name;
	String addr;
	String telno;
	Date dateEnrol;   // ��ϳ�¥�� �ð��� ����

	int countVisit;   // �湮ȸ��

	int countBuying;  // ����ȸ��
	Pet petsBuying[] = new Pet[10];  // ���� ���� �����ϴ� Pet �迭, �ִ� 10��������
	
	// �Ʒ� �κп��� ���Ǵ� this�� �����ǰų� �����ڷ� ���Ǵ� ��ü�� ��Ÿ���� Ư���� ��ü ���� ������
	//   this�� ��κ��� ��� ����������, �� ���α׷������� �������� �ʰ� ���
	// this�� �������� ���ϴ� ���� �޼ҵ��� �Ű������� �ʵ��� �̸��� ���� ���μ�, 
	//   �� ��� �Ű������� �켱������ �����Ƿ� �ʵ忡 �ݵ�� 'this.'�� �ٿ��� �Ѵ�.  

	//	�̸�, �ּ�, ��ȭ��ȣ�� �־����� ����ü��  �����ϴ� ��ü ������
	Customer(String name, String addr, String telno) { 
		this.custID = nextCustID++; // nextCustID�� �����̵� �Ҵ��ϰ� nextCustID 1 ����
		this.name = name;
		this.addr = addr;
		this.telno = telno;	   
		
		this.dateEnrol = new Date(); //  new Date()�� ���� ��¥�� �ð����� ������ Date ��ü�� �����Ͽ� ��ȯ
	}

	// ���� ���� ���Կ��� ����
	void buyPet(Pet pet, PetStore store) {  
		this.petsBuying[countBuying++] = pet;  // ���� ����  petsBuying �迭�� �����ϰ� ����ȸ�� ����		
	}

	// ���� ���� �湮
	void visitStore(PetStore store){  
		this.countVisit++;       // �湮ȸ�� ����
	}
	public String toString() {
		return "�� ���̵�: " + this.custID + "\t �� �̸�: " + this.name + "\t �ּ�: " + this.addr 
				 + "\\n\\t\\t\t ��ȭ��ȣ: "+this.telno + "\t �����: " + this.dateEnrol
				 + "\n\t\t\t �湮ȸ��: " + this.countVisit + "\t �� ����ȸ��: " +countBuying;
		
	}
	
	// ���� �⺻������ ���� �޽����� �Բ� ���
	void output(String leadingMsg) {
		System.out.println(leadingMsg + this.toString() + "\n");
	}

	// ���� �⺻���� ���
	void output() {
		output("  * ");
	}

	// ���� �������� ���
	void outputBuying(String leadingMsg) {
		if (this.countBuying > 0){        // 1 ���� �̻��� pet ���� �� ��� 
			for (int i=0; i < this.countBuying; i++)
				this.petsBuying[i].output(leadingMsg);
			
			System.out.println("\n");
		}
	}

	// ���� ���������� ���� �޽����� �Բ� ���
	void outputBuying() {
		outputBuying("  * ");
	}
}
