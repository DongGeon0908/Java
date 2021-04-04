/**
 * [ PrintLikeJava10Times ]: "I like Java "를 반복문을 사용하지 않고서 10번 출력하기
 *   
 *   o 프로그래밍 스타일
 *     1) main() 메소드로만 클래스 구성
 *     2) 반복문 사용하지 않고 동일한 문장을 여러 번 나열하기
 *      
 *   o 반복 작업
 *     - 똑같은 작업을 반복하는 프로그램을 반복문 사용하지 않고서 직접 작성해보는 것은 
 *       반복문의 중요성을 이해하기 위해 매우 중요함
 *        
 *     - 반복문 사용하지 않고서 직접 반복문장 나열의 난이도는 반복 회수에 따라 달라짐
 *        
 *     - 반복회수가 작을 때는 대수롭지 않다가, 회수가 많아지면 점점 어려워져 회수가 
 *       아주 많아지면 거의 불가능하기도 함    
 */

class Ex3_4_3_PrintLikeJava_10Times  {
	public static void main(String[] args)  {
		System.out.print("\n  **** Print \"I like Java\" 10 times not using for statement ****\n");

		// "I like Java " 문자열을 10번 출력
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
		System.out.print("I like Java ");
	}
}

/* 
 * [ 실습과제 ]
 * 
 *   1) "I like Java "를 21번 출력하는 프로그램을 Pr3_4_3_PrintLikeJava_21Times 
 *       클래스로 작성하라.
 *          
 *   2) "I like Java "를 121번 출력하는 프로그램을 Pr3_4_3_PrintLikeJava_121Times 
 *        클래스로 작성하라.
 *         
 *   3) "I like Java "를 1221번 출력하는 프로그램을 Pr3_4_3_PrintLikeJava_1221Times 
 *      클래스로 작성하라.
 *          
 *   4) "I like Java "를 12321번 출력하는 프로그램을 Pr3_4_3_PrintLikeJava_12321Times 
 *      클래스로 작성하라.  
 *   
 *  
 * [ 참고사항 ]
 *
 *   1) 실습과제를 할 때에는 이 클래스의 프로그래밍 스타일과 동일한 스타일의 프로그램을 
 *      작성하여야 하며, 반복문을 사용해서는 안 된다.
 *     
 *   2) 실습과제 1), 2)까지는 출력문 << System.out.print("I like Java "); >>을 반복하여 
 *      나열하여 작성할 수도 있을 것이지만 실습과제 3), 4)의 경우에는 작성이 완료된 
 *      후에 출력문의 개수가 정확히 1221번 또는 12321번인지 확신하기 어려울 것이며 
 *      확실한 방법을 고안해야 한다. (가능한 방법을 찾아보고, 안되면 하지 않아도 됨)
 *         
 *   3) 프로그램 오류 찾기: 이 프로그램은 "I like Java "를 10번 출력한다고 프로그램을 작성했지만
 *      실제로 출력하는 회수는 10번이 아니라 11번이다. 
 *      print() 메소드를 호출하는 문장이 11개이므로 "I like Java "를 11번 출력한다. 
 *
 *      인간의 인식 체계에서 7개 이상인 것을 시각적으로 한꺼번에 파악하기 어려운 특징이 있으므로
 *      문장이 11개이지만 11개인지 바로 파악하기는 어렵다.
 *     
 *      지금은 연습으로 프로그램을 작성하므로 오류가 있어도 별 문제가 되지 않는다.
 *      그러나 실제 업무처리에서의 실수는 용납되지 않는다. 큰 재앙을 불러 올 수도 있기 때문이다.
 *
 *         
 * [ 스스로 생각하고 고민해볼 과제 ]     
 *  
 *   1) 이 프로그램에는 오류가 있다. 오류를 찾아 프로그램을 올바르게 수정하라.
 *           
 *   2) 오류의 원인은 무엇이라고 생각하는가?    
 *    
 */
 