/** 
 * [ Scores_ArrayAsReturnValue ]: 배열을 메소드 반환값으로 사용하기
 * 
 *   o 배열을 메소드 반환값으로 사용
 *     - 호출된 메소드에서 배열 객체 생성하여 이 배열을 반환값으로 반환할 수 있음
 *     - 배열이 반환값으로 반환되면 호출한 메소드에서도 반환된 배열의 모든 원소 접근하거나 수정할 수 있음
 */

class Ex5_5_2_Scores_ArrayAsReturnValue {
	public static void main(String[] args) { 
		// inputInts()에서 입력된 원소가 저장된 배열을 반환받아 출력
		int[] scores = inputInts(10, "\n  o 점수 10개 입력하시오 > ");  
		
		outputInts(scores, "\n  ** scores 배열에 저장된 점수들 **\n  * ");  
	}

	// prompt 메시지 출력 후 n개 정수 입력하여 배열에 저장하고 배열 반환
	//   이 메소드는 정수 배열을 반환하므로 반환타입이 int[]
	static int[] inputInts(int n, String prompt) {
		int[] ints = new int[n];           // n개 정수 저장할 배열객체 생성하여 ints 배열변수에 저장

		System.out.print(prompt);          // prompt 출력

		for (int i = 0; i < n; i++) 
			ints[i] = SkScanner.getInt();  //   정수 입력하여 ints 배열 원소로 저장

		outputInts(ints, "\n  ** ints 배열에 입력되어 저장된 원소들 **\n  * "); // 배열을 매개변수로 전달하여 모든 원소 출력

		return ints;  // ints[] 배열을 반환
	}

	// title과 정수 배열변수 ints에 저장된 모든 원소를 한 라인에 출력하는 메소드
	//   출력할 원소의 개수가 주어지지 않을 경우 배열의 length 필드를 이용하여 원소 개수를 구함
	static void outputInts(int[] ints, String title) {
		System.out.print(title);                 // title 출력

		for (int i = 0; i < ints.length; i++) 
			System.out.print(ints[i]  + "  ");   //   ints 배열의 각 원소를 출력

		System.out.println();     
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *      
 *   1) 배열을 메소드 반환값으로 반환하면 호출한 메소드에서 반환된 배열을 사용 가능함을 확실히 이해하라.
 *      - 호출된 메소드의 반환값으로 배열을 전달
 *      - 반환된 배열은 호출된 메소드의 배열변수와 동일한 배열객체를 참조
 *      - 호출된 메소드에서 배열원소를 변경하면 호출한 메소드에서도 변경된 결과를 가짐
 *     
 *   2) inputInts()에서 선언된 ints 배열변수는 main() 메소드의  scores 배열변수와 같은 배열객체를 참조함
 *      - inputInts() 메소드의 ints 배열변수의 원소들은 main()의  scores 배열변수의 원소와 동일
 *      - inputInts() 메소드의 ints 배열변수의 원소들을 출력한 결과와  
 *        main()의 scores 배열변수의 원소들을 출력한 결과는 동일
 *         
 *   3) outputInts() 메소드의 형식매개변수인 ints 배열변수는 main()과 inputInts()에서의 배열객체를 참조함
 *      - main()의 scores 배열변수의 원소들은 outputInts() 메소드의 형식매개변수인  
 *        ints 배열변수를 통해서도 접근 가능
 *       
 *       
 * [ 참고 사항 ]
 * 
 *   o Java에서는 호출된 메소드에서 배열을 생성하여 작업한 후 호출한 메소드로 배열을 반환해도 문제가 되지 않는다.
 *   
 *     그런데, C 언어에서는 호출된 함수에서 배열을 선언하고 작업한 후 호출한 함수로 배열을 반환하면
 *     배열이 손상되거나 다른 심각한 문제가 발생할 수 있으므로 주의를 해야 한다.
 *     
 *     그 이유는 C에서 호출된 함수에서 선언된 배열은 시스템 스택에 할당되기 때문이다. 
 */
