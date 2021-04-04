package ex09_draw_diamond;
/*
 * [ PrintDiamond_UsingMethod ]: �Էµ� ���ڷ� �Էµ� ���� ���̾Ƹ�� ��� ����ϱ�(Ŭ���� ���)
 *  
 *    o ��Ÿ�� 6: ��ø�� �ݺ��� ����Ͽ� �ۼ��ϱ�
 *               + ���̾Ƹ���� ���� ������ ���� ������ ���ڵ�� ��� 
 */

class Diamond {
	char cToDraw;    // ���̾Ƹ�� �׸� ����
	int width; // ���̾Ƹ�� �ִ� ��(Ȧ���̾�� ��)
	
	// ���̾Ƹ�� �׸� ���ڿ� �ִ� ���� �־����� �̸� �ʵ� cTodraw�� width�� �����ϴ� ��ü ������
	Diamond(char c, int width) {
		this.cToDraw = c;
		this.width = width;
	}
	
	// �ʵ忡 ����� ���ڿ� ������  ���̾Ƹ�� ����ϴ� �޼ҵ�
	void draw() {
		Diamond.draw(cToDraw, width);
	}
	
	// msg�� ����� �� ���̾Ƹ�� ����ϴ� �޼ҵ�
	void draw(String msg) {
		System.out.print(msg);
		draw();
	}
	
	// �־��� ���ڿ� ������  ���̾Ƹ�� ����ϴ� �޼ҵ�
	// 	�̵ �ﰢ���� Ŭ���� �޼ҵ��� draw(int c, int base)�� drawReverse(int c, int base)��
	//  �̿��Ͽ� �׸�
	static void draw(char cToDraw, int width) {
		IoscelesTriangle.draw(cToDraw, width);             // ���̸���� �� �κ��� �̵ �ﰢ�� �׸���
		IoscelesTriangle.drawReverse(cToDraw, width - 2);  // ���̸���� �Ʒ� �κ��� �� �̵ �ﰢ�� �׸���				
	}
}

// �̵ �ﰢ���� ���� Ŭ����
class IoscelesTriangle {
	char cTodraw;    // �̵�ﰢ�� �׸� ����
	int base;        // �̵�ﰢ�� �غ�(Ȧ���̾�� ��)
	
	// �̵�ﰢ�� �׸� ���ڿ� �غ��� �־����� �̸� �ʵ� cTodraw�� base�� �����ϴ� ��ü ������
	IoscelesTriangle(char cTodraw, int base) {
		this.cTodraw = cTodraw;
		this.base = base;
	}
	
	void draw() {
		IoscelesTriangle.draw(cTodraw, base);    // �̵ �ﰢ�� �׸���
	}
	void drawReverse() {
		IoscelesTriangle.drawReverse(cTodraw, base);    // �̵ �ﰢ�� �׸���
	}

	// �̵ �ﰢ���� �׸��� �޼ҵ�
	static void draw(char c, int width) {
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
	static void drawReverse(char c, int width) {
		if (width % 2 == 0)  //  ���� ¦���̸� 1 ���� Ȧ���� �缳��
			width--;
			
		int cntCharInit = width;           // ù ���ο� ����� ���� ���� ����
		int cntBlankLast = width / 2;  // ������ ���ο� ����� blank�� ���� ����
		
		int cntChar, cntBlank; // �� ���ο� ����ϴ� ���ڿ� blank�� ���� ����
		
		//  ���� ���Һκ�: ���θ��� ���� 2�� ����, blank 1�� ���� 		
		cntChar = cntCharInit; 
		for (cntBlank = 0; cntBlank <= cntBlankLast; cntBlank++) {
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


class Ex6_PrintDiamond_UsingClass {
	public static void main(String[] args) {

		IoscelesTriangle.drawReverse('$', 15);
		IoscelesTriangle.draw('#', 15);

		while(true) {		
			System.out.print("\n  **** Print diamond of given character and width ****\n");
			char cToDraw = SkScanner.getCharWithPrompt(" \n  o Input character to draw > ");   // ù ���� �׸� �� ���� ����
			int width = SkScanner.getIntWithPrompt(" \n  o Input odd width of diamond to draw > ");

			Diamond diamond =  new Diamond(cToDraw, width);
			diamond.draw("\n  ** Diamond of width " + width + " with '" + cToDraw +"' **\n\n");
		}

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
