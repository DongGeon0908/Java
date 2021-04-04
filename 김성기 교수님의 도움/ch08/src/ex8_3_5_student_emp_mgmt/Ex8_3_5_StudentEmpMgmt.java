package ex8_3_5_student_emp_mgmt;

/**
 * [ EmployeeIF 인터페이스와 이를 구현하는 StudentEmp, UniversityStudentEmp 클래스 작성하기 ]
 * 
 *   o 주어진 상황: "사원을 나타내는 인터페이스인 EmployeeIF 인터페이스와 이를 구현하는 
 *                 StudentEmp, UniversityStudentEmp 클래스를 다음을 참고하여 작성하라."
 * 
 *      - 학생을 나타내는 Student 클래스는 Person 클래스의 하위 클래스
 *      - 대학생을 나타내는 UniversityStudent 클래스는 Student 클래스의 하위 클래스
 *      
 *      - 그런데 학생 중에서 사원으로 일하면서 공부하는 학생을 나타내기 위해 Student와 UniversityStudent의 하위 클래스를
 *        각각 작성할 경우 이들 하위 클래스들의 객체는 사원이라는 통합된 객체로서 다룰 수 없게 됨
 *        
 *      - 사원으로 일하는 학생들을 통합적으로 관리하기 위해서 사원을 나타내는 EmployeeIF 인터페이스를 작성하고, 
 *        이를 구현하는 StudentEmp, UniversityStudentEmp 클래스를 작성하면 됨 
 *     
 *   o 수행해야 할 과제 
 *   
 *     1) 작성할 패키지인 ex8_3_5_student_emp_mgmt 패키지를 생성하라.
 *     
 *     2) Person, Student, UniversityStudent 클래스를 작성하라.
 *           
 *     3) 사원을 나타내는 EmployeeIF 인터페이스는 다음의 abstract 메소드를 갖도록 작성하라.
 *     
 *          public void setCompanyName(String name);  // 근무 회사명을 저장하는 메소드
 *          public String getCompanyName();           // 근무 회사명을 반환하는 메소드  
 *          public void setEmpType(Strung empType);   // 사원유형을 저장하는 메소드
 *          public String getEmpType();               // 사원유형을 반환하는 메소드
 *         
 *     4) EmployeeIF 인터페이스를 구현하는 StudentEmp, UniversityStudentEmp 클래스를 작성하라. 
 *     
 *        - 이들 클래스의 객체 생성자는 근무 회사명과 사원유형을 매개변수로 추가로 가져야 한다.
 *        - 학생 정보, 회사명, 사원 유형을  문자열로 구성하여 반환하는 toString() 메소드를 작성해야 한다.
 *        - toString() 메소드를 이용하여 객체 정보를 출력하는 output() 메소드를  작성해야 한다.
 *        
 *     5) StudentEmpMgmt 클래스의 main() 메소드에서 StudentEmp, UniversityStudentEmp 클래스의 객체 1개씩을 생성하고
 *        이를 Student 클래스의 배열변수 students의 원소로 저장하고 객체를 출력하라.
 *        
 *        (이를 위해서 배열변수는 Student[] students = new Student[20]; 으로 선언함)
 *        
 *     6) 배열변수 students에 저장된 원소들을 EmployeeIF 인터페이스의 배열변수 studentEmps의 원소로 저장하고 객체의 
 *        근무 회사명 사원유형을 출력하라. 
 *        
 *        (이를 위해서 배열변수는 EmployeeIF[] studentEmps = new EmployeeIF[20]; 으로
 *        선언하고  배열변수 students의 원소들을 EmployeeIF 타입으로 다운캐스팅하여 studentEmps의 원소로 저장함)
 *        
 *     7) studentEmps의 원소들에 대해 setCompanyName(), setEmpType() 메소드 호출하여 근무 회사명과 사원유형을 변경하라.
 *     
 *     8) 배열변수 students에 저장된 객체를 출력하여 근무 회사이름과 사원유형이 변경된 사항을 확인하라.
 */   

interface EmployeeIF {
	public void setCompanyName(String name);   // 근무 회사명을 등록하는 메소드
	public String getCompanyName();            // 근무 회사명을 반환하는 메소드  

	public void setEmpType(String empType);    // 사원유형을 저장하는 메소드
	public String getEmpType();                // 사원유형을 반환하는 메소드
}

// StudentEmp: Student 클래스를 확장하면서 EmployeeIF를 구현하는 클래스
class StudentEmp extends Student implements EmployeeIF {
	String companyName, empType;

