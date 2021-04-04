import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * [ Calculator2_JRadioButton ] : 라디오 버튼을 이용하여 4칙 연산 수행하는 GUI 프로그램
 * 
 *  o 라디오 버튼
 *    - 여러 중에서 하나만을 선택할 수 있게 하는 컴포넌트
 *    - 객체 생성자 
 *       public JRadioButton(String text): 주어진 문자열의 라디오 버튼 생성
 *       public JRadioButton(Icon icon): 주어진 이미지 갖는 라디오 버튼 생성 
 *       public JRadioButton(String text, boolean selected): 주어진 문자열의 라디오 버튼 생성하며 selected가 true이면 선택되게 함
 *       JRadioButton(Icon icon, boolean selected): 주어진 이미지 갖는 라디오 버튼 생성하며 selected가 true이면 선택되게 함
 *       
 *    - 라디오 버튼은 반드시 컨테이너에 배치될 뿐 아니라 ButtonGroup 객체에도  add되어야 함  
 *       
 *        String[] oprNames = { "더하기", "빼기", "곱하기", "나누기" };
 *        String[] oprSign = { "  + ", " - ", " * ", " / " };
 *      
 *        ButtonGroup btnGroup = new ButtonGroup();       // 라디오 버튼들을 담을 버튼 그룹
 *        JRadioButton[] btnOprs  = new JRadioButton[4];  // +, -, * /를 나타낼 radio button 배열
 *      
 *        MyActionListener listener = new MyActionListener(); 
 *      
 *        for (int i=0; i<4; i++) {
 *	 	     btnOprs[i] = new JRadioButton(oprNames[i]);
 *		  	 btnOprs[i].addActionListener(listener);
 *			
 *			 add(btnOprs[i]);  			
 *		     btnGroup.add(btnOprs[i]);    // btnOprs[i]을 btnGroup에 추가
 *		  }
 * 
 *   - 라디오 버튼의 중요 메소드
 *      public boolean isSelected(): 라디오 버튼 선택되었으면 true, 아니면 false 반
 *      public void addActionListener(ActionListener l): Action 리스너를 등록 
 *      public void addItemListener(ItemListener l): Item 리스너를 등록 
 *      public void addChangeListener(ChangeListener l): Change 리스너를 등록 
 * 
 *   - 라디오 버튼은 Action 이벤트, Item 이벤트, Change 이벤트를 발생시킴
 *   
 *  o Item 이벤트
 *    - 선택 가능한 아이템이 선택되면 발생하는 이벤트
 *    - 라디오 버튼의 상태가 변해도 발생함(이때에는 Action이벤트도 발생)
 *    - ItemListener 인터페이스를 구현하면 Item 이벤트를 처리 할 수 있음
 *    - ItemListener 인터페이스의 이벤트 처리 메소드 
 *          void itemStateChanged(ItemEvent e)
 */

class Ex12_6_2_Calculator2_JRadioButton {
	public static void main(String [] args) {
		new CalculatorFrame_JRadioButton();
	}
}

class CalculatorFrame_JRadioButton extends JFrame {
	
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	String[] oprNames = { "더하기", "빼기", "곱하기", "나누기" };
	String[] oprSign = { "  + ", " - ", " * ", " / " };

	
    ButtonGroup btnGroup = new ButtonGroup();       // 라디오 버튼들을 담을 버튼 그룹
	JRadioButton[] btnOprs  = new JRadioButton[4];  // +, -, * /를 나타낼 라디오 버튼  배열

