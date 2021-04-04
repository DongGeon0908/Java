package ex10_4_java_io_package;

import java.io.*;  // FileInputStream Ŭ������ ����ϱ� ���� import

/**
 * [ FileWritingUsingFileWriter Ŭ���� ]: 
 *       java.io.FileReader �̿��Ͽ� ���� ������ ���� �����͸� ��ȣȭ�ϰ�
 *       java.io.FileWriter �̿��Ͽ� ���� ������ ���Ͽ� �� �� �ٽ� �б� 
 *       file�� ���ڸ� ����
 *  
 *   o java.io ��Ű���� FileReader
 *     - ���Ͽ��� ���� ������ �д� Ŭ����
 *     - ����η� ���� ��� ������ ������Ʈ ���� �Ǵ� �Ʒ� ������ ����Ǿ�� ��
 *     - �׷��Ƿ� ���� ���� "java.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� ����
 *    
 *     - int read() �޼ҵ�: �� ���� �����͸� ��ü �����ڿ� ��õ� ���Ͽ��� �о� ���̸�, 
 *                         �� �̻� ���� ���ڰ� ������ -1�� ��ȯ
 *                         (���ڸ� ������ ��ȯ�� Ÿ���� int�� �� ����� ��)
 *                         
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                      �Է��� ���� �Ҵ�� �ڿ����� ��� ȸ��
 *                    
 *   o java.io ��Ű���� FileWriter
 *     - ���Ͽ� ���� ������ ���� Ŭ����
 *     - ����η� ������ ���Ͽ� ���� ������ ������Ʈ ������ ����
 *     - �׷��Ƿ� �� ���� "javaEncryption.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� ����
 *    
 *     - void read(int c) �޼ҵ�: �� ���� �����͸� ��ü �����ڿ� ��õ� ���Ͽ� ��
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                    �Է��� ���� �Ҵ�� �ڿ��� ��� ȸ��    
 */

class Ex10_4_4_FileWriting_UsingFileWriter {
	public static void main(String[] args) {
		// java.txt ������ �����͸�  ���� ������ �о� ��ȣȭ�Ͽ� javaEncryption.txt ���Ͽ� ����
		readEncryptWrite("java.txt", "javaEncryption.txt");
		
		// javaEncryption.txt ������ �����͸�  ���� ������ �о� ȭ�鿡 ���
		readOutputToScreen("javaEncryption.txt");
	}

	// from ������ �����͸� ���� ������ �о� ��ȣȭ�Ͽ� to ���Ͽ� ���� �޼ҵ�
	static void readEncryptWrite(String from, String to) {    
		// ��ü �����ڿ� ����� �޼ҵ�� ���ܸ� �߻��ϹǷ� try-catch ������� ���� ó��
		try {
			// from ���Ͽ� ���� FileReader ��ü ����
			FileReader frdr = new FileReader(from); 

			// to ���Ͽ� ���� FileWriter ��ü ����
			FileWriter fwrt = new FileWriter(to); 

			int c; // ���� ���ڸ� �����ϴ� ������ int�� �ؾ� ���� �� -1�� �˻� ����

			// �Է� ��Ʈ�� instrm���� ���� ������ ������ �о� ��ȣȭ�Ͽ� outstrm�� ��
			while((c = frdr.read()) != -1) 
				fwrt.write(c + 1);  // ���� ���ڿ� 1�� ���Ͽ� ��� ��Ʈ���� ��

			frdr.close();  // �Է� ��Ʈ���� ����
			fwrt.close();  // ��� ��Ʈ���� ����

		} catch (IOException e) {
			System.out.print("  ??? ����: " + e.getMessage());
		}
	}
		
	// filename ������ �����͸�  ���� ������ �о� ȭ�鿡 ���
	static void readOutputToScreen(String filename) {   

		System.out.println("\n  ** java.txt ���Ͽ��� ���� �о� 1 ���� �� ���� �ٽ� ���� ��� **\n");
		
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
 *   1) �� ���α׷��� "java.txt" ������ ���� ������ ���� ���ڿ� 1�� ���Ͽ�(�̴� �ʺ��� ��ȣȭ ���)  
 *      "javaEncryption.txt"�� ���� ������ ����Ѵ�. 
 *      
 *       �ٽ� "javaEncryption.txt"�� ���� ������ �о� ȭ�鿡 ����Ѵ�. 
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 *   
 *        ����       : Java is an object-oriented programming language developed by Sun Microsystems' James Gosling and other researchers.
 *        ��ȯ�� ��: Kbwb!jt!bo!pckfdu.psjfoufe!qsphsbnnjoh!mbohvbhf!efwfmpqfe!cz!Tvo!Njdsptztufnt(!Kbnft!Hptmjoh!boe!puifs!sftfbsdifst/
 *   
 *        ����       : �ڹٴ�  1995�⿡  ��ǥ�Ǿ���.
 *        ��ȯ�� ��: �۹ڈd!2::6����!��i�پ���/
 *      
 *      - ���α׷� ����� ����, �Է� �������� ù �ܾ��� "java"�� J�� K, a�� b, v�� w, a�� b�� ��ȣȭ�Ǿ� 
 *        ������Ͽ� ����Ǿ��µ�, �̵� ��ȭ�� ���ڴ� ������ ������ ���� ������
 *        
 *      - ���ںκ��� 1995�� 2::6���� ��ȣȭ��
 *      - �ѱۺκ��� "�ڹٴ�"�� �ڴ� ��, �ٴ� ��, ���� �d���� ��ȣȭ�Ǿ��µ�, �̵� ��ȭ�� ���ڴ� �ѱ� ������ ���� ������
 *   
 *   3) ���� ������ ���� ��� �ѱ� �����ʹ� �������� ������ Ȯ���϶�.
 */
