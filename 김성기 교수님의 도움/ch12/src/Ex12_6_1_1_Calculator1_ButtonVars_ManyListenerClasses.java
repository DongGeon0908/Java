import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * [ Calculator1_ButtonVars_ManyListenerClasses ]: 
 *       ��ư�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *  o �̺�Ʈ �߻� ��ư�� �ټ��� �� ��ư ����  ������ Ŭ���� �ۼ�
 *     - 4���� ��ư�鿡 ���� 4���� ������ Ŭ������ ������ ��ü�� �����Ͽ� ��ư�� ���
 * 
 *  o �� ��ư���� �ٸ� ������ Ŭ���� �ۼ��Ͽ� ��ư�� �̺�Ʈ ó�� ����
 *    - ����: �̺�Ʈ �ҽ��� ���� ������ �̺�Ʈ ó�� ����
 *    - ����: ������ Ŭ���� ���� �������� ������ ����� ������ ������ ��ü �����ؾ� ��
 *           ==> ��ȣ�ϴ� ����� �ƴ�
 */

public class Ex12_6_1_1_Calculator1_ButtonVars_ManyListenerClasses {
	public static void main(String [] args) {
		new CalculatorFrame_ButtonVars_ManyListenerClasses();
	}
}

class CalculatorFrame_ButtonVars_ManyListenerClasses extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnAdd, btnSub, btnMult, btnDiv;
	JLabel opr;

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	CalculatorFrame_ButtonVars_ManyListenerClasses() {
		setTitle("���� - JButton ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		add(tf1 = new JTextField("1234", 10)); // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(opr = new JLabel(" + "));

		add(tf2 = new JTextField("2345", 10)); // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		/*
		 *  4�� ��ư ��ü �����Ͽ� ��ġ
		 */
		add(btnAdd = new JButton("���ϱ�"));
		add(btnSub = new JButton("����"));
		add(btnMult = new JButton("���ϱ�"));
		add(btnDiv = new JButton("������"));

		/*
		 * 4�� ��ư�� ���Ͽ� ���� �ٸ� ������ Ŭ���� �ۼ��Ͽ� ������ ��ü ���
		 */
		ActionListener listenerAdd = new ActionListenerAdd(); 
		btnAdd.addActionListener(listenerAdd);
		
		ActionListener listenerSub = new ActionListenerSub();
		btnSub.addActionListener(listenerSub);
		
		ActionListener listenerMult = new ActionListenerMult();
		btnMult.addActionListener(listenerMult);
		
		ActionListener listenerDiv = new ActionListenerDiv();
		btnDiv.addActionListener(listenerDiv);

		setBounds(500, 400, 450,150);		
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// ���ϱ� ��ư�� ���� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//  ActionListener �����ϴ�  Action ������ Ŭ����
    //  Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ�
	class ActionListenerAdd implements ActionListener {
		
		// �� �̺�Ʈ ó�� �޼ҵ�� ���ϱ� ��ư Ŭ���� ���� ȣ��ǹǷ� ���ϱ⸦ ����Ͽ� ���
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1�� tf2�� �Էµ� �������� ������ ���ϱ� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" + ");
					tfRes.setText(" " + (op1 + op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// ���� ��ư�� ���� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ActionListener �����ϴ�  Action ������ Ŭ����
    //   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ�
	class ActionListenerSub implements ActionListener {
		
		// �� �̺�Ʈ ó�� �޼ҵ�� ���� ��ư Ŭ���� ���� �߻��ϹǷ� ���⸦ ����Ͽ� ���
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1�� tf2�� �Էµ� �������� ������ ���ϱ� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" - ");
					tfRes.setText(" " + (op1 - op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// ���ϱ� ��ư�� ���� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ActionListener �����ϴ�  Action ������ Ŭ����
    //   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ�
	class ActionListenerMult implements ActionListener {
		
		// �� �̺�Ʈ ó�� �޼ҵ�� ���ϱ� ��ư Ŭ���� ���� �߻��ϹǷ� ���ϱ⸦ ����Ͽ� ���
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1�� tf2�� �Էµ� �������� ������ ���ϱ� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" * ");
					tfRes.setText(" " + (op1 * op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// ������ ��ư�� ���� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ActionListener �����ϴ�  Action ������ Ŭ����
    //   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ�
	class ActionListenerDiv implements ActionListener {
		
		// �� �̺�Ʈ ó�� �޼ҵ�� ������ ��ư Ŭ���� ���� �߻��ϹǷ� �����⸦ ����Ͽ� ���
		public void actionPerformed(ActionEvent e) {
			try {
				// tf1�� tf2�� �Էµ� �������� ������ ���ϱ� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
					opr.setText(" / ");
					tfRes.setText(" " + (op1 / op2));
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
 *   1) �� ���α׷��� 4���� ��ư�� ���� 4���� �ٸ� ������ Ŭ������ �ۼ��ϰ� �� ��ư���� �ٸ� ������ ��ü�� ����Ͽ���.
 *             
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *  
 *   3) 4���� �ٸ� ������ Ŭ������ �ۼ��ϰ� �� ��ư���� �ٸ� ������ ��ü�� ����� ���� �������� �ľ��غ���.
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 *  
 *  
 * [ �ǽ����� ]
 *
 *   1) �� ���α׷��� ��ư�� ���� Action �̺�Ʈ�� ��ϵǾ� �ִ�. Action �̺�Ʈ�� �������� �ʰ� 
 *      Mouse �̺�Ʈ�� ���� ������ �� �ֵ��� ���α׷��� �����Ϸ��Ѵ�.
 *     
 *      �̸� ���Ͽ� ������ Ŭ������ MouseListenerAdd, MouseListenerSub, MouseListenerMult, 
 *      MouseListenerDiv Ŭ������  ���� Ŭ������ ������ ���� �ۼ��ϰ�  �� ������ Ŭ������ ��ü�� �����Ͽ� 
 *      4�� ��ư�� ���� ����϶�.
 *     
 *      (1) Mouse �̺�Ʈ ó�� �޼ҵ� �߿���  buttonClicked(ActionEvent e) �޼ҵ�� �̺�Ʈ ó���ϵ��� 
 *          Mouse �������� �̺�Ʈ ó�� �޼ҵ带 �ۼ��϶�. 
 *      
 *      (2) �ٸ� �̺�Ʈ ó�� �޼ҵ�� �޼ҵ� ������ {}���� �ۼ��϶�.        
 */
