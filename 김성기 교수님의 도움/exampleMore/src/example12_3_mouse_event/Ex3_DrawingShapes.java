package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ DrawingShapeColor ] : Panel에 선, 삼각형, 직사각형, 정사각형, 원 등을 그리는 추가 예제
 *   
 *   o 상부의 메뉴 패널에서 작업을 선택하고 하부 캔버스 패널에서 마우스 클릭하면 캔버스 패널에 도형 그림 
 * 
 *   o JPanel에 문자열이나 도형을 그리기 위한 작업
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

public class Ex3_DrawingShapes {
	public static void main(String[] args) {
		DrawingShapeColorFrame frame = new DrawingShapeColorFrame("Draw Shapes ");
		
		// panel에서 그래픽을 사용하기 위한 Graphics 객체 구하여 저장
		//   panel에서 Graphics 객체 g는 반드시 프레임이 디스플레이된 후 구할 수 있으므로
		//   frame.setvisible(true) 수행 후 getGraphics() 호출되어야 함		
		frame.g = frame.panelCanvas.getGraphics();		
	}
}

class DrawingShapeColorFrame extends JFrame {
	int wPanelMenu = 720, hPanelMenu = 50;
	int wPanelCanvas = 720, hPanelCanvas = 330;

	JPanel panelMenu = new JPanel(); 
	JPanel panelCanvas = new JPanel();
	
	int taskNo;
	String[] tasknames = { "선 그리기", "삼각형 그리기", "직사각형 그리기", "정사각형 그리기", "원 그리기", "모두 지우기" };
	
	Graphics g;   
	
	Point[] points = new Point[1000];
	int cntPoints = 0;

	DrawingShapeColorFrame(String title) {
		super(title);
		
		int wFrame = 755, hFrame = 450;
		setSize(wFrame, hFrame);
		
		// 모니터 해상도(가로 픽셀수, 세로 픽셀수) 가져오기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // 모니터 가로 크기
		int hScreen = (int) screen.getHeight(); // 모니터 세로 크기

		// 프레임을 화면 중앙에 배치
		setLocation((wScreen - wFrame) / 2, (hScreen - hFrame)/2);
		
		setLayout(null);
		
		panelMenu.setBounds(10, 10, wPanelMenu, hPanelMenu);

		panelMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panelMenu.setBackground(Color.cyan);
		

		add(panelMenu);
		
		ActionListener al = new MyActionListener();
		
		for (String taskname : tasknames) {
			JButton bt = new JButton(taskname);
			panelMenu.add(bt);
			bt.addActionListener(al);
		}
		
		panelCanvas.setBounds(10, 70, wPanelCanvas, hPanelCanvas);
		panelCanvas.setBackground(Color.WHITE);
		add(panelCanvas);

		MouseListener l = new MyMouseListener();
		panelCanvas.addMouseListener(l);
		
		setVisible(true);
	}


	class MyActionListener implements ActionListener {
		
