package example12_2_bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

	/*
	 * 여러 컴포넌트가 주어지면 이를 컨테이너에 자동 배치하기 위한 필드들 선언
	 */

public class PanelMgmt {

	static int hGapMax = 20;
	static int vGapMax = 20;

	static int hGapMin = 3;
	static int vGapMin = 3;

	static int defaultWidth = 80;
	static int defaultHeight = 20;
	static int defaultFontSize = 12;

	static int defaultOkButtonWidth = 120;
	static int defaultOkButtonHeight = 25;
	static int defaultOkButtonFontSize = 13;

	static int defaultTitleWidth = 150;
	static int defaultTitleHeight = 35;
	static int defaultTitleFontSize = 16;

	static Container containerAdded;
	static Container containerOriginal;
	static int widthContainer;
	static int heightContainer;

	static JComponent titleToAdd;
	static int 	heightTitleToAdd;

	static JComponent[][] compsToAdd;

	static JButton okBtToAdd;
	static int 	heightOkBtToAdd;

	static int noRowsToAdd; 		// add할 컴포넌트들의 행 개수
	static int noRowsToAddPlusTitleOkBt;       // 타이틀과 okBt 포함 행 개수
	static int noColumnsToAdd;  	// add할 컴포넌트들의 열 개수
	static int sumRowHeights;    	// 한 행의 컴포넌트들의 너비의 합
	static int sumColumnWidths;   	// 한 열의 컴포넌트들의 높이의 합

	static int[][] columnWidthsToAdd; 	// 배치할 컴포넌트의 너비를 저장할 필드
	static int[][] rowHeightsToAdd; 	// 배치할 컴포넌트의 높이를 저장할 필드

	static int[] maxColumnWidths;    			// 각 열로 최대 너비를 저장하는 필드 
	static int[] maxRowHeights;   				// 각 행별로 최대 높이를 저장하는 필드

	static int hGapToAdd;  			// 컴포넌트 사이의 수평 여백 크기
	static int vGapToAdd;  			// 컴포넌트 사이의 수직 여백 크기
	static int noHgapsToAdd;         // 컴포넌트 사이의 수평 여백 개수
	static int noVgapsToAdd;        // 컴포넌트 사이의 수직 여백 개수


	static boolean hasScrollPaneToAdd;   // 배치할 컴포넌트 중  ScrollPane 유무 나타내는 필드: 컴포넌트 배치 여분이 부족시 ScrollPane 있으면 줄일 수 있도록 함
	static boolean hasScrollPaneReduced; // 배치할 컴포넌트 중  ScrollPane 크기 줄었는가 나타내는 필드: 컴포넌트 배치 여분이 부족시 ScrollPane 있으면 줄일 수 있도록 함
	static int noScrollPanesToAdd;    	// crollPane 개수 저장하는 필드
	static JScrollPane ScrollPaneToAdd;	// 배치할 컴포넌트 중  ScrollPane 저장하는 필드 
	static int rowNoScrollPaneToAdd;	// 배치할 컴포넌트 중  ScrollPane의 row 번호 
	static int columnNoScrollPaneToAdd;	// 배치할 컴포넌트 중  ScrollPane의 column 번호 

	static int initX; 		// 처음 배치할 x 위치
	static int initY;  		// 처음 배치할 y 위치

	static int scrollBarWidth = 18;
	static int scrollBarHeight = 18;

