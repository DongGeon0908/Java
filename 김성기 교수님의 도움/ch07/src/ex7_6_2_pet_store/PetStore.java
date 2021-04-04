package ex7_6_2_pet_store;

/**
 * [ �־��� ��Ȳ ] 
 * 
 *   o ȫ�浿�� CEO�� �갡�� �곪��� ���� ã�ƿ��� ȯ���ϰ� 
 *     ��ī��(�� ���̵�, �̸�, �ּ�, ��ȭ��ȣ) �ۼ��Ͽ� ������ ����  
 * 
 * [ ���� ���� ] 
 * 
 *   o ���� �湮�� ������ �湮ȸ�� ���
 *   o ������ ������ �� �Ǹ��ϸ�, �Ǹ�ȸ���� ������ �� ���
 *   o ����  ����̵�, ���̸�, ����, ����, ���� ���� ���� ����
 *   o ���� ���� ���� �� �����ϱ� ���� ��ü �迭 ���
 *    
 * [ PetStore Ŭ���� ]
 * 
 *   o �갡�� ��Ÿ���� Ŭ����
 *     - �ʵ�: ���� ��, �湮��, ���Ű� ���� �����ϱ� ���� �ʵ��
 *     - �޼ҵ�: ���� ����, ȯ��, �� ����, �� �Ǹ� ���� ���� �޼ҵ��   
 */

class PetStore {	
	String storename;
	String CEO;

	int totalAmount;        // �� �Ǹűݾ�
	
	int countPetsHaving;    //���� �� ������
	Pet petsHaving[] = new Pet[30]; // ���Կ��� ������ ���� �����ϴ� petsHaving �迭

	int countCustsVisit;    // �湮�� �ο���
	Customer custsVisit[] = new Customer[30];  // ���Ը� �湮�� ���� �����ϴ� custsVisit �迭

	int countCustsBuying;   // ���Ű� �ο���
	Customer custsBuying[] = new Customer[30]; // ���Կ��� ������ ���� �����ϴ� custsBuying �迭

	// ���� �����ϴ� �޼ҵ� - static �޼ҵ��̹Ƿ� PetStore�� �����ڰ� ��
	static PetStore openPetStore(String storename, String CEO) {
		return new PetStore(storename, CEO);   // PetStore ��ü�� ����
	}

	//	���� �̸�CEO�� �־����� �갡��  ��ü�� �����ϴ� ��ü ������
	PetStore(String storename, String CEO) {
		this.storename = storename;
		this.CEO = CEO;
	}

	// �� ù �湮 �� ȯ�� ó�� �޼ҵ�: ���̸�, �ּ�, ��ȭ��ȣ�� �־����� �� ��ü�� �����Ͽ� �湮 ������ ���
	Customer welcomeCustomer(String name, String addr, String telno) {
		Customer cust  = new Customer(name, addr, telno);  // �� ��ü ����
		
		cust.visitStore(this);   // ���� �湮 ó��

		this.enrolVisitCustomer(cust);  // �湮������ ���

		return cust;
	}
	// �� ��湮 �� ȯ�� ó�� �޼ҵ�
	void welcomeRevisitedCustomer(Customer cust) {
		cust.visitStore(this);   // ���� �湮 ó��
	}

	//	�� �̸�, ����, ����, ������ �־����� �� ��ü�� �����Ͽ� ���� ������ ��� 
	Pet havePet(String petname, String kind, int age, int price) {
		Pet pet = new Pet(petname, kind,  age, price);
		
		this.havePet(pet);       // ���� ������ ���
		
		return pet;
	}
	
	//	�� ��ü��  �־����� ���� ������ ��� 
	void havePet(Pet pet) {
		this.petsHaving[this.countPetsHaving++] = pet; //pet��   petsHaving[] �迭�� ���ҷ� �����ϰ� ���� �� ������ ���� 
	}
	
