package exercise05;

/**
 * [ 5장 연습문제  5 ]:
 *   
 *   5. 다음의 main() 메소드 문장들을 대체 추상화 과정을 통해 대체 메소드로 작성하려 한다.
 *   
 *      1) 각 프로그램의 기능을 설명하라.
 *      2) 각 프로그램의 기능에 적합한 대체 메소드 이름을 작명하라.
 *      3) 대체 메소드를 작성하고 main()에서 대체 메소드를 호출하라.
 *   
 * [ 5장 연습문제 6 ]:
 * 
 *   6. 연습문제 5에서 작성한 대체 메소드들에 대한 통합 메소드를 각각 작성하려 한다.
 *   
 *      1) 작성한 대체 메소드와 유사한 기능의 대체 메소드 2개를 추가로 작성하라. 
 *         예를 들어, [1]의 프로그램에 대해 대체 메소드 printLikeJava_ 10Times()
 *         를 작성하였으면 printLikeJava_20Times(), printLikeJava_100Times()를 작성하라.
 *         
 *      2) 유사한 메소드를 통합하기 위한 매개변수를 결정하고 통합 메소드를 각각 작성하라. 
 *         예를 들어, [1]의 프로그램에 대해 대체 메소드 printLikeJava_ 10Times()를 작성한 후 
 *         printLikeJava_20Times() 메소드와  printLike Java_100Times()를 작성했다면 
 *         통합 메소드에 해당되는 printLikeJava (int cnt)를 작성하라.
 */

class Exercise5_0506 {
	public static void main(String[] args) {

		// [1]
		for (int i = 0; i < 10; i++)
			System.out.print("I like Java ");

		
		// [2]
		int cnt = 0; 
		for (int n = 1234; n != 0; n /= 10) 
			cnt ++;
		
		System.out.println("\n  * cnt = " + cnt);

		
		// [3]
		int n1, n2, n3; 

		n1 = 23;  n2 = 33;  n3 = 43; 

		int max = (n1>n2) ? ((n1>n3) 
				? n1 : n3) : ((n2>n3) ? n2 : n3);

		System.out.println("\n  * max = " + max); 
		

		// [4]
		int[] scores = new int[10]; 
		
		System.out.print("\n  o 10개 정수 입력하시오 > ");

		int sum = 0;     
		for (int i = 0; i < 10; i++) {
			scores[i] = SkScanner.getInt();   
			sum = sum + scores[i];
		}

		System.out.println("\n  * sum = " + sum); 
	      
	}
}