	static JComponent[][] emptyComps = {{}};
	

// displayComponents(JFrame frame, ): 주어진 컨테이너 cont에 타이틀, 컴포넌트 배열의 여러 컴포넌트들, 확인버튼을 배치
//    여러 컴포넌트는 한 줄에 noColumnsToAdd 개씩 배치됨
//    각 컴포넌트는 자동적으로  격자모양으로 일정한 위치에 배치됨 
static void displayComponents(JFrame frame, Container cont, Object title, JComponent[][] comps, JButton okBt) {	
			
		titleToAdd = null;
		okBtToAdd = null;

		noRowsToAdd = 0;
		noColumnsToAdd = 0;		

		containerOriginal = containerAdded = cont;
		widthContainer = containerAdded.getWidth();
		heightContainer = containerAdded.getHeight();

		// 컨솔 창에 패널의 기본정보 출력해봄(출력하지 않아도 무방한 부분임)
		
		compsToAdd = getExact2DimensionalComponents(comps); // 정방형 2차원 배열로 변환

		getColumnWidthsRowHeights(title, okBt); // 모든 컴포넌트의 너비와 높이 구함

		getMaxColumnWidthsRowHeights(); 	// 모든 컴포넌트의너비와 높이 구함

		getSumRowWidthsColumnHeights();  	// 행과 열에서의 최대 너비와 폭을 구함	

		containerAdded.setVisible(false);  // 기존에 배치되었던 모든 컴포넌트를 제거하기 위해 사라지게 함
		containerAdded.removeAll();        // 새로운 컴포넌트들을 배치하기 위해 기존에 배치되었던 모든 컴포넌트를 제거 

		secureGap();

		getInitXY();

		containerAdded.setLayout(null);

		int x = initX + hGapToAdd;
		int y = initY + vGapToAdd;

		// 타이틀 부분을 출력하기 위한 버튼의 배치
		if (titleToAdd != null) {
			containerAdded.add(titleToAdd);

			if (noRowsToAdd < 1)
				y = (heightContainer - getComponentHeight(titleToAdd)) / 2;

			titleToAdd.setLocation((widthContainer - titleToAdd.getWidth()) / 2, y);

			y += titleToAdd.getHeight() + vGapToAdd;

		}

		// 배치할 컴포넌트를 위치 계산하여 배치
		for (int i= 0; i < compsToAdd.length; i++) {	
			int noColumnsToAddInRow = compsToAdd[i].length;

			for (int j= 0; j < noColumnsToAddInRow; j++){


				// null이 아닌 컴포넌트 속성을 설정하고 p에 배치
				if (compsToAdd[i][j] != null) {
					if (compsToAdd[i][j] instanceof JTextField) { // JTextField 정렬: 숫자 - 오른쪽 정렬, 그외: 중앙 정렬
						JTextField tf = (JTextField) compsToAdd[i][j];
						try {	
							String text = tf.getText();
							double d = Double.parseDouble(text);
							tf.setHorizontalAlignment(JTextField.RIGHT);
						}
						catch(Exception e) {
							tf.setHorizontalAlignment(JTextField.LEFT);
						}
					}

					// 각 열에 대해 동일한 너비로 동일한 x 위치에 배치(단, ScrollPane은 setSize() 하지 않음: JTable이 포함되어 이상해짐)
					if (compsToAdd[i][j] instanceof JScrollPane) {
						if (maxColumnWidths[j] > columnWidthsToAdd[i][j]) {
							int vGapExtra = (maxColumnWidths[j] - columnWidthsToAdd[i][j] + 1) / 2;
							compsToAdd[i][j].setLocation(x + vGapExtra, y);

						}
						else {
							compsToAdd[i][j].setLocation(x, y);							
						}
					}
					else {
						compsToAdd[i][j].setSize(maxColumnWidths[j], maxRowHeights[i]);
						compsToAdd[i][j].setLocation(x, y);
					}

					containerAdded.add(compsToAdd[i][j]);
				}

				// 다음 컴포넌트 배치 위치 (x, y)를 계산
				if (j == (noColumnsToAddInRow - 1)) {  // 마지막 열에 배치한 경우 다음 위치는 첫번째 열에 배치함
					x = initX + hGapToAdd;
					y += maxRowHeights[i]+ vGapToAdd;

				} else {
					if (j == noColumnsToAdd - 1)
						y += maxRowHeights[i]+ vGapToAdd;

					x += maxColumnWidths[j] + hGapToAdd;
				}
			}
		}

		if (okBt != null){  // 확인버튼 배치
			containerAdded.add(okBt);
			okBt.setLocation((widthContainer - okBt.getWidth()) / 2, y);
		}

		containerOriginal.setVisible(true);  // 내부 패널이 생겼을 수 있으므로 containerOriginal을 보이게 해야 함
	}

	// 행마다 열의 개수가 일정하지 않을 수 있는 2차원 배열을 정방형 2차원 배열로 변환
	static JComponent[][] getExact2DimensionalComponents(JComponent[][] comps) {
		if (comps == null)
			return emptyComps;

		int noRows = comps.length;  //  add할 컴포넌트들의 행 개수를 결정함

		if (noRows <= 1)  // 행 개수가 1 이하면 자신을 반환
			return comps;

		int maxNoColumns = comps[0].length;
		int preNoColumns = comps[0].length;
		boolean isAllSameNoColumns = true;

		// 각 행의 열의 개수중 최대인 개수를 maxNoColumns에 구함
		for (int i=1; i < noRows; i++) {
			if (maxNoColumns < comps[i].length) 
				maxNoColumns = comps[i].length;

			if (preNoColumns != comps[i].length)
				isAllSameNoColumns = false;
		}

		if (isAllSameNoColumns) {
			return comps;
		}

		// 모든 행의 열 개수가 같지 않으면 열의 개수가 같은 정방형 2차원 배열로 변환하여 반환
		JComponent[][] exact2Dcomps = new JComponent[noRows][maxNoColumns];

		// comps 2차원 배열의 모든 원소를 exact2Dcomps 이차원 배열에 복사
		for (int i=0; i < noRows; i++)
			for (int j= 0; j < comps[i].length; j++){
				exact2Dcomps[i][j] = comps[i][j];

			}
		
		return exact2Dcomps;
	}
	
