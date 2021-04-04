package ex7_6_2_pet_store;

/**
 * [ 주어진 상황 ] 
 * 
 *   o 홍길동이 CEO인 펫가게 펫나라는 고객이 찾아오면 환영하고 
 *     고객카드(고객 아이디, 이름, 주소, 전화번호) 작성하여 고객으로 관리  
 * 
 * [ 관리 내용 ] 
 * 
 *   o 고객이 방문할 때마다 방문회수 기록
 *   o 고객에게 보유한 펫 판매하며, 판매회수와 구매한 펫 기록
 *   o 펫은  펫아이디, 펫이름, 종류, 나이, 가격 등의 정보 가짐
 *   o 여러 고객과 여러 펫 관리하기 위해 객체 배열 사용
 *    
 * [ PetStore 클래스 ]
 * 
 *   o 펫가게 나타내는 클래스
 *     - 필드: 보유 펫, 방문고객, 구매고객 등을 관리하기 위한 필드들
 *     - 메소드: 가게 개설, 환영, 펫 보유, 펫 판매 등을 위한 메소드들   
 */

class PetStore {	
	String storename;
	String CEO;

	int totalAmount;        // 총 판매금액
	
	int countPetsHaving;    //보유 펫 마리수
	Pet petsHaving[] = new Pet[30]; // 가게에서 보유한 펫을 저장하는 petsHaving 배열

	int countCustsVisit;    // 방문고객 인원수
	Customer custsVisit[] = new Customer[30];  // 가게를 방문한 고객을 저장하는 custsVisit 배열

	int countCustsBuying;   // 구매고객 인원수
	Customer custsBuying[] = new Customer[30]; // 가게에서 구매한 고객을 저장하는 custsBuying 배열

	// 가게 개설하는 메소드 - static 메소드이므로 PetStore가 수신자가 됨
	static PetStore openPetStore(String storename, String CEO) {
		return new PetStore(storename, CEO);   // PetStore 객체를 생성
	}

	//	가게 이름CEO가 주어지면 펫가게  객체를 생성하는 객체 생성자
	PetStore(String storename, String CEO) {
		this.storename = storename;
		this.CEO = CEO;
	}

	// 고객 첫 방문 시 환영 처리 메소드: 고객이름, 주소, 전화번호가 주어지면 고객 객체를 생성하여 방문 고객으로 등록
	Customer welcomeCustomer(String name, String addr, String telno) {
		Customer cust  = new Customer(name, addr, telno);  // 고객 객체 생성
		
		cust.visitStore(this);   // 가게 방문 처리

		this.enrolVisitCustomer(cust);  // 방문고객으로 등록

		return cust;
	}
	// 고객 재방문 시 환영 처리 메소드
	void welcomeRevisitedCustomer(Customer cust) {
		cust.visitStore(this);   // 가게 방문 처리
	}

	//	펫 이름, 종류, 나이, 가격이 주어지면 펫 객체를 생성하여 보유 펫으로 등록 
	Pet havePet(String petname, String kind, int age, int price) {
		Pet pet = new Pet(petname, kind,  age, price);
		
		this.havePet(pet);       // 보유 펫으로 등록
		
		return pet;
	}
	
	//	펫 객체가  주어지면 보유 펫으로 등록 
	void havePet(Pet pet) {
		this.petsHaving[this.countPetsHaving++] = pet; //pet을   petsHaving[] 배열의 원소로 저장하고 보유 펫 마리수 증가 
	}
	
	// 펫 객체가  주어지면 그 객체를 보유 펫에서 삭제하고 보유 펫 마리수 감소
	void deletePet(Pet pet) {
		int i;

		for (i=0; i < this.countPetsHaving; i++ )
			if (pet == this.petsHaving[i]) {  // 주어진 pet이  보유 펫들과  비교하여 일치하면
				break;
			}

		// i는 삭제할 객체의  인덱스가 저장됨, i+1부터 하나씩 앞으로 쉬프트시킴==> i번째 객체가 삭제됨
		for (int j = i+1; j < this.countPetsHaving; j++ )
			this.petsHaving[j - 1] = this.petsHaving[j];

		this.countPetsHaving--;  // 보유 펫 마리수 감소
	}

	//	고객 객체가 주어지면 방문고객으로 등록
	void enrolVisitCustomer(Customer cust) {
		this.custsVisit[this.countCustsVisit++] = cust;  //cust를  custVisit[] 배열의 원소로 저장하고 방문고객 인원수 증가
	}

	//	고객에게  펫을 판매한  경우  총 판매금액을 누적하고 구매고객으로 등록
	void sellPet(Customer cust, Pet pet) {
		this.totalAmount += pet.price;  // 총 판매금액을 누적
		
		this.enrolBuyingCustomer(cust, pet);  // 구매 고객 등록
		this.deletePet(pet);
		
		cust.buyPet(pet, this);         //  고객이 가게에서 펫을 구매한 내역을 처리
	}
	
	//	구매고객으로 등록
	void enrolBuyingCustomer(Customer cust, Pet pet) {	
		for(int i=0; i < this.countCustsBuying; i++)  // cust가 이미 구매등록으로 등록되어 있으면 
			if (cust == this.custsBuying[i])          // 다시 등록하지 않음
				return;

		this.custsBuying[this.countCustsBuying++] = cust;  //cust를  custBuying[] 배열의 원소로 저장하고 구매고객 인원수 증가
	}

	// petID가 주어지면 그 petID의 Pet 객체를 찾아 반환, 그 아이디 펫이 없으면 null 반환
	Pet getPet(int petID){
		Pet pet;

		for (int i=0; i < this.countPetsHaving; i++ )
			if (petID == this.petsHaving[i].petID) {  //주어진 petID와 보유 펫들의 petID를 비교하여 일치하면
				pet = this.petsHaving[i];
				return pet;
			}

		return null;	
	}

	// 주어진 아이디의 고객을 찾아 고객 객체 반환, 그 아이디 고객이 없으면 null 반환
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
		if (this.countPetsHaving > 0){ // 보유 펫이 이 1마리 이상이면  
			System.out.println("\n  ** 보유 펫 ** \n");
			for (int i = 0; i < this.countPetsHaving; i++)
				this.petsHaving[i].output();
		}	
	}

	void listCustomersVisit() {
		if (this.countCustsVisit > 0){ // 방문 고객이 1명 이상이면  
			System.out.println("\n  ** 방문 고객 ** \n");
			for (int i=0; i < this.countCustsVisit; i++)
				this.custsVisit[i].output();
		}	
	}

	void listCustomersBuying() {
		if (this.countCustsBuying > 0){ // 구매 고객이 1명 이상이면  
			System.out.println("\n  ** 구매 고객 ** \n");
			
			for (int i=0; i < this.countCustsBuying; i++) {
				this.custsBuying[i].output("  * ");
				this.custsBuying[i].outputBuying("    - 구매 펫 ");
			}
		}		
	}
	
	void output() {
		System.out.println("\n\n  **** 펫가게명  '" + this.storename + "'   CEO: " + this.CEO + " ****");
		System.out.println("\n  ** 총판매액 : " + this.totalAmount+ "\n");

		listPetsHaving();        // 보유 펫 출력
		
		listCustomersVisit();    // 방문 고객  출력
		
		listCustomersBuying();    // 구매 고객 출력
	}
}
