package ex04_4_patient_mgmt_subclass_abstractclass;

// ClassForPatientMgmt Ŭ����
//   - ȯ�� ������ ����  Ŭ��������  Clinic, Person, TreatMent�� ���� Ŭ���� 
//   - ���� Ŭ�������� �ʿ��� ��ü ��� �޼ҵ��� output() �޼ҵ���� ������
//   - abstract Ŭ�����̹Ƿ� ��ü�� ������ �� ����

abstract class ClassForPatientMgmt {

	// output(): ��ü ��� �޼ҵ� - �ʵ� ���� ����ϴ� �޼ҵ�
	void output() {
		System.out.println(this.toString());
	}

	// output(String title)�־��� Ÿ��Ʋ�� ����� �� Person ��ü�� ��� �ʵ� ���� ����ϴ� �޼ҵ�
	void output(String title) {
		System.out.print(title);  // Ÿ��Ʋ ��� - �̶����� �ٹٲ��� ���� ����(�ٹٲ��� �Ϸ��� title���� ���� '\n'�� ÷���ؾ� ��)
		this.output();
	}
}
