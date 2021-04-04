package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ MousePositionTrace ] : JPanel에서 클릭되는 점들을 연결한 선을 그리는 추가 예제
 * 
 *   o JPanel에 문자열이나 도형을 그리기 위한 작업(1)
 *   
*      1) JPanel 객체 생성 및 속성 설정
 *      
 *         JPanel panel = new JPanel();
 *         ... // JPanel 객체 속성 설정
 *         
 *     2) JPanel 객체에서 Graphics 객체를 구함
 *         
 *        // 그래픽 작업을 위해 패널의 Graphics 객체 구함 
 *        java.awt.Graphics g = panel.getGraphics();
 *        
 *     3) Graphics 객체  g의 그리기 메소드 이용하여 필요한 그래픽 작업 수행
 *     
 *        - void setColor(Color c): 그래픽 작업을 주어진 색상 c로 하도록 작업 색상 설정
 *                                  (작업 색상 설정되면 그리기, 채우기 작업은 설정된 색상으로 이루어짐)
 *        
 *        - void drawLine(int x1, int y1, int x2, int y2): 두 점 사이의 선을 그림
 *        - void drawRect(int x, int y, int width, int height) : 점에서 가로 w, 세로 h의 직사각형 그림
 *        - void drawOval(int x, int y, int width, int height): 주어진 직사각형에 내접하는 타원을 그림(width와 height가 같으면 원 그림)
 *        - void drawString(String s, int x, int y): 주어진 문자열을 (x, y) 위치에 출력
 *        
 *        - void fillRect(int x, int y, int width, int height) : 주어진 직사각형의 영역을 작업색상으로 채움
 */

public class Ex2_1_DrawLines_UsingG {
	public static void main(String[] args) {
		MousePosTraceFrame frame = new MousePosTraceFrame("\"Draw Lines Using g");
		
		// panel에서 그래픽을 사용하기 위한 Graphics 객체 g 구하여 저장
		//   panel에서 Graphics 객체 g는 반드시 프레임이 디스플레이된 후 구할 수 있으므로
		//   frame.setVisible(true) 수행 후 getGraphics() 호출되어야 함
		frame.g = frame.panel.getGraphics();		
		frame.g.drawString("패널에 마우스 클릭하면 선이 그려집니다", 3, 15);  // 패널에 안내 메시지 출력
	}
}

class MousePosTraceFrame extends JFrame {
	JPanel panel = new JPanel(); // JPanel 객체 생성
	Graphics g;
	
	Point[] points = new Point[1000];
	int cntPoints = 0;

	MousePosTraceFrame(String title) {
		super(title);
		
		int wFrame = 500, hFrame = 400;
		setSize(wFrame, hFrame);
		
		// 모니터 해상도(가로 픽셀수, 세로 픽셀수) 가져오기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // 모니터 가로 크기
		int hScreen = (int) screen.getHeight(); // 모니터 세로 크기

		// 프레임을 화면 중앙에 배치
		setLocation((wScreen - wFrame) / 2, (hScreen - hFrame)/2);
		
		setLayout(new GridLayout(1, 1));
			
		add(panel);

		MouseListener l = new MyMouseListener();
		panel.addMouseListener(l);		

		setVisible(true);		
	}

	class MyMouseListener extends MouseAdapter {
		// 패널에서 마우스 클릭되면 호출되는 이벤트 처리 메소드
		//   마우스 클릭된 위치를 구해 이전 위치의 점과  클릭된 위치의 점 사이의 라인을 그림
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();   // 마우스 클릭된 위치를 구함
			points[cntPoints++] = p;  // 클릭된 위치들을 배열에 저장

			drawLines(g);
		}
	}
	
	void drawLines(Graphics g) {		
		if (cntPoints == 0)
			return;

		if (cntPoints == 1)
			g.drawString("*", points[0].x, points[0].y + 8); // 첫 위치에 * 출력
		else {
			g.drawString("*", points[0].x, points[0].y + 8); // 첫 위치에 * 출력

			for (int i = 1; i < cntPoints; i++)              
				g.drawLine(points[i-1].x, points[i-1].y,     // 두 점 사이에 라인 그림
						points[i].x, points[i].y);            		
		}
	}
}
