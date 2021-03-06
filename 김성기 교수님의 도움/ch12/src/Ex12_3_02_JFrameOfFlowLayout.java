import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfFlowLayout ]: 자동 배치방식인 flow layout으로 JFrame에 버튼들을 배치하기
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

class Ex12_3_02_JFrameOfFlowLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout());  // 컴포넌트 배치방식을 flow layout으로 

		frame.setSize(230, 144);  // 가로 210픽셀, 세로 150픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정

		// flow layout 컨테이너에 컴포넌트 배치하기 - 컴포넌트의 크기, 위치 지정할 필요 없음
		frame.add(new JButton("button-1"));
		frame.add(new JButton("button-2"));  
		frame.add(new JButton("button-3"));
		frame.add(new JButton("button-4"));    
		frame.add(new JButton("button-5"));    

		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남        }
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                  
 *   2) 프로그램을 수행하고 결과를 확인하라.
 *   
 *   3) 마우스로 윈도우의 오른쪽 아래를 드래그하여 윈도우의 크기를 변경하면 배치된 컴포넌트의 배치가 어떻게 되는가를 확인하라.
 *  
 *  
 * [ 실습과제 ]
 *
 *   1) frame의 크기를 230, 300으로 변경하라. 이때에는 frame의 setSize() 메소드를 변경한다.
 *   
 *   2) 이 프로그램은 5개의 버튼을 생성하고 이를 frame에 배치한다.
 *      3개의 버튼을 추가로 생성하여 frame에 배치하도록 프로그램을 변경하라.
 *      
 *   3) 20개의 버튼을 생성하여 frame에 배치하도록 프로그램을 변경하기 위해서는 20개의 버튼을 생성하고 
 *      20번 add() 메소드를 호출해야한다.
 *       
 *      이 작업은 배열과 for 문을 사용하여 보다 간결하게 작성할 수 있다.
 *      배열과 for 문을 사용하여 20개의 버튼을 frame에 배치하도록 프로그램을 변경하라.
 *      
 *   4) 버튼들을 왼쪽 정렬, 수평 여백 6, 수직 여백 7로 flow layout 설정하기 위하여
 *      << frame.setLayout(new FlowLayout()); >> 메소드 호출을 변경하라.  
 *      
 *      왼쪽 정렬을 위해서는  FlowLayout 클래스의 객체 생성자  FlowLayout(int align, int hGap, int vGap)에서 
 *      align 매개변수를 FlowLayout.LEFT로 전달한다.
 *      또한 수평 여백과 수직 여백을 지정하기 위해서는  hGap과 vGap 매개변수를 지정할 픽셀 수로 전달한다.
 *      
 *   5) 버튼들을 오른쪽 정렬, 수평 여백 10, 수직 여백 10으로 flow layout 설정하기 위하여
 *      << frame.setLayout(new FlowLayout()); >> 메소드 호출을 변경하라. 
 *      
 *      오른쪽 정렬을 위해서는 FlowLayout 클래스의 객체 생성자에서  align 매개변수를 FlowLayout.RIGHT로 전달한다.
 *      
 *   6) Flow Layout으로 이름, 나이, 학과, 학년을 입력하는 GUI 프로그램을 작성하라. 
 *      이때, 수평 여백과 수직 여백은 5로 설정한다.
 */
