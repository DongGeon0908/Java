import java.awt.*;
import javax.swing.*;        

/**
 * [ JFramesDisplay ]: 3개의 JFrame 객체 생성하고 디스플레이하기
 * 
 *   o 컨테이너 컴포넌트
 *     - 다른 컴포넌트를 배치할 수 있는 컴포넌트
 *     - 최상위 컨테이너와 종속 컨테이너로 구분됨
 *     - 최상위 컴포넌트: 다른 컨테이너에 배치되지 않고서 스크린에 디스플레이될 수 있는 컨테이너
 *          JFrame, JDialog
 *          
 *     - 종속 컨테이너: 다른 컨테이너에 배치되어야만 스크린에 디스플레이될 수 있는 컨테이너
 *          JPanel, JScrollPane
 *             
 *   o JFrame
 *     - 독립적으로 디스플레이되는 최상위 컨테이너 클래스로 가징 많이 사용됨 
 *       
 *   o 컨테이너 컴포넌트들의 속성 설정을 위한 메소드
 *     - public void setSize(int width, int height) : 가로와 세로 크기 설정
 *     - public void setLocation(int x, int y) : 좌표 (x, y) 위치에 배치
 *     - public void setBounds(int x, int y, int width, int height) : 
 *                                가로와 세로 크기 설정하여 좌표 (x, y) 위치에  배치
 *       
 *     - public void setBackground(Color c) : 배경색을 주어진 색상으로 설정
 *     - public void setForeground(Color c) : 전경색을 주어진 색상으로 설정
 *     - public void setFont(Font f) : 컴포넌트의 폰트를 설정
 *      
 *     - public void setFocusable(boolean b) : 포커스를 받을 수 있거나 없게 함 
 *     - public void setEnabled(boolean b) : 입력에 대해 반응할 수 있거나 없게 함
 *     - public void setVisible(boolean b) : 디스플레이되게 하거나 사라지게 함
 */

class Ex12_3_06_JFramesDisplay {

	public static void main(String[] args) {
		JFrame frame1 = new JFrame(); // 타이틀 없는 JFrame 
		frame1.setSize(160, 150);     // 크기 설정
		frame1.setLocation(10, 10);   // 디스플레이할 위치 설정
		frame1.setVisible(true);      // 스크린에 디스플레이시키기
 
		JFrame frame2 = new JFrame("타이틀 있는 JFrame"); // 타이틀 있는 JFrame 
		frame2.setBounds(200, 10, 300, 200);            // 크기와 위치 설정
		frame2.setVisible(true);                        // 스크린에 디스플레이시키기

		JFrame frame3 = new JFrame();           // 타이틀 없는 JFrame 객체 생성
		frame3.setBounds(450, 10, 310, 250);    // 크기와 위치 설정
		frame3.setTitle("타이틀 설정한 JFrame");   // 타이틀 설정
		frame3.setVisible(true);                // 스크린에 디스플레이시키기
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 3개의 JFrame을 생성하여 속성을 설정한 후 스크린에 디스플레이시킨다.
 *   
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *      
 *   3) 프로그램을 수행하고 결과를 확인라라.
 *   
 *  
 * [ 실습과제 ]
 *
 *   o setSize(), setLocation(), setBounds(), setTitle(), setVisible() 메소드의 
 *     매개변수를 수정한 후 결과를 확인하라.
 */