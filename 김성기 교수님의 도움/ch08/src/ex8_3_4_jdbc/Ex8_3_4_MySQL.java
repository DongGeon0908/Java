package ex8_3_4_jdbc;  

/**
 * [ ex8_3_4_JDBC ��Ű�� ] : MySQL�� company �����ͺ��̽��� �����ϴ� ���� 
 * 
 *   o JDBC(Java Database Connectivity)
 *     - Java ���α׷����� �����ͺ��̽� �ý����� �����Ͽ� SQL ��ɰ� ó������� �ְ���� �� �ֵ��� �ϴ� ǥ������ ���
 *     - JDBC�� ���Ͽ� java.sql ��Ű������ Java ���α׷��� �����ͺ��̽� �ý��۰��� ����� ���� �������̽��� Ŭ������ ����
 *     
 *     - ��̷ο� ��: java.sql ��Ű������ Ŭ�������� �������̽��� �� ����
 *     - �̴� JDBC�� Oracle, SQL Server �� Ư�� ȸ���� �����ͺ��̽��� �ƴ϶� 
 *       ��� �����ͺ��̽��� ������ �� �� �ִ� ǥ������ ����� �����ϱ� ����
 *       
 *     - java.sql ��Ű���� �������̽��� �����ͺ��̽� ������ �ʿ��� �������ݷ� ���Ǹ�, 
 *       �̸� �̿��Ͽ� ��� �����ͺ��̽��͵� �����Ǵ� Java ���α׷��� ���� �ۼ��� �� ����
 */

import java.sql.*;  // java.sql ��Ű���� import

class Ex8_3_4_MySQL {
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");        // MySQL JDBC ����̹� �ε�

			Connection con = DriverManager.getConnection(  // �����ͺ��̽� ����
					"jdbc:mysql://localhost:3306/company", "root","onlyroot"); 

			Statement stmt = con.createStatement();        // Statement �������̽� ��ü ����

			ResultSet rs = stmt.executeQuery("select * from department");  // SQL ���� 

			while (rs.next()) {	// �����ͺ��̽� ��� ó��
				System.out.print (rs.getInt("deptNo") + ",  ");  
				System.out.print (rs.getString("deptName") + ",  ");
				System.out.println (rs.getString("location") );
			}

			stmt.close();        // Statement ��ü�� ����
			con.close();         // �����ͺ��̽� ���� ����
		}
		catch(Exception e) {
			System.out.println("\n * SQL ���� ���� �߻���: " + e.getMessage());
		}
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷������� try { ... }, catch(Exception e) { ... } �� ���ο� ��ҵ��� ���ȴ�.
 *      �̵��� Java���� ���ܸ� ó���ϱ� ���� �����Ǵ� ��ҵ�μ� �ڿ��� ����.
 *     
 *   2) �� ���α׷��� �����Ͽ����� ������ �߻����� ������ ���� �� ������ �߻��Ͽ�, ���൵ ���� �ʴ´�.
 * 
 *   3) �� ���� ���α׷��� ���������� �����ϱ� ���ؼ��� ������ �۾��� ���� �ʿ��ϴ�.
 *   
 *      (1) MySQL JDBC ����̹� ��ġ 
 *      (2) MySQL DBMS ��ġ 
 *      (3) MySQL�� company �����ͺ��̽� ����
 *      (4) department ���̺� ���� 
 *  
 *   4) JDBC�� �̿��� �����ͺ��̽� ���α׷����� ���� �䱸�Ǿ����Ƿ� �̿� ���ؼ��� �н��ؾ� �Ѵ�.  
 */
