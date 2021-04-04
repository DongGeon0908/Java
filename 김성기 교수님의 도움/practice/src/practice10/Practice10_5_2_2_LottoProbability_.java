package practice10;

import java.util.Random;
import java.util.Date;

/**
 * [ 10장 실습과제 5-2 모범 답안2) ]: 
 *        Random 클래스의 난수를 이용하여 로또 1등 확률 구하기
 *    
 *   o 5-2) 난수 관련 프로그래밍(방법 2)
 *   
 *        2) 로또는 1부터 45까지 서로 다른 6개의 정수가 일치하면 1등으로 당첨되는 복권이다. 
 *           java.util.Random 클래스의 메소드를 이용하여 로또 1등 당첨될 확률을 다음의 과정으로 구하라.
 *            
 *           (1) 1부터 45까지 서로 다른 정수 6개를 입력하여 가상적 1등 번호들로 설정한다. 또한, 비교회수를 0으로 저장한다.
 *           
 *           (2) 1부터 45까지 서로 다른 6개의 난수를 추출하여 가상적 1등 번호들과 비교하여 모두 일치하면 (3)을 수행하라. 
 *               일치하지 않으면 비교회수를 1 증가시키고 (2)를 반복하라.
 *               
 *           (3) 일치할 때까지 총 비교회수를 n이라 하면 1 / (double) n으로 당첨확률로 출력하라.
 *           
 *   o 방법 2: 로또 1등 당첨 번호와 로또 번호 6개를 long 정수의 비트로 표시
 *   
 *     - 하나의 long 정수로 6개 로또 번호 표현 가능하므로 여러 면에서 편리하고 성능이 좋아짐
 *     
 *     - 6개 로또번호를 long 정수끼리 바로 비교하여 당첨 여부 확인 가능함
 *     
 *     - long 정수를 다루는 프로그램은 int 정수를 다루는 프로그램보다
 *       작성하고 디버깅하기가 훨씬 어려움
 *   
 */

public class Practice10_5_2_2_LottoProbability_ {	
	static int CNTLOTTONOS = 6;
	static int MAXLOTTONO = 45;
	
	static long lottoNosFirst;
	static long lottoNosSelected;

	static int totalTries = 0;
	static long totalN = 0;
	

	static Date startTime;
	static Date endTime;
	static long totalTime;
    
	public static void main(String[] args) {

		while(true) {
			long n = 0;  					// 당첨까지의 회수 저장하는 변수 0으로 초기화
			startTime = new Date();  		// 시작시간 기록 

			lottoNosFirst = getLottoNos();  			// 1등 당첨 로또 번호들을 구함
			outputLottoNos(lottoNosFirst, "\n\n  * 1등 로또 번호들");

			while(true) {
				n++;	

				lottoNosSelected = getLottoNos(); 		// 로또 번호들 선택함

				if (lottoNosFirst == lottoNosSelected)	// 선택된 번호들이 1등 번호들과 같으면
					break;								//    당첨 처리
			}

			System.out.println("\n  * 당첨! " + n / 10000 + "만 " + n % 10000 + "번 째 당첨, 확률: " + 1 / (double) n );
			outputLottoNos(lottoNosSelected, "  * 당첨 로또 번호들");
			
			totalTries++;
			totalN += n;	
			
			System.out.println("\n  * " + totalTries + "번째 당첨까지 평균 회수: " + totalN / totalTries / 10000 + "만 " 
					+ totalN / totalTries % 1000 + "번 , 평균확률: " + totalTries / (double) totalN );
			
			endTime = new Date();
			long time = endTime.getTime() - startTime.getTime();
			totalTime += time;
			
			System.out.println("  * " + totalTries + "번째 소요시간: " + time * 100 / 1000 / 100. + "(초), 평균소요시간: " + totalTime * 100 / 1000 / totalTries / 100.   + "(초)");
		
		
		}

	}

	// CNTLOTTONOS개 서로 다른 로또 번호들 구해 long 정수에 비트 패턴으로 저장하여 반환
	//   예를 들어, 1, 3, 5, 10, 11, 13이 로또 번호로 선택되면
	//   aLottoNo에는 0b0010_1100_0010_1010 이 저장됨
	static long getLottoNos() {
		long aLottos = 0;

		for (int i = 0; i < CNTLOTTONOS; i++) {
			int aLottoNo;

			// 선택된 위치의 비트가 1이 아니면 중복 안된 번호이므로 해당 위치의 비트를 1로 지정 
			do {
				aLottoNo = getLottoNo();  // 로또 번호 하나 구함
			}
			while( (aLottos & (1L << aLottoNo)) != 0); // aLottoNo 위치의 비트가 1인가를 검사여 0이 아니면 이미 선택된 번호

			aLottos = (aLottos | (1L << aLottoNo));	   // 선택된 번호 aLottoNo의 비트 위치를 1로 지정
		}
			
		return aLottos;
	}

	static Random rd = new Random();
	
	// 1부터 MAXLOTTONO까지 로또 번호들 난수로 구해 반환
	static int getLottoNo() {
		return rd.nextInt(MAXLOTTONO) + 1;
	}

	// 주어진	lottoNos에  로또 번호들이 비트 패턴으로 저장되어 있을 때 로또 번호들을 모두 출력
	static void outputLottoNos(long aLottos, String msg) {
		System.out.print(msg + ": [ ");

		for (int i=1; i <= MAXLOTTONO; i++) {

			if ((aLottos & (1L << i)) != 0)  // i위치 비트가 0이 아니면
				System.out.print( i + " ");  //    위치 i를 출력
		}

		System.out.println("]");		
	}

}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 로또 1등 당첨 확률을 개략적으로 구해본다.
 *         
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 */
