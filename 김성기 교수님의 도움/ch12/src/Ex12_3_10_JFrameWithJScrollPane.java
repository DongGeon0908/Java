import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJScrollPane]: JFrame 객체와 JScrollPane 객체를 생성하고 JScrollPane 객체를 JFrame 객체에 배치
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
 *     - public void setSize(int width, int height) : 가로와 세로 크기를 설정
 *     - public void setLocation(int x,  int y) : 좌표 (x, y) 위치에 배치
 *     - public void setBounds(int x,  int y, int width, int height) : 
 *                               가로와 세로 크기 설정하여 좌표 (x, y) 위치에  배치
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
 *      
 *   o JTextArea
 *     - 여러 라인의 문자열을 입력하고 출력할 수 있는 컴포넌트
 *     - 객체 생성자
 *         JTextArea(int row, int column) : 주어진 행과 열의 개수의 문자열을 입력하는 JTextArea 객체 생성
 *         JTextArea(String initialText, int row, int column): 주어진 초기 텍스트, 행과 열을 갖는 JTextArea 객체 생성
 *         
 *   o JScrollPane
 *     - 가변 크기의 컴포넌트를 배치하여 배치된 컴포넌트가 커지면 자동적으로 스크롤 바를 생성하여 스크롤링되게 하는 컨테이너
 *     - 객체 생성자
 *         JScrollPane(Component comp) :  컴포넌트 comp를 배치하는 JScrollPane 객체 생성   
 */

// JFrame을 확장하는 하위 클래스
class Ex12_3_10_JFrameWithJScrollPane extends JFrame {
    
    JTextArea ta = new JTextArea("홍길동\n박문수\n이몽룡\n", 4, 8); // 여러 라인에 걸쳐 텍스트를 입력할 수 있는 컴포넌트
    JScrollPane scrollPane = new JScrollPane(ta);  // ta 컴포넌트를 배치하는 JScrollPane 객체 생성

    // 객체 생성자: 윈도우를 위한 설정
	Ex12_3_10_JFrameWithJScrollPane(String title) { 
		super(title);
	    this.setLayout(null);         // 배치방식을 수동 배치로
		this.setLocation(500, 300);   // 윈도우를 (500, 300) 위치에 배치
		this.setSize(320, 200);       // 가로 320픽셀, 세로 20픽셀 크기로		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	}

	// 컴포넌트들 설정 메소드
	void setupComponents() {     				
		// ta의 속성 설정
		ta.setBackground(Color.yellow);   // 색상명을 이용하여 배경색 지정하기
		ta.setForeground(Color.blue);     // 색상명을 이용하여 전경색 지정하기

		// scrollPane의 속성 설정	
		scrollPane.setLocation(100, 30);  // (100, 30)의 위치에 배치
		scrollPane.setSize(100, 100);     // 가로 100픽셀, 세로 100픽셀 크기로
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		this.add(scrollPane);            // JFrame에 scrollPane 배치
	}

	public static void main(String[] args) {
		Ex12_3_10_JFrameWithJScrollPane frame = new Ex12_3_10_JFrameWithJScrollPane("JFrameWithScrollPane");  // 윈도우 생성 및 설정

		frame.setupComponents();  // frame에 배치될 컴포넌트들의 속성 설정
		frame.addComponents();    // frame에 컴포넌트들을 배치  
		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                 
 *   2) 프로그램을 수행하고 여러 라인에 걸처 이름을 입력하면서
 *      화면이 어떻게 변하는가를 확인하라.  
 */
