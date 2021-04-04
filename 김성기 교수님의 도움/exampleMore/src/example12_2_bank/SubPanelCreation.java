package example12_2_bank;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * [ SubPanelCreation Ŭ���� ] :
 *      �ϳ��� �����̳ʿ� 2�� �Ǵ� 3���� ���� �г��� �����Ͽ� ��ġ�ϴ� Ŭ����
 *      
 * 	  o �����̳ʿ� ���� ���� �����̳ʸ� �����Ͽ� ������ ��ġ�� ��ġ
 */

public class SubPanelCreation {
	static int boundaryWidth = 5; // frame�� ��� �κ��� �ʺ� �ȼ� ��
	static int boundaryHeight = 28; // frame�� ��� �κ��� ���� �ȼ� ��



	// createSubPanelsCenter() :
	//   �־��� �����̳� cont�� �߾� 1���� �������� ������ �г��� ��ġ�ϰ�, ��ġ�� �г��� ��ȯ
	static Container createSubPanelCenter(Container cont, Color centerColor, int gap) {

		cont.setLayout(null);

		/*
		 *  �־��� cont�� ���� ��� ������ �ʺ�� ���̸� ���� 
		 *     �� �κ��� �ٸ� �������� getContainerUsableSize(Container cont) �޼ҵ带 �����
		 */
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -= boundaryWidth;     // title�� ǥ�õǴ� �����̳��� ���� �ʺ� �������ŭ �ٿ���
			height -= boundaryHeight;   // title�� ǥ�õǴ� �����̳��� ���� ���̸� �������ŭ �ٿ���
		}

		// 1���� �г��� �����Ͽ� �־��� cont�� ��ġ, �гΰ� ��� ���� gap�� ����Ͽ� �г��� �ʺ�� ���̸� ������
		Container panel = createAddPanel(cont, width - gap * 2, height - gap * 2, gap, gap, centerColor); // �߾� �г�

