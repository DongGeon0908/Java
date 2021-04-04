package ex10_2_java_lang_package;

/** 
 * [ StringMethods Ŭ���� ]: ���ڿ� ������ ���ڿ� ó�� �޼ҵ��
 * 
 *   o String Ŭ����
 *     - ���ڿ� ��, ���ڿ������� ���� �˻�, ���ڿ� �κ� Ž��, ���ڿ� �κ� ����, ��ҹ��� ��ȯ, 
 *       ���ڿ� ���� ���� ����  �پ��� �޼ҵ� ����
 *     - ���� ���ڿ� ������ ���� �������� + ������ ����
 *     - Ư�� �ٸ� ��� Ŭ������ ��ü���� ���ڿ��� ��ȯ�� �� �ֵ��� toString() �޼ҵ尡 Object Ŭ������ ����

 *   o �߿� �޼ҵ��
 *     - equals(): �� ���ڿ��� ������ true, �ƴϸ� false ��ȯ
 *     - compareTo(): �� ���ڿ� �� ������ ũ�� ���, ������ 0, ������ ���� ��ȯ
 *     - length(): ���ڿ� ���� ��ȯ
 *     - charAt(), startsWith(), substring() �޼ҵ嵵 ����ϰ� ���Ǵ� �޼ҵ���
 */

class Ex10_2_6_StringMethods {  
	public static void main(String[] args) {

		String s = "Java";
		String s1 = new String("Java");

		byte[] b = { 'J', 'a', 'v', 'a' };
		String s2 = new String(b);

		char[] c = { 'J', 'a', 'v', 'a' };
		String s3 = new String(c);   

		char[] c1 = { 'A', 'J', 'a', 'v', 'a' };
		String s4 = new String(c1, 1, 4);  // c1�� �ε��� 1 ��ġ 4 ���ڸ� ���ڿ���

		System.out.println(" * s = \"" + s + "\"");  
		System.out.println(" * s1 = \"" + s1 + "\"");  
		System.out.println(" * s2 = \"" + s2 + "\"");  
		System.out.println(" * s3 = \"" + s3 + "\"");  
		System.out.println(" * s4 = \"" + s4 + "\"");
		System.out.println();
		
		System.out.println(" * s1.toString() = \"" + s1.toString() + "\"");       
		System.out.println();
		
		System.out.println(" * s1.equals(s1) = " + s1.equals(s1) );  
		System.out.println(" * s1.equals(s2) = " + s1.equals(s2) );  
		System.out.println(" * s1.equals(\"C\") = " + s1.equals("C") );  
		System.out.println();
		
		System.out.println(" * \"ȫ�浿\".length() = " + "ȫ�浿".length() ); 
		System.out.println(" * s1.length() = " + s1.length() );  
		System.out.println();
		
		System.out.println(" * s1.charAt(2) = " + s1.charAt(2) );  
		System.out.println();
		
		System.out.println(" * s1.compareTo(s2) = " + s1.compareTo(s2) );  
		System.out.println(" * s1.compareTo(\"Java\") = " + s1.compareTo("Java") );  
		System.out.println(" * s1.compareTo(\"C\") = " + s1.compareTo("C") );  
		System.out.println();
		
		System.out.println(" * s1.concat(\" and C\") = " + s1.concat(" and C") );  
		System.out.println();
		
		System.out.println(" * s1.indexOf('v') = " + s1.indexOf('v') );  
		System.out.println(" * s1.indexOf('b') = " + s1.indexOf('b') );  

		System.out.println(" * s1.startsWith(\"Ja\") = " + s1.startsWith("Ja") );  
		System.out.println(" * s1.startsWith(\"ja\") = " + s1.startsWith("ja") );  

		System.out.println(" * s1.substring(1) = " + s1.substring(1) );  
		System.out.println(" * s1.substring(2) = " + s1.substring(2) );  
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���ڿ��� �����ϴ� ����� ���� ���ڿ� �޼ҵ� ȣ���� �����ش�.
 *   
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.   
 */
