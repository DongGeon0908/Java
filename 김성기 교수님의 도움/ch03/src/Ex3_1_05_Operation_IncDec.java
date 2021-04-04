/**
 * [ Operation_IncDec ]: ���� �� ���� ������ ���� 
 *     
 *   o ���α׷��� ��Ÿ�� 
 *     1) main() �޼ҵ�θ� Ŭ���� ����
 *     2) ���� �Ǵ� �Ǽ��� ���� ���� �� ���� ������ �����Ͽ� ��� �� ���
 *     
 *   o ���� �� ���� ������ ���� ���� �Ǵ� �Ǽ� ������ ���ؼ��� ���� ������
 *   
 *   o ���� �� ���� �����ڴ�   ++. --�� ������ ���� �տ�, �Ǵ� ���� �ڿ� ������ ��ġ ����
 *     - ���� �տ� ������ ��ġ: ������ ���� ���� ���� �Ǵ� ���ҽ�Ų �� ����� ���� ������ ���� ��� ����
 *     - ���� �ڿ� ������ ��ġ: ������ ������ �������� ������ �� ������ ����  ���� �Ǵ� ���ҽ�Ŵ
 */

class Ex3_1_05_Operation_IncDec  {
	public static void main(String[] args)  {

		int count = 1;

		System.out.println("\n  ** ���� �� ���� ����(++, --) **\n");
		System.out.println("  * ���� �� ���� ����(++, --)�� ������ ����� ������ ����� �ٸ� �� ����(++ �Ǵ�  --�� ���� �ڿ� �ִ� ���)\n");

		
		System.out.println("  * ���� �ʱⰪ: count = " + count + " (��� ������ << count = 1; >> ������ �� ����)");  
		System.out.println();

		/*
		 *  ���� �� ���� ���꿡 ���� ��
		 */
		count = 1;
		System.out.println("  * ++count := " + ( ++count ) + "   �� count := " + (count));  // �� ���� ��� : 2, count ���� ��: 2

		count = 1;
		System.out.println("  * count++ := " + ( count++ ) + "   �� count := " + (count));  // �� ���� ��� : 1, count ���� ��: 2

		count = 1;
		System.out.println("  * --count := " + ( --count ) + "   �� count := " + (count));  // �� ���� ��� : 0, count ���� ��: 0

		count = 1;
		System.out.println("  * count-- := " + ( count-- ) + "   �� count := " + (count));  // �� ���� ��� : 1, count ���� ��: 0
		System.out.println();

		/*
		 *  ���� �� ���� ������ �� ����� �Բ� ���� ��
		 */
		count = 1;
		System.out.println("  * ++count  > 1 := " + ( ++count > 1 ) + "   �� count := " + (count));  // �� ���� ��� : true, count ���� ��: 2

		count = 1;
		System.out.println("  * count++  > 1 := " + ( count++ > 1 ) + "  �� count := " + (count));  // �� ���� ��� : false, count ���� ��: 2

		count = 1;
		System.out.println("  * --count == 0 := " + ( --count  == 0) + "   �� count := " + (count));  // �� ���� ��� : true, count ���� ��: 0

		count = 1;
		System.out.println("  * count-- == 0 := " + ( count-- == 0) + "  �� count := " + (count));  // �� ���� ��� : false, count ���� ��: 0
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   o ������ ����� ������ ���غ��� ������ ����� ���� ����.
 *   
 *   o ���� �� ���� ����(++, --)�� for ��, while �� ���� �ݺ�������
 *     �ݺ� ��� ���� ���� ���ǹǷ� ���� ����� ���� ���� ��Ȯ�� ����� �� �־�� �Ѵ�. 
 */
