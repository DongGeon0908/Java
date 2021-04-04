package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ DrawingShapesFrame ] : JPanel�� ��, �ﰢ��, ���簢��, ���簢��, �� ���� ������ �����Ͽ� �׸��� �߰� ����
 * 
 *   o ����� �޴� �гο��� �۾��� �����ϰ� �Ϻ� ĵ���� �гο��� ���콺 Ŭ���ϸ� ĵ���� �гο� ���� �׸� 
 *     - �۾����� ������ ���� ���� �����ϸ� ������ ���õ� �������� �׷���
 * 
 *   o JPanel�� ���ڿ��̳� ������ �׸��� ���� �۾�
 *   
 *     1) JPanel ��ü ���� �� �Ӽ� ����
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
 *        
 *     4) ���� �����ϱ�
 *        - java.swing ��Ű���� JColorChooser Ŭ������ ���� ���� �޼ҵ�
 *        
 *           public static Color showDialog(Component component, String title,
 *                                     Color initialColor) throws HeadlessException
 *                                     
 *           // ���� ������ workColor�� �����ϱ�                          
 *           Color workColor = JColorChooser.showDialog(panelColor, "�۾����� ����", workColor);                          
 */

public class Ex4_DrawingShapesColor {
	public static void main(String[] args) {
		DrawingShapesFrame frame = new DrawingShapesFrame("Mouse Position Trace");
		
		frame.gSetupPanelCanvas();
		
		frame.gSetupPanelColor();	
	}
}

class DrawingShapesFrame extends JFrame {
	DrawingShapesFrame frame;
	
	int wFrame = 785, hFrame = 500;
	
	JPanel panelMenu = new JPanel(); 
	JButton workColorBt = new JButton("�۾����� ����");
	JPanel panelColor = new JPanel();
	JPanel panelCanvas = new JPanel();
	
	int wPanelMenu = 620, hPanelMenu = 85;
	int wWorkColorBt = 120, hWorkColorBt = 30;
	int wPanelColor = 120, hPanelColor = 30;
	int wPanelCanvas = 750, hPanelCanvas = 348;
	
	// ĵ���� �гο��� ���콺 Ŭ�� �Ұ� ���θ� ��Ÿ���� �ʵ� 
	boolean canvasClickNotAllowed = false;
	
	int taskNo;
	String[] tasknames = { "�� �׸���", "�ﰢ�� �׸���", "���簢�� �׸���", "���簢�� �׸���", "�� �׸���", "��� �����"};
	
	Graphics gCanvas; // ĵ���� �г��� ���� �׷��� ��ü ������ �ʵ�
	Graphics gColor;  // ���� �۾� ������ ������ �÷� �г��� ���� �׷��� ��ü ������ �ʵ�
	
	Color menuColor = Color.cyan;     // �޴� �г��� ���� ����
	Color workColor = Color.black;    // ���� �۾����� ������ �ʵ�(�ʱ� ������ ����)
	Color canvasColor = Color.white;  // ĵ���� �г��� ���� ����(���)
	
	Point[] points = new Point[1000]; // ĵ���� �гο��� Ŭ���� ��ǥ ������ �迭 �ʵ�
	int cntPoints = 0;                // ĵ���� �гο��� Ŭ���� ���� ������ �ʵ�

	
	// ��ü ������
	DrawingShapesFrame(String title) {
		super(title);
		
		setSize(wFrame, hFrame);
		
		// ����� �ػ�(���� �ȼ���, ���� �ȼ���) ��������
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // ����� ���� ũ��
		int hScreen = (int) screen.getHeight(); // ����� ���� ũ��

		// �������� ȭ�� �߾ӿ� ��ġ
		setLocation((wScreen - wFrame) / 2, (hScreen - hFrame)/2);
		
		setLayout(null);  // �����ӿ� ������Ʈ ��ġ�� ���� ��ġ�� ����
		
		// �޴� �г� ����
		panelMenu.setBounds(10, 10, wPanelMenu, hPanelMenu);
		panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panelMenu.setBackground(menuColor);
		
		add(panelMenu);
		
		// �۾����� �����ϱ� ���� ��ư ����
		workColorBt.setBounds(640, 22, wWorkColorBt, hWorkColorBt);
		
		add(workColorBt);
		
		// �۾����� �����ִ� �г� ����
		panelColor.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panelColor.setBackground(workColor);
		panelColor.setBounds(640, 57, wPanelColor, hPanelColor);
		
		add(panelColor);
		
		// ��ư Ŭ���� �̺�Ʈ ó���� ������ ��ü ���� �� ���
		ActionListener al = new MyActionListener();
		
		for (String taskname : tasknames) {
			JButton bt = new JButton(taskname);
			panelMenu.add(bt);
			bt.addActionListener(al);
		}
		
		workColorBt.addActionListener(al); 
		
		// ���� �׸� ĵ������ ���� �г� ����
		panelCanvas.setBounds(10, 105, wPanelCanvas, hPanelCanvas);
		panelCanvas.setBackground(canvasColor);
		add(panelCanvas);

		// ĵ���� �гο��� ���콺 Ŭ���Ǹ� �̺�Ʈ ó���� �̺�Ʈ ������ ��ü ���� �� ���
		MouseListener l = new MyMouseListener();
		panelCanvas.addMouseListener(l);
		
		setVisible(true);
	}

