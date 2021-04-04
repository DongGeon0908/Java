package practice10;

import java.util.Random;
import java.util.Date;

/**
 * [ 10�� �ǽ����� 5-2 ��� ���2) ]: 
 *        Random Ŭ������ ������ �̿��Ͽ� �ζ� 1�� Ȯ�� ���ϱ�
 *    
 *   o 5-2) ���� ���� ���α׷���(��� 2)
 *   
 *        2) �ζǴ� 1���� 45���� ���� �ٸ� 6���� ������ ��ġ�ϸ� 1������ ��÷�Ǵ� �����̴�. 
 *           java.util.Random Ŭ������ �޼ҵ带 �̿��Ͽ� �ζ� 1�� ��÷�� Ȯ���� ������ �������� ���϶�.
 *            
 *           (1) 1���� 45���� ���� �ٸ� ���� 6���� �Է��Ͽ� ������ 1�� ��ȣ��� �����Ѵ�. ����, ��ȸ���� 0���� �����Ѵ�.
 *           
 *           (2) 1���� 45���� ���� �ٸ� 6���� ������ �����Ͽ� ������ 1�� ��ȣ��� ���Ͽ� ��� ��ġ�ϸ� (3)�� �����϶�. 
 *               ��ġ���� ������ ��ȸ���� 1 ������Ű�� (2)�� �ݺ��϶�.
 *               
 *           (3) ��ġ�� ������ �� ��ȸ���� n�̶� �ϸ� 1 / (double) n���� ��÷Ȯ���� ����϶�.
 *           
 *   o ��� 2: �ζ� 1�� ��÷ ��ȣ�� �ζ� ��ȣ 6���� long ������ ��Ʈ�� ǥ��
 *   
 *     - �ϳ��� long ������ 6�� �ζ� ��ȣ ǥ�� �����ϹǷ� ���� �鿡�� ���ϰ� ������ ������
 *     
 *     - 6�� �ζǹ�ȣ�� long �������� �ٷ� ���Ͽ� ��÷ ���� Ȯ�� ������
 *     
 *     - long ������ �ٷ�� ���α׷��� int ������ �ٷ�� ���α׷�����
 *       �ۼ��ϰ� ������ϱⰡ �ξ� �����
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
			long n = 0;  					// ��÷������ ȸ�� �����ϴ� ���� 0���� �ʱ�ȭ
			startTime = new Date();  		// ���۽ð� ��� 

			lottoNosFirst = getLottoNos();  			// 1�� ��÷ �ζ� ��ȣ���� ����
			outputLottoNos(lottoNosFirst, "\n\n  * 1�� �ζ� ��ȣ��");

			while(true) {
				n++;	

				lottoNosSelected = getLottoNos(); 		// �ζ� ��ȣ�� ������

				if (lottoNosFirst == lottoNosSelected)	// ���õ� ��ȣ���� 1�� ��ȣ��� ������
					break;								//    ��÷ ó��
			}

			System.out.println("\n  * ��÷! " + n / 10000 + "�� " + n % 10000 + "�� ° ��÷, Ȯ��: " + 1 / (double) n );
			outputLottoNos(lottoNosSelected, "  * ��÷ �ζ� ��ȣ��");
			
			totalTries++;
			totalN += n;	
			
			System.out.println("\n  * " + totalTries + "��° ��÷���� ��� ȸ��: " + totalN / totalTries / 10000 + "�� " 
					+ totalN / totalTries % 1000 + "�� , ���Ȯ��: " + totalTries / (double) totalN );
			
			endTime = new Date();
			long time = endTime.getTime() - startTime.getTime();
			totalTime += time;
			
			System.out.println("  * " + totalTries + "��° �ҿ�ð�: " + time * 100 / 1000 / 100. + "(��), ��ռҿ�ð�: " + totalTime * 100 / 1000 / totalTries / 100.   + "(��)");
		
		
		}

	}

	// CNTLOTTONOS�� ���� �ٸ� �ζ� ��ȣ�� ���� long ������ ��Ʈ �������� �����Ͽ� ��ȯ
	//   ���� ���, 1, 3, 5, 10, 11, 13�� �ζ� ��ȣ�� ���õǸ�
	//   aLottoNo���� 0b0010_1100_0010_1010 �� �����
	static long getLottoNos() {
		long aLottos = 0;

		for (int i = 0; i < CNTLOTTONOS; i++) {
			int aLottoNo;

			// ���õ� ��ġ�� ��Ʈ�� 1�� �ƴϸ� �ߺ� �ȵ� ��ȣ�̹Ƿ� �ش� ��ġ�� ��Ʈ�� 1�� ���� 
			do {
				aLottoNo = getLottoNo();  // �ζ� ��ȣ �ϳ� ����
			}
			while( (aLottos & (1L << aLottoNo)) != 0); // aLottoNo ��ġ�� ��Ʈ�� 1�ΰ��� �˻翩 0�� �ƴϸ� �̹� ���õ� ��ȣ

			aLottos = (aLottos | (1L << aLottoNo));	   // ���õ� ��ȣ aLottoNo�� ��Ʈ ��ġ�� 1�� ����
		}
			
		return aLottos;
	}

	static Random rd = new Random();
	
	// 1���� MAXLOTTONO���� �ζ� ��ȣ�� ������ ���� ��ȯ
	static int getLottoNo() {
		return rd.nextInt(MAXLOTTONO) + 1;
	}

	// �־���	lottoNos��  �ζ� ��ȣ���� ��Ʈ �������� ����Ǿ� ���� �� �ζ� ��ȣ���� ��� ���
	static void outputLottoNos(long aLottos, String msg) {
		System.out.print(msg + ": [ ");

		for (int i=1; i <= MAXLOTTONO; i++) {

			if ((aLottos & (1L << i)) != 0)  // i��ġ ��Ʈ�� 0�� �ƴϸ�
				System.out.print( i + " ");  //    ��ġ i�� ���
		}

		System.out.println("]");		
	}

}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� �ζ� 1�� ��÷ Ȯ���� ���������� ���غ���.
 *         
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 */
