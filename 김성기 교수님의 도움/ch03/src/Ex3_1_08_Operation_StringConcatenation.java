/**
 * [ Operation_StringConcatenation ]: ���ڿ� ���� ������ ����
 *   
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���ڿ� ���� ������ �����Ͽ� ��� �� ���
 *       
 *   o ���ڿ� ���� ���� + 
 *     - �� ���ڿ��� �ϳ��� ���ڿ��� ����
 *     - �ǿ����� �� �ϳ��� ���ڿ��̾ �ٸ� ���� ���ڿ��� ��ȯ�Ͽ� ���ӽ�Ų ���ڿ� ����
 */

class Ex3_1_08_Operation_StringConcatenation  {
	public static void main(String[] args)  {
		
		String name = "ȫ�浿"; 
		int age = 18;
		double height = 177.7;
		boolean isKorean = true;

		System.out.println("\n  ** ���ڿ� ���� ����(+) **\n");

		System.out.println("  * ���� �ʱⰪ: name = " + name + ", age = " + age + ", height = " + height + ", isKorean = " + isKorean); 
		System.out.println();

		System.out.println("  * \"ȫ\" + \"�浿\"     := " + ( "ȫ" + "�浿" ));  // ���ڿ� ����� ���ڿ� ����� ����
		System.out.println("  * \"�̸��� \" + name   := " + ( "�̸��� " + name ));  // ���ڿ� ����� ���ڿ� ������ ����
		
		System.out.println("  * \"���̴� \" + age    := " + ( "���̴� " + age ));   // ���ڿ��� ���� ����: ������ ���ڿ��� ��ȯ�� �� ���ӵ�	
		System.out.println("  * height + \"�� Ű\"  := " + ( height + "�� Ű" )); // �Ǽ��� ���ڿ��� ����: �Ǽ��� ���ڿ��� ��ȯ�� �� ���ӵ� 	
		System.out.println();
		
		System.out.println("  * age + height        := " + ( age + height ));  	      // ������ �Ǽ��� + �ϸ� ���ڿ� ������ �ƴ�
		System.out.println("  * \" \" + age + height  := " + ( " " + age + height )); // ���ڿ��� ���� �����ϰ� ������ �Ǽ��� + �ϸ� ���ڿ� ������ ��	
		System.out.println();			

		// ���ڿ��� boolean �� ����: boolean ���� ���ڿ��� ��ȯ�� �� ���ӵ�
		System.out.println("  * \"�ѱ��� ���δ� \" + isKorean  := " + ( "�ѱ��� ���δ� " + isKorean ));  	
		System.out.println();			
}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */
