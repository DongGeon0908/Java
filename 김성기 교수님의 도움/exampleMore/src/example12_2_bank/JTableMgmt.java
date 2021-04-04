package example12_2_bank;

import java.awt.*;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.*;


/**
 * [ JTableMgmt ] : JTable의 생성과 패널에 컴포넌트 배치를 용이하게 하기 위한 클래스
 */

public class JTableMgmt {

	static int DEFALTCELLHEIGHT = 20;  // 테이블의 셀 높이 디폴트 값
	static int wDeltaForScrollPane = 3;
	static int hDeltaForScrollPane = 5;

	// title, attrnames, tuples가 주어지면 이를 panel에 배치
	static void  displayJTableToPanel(JFrame frame, JPanel panel, String title, String[] attrnames, Object[][] tuples) {
		JTable table = setupJTable(attrnames, tuples);
		
		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable 객체를 포함하는 JScrolPane 객체 구함

		PanelMgmt.displayComponents(frame, panel, title, sc);
	}

	// title, attrnames, tuples, alignments가 주어지면 이를 panel에 배치
	static void  displayJTableToPanel(JFrame frame, JPanel panel, String title, String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable table = setupJTable(attrnames, tuples, alignments);

		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable 객체를 포함하는 JScrolPane 객체 구함
		
		JComponent[][] comps = { { sc } };
		
		PanelMgmt.displayComponents(frame, panel, title, comps, null);
	}

	// title, table이 주어지면 이를 panel에 배치
	static void displayJTableToPanel(JFrame frame, JPanel panel, String  title, JTable table ) {		
			
		JScrollPane sc = getScrollPaneWithJTable(table);  	// JTable 객체를 포함하는 JScrolPane 객체 구함

		PanelMgmt.displayComponents(frame, panel, title, sc); 				
	}

	// 주어진 JTable 객체를 포함하는 JScrollPane 객체 생성하여 반환
	//    이때, JScrollPane 객체 크기는 JTable 객체 크기보다 (+3, +5) 해야 깔끔하게 출력됨
	static JScrollPane getScrollPaneWithJTable(JTable table) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  	// JTable이 JScrollPane에서 사이즈 변경되지 못하게 설정        

		JScrollPane sc = new JScrollPane(table);  			// JTable 객체를 JScrolPane 객체에 배치

		Dimension d = getJTableSizeForJScrollPane(table);

		int w = d.width;
		int h = d.height;

		sc.setPreferredSize(new Dimension(w, h));		
		sc.setSize(w, h);      

		return sc;
	}
	
	// 주어진 JTable 객체의 크기를 구하여 반환하는 메소드
	static Dimension getJTableSize(JTable table) {
		Dimension d = table.getPreferredSize();	// JTable의 크기는  getPreferredSize() 메소드로 구해야 함(?)
		int tableWidth = d.width; 					// 전체 테이블의 폭 구함
		
		int rowCount = table.getRowCount();        		// 테이블에 저장된 투플 개수 구함
		int tableHeight = (rowCount + 1) * table.getRowHeight(); //  전체 테이블 높이 구함(전체 높이 = 투플 개수 * 셀 높이 + 헤더 높
		
		return new Dimension(tableWidth, tableHeight); 
	}

	// 주어진 JTable 객체를 포함하는 JScrollPane 객체의 크기를 반환하는 메소드
	static Dimension getJTableSizeForJScrollPane(JTable table) {
		Dimension d = getJTableSize(table);
		
		return new Dimension(d.width + wDeltaForScrollPane, 
				d.height + hDeltaForScrollPane);   // JScrollPane 객체 크기 설정: (+3, +5) 하면 JScrollPane에 깔끔하게 표시됨
	}


	/*
	 * JTable의 각 애트리뷰트를 주어진 정렬방식으로 정렬하기 위한 부분	
	 */
	
	// 주어진 attrnames[] 배열과  tuples[][] 이차원 배열에 대해 JTable 객체를 생성하여 반환
	static JTable setupJTable(String[] attrnames, Object[][] tuples) {
		JTable table = new JTable(tuples, attrnames);   	// JTable 객체 생성 - tuples: 이차원 배열, attrnames: 1차원 배열 

		JTableHeader header = table.getTableHeader();		// 테이블의 헤더를 구함 	
		header.setBackground(Color.cyan);                   // 테이블의 헤더 색상 설정
		header.setFont(new Font("고딕체", Font.BOLD, header.getFont().getSize())); // 테이블의 헤더 텍스를 bold로 설정

		table.setBackground(Color.cyan);                  // 테이블의 배경 색상 설정
		table.setForeground(Color.black);                 // 테이블의 전경(글자) 색상 설정
		table.setRowHeight(DEFALTCELLHEIGHT);             // 테이블의 셀 높이 설정

		return table;
	}

	static DefaultTableCellRenderer dtcrLeft = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	static DefaultTableCellRenderer dtcrCenter = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	static DefaultTableCellRenderer dtcrRight = new DefaultTableCellRenderer(); // 디폴트 테이블 셀 렌더러 생성
	static {
		dtcrLeft.setHorizontalAlignment(SwingConstants.LEFT); // 렌더러의  수평 정렬을 LEFT로
		dtcrCenter.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 수평 정렬을 CENTER로
		dtcrRight.setHorizontalAlignment(SwingConstants.RIGHT); // 렌더러의 수평 정렬을 RIGHT로
	}

	static DefaultTableCellRenderer[] dtcrArray = { dtcrLeft, dtcrCenter, dtcrRight };

 	// attrnames, tuples. alignments가 주어지면 JTable 객체를 생성하여 반환하는 메소드	
	static  JTable setupJTable(String[] attrnames, Object[][] tuples, int[] alignments) {
		JTable table = setupJTable(attrnames, tuples);

		TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

		// 각각의 애트리뷰트(컬럼)에 대해 주어진 정렬방식(0: 왼쪽 정렬, 1: 중앙 정렬, 2: 오른쪽 정렬)을  지정
		// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여 주어진 정렬방식으로 설정
		for(int i = 0 ; i < tcm.getColumnCount() ; i++){   		
			// 각각의 셀 렌더러를 alignments[i]의 값에 따라 설정
			tcm.getColumn(i).setCellRenderer(dtcrArray[alignments[i]]);  
		}

		return table;		
	}
}
