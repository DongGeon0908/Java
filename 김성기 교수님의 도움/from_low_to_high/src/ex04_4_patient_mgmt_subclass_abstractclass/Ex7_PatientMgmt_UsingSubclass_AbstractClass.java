package ex04_4_patient_mgmt_subclass_abstractclass;

import java.util.Vector;
import java.util.Calendar;  // ��¥�� �ð��� �ٷ�� ���� Ŭ���� import

/*
 * [ Patient_management ]: �ǻ簡 ���� �����Ͽ� ȯ�ڸ� ģ���ϴ� ��Ȳ�� ��Ÿ���� ���α׷�
 * 
 *   o ���α׷��� ��Ÿ��
 *     1) ���� Ŭ������� �����Ͽ� ����(clinic)�� ���� ������ �����ϴ� ���α׷��� �ۼ�
 *     2) ��� Ŭ�������� �ʿ���  output() �޼ҵ带 ���� ClassForPatientMgmt Ŭ������ 
 *        abstract Ŭ������ �ۼ��ϰ�  Clinic, Person Ŭ������ ���� Ŭ������ ����
 *     3) Doctor�� Patient Ŭ������ Person�� ���� Ŭ������ �ۼ�
 *     4) �� Ŭ������ �ʿ��� �޼ҵ带 �ۼ�
 *
 */

class Ex7_PatientMgmt_UsingSubclass_AbstractClass { 
	public static void main(String [] args) {
		Doctor hj = Doctor.thereIsDoctor("����", 35, 19950007, "����");  // ���� 35��, ���� �������� �ǻ� ���� ����
		
		Clinic hjClinic = hj.openClinic("���س���", 19950830, "02)336-1345");   // ������ ���س��� ������ ������
		hjClinic.output("\n  ** ���� ���� �Ϸ� **\n\n  * ���� ������ ���� - ");
		hj.goToWork();
		hj.output("\n  * �ǻ� ���� - ");
		
		Doctor ljm = Doctor.thereIsDoctor("������", 32, 20100002, "����");  // ���� 32��,���� �������� �ǻ� ������ ����
        Clinic ljmClinic = ljm.openClinic("����������", 20100120, "02)3465-1133");   // �������� ���������� ������ ������
        ljmClinic.output("\n  ** ���� ���� �Ϸ� **\n\n  * " + ljm.name + " ������ ���� - ");
		ljm.goToWork();
		ljm.output("\n  * �ǻ� " +  ljm.name + " - ");
		
		Patient sc = Patient.thereIsPatient("��û", 19971203);
		sc.goToClinic(hjClinic);
		hjClinic.doctor.treats(sc,  "����� ���� ����� ��ħ, ���� ����", "Ÿ�̷��� 1�� �Ϸ� 3ȸ 3��ġ ó��", 15);
		hjClinic.doctor.treats(sc,  "����� ���� ������ ������ ��ħ ���ϰ� ���� ����", "�׶�Ǯ�� 1�� �Ϸ� 3ȸ 3��ġ ó��", 15);
		
		sc.goToClinic(ljmClinic);
		ljmClinic.doctor.treats(sc, "����� ���� �������� ���� ����", "�׹�Ǯ�� 2�� �Ϸ� 3ȸ 3��ġ ó�� ", 10);
		ljmClinic.doctor.treats(sc, "���� ���� ��ȭ�Ǿ� ��ħ�� ���� �پ��", "�׹�Ǯ�� 1�� �Ϸ� 3ȸ 3��ġ ó��", 10);
		
		sc.output("\n\n  ** ȯ�� ���� �� �������� **\n\n");	
		
	}
}

/*
 * [ ���α׷��� ���� �� ���� ]
 *
 *   1) �־��� ���α׷��� ���캸�� ���α׷��� ������ �ľ��϶�.
 *
 *   2) �ڽ��� ȯ�ڷ� �����Ͽ� ȯ�������� ���������� �Է��Ͽ� ����� Ȯ���϶�.
 */
