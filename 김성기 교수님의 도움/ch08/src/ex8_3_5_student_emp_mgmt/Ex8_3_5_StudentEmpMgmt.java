package ex8_3_5_student_emp_mgmt;

/**
 * [ EmployeeIF �������̽��� �̸� �����ϴ� StudentEmp, UniversityStudentEmp Ŭ���� �ۼ��ϱ� ]
 * 
 *   o �־��� ��Ȳ: "����� ��Ÿ���� �������̽��� EmployeeIF �������̽��� �̸� �����ϴ� 
 *                 StudentEmp, UniversityStudentEmp Ŭ������ ������ �����Ͽ� �ۼ��϶�."
 * 
 *      - �л��� ��Ÿ���� Student Ŭ������ Person Ŭ������ ���� Ŭ����
 *      - ���л��� ��Ÿ���� UniversityStudent Ŭ������ Student Ŭ������ ���� Ŭ����
 *      
 *      - �׷��� �л� �߿��� ������� ���ϸ鼭 �����ϴ� �л��� ��Ÿ���� ���� Student�� UniversityStudent�� ���� Ŭ������
 *        ���� �ۼ��� ��� �̵� ���� Ŭ�������� ��ü�� ����̶�� ���յ� ��ü�μ� �ٷ� �� ���� ��
 *        
 *      - ������� ���ϴ� �л����� ���������� �����ϱ� ���ؼ� ����� ��Ÿ���� EmployeeIF �������̽��� �ۼ��ϰ�, 
 *        �̸� �����ϴ� StudentEmp, UniversityStudentEmp Ŭ������ �ۼ��ϸ� �� 
 *     
 *   o �����ؾ� �� ���� 
 *   
 *     1) �ۼ��� ��Ű���� ex8_3_5_student_emp_mgmt ��Ű���� �����϶�.
 *     
 *     2) Person, Student, UniversityStudent Ŭ������ �ۼ��϶�.
 *           
 *     3) ����� ��Ÿ���� EmployeeIF �������̽��� ������ abstract �޼ҵ带 ������ �ۼ��϶�.
 *     
 *          public void setCompanyName(String name);  // �ٹ� ȸ����� �����ϴ� �޼ҵ�
 *          public String getCompanyName();           // �ٹ� ȸ����� ��ȯ�ϴ� �޼ҵ�  
 *          public void setEmpType(Strung empType);   // ��������� �����ϴ� �޼ҵ�
 *          public String getEmpType();               // ��������� ��ȯ�ϴ� �޼ҵ�
 *         
 *     4) EmployeeIF �������̽��� �����ϴ� StudentEmp, UniversityStudentEmp Ŭ������ �ۼ��϶�. 
 *     
 *        - �̵� Ŭ������ ��ü �����ڴ� �ٹ� ȸ���� ��������� �Ű������� �߰��� ������ �Ѵ�.
 *        - �л� ����, ȸ���, ��� ������  ���ڿ��� �����Ͽ� ��ȯ�ϴ� toString() �޼ҵ带 �ۼ��ؾ� �Ѵ�.
 *        - toString() �޼ҵ带 �̿��Ͽ� ��ü ������ ����ϴ� output() �޼ҵ带  �ۼ��ؾ� �Ѵ�.
 *        
 *     5) StudentEmpMgmt Ŭ������ main() �޼ҵ忡�� StudentEmp, UniversityStudentEmp Ŭ������ ��ü 1������ �����ϰ�
 *        �̸� Student Ŭ������ �迭���� students�� ���ҷ� �����ϰ� ��ü�� ����϶�.
 *        
 *        (�̸� ���ؼ� �迭������ Student[] students = new Student[20]; ���� ������)
 *        
 *     6) �迭���� students�� ����� ���ҵ��� EmployeeIF �������̽��� �迭���� studentEmps�� ���ҷ� �����ϰ� ��ü�� 
 *        �ٹ� ȸ��� ��������� ����϶�. 
 *        
 *        (�̸� ���ؼ� �迭������ EmployeeIF[] studentEmps = new EmployeeIF[20]; ����
 *        �����ϰ�  �迭���� students�� ���ҵ��� EmployeeIF Ÿ������ �ٿ�ĳ�����Ͽ� studentEmps�� ���ҷ� ������)
 *        
 *     7) studentEmps�� ���ҵ鿡 ���� setCompanyName(), setEmpType() �޼ҵ� ȣ���Ͽ� �ٹ� ȸ���� ��������� �����϶�.
 *     
 *     8) �迭���� students�� ����� ��ü�� ����Ͽ� �ٹ� ȸ���̸��� ��������� ����� ������ Ȯ���϶�.
 */   

interface EmployeeIF {
	public void setCompanyName(String name);   // �ٹ� ȸ����� ����ϴ� �޼ҵ�
	public String getCompanyName();            // �ٹ� ȸ����� ��ȯ�ϴ� �޼ҵ�  

	public void setEmpType(String empType);    // ��������� �����ϴ� �޼ҵ�
	public String getEmpType();                // ��������� ��ȯ�ϴ� �޼ҵ�
}

// StudentEmp: Student Ŭ������ Ȯ���ϸ鼭 EmployeeIF�� �����ϴ� Ŭ����
class StudentEmp extends Student implements EmployeeIF {
	String companyName, empType;

