
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * [ JTable ]: JTable의 사용법을 보여주기 위한 예제
 *  
 *   o JTable 2개를 생성하여 한 화면에 출력하고 이벤트 처리함
 *     - 첫번째 테이블: 3개의 행과 3개의 열 가지는 신상정보 JTable
 *     - 두번째 테이블: 7개의 행과 4개의 열 가지는 좌석 예약 JTable
 *      
 *   o JTable은 행과 열의 개수에 따라 크기가 달라지므로 JScrollPane에 포함하여 디스플레이하면 편리
 *    
 *   o JTable의 특정 셀이 클릭되었을 때 클릭된 셀 확인하기 위한 방법
 *     1) MouseListener 인터페이스를 구현하는  리스너 클래스 작성하여 JTable 객체에 등록
 *     2) 리스너 클래스의  mouseClicked(MouseEvent e) 메소드에서
 *        (1) 클릭된 위치의 좌표 구하여 저장: Point p = e.getPoint();  
 *	   (2) 테이블에서 p 위치의 행 번호 구하여 저장: int row = tbl.rowAtPoint(p);     
 *	   (3) 테이블에서 p 위치의 열 번호 구하여 저장: int col = tbl.columnAtPoint(p);  
 */

public class Ex12_6_6_JFrameWithJTable extends JFrame{  
	String[] columnNames =  { "이름", "나이", "현위치" };    
	
	Object[][] tuples =  
		{  	{ "홍길동", 18, "금강산" }, 
			{ "이몽룡", 20, "남원" }, 
			{ "박문수", 30, "한양" }
	    };    

	String[] columnNames2 =  { "1열",    "2열", "3열", "4열" };    
	String[][] tuples2 =   
		{  	{ "1A", "2A", "3A",  "4A"   }, 
			{ "1B", "2B", "3B",  "4B"   }, 
			{ "1C", "2C", "3C",  "4C"   },
			{ "1D", "2D", "3D",  "4D"   },
			{ "1E", "2E", "3E",  "4E"   },
			{ "1F", "2F", "3F",  "4F"   },
			{ "1G", "2G", "3G",  "4G"   }
	    };    
	
	JTable personsTbl, seatsTbl;
	JLabel seatLabel;

	// 객체 생성자: 컴포넌트 배치 및 설정, 이벤트 객체 등록, 화면에 보이기 등 수행
	public Ex12_6_6_JFrameWithJTable(String title)    {   
		super(title);
		
		setLayout(null);

	    // 신상정보 저장하는 테이블  personsTbl 생성하여 여러 속성 설정 
		personsTbl = new JTable(tuples, columnNames);  // 2차원 배열 투플들과 1차원배열 애트리뷰트로 JTable 객체 생성함		
		personsTbl.setBackground(Color.cyan);
		personsTbl.setForeground(Color.black); 
		personsTbl.getTableHeader().setBackground(Color.YELLOW); // JTable의 헤더 구하여 배경색 지정		
		//	personsTbl.getTableHeader().setVisible(false);       // JTable의 Header 부분을 보이지 않게 함
		personsTbl.setCellSelectionEnabled(true);                // JTable의 각 cell을 선택할 수 있게 함
		
		// personsTbl을 담은 스크롤패인 생성하여 배치
		JScrollPane jScrollPane1 = new JScrollPane(personsTbl); 
		jScrollPane1.setSize(300, 80);
		jScrollPane1.setLocation(130, 30);
		add(jScrollPane1);   
		
		
		// 좌석 예약정보 저장하는 테이블  seatsTbl 생성하여 여러 속성 설정 
		seatsTbl = new JTable(tuples2, columnNames2);  // 2차원 배열 투플들과 1차원배열 애트리뷰트로 JTable 객체 생성함		
		seatsTbl.setBackground(Color.cyan);
		seatsTbl.setForeground(Color.black); 
		seatsTbl.getTableHeader().setBackground(Color.YELLOW); // JTable의 헤더 구하여 배경색 지정		
//		seatsTbl.getTableHeader().setVisible(false);           // JTable의 Header 부분을 보이지 않게 하려면 false로 지정하면 됨
		seatsTbl.setCellSelectionEnabled(true);                // JTable의 각 cell을 선택할 수 있게 함

		// seatsTbl을 담은 스크롤패인 생성하여 배치
		JScrollPane jScrollPane2 = new JScrollPane(seatsTbl);  	
		jScrollPane2.setSize(300, 100);
		jScrollPane2.setLocation(130, 150);
		add(jScrollPane2);   

		// MouseAdapter를 확장한 리스너 객체 생성하여 테이블 객체에 등록
		MouseListener listener = new MyMouseAdapter();
		personsTbl.addMouseListener(listener);  
		seatsTbl.addMouseListener(listener); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		setBounds(150, 150, 600, 350);      
		
		setVisible(true);    // 생성된 JFrame 객체를 화면에 나타나게 함
	}  

