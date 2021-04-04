package ex12_more;
/*
 * [ Print_IlikeJava1221_UsingMethod ]: "I Like Java "를 1221번 출력하기
 *       
 *  o 스타일 4 : 반복문 사용하지 않기
 *            + 메소드 호출을 이용하여 "I Like Java "를 출력
 *      
 *  o 똑같은 작업을 반복하는 프로그램을 반복문을 사용하지 않고서 직접 작성해보는 것은 
 *        반복문의 중요성을 이해하기 위해 매우 중요하다.
 *        
 *  o 반복문을 사용하지 않고서 직접 반복문장을 나열하는 것은 반복 회수에 따라 난이도가 달라진다. 
 *     반복회수가 작을 때는 때에는 대수롭지 않다가, 회수가 많아지면 점점 어려워져 
 *     회수가 아주 많아지면 거의 불가능해 보이기도 한다. 
 *     1221번은 직접 할 수 있으나 12321번, 1234321번 등의 가능할까?

 *   ********************************************************
 *    o 반복문 쓰지 않고 1221번 또는 그 이상을 출력하는 프로그램 작성하기
 *    
 *       - 두번째 방법: "I Like Java " 출력 회수를 10배씩 증가시키는 메소드들을 작성하고  
 *                  1회 메소드 1번, 10회 메소드 2번, 100회 메소드 2번 1000회 메소드 1번 호출  
 *                    
 *     1) "I Like Java "를 1번 출력하는 printLike1() 메소드 작성
 *     2) printLike1()를 10번 호출하는 printLike10() 메소드 작성
 *     3) printLike10()를 10번 호출하는 printLike100() 메소드 작성
 *     4) printLike100()를 10번 호출하는 printLike1000() 메소드 작성
 *     5) main() 메소드에서 printLike1000() 1번, printLike100() 2번, 
 *        printLike10() 2번, printLike1() 1번 호출하면 "I Like Java "가 모두 1221번 출력
 *        
 *    질문:  아직 배우지 않은 메소드인데? 
 *    대답:  main() 메소드도 메소드이고, Java의 시작 메소드이다. 메소드를 전혀 배우지 않은 것은 아니다.
 *           2주 후에 메소드에 대해 보다 자세히 배울 것이다.
 *    
 *   *****************************************************************************************************************
*/

public class Ex4_04_6_Print_IlikeJava1221_UsingMethod {
	public static void main(String[] args)  {
		printLike1000();		

		printLike100();
		printLike100();

		printLike10();
		printLike10();

		printLike1();
	}
 
	// "I Like Java "를 1번 출력
	public static void printLike1() {
		System.out.print("I Like Java ");
	}

	// "I Like Java "를 10번 출력
	public static void printLike10() {
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
	}

	// "I Like Java "를 100번 출력
	public static void printLike100() {
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
	}

	// "I Like Java "를 1000번 출력
	public static void printLike1000() {
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
	}
}
