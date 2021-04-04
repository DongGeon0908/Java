import java.awt.*;
import javax.swing.*;        

/**
 * [ JFramesDisplay ]: 3���� JFrame ��ü �����ϰ� ���÷����ϱ�
 * 
 *   o �����̳� ������Ʈ
 *     - �ٸ� ������Ʈ�� ��ġ�� �� �ִ� ������Ʈ
 *     - �ֻ��� �����̳ʿ� ���� �����̳ʷ� ���е�
 *     - �ֻ��� ������Ʈ: �ٸ� �����̳ʿ� ��ġ���� �ʰ� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JFrame, JDialog
 *          
 *     - ���� �����̳�: �ٸ� �����̳ʿ� ��ġ�Ǿ�߸� ��ũ���� ���÷��̵� �� �ִ� �����̳�
 *          JPanel, JScrollPane
 *             
 *   o JFrame
 *     - ���������� ���÷��̵Ǵ� �ֻ��� �����̳� Ŭ������ ��¡ ���� ���� 
 *       
 *   o �����̳� ������Ʈ���� �Ӽ� ������ ���� �޼ҵ�
 *     - public void setSize(int width, int height) : ���ο� ���� ũ�� ����
 *     - public void setLocation(int x, int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBounds(int x, int y, int width, int height) : 
 *                                ���ο� ���� ũ�� �����Ͽ� ��ǥ (x, y) ��ġ��  ��ġ
 *       
 *     - public void setBackground(Color c) : ������ �־��� �������� ����
 *     - public void setForeground(Color c) : ������� �־��� �������� ����
 *     - public void setFont(Font f) : ������Ʈ�� ��Ʈ�� ����
 *      
 *     - public void setFocusable(boolean b) : ��Ŀ���� ���� �� �ְų� ���� �� 
 *     - public void setEnabled(boolean b) : �Է¿� ���� ������ �� �ְų� ���� ��
 *     - public void setVisible(boolean b) : ���÷��̵ǰ� �ϰų� ������� ��
 */

class Ex12_3_06_JFramesDisplay {

	public static void main(String[] args) {
		JFrame frame1 = new JFrame(); // Ÿ��Ʋ ���� JFrame 
		frame1.setSize(160, 150);     // ũ�� ����
		frame1.setLocation(10, 10);   // ���÷����� ��ġ ����
		frame1.setVisible(true);      // ��ũ���� ���÷��̽�Ű��
 
		JFrame frame2 = new JFrame("Ÿ��Ʋ �ִ� JFrame"); // Ÿ��Ʋ �ִ� JFrame 
		frame2.setBounds(200, 10, 300, 200);            // ũ��� ��ġ ����
		frame2.setVisible(true);                        // ��ũ���� ���÷��̽�Ű��

		JFrame frame3 = new JFrame();           // Ÿ��Ʋ ���� JFrame ��ü ����
		frame3.setBounds(450, 10, 310, 250);    // ũ��� ��ġ ����
		frame3.setTitle("Ÿ��Ʋ ������ JFrame");   // Ÿ��Ʋ ����
		frame3.setVisible(true);                // ��ũ���� ���÷��̽�Ű��
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) 3���� JFrame�� �����Ͽ� �Ӽ��� ������ �� ��ũ���� ���÷��̽�Ų��.
 *   
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *      
 *   3) ���α׷��� �����ϰ� ����� Ȯ�ζ��.
 *   
 *  
 * [ �ǽ����� ]
 *
 *   o setSize(), setLocation(), setBounds(), setTitle(), setVisible() �޼ҵ��� 
 *     �Ű������� ������ �� ����� Ȯ���϶�.
 */