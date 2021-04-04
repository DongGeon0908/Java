/**
 * [ TypeConversion_ErrorAssignment ]: 대입 연산에서의 오류 확인하기
 *        
 *   o 프로그래밍 스타일 
 *     1) main() 메소드로만 클래스 구성
 *     2) 대입 연산에서 발생하는 오류 확인 및 수정
 *       
 *   o 대입 연산에서 강한 타입의 값을 약한 타입의 변수에 저장하면 오류 발생
 *     - int avg = 89.4;  (실수 값을 정수 변수에 저장하면 오류)
 *     - 이는 정보 손실이 발생할 수 있기 때문
 *     - 강제 타입 변환을 통해 약한 타입의 값으로 변환한 후 저장해야 함
 *           int avg = ( int ) 89.4;
 *             
 *   o 대입 연산에서 발생한 오류를 제거하기 위한 방법
 *     (1) 저장할 값의 타입에 적합한 변수 타입으로 선언하기
 *     (2) 저장할 값을 변수 타입에 적합한 값으로 변환하기            
 *          
 *   o 약한 타입과 강한 타입 관계 
 *        byte ≪ char/short ≪ int  ≪   long ≪  float ≪  double       
 */

class Ex3_2_4_TypeConversion_ErrorAssignment  {
	public static void main(String[] args)  {

		int avg;
		int n = 10;
		short s;
		long distance;
												
		System.out.println("\n  ** 대입 연산에서의 오류 확인 **\n");
				
		System.out.println("  * 변수 선언: int avg;  short s;  int n = 10; long distance; \n");	
		
		System.out.println("  * 대입시 오류: avg = 89.4	  := " + ( avg = 89.4 ));      // double 값을 int 변수에 저장하면 오류 
		System.out.println("  * 대입시 오류: avg = 89.0	  := " + ( avg = 89.0 ));      // double 값을 int 변수에 저장하면 오류
		
		System.out.println("  * 대입시 오류: s = 0x1234_5678  := " + ( s = 0x1234_5678 ));  // int 값을 short 변수에 저장하면 오류        
		System.out.println("  * 대입시 오류: s = n   := " + ( s = n ));                     // int 변수 값을 short 변수에 저장하면 오류    
		System.out.println("  * 대입시 오류 아님: s = 10   := " + ( s = 10 ));               // short 범위 내의 int 상수 값을 short 변수에 저장하면 오류 아님
		
		System.out.println("  * 대입시 오류: distance = 9.46E12 := " + ( distance = 9.46E12 )); // double 값을 long 변수에 저장하면 오류      
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 오류가 있는 문장의 왼쪽에 붉게 표시된 오류 표시를 클릭하여 오류 메시지를 확인하라.
 *     - Type mismatch: can not convert from double to int
 *     - Type mismatch: can not convert from double to int
 *     - Type mismatch: can not convert from int to short
 *     - Type mismatch: can not convert from int to short
 *     - Type mismatch: can not convert from long to int
 *     
 *   2) 오류를 제거하기 위해 변수 타입을 변경하거나 강제적 타입변환인 캐스트를 적용시켜 
 *      오류를 수정한 후 결과를 확인하라.  
 */

