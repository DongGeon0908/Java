package practice12_6_Hospital;

import java.util.*;

/**
 *  * [ 12�� �ǽ����� 6�� ��� ��� �� �Ϻ� - Patient, OutPatient, InPatient ] : 
 * 
 *   o �ܷ� ȯ�ڿ� �Կ� ȯ�ڸ� ġ���ϴ� ������ ��Ȳ�� ������ ����.
 *     - ȯ�ڴ� �ܷ� ȯ�ڿ� �Կ� ȯ�ڷ� ���е� 
 *     - �ܷ� ȯ�ڴ� ����ð��� ���� ������ �����ϸ�, �Կ� ȯ�ڴ� ����ð��� �Կ��ϼ��� ���� ������ ������
 *     - ���������� �ܷ� ȯ�ڿ� �Կ�ȯ�ڸ� ȯ�� ��ü�� ���������� �ٷ����ϸ�, ���� �и��� ȯ�ڷε� �ٷ� �� �־�� ��
 *     
 *   o Ŭ���� ����
 *     - �̷��� ��Ȳ���� ȯ�ڸ� ���� Patient Ŭ����, ���� Ŭ�������� �ܷ�ȯ�� outPatient Ŭ������  
 *       �Կ�ȯ�� inPatient Ŭ������ ����
 *       
 *   o Patient Ŭ����
 *     - ���� Ŭ�����̸�, abstract Ŭ������ �����Ͽ� ��ü �������� ����
 *     - �Ϲ� ȯ�ڸ� ���� �ʵ�� �޼ҵ� ����
 *     - ������ ����ϴ� getPayFee() �޼ҵ带 abstract �޼ҵ�� �ۼ�
 *     - ���� Ŭ������ OutPatient�� InPatient�� ���� Ŭ������ getPayFee() �޼ҵ带 �ݵ�� �����ؾ� �� 
 *     
 *   o OutPatient Ŭ���� 
 *     - �ܷ� ȯ�ڸ� ���� �ʵ�� �޼ҵ带 �߰��� ���� ���� Ŭ����   
 *        
 *   o InPatient Ŭ���� 
 *     - �Կ� ȯ�ڸ� ���� �ʵ�� �޼ҵ带 �߰��� ���� ���� Ŭ����     
 *     
 *   o �������
 *     - �ܷ�ȯ�ڿ� �Կ�ȯ���� ���� ������ ����� ����, ����, �����, ���� ���, ���� �� óġ � ���� �ٸ�
 *     - ���⿡���� ������ ������� �ܷ� ȯ�ڿ� �Կ� ȯ���� ������ ����� 
 */

/*
 *  Patient Ŭ����: �ܷ�ȯ�ڿ� �Կ�ȯ�� �� ���� Ŭ������ �������� ������ ������ abstract Ŭ���� 
 */

abstract class Patient {
	int pno; String name;  int age;  int minutesTreat;  // ȯ�ڹ�ȣ, �̸�, ����, ����ð�

	// ��ü ������
	Patient(int pno, String name, int age) {
		this.pno = pno; this.name = name; this.age = age; 
	}

	// �־��� ����ð�  minutes�� minutesTreat �ʵ忡 �����ϴ� �޼ҵ�
	void takeTreat(int minutes) {  
		this.minutesTreat += minutes;
	} 

	// ������ ����Ͽ� ��ȯ�ϴ� abstract �޼ҵ�	
	//   ���� ������� �ܷ�ȯ�� �Ǵ� �Կ�ȯ�� �� ���� Ŭ������ ��ü�� ���� ���ǹǷ� 
	//   �� Ŭ���������� abstract �޼ҵ�� �ۼ���
	abstract int getPayFee(); 

	// ȯ�� ������ ���ڿ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String toString() {
		return "pno:" + pno + ", name:" + name +
				", age:" + age + ", minutes of treat:" + minutesTreat;
	}

	//  ȯ�� ������ ����ϴ� �޼ҵ�
	void output(String msg) {
		System.out.println(msg + toString());
	}
}

/*
 *  OutPatient Ŭ����: Patient Ŭ������ ����  Ŭ������  abstract �޼ҵ��� getPayFee()�� �����ϴ�  Ŭ���� 
 */
class OutPatient extends Patient { // Patient Ŭ������ ���� Ŭ����
	Date dateTreatment; // (ġ�ᳯ¥) 

	OutPatient(int pno, String name, int age, Date dateTreatment) {
		super(pno, name, age);
		this.dateTreatment = dateTreatment;
	}

	// Patient Ŭ������ abstract �޼ҵ带 ������ �޼ҵ�� ������ ����Ͽ� ��ȯ
	//    �ܷ� ȯ�� ������ = �⺻�����(6000��) + �д������(500��) * ����ð�
	int getPayFee() { 
		return 6000 + minutesTreat * 500; 
	}

	public String toString() {
		return super.toString() + ", date of Treatment:" + dateTreatment + 
				", pay fee:" + getPayFee();
	}
}

/*
 *  InPatient Ŭ����: Patient Ŭ������ ����  Ŭ������ abstract �޼ҵ��� getPayFee()�� �����ϴ�  Ŭ���� 
 */
class InPatient extends Patient { // Patient Ŭ������ ���� Ŭ����

	Date dateHospitalization; // (�Կ���¥)
	int roomNo; 				// (�Կ��� ��ȣ)
	int daysHospitalization; 	// (�Կ��ϼ�) �ʵ带 �߰��� ����

	InPatient(int pno, String name, int age, Date dateHospitalization, int roomNo) {
		super(pno, name, age);
		this.dateHospitalization = dateHospitalization;
		this.roomNo = roomNo;
	}
	

	// ����� ó���ϱ� ���� �־��� days�� daysHospitalization �ʵ忡 �����ϴ� �޼ҵ�
	void leaveHospitalAfter(int days) { 
		daysHospitalization = days;
	}

	// Patient Ŭ������ abstract �޼ҵ带 ������ �޼ҵ�� ������ ����Ͽ� ��ȯ
	//    �Կ�ȯ�� ������ = �⺻�����(1����) + �д������(500��) * ����ð�  + �Կ��ϼ� * 1�� �Կ���(2����)
	int getPayFee() { 
		return 10000 + minutesTreat * 500 + daysHospitalization * 20000 ;
	}

	public String toString() {
		return super.toString() + ", date of hospitalization:" + dateHospitalization +
				", room No:" + roomNo + ", days of Hospitalization:" +
				daysHospitalization + ", pay fee:" + getPayFee();
	}
}
