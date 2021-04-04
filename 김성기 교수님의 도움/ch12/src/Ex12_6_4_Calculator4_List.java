import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

/**
 * [ Calculator4_List ]: JList�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *   o JList  
 *     - ���� �������� ���÷��̽�Ű�� �� �������� ������ �� �ְ� �ϴ� ������Ʈ
 *     - �迭 �Ǵ� Vector�� ����� ���ҵ��� ����Ʈ�� ���������� ���Խ�ų �� ����
 */

public class Ex12_6_4_Calculator4_List extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	String[] oprSigns = { " + ", " - ", " * ", " / " };

	JList listOprs;

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	Ex12_6_4_Calculator4_List() {
		setTitle("���� - List �̿�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�

		listOprs = new JList(oprSigns);
		add(listOprs);
		
		MyListSelectionListener slistener = new MyListSelectionListener();
		listOprs.addListSelectionListener(slistener);

//		MyMouseListener mlistener = new MyMouseListener();
//		listOprs.addMouseListener(mlistener);

		add(tf2 = new JTextField("2345", 10)); // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		setBounds(500, 400, 450,150);		
		
		setVisible(true);     // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	public static void main(String [] args) {
		new Ex12_6_4_Calculator4_List();
	}

	// ListSelectionListener �����ϴ� ListSelection ������(���� Ŭ������ �ۼ�)
	class MyListSelectionListener implements ListSelectionListener {
		
		// ����Ʈ �������� �����ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
		public void valueChanged(ListSelectionEvent e) {
			JList l = (JList) e.getSource();// ���õ� ��ư ��ü ����

			String opr = (String) l.getSelectedValue(); // ����Ʈ���� ���õ� �������� ���� 
			
			int index = l.getSelectedIndex() ;         //  ���õ� ����Ʈ �������� �ε��� ��ȣ�� ������
			System.out.println("���õ� ������ = " + opr + ", �ε��� = " + index );


			try {
				// tf1�� tf2�� �Էµ� �������� ������ ���� �����ڿ� ���� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				tfRes.setText(" " + getResult(op1, index, op2));

			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// MouseAdapter�� Ȯ���ϴ�  Mouse ������
	class MyMouseListener extends  MouseAdapter {
		public void mouseClicked(MouseEvent e) { 				
			JList l = (JList) e.getSource();// ���õ� ��ư ��ü�� ����

			try {			// tf1�� tf2�� �Էµ� �������� ������ ���� �����ڿ� ���� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());


				int oprIndex = l.getSelectedIndex();   // ���û����� �������� �ε��� ��ȣ�� ������
				tfRes.setText(" " + getResult(op1, oprIndex, op2));
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���� �Է¿����� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// ���� �ǿ�����, ������ ��ȣ(0: ���ϱ�, 1: ����, 2: ���ϱ�, 3; ������), ������ �ǿ����ڰ� �־����� ����Ͽ� ��� ��ȯ�ϴ� �޼ҵ�
	int getResult(int op1, int opr, int op2) { 
		int res  = 0;

		if (opr == 0) res = op1 + op2;
		else if (opr == 1) res =  op1 - op2;
		else if (opr == 2) res =  op1 * op2;
		else if (opr == 3) res =  op1 / op2;

		return res;			
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ����Ʈ�� �̿��Ͽ� 4Ģ ���� �����Ѵ�.
 *      - ����Ʈ�� ��ü ������, �Ӽ� ���� �޼ҵ�, �߻� ������ �̺�Ʈ�� ������ ��ü ��� ��� ���� ������ ��   
 *      - Ư��, ����Ʈ�� ���� �������� ������ ��ü ������ �̷������ ���� Ȯ���� ��
 *     
 *   2) ����Ʈ�� Mouse �̺�Ʈ, ListSelection �̺�Ʈ �߻���Ű�Ƿ� �̵��� ���� ������ ��ü ����� �����ϴ�.
 *      ListSelection �̺�Ʈ Ŭ���� �ۼ������ ���� ����Ʈ ������ �� ���õ� �������� ã�� ����� Ȯ���϶�. 
 *               
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.  
 *   
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.  
 */
