import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * [ Ex12_5_1_JButtonEvent ]: JButton에 대해 발생 가능한 이벤트들을 처리하는 프로그램
 *  
 *   o JButton에서는 Action 이벤트, Mouse 이벤트, Fucus 이벤트 등이 발생 가능
 *  
 *   o 버튼에서 이벤트 처리를 위한 사전 준비작업: 
 *     - 버튼에 대한 리스너 클래스 작성, 리스너 객체 생성 및 등록
 *     - 처리를 위한 Action 리스너 객체, Mouse 리스너 객체, Focus 리스너 객체 등록 가능(그 외도 가능)
 *     - Action 리스너 클래스, Mouse 리스너 클래스, Focus 리스너 클래스의 이벤트 처리 메소드들 작성해야 함 
 *     - 이들 리스너 클래스 객체 생성하여 버튼에 등록하면 이벤트 처리 준비 완료
 *  
 *   o 각 이벤트에 대한 이벤트 리스너 객체를 버튼에 등록한 후 버튼에서 이벤트 발생할 경우
 *     1) 이벤트 객체 생성
 *     2) 등록된 이벤트 리스너의 해당 이벤트 처리 메소드가 모두 차례로 호출되어 수행
 *     3) 이벤트 처리 메소드가 호출될 때 이벤트 객체가 실매개변수로 전달
 */

