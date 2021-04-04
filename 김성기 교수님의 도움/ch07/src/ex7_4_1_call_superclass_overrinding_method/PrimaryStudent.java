package ex7_4_1_call_superclass_overrinding_method;

// Student 클래스의 하위 클래스인 초등학생을 나타내는 PrimaryStudent 클래스
class PrimaryStudent extends Student {
	int classNo;    // 반
	int noInClass;  // 반에서의 번호

	// 초등학생 정보가 주어지면 필드에 저장하는 객체 생성자
	PrimaryStudent(String name, int age, String schoolname, int grade, int classNo, int noInClass) {
		this.name = name;  this.age = age;                       
		this.schoolname = schoolname;       this.grade = grade;
		this.classNo = classNo;  this.noInClass = noInClass;
	}
	
	// output(): 수신자 객체의 모든 필드 값을 출력하는 메소드
	void output() {
		System.out.println("\n  * 초등학생-  이름:" + this.name + ", 나이:" + this.age + 
				", 현위치:" + this.currentLocation +
				", 학교명:" + this.schoolname + ", 학년:" + this.grade + 
				", 반:" + this.classNo + ", 번호:" + this.noInClass);
	}
}