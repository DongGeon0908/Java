import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ Calculator3_ComboBox ]: JComboBox�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *   o JComboBox  
 *     - ���� �������� �˾� ����Ʈ�� ���Խ�Ű�� �� �������� ������ �� �ְ� �ϴ� ������Ʈ
 *     - �迭 �Ǵ� Vector�� ����� ���ҵ��� �˾� ����Ʈ�� ���������� ���Խ�ų �� ����
 */

public class Ex12_6_3_Calculator3_ComboBox extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	String[] oprSigns = { " + ", " - ", " * ", " / ", "" };

	JComboBox cbOprs;
	
	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	Ex12_6_3_Calculator3_ComboBox() {
		setTitle("����  - JComboBox �̿�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		add(tf1 = new JTextField("1234", 7)); // �ʱⰪ "1234", â ũ�� 7�� �ؽ�Ʈ�ʵ�

		cbOprs = new JComboBox(oprSigns);	
		cbOprs.setSelectedIndex(4);          // ���õ� �����ڸ� ""�� ������
		add(cbOprs);
				
		ActionListener alistener = new MyActionListener();  // Action ������ ��ü �����Ͽ� ���
		cbOprs.addActionListener(alistener);	

//		ItemListener ilistener = new MyItemListener();      // Item ������ ��ü �����Ͽ� ���
//		cbOprs.addItemListener(ilistener);	

		add(tf2 = new JTextField("2345", 7));    // �ʱⰪ "2345", ũ�� 7�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField(" ", 7));     // �ʱⰪ "", ũ�� 7�� �ؽ�Ʈ�ʵ�

		setBounds(500, 400, 450,90);		
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	public static void main(String [] args) {
		new Ex12_6_3_Calculator3_ComboBox();
	}

	// ActionListener�� �����ϴ� Action ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   Action �������� �̺�Ʈ ó�� �޼ҵ�� actionPerformed() �ϳ���
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();  // e.getSource() �޼ҵ�� ���õ� �޺��ڽ� ��ü ����
			
			String opr = (String)cb.getSelectedItem(); // �޺��ڽ����� ���õ� �������� ���� 
			int index = cb.getSelectedIndex() ;        // �޺��ڽ����� ���õ� �������� �ε����� ���� 
			System.out.println("���õ� �������� �ε��� = " + index + ", opr= " + opr );
			
			try {		
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
				
				if (index <= 3)         // ���õ� ��������  " + ", " - ", " * ", " / " �ϳ��̸�
					tfRes.setText(" " + getResult(op1, index, op2));  // ���� ��� ���� ���
				else
					tfRes.setText("");  // dummy ���� ��� "" ���
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// ItemListener�� �����ϴ� Item ������  Ŭ����
	class MyItemListener implements ItemListener {
		
		// �������� �����ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
		public void itemStateChanged(ItemEvent e) {
			JComboBox cb = (JComboBox) e.getSource();  // e.getSource() �޼ҵ�� ���õ� �޺��ڽ� ��ü ����
			
			String opr = (String) cb.getSelectedItem(); // �޺��ڽ����� ���õ� �������� ���� 
			
			int index = cb.getSelectedIndex() ;        // �޺��ڽ����� ���õ� �������� �ε����� ���� 
			System.out.println("���õ� �������� �ε��� = " + index + ", opr= " + opr );
			
			try {		
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());
				
				if (index <= 3)        // ���õ� ��������  " + ", " - ", " * ", " / " �ϳ��̸�
					tfRes.setText(" " + getResult(op1, index, op2));  //���� ��� ���� ���
				else
					tfRes.setText(""); // dummy ���� ��� "" ���
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
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
 *   1) �޺��ڽ��� �̿��Ͽ� 4Ģ ���� �����Ѵ�.
 *      - �޺��ڽ��� ��ü ������, �Ӽ� ���� �޼ҵ�, �߻� ������ �̺�Ʈ�� ������ ��ü ��� ��� ���� ������ ��   
 *      - Ư��, �޺��ڽ��� ���� �������� ������ ��ü ������ �̷������ ���� Ȯ���� ��
 *     
 *   2) �޺��ڽ��� Action �̺�Ʈ, Item �̺�Ʈ �߻���Ű�Ƿ� �̵��� ���� ������ ��ü ����� �����ϴ�.
 *      Item �̺�Ʈ Ŭ���� �ۼ������ ���� �޺��ڽ� ������ �� ���õ� �������� ã�� ����� Ȯ���϶�. 
 *               
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.  
 *     
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 */