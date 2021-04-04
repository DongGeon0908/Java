/**
 * [ Operation_Logical ]: �� ������ ����
 *   
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) boolean ���� ���� �� ������ �����Ͽ� ��� �� ���
 *       
 *   o �� ������ boolean ���� ���� &&, ||, !�� ����
 */

class Ex3_1_03_Operation_Logical  {
	public static void main(String[] args)  {

		boolean isKorean = true;
		boolean isMale = false;

		System.out.println("\n  ** boolean ���� ���� �� ����(&&, ||, !) **\n");
		
		System.out.println("  * ���� �ʱⰪ: isKorean := " + isKorean);
		System.out.println("  * ���� �ʱⰪ: isMale   := " + isMale);
		System.out.println();
		
		System.out.println("  * isKorean && isMale  := " + ( isKorean + " && " + isMale) 
				                                         + " := " + ( isKorean && isMale	)); //  ��  true  && false	 ��  false		
		System.out.println("  * isKorean || isMale  := " + ( isKorean + " || " +  isMale)
				                                         + " := " + ( isKorean || isMale));     //  ��  true  || false	 ��  true 
		System.out.println();

		System.out.println("  * ! isKorean := " + ( "! " +  isKorean	) + "  := "  + ( ! isKorean	));  //   �� ! true  ��  false		
		System.out.println("  * ! isMale   := " + ( "! " +  isMale	) + " := "  + ( ! isMale )); 	     //   ��  ! false ��  true	
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *  
 */