	// 정방형 2차원 배열의 컴포넌트들에 대해 너비와 높이를 구하여 저장하는 메소드
	//   수평 여백과 수직 여백을 결정하기 위한 준비 단계임
	static void getColumnWidthsRowHeights(Object title, JButton okBt) {

		if (compsToAdd == null || compsToAdd == emptyComps	) {
			noRowsToAdd = 0; 			 		// add할 컴포넌트들의 행 개수를 결정함
			noColumnsToAdd = 0; 
		}
		else {
			noRowsToAdd = compsToAdd.length;    // add할 컴포넌트들의 행 개수를 결정함
			noColumnsToAdd = compsToAdd[0].length; 
		}

		maxColumnWidths = new int[noColumnsToAdd + 1];
		maxRowHeights = new int[noRowsToAdd + 5]; // title과 OkBt 등을 행에 포함시키기 위해 주가함 

		columnWidthsToAdd = new int[noRowsToAdd + 1][noColumnsToAdd];
		rowHeightsToAdd = new int[noRowsToAdd + 5][noColumnsToAdd];

		hasScrollPaneToAdd = false;  
		noScrollPanesToAdd = 0;

		// 2차원 배열의 모든  컴포넌트들의 크기를 비교하여 각 행의 최대 높이와 각 열의 최대 너비를 구함
		for (int i= 0; i < compsToAdd.length; i++) {	
			int noColumns = compsToAdd[i].length;

			for (int j= 0; j < noColumns; j++){
				JComponent comp = compsToAdd[i][j];

				if (compsToAdd[i][j] == null)
					continue;

				comp.setFont(new Font("고딕체", Font.PLAIN, 12));

				// 컴포넌트의 너비와 높이를 결정
				columnWidthsToAdd[i][j] = getComponentWidth(comp);
				rowHeightsToAdd[i][j] = getComponentHeight(comp);

				if (comp instanceof JTable || comp  instanceof JTextArea || comp instanceof JLabel)
					compsToAdd[i][j] = comp = getJScrollPaneToAddComp(comp);

				if (comp instanceof JScrollPane) {
					hasScrollPaneToAdd = true;  // 컴포넌트 배치 여분이 부족시 ScrollPane 있으면 줄일 수 있도록 설정
					noScrollPanesToAdd++;  // ScrollPane 개수 1 증가

					if (noScrollPanesToAdd == 1) {
						ScrollPaneToAdd = (JScrollPane) comp;
						rowNoScrollPaneToAdd = i;		// 배치할 컴포넌트 중  ScrollPane의 row 번호  저장
						columnNoScrollPaneToAdd = j;	// 배치할 컴포넌트 중  ScrollPane의 column 번호저장
					}
					else {
						// JScrollPane 객체가  2개 이상이면 면적이 큰 JScrollPane 객체에 대해 여분 부족시 줄이도록 함
						JScrollPane thisJScrollPane = (JScrollPane) comp;
						int areaPrev = getAreaOfJScrollPaneByAddedComponent(ScrollPaneToAdd);
						int areaThis = getAreaOfJScrollPaneByAddedComponent(thisJScrollPane);
						
						if (areaThis > areaPrev) {
							ScrollPaneToAdd = thisJScrollPane;
							rowNoScrollPaneToAdd = i;		// 배치할 컴포넌트 중  ScrollPane의 row 번호  저장
							columnNoScrollPaneToAdd = j;	// 배치할 컴포넌트 중  ScrollPane의 column 번호저장
						}
					}
				}
					
			}
		}		

		setTitleComponent(title);
		setOkButton(okBt);  // 확인 버턴의 크기, 폰트 지정

		// 타이틀과 okBt은 높이에 영향을 주며 이로 인해 여백도 발생하므로 총 열 개수에 더해주어야 함
		noRowsToAddPlusTitleOkBt = noRowsToAdd;

		if (titleToAdd != null)
			noRowsToAddPlusTitleOkBt++;

		if (okBtToAdd != null)
			noRowsToAddPlusTitleOkBt++;

		noHgapsToAdd = noColumnsToAdd + 1;
		noVgapsToAdd = noRowsToAddPlusTitleOkBt + 1;
	}

	// JScrollPane에 배치될 수 잇는 컴포넌트인가를 확인하는 메소드
	static boolean isScrollableComponents(JComponent comp) {		
		if (comp instanceof JTable || comp  instanceof JTextArea)
			return true;
		
		if (comp instanceof JLabel)
			if (((JLabel) comp).getIcon() != null)
				return true;
				
		return false;
	}


	// JScrollPane에 배치된 컴포넌트를 구해 반환
	static JComponent getJScrollPaneToAddComp(JComponent comp) {
		if (comp instanceof JTable)
			return JTableMgmt.getScrollPaneWithJTable((JTable) comp);

		if (comp instanceof JTextArea)
			return JTextAreaMgmt.getScrollPaneWithJTextArea((JTextArea) comp);
		
		if (comp instanceof JLabel && ((JLabel) comp).getIcon() != null) {
			return JLabelMgmt.getScrollPaneWithJLabel((JPanel) containerAdded, (JLabel) comp);
		}
		
		return comp;
	}
	
