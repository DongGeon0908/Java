import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonArray ] : ��ư �迭�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *   o �̺�Ʈ �߻� ��ư���� �ټ��� �� �̸� �迭 ���ҷ� ����
 *     - ��ư���� ��ư �迭�� �����Ͽ� for �� �̿��Ͽ� ��ü������ �����ϰ� ��
 * 
 *   o �̺�Ʈ �߻� ��ư�� �ټ��� �� �ϳ��� ������ Ŭ���� �ۼ�
 *     - ��� ��ư�� �ϳ��� ������ ��ü�� ����Ͽ� �̺�Ʈ ó�� �޼ҵ忡�� �̺�Ʈ �߻� ��ư Ȯ���Ͽ� 
 *       �ش� ��ư�� ���� �̺�Ʈ ó��
 *       
 *     - ����: �ϳ��� ������ Ŭ����, �ϳ��� ������ ��ü �������� ���� 
 *     
 *     - ����: �ϳ��� ������ Ŭ�������� ���� ��ư �� �̺�Ʈ �߻��� �ҽ� ã�� �ҽ��� �̺�Ʈ  ó���ؾ� �ϹǷ� 
 *            �̺�Ʈ ó���� �ټ� ����
 *            
 *     - ������ ���α׷��� ������ �����
 */

public class Ex12_6_1_3_Calculator1_ButtonArray  {
	
	public static void main(String [] args) {
		new  CalculatorFrame_ButtonArray();
	}
}

class CalculatorFrame_ButtonArray extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	String[] oprNames = { "���ϱ�", "����", "���ϱ�", "������" };
	String[] oprSign = { " + ", " - ", " * ", " / " };
	
	JButton[] btnOprs  = new JButton[4];

	JLabel opr;

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	CalculatorFrame_ButtonArray() {
		setTitle("���� - JButton �迭 �̿�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10));       // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(opr = new JLabel(oprSign[0]));

		add(tf2 = new JTextField("2345", 10));       // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));         // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		ActionListener listener = new MyActionListener(); // Action ������ ��ü ����

		for (int i=0; i<4; i++) {
			btnOprs[i] = new JButton(oprNames[i]);   // ��ư ��ü �����Ͽ� �迭 ���ҷ� ����
			btnOprs[i].addActionListener(listener);  // ��ư ��ü�� ������ ��ü ���
			add(btnOprs[i]);                         // ��ư ��ü�� JFrame ��ü�� ��ġ
		}

		setBounds(500, 400, 450,150);	
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// 4�� ��ư�� ���� ��� Action �̺�Ʈ ó���ϴ� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ActionListener �����ϴ�  Action ������
    //   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ���
	class MyActionListener implements ActionListener {
		
		// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// e.getSource() �޼ҵ�� ���õ� ��ư ��ü ����

			try {			// tf1�� tf2�� �Էµ� �������� ������ ���� �����ڿ� ���� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
                int res = 0;

				for (int i=0; i < btnOprs.length; i++)  // Ŭ���� ��ư�� ã�� �ش� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					if (b == btnOprs[i]) {
						opr.setText(oprSign[i]);        // Ŭ���� ��ư�� ������ ���
						
						if (i == 0) res = op1 + op2;    // Ŭ���� ��ư�� ���� ��� ���
						else if (i == 1) res =  op1 - op2;
						else if (i == 2) res =  op1 * op2;
						else if (i == 3) res =  op1 / op2;

						tfRes.setText(" " + res);      // ��� ��� ���
					}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) 4�� ��ư�� ���� �ϳ��� ������ Ŭ������ �ۼ��ϰ� ��� ��ư�� ���� ������ ��ü�� ����Ͽ���.
 *      �ϳ��� ������ Ŭ�������� 4�� ��ư�� ���� �̺�Ʈ�� ó���� �� �ֵ��� �ڵ尡 �ۼ��Ǹ�,
 *      Ư�� �̺�Ʈ �ҽ��� ã�� ������ ó���� �� �� �ֵ��� �̺�Ʈ ó�� �޼ҵ尡 �ۼ��Ǿ���.
 *     
 *      - �̺�Ʈ �ҽ��� ã�� ���� ȣ��� �̺�Ʈ ó�� �޼ҵ��� �Ű������� �־��� �̺�Ʈ ��ü�� ���� getSource() �޼ҵ带 ȣ���Ѵ�.
 *     
 *   2) ��ư ������ �ټ��� �� �迭 �̿��ϸ� ��ư ����, ��ġ, ������ ��ü ��� ���� ����������
 *      ������ Ŭ������ �̺�Ʈ ó�� �޼ҵ��� �ۼ��� ��������
 *
 *      - for ������  ��ư ��ü�� ����, ������ ��ü ���, ��ġ, �̺�Ʈ �ҽ� ã�� �� ����
 *                  
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   4) ���� 12-6-1-2�� ���α׷��� ���Ͽ� ��ư �迭 Ȱ���� ������ �ľ��϶�.   
 *    
 *   5) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *      
 */
