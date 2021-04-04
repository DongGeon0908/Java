import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * [ JFrameWithJButtons] : 
 *    JButton 클릭하면 레이블에 이미지 보여주기
 *    
 *   o 2개 버튼 중 하나 클릭하면 해당 버튼의 이미지를 보여줌        
 */

// 대개 GUI 프로그램은 JFrame을 확장하는 하위 클래스로 JFrame 객체를 생성함
class Ex12_4_2_JFrameWithJButtons extends JFrame {
	JButton btShowCat = new JButton("고양이 보기");  // 텍스트 갖는 버튼 생성
	JButton btShowDog = new JButton("강아지 보기");  // 텍스트 갖는 버튼 생성

	ImageIcon iconCat = new ImageIcon("images/cat.jpg");  // 이미지 아이콘 생성
	JLabel labelCat = new JLabel(iconCat);       // 이미지 갖는 레이블 생성

	ImageIcon dogIcon = new ImageIcon("images/dog.jpg");  // 이미지 아이콘 생성
	JLabel labelDog = new JLabel("강아지 이미지", dogIcon, SwingConstants.CENTER);   // 텍스트와 이미지 갖는 레이블 생성

	// 객체 생성자: 윈도우를 위한 설정
	Ex12_4_2_JFrameWithJButtons(String title) { 
		super(title);

		this.setSize(450, 300);       // 가로 450픽셀, 세로 300픽셀 크기로
		this.setLocation(420, 220);   // 윈도우를 (420, 220) 위치에 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 옵션 지정

		this.setLayout(new GridLayout(2, 2, 10, 10));  // 컴포넌트 배치방식을 grid layout으로 
	}

	// 윈도우에 필요한 컴포넌트를 추가하여 배치하는 메소드
	void addComponents() {   
		this.add(btShowCat);
		this.add(btShowDog);
		this.add(labelCat);
		this.add(labelDog);
	}

	// 윈도우를 스크린에 나타나게 하고 입력을 기다리게 하는 메소드 
	void showFrame() {
		labelCat.setVisible(false); // setVisible(false)로 고양이 이미지 나타나지 않게 함
		labelDog.setVisible(false); // setVisible(false)로 강아지 이미지 나타나지 않게 함

		this.setVisible(true);      // 이 객체를 setVisible(true)로 하면 윈도우가 나타남 
	}

	// JButton 객체에 버튼 이벤트 리스너 객체를 등록시키는 메소드
	//    JButton 객체에서 마우스 클릭이 되면  
	//    등록된 Button_Listener 객체의 이벤트 메소드가 자동적으로 호출되면서 MouseEvent 객체가 매개변수로 전달됨
	void enrolEventListener() {
		// 익명 클래스를 사용하여 리스너 객체 생성
		MouseAdapter listener = new MouseAdapter() {
			// mousePressed() 메소드는 마우스 클릭이 완료된 후  자동적으로 호출되는 메소드임
			// 입력된 문자열을 검토하여 정상적인 실수 온도이면 다른 온도로 변환하여 출력
			public void mousePressed(MouseEvent e) { 
				Object src = e.getSource();       // 이벤트 발생한 소스를 구함
				if (src == btShowCat) {           // 입력 이벤트 발생 소스가btShowCat 버튼이면
					labelCat.setVisible(true);    //   labelCat 레이블을 보이게 함
				}
				else if (src == btShowDog) {      // 입력 이벤트 발생 소스가 btShowDog 버튼이면
					labelDog.setVisible(true);    //   labelDog 레이블을 보이게 함
				}
			}
		}; // 리스너 객체 생성

		btShowCat.addMouseListener(listener);  // 리스너 객체를 등록시킴
		btShowDog.addMouseListener(listener);  // 리스너 객체를 등록시킴
	}
	
	void enrolEventListener2() {
		Button_Listener listener = new Button_Listener(); // 리스너 객체 생성
		btShowCat.addMouseListener(listener);  // 리스너 객체를 등록시킴
		btShowDog.addMouseListener(listener);  // 리스너 객체를 등록시킴
	}

	// MouseAdapter를 확장하는 버튼 이벤트 리스너 클래스(내부 클래스)
	//  이 클래스는 MouseAdapter의 mousePressed() 메소드를 오버라이딩함
	//  마우스 클릭이 완료된 후 자동적으로 호출되는  mousePressed()를 이용하여 입력처리
	class Button_Listener extends MouseAdapter {
		// mousePressed() 메소드는 마우스 클릭이 완료된 후  자동적으로 호출되는 메소드임
		// 입력된 문자열을 검토하여 정상적인 실수 온도이면 다른 온도로 변환하여 출력
		public void mousePressed(MouseEvent e) { 
			Object src = e.getSource();       // 이벤트 발생한 소스를 구함
			if (src == btShowCat) {           // 입력 이벤트 발생 소스가btShowCat 버튼이면
				labelCat.setVisible(true);    //   labelCat 레이블을 보이게 함
			}
			else if (src == btShowDog) {      // 입력 이벤트 발생 소스가 btShowDog 버튼이면
				labelDog.setVisible(true);    //   labelDog 레이블을 보이게 함
			}
		}
	}

	public static void main(String[] args) {
		Ex12_4_2_JFrameWithJButtons frame =  
				 new Ex12_4_2_JFrameWithJButtons("JFrameWithJButtons");  // 윈도우 생성 및 설정
		
		frame.addComponents();      // frame에 컴포넌트들을 배치  
		frame.enrolEventListener(); // 버튼에 리스너 등록시킴
		frame.showFrame();          // frame을 나타나게 하고 입력을 기다림
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *                 
 *   2) 프로그램을 수행하고 프로그램 결과를 확인하라.
 *   
 *   3) 이 프로그램에 이벤트 처리를 위한 리스너 클래스가 2개 작성되어 있다. 
 *      main()에서  << frame.enrolEventListener(); >>을
 *      << frame.enrolEventListener2(); >>로 변경해도 이벤트 처리된다.
 */
