package ex10_4_java_io_package;

import java.io.*;  // FileReader 클래스를 사용하기 위해 import

/**
 * [ FileReadingUsingFileReader 클래스 ]: 
 *       java.io.FileReader를 이용하여 file에서 문자 읽기
 *  
 *   o java.io 패키지의 FileReader
 *     - 파일에서 문자 데이터 읽게 하는 클래스
 *     - 상대경로로 읽을 경우 파일은 프로젝트 폴더 또는 아래 폴더에 저장되어야 함
 *     - 그러므로 읽을 파일 "java.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장
 *    
 *     - int read() 메소드: 한 문자 데이터를 객체 생성자에 명시된 파일에서 읽어 들이며, 
 *                         더 이상 읽을 문자가 없으면 -1을 반환
 *                         (문자를 읽지만 반환값 타입은 int임 꼭 기억할 것)
 *                         
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                      입력을 위해 할당된 자원들 모두 회수
 */

public class Ex10_4_3_FileReading_UsingFileReader {
	public static void main(String[] args) {
		// java.txt 파일의 데이터를  문자 단위로 읽어 화면에 출력
		readOutputToScreen("java.txt");
	}

	// filename 파일의 데이터를  문자 단위로 읽어 화면에 출력
	static void readOutputToScreen(String filename) {   
		
		System.out.println("\n  ** java.txt 파일에서 문자 읽은 결과 **\n");

		// 객체 생성자, read(), close() 메소드는 예외를 발생하므로 try-catch 블록으로 예외 처리
		try {
			// filename 파일에 대한 FileReader 객체 생성하여 frdr에 저장
			FileReader frdr = new FileReader(filename); 

			int c; // 읽어들인 문자를 저장하는 변수는 int로 해야 파일 끝 -1을 검사 가능

			// FileReader frdr에서 파일의 끝까지 데이터를 읽어 화면에 출력
			while((c = frdr.read()) != -1) 
				System.out.print((char) c);  // 읽은 문자를 화면에 문자로 출력하기 위해(char)로 캐스트(캐스트 않으면 정수 출력)

			frdr.close();  // FileReader frdr을 닫음
		} catch (IOException e) {
			System.out.print("  ??? 오류: " + e.getMessage());
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 상대경로로 표시된 "java.txt" 파일을 문자 단위로 읽어 화면에 출력한다.
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 *   
 *   3) 문자 단위로 읽을 경우 한글 데이터는 정상적으로 읽어짐을 확인하라.
 */
