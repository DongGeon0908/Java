package ex12_more;
/*
 *  PrintDiamond_WidthAny_CharVarying: �ٲ�� ���ڷ� �Էµ� ���� ���̾Ƹ�� ��� ����ϱ�
 *  
 *    o ��Ÿ�� 4: ��ø�� �ݺ��� ����Ͽ� �ۼ��ϱ�
 *              + ���̾Ƹ���� ���� ������ ���� ������ ���ڵ�� ���
 *                (���̾Ƹ���� �� ������ �ٸ� ���ڷ� �׸�) 
 */

class Ex4_08_4_PrintDiamond_WidthAny_CharVarying {
	public static void main(String[] args) {
	
		
		System.out.print("\n  **** Print diamond of given width varing char ****\n");
		int widthDiamond = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");
		char cToPrint = SkScanner.getCharWithPrompt(" \n  o Input char of first line to draw > ");   // ù ���� �׸� �� ���� ����
		
		
		if (widthDiamond % 2 == 0)  // ���̾Ƹ�� ���� ¦���̸� 1 ���� Ȧ���� �缳��
			widthDiamond--;
		
		int cntStarInit = 1;  // ù ���ο� ����� * ���� ����
		int cntBlankInit = widthDiamond / 2; // ù ���ο� ����� blank�� ���� ����
		
		int cntStar, cntBlank; // �� ���ο� ����ϴ� *�� blank�� ���� ����
		System.out.print("\n  ** Diamond of width " + widthDiamond + " with starting '" + cToPrint +"' **\n");
		
		// ���̾Ƹ�� �����κ�: ���θ��� blank 1�� ����, �׸� ���� 2�� ���� 
		cntStar = cntStarInit;
		for (cntBlank = cntBlankInit; cntBlank >= 0; cntBlank--) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank��  ���
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *�� ���
			System.out.println();
			
			cntStar += 2;
			cToPrint++;  // ���� ������ ���� ������ ���ڷ� �׸����� ��			
		}

		// ���̾Ƹ�� ���Һκ�: ���θ���  blank 1�� ����, �׸� ���� 2�� ���� 
		cntStar = widthDiamond - 2; 
		for (cntBlank = 1; cntBlank <= cntBlankInit; cntBlank++) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank��  ���
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *�� ���
			System.out.println();
			
			cntStar -= 2;
			cToPrint++; // ���� ������ ���� ������ ���ڷ� �׸����� ��
		}
		
		main(args);
	}
}  


