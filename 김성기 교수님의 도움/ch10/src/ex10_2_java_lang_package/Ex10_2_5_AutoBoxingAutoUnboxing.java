package ex10_2_java_lang_package;

import java.util.Vector;  // java.util.Vector 클래스를 사용하기 위해 import

/** 
 * [ AutoBoxingAutoUnboxing 클래스 ]: 자동 박싱과 자동 언박싱
 * 
 *   o 자동 박싱과 자동 언박싱
 *     - 박싱 작업과 언박싱 작업은 간단한 작업이지만 프로그래밍 과정에서는 다소 번거로운 작업임
 *     - 자동 박싱: 박싱을 하지 않고서 기본 타입의 값을 Wrapper 클래스의 참조변수에 바로 저장
 *     - 자동 언박싱: 언박싱을 하지 않고서 Wrapper 클래스의 객체를 단순변수에 바로 저장
 *     - Java 컴파일러는 박싱과 언박싱을 필요한 경우를 검사하여 자동적으로 박싱과 언박싱을 수행
 *     
 *   o 자동 박싱 예
 *     - 박싱을 하지 않고서 정수 23을 Integer 클래스의 참조변수 ageInt에 저장
 *         Integer ageInt = 23;  // 자동 박싱: 정수 23을 Integer 클래스의 객체 참조변수 ageInt에 저장
 *         
 *     - Java 컴파일러는 이 문장을 검토하여 박싱이 필요한 작업임을 확인한 후 
 *       다음과 같이 박싱이 포함되는 문장으로 수정하여 컴파일
 *         Integer ageInt = Integer.valueOf(23);  // 23 저장하는 Integer 클래스 객체 생성하여 ageInt에 저장
 *        
 *   o 자동 언박싱의 예
 *     - Integer 클래스의 객체를 기본 타입의 변수에 바로 저장
 *         int age = ageInt;      // 자동 언박싱: Wrapper 클래스의 객체 ageInt를 int 변수  age에 바로 저장
 *         
 *     - Java 컴파일러는 이 문장을 검토하여 언박싱이 필요한 작업임을 확인한 후 
 *       다음과 같이 언박싱이 포함되는 문장으로 수정하여 컴파일
 *         int age = ageInt.intValue();  // Integer 객체에 저장된 정수 값 가져와 age에 저장
 *         
 *   o 자동 박싱과 자동 언박싱의 이점
 *     - 자동 박싱과 자동 언박싱은 Java에서 기본 타입의 값과 Wrapper 객체 사이의 차이를 없애므로 
 *       프로그램이 아주 간결하게 작성될 수 있는 이점이 있음
 *       
 *     - 자동 박싱과 자동 언박싱의 이점은 컬렉션(Collection) 클래스를 이용하여 여러 데이터를 다룰 때 명확히 드러남
 *       (컬렉션 클래스는 여러 데이터를 편리하게 저장하고 관리하기 위한 클래스들로서, 
 *        Java에서는 java.util 패키지에 Vector, ArrayList, HashTable, Stack 등 여러 클래스가 제공됨)
 */

class Ex10_2_5_AutoBoxingAutoUnboxing {
	public static void main(String[] args) {
		// 정수 원소들을 저장하는 벡터 객체 생성하여 scores에 저장
		Vector<Integer> scores = new Vector<Integer>();  // Vector 클래스 객체 생성 및 저장 

		for (int i = 0; i < 10; i++) {
			int score = (int) (Math.random() * 101); // 0과 100 사이 난수 생성하여 
			scores.add(score);                       // 정수 score를 scores 벡터에 저장: 자동 박싱
		}

		System.out.print("\n  * 난수로 구한 10개 점수: "); 
		for (int i = 0; i < scores.size(); i++) {    // scores 벡터에서 
			int score = scores.get(i);               //   Integer 원소들을 꺼내어 score에 저장: 자동 언박싱
			System.out.print(score + " ");           //   score 출력
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) Vector 객체에 Integer 객체를 저장하고 끄집어내는 메소드인 add() 메소드와 get() 메소드의 시그니쳐와 기능은 다음과 같다.
 *      - public boolean add(Integer i): Integer 객체 i를 Vector에 저장
 *      - public Integer get(int index): Vector에 저장된 Integer 객체를 반환
 *      
 *   2) 이 예제에서 add() 메소드의 실매개변수는 Integer 객체이지만 정수값인 score가 실매개변수로 사용되었고, 
 *      Vector 객체에서 값을 꺼내기 위한 get() 메소드의 반환값인 Integer 객체가 바로 int 변수에 저장되었다. 
 *      - 이는 모두 자동 박싱과 자동 언박싱이 제공되기 때문에 가능
 *      
 *   3) 자동 박싱과 언박싱을 이용하지 않고 직접 박싱과 언박싱을 수행할 경우  <<scores.add(score);>>에서의 메소드 호출과 
 *      <<int score = scores.get(i);>>에서의 메소드 호출은 다음과 같이 변경되어야 한다.
 *      
 *      - scores.add(Integer.valueOf(score));    // 정수값 score를 Wrapper 객체로 박싱
 *      - int score = scores.get(i).intValue();  // Wrapper 객체 scores.get(i)를 언박싱
 *  
 *   4) 프로그램을 실행하여 출력 결과를 확인하라.   
 */
