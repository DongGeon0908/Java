/**
 * [ Max_UsingMethodWithReturnValue ]: 
 *       반환값 갖는 메소드 사용하여 정수 중 최대값 찾아 출력하기
 * 
 *   o 반환값 갖는 메소드 작성
 *     - 메소드 시그니처에 void 키워드 대신 반환값의 타입 명시
 *     - 메소드의 수행이 종료되기 전에 반드시 반환값 갖는 return 문 수행하여 
 *       호출한 메소드로 반환값 전달해야 함
 *      
 *   o 반환값 갖는 메소드 호출
 *     - 메소드 호출되면 결과값이 반환되므로 메소드 호출이 수식의 일부로 사용 가능 
 *  
 *   o 이 프로그램은 다음의 작업을 수행함
 *     - 100과 101 중 큰 값 구하여 출력
 *     - 2개의 정수 23과 18중 중 큰 값 구하여 변수에 저장하여 출력
 *     - 23, 18 중 큰 값 구하여 매개변수로 사용, 12, 24 중 큰 값 구하여 매개변수로 사용
 *         ==> 4개 중 최대값 구하여  max4에 저장하고  출력
 */

class Ex5_4_1_Max_UsingMethodWithReturnValue  {		

	// 2 정수 중 큰 값을 반환하는 메소드
	// static 다음의 int는 반환값의 타입을 표시함 
	static int getMax(int n1, int n2) {
		int max = (n1 > n2) ? n1 : n2;
		
		return max;  // 키워드 return 다음의 값을 반환하는 문장
	}
	
	public static void main(String[] args) {

		System.out.println("\n  * 100과 101 중 큰 값 = " + getMax(100, 101) );    // getMax() 반환값 출력
		
		int n1 = 23, n2 = 18, n3 = 12, n4 = 24;

		int max2 = getMax(n1, n2);                                        // getMax() 반환값 변수에 저장하여 
		System.out.println("\n  * " + n1 + ", " + n2 + " 중 큰 값 = " + max2 ); // n1, n2 중 큰 값 출력

		// getMax() 반환값을 매개변수로 사용하는 예
		int max4 = getMax( getMax(n1, n2), getMax(n3, n4) );              // 4개의 정수 중 최대값 구해 출력
		System.out.println("\n  * " + n1 + ", " + n2 +", " + n3 + ", " + n4 + " 중 최대값 = " +  max4 ); 
	} 
} 

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 반환값 갖는 메소드 이용하여 최대값 구한 후 출력한다.
 *   
 *   2) 이를 위해 반환값 갖는 메소드 static int getMax(int n1, int n2)를 작성했다.
 *      - 반환값 타입  int의 명시와 return 문에서 반환값을  반환하는 것에 주목할 것
 *      - 매개변수 전달과 같이 눈에 보이지 않지만 반환값이 호출한 함수로 전달됨    
 *     
 *   3) main()에서 반환값 갖는 메소드 static int getMax(int n1, int n2) 호출한다.
 *      - 반환값 갖는 메소드는 값을 나타내므로 수식의 한 부분으로 사용됨
 *      - 이 예제에서 값 출력, 변수에 저장 값, 메소드 매개변수 등으로 사용
 *
 *
 * [ 실습과제 ]
 * 
 *   1) getMax() 메소드의 문장 << int max = n1 > n2 ? n1 : n2 ; >>을 if 문으로 변경하라.
 *   
 *   2) 3개 정수가 주어지면 그 중에서 가장 큰 값을 반환하는 메소드를 작성하라.
 *      - static int getMax3(int n1, int n2 , int n3) 
 *      - getMax() 메소드 이용하면 아주 간단하게 작성 가능
 *
 *   3) main()에서 3개의 정수에 대해 getMax3() 메소드 호출하여 가장 큰 정수를 출력하라
 */

