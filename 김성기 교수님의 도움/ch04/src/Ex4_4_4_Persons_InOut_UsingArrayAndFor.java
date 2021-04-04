/**
 * [ Persons_InOut_UsingArrayAndFor]: �Ż������� �Է��� �� ���� �� ���(�迭�� For ���� �̿�)
 * 
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) �迭���� ����, for ���� �̿��Ͽ� �����ϰ� �Է�, ����, ���� ���
 *               
 *   o ������Ʈ �޽��� ��� �� Ÿ�Ժ��� ���� �Է��ϴ� �޼ҵ��� SkScanner.getXxxWithPrompt() 
 *     - SkScanner.getStringWithPrompt(���ڿ��޽���):  �޽��� ��� �� ���ڿ� �Է�
 *     - SkScanner.getIntWithPrompt(���ڿ��޽���):     �޽��� ��� �� ���� �Է�
 *     - SkScanner.getDoubleWithPrompt(���ڿ��޽���):  �޽��� ��� �� �Ǽ� �Է�
 *     - SkScanner.getBooleanWithPrompt(���ڿ��޽���): �޽��� ��� �� boolean �Է�         
 */ 

class Ex4_4_4_Persons_InOut_UsingArrayAndFor {

	public static void main(String[] args) {
		int noPersons = 3;

		//  �Ż����� �׸�(�̸�, ����, ����ġ)���� �����ϱ� ���� �迭���� ����
		String[] names = new String[noPersons]; // noPersons ���� �̸� ������ ���ڿ� �迭���� 
		int[] ages = new int[noPersons];        // noPersons ����  ���� ������ ���� �迭���� 
		String[] currentLocations = new String[noPersons];  // ����ġ ������ ���ڿ� �迭����

		// �Է��� ���� Ÿ��Ʋ ���
		System.out.println("\n  **  " + noPersons + "���� �Ż����� �Է� **");  

		for (int i = 0; i < noPersons; i++) {
			// �Ż����� �׸� ���� �Է��Ͽ� �迭�������� �ε��� i ��ġ�� ���� ����
			names[i] = SkScanner.getStringWithPrompt("\n  o " + ( i + 1) + "��° �̸� > ");   
			ages[i] = SkScanner.getIntWithPrompt("                 ���� > ");                      
			currentLocations[i] = SkScanner.getStringWithPrompt("                 ����ġ > ");     
		}

		// ����� ���� Ÿ��Ʋ ���
		System.out.println("\n  **  �Էµ� " + noPersons + "���� �Ż����� **\n");  

		for (int i = 0; i < noPersons; i++) {
			System.out.println("  * " + (i + 1) + "��° " + names[i] + "�� ���̴� " + ages[i] 
					+ "���̰� " + currentLocations[i]  + "�� ���� ");
		}		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *   
 *      - Persons_InOut_UsingArrayFor Ŭ������ ����Ǿ� ������, Ŭ���� ���ο� 
 *        main() �޼ҵ尡 �ۼ��Ǿ� �ִ�. 
 *      
 *      - main() �޼ҵ�� �迭���� ���� �� �迭 ��ü ����, for ������ �̿��Ͽ� 
 *        �Է��� �Ż����� �׸��� �迭 ���ҿ� ����, �迭 ������ ��� ���� �����Ѵ�.
 *      
 *      - Ư�� ������Ʈ �޽��� ��� �� Ÿ�Ժ��� ���� �Է��ϴ� �޼ҵ��� 
 *        SkScanner.getXxxWithPrompt()�� ����Ͽ� �Է¿� �ʿ��� ������ �ϳ��� ���δ�. 
 *       
 *   2) ���α׷��� �����Ͽ� �׸��� �Է��ϰ� ����� Ȯ���϶�.
 *     
 *   
 * [ �ǽ����� ]
 *
 *   o ��� 5���� �Ż������� �����ϰ� ����� �� �ֵ��� ���α׷��� �����϶�.
 *     
 *     �� �ۼ��� ���α׷��� �䱸���� ���� �� ���� ���α׷��� ������ �� �ִ� ���α׷��̴�.
 *     �׷��� �������� �� ���α׷��� ���� �� �ۼ��� ���α׷��̴�.               
 */
