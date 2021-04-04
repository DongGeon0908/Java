package ex6_5_1_main_args;

/**
 * [ PrintMainArgs Ŭ���� ]: �ܺο��� main() �޼ҵ�� ���޵� ���� ó���ϱ�
 *   
 *   o main() �޼ҵ��� args[] �迭����
 *     - Java ���α׷��� ������ �� Java ���α׷����� ���ڿ� ������ �����ϱ� ���� ����
 *     
 *     - ���α׷����� ���ڿ� ���� ���� ���
 *       1) �ܺ��� ��ɾ� ���ο��� �����ϱ�: java Ŭ�����̸� ���ڿ�1 ���ڿ�2 ���ڿ�3 ...
 *           ��: java PrintMainArgs Hi! "My name" is "Hong Gildong " in "Seoul Korea" // 6���� ���ڿ��� ���޵�
 *           
 *       2) Eclipse���� �����ϱ�: Run -> Run Configurations Ŭ���� ��
 *           (x)= argument ���� Ŭ���Ͽ� program arguments �Է�â�� ���ڿ� �Է�
 *           
 *     - �������
 *       1) ���ڿ��� "�� " ���̿� ǥ���� �� �ְų� " �����ص� �� 
 *       2) blank, tab ���� ȭ��Ʈ �����̽� ���ڰ� ���ڿ��� ���Ե� ��� �ݵ�� "�� " ���̿� ���ڿ� ǥ���ؾ� ��
 */

class Ex6_5_1_PrintMainArgs {
	public static void main(String[] args) {

		if (args.length == 0) // args.length�� args[] �迭�� ���� ������ �����ϴ� �ʵ�
			System.out.println("\n  ** �ܺο��� ���޵� ���ڿ� ������ ���� **\n");
		else {
			System.out.println("\n  ** �ܺο��� ���޵� ���ڿ� ���� ����: " + args.length  + " ** \n");

			for (int i = 0; i < args.length; i++)
				System.out.println("  * " + (i + 1) + "��° ���޵� ����: " + args[i]);
		}
	}
} 

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���α׷� �ܺο��� ���޵� ���ڿ� ������ main() �޼ҵ��� args[] �迭������ ���޹޾�
 *      ����Ѵ�.
 *      
 *      ���� ���, Hi! "My name" is "Hong Gildong " in "Seoul Korea"�� �����ϸ� 
 *      �̵� ���ڿ� ������ ���ڿ����� ���ʷ� ����Ѵ�.
 *      
 *   2) Eclipse���� ���α׷����� ���ڿ� ���� �����ϴ� ���
 *      Eclipse�� Run -> Run Configurations... ->
 *        -> Main �ǿ���  << Main class: >> �������� search Ŭ���Ͽ� ex6_5_1_MainArgs.PrintMainArgs ã�� Ŭ��
 *        ->(x)= arguments �� Ŭ�� 
 *        -> Program arguments: â��   Hi! "My name" is "Hong Gildong" in "Seoul Korea" �Է�
 *        -> Run Ŭ���ϸ� �������� console �信 ��µ�
 *          
 *   3) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   
 * [ �ǽ����� ]
 * 
 *   o Program arguments ���ڵ��� �ڽ��� �̸����� ������ �� ���α׷��� �����Ͽ� ��� Ȯ���϶�.
 */