	// 이름, 나이, 학교명, 학년, 회사명, 사원유형이 주어지면 필드에 저장하는 객체 생성자
	StudentEmp(String name, int age, String schoolname, int grade, String companyName, String empType) {
		super(name, age, schoolname, grade);  // 상위 클래스 객체 생성자 이용하여 초기화
		this.companyName = companyName;       // 회사명 저장
		this.empType = empType;               // 사원유형 저장
	}
		
	public void setCompanyName(String name) { // 근무 회사명을 등록하는 메소드
		this.companyName = name;

	}

	public String getCompanyName() {          // 근무 회사명을 반환하는 메소드
		return companyName;
	}

	public void setEmpType(String empType) {  // 급여를 저장하는 메소드
		this.empType = empType;
	}

	public String getEmpType() {              // 급여를 반환하는 메소드
		return empType;
	}	
	
	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩 
	//   상속필드인 name, age, cuurentLocation, schoolname, grade에 대해 필드들의 문자열을 구성하기 위해  
	//   super.toString()을 이용하여 상위 클래스의 toString() 메소드 호출
	public String toString() {
		return  super.toString() + 
				", 회사명:" + this.companyName + ", 사원유형:" + this.empType;  
	}

	// 객체의 필드들을 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩
	void output() {
		System.out.println("\n  * 학생 사원 - " + this.toString());
	}
}

// UniversityStudentEmp: UniversityStudent 클래스를 확장하면서 EmployeeIF를 구현하는 클래스
class UniversityStudentEmp extends UniversityStudent implements EmployeeIF {
	String companyName, empType;

	//이름, 나이, 학교명, 학년, 학번, 학과, 회사명, 사원유형이 주어지면 필드에 저장하는 객체 생성자
	UniversityStudentEmp(String name, int age, String schoolname, int grade, 
			          int sno, String dept, String companyName, String empType) {
		super(name, age, schoolname, grade, sno, dept);  // 상위 클래스 객체 생성자 이용하여 초기화
		this.companyName = companyName;                  // 회사명 저장
		this.empType = empType;                          // 사원유형 저장
	}
		
	public void setCompanyName(String name) { // 근무 회사명을 등록하는 메소드
		this.companyName = name;
	}

	public String getCompanyName() {          // 근무 회사명을 반환하는 메소드
		return companyName;
	}

	public void setEmpType(String empType) {  // 급여를 저장하는 메소드
		this.empType = empType;
	}

	public String getEmpType() {              // 급여를 반환하는 메소드
		return empType;
	}	
	
	// toString(): 객체의 필드들을 문자열로 구성하여 반환하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩
	//   상속필드에 대해 필드들의 문자열을 구성하기 위해  
	//   super.toString()을 이용하여 상위 클래스의 toString() 메소드 호출
	public String toString() {
		return  super.toString() + 
				", 회사명:" + this.companyName + ", 사원유형:" + this.empType;  
	}

	// 객체의 필드들을 출력하는 메소드
	//   이 메소드는 Person 클래스의 메소드를 오버라이딩
	void output() {
		System.out.println("\n  * 대학생 사원 - " + this.toString());
	}
}

public class Ex8_3_5_StudentEmpMgmt {
	public static void main(String[] args) {

		// 학생 관리를 위한 Students 배열
		Student[] students = new Student[20];			// 20명의 학생사원을 저장하는 배열변수

		// 한국대학교 4학년 학생인 23세 심청은 한국모바일 시간제사원 사원임
		students[0] = new StudentEmp("심청", 23, "한국대학교", 4, "한국모바일", "시간제사원");

		// 한국대학교 컴퓨터공학과 3학년 대학생인 21세 김철수는 한국전자 인턴 사원임
		students[1] = new UniversityStudentEmp("김철수", 21, "한국대학교",3, 201611001, "컴퓨터공학", "한국전자", "인턴");

		System.out.println("\n\n  ** 초기 학생사원 리스트 **");
		students[0].output();
		students[1].output();
		
		// 학생사원 관리를 위한 studentemps 배열
		EmployeeIF[] studentemps = new EmployeeIF[20];  // 20명의 사원을 저장하는 배열변수
		
		studentemps[0] = (EmployeeIF) students[0];
		studentemps[1] = (EmployeeIF) students[1];
		
		// 한국대학교 심청이 한국컴퓨터로 회사 옮김
		studentemps[0].setCompanyName("한국컴퓨터");
		
		// 한국대학교 홍길동이 인턴에서 시간제사원으로 변경
		studentemps[1].setEmpType("시간제사원");		
		
		System.out.println("\n\n  ** 사원 정보 변경 후 학생사원 리스트 **");
		students[0].output();
		students[1].output();
	}    
}

