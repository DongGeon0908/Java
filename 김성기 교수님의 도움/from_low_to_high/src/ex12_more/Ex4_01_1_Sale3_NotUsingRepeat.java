package ex12_more;

/*
 *  [ Sale3_NotUsingRepeat ]: ��ǰ �Ǹ��� ���ݰ� ������ 3�� �Է��Ͽ� ���ǸŰ����� ���Ǹűݾ��� ���
 *  
 *    o ��Ÿ�� 1: �ݺ����� ������� �ʰ� �ۼ��ϱ� - ���� �� ������ �� ���� ������� �ݺ���Ŵ
 *    
 *    o ������ ���� �Է��� SkScanner.getInt()�� �̿���*    
 *  
 */

class Ex4_01_1_Sale3_NotUsingRepeat  {


	public static void main(String[] args)  {

		int price, number;   // �ǸŰ����� �Ǹűݾ��� �Է¹��� ����
		int totalPrice = 0, totalNumber = 0;  // ���ǸŰ����� ���Ǹűݾ��� ������ ����

		System.out.print("\n o Enter first price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter first number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // ���Ǹűݾ��� ����
		totalNumber += number;           // ���ǸŰ����� ����

		System.out.print("\n o Enter second price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter second number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // ���Ǹűݾ��� ����
		totalNumber += number;           // ���ǸŰ����� ����

		System.out.print("\n o Enter third price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter third number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // ���Ǹűݾ��� ����
		totalNumber += number;           // ���ǸŰ����� ����

		System.out.println("\n\n  ** Sale Report **\n");

		System.out.println("  * Total number = " + totalNumber);
		System.out.println("  * Total price = " + totalPrice);
		System.out.println("  * Average price = " + totalPrice / (double) totalNumber);
	}
}

/*
 *  [ �ǽ����� ]
 *
 *   1) 0�� �������� �ԷµǸ� �׶������� ���ǸŰ����� ���Ǹűݾ��� ����ϴ� 
 *      ���α׷���  Pr4_1_1_SaleUntilPrice0NoRepeatStmt Ŭ������ �ۼ��϶�.
 *      (��, �� ���α׷��� ��Ÿ���� �����Ͽ��� ��) 
 *     
 *   2) 0�� �������� �ԷµǸ� �׶������� ���ǸŰ����� ���Ǹűݾ��� ����ϴ� 
 *      ���α׷���  Pr4_1_1_SaleUntilPrice0 Ŭ������ �ۼ��϶�.
 *      (��, �� ���α׷��� ��Ÿ���� �������� �ʾƵ� ����, ������ ����� ã�� �̿��� ��) 
 *     
 */

