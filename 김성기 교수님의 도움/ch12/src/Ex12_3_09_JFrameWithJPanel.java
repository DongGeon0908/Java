import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJPanel ]: JFrame 객체와 JPanel 객체들을 생성하고 JPanel 객체들을 배치
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
 *   o 컨테이너 컴포넌트들의 속성 설정을 위한 메소드
 *     - public void setSize(int width, int height) : 가로와 세로 크기 설정
 *     - public void setLocation(int x,  int y) : 좌표 (x, y) 위치에 배치
 *     - public void setBounds(int x,  int y, int width, int height) : 
 *                                   가로와 세로 크기 설정하여 좌표 (x, y) 위치에  배치
 *       
 *     - public void setBackground(Color c) : 배경색을 주어진 색상으로 설정
 *     - public void setForeground(Color c) : 전경색을 주어진 색상으로 설정
 *     - public void setFont(Font f) : 이 컴포넌트의 폰트 설정
 *       
 *     - public void setFocusable(boolean b) : 포커스를 받을 수 있거나 없게 함 
 *     - public void setEnabled(boolean b) : 입력에 대해 반응할 수 있거나 없게 함
 *     - public void setVisible(boolean b) : 디스플레이되게 하거나 사라지게 함
 *       
 *   o 컨테이너 컴포넌트에 컴포넌트 배치를 위한 메소드
 *     - public void setLayout(LayoutManager mgr) : 컴포넌트 배치하는 방식 설정
 *     - public Component add(Component comp) : 컴포넌트 comp 추가하여 배치
 *     - public void remove(Component comp) : 배치된 comp 제거
 *     - public Component getComponent(int n) : 배치된 n번째 컴포넌트 반환         
 */

// 대개 GUI 프로그램은 JFrame을 확장하는 하위 클래스로 JFrame 객체를 생성함
class Ex12_3_09_JFrameWithJPanel extends JFrame {
	JLabel labelInFrame = new JLabel("   JFrame에 배치된 레이블");

	JPanel panel  = new JPanel();  // JPanel 객체 생성하여 panel이 참조
	JLabel labelInPanel = new JLabel("   JPanel에 배치된 레이블");

	// 객체 생성자: 윈도우를 위한 설정
	Ex12_3_09_JFrameWithJPanel(String title) { 
		super(title);

		this.setLayout(null);         // 컴포넌트 배치방식을 지정하지 않음
		this.setSize(400, 220);       // 가로 400픽셀, 세로 220픽셀 크기로
		this.setLocation(420, 220);   // 윈도우를 (420, 220) 위치에 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	}

	// 컴포넌트들 설정 메소드
	void setupComponents() {     
		// labelInFrame의 속성 설정
		labelInFrame.setOpaque(true);               // !! JLabel 배경색 변경 위해 필요
		labelInFrame.setBackground(Color.black);    // 배경색 지정하기
		labelInFrame.setForeground(Color.orange);   // 전경색 지정하기
		labelInFrame.setSize(160, 20);              // 크기를 가로 170픽셀, 세로 20픽셀 크기로
		labelInFrame.setLocation(120, 20);          // (120, 20) 위치에 배치

		// panel의 속성 설정
		panel.setLayout(null);                      // null이므로 컴포넌트마다 배치 위치 지정하는 수동 배치
		panel.setBackground(Color.green);           // 배경색 지정하기
		panel.setForeground(Color.magenta);          // 전경색 지정하기
		panel.setSize(300, 100);                    // panel 크기를 가로 300픽셀, 세로 100픽셀 크기로
		panel.setLocation(50, 60);                  // panel을 (50, 60) 위치에 배치

		// labelInPanel의 속성 설정
		labelInPanel.setOpaque(true);               // !! JLabel 배경색 변경 위해 필요
		labelInPanel.setBackground(Color.white);    // 배경색 지정하기
		labelInPanel.setForeground(Color.red);      // 전경색 지정하기
		labelInPanel.setSize(160, 20);              // 크기를 가로 170픽셀, 세로 20픽셀 크기로
		labelInPanel.setLocation(70, 40);           //  (70, 40) 위치에 배치
	} 

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		this.add(labelInFrame);    // frame에 레이블 추가
		this.add(panel);           // frame에 panel 추가
		panel.add(labelInPanel);   // panel에 레이블 추가
	}

	public static void main(String[] args) {
		Ex12_3_09_JFrameWithJPanel frame = new   
				Ex12_3_09_JFrameWithJPanel("JFrameWithJPanel");  // 윈도우 생성 및 설정

		frame.setupComponents();   // frame에 배치될 컴포넌트들의 속성 설정
		frame.addComponents();     // frame에 컴포넌트들을 배치  
		frame.setVisible(true);    // frame을 setVisible(true)로 하면 윈도우가 나타남 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 이 프로그램은 JFrame에 JLabel과 JPanel을 배치하고 JPanel에 JLabel을 배치한다.
 *   
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                   
 *   3) 프로그램을 수행하고 결과를 확인하라.
 */