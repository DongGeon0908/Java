package ex11_1_need_for_collection;

/**
 * [ StringsMgmt_OutOfBoundsException 클래스 ]: 
 *       배열의 최대 저장 가능 원소보다 더 많은 원소를 저장할 경우 예외 발생을 보이는 예제
 * 
 *   o 배열의 저장 가능한 최대 원소 개수보다 더 많은 원소 저장하면 인덱스 범위 초과 예외인
 *     ArrayIndexOutOfBoundsException 발생
 *    
 *   o 저장 가능한 최대 원소 개수는 3인데 main()에서 5개 원소 저장하려 함
 *     - 4번째 원소를 strings[3]에 저장하려할 때 인덱스 범위 초과 예외 발생
 */

class Ex11_1_1_StringsMgmt_OutOfBoundsException {  
	public static void main(String[] args) {
		String[] strings = new String[3];     // 최대 3개 문자열 저장하는 배열

		strings[0] = "홍길동"; 
		strings[1] = "박문수";
		strings[2] = "이몽룡";
	    strings[3] = "성춘향";
  		strings[4] = "심청";
  		
		System.out.print("\n  ** 저장된 이름들 **\n\n  ");

		for (String s : strings)             // strings 배열의 모든 원소 s에 대해
			if (s != null)                   //   s가 null이 아니면
				System.out.print(s + " ");   //     s를 출력
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 이 프로그램은 예외를 발생시키도록 작성되어 있다. 
 *      예외를 발생시키지 않도록 2가지 방법으로 프로그램을 수정하여 실행하라. 
 *      
 *      수정하는 방법은 다음과 같다.
 *      
 *      (1) 배열 객체의 저장 가능한 최대 원소 개수 증가하기
 *      (2) 저장할 문자열 개수 감소하기
 *   
 *   
 * [ 실습과제 ]
 *   
 *   o 최대 정수 10개를 저장하는 int 배열객체를 생성하여 배열변수 ints[]에 저장하고
 *     11개의 정수를 ints[]에 저장하도록 추가로 작성하고 프로그램을 실행하여 결과를 확인하라.
 */