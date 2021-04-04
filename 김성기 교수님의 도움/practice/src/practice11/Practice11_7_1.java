package practice11;

import java.util.Vector;

/**
 * [ 11�� �ǽ����� 7�� �ҽ� ���α׷� ]
 * 
 *   7. ������ Integer �迭�� ����� ���� ������ Vector ��ü�� �����ϰ� ����Ѵ�.
 *      
 *      1) �� ���α׷��� ����� ���϶�.
 *      
 *      2) �� ���α׷��� Integer �迭�� ���� ���Ҹ� intsV ��ü ���� Vector ��ü�� �����Ѵ�. 
 *         ���� �迭 ��� Double �迭�� ���ҵ��� doublesV ��ü ���� Vector ��ü�� �����ϵ��� 
 *         �����Ͽ� DoublesV�� Practice11_7_2 Ŭ������ �ۼ��϶�.
 *         
 *      3) IntsV Ŭ������ ���� �ۼ��� DoublesV Ŭ������ �ſ� ������ Ŭ�����̹Ƿ� ���׸� Ŭ������
 *         �ۼ��� �� �ִ�. ���׸� Ŭ������ �����Ͽ� ObjectsV�� Practice11_7_3 Ŭ������ �ۼ��ϰ� 
 *         main()���� ���׸� Ŭ���� ObjectsV�� ��ü�� �����ϰ� Integer �迭 ���ҵ�� Double
 *         �迭 ���ҵ��� �����϶�.       
 */

class IntsV { 
   Vector<Integer> intsV = new Vector<Integer>();  

   // �迭 ints[]�� ��� ���Ҹ� ���� ��ü intsV�� �����ϴ� �޼ҵ�   
   void addInts(Integer[] ints) {
      addInts(ints, ints.length);
   }

   // �迭 ints[]�� ���� n���� ���� ��ü intsV�� �����ϴ� �޼ҵ�   
   void addInts(Integer[] ints, int n) {
      intsV = new Vector<Integer>();

      for (int i = 0; i < n; i++)
         intsV.add(ints[i]);
   }

   // ���Ͱ�ü intsV�� ����� ��� ���Ҹ� ����ϴ� �޼ҵ�   
   void output() {
      System.out.print("\n  * " + intsV.size() +"�� ���ҵ�: "); 

      for (int n : intsV)            			// ���Ͱ�ü intsV�� ��� ���� n�� ����
         System.out.print(n + " "); 			//    n ���   
   }
} 

class Practice11_7_1 {
	public static void main(String[] args) {   
		Integer[] scores = { 90, 91, 88, 87, 83, 78, 99, 76, 45, 67, 88, 12 };

		IntsV v = new IntsV();

		v.addInts(scores);            			// ��� ���� ������
		v.output();

		v.addInts(scores, 5);   					// ���� 5���� ������
		v.output(); 
	}
}