package practice11;

/**
 * [ 11�� �ǽ����� 6�� �ҽ� ���α׷� ]
 * 
 *   6. �迭 �̿��ϴ� ���α׷��� Vector �̿��ϴ� ���α׷����� ����
 *   
 *      ������ �迭�� �̿��ϴ� ���α׷��� Vector�� �̿��ϴ� ���α׷����� �����϶�.
 *      
 *      (�迭���� �ִ� ���� �������� ���� ���Ҹ� �����ϸ� ���ܰ� �߻��ϹǷ� ���� ó���ؾ� ������ 
 *       Vector���� ���� ó���� �ʿ� ����)
 */
class Practice11_6 {
	public static void main(String[] args) {

		String[] names = new String[10];    // ���� �ִ� 10���� ������ �迭����

		int no = SkScanner.getInt("  o ������ �̸��� ���� �Է� > ");
		
		if ( no > 10)
			System.out.println("  ??? ������ �� �ִ� �ִ� ������ 10���� "); 
		else {
			for (int i = 0; i < no; i++) {
				String name = SkScanner.getString("  o "+(i+1)+"��° �̸� > ");
				names[i] = name;
			}

			System.out.println("  * ����� " + no + "�� �̸�: ");  
			
			for ( String name : names)
				System.out.println(name + " "); 
		}  
	}
}