	// panelCanvas���� �׷��� ����ϱ� ���� Graphics ��ü ���Ͽ� ����
	void gSetupPanelCanvas() {
		//   panel���� Graphics ��ü g�� �ݵ�� �������� ���÷��̵� �� ���� �� �����Ƿ�
		//   frame.setvisible(true) ���� �� getGraphics() ȣ��Ǿ�� ��
		gCanvas =  panelCanvas.getGraphics();		
	}

	// panelColor���� �׷��� ����ϱ� ���� Graphics ��ü ���Ͽ� �����ϰ�
	//    �۾� ������ �������� ����
	void gSetupPanelColor() {
		//   panel���� Graphics ��ü g�� �ݵ�� �������� ���÷��̵� �� ���� �� �����Ƿ�
		//   frame.setvisible(true) ���� �� getGraphics() ȣ��Ǿ�� ��
		gColor = panelColor.getGraphics();

		// ���� �۾������� �������� ����
		gColor.setColor(workColor);
		gColor.fillRect(0, 0, wPanelColor, hPanelColor);
	}

	class MyActionListener implements ActionListener {
		// �гο��� ���콺 Ŭ���Ǹ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ�
		public void actionPerformed(ActionEvent e) {
			String taskname = e.getActionCommand();
			
			// ��ư Ȯ���Ͽ� ������ �۾��� ��ȣ Ȯ���Ͽ� taskNo�� ����
			for (int i = 0; i < tasknames.length; i++)
				if (taskname.equals(tasknames[i]))
						taskNo = i;
			
			cntPoints = 0;		
			canvasClickNotAllowed = false;  // canvas �гο��� Ŭ�� ���
			
			if (taskname.equals("��� �����")) { 
				// ��� ����� �۾��̸� �г��� ������� ä��� �۾� ������ ���� �۾��������� �ٽ� ���� 
				gCanvas.setColor(canvasColor);
				gCanvas.fillRect(0, 0, wPanelCanvas, hPanelCanvas);
				
				gCanvas.setColor(workColor);
				
				canvasClickNotAllowed = true;   // canvas �гο��� Ŭ�� ������Ŵ
			}
			else if (taskname.equals("�۾����� ����")) {	
				
				// ���� ���ñ⿡�� ���ο� ������ �����Ͽ� ��ȯ
				workColor = JColorChooser.showDialog(panelColor, "�۾����� ����", workColor);
				gColor.setColor(workColor);		
				gColor.fillRect(0, 0, wPanelColor, hPanelColor);

				System.out.println("\n ���� ���� = " + workColor);
				
				gCanvas.setColor(workColor);
				
				canvasClickNotAllowed = true;  // canvas �гο��� Ŭ�� ������Ŵ
			}
		}
	}

	class MyMouseListener extends MouseAdapter {

