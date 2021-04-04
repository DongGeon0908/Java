/**
 * [ TypeConversion_ErrorCorrection ]: 대입 연산에서 발생한 오류 확인하고 수정하기
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 대입 연산에서 발생하는 오류 확인 및 수정
 *       
 *   o 대입 연산에서 강한 타입의 값을 약한 타입의 변수에 저장하면 오류 발생함
 *     - int avg = 89.4;(실수 값을 정수 변수에 저장하면 오류)
 *     - 이는 정보 손실이 발생할 수 있기 때문
 *     - 강제 타입 변환을 통해 약한 타입의 값으로 변환한 후 저장해야 함
 *          int avg = (int) 89.4;
 *            
 *   o 대입 연산에서 발생한 오류를 제거하기 위한 방법
 *     (1) 저장할 값의 타입에 적합한 변수 타입으로 선언하기
 *     (2) 저장할 값을 변수 타입에 적합한 값으로 변환하기
 *          
 *    o 약한 타입과 강한 타입 관계 
 *         byte ≪  char/short ≪ int ≪  long ≪  float ≪  double       
 */

class Ex3_2_5_TypeConversion_ErrorCorrection  {
	public static void main(String[] args)  {

		double avg;      // 변수 avg를 double 타입으로 선언해 실수 저장하게 함
		int n = 10;
		int s;           // 변수 s를 int 타입으로 선언해 4 바이트 정수 값을 저장하게 함
		long distance;
												
		System.out.println("\n  ** 대입 연산에서 발생한  오류 수정 후 확인 **\n");
				
		System.out.println("  * 변수 선언: double avg;  n = 10; int s;  long distance;	\n");					
		System.out.println("  * 대입시 오류  수정: avg = 89.4  := " + ( avg = 89.4 ));   // double 변수에 double 값 저장가능
		System.out.println("  * 대입시 오류  수정: avg = 89.0  := " + ( avg = 89.0 ));   // double 변수에 double 값 저장가능
		
		System.out.println("\n  * 대입시 오류  수정: s = 0x1234_5678  := " + ( s = 0x1234_5678 )); // int 변수에 int 값 저장가능
		System.out.println(  "  * 대입시 오류  수정: s = n := " + ( s = n ));                      // int 변수에 int 값 저장가능
		System.out.println(  "  * 대입시 오류 아님: s = 10 := " + ( s = 10 ));                     // short 범위 내의 int 값을 short 변수에 저장하면 오류 아님
		
     	System.out.println("\n  * 대입시 오류  수정: distance = 9460000000000L  := " + ( distance = 9460000000000L )); // double 값 9.46E12를 long 값으로 표시
		System.out.println(  "  * 대입시 오류  수정: distance = (long) 9.46E12  := " + ( distance = (long) 9.46E12)); // double 값을 long 값으로 강제로 변환시킴      
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   o 예제 3-2-4의 오류를 제거하기 위해 취해진 조치를 살펴보고 결과를 확인하라.  
*/
