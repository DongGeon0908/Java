package ex10_4_java_io_package;

import java.io.*;  // FileInputStream, FileOutputStream Ŭ������ ����ϱ� ���� import

/**
 * [ FileWritingUsingFileOutputStream Ŭ���� ]: 
 *        java.io.FileInputStream �̿��Ͽ� ���� ����Ʈ �����͸� ��ȣȭ�� �� 
 *        java.io.FileOutputStream �̿��Ͽ� file�� ����Ʈ ������ �� �� �ٽ� �о� ����ϱ�
 *  
 *   o java.io ��Ű���� FileInputStream
 *     - ���Ͽ��� ����Ʈ ������ �а� �ϴ� Ŭ����
 *     - ���� ������ ����η� ǥ�õ� �����̸� ������Ʈ ���� �Ǵ� �Ʒ� ������ ����Ǿ�� ��
 *     - �׷��Ƿ�  ���� ���� "java.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� ����
 *    
 *     - int read() �޼ҵ�: �� ����Ʈ�� �����͸� ��ü �����ڿ� ��õ� ���Ͽ��� �о� ���̸�, 
 *                         �� �̻� ���� ����Ʈ�� ������ -1�� ��ȯ
 *                         (����Ʈ�� ������ ��ȯ�� Ÿ���� int�� �� ����� ��)
 *                         
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                      �Է��� ���� �Ҵ�� �ڿ��� ��� ȸ�� 
 *                    
 *   o FileOutputStream: ���Ͽ� ����Ʈ ������ ���� Ŭ����
 *     - ����η� ������ ���Ͽ� ���� ������ ������Ʈ ������ ����
 *     - �׷��Ƿ� �� ���� "javaEncryption.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� ����
 *    
 *     - void write(int c) �޼ҵ�: �� ����Ʈ �����͸� ��ü �����ڿ� ��õ� ���Ͽ� ��
 *     
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                      �Է��� ���� �Ҵ�� �ڿ��� ��� ȸ��                      
 */

class Ex10_4_2_FileWriting_UsingFileOutputStream {
	public static void main(String[] args) {

		System.out.println("\n  ** java.txt ���Ͽ��� ����Ʈ �о� 1 ���� �� ���� �ٽ� ���� ��� **\n");
		
		// ��ü ������, read(), write(), close() �޼ҵ�� ���ܸ� �߻��ϹǷ� try-catch ������� ���� ó��
		try {
			// ����η� ǥ�õ� java.txt ���Ͽ� ���� FileInputStream ��ü ����
			FileInputStream instrm = new FileInputStream("java.txt"); 

			// ����η� ǥ�õ� javaEncoding.txt ���Ͽ� ���� FileOutputStream ��ü ����
			FileOutputStream outstrm = new FileOutputStream("javaEncryption.txt"); 

			int c; // ���� ����Ʈ�� �����ϴ� ������ int�� �ؾ� ���� �� -1�� �˻� ����

			// �Է� ��Ʈ�� instrm���� ���� ������ ������ �о� ��ȣȭ(1�� ����)�Ͽ� outstrm�� ��
			while((c = instrm.read()) != -1) 
				outstrm.write(c + 1);  // ���� ����Ʈ�� 1�� ���Ͽ� ��� ��Ʈ���� ��
			
			instrm.close();  // �Է� ��Ʈ���� ����
			outstrm.close(); // ��� ��Ʈ���� ����
					
			// ����η� ǥ�õ� javaEncryption.txt ���Ͽ� ���� FileInputStream ��ü ����
			instrm = new FileInputStream("javaEncryption.txt"); 

			// �Է� ��Ʈ�� instrm���� ������ ������ �����͸� �о� ȭ�鿡 ���
			while((c = instrm.read()) != -1) 
				  System.out.print((char) c);  // �о���� ����Ʈ�� ȭ�鿡 ���ڷ� ����ϱ� ���� (char)�� ĳ��Ʈ
			
			instrm.close();

		} catch (IOException e) {
			System.out.print("  ??? ����: " + e.getMessage());
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� "java.txt" ������ ����Ʈ ������ ���� ����Ʈ�� 1�� ���Ͽ�(�̴� �ʺ��� ��ȣȭ ���)  
 *      "javaEncryption.txt"�� ����Ʈ ������ ����Ѵ�. 
 *      
 *      �ٽ� "javaEncryption.txt"�� ����Ʈ ������ �о� ȭ�鿡 ����Ѵ�. 
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 *      - ���α׷� ����� ����, �Է� �������� ù �ܾ��� "java"�� J�� K, a�� b, v�� w, a�� b�� ��ȣȭ�Ǿ� 
 *        ������Ͽ� ����Ǿ��µ�, �̵� ��ȣȭ�� ���ڴ� ������ ������ ���� ������
 *      - ���ںκ��� 1995�� 2::6���� ��ȣȭ��
 *   
 *   3) ����Ʈ ������ ���� ��� �ѱ� �����ʹ� �������� Ȯ���϶�.
 */
