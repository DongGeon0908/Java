package ex06_temperature;
import java.awt.*;

import javax.swing.*;        

import java.awt.event.*;


/*
 * [ TemperatureConversion_GUI ]: GUI�� �ۼ���, ȭ�� �µ��� ���� �µ��� ��ȯ�Ͽ� ����ϴ� ���α׷�
 *                                (�Է� ó���� ��)
 *        
 *     o �µ� ü��
 *       1) �����µ�(���� C): ��� �µ�: 0, ���� �µ�: 100 (100 ��н�Ų �µ�ü��)
 *       2) ȭ���µ�(���� F): ��� �µ�: 32, ���� �µ�: 212 (180 ��н�Ų �µ�ü��)
 *       3) Ķ��(Kelvin)�µ�(���� K): -273.15C�� 0K�� ����, Ķ��µ� 0K ������ �µ��� ���� �����п��� ����ϴ� ���� �µ�ü��
 *       
 *     o ȭ���µ����� �����µ����� ��ȯ
 *       C = (F - 32) * 5 / 9;
 *       
 *     o GUI�� ������ ������ ������Ʈ ��ġ
 *       - �밳 ����� ȭ���� ���� ũ���� ������� ������
 *       - �����쿡 �ش�Ǵ� Ŭ������ JFrame�� JDialog�� ������, �̸� �ֻ��� �����̳ʶ�� ��       
 *       - �����쿡�� ���� ������� ���� ������Ʈ(component)���� ȭ�� ������ ���� ������ ��ġ
 *       - ������Ʈ ���� �Ϻδ� �Է��� ���� ������Ʈ, �Ϻδ� ����� ���� ������Ʈ, �Ϻδ� ������� ���� ������Ʈ�� ���� 
 *       
 *     o ��ǥ�� ������Ʈ
 *       - �Է� ������Ʈ: JButton, JList, JCheckBox, JMenuItem, JScrollBar
 *       - ��� ������Ʈ: JLabel
 *       - ����� ������Ʈ: JTextField, JPanel,JTable
 *       
 *     o �Է� ó���� ���� 3���� ����   
 *       1) �̺�Ʈ ������ Ŭ���� �ۼ�
 *       2) �̺�Ʈ ������ Ŭ������ ��ü ���� �� ����
 *       3) �̺�Ʈ ������ ��ü�� �Է� ������Ʈ�� ���
 */

class Ex12_1_3_TemperatureConversion_GUIEvent  {
	// �ʿ��� ������Ʈ�� ��ġ�� ������ ����
	static JFrame frame = new JFrame("Temperature Conversion");

	// ���α׷� Ÿ��Ʋ ����� ���� ���̺� ����
	static JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// �Է¹��� ȭ���µ��� ���� ������Ʈ �޽��� ���̺� �� �ؽ�Ʈ�ʵ�  ����
	static JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	static JTextField degreeToConvertTF = new JTextField(10);

	// ��ȯ�� �����µ��� ���� ���̺� �� �ؽ�Ʈ�ʵ� ���� 
	static  JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	static JTextField degreeConvertedTF = new JTextField(10);

