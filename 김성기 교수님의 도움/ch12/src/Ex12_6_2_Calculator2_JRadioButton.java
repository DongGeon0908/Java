import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * [ Calculator2_JRadioButton ] : ���� ��ư�� �̿��Ͽ� 4Ģ ���� �����ϴ� GUI ���α׷�
 * 
 *  o ���� ��ư
 *    - ���� �߿��� �ϳ����� ������ �� �ְ� �ϴ� ������Ʈ
 *    - ��ü ������ 
 *       public JRadioButton(String text): �־��� ���ڿ��� ���� ��ư ����
 *       public JRadioButton(Icon icon): �־��� �̹��� ���� ���� ��ư ���� 
 *       public JRadioButton(String text, boolean selected): �־��� ���ڿ��� ���� ��ư �����ϸ� selected�� true�̸� ���õǰ� ��
 *       JRadioButton(Icon icon, boolean selected): �־��� �̹��� ���� ���� ��ư �����ϸ� selected�� true�̸� ���õǰ� ��
 *       
 *    - ���� ��ư�� �ݵ�� �����̳ʿ� ��ġ�� �� �ƴ϶� ButtonGroup ��ü����  add�Ǿ�� ��  
 *       
 *        String[] oprNames = { "���ϱ�", "����", "���ϱ�", "������" };
 *        String[] oprSign = { "  + ", " - ", " * ", " / " };
 *      
 *        ButtonGroup btnGroup = new ButtonGroup();       // ���� ��ư���� ���� ��ư �׷�
 *        JRadioButton[] btnOprs  = new JRadioButton[4];  // +, -, * /�� ��Ÿ�� radio button �迭
 *      
 *        MyActionListener listener = new MyActionListener(); 
 *      
 *        for (int i=0; i<4; i++) {
 *	 	     btnOprs[i] = new JRadioButton(oprNames[i]);
 *		  	 btnOprs[i].addActionListener(listener);
 *			
 *			 add(btnOprs[i]);  			
 *		     btnGroup.add(btnOprs[i]);    // btnOprs[i]�� btnGroup�� �߰�
 *		  }
 * 
 *   - ���� ��ư�� �߿� �޼ҵ�
 *      public boolean isSelected(): ���� ��ư ���õǾ����� true, �ƴϸ� false ��
 *      public void addActionListener(ActionListener l): Action �����ʸ� ��� 
 *      public void addItemListener(ItemListener l): Item �����ʸ� ��� 
 *      public void addChangeListener(ChangeListener l): Change �����ʸ� ��� 
 * 
 *   - ���� ��ư�� Action �̺�Ʈ, Item �̺�Ʈ, Change �̺�Ʈ�� �߻���Ŵ
 *   
 *  o Item �̺�Ʈ
 *    - ���� ������ �������� ���õǸ� �߻��ϴ� �̺�Ʈ
 *    - ���� ��ư�� ���°� ���ص� �߻���(�̶����� Action�̺�Ʈ�� �߻�)
 *    - ItemListener �������̽��� �����ϸ� Item �̺�Ʈ�� ó�� �� �� ����
 *    - ItemListener �������̽��� �̺�Ʈ ó�� �޼ҵ� 
 *          void itemStateChanged(ItemEvent e)
 */

class Ex12_6_2_Calculator2_JRadioButton {
	public static void main(String [] args) {
		new CalculatorFrame_JRadioButton();
	}
}

