package ex12_more;
/*
 *  [ PrintLikeJava_AnyTimes_UsingFor ]: ���ȸ���� �Է��Ͽ� "I like Java "�� ȸ����ŭ ����ϱ�
 *  
 *    o ��Ÿ�� 2: �ݺ��� ����Ͽ� ���� ���� �ۼ��ϱ�
 *             
 *    o �ݺ���(repetition statement)
 *      - �Ȱ��� ����� �Ǵ� ������ ������� �ݺ������� �����Ǵ� ��� 
 *        �̸� �ϳ��� �������� ���������� �����Ͽ� �ݺ���Ŵ
 *      - for ��, while ��, do-while�� ���� �ݺ���     
 *      
 *    o for ��
 *      - �ݺ� ������� �̿��Ͽ� �ݺ� ȸ���� ������
 *      - �ݺ� ������� for �� �ܺ� �Ǵ� ���ο��� ���� ����
 *      - for �� �ܺο��� ������ �ݺ� ������� for �� ���� for ���� ����� �Ŀ��� ��� ������ 
 *      - for �� ���ο��� ������ �ݺ� ������� for �� �������� ��� ������ 
 */

class Ex4_04_3_PrintLikeJava_AnyTimes_UsingFor {
	public static void main(String[] args)  {
		System.out.print("\n  **** Print \"I like Java\" many times using for statement ****\n");

		// �ݺ� ����� ȸ���� cnt�� �Է�
		int cnt = SkScanner.getIntWithPrompt("\n  o Enter count to print > ");     

		System.out.println("\n  o print \"I like Java \" " + cnt + " times\n");

		for (int i = 0; i < cnt; i++)        // i�� 0���� cnt ������ ���� ���� �ݺ�
			System.out.print("I like Java ");  // �ݺ� ������ 1���̹Ƿ� ���({...}) ���ʿ�		
		
	}
}

