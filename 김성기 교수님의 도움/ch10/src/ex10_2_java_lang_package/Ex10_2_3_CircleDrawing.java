package ex10_2_java_lang_package;

/**
 * [ Circle, CircleDrawing Ŭ����]: 
 *       Math Ŭ������ �޼ҵ� �̿��Ͽ� �� �׸���
 * 
 *   o ��(circle)
 *     - �߽ɿ��� �Ÿ��� ������ ������ ����
 *     - ���� �߽��� (xc, yc), �������� r�� �� ���� ���� ���� �� P(x, y)�� ������ ���� ������
 *       x = xc + r * sin(��)
 *       y = yc + r * cos(��)
 *       
 *       (��, ��� ȣ���� ������)
 *       
 *   o �� �׸���
 *     - ���� ���� �踦 0�������� �����ϰ� ��ȭ��Ű�鼭 ���� ���� ���� ��ǥ(x, y)�� ����
 *     - �� ��ǥ ��ġ�� 2���� �迭 ���ҿ� ���� '*'�� �����ϸ� �������� ���� �׸� �� ����
 *     
 *     - �� ���α׷��� �ﰢ�Լ�, ��ǥ��, �ݿø�, 2���� �迭 ���� ����ϴ� ���� ������ ���α׷�
 *     - ���� ���α׷��ӷ� �ߵ����ϱ� ���ؼ��� �������� ������ �ʿ����� ������ 
 */

class Circle {
	int xC;      // ���� �߽� ��ǥ�� x 
	int yC;      // ���� �߽� ��ǥ�� y 
	int radius;  // ���� ������ 

	Circle(int xC, int yC, int radius) {  // ��ü ������
		this.xC = xC; this.yC = yC;  this.radius = radius; 
	}

	// Circle ��ü�� ���� 2���� �迭�� �̿��Ͽ� �׸��� �޼ҵ�
	void draw() {
		setCharMap();        // �߽ɰ� �������� ���� �ʿ��� 2���� �迭�� ����
		setAxis();           // ���� �׸��� ���� ���� �迭�� x ��� y���� ��ġ
		setCircumference();  // ���� �׸��� ���� ���� �迭�� ���ָ� ��Ÿ���� *�� ��ġ
		drawCharMap();       // ���� �׸��� ���� ���� �迭�� ���
	}

	char[][] charMap;  // ���� �׸��� ���� 2���� ���� �迭����
	int xLen;          // x ���� ũ��(xLen/2 ��ġ�� x ��ǥ 0 ��ġ��)
	int yLen;          // y ���� ũ��(yLen/2 ��ġ�� y ��ǥ 0 ��ġ��)

	// �߽ɰ� ���������� x ��� y �� ũ�� ����Ͽ� 2���� ���� �迭 �����ϴ� �޼ҵ�
	void setCharMap() {
		// x ��� y���� ���̸� �����Ͽ� 2���� ���� �迭 ��ü ����
		// �������� ���� �� ��ġ�� 2�� + 5�� ���� ũ����
		xLen = Math.max(Math.abs(xC + radius), Math.abs(xC - radius)) * 2 + 5;
		yLen = Math.max(Math.abs(yC + radius), Math.abs(yC - radius)) * 2 + 5;

		charMap = new char[yLen][xLen];  // x ��� y �� ũ�⸸ŭ�� 2���� �迭 ���� 
	}

	// ���� �׸��� ���� ���� �迭�� x ��� y���� ��ġ�ϴ� �޼ҵ�	
	void setAxis() {
		for (int y=0; y < yLen; y++)  // ���ڹ迭�� ��� ���Ҹ� ' '�� ����
			for (int x=0; x < xLen; x++)  
				charMap[y][x] = ' ';

		for (int x=0; x < xLen; x++)  // x �࿡ �ش�Ǵ� ��� ���ҵ��� '-'��  ����
			charMap[yLen/2][x] = '-';

		for (int y=0; y < yLen; y++)  // y �࿡ �ش�Ǵ� ��� ���ҵ��� '|'��  ����
			charMap[y][xLen/2] = '|';			

		// (0, 0), (5, 0), (0, 5), (-5, 0), (0, -5) ��ǥ�� ���� 0, +5, +5, -5, -5 ǥ��
		charMap[yLen/2][xLen/2] = '0';			
		charMap[yLen/2][xLen/2 + 4] = '+'; charMap[yLen/2][xLen/2 + 5] = '5';
		charMap[yLen/2 + 5][xLen/2 - 1] = '+'; charMap[yLen/2 + 5][xLen/2] = '5';			
		charMap[yLen/2][xLen/2 - 6] = '-'; charMap[yLen/2][xLen/2 - 5] = '5';	
		charMap[yLen/2 - 5][xLen/2 - 1] = '-'; charMap[yLen/2 - 5][xLen/2] = '5';
	}

