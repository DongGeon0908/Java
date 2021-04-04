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
 * [ Customer 클래스 ]
 * 
 *   o 펫을 구매하는 고객을 나타내는 클래스
 *     - 필드: 고객 정보와 구매한 pet 정보를 저장하기 위한 필드들
 *     - 메소드: 객체 생성자, 구매하다, 방문하다, toString(), output(), outputBuying() 
 */

import java.util.Date;  // 날짜와 시간을 저장하는 Date 객체를 생성하고 관리하는 클래스

class Customer {
	static int nextCustID = 2001;  // 고객아이디를 부여하기 위한 static 변수
	
	int custID;
	String name;
	String addr;
	String telno;
	Date dateEnrol;   // 등록날짜와 시간을 저장

	int countVisit;   // 방문회수

	int countBuying;  // 구매회수
	Pet petsBuying[] = new Pet[10];  // 구매 펫을 저장하는 Pet 배열, 최대 10마리까지
	
	// 아래 부분에서 사용되는 this는 생성되거나 수신자로 사용되는 객체를 나타내는 특수한 객체 참조 변수인
	//   this는 대부분의 경우 생략되지만, 이 프로그램에서는 생략하지 않고 사용
	// this가 생략되지 못하는 경우는 메소드의 매개변수와 필드의 이름이 같은 경우로서, 
	//   이 경우 매개변수가 우선순위가 높으므로 필드에 반드시 'this.'을 붙여야 한다.  

	//	이름, 주소, 전화번호가 주어지면 고객객체를  생성하는 객체 생성자
	Customer(String name, String addr, String telno) { 
		this.custID = nextCustID++; // nextCustID로 고객아이디를 할당하고 nextCustID 1 증가
		this.name = name;
		this.addr = addr;
		this.telno = telno;	   
		
		this.dateEnrol = new Date(); //  new Date()는 현재 날짜와 시간으로 설정된 Date 객체를 생성하여 반환
	}

	// 고객이 펫을 가게에서 구매
	void buyPet(Pet pet, PetStore store) {  
		this.petsBuying[countBuying++] = pet;  // 구매 펫을  petsBuying 배열에 저장하고 구매회수 증가		
	}

	// 고객의 가게 방문
	void visitStore(PetStore store){  
		this.countVisit++;       // 방문회수 증가
	}
	public String toString() {
		return "고객 아이디: " + this.custID + "\t 고객 이름: " + this.name + "\t 주소: " + this.addr 
				 + "\\n\\t\\t\t 전화번호: "+this.telno + "\t 등록일: " + this.dateEnrol
				 + "\n\t\t\t 방문회수: " + this.countVisit + "\t 펫 구매회수: " +countBuying;
		
	}
	
	// 고객의 기본정보를 리딩 메시지와 함께 출력
	void output(String leadingMsg) {
		System.out.println(leadingMsg + this.toString() + "\n");
	}

	// 고객의 기본정보 출력
	void output() {
		output("  * ");
	}

	// 고객의 구매정보 출력
	void outputBuying(String leadingMsg) {
		if (this.countBuying > 0){        // 1 마리 이상의 pet 구매 한 경우 
			for (int i=0; i < this.countBuying; i++)
				this.petsBuying[i].output(leadingMsg);
			
			System.out.println("\n");
		}
	}

	// 고객의 구매정보를 리딩 메시지와 함께 출력
	void outputBuying() {
		outputBuying("  * ");
	}
}
