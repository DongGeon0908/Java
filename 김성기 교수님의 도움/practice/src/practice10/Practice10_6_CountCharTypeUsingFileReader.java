package practice10;

import java.io.*;  // FileReader 클래스를 사용하기 위해 import

/**
 * [ 10장 실습과제 6 모범 답안 ]: 
 *     FileReader를 이용하여 file에서 문자 읽어 문자 종류별 개수 구하기
 *         
 *   6. 파일에서 문자 읽어 종류별 개수 출력하기
 *       
 *     java.io.FileReader 클래스의 int read() 메소드를 이용하여 
 *     "java.txt" 파일의 데이터를 문자 단위로 읽어 문자의 종류별 개수를 구해 
 *     출력하는 프로그램을 작성하라.
 *       
 *     문자의 종류는 영어 대문자 모음, 영어 대문자 자음, 영어 소문자 모음, 영어 소문자 자음, 
 *     한글 문자, 특수문자, 기타문자 등으로 하며, 변수 c에 저장된 문자가 한글 문자인가를 검사하는 조건은 
 *     (c >= 'ㄱ' && c <= 'ㅎ' || c >= 'ㅏ' && c <= 'ㅣ' || c >= '가' && c <= '힣') 이다. 
 *  
 *   o java.io 패키지의 FileReader
 *     - 파일에서 문자 데이터 읽게하는 클래스
 *     - 상대경로로 읽을 경우 파일은 프로젝트 폴더에 저장되어야 함
 *     - 그러므로 읽을 파일 "java.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장됨
 *    
 *     - int read() 메소드: 한 문자 데이터를 객체 생성자에 명시된 파일에서 읽어 들이며, 
 *                         더 이상 읽을 문자가 없으면 -1을 반환
 *                         (문자를 읽지만 반환값 타입은 int임 꼭 기억할 것)
 *                         
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                      입력을 위해 할당된 자원들이 모두 회수
 */

public class Practice10_6_CountCharTypeUsingFileReader {
	// 문자 종류별 명칭을 저장하는 문자열 배열
	static String[] ctypeNames = { 
			"영대문자 모음", "영대문자 자음", 
			"영소문자 모음", "영소문자 자음",
			"한글 자음", "한글 모음", "한글 글자",
			"숫자 디지트",
			"기타 문자"
	};
	
	public static void main(String[] args) {
		
		// "java.txt" 파일의 데이터 읽어 문자 종류별 개수 출력
		int[] countCharTypes = getCountOfCharTypes("java.txt");
		
		outputCountCharTypes(countCharTypes);
	}

	// filename 파일의 데이터를 문자 단위로 읽어 문자 종류별 개수 출력하는 메소드
	static int[] getCountOfCharTypes(String filename) {   
		
		// 문자 종류별 개수를 저장할 배열변수
		int[] countCharTypes = new int[ctypeNames.length];
		
		// 객체 생성자, read(), close() 메소드는 예외를 발생하므로 try-catch 블록으로 예외 처리
		try {
			// filename 파일에 대한 FileReader 객체 생성하여 frdr에 저장
			FileReader frdr = new FileReader(filename); 

			int c; // 읽은 문자를 저장하는 변수는 int로 해야 파일 끝 -1을 검사 가능

			System.out.println("\n  ** " + filename +"에서 읽은 문자들 **\n");
			
			// FileReader frdr에서 파일의 끝까지 데이터를 읽어 화면에 출력
			while((c = frdr.read()) != -1) {
				int ctype = getCharType((char) c);  // 읽은 문자의 문자 종류 구함
				countCharTypes[ctype]++;            // 해당 문자 종류의 문자 개수 1 증가
				
				System.out.print((char) c);       // 읽은 int 값 c를 문자로 출력하기 위해 캐스트
			}
			frdr.close();  // FileReader frdr을 닫음
		} catch (IOException e) {
			System.out.print("  ??? 오류: " + e.getMessage());
		}
		
		return countCharTypes;
	}

	// 주어진 문자의 문자 종류를 구하여 반환하는 메소드 
	static int getCharType(char c) {
		int ctype;  // 0부터 8까지의 문자종류 나타내는 번호를 저장할 변수

		// 문자종류를 확인하여 ctype에 종류번호 저장
		if (c >= 'A' && c <= 'Z') {           // 'A'부터 'Z'까지는 영대문자
			if (c=='A' || c=='E' || c=='I' || c=='O' || c=='U')  
				ctype = 0;                    //    영대문자 모음의 종류번호: 0
			else
				ctype = 1;                    //    영대문자 자음의 종류번호: 1
		} else if (c >= 'a' && c <= 'z') {    // 'a'부터 'z'까지는 영소문자
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')  
				ctype = 2;                    //    영소문자 모음의 종류번호: 2
			else
				ctype = 3;                    //    영소문자 자음의 종류번호: 3
		} else if (c >= 'ㄱ' && c <= 'ㅎ')     // 'ㄱ'은 한글 자음 중 최소, 'ㅎ'은 최대
			ctype = 4;	                      //     한글 자음의 종류번호: 4
		else if (c >= 'ㅏ' && c <= 'ㅣ')       // 'ㅏ'는 한글 모음 중 최소, 'ㅣ'는 최대
			ctype = 5;	                      //     한글 모음의 종류번호: 6 
		else if (c >= '가' && c <= '힣')       // '가'는 한글 글자 중 최소, '힣'은 최대
			ctype = 6;	                      //     한글 글자의 종류번호: 6  
		else if (c >= '0' && c <= '9')        // '0'부터 '9'까지는 디지트
			ctype = 7;                        //     숫자 디지트의 종류번호: 7 
		else 
			ctype = 8;                        //     기타 문자종류의 번호: 8 
 
		return ctype;
	}	

	// int 배열 countCharTypes에 저장된 문자 종류별 개수를 출력하는 메소드
	static void outputCountCharTypes(int[] countCharTypes) {
		System.out.println("\n\n  ** 읽은 문자들의 종류별 개수 **\n");
		
		for (int i = 0; i < ctypeNames.length; i++)
			System.out.println("  * " + ctypeNames[i] + ": " + countCharTypes[i]);				
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 "java.txt" 파일을 문자 단위로 읽어 화면에  출력한 후 한글 문자의 개수를 출력한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 */