class CalculatorFrame_JRadioButton extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	String[] oprNames = { "���ϱ�", "����", "���ϱ�", "������" };
	String[] oprSign = { "  + ", " - ", " * ", " / " };

	
    ButtonGroup btnGroup = new ButtonGroup();       // ���� ��ư���� ���� ��ư �׷�
	JRadioButton[] btnOprs  = new JRadioButton[4];  // +, -, * /�� ��Ÿ�� ���� ��ư  �迭

	JLabel opr;

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	CalculatorFrame_JRadioButton() {
		setTitle("���� - JRadioButton �迭 �̿�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(opr = new JLabel(oprSign[0]));

		add(tf2 = new JTextField("2345", 10)); // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		MyItemListener iListener = new MyItemListener();      // Item ������ ��ü ����
		MyActionListener aListener = new MyActionListener();  // Action ������ ��ü ����

		for (int i=0; i<4; i++) {
			btnOprs[i] = new JRadioButton(oprNames[i]);  // i��° ���� ��ư ����
			btnOprs[i].addItemListener(iListener);       // ���� ��ư�� Item ������ ��ü ���
			btnOprs[i].addActionListener(aListener);     // ���� ��ư�� Action ������ ��ü ���
			
			add(btnOprs[i]);  			                 // btnOprs[i]�� �����̳ʿ� ��ġ 
		    btnGroup.add(btnOprs[i]);                    // btnOprs[i]�� btnGroup�� �߰�
		}
		
		setBounds(500, 400, 450,100);	
		
		setVisible(true);    // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}
	
	// 4�� ���� ��ư �� �ϳ� Ŭ���Ǹ� �ش� ���� ��ư Ž���Ͽ� �̺�Ʈ ó���ϴ� ������ Ŭ����(���� Ŭ������ �ۼ�)
	//   ItemListener�� �����ϴ�  Item ������
	//   Item �������� �̺�Ʈ ó�� �޼ҵ��  itemStateChanged() �ϳ���
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			try {			
				// tf1�� tf2�� �Էµ� �������� ������ ���� �����ڿ� ���� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				for (int i=0; i < btnOprs.length; i++)  // Ŭ���� ������ư�� ã�� �ش� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					if (btnOprs[i].isSelected()) {      // ���� ��ư �߿� ���õ� ���� ��ư�� isSelected() �޼ҵ尡 true�� �� �̿��Ͽ� ���õ� ��ư ã��
						opr.setText(oprSign[i]);                      // ������ ���
						tfRes.setText(" " + getResult(op1, i, op2));  // ��� ��� ���
					}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "���⿡���� ����", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// 4���� ���� ��ư �� �ϳ��� Ŭ���Ǹ� �ش� ���� ��ư�� Ž���Ͽ� �̺�Ʈ ó���ϴ� ������ Ŭ����
	//   ActionListener�� �����ϴ�  Action ������
	//   Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ���
	class MyActionListener implements ActionListener {
		
		// ��ư�� Ŭ���ϸ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ带 ������
		public void actionPerformed(ActionEvent e) {
			JRadioButton b = (JRadioButton)e.getSource();// e.getSource() �޼ҵ�� ���õ� ���� ��ư ��ü ����
			System.out.println("���õ� RadioButton = " + b );
			
			try {			
				// tf1�� tf2�� �Էµ� �������� ������ ���� �����ڿ� ���� ����� ����Ͽ� tfRes�� ���
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				// ���� ��ư���� ���õ� ��ư ã��
				for (int i=0; i < btnOprs.length; i++)  // Ŭ���� ������ư�� ã�� �ش� ������ �����Ͽ� ����� ��� �ؽ�Ʈ�ʵ忡 ���
					if (btnOprs[i].isSelected()) {      // ���� ��ư �߿� ���õ� ���� ��ư�� isSelected() �޼ҵ尡 true�� �� �̿��Ͽ� ���õ� ��ư ã��
						opr.setText(oprSign[i]);                      // ������ ���
						tfRes.setText(" " + getResult(op1, i, op2));  // ��� ��� ���� ���
					}
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
 *   1) ���� ��ư�� �̿��Ͽ� 4Ģ ���� �����Ѵ�.
 *      - ���� ��ư�� ��ü ������, �Ӽ� ���� �޼ҵ�, �߻� ������ �̺�Ʈ�� ������ ��ü ��� ��� ���� ������ ��   
 *      - Ư��, ���� ��ư�� �ݵ�� ButtonGroup ��ü���� add �Ǿ�� ���� Ȯ���� ��
 *     
 *   2) ���� ��ư�� Action �̺�Ʈ, Item �̺�Ʈ �߻���Ű�Ƿ� �̵��� ���� ������ ��ü ��� �����ϴ�.
 *      Item �̺�Ʈ Ŭ���� �ۼ������ ���� ���� ��ư �� Ŭ���� ��ư�� ã�� ����� Ȯ���϶�. 
 *               
 *   3) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.  
 *      
 *   4) ���α׷��� �����ϰ� ���α׷� ����� Ȯ���϶�.
 */
