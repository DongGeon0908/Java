package ex10_2_java_lang_package;

import java.util.Vector;  // java.util.Vector Ŭ������ ����ϱ� ���� import

/** 
 * [ AutoBoxingAutoUnboxing Ŭ���� ]: �ڵ� �ڽ̰� �ڵ� ��ڽ�
 * 
 *   o �ڵ� �ڽ̰� �ڵ� ��ڽ�
 *     - �ڽ� �۾��� ��ڽ� �۾��� ������ �۾������� ���α׷��� ���������� �ټ� ���ŷο� �۾���
 *     - �ڵ� �ڽ�: �ڽ��� ���� �ʰ� �⺻ Ÿ���� ���� Wrapper Ŭ������ ���������� �ٷ� ����
 *     - �ڵ� ��ڽ�: ��ڽ��� ���� �ʰ� Wrapper Ŭ������ ��ü�� �ܼ������� �ٷ� ����
 *     - Java �����Ϸ��� �ڽ̰� ��ڽ��� �ʿ��� ��츦 �˻��Ͽ� �ڵ������� �ڽ̰� ��ڽ��� ����
 *     
 *   o �ڵ� �ڽ� ��
 *     - �ڽ��� ���� �ʰ� ���� 23�� Integer Ŭ������ �������� ageInt�� ����
 *         Integer ageInt = 23;  // �ڵ� �ڽ�: ���� 23�� Integer Ŭ������ ��ü �������� ageInt�� ����
 *         
 *     - Java �����Ϸ��� �� ������ �����Ͽ� �ڽ��� �ʿ��� �۾����� Ȯ���� �� 
 *       ������ ���� �ڽ��� ���ԵǴ� �������� �����Ͽ� ������
 *         Integer ageInt = Integer.valueOf(23);  // 23 �����ϴ� Integer Ŭ���� ��ü �����Ͽ� ageInt�� ����
 *        
 *   o �ڵ� ��ڽ��� ��
 *     - Integer Ŭ������ ��ü�� �⺻ Ÿ���� ������ �ٷ� ����
 *         int age = ageInt;      // �ڵ� ��ڽ�: Wrapper Ŭ������ ��ü ageInt�� int ����  age�� �ٷ� ����
 *         
 *     - Java �����Ϸ��� �� ������ �����Ͽ� ��ڽ��� �ʿ��� �۾����� Ȯ���� �� 
 *       ������ ���� ��ڽ��� ���ԵǴ� �������� �����Ͽ� ������
 *         int age = ageInt.intValue();  // Integer ��ü�� ����� ���� �� ������ age�� ����
 *         
 *   o �ڵ� �ڽ̰� �ڵ� ��ڽ��� ����
 *     - �ڵ� �ڽ̰� �ڵ� ��ڽ��� Java���� �⺻ Ÿ���� ���� Wrapper ��ü ������ ���̸� ���ֹǷ� 
 *       ���α׷��� ���� �����ϰ� �ۼ��� �� �ִ� ������ ����
 *       
 *     - �ڵ� �ڽ̰� �ڵ� ��ڽ��� ������ �÷���(Collection) Ŭ������ �̿��Ͽ� ���� �����͸� �ٷ� �� ��Ȯ�� �巯��
 *       (�÷��� Ŭ������ ���� �����͸� ���ϰ� �����ϰ� �����ϱ� ���� Ŭ������μ�, 
 *        Java������ java.util ��Ű���� Vector, ArrayList, HashTable, Stack �� ���� Ŭ������ ������)
 */

class Ex10_2_5_AutoBoxingAutoUnboxing {
	public static void main(String[] args) {
		// ���� ���ҵ��� �����ϴ� ���� ��ü �����Ͽ� scores�� ����
		Vector<Integer> scores = new Vector<Integer>();  // Vector Ŭ���� ��ü ���� �� ���� 

		for (int i = 0; i < 10; i++) {
			int score = (int) (Math.random() * 101); // 0�� 100 ���� ���� �����Ͽ� 
			scores.add(score);                       // ���� score�� scores ���Ϳ� ����: �ڵ� �ڽ�
		}

		System.out.print("\n  * ������ ���� 10�� ����: "); 
		for (int i = 0; i < scores.size(); i++) {    // scores ���Ϳ��� 
			int score = scores.get(i);               //   Integer ���ҵ��� ������ score�� ����: �ڵ� ��ڽ�
			System.out.print(score + " ");           //   score ���
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) Vector ��ü�� Integer ��ü�� �����ϰ� ������� �޼ҵ��� add() �޼ҵ�� get() �޼ҵ��� �ñ״��Ŀ� ����� ������ ����.
 *      - public boolean add(Integer i): Integer ��ü i�� Vector�� ����
 *      - public Integer get(int index): Vector�� ����� Integer ��ü�� ��ȯ
 *      
 *   2) �� �������� add() �޼ҵ��� �ǸŰ������� Integer ��ü������ �������� score�� �ǸŰ������� ���Ǿ���, 
 *      Vector ��ü���� ���� ������ ���� get() �޼ҵ��� ��ȯ���� Integer ��ü�� �ٷ� int ������ ����Ǿ���. 
 *      - �̴� ��� �ڵ� �ڽ̰� �ڵ� ��ڽ��� �����Ǳ� ������ ����
 *      
 *   3) �ڵ� �ڽ̰� ��ڽ��� �̿����� �ʰ� ���� �ڽ̰� ��ڽ��� ������ ���  <<scores.add(score);>>������ �޼ҵ� ȣ��� 
 *      <<int score = scores.get(i);>>������ �޼ҵ� ȣ���� ������ ���� ����Ǿ�� �Ѵ�.
 *      
 *      - scores.add(Integer.valueOf(score));    // ������ score�� Wrapper ��ü�� �ڽ�
 *      - int score = scores.get(i).intValue();  // Wrapper ��ü scores.get(i)�� ��ڽ�
 *  
 *   4) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.   
 */
