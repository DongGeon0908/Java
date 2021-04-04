// GUI ���α׷����� ���� import
import java.awt.*;
import javax.swing.*;        
       
/**
 * [ TemperatureConversion_SubClassOfJFrame ]: 
 *       ȭ���µ��� �����µ��� ��ȯ�Ͽ� ����ϴ� GUI ����
 *       (JFrame�� ���� Ŭ������ �ۼ�, �Է� ó�� ����)     
 *        
 *   o �µ� ü��
 *     1) �����µ�(���� C): ��� �µ�: 0, ���� �µ�: 100 (100 ��н�Ų �µ�ü��)
 *     2) ȭ���µ�(���� F): ��� �µ�: 32, ���� �µ�: 212 (180 ��н�Ų �µ�ü��)
 *     3) Ķ��(Kelvin)�µ�(���� K): -273.15C�� 0K�� ����, Ķ��µ� 0K ������ �µ��� 
 *                               ���� �����п��� ����ϴ� ���� �µ�ü��
 *       
 *   o ȭ���µ����� �����µ����� ��ȯ
 *      C = (F - 32) * 5 / 9;
 *       
 *   o GUI ������ ������ ������Ʈ ��ġ
 *     - �밳 ����� ȭ���� ���� ũ���� ������� ����
 *     - �����쿡 �ش�Ǵ� Ŭ������ JFrame�� JDialog�� ������, �̵��� �ֻ��� �����̳�     
 *     - �����쿡�� ���� ������� ���� ������Ʈ(component)���� ȭ�� ������ ���� ������ ��ġ
 *     - ������Ʈ ���� �Ϻδ� �Է��� ���� ������Ʈ, �Ϻδ� ����� ���� ������Ʈ, �Ϻδ� ������� ���� ������Ʈ�� ���� 
 *         
 *   o ��ǥ�� ������Ʈ
 *     - �Է� ������Ʈ: JButton, JList, JCheckBox, JMenuItem
 *     - ��� ������Ʈ: JLabel 
 *     - ����� ������Ʈ: JTextField, JPanel, JTable
 *       
 *   o JFrame�� Ȯ���� ���� Ŭ������ ������ �ۼ�
 *     - JFrame�� ���� ������Ʈ ��ġ�� ��� JFrame�� ���� Ŭ������ ������ �ۼ��ϴ� ���� ����
 *     - ��ü �������� ������� Ŭ���� �ۼ� �����ϸ� ��ġ�Ǵ� ������Ʈ�� ������ ���� ����
 *     
 *         class XxxFrame extends JFrame {
 *              << frame�� ��ġ�� ������Ʈ�� ��ü �ʵ�� ���� >>
 *              
 *              XxxFrame(String title) {  // ��ü ������
 *                 super(title);
 *              }
 *              
 *              << ��ġ�� ������Ʈ ���� �� ����, ��ġ, ������ ��� ���� ���� �ڵ� �ۼ�  >> 
 *          }
 */

// JFrame�� Ȯ���ϴ� ���� Ŭ������ ������ �ۼ��ϱ�
class TemperatureConversionFrame extends JFrame  {

	// ���α׷� Ÿ��Ʋ ����� ���� ���̺� ����
	JLabel titleLB = new JLabel("Conversion of Fahrenheit to Centigrade");

	// �Է¹��� ȭ���µ��� ���� ������Ʈ �޽��� ���̺� �� �ؽ�Ʈ�ʵ� ����
	JLabel degreeToConvertLB = new JLabel("Fahrenheit degree to convert:");
	JTextField degreeToConvertTF = new JTextField(10);

	// ��ȯ�� �����µ��� ���� ���̺� �� �ؽ�Ʈ�ʵ� ���� 
	JLabel degreeConvertedLB = new JLabel("Centigrade degree converted:");
	JTextField degreeConvertedTF = new JTextField(10);

	// ��ü ������ - �ʿ��� ������Ʈ�� ��ġ�� ������ ����
	TemperatureConversionFrame(String title) {
		super(title);  // ���� Ŭ������ JFrame�� ��ü �����ڸ� �ݵ�� ȣ���ؾ� ��
	}

	// �����츦 ���� ���� �޼ҵ�
	void setupFrame() {   
		setLayout(new FlowLayout());  // ������Ʈ ��ġ ����� FlowLayout���� 
		setSize(330, 125);            // ���� 330�ȼ�, ���� 125�ȼ� ũ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� �ɼ� ����
	}

	// �����쿡 �ʿ��� ������Ʈ�� �߰��Ͽ� ��ġ�ϴ� �޼ҵ�
	void addComponents() {   
		add(titleLB);  // Ÿ��Ʋ�� ���� ���̺� �߰�  

		add(degreeToConvertLB);  // �Է¹��� ȭ���µ��� ���� ���̺� �߰� 
		add(degreeToConvertTF);  // �Է¹��� ȭ���µ��� ���� �ؽ�Ʈ�ʵ� �߰� 

		add(degreeConvertedLB);  // ��ȯ�� �����µ��� ���� ���̺� �߰� 
		add(degreeConvertedTF);  // ��ȯ�� �����µ��� ���� �ؽ�Ʈ�ʵ� �߰�
	}
}    

class Ex12_3_07_TemperatureConversion_SubClassOfJFrame {
	public static void main(String[] args) {
		TemperatureConversionFrame frame 
		       = new TemperatureConversionFrame("Temperature Conversion");
		frame.setupFrame();     // ������ ����
		frame.addComponents();  // ������Ʈ���� ��ġ    
		frame.setVisible(true); // frame�� setVisible(true)�� �ϸ� �����찡 ��Ÿ�� 
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *      - TemperatureConversionFrame Ŭ������ JFrame�� ���� Ŭ������ �ۼ�
 *      - ��� ������Ʈ���� ��ü �ʵ忡 ����Ǹ�, ��� �޼ҵ尡 ��ü �޼ҵ�� �ۼ�
 *             
 *   2) ���α׷��� �����ϰ� ����� Ȯ���϶�.
 *   
 *   3) �� ���α׷��� ȭ���µ��� �Է��Ͽ��� ��ȯ�� �����µ��� ��µ��� �ʴ´�.
 *      �� ������ �Է� ������Ʈ�� degreeToConvertTF �ؽ�Ʈ�ʵ忡 ���� �̺�Ʈ ó���� ���� �ʱ� �����̴�.
 *      Java���� �Է� ó���� ���ؼ��� �Է� ������Ʈ�� ���� �̺�Ʈ ó���� �Ǿ�� �Ѵ�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   o �̸�, ����, ����ġ�� �Է��ϱ� ���� GUI ���α׷��� PersonInfoFrame Ŭ������ �ۼ��Ϸ� �Ѵ�.
 *      Ex12_3_4_JFrameOfGridLayout.java�� �����Ͽ� PersonInfoFrame Ŭ������ 
 *      JFrmae Ŭ������ ���� Ŭ������ �ۼ��϶�.   
 */
