package ex09_draw_diamond;
/*
 * [ PrintDiamond_UsingMethod ]: �Էµ� ���ڷ� �Էµ� ���� ���̾Ƹ�� ��� ����ϱ�(�޼ҵ� ���)
 *  
 *    o ��Ÿ�� 5: ��ø�� �ݺ��� ����Ͽ� �ۼ��ϱ�
 *               + ���̾Ƹ���� ���� ������ ���� ������ ���ڵ�� ��� 
 */

class Ex5_PrintDiamond_UsingMethod {
	public static void main(String[] args) {
			
		System.out.print("\n  **** Print diamond of given character and width ****\n");
		char cToDraw = SkScanner.getCharWithPrompt(" \n  o Input character to draw > ");   // ù ���� �׸� �� ���� ����
		int widthDiamond = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");
		
		System.out.print("\n  ** Diamond of width " + widthDiamond + " with '" + cToDraw +"' **\n\n");
		drawDiamond(cToDraw, widthDiamond);		
		
		main(args);
		
	}
	
	// ���̾Ƹ�带 �׸��� �޼ҵ�
	static void drawDiamond(char c, int width) {		
		drawIoscelesTriangle(c, width);    // �̵ �ﰢ�� �׸���
		drawReverseIoscelesTriangle(c, width - 2);  // �� �̵ �ﰢ�� �׸���
	}
	
	// �̵ �ﰢ���� �׸��� �޼ҵ�
	static void drawIoscelesTriangle(char c, int width) {
		if (width % 2 == 0)  //  ���� ¦���̸� 1 ���� Ȧ���� �缳��
			width--;
			
		int cntCharInit = 1;  // ù ���ο� ����� ���� ���� ����
		int cntBlankInit = width / 2; // ù ���ο� ����� blank�� ���� ����
		
		int cntChar, cntBlank; // �� ���ο� ����ϴ� ���ڿ� blank�� ���� ����
		
		// ���� �����κ�: ���θ��� ���� 2�� ����, blank 1�� ���� 
		cntChar = cntCharInit;
		for (cntBlank = cntBlankInit  ; cntBlank >= 0; cntBlank--) {
			printChar(' ', cntBlank); // blank��  ���
			printChar(c, cntChar);    // ���ڸ� ���
			printChar('\n', 1); 
			
			cntChar += 2;
		}
	}
	
	// ������ �̵ �ﰢ���� �׸��� �޼ҵ�
	static void drawReverseIoscelesTriangle(char c, int width) {
		if (width % 2 == 0)  //  ���� ¦���̸� 1 ���� Ȧ���� �缳��
			width--;
			
		int cntCharInit = width;           // ù ���ο� ����� ���� ���� ����
		int cntBlankLast = width / 2 + 1;  // ������ ���ο� ����� blank�� ���� ����
		
		int cntChar, cntBlank; // �� ���ο� ����ϴ� ���ڿ� blank�� ���� ����
		
		//  ���� ���Һκ�: ���θ��� ���� 2�� ����, blank 1�� ���� 		
		cntChar = cntCharInit; 
		for (cntBlank = 1; cntBlank <= cntBlankLast; cntBlank++) {
			printChar(' ', cntBlank); // blank��  ���
			printChar(c, cntChar);    // ���ڸ� ���
			printChar('\n', 1); 
			
			cntChar -= 2;
		}
	}
	
	static void printChar(char c, int cnt) {
		for (int i = 0; i < cnt; i++)  
			System.out.print(c);  // ���ڸ� ���		
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
