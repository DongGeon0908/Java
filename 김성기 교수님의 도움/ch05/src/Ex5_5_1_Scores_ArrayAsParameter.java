/**
 * [ Scores_ArrayAsParameter ]: 배열을 메소드 매개변수로 사용하기
 * 
 *   o 배열을 메소드 매개변수로 사용
 *     - 호출된 메소드에서도 배열의 모든 원소 접근하거나 수정할 수 있음
 *     - 매개변수로 배열 전달하면 실매개변수의 배열객체를 형식매개변수가 또다시 참조하게 됨
 *     - 이는 하나의 배열객체를 여러 배열변수가 참조하게 되며, 
 *       동시에 한 배열객체를 여러 배열변수가 공유하게 되는 효과
 *      
 *   o 호출된 메소드에서 수정된 배열 원소는 호출한 메소드에서도 수정된 결과로 나타남
 *     - inputInts() 메소드에서 매개변수로 전달받은 배열변수 ints의  원소에 입력
 *        ==> main()에서의 실매개변수인  scores 배열의 원소에 입력되는 효과를 냄  
 */

class Ex5_5_1_Scores_ArrayAsParameter {
	public static void main(String[] args) { 
		int[] scores = new int[100]; 

		inputInts(scores, 10, "\n  o 점수 10개 입력하시오 > ");                 // 배열을 매개변수로 전달하여 원소에 값 입력
		outputInts(scores, 10, "\n  ** scores 배열에 저장된 점수들 **\n  * ");   // 배열을 매개변수로 전달하여 모든 원소 출력 
	}

	// prompt 메시지 출력 후 주어진 배열변수  ints에 n 개의 정수를 입력하는 메소드
	static void inputInts(int[] ints, int n, String prompt) {
		System.out.print(prompt);               // prompt 출력

		for (int i = 0; i < n; i++) 
			ints[i] = SkScanner.getInt(); // 정수 입력하여 ints 배열 원소로 저장 호출한 메소드의 배열도 변경되는 효과

		outputInts(ints, n, "\n  ** ints 배열에 입력되어 저장된 원소들 **\n  * "); // 배열을 매개변수로 전달하여 모든 원소 출력
	} 

	// title과 정수 배열변수 ints에 저장된 n 개의 정수를 한 라인에 출력하는 메소드
	static void outputInts(int[] ints, int n, String title) {
		System.out.print(title);               // title 출력

		for (int i = 0; i < n; i++) 
			System.out.print(ints[i]  + "  ");   // ints 배열의 각 원소를 출력

		System.out.println();
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 * 
 *   1) main()에 선언된 scores[] 배열변수는 inputInts() 메소드의 형식매개변수인  
 *      ints 배열변수와 같은 배열객체를 참조한다.
 *      - inputInts() 메소드에서 ints 배열변수의 원소들을 변경하면  
 *        scores 배열변수의 원소도 수정되는 효과
 *      - inputInts() 메소드에서 ints 배열변수의 원소들을 출력한 결과와  
 *        main()의 scores 배열변수의 원소들을 출력한 결과는 동일함
 *         
 *   2) outputInts() 메소드의 형식매개변수인  ints 배열변수는 
 *      main()과 inputInts()에서의  배열객체를 참조한다.
 *      - main()의 scores 배열변수의 원소들은 outputInts() 메소드의 형식매개변수인  
 *        ints 배열변수를 통해서도 접근 가능함
 *      - inputInts() 메소드의 ints 배열변수의 원소들은 outputInts() 메소드의 형식매개변수인  
 *        ints 배열변수를 통해서도 접근 가능함
 *     
 *   3) 배열을 메소드의 매개변수로 사용하면 배열의 모든 원소를 호출된 메소드에서도 
 *      접근하거나 수정할 수 있음을 확실히 이해하라.
 *      - 호출된 메소드의 매개변수로 배열을 전달
 *      - 전달받은 배열은 호출한 메소드의 배열변수와 동일한 배열객체를 참조함
 *      - 호출된 메소드에서 배열원소를 변경하면 호출한 메소드에서도 변경된 결과를 가짐
 *     
 *     
 * [ 실습과제 ]
 * 
 *   1) 정수 배열과 원소 개수가 매개변수로  주어지면 평균을 구하여 반환하는 
 *      static double getAverage(int[] ints, int no) 메소드를 작성하고
 *      main()에서 scores 배열변수에 저장된 10개의 점수 평균을 구해 평균을 출력하는 코드를  추가로 작성하라.
 *      
 *   2) static int getCountMoreThan(int[] ints, int no, int n) 메소드는  
 *      정수 배열 ints, 원소 개수 no 그리고 정수 n이 매개변수로  주어지면 n보다 큰 원소 개수를 반환하는 메소드이다. 
 *      
 *      이 메소드를 작성하고 main()에서 scores 배열변수에 저장된 10개의 점수 중에서 90보다 큰 
 *      점수 개수를 구하여 출력하는 코드를 추가로 작성하라.    
 */
