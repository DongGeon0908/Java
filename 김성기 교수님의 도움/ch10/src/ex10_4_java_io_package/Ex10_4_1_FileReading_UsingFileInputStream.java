package ex10_4_java_io_package;

import java.io.*;  // FileInputStream 클래스를 사용하기 위해 import

/**
 * [ FileReadingUsingFileInputStream 클래스 ]: 
 *       java.io.FileInputStream을 이용하여 file에서 바이트 읽기
 *  
 *   o java.io 패키지의 FileInputStream
 *     - 파일에서 바이트 데이터 읽게 하는 클래스
 *     - 읽을 파일이 상대경로로 표시된 파일이면 프로젝트 폴더 또는 아래 폴더에 저장되어야 함
 *     - 그러므로  읽을 파일 "java.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장
 *    
 *     - int read() 메소드: 한 바이트의 데이터를 객체 생성자에 명시된 파일에서 읽어 들이며, 
 *                         더 이상 읽을 바이트가 없으면 -1을 반환
 *                         (바이트를 읽지만 반환값 타입은 int임 꼭 기억할 것)
 *                                                  
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                      입력을 위해 할당된 자원들 모두 회수
 */ 

public class Ex10_4_1_FileReading_UsingFileInputStream {
	public static void main(String[] args) {

		// 현재 작업폴더를 구하여 출력하기
		System.out.println("\n  * 현재 작업 폴더: " + System.getProperty("user.dir"));

		System.out.println("\n  ** java.txt 파일에서 바이트를 읽은 결과 **\n");

		// 객체 생성자, read(), close() 메소드는 예외 발생하므로 try-catch 블록으로 예외 처리
 		try {					
			// 상대경로로 표시된 java.txt 파일에 대한 FileInputStream 객체 생성
			FileInputStream instrm = new FileInputStream("java.txt"); 

			int c; // 읽어들인 바이트를 저장하는 변수는 int로 해야 파일 끝 -1을 검사 가능함

			// 입력 스트림 instrm에서 파일의 끝까지 데이터를 읽어 화면에 출력
			while((c = instrm.read()) != -1) 
				System.out.print((char) c);  // 읽어들인 바이트를 화면에 문자로 출력하기 위해 (char)로 캐스트

			instrm.close();
 		} catch (IOException e) {
 			System.out.print("  ??? 오류: " + e.getMessage());
 		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 상대경로로 표시된 "java.txt" 파일을 바이트 단위로 읽어 화면에 출력한다.
 *   
 *      파일 경로가 상대경로이면 현재 작업폴더인 Eclipse 프로젝트가 저장된 폴더에서 파일을 찾게 되며, 
 *      파일 경로가 절대 경로이면 드라이브의 루트에서 시작하여 주어진 경로에서의 파일을 찾는다.
 *      
 *   2) 객체 생성자 FileInputStream(), read() 메소드, close() 메소드는 IOException 예외를 
 *      발생시키는 메소드이므로 호출할 때 try-catch 블록으로 예외 처리해야 한다.
 *      
 *   3) 프로그램을 실행하여 출력 결과를 확인하라.     
 *   
 *   4) 바이트 단위로 읽을 경우 한글 데이터는 깨어짐을 확인하라.
 *   
 *   
 * [ 실습 과제 ]
 * 
 *   1) 이 프로그램은 상대경로로 표시된 "java.txt" 파일을 읽으며, "java.txt" 파일은 현재 작업폴더인 ch10 폴더에 저장되어 있다.
 *      (ch10 프로젝트의 아래에 보면 java.txt 파일이 저장되어 있음)
 *     
 *      절대경로로 표시된  파일이름을 사용하도록 다름의 작업을 수행하라.
 *   
 *      (1) C 드라이브의 루트 폴더에 files 폴더를 생성하라.
 *      (2) ch10 프로젝트의 아래쪽에 저장되어 있는 "java.txt" 파일을 C 드라이브의 files 폴더에 복사하라.
 *      (3) 절대경로로 표시된 "C:\\files\\java.txt" 파일을 읽을 수 있도록 객체 생성자  FileInputStream()의 
 *          매개변수로 주어진 파일이름을 "C:\\files\\java.txt"로 변경하라.
 *      (4) 변경된 프로그램을 실행하여 결과를 확인하라.
 *      
 *   2) 파일 이름을 잘못된 파일 이름인 "java.text" 로 변경했을 때 발생하는 예외를 확인하라.
 */