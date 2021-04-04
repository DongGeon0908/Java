package ex12_more;
/*
 *  [ PrintDiamond_WidthAny ]: ������ ���� ���� ���̾Ƹ�� ��� ����ϱ�
 *  
 *    o ��Ÿ�� 3: ��ø�� �ݺ��� ����Ͽ� �����ϰ� �ۼ��ϱ�
 *     
 *    o ���̾Ƹ�� �׸��� 
 *      - ���̾Ƹ��� *�� �����ϴ� �κа� �����ϴ� �κ����� ��������
 *      - ���̾Ƹ�� ���� n�̸� ó�� ������ blank�� n / 2��, *�� 1����
 *      - ���� ���κ��� blank�� 1���� ����, *�� 2���� �����ϴ� �κ���
 *      - blank�� 0�̵Ǹ� �ٽ� blank�� 1���� ����, *�� 2���� �����ϴ� �κ���
*/

class Ex4_08_3_PrintDiamond_WidthAny {
	public static void main(String[] args) {

		int i;
		char cToDraw = '*';  // ���̾Ƹ�带 �׸� ���ڸ� ����

		int widthDiamond = 9;       // ���̾Ƹ�� ���� �����ϴ� ����, �� ���� ���� Ȧ���̾�� ��
		if (widthDiamond % 2 == 0)  // ���̾Ƹ�� ���� ¦���̸� 1 ���� Ȧ���� �缳��
			widthDiamond--;
	
		int cntStarInit = 1;  // ù ���ο� ����� ���� ���� ����
		int cntBlankInit = widthDiamond / 2; // ù ���ο� ����� blank�� ���� ����		
		
		int cntStar, cntBlank; // �� ���ο� ����ϴ� ���ڿ� blank�� ���� ����
		
		System.out.print("\n  **** Print diamond of width " + widthDiamond + " (style 3) ****\n\n");

		// ���̾Ƹ�� ���� ���� �κ�: ���θ��� blank 1�� ����, �׸� ���� 2�� ����  
		cntStar = cntStarInit;  // ���� �κ��� *�� 1������ ������
		for (cntBlank = cntBlankInit  ; cntBlank >= 0; cntBlank--) { // �� ������ blank ������ �ݺ��� ����

			for (i = 0; i < cntBlank; i++) System.out.print(' ');     // blank ���
			for (i = 0; i < cntStar; i++)  System.out.print(cToDraw); // �׸� ���� ���
			System.out.println();
			
			cntStar += 2;  // * ������ 2�� ����
		}

		// ���̾Ƹ�� ���� ���� �κ�: ���θ��� blank 1�� ����, �׸� ���� 2�� ����
		cntStar = widthDiamond - 2;  // ���� �κ��� *�� (�� - 2)������ ������
		for (cntBlank = 1; cntBlank <= cntBlankInit; cntBlank++) { // �� ������ blank ������ �ݺ��� ����

			for (i = 0; i < cntBlank; i++) System.out.print(' ');     // blank ���
			for (i = 0; i < cntStar; i++)  System.out.print(cToDraw); // �׸� ���� ���
			System.out.println();
			
			cntStar -= 2;  // * ������ 2�� ����
		}
	}
}  

/*
 *  [ �ǽ����� ]
 *  
 *    1) �� ���α׷��� '*'�� �̿��Ͽ� ���� 9�� ���̾Ƹ�带 �׷��ش�. 
 *    
 *       �� ���α׷� ��Ÿ�Ϸ� '$'�� �̿��Ͽ� ���� 15�� ���̾Ƹ�带 �׸��� ���α׷���
 *       Pr4_8_3_PrintDiamond_Width Ŭ������  �ۼ��϶�. 
 *       
 *    2) �� ���α׷� ��Ÿ�Ϸ� ���� 121�� ���̾Ƹ�� �Ǵ� ���� 1221�� ���̾Ƹ�带 
 *       ���α׷��� �ۼ��� �� �ְڴ°�? 
 *       
 *       �� ���� �� ���� ������ ��û �������� �۾��ΰ�? 
 * 
 * 
 *  [ ������ �����ϰ� ����غ� ���� ]  
 * 
 *    1) �� ���α׷��� Ex4_8_2_PrintDiamond_Width9 Ŭ�������� �ݺ��Ǵ� ���� �κе��� ������
 *       ���α׷��̴�.
 *       
 *       ���� 9�� ���̾Ƹ�常 �׸��� �ͻӸ� �ƴ϶� ��� ���� ���̾Ƹ�嵵
 *       �����ϰ� �����Ͽ� �׸� �� �ִ� ���뼺�� ���� ���α׷��̴�.
 *       
 *       ���α׷��� �ۼ��ϰ� �����ϱ�� ���� ������ �� ���� ������ ���α׷��� �ۼ��� �� �ֵ���
 *       ���� ������ �ؾ� �Ѵ�.
 */
