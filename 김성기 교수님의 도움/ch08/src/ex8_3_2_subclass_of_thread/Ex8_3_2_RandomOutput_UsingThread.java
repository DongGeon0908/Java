package ex8_3_2_subclass_of_thread;

/** 
 * [ RandomOutputUsingThread 클래스 ] 
 *       Thread 클래스를 이용하여 여러 스레드 수행을 보여주는 예제
 * 
 *   o 스레드
 *     - 스레드(thread): Java 프로그램에서 작업 수행하는 독립적인 실행단위
 *     - Java에서는 한 프로그램에 대해 여러 스레드 생성하여 동시에 여러 작업을 병행적으로 수행시킬 수 있음
 *     - 스레드간의 동기화를 위한 방법도 제공
 *     
 *   o Thread 클래스
 *     - 여러 스레드 동시에 수행하기 위해 제공되는 클래스
 *     - java.lang 패키지의 클래스
 *     - 여러 프로그램을 동시에 수행하는 방법을 제공하는 중요한 클래스
 *     
 *     - 스레드 수행하기
 *        java.lang.Thread 클래스의 run() 메소드를 오버라이딩시킨 하위 클래스 작성 
 *        ==> 이 클래스의  여러 스레드 객체 생성한 후 start() 메소드 호출
 *        ==> 스레드가 수행되며, 스레드는 run() 메소드 수행 
 *        ==> 여러 스레드가 동시에 수행 가능
 */

class Ex8_3_2_RandomOutput_UsingThread extends Thread { 
	static int count = 0;   // 한 라인에 출력되는 난수 개수를 제어하기 위한 static 필드

	int noRandoms;   // 난수 개수를 저장하는 필드
	int[] ints;      // 난수를 저장하는 배열변수

	Ex8_3_2_RandomOutput_UsingThread (int n){  // 객체 생성자: n개 난수 생성해 배열에 저장
		noRandoms = n;           // 난수 개수 noRandoms 필드에 저장
		this.ints = new int[n];  // 난수들을 저장할 배열 객체를 생성

		// 1부터 n-1까지의 난수 n개를 생성하여 ints[] 배열에 저장
		for (int i=0; i < n; i++) {
			ints[i] = (int) (Math.random() * n);  
		}
	}

	// 저장된 난수를 모두 출력하는 메소드
	void output() {
		System.out.println("** " + noRandoms +"개 난수 **");

		for (int i=0; i < noRandoms; i++) {
			// (순번/전체개수: 난수)의 형식으로 저장된 모든 난수  출력
			System.out.print(" [" + (i + 1) + "/" + noRandoms+":" + ints[i] +"]");

			if (++count % 10 == 0) // 이 코드는 난수를 한 라인에 10개씩 출력하게 함
				System.out.println();
		}
	}

	// run(): Thread의 하위 클래스가 반드시 구현해야 하는 메소드
	//    스레드 객체의 start() 메소드 호출하여 스레드가 수행되면 run() 메소드가 
	//    자동적으로 호출되어 수행되므로 output() 메소드가 수행되어 저장된 모든 난수가 출력됨
	public void run() {
		output();	   
	}

	public static void main(String[] args) {
		
		// 10개, 20개, 30개 난수를 출력하는 스레드 객체를 생성
		Ex8_3_2_RandomOutput_UsingThread th1 = new Ex8_3_2_RandomOutput_UsingThread(10);  
		Ex8_3_2_RandomOutput_UsingThread th2 = new Ex8_3_2_RandomOutput_UsingThread(20);      
		Ex8_3_2_RandomOutput_UsingThread th3 = new Ex8_3_2_RandomOutput_UsingThread(30);

		// start() 메소드로 스레드 수행
 		th1.start();
		th2.start();
 		th3.start();
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 *
 *   1) main()에서 Thread 클래스의 하위 클래스인 RandomOutputUsingThread를 선언한다.
 *   
 *   2) 난수 개수를 매개변수로 사용하여 RandomOutputUsingThread 객체 생성하여 th1, th2, th3에 저장하고 
 *      start() 메소드로 실행하여 각 스레드가 실행되게 한다.
 *      
 *      - th1.start()가 먼저 호출되고 th2.start()와 th3.start()가  나중에 호출되었지만 
 *        호출 순서대로 결과가 출력되지 않고  3 스레드가  동시에 실행되므로 엉클어진 결과가 출력된다.     
 *      
 *   3) 출력 결과를 보면 스레드가 아닌 프로그램의 출력과는 아주 다른 것을 볼 수 있다.     
 *      - th1, th2, th3  스레드가 동시에 실행되면서 각기 10개, 20개, 30개 난수들을 출력
 *      - 출력된 난수들의 순서는 th1, th2, th3의 난수들이 서로 엉키어 출력
 *      
 *      - 예를 들어, 출력결과  << [1/30:8] [1/10:2] [1/20:13] [2/10:4] ... >>는 다음을 나타낸다. 
 *        . [1/30:8] : th3의 30개 중 1번째 난수인 8 출력
 *        . [1/10:2] : th1의 10개중 1번째 난수인 16 출력
 *        . [1/20:13] : th2의 20개 중 1번째 난수인 13 출력
 *        . [2/10:4] : th1의 10개 중 2번째 난수인 4 출력 
 *        
 *      - th1의 10개, th2의 20개, th3의 30개 난수가 차례대로 출력되지 않고 임의의 순서대로 출력되는
 *        이유는 3개 스레드가 동시에 수행되면서 난수를 출력하기 때문
 *       
 *   4) 프로그램을 실행하여 실행할 때마다 출력 순서가 달라짐을 확인하라.
 *
 *
 * [ 실습과제]
 * 
 *   1) th1.start()만 수행하여 출력되는 결과를 확인하라.
 *   
 *   2) th1.start()와 th2.start()만 수행하여 출력되는 결과를 확인하라.
 */
