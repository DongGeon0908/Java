package ex12_more;
/*
 * [ Print_IlikeJava1221_UsingMethod ]: "I Like Java "�� 1221�� ����ϱ�
 *       
 *  o ��Ÿ�� 4 : �ݺ��� ������� �ʱ�
 *            + �޼ҵ� ȣ���� �̿��Ͽ� "I Like Java "�� ���
 *      
 *  o �Ȱ��� �۾��� �ݺ��ϴ� ���α׷��� �ݺ����� ������� �ʰ� ���� �ۼ��غ��� ���� 
 *        �ݺ����� �߿伺�� �����ϱ� ���� �ſ� �߿��ϴ�.
 *        
 *  o �ݺ����� ������� �ʰ� ���� �ݺ������� �����ϴ� ���� �ݺ� ȸ���� ���� ���̵��� �޶�����. 
 *     �ݺ�ȸ���� ���� ���� ������ ������� �ʴٰ�, ȸ���� �������� ���� ������� 
 *     ȸ���� ���� �������� ���� �Ұ����� ���̱⵵ �Ѵ�. 
 *     1221���� ���� �� �� ������ 12321��, 1234321�� ���� �����ұ�?

 *   ********************************************************
 *    o �ݺ��� ���� �ʰ� 1221�� �Ǵ� �� �̻��� ����ϴ� ���α׷� �ۼ��ϱ�
 *    
 *       - �ι�° ���: "I Like Java " ��� ȸ���� 10�辿 ������Ű�� �޼ҵ���� �ۼ��ϰ�  
 *                  1ȸ �޼ҵ� 1��, 10ȸ �޼ҵ� 2��, 100ȸ �޼ҵ� 2�� 1000ȸ �޼ҵ� 1�� ȣ��  
 *                    
 *     1) "I Like Java "�� 1�� ����ϴ� printLike1() �޼ҵ� �ۼ�
 *     2) printLike1()�� 10�� ȣ���ϴ� printLike10() �޼ҵ� �ۼ�
 *     3) printLike10()�� 10�� ȣ���ϴ� printLike100() �޼ҵ� �ۼ�
 *     4) printLike100()�� 10�� ȣ���ϴ� printLike1000() �޼ҵ� �ۼ�
 *     5) main() �޼ҵ忡�� printLike1000() 1��, printLike100() 2��, 
 *        printLike10() 2��, printLike1() 1�� ȣ���ϸ� "I Like Java "�� ��� 1221�� ���
 *        
 *    ����:  ���� ����� ���� �޼ҵ��ε�? 
 *    ���:  main() �޼ҵ嵵 �޼ҵ��̰�, Java�� ���� �޼ҵ��̴�. �޼ҵ带 ���� ����� ���� ���� �ƴϴ�.
 *           2�� �Ŀ� �޼ҵ忡 ���� ���� �ڼ��� ��� ���̴�.
 *    
 *   *****************************************************************************************************************
*/

public class Ex4_04_6_Print_IlikeJava1221_UsingMethod {
	public static void main(String[] args)  {
		printLike1000();		

		printLike100();
		printLike100();

		printLike10();
		printLike10();

		printLike1();
	}
 
	// "I Like Java "�� 1�� ���
	public static void printLike1() {
		System.out.print("I Like Java ");
	}

	// "I Like Java "�� 10�� ���
	public static void printLike10() {
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
		printLike1();
	}

	// "I Like Java "�� 100�� ���
	public static void printLike100() {
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
		printLike10();
	}

	// "I Like Java "�� 1000�� ���
	public static void printLike1000() {
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
		printLike100();
	}
}
