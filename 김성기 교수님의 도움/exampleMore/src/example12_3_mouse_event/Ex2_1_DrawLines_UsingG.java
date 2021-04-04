package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ MousePositionTrace ] : JPanel���� Ŭ���Ǵ� ������ ������ ���� �׸��� �߰� ����
 * 
 *   o JPanel�� ���ڿ��̳� ������ �׸��� ���� �۾�(1)
 *   
*      1) JPanel ��ü ���� �� �Ӽ� ����
 *      
 *         JPanel panel = new JPanel();
 *         ... // JPanel ��ü �Ӽ� ����
 *         
 *     2) JPanel ��ü���� Graphics ��ü�� ����
 *         
 *        // �׷��� �۾��� ���� �г��� Graphics ��ü ���� 
 *        java.awt.Graphics g = panel.getGraphics();
 *        
 *     3) Graphics ��ü  g�� �׸��� �޼ҵ� �̿��Ͽ� �ʿ��� �׷��� �۾� ����
 *     
 *        - void setColor(Color c): �׷��� �۾��� �־��� ���� c�� �ϵ��� �۾� ���� ����
 *                                  (�۾� ���� �����Ǹ� �׸���, ä��� �۾��� ������ �������� �̷����)
 *        
 *        - void drawLine(int x1, int y1, int x2, int y2): �� �� ������ ���� �׸�
 *        - void drawRect(int x, int y, int width, int height) : ������ ���� w, ���� h�� ���簢�� �׸�
 *        - void drawOval(int x, int y, int width, int height): �־��� ���簢���� �����ϴ� Ÿ���� �׸�(width�� height�� ������ �� �׸�)
 *        - void drawString(String s, int x, int y): �־��� ���ڿ��� (x, y) ��ġ�� ���
 *        
 *        - void fillRect(int x, int y, int width, int height) : �־��� ���簢���� ������ �۾��������� ä��
 */

public class Ex2_1_DrawLines_UsingG {
	public static void main(String[] args) {
		MousePosTraceFrame frame = new MousePosTraceFrame("\"Draw Lines Using g");
		
		// panel���� �׷����� ����ϱ� ���� Graphics ��ü g ���Ͽ� ����
		//   panel���� Graphics ��ü g�� �ݵ�� �������� ���÷��̵� �� ���� �� �����Ƿ�
		//   frame.setVisible(true) ���� �� getGraphics() ȣ��Ǿ�� ��
		frame.g = frame.panel.getGraphics();		
		frame.g.drawString("�гο� ���콺 Ŭ���ϸ� ���� �׷����ϴ�", 3, 15);  // �гο� �ȳ� �޽��� ���
	}
}

class MousePosTraceFrame extends JFrame {
	JPanel panel = new JPanel(); // JPanel ��ü ����
	Graphics g;
	
	Point[] points = new Point[1000];
	int cntPoints = 0;

	MousePosTraceFrame(String title) {
		super(title);
		
		int wFrame = 500, hFrame = 400;
		setSize(wFrame, hFrame);
		
		// ����� �ػ�(���� �ȼ���, ���� �ȼ���) ��������
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // ����� ���� ũ��
		int hScreen = (int) screen.getHeight(); // ����� ���� ũ��

		// �������� ȭ�� �߾ӿ� ��ġ
		setLocation((wScreen - wFrame) / 2, (hScreen - hFrame)/2);
		
		setLayout(new GridLayout(1, 1));
			
		add(panel);

		MouseListener l = new MyMouseListener();
		panel.addMouseListener(l);		

		setVisible(true);		
	}

	class MyMouseListener extends MouseAdapter {
		// �гο��� ���콺 Ŭ���Ǹ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ�
		//   ���콺 Ŭ���� ��ġ�� ���� ���� ��ġ�� ����  Ŭ���� ��ġ�� �� ������ ������ �׸�
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();   // ���콺 Ŭ���� ��ġ�� ����
			points[cntPoints++] = p;  // Ŭ���� ��ġ���� �迭�� ����

			drawLines(g);
		}
	}
	
	void drawLines(Graphics g) {		
		if (cntPoints == 0)
			return;

		if (cntPoints == 1)
			g.drawString("*", points[0].x, points[0].y + 8); // ù ��ġ�� * ���
		else {
			g.drawString("*", points[0].x, points[0].y + 8); // ù ��ġ�� * ���

			for (int i = 1; i < cntPoints; i++)              
				g.drawLine(points[i-1].x, points[i-1].y,     // �� �� ���̿� ���� �׸�
						points[i].x, points[i].y);            		
		}
	}
}
