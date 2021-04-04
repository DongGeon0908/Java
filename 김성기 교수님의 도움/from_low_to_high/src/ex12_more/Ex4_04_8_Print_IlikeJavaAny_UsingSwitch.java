package ex12_more;
/*
 *  [ Print_IlikeJavaAny_UsingSwitch ]: "I Like Java "�� �Է��� ȸ����ŭ  ����ϱ�
 *  
 *   o ��Ÿ�� 6: �ݺ��� ������� �ʱ�
 *           + switch ���� �޼ҵ� �̿��Ͽ� "I Like Java "�� ���
 *      
 *   o �Ȱ��� �۾��� �ݺ��ϴ� ���α׷��� �ݺ����� ������� �ʰ� ���� �ۼ��غ��� ���� 
 *     �ݺ����� �߿伺�� �����ϱ� ���� �ſ� �߿��ϴ�.
 *        
 *   o �ݺ����� ������� �ʰ� ���� �ݺ������� �����ϴ� ���� �ݺ� ȸ���� ���� ���̵��� �޶�����. 
 *     �ݺ�ȸ���� ���� ���� ������ ������� �ʴٰ�, ȸ���� �������� ���� ������� 
 *     ȸ���� ���� �������� ���� �Ұ����� ���̱⵵ �Ѵ�. 
 *     1221���� ���� �� �� ������ 12321��, 1234321�� ���� �����ұ�?
 *       
 *   ************************************************************************************
  *    o �ݺ��� ���� �ʰ� 1221�� �Ǵ� �� �̻��� ����ϴ� ���α׷� �ۼ��ϱ�
  *    
 *       - �׹�° ���: switch ����  �޼ҵ带 �ۼ��ϰ� �̸� ȣ��
 *       
 *       - ���ݱ����� ���α׷��� Ư�� ȸ���� "I Like Java "�� �ݺ��� ������� �ʰ�  ����ϴ� ����� ���캽
 *       
 *       - ��¡ ����� ����� �ݺ����� ��� �޼ҵ带 ������� �ʰ� �Էµ� ȸ����ŭ
 *         "I Like Java "��  ����ϴ� �����̴�.
 *       
 *       - �� ������ ���� ���� ���ٰ� �����Ǵ� �ش��� switch ���� ����ϴ� ���̸�
 *         �ۼ��� ����׷��� 99999�������� ȸ���� Ŀ���Ѵ�.
 *         (10�� �Ǵ� 100�� �̻��� ȸ���� ����Ϸ��� �� ���� �޼ҵ� �ۼ��ؾ� ��)
 *           
 *   **************************************************************************************
 */

public class Ex4_04_8_Print_IlikeJavaAny_UsingSwitch {
	public static void main(String[] args)  {
		int cnt = SkScanner.getIntWithPrompt("\n\n  o Input count to print(maximun 99999) > ");
		
		print_IlikeJava_AnyTimes(cnt);
	}
	
	static void print_IlikeJava_AnyTimes(int cnt) {
		int cnt10000 = cnt / 10000 % 10;   // �Էµ� ������ �� �ڸ� ����Ʈ ����
		int cnt1000 = cnt / 1000 % 10;     // �Էµ� ������ õ �ڸ� ����Ʈ ����
		int cnt100 = cnt / 100 % 10;	   // �Էµ� ������ �� �ڸ� ����Ʈ ����
		int cnt10 = cnt / 10 % 10;         // �Էµ� ������ �� �ڸ� ����Ʈ ����
		int cnt1 = cnt % 10;               // �Էµ� ������ �� �ڸ� ����Ʈ ����
		
		printLikeJava10000Digit( cnt10000 );  // �� ������  ȸ���� ���
		printLikeJava1000Digit( cnt1000 );    // õ ������  ȸ���� ���
		printLikeJava100Digit( cnt100 );      // �� ������  ȸ���� ���
		printLikeJava10Digit( cnt10 );        // �� ������  ȸ���� ���
		printLikeJava1Digit( cnt1 );          // �� ������  ȸ���� ���
	}

