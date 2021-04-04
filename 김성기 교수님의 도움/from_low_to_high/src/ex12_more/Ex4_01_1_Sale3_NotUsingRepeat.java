package ex12_more;

/*
 *  [ Sale3_NotUsingRepeat ]: 물품 판매한 가격과 개수를 3번 입력하여 총판매개수와 총판매금액을 출력
 *  
 *    o 스타일 1: 반복문을 사용하지 않고 작성하기 - 여러 번 도장을 찍 듯이 문장들을 반복시킴
 *    
 *    o 개수와 가격 입력은 SkScanner.getInt()를 이용함*    
 *  
 */

class Ex4_01_1_Sale3_NotUsingRepeat  {


	public static void main(String[] args)  {

		int price, number;   // 판매개수와 판매금액을 입력받을 변수
		int totalPrice = 0, totalNumber = 0;  // 총판매개수와 총판매금액을 저장할 변수

		System.out.print("\n o Enter first price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter first number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // 총판매금액을 누적
		totalNumber += number;           // 총판매개수를 누적

		System.out.print("\n o Enter second price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter second number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // 총판매금액을 누적
		totalNumber += number;           // 총판매개수를 누적

		System.out.print("\n o Enter third price > ");
		price = SkScanner.getInt();
		
		System.out.print(" o Enter third number > ");
		number = SkScanner.getInt();
		
		totalPrice += price * number;    // 총판매금액을 누적
		totalNumber += number;           // 총판매개수를 누적

		System.out.println("\n\n  ** Sale Report **\n");

		System.out.println("  * Total number = " + totalNumber);
		System.out.println("  * Total price = " + totalPrice);
		System.out.println("  * Average price = " + totalPrice / (double) totalNumber);
	}
}

/*
 *  [ 실습과제 ]
 *
 *   1) 0이 가격으로 입력되면 그때까지의 총판매개수와 총판매금액을 출력하는 
 *      프로그램을  Pr4_1_1_SaleUntilPrice0NoRepeatStmt 클래스로 작성하라.
 *      (단, 이 프로그램의 스타일을 유지하여야 함) 
 *     
 *   2) 0이 가격으로 입력되면 그때까지의 총판매개수와 총판매금액을 출력하는 
 *      프로그램을  Pr4_1_1_SaleUntilPrice0 클래스로 작성하라.
 *      (단, 이 프로그램의 스타일을 유지하지 않아도 좋음, 가능한 방법을 찾아 이용할 것) 
 *     
 */