	// JScrollPane의 영역 크기 구해 반환
	static int getAreaOfJScrollPaneByAddedComponent(JScrollPane sc) {
		Dimension d = getSizeOfJScrollPaneByAddedComponent(sc);
	
		return d.width * d.height;
	}
	
	// JScrollPane의 크기 구해 반환
	static Dimension getSizeOfJScrollPaneByAddedComponent(JScrollPane sc) {
		JViewport viewport = sc.getViewport(); 
		Component comp = viewport.getView(); 

		Dimension d;

		if (comp instanceof JTable) {

			d = JTableMgmt.getJTableSizeForJScrollPane((JTable) comp);

		}
		else if (comp instanceof JTextArea) {
			d = JTextAreaMgmt.getJTextAreaSizeForJScrollPane((JTextArea) comp);
		}	
		else if (comp instanceof JLabel)
			d = sc.getSize();  // 이미지 갖는 JLabel의 경우 크기를 현재의 JScrollPane 크기로 함(원래 이미지는 클 가능성이 많기 때문에) 
		else
			d = comp.getPreferredSize();

		return d;		
	}
	
	// 정방형 2차원 배열의 컴포넌트들에 대해 주어진 컴포넌트 중 row와 열 col에 대해 너비와 폭을 변경하는 메소드
	//    이 메소드는 ScrollPane의 크기가 변경되면 호출됨
	//    크기 변경된 ScrollPane 객체는 compsToAdd[row][col]에 저장되어 있음
	static void changeComponentWidthHeight(int w, int h, int row, int col) {
		columnWidthsToAdd[row][col] = w;
		rowHeightsToAdd[row][col] = h;

		getMaxColumnWidthsRowHeights();

		getSumRowWidthsColumnHeights();

		getGapHV();
	}

	// 정방형 2차원 배열의 컴포넌트들에 대해 열별 최대 너비와 행별 최대 높이를 구하여 
	//   배열 필드 maxColumnWidths[]와 maxRowHeights[]에 저장하는 메소드
	//   수평 여백과 수직 여백을 결정하기 위한 준비 단계임
	static void getMaxColumnWidthsRowHeights() {
		
		for (int i= 0; i < noRowsToAdd; i++)
			maxRowHeights[i] = 0;

		for (int j= 0; j < noColumnsToAdd; j++)
			maxColumnWidths[j] = 0; 

		// 2차원 배열의 모든  컴포넌트들의 크기를 비교하여 각 행의 최대 높이와 각 열의 최대 너비를 구함
		for (int i= 0; i < noRowsToAdd; i++) {	
			for (int j= 0; j < noColumnsToAdd; j++){

				if (compsToAdd[i][j] == null)
					continue;

				int w = columnWidthsToAdd[i][j];
				int h = rowHeightsToAdd[i][j];

				if (w > maxColumnWidths[j])
					maxColumnWidths[j] = w;  // 현재 컴포넌트의 너비가 지금까지의 최대 너비보다 크면 최대 너비 변경 

				if (h > maxRowHeights[i])
					maxRowHeights[i] = h; // 현재 컴포넌트의 높이가 지금까지의 최대 높이보다 크면 최대 높이 변경 
			}
		}
	}

	// 행과 열 중에서 가장 긴 길이의 행 너비와 열 높이를 구하는 메소드
	//    이 메소드는 전체 컴포넌트 배치에서 여백을 결정하기 위해 필요함
	static void getSumRowWidthsColumnHeights() {
		sumColumnWidths = 0;
		
		for (int i= 0; i<noColumnsToAdd; i++){
			sumColumnWidths += maxColumnWidths[i];
		}

		sumRowHeights = 0;
		for (int i= 0; i< noRowsToAdd; i++){
			sumRowHeights += maxRowHeights[i];
		}
		
		if (titleToAdd !=null) {
			sumRowHeights += getComponentHeight(titleToAdd);
		}
		
		if (okBtToAdd !=null) {
			sumRowHeights += getComponentHeight(okBtToAdd);;	
		}
	}

	// 타이틀에 대한 설정을 수행
	static void setTitleComponent(Object title) {
		if (title == null) 
			return;

		if (title != null) {
			if (title instanceof String) { //타이틀이 문자열로 주어진 경우 문자열을 갖는 버튼을 생성하여 타이틀로 배치
				titleToAdd = new JButton((String) title);

				titleToAdd.setFont(new Font("고딕체", Font.BOLD, defaultTitleFontSize));
			}
			else  { // 타이틀 컴포넌트가 문자열이 아닌 경우 주어진 컴포넌트를 타이틀로 배치
				titleToAdd = (JComponent) title;
			}

			int titleWidth = getComponentWidth(titleToAdd);
			int titleHeight = getComponentHeight(titleToAdd);

			titleToAdd.setSize(titleWidth, titleHeight);	
		}
	}

