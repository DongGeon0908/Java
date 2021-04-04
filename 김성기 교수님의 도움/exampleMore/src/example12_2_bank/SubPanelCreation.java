package example12_2_bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * [ SubPanelCreation 클래스 ] :
 *      하나의 컨테이너에 2개 또는 3개의 서브 패널을 생성하여 배치하는 클래스
 *      
 * 	  o 컨테이너에 여러 서브 컨테이너를 생성하여 적절한 위치에 배치
 */

public class SubPanelCreation {
	static int boundaryWidth = 5; // frame의 경계 부분의 너비 픽셀 수
	static int boundaryHeight = 28; // frame의 경계 부분의 높이 픽셀 수



	// createSubPanelsCenter() :
	//   주어진 컨테이너 cont를 중앙 1개의 영역으로 나누어 패널을 배치하고, 배치된 패널을 반환
	static Container createSubPanelCenter(Container cont, Color centerColor, int gap) {

		cont.setLayout(null);

		/*
		 *  주어진 cont의 실제 사용 가능한 너비와 높이를 구함 
		 *     이 부분은 다른 곳에서는 getContainerUsableSize(Container cont) 메소드를 사용함
		 */
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -= boundaryWidth;     // title이 표시되는 컨테이너의 가용 너비를 경계폭만큼 줄여줌
			height -= boundaryHeight;   // title이 표시되는 컨테이너의 가용 높이를 경계폭만큼 줄여줌
		}

		// 1개의 패널을 생성하여 주어진 cont에 배치, 패널간 띄움 간격 gap을 고려하여 패널의 너비와 높이를 결정함
		Container panel = createAddPanel(cont, width - gap * 2, height - gap * 2, gap, gap, centerColor); // 중앙 패널