		// 패널에서 마우스 클릭되면 호출되는 이벤트 처리 메소드
		public void actionPerformed(ActionEvent e) {
			String taskname = e.getActionCommand();
			
			// 버튼 확인하여 수행할 작업의 번호 확인하여 taskNo에 저장
			for (int i = 0; i < tasknames.length; i++)
				if (taskname.equals(tasknames[i]))
						taskNo = i;
			
			cntPoints = 0;		
			
			if (taskname.equals("모두 지우기")) { 
				// 모두 지우기 작업이면 패널을 흰색으로 채우고 작업 색상을 흑색으로 다시 설정 
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, wPanelCanvas, hPanelCanvas);
				
				g.setColor(Color.BLACK);
			}

		}
	}

	class MyMouseListener extends MouseAdapter {
		
		// 패널에서 마우스 클릭되면 호출되는 이벤트 처리 메소드
		//   작업 종류에 따라 클릭된 위치를 구하여 해당 도형을 그림
		public void mouseClicked(MouseEvent e) {

			if (taskNo == 5) 
			{
				JOptionPane.showMessageDialog(null, "작업을 먼저 선택하시오", 
						"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 

				return;
			}

			Point p = e.getPoint();   // 마우스 클릭된 위치를 구함
			points[cntPoints++] = p;  // 클릭된 위치들을 배열에 저장

			if (taskNo == 0 ) {			
				if (cntPoints == 1)
					g.drawString("*", points[0].x - 2 , points[0].y + 7); // 첫 위치에 * 출력
				else
					g.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // 두 점 사이 선 그림
			}
			if (taskNo == 1 ) {			
				// 세 점이 주어지면 이를 연결하는 삼각형 그리기
				
				if (cntPoints % 3 == 1)
					g.drawString("*", points[0].x - 2 , points[0].y + 7); // 첫 위치에 * 출력
				else if (cntPoints % 3 == 2)
					g.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // 첫 번째와 두 번째 사이 선 그림
				else {
					g.drawLine(points[cntPoints-2].x, points[cntPoints-2].y, p.x, p.y); // 두 번째와 세 번째  사이 선 그림
					g.drawLine(points[cntPoints-3].x, points[cntPoints-3].y, p.x, p.y); // 세 번째와 첫 번째  사이 선 그림	

					cntPoints = 0;
				}
			}
			else if (taskNo == 2 ) {			
				if (cntPoints %2 == 1)
					g.drawString("*", p.x - 2, p.y + 7); // 첫 위치에 * 출력
				else {
					// 직사각형 대각선 끝의 2 점 주어지면 직사각형 그리는 코드
					// 가로는 x축과 평행하며, 세로는 y축과 평행하도록 그림
					
					int xDiff = points[cntPoints-2].x - p.x;   // 대각선 2 점 사이의 x 거리
					int yDiff = points[cntPoints-2].y - p.y;   // 대각선 2 점 사이의 y 거리

					int x = xDiff > 0 ? p.x : points[cntPoints-2].x;  // 직사각형의 왼쪽 위 점의 x 좌표
					int y = yDiff > 0 ? p.y : points[cntPoints-2].y;  // 직사각형의 왼쪽 위 점의 y 좌표

					int w = Math.abs(xDiff);  // 직사각형의 가로 크기
					int h = Math.abs(yDiff);  // 직사각형의 세로 크기
					
					g.drawRect(x, y, w, h); // 시작점 (x, y)에서 가로 w, 세로 h인 직사각형 그림
				}
			}
			else if (taskNo == 3 ) {			
				if (cntPoints %2 == 1)
					g.drawString("*", p.x - 2, p.y + 7); // 첫 위치에 * 출력
				else {
					// 정사각형 대각선 끝의 2 점 주어지면 정사각형 그리는 코드 
					
					int xC = (points[cntPoints-2].x + p.x) / 2;   // 대각선 끝 2 점의 중심 x 좌표
					int yC = (points[cntPoints-2].y + p.y) / 2;   // 대각선 끝 2 점의 중심 y 좌표

					int x0 = points[cntPoints-2].x;  // 대각선 끝의 한 점 x 좌표
					int y0 = points[cntPoints-2].y;  // 대각선 끝의 한 점 y 좌표

					// 대각선 중심점에 대해 한 점을 90도 회전이동시킨 점이 정사각형의 두 번째 꼭지점
					int x1 = (int) ((x0 - xC) * Math.cos(90 * Math.PI / 180) - (y0 - yC) *  Math.sin(90 * Math.PI / 180) + xC + 0.5);
					int y1 = (int) ((x0 - xC) * Math.sin(90 * Math.PI / 180) + (y0 - yC) *  Math.cos(90 * Math.PI / 180) + yC + 0.5);

					int x2 = p.x; // 대각선 다른 끝의 한 점 x 좌표
					int y2 = p.y; // 대각선 다른 끝의 한 점 y 좌표

					// 대각선 중심점에 대해 다른  한 점을 90도 회전이동시킨 점이 정사각형의 네 번째 꼭지점
					int x3 = (int) ((x2 - xC) * Math.cos(Math.PI / 2) - (y2 - yC) *  Math.sin(Math.PI / 2) + xC + 0.5);
					int y3 = (int) ((x2 - xC) * Math.sin(Math.PI / 2) + (y2 - yC) *  Math.cos(Math.PI / 2) + yC + 0.5);

					g.drawLine(x0, y0, x1, y1); // 첫 번째와 두 번째  사이  선 그림
					g.drawLine(x1, y1, x2, y2); // 두 번째와 세 번째  사이  선 그림			    		
					g.drawLine(x2, y2, x3, y3); // 세 번째와 네 번째  사이  선 그림
					g.drawLine(x3, y3, x0, y0); // 네 번째와 첫 번째  사이  선 그림
				}
			}
			else if (taskNo == 4 ) {			
				// 중심과 원주 상의 2 점 주어지면 원 그리는 코드 
				
				if (cntPoints % 2 == 1)
					g.drawString("*", p.x - 2, p.y + 7); // 첫 위치에 * 출력
				else {
					int xDiff = points[cntPoints-2].x - p.x;   // 중심과 원주 사이의  x 거리
					int yDiff = points[cntPoints-2].y - p.y;   // 중심과 원주 사이의 y 거리

					int r = (int) (Math.sqrt(xDiff * xDiff + yDiff * yDiff) + 0.5);  // 반지름 크기
					
					int x = points[cntPoints-2].x - r;  // 원이 내접하는 사각형의 왼쪽 위  점의  x 좌표
					int y = points[cntPoints-2].y - r;  // 원이 내접하는 사각형의 왼쪽 위  점의  y 좌표

					int w = 2 * r;  // 원이 내접하는 사각형의 가로 크기(반지름의 2배)
					int h = 2 * r;  // 원이 내접하는 사각형의 세로 크기(반지름의 2배)
					g.drawOval(x, y, w, h); // 사각형에 내접하는 원 그림
				}
			}	
		}
	}
}
