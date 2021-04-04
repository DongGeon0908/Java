// GUI ���α׷����� ���� import
import java.awt.*;
import javax.swing.*;

// �̺�Ʈ ó���� ���� import
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * [ TemperatureConversion_GUIEvent_SetupComponent ]: 
 *        ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϴ� GUI ����(������Ʈ�� �Ӽ� ����)
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
 *   o ������Ʈ���� �Ӽ� ������ ���� �޼ҵ�
 *     - public void setSize(int width, int height) : ���ο� ���� ũ�⸦ ����
 *     - public void setLocation(int x,  int y) : ��ǥ (x, y) ��ġ�� ��ġ
 *     - public void setBackground(Color c) : ������ �־��� �������� ����
 *     - public void setForeground(Color c) : ������� �־��� �������� ����
 *     - public void setFont(Font f) : �� ������Ʈ�� ��Ʈ�� ����
 *     - public void setEnabled(boolean b) : �Է¿� ���� ������ �� �ְų� ���� ��
 *     - public void setFocusable(boolean b) : ��Ŀ���� ���� �� �ְų� ���� �� 
 *     - public void setVisible(boolean b) : ���÷��� �ǰ� �ϰų� ������� �� 
 */

class Ex12_2_1_TemperatureConversion_GUIEvent_SetupComponent  {
	// �ʿ��� ������Ʈ�� ��ġ�� ������ ����
	static JFrame frame = new JFrame("Temperature Conversion");

	// ���α׷� Ÿ��Ʋ ����� ���� ���̺� ����
	static JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// �Է¹��� ȭ���µ��� ���� ������Ʈ �޽��� ���̺� �� �ؽ�Ʈ�ʵ�  ����
	static JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	static JTextField degreeToConvertTF = new JTextField(10);

	// ��ȯ�� �����µ��� ���� ���̺� �� �ؽ�Ʈ�ʵ� ���� 
	static JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	static JTextField degreeConvertedTF = new JTextField(10);

	// �����츦 ���� frame ���� �޼ҵ�
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // ������Ʈ ��ġ ����� FlowLayout���� 
		frame.setSize(330, 125);            // ���� 330�ȼ�, ���� 125�ȼ� ũ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
		
