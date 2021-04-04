package ex10_1_class_reference;

/**
 * [ DateCalendarUsingImportAllPackageMembers Ŭ���� ]: 
 *        ��Ű�� ��� ��ü import�ϰ� Ŭ���� �̸����� ����
 * 
 *   o ��Ű���� ���ԵǴ� Ŭ���� �����ϱ�
 *     1) ����ȭ�� �̸����� ��Ű�� ��� ����: ��Ű�� ����� << ��Ű���̸�.Ŭ�����̸� >>�� ���� 
 *        ��Ű�� �̸��� Ŭ���� �̸��� ��Ʈ�� �����Ų ����ȭ�� �̸����� ǥ���Ͽ� ����
 *     2) ��Ű�� ��� import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ����ȭ�� �̸����� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *     3) ��Ű�� ��ü import�ϰ� Ŭ���� �̸����� ����: ��Ű�� ����� ���Ե� ��Ű�� ��ü�� import�ϰ� 
 *        Ŭ���� �̸��� ǥ���Ͽ� ����
 *        
 *   o ��Ű�� ��ü import�ϰ� Ŭ���� �̸����� �����ϱ�
 *     - << import ��Ű��.*; >>�� import�ϸ� 
 *       �� ��Ű���� ��� ����� Ŭ���� �̸������� ��� ����
 *       
 *     - Date Ŭ������ Calendar Ŭ���� �����ϱ� ���� java.util ��Ű���� ��� ��� import
 *     - << import java.util.*; >>�� import�ϸ� 
 *       java.util ��Ű���� ��� Ŭ������ Ŭ���� �̸������� ���� ����
 *       
 *   o Date�� Calendar Ŭ���� �̿��Ͽ� ���� ��¥�� �ð� ���
 *     - java.util ��Ű���� Date Ŭ������ Calendar Ŭ������ ��¥�� �ð� �ٷ�� ���� Ŭ����
 *     - ��¥�� �ð� �ٷ�� ���� Calendar Ŭ������ Date Ŭ�������� �� ���� �޼ҵ� ����
 *     - �ֱٿ��� Date Ŭ������ ������� ���� �߼�
 */

import java.util.*;  // java.util ��Ű���� ��� Ŭ���� ��ü�� import

class Ex10_1_4_DateCalendar_UsingImportAllPackageMembers {  
   public static void main(String[] args) {

     // java.util.* import�����Ƿ� Ŭ���� �̸� Date������ ���� ������
     Date nowDate = new Date(); // Date() ��ü �����Ͽ� now�� ����
	
     System.out.println("\n  * ���� ��¥�� �ð�: " + nowDate);  // nowDate ���

     // java.util.* import�����Ƿ� Ŭ���� �̸� Calendar������ ���� ������
     Calendar nowCal = Calendar.getInstance();  // Calendar ��ü �����Ͽ� nowCal�� ����
	
     System.out.println("\n  * ���� ��¥�� �ð�: "
                          + nowCal.get(Calendar.YEAR) + "�� " 
                          + (nowCal.get(Calendar.MONTH) + 1) + "�� " 
                          + nowCal.get(Calendar.DATE) + "�� " 
                          + nowCal.get(Calendar.HOUR_OF_DAY) + "�� " 
                          + nowCal.get(Calendar.MINUTE) + "�� "
                          + nowCal.get(Calendar.SECOND) + "�� " );
  }
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Date ��ü�� Calendar ��ü�� �����Ͽ� ��ü ���������� ������ �� �⵵, ��, ��, ��, ��, �ʸ� ���
 *   
 *      o import ���� << import java.util.*; >>���� java.util ��Ű���� ��� Ŭ������ import�ǰ� ��
 *      
 *      o java.util ��Ű���� ������ ������ ��Ű�� �̸��� �����ص� ��
 *      
 *      o �� ���, ���α׷��� ���� �����ϰ� �ۼ���
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.
 *      ������ ������ ��, ��, �ʰ� ��ȭ���� �ݵ�� Ȯ���϶�.        
 *      
 *      
 * [ �ǽ� ���� ]
 * 
 *   1) java.util ��Ű������ ����(random number)�� ������ �� �ִ� Random Ŭ������  �ִ�.
 *   
 *      o Random()�� Random Ŭ������ ��ü �������̸�, ��ü �޼ҵ� double nextDouble()�� 
 *        0�� 1 ������ �Ǽ� ������ ��ȯ�ϴ� �޼ҵ��̴�.
 *       
 *      (1) Random Ŭ������ ��ü�� �����Ͽ� ��ü�������� rd�� �����ϴ� ������ �ۼ��϶�.
 *          �� ��  Random Ŭ������ import�ϴ� import ���� �����ص� ���� Ȯ���϶�.
 *        
 *      (2) for ���� �̿��Ͽ� rd ��ü���� 20���� 0�� 1 ������ ������ �����Ͽ� ����ϰ� 
 *          ����� ���Ͽ� ����ϴ� �ڵ带 �ۼ��϶�.      
 *      
 *   2) java.awt ��Ű������ ��ư�� ������ �� �ִ� Button Ŭ������  �ִ�.
 *   
 *      Button Ŭ������ Button(String label)�� �־��� ���ڿ��� ��ư ��ü�� ���̺�� �����ϴ� ��ü �������̸�, 
 *      ��ü �޼ҵ� String getLabel()�� ��ü ���� �� ����� ���̺��� ��ȯ�Ѵ�. 

 *              
 *      (1) 20���� Button ��ü�� ���ҷ� �����ϴ� �迭��ü�� �����Ͽ� �迭���� buttons�� �����϶�. 
 *          �� �� Button Ŭ������ import�ϴ� import ���� �����ϸ� ������ �߻����� Ȯ���϶�.
 *       
 *      (2) 20���� Button ��ü�� �����ϸ鼭 ���̺�� "Button-1", "Button-2" ���� ���ʷ� �����ϰ�, 
 *          ��ü�� �迭���� buttons�� ���ҷ� �����ϴ� �ڵ带 �ۼ��϶�.
 *          
 *      (3) �迭���� buttons�� ���ҵ鿡 ���� getLabel() �޼ҵ带 ȣ���Ͽ� ���̺���� ���ʷ� ����ϴ� 
 *          �ڵ带 �ۼ��϶�.   
 */