	JLabel opr;

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	CalculatorFrame_JRadioButton() {
		setTitle("계산기 - JRadioButton 배열 이용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());

		add(tf1 = new JTextField("1234", 10)); // 초기값 "1234", 크기 10인 텍스트필드
		add(opr = new JLabel(oprSign[0]));

		add(tf2 = new JTextField("2345", 10)); // 초기값 "2345", 크기 10인 텍스트필드
		add(new JLabel("  =  "));
		add(tfRes = new JTextField("", 10));   // 초기값 "", 크기 10인 텍스트필드

		MyItemListener iListener = new MyItemListener();      // Item 리스너 객체 생성
		MyActionListener aListener = new MyActionListener();  // Action 리스너 객체 생성

		for (int i=0; i<4; i++) {
			btnOprs[i] = new JRadioButton(oprNames[i]);  // i번째 라디오 버튼 생성
			btnOprs[i].addItemListener(iListener);       // 라디오 버튼에 Item 리스너 객체 등록
			btnOprs[i].addActionListener(aListener);     // 라디오 버튼에 Action 리스너 객체 등록
			
			add(btnOprs[i]);  			                 // btnOprs[i]를 컨테이너에 배치 
		    btnGroup.add(btnOprs[i]);                    // btnOprs[i]를 btnGroup에 추가
		}
		
		setBounds(500, 400, 450,100);	
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}
	
	// 4개 라디오 버튼 중 하나 클릭되면 해당 라디오 버튼 탐색하여 이벤트 처리하는 리스너 클래스(내부 클래스로 작성)
	//   ItemListener를 구현하는  Item 리스너
	//   Item 리스너의 이벤트 처리 메소드는  itemStateChanged() 하나임
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			try {			
				// tf1과 tf2에 입력된 정수값을 가져와 선택 연산자에 따라 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				for (int i=0; i < btnOprs.length; i++)  // 클릭된 라디오버튼을 찾아 해당 연산을 수행하여 결과를 결과 텍스트필드에 출력
					if (btnOprs[i].isSelected()) {      // 라디오 버튼 중에 선택된 라디오 버튼만 isSelected() 메소드가 true인 것 이용하여 선택된 버튼 찾음
						opr.setText(oprSign[i]);                      // 연산자 출력
						tfRes.setText(" " + getResult(op1, i, op2));  // 계산 결과 출력
					}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// 4개의 라디오 버튼 중 하나가 클릭되면 해당 라디오 버튼을 탐색하여 이벤트 처리하는 리스너 클래스
	//   ActionListener를 구현하는  Action 리스너
	//   Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나임
	class MyActionListener implements ActionListener {
		
		// 버튼을 클릭하면 호출되는 이벤트 처리 메소드를 구현함
		public void actionPerformed(ActionEvent e) {
			JRadioButton b = (JRadioButton)e.getSource();// e.getSource() 메소드는 선택된 라디오 버튼 객체 구함
			System.out.println("선택된 RadioButton = " + b );
			
			try {			
				// tf1과 tf2에 입력된 정수값을 가져와 선택 연산자에 따라 결과를 계산하여 tfRes에 출력
				int op1 = Integer.parseInt(tf1.getText());
				int op2 = Integer.parseInt(tf2.getText());

				// 라디오 버튼에서 선택된 버튼 찾기
				for (int i=0; i < btnOprs.length; i++)  // 클릭된 라디오버튼을 찾아 해당 연산을 수행하여 결과를 결과 텍스트필드에 출력
					if (btnOprs[i].isSelected()) {      // 라디오 버튼 중에 선택된 라디오 버튼만 isSelected() 메소드가 true인 것 이용하여 선택된 버튼 찾음
						opr.setText(oprSign[i]);                      // 연산자 출력
						tfRes.setText(" " + getResult(op1, i, op2));  // 계산 결과 구해 출력
					}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, " Error: " + ex.getMessage(), "계산기에서의 오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	// 왼쪽 피연산자, 연산자 번호(0: 더하기, 1: 빼기, 2: 곱하기, 3; 나누기), 오른쪽 피연산자가 주어지면 계산하여 결과 반환하는 메소드
	int getResult(int op1, int opr, int op2) { 
		int res  = 0;

		if (opr == 0) res = op1 + op2;
		else if (opr == 1) res =  op1 - op2;
		else if (opr == 2) res =  op1 * op2;
		else if (opr == 3) res =  op1 / op2;

		return res;			
	}		
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 라디오 버튼을 이용하여 4칙 연산 수행한다.
 *      - 라디오 버튼의 객체 생성자, 속성 설정 메소드, 발생 가능한 이벤트와 리스너 객체 등록 방법 등을 이해할 것   
 *      - 특히, 라디오 버튼은 반드시 ButtonGroup 객체에도 add 되어야 함을 확인할 것
 *     
 *   2) 라디오 버튼은 Action 이벤트, Item 이벤트 발생시키므로 이들을 위한 리스너 객체 등록 가능하다.
 *      Item 이벤트 클래스 작성방법과 여러 라디오 버튼 중 클릭된 버튼을 찾는 방법을 확인하라. 
 *               
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.  
 *      
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.
 */
