package ex11_3_collection_classes;

import java.util.Stack;

/**
 * [ StoreStrings_UsingStack Ŭ���� ]: 
 *       java.util.Stack Ŭ������ Ǫ�ÿ� �� �����ϱ�
 * 
 *   o ����
 *     - ���Լ���(last-in, first-out: �������� ���Ե� ���Ұ� ���� ���� �����)�� ����� ���� ����Ʈ
 *     - ���ÿ����� ���� ������ Ǫ��(push)�� �ϸ�, Ǫ�ô� ž(top)�̶� �Ҹ��� ���ʿ����� ���ʷ� ����
 *     - ���ÿ����� ���� ������ ��(pop)�̶� �ϸ�, �˵� ���� ž ��ġ�� ���Ұ� ���ʴ�� ����ǰ� ���Ұ� ����
 *   
 *   o Stack Ŭ����
 *     - Vector Ŭ������ ���� Ŭ����
 *     - ���Լ����� �����ϱ� ���Ͽ� empty(), peek(), pop(), push(), search() �޼ҵ带 �߰��� ����
 *          
 *   o main()���� �̸� 5���� Stack ��ü�� Ǫ���� �� �˽�Ŵ
 */

class Ex11_3_2_StoreStrings_UsingStack {  
	public static void main(String[] args) {   
		// ���ڿ��� ���ҷ� ������ Stack ��ü �����Ͽ� strings�� �����ϰ� �� 
		Stack<String> nameStack = new Stack<String>(); 

		// 5���� �̸��� Ǫ���ϱ� 
		nameStack.push("ȫ�浿");
		nameStack.push("�ڹ���");
		nameStack.push("�̸���");
		nameStack.push("������");
		nameStack.push("��û");

		int cntNames = nameStack.size(); // ���ÿ� ����� ���� ���� ����

		System.out.print("\n  ** nameStack�� ��� ����(" + cntNames +"��) �˽�Ű�� **\n\n  * "); 
		
		for (int i = 0; i < cntNames; i++) { // nameStack�� ����� ���� ������ŭ
			String s = nameStack.pop();      //   ���Ҹ� �˽���
			System.out.print(s + " ");       //   ��� 
		} 
	}
}

/*
* [ ���α׷��� ���� �� ���� ]
*   
*   1) ���α׷��� �����Ͽ� ����� Ȯ���϶�.
*   
*   2) 2���� �̸��� nameStack�� �߰��Ͽ� Ǫ���ϵ��� ���α׷��� �����ϰ� ����� Ȯ���϶�.
*   
*   3) ��µ� ����� �� ���캸�� Stack�� Ǫ�ÿ� ���� ��� ���߿� Ǫ�õ� �����Ͱ� ���� �˵��� Ȯ���϶�.
*/