	// �����츦 ���� frame ���� �޼ҵ�
	static void setupFrame() {   
		frame.setLayout(new FlowLayout());  // ������Ʈ ��ġ ����� FlowLayout���� 
		frame.setSize(330, 125);            // ���� 330�ȼ�, ���� 125�ȼ� ũ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
		
		
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	static void addComponents() {   
		frame.add(titleLB);  // Ÿ��Ʋ�� ���� ���̺� �߰�  

		frame.add(degreeToConvertLB);  // �Է¹��� ȭ���µ��� ���� ���̺� �߰� 
		frame.add(degreeToConvertTF);  // �Է¹��� ȭ���µ��� ���� �ؽ�Ʈ�ʵ� �߰� 

		frame.add(degreeConvertedLB);  // ��ȯ�� �����µ��� ����  ���̺� �߰� 
		frame.add(degreeConvertedTF);  // ��ȯ�� �����µ��� ���� �ؽ�Ʈ�ʵ� �߰�
		
		degreeConvertedTF.setFocusable(false);  // �� �ؽ�Ʈ�ʵ�� �Է����� ���ϰ� ��
	}

	// �����츦 ���÷��̿� ��Ÿ���� �ϰ� �Է��� ��ٸ��� �ϴ� �޼ҵ�
	//  �Է��� �߻��ϸ� �̺�Ʈ ��ü�� �����ǰ� ��ϵ� �̺�Ʈ �����ʿ� ���� ó����   
	static void showFrame() {
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��       
	}

	// ȭ���µ��� �Է¹޴� �ؽ�Ʈ�ʵ� degreeToConvertTF���� ȭ���µ��� �ԷµǸ�   
	//  �̸� ó���ϱ� ���� �̺�Ʈ ������ ��ü�� ��Ͻ�Ű�� �޼ҵ�
	//  degreeToConvertTF ��ü���� Ű���� �Է��� �Ǹ�   
	//  ��ϵ� KeyListener ��ü�� �̺�Ʈ �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭  KeyEvent ��ü�� �Ű������� ���޵�
	static void enrolEventListener() {
		KeyListener listener = new DegreeToConvertTF_Listener(); // ������ ��ü ����
		degreeToConvertTF.addKeyListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}

	// KeyListener �������̽��� �����ϴ� �̺�Ʈ ������ Ŭ����(���� Ŭ����)
	//  �� Ŭ������ KeyListener �������̽��� 3�� �߻� �޼ҵ带 �����ؾ� �ϸ�,
	//  Ű �Է��� �Ϸ�� �� �ڵ������� ȣ��Ǵ� KeyReleased()�� �̿��Ͽ� �Է�ó��
	static class DegreeToConvertTF_Listener implements KeyListener {
		static String prevTF = "";  // ������ �Էµ� ȭ���µ� ���ڿ��� �����ϴ� �ʵ�
		
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
				// Double.parseDouble()�� ���ڿ��� �Ǽ��� ��ȯ�� ���� �߻��ϸ� ���ܸ� ó����
				if (tf.equals("") || tf.equals("-") || tf.equals(".")) {
					degreeConvertedTF.setText("");   // �����µ� �κ��� ����
					prevTF = tf;
				}
				else {
					degreeToConvertTF.setText(prevTF); // ȭ���µ� �κ��� ���� ���ڿ��� ��ü��Ŵ
					
					if (prevTF.equals("") || prevTF.equals("-") || prevTF.equals(".")) {
						degreeConvertedTF.setText("");   // �����µ� �κ��� ����
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		setupFrame();         // ������ ����
		addComponents();      // ������Ʈ���� ��ġ  
		enrolEventListener(); // degreeToConvertTF�� �̺�Ʈ ������ ��ü�� ��� 
		showFrame();          // �����츦 ��Ÿ���� �ϰ� �Է��� ��ٸ�
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.
 *      - �� ���α׷��� �����츦 �����ϰ�  ũ�⸦ ���� 330�ȼ�, ���� 125�ȼ� ũ��� �ȼ��� �����ϸ�, 
 *        ���� ��ư�� Ŭ���ϸ� �����찡 �縮���� ���α׷��� ����ȴ�.
 *      - ȭ���µ��� �Է¹ޱ� ���Ͽ� ������Ʈ �޽����� ����� ���̺�� �ؽ�Ʈ �ʵ带 �����쿡 �߰��Ѵ�.  
 *      - ��ȯ�� �����µ��� ����ϱ� ���Ͽ� ������Ʈ �޽����� ����� ���̺�� �ؽ�Ʈ �ʵ带 �����쿡 �߰��Ѵ�.   
 *             
 *   2) �� ���α׷��� ȭ�� �µ��� �Է��ϸ� ��ȯ�� ���� �µ��� ��µȴ�. 
 *      �� ������ �Է¹޴� ������Ʈ�� degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� �Ǿ��� �����̴�.
 *      Java���� �Է¿� ���� ó���� ���ؼ��� �Է� ������Ʈ�� ���� �̺�Ʈ ó���� �Ǿ�� �Ѵ�.
 *      
 *   3) degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� 3���� �������� �����ȴ�.
 *      (1) KeyListener �������̽��� �����ϴ� �̺�Ʈ ������ Ŭ����(���� Ŭ����)�� 
 *          DegreeToConvertTF_Listener Ŭ���� �ۼ�
 *          
 *          ���⿡�� keyReleased( KeyEvent e ) �޼ҵ� �ۼ��� �߿��ϸ�, �� �޼ҵ�� �Էµ� ȭ���µ� ���ڿ��� 
 *          �����ͼ� �Է��� ó����
 *          
 *      (2) �̺�Ʈ ������ ��ü�� ����
 *          KeyListener listener = new DegreeToConvertTF_Listener(); // ������ ��ü ����		
 *      
 *      (3) �̺�Ʈ ������ ��ü�� degreeToConvertTF�� ���
 *          degreeToConvertTF.addKeyListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϴ� GUI ���α׷��̴�.
 *      �ݴ�� �����µ���  �Է��Ͽ� ȭ���µ��� ��ȯ�Ͽ� ����ϴ� ���α׷��� 
 *      Pr12_1_3_TemperatureConversion_GUIEvent_CtoF Ŭ������ �ۼ��϶�. 
 *      (�����µ� C�� ȭ���µ� F�� ��ȯ�ϴ� ������ F = C * 9 / 5  + 32 ��)
 *   
 *   2) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����Ѵ�. ȭ�� �µ��� Ķ�� �µ��� 
 *      ��ȯ�Ͽ� ����ϴ� ���α׷��� Pr12_1_3_TemperatureConversion_GUIEvent_CtoK Ŭ������ �ۼ��϶�.  
 *      (�����µ� C�� Ķ��µ� K�� ��ȯ�ϴ� ������ K = C + 273.15�̸�, 
 *       ȭ���µ����� �����µ��� ���� �� �ٽ� �����µ����� Ķ��µ��� ���� ����ϸ� ��) 
 */