		frame.getContentPane().setBackground(new Color(230, 130, 230));  // RGB ���� �̿��Ͽ� ���� �����ϱ�
		frame.setLocation(500, 300);       // �����츦 (500, 300) ��ġ�� ȭ�� �߾������� ��ġ 
	}
	
	// ������Ʈ�� ���� �޼ҵ�
	static void setupComponents() {     
		// titleLB�� �Ӽ� ����
		titleLB.setOpaque(true);  // ** JLabel�� ����, ������� �����Ϸ��� true�� �����ؾ� �� **
		titleLB.setBackground(Color.pink);     // �ҹ��� ������� �̿��Ͽ� ���� �����ϱ�
		titleLB.setForeground(Color.BLUE);     // �빮�� ������� �̿��Ͽ� ����� �����ϱ�
		titleLB.setFont(new Font("�Ÿ���", Font.ITALIC, 17));  // (�Ÿ���ü, ���Ÿ�, ũ�� 17)�� ��Ʈ ����
	
		// degreeToConvertLB�� �Ӽ� ����
		degreeToConvertLB.setOpaque(true);     // ** JLabel�� ������ �����Ϸ��� true�� �����ؾ� �� **
		degreeToConvertLB.setBackground(Color.yellow);
		degreeToConvertLB.setFont(new Font("���", Font.PLAIN, 14));  // (���ü, �Ϲ� ��Ʈ, ũ�� 14)�� ��Ʈ ����

		// degreeConvertedLB�� �Ӽ� ����
		degreeConvertedLB.setOpaque(true);     // ** JLabel�� ������ �����Ϸ��� true�� �����ؾ� �� **
		degreeConvertedLB.setBackground(Color.yellow);
		
		degreeToConvertLB.setFont(new Font("Times New Roman", Font.PLAIN, 14));  // (Times, �Ϲ� ��Ʈ, ũ�� 14)�� ��Ʈ ����
		
		degreeToConvertTF.setBackground(Color.cyan);		
		degreeToConvertTF.setFocusable(true);  // setFocusable(true)�� ��Ŀ���� ���� �� �ְ� ��
		
		degreeConvertedTF.setBackground(Color.cyan);
		degreeConvertedTF.setEnabled(true);     //setEnabled(true)�� �ϸ� �Է¹��� �� �ְ� ��       
		degreeConvertedTF.setFocusable(false);  // setFocusable(false)�� ��Ŀ�� ���� �� ���� �� - �Էµ� �Ұ�
	}
	
	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ� 
	static void addComponents() {   
		frame.add(titleLB);  // Ÿ��Ʋ�� ���� ���̺� �߰�  

		frame.add(degreeToConvertLB);  // �Է¹��� ȭ���µ��� ���� ���̺� �߰� 
		frame.add(degreeToConvertTF);  // �Է¹��� ȭ���µ��� ���� �ؽ�Ʈ�ʵ� �߰� 

		frame.add(degreeConvertedLB);  // ��ȯ�� �����µ��� ����  ���̺� �߰� 
		frame.add(degreeConvertedTF);  // ��ȯ�� �����µ��� ���� �ؽ�Ʈ�ʵ� �߰�
	}

	// �����츦 ���÷��̿� ��Ÿ���� �ϰ� �Է��� ��ٸ��� �ϴ� �޼ҵ�
	//  �Է��� �߻��ϸ� �̺�Ʈ ��ü�� �����ǰ� ��ϵ� �̺�Ʈ �����ʿ� ���� ó����   
	static void showFrame() {
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��       
	}

	// ȭ���µ� �Է¹޴� �ؽ�Ʈ�ʵ� degreeToConvertTF���� ȭ���µ� �ԷµǸ�   
	//   �̸� ó���ϱ� ���� �̺�Ʈ ������ ��ü ��Ͻ�Ű�� �޼ҵ�
	//   degreeToConvertTF ��ü���� Ű���� �ԷµǸ� KeyEvent ��ü �����ǰ�  
	//   ��ϵ� KeyListener ��ü�� �̺�Ʈ ó�� �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭 KeyEvent ��ü�� �Ű������� ���޵�
	static void enrolEventListener() {
		KeyListener listener = new MyKeyListener();  // ������ ��ü ����
		degreeToConvertTF.addKeyListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}

	// KeyListener �������̽��� �����ϴ� �̺�Ʈ ������ Ŭ����(static nested Ŭ����)
	//   �� Ŭ������ KeyListener �������̽��� 3�� abstract �޼ҵ带 �����ؾ� �ϸ�,
	//   Ű �Է��� �Ϸ�� �� �ڵ������� ȣ��Ǵ� KeyReleased()�� �̿��Ͽ� �Է�ó��
	static class MyKeyListener implements KeyListener {
		String prevTF = "";  // ������ �Էµ� ȭ���µ� ���ڿ��� �����ϴ� �ʵ�
		
		public void keyPressed(KeyEvent e) {}  // �� �޼ҵ�� ������� ����    
		public void keyTyped(KeyEvent e) {}    // �� �޼ҵ�� ������� ���� 

		// Ű���忡�� Ű �Է��� �� ���� �Ϸ�Ǹ� �ڵ������� ȣ��Ǵ� �޼ҵ���
		// �Էµ� ���ڿ��� �����Ͽ� �������� �Ǽ� ȭ���µ��̸� ������ ��ȯ�Ͽ� ���
		public void keyReleased( KeyEvent e ) {
			String tf = degreeToConvertTF.getText(); // �Էµ� ȭ���µ� ���ڿ��� ����

			try {
				// �Էµ� ���ڿ��� �������� �Ǽ� ȭ���µ��̸� �̸� �����µ��� ��ȯ�Ͽ� ���
				double degreeToConvert = Double.parseDouble(tf);          // ���ڿ��� �Ǽ��� ��ȯ�ϴ� �޼ҵ�
				double degreeConverted = (degreeToConvert - 32) * 5 / 9;  // ȭ���� ������ ��ȯ
				
				degreeConvertedTF.setText(String.valueOf( 
						(long) (degreeConverted * 10000) / 10000.) );     // ��ȯ�� �����µ��� ���
				
				prevTF = tf;
			}
			catch(Exception ex) {
				// Double.parseDouble()�� ���ڿ��� �Ǽ��� ��ȯ �� ���� �߻��ϸ� ���ܸ� ó����
				if (tf.equals("") || tf.equals("-") || tf.equals(".")) {  // ���ο� ȭ���µ� �Է� �����̸�
					degreeConvertedTF.setText("");                        // ���� �����µ� �κ��� ����
					prevTF = tf;
				}
				else {
					degreeToConvertTF.setText(prevTF); // ȭ���µ� �κ��� ���� ���ڿ��� ��ü��Ŵ
					
					if (prevTF.equals("") || prevTF.equals("-") || prevTF.equals(".")) {  // ���ο� ȭ���µ� �Է� �����̸�
						degreeConvertedTF.setText("");                                    // ���� �����µ� �κ��� ����
					}
				}
			}
		}
	}
		
	public static void main(String[] args) {
		setupFrame();         // ������ ����
		setupComponents();    // ������Ʈ�� �Ӽ� ����
		addComponents();      // ������Ʈ���� ��ġ  
		enrolEventListener(); // degreeToConvertTF�� �̺�Ʈ ������ ��ü�� ��� 
		showFrame();          // �����츦 ��Ÿ���� �ϰ� �Է��� ��ٸ�
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
*   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *      - �� ���α׷��� ������ ����, ũ�� ���� 330 �ȼ�, ���� 125 �ȼ��� ����, ���� ��ư �߰�
 *      - ȭ���µ� �Է� ���� ������Ʈ �޽��� ����� ���̺�� �Է� �ؽ�Ʈ �ʵ带 �����쿡 �߰�  
 *      - ���� ��ư Ŭ���ϸ� ������ ������� ���α׷��� ����
 *      - ��ȯ�� �����µ� ��� ���� ������Ʈ �޽��� ����� ���̺�� �ؽ�Ʈ �ʵ带 �����쿡 �߰�     
 *               
 *   2) �� ���α׷��� ȭ���µ��� �Է��ϸ� ��ȯ�� �����µ��� ��µȴ�. 
 *      - �� ������ �Է� ������Ʈ�� degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� �Ǿ��� ����
 *      - Java���� �Է� ó���� ���� �Է� ������Ʈ�� ���� �̺�Ʈ ó���Ǿ�� ��
 *      
 *   3) setupFrame() �޼ҵ�� setupComponents() �޼ҵ忡 ���� �Ӽ��� �����ϴ� �۾��� �߰��Ǿ�
 *      ��ũ���� ���÷��̵Ǵ� �������� �ܾ��� �޶�����.
 *   
 * 
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� setupFrame() �޼ҵ�� setupComponents() �޼ҵ��� �Ӽ��� 
 *      ������ ���� �����Ͽ� �������� �ܾ��� �������� ���� Ȯ���϶�.
 *       
 *      - �������� ũ�⸦ (900, 700)���� �����϶�.
 *      - �������� ������ Color.white�� �����϶�.
 *      - titleLB�� ������ new Color(200, 200, 200)����, ������� new Color(20, 20, 20)���� �����϶�.
 *      
 *   2) ������ ���� �̸����� ǥ���ϴ� ���� Color.WHITE, Color.white, CoLor.BLACK, Color.black �� ���� ������ �ִ�.
 *      Java���� �����ϴ� ���� �̸��� �˾ƺ��� �̸� �̿��Ͽ� �� ������Ʈ�� ������ �����غ���.     
 */
     