	// �̸�, ����, �б���, �г�, ȸ���, ��������� �־����� �ʵ忡 �����ϴ� ��ü ������
	StudentEmp(String name, int age, String schoolname, int grade, String companyName, String empType) {
		super(name, age, schoolname, grade);  // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.companyName = companyName;       // ȸ��� ����
		this.empType = empType;               // ������� ����
	}
		
	public void setCompanyName(String name) { // �ٹ� ȸ����� ����ϴ� �޼ҵ�
		this.companyName = name;

	}

	public String getCompanyName() {          // �ٹ� ȸ����� ��ȯ�ϴ� �޼ҵ�
		return companyName;
	}

	public void setEmpType(String empType) {  // �޿��� �����ϴ� �޼ҵ�
		this.empType = empType;
	}

	public String getEmpType() {              // �޿��� ��ȯ�ϴ� �޼ҵ�
		return empType;
	}	
	
	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵� 
	//   ����ʵ��� name, age, cuurentLocation, schoolname, grade�� ���� �ʵ���� ���ڿ��� �����ϱ� ����  
	//   super.toString()�� �̿��Ͽ� ���� Ŭ������ toString() �޼ҵ� ȣ��
	public String toString() {
		return  super.toString() + 
				", ȸ���:" + this.companyName + ", �������:" + this.empType;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�
	void output() {
		System.out.println("\n  * �л� ��� - " + this.toString());
	}
}

// UniversityStudentEmp: UniversityStudent Ŭ������ Ȯ���ϸ鼭 EmployeeIF�� �����ϴ� Ŭ����
class UniversityStudentEmp extends UniversityStudent implements EmployeeIF {
	String companyName, empType;

	//�̸�, ����, �б���, �г�, �й�, �а�, ȸ���, ��������� �־����� �ʵ忡 �����ϴ� ��ü ������
	UniversityStudentEmp(String name, int age, String schoolname, int grade, 
			          int sno, String dept, String companyName, String empType) {
		super(name, age, schoolname, grade, sno, dept);  // ���� Ŭ���� ��ü ������ �̿��Ͽ� �ʱ�ȭ
		this.companyName = companyName;                  // ȸ��� ����
		this.empType = empType;                          // ������� ����
	}
		
	public void setCompanyName(String name) { // �ٹ� ȸ����� ����ϴ� �޼ҵ�
		this.companyName = name;
	}

	public String getCompanyName() {          // �ٹ� ȸ����� ��ȯ�ϴ� �޼ҵ�
		return companyName;
	}

	public void setEmpType(String empType) {  // �޿��� �����ϴ� �޼ҵ�
		this.empType = empType;
	}

	public String getEmpType() {              // �޿��� ��ȯ�ϴ� �޼ҵ�
		return empType;
	}	
	
	// toString(): ��ü�� �ʵ���� ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�
	//   ����ʵ忡 ���� �ʵ���� ���ڿ��� �����ϱ� ����  
	//   super.toString()�� �̿��Ͽ� ���� Ŭ������ toString() �޼ҵ� ȣ��
	public String toString() {
		return  super.toString() + 
				", ȸ���:" + this.companyName + ", �������:" + this.empType;  
	}

	// ��ü�� �ʵ���� ����ϴ� �޼ҵ�
	//   �� �޼ҵ�� Person Ŭ������ �޼ҵ带 �������̵�
	void output() {
		System.out.println("\n  * ���л� ��� - " + this.toString());
	}
}

public class Ex8_3_5_StudentEmpMgmt {
	public static void main(String[] args) {

		// �л� ������ ���� Students �迭
		Student[] students = new Student[20];			// 20���� �л������ �����ϴ� �迭����

		// �ѱ����б� 4�г� �л��� 23�� ��û�� �ѱ������ �ð������ �����
		students[0] = new StudentEmp("��û", 23, "�ѱ����б�", 4, "�ѱ������", "�ð������");

		// �ѱ����б� ��ǻ�Ͱ��а� 3�г� ���л��� 21�� ��ö���� �ѱ����� ���� �����
		students[1] = new UniversityStudentEmp("��ö��", 21, "�ѱ����б�",3, 201611001, "��ǻ�Ͱ���", "�ѱ�����", "����");

		System.out.println("\n\n  ** �ʱ� �л���� ����Ʈ **");
		students[0].output();
		students[1].output();
		
		// �л���� ������ ���� studentemps �迭
		EmployeeIF[] studentemps = new EmployeeIF[20];  // 20���� ����� �����ϴ� �迭����
		
		studentemps[0] = (EmployeeIF) students[0];
		studentemps[1] = (EmployeeIF) students[1];
		
		// �ѱ����б� ��û�� �ѱ���ǻ�ͷ� ȸ�� �ű�
		studentemps[0].setCompanyName("�ѱ���ǻ��");
		
		// �ѱ����б� ȫ�浿�� ���Ͽ��� �ð���������� ����
		studentemps[1].setEmpType("�ð������");		
		
		System.out.println("\n\n  ** ��� ���� ���� �� �л���� ����Ʈ **");
		students[0].output();
		students[1].output();
	}    
}

