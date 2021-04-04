package practice10;

import java.util.Random;
import java.util.Date;

/**
 * [ 10�� �ǽ����� 5-2 ��� ��� 1) ]: 
 *        Random Ŭ������ ������ �̿��Ͽ� �ζ� 1�� Ȯ�� ���ϱ�
 *    
 *   o 5-2) ���� ���� ���α׷���(��� 1)
 *   
 *      2) �ζǴ� 1���� 45���� ���� �ٸ� 6���� ������ ��ġ�ϸ� 1������ ��÷�Ǵ� �����̴�. 
 *         java.util.Random Ŭ������ �޼ҵ带 �̿��Ͽ� �ζ� 1�� ��÷�� Ȯ���� ������ �������� ���϶�.
 *           
 *        (1) 1���� 45���� ���� �ٸ� ���� 6���� �Է��Ͽ� ������ 1�� ��ȣ��� �����Ѵ�. ����, ��ȸ���� 0���� �����Ѵ�.
 *          
 *        (2) 1���� 45���� ���� �ٸ� 6���� ������ �����Ͽ� ������ 1�� ��ȣ��� ���Ͽ� ��� ��ġ�ϸ� (3)�� �����϶�. 
 *            ��ġ���� ������ ��ȸ���� 1 ������Ű�� (2)�� �ݺ��϶�.
 *              
 *        (3) ��ġ�� ������ �� ��ȸ���� n�̶� �ϸ� 1 / (double) n���� ��÷Ȯ���� ����϶�.
 *        
 *   o ��� 1: �ζ� 1�� ��÷ ��ȣ�� �ζ� ��ȣ 6���� ���� �迭�� ����
 *   
 *     - ���� �ٸ� ���� 6���� �ζ� ��ȣ���� ���� �� �����Ͽ� �迭�� ����
 *     - ���ĵǸ� 1�� ��ȣ�� ���õ� ��ȣ�� ��÷ ���� �񱳰�  ������
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
			long n = 0;  					// ��÷������ ȸ�� �����ϴ� ���� 0���� �ʱ�ȭ
			startTime = new Date();  		// ���۽ð� ��� 

			getLottoNos(lottoNosFirst);		// 1�� ��÷ �ζ� ��ȣ���� ����
			outputLottoNos(lottoNosFirst, "\n\n  * 1�� �ζ� ��ȣ��");

			while(true) {
				n++;	

				getLottoNos(lottoNosSelected);						// �ζ� ��ȣ�� ������

				if (sameLottoNos(lottoNosFirst, lottoNosSelected))  // ���õ� ��ȣ���� 1�� ��ȣ��� ������
					break;											//    ��÷ ó��
			}

			/* 
			 * ��÷ ���� ���� �������� ���
			 */
			System.out.println("\n  * ��÷! " + n / 10000 + "�� " + n % 10000 + "�� ° ��÷, Ȯ��: " + 1 / (double) n );
			outputLottoNos(lottoNosSelected, "  * ��÷ �ζ� ��ȣ��");

			totalTries++;
			totalN += n;
			System.out.println("\n  * " + totalTries + "��° ��÷���� ��� ȸ�� : " + totalN / totalTries / 10000 + "�� " 
					+ totalN / totalTries % 1000 + "�� , ���Ȯ��: " + totalTries / (double) totalN );

			endTime = new Date();									// ��÷ ����ð� ���
			long time = endTime.getTime() - startTime.getTime();  	// ���ۿ��� ��÷���� �ҿ�ð� ����(����: �и���)
			totalTime += time;                                    	// �� �ҿ�ð��� ����

			System.out.println("  * " + totalTries + "��° �ҿ�ð�: " + time * 100 / 1000 / 100. + "(��), ��ռҿ�ð�: " + totalTime * 100 / 1000 / totalTries / 100.   + "(��)");
		}

	}

	// 1���� 45���� 6�� ���� �ٸ� �ζ� ��ȣ�� ���� �־��� lottoNos �迭�� ����
	static void getLottoNos(int[] lottoNos) {
		lottoNos[0] = getLottoNo();

		for (int i = 1; i < 6; i++) {
			int aLottoNo;

			// 2��°���� 6��°�� �̹� ���õ� ���� ��ȣ�� �޶�� ��
			do {
				aLottoNo = getLottoNo();

			}
			while(containsLottoNo(lottoNos, aLottoNo, i));

			lottoNos[i] = aLottoNo;	
		}

		sortLotto(lottoNos);  // �ζǹ�ȣ�� �� ��ġ �˻縦 ���� wjdfuftlzla
	}

	static Random rd = new Random();
	
	// 1���� 45���� �ζ� ��ȣ�� ������ ���� ��ȯ
	static int getLottoNo() {
		return rd.nextInt(45) + 1;
	}

	// �־���	lottoNos �迭�� cnt ���� �ζ� ��ȣ�� ����Ǿ� ���� �� �־��� aLottoNo ��ȣ��
	//   �̹� �����ϸ� true, �ƴϸ� false ��ȯ
	static boolean containsLottoNo(int[] lottoNos, int aLottoNo, int cnt) {
		for (int i = 0; i < cnt; i++)
			if (lottoNos[i] == aLottoNo)
				return true;

		return false;		
	}

	// �־���	lottoNos �迭��  �ζ� ��ȣ�� ����Ǿ� ���� �� �ζ� ��ȣ�� ��� ���
	static void outputLottoNos(int[] lottoNos, String msg) {
		System.out.print(msg + ": [ ");

		for (int i=0; i < 6; i++) {
			System.out.print( lottoNos[i] + " ");
		}

		System.out.println(" ]");		
	}

	// �־���	lottoNos1 �迭�� lottoNos2 �迭��  �ζ� ��ȣ�� ��ġ�ϴ°� �˻�
	//   �ζ� ��ȣ�� ���ĵǾ� �迭�� ����ǹǷ� ���� �ϳ��� ���Ͽ� ��� ������ ��ġ
	static boolean sameLottoNos(int[] lottoNos1, int[]lottoNos2) {

		for (int i=0; i < 6; i++) {
			if (lottoNos1[i] != lottoNos2[i])  // ���� �ϳ��� ���� ������
				return false;                  //    ��ġ���� �����Ƿ� false ��ȯ
		}

		return true;                           // ��� ��ġ�ϸ� true ��ȯ
	}

	// �־���	lottoNos �迭�� ũ������� ����
	static void sortLotto(int[] lottoNos) {
		java.util.Arrays.sort(lottoNos);  // java.util.Arrays�� ���� �޼ҵ� �̿�
	}

}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� �ζ� 1�� ��÷ Ȯ���� ���������� ���غ���.
 *         
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 */
