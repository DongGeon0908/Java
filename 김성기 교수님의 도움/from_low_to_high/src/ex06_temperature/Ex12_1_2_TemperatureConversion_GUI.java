package ex06_temperature;
import java.awt.*;

import javax.swing.*;        

/*
 * [ TemperatureConversion_GUI ]: GUI�� �ۼ���, ȭ�� �µ��� ���� �µ��� ��ȯ�Ͽ� ����ϴ� ���α׷�
 *                                (�Է� ó���� ���� ����)
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
 */

class Ex12_1_2_TemperatureConversion_GUI  {
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
	}

	// �����츦 ���÷��̿� ��Ÿ���� �ϰ� �Է��� ��ٸ��� �ϴ� �޼ҵ�
	//  �Է��� �߻��ϸ� �̺�Ʈ ��ü�� �����ǰ� ��ϵ� �̺�Ʈ �����ʿ� ���� ó����   
	static void showFrame() {
		frame.setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��       
	}

	public static void main(String[] args) {
		setupFrame();     // ������ ����
		addComponents();  // ������Ʈ���� ��ġ    
		showFrame();      // �����츦 ��Ÿ���� �ϰ� �Է��� ��ٸ�
	}
}


/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ���븦 �ľ��϶�.
 *      - �� ���α׷��� �����츦 �����ϰ�  ũ�⸦ ���� 330 �ȼ�, ���� 125 �ȼ��� �����ϸ�, ���� ��ư�� �߰��Ѵ�.
 *      - ȭ���µ��� �Է¹ޱ� ���Ͽ� ������Ʈ �޽����� ����� ���̺�� �ؽ�Ʈ �ʵ带 �����쿡 �߰��Ѵ�.  
 *      - ��ȯ�� �����µ��� ��¹ޱ� ���Ͽ� ������Ʈ �޽����� ����� ���̺�� �ؽ�Ʈ �ʵ带 �����쿡 �߰��Ѵ�.       
 *             
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶��.
 *   
 *   3) �� ���α׷��� ȭ�� �µ��� �Է��Ͽ��� ��ȯ�� ���� �µ��� ��µ��� �ʴ´�.
 *      �� ������ �Է¹޴� ������Ʈ�� degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� ���� �ʱ� �����̴�.
 *      Java���� �Է¿� ���� ó���� ���ؼ��� �Է� ������Ʈ�� ���� �̺�Ʈ ó���� �Ǿ�� �Ѵ�.
 *      
 *      ���� 12-1-3�� degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� �Ǵ� ���α׷��̴�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϱ� ���� �ۼ��� GUI ���α׷��̴�.
 *      �ݴ�� �����µ��� �Է��Ͽ� ȭ���µ��� ��ȯ�Ͽ� ����ϱ� ���� ���α׷��� 
 *      Pr12_1_2_TemperatureConversion_GUI_CtoF Ŭ������ �ۼ��϶�. 
 *      (�� ���α׷��� ���� ȭ�� �µ��� �Է��Ͽ��� ���� �µ��� ��µ��� �ʰ� �Ѵ�.)
 *   
 *   2) �� ���α׷��� ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϱ� ���� �ۼ��Ǿ���. 
 *      ȭ�� �µ��� Ķ�� �µ���  ��ȯ�Ͽ� ����ϱ� ���� ���α׷��� 
 *      Pr12_1_2_TemperatureConversion_GUI_ Ŭ������ �ۼ��϶�.  
 *      (�� ���α׷��� ���� ȭ�� �µ��� �Է��Ͽ��� Ķ�� �µ��� ��µ��� �ʰ� �Ѵ�.) 
 */