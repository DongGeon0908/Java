package ex12_more;

/*
/*
 *   [ SaleUntilPrice0UsingWhile ]: ������ 0�� �Էµ� ������ ��ǰ�Ǹ��� ���ݰ� ������ �Է��Ͽ� ���ǸŰ����� ���Ǹűݾ��� ���    
 *     
 *     o ��Ÿ�� 3: �ݺ����� ����Ͽ� �ۼ��ϱ� - while �������� �ݺ�
 *  
 *     o ������ ���� �Է��� SkScanner.getInt()�� �̿���
 */

public class Ex4_01_3_SaleUntilPrice0UsingWhile {

	public static void main(String[] args)  {

		int price, number;                    // �Ǹűݾװ� �ǸŰ�����  �Է¹��� ����
		int totalPrice = 0, totalNumber = 0;  // ���Ǹűݾװ� ���ǸŰ����� ������ ����

		int cnt = 1; 	// �Է� ȸ���� ��Ÿ���� ����
		
		while(true) {   // Java���� ���� �ݺ��ϵ��� �ϴ� ���(����� C������ < while(1) { >)
			System.out.print("\n  o Enter " +  cnt++ + "-th price (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  // price�� 0�� �ԷµǸ�
				break;       // while ���� �ݺ��� ���
			
			System.out.print("    Enter number > ");
			number = SkScanner.getInt();

			totalPrice += price * number;    // ���Ǹűݾ��� ����
			totalNumber += number;           // ���ǸŰ����� ����
		}
				
		System.out.println();

		System.out.println();
		System.out.println("\n  ** Sale Report **   \n");

		System.out.println("  * Total price = " + totalPrice);
		System.out.println("  * Total number = " + totalNumber);

		if (totalNumber != 0)
			System.out.println("  * Average price = " + totalPrice / (double) totalNumber);
		else
			System.out.println("  * Average price : ???");	

	}

	// �ٸ� ������� �ۼ��� main() �޼ҵ�
	public static void mainOther1(String[] args)  {

		int price, number;                    // �Ǹűݾװ� �ǸŰ�����  �Է¹��� ����
		int totalPrice = 0, totalNumber = 0;  // ���Ǹűݾװ� ���ǸŰ����� ������ ����

		boolean flag = true;  // flag ������ true�� ���� �ݺ��� ��Ű�� ���� true�� ó�� ������

		while(flag==true) {   // �̴� < while(flag) { >�� ������, ���� �� ǥ���� �ͼ����� ������ 
			System.out.print("Enter price & number (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  {   // price�� 0�� �ԷµǸ�
				flag = false;    // flag ������ false�� �����Ͽ� ���� �ݺ����� �ݺ��� ����� ��
			}
			else {
				number = SkScanner.getInt();

				totalPrice += price * number;    // ���Ǹűݾ��� ����
				totalNumber += number;           // ���ǸŰ����� ����
			}
		}

		System.out.println("   Total number = " +totalNumber);
		System.out.println("   Total price = " + totalPrice);
		System.out.println("   Average price = " + totalPrice / totalNumber);
	}

	// �ٸ� ������� �ۼ��� main() �޼ҵ�
	public static void mainOther2(String[] args)  {

		int price, number;                    // �Ǹűݾװ� �ǸŰ�����  �Է¹��� ����
		int totalPrice = 0, totalNumber = 0;  // ���Ǹűݾװ� ���ǸŰ����� ������ ����

		for (boolean flag = true; flag==true; ) {  // mainOther1() �޼ҵ��� while ���� for ������ ������ ����
			System.out.print("Enter price & number (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  {   // price�� 0�� �ԷµǸ�
				flag = false;    // flag ������ false�� �����Ͽ� ���� �ݺ����� �ݺ��� ����� ��
			}
			else {
				number = SkScanner.getInt();

				totalPrice += price * number;    // ���Ǹűݾ��� ����
				totalNumber += number;           // ���ǸŰ����� ����
			}
		}

		System.out.println("   Total number = " +totalNumber);
		System.out.println("   Total price = " + totalPrice);
		System.out.println("   Average price = " + totalPrice / totalNumber);
	}
}


/*
 *  [ �ǽ����� ]
 *  
 *    o ���� �Է��� ���� SkScanner.getInt() �޼ҵ带 ����ϴ� ��� 
 *      java.util.Scanner Ŭ������ nextInt() �޼ҵ带 ����ϴ� 
 *      ���α׷���  Pr4_1_3_SaleUntilPrice0UsingJavaUtilScanner Ŭ�������� �ۼ��϶�.
 *
 *      �̸� ���ؼ��� import java.util.Scanner�� ù �κп� ��Ÿ���� �ϸ�,
 *      Scanner Ŭ������ ��ü�� new�� ���� �����Ǿ�� �Ѵ�(< Scanner scanner = new Scanner(System.in) >)
 * 
 * 
 *  [ ������ �����ϰ� ����غ� ���� ]
 *  
 *   o �� ���α׷���� �ݺ����� ������� �ʴ� Ex4_1_1_Sale3_NotUsingRepeat�� ���غ��鼭
 *     �ݺ����� �ʿ伺, �߿伺, ȿ�뼺 ���� �����غ��ÿ�.

 */

