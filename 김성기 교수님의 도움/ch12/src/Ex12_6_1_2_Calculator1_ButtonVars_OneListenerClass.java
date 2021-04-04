import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonVars2_OneListenerClass ]: ��ư�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *  o �̺�Ʈ �߻� ��ư�� �ټ��� �� �ϳ��� ������ Ŭ���� �ۼ�
 *    - 4���� ��ư�鿡 ���� 1�� ������ Ŭ���� �ۼ��ϰ� 1�� ������ ��ü�� �����Ͽ� 4���� ��ư�� ��� 
 *    
 *  o ��� ��ư�� �ϳ��� ������ ��ü�� ����Ͽ� �̺�Ʈ ó�� �޼ҵ忡�� �̺�Ʈ �߻� ��ư Ȯ���Ͽ� �ش� ��ư�� ���� �̺�Ʈ ó��
 *    - ����: �ϳ��� ������ Ŭ����, �ϳ��� ������ ��ü �������� ���� 
 *    - ����: �ϳ��� ������ Ŭ�������� ���� ��ư �� �̺�Ʈ �߻���  �ҽ� ã��  �ҽ��� �̺�Ʈ  ó���ؾ� �ϹǷ� �̺�Ʈ ó���� �ټ� ����
 *    - ��ȣ�ϴ� ���
 */

public class Ex12_6_1_2_Calculator1_ButtonVars_OneListenerClass extends JFrame {
	
	public static void main(String [] args) {
		new CalculatorFrame_ButtonVars_OneListenerClass();
	}
}

class CalculatorFrame_ButtonVars_OneListenerClass extends JFrame {

	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnAdd, btnSub, btnMult, btnDiv;
	JLabel opr;
	
	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	CalculatorFrame_ButtonVars_OneListenerClass() {
		setTitle("���� - JButton ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		add(tf1 = new JTextField("1234", 10));  // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(opr = new JLabel(" ? "));

		add(tf2 = new JTextField("2345", 10));  // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));    // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		/*
		 *  4�� ��ư ��ü �����Ͽ� ��ġ
		 */
		add(btnAdd = new JButton("���ϱ�"));
		add(btnSub = new JButton("����"));
		add(btnMult = new JButton("���ϱ�"));
		add(btnDiv = new JButton("������"));

		/*
		 * �ϳ��� ������ Ŭ���� �ۼ��Ͽ� �� ������ ��ü�� 4�� ��ư�� ��� ���
		 */
		MyActionListener listener = new MyActionListener();   // ������ ��ü ����

		btnAdd.addActionListener(listener);  // ��ư�� ������ ��ü ���
		btnSub.addActionListener(listener);  // ��ư�� ������ ��ü ���
		btnMult.addActionListener(listener); // ��ư�� ������ ��ü ���
		btnDiv.addActionListener(listener);  // ��ư�� ������ ��ü ���

		setBounds(500, 400, 450,150);	
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// 4�� ��ư�� ���� ��� Action �̺�Ʈ ó���ϴ� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ActionListener �����ϴ�  Action ������ Ŭ����
	//   Action �������� �̺�Ʈ ó�� �޼ҵ�� actionPerformed() �ϳ���
	//   �̺�Ʈ �߻��� ��ư�� ã�� �� ��ư�� �ش�Ǵ� �̺�Ʈ ó���ϵ��� ��
	class MyActionListener implements ActionListener {

		// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ� ������
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();// e.getSource() �޼ҵ�� ���õ� ��ư ��ü ����

			try {
				// tf1�� tf2�� �Էµ� ������ ������ ��ư�� ���� ��� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				if (b == btnAdd)  {      // Ŭ���� ��ư�� btnAdd�̸� ���ϱ� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					opr.setText(" + ");
					tfRes.setText(" " + (op1 + op2));
				}
				else if (b == btnSub)  { // Ŭ���� ��ư�� btnSub�̸� ���� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					opr.setText(" - ");
					tfRes.setText(" " + (op1 - op2));
				}
				else if (b == btnMult) { // Ŭ���� ��ư�� btnMult�̸� ���ϱ� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					opr.setText(" * ");
					tfRes.setText(" " + (op1 * op2));	
				}
				else if (b == btnDiv) {  // Ŭ���� ��ư�� btnDiv�̸� ������ ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					opr.setText(" / ");
					tfRes.setText(" " + (op1 / op2));		
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", 
						                                                 JOptionPane.ERROR_MESSAGE);
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
 *     		public void actionPerformed(ActionEvent e) {
 *			   JButton b = (JButton)e.getSource();// e.getSource() �޼ҵ�� ���õ� ��ư ��ü ����
 *      
 *      - �� ���� ������ �̺�Ʈ �ҽ��� �� ��ư�� ���Ͽ� 4�� ��ư �� ��� ��ư�ΰ��� Ȯ���Ѵ�.
 *     
 *          if (b == btnAdd)  { // Ŭ���� ��ư�� btnAdd�̸� ���ϱ� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
 *		     	opr.setText(" + ");
 *				tfRes.setText(" " + (op1 + op2));
 *			}
 *			else if (b == btnSub)  { // Ŭ���� ��ư�� btnSub�̸� ���� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
 *				opr.setText(" - ");
 *				tfRes.setText(" " + (op1 - op2));
 *			}
 *             ...   
 *             
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   3) �ϳ��� ������ Ŭ������ �ۼ��ϰ� ��� ��ư�� ������ ������ ��ü�� ����� ���� ������ �ľ��غ���.
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *  1) �� ���α׷��� ��ư�� ���� Action �̺�Ʈ�� ��ϵǾ� �ִ�. Action �̺�Ʈ�� �������� �ʰ� 
 *     Mouse �̺�Ʈ�� ���� ������ �� �ֵ��� ���α׷��� �����Ϸ��Ѵ�.
 *     
 *     �̸� ���Ͽ� ������ Ŭ������ MyMouseListener Ŭ������ 
 *     ���� Ŭ������ ������ ���� �ۼ��ϰ�, �� ������ Ŭ������  ��ü �ϳ��� �����Ͽ� 4�� ��ư�� ��� ����϶�.
 *     
 *     (1) Mouse �̺�Ʈ ó�� �޼ҵ� �߿��� buttonClicked(ActionEvent e) �޼ҵ�� �̺�Ʈ ó���ϵ��� 
 *         Mouse �������� �̺�Ʈ ó�� �޼ҵ带 �ۼ��϶�. 
 *         
 *     (2) �ٸ� �̺�Ʈ ó�� �޼ҵ�� �޼ҵ� ������ {}���� �ۼ��϶�.        
 */
