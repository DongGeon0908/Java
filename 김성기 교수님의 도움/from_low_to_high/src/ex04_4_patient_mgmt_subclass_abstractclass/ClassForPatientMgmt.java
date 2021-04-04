package ex04_4_patient_mgmt_subclass_abstractclass;

// ClassForPatientMgmt 클래스
//   - 환자 관리를 위한  클래스들인  Clinic, Person, TreatMent의 상위 클래스 
//   - 하위 클래스에서 필요한 객체 출력 메소드인 output() 메소드들을 선언함
//   - abstract 클래스이므로 객체를 생성할 수 없음

abstract class ClassForPatientMgmt {

	// output(): 객체 출력 메소드 - 필드 값을 출력하는 메소드
	void output() {
		System.out.println(this.toString());
	}

	// output(String title)주어진 타이틀을 출력한 후 Person 객체의 모든 필드 값을 출력하는 메소드
	void output(String title) {
		System.out.print(title);  // 타이틀 출력 - 이때에는 줄바꿈을 하지 않음(줄바꿈을 하려면 title에서 끝에 '\n'을 첨부해야 함)
		this.output();
	}
}
