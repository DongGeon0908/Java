import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameOfCardLayout ]: 자동 배치방식인 card layout으로 JFrame에 버튼들 배치하기
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

class Ex12_3_05_JFrameOfCardLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CardLayout cardlo = new CardLayout(30, 20);  // 수평 및 수직 여백이 30인  card layout 객체 생성

		frame.setLayout(cardlo);  //  배치방식: card layout
		frame.setSize(210, 150);  // 가로 210픽셀, 세로 150픽셀 크기로
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정

		// card layout 컨테이너에 버튼들 배치하기 - 버튼의 크기, 위치 지정할 필요 없음
		int noButtons = 20;
		JButton[] bts = new JButton[noButtons];    // 버튼 저장할 배열 생성 및 참조
  
		for (int i = 0; i < noButtons; i++) {  
			bts[i] = new JButton("button-" + (i+1));  // 버튼 생성하여 버튼 배열에 저장
			frame.add(bts[i]);                        // 버튼을 frame에 배치
		}     
		
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
 *   4) card layout의 경우 처음 배치된 컴포넌트만 디스플레이되고 다른 컴포넌트는 가려진다.
 *      다른 컴포넌트를 디스플레이하려면 처음 배치된 bts[0]을 setVisible(false)로 하고 
 *      디스플레이할 컴포넌트를 setVisible(true)로 하면 된다.      
 *      
 *      main() 메소드의 마지막 라인 << frame.setVisible(true); >> 다음 라인에 다음 코드 추가하고 결과 확인하라.
 *      
         for (int i = 0; i < noButtons - 1; i++) {
            try { Thread.sleep(1000); } catch(Exception e ) {} // 프로그램 수행을 1초 동안 중지시킴

            bts[i].setVisible(false);  // 이전 버튼을 보이지 않게 함
            bts[i+1].setVisible(true); // 다음 버튼을 보이게 함
         }
          
 *     
 */
