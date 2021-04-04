// 여기의 클래스들은 ex6_1_honggildong 패키지에 포함되는 클래스임을 나타냄
package ex6_1_honggildong;

/**
 * [ RighteousOutlaw, CorruptOfficial, HeroMgmt 클래스 ] :
 *      홍길동의 활약을 Java 프로그램으로 표현하기
 * 
 *   o "의적 홍길동은 탐관오리를 징벌하였다, 그 탐관오리는 홍길동에게 징벌받았다."라는 
 *     상황을 나타내는 가상적 Java 프로그램
 *     
 *     1. << 주어진 상황>>
 *        "의적 홍길동은 탐관오리를 징벌하였다, 그 탐관오리는 홍길동에게 징벌받았다."
 *  
 *     2. << 객체, 클래스, 이름에 대한 보다 정확한 표현 >>
 *        "이름이 홍길동인 의적 클래스의 객체가 이름이 무명인 탐관오리 클래스의 객체를 징벌했다."
 *    
 *     3. << 객체 참조를 통한 명확한 표현 >>
 *       1) 의적 클래스의 객체가 있고, O1이 이를 참조한다. O1의 이름은 홍길동이다.
 *       2) 탐관오리 클래스의 객체가 있고, O2가 이를 참조한다. O2의 이름은 무명이며, 관직명은 알지 못함이다.
 *       3) O1이 O2를 징벌했다.
 *       4) O2는 O1에게 징벌받았다.
 *       
 *     4. 작성된  Java 프로그램
 */
 
 class RighteousOutlaw {  // 의적 클래스
	String name;         //   	이름 필드

	// punish(): 의적 객체가 탐관오리 객체를 징벌하는 메소드
	void punish(CorruptOfficial co) {  
		// 탐관오리를 불시에 잡아서 질책하는 등 보다 구체적인 
		// 작업들로 구성되며, 세부 내용은 생략함
		//   this.catchSuddenly(co);
		//   this.rebuke(co);
		//   ...
		
		System.out.println("\n  * " + this.name +" 의적 클래스 객체가 " + co.name + " 탐관오리 객체를 징벌했다");
				
	}
}

class CorruptOfficial {  // 탐관오리 클래스
	String name;         //  	이름 필드
	String publicPost;   //    	관직명 필드

	// bePunishedBy(): 탐관오리 객체가 의적 객체에게 징벌받는 메소드
	void bePunishedBy(RighteousOutlaw ro) {
		// 세부 내용은 생략함
		
		System.out.println("\n  * " + this.name +" 탐관오리 클래스 객체가 " + ro.name + " 의적 객체에게 징벌받았다\n");

	}
}

class Ex6_1_HeroMgmt {
	public static void main(String[] args) {
		RighteousOutlaw O1              // 의적 객체 참조할 객체 참조변수 O1,  
	       	= new RighteousOutlaw();    //    의적 객체 생성하여 O1이 참조
		O1.name = "홍길동";              // O1이 참조하는 객체의 이름 저장

		CorruptOfficial O2             // 탐관오리 객체 참조할 참조변수 O2,
	     	= new CorruptOfficial();   //   탐관오리 객체 생성하여 O2가 참조
		O2.name = "무명씨";          	   // O2가 참조하는 객체의 이름 저장
		O2.publicPost = "알지 못함";      // O2가 참조하는 객체의 관직명 저장

		O1.punish(O2);                 // O1 참조 객체가 O2 참조 객체를 징벌함
		O2.bePunishedBy(O1);           // O2 참조 객체가 O1 참조 객체에게 징벌받음
	}
}


/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) << 주어진 상황 >>을 << 객체, 클래스, 이름에 대한 보다 정확한 표현 >>과
 *      << 객체 참조를 통한 명확한 표현 >>으로의 변환한 과정을 살펴보고 그 의미를 이해하라.
 *   
 *   2) << 객체 참조를 통한 명확한 표현 >>이 변환된 Ex6_1_Honggildong 패키지의 클래스를 
 *      살펴보고 명확한 표현과의 관련성을 이해하라.
 *      
 *   3) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *   
 *   o 다음의 주어진 상황을 << 객체, 클래스, 이름에 대한 보다 정확한 표현 >>과
 *     << 객체 참조를 통한 명확한 표현 >>으로 변환하고 이를 나타내는 가상적인 Java 프로그램을
 *     작성하라.
 *      
 *     (1) 심청이 심학규를 잔치에서 만났다.
 *     (2) 이몽룡은 한양으로 가서 과거시험을 보았다.
 *     (3) 뺑덕이가 (아파) 병원에 가서 허준에게 치료받았다.
 */
