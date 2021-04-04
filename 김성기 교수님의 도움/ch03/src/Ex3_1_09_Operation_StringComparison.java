/**
 * [ Operation_StringComparison ]: ���ڿ� ���� ����
 *     
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���ڿ� �� ������ �����Ͽ� ��� �� ���
 *      
 *   o ���ڿ� �� ������ ���� ���� == �̸�, �̴� equals() �޼ҵ�� ��������� �ٸ�
 *     - == ����: ��ü ��ü�� ������ ��ü�ΰ��� �˻�
 *     - equals() �޼ҵ�: ��ü ���� ����� ���ڿ��� ���� ���ڿ��ΰ��� �˻�
 *     - ���ڿ� �񱳿����� equals() �޼ҵ� ����ϴ� ���� ����
 *     
 *   o �� �� �񱳴� compareTo() �޼ҵ带 �̿���
 */

class Ex3_1_09_Operation_StringComparison  {
	public static void main(String[] args)  {

		String name = "ȫ�浿"; 
		
		System.out.println("\n  ** ���ڿ� ���� �� ����(==) �� equals(), compareTo() �޼ҵ� **\n");

		System.out.println("  * ���� �ʱⰪ: name = " + name); 
		System.out.println(); 

		// ���ڿ� ����� ���ڿ� ����� ���� ��
		System.out.println("  * \"ȫ�浿\" == \"ȫ�浿\"      := " + ( "ȫ�浿" == "ȫ�浿" )); 
		System.out.println("  * \"ȫ�浿\".equals(\"ȫ�浿\") := " + ( "ȫ�浿".equals("ȫ�浿") )); 
		System.out.println(); 
		
		// ���ڿ� ������ ���ڿ� ����� ����  ��
		System.out.println("  * name == \"ȫ�浿\"      := " + ( name == "ȫ�浿" )); 
		System.out.println("  * name.equals(\"ȫ�浿\") := " + ( name.equals("ȫ" + "�浿") )); 
		System.out.println(); 

		// ���ڿ� ������ ���ڿ� ����� ���� ��
		System.out.println("  * name == \"ȫ�漭\"      := " + ( name == "ȫ�漭" )); 
		System.out.println("  * name.equals(\"ȫ�漭\") := " + ( name.equals("ȫ�漭") )); 
		System.out.println(); 

		// ���ڿ� ���� ������ ũ�� ��
		System.out.println("  * \"ȫ�浿\".compareTo(\"ȫ�浿\") := " + ( "ȫ�浿".compareTo("ȫ�浿") )); // ũ�Ⱑ �����Ƿ� 0
		System.out.println("  * \"ȫ�浿\".compareTo(\"ȫ�漭\") := " + ( "ȫ�浿".compareTo("ȫ�漭") )); // "ȫ�浿"�� "ȫ�漭"���� �����Ƿ� ����
		System.out.println("  * name.compareTo(\"ȫ�泲\")    := " + ( name.compareTo("ȫ�泲") ));  // "ȫ�浿"�� "ȫ�泲"���� ũ�Ƿ� ���
		System.out.println(); 

		System.out.println("  * \"Java\".compareTo(\"C\"))        := " + ( "Java".compareTo("C") )); // "Java"�� "C"���� ũ�Ƿ� ���
		System.out.println("  * \"JDK1.7\".compareTo(\"JDK1.8\")) := " + ( "JDK1.7".compareTo("JDK1.8") )); // "JDK1.7"�� "JDK1.8"���� �����Ƿ� ����

	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   
 * [ ������� ]
 *  
 *   o ���ڿ� ����� ��ü ���� ���� ���� �ٷ� �� �ִ� ������ ������  Java���� ���ڿ� ����� 
 *     new String()�� ���� ������ ���ڿ� ��ü�� �ٸ��� �����ǹǷ� ���Ǹ� ���Ѵ�.
 *     
 *     - ���� ���, ���ڿ� ����� ���ڿ� ��ü�� ������ ���� == �����ڷ� ���ϸ� �̴� ���� �ٸ� ��ü�̹Ƿ� false�̴�.
 *        "ȫ�浿" == new String("ȫ�浿") ==> false      // ���ڿ� ����� new�� ���� ������ ���ڿ� ��ü�� �ٸ� ��ü
 *        
 *     - ���ڿ� ����� ���ڿ� ��ü�� ������ ���� equals() �޼ҵ�� ���ϸ� �̴� ���� ������ ������ ���ڿ��̹Ƿ� true�̴�.
 *        "ȫ�浿".equals(new String("ȫ�浿")) ==> true  // equals(_)�޼ҵ�� ���ڿ� ������ �����ϸ� true
 *        
 *     - �׷��Ƿ� ���ڿ��� ���� ������ == �����ں��� equals() �޼ҵ带 ����ϴ� ���� ����.   
 */
