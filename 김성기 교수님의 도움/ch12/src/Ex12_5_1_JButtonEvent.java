import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * [ Ex12_5_1_JButtonEvent ]: JButton�� ���� �߻� ������ �̺�Ʈ���� ó���ϴ� ���α׷�
 *  
 *   o JButton������ Action �̺�Ʈ, Mouse �̺�Ʈ, Fucus �̺�Ʈ ���� �߻� ����
 *  
 *   o ��ư���� �̺�Ʈ ó���� ���� ���� �غ��۾�: 
 *     - ��ư�� ���� ������ Ŭ���� �ۼ�, ������ ��ü ���� �� ���
 *     - ó���� ���� Action ������ ��ü, Mouse ������ ��ü, Focus ������ ��ü ��� ����(�� �ܵ� ����)
 *     - Action ������ Ŭ����, Mouse ������ Ŭ����, Focus ������ Ŭ������ �̺�Ʈ ó�� �޼ҵ�� �ۼ��ؾ� �� 
 *     - �̵� ������ Ŭ���� ��ü �����Ͽ� ��ư�� ����ϸ� �̺�Ʈ ó�� �غ� �Ϸ�
 *  
 *   o �� �̺�Ʈ�� ���� �̺�Ʈ ������ ��ü�� ��ư�� ����� �� ��ư���� �̺�Ʈ �߻��� ���
 *     1) �̺�Ʈ ��ü ����
 *     2) ��ϵ� �̺�Ʈ �������� �ش� �̺�Ʈ ó�� �޼ҵ尡 ��� ���ʷ� ȣ��Ǿ� ����
 *     3) �̺�Ʈ ó�� �޼ҵ尡 ȣ��� �� �̺�Ʈ ��ü�� �ǸŰ������� ����
 */

public class Ex12_5_1_JButtonEvent extends JFrame {
	JTextField tf1, tf2, tfRes;  // ���� �ǿ�����, ������ �ǿ�����, ����� ������ �ؽ�Ʈ �ʵ�
	JButton btnPlus;             // �����ڸ� ��Ÿ���� ��ư

	// ��ü ������: ������Ʈ ��ġ �� ����, �̺�Ʈ ��ü ���, ȭ�鿡 ���̱� �� ����
	Ex12_5_1_JButtonEvent() {
		setTitle("Adder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		this.add(tf1 = new JTextField("1234", 10));  // �ʱⰪ "1234", ũ�� 10�� �ؽ�Ʈ�ʵ�
		this.add(btnPlus = new JButton(" + "));

		this.add(tf2 = new JTextField("2345", 10));  // �ʱⰪ "2345", ũ�� 10�� �ؽ�Ʈ�ʵ�
		this.add(new JLabel(" = "));
		this.add(tfRes = new JTextField("", 10));    // �ʱⰪ "", ũ�� 10�� �ؽ�Ʈ�ʵ�

		ActionListener aListener = new MyActionListener();  // Action ������ ��ü �����Ͽ�
		btnPlus.addActionListener(aListener);               // ���� ��ư�� ���  ==> ��ư Ŭ���ϸ� Action �̺�Ʈ �߻��Ͽ� ó����

		MouseListener mListener = new MyMouseListener();    // Mouse ������ ��ü �����Ͽ�
		btnPlus.addMouseListener(mListener);                // ���� ��ư�� ���  ==> ��ư Ŭ���ϰų� ���콺�� ��ư �̵��ϸ� Mouse �̺�Ʈ �߻��Ͽ� ó����

		FocusListener fListener = new MyFocusListener();    // Focus ������ ��ü �����Ͽ�
		btnPlus.addFocusListener(fListener);                // ���� ��ư�� ���  ==> ��ư�� focus ��ų� �Ұ� �Ǹ� Focus �̺�Ʈ �߻��Ͽ� ó����

		setBounds(500, 400, 450,100);		
		
		setVisible(true);   // ������ JFrame ��ü�� ȭ�鿡 ��Ÿ���� ��
	}

	// tf1�� tf2�� �Էµ� ������ ������ ���� ����� ����Ͽ� tfRes�� ����ϴ� �޼ҵ�
    void  doAddition(int methodNo) {
        try {
            int op1 = Integer.parseInt(tf1.getText());
            int op2 = Integer.parseInt(tf2.getText());
            
            tfRes.setText( methodNo + ") " + (op1 + op2) );
         }
         catch(Exception ex) {
             JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
                                             "���� �Է¿����� ����", JOptionPane.ERROR_MESSAGE);
         }
    }
    
