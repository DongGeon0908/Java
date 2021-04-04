package example11_2_person_mgmt;

/**
 * [ PersonMgmt1 ]: 배열의 최대 저장 가능 원소보다 더 많은 원소를 저장할 경우 예외 발생을 보이는 예제
 * 
 *   o 배열의 저장 가능한 최대 원소 개수보다 더 많은 원소를 저장하려 하면 인덱스 범위 초과 오류인
 *     ArrayIndexOutOfBoundsException이 발생함
 *    
 *   o 저장 가능한 최대 원소 개수는 3인데 main()에서 5개 원소를 저장하려 함
 *     - 4번째 원소를 persons[3]에 저장하려할 때 인덱스 범위 초과 오류가 발생함
 */

class Ex11_1_1_PersonMgmt1 {  // PersonMgmt1 클래스 선언
	public static void main(String[] args) {
		Person[] persons = new Person[3];  // 최대 3개 Person 객체 저장하는 배열

		for (int i = 0; i < 5; i++) {
			Person p = new Person();      // Person 객체를 생성
			p.input("\n  ** " + (i+1) + "번째 신상정보(이름, 나이, 현위치) 입력 **"); 
			persons[i] = p;               // p를 배열변수 persons에 저장
		}

		for (Person p : persons)         // persons 배열의 모든 원소 p에 대해
			if (p != null)               //   p가 null이 아니면
				p.output();              //     p를 output() 메소드로 출력
	}
}
  
/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 프로그램을 실행하여 결과를 확인하라.
 *   
 *   2) 이 프로그램은 예외를 발생시키도록 작성되어 있다. 예외를 발생시키지 않도록 2가지 방법으로 
 *      프로그램을 수정하여 실행하라. 수정하는 방법은 다음과 같다.
 *      
 *      (1) 배열 객체의 저장 가능한 최대 원소 개수를 증가하기
 *      (2) 저장할 객체 개수를 감소하기
 *   
 *   
 * [ 실습과제 ]
 *   
 *   1) 최대 정수 10개를 저장하는 int 배열객체를 생성하여 배열변수 ints[]에 저장하고
 *      11개의 정수를 입력하여 ints[]에 저장하도록 추가로 작성하고, 프로그램을 실행하여 결과를 확인하라.
 */