		// �гο��� ���콺 Ŭ���Ǹ� ȣ��Ǵ� �̺�Ʈ ó�� �޼ҵ�
		//   �۾� ������ ���� Ŭ���� ��ġ�� ���Ͽ� �ش� ������ �׸�
		public void mouseClicked(MouseEvent e) {

			if (canvasClickNotAllowed) {
				JOptionPane.showMessageDialog(null, "�۾��� ���� �����Ͻÿ�", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return;
			}

			Point p = e.getPoint();   // ���콺 Ŭ���� ��ġ�� ����
			points[cntPoints++] = p;  // Ŭ���� ��ġ���� �迭�� ����

			if (taskNo == 0 ) {			
				if (cntPoints == 1)
					gCanvas.drawString("*", points[0].x - 2 , points[0].y + 7); // ù ��ġ�� * ���
				else
					gCanvas.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // �� �� ���� �� �׸�
			}
			if (taskNo == 1 ) {			
				// �� ���� �־����� �̸� �����ϴ� �ﰢ�� �׸���
				
				if (cntPoints % 3 == 1)
					gCanvas.drawString("*", points[0].x - 2 , points[0].y + 7); // ù ��ġ�� * ���
				else if (cntPoints % 3 == 2)
					gCanvas.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // ù ��°�� �� ��° ���� �� �׸�
				else {
					gCanvas.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // �� ��°�� �� ��°  ���� �� �׸�
					gCanvas.drawLine(points[cntPoints-3].x, points[cntPoints-3].y, p.x, p.y); // �� ��°�� ù ��°  ���� �� �׸�	

					cntPoints = 0;
				}
			}
			else if (taskNo == 2 ) {			
				if (cntPoints %2 == 1)
					gCanvas.drawString("*", p.x - 2, p.y + 7); // ù ��ġ�� * ���
				else {
					// ���簢�� �밢�� ���� 2 �� �־����� ���簢�� �׸��� �ڵ�
					// ���δ� x��� �����ϸ�, ���δ� y��� �����ϵ��� �׸�
					
					int xDiff = points[cntPoints-2].x - p.x;   // �밢�� 2 �� ������ x �Ÿ�
					int yDiff = points[cntPoints-2].y - p.y;   // �밢�� 2 �� ������ y �Ÿ�

					int x = xDiff > 0 ? p.x : points[cntPoints-2].x;  // ���簢���� ���� �� ���� x ��ǥ
					int y = yDiff > 0 ? p.y : points[cntPoints-2].y;  // ���簢���� ���� �� ���� y ��ǥ

					int w = Math.abs(xDiff);  // ���簢���� ���� ũ��
					int h = Math.abs(yDiff);  // ���簢���� ���� ũ��
					
					gCanvas.drawRect(x, y, w, h); // ������ (x, y)���� ���� w, ���� h�� ���簢�� �׸�
				}
			}
			else if (taskNo == 3 ) {			
				if (cntPoints %2 == 1)
					gCanvas.drawString("*", p.x - 2, p.y + 7); // ù ��ġ�� * ���
				else {
					// ���簢�� �밢�� ���� 2 �� �־����� ���簢�� �׸��� �ڵ� 
					
					int xC = (points[cntPoints-2].x + p.x) / 2;   // �밢�� �� 2 ���� �߽� x ��ǥ
					int yC = (points[cntPoints-2].y + p.y) / 2;   // �밢�� �� 2 ���� �߽� y ��ǥ

					int x0 = points[cntPoints-2].x;  // �밢�� ���� �� �� x ��ǥ
					int y0 = points[cntPoints-2].y;  // �밢�� ���� �� �� y ��ǥ

					// �밢�� �߽����� ���� �� ���� 90�� ȸ���̵���Ų ���� ���簢���� �� ��° ������
					int x1 = (int) ((x0 - xC) * Math.cos(90 * Math.PI / 180) - (y0 - yC) *  Math.sin(90 * Math.PI / 180) + xC + 0.5);
					int y1 = (int) ((x0 - xC) * Math.sin(90 * Math.PI / 180) + (y0 - yC) *  Math.cos(90 * Math.PI / 180) + yC + 0.5);

					int x2 = p.x; // �밢�� �ٸ� ���� �� �� x ��ǥ
					int y2 = p.y; // �밢�� �ٸ� ���� �� �� y ��ǥ

					// �밢�� �߽����� ���� �ٸ�  �� ���� 90�� ȸ���̵���Ų ���� ���簢���� �� ��° ������
					int x3 = (int) ((x2 - xC) * Math.cos(Math.PI / 2) - (y2 - yC) *  Math.sin(Math.PI / 2) + xC + 0.5);
					int y3 = (int) ((x2 - xC) * Math.sin(Math.PI / 2) + (y2 - yC) *  Math.cos(Math.PI / 2) + yC + 0.5);

					gCanvas.drawLine(x0, y0, x1, y1); // ù ��°�� �� ��°  ����  �� �׸�
					gCanvas.drawLine(x1, y1, x2, y2); // �� ��°�� �� ��°  ����  �� �׸�			    		
					gCanvas.drawLine(x2, y2, x3, y3); // �� ��°�� �� ��°  ����  �� �׸�
					gCanvas.drawLine(x3, y3, x0, y0); // �� ��°�� ù ��°  ����  �� �׸�
				}
			}
			else if (taskNo == 4 ) {			
				// �߽ɰ� ���� ����  2 ��  �־����� �� �׸��� �ڵ� 
				
				if (cntPoints % 2 == 1)
					gCanvas.drawString("*", p.x - 2, p.y + 7); // ù ��ġ�� * ���
				else {
					int xDiff = points[cntPoints-2].x - p.x;   // �߽ɰ� ���� ������  x �Ÿ�
					int yDiff = points[cntPoints-2].y - p.y;   // �߽ɰ� ���� ������ y �Ÿ�

					int r = (int) (Math.sqrt(xDiff * xDiff + yDiff * yDiff) + 0.5);  // ������ ũ��
					
					int x = points[cntPoints-2].x - r;  // ���� �����ϴ� �簢���� ���� ��  ����  x ��ǥ
					int y = points[cntPoints-2].y - r;  // ���� �����ϴ� �簢���� ���� ��  ����  y ��ǥ

					int w = 2 * r;  // ���� �����ϴ� �簢���� ���� ũ��(�������� 2��)
					int h = 2 * r;  // ���� �����ϴ� �簢���� ���� ũ��(�������� 2��)
					gCanvas.drawOval(x, y, w, h); // �簢���� �����ϴ� �� �׸�
				}
			}	
		}	
	}
}
