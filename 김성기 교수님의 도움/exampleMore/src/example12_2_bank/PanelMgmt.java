package example12_2_bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

	/*
	 * ���� ������Ʈ�� �־����� �̸� �����̳ʿ� �ڵ� ��ġ�ϱ� ���� �ʵ�� ����
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

	static int noRowsToAdd; 		// add�� ������Ʈ���� �� ����
	static int noRowsToAddPlusTitleOkBt;       // Ÿ��Ʋ�� okBt ���� �� ����
	static int noColumnsToAdd;  	// add�� ������Ʈ���� �� ����
	static int sumRowHeights;    	// �� ���� ������Ʈ���� �ʺ��� ��
	static int sumColumnWidths;   	// �� ���� ������Ʈ���� ������ ��

	static int[][] columnWidthsToAdd; 	// ��ġ�� ������Ʈ�� �ʺ� ������ �ʵ�
	static int[][] rowHeightsToAdd; 	// ��ġ�� ������Ʈ�� ���̸� ������ �ʵ�

	static int[] maxColumnWidths;    			// �� ���� �ִ� �ʺ� �����ϴ� �ʵ� 
	static int[] maxRowHeights;   				// �� �ະ�� �ִ� ���̸� �����ϴ� �ʵ�

	static int hGapToAdd;  			// ������Ʈ ������ ���� ���� ũ��
	static int vGapToAdd;  			// ������Ʈ ������ ���� ���� ũ��
	static int noHgapsToAdd;         // ������Ʈ ������ ���� ���� ����
	static int noVgapsToAdd;        // ������Ʈ ������ ���� ���� ����


	static boolean hasScrollPaneToAdd;   // ��ġ�� ������Ʈ ��  ScrollPane ���� ��Ÿ���� �ʵ�: ������Ʈ ��ġ ������ ������ ScrollPane ������ ���� �� �ֵ��� ��
	static boolean hasScrollPaneReduced; // ��ġ�� ������Ʈ ��  ScrollPane ũ�� �پ��°� ��Ÿ���� �ʵ�: ������Ʈ ��ġ ������ ������ ScrollPane ������ ���� �� �ֵ��� ��
	static int noScrollPanesToAdd;    	// crollPane ���� �����ϴ� �ʵ�
	static JScrollPane ScrollPaneToAdd;	// ��ġ�� ������Ʈ ��  ScrollPane �����ϴ� �ʵ� 
	static int rowNoScrollPaneToAdd;	// ��ġ�� ������Ʈ ��  ScrollPane�� row ��ȣ 
	static int columnNoScrollPaneToAdd;	// ��ġ�� ������Ʈ ��  ScrollPane�� column ��ȣ 

	static int initX; 		// ó�� ��ġ�� x ��ġ
	static int initY;  		// ó�� ��ġ�� y ��ġ

	static int scrollBarWidth = 18;
	static int scrollBarHeight = 18;

	static JComponent[][] emptyComps = {{}};
	

// displayComponents(JFrame frame, ): �־��� �����̳� cont�� Ÿ��Ʋ, ������Ʈ �迭�� ���� ������Ʈ��, Ȯ�ι�ư�� ��ġ
//    ���� ������Ʈ�� �� �ٿ� noColumnsToAdd ���� ��ġ��
//    �� ������Ʈ�� �ڵ�������  ���ڸ������ ������ ��ġ�� ��ġ�� 
static void displayComponents(JFrame frame, Container cont, Object title, JComponent[][] comps, JButton okBt) {	
			
		titleToAdd = null;
		okBtToAdd = null;

		noRowsToAdd = 0;
		noColumnsToAdd = 0;		

		containerOriginal = containerAdded = cont;
		widthContainer = containerAdded.getWidth();
		heightContainer = containerAdded.getHeight();

		// ���� â�� �г��� �⺻���� ����غ�(������� �ʾƵ� ������ �κ���)
		
		compsToAdd = getExact2DimensionalComponents(comps); // ������ 2���� �迭�� ��ȯ

		getColumnWidthsRowHeights(title, okBt); // ��� ������Ʈ�� �ʺ�� ���� ����

		getMaxColumnWidthsRowHeights(); 	// ��� ������Ʈ�ǳʺ�� ���� ����

		getSumRowWidthsColumnHeights();  	// ��� �������� �ִ� �ʺ�� ���� ����	

		containerAdded.setVisible(false);  // ������ ��ġ�Ǿ��� ��� ������Ʈ�� �����ϱ� ���� ������� ��
		containerAdded.removeAll();        // ���ο� ������Ʈ���� ��ġ�ϱ� ���� ������ ��ġ�Ǿ��� ��� ������Ʈ�� ���� 

		secureGap();

		getInitXY();

		containerAdded.setLayout(null);

		int x = initX + hGapToAdd;
		int y = initY + vGapToAdd;

		// Ÿ��Ʋ �κ��� ����ϱ� ���� ��ư�� ��ġ
		if (titleToAdd != null) {
			containerAdded.add(titleToAdd);

			if (noRowsToAdd < 1)
				y = (heightContainer - getComponentHeight(titleToAdd)) / 2;

			titleToAdd.setLocation((widthContainer - titleToAdd.getWidth()) / 2, y);

			y += titleToAdd.getHeight() + vGapToAdd;

		}

		// ��ġ�� ������Ʈ�� ��ġ ����Ͽ� ��ġ
		for (int i= 0; i < compsToAdd.length; i++) {	
			int noColumnsToAddInRow = compsToAdd[i].length;

			for (int j= 0; j < noColumnsToAddInRow; j++){


				// null�� �ƴ� ������Ʈ �Ӽ��� �����ϰ� p�� ��ġ
				if (compsToAdd[i][j] != null) {
					if (compsToAdd[i][j] instanceof JTextField) { // JTextField ����: ���� - ������ ����, �׿�: �߾� ����
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

					// �� ���� ���� ������ �ʺ�� ������ x ��ġ�� ��ġ(��, ScrollPane�� setSize() ���� ����: JTable�� ���ԵǾ� �̻�����)
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

				// ���� ������Ʈ ��ġ ��ġ (x, y)�� ���
				if (j == (noColumnsToAddInRow - 1)) {  // ������ ���� ��ġ�� ��� ���� ��ġ�� ù��° ���� ��ġ��
					x = initX + hGapToAdd;
					y += maxRowHeights[i]+ vGapToAdd;

				} else {
					if (j == noColumnsToAdd - 1)
						y += maxRowHeights[i]+ vGapToAdd;

					x += maxColumnWidths[j] + hGapToAdd;
				}
			}
		}

		if (okBt != null){  // Ȯ�ι�ư ��ġ
			containerAdded.add(okBt);
			okBt.setLocation((widthContainer - okBt.getWidth()) / 2, y);
		}

		containerOriginal.setVisible(true);  // ���� �г��� ������ �� �����Ƿ� containerOriginal�� ���̰� �ؾ� ��
	}

	// �ึ�� ���� ������ �������� ���� �� �ִ� 2���� �迭�� ������ 2���� �迭�� ��ȯ
	static JComponent[][] getExact2DimensionalComponents(JComponent[][] comps) {
		if (comps == null)
			return emptyComps;

		int noRows = comps.length;  //  add�� ������Ʈ���� �� ������ ������

		if (noRows <= 1)  // �� ������ 1 ���ϸ� �ڽ��� ��ȯ
			return comps;

		int maxNoColumns = comps[0].length;
		int preNoColumns = comps[0].length;
		boolean isAllSameNoColumns = true;

		// �� ���� ���� ������ �ִ��� ������ maxNoColumns�� ����
		for (int i=1; i < noRows; i++) {
			if (maxNoColumns < comps[i].length) 
				maxNoColumns = comps[i].length;

			if (preNoColumns != comps[i].length)
				isAllSameNoColumns = false;
		}

		if (isAllSameNoColumns) {
			return comps;
		}

		// ��� ���� �� ������ ���� ������ ���� ������ ���� ������ 2���� �迭�� ��ȯ�Ͽ� ��ȯ
		JComponent[][] exact2Dcomps = new JComponent[noRows][maxNoColumns];

		// comps 2���� �迭�� ��� ���Ҹ� exact2Dcomps ������ �迭�� ����
		for (int i=0; i < noRows; i++)
			for (int j= 0; j < comps[i].length; j++){
				exact2Dcomps[i][j] = comps[i][j];

			}
		
		return exact2Dcomps;
	}
	
	// ������ 2���� �迭�� ������Ʈ�鿡 ���� �ʺ�� ���̸� ���Ͽ� �����ϴ� �޼ҵ�
	//   ���� ����� ���� ������ �����ϱ� ���� �غ� �ܰ���
	static void getColumnWidthsRowHeights(Object title, JButton okBt) {

		if (compsToAdd == null || compsToAdd == emptyComps	) {
			noRowsToAdd = 0; 			 		// add�� ������Ʈ���� �� ������ ������
			noColumnsToAdd = 0; 
		}
		else {
			noRowsToAdd = compsToAdd.length;    // add�� ������Ʈ���� �� ������ ������
			noColumnsToAdd = compsToAdd[0].length; 
		}

		maxColumnWidths = new int[noColumnsToAdd + 1];
		maxRowHeights = new int[noRowsToAdd + 5]; // title�� OkBt ���� �࿡ ���Խ�Ű�� ���� �ְ��� 

		columnWidthsToAdd = new int[noRowsToAdd + 1][noColumnsToAdd];
		rowHeightsToAdd = new int[noRowsToAdd + 5][noColumnsToAdd];

		hasScrollPaneToAdd = false;  
		noScrollPanesToAdd = 0;

		// 2���� �迭�� ���  ������Ʈ���� ũ�⸦ ���Ͽ� �� ���� �ִ� ���̿� �� ���� �ִ� �ʺ� ����
		for (int i= 0; i < compsToAdd.length; i++) {	
			int noColumns = compsToAdd[i].length;

			for (int j= 0; j < noColumns; j++){
				JComponent comp = compsToAdd[i][j];

				if (compsToAdd[i][j] == null)
					continue;

				comp.setFont(new Font("���ü", Font.PLAIN, 12));

				// ������Ʈ�� �ʺ�� ���̸� ����
				columnWidthsToAdd[i][j] = getComponentWidth(comp);
				rowHeightsToAdd[i][j] = getComponentHeight(comp);

				if (comp instanceof JTable || comp  instanceof JTextArea || comp instanceof JLabel)
					compsToAdd[i][j] = comp = getJScrollPaneToAddComp(comp);

				if (comp instanceof JScrollPane) {
					hasScrollPaneToAdd = true;  // ������Ʈ ��ġ ������ ������ ScrollPane ������ ���� �� �ֵ��� ����
					noScrollPanesToAdd++;  // ScrollPane ���� 1 ����

					if (noScrollPanesToAdd == 1) {
						ScrollPaneToAdd = (JScrollPane) comp;
						rowNoScrollPaneToAdd = i;		// ��ġ�� ������Ʈ ��  ScrollPane�� row ��ȣ  ����
						columnNoScrollPaneToAdd = j;	// ��ġ�� ������Ʈ ��  ScrollPane�� column ��ȣ����
					}
					else {
						// JScrollPane ��ü��  2�� �̻��̸� ������ ū JScrollPane ��ü�� ���� ���� ������ ���̵��� ��
						JScrollPane thisJScrollPane = (JScrollPane) comp;
						int areaPrev = getAreaOfJScrollPaneByAddedComponent(ScrollPaneToAdd);
						int areaThis = getAreaOfJScrollPaneByAddedComponent(thisJScrollPane);
						
						if (areaThis > areaPrev) {
							ScrollPaneToAdd = thisJScrollPane;
							rowNoScrollPaneToAdd = i;		// ��ġ�� ������Ʈ ��  ScrollPane�� row ��ȣ  ����
							columnNoScrollPaneToAdd = j;	// ��ġ�� ������Ʈ ��  ScrollPane�� column ��ȣ����
						}
					}
				}
					
			}
		}		

		setTitleComponent(title);
		setOkButton(okBt);  // Ȯ�� ������ ũ��, ��Ʈ ����

		// Ÿ��Ʋ�� okBt�� ���̿� ������ �ָ� �̷� ���� ���鵵 �߻��ϹǷ� �� �� ������ �����־�� ��
		noRowsToAddPlusTitleOkBt = noRowsToAdd;

		if (titleToAdd != null)
			noRowsToAddPlusTitleOkBt++;

		if (okBtToAdd != null)
			noRowsToAddPlusTitleOkBt++;

		noHgapsToAdd = noColumnsToAdd + 1;
		noVgapsToAdd = noRowsToAddPlusTitleOkBt + 1;
	}

	// JScrollPane�� ��ġ�� �� �մ� ������Ʈ�ΰ��� Ȯ���ϴ� �޼ҵ�
	static boolean isScrollableComponents(JComponent comp) {		
		if (comp instanceof JTable || comp  instanceof JTextArea)
			return true;
		
		if (comp instanceof JLabel)
			if (((JLabel) comp).getIcon() != null)
				return true;
				
		return false;
	}


	// JScrollPane�� ��ġ�� ������Ʈ�� ���� ��ȯ
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
	
	// JScrollPane�� ���� ũ�� ���� ��ȯ
	static int getAreaOfJScrollPaneByAddedComponent(JScrollPane sc) {
		Dimension d = getSizeOfJScrollPaneByAddedComponent(sc);
	
		return d.width * d.height;
	}
	
	// JScrollPane�� ũ�� ���� ��ȯ
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
			d = sc.getSize();  // �̹��� ���� JLabel�� ��� ũ�⸦ ������ JScrollPane ũ��� ��(���� �̹����� Ŭ ���ɼ��� ���� ������) 
		else
			d = comp.getPreferredSize();

		return d;		
	}
	
	// ������ 2���� �迭�� ������Ʈ�鿡 ���� �־��� ������Ʈ �� row�� �� col�� ���� �ʺ�� ���� �����ϴ� �޼ҵ�
	//    �� �޼ҵ�� ScrollPane�� ũ�Ⱑ ����Ǹ� ȣ���
	//    ũ�� ����� ScrollPane ��ü�� compsToAdd[row][col]�� ����Ǿ� ����
	static void changeComponentWidthHeight(int w, int h, int row, int col) {
		columnWidthsToAdd[row][col] = w;
		rowHeightsToAdd[row][col] = h;

		getMaxColumnWidthsRowHeights();

		getSumRowWidthsColumnHeights();

		getGapHV();
	}

	// ������ 2���� �迭�� ������Ʈ�鿡 ���� ���� �ִ� �ʺ�� �ະ �ִ� ���̸� ���Ͽ� 
	//   �迭 �ʵ� maxColumnWidths[]�� maxRowHeights[]�� �����ϴ� �޼ҵ�
	//   ���� ����� ���� ������ �����ϱ� ���� �غ� �ܰ���
	static void getMaxColumnWidthsRowHeights() {
		
		for (int i= 0; i < noRowsToAdd; i++)
			maxRowHeights[i] = 0;

		for (int j= 0; j < noColumnsToAdd; j++)
			maxColumnWidths[j] = 0; 

		// 2���� �迭�� ���  ������Ʈ���� ũ�⸦ ���Ͽ� �� ���� �ִ� ���̿� �� ���� �ִ� �ʺ� ����
		for (int i= 0; i < noRowsToAdd; i++) {	
			for (int j= 0; j < noColumnsToAdd; j++){

				if (compsToAdd[i][j] == null)
					continue;

				int w = columnWidthsToAdd[i][j];
				int h = rowHeightsToAdd[i][j];

				if (w > maxColumnWidths[j])
					maxColumnWidths[j] = w;  // ���� ������Ʈ�� �ʺ� ���ݱ����� �ִ� �ʺ񺸴� ũ�� �ִ� �ʺ� ���� 

				if (h > maxRowHeights[i])
					maxRowHeights[i] = h; // ���� ������Ʈ�� ���̰� ���ݱ����� �ִ� ���̺��� ũ�� �ִ� ���� ���� 
			}
		}
	}

	// ��� �� �߿��� ���� �� ������ �� �ʺ�� �� ���̸� ���ϴ� �޼ҵ�
	//    �� �޼ҵ�� ��ü ������Ʈ ��ġ���� ������ �����ϱ� ���� �ʿ���
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

	// Ÿ��Ʋ�� ���� ������ ����
	static void setTitleComponent(Object title) {
		if (title == null) 
			return;

		if (title != null) {
			if (title instanceof String) { //Ÿ��Ʋ�� ���ڿ��� �־��� ��� ���ڿ��� ���� ��ư�� �����Ͽ� Ÿ��Ʋ�� ��ġ
				titleToAdd = new JButton((String) title);

				titleToAdd.setFont(new Font("���ü", Font.BOLD, defaultTitleFontSize));
			}
			else  { // Ÿ��Ʋ ������Ʈ�� ���ڿ��� �ƴ� ��� �־��� ������Ʈ�� Ÿ��Ʋ�� ��ġ
				titleToAdd = (JComponent) title;
			}

			int titleWidth = getComponentWidth(titleToAdd);
			int titleHeight = getComponentHeight(titleToAdd);

			titleToAdd.setSize(titleWidth, titleHeight);	
		}
	}

	// Ok ��ư�� ���� ����
	static void setOkButton(JButton okBt){
		if (okBt == null)
			return;

		okBtToAdd = okBt;

		okBt.setFont(new Font("���ü", Font.ITALIC, defaultOkButtonFontSize));

		int okWidth = getComponentWidth(okBt);
		int okHeight = getComponentHeight(okBt);

		okBt.setSize(okWidth, okHeight);
	}

	// �־��� �г� p�� Ÿ��Ʋ, 1���� �迭�� ���� ������Ʈ��, Ȯ�ι�ư�� ��ġ
	//    ���� ������Ʈ�� �� �ٿ� noColumns ���� ��ġ��
	//    �� ������Ʈ�� �ڵ�������  ���ڸ������ ������ ��ġ�� ��ġ�� 
	static void displayComponents(JFrame frame, Container  p, Object title, int noColumns, JComponent[] comps, JButton okBt) {

		// 1���� ������Ʈ �迭�� 2���� ������Ʈ �迭�� ��ȯ
		JComponent[][] convertedComps = convert1DimTo2DimComponents(comps, noColumns);

		// p�� Ÿ��Ʋ, 2���� �迭�� ���� ������Ʈ��, Ȯ�ι�ư�� ��ġ
		displayComponents(frame,  p,  title, convertedComps, okBt);
	}

	// 1���� �迭�� ����� ������Ʈ���� �־��� ���� ������ ���߾� 2���� �迭�� ����
	static JComponent[][] convert1DimTo2DimComponents(JComponent[] comps, int noColumns) {
		int noComps = comps.length;   //  add�� ������Ʈ ������ ����
		int noRows = (noComps + noColumns - 1) / noColumns;  //  add�� ������Ʈ���� �� ������ ������

		JComponent[][] convertedComps = new JComponent[noRows][noColumns];  // ������ 2���� �迭 ����

		int no = 0;
		for (int i=0; i < noRows; i++)
			for (int j=0; j<noColumns; j++) {
				convertedComps[i][j] = comps[no++];

				if (no >= noComps)
					break;
			}

		return convertedComps;		
	}

	// ������ ����Ǵ°��� Ȯ���Ͽ� ������ ���ڶ�� JScrollPane�� �̿��Ͽ� �г��� Ȯ���Ŵ
	static void secureGap() {

		// hGapToAdd, vGapToAdd ���� ���
		getGapHV();

		// ������ �ּ� ���麸�� ������ ��ũ�� ���� �̿��Ͽ� �ּ� ������ Ȯ����
		if (vGapToAdd  < vGapMin || hGapToAdd < hGapMin) {
			createScrollBar();
		}
	}

	// �� ū �г��� �����Ͽ� ������Ʈ�� ��ġ�ϰ� �г��� JScrollPane�� ��ġ�ϴ� �޼ҵ�
	static void createScrollBar() {		
		boolean reduced = false;

		// ������Ʈ �� JScrollPane ������ JScrollPane ũ�� �ٿ� ���� Ȯ��
		if (hasScrollPaneToAdd)
			reduced = reduceScrollPaneToAdd();

		// �׷��� ���� ������ ���� ��ũ�ѹ� ���� ���� �г� �����Ͽ� ������Ʈ�� ��ġ
		if (vGapToAdd  < vGapMin || hGapToAdd < hGapMin) 
			createScrollPaneToAddContainer();
	}

	// ����, ���� ������ ����
	static void getGapHV() {
		// ��� �� �ִ� ���̸� �̿��Ͽ� ���� �� ���� ���� ���
		vGapToAdd = (heightContainer - sumRowHeights) / (noRowsToAddPlusTitleOkBt + 1);
		hGapToAdd = (widthContainer - sumColumnWidths) / (noColumnsToAdd + 1);
	}

	// ó�� ��ġ�� ������Ʈ�� ��ǥ�� �����ϴ� �޼ҵ�
	//   ������Ʈ ���̿� ���� ������ ���ϰ� ���� ������ ������ �ʱ� ��ġ�� ����
	static void getInitXY() {		
		if (hGapToAdd > hGapMax){	// ���� ������ �ּ� ���麸�� ������ �ּ� ��������
			hGapToAdd = hGapMax;
		}

		if (vGapToAdd > vGapMax){	// ���� ������ �ּ� ���麸�� ������ �ּ� ��������
			vGapToAdd = vGapMax;
		}

		// ��ü ������Ʈ ���̿� ���� ���� ���̿��� ���� ���̴� �� ��, �Ǵ� �Ʒ� ���� �������� ����
		int sumColumnsHgaps = sumColumnWidths + hGapToAdd * noHgapsToAdd;
		int sumRowsVgaps = sumRowHeights + vGapToAdd * noVgapsToAdd;

		initX = (widthContainer - (sumColumnsHgaps + 1)) / 2 + (widthContainer - sumColumnsHgaps) % noHgapsToAdd / 2;
		initY = (heightContainer - (sumRowsVgaps + 1)) / 2 + (heightContainer - sumRowsVgaps) % noVgapsToAdd / 2;

		if (initX < 0)
			initX = 0;

		if (initY < 0)
			initY = 0;	
	}

	// �ٿ��� �� ũ��(�ʺ�� ����) �����ϴ� ������
	static int widthToReduce = 0;
	static int heightToReduce = 0;	
	static boolean sizeChanged = false;

	// �����̳ʿ� ������Ʈ ��ġ�� ���� �����ϸ� ������Ʈ �� ScrollPane�� ������
	//    ScrollPane�� ũ�⸦ �ٿ� ������ Ȯ���ϴ� �޼ҵ�
	//    �� �޼ҵ�� ������Ʈ ������ ������ �ּ� ���麸�� ������ ȣ���
	static boolean reduceScrollPaneToAdd() {

		//ScrollPane�� ���Ե� ��� ������ ���� ū ������Ʈ���� Ȯ��
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
		// ����  ScrollPane ũ�⸦ ���
		int widthReduced = width - widthToReduce;
		int heightReduced = height - heightToReduce;

		if (widthReduced < defaultWidth * 1.5)    // ��ҵ� �� �ʺ� �ʹ� ������ ScrollPane�� ������� ����
			return false;

		if (heightReduced < defaultHeight * 2.5)  // ��ҵ� �� ���̰� �ʹ� ������ ScrollPane�� ������� ����(���̺��� ��� [���, row �ϳ�, ��ũ�ѹ�] ���� �ʿ�)
			return false;

		changeComponentWidthHeight(widthReduced, heightReduced, rowNo, colNo);

		hasScrollPaneReduced = true;
		
		// ���� ScrollPane�� ũ��� ScrollPane ũ�� ����
		ScrollPaneToAdd.setPreferredSize(new Dimension(widthReduced, heightReduced));	
		ScrollPaneToAdd.setSize(widthReduced, heightReduced);

		return true;
	}

	// ���� Ȯ���ϱ� ���� �ٿ����� JScrollPane ũ�⸦ �����ϴ� �޼ҵ�
	static void getSizeToReduce() {
		int width = columnWidthsToAdd[rowNoScrollPaneToAdd][columnNoScrollPaneToAdd];
		int height = rowHeightsToAdd[rowNoScrollPaneToAdd][columnNoScrollPaneToAdd];

		sizeChanged = false;
		
		// ���� ����� ���� ���� ��� �����ϸ� ����� ������ ��� ��ũ�ѹ� ���� ����Ͽ� ���� ������ ����
		if (width == maxColumnWidths[columnNoScrollPaneToAdd] && hGapToAdd < hGapMin
				&& height == maxRowHeights[rowNoScrollPaneToAdd] && vGapToAdd < vGapMin) {

			// �ٿ��� ũ��(�Ǵ� Ȯ���ؾ��� ���� ũ��) ���
			widthToReduce = (hGapMin - hGapToAdd) * (noHgapsToAdd) + scrollBarWidth ;
			heightToReduce = (vGapMin - vGapToAdd) * (noVgapsToAdd) + scrollBarHeight;

			// �� ������ �ٸ� ������Ʈ �ʺ� �Ǵ� ���� ���� Ŀ�� ��ȿ�� ������ ��			
			if (isSecondRankOfColumnWidths(width-widthToReduce, columnNoScrollPaneToAdd) ||
					isSecondRankOfRowHeights(height - heightToReduce, rowNoScrollPaneToAdd))
				sizeChanged = true;
		}
		// ���� ������ �����ϸ� ���� ��ũ�ѹ� ���� ����Ͽ� ���� ������ ����
		else if (width == maxColumnWidths[columnNoScrollPaneToAdd] && hGapToAdd < hGapMin) {
			// �ٿ��� ũ��(�Ǵ� Ȯ���ؾ��� ���� ũ��) ���
			widthToReduce = (hGapMin - hGapToAdd) * (noColumnsToAdd + 1) + noColumnsToAdd;
			heightToReduce = -scrollBarHeight; // ;  // ���� ��ũ�ѹ� ����Ƿ� ���� �þ� ���� �پ��

			// �� ������ �ٸ� ������Ʈ �ʺ񺸴� Ŀ�� ��ȿ�� ������ ��
			if (isSecondRankOfColumnWidths(width-widthToReduce, columnNoScrollPaneToAdd))
				sizeChanged = true;
		}		
		// ���� ������ �����ϸ� ����  ��ũ�ѹ� ���� ����Ͽ� ���� ������ ����
		else if (height == maxRowHeights[rowNoScrollPaneToAdd] && vGapToAdd < vGapMin) {
			widthToReduce = -scrollBarWidth;
			heightToReduce = (vGapMin - vGapToAdd) * (noVgapsToAdd) + (noVgapsToAdd - 1);

			// �� ������ �ٸ� ������Ʈ ���̺��� Ŀ�� ��ȿ�� ������ ��
			if (isSecondRankOfRowHeights(height - heightToReduce, rowNoScrollPaneToAdd)) 
				sizeChanged = true;		
		}
	}

	// ���� ����� 2��° ū ������Ʈ���� ū ���� Ȯ�ϴ� �޼ҵ�
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

	// ���� ����� 2��° ū ������Ʈ���� ū ���� Ȯ�ϴ� �޼ҵ�
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

	// �����̳ʿ� ������Ʈ ��ġ�� ���� �����ϸ� ScrollPane�� ���ο� ���� �г��� �ְ�
	//    ���� �гο� ��ġ�ϵ��� �ϴ� �޼ҵ�
	//    �� �޼ҵ�� ������Ʈ ������ ������ �ּ� ���麸�� ������ ȣ���
	static void createScrollPaneToAddContainer() {
		if (hGapToAdd >= hGapMin && vGapToAdd >= vGapMin ) 
			return;
		
		JPanel innerP = createCopyJPanel(containerAdded); // ��ġ�� ���� �г� ���� �� �Ӽ��� ���� �����̳ʿ� �����ϰ� ��

		// ScrollPane�� ũ�� �� ���� ������ ���� ũ���� ȸ����Ŵ
		restoreSizeScrollPaneToAdd();
		
		// ���� �г��� �ʺ�� ���� ����
		//   ������Ʈ ������ ������ �ּ� ���鸸ŭ �� �� �ֵ��� �ʺ�� ���� ���� 
		//   -scrollBarWidth �Ǵ� - scrollBarHeight�� ���ʿ��� ��ũ�ѹ� ���� �����ϱ� ���� �ʿ���(�� ������ ��Ȯ�� �ľǾȵ�)

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

		JScrollPane scp = new JScrollPane(innerP);      // ���� �г��� ��ũ�����ο� ��ġ
		scp.setSize(widthContainer, heightContainer);   // ��ũ������ ũ�� ����

		containerAdded.add(scp);        // ��ũ�������� �ܺ� �гο� ��ġ
		containerAdded = innerP;           // ���� �г��� ������Ʈ�� ��ġ�� �����̳ʷ� �����Ͽ�

		do {
			widthContainer = widthInnerP;      //   �ʺ�� ���̸� �����̳��� �ʺ�� ���̷� ����
			heightContainer = heightInnerP;	

			// ������Ʈ�� ����� �ʺ�� ����� ���� ��ü ���� ����
			getSumRowWidthsColumnHeights();

			// ó�� ��ġ�� ���� ����� ���� ���� ũ�� ����
			getGapHV();

			// ���� ����� ���� ������ �����ϸ� ���� �г��� ũ�⸦ �ø�
			if (hGapToAdd < hGapMin || vGapToAdd < vGapMin) {
				Dimension d = increaseInnerPanel(innerP);
				widthInnerP = d.width;;    
				heightInnerP = d.height;	
			}
		}
		while(hGapToAdd < hGapMin || vGapToAdd < vGapMin);
	}


	// ���� �г��� ũ�⸦ ������ ����ϵ��� ���̴� �޼ҵ�
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

	// ������ ũ��� �ٽ� ȸ����Ű�� �޼ҵ�
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

	// �־��� �����̳ʿ� ������ ������ JPanel ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	static JPanel createCopyJPanel(Container cont) {
		JPanel p = new JPanel();

		p.setBackground(cont.getBackground());
		p.setBounds(cont.getBounds());	
		p.setLayout(cont.getLayout());

		return p;
	}

	// ������Ʈ�� �ʺ�� ���̸� �����ϴ� �޼ҵ�
	//   �̹� ������ ��� �״�� �̿��ϰ�
	//   ������ �������� �ʾ����� getPreferredSize() �޼ҵ� �̿��Ͽ� �־����� �̻����� �ʺ�� ���� Ȱ�� 
	// �־��� ������Ʈ�� �ʺ� ��ȯ
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

	// �־��� ������Ʈ�� ���� ��ȯ
	static int getComponentHeight(JComponent comp){
		if (comp == null)
			return 0;

		if (comp instanceof JTable) { 
			// ��ü ���̺��� �� ����
			int rowCount = ((JTable) comp).getRowCount();        				// ���̺� ����� ���� ���� ����
			int jTableHeight = (rowCount + 1) * ((JTable) comp).getRowHeight(); //  ��ü ���̺� ���� ����(��ü ���� = ���� ���� * �� ���� + ��� ����)

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
	 *  ������  �޼ҵ���� displayComponents(JFrame frame, ) �޼ҵ带 �����ϰ� ȣ���ϱ� ���� �޼ҵ����
	 */


	// �ϳ��� ������Ʈ�� ��ġ
	static void displayComponents(JFrame frame, Container  p, Object comp) {
		displayComponents(frame, p, comp, null, null);
	}

	// ������Ʈ�鸸 ��ġ
	static void displayComponents(JFrame frame, Container  p, JComponent[][] comps) {
		displayComponents(frame, p, null, comps, null);
	}

	// Ÿ��Ʋ�� �ϳ��� ������Ʈ�� ��ġ
	static void displayComponents(JFrame frame, Container  p, Object title, JComponent comp) {
		JComponent[][] comps = { { comp } };
		displayComponents(frame, p, title, comps, null);
	}

	// Ÿ��Ʋ ���� �ϳ��� ������Ʈ�� Ȯ�ι�ư ��ġ
	static void displayComponents(JFrame frame, Container  p, JComponent comp, JButton okBt) {
		JComponent[][] comps = { { comp } };
		displayComponents(frame, p, null, comps, okBt);
	}

	// Ÿ��Ʋ ���� 2����  ������Ʈ�� Ȯ�ι�ư �������� ��ġ
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JButton okBt) {
		JComponent[][] comps = { { comp1 }, { comp2} };

		displayComponents(frame, p, null,  comps, okBt);
	}

	// Ÿ��Ʋ ���� 6���� ������Ʈ �������� ��ġ
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JComponent comp3,
			JComponent comp4, JComponent comp5, JComponent comp6) {
		JComponent[][] comps = { { comp1 }, { comp2 }, { comp3 }, { comp4 }, { comp5 }, { comp6 } };

		displayComponents(frame, p, null, comps, null);
	}

	// Ÿ��Ʋ ���� 7����  ������Ʈ �������� ��ġ
	static void displayComponents(JFrame frame, Container  p, JComponent comp1, JComponent comp2, JComponent comp3,
			JComponent comp4, JComponent comp5, JComponent comp6, JComponent comp7) {
		JComponent[] comps = { comp1, comp2, comp3, comp4, comp5, comp6, comp7  };

		displayComponents(frame, p, null, 1, comps, null);
	}

	// ���ڿ� Ÿ��Ʋ�� 1���� ���ڿ� �迭��  ������Ʈ�� �����Ͽ� ��ġ
	static void displayTableComponents(JFrame frame, Container p, String title, int noColumns, String[] ss) {

		int n = ss.length;   //  add�� ������Ʈ ����

		JComponent[] comps = new JComponent[n];

		for (int i= 0; i<n; i++) {

			if (i < noColumns) {
				comps[i] = new JLabel(ss[i]);

				comps[i].setFont(new Font("���ü", Font.BOLD, 12));
			}
			else {
				comps[i] = new JTextField(ss[i]);

				comps[i].setFont(new Font("���ü", Font.PLAIN, 12));
			}

		}

		displayComponents(frame, p, title, noColumns, comps, null);
	}
}
