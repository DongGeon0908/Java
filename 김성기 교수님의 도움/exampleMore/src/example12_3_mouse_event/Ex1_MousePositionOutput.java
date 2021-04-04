package example12_3_mouse_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ Ex1_MousePositionOutput ] : 클릭된 마우스의 위치를 출력하는 추가 예제
 */

public class Ex1_MousePositionOutput {
	public static void main(String[] args) {
		new MousePosFrame("get Mouse Position");
	}
}

class MousePosFrame extends JFrame {
	JButton bt = new JButton("원하는 위치에서 클릭하시오."); 
	JLabel lb = new JLabel("     이 레이블에 클릭 위치가 표시됩니다.");	

	MousePosFrame(String title) {
		super(title);
		
		int wFrame = 300, hFrame = 200;
		setSize(wFrame, hFrame);
		
		// 모니터 해상도(가로 픽셀수, 세로 픽셀수) 가져오기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int wScreen = (int) screen.getWidth();  // 모니터 가로 크기
		int hScreen = (int) screen.getHeight(); // 모니터 세로 크기

		// 프레임을 화면 중앙에 배치
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
    	  Point p = e.getPoint();  // click된 좌표의 point 객체 구함
    	  
    	  lb.setText("                 (" + p.x +", " + p.y + ") 위치에서 클릭");
      }
	}
}