	// Ok 버튼에 대한 설정
	static void setOkButton(JButton okBt){
		if (okBt == null)
			return;

		okBtToAdd = okBt;

		okBt.setFont(new Font("고딕체", Font.ITALIC, defaultOkButtonFontSize));

		int okWidth = getComponentWidth(okBt);
		int okHeight = getComponentHeight(okBt);

		okBt.setSize(okWidth, okHeight);
	}

	// 주어진 패널 p에 타이틀, 1차원 배열의 여러 컴포넌트들, 확인버튼을 배치
	//    여러 컴포넌트는 한 줄에 noColumns 개씩 배치됨
	//    각 컴포넌트는 자동적으로  격자모양으로 일정한 위치에 배치됨 
	static void displayComponents(JFrame frame, Container  p, Object title, int noColumns, JComponent[] comps, JButton okBt) {

		// 1차원 컴포넌트 배열을 2차원 컴포넌트 배열로 변환
		JComponent[][] convertedComps = convert1DimTo2DimComponents(comps, noColumns);

		// p에 타이틀, 2차원 배열의 여러 컴포넌트들, 확인버튼을 배치
		displayComponents(frame,  p,  title, convertedComps, okBt);
	}

	// 1차원 배열에 저장된 컴포넌트들을 주어진 열의 개수에 맞추어 2차원 배열에 저장
	static JComponent[][] convert1DimTo2DimComponents(JComponent[] comps, int noColumns) {
		int noComps = comps.length;   //  add할 컴포넌트 개수를 구함
		int noRows = (noComps + noColumns - 1) / noColumns;  //  add할 컴포넌트들의 행 개수를 결정함

		JComponent[][] convertedComps = new JComponent[noRows][noColumns];  // 저장할 2차원 배열 생성

		int no = 0;
		for (int i=0; i < noRows; i++)
			for (int j=0; j<noColumns; j++) {
				convertedComps[i][j] = comps[no++];

				if (no >= noComps)
					break;
			}

		return convertedComps;		
	}

	// 여백이 보장되는가를 확인하여 여백이 모자라면 JScrollPane을 이용하여 패널을 확장시킴
	static void secureGap() {

		// hGapToAdd, vGapToAdd 등을 계산
		getGapHV();

		// 여백이 최소 여백보다 작으면 스크롤 패인 이용하여 최소 여백을 확보함
		if (vGapToAdd  < vGapMin || hGapToAdd < hGapMin) {
			createScrollBar();
		}
	}

	// 더 큰 패널을 생성하여 컴포넌트를 배치하고 패널을 JScrollPane에 배치하는 메소드
	static void createScrollBar() {		
		boolean reduced = false;

		// 컴포넌트 중 JScrollPane 있으면 JScrollPane 크기 줄여 여백 확보
		if (hasScrollPaneToAdd)
			reduced = reduceScrollPaneToAdd();

		// 그래도 여백 없으면 내부 스크롤바 가진 내부 패널 생성하여 컴포넌트들 배치
		if (vGapToAdd  < vGapMin || hGapToAdd < hGapMin) 
			createScrollPaneToAddContainer();
	}

	// 수평, 수직 여백을 구함
	static void getGapHV() {
		// 행과 열 최대 길이를 이용하여 수평 및 수직 여백 계산
		vGapToAdd = (heightContainer - sumRowHeights) / (noRowsToAddPlusTitleOkBt + 1);
		hGapToAdd = (widthContainer - sumColumnWidths) / (noColumnsToAdd + 1);
	}

	// 처음 배치할 컴포넌트의 좌표를 결정하는 메소드
	//   컴포넌트 길이와 정상 여백을 제하고 남은 길이의 절반을 초기 위치로 결정
	static void getInitXY() {		
		if (hGapToAdd > hGapMax){	// 수평 여백이 최소 여백보다 작으면 최소 여백으로
			hGapToAdd = hGapMax;
		}

		if (vGapToAdd > vGapMax){	// 수직 여백이 최소 여백보다 작으면 최소 여백으로
			vGapToAdd = vGapMax;
		}

		// 전체 컴포넌트 길이와 정상 여백 길이에서 남는 길이는 앞 뒤, 또는 아래 위의 여백으로 배정
		int sumColumnsHgaps = sumColumnWidths + hGapToAdd * noHgapsToAdd;
		int sumRowsVgaps = sumRowHeights + vGapToAdd * noVgapsToAdd;

		initX = (widthContainer - (sumColumnsHgaps + 1)) / 2 + (widthContainer - sumColumnsHgaps) % noHgapsToAdd / 2;
		initY = (heightContainer - (sumRowsVgaps + 1)) / 2 + (heightContainer - sumRowsVgaps) % noVgapsToAdd / 2;

		if (initX < 0)
			initX = 0;

		if (initY < 0)
			initY = 0;	
	}

