
package ex9_1_novice_exception_handling;

/**
 * [ Person, ExceptionInSetAgeMethod 클래스 ] : 
 *       나이 저장에서 초보적 예외 대처방법을 구현한 프로그램
 * 
 *   o Person 클래스
 *     - 필드 name, age
 *     - 나이를 저장하는 메소드 setAge1(), setAge2(), setAge3(), setAge4()
 *     - 서로 다른 예외 처리를 구현하기 위해  나이를 나이 필드에 저장하는 메소드를 
 *       4가지 방법으로 다르게 작성
 *     - 초보적 방법으로 예외 처리하므로 모두 문제점을 가짐
 *     
 *   o 4가지 메소드의 예외 처리 방법 비교
 *     1) setAge1(): 음수를 그대로 저장
 *       - 처리방법: 예외 상황이 발생해도 예외 처리를 하지 않음
 *       - 문제점: age 필드에는 오류 값인 -24 저장하므로 잘못된 결과를 낳게 됨
 *       
 *     2) setAge2(): 음수 나이를 저장하지 않음
 *       - 처리방법: 잘못된 나이를 저장되지 않게 하고서 예외 처리 완료
 *       - 문제점: 사용자의 입력 잘못으로 발생한 예외 상황을 사용자는 알 수 없음
 *       - 예외가 발생하면 사용자에게 발생한 예외에 대해 알려주는 것이 바람직
 *       
 *     3) setAge3(): 음수 나이 저장하지 않고 예외 메시지 출력
 *       - 처리방법: 예외 발생한 곳에서 직접 예외 처리 완료
 *       - 문제점: 예외 처리 방법이 고정되어 이 메소드에서 제공하는 방법으로만 예외 처리가 가능
 *       
 *     4) setAge4(): 음수 나이를 저장하지 않고 발생한 예외 상황을 필드에 저장
 *       - 처리방법: 이 메소드에서 예외 처리를 완료하지 않고, 메소드를 호출한 곳에서 예외 발생을 확인하여 
 *                  예외 처리할 수 있도록 예외 필드에 예외 발생 정보 저장
 *       - 장점: 호출한 곳에서 예외 발생 여부를 확인하여 예외 처리를 할 수 있으며, 
 *              이 메소드를 호출할 때마다 다른 예외 처리가 가능
 *       - 문제점: 예외 발생 가능한 모든 객체마다 예외 메시지 저장을 위한 필드를 선언해야하며, 
 *                이 메소드를 호출한 곳에서 예외 발생 여부를 확인하지 않으면 예외가 발생해도 예외 처리가 완료되지 않음
 */

class Person {
	String exceptionMsg;   // 예외 발생하면 예외 메시지를 저장하는 필드

	String name;  int age; // 이름, 나이 저장하는 필드

	// 객체 생성자: 이름, 나이가 주어지면 이를 객체의 필드 값으로 저장
	Person(String name, int age) {
		this.name = name;   this.age = age; 
	}

	// setAge1() : 음수 나이도 그대로 저장: 예외 처리하지 않음
	void setAge1(int age) {
		this.age = age;     // 잘못된 나이 저장이어도 age 필드에 저장
	} 

	// setAge2() : 음수 나이면 저장하지 않음: 잘못된 나이 저장 않고 예외 처리 완료
	void setAge2(int age) {
		if (age >= 0)        // 정상적인 나이 저장인 경우에만
			this.age = age;  //   나이를 age 필드에 저장
	} 

	// setAge3() : 음수 나이면 저장하지 않고 발생한 예외 상황에 대한 메시지 출력
	//   예외 발생한 곳에서 예외 처리 완료
	void setAge3(int age) {
		if (age >= 0)        // 정상적인 나이 저장이면
			this.age = age;  //   나이를 age 필드에 저장
		else
			// 잘못된 나이 저장이면 나이 저장 않고 예외 메시지를 여기에서 출력
	         System.out.println("\n  !!! setAge3() 내에서 오류 발생: 잘못된 음수 나이 "
                     + age + " 저장");
	} 

	// setAge4() : 음수 나이면 저장하지 않고 발생한 예외 상황을 예외 메시지 필드에  저장
	//    예외 처리 완료하지 않고 예외 메시지를 전달하여 호출한 곳에서 예외 처리하게 함
	void setAge4(int age) {
		if (age >= 0) {           // 정상적인 나이 저장이면
			this.age = age;       //   나이를 age 필드에 저장  
			exceptionMsg = null;  //   예외가 없으므로 exceptionMsg에 null 저장
		}
		else  // 잘못된 나이 저장이면 나이 저장 않고 예외 메시지를 예외 메시지 필드에 저장
			exceptionMsg = "잘못된 음수 나이 "  + age;  
	} 

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age ;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	} 
}

/*
 *  o Ex9_1_1_ExceptionInSetAgeMethod 클래스
 *    - 나이를  나이 필드에 저장하는 메소드 4개를 각각 호출 
 *    - 잘못된 나이인 음수 나이를  나이 필드에 저장하는 메소드가 호출되면 서로 다른 결과를 낳게 됨 
 *    - 특히, setAge4() 메소드 호출에서 오류가 발생하면 호출한 곳에서 다르게 예외 처리가 가능함
 */
