package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ Ex1_MousePositionOutput ] : Ŭ���� ���콺�� ��ġ�� ����ϴ� �߰� ����
 */

public class Ex1_MousePositionOutput {
	public static void main(String[] args) {
		new MousePosFrame("get Mouse Position");
	}
}

class MousePosFrame extends JFrame {
	JButton bt = new JButton("���ϴ� ��ġ���� Ŭ���Ͻÿ�."); 
	JLabel lb = new JLabel("     �� ���̺� Ŭ�� ��ġ�� ǥ�õ˴ϴ�.");	

	MousePosFrame(String title) {
		super(title);
		
		int wFrame = 300, hFrame = 200;
		setSize(wFrame, hFrame);
		
		// ����� �ػ�(���� �ȼ���, ���� �ȼ���) ��������
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // ����� ���� ũ��
		int hScreen = (int) screen.getHeight(); // ����� ���� ũ��

		// �������� ȭ�� �߾ӿ� ��ġ
		setLocation((wScreen - wFrame) / 2, (hScreen - hFrame)/2);
		
		setLayout(new GridLayout(2, 1));
		add(bt);
		add(lb);

		MouseListener l = new MyMouseListener();
		bt.addMouseListener(l);
		
		setVisible(true);

	}

	class MyMouseListener extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
    	  Point p = e.getPoint();  // click�� ��ǥ�� point ��ü ����
    	  
    	  lb.setText("                 (" + p.x +", " + p.y + ") ��ġ���� Ŭ��");
      }
	}
}