	// 줄여야 할 크기(너비와 높이) 저장하는 변수들
	static int widthToReduce = 0;
	static int heightToReduce = 0;	
	static boolean sizeChanged = false;

	// 컨테이너에 컴포넌트 배치할 공간 부족하면 컴포넌트 중 ScrollPane이 있으면
	//    ScrollPane의 크기를 줄여 여백을 확보하는 메소드
	//    이 메소드는 컴포넌트 사이의 여백이 최소 여백보다 작으면 호출됨
	static boolean reduceScrollPaneToAdd() {

		//ScrollPane이 포함된 행과 열에서 가장 큰 컴포넌트인지 확인
		hasScrollPaneReduced = false;

		int widthPrev, width;
		int heightPrev, height;

		int rowNo = rowNoScrollPaneToAdd; 
		int colNo = columnNoScrollPaneToAdd;

		widthPrev = width = columnWidthsToAdd[rowNo][colNo];
		heightPrev = height = rowHeightsToAdd[rowNo][colNo];

		getSizeToReduce();

		if (sizeChanged == false) {
			return false;
		}
		else {

		}
		// 줄인  ScrollPane 크기를 계산
		int widthReduced = width - widthToReduce;
		int heightReduced = height - heightToReduce;

		if (widthReduced < defaultWidth * 1.5)    // 축소된 후 너비가 너무 작으면 ScrollPane을 축소하지 않음
			return false;

		if (heightReduced < defaultHeight * 2.5)  // 축소된 후 높이가 너무 작으면 ScrollPane을 축소하지 않음(테이블의 경우 [헤더, row 하나, 스크롤바] 높이 필요)
			return false;

		changeComponentWidthHeight(widthReduced, heightReduced, rowNo, colNo);

		hasScrollPaneReduced = true;
		
		// 줄인 ScrollPane의 크기로 ScrollPane 크기 설정
		ScrollPaneToAdd.setPreferredSize(new Dimension(widthReduced, heightReduced));	
		ScrollPaneToAdd.setSize(widthReduced, heightReduced);

		return true;
	}

	// 여백 확보하기 위해 줄여야할 JScrollPane 크기를 결정하는 메소드
	static void getSizeToReduce() {
		int width = columnWidthsToAdd[rowNoScrollPaneToAdd][columnNoScrollPaneToAdd];
		int height = rowHeightsToAdd[rowNoScrollPaneToAdd][columnNoScrollPaneToAdd];

		sizeChanged = false;
		
		// 수평 여백과 수직 여백 모두 부족하면 수평과 수직에 모두 스크롤바 생김 고려하여 줄일 사이즈 결정
		if (width == maxColumnWidths[columnNoScrollPaneToAdd] && hGapToAdd < hGapMin
				&& height == maxRowHeights[rowNoScrollPaneToAdd] && vGapToAdd < vGapMin) {

			// 줄여할 크기(또는 확보해야할 여백 크기) 계산
			widthToReduce = (hGapMin - hGapToAdd) * (noHgapsToAdd) + scrollBarWidth ;
			heightToReduce = (vGapMin - vGapToAdd) * (noVgapsToAdd) + scrollBarHeight;

			// 이 줄임이 다른 컴포넌트 너비 또는 높이 보다 커야 유효한 줄임이 됨			
			if (isSecondRankOfColumnWidths(width-widthToReduce, columnNoScrollPaneToAdd) ||
					isSecondRankOfRowHeights(height - heightToReduce, rowNoScrollPaneToAdd))
				sizeChanged = true;
		}
		// 수평 여백이 부족하면 수직 스크롤바 생김 고려하여 줄일 사이즈 결정
		else if (width == maxColumnWidths[columnNoScrollPaneToAdd] && hGapToAdd < hGapMin) {
			// 줄여할 크기(또는 확보해야할 여백 크기) 계산
			widthToReduce = (hGapMin - hGapToAdd) * (noColumnsToAdd + 1) + noColumnsToAdd;
			heightToReduce = -scrollBarHeight; // ;  // 수평 스크롤바 생기므로 높이 늘어 여백 줄어듬

			// 이 줄임이 다른 컴포넌트 너비보다 커야 유효한 줄임이 됨
			if (isSecondRankOfColumnWidths(width-widthToReduce, columnNoScrollPaneToAdd))
				sizeChanged = true;
		}		
		// 수직 여백이 부족하면 수평  스크롤바 생김 고려하여 줄일 사이즈 결정
		else if (height == maxRowHeights[rowNoScrollPaneToAdd] && vGapToAdd < vGapMin) {
			widthToReduce = -scrollBarWidth;
			heightToReduce = (vGapMin - vGapToAdd) * (noVgapsToAdd) + (noVgapsToAdd - 1);

			// 이 줄임이 다른 컴포넌트 높이보다 커야 유효한 줄임이 됨
			if (isSecondRankOfRowHeights(height - heightToReduce, rowNoScrollPaneToAdd)) 
				sizeChanged = true;		
		}
	}

