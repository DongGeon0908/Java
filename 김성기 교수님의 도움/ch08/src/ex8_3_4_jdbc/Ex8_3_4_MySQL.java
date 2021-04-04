package ex8_3_4_jdbc;  

/**
 * [ ex8_3_4_JDBC 패키지 ] : MySQL의 company 데이터베이스와 연동하는 예제 
 * 
 *   o JDBC(Java Database Connectivity)
 *     - Java 프로그램에서 데이터베이스 시스템을 연결하여 SQL 명령과 처리결과를 주고받을 수 있도록 하는 표준적인 방법
 *     - JDBC를 위하여 java.sql 패키지에는 Java 프로그램과 데이터베이스 시스템과의 통신을 위한 인터페이스와 클래스가 선언
 *     
 *     - 흥미로운 것: java.sql 패키지에는 클래스보다 인터페이스가 더 많음
 *     - 이는 JDBC는 Oracle, SQL Server 등 특정 회사의 데이터베이스가 아니라 
 *       모든 데이터베이스와 연결을 할 수 있는 표준적인 방법을 제공하기 위함
 *       
 *     - java.sql 패키지의 인터페이스는 데이터베이스 연동에 필요한 프로토콜로 사용되며, 
 *       이를 이용하여 어느 데이터베이스와도 연동되는 Java 프로그램을 쉽게 작성할 수 있음
 */

import java.sql.*;  // java.sql 패키지를 import

class Ex8_3_4_MySQL {
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");        // MySQL JDBC 드라이버 로딩

			Connection con = DriverManager.getConnection(  // 데이터베이스 연결
					"jdbc:mysql://localhost:3306/company", "root","onlyroot"); 

			Statement stmt = con.createStatement();        // Statement 인터페이스 객체 생성

			ResultSet rs = stmt.executeQuery("select * from department");  // SQL 수행 

			while (rs.next()) {	// 데이터베이스 결과 처리
				System.out.print (rs.getInt("deptNo") + ",  ");  
				System.out.print (rs.getString("deptName") + ",  ");
				System.out.println (rs.getString("location") );
			}

			stmt.close();        // Statement 객체의 종료
			con.close();         // 데이터베이스 연결 종료
		}
		catch(Exception e) {
			System.out.println("\n * SQL 관련 예외 발생함: " + e.getMessage());
		}
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램에서는 try { ... }, catch(Exception e) { ... } 등 새로운 요소들이 사용된다.
 *      이들은 Java에서 예외를 처리하기 위해 제공되는 요소들로서 뒤에서 배운다.
 *     
 *   2) 이 프로그램은 컴파일에서는 오류가 발생하지 않지만 실행 시 오류가 발생하여, 실행도 되지 않는다.
 * 
 *   3) 이 예제 프로그램을 정상적으로 수행하기 위해서는 다음의 작업이 먼저 필요하다.
 *   
 *      (1) MySQL JDBC 드라이버 설치 
 *      (2) MySQL DBMS 설치 
 *      (3) MySQL에 company 데이터베이스 생성
 *      (4) department 테이블 생성 
 *  
 *   4) JDBC를 이용한 데이터베이스 프로그래밍이 많이 요구되어지므로 이에 대해서도 학습해야 한다.  
 */
