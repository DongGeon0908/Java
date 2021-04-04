package ex10_2_java_lang_package;

import java.lang.*;  // java.lang ��Ű���� ��� ��ü�� import, �����ص� ��

/**
 * [ Ex10_2_1_ObjectMgmt Ŭ����]: Object Ŭ������ ���� �޼ҵ� Ȱ���ϱ�
 *  
 *   o Object Ŭ����
 *     - ��� Ŭ������ ���� Ŭ������ �Ǵ� �ֻ��� Ŭ����
 *     
 *     - Object Ŭ�������� ��� ��ü���� �ʿ��� �޼ҵ��� 
 *       toString(), hashCode(), equals(), getClass() ���� �޼ҵ���� ���ǵǾ� ����
 *     - Object Ŭ������ �޼ҵ��  ��� Ŭ������ ���
 *     - ��� Ŭ������ ��ü�� Object Ŭ������ �޼ҵ� ȣ�� ����
 *     
 *     - �޼ҵ� toString(), equals()�� ���� Ŭ�������� �������̵��ϵ��� ����
 */

class Ex10_2_1_ObjectMgmt {  
	public static void main(String[] args) {

		Object obj = new Object(); // Object() ��ü �����Ͽ� obj�� ����

		System.out.println("\n  * obj = " + obj );  // obj ���
		System.out.println("  * obj.toString() = " + obj.toString() );     

		System.out.println("  * obj.getClass() = " + obj.getClass() );  
		System.out.println("  * obj.hashCode() = " + obj.hashCode() );  

		System.out.println("  * obj.equals(obj) = " + obj.equals(obj) );  

		Object s ="ȫ�浿";  // ���ڿ� "ȫ�浿"�� ��ĳ�����Ͽ�  Object ��ü �������� s�� ����
		System.out.println("\n  * s.toString() = " + s.toString() );     

		System.out.println("  * s.getClass() = " + s.getClass() );  
		System.out.println("  * s.hashCode() = " + s.hashCode() );  

		System.out.println("  * s.equals(\"ȫ�浿1\") = " + s.equals("ȫ�浿1") );
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� Object Ŭ���� ��ü�� String Ŭ���� ��ü�� Object Ŭ������ 
 *      ��ü ���������� �����ϰ� Object Ŭ������ �޼ҵ带 ȣ���Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.   
 *           
 *   3) Object ��ü�� toString() ��ȯ���� String ��ü�� toString() ��ȯ���� �ٸ� ����
 *      Ȯ���ϰ� �� ������ ���������� �����غ���.    
 *      
 * [ �ǽ� ���� ]
 * 
 *   1) ������ ��Ű���� Ŭ������ ���ǵǾ� �ִ�. �� Ŭ������ ��ü�� �����ϰ� 
 *      �̸� Object Ŭ������ ��ü ���������� �����ϰ� Object Ŭ������ �޼ҵ带 ȣ���ϰ� �� ����� Ȯ���϶�.
 *      (��ü �������� ��� �Ű����� ���� ��ü ������ �̿�)
 *       
 *     (1) java.util ��Ű���� Vector Ŭ����
 *     (2) java.awt ��Ű���� Button Ŭ����
 *     (3) java.text ��Ű���� SimpleDateFormat Ŭ����
 *     
 *   2) Person Ŭ������ ��ü�� �����ϰ� �̸� Object Ŭ������ ��ü ���������� �����ϰ� 
 *      Object Ŭ������ �޼ҵ带 ȣ���ϰ� �� ����� Ȯ���϶�.
 *      
 *      Person Ŭ������ ����ϱ� ���� Person Ŭ������ �� ��Ű���� Ŭ������ �����Ͽ��� �Ѵ�.        
 */