    int cntCalls = 0;  // �̺�Ʈ ó�� �޼ҵ尡 ȣ��� ȸ�� �����ϴ� ����, �޼ҵ尡 ȣ��� ������ 1 ������

    //ActionListener�� �����ϴ�  Action ������ Ŭ���� �ۼ�
    //  Action �̺�Ʈ�� ���콺�� ������Ʈ �Ǵ� �������� �����ϰų� ����Ű �Է� �� �߻�
    //  Action �������� �̺�Ʈ ó�� �޼ҵ��  actionPerformed() �ϳ�
    class MyActionListener implements ActionListener {

       // ���콺�� ��ư�� Ŭ���ϸ� �߻��ϴ� �̺�Ʈ ó���ϴ� �޼ҵ�   
       public void actionPerformed(ActionEvent e) { 
          System.out.println("[" + ++cntCalls + "] 1) actionPerformed(ActionEvent e)");

  		   JButton b = (JButton)e.getSource();// ���õ� ��ư ��ü ������              
          if (b == btnPlus) 
             doAddition(1);
       } 
    }
    
    // MouseListener�� �����ϴ� Mouse ������ Ŭ������ ���� Ŭ������ �ۼ�
    //   Mouse �̺�Ʈ�� ���콺�� ������Ʈ�� ������ �۾��� �����ϸ� �߻�
    //   Mouse �������� �̺�Ʈ ó�� �޼ҵ�� ��� 5��
    class MyMouseListener implements MouseListener {

        // ���콺�� ��ư Ŭ���ϸ� �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�      
        public void mouseClicked(MouseEvent e) { 
           System.out.println("[" + ++cntCalls + "] 2) mouseClicked(MouseEvent e)");
           
           JButton b = (JButton)e.getSource(); // e.getSource() �޼ҵ�� ���õ� ��ư ��ü ����
           if (b == btnPlus) 
              doAddition(2);
        }     
        
        // ���콺�� ��ư ������ �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�            
        public void mousePressed(MouseEvent e) { 
           System.out.println("[" + ++cntCalls + "] 3) mousePressed(MouseEvent e)");
           doAddition(3);
        } 

       // ���콺�� ��ư �����ٰ� ���� �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�         
       public void mouseReleased(MouseEvent e) { 
          System.out.println("[" + ++cntCalls + "] 4) mouseReleased(MouseEvent e)");
          
          JButton b = (JButton)e.getSource(); // e.getSource() �޼ҵ�� ���õ� ��ư ��ü ����
          if (b == btnPlus) 
             doAddition(4);
       } 

       // ���콺�� ��ư���� ������ �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�
       public void mouseEntered(MouseEvent e) { 
          System.out.println("[" + ++cntCalls + "] 5) mouseEntered(MouseEvent e)");
       } 
       
       // ���콺�� ��ư�� ������ �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�
       public void mouseExited(MouseEvent e) {  
          System.out.println("[" + ++cntCalls + "] 6) mouseExited(MouseEvent e)");
       }       
    }
    
    //FocusListener�� �����ϴ� Focus �����ʸ� �ۼ�
    //  Focus �̺�Ʈ�� ������Ʈ�� ��Ŀ���� ��ų� ������ �߻�
    //  Focus �������� �̺�Ʈ ó�� �޼ҵ�� ��� 2��
    class MyFocusListener implements FocusListener {
    	
