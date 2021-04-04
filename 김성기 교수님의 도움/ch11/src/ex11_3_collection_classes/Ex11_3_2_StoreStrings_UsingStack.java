package ex11_3_collection_classes;

import java.util.Stack;

/**
 * [ StoreStrings_UsingStack 클래스 ]: 
 *       java.util.Stack 클래스의 푸시와 팝 이해하기
 * 
 *   o 스택
 *     - 후입선출(last-in, first-out: 마지막에 삽입된 원소가 가장 먼저 추출됨)의 기능을 갖는 리스트
 *     - 스택에서의 원소 삽입을 푸시(push)라 하며, 푸시는 탑(top)이라 불리는 한쪽에서만 차례로 삽입
 *     - 스택에서의 원소 삭제를 팝(pop)이라 하며, 팝도 역시 탑 위치의 원소가 차례대로 추출되고 원소가 제거
 *   
 *   o Stack 클래스
 *     - Vector 클래스의 하위 클래스
 *     - 후입선출을 지원하기 위하여 empty(), peek(), pop(), push(), search() 메소드를 추가로 제공
 *          
 *   o main()에서 이름 5개를 Stack 객체에 푸시한 후 팝시킴
 */

class Ex11_3_2_StoreStrings_UsingStack {  
	public static void main(String[] args) {   
		// 문자열을 원소로 저장할 Stack 객체 생성하여 strings가 참조하게 함 
		Stack<String> nameStack = new Stack<String>(); 

		// 5개의 이름을 푸시하기 
		nameStack.push("홍길동");
		nameStack.push("박문수");
		nameStack.push("이몽룡");
		nameStack.push("성춘향");
		nameStack.push("심청");

		int cntNames = nameStack.size(); // 스택에 저장된 원소 개수 구함

		System.out.print("\n  ** nameStack의 모든 원소(" + cntNames +"개) 팝시키기 **\n\n  * "); 
		
		for (int i = 0; i < cntNames; i++) { // nameStack에 저장된 원소 개수만큼
			String s = nameStack.pop();      //   원소를 팝시켜
			System.out.print(s + " ");       //   출력 
		} 
	}
}

/*
* [ 프로그램의 이해 및 실행 ]
*   
*   1) 프로그램을 실행하여 결과를 확인하라.
*   
*   2) 2명의 이름을 nameStack에 추가하여 푸시하도록 프로그램을 변경하고 결과를 확인하라.
*   
*   3) 출력된 결과를 잘 살펴보고 Stack의 푸시와 팝의 경우 나중에 푸시된 데이터가 먼저 팝됨을 확인하라.
*/