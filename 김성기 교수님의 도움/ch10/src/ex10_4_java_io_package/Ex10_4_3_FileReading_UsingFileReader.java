package ex10_4_java_io_package;

import java.io.*;  // FileReader Ŭ������ ����ϱ� ���� import

/**
 * [ FileReadingUsingFileReader Ŭ���� ]: 
 *       java.io.FileReader�� �̿��Ͽ� file���� ���� �б�
 *  
 *   o java.io ��Ű���� FileReader
 *     - ���Ͽ��� ���� ������ �а� �ϴ� Ŭ����
 *     - ����η� ���� ��� ������ ������Ʈ ���� �Ǵ� �Ʒ� ������ ����Ǿ�� ��
 *     - �׷��Ƿ� ���� ���� "java.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� ����
 *    
 *     - int read() �޼ҵ�: �� ���� �����͸� ��ü �����ڿ� ��õ� ���Ͽ��� �о� ���̸�, 
 *                         �� �̻� ���� ���ڰ� ������ -1�� ��ȯ
 *                         (���ڸ� ������ ��ȯ�� Ÿ���� int�� �� ����� ��)
 *                         
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                      �Է��� ���� �Ҵ�� �ڿ��� ��� ȸ��
 */

public class Ex10_4_3_FileReading_UsingFileReader {
	public static void main(String[] args) {
		// java.txt ������ �����͸�  ���� ������ �о� ȭ�鿡 ���
		readOutputToScreen("java.txt");
	}

	// filename ������ �����͸�  ���� ������ �о� ȭ�鿡 ���
	static void readOutputToScreen(String filename) {   
		
		System.out.println("\n  ** java.txt ���Ͽ��� ���� ���� ��� **\n");

		// ��ü ������, read(), close() �޼ҵ�� ���ܸ� �߻��ϹǷ� try-catch ������� ���� ó��
		try {
			// filename ���Ͽ� ���� FileReader ��ü �����Ͽ� frdr�� ����
			FileReader frdr = new FileReader(filename); 

			int c; // �о���� ���ڸ� �����ϴ� ������ int�� �ؾ� ���� �� -1�� �˻� ����

			// FileReader frdr���� ������ ������ �����͸� �о� ȭ�鿡 ���
			while((c = frdr.read()) != -1) 
				System.out.print((char) c);  // ���� ���ڸ� ȭ�鿡 ���ڷ� ����ϱ� ����(char)�� ĳ��Ʈ(ĳ��Ʈ ������ ���� ���)

			frdr.close();  // FileReader frdr�� ����
		} catch (IOException e) {
			System.out.print("  ??? ����: " + e.getMessage());
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ����η� ǥ�õ� "java.txt" ������ ���� ������ �о� ȭ�鿡 ����Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 *   
 *   3) ���� ������ ���� ��� �ѱ� �����ʹ� ���������� �о����� Ȯ���϶�.
 */
