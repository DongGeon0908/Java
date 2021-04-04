package ex12_more;

/*
 *   [ SaleUntilPrice0UsingFor ]: 가격이 0이 입력될 때까지 물품판매한 가격과 개수를 입력하여 총판매개수와 총판매금액을 출력    
 *     
 *     o 스타일 2: 반복문을 사용하여 작성하기 - for 문장으로 반복
 *  
 *     o 개수와 가격 입력은 SkScanner.getInt()를 이용함
 */
public class Ex4_01_2_SaleUntilPrice0UsingFor {

	public static void main(String[] args)  {

		int price, number;                    // 판매금액과 판매개수를  입력받을 변수
		int totalPrice = 0, totalNumber = 0;  // 총판매금액과 총판매개수를 저장할 변수

		int cntSales = SkScanner.getIntWithPrompt("\n\n  o Input total count of sales > "); 	// 입력할 회수를 나태내는 판매회수를 입력
		
		for (int cnt = 0; cnt < cntSales; cnt++) {
			System.out.print("\n  o Enter " +  (cnt + 1) + "-th price  > ");
			price = SkScanner.getInt();
			
			System.out.print("    Enter number > ");
			number = SkScanner.getInt();

			totalPrice += price * number;    // 총판매금액을 누적
			totalNumber += number;           // 총판매개수를 누적
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