		return panel;
	}

	// createSubPanelsTopCenter() :
	//   �־��� �����̳� cont�� ���ʰ� �߾� 2���� �������� ������ �г��� ��ġ�ϰ�, ��ġ�� �гε��� �迭�� ��ȯ
	static Container[] createSubPanelsTopCenter(Container cont, int topHeight, 
			Color topColor, Color centerColor, int gap) {

		cont.setLayout(null);

		// �־��� cont�� ���� ��� ������ �ʺ�� ���̸� ����
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		Container[] subPanels = new Container[2];		

		if (topHeight + gap * 2 > height)
			topHeight = height / 2 - gap * 2; // topPanel�� ���̰� �����̳ʺ��� ũ�� �����̳��� ���� ũ��� ����

		// 2���� �г��� �����Ͽ� �־��� cont�� ��ġ, �гΰ� ��� ���� gap�� ����Ͽ� �� �г��� �ʺ�� ���̸� ������
		int wPanel1 = width - gap * 2;
		int hpPanel1 = topHeight;

		int wPanel2 = width - gap * 2;
		int hpPanel2 = height - topHeight - gap * 3;


		subPanels[0] = createAddPanel(cont, wPanel1, hpPanel1, gap, gap, topColor); // ��� �г�
		subPanels[1] = createAddPanel(cont, width - gap * 2, hpPanel2, gap, topHeight + gap * 2, centerColor);  // �߾� �г�

		return subPanels;
	}

	// createSubPanelsLeftRight() :
	//   �־��� �����̳� cont�� ���� , ������  �� 2���� �������� ������ �г��� ��ġ�ϰ�, ��ġ�� �гε��� �迭�� ��ȯ
	static Container[] createSubPanelsLeftRight(Container cont, int leftWidth, 
			Color leftColor, Color rightColor, int gap) {

		cont.setLayout(null);

		// �־��� cont�� ���� ��� ������ �ʺ�� ���̸� ����
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		if (leftWidth  + gap * 2 > width)
			leftWidth = width / 2 - gap * 2; // leftWidth�� �ʺ� �����̳ʺ��� ũ�� �����̳��� ���� ũ��� ����

		Container[] subPanels = new Container[2];		

		// 2���� �г��� �����Ͽ� �־��� cont�� ��ġ, �гΰ� ��� ���� gap�� ����Ͽ� �� �г��� �ʺ�� ���̸� ������
		subPanels[0] = createAddPanel(cont, leftWidth, height - gap * 2, gap, gap, leftColor); // ���� �г�
		subPanels[1] = createAddPanel(cont, width - (leftWidth + gap * 3), height - gap * 2, leftWidth + 2 * gap, gap, rightColor);  // ������ �г�

		return subPanels;
	}

	// createSubPanelsTopLeftCenter() :
	//   �־��� �����̳� cont�� ����, ���� , �߾� �� 3���� �������� ������ �г��� ��ġ�ϰ�, ��ġ�� �гε��� �迭�� ��ȯ
	static Container[] createSubPanelsTopLeftCenter(Container cont, int topHeight, int leftWidth, 
			Color topColor, Color leftColor, Color centerColor, int gap) {

		cont.setLayout(null);

		// �־��� cont�� ���� ��� ������ �ʺ�� ���̸� ����
		Dimension dim = getContainerUsableSize(cont);
		int width = dim.width;  
		int height = dim.height;

		if (topHeight  + gap * 2> height)
			topHeight = height / 2- gap * 2; // topPanel�� ���̰� �����̳ʺ��� ũ�� �����̳��� ���� ũ��� ����

		if (leftWidth  + gap * 2> width)
			leftWidth = width / 2 - gap * 2; // leftWidth�� �ʺ� �����̳ʺ��� ũ�� �����̳��� ���� ũ��� ����

		Container[] subPanels = new Container[3];		

		// 3���� �г��� �����Ͽ� �־��� cont�� ��ġ, �гΰ� ��� ���� gap�� ����Ͽ� �� �г��� �ʺ�� ���̸� ������
		subPanels[0] = createAddPanel(cont, width - gap * 2, topHeight, gap, gap, topColor); // ��� �г�
		subPanels[1] = createAddPanel(cont, leftWidth, height - topHeight - gap * 3, gap, topHeight+gap * 2, leftColor);   // ���� �ҳ�
		subPanels[2] = createAddPanel(cont, width - leftWidth - gap * 3, height - topHeight - gap * 3, leftWidth + gap * 2, topHeight + gap * 2, centerColor);  // �߾� �г�


		return subPanels;
	}

	// createSubPanelsTopCenterBottom() :
	//   �־��� �����̳� cont�� ��,  �߾�, �Ʒ� �� 3���� �������� ������ �г��� ��ġ�ϰ�, ��ġ�� �гε��� �迭�� ��ȯ
	static Container[] createSubPanelsTopCenterBottom(Container cont, int topHeight, int bottomHeight, 
			Color topColor, Color centerColor, Color bottomColor, int gap) {
		cont.setLayout(null);

		// �־��� cont�� ���� �ʺ�� ���̸� ���� 
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -=  boundaryWidth;     // title�� ǥ�õǴ� �����̳��� ���� �ʺ� �������ŭ �ٿ���
			height -=  boundaryHeight;   // title�� ǥ�õǴ� �����̳��� ���� ���̸� �������ŭ �ٿ���
		}

		if (topHeight  + bottomHeight + gap * 3 > height) {
			int hNewTopPlusButton = height * 2 / 3 - gap * 3; // topPanel + bottomHeight�� ���̰� �����̳ʺ��� ũ�� �̵� �� ũ�⸦ �����̳��� 2/3 ũ��� ����
			double ratioTopBottom = topHeight / (double) bottomHeight;

			// topHeight�� bottomHeight ������� ���ο� ���̸� ����
			bottomHeight =  (int) (hNewTopPlusButton / (ratioTopBottom + 1));
			topHeight =  hNewTopPlusButton - bottomHeight;
		}

		Container[] subPanels = new Container[3];		

		// 3���� �г��� �����Ͽ� �־��� cont�� ��ġ, �гΰ� ��� ���� gap�� ����Ͽ� �� �г��� �ʺ�� ���̸� ������
		subPanels[0] = createAddPanel(cont, width - gap * 2, topHeight, gap, gap, topColor); // ��� �г�
		subPanels[1] = createAddPanel(cont, width - gap * 2, height - (topHeight + bottomHeight + gap * 4), gap, topHeight+gap * 2, centerColor);   // �߾� �ҳ�
		subPanels[2] = createAddPanel(cont, width - gap * 2, bottomHeight, gap, (height - (bottomHeight + gap)), bottomColor);  // �Ʒ� �г�


		return subPanels;
	}

	// getContainerUsableSize() : �־��� cont�� ���� �ʺ�� ���̸� ���Ͽ� Dimension ��ü�� ��ȯ
	//   Dimension Ŭ������ width�� height ���� ������ �� �ִ� Ŭ������
	static Dimension getContainerUsableSize(Container cont) {
		// �־��� cont�� ���� �ʺ�� ���̸� ���� 
		int width = cont.getWidth();  
		int height = cont.getHeight();

		if (cont instanceof JFrame || cont instanceof Frame || cont instanceof Window || cont instanceof JWindow  ) {
			width -=  boundaryWidth;     // title�� ǥ�õǴ� �����̳��� ���� �ʺ� �������ŭ �ٿ���
			height -=  boundaryHeight;   // title�� ǥ�õǴ� �����̳��� ���� ���̸� �������ŭ �ٿ���
		}

		return new Dimension(width, height); // ���� width�� height�� ������ Dimension ��ü �����Ͽ� ��ȯ
	}

	// createAddPanel() : �г��� �����Ͽ� �־��� �����̳� cont�� ��ġ
	//   �г��� ũ��� (w, h), ��ġ ��ġ�� (x,y)
	static Container createAddPanel(Container cont, int w, int h, int x, int y, Color color) {
		Container p = createPanel(w, h, color);

		addPanel(cont, p, x, y);   // p�� cont�� (x, y) ��ġ�� ��ġ

		return p;
	}

	// createPanel() : �г��� ũ�� (w, h), ���� color�� �г��� �����Ͽ� ��ȯ
	static Container createPanel( int w, int h, Color color) {
		Container p = new JPanel(null);

		p.setSize(w, h);           // ũ�� ����
		p.setBackground(color);    // ���� ����
		p.setLayout(null);	       // ���̾ƿ� null�� ����(��ǥ�� ����Ͽ�  ���� ��ġ�� ������Ʈ ��ġ ������)

		return p;
	}

	// addPanel() : �־��� �����̳� p�� �����̳� cont�� (x, y) ��ġ��  ��ġ
	static void  addPanel(Container cont, Container p, int x, int y) {
		cont.add(p);               // cont�� ��ġ

		p.setLocation(x, y);	   // ��ġ ����
	}
}
