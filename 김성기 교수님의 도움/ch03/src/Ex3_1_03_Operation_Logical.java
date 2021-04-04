/**
 * [ Operation_Logical ]: 논리 연산의 연습
 *   
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) boolean 값에 대한 논리 연산을 수행하여 결과 값 출력
 *       
 *   o 논리 연산은 boolean 값에 대한 &&, ||, !이 있음
 */

class Ex3_1_03_Operation_Logical  {
	public static void main(String[] args)  {

		boolean isKorean = true;
		boolean isMale = false;

		System.out.println("\n  ** boolean 값에 대한 논리 연산(&&, ||, !) **\n");
		
		System.out.println("  * 변수 초기값: isKorean := " + isKorean);
		System.out.println("  * 변수 초기값: isMale   := " + isMale);
		System.out.println();
		
		System.out.println("  * isKorean && isMale  := " + ( isKorean + " && " + isMale) 
				                                         + " := " + ( isKorean && isMale	)); //  ⇒  true  && false	 ⇒  false		
		System.out.println("  * isKorean || isMale  := " + ( isKorean + " || " +  isMale)
				                                         + " := " + ( isKorean || isMale));     //  ⇒  true  || false	 ⇒  true 
		System.out.println();

		System.out.println("  * ! isKorean := " + ( "! " +  isKorean	) + "  := "  + ( ! isKorean	));  //   ⇒ ! true  ⇒  false		
		System.out.println("  * ! isMale   := " + ( "! " +  isMale	) + " := "  + ( ! isMale )); 	     //   ⇒  ! false ⇒  true	
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 연산의 결과를 손으로 구해보고 수행한 결과와 비교해 보라.
 *  
 */
