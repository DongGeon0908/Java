package practice11;

import java.util.Vector;

/**
 * [ 11장 실습과제 7의 소스 프로그램 ]
 * 
 *   7. 다음은 Integer 배열에 저장된 여러 정수를 Vector 객체에 저장하고 출력한다.
 *      
 *      1) 이 프로그램의 출력을 구하라.
 *      
 *      2) 이 프로그램은 Integer 배열의 여러 원소를 intsV 객체 내의 Vector 객체에 저장한다. 
 *         정수 배열 대신 Double 배열의 원소들을 doublesV 객체 내의 Vector 객체에 저장하도록 
 *         변경하여 DoublesV와 Practice11_7_2 클래스를 작성하라.
 *         
 *      3) IntsV 클래스와 새로 작성된 DoublesV 클래스는 매우 유사한 클래스이므로 제네릭 클래스로
 *         작성될 수 있다. 제네릭 클래스로 변경하여 ObjectsV와 Practice11_7_3 클래스로 작성하고 
 *         main()에서 제네릭 클래스 ObjectsV의 객체를 생성하고 Integer 배열 원소들과 Double
 *         배열 원소들을 저장하라.       
 */

class IntsV { 
   Vector<Integer> intsV = new Vector<Integer>();  

   // 배열 ints[]의 모든 원소를 벡터 객체 intsV에 저장하는 메소드   
   void addInts(Integer[] ints) {
      addInts(ints, ints.length);
   }

   // 배열 ints[]의 원소 n개를 벡터 객체 intsV에 저장하는 메소드   
   void addInts(Integer[] ints, int n) {
      intsV = new Vector<Integer>();

      for (int i = 0; i < n; i++)
         intsV.add(ints[i]);
   }

   // 벡터객체 intsV에 저장된 모든 원소를 출력하는 메소드   
   void output() {
      System.out.print("\n  * " + intsV.size() +"개 원소들: "); 

      for (int n : intsV)            			// 벡터객체 intsV의 모든 원소 n에 대해
         System.out.print(n + " "); 			//    n 출력   
   }
} 

class Practice11_7_1 {
	public static void main(String[] args) {   
		Integer[] scores = { 90, 91, 88, 87, 83, 78, 99, 76, 45, 67, 88, 12 };

		IntsV v = new IntsV();

		v.addInts(scores);            			// 모든 원소 저장함
		v.output();

		v.addInts(scores, 5);   					// 원소 5개만 저장함
		v.output(); 
	}
}