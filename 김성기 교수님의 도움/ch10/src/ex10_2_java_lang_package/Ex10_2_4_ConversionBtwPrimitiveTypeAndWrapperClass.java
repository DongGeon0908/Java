package ex10_2_java_lang_package;

/**
 * [ ConversionBtwPrimitiveTypeAndWrapperClass 클래스 ]: 
 *       기본 타입의 값을 Wrapper 클래스 객체로 변환하고 Wrapper 클래스 객체의 값 출력하기
 *        
 *   o Wrapper 클래스
 *     - 기본 타입의 값을 내부적으로 갖는 객체를 제공하여 기본 타입의 값을 사용하지 못하고 
 *       반드시 객체를 사용해야 할 경우에 대처하게 함
 *     - Wrapper 클래스라 불리는 이유는 이 클래스의 객체는 기본 타입의 값을 둘러싸기(wrapping) 때문
 *     - Wrapper 클래스는 각 기본 타입마다 존재
 *     - int 타입과 char 타입의 Wrapper 클래스는 Integer와 Character
 *     - 그 외의 Wrapper 클래스 이름은 기본 타입의 첫 글자를 대문자로 변경한 이름을 사용
 *    
 *   o Wrapper 클래스의 생성자
 *     - 기본 타입의 값이 주어지면 이를 Wrapper 클래스의 객체에 저장
 *    
 *   o 기본 타입과 Wrapper 클래스간의 변환 메소드
 *     - 모든 Wrapper 클래스는 기본 타입의 값이 주어지면 Wrapper 클래스 객체로 변환하는 
 *       클래스 메소드 valueOf() 메소드 가짐
 *     - Wrapper 객체에 저장된 값을 기본 타입으로 반환하는 객체 메소드도 가짐 
 *    
 *   o Wrapper 클래스의 객체를 System.out.println()에서 출력
 *     - Wrapper 클래스 객체에 저장된 기본 타입의 값이 출력
 *     - Wrapper 클래스의 toString() 메소드를 저장된 기본 타입의 값을 반환하도록 
 *       Object 클래스의 toString() 메소드를 오버라이딩했기 때문
 */
  
class Ex10_2_4_ConversionBtwPrimitiveTypeAndWrapperClass {  
	public static void main(String[] args) {

		Integer I = new Integer(23);
		int i = I.intValue();
		System.out.println("  * I = " + I + ", i = " + i);

		Double D = new Double(177.7);
		double d = D.doubleValue();
		System.out.println("  * D = " + D + ", d = " + d);

		Character C = Character.valueOf('H');
		char c = C.charValue();
		System.out.println("  * C = " + C + ", c = " + c);

		Boolean B = Boolean.valueOf(true);
		boolean b = B.booleanValue();
		System.out.println("  * B = " + B + ", b= " + b);

		Object obj = Integer.valueOf(23);  // Integer 객체를 Object 참조변수에 저장
		i = ((Integer) obj).intValue();    // obj를 다운캐스팅하여 구한 정수값 i에 저장
		System.out.println("  * obj = " + obj + ", i = " + i); 
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 여러 Wrapper 클래스 객체를 생성하면서 값을 저장한 후  
 *      객체와 객체에 저장된 기본 타입의 값을 구하는 출력한다.
 *  
 *   2) 프로그램을 실행하여 출력 결과를 확인하라. 이때 Wrapper 객체를 출력하면  
 *      Wrapper 객체에 저장된 기본 타입의 값이 출력됨을 반드시 확인하라.
 *   
 *      이는 Wrapper 클래스는 기본 타입을 값을 출력하도록 toString() 메소드를 
 *      오버라이딩했기 때문이다.  
 *      
 *   3) 프로그램을 실행하고 결과를 확인하라.
 */