	// �� ��ü��  �־����� �� ��ü�� ���� �꿡�� �����ϰ� ���� �� ������ ����
	void deletePet(Pet pet) {
		int i;

		for (i=0; i < this.countPetsHaving; i++ )
			if (pet == this.petsHaving[i]) {  // �־��� pet��  ���� ����  ���Ͽ� ��ġ�ϸ�
				break;
			}

		// i�� ������ ��ü��  �ε����� �����, i+1���� �ϳ��� ������ ����Ʈ��Ŵ==> i��° ��ü�� ������
		for (int j = i+1; j < this.countPetsHaving; j++ )
			this.petsHaving[j - 1] = this.petsHaving[j];

		this.countPetsHaving--;  // ���� �� ������ ����
	}

	//	�� ��ü�� �־����� �湮������ ���
	void enrolVisitCustomer(Customer cust) {
		this.custsVisit[this.countCustsVisit++] = cust;  //cust��  custVisit[] �迭�� ���ҷ� �����ϰ� �湮�� �ο��� ����
	}

	//	������  ���� �Ǹ���  ���  �� �Ǹűݾ��� �����ϰ� ���Ű����� ���
	void sellPet(Customer cust, Pet pet) {
		this.totalAmount += pet.price;  // �� �Ǹűݾ��� ����
		
		this.enrolBuyingCustomer(cust, pet);  // ���� �� ���
		this.deletePet(pet);
		
		cust.buyPet(pet, this);         //  ���� ���Կ��� ���� ������ ������ ó��
	}
	
	//	���Ű����� ���
	void enrolBuyingCustomer(Customer cust, Pet pet) {	
		for(int i=0; i < this.countCustsBuying; i++)  // cust�� �̹� ���ŵ������ ��ϵǾ� ������ 
			if (cust == this.custsBuying[i])          // �ٽ� ������� ����
				return;

		this.custsBuying[this.countCustsBuying++] = cust;  //cust��  custBuying[] �迭�� ���ҷ� �����ϰ� ���Ű� �ο��� ����
	}

	// petID�� �־����� �� petID�� Pet ��ü�� ã�� ��ȯ, �� ���̵� ���� ������ null ��ȯ
	Pet getPet(int petID){
		Pet pet;

		for (int i=0; i < this.countPetsHaving; i++ )
			if (petID == this.petsHaving[i].petID) {  //�־��� petID�� ���� ����� petID�� ���Ͽ� ��ġ�ϸ�
				pet = this.petsHaving[i];
				return pet;
			}

		return null;	
	}

	// �־��� ���̵��� ���� ã�� �� ��ü ��ȯ, �� ���̵� ���� ������ null ��ȯ
	Customer getCustomer(int custID) {
		Customer cust;

		for (int i = 0; i < this.countCustsVisit; i++ )
			if (custID == this.custsVisit[i].custID) {
				cust = this.custsVisit[i];
				return cust;
			}

		return null;	 	
	}
	
	void listPetsHaving() {
		if (this.countPetsHaving > 0){ // ���� ���� �� 1���� �̻��̸�  
			System.out.println("\n  ** ���� �� ** \n");
			for (int i = 0; i < this.countPetsHaving; i++)
				this.petsHaving[i].output();
		}	
	}

	void listCustomersVisit() {
		if (this.countCustsVisit > 0){ // �湮 ���� 1�� �̻��̸�  
			System.out.println("\n  ** �湮 �� ** \n");
			for (int i=0; i < this.countCustsVisit; i++)
				this.custsVisit[i].output();
		}	
	}

	void listCustomersBuying() {
		if (this.countCustsBuying > 0){ // ���� ���� 1�� �̻��̸�  
			System.out.println("\n  ** ���� �� ** \n");
			
			for (int i=0; i < this.countCustsBuying; i++) {
				this.custsBuying[i].output("  * ");
				this.custsBuying[i].outputBuying("    - ���� �� ");
			}
		}		
	}
	
	void output() {
		System.out.println("\n\n  **** �갡�Ը�  '" + this.storename + "'   CEO: " + this.CEO + " ****");
		System.out.println("\n  ** ���Ǹž� : " + this.totalAmount+ "\n");

		listPetsHaving();        // ���� �� ���
		
		listCustomersVisit();    // �湮 ��  ���
		
		listCustomersBuying();    // ���� �� ���
	}
}
