package ex7_6_2_pet_store;

/**
 * [ 주어진 상황 ] 
 * 
 *   o 홍길동이 CEO인 펫가게인 펫나라는 고객이 찾아오면 환영하고 
 *     고객카드(고객 아이디, 이름, 주소, 전화번호) 작성하여 고객으로 관리
 *     
 * [ 관리 내용 ] 
 * 
 *   o 고객이 방문할 때마다 방문회수 기록
 *   o 고객에게 보유한 펫 판매하며, 판매회수와 구매한 펫 기록
 *   o 펫은  펫아이디, 펫이름, 종류, 나이, 가격 등의 정보 가짐
 *   o 여러 고객과 여러 펫을 관리하기 위해 배열 사용
 *    
 * [ Pet 클래스 ]
 * 
 *   o 펫을 나타내는 클래스
 *     - 필드: 펫 정보를 저장하기 위한 필드들
 *     - 메소드: 객체 생성자, toString(), output()
 *   
 * [ Pet의 하위 클래스들 ]
 * 
 *   o 포유류, 조류, 어류 등 종류별 펫을 나타내는 하위 클래스들
 *     - MammalPet
 *     - BirdPet
 *     - FishPet
 *     
 *   o 하위 클래스마다 새로운 필드를 가지며, 객체 생성자도 달라짐
 */

class Pet {
	static int nextPetID = 1001;  // 펫 아이디를 할당하기 위한 static 변수

	int petID;
	String petname;
	String kind;
	int age;
	int price;

	Pet() {		
	}

	// 펫 이름, 종류, 나이, 가격이 주어지면 펫 객체를 생성하는 객체 생성자
	Pet(String petname,String kind, int age, int price) {
		this.petID = nextPetID++;  // nextPetID로 펫아이디를 할당하고 nextPetID 1 증가
		this.petname = petname ;
		this.kind = kind;
		this.age = age;
		this.price = price;
	}

	public String toString() {
		return "아이디: " + this.petID + "\t 펫이름: " + this.petname + "\t 종류: " + this.kind + "\t 나이: " 
	           + this.age + "\t 가격: " + this.price;
		
	}
	
	void output(String leadingMsg) {
		System.out.println(leadingMsg + this.toString() + "\n");
	}
	
	void output() {
		output("  * 펫 ");
	}	
}

class MammalPet extends Pet {
	// MammalPet 클래스는 몸무게, 임신기간 필드를 추가로 가짐
	double weight;
	int pregnancyPeriod;
	
	MammalPet(String petname, String kind, int age, int price, double weight, int pregnancyPeriod) {
		super(petname, kind,  age,  price);
		this.weight = weight; 
        this.pregnancyPeriod = pregnancyPeriod;
	}
}

class BirdPet extends Pet {
	// BirdPet 클래스는 색깔 필드를 추가로 가짐
	String color;
	
	BirdPet(String petname, String kind, int age, int price, String color) {
		super(petname, kind,  age,  price);
		this.color = color; 
	}
}

class FishPet extends Pet {
   // FishPet 클래스는 색깔, 적정수온 필드를 추가로 가짐
	String color;
	int optimumTemperature; 
	
	FishPet(String petname, String kind, int age, int price, String color, int optimumTemperature) {
		super(petname, kind,  age,  price);
		this.color = color; 
		this.optimumTemperature = optimumTemperature;
	}
}

/*
 * [ 프로그램 살펴보기 및 프로그램 이해 ]
 * 
 *    1) MammalPet 클래스는 Pet 클래스의 하위 클래스로 Pet 클래스의 필드 외에 몸무게, 임신기간  필드를 추가로 갖는다.
 *           
 *    2) BirdPet 클래스는 Pet 클래스의 하위 클래스로 Pet 클래스의 필드 외에 색깔 필드를 추가로 갖는다.
 *    
 *    3) FishPet 클래스는 Pet 클래스의 하위 클래스로 Pet 클래스의 필드 외에 색깔, 적정수온 필드를 추가로 갖는다.
 *    
 *      
 *  [ 실습 과제 ]
 *  
 *    1) MammalPet 클래스의 모든 필드 값을 문자열로 구성하는 toString() 메소드를 작성하라. 
 *       이때는 상위 클래스의 toString()을 호출해야 한다.
 *       
 *    2) BirdPet 클래스의 모든 필드 값을 문자열로 구성하는 toString() 메소드를 작성하라. 
 *       이때는 상위 클래스의 toString()을 호출해야 한다.
 *       
 *    3) FishPet 클래스의 모든 필드 값을 문자열로 구성하는 toString() 메소드를 작성하라. 
 *       이때는 상위 클래스의 toString()을 호출해야 한다.
 */
 