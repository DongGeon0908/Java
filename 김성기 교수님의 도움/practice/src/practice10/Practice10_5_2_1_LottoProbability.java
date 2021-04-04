package practice10;

import java.util.Random;
import java.util.Date;

/**
 * [ 10장 실습과제 5-2 모범 답안 1) ]: 
 *        Random 클래스의 난수를 이용하여 로또 1등 확률 구하기
 *    
 *   o 5-2) 난수 관련 프로그래밍(방법 1)
 *   
 *      2) 로또는 1부터 45까지 서로 다른 6개의 정수가 일치하면 1등으로 당첨되는 복권이다. 
 *         java.util.Random 클래스의 메소드를 이용하여 로또 1등 당첨될 확률을 다음의 과정으로 구하라.
 *           
 *        (1) 1부터 45까지 서로 다른 정수 6개를 입력하여 가상적 1등 번호들로 설정한다. 또한, 비교회수를 0으로 저장한다.
 *          
 *        (2) 1부터 45까지 서로 다른 6개의 난수를 추출하여 가상적 1등 번호들과 비교하여 모두 일치하면 (3)을 수행하라. 
 *            일치하지 않으면 비교회수를 1 증가시키고 (2)를 반복하라.
 *              
 *        (3) 일치할 때까지 총 비교회수를 n이라 하면 1 / (double) n으로 당첨확률로 출력하라.
 *        
 *   o 방법 1: 로또 1등 당첨 번호와 로또 번호 6개를 정수 배열에 저장
 *   
 *     - 서로 다른 정수 6개의 로또 번호들을 구한 후 정렬하여 배열에 저장
 *     - 정렬되면 1등 번호와 선택된 번호의 당첨 여부 비교가  쉬워짐
 */

public class Practice10_5_2_1_LottoProbability {

	static int[] lottoNosFirst = new int[6];
	static int[] lottoNosSelected = new int[6];

	static int totalTries = 0;
	static long totalN = 0;

	static Date startTime;
	static Date endTime;
	static long totalTime;

	public static void main(String[] args) {

		while(true) {
			long n = 0;  					// 당첨까지의 회수 저장하는 변수 0으로 초기화
			startTime = new Date();  		// 시작시간 기록 

			getLottoNos(lottoNosFirst);		// 1등 당첨 로또 번호들을 구함
			outputLottoNos(lottoNosFirst, "\n\n  * 1등 로또 번호들");

			while(true) {
				n++;	

				getLottoNos(lottoNosSelected);						// 로또 번호들 선택함

				if (sameLottoNos(lottoNosFirst, lottoNosSelected))  // 선택된 번호들이 1등 번호들과 같으면
					break;											//    당첨 처리
			}

			/* 
			 * 당첨 관련 여러 정보들을 출력
			 */
			System.out.println("\n  * 당첨! " + n / 10000 + "만 " + n % 10000 + "번 째 당첨, 확률: " + 1 / (double) n );
			outputLottoNos(lottoNosSelected, "  * 당첨 로또 번호들");

			totalTries++;
			totalN += n;
			System.out.println("\n  * " + totalTries + "번째 당첨까지 평균 회수 : " + totalN / totalTries / 10000 + "만 " 
					+ totalN / totalTries % 1000 + "번 , 평균확률: " + totalTries / (double) totalN );

			endTime = new Date();									// 당첨 종료시간 기록
			long time = endTime.getTime() - startTime.getTime();  	// 시작에서 당첨까지 소요시간 구함(단위: 밀리초)
			totalTime += time;                                    	// 총 소요시간에 누적

			System.out.println("  * " + totalTries + "번째 소요시간: " + time * 100 / 1000 / 100. + "(초), 평균소요시간: " + totalTime * 100 / 1000 / totalTries / 100.   + "(초)");
		}

	}

	// 1부터 45까지 6개 서로 다른 로또 번호들 구해 주어진 lottoNos 배열에 저장
	static void getLottoNos(int[] lottoNos) {
		lottoNos[0] = getLottoNo();

		for (int i = 1; i < 6; i++) {
			int aLottoNo;

			// 2번째부터 6번째는 이미 선택된 이전 번호와 달라야 함
			do {
				aLottoNo = getLottoNo();

			}
			while(containsLottoNo(lottoNos, aLottoNo, i));

			lottoNos[i] = aLottoNo;	
		}

		sortLotto(lottoNos);  // 로또번호들 간 일치 검사를 위해 wjdfuftlzla
	}

	static Random rd = new Random();
	
	// 1부터 45까지 로또 번호들 난수로 구해 반환
	static int getLottoNo() {
		return rd.nextInt(45) + 1;
	}

	// 주어진	lottoNos 배열에 cnt 개의 로또 번호가 저장되어 있을 때 주어진 aLottoNo 번호를
	//   이미 포함하면 true, 아니면 false 반환
	static boolean containsLottoNo(int[] lottoNos, int aLottoNo, int cnt) {
		for (int i = 0; i < cnt; i++)
			if (lottoNos[i] == aLottoNo)
				return true;

		return false;		
	}

	// 주어진	lottoNos 배열에  로또 번호가 저장되어 있을 때 로또 번호를 모두 출력
	static void outputLottoNos(int[] lottoNos, String msg) {
		System.out.print(msg + ": [ ");

		for (int i=0; i < 6; i++) {
			System.out.print( lottoNos[i] + " ");
		}

		System.out.println(" ]");		
	}

	// 주어진	lottoNos1 배열과 lottoNos2 배열의  로또 번호가 일치하는가 검사
	//   로또 번호는 정렬되어 배열에 저장되므로 원소 하나씩 비교하여 모두 같으면 일치
	static boolean sameLottoNos(int[] lottoNos1, int[]lottoNos2) {

		for (int i=0; i < 6; i++) {
			if (lottoNos1[i] != lottoNos2[i])  // 원소 하나라도 같지 않으면
				return false;                  //    일치하지 않으므로 false 반환
		}

		return true;                           // 모두 일치하면 true 반환
	}

	// 주어진	lottoNos 배열을 크기순으로 정렬
	static void sortLotto(int[] lottoNos) {
		java.util.Arrays.sort(lottoNos);  // java.util.Arrays의 정렬 메소드 이용
	}

}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 로또 1등 당첨 확률을 개략적으로 구해본다.
 *         
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 */