	// ���� �׸��� ���� ���� �迭�� ���ָ� ��Ÿ���� *�� ��ġ�ϴ� �޼ҵ�
	void setCircumference() {
		charMap[yC + yLen / 2][xC + xLen / 2] = '��';         // �� �߽ɿ� '��' ��ġ

		// ���� ���̸� �̿��Ͽ� ���ο� ���� ���� ������ ���
		int circum = (int) Math.round(2 * Math.PI * radius); // ���� ���� ���
		if (circum >= 360) 
			circum = 360;           // ���� ���̰� 360�̻��̸� 360���� ����
		int inc = 360 / circum;     // 360�� ���� ���̷� ������ ���� ������ inc�� ����

		// ���� 0���� �����Ͽ� �����и�ŭ �����ϸ鼭 ������ ��ǥ ����
		for (int angle = 0; angle <= 360; angle += inc) {
			double radian = angle * Math.PI / 180;  // 60�й� ������ �������� ����

			// radian ������ ���� ���ֻ��� ��ǥ(x, y)�� ����		
			int x = xC + (int) Math.round(radius * Math.sin(radian));
			int y = yC + (int) Math.round(radius * Math.cos(radian));

			// (x, y) ��ǥ ��ġ ���ڿ� '*' ���ڸ� ��ġ��
			charMap[y + yLen / 2][x + xLen / 2] = '*'; 
		}
	}

	// ���� �׸��� ����  ���� �迭�� ����ϴ� �޼ҵ�
	void drawCharMap() {
		for (int y = yLen - 1; y >=0 ; y--) { // y ���� +���� -�� �׸��� ���� ���ҽ�Ŵ
			for (int x=0; x < xLen; x++)
				System.out.print(charMap[y][x]);
			System.out.println();
		}
	}
}

public class Ex10_2_3_CircleDrawing {		
	public static void main(String[] args) {

		while(true) {
			int xC = SkScanner.getInt("\n  o �� �߽��� x ��ǥ > ");  // �߽� x ��ǥ �Է�
			int yC = SkScanner.getInt("  o �� �߽��� y ��ǥ > ");   // �߽� x ��ǥ �Է�
			int radius = SkScanner.getInt("  o �� ������ > ");       // ������ �Է�

			Circle circle = new Circle(xC, yC, radius);  // Circle ��ü ����
			circle.draw();	                        // ���� �׸�		
		}		
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� �߽� ��ǥ�� �������� �Է��Ͽ� �������� ���� �׸���.
 *      ȭ�� �󿡼��� ���ο� ���� ���ں����� 1:1�� �ƴϹǷ� ���� Ÿ��ó�� ���δ�.
 *   
 *   2) ���α׷��� �����Ͽ� ���� �߽� ��ǥ�� �������� �Է��ϰ� ��� ����� Ȯ���϶�.   
 *   
 *   
 * [ �ǽ� ���� ]
 * 
 *   o �� ���α׷���  Math Ŭ������ �迭�� Ȱ���Ͽ� �������� ���� �׸���. �̸� �����Ͽ� 
 *     sin �׷����� ���������� �׸��� ���α׷��� �ۼ��϶�. 
 *     
 *     sin �׷����� x���� 0������ 360���� ������ ��Ÿ����, y���� -1���� 1������ 
 *     sin ���� ��Ÿ������ �Ѵ�. y���� ���� 20��� Ȯ���Ͽ� �׸���.     
 */