public class Ex12_5_1_JButtonEvent extends JFrame {
	JTextField tf1, tf2, tfRes;  // 왼쪽 피연산자, 오른쪽 피연산자, 결과를 저장할 텍스트 필드
	JButton btnPlus;             // 연산자를 나타내는 버튼

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	Ex12_5_1_JButtonEvent() {
		setTitle("Adder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		this.add(tf1 = new JTextField("1234", 10));  // 초기값 "1234", 크기 10인 텍스트필드
		this.add(btnPlus = new JButton(" + "));

		this.add(tf2 = new JTextField("2345", 10));  // 초기값 "2345", 크기 10인 텍스트필드
		this.add(new JLabel(" = "));
		this.add(tfRes = new JTextField("", 10));    // 초기값 "", 크기 10인 텍스트필드

		ActionListener aListener = new MyActionListener();  // Action 리스너 객체 생성하여
		btnPlus.addActionListener(aListener);               // 덧셈 버튼에 등록  ==> 버튼 클릭하면 Action 이벤트 발생하여 처리됨

		MouseListener mListener = new MyMouseListener();    // Mouse 리스너 객체 생성하여
		btnPlus.addMouseListener(mListener);                // 덧셈 버튼에 등록  ==> 버튼 클릭하거나 마우스로 버튼 이동하면 Mouse 이벤트 발생하여 처리됨

		FocusListener fListener = new MyFocusListener();    // Focus 리스너 객체 생성하여
		btnPlus.addFocusListener(fListener);                // 덧셈 버튼에 등록  ==> 버튼이 focus 얻거나 잃게 되면 Focus 이벤트 발생하여 처리됨

		setBounds(500, 400, 450,100);		
		
		setVisible(true);   // 생성된 JFrame 객체를 화면에 나타나게 함
	}

	// tf1과 tf2에 입력된 정수값 가져와 덧셈 결과를 계산하여 tfRes에 출력하는 메소드
    void  doAddition(int methodNo) {
        try {
            int op1 = Integer.parseInt(tf1.getText());
            int op2 = Integer.parseInt(tf2.getText());
            
            tfRes.setText( methodNo + ") " + (op1 + op2) );
         }
         catch(Exception ex) {
             JOptionPane.showMessageDialog(null, " Error - " + ex.getMessage(), 
                                             "정수 입력에서의 오류", JOptionPane.ERROR_MESSAGE);
         }
    }
    
    int cntCalls = 0;  // 이벤트 처리 메소드가 호출된 회수 저장하는 변수, 메소드가 호출될 때마다 1 증가됨

    //ActionListener를 구현하는  Action 리스너 클래스 작성
    //  Action 이벤트는 마우스로 컴포넌트 또는 아이템을 선택하거나 엔터키 입력 시 발생
    //  Action 리스너의 이벤트 처리 메소드는  actionPerformed() 하나
    class MyActionListener implements ActionListener {

       // 마우스로 버튼을 클릭하면 발생하는 이벤트 처리하는 메소드   
       public void actionPerformed(ActionEvent e) { 
          System.out.println("[" + ++cntCalls + "] 1) actionPerformed(ActionEvent e)");

  		   JButton b = (JButton)e.getSource();// 선택된 버튼 객체 가져옴              
          if (b == btnPlus) 
             doAddition(1);
       } 
    }
    
    // MouseListener를 구현하는 Mouse 리스너 클래스를 내부 클래스로 작성
    //   Mouse 이벤트는 마우스가 컴포넌트와 연관된 작업을 수행하면 발생
    //   Mouse 리스너의 이벤트 처리 메소드는 모두 5개
    class MyMouseListener implements MouseListener {

        // 마우스로 버튼 클릭하면 발생하는 이벤트를 처리하는 메소드      
        public void mouseClicked(MouseEvent e) { 
           System.out.println("[" + ++cntCalls + "] 2) mouseClicked(MouseEvent e)");
           
           JButton b = (JButton)e.getSource(); // e.getSource() 메소드는 선택된 버튼 객체 구함
           if (b == btnPlus) 
              doAddition(2);
        }     
        
        // 마우스로 버튼 누르면 발생하는 이벤트를 처리하는 메소드            
        public void mousePressed(MouseEvent e) { 
           System.out.println("[" + ++cntCalls + "] 3) mousePressed(MouseEvent e)");
           doAddition(3);
        } 

       // 마우스로 버튼 눌렀다가 떼면 발생하는 이벤트를 처리하는 메소드         
       public void mouseReleased(MouseEvent e) { 
          System.out.println("[" + ++cntCalls + "] 4) mouseReleased(MouseEvent e)");
          
          JButton b = (JButton)e.getSource(); // e.getSource() 메소드는 선택된 버튼 객체 구함
          if (b == btnPlus) 
             doAddition(4);
       } 

       // 마우스가 버튼으로 들어오면 발생하는 이벤트를 처리하는 메소드
       public void mouseEntered(MouseEvent e) { 
          System.out.println("[" + ++cntCalls + "] 5) mouseEntered(MouseEvent e)");
       } 
       
       // 마우스가 버튼을 떠나면 발생하는 이벤트를 처리하는 메소드
       public void mouseExited(MouseEvent e) {  
          System.out.println("[" + ++cntCalls + "] 6) mouseExited(MouseEvent e)");
       }       
    }
    
    //FocusListener를 구현하는 Focus 리스너를 작성
    //  Focus 이벤트는 컴포넌트가 포커스를 얻거나 잃으면 발생
    //  Focus 리스너의 이벤트 처리 메소드는 모두 2개
    class MyFocusListener implements FocusListener {
    	
       // focus를 얻으면 발생하는 이벤트를 처리하는 메소드
       public void focusGained(FocusEvent e) {  
          System.out.println("[" + ++cntCalls + "] 7) focusGained(FocusEvent e)");
       } 
       
       // focus를 잃으면 발생하는 이벤트를 처리하는 메소드
       public void focusLost(FocusEvent e) {  
          System.out.println("[" + ++cntCalls + "] 8) focusLost(FocusEvent e)");
       }
    }
    
	public static void main(String [] args) {
		new Ex12_5_1_JButtonEvent();
	}
 }

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 버튼에 대해 Action 이벤트, Mouse 이벤트, Focus 이벤트 리스너 객체 등록한다.
 *      - 마우스 클릭, 마우스의 컴포넌트로의 이동, Focus의 얻음과 잃음 등의 경우 이벤트가 발생
 *      - 이벤트 발생하면 이벤트 객체 생성, 이벤트 리스너 객체의 해당 이벤트 처리 메소드 자동적 호출
 *      - 이벤트 처리 메소드 호출될 때 이벤트 객체가 매개변수로 전달
 *      - 이러한 작업은 Java 가상기계의 이벤트 분배를 담당하는 프로그램에 의해 수행
 *        (이 부분은 보이지 않지만 개략적으로 이해할 것)
 *        
 *   2) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 * 
 *   3) 프로그램을 수행하고 컨솔 뷰에 출력되는 내용을 확인하라.
 *      - 마우스 이동 및 클릭, 탭 키로 포커스 얻음과 잃음 등에 대해 이벤트 처리 메소드 호출 상황이 컨솔 뷰에 출력
 *      - 이벤트별 호출되는 이벤트 처리 메소드와 호출 순서 확인할 것
 *      
 *      - 버튼에 마우스 들어가면 mouseEntered(), 나가면 mouseExited() 메소드 호출됨
 *      - 마우스로 버튼 클릭하면 mousePressed(), focusGained(), actionPerformed(),  mouseReleased(),  
 *        mouseClicked() 등 5개 메소드가 순서대로 모두 호출됨   
 *        
 *      - 탭 키로 마우스로 들어가면 focusGained(), 나가면 focusLost() 메소드 호출됨
 *  
 *   4) 프로그램을 수행하고 덧셈 결과를 확인하라.  
 *      - 이벤트 처리되는 양상 보이기 위해 Action 이벤트, Mouse 이벤트, Focus 이벤트 리스너 객체가 
 *        버튼에  등록되어 여러 이벤트를 처리
 *        
 *      - 4개의 actionPerform(), mouseClicked(), mousePressed(), mouseReleased() 메소드 모두
 *        덧셈 결과 구해 결과 텍스트필드에 출력하지만 앞의 결과 지워지고 마지막 mouseClicked()의 결과만 보임
 *        
 *      - actionPerform(), mouseClicked(), mousePressed(), mouseReleased() 메소드 중 하나만 
 *        작성해도 덧셈 결과를 구해 출력 가능함
 *        
 *      - 어느 이벤트 리스너의 어느 이벤트 처리 메소드를 작성할 지는 프로그래머가 결정할 사항
 *  
 *  
 * [ 실습과제 ]
 *
 *    o Focus를 얻을 때 "포커스를 얻음", Focus를 일을 때 "포커스를 잃음"을 JOptionPane을 이용하여 출력하도록
 *       프로그램을 수정하라.     
 */
