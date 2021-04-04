
import javax.swing.*;        

/**
 * [ JOptionPane ]: JOptionPane의 사용법을 보여주는 예제
 * 
 *   o JOptionPane
 *     - 문자열을 입력하거나 정보를 출력하기 위해 표준 대화상자를 팝업시키는 편리한 방법을 제공하는 클래스
 *       
 *   o JOptionPane의 주요 메소드
 *     - public static String showInputDialog(Object message) : 
 *           message를 출력한 후 사용자 입력 받아 문자열로 반환
 *           
 *     - public static int showConfirmDialog(Component parent, Object msg, 
 *           String title, int optionType): title과 msg 출력하고 optionType에 따른 입력을 정수로 반환
 *           
 *     - public static void showMessageDialog(Component  parent, Object msg): msg 출력
 *     
 *     - public static void showMessageDialog(Component parent, Object msg, 
 *           String title, int optionType): title 출력하고 optionType에 따른 msg 출력   
 *              
 *     - 모두 static 메소드이므로 객체 생성하지 않고 클래스 이름으로 호출 가능
 *   
 *   o 모달 유형(modal type)의 대화상자 작동방식
 *     - JOptionPane의 메소드가 호출되면 대화 상자가 생성되어 화면에 나타남
 *     - JOptionPane 대화상자의 작업이 완료될 때까지 Java 프로그램은 대기
 *     - 이러한 방식의 대화상자 작동방식을 모달 유형(modal type)이라 함 
 */

class Ex12_3_08_1_JOptionPane {
	public static void main(String[] args) {		
		String name = JOptionPane.showInputDialog("이름을 입력하시오");  
		
		System.out.println("이름: " + name);			
		JOptionPane.showMessageDialog(null, "입력된 이름은 " + name +"입니다.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 


		int yes_or_no = JOptionPane.showConfirmDialog(null, "당신은 남성입니까?", 
				                         "ConfirmDialog", JOptionPane.YES_NO_OPTION);  
		
		if (yes_or_no == JOptionPane.YES_OPTION) 
			System.out.println("당신은 남성입니다.");
		else
			System.out.println("당신은 여성입니다.");
	
		JOptionPane.showMessageDialog(null, "당신은 " + (yes_or_no == JOptionPane.YES_OPTION ? "남성" : "여성") + "이네요.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 
 
		// 학생 여부 확인시 사용자에 의한 닫힘과 취소도 가능함
		int yes_or_no_cancel = JOptionPane.showConfirmDialog(null, "당신은 학생입니까?", 
				                   "ConfirmDialog", JOptionPane.YES_NO_CANCEL_OPTION);  		
		if (yes_or_no_cancel == JOptionPane.YES_OPTION) 
			System.out.println("당신은 학생입니다.");
		else if (yes_or_no_cancel == JOptionPane.NO_OPTION) 
			System.out.println("당신은 학생이 아닙니다.");
		else if (yes_or_no_cancel == JOptionPane.CANCEL_OPTION) 
			System.out.println("사용자에 의해 닫혀짐.");
		else if (yes_or_no_cancel == JOptionPane.CLOSED_OPTION) 
			System.out.println("사용자에 의해 취소됨");  
			
		// 여러 종류의 메시지를 보여주는 예제
		JOptionPane.showMessageDialog(null, "지금부터 여러 메시지 상자가 보입니다.", 
                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 

		JOptionPane.showMessageDialog(null, "사용자에 의해 닫혀짐"); 

		JOptionPane.showMessageDialog(null, "사용자에 의해 취소됨", 
            	                "PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "정수가 입력되어야 합니다", 
	                        	"ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "변수에 값이 저장되지 않았습니다", 
                             	"WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "인원수를 확인하기 바랍니다", 
             	                "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE); 
		
		JOptionPane.showMessageDialog(null, "사용자가 로그인 되었습니다", 
								"INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE); 		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.
 *      - OptionPane의 입력 작업, 확인 작업, 메시지 출력 작업 등에 사용되는 메소드와 메소드의 매개변수가 달라지면 
 *        대화상자가 달라짐
 *             
 *   2) 프로그램을 수행하고 결과를 확인하라.    
 *      - 입력 대화 상자에서 입력된 문자열이 프로그램에 전달되어 컨솔 뷰에 출력되거나 대화 상자에 출력됨을 확인하라.      
 */
