import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfNullLayout ]: 수동 배치방식으로 버튼들을 배치하기
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
 *                               가로와 세로 크기 설정하여 좌표 (x, y) 위치에  배치
 *       
 *     - public void setBackground(Color c) : 배경색을 주어진 색상으로 설정
 *     - public void setForeground(Color c) : 전경색을 주어진 색상으로 설정
 *     - public void setFont(Font f) : 컴포넌트의 폰트 설정
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

class Ex12_3_01_JFrameOfNullLayout {
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    frame.setLayout(null);    // 컴포넌트 배치 방식을 수동 배치방식으로 

	    frame.setSize(250, 150);  // 가로 210픽셀, 세로 150픽셀 크기로
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정
	  
	    // 수동 배치방식으로 컴포넌트를 배치하기 위한 컴포넌트 생성, 크기와 위치 설정
	    JButton bt1 = new JButton("button-1");         // 버튼 객체 생성
	    bt1.setSize(90, 30); bt1.setLocation(5, 5);    // 버튼 크기와 위치 지정
	    
	    JButton bt2 = new JButton("button-2"); 
	    bt2.setSize(90, 30); bt2.setLocation(140, 5); 	    
	    
	    JButton bt3 = new JButton("button-3"); 
	    bt3.setSize(90, 30); bt3.setLocation(25, 40); 
	    
	    JButton bt4 = new JButton("button-4"); 
	    bt4.setSize(90, 30); bt4.setLocation(120, 40); 
	    
	    JButton bt5 = new JButton("button-5"); 
	    bt5.setBounds(105, 75, 90, 30);       
	      
	    // 수동 배치방식 컨테이너에 컴포넌트 배치하기 - 컴포넌트의 크기와 위치가 미리 지정되어야 함
	    frame.add(bt1); frame.add(bt2); frame.add(bt3); frame.add(bt4); frame.add(bt5);

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
 *   1) frame의 크기를 130, 300으로 변경하라. 이때에는 frame의 setSize() 메소드를 변경한다.
 *   
 *   2) 버튼들을 한 라인에 하나씩을 출력하도록 각 버튼에 대한 setLocation() 메소드 호출을 변경하라.
 *      이 때에는 버튼의 setLocation() 메소드의 x 위치는 모두 동일하게 하고  
 *      y 위치 값을 각 버튼마다 일정하게 증가시켜야 한다.
 *      
 *   3) 수동 배치방식으로 이름, 나이, 학과, 학년을 입력하는 GUI 프로그램을 작성하라.
 *      이때 레이블과 텍스트필드의 크기와 위치는 적절히 결정한다.
 */
