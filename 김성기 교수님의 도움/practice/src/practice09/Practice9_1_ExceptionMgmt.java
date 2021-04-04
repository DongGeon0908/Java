package practice09;

/**
 *  [ 9장 실습과제  1의 모범 답안 ]
 *  
 *    1. 예외 발생 메소드 작성 및 예외저리 메소드 호출
 *    
 *       다음의 클래스를 작성하면서 요구되는 기능을 수행하는 메소드를 예외발생 메소드로 작성하고 
 *       main()에서 이 메소드를 호출하고 예외 처리를 적절히 수행하라. 예외발생 메소드가 객체 메소드이면 
 *       객체를 먼저 생성한다.
 *       
 *      1) UniversityStudent 클래스
 *     
 *         o UniversityStudent 클래스는 필드로 이름, 학과, 학년을 나타내는 String name, String dept, 
 *           int grade를 가짐
 *          
 *         o UniversityStudent 클래스의 객체 생성자는 이름, 학과, 학년이 매개변수로 주어지면 필드 name, dept, 
 *           grade를 초기화
 *          
 *         o int setGrade(int grade) 메소드는 학년 grade가 주어지면 이를 UniversityStudent 클래스의
 *           grade 필드에 저장하고 변경된 학년을 반환
 *          
 *         o setGrade(int grade) 메소드는 grade가 음수 또는 5 초과면 "잘못된 학년" 예외 발생
 *         
 *      2) Menu 클래스
 *     
 *         o Menu 클래스의 필드는 없음
 *        
 *         o static int getMenuNo(String[] menus) 메소드는 String 배열 menus가 주어지면
 *           menus 배열의 원소를 순번과 함께 출력한 후 순번을 입력하여 반환하는 메소드
 *          
 *         o getMenuNo(String[] menus) 메소드는 입력받은 순번이 1보다 작거나 원소 개수보다 크면 
 *           "잘못된 메뉴 선택" 예외 발생
 *           
 *      3) IntArray 클래스
 *    
 *         o IntArray 클래스는 필드로 int[] array, int maxNo, int posToSave를 가짐
 *       
 *         o IntArray 클래스의 객체 생성자는 다음과 같음
 *       
 *            IntArray(int no) {
 *               array = new int[no];		// array 배열변수는 최대 no개 정수 저장 가능
 *               maxNo = no;       		// 정수 저장 가능 개수를 n으로 설정
 *               posToSave = 0;   			// 다음에 저장될 위치를 0으로 설정
 *            }
 *          
 *         o int add(int n) 메소드는 주어진 n을 필드 배열변수 array의 posToSave 위치에 저장하고 posToSave를
 *           1 증가하고 저장된 위치를 반환하는 메소드
 *         
 *         o int add(int n) 메소드는 필드 posToSave의 값이 필드 maxNo과 같으면 "저장 공간 부족으로 저장 불가" 
 *           예외 발생
 */

class UniversitySt {
	String name; String dept; int year;

	UniversitySt(String name, String dept, int year) {
		this.name = name; this.dept = dept; this.year = year;
	}

	int setYear(int year) throws Exception {
		if (year >= 1 && year <= 4) {
			this.year = year;
			return this.year;
		}
		else
			throw new Exception("잘못된 학년 " + year);
	}
}

class Menu {	
	static int getMenuNo(String[] menus) throws Exception { 

		System.out.println("\n"); 

		int menuNo = menus.length;
		for (int i = 1; i <= menuNo; i++)
			System.out.println("  " + i + ") " + menus[i-1]);

		int menu = SkScanner.getInt("\n  o 메뉴 선택 > ");

		if (menu >= 1 && menu <= menuNo)
			return menu;
		else
			throw new Exception("잘못된 메뉴 선택");		
	}
}

class IntArray {
	int[] array; int maxNo; int posToSave;


	IntArray(int no) {
		array = new int[no]; // array 배열변수는 최대 no개 정수 저장 가능
		maxNo = no;        // 정수 저장 가능 개수를 n으로 설정
		posToSave = 0;     //  다음에 저장될 위치를 0으로 설정
	}

	int add(int n) throws Exception {
		if (posToSave < maxNo) {
			array[posToSave++] = n;
			return posToSave -1;
		}
		else 
			throw new Exception("저장 공간 부족으로 저장 불가");
	}
}

class Practice9_1_ExceptionMgmt {
	public static void main(String[] args) {
		System.out.println("\n  ** 학년 저장 및 출력 **\n");

		UniversitySt st = new UniversitySt("홍길동", "컴퓨터학과", 2);

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * 변경된 학년 = " + st.setYear(i));
			}
		catch(Exception e) {
			System.out.println("  * 오류: " + e.getMessage());
		}


		System.out.println("\n  ** 메뉴 출력 및 입력 **\n");

		String[] menus = {"계좌 생성", "입금", "출금", "이체", "종료" };

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * 선택된 메뉴 = " + Menu.getMenuNo(menus));
			}
		    catch(Exception e) {
			    System.out.println("  * 오류: " + e.getMessage());
		    }

		System.out.println("\n  ** 원소 저장 및 저장 위치 출력 **\n");

		IntArray ia  = new IntArray(4);

		for (int i = 1; i <= 5; i++)
			try {
				System.out.println("  * " + i + " 저장된 위치 = " + ia.add(i) );
			}
		catch(Exception e) {
			System.out.println("  * 오류: " + e.getMessage());
		}
	}
}
