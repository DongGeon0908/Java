package ex11_3_collection_classes;

import java.util.TreeSet;

/**
 * [ StorePersonsSorted_UsingTreeSet Ŭ���� ]: 
 *       java.util.TreeSet Ŭ������ ��ü�� ���Ҹ� �����ϰ� ���ĵ� ���ҵ��� ����ϱ�

 *   o TreeSet Ŭ����
 *     - �ߺ����� �ʴ� ���� �����͸� �̸� ������ ũ�� ������� �����ϰ� �˻��ϴ� ���� ��� �����ϴ� Ŭ���� 
 *     - TreeSet �̿��Ͽ� ���Ҹ� ������ �� ������ ������ �ִ� ũ�� ������ ������ �ʿ䰡 ����
 *     - ��ü������ ���� ������ ���� �����ϰ�, �� ���� ���Ұ� ����� �ʿ䰡 ������ ���� ���� �߰��� Ȯ����
 *     - ����� ��ġ ������ �� ������ �ߺ��� ���� ������ �� ���� ������ ����
 *    
 *   o TreeSet�� ����Ǵ� ���ҵ��� ũ�� ������ �����ϴ� ���
 *     - TreeSet ��ü�� ���� �����ϱ� ���� ���� Ŭ������ java.lang.Comparable �������̽��� �����ϴ� Ŭ����������
 *     - Comparable �������̽��� abstract �޼ҵ��� compareTo() �޼ҵ带 �ݵ�� �����ؾ� ��  
 *     - ������ ���ҿ� ����� ������ �񱳸� ���� ������ ������ ũ�� ������ ���� ��ġ�� ������   
 *     
 *     - name �ʵ��� ������ ������ �����ϱ�
 *     
 *     	   public int compareTo(PersonComparable p) {  
 *             // ������ ���� name �ʵ�� ����� ������ name �ʵ� ���Ͽ� ������ ������ �����ϰ� ��
 *	          return this.name.compareTo(p.name);  
 *         }
 *         
 *    - age �ʵ��� ������ ������ �����ϱ�
 *     
 *     	   public int compareTo(PersonComparable p) {  
 *            // ������ ���� �ʵ�� ����� ������ age �ʵ� ���Ͽ� ������ ������ �����ϰ� ��
 *	          return p.age - this.age;  
 *         }
 *       
 *   o TreeSet Ŭ������ �ֿ� �޼ҵ�
 *     - boolean add(E element) �޼ҵ�: ũ�� ������ �����Ͽ� ���� element ����
 *                                     Ư�� �̶��� ������ ������ ������ �ڵ������� ������ Ȯ���Ͽ� ���� ����
 *    - boolean contains(Object o) �޼ҵ�: ��ü o�� ���ҿ� ���ԵǸ� true ��ȯ, �׷��� ������ false ��ȯ
 *    - size() �޼ҵ�: ���� ����� ���� ���� ��ȯ     
 *    - remove(Object o) �޼ҵ�: ��ü o�� ���ҿ� ���ԵǸ� �̸� �����ϰ� true ��ȯ, 
 *                             �׷��� ������ false ��ȯ 
 *          
 *  o main()���� TreeSet ��ü�� �̸� 5�� ������ �� �����
 */

// PersonComparable Ŭ����: TreeSet�� ���ҷ� �����ϱ� ���� Person Ŭ������ ���� Ŭ����
//  - TreeSet�� ���ҷ� �����ϱ� ���ؼ��� �ݵ�� Comparable �������̽� �����ؾ� �ϹǷ�
//    �� Ŭ������ << class PersonComparable implements Comparable<PersonComparable> >>�� ���ǵ�
//  - �ʵ� name, age, currentLocation, �޼ҵ� goTo(), output()�� ���� Ŭ����
class PersonComparable extends Person implements Comparable<PersonComparable> {

	// �̸�, ����, ��Ұ� �־����� �ʵ忡 �����ϴ� ��ü ������
	//   ���� Ŭ������ ��ü ������ Person(String name, int age) ȣ��
	PersonComparable(String name, int age) {
		super(name, age);
	}
	
	// java.lang.Comparable Ŭ������ �߻� �޼ҵ� compareTo()�� �����ϴ� �޼ҵ� 
	//  name �ʵ��� ������ ������ ������ �����ϱ� ����
	//  this�� �Ű����� p�� name ũ�� ���Ͽ� ũ�� ���, ������ 0, ������ ���� ��ȯ
	public int compareTo(PersonComparable p) {  
		return this.name.compareTo(p.name);  
	}
}

class Ex11_3_4_StorePersonsSorted_UsingTreeSet {  
	public static void main(String[] args) {   
		// PersonComparable ��ü�� ���ҷ� ������ TreeSet ��ü �����Ͽ�  persons�� �����ϰ� �� 
		TreeSet<PersonComparable> persons = new TreeSet<PersonComparable>(); 

		// 5���� PersonComparable ��ü�� persons�� ���� 
		persons.add( new PersonComparable("ȫ�浿", 18));
		persons.add( new PersonComparable("�ڹ���", 23));
		persons.add( new PersonComparable("�̸���", 16));
		persons.add( new PersonComparable("������", 14));
		persons.add( new PersonComparable("��û", 20));

		System.out.print("\n  ** TreeSet�� ��� ���� ����ϱ� **\n\n  * "); 

		for (PersonComparable p : persons)      // persons�� �� ������ p�� ����
			System.out.print("[ " + p + " ] "); //   p ��� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) PersonComparableŬ������ compareTo() �޼ҵ��� ��ȯ��  
 *      << return this.name.compareTo(p.name); >>�� ���� 
 *      ���� ������ �����ǹǷ� name �ʵ��� ũ������� TreeSet���� ���ĵȴ�.
 *      
 *   2) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
 *      
 *   3) 2���� PersonComparable ��ü�� persons�� �߰��Ͽ� �����ϵ��� ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   4) ��µ� ����� �� ���캸�� TreeSet�� ����Ǵ� ������ ���� ���� �̸������� ���ĵǾ� ��µ��� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 *   
 *   1) PersonComparable ��ü�� compareTo() �޼ҵ忡 ���� �̸��� ������ ������ ��ü�� �����Ѵ�.
 *      �̸��� ������ ������ ��ü�� �����ϵ���  int compareTo(Comparable p) �޼ҵ带  
 *      ������ ���� �����ϰ� �����  Ȯ���϶�.  
 *      
 *         return p.name.compareTo(this.name);
 *      
 *   
 *   2) PersonComparable ��ü�� compareTo() �޼ҵ�� �̸��� ũ�⸦ ���Ͽ� ����� ��ȯ�ϹǷ� 
 *      TreeSet�� ����Ǵ� ������ �̸� ũ�� ���� �ȴ�.
 *      
 *      TreeSet�� ����Ǵ� ������ ���� ������ �ϱ� ���ؼ� int compareTo(Comparable p) �޼ҵ带  
 *      ������ ���� �����ϰ� �����  Ȯ���϶�.  
 *      
 *         return this.age - p.age;  // this�� �Ű����� p�� age �ʵ��� ũ�⸦ ���Ͽ� ũ�� ���, ������ 0, ������ ������ ��ȯ
 *      
 *      �̷��� �����ϸ� ���� ������ ����� ��µȴ�.
 */