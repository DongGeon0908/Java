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
 * [ PetStoreMgmt 클래스 ]
 * 
 *   o 펫가게 운영을 위한 main() 메소드 포함 클래스
 */

public class Ex7_6_2_PetStoreMgmt {
	public static void main(String[] args) {
		
		// 펫가게  펫나라를 개점
		PetStore petNara = PetStore.openPetStore("펫나라", "심청");
		
		// Pet 관련 4가지 클래스의 객체 생성
		//  Pet 클래스 - 이름:짱이, 종류:개, 나이:2, 가격:200000원
		//  MammalPet 클래스 - 이름:콩이, 종류:개, 나이:3, 가격:120000원, 몸무게:1.2KG, 임신기간:60일
		//  BirdPet 클래스 - 이름:초롱이, 종류:앵무새, 나이:1, 가격:40000원, 색깔:레드
		//  FishPet 클래스 - 이름:구피, 종류:열대어, 나이:1, 가격:2000원, 색깔:레드, 적정수온:25도

		Pet p1 = new Pet("짱이", "개", 2, 200000);
		Pet p2 = new MammalPet("콩이", "개", 3, 120000, 1.2, 60);
		Pet p3 = new BirdPet("초롱이", "앵무새", 1, 40000, "레드");
		Pet p4 = new FishPet("구피", "열대어", 1, 2000, "레드", 25);
			
		// p1부터 p4를 펫나라가 소유함
		petNara.havePet(p1); 
		petNara.havePet(p2);
		petNara.havePet(p3);
		petNara.havePet(p4);
		
		// 심청과 춘향이 펫나라 방문하여 환영받음
		Customer sim  = petNara.welcomeCustomer("심청", "서울시 종로구 종로1가 1", "010-2345-6789");
		Customer sung  = petNara.welcomeCustomer("성춘향", "서울시 종로구 종로12가 2", "010-2255-6633");
		
		petNara.sellPet(sim, p1);   // 펫나라가 심청에게 p1을 판매
		petNara.sellPet(sim, p2);   // 펫나라가 심청에게 p2를 판매
			
		petNara.sellPet(sung, p3);  // 펫나라가 심청에게 p2를 판매
		
		petNara.output();	        // 펫나라의 정보를 출력				
	}	
}

/*
 * [ 실습 과제 ]
 * 
 *   1) 전화번호가 "203-2785"이고 "서울시 종로"에 사는 홍길동 고객이 펫나라를 방문하여
 *      p4 펫 객체를 구매하였다를 나타내는 코드를 작성하라.
 *      
 *   2) 펫나라에서 여러 새로운 펫을 소유하고 전화번호가 "443-5389"이고 "서울시 서초"에 사는 향단 고객이 
 *      펫나라를 방문하여 여러 펫 객체를 구매하였다를 나타내는 코드를 작성하라.
 *      
 *   3) 펫 보유하기, 보유 펫 보기, 판매 펫 보기, 고객  방문, 고객에게 펫 판매, 구매고객 보기, 판매현황 보기 등의 
 *      메뉴를 제공하는 펫 관리 프로그램을 PetMgmt 클래스로 작성하라. 
 */