       // focus�� ������ �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�
       public void focusGained(FocusEvent e) {  
          System.out.println("[" + ++cntCalls + "] 7) focusGained(FocusEvent e)");
       } 
       
       // focus�� ������ �߻��ϴ� �̺�Ʈ�� ó���ϴ� �޼ҵ�
       public void focusLost(FocusEvent e) {  
          System.out.println("[" + ++cntCalls + "] 8) focusLost(FocusEvent e)");
       }
    }
    
	public static void main(String [] args) {
		new Ex12_5_1_JButtonEvent();
	}
 }

/*
 * [ ���α׷��� ���� �� ���� ]
 *   
 *   1) ��ư�� ���� Action �̺�Ʈ, Mouse �̺�Ʈ, Focus �̺�Ʈ ������ ��ü ����Ѵ�.
 *      - ���콺 Ŭ��, ���콺�� ������Ʈ���� �̵�, Focus�� ������ ���� ���� ��� �̺�Ʈ�� �߻�
 *      - �̺�Ʈ �߻��ϸ� �̺�Ʈ ��ü ����, �̺�Ʈ ������ ��ü�� �ش� �̺�Ʈ ó�� �޼ҵ� �ڵ��� ȣ��
 *      - �̺�Ʈ ó�� �޼ҵ� ȣ��� �� �̺�Ʈ ��ü�� �Ű������� ����
 *      - �̷��� �۾��� Java �������� �̺�Ʈ �й踦 ����ϴ� ���α׷��� ���� ����
 *        (�� �κ��� ������ ������ ���������� ������ ��)
 *        
 *   2) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 * 
 *   3) ���α׷��� �����ϰ� ���� �信 ��µǴ� ������ Ȯ���϶�.
 *      - ���콺 �̵� �� Ŭ��, �� Ű�� ��Ŀ�� ������ ���� � ���� �̺�Ʈ ó�� �޼ҵ� ȣ�� ��Ȳ�� ���� �信 ���
 *      - �̺�Ʈ�� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ�� ȣ�� ���� Ȯ���� ��
 *      
 *      - ��ư�� ���콺 ���� mouseEntered(), ������ mouseExited() �޼ҵ� ȣ���
 *      - ���콺�� ��ư Ŭ���ϸ� mousePressed(), focusGained(), actionPerformed(),  mouseReleased(),  
 *        mouseClicked() �� 5�� �޼ҵ尡 ������� ��� ȣ���   
 *        
 *      - �� Ű�� ���콺�� ���� focusGained(), ������ focusLost() �޼ҵ� ȣ���
 *  
 *   4) ���α׷��� �����ϰ� ���� ����� Ȯ���϶�.  
 *      - �̺�Ʈ ó���Ǵ� ��� ���̱� ���� Action �̺�Ʈ, Mouse �̺�Ʈ, Focus �̺�Ʈ ������ ��ü�� 
 *        ��ư��  ��ϵǾ� ���� �̺�Ʈ�� ó��
 *        
 *      - 4���� actionPerform(), mouseClicked(), mousePressed(), mouseReleased() �޼ҵ� ���
 *        ���� ��� ���� ��� �ؽ�Ʈ�ʵ忡 ��������� ���� ��� �������� ������ mouseClicked()�� ����� ����
 *        
 *      - actionPerform(), mouseClicked(), mousePressed(), mouseReleased() �޼ҵ� �� �ϳ��� 
 *        �ۼ��ص� ���� ����� ���� ��� ������
 *        
 *      - ��� �̺�Ʈ �������� ��� �̺�Ʈ ó�� �޼ҵ带 �ۼ��� ���� ���α׷��Ӱ� ������ ����
 *  
 *  
 * [ �ǽ����� ]
 *
 *    o Focus�� ���� �� "��Ŀ���� ����", Focus�� ���� �� "��Ŀ���� ����"�� JOptionPane�� �̿��Ͽ� ����ϵ���
 *       ���α׷��� �����϶�.     
 */