	// JTable의 특정 셀 클릭했을 때의 이벤트 처리를 위한 리스너 클래스
    //    MouseAdapter를 확장한 리스너 클래스 작성
	class MyMouseAdapter extends MouseAdapter {
		
		// 마우스 클릭하면 호출되는 이벤트 처리 메소드를 오버라이딩함    
		public void mouseClicked(java.awt.event.MouseEvent e) {
			JTable tbl = (JTable) e.getSource();  // e.getSource() 메소드는 선택된 테이블 객체 구함

			Point p = e.getPoint();               // 마우스가 클릭된 좌표 (x, y)를 전달받아 p에 저장

			int row = tbl.rowAtPoint(p);          // 테이블에서 p 위치의 행 번호를 구하여 row에 저장
			int col = tbl.columnAtPoint(p);       // 테이블에서 p 위치의 열 번호를 구하여 row에 저장

			Object obj = tbl.getValueAt(row, col);   // 테이블에서 (row, col)의 셀 값을 구하여 obj에 저장
			System.out.println("마우스 클릭된 위치: "  + p + ", 클릭된 위치의 데이터: " + obj);

			if (tbl==seatsTbl) {
				if (obj.equals("예약")) {         // 이미 예약된 좌석을 선택하면 오류 창 띄움
					JOptionPane.showMessageDialog(null, "선택되지 않은 좌석을 선택하십시오", 
							                "이미 선택된 좌석", JOptionPane.ERROR_MESSAGE);
					return;
				}

				tbl.setValueAt("예약", row, col); // 해당 좌석을 예약된 좌석으로 변경				
			}

			String tblName = (tbl == personsTbl ? "신상 테이블": "좌석 예약 테이블");

			// 선택된 셀의 객체를 컨솔과 창에 동시 출력
			System.out.println(tblName +"에서 선택된  (" + row + ", "+ col + ") 셀 : "  + obj);
			JOptionPane.showMessageDialog(null, 
				           	tblName + "의 (" + row + ", "+ col + ") 셀 : " + obj, 
				         	tblName + "에서의 선택", JOptionPane.INFORMATION_MESSAGE );
		}

		// 다른 이벤트 처리 메소드는 작성하지 않아도 됨
		//  이미 MouseAdapter 클래스에서 공백 메소드로 작성되었기 때문임
	}    
	
	public static void main(String[] args)    { 
		new Ex12_6_6_JFrameWithJTable("JTable 예제");  
	}	
} 

/*
 * [ 프로그램의 이해 및 실행 ]
 *   
 *   1) 2개의 테이블 객체를 디스플레이한다.
 *      - 신상 정보 테이블: 특정 셀을 클릭하면 그 셀의 행과 열 번호와 셀의 내용을 보여 줌
 *      - 영화 예약 정보 테이블: 특정 셀 클릭했을 때 예약 안된 셀이면 예약된 셀로 변경하고
 *        이미 예약된 셀이면 선택된 좌석임을 알림
 *        
 *      - 테이블의 객체 생성자, 메소드, 발생 가능한 이벤트와 리스너 객체 등록 방법 등을 이해할 것   
 *      - 특히, 2차원 배열을 테이블의 셀로 구성하는 방법을 확실히 이해할 것
 *     
 *   2) 테이블은 Mouse 이벤트를 발생시키므로 이들 위한 리스너 객체 등록이 가능하다.
 *      마우스 이벤트 처리 메소드에서 클릭된 셀의 행 번호와 열 번호를 구하는 방법을 확인하라. 
 *               
 *   3) 주어진 프로그램을 살펴보고 프로그램의 내용을 파악하라.  
 *   
 *   4) 프로그램을 수행하고 프로그램 결과를 확인하라.     
 */