	// �� ������  ȸ���� cnt�� �־����� �� ȸ����ŭ "I Like Java "�� ���
	//  ���� ���, cnt�� 9�̸� 9�� ���
	static void printLikeJava1Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike1Times();
		case 8:
			printLike1Times();				
		case 7:
			printLike1Times();			
		case 6:
			printLike1Times();	
		case 5:
			printLike1Times();
		case 4:
			printLike1Times();				
		case 3:
			printLike1Times();			
		case 2:
			printLike1Times();	
		case 1:
			printLike1Times();
		}
	}

	// �� ������  ȸ���� cnt�� �־����� �� ȸ����ŭ "I Like Java "�� ���
	//  ���� ���, cnt�� 9�̸� 90�� ���
	static void printLikeJava10Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike10Times();
		case 8:
			printLike10Times();				
		case 7:
			printLike10Times();			
		case 6:
			printLike10Times();	
		case 5:
			printLike10Times();
		case 4:
			printLike10Times();				
		case 3:
			printLike10Times();			
		case 2:
			printLike10Times();	
		case 1:
			printLike10Times();
		}
	}

	// �� ������  ȸ���� cnt�� �־����� �� ȸ����ŭ "I Like Java "�� ���
	//  ���� ���, cnt�� 9�̸� 900�� ���
	static void printLikeJava100Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike100Times();
		case 8:
			printLike100Times();				
		case 7:
			printLike100Times();			
		case 6:
			printLike100Times();	
		case 5:
			printLike100Times();
		case 4:
			printLike100Times();				
		case 3:
			printLike100Times();			
		case 2:
			printLike100Times();	
		case 1:
			printLike100Times();
		}
	}
	
	// õ ������  ȸ���� cnt�� �־����� �� ȸ����ŭ "I Like Java "�� ���
	//  ���� ���, cnt�� 9�̸� 9000�� ���
	static void printLikeJava1000Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike1000Times();
		case 8:
			printLike1000Times();				
		case 7:
			printLike1000Times();			
		case 6:
			printLike1000Times();	
		case 5:
			printLike1000Times();
		case 4:
			printLike1000Times();				
		case 3:
			printLike1000Times();			
		case 2:
			printLike1000Times();	
		case 1:
			printLike1000Times();
		}
	}

	// �� ������  ȸ���� cnt�� �־����� �� ȸ����ŭ "I Like Java "�� ���
	//  ���� ���, cnt�� 9�̸� 90000�� ���
	static void printLikeJava10000Digit(int cnt ) {
		switch(cnt) {
		case 9:
			printLike10000Times();
		case 8:
			printLike10000Times();				
		case 7:
			printLike10000Times();			
		case 6:
			printLike10000Times();	
		case 5:
			printLike10000Times();
		case 4:
			printLike10000Times();				
		case 3:
			printLike10000Times();			
		case 2:
			printLike10000Times();	
		case 1:
			printLike10000Times();
		}
	}
	
	/*
	 * �ݺ����� ������� �ʰ� "I Like Java "�� ����ϱ� ���� �ۼ��� �޼ҵ��
	 * 1��, 10��, 100��, 10000��, 100000�� ����ϴ� �޼ҵ带 �ۼ�
	 */
	// "I Like Java "�� 1�� ���
	public static void printLike1Times() {
		System.out.print("I Like Java ");
	}

	// "I Like Java "�� 10�� ���
	public static void printLike10Times() {
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
		printLike1Times();
	}

	// "I Like Java "�� 100�� ���
	public static void printLike100Times() {
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
		printLike10Times();
	}

	// "I Like Java "�� 1000�� ���
	public static void printLike1000Times() {
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
		printLike100Times();
	}


	// "I Like Java "�� 10000�� ���
	public static void printLike10000Times() {
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
		printLike1000Times();
	}
}

