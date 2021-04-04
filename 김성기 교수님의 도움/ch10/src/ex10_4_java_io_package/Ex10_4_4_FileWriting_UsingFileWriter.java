package ex10_4_java_io_package;

import java.io.*;  // FileInputStream 클래스를 사용하기 위해 import

/**
 * [ FileWritingUsingFileWriter 클래스 ]: 
 *       java.io.FileReader 이용하여 문자 단위로 읽은 데이터를 암호화하고
 *       java.io.FileWriter 이용하여 문자 단위로 파일에 쓴 후 다시 읽기 
 *       file에 문자를 쓰기
 *  
 *   o java.io 패키지의 FileReader
 *     - 파일에서 문자 데이터 읽는 클래스
 *     - 상대경로로 읽을 경우 파일은 프로젝트 폴더 또는 아래 폴더에 저장되어야 함
 *     - 그러므로 읽을 파일 "java.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장
 *    
 *     - int read() 메소드: 한 문자 데이터를 객체 생성자에 명시된 파일에서 읽어 들이며, 
 *                         더 이상 읽을 문자가 없으면 -1을 반환
 *                         (문자를 읽지만 반환값 타입은 int임 꼭 기억할 것)
 *                         
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                      입력을 위해 할당된 자원들이 모두 회수
 *                    
 *   o java.io 패키지의 FileWriter
 *     - 파일에 문자 데이터 쓰는 클래스
 *     - 상대경로로 지정된 파일에 쓰면 파일은 프로젝트 폴더에 저장
 *     - 그러므로 쓸 파일 "javaEncryption.txt" 파일은 프로젝트 ch10이 저장되는 ch10 폴더 아래에 저장
 *    
 *     - void read(int c) 메소드: 한 문자 데이터를 객체 생성자에 명시된 파일에 씀
 *     - close() 메소드: 작업이 끝나 파일을 더 이상 사용하지 않을 경우 호출하며, 
 *                    입력을 위해 할당된 자원들 모두 회수    
 */

class Ex10_4_4_FileWriting_UsingFileWriter {
	public static void main(String[] args) {
		// java.txt 파일의 데이터를  문자 단위로 읽어 암호화하여 javaEncryption.txt 파일에 쓰기
		readEncryptWrite("java.txt", "javaEncryption.txt");
		
		// javaEncryption.txt 파일의 데이터를  문자 단위로 읽어 화면에 출력
		readOutputToScreen("javaEncryption.txt");
	}

	// from 파일의 데이터를 문자 단위로 읽어 암호화하여 to 파일에 쓰는 메소드
	static void readEncryptWrite(String from, String to) {    
		// 객체 생성자와 입출력 메소드는 예외를 발생하므로 try-catch 블록으로 예외 처리
		try {
			// from 파일에 대한 FileReader 객체 생성
			FileReader frdr = new FileReader(from); 

			// to 파일에 대한 FileWriter 객체 생성
			FileWriter fwrt = new FileWriter(to); 

			int c; // 읽은 문자를 저장하는 변수는 int로 해야 파일 끝 -1을 검사 가능

			// 입력 스트림 instrm에서 파일 끝까지 데이터 읽어 암호화하여 outstrm에 씀
			while((c = frdr.read()) != -1) 
				fwrt.write(c + 1);  // 읽은 문자에 1을 더하여 출력 스트림에 씀

			frdr.close();  // 입력 스트림을 닫음
			fwrt.close();  // 출력 스트림을 닫음

		} catch (IOException e) {
			System.out.print("  ??? 오류: " + e.getMessage());
		}
	}
		
	// filename 파일의 데이터를  문자 단위로 읽어 화면에 출력
	static void readOutputToScreen(String filename) {   

		System.out.println("\n  ** java.txt 파일에서 문자 읽어 1 더한 후 쓰고 다시 읽은 결과 **\n");
		
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
 *   1) 이 프로그램은 "java.txt" 파일을 문자 단위로 읽은 문자에 1을 더하여(이는 초보적 암호화 방법)  
 *      "javaEncryption.txt"에 문자 단위로 출력한다. 
 *      
 *       다시 "javaEncryption.txt"를 문자 단위로 읽어 화면에 출력한다. 
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.     
 *   
 *        원문       : Java is an object-oriented programming language developed by Sun Microsystems' James Gosling and other researchers.
 *        변환된 문: Kbwb!jt!bo!pckfdu.psjfoufe!qsphsbnnjoh!mbohvbhf!efwfmpqfe!cz!Tvo!Njdsptztufnt(!Kbnft!Hptmjoh!boe!puifs!sftfbsdifst/
 *   
 *        원문       : 자바는  1995년에  발표되었다.
 *        변환된 문: 작박늕!2::6녅엑!밝푝됙엉닥/
 *      
 *      - 프로그램 결과를 보면, 입력 데이터의 첫 단어인 "java"의 J는 K, a는 b, v는 w, a는 b로 암호화되어 
 *        출력파일에 저장되었는데, 이들 암화된 문자는 영문자 순서상 다음 글자임
 *        
 *      - 숫자부분인 1995는 2::6으로 암호화됨
 *      - 한글부분인 "자바는"의 자는 작, 바는 박, 는은 늕으로 암호화되었는데, 이들 암화된 문자는 한글 순서상 다음 글자임
 *   
 *   3) 문자 단위로 읽을 경우 한글 데이터는 깨어지지 않음을 확인하라.
 */
