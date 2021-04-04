import java.awt.*;
import javax.swing.*;        

/**
 * [ JFrameWithJLabels]: JLabel 객체들을 JFrame 객체에 배치
 *   
 *   o JLabel
 *     - 화면에 문자열 또는 이미지를 화면에 출력하여 필요한 정보 제공하기 위한 컴포넌트
 *   
 *   o JLabel 객체 생성자
 *     - 텍스트 갖는 레이블, 이미지 갖는 레이블, 이미지와 텍스트 모두 갖는 레이블  생성할 수 있게 함
 *     
 *       public JLabel(String text): 주어진 텍스트 갖는 레이블 생성 
 *       public JLabel(Icon image): 주어진 이미지 갖는 레이블 생성 
 *       public JLabel(String text,Icon image, int horizontalAlignment):
 *           주어진 수평 정렬의 텍스트와 이미지 갖는 레이블  생성 
 *           (수평 정렬은 SwingConstants 클래스의 상수 LEFT, CENTER, RIGHT, LEADING, TRAILING 중 하나 명시)        
 */

// 대개 GUI 프로그램은 JFrame을 확장하는 하위 클래스로 JFrame 객체를 생성함
class Ex12_4_1_JFrameWithJLabels extends JFrame {
	JLabel labelCatText = new JLabel("고양이");  // 텍스트 갖는 레이블 생성

	ImageIcon iconCat = new ImageIcon("images/cat.jpg");  // 이미지 아이콘 생성
	JLabel labelCatImage = new JLabel(iconCat);    // 이미지 갖는 레이블 생성

	ImageIcon iconDog = new ImageIcon("images/dog.jpg");  // 이미지 아이콘 생성
	JLabel labelDog = new JLabel("강아지 이미지", iconDog, SwingConstants.CENTER); // 텍스트와 이미지 갖는 레이블 생성

	// 객체 생성자: 윈도우를 위한 설정
	Ex12_4_1_JFrameWithJLabels(String title) { 
		super(title);

		this.setSize(450, 300);      // 가로 450픽셀, 세로 300픽셀 크기로
		this.setLocation(420, 220);  // 윈도우를 (420, 220) 위치에 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // 종료 옵션 지정
		
//		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));  // 컴포넌트 배치방식을 flow layout으로 
		this.setLayout(new GridLayout(2, 2));  // 컴포넌트 배치방식을 grid layout으로 
	}
	
	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		this.add(labelCatText);
		this.add(labelCatImage);
		this.add(labelDog);
	}

	public static void main(String[] args) {
		Ex12_4_1_JFrameWithJLabels frame = new   
				Ex12_4_1_JFrameWithJLabels("JFrameWithJLabels");  // 윈도우 생성 및 설정

		frame.addComponents();    // frame에 컴포넌트들을 배치  
		frame.setVisible(true);   // frame을 setVisible(true)로 하면 윈도우가 나타남 
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *   
 *   2) 프로그램을 수행하고 프로그램 결과를 확인하라.                
 *                 
 *   3) 레이블의 텍스트를 변경하여 프로그램 결과를 확인하라.  
 */