	// 줄인 결과가 2번째 큰 컴포넌트보다 큰 가를 확하는 메소드
	static boolean isSecondRankOfRowHeights(int h, int row) {
		int rank = 1;
		for (int i= 0; i < noColumnsToAdd; i++)
			if (rowHeightsToAdd[row][i] > h)
				rank++;

		if (rank <= 2)
			return true;
		else
			return false;
	}

	// 줄인 결과가 2번째 큰 컴포넌트보다 큰 가를 확하는 메소드
	static boolean isSecondRankOfColumnWidths(int w, int col) {
		int rank = 1;

		for (int i= 0; i < noRowsToAdd; i++) {
			if (columnWidthsToAdd[i][col] > w)
				rank++;
		}
		if (rank <= 2)
			return true;
		else
			return false;
	}

	// 컨테이너에 컴포넌트 배치할 공간 부족하면 ScrollPane에 새로운 내부 패널을 넣고
	//    내부 패널에 배치하도록 하는 메소드
	//    이 메소드는 컴포넌트 사이의 여백이 최소 여백보다 작으면 호출됨
	static void createScrollPaneToAddContainer() {
		if (hGapToAdd >= hGapMin && vGapToAdd >= vGapMin ) 
			return;
		
		JPanel innerP = createCopyJPanel(containerAdded); // 배치할 내부 패널 생성 및 속성을 기존 컨테이너와 동일하게 함

		// ScrollPane의 크기 준 것이 있으면 원래 크기대로 회복시킴
		restoreSizeScrollPaneToAdd();
		
		// 내부 패널의 너비와 높이 결정
		//   컴포넌트 사이의 여백이 최소 여백만큼 될 수 있도록 너비와 폭을 설정 
		//   -scrollBarWidth 또는 - scrollBarHeight는 불필요한 스크롤바 생성 방지하기 위해 필요함(그 이유는 정확히 파악안됨)

		int widthInnerP = widthContainer;
		int heightInnerP = heightContainer;

		if (hGapToAdd < hGapMin && vGapToAdd < vGapMin ) {
			widthInnerP = sumColumnWidths + hGapMin * (noHgapsToAdd) + scrollBarWidth; 
			heightInnerP = sumRowHeights + vGapMin * (noVgapsToAdd) + scrollBarHeight;       	

			sizeChanged = true;
		}
		else if (hGapToAdd < hGapMin) {	
			widthInnerP = sumColumnWidths + hGapMin * (noHgapsToAdd); 
			heightInnerP = heightContainer   - scrollBarHeight;       		
		}
		else if (vGapToAdd < vGapMin) {	
			widthInnerP = widthContainer - scrollBarWidth;
			heightInnerP = sumRowHeights + vGapMin * (noVgapsToAdd);
		}

		innerP.setPreferredSize(new Dimension(widthInnerP, heightInnerP));		
		innerP.setSize(widthInnerP, heightInnerP);

		JScrollPane scp = new JScrollPane(innerP);      // 내부 패널을 스크롤패인에 배치
		scp.setSize(widthContainer, heightContainer);   // 스크롤패인 크기 설정

		containerAdded.add(scp);        // 스크롤패인을 외부 패널에 배치
		containerAdded = innerP;           // 내부 패널을 컴포넌트들 배치할 컨테이너로 변경하여

		do {
			widthContainer = widthInnerP;      //   너비와 높이를 컨테이너의 너비와 높이로 저장
			heightContainer = heightInnerP;	

			// 컴포넌트의 행들의 너비와 행들의 높이 전체 길이 조정
			getSumRowWidthsColumnHeights();

			// 처음 배치할 수평 여백과 수직 여백 크기 결정
			getGapHV();

			// 수평 여백과 수직 여백이 부족하면 내부 패널의 크기를 늘림
			if (hGapToAdd < hGapMin || vGapToAdd < vGapMin) {
				Dimension d = increaseInnerPanel(innerP);
				widthInnerP = d.width;;    
				heightInnerP = d.height;	
			}
		}
		while(hGapToAdd < hGapMin || vGapToAdd < vGapMin);
	}


	// 내부 패널의 크기를 여백이 충분하도록 늘이는 메소드
	static Dimension increaseInnerPanel(JPanel innerP) {
		Dimension d = innerP.getSize();
		int w = d.width;
		int h = d.height;

		int wInc = w;
		int hInc = h;

		if (hGapToAdd < hGapMin) 
			wInc += (hGapMin - hGapToAdd) * (noHgapsToAdd);

		if (vGapToAdd < vGapMin)
			hInc += (vGapMin - vGapToAdd) * (noVgapsToAdd);

		d = new Dimension(wInc, hInc);

		innerP.setPreferredSize(d);		
		innerP.setSize(d);
		
		return d;
	}

