package ex10_2_java_lang_package;

/**
 * [ Circle, CircleDrawing 클래스]: 
 *       Math 클래스의 메소드 이용하여 원 그리기
 * 
 *   o 원(circle)
 *     - 중심에서 거리가 일정한 점들의 집합
 *     - 원의 중심이 (xc, yc), 반지름이 r일 때 각도 θ인 원의 점 P(x, y)는 다음과 같이 구해짐
 *       x = xc + r * sin(θ)
 *       y = yc + r * cos(θ)
 *       
 *       (단, θ는 호도법 각도임)
 *       
 *   o 원 그리기
 *     - 원의 각도 θ를 0에서부터 일정하게 변화시키면서 각도 θ일 때의 좌표(x, y)를 구함
 *     - 그 좌표 위치의 2차원 배열 원소에 문자 '*'를 저장하면 개략적인 원을 그릴 수 있음
 *     
 *     - 이 프로그램은 삼각함수, 좌표계, 반올림, 2차원 배열 등을 사용하는 높은 수준의 프로그램
 *     - 전문 프로그래머로 발돋움하기 위해서는 수학적인 지식이 필요함을 보여줌 
 */

class Circle {
	int xC;      // 원의 중심 좌표의 x 
	int yC;      // 원의 중심 좌표의 y 
	int radius;  // 원의 반지름 

	Circle(int xC, int yC, int radius) {  // 객체 생성자
		this.xC = xC; this.yC = yC;  this.radius = radius; 
	}

	// Circle 객체의 원을 2차원 배열을 이용하여 그리는 메소드
	void draw() {
		setCharMap();        // 중심과 반지름에 따라 필요한 2차원 배열을 생성
		setAxis();           // 원을 그리기 위한 문자 배열에 x 축과 y축을 배치
		setCircumference();  // 원을 그리기 위한 문자 배열에 원주를 나타내는 *를 배치
		drawCharMap();       // 원을 그리기 위한 문자 배열을 출력
	}

	char[][] charMap;  // 원을 그리기 위한 2차원 문자 배열변수
	int xLen;          // x 축의 크기(xLen/2 위치가 x 좌표 0 위치임)
	int yLen;          // y 축의 크기(yLen/2 위치가 y 좌표 0 위치임)

	// 중심과 반지름으로 x 축과 y 축 크기 계산하여 2차원 문자 배열 생성하는 메소드
	void setCharMap() {
		// x 축과 y축의 길이를 결정하여 2차원 문자 배열 객체 생성
		// 원점에서 가장 먼 위치의 2배 + 5가 축의 크기임
		xLen = Math.max(Math.abs(xC + radius), Math.abs(xC - radius)) * 2 + 5;
		yLen = Math.max(Math.abs(yC + radius), Math.abs(yC - radius)) * 2 + 5;

		charMap = new char[yLen][xLen];  // x 축과 y 축 크기만큼의 2차원 배열 생성 
	}

	// 원을 그리기 위한 문자 배열에 x 축과 y축을 배치하는 메소드	
	void setAxis() {
		for (int y=0; y < yLen; y++)  // 문자배열의 모든 원소를 ' '로 저장
			for (int x=0; x < xLen; x++)  
				charMap[y][x] = ' ';

		for (int x=0; x < xLen; x++)  // x 축에 해당되는 모든 원소들을 '-'로  저장
			charMap[yLen/2][x] = '-';

		for (int y=0; y < yLen; y++)  // y 축에 해당되는 모든 원소들을 '|'로  저장
			charMap[y][xLen/2] = '|';			

		// (0, 0), (5, 0), (0, 5), (-5, 0), (0, -5) 좌표에 숫자 0, +5, +5, -5, -5 표시
		charMap[yLen/2][xLen/2] = '0';			
		charMap[yLen/2][xLen/2 + 4] = '+'; charMap[yLen/2][xLen/2 + 5] = '5';
		charMap[yLen/2 + 5][xLen/2 - 1] = '+'; charMap[yLen/2 + 5][xLen/2] = '5';			
		charMap[yLen/2][xLen/2 - 6] = '-'; charMap[yLen/2][xLen/2 - 5] = '5';	
		charMap[yLen/2 - 5][xLen/2 - 1] = '-'; charMap[yLen/2 - 5][xLen/2] = '5';
	}

	// 원을 그리기 위한 문자 배열에 원주를 나타내는 *를 배치하는 메소드
	void setCircumference() {
		charMap[yC + yLen / 2][xC + xLen / 2] = '●';         // 원 중심에 '●' 배치

		// 원주 길이를 이용하여 루핑에 사용될 각도 증가분 계산
		int circum = (int) Math.round(2 * Math.PI * radius); // 원주 길이 계산
		if (circum >= 360) 
			circum = 360;           // 원주 길이가 360이상이면 360으로 변경
		int inc = 360 / circum;     // 360을 원주 길이로 나누어 각도 증가분 inc를 구함

		// 각도 0부터 시작하여 증가분만큼 증가하면서 원주의 좌표 구함
		for (int angle = 0; angle <= 360; angle += inc) {
			double radian = angle * Math.PI / 180;  // 60분법 각도를 라디안으로 변경

			// radian 각도에 대한 원주상의 좌표(x, y)를 구함		
			int x = xC + (int) Math.round(radius * Math.sin(radian));
			int y = yC + (int) Math.round(radius * Math.cos(radian));

			// (x, y) 좌표 위치 문자에 '*' 문자를 배치함
			charMap[y + yLen / 2][x + xLen / 2] = '*'; 
		}
	}

	// 원을 그리기 위한  문자 배열을 출력하는 메소드
	void drawCharMap() {
		for (int y = yLen - 1; y >=0 ; y--) { // y 축을 +에서 -로 그리기 위해 감소시킴
			for (int x=0; x < xLen; x++)
				System.out.print(charMap[y][x]);
			System.out.println();
		}
	}
}

public class Ex10_2_3_CircleDrawing {		
	public static void main(String[] args) {

		while(true) {
			int xC = SkScanner.getInt("\n  o 원 중심의 x 좌표 > ");  // 중심 x 좌표 입력
			int yC = SkScanner.getInt("  o 원 중심의 y 좌표 > ");   // 중심 x 좌표 입력
			int radius = SkScanner.getInt("  o 원 반지름 > ");       // 반지름 입력

			Circle circle = new Circle(xC, yC, radius);  // Circle 객체 생성
			circle.draw();	                        // 원을 그림		
		}		
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 원의 중심 좌표와 반지름을 입력하여 개략적인 원을 그린다.
 *      화면 상에서는 가로와 세로 문자비율이 1:1이 아니므로 원이 타원처럼 보인다.
 *   
 *   2) 프로그램을 실행하여 원의 중심 좌표와 반지름을 입력하고 출력 결과를 확인하라.   
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   o 이 프로그램은  Math 클래스와 배열을 활용하여 개략적인 원을 그린다. 이를 참고하여 
 *     sin 그래프를 개략적으로 그리는 프로그램을 작성하라. 
 *     
 *     sin 그래프의 x축은 0도부터 360도의 각도를 나타내며, y축은 -1부터 1까지의 
 *     sin 값을 나타내도록 한다. y축의 값은 20배로 확대하여 그린다.     
 */