		return panel;
	}

	// createSubPanelsTopCenter() :
	//   주어진 컨테이너 cont을 위쪽과 중앙 2개의 영역으로 나누어 패널을 배치하고, 배치된 패널들을 배열로 반환
	static Container[] createSubPanelsTopCenter(Container cont, int topHeight, 
			Color topColor, Color centerColor, int gap) {

		cont.setLayout(null);

		// 주어진 cont의 실제 사용 가능한 너비와 높이를 구함
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		Container[] subPanels = new Container[2];		

		if (topHeight + gap * 2 > height)
			topHeight = height / 2 - gap * 2; // topPanel의 높이가 컨테이너보다 크면 컨테이너의 절반 크기로 변경

		// 2개의 패널을 생성하여 주어진 cont에 배치, 패널간 띄움 간격 gap을 고려하여 각 패널의 너비와 높이를 결정함
		int wPanel1 = width - gap * 2;
		int hpPanel1 = topHeight;

		int wPanel2 = width - gap * 2;
		int hpPanel2 = height - topHeight - gap * 3;


		subPanels[0] = createAddPanel(cont, wPanel1, hpPanel1, gap, gap, topColor); // 상부 패널
		subPanels[1] = createAddPanel(cont, width - gap * 2, hpPanel2, gap, topHeight + gap * 2, centerColor);  // 중앙 패널

		return subPanels;
	}

	// createSubPanelsLeftRight() :
	//   주어진 컨테이너 cont을 왼쪽 , 오른쪽  등 2개의 영역으로 나누어 패널을 배치하고, 배치된 패널들을 배열로 반환
	static Container[] createSubPanelsLeftRight(Container cont, int leftWidth, 
			Color leftColor, Color rightColor, int gap) {

		cont.setLayout(null);

		// 주어진 cont의 실제 사용 가능한 너비와 높이를 구함
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		if (leftWidth  + gap * 2 > width)
			leftWidth = width / 2 - gap * 2; // leftWidth의 너비가 컨테이너보다 크면 컨테이너의 절반 크기로 변경

		Container[] subPanels = new Container[2];		

		// 2개의 패널을 생성하여 주어진 cont에 배치, 패널간 띄움 간격 gap을 고려하여 각 패널의 너비와 높이를 결정함
		subPanels[0] = createAddPanel(cont, leftWidth, height - gap * 2, gap, gap, leftColor); // 왼쪽 패널
		subPanels[1] = createAddPanel(cont, width - (leftWidth + gap * 3), height - gap * 2, leftWidth + 2 * gap, gap, rightColor);  // 오른쪽 패널

		return subPanels;
	}

	// createSubPanelsTopLeftCenter() :
	//   주어진 컨테이너 cont를 위쪽, 왼쪽 , 중앙 등 3개의 영역으로 나누어 패널을 배치하고, 배치된 패널들을 배열로 반환
	static Container[] createSubPanelsTopLeftCenter(Container cont, int topHeight, int leftWidth, 
			Color topColor, Color leftColor, Color centerColor, int gap) {

		cont.setLayout(null);

		// 주어진 cont의 실제 사용 가능한 너비와 높이를 구함
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		if (topHeight  + gap * 2> height)
			topHeight = height / 2- gap * 2; // topPanel의 높이가 컨테이너보다 크면 컨테이너의 절반 크기로 변경

		if (leftWidth  + gap * 2> width)
			leftWidth = width / 2 - gap * 2; // leftWidth의 너비가 컨테이너보다 크면 컨테이너의 절반 크기로 변경

		Container[] subPanels = new Container[3];		

		// 3개의 패널을 생성하여 주어진 cont에 배치, 패널간 띄움 간격 gap을 고려하여 각 패널의 너비와 높이를 결정함
		subPanels[0] = createAddPanel(cont, width - gap * 2, topHeight, gap, gap, topColor); // 상부 패널
		subPanels[1] = createAddPanel(cont, leftWidth, height - topHeight - gap * 3, gap, topHeight+gap * 2, leftColor);   // 왼쪽 팬널
		subPanels[2] = createAddPanel(cont, width - leftWidth - gap * 3, height - topHeight - gap * 3, leftWidth + gap * 2, topHeight + gap * 2, centerColor);  // 중앙 패널


		return subPanels;
	}

	// createSubPanelsTopCenterBottom() :
	//   주어진 컨테이너 cont를 위,  중앙, 아래 등 3개의 영역으로 나누어 패널을 배치하고, 배치된 패널들을 배열로 반환
	static Container[] createSubPanelsTopCenterBottom(Container cont, int topHeight, int bottomHeight, 
			Color topColor, Color centerColor, Color bottomColor, int gap) {
		cont.setLayout(null);

		// 주어진 cont의 실제 너비와 높이를 구함 
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -=  boundaryWidth;     // title이 표시되는 컨테이너의 가용 너비를 경계폭만큼 줄여줌
			height -=  boundaryHeight;   // title이 표시되는 컨테이너의 가용 높이를 경계폭만큼 줄여줌
		}

		if (topHeight  + bottomHeight + gap * 3 > height) {
			int hNewTopPlusButton = height * 2 / 3 - gap * 3; // topPanel + bottomHeight의 높이가 컨테이너보다 크면 이들 합 크기를 컨테이너의 2/3 크기로 변경
			double ratioTopBottom = topHeight / (double) bottomHeight;

			// topHeight와 bottomHeight 비율대로 새로운 높이를 배정
			bottomHeight =  (int) (hNewTopPlusButton / (ratioTopBottom + 1));
			topHeight =  hNewTopPlusButton - bottomHeight;
		}

		Container[] subPanels = new Container[3];		

		// 3개의 패널을 생성하여 주어진 cont에 배치, 패널간 띄움 간격 gap을 고려하여 각 패널의 너비와 높이를 결정함
		subPanels[0] = createAddPanel(cont, width - gap * 2, topHeight, gap, gap, topColor); // 상부 패널
		subPanels[1] = createAddPanel(cont, width - gap * 2, height - (topHeight + bottomHeight + gap * 4), gap, topHeight+gap * 2, centerColor);   // 중앙 팬널
		subPanels[2] = createAddPanel(cont, width - gap * 2, bottomHeight, gap, (height - (bottomHeight + gap)), bottomColor);  // 아래 패널


		return subPanels;
	}

	// getContainerUsableSize() : 주어진 cont의 실제 너비와 높이를 구하여 Dimension 객체로 반환
	//   Dimension 클래스는 width와 height 값을 저장할 수 있는 클래스임
	static Dimension getContainerUsableSize(Container cont) {
		// 주어진 cont의 실제 너비와 높이를 구함 
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -=  boundaryWidth;     // title이 표시되는 컨테이너의 가용 너비를 경계폭만큼 줄여줌
			height -=  boundaryHeight;   // title이 표시되는 컨테이너의 가용 높이를 경계폭만큼 줄여줌
		}

		return new Dimension(width, height); // 계산된 width와 height를 저장한 Dimension 객체 생성하여 반환
	}

	// createAddPanel() : 패널을 생성하여 주어진 컨테이너 cont에 배치
	//   패널의 크기는 (w, h), 배치 위치는 (x,y)
	static Container createAddPanel(Container cont, int w, int h, int x, int y, Color color) {
		Container p = createPanel(w, h, color);

		addPanel(cont, p, x, y);   // p를 cont의 (x, y) 위치에 배치

		return p;
	}

	// createPanel() : 패널의 크기 (w, h), 배경색 color인 패널을 생성하여 반환
	static Container createPanel( int w, int h, Color color) {
		Container p = new JPanel(null);

		p.setSize(w, h);           // 크기 지정
		p.setBackground(color);    // 배경색 지정
		p.setLayout(null);	       // 레이아웃 null로 지정(좌표를 사용하여  임의 위치에 컴포넌트 배치 가능함)

		return p;
	}

	// addPanel() : 주어진 컨테이너 p를 컨테이너 cont의 (x, y) 위치에  배치
	static void  addPanel(Container cont, Container p, int x, int y) {
		cont.add(p);               // cont에 배치

		p.setLocation(x, y);	   // 위치 지정
	}
}
