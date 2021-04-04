package ex10_1_class_reference;

/**
 * [ CalendarUsingFullyQualifiedName Ŭ���� ]: 
 *       ����ȭ�� �̸�(fully qualified name)���� Ŭ���� ������ ���� ������ ���̴� ����
 * 
 *   o ��Ű���� ���ԵǴ� Ŭ���� �����ϱ�
 *     1) ����ȭ�� �̸����� ��Ű�� ��� ����: ��Ű�� ����� << ��Ű���̸�.Ŭ�����̸� >>�� ���� ��Ű�� �̸��� Ŭ���� �̸��� 
 *        ��Ʈ�� �����Ų ����ȭ�� �̸�(fully qualified name)���� ǥ���Ͽ� ����
 *     2) ��Ű�� ��� import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ����ȭ�� �̸����� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *     3) ��Ű�� ��ü import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ���Ե� ��Ű�� ��ü�� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *        
 *   o ����ȭ�� �̸����� ��Ű�� ��� ����    
 *     - Ŭ������ ������ ������ ��Ű���̸�.Ŭ�����̸� �������� Ŭ���� ǥ��
 *     - java.util ��Ű���� Date Ŭ���� ==> java.util.Date
 *     - java.util ��Ű���� Calendar Ŭ���� ==> java.util.Calendar   
 *    
 *     - ����ȭ�� �̸��� ����ϸ� ���� Ŭ������  ��Ű���� Ŭ���� ��ü�� import�� �ʿ䰡 ����    
 *    
 *     - �� ��Ű�� ����� ���� �� �����Ǹ� ����ȭ�� �̸��� �ݺ������� ���ǹǷ� 
 *       ���α׷� �ۼ��� ���ŷӰ� �������� ����    
 *    
 *   o Date�� Calendar Ŭ���� �̿��Ͽ� ���� ��¥�� �ð� ���
 *     - java.util ��Ű���� Date Ŭ������ Calendar Ŭ������ ��¥�� �ð� �ٷ�� ���� Ŭ����
 *     - ��¥�� �ð� �ٷ�� ���� Calendar Ŭ������ Date Ŭ�������� �� ���� �޼ҵ� ����
 *     - �ֱٿ��� Date Ŭ������ ������� ���� �߼�
 */

class Ex10_1_2_Calendar_UsingFullyQualifiedName  {  
	public static void main(String[] args) {

		// Calendar Ŭ������ java.util�� �����
		// Calendar Ŭ������ ��ü�� getInstance() �޼ҵ带 �̿��Ͽ� ������
		java.util.Calendar now = java.util.Calendar.getInstance();  // Calendar ��ü �����Ͽ� now�� ����

		System.out.println("\n  * ���� ��¥�� �ð�: "
				+ now.get(java.util.Calendar.YEAR) + "�� " 
				+ (now.get(java.util.Calendar.MONTH) + 1) + "�� " // ����� ���� ���� ������ 1 ���� ����
				+ now.get(java.util.Calendar.DATE) + "�� " 
				+ now.get(java.util.Calendar.HOUR_OF_DAY) + "�� " 
				+ now.get(java.util.Calendar.MINUTE) + "�� "
				+ now.get(java.util.Calendar.SECOND) + "�� " );
	}
}


/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Calendar ��ü�� �����Ͽ� now�� ������ �� now�� �⵵, ��, ��, ��, ��, �ʸ� ����Ѵ�.
 *   
 *      o java.util.Calendar�� Calendar Ŭ������ java.util ��Ű���� Ŭ�������� ��Ÿ���� ����ȭ�� �̸� 
 *      
 *      o << java.util.Calendar.getInstance(); >>������ Calendar Ŭ������ ��ü�� �����ϰ� 
 *         ���� ��¥�� �ð��� ��ü ���ο� ����
 *         
 *      o << java.util.Calendar now = java.util.Calendar.getInstance(); >>������ 
 *         ������ Calendar Ŭ������ ��ü�� ��ü �������� now�� ����
 *         
 *   2) System.out.println() �޼ҵ忡�� Calendar ��ü ���� 
 *      ����� �⵵, ��, ��, ��, ��, �ʸ� get() �޼ҵ�� ���Ͽ� ����Ѵ�.
 *      
 *   3) Calendar Ŭ������ ��� 8�� �����Ǿ� java.util.Calendar�� �ݺ������� ǥ�õǾ�����. 
 *      �� ��� ���α׷��� �������� ����
 *      
 *      ==> ���� 10-1-3���� import ���� �̿��Ͽ� Ŭ������ ��Ű�� �̸��� ������ �� �ְ� ��
 *      
  *  4) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.
 *      ������ ������ ��, ��, �ʰ� ��ȭ���� �ݵ�� Ȯ���϶�. 
 *      
 *   
 * [ �ǽ� ���� ]
 * 
 *   1) ���ѹα��� ������ ��¥�� �ð��� 1945�� 8�� 15�� ���� 12�� 0�� 0�ʸ� �����ϰ� �̸� ����Ϸ� �Ѵ�.
 *   
 *      o Calendar Ŭ������ ��ü�� ��¥�� �ð��� �����ϱ� ���� �޼ҵ�� set()
 *      
 *        - ������ set() �޼ҵ��  Calendar ��ü  now�� ���� ���� 8�� 15�� ����     
 *           now.set(java.util.Calendar.MONTH, 8-1); // ���� ���� ������ 1 ���� ���� ����
 *           now.set(java.util.Calendar.DATE, 15);   // ���� ���� ���� ���� ����
 *        
 *        - ��, �ϻ� �ƴ϶� ��, ��, ��, �ʵ� set() �޼ҵ带 �̿��Ͽ� ���� ����
 *      
 *      o Calendar Ŭ������ ��ü���� ��¥�� �ð��� �������� ���� �޼ҵ�� get()
 *      
 *        - ������ get() �޼ҵ��  Calendar ��ü  now�� ����� ���� ���� ������
 *           int month = now.get(java.util.Calendar.MONTH); // ���� ���� ������ 1 ���� ���� ����Ǿ� ����
 *           int date = now.get(java.util.Calendar.DATE);   // ���� ���� ���� ���� ����
 *                  
 *        -  ��, �ϻ� �ƴ϶� ��, ��, ��, �ʵ� get() �޼ҵ带 �̿��Ͽ� ������ �� ����
 *      
 *      (1) ������ ��¥�� �ð��� �����ϱ� ���� Calendar ��ü�� �����ϰ� 
 *         �̸� Calendar ��ü�������� independenceDate�� �����϶�.
 *          
 *      (2) independenceDate�� ���� ��¥�� ���� �ð��� ������ �� �̸� ����ϴ� �ڵ带 �߰��� �ۼ��϶�. 
 *      
 *     
 *   2) java.util ��Ű������ ����(random number)�� ������ �� �ִ� Random Ŭ������  �ִ�.
 *   
 *      Random Ŭ������ Random()�� ��ü �������̸�, ��ü �޼ҵ� double nextDouble()�� 
 *      0�� 1 ������ �Ǽ� ������ ��ȯ�ϴ� �޼ҵ��̴�.
 *       
 *      (1) Random Ŭ������ ��ü�� �����Ͽ� ��ü�������� rd�� �����ϴ� ������ �ۼ��϶�.
 *        
 *      (2) for ���� �̿��Ͽ� rd ��ü���� 20���� 0�� 1 ������ ������ �����Ͽ� ����ϴ� �ڵ带 �ۼ��϶�.      
 */