package ex9_5_java_exception;

/**
 * [ JavaExceptionHandling Ŭ���� ] : Java���� �����ϴ� ���� Ŭ������ �߻����� ó���ϴ� ����
 * 
 *   o Java���� �����ϴ� ����
 *     - ���α׷����� ���� �߻��ϴ� ������ ��Ȳ�� ���ؼ� �ڵ������� ���ܸ�
 *       �߻���Ű�� �̸�  Ž���Ͽ� ó���� �� �ִ� ����� ���� 
 *     - Java���� �����ϴ� ����: ������ ��Ȳ���� �ý��ۿ� ���� �ڵ������� �߻��ϴ� ����
 *     
 *   o Java���� �����ϴ� ���� Ŭ���� 
 *     - Java���� �����ϴ� ���ܿ� ���� �� Ŭ������ java.lang ��Ű���� ����Ǿ� ���� 
 *     - Throwable, Error, Exception, RunTimeException Ŭ������ �̵��� ���� ���� ���� Ŭ������ ����
 *     - unchecked ����: Error Ŭ���� �� ���� Ŭ������ RunTimeException Ŭ���� �� ���� Ŭ������ 
 *                      Java �����Ϸ��� ���� ó�� ���θ� �˻����� �����Ƿ� ���� ó���� ���� �ʾƵ� ��
 *     - checked ����: �� ���� ���� Ŭ�������� Java �����Ϸ��� ���� ó�� ���θ� Ȯ���ϹǷ� �ݵ�� ���� ó���ؾ��ϴ� ��
 *   
 *     - Java���� �����ϴ� ���� Ŭ������ ��
 *       . ArithmeticException: 0���� ������ ���� ��� ���꿡 ���� ����
 *       . ArrayIndexOutOfBoundsException: �迭 �ε����� ���� �ʰ� ����
 *       . ArrayStoreException: �迭 ���ҿ� ���� �ʴ� Ÿ���� �� ������ ����
 *     
 *     - Java���� �����ϴ� ���ܴ� ���α׷��� ���� �� �ڵ������� �߻��ϸ�, ���α׷��Ӱ� ���� �� ���� 
 *     - Java���� �����ϴ� ���ܴ� ���α׷����� ���� Ž���ǰ� ó���� �� ���� 
 */

class Ex9_5_1_JavaExceptionHandling {
	public static void main(String[] args) {
		int i = 7, j;

		try  {
			// ���� ��Ȳ: 0���� ������ �߸��� ���������� 
			//          ArithmeticException�� �ڵ������� �߻�
			j = i / 0;   
		}
		catch (ArithmeticException e) {
			System.out.println("\n  * ����: 0���� ������: " + e.getMessage());
		}

		int[] arr = new int[10];
		try {
			// ���� ��Ȳ: arr[20]�� �������� �ʴ� �迭���ҷ� 
			//       ArrayIndexOutOfBoundsException�� �ڵ������� �߻�
			arr[20] = 4;  
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\n  * ����: ������ ��� �迭 �ε���: " + e.getMessage());
		}
	}	
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� 0���� ������, �ε��� ���� �ʰ� ���� �� Java���� �����ϴ� ���ܸ� �߻���Ű�� �̸� ó���Ѵ�.
 *   
 *   2) ���α׷��� ���� ����� Ȯ���϶�.  
 */

