package ex9_2_java_exception_handling;

/**
 * [ Person, ExceptionInSetAge 클래스 ] :
 *       잘못된 나이 저장할 경우 Java의 예외 처리 방법을 보여주는 예제
 *         
 *   o Java에서의 예외 처리
 *     - 메소드 수행 도중에 예외가 발생할 경우
 *       1) 예외객체를 생성하여 예외 관련 정보를 저장하고 이를 호출한 메소드로 던짐
 *       2) 호출한 메소드에서 던져진 예외객체를 잡아 예외 처리 
 * 
 *   o Java에서의 예외 처리 예
 *     - setAge() 메소드에서 age 필드에 저장할 나이가 음수인 경우
 *       1) 이를 저장하지 않고 발생한 예외 관련 정보를 예외객체에 저장하고 예외객체를 던짐
 *       2) setAge() 메소드를 호출한 메소드에서 던져진 예외객체를 잡아 예외 처리
 *      
 *     - withdraw() 메소드의 출금 과정에서 출금액이 0 이하 또는 잔액보다 큰 경우
 *       1) 예외객체를 생성하여 예외 관련 정보를 예외객체에 저장하고 던짐
 *       2) 호출한 메소드에서 예외객체 잡아 예외 처리
 * 
 *   o Java 예외 처리의 특징: 예외 발생과 처리의 분리
 *     - 처음에 Java 예외 처리를 접하게 되면 약간 독특하면서 어렵게 보임
 *     - 왜냐하면 예외 발생하는 곳에서 예외 처리되는 것이 아니라 다른 곳에서 예외 처리
 *     - 이는 Java의 예외 처리에서 가장 중요한 핵심사항
 *     - 예외를 발생시키는 부분과 발생한 예외를 탐지하고 처리하는 부분이 서로 분리됨 
 */

class Person {
	String 	name;    	 // 이름
	int    	age;		 // 나이

	// 객체 생성자: 이름, 나이가 주어지면 이를 객체의 필드 값으로 저장
	Person(String name, int age) {
		this.name = name;   this.age = age; 
	}

	// setAge() - 음수 나이면 예외 내용을 예외객체에 저장하고 예외객체를 던짐: 
	// Java에서 예외 처리하는 방법으로, 예외를 다른 곳에서 처리하게 함           
	void setAge(int age) throws Exception {  // 예외 클래스 명시
		if (age >= 0)
			this.age = age;
		else {
			Exception ex = new Exception("잘못된 음수 나이: " + age); // 예외객체 생성하며 예외발생 정보 저장
			throw ex;  // 예외객체 ex 던지기   
		}
	} 

	// toString(): 객체의 필드명과 필드값을 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "이름:" + this.name + ", 나이:" + this.age;
	}

	// output(): 객체의 필드명과 필드값을 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + this.toString());
	} 
}

class Ex9_2_1_ExceptionInSetAge {
	public static void main(String[] args) {
		Person p = new Person("김철수",  23); // 23세의 김철수가 있음

		while(true) {
			System.out.println("\n\n  ** 나이 입력하여 나이 변경하면서 예외 상황 살펴보기 **");

			int age = SkScanner.getInt("\n  o 김철수의 새로운 나이 입력 > ");  

			p.output("\n  * << p.setAge(" + age + "); >> 전의 김철수 - ");

			// 예외 탐지 및 처리: try-catch 블록 이용하여 예외객체 잡아 처리
			try { 				
				p.setAge(age);       // 음수 나이이면 저장하지 않고 Exception 객체가 던져짐
				p.output("\n  * << p.setAge(" + age  + "); >> 후의 김철수 - ");
			} 
			catch(Exception e) {     // 예외가 발생하면 Exception 객체가 던져지므로
				// 이를 잡아 객체참조변수 e에 저장하여 예외 처리
				System.out.println("\n  ??? p.setAge() 메소드 수행 중 예외가 발생함");
				System.out.println("  ??? 객체 참조변수 e에 저장된 예외 메시지 = '"
						                                +  e.getMessage() + "'");
				System.out.println("\n  * << catch(Exception e) >> 후의 김철수 - " + p);
			}		
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Person 클래스에서 나이 필드를 음수로 저장할 때 예외를 발생시키고 
 *      이를 탐지하고 처리한다.
 *
 *   2) 예외발생 메소드가 호출된다고 항상 예외가 발생하는 것은 아니다.
 *   
 *      - << p.setAge(24); >>가 호출되면 예외 발생하지 않고 나이 변경됨
 * 
 *      - << p.setAge(-24); >>가 호출되면 예외 발생하고 나이 변경되지 않음
 * 
 *   3) 나이를 양수와 음수로 입력한 후 프로그램의 실행 결과를 확인하라.
 *   
 *   4) try-catch 블록을 제거한 후 어떠한 오류가 발생하는 가를 확인하라.
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
 *     3) 성별 문자열이 주어지면 이를 저장하는 메소드  void setGender(String gender)를  예외발생 메소드로 작성하라.
 *            
 *     4) main() 메소드에서 "동성" 또는 ""을 매개변수로 하여 setGrade() 메소드를 호출한 후 객체를 
 *        출력하라. 메소드 호출 할 때에는 try-catch 블록으로 예외 처리를 하라.
 */

