import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfGridLayout ]: 자동 배치방식인 grid layout으로 JFrame에 버튼들을 배치하기
 *             
 *    o 컨테이너 컴포넌트
 *       - 다른 컴포넌트를 배치할 수 있는 컴포넌트
 *       - 최상위 컨테이너와 종속 컨테이너로 구분됨
 *       - 최상위 컴포넌트: 다른 컨테이너에 배치되지 않고서 스크린에 디스플레이될 수 있는 컨테이너
 *          JFrame, JDialog
 *          
 *       - 종속 컨테이너: 다른 컨테이너에 배치되어야만 스크린에 디스플레이될 수 있는 컨테이너
 *          JPanel, JScrollPane
 *       
 *    o 컨테이너 컴포넌트들의 속성 설정을 위한 메소드
 *     - public void setSize(int width, int height) : 가로와 세로 크기 설정
 *     - public void setLocation(int x, int y) : 좌표 (x, y) 위치에 배치
 *     - public void setBounds(int x, int y, int width, int height) : 
 *                               가로와 세로 크기 설정하여 좌표 (x, y) 위치에  배치
 *       
 *     - public void setBackground(Color c) : 배경색을 주어진 색상으로 설정
 *     - public void setForeground(Color c) : 전경색을 주어진 색상으로 설정
 *     - public void setFont(Font f) : 컴포넌트의 폰트를 설정
 *      
 *     - public void setFocusable(boolean b) : 포커스를 받을 수 있거나 없게 함 
 *     - public void setEnabled(boolean b) : 입력에 대해 반응할 수 있거나 없게 함
 *     - public void setVisible(boolean b) : 디스플레이되게 하거나 사라지게 함
 *       
 *   o 컨테이너 컴포넌트에 컴포넌트 배치를 위한 메소드
 *     - public void setLayout(LayoutManager mgr) : 컴포넌트 배치하는 방식 설정
 *     - public Component add(Component comp) : 컴포넌트 comp 추가하여 배치
 *     - public void remove(Component comp) : 배치된 comp 제거
 *     - public Component getComponent(int n) : 배치된 n번째의 컴포넌트 반환
 *       
 *   o 컨테이너 컴포넌트의 배치방식 설정하기
 *     - setLayout(null) : 수동 배치방식 - 컴포넌트 크기와 위치를 직접 지정하여 배치
 *     - setLayout( new FlowLayout() ) : 자동 배치방식 - 왼쪽에서 오른쪽, 위에서 아래로 차례로 배치
 *     - setLayout( new BorderLayout() ) : 자동 배치방식 - 컴포넌트들을 동, 서, 남, 북, 중앙 등 5개 영역에 배치
 *     - setLayout( new GridLayout() ) : 자동 배치방식 - 배치 공간을 동일한 크기의 2차원 그리드로 나누어 
 *                                       왼쪽에서 오른쪽, 위에서 아래로 자동 배치
 *     - setLayout( new CardLayout() ) : 자동 배치방식 - 컴포넌트들을 카드 쌓은 형태로 자동 배치, 
 *                                       하나의 컴포넌트만 나타나게 함   
 */

class Ex12_3_04_JFrameOfGridLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3, 2) ); // 배치방식: 3*2 행렬의 grid layout

		frame.setSize(200, 100);            // 가로 150픽셀, 세로 100픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정

		// grid layout 컨테이너에 컴포넌트 배치 
		frame.add(new JLabel("    이름:"));   frame.add(new JTextField(10));  
		frame.add(new JLabel("    나이:"));   frame.add(new JTextField(10));  
		frame.add(new JLabel("    현위치:"));  frame.add(new JTextField(10));  
	
		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남    
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                  
 *   2) 프로그램을 수행하고 결과를 확인하라.
 *   
 *   3) 마우스로 윈도우의 오른쪽 아래를 드래그하여 윈도우의 크기를 변경하면 배치된 컴포넌트의 배치가 
 *      어떻게 되는가를 확인하라.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) frame의 크기를 230, 300으로 변경하라. 이때에는 frame의 setSize() 메소드를 변경한다.
 *         
 *   2) 이 프로그램의 결과에서 3개 레이블과 3개 텍스트필드가 행 개수 3, 열 개수 2인 그리드에 배치되어 있다. 
 *      행 개수 3, 열 개수 3, 수평 여백 10과 수직 여백 10인 grid layout 설정하기 위하여
 *      << frame.setLayout(new GridLayout(3, 2)); >> 메소드 호출을 변경하라.  
 *      
 *      행 개수, 열 개수, 수평 여백, 수직 여백을 지정하기 위해서는 GridLayout 클래스의 
 *      객체 생성자 GridLayout(int rows, int cols, int hGap, int vGap)의 
 *      rows, cols, hGap, vGap 매개변수를 지정할 값으로 전달한다.
 */
