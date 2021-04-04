package ex12_more;

/*
 *   [ SaleUntilPrice0UsingFor ]: ������ 0�� �Էµ� ������ ��ǰ�Ǹ��� ���ݰ� ������ �Է��Ͽ� ���ǸŰ����� ���Ǹűݾ��� ���    
 *     
 *     o ��Ÿ�� 2: �ݺ����� ����Ͽ� �ۼ��ϱ� - for �������� �ݺ�
 *  
 *     o ������ ���� �Է��� SkScanner.getInt()�� �̿���
 */
public class Ex4_01_2_SaleUntilPrice0UsingFor {

	public static void main(String[] args)  {

		int price, number;                    // �Ǹűݾװ� �ǸŰ�����  �Է¹��� ����
		int totalPrice = 0, totalNumber = 0;  // ���Ǹűݾװ� ���ǸŰ����� ������ ����

		int cntSales = SkScanner.getIntWithPrompt("\n\n  o Input total count of sales > "); 	// �Է��� ȸ���� ���³��� �Ǹ�ȸ���� �Է�
		
		for (int cnt = 0; cnt < cntSales; cnt++) {
			System.out.print("\n  o Enter " +  (cnt + 1) + "-th price  > ");
			price = SkScanner.getInt();
			
			System.out.print("    Enter number > ");
			number = SkScanner.getInt();

			totalPrice += price * number;    // ���Ǹűݾ��� ����
			totalNumber += number;           // ���ǸŰ����� ����
		}
				
		System.out.println();
		System.out.println("\n  ** Sale Report **   \n");

		System.out.println("  * Total price = " + totalPrice);
		System.out.println("  * Total number = " + totalNumber);
		
		if (totalNumber != 0)
			System.out.println("  * Average price = " + totalPrice / (double) totalNumber);
		else
			System.out.println("  * Average price : ???");			
	}
}


