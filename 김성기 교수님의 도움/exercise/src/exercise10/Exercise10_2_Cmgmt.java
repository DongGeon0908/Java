package exercise10;

/**
 * [ 10장 연습문제 2의 소스 프로그램 ]
 * 
 *   2. 다음 프로그램에 대해 답하시오.
 *   
 *      1) 패키지 p1.p2.p3의 클래스인 C, C1, C2에 대해 프로그램에서 
 *         유추할 수 있는 사항들을 설명하라.
 *         
 *      2) 이 프로그램에서 패키지 p1.p2.p3의 클래스를 참조하기 위해 정규화된 이름을 사용한다. 
 *         이를 개별 클래스를 import하는 프로그램으로 변경하라.
 *         
 *      3) 이 프로그램을 패키지 p1.p2.p3의 모든 클래스를 import하는 프로그램으로 변경하라.
 *
 *  [ 참고사항 ] 
 *     p1.p2.p3 패키지는 ch10 프로젝트에 p1.p2.p3 패키지로 작성되어 있음 
 */
     
public class Exercise10_2_Cmgmt {

	public static void main(String[] args) {
	     p1.p2.p3.C c1 = new p1.p2.p3.C1();
	     p1.p2.p3.C c2 = new p1.p2.p3.C2();

	     c1.output();
	     c2.output();
	}
}
