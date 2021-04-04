package ex10_4_java_io_package;

import java.io.*;  // FileInputStream, FileOutputStream 클래스를 사용하기 위해 import

/**
 * [ FileWritingUsingFileOutputStream 클래스 ]: 
 *        java.io.FileInputStream 이용하여 읽은 바이트 데이터를 암호화한 후 
 *        java.io.FileOutputStream 이용하여 file에 바이트 단위로 쓴 후 다시 읽어 출력하기
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
 *                    
 *   o FileOutputStream: 파일에 바이트 데이터 쓰는 클래스
 *     - 상대경로로 지정된 파일에 쓰면 파일은 프로젝트 폴더에 저장
 *     - 그러므로 쓸 파일 "javaEncryption.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장
 *    
 *     - void write(int c) 메소드: 한 바이트 데이터를 객체 생성자에 명시된 파일에 씀
 *     
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                      입력을 위해 할당된 자원들 모두 회수                      
 */

class Ex10_4_2_FileWriting_UsingFileOutputStream {
	public static void main(String[] args) {

		System.out.println("\n  ** java.txt 파일에서 바이트 읽어 1 더한 후 쓰고 다시 읽은 결과 **\n");
		
		// 객체 생성자, read(), write(), close() 메소드는 예외를 발생하므로 try-catch 블록으로 예외 처리
		try {
			// 상대경로로 표시된 java.txt 파일에 대한 FileInputStream 객체 생성
			FileInputStream instrm = new FileInputStream("java.txt"); 

			// 상대경로로 표시된 javaEncoding.txt 파일에 대한 FileOutputStream 객체 생성
			FileOutputStream outstrm = new FileOutputStream("javaEncryption.txt"); 

			int c; // 읽은 바이트를 저장하는 변수는 int로 해야 파일 끝 -1을 검사 가능

			// 입력 스트림 instrm에서 파일 끝까지 데이터 읽어 암호화(1을 더함)하여 outstrm에 씀
			while((c = instrm.read()) != -1) 
				outstrm.write(c + 1);  // 읽은 바이트에 1을 더하여 출력 스트림에 씀
			
			instrm.close();  // 입력 스트림을 닫음
			outstrm.close(); // 출력 스트림을 닫음
					
			// 상대경로로 표시된 javaEncryption.txt 파일에 대한 FileInputStream 객체 생성
			instrm = new FileInputStream("javaEncryption.txt"); 

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
 *   1) 이 프로그램은 "java.txt" 파일을 바이트 단위로 읽은 바이트에 1을 더하여(이는 초보적 암호화 방법)  
 *      "javaEncryption.txt"에 바이트 단위로 출력한다. 
 *      
 *      다시 "javaEncryption.txt"를 바이트 단위로 읽어 화면에 출력한다. 
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 *      - 프로그램 결과를 보면, 입력 데이터의 첫 단어인 "java"의 J는 K, a는 b, v는 w, a는 b로 암호화되어 
 *        출력파일에 저장되었는데, 이들 암호화된 문자는 영문자 순서상 다음 글자임
 *      - 숫자부분인 1995는 2::6으로 암호화됨
 *   
 *   3) 바이트 단위로 읽을 경우 한글 데이터는 깨어짐을 확인하라.
 */
