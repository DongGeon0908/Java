package ex03_scores;

/*
 *  [ SumGreaterOrEqual_UsingBreak ]: break ���� �̿��Ͽ� 1������ ���� 100000 �̻��� ���� ���ϱ�   
 *            
 *    o while ��
 *      - while(�ݺ�����)
	              �ݺ�_������_����
	              
 *      - �ݺ������� true�� ���� �ݺ�_������_������ �ݺ�
 *	               
 */

class Ex4_5_1_SumGreaterOrEqual_UsingBreak {
	public static void main(String[] args)  {
		System.out.println("\n  ** 1������ ���� 100000 �̻��� ���� ���ϱ� **\n");
		
		int n, sum = 0;
		for (n = 1; ; n++)	 {      // n�� 1���� �����ϸ鼭 ������ �ݺ��ϴ� �߿� 
		    sum += n;           	//     sum�� 1���� n������ ���� �����Ͽ�
		    if (sum >= 100000)	 	//     sum�� 100000���� ũ�ų� ������
		       break;		        //        break ���� �̿��Ͽ� for ���� ���	
		}

		System.out.println("  * 1������ ���� 100000 �̻��� ù ����: " + n + ", ��: " + sum);
	}
}