class Ex9_1_1_ExceptionInSetAgeMethod {
	public static void main(String[] args) {
		Person p = new Person("김철수",  23); // 23세의 김철수가 있음

		System.out.println("\n\n  ** 나이 입력하여 나이 변경하면서 예외 상황 살펴보기 **");
		p.output("\n  * 나이 변경 전의 김철수 - ");

		System.out.println("\n  <참고> 여기에서 음수 나이도 입력하여 의도적으로 예외 발생시킴");
		int age = SkScanner.getInt("\n  o 김철수의 새로운 나이 입력  > ");

		p.setAge1(23);  p.setAge1(age);
		p.output("\n  * << p.setAge1(" + age + "); >> 후의 김철수 - ");

		p.setAge2(23);  p.setAge2(age);
		p.output("\n  * << p.setAge2(" + age + "); >> 후의 김철수 - ");

		p.setAge3(23);  p.setAge3(age);  // setAge3() 내에서 오류 처리 완료함
		p.output("\n  * << p.setAge3(" + age + ")); >> 후의 김철수 - ");

		/*
		 *  setAge4()를 호출하고 오류 발생 시 여러 방법으로 오류 처리를 보여주는 예
		 */		
		p.setAge4(23);  p.setAge4(age);  // setAge4()에서 오류 발생하면 오류가 전달됨
		p.output("\n  * << p.setAge4(" + age + ")); >> 후의 김철수 - ");

		// setAge4()에서 발생한 오류 처리 1: 
		//      setAge4()에서 예외 발생하면 exceptionMsg 필드에 예외 메시지 저장하므로  
		//      setAge4() 호출한 이곳에서 예외 발생 여부 확인하여 예외 처리 가능함
		if (p.exceptionMsg != null) {    // exceptionMsg 필드 null 아니면 예외 발생한 것
			// 예외 발생 확인되면 이곳에서 예외 메시지 출력하여 오류 처리함
			System.out.println("  !!! setAge4(" + age + ") 호출했을 때 오류 발생: " + p.exceptionMsg);  // 간단한 오류 메시지 출력
		}

		p.setAge4(23);  p.setAge4(age);  // 다른 오류 처리를 보이기 위해 p.setAge4(age) 다시 호출
		p.output("\n  * << p.setAge4(" + age + ")); >> 후의 김철수 - ");

		// setAge4()에서 발생한 오류 처리 2: 
		//      setAge4()에서 예외 발생하면 exceptionMsg 필드에 예외 메시지 저장하므로  
		//      setAge4() 호출한 이곳에서 예외 발생 여부 확인하여 예외 처리 가능함
		if (p.exceptionMsg != null) {    // exceptionMsg 필드 null 아니면 예외 발생한 것
			// 예외 발생 확인되면 이곳에서 예외 처리함
			System.out.println("  ??? 나이 저장 과정에서 문제 발생했습니다.");
			System.out.println("  ??? 오류 메시지는 '" + p.exceptionMsg + "'입니다.");   
		}

		// setAge4()에서 발생한 오류 처리 3: 
		//      setAge4()에서 예외 발생하면 exceptionMsg 필드에 예외 메시지 저장하므로  
		//      setAge4() 호출한 이곳에서 예외 발생 여부 확인하여 예외 처리 가능함
		//      마지막 메소드 호출 p.setAge4(age)에서 예외가 발생하여 예외 메시지가 전달되어도 예외 처리 하지 않음
		//      이는 setAge2()에서의 예외 발생이 사용자에게 표시되지 않는 것과 같음 
		p.setAge4(23);  p.setAge4(age);  // 다른 오류 처리를 보이기 위해 p.setAge4(age) 다시 호출
		p.output("\n  * << p.setAge4(" + age + ")); >> 후의 김철수 - ");

		System.out.println("\n  << 참고사항  >> 마지막 p.setAge4(age)에서 음수 나이 저장으로 예외 발생해도 예외 처리되지 않습니다.");   

		main(args);  // 반복 수행시킴
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 입력한 나이를 저장하는 메소드 setAge1(), setAge2(), setAge3(), 
 *      setAge4()를 호출하여 예외가 여러 방법으로 처리되게 한다. 
 * 
 *   2) 실행결과는 음수 나이를 저장할 경우의 예외 처리결과를 보여준다. 
 *
 *   3) 프로그램의 실행 결과를 확인하라.
 *   
 *   
 * [ 실습과제 ]
 *  
 *   o 성별 필드인 gender를 추가로 선언하려 한다. gender 필드는 "남성" 또는 "여성" 값만 저장 가능하다.
 *  
 *     1) gender 필드를 선언하라.
 *     
 *     2) gender 필드 값이 출력되도록 toString() 메소드를 변경하라.
 *     
 *     3) 성별 문자열이 주어지면 이를 저장하는 메소드  void setGender(String gender)를 4가지로 작성하라.
 *     
 *        setGender1(String gender), setGender2(String gender), setGender3(String gender), 
 *        setGender4(String gender)은  setAge1(int age), setAge2(int age), setAge3(int age), 
 *        setAge4(int age)와 같은 방법으로 예외 처리한다.
 *        
 *     4) main() 메소드에서 "동성" 또는 ""을 매개변수로 하여 이들 메소드를 호출한 후 객체를 
 *        출력하라. setGender4(int n) 메소드 호출 후에는 적절한 예외 처리를 하라.
 */
