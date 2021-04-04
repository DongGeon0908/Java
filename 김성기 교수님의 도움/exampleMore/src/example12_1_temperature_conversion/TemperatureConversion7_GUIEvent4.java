package example12_1_temperature_conversion;

import java.awt.*;
import javax.swing.*;        
import java.awt.event.*;

/**
 * [ TemperatureConversion7_GUIEvent4 ]: 
 *     - JFramne�� ���� Ŭ������ �ۼ�
 *     - ȭ���µ��� �����µ���, �����µ��� ȭ���µ��� ��ȯ�Ͽ� ����ϴ� ���α׷�(�Է� ó�� ��)
 *        
 *     o �µ� ü��
 *       1) �����µ�(���� C): ��� �µ�: 0, ���� �µ�: 100 (100 ��н�Ų �µ�ü��)
 *       2) ȭ���µ�(���� F): ��� �µ�: 32, ���� �µ�: 212 (180 ��н�Ų �µ�ü��)
 *       3) Ķ��(Kelvin)�µ�(���� K): -273.15C�� 0K�� ����, Ķ��µ� 0K ������ �µ��� ���� 
 *                                 �����п��� ����ϴ� ���� �µ�ü��
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

class TemperatureConversionFrame extends JFrame  {
	
	// ��ü ������
	TemperatureConversionFrame(String title) {
		super(title);
	}
	
	// ���α׷� Ÿ��Ʋ ����� ���� ���̺� ����
	JLabel titleLB = new JLabel("    Conversion of Fahrenheit and Centigrade    ");
	JLabel dummyLB1 = new JLabel("         ");
	JLabel dummyLB2 = new JLabel("         ");
	
	// �Է¹��� ȭ���µ��� ���� ������Ʈ �޽��� ���̺� �� �ؽ�Ʈ�ʵ�  ����
	JLabel fahrenheitLB = new JLabel("  Fahrenheit degree:");
	JTextField fahrenheitTF = new JTextField(10);

	// ��ȯ�� �����µ��� ���� ���̺� �� �ؽ�Ʈ�ʵ� ���� 
	 JLabel centigradeLB = new JLabel("Centigrade degree:");
	JTextField centigradeTF = new JTextField(10);

	JButton toCentigradeBt = new JButton("to Centigrade");
	JButton toFahrenheitBt = new JButton("to Fahrenheit");
	JButton resetBt = new JButton("   reset   ");

	// �����츦 ���� frame ���� �޼ҵ�
	void setupFrame() {   
		setLayout(new FlowLayout());  // ������Ʈ ��ġ ����� FlowLayout���� 
		setSize(400, 170);            // ���� 400�ȼ�, ���� 170�ȼ� ũ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����	
	}

	// ������Ʈ ���� �޼ҵ�
	void setupComponents() {   
		toCentigradeBt.setSize(50, 250);  // toCentigradeBt ũ�� ���� 
		toFahrenheitBt.setSize(50, 150);  // toFahrenheitBt ũ�� ����  
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		add(dummyLB1);  // Ÿ��Ʋ�� ���� ���̺� �߰�  
		add(titleLB);  // Ÿ��Ʋ�� ���� ���̺� �߰�  
		add(dummyLB2);  // Ÿ��Ʋ�� ���� ���̺� �߰�  

		add(fahrenheitLB);  // �Է¹��� ȭ���µ��� ���� ���̺� �߰� 
		add(fahrenheitTF);  // �Է¹��� ȭ���µ��� ���� �ؽ�Ʈ�ʵ� �߰� 
		add(toCentigradeBt);  // �����µ��� ��ȯ ��ư �߰� 

		add(centigradeLB);  // ��ȯ�� �����µ��� ����  ���̺� �߰� 
		add(centigradeTF);  // ��ȯ�� �����µ��� ���� �ؽ�Ʈ�ʵ� �߰�		
		add(toFahrenheitBt);  // ȭ���µ��� ��ȯ ��ư �߰� 

		add(resetBt);         // reset ��ư �߰� 
	}

	// �����츦 ���÷��̿� ��Ÿ���� �ϰ� �Է��� ��ٸ��� �ϴ� �޼ҵ�
	//  �Է��� �߻��ϸ� �̺�Ʈ ��ü�� �����ǰ� ��ϵ� �̺�Ʈ �����ʿ� ���� ó����   
	void showFrame() {
		setVisible(true);   // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ��       
	}

	// ȭ���µ��� �Է¹޴� �ؽ�Ʈ�ʵ� fahrenheitTF���� ȭ���µ��� �ԷµǸ�   
	//  �̸� ó���ϱ� ���� �̺�Ʈ ������ ��ü�� ��Ͻ�Ű�� �޼ҵ�
	//  JButton ��ü���� ���콺 Ŭ���� �Ǹ�  
	//  ��ϵ� Button_Listener ��ü�� �̺�Ʈ �޼ҵ尡 �ڵ������� ȣ��Ǹ鼭 MouseEvent ��ü�� �Ű������� ���޵�
	void enrolEventListener() {
		Button_Listener listener = new Button_Listener(); // ������ ��ü ����
		toCentigradeBt.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
		toFahrenheitBt.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
		resetBt.addMouseListener(listener);  // ������ ��ü�� ��Ͻ�Ŵ
	}

	// MouseAdapter�� Ȯ���ϴ� ��ư �̺�Ʈ ������ Ŭ����(���� Ŭ����)
	//  �� Ŭ������ MouseAdapter�� mousePressed() �޼ҵ带 �������̵���
	//  ���콺 Ŭ���� �Ϸ�� �� �ڵ������� ȣ��Ǵ�  mousePressed()�� �̿��Ͽ� �Է�ó��
	class Button_Listener extends MouseAdapter {
		// mousePressed() �޼ҵ�� ���콺 Ŭ���� �Ϸ�� ��  �ڵ������� ȣ��Ǵ� �޼ҵ���
		// �Էµ� ���ڿ��� �����Ͽ� �������� �Ǽ� �µ��̸� �ٸ� �µ��� ��ȯ�Ͽ� ���
		public void mousePressed(MouseEvent e) { 
			JTextField degreeToConvertTF = null;
			JTextField degreeConvertedTF = null;

			String tf ="";

			double degreeToConvert = 0;   // �Է¿µ� �����ϴ� ����
			double degreeConverted = 0;   // ��ȯ�� �µ� �����ϴ� ����

			Object src = e.getSource();  // �̺�Ʈ �߻��� �ҽ��� ����
			if (src == resetBt) {           // �Է� �̺�Ʈ �߻� �ҽ��� reset ��ư�̸�
				fahrenheitTF.setText("");   //   ȭ���µ� �κ��� ����
				centigradeTF.setText("");   //   �����µ� �κ��� ����
				return;
			}
			else if (src == toCentigradeBt) {       // �Է� �̺�Ʈ �߻� �ҽ��� �����µ� ��ȯ ��ư�̸�
				degreeToConvertTF = fahrenheitTF;   //   �Է� �ؽ�Ʈ�ʵ带 ȭ���µ� �ؽ�Ʈ�ʵ�� ����
				degreeConvertedTF = centigradeTF;   //   ��ȯ�� �ؽ�Ʈ�ʵ带 �����µ� �ؽ�Ʈ�ʵ�� ����
			}
			else if (src == toFahrenheitBt) {       // �Է� �̺�Ʈ �߻��ҽ���  ȭ���µ� ��ȯ ��ư�̸�
				degreeToConvertTF = centigradeTF;   //   �Է� �ؽ�Ʈ�ʵ带 �����µ� �ؽ�Ʈ�ʵ�� ����
				degreeConvertedTF = fahrenheitTF;   //   ��ȯ�� �ؽ�Ʈ�ʵ带 ȭ���µ� �ؽ�Ʈ�ʵ�� ����			
			}

			tf = degreeToConvertTF.getText(); // �Էµ� �µ� ���ڿ��� ����

			try {
				// �Էµ� ���ڿ��� �������� �Ǽ� �µ��̸� �䱸�Ǵ� �µ��� ��ȯ�Ͽ� ���
				degreeToConvert = Double.parseDouble(tf);          // ���ڿ��� �Ǽ��� ��ȯ�ϴ� �޼ҵ�

				if (src == toCentigradeBt)
					degreeConverted = (degreeToConvert - 32) * 5 / 9; // ȭ���� ������ ��ȯ
				else if (src == toFahrenheitBt)
					degreeConverted = degreeToConvert * 9 / 5 + 32;   // ������ ȭ���� ��ȯ

				degreeConvertedTF.setText(String.valueOf( 
						(long) (degreeConverted * 10000) / 10000.) );    // ��ȯ�� �µ� ���				
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "'"+ tf + "' : �߸��� �Ǽ�");
			}
		}
	}
	
	public static void main(String[] args) {
		TemperatureConversionFrame frame = new TemperatureConversionFrame("Temperature Conversion 6");

		frame.setupFrame();         // ������ ����
		frame.setupComponents();    // ������Ʈ���� ����
		frame.addComponents();      // ������Ʈ���� ��ġ  
		frame.enrolEventListener(); // fahrenheitTF�� �̺�Ʈ ������ ��ü�� ��� 
		frame.showFrame();          // �����츦 ��Ÿ���� �ϰ� �Է��� ��ٸ�
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �� ���α׷��� ȭ���µ��� �����µ� �� �µ���ȯ�Ͽ� ����ϴ� GUI ���α׷��̴�.
 *   
 *   2) ���α׷��� �����Ͽ� ��� Ȯ���϶�.
 *   
 *   3) ��ü ���α׷��� ������ �̺�Ʈ ó���� ���� ���������� �ľ��϶�.
 */
