package ex03_scores;
/* 
 * [ Scores_ArrayAsReturnValue ]: 배열을 메소드의 반환값으로 사용하기
 * 
 *  o 배열이 메소드의 반환값으로 사용
 *    - 호출된 메소드에서 배열 객체 생성하여 이 배열을 반환값으로 반환할 수 있음
 *    - 배열이 반환값으로 반환되면 호출한 메소드에서도 반환된 배열의 모든 원소를 접근하거나 수정할수 있음
 */

class Ex5_5_2_Scores_ArrayAsReturnValue {
	public static void main(String[] args) { 
		// inputInts()에서 입력된 원소가 저장된 배열을 반환받아 출력
		int[] scores = inputInts(10, "\n  o 10개 점수 입력하시오 > ");  
		outputInts(scores, "\n  ** scores 배열에 저장된 점수들 **\n  * ");  
	}

	// prompt 메시지 출력 후 n개의 정수를 입력하여 생성된 배열에 저장하고 배열을 반환
	static int[] inputInts(int n, String prompt) {
		int[] ints = new int[n];  // n개 정수 저장할 배열객체 생성하여 ints 배열변수에 저장

		System.out.print(prompt);      // prompt 출력

		for (int i = 0; i < n; i++) 
			ints[i] = SkScanner.getInt(); // 정수 입력하여 ints 배열 원소로 저장

		outputInts(ints, "\n  ** ints 배열에 입력되어 저장된 원소들 **\n  * "); // 배열을 매개변수로 전달하여 모든 원소 출력

		return ints;  // ints[] 배열을 반환
	}

	// title과 정수 배열변수 ints에 저장된 모든 원소를 한 라인에 출력하는 메소드
	//   출력할 원소의 개수가 주어지지 않을 경우 배열의 length 필드를 이용하여 원소 개수를 구함
	static void outputInts(int[] ints, String title) {
		System.out.print(title);               // title 출력

		for (int i = 0; i < ints.length; i++) 
			System.out.print(ints[i]  + "  ");   // ints 배열의 각 원소를 출력

		System.out.println();     
	}
}