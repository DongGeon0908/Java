import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * [ Calculator5_Desktop ]: Ź��� ���⸦ �����ϴ� GUI ���α׷�
 * 
 *   o ��� ��� ����ϴ� �ؽ�Ʈ�ʵ�� 16���� Ű�� ȭ�� ����
 *   
 *   o ù ��° �ǿ�����, ������, �� ��° �ǿ������� �Է¿� ���� ������ ó���� ����
 *   
 *   o 16���� ��ư�� ���� Action �̺�Ʈ �����ʷ� �̺�Ʈ ó��
 *
 *   o �ҽ� �ڵ� �� �м��Ͽ� ������ �� �ֵ��� ����� ��
 */

class Calculator5_Desktop extends JFrame  {

	// ���⸦ �����ϴ� ������Ʈ�� ����
	private JPanel keyPadPanel = new JPanel();          // Ű ��ư�� ����� �ؽ�Ʈ�ʵ� ��ġ�� �г�
	private JTextField resultTF = new JTextField(20);   // ����� ���÷����� �ؽ�Ʈ�ʵ�
	private JButton keyButtons[]  = new JButton[16];    // 16�� Ű ��ư
	
	// ó���� ���� ������ ����
	String keyNames[] = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0", "=", "/" };
	private double result  = 0.0;                       // ��� �����ϴ� ����
	private boolean isFirstOperand = true;              // ù ��° �ǿ����� �Է��̸� true, �ƴϸ� false�� ����
	static boolean mustTextFieldCleared= true;          // ��� �ؽ�Ʈ�� �������� �ϴ°� ��Ÿ���� ����
	private int operator = 0;                       // ���������� ������ ������ ����

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	public Calculator5_Desktop() {
		setTitle("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());                // JFrame ��ü�� Border ���̾ƿ����� ����		

		add(resultTF, BorderLayout.NORTH);            // ����� �ؽ�Ʈ�ʵ带 ���ʿ� ��ġ
		resultTF.setEditable(false);                  // ������ �ؽ�Ʈ�ʵ忡 �Է����� ���ϵ��� ����

		add(keyPadPanel, BorderLayout.CENTER);        // Ű�е� �г��� �߾ӿ� ��ġ

		//16�� Ű ��ġ�� Ű�е� �г��� 4 * 4 grid layout���� ����
		keyPadPanel.setLayout(new GridLayout(4, 4));

		// 16 Ű ��ư �����Ͽ� Ű�е� �гο� ��ġ
		for (int i = 0; i < 16; i++) {
			keyButtons[i] = new JButton(keyNames[i]); // Ű ��ư ����
			keyPadPanel.add(keyButtons[i]);           // Ű�е� �гο� Ű ��ư ��ġ
		}

		MyActionListener listener = new MyActionListener();  // Ű ��ư�� ���� Action ������ ��ü ����
		for ( int i = 0; i < 16; i++) {
			keyButtons[i].addActionListener(listener);       // Ű ��ư�� Action ������ ��ü ���
		}
		
		setBounds(300, 200, 220, 220);   // JFrame ��ü�� ũ��� ��ġ ����
		
		setVisible(true);                // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	//  Action �̺�Ʈ ó���ϴ� ������ Ŭ����(���� Ŭ������ �ۼ�)
    //   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ���
	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// �Էµ� Ű�� ó���� ������ for ���� �ݺ�
			for ( int i = 0; i < 16 ; i++) {
				JButton bt = (JButton) e.getSource();
				
				if( bt == keyButtons[i]) {  // Ű��  ã������
					processKey(i);
				}
			}
		}

		// ������ Ű�� ���� ó���ϴ� �޼ҵ�
		void processKey(int keyNo) {			
			switch(keyNo) {
			// ���� Ű �� .(period) Ű �Է� ���� ó��
			case 0:   case 1:   case 2:   case 4:   case 5:              // 1, 2, 3, 4, 5
			case 6:   case 8:   case 9:   case 10:  case 12:  case 13:   // 6, 7, 8, 9, ., 0

				if(mustTextFieldCleared) {   // ó������ ���� Ű Ŭ���Ǹ� ���� �ؽ�Ʈ�ʵ� ������ ����
					resultTF.setText("");
					mustTextFieldCleared = false;
				}

				// �ؽ�Ʈ�ʵ��� ���� �ڿ� �Էµ� ���ڸ� ���
				resultTF.setText(resultTF.getText() + keyButtons[keyNo].getText());					

				break;

				// ������ �Է� ���� ó��
			case 3:  case 7:  case 11: case 14: case 15: // ���ϱ�, ����, ���ϱ�, = , ������

				// mustTextFieldCleared ������ true�� �Ͽ� ���� ���� Ű Ŭ�� �� �ؽ�Ʈ�ʵ带 ����� ��
				mustTextFieldCleared = true;

				if (isFirstOperand) {  // ù �ǿ����� �ԷµǾ�����, ���� �ǿ����ڸ� ��ٸ��� ��	
					// �ؽ�Ʈ�ʵ� ���� result ������ ������
					if(resultTF.getText().length() == 0) 
						result = 0.0;
					else
						result = Double.valueOf(resultTF.getText());

					if (keyNo == 14)  // = ��ư�̸� result�� �ؽ�Ʈ�ʵ忡 ���
						resultTF.setText(toString(result));

					isFirstOperand = false;
					operator = keyNo; // �Էµ� �������� �ε����� operator ������ ����
				}
				else { // �� ��° �ǿ����ڰ� �ԷµǾ�����, result, operator, �ؽ�Ʈ�ʵ��� ������ ����Ͽ� ��� ���	

					switch(operator) {
					case 3: // ���ϱ�
						result += Double.valueOf(resultTF.getText());
						break;

					case 7: // ����
						result -= Double.valueOf(resultTF.getText());
						break;

					case 11: // ���ϱ�
						result *= Double.valueOf(resultTF.getText());
						break;

					case 15: // ������
						result /= Double.valueOf(resultTF.getText());
						break;

					case 14: // =
						result = Double.valueOf(resultTF.getText());
						break;

					}

					resultTF.setText(toString(result)); // ����� �ؽ�Ʈ�ʵ忡 ���

					if (keyNo == 14)          // = �������̸�  isFirstOperand�� true�� 
						isFirstOperand = true;
					else
						operator = keyNo;     // �ƴϸ� �Էµ� �������� �ε����� operator ������ ����
				}

				break;
			}
		}

		// double Ÿ���� ���� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		//  �Ҽ��� ���ϰ��� ������ ���� ���ڿ��� ��ȯ��
		String toString(double d) {
			String s = "";

			if (d == (int) d)      // �Ҽ��� ���ϰ��� ������ 
				s = s + (int) d;   //   ���� ���ڿ��� ��ȯ
			else
				s = s + d;

			return s;
		}		
	}
}

class Ex12_6_5_Calculator5_Desktop {
	public static void main(String[] args)  {
		System.out.println("Starting Calculator...");
		new Calculator5_Desktop();
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) 16�� Ű�� ������ Ű�е带 �̿��Ͽ� Ź��� ���⸦ �����Ͽ���.
 *      - ����Ű�� . Ű�� Ŭ���Ǹ� ���� �ǿ����ڿ� ������ �ǿ����ڸ� ���н��� ó���� �� �ְ� ��
 *      - ���� �ǿ����ڰ� �ԷµǸ� �����ڸ� ��ٸ����� ó��
 *      - ������ �ǿ����� �ԷµǸ� ������ �����Ų �����ڷ� ���� �����Ͽ� ������ ���� ��� �ؽ�Ʈ�ʵ忡 ���÷���
 *      - ������ Ű�� Ŭ���Ǹ� ������ �ǿ����� �� ����� �� �ֵ��� �����ڸ� ������
 *     
 *   2) ��ü���� ó�� ������ �ټ� �����ϹǷ� �ҽ� �ڵ带 �� �о�鼭 �����ؾ� �Ѵ�.
 *               
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.  
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.      
 */ 
