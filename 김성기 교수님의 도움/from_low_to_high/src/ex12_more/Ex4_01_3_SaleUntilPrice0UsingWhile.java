package ex12_more;

/*
/*
 *   [ SaleUntilPrice0UsingWhile ]: 가격이 0이 입력될 때까지 물품판매한 가격과 개수를 입력하여 총판매개수와 총판매금액을 출력    
 *     
 *     o 스타일 3: 반복문을 사용하여 작성하기 - while 문장으로 반복
 *  
 *     o 개수와 가격 입력은 SkScanner.getInt()를 이용함
 */

public class Ex4_01_3_SaleUntilPrice0UsingWhile {

	public static void main(String[] args)  {

		int price, number;                    // 판매금액과 판매개수를  입력받을 변수
		int totalPrice = 0, totalNumber = 0;  // 총판매금액과 총판매개수를 저장할 변수

		int cnt = 1; 	// 입력 회수를 나타내는 변수
		
		while(true) {   // Java에서 무한 반복하도록 하는 기법(참고로 C에서는 < while(1) { >)
			System.out.print("\n  o Enter " +  cnt++ + "-th price (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  // price에 0이 입력되면
				break;       // while 무한 반복을 벗어남
			
			System.out.print("    Enter number > ");
			number = SkScanner.getInt();

			totalPrice += price * number;    // 총판매금액을 누적
			totalNumber += number;           // 총판매개수를 누적
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

	// 다른 방법으로 작성된 main() 메소드
	public static void mainOther1(String[] args)  {

		int price, number;                    // 판매금액과 판매개수를  입력받을 변수
		int totalPrice = 0, totalNumber = 0;  // 총판매금액과 총판매개수를 저장할 변수

		boolean flag = true;  // flag 변수가 true인 동안 반복을 시키기 위해 true로 처음 설정함

		while(flag==true) {   // 이는 < while(flag) { >와 동일함, 아직 이 표현이 익숙하지 않으면 
			System.out.print("Enter price & number (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  {   // price에 0이 입력되면
				flag = false;    // flag 변수를 false로 변경하여 다음 반복에서 반복을 벗어나게 함
			}
			else {
				number = SkScanner.getInt();

				totalPrice += price * number;    // 총판매금액을 누적
				totalNumber += number;           // 총판매개수를 누적
			}
		}

		System.out.println("   Total number = " +totalNumber);
		System.out.println("   Total price = " + totalPrice);
		System.out.println("   Average price = " + totalPrice / totalNumber);
	}

	// 다른 방법으로 작성된 main() 메소드
	public static void mainOther2(String[] args)  {

		int price, number;                    // 판매금액과 판매개수를  입력받을 변수
		int totalPrice = 0, totalNumber = 0;  // 총판매금액과 총판매개수를 저장할 변수

		for (boolean flag = true; flag==true; ) {  // mainOther1() 메소드의 while 문을 for 문으로 변경한 것임
			System.out.print("Enter price & number (exit if price=0) > ");
			price = SkScanner.getInt();

			if (price == 0)  {   // price에 0이 입력되면
				flag = false;    // flag 변수를 false로 변경하여 다음 반복에서 반복을 벗어나게 함
			}
			else {
				number = SkScanner.getInt();

				totalPrice += price * number;    // 총판매금액을 누적
				totalNumber += number;           // 총판매개수를 누적
			}
		}

		System.out.println("   Total number = " +totalNumber);
		System.out.println("   Total price = " + totalPrice);
		System.out.println("   Average price = " + totalPrice / totalNumber);
	}
}


/*
 *  [ 실습과제 ]
 *  
 *    o 정수 입력을 위해 SkScanner.getInt() 메소드를 사용하는 대신 
 *      java.util.Scanner 클래스의 nextInt() 메소드를 사용하는 
 *      프로그램을  Pr4_1_3_SaleUntilPrice0UsingJavaUtilScanner 클ㄹ래스로 작성하라.
 *
 *      이를 위해서는 import java.util.Scanner가 첫 부분에 나타나야 하며,
 *      Scanner 클래스의 객체가 new를 통해 생성되어야 한다(< Scanner scanner = new Scanner(System.in) >)
 * 
 * 
 *  [ 스스로 생각하고 고민해볼 과제 ]
 *  
 *   o 이 프로그램들과 반복문을 사용하지 않는 Ex4_1_1_Sale3_NotUsingRepeat와 비교해보면서
 *     반복문의 필요성, 중요성, 효용성 등을 생각해보시오.

 */

