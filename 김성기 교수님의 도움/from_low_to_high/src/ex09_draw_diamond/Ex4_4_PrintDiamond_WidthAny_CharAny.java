package ex09_draw_diamond;
/*
 * [ PrintDiamond_WidthAny_CharAny ]: �ٲ�� ���ڷ� �Էµ� ���� ���̾Ƹ�� ��� ����ϱ�
 *  
 *    o ��Ÿ�� 4: ��ø�� �ݺ��� ����Ͽ� �ۼ��ϱ�
 *               + ���̾Ƹ���� ���� ������ ���� ������ ���ڵ�� ��� 
 */

class Ex4_4_PrintDiamond_WidthAny_CharAny {
	public static void main(String[] args) {
	
		
		System.out.print("\n  **** Print diamond of given width varing char ****\n");
		char cToPrint = SkScanner.getCharWithPrompt(" \n  o Input character to draw > ");               // �׸� �� ���� ����
		int widthDiamond = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");  // ���̾Ƹ�� �ִ� ��
		
		
		if (widthDiamond % 2 == 0)  // ���̾Ƹ�� ���� ¦���̸� 1 ���� Ȧ���� �缳��
			widthDiamond--;
		
		int cntStarInit = 1;  // ù ���ο� ����� * ���� ����
		int cntBlankInit = widthDiamond / 2; // ù ���ο� ����� blank�� ���� ����
		
		int cntStar, cntBlank; // �� ���ο� ����ϴ� *�� blank�� ���� ����
		System.out.print("\n  ** Diamond of width " + widthDiamond + " with starting '" + cToPrint +"' **\n");
		
		// ���̾Ƹ�� * �����κ�: ���θ��� * 2�� ����, blank 1�� ���� 
		cntStar = cntStarInit;
		for (cntBlank = cntBlankInit  ; cntBlank >= 0; cntBlank--) {
			int i;

			for (i = 0; i < cntBlank; i++) System.out.print(' '); // blank��  ���
			for (i = 0; i < cntStar; i++)  System.out.print(cToPrint); // *�� ���
			System.out.println();
			
			cntStar += 2;
			cToPrint++;  // ���� ������ ���� ������ ���ڷ� �׸����� ��			
		}

		// ���̾Ƹ�� * ���Һκ�: ���θ��� * 2�� ����, blank 1�� ���� 
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

/*
 *
 * [ �ǽ����� ]
 * 
 *   1) �� ���α׷��� �޼ҵ带 �̿��ϴ� ���α׷����� �����϶�.
 *   
 *   
 * [ ������ �����ϰ� ����غ� ����: ]  
 *    1) �� ���α׷��� 3���� ������ ���̾Ƹ�� �� ������ �׸��� �۾��� �����Ѵ�
 *       3���� ������ ���缺�� ��Ģ���� ������ �ִ�. ��Ģ���� ���� �ľ��϶�.
 *       
 *    2) ���缺�� ��Ģ���� ������ ������ �ݺ����� ���� �����ϰ� ��ȯ�� �� �ִ�.
 *       �� ���α׷��� �����ϰ� �ٲ� �� �ִ� ����� �����غ���.
 *        
 *    3) ������ ������ ������� for ���� �̿��Ͽ� �����ϰ� ��ȯ�ϴ� ������ �����Ѵ�.
 *       a), b), c)�� ���� ������ �������� ���� ������ ������� a"), b"), c")�� ����
 *       �ϳ��� for ������ �����ϱ� ���ؼ��� a'), b'), c')�� ���� ��ȯ�� �߰� ������ �ʿ��ϴ�.
  *        
 *       a)      ===========> a') int i = 1;     ===========>  a")  for (int i = 1; i <= 3; i++) 
 *        sum = sum + 1;          sum = sum + i;  i++;                  sum = sum + i;
 *        sum = sum + 2;          sum = sum + i;  i++; 
 *        sum = sum + 3;          sum = sum + i;  i++;
 *        (���� �ִ� ���� 1, 2, 3���� 1�� ������)
 *     
 *       b)     ===========>  b') int i = 7;     ===========>  b")  for (int i = 7; i <= 11; i=i+2) 
 *        sum = sum + 7;          sum = sum + i;  i=i+2;                sum = sum + i;
 *        sum = sum + 9;          sum = sum + i;  i=i+2; 
 *        sum = sum + 11;         sum = sum + i;  i=i+2;
 *        (���� �ִ� ���� 7, 9, 11�� 2�� ������)
 *                                                                  
 *       c)    ===========>  c')  int i = 0;     ===========>  c")  int sum[] = { no0, no1, no2 };
 *        sum = sum + no0;        sum = sum + no[i];  i++;          sum = sum + no[i];
 *        sum = sum + no1;        sum = sum + no[i];  i++;          for (int i = 0; i < 3; i++) 
 *        sum = sum + no2;        sum = sum + no[i];  i++;               sum = sum + no[i];
 *        (���� �ִ� ���� ��Ģ���� ���� ��� �迭�� ������ �� �迭 ���Ҹ� ���ʷ� ������))
 *        
 *      ���� ������� ������ �������� ������ ���� �����ϰų� ��Ģ������ ���� ��� 
 *      �ݺ����� ����ϱ� ���Ͽ� ���յ� �������� �ۼ��ϴ� ������ ���� �����غ��ÿ�. 
 */
