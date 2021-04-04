package ex12_more;
/*
 *  [ Print_IlikeJava1221_UsingRecursiveMethod }]: "I Like Java "를 1221번 출력하기
 *  
 *    o 스타일 5: 반복문 사용하지 않기
 *             +  재귀적 메소드 호출을 이용하여 "I Like Java "를 출력
 *      
 *  o 똑같은 작업을 반복하는 프로그램을 반복문을 사용하지 않고서 직접 작성해보는 것은 
 *        반복문의 중요성을 이해하기 위해 매우 중요하다.
 *        
 *  o 반복문을 사용하지 않고서 직접 반복문장을 나열하는 것은 반복 회수에 따라 난이도가 달라진다. 
 *     반복회수가 작을 때는 때에는 대수롭지 않다가, 회수가 많아지면 점점 어려워져 
 *     회수가 아주 많아지면 거의 불가능해 보이기도 한다. 
 *     1221번은 직접 할 수 있으나 12321번, 1234321번 등의 가능할까?
 *       
 *   *****************************************************************************************************************
  *    o 반복문 쓰지 않고 1221번 또는 그 이상을 출력하는 프로그램 작성하기
 *       - 세번째 방법: 재귀적 메소드를 작성하고 이를 호출
 *   
 *       1) 다음의 재귀적 메소드(recursive method: 자기 자신을 호출하는 메소드)를 작성
 *   
 *          public static void printLikeRecursive(int n) {   // n에 저장된 회수만큼 출력하려면 
 *             if (n > 0) {                          // n이 0보다 클 경우
 *                System.out.print("I Like Java ");  // 1번 출력한 후
 *                printLikeRecursive(n-1);           // 나머지 n-1번 출력하면 됨
 *             }
 *             
 *             // n이 0보다 작거나 같으면 아무 것도 수행하지 않음 경우
 *          } 
 *       
 *       2) main() 메소드에서는 printLikeRecursive(1221)을 호출
 *          public static void main(String[] args)  {
 *       	 	printLikeRecursive(1221);
 *          }	
 *       
 *       3) console 뷰에서 결과를 확인	
 *     
 *     재귀적 메소드는메소드 바디부분에서 자기 자신을 호출하는 메소드이며, 보통 자신을 호출하면서 매개변수의 값을 
 *     변경시켜 어느 순간에 더이상 자신을 호출하는 것이 멈추도록 작성된다. 
 *       
 *     위에서는 처음 호출에서 매개변수가 1221로 호출되며, 자신을 호출할 때에서 n으로 주어졌던 매개변수를 n-1로 바꾸어
 *     호출한다. 그러므로 매개변수가 0인 상태에서 호출된 어느 순간, 더이상 자신을 호출하지 않게 되며 return만 연속으로
 *     이루어져 프로그램이 종료된다.    
 *   *****************************************************************************************************************
 */

public class Ex4_04_7_Print_IlikeJava1221_UsingRecursiveMethod {
	public static void main(String[] args)  {
		printLikeRecursive(123);
	}

	public static void printLikeRecursive(int n) {       // n번 출력하려면 
		if (n > 0) {                            // n이 0보다 클 경우
			System.out.print("I Like Java ");   // 1번 출력한 후
			printLikeRecursive(n-1);            // 나머지 n-1번 출력하면 됨
		}
	} 
}
