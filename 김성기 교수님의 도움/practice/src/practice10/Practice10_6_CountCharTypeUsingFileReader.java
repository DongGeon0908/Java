package practice10;

import java.io.*;  // FileReader Ŭ������ ����ϱ� ���� import

/**
 * [ 10�� �ǽ����� 6 ��� ��� ]: 
 *     FileReader�� �̿��Ͽ� file���� ���� �о� ���� ������ ���� ���ϱ�
 *         
 *   6. ���Ͽ��� ���� �о� ������ ���� ����ϱ�
 *       
 *     java.io.FileReader Ŭ������ int read() �޼ҵ带 �̿��Ͽ� 
 *     "java.txt" ������ �����͸� ���� ������ �о� ������ ������ ������ ���� 
 *     ����ϴ� ���α׷��� �ۼ��϶�.
 *       
 *     ������ ������ ���� �빮�� ����, ���� �빮�� ����, ���� �ҹ��� ����, ���� �ҹ��� ����, 
 *     �ѱ� ����, Ư������, ��Ÿ���� ������ �ϸ�, ���� c�� ����� ���ڰ� �ѱ� �����ΰ��� �˻��ϴ� ������ 
 *     (c >= '��' && c <= '��' || c >= '��' && c <= '��' || c >= '��' && c <= '�R') �̴�. 
 *  
 *   o java.io ��Ű���� FileReader
 *     - ���Ͽ��� ���� ������ �а��ϴ� Ŭ����
 *     - ����η� ���� ��� ������ ������Ʈ ������ ����Ǿ�� ��
 *     - �׷��Ƿ� ���� ���� "java.txt" ������ ������Ʈ ch10�� ����Ǵ� ch10 ���� �Ʒ��� �����
 *    
 *     - int read() �޼ҵ�: �� ���� �����͸� ��ü �����ڿ� ��õ� ���Ͽ��� �о� ���̸�, 
 *                         �� �̻� ���� ���ڰ� ������ -1�� ��ȯ
 *                         (���ڸ� ������ ��ȯ�� Ÿ���� int�� �� ����� ��)
 *                         
 *     - close() �޼ҵ�: �۾��� ���� ������ �� �̻� ������� ���� ��� ȣ���ϸ�, 
 *                      �Է��� ���� �Ҵ�� �ڿ����� ��� ȸ��
 */

public class Practice10_6_CountCharTypeUsingFileReader {
	// ���� ������ ��Ī�� �����ϴ� ���ڿ� �迭
	static String[] ctypeNames = { 
			"���빮�� ����", "���빮�� ����", 
			"���ҹ��� ����", "���ҹ��� ����",
			"�ѱ� ����", "�ѱ� ����", "�ѱ� ����",
			"���� ����Ʈ",
			"��Ÿ ����"
	};
	
	public static void main(String[] args) {
		
		// "java.txt" ������ ������ �о� ���� ������ ���� ���
		int[] countCharTypes = getCountOfCharTypes("java.txt");
		
		outputCountCharTypes(countCharTypes);
	}

	// filename ������ �����͸� ���� ������ �о� ���� ������ ���� ����ϴ� �޼ҵ�
	static int[] getCountOfCharTypes(String filename) {   
		
		// ���� ������ ������ ������ �迭����
		int[] countCharTypes = new int[ctypeNames.length];
		
		// ��ü ������, read(), close() �޼ҵ�� ���ܸ� �߻��ϹǷ� try-catch ������� ���� ó��
		try {
			// filename ���Ͽ� ���� FileReader ��ü �����Ͽ� frdr�� ����
			FileReader frdr = new FileReader(filename); 

			int c; // ���� ���ڸ� �����ϴ� ������ int�� �ؾ� ���� �� -1�� �˻� ����

			System.out.println("\n  ** " + filename +"���� ���� ���ڵ� **\n");
			
			// FileReader frdr���� ������ ������ �����͸� �о� ȭ�鿡 ���
			while((c = frdr.read()) != -1) {
				int ctype = getCharType((char) c);  // ���� ������ ���� ���� ����
				countCharTypes[ctype]++;            // �ش� ���� ������ ���� ���� 1 ����
				
				System.out.print((char) c);       // ���� int �� c�� ���ڷ� ����ϱ� ���� ĳ��Ʈ
			}
			frdr.close();  // FileReader frdr�� ����
		} catch (IOException e) {
			System.out.print("  ??? ����: " + e.getMessage());
		}
		
		return countCharTypes;
	}

	// �־��� ������ ���� ������ ���Ͽ� ��ȯ�ϴ� �޼ҵ� 
	static int getCharType(char c) {
		int ctype;  // 0���� 8������ �������� ��Ÿ���� ��ȣ�� ������ ����

		// ���������� Ȯ���Ͽ� ctype�� ������ȣ ����
		if (c >= 'A' && c <= 'Z') {           // 'A'���� 'Z'������ ���빮��
			if (c=='A' || c=='E' || c=='I' || c=='O' || c=='U')  
				ctype = 0;                    //    ���빮�� ������ ������ȣ: 0
			else
				ctype = 1;                    //    ���빮�� ������ ������ȣ: 1
		} else if (c >= 'a' && c <= 'z') {    // 'a'���� 'z'������ ���ҹ���
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')  
				ctype = 2;                    //    ���ҹ��� ������ ������ȣ: 2
			else
				ctype = 3;                    //    ���ҹ��� ������ ������ȣ: 3
		} else if (c >= '��' && c <= '��')     // '��'�� �ѱ� ���� �� �ּ�, '��'�� �ִ�
			ctype = 4;	                      //     �ѱ� ������ ������ȣ: 4
		else if (c >= '��' && c <= '��')       // '��'�� �ѱ� ���� �� �ּ�, '��'�� �ִ�
			ctype = 5;	                      //     �ѱ� ������ ������ȣ: 6 
		else if (c >= '��' && c <= '�R')       // '��'�� �ѱ� ���� �� �ּ�, '�R'�� �ִ�
			ctype = 6;	                      //     �ѱ� ������ ������ȣ: 6  
		else if (c >= '0' && c <= '9')        // '0'���� '9'������ ����Ʈ
			ctype = 7;                        //     ���� ����Ʈ�� ������ȣ: 7 
		else 
			ctype = 8;                        //     ��Ÿ ���������� ��ȣ: 8 
 
		return ctype;
	}	

	// int �迭 countCharTypes�� ����� ���� ������ ������ ����ϴ� �޼ҵ�
	static void outputCountCharTypes(int[] countCharTypes) {
		System.out.println("\n\n  ** ���� ���ڵ��� ������ ���� **\n");
		
		for (int i = 0; i < ctypeNames.length; i++)
			System.out.println("  * " + ctypeNames[i] + ": " + countCharTypes[i]);				
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� "java.txt" ������ ���� ������ �о� ȭ�鿡  ����� �� �ѱ� ������ ������ ����Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.     
 */