	// 원래의 크기로 다시 회복시키는 메소드
	static void restoreSizeScrollPaneToAdd() {
		if (hasScrollPaneToAdd == false  
				||	hasScrollPaneReduced == false)
			return;
		
		Dimension d = getSizeOfJScrollPaneByAddedComponent(ScrollPaneToAdd);
		
		int w = d.width;
		int h = d.height;
		ScrollPaneToAdd.setSize(w, h);
		
		changeComponentWidthHeight(w, h, rowNoScrollPaneToAdd, columnNoScrollPaneToAdd);		
	}

	// 주어진 컨테이너와 동일한 조건의 JPanel 객체를 생성하여 반환하는 메소드
	static JPanel createCopyJPanel(Container cont) {
		JPanel p = new JPanel();

		p.setBackground(cont.getBackground());
		p.setBounds(cont.getBounds());	
		p.setLayout(cont.getLayout());

		return p;
	}

	// 컴포넌트의 너비와 높이를 결정하는 메소드
	//   이미 설정된 경우 그대로 이용하고
	//   별도로 설정되지 않았으면 getPreferredSize() 메소드 이용하여 주어지는 이상적인 너비와 높이 활용 
	// 주어진 컴포넌트의 너비 반환
	static int getComponentWidth(JComponent comp) {
		if (comp == null)
			return 0;

		int w = comp.getWidth();

		if (w != 0)
			return w;
		else {
			w = comp.getPreferredSize().width;

			if (w != 0)
				return w;

			return defaultWidth;
		}		
	}

	// 주어진 컴포넌트의 높이 반환
	static int getComponentHeight(JComponent comp){
		if (comp == null)
			return 0;

		if (comp instanceof JTable) { 
			// 전체 테이블의 폭 구함
			int rowCount = ((JTable) comp).getRowCount();        				// 테이블에 저장된 투플 개수 구함
			int jTableHeight = (rowCount + 1) * ((JTable) comp).getRowHeight(); //  전체 테이블 높이 구함(전체 높이 = 투플 개수 * 셀 높이 + 헤더 높이)

			return jTableHeight;
		}
		
		int h = comp.getHeight();

		if (h != 0)
			return h;
		else {
			h = comp.getPreferredSize().height;

			if (h != 0)
				return h;

			return defaultHeight;
		}

	}
	
	/*
	 *  다음의  메소드들은 displayComponents(JFrame frame, ) 메소드를 간단하게 호출하기 위한 메소드들임
	 */


	// 하나의 컴포넌트만 배치
	static void displayComponents(JFrame frame, Container  p, Object comp) {
		displayComponents(frame, p, comp, null, null);
	}

	// 컴포넌트들만 배치
	static void displayComponents(JFrame frame, Container  p, JComponent[][] comps) {
		displayComponents(frame, p, null, comps, null);
	}

	// 타이틀과 하나의 컴포넌트만 배치
	static void displayComponents(JFrame frame, Container  p, Object title, JComponent comp) {
		JComponent[][] comps = { { comp } };
		displayComponents(frame, p, title, comps, null);
	}

	// 타이틀 없이 하나의 컴포넌트와 확인버튼 배치
	static void displayComponents(JFrame frame, Container  p, JComponent comp, JButton okBt) {
		JComponent[][] comps = { { comp } };
		displayComponents(frame, p, null, comps, okBt);
	}

	// 타이틀 없이 2개의  컴포넌트와 확인버튼 수직으로 배치
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JButton okBt) {
		JComponent[][] comps = { { comp1 }, { comp2} };

		displayComponents(frame, p, null,  comps, okBt);
	}

	// 타이틀 없이 6개의 컴포넌트 수직으로 배치
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JComponent comp3,
			JComponent comp4, JComponent comp5, JComponent comp6) {
		JComponent[][] comps = { { comp1 }, { comp2 }, { comp3 }, { comp4 }, { comp5 }, { comp6 } };

		displayComponents(frame, p, null, comps, null);
	}

	// 타이틀 없이 7개의  컴포넌트 수직으로 배치
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JComponent comp3,
			JComponent comp4, JComponent comp5, JComponent comp6, JComponent comp7) {
		JComponent[] comps = { comp1, comp2, comp3, comp4, comp5, comp6, comp7  };

		displayComponents(frame, p, null, 1, comps, null);
	}

	// 문자열 타이틀과 1차원 문자열 배열을  컴포넌트로 변경하여 배치
	static void displayTableComponents(JFrame frame, Container p, String title, int noColumns, String[] ss) {

		int n = ss.length;   //  add할 컴포넌트 개수

		JComponent[] comps = new JComponent[n];

		for (int i= 0; i<n; i++) {

			if (i < noColumns) {
				comps[i] = new JLabel(ss[i]);

				comps[i].setFont(new Font("고딕체", Font.BOLD, 12));
			}
			else {
				comps[i] = new JTextField(ss[i]);

				comps[i].setFont(new Font("고딕체", Font.PLAIN, 12));
			}

		}

		displayComponents(frame, p, title, noColumns, comps, null);
	}
}
