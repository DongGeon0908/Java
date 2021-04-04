package ex04_4_patient_mgmt_subclass_abstractclass;

import java.util.Vector;
import java.util.Calendar;  // 날짜와 시간을 다루기 위한 클래스 import

/*
 * [ Patient_management ]: 의사가 병원 개원하여 환자를 친료하는 상황을 나타내는 프로그램
 * 
 *   o 프로그래밍 스타일
 *     1) 여러 클래스들로 구성하여 병원(clinic)의 실제 엄무를 수행하는 프로그램을 작성
 *     2) 모든 클래스에서 필요한  output() 메소드를 갖는 ClassForPatientMgmt 클래스를 
 *        abstract 클래스로 작성하고  Clinic, Person 클래스를 하위 클래스로 선언
 *     3) Doctor와 Patient 클래스를 Person의 하위 클래스로 작성
 *     4) 각 클래스에 필요한 메소드를 작성
 *
 */

class Ex7_PatientMgmt_UsingSubclass_AbstractClass { 
	public static void main(String [] args) {
		Doctor hj = Doctor.thereIsDoctor("허준", 35, 19950007, "내과");  // 나이 35세, 내과 전문의인 의사 허준 있음
		
		Clinic hjClinic = hj.openClinic("허준내과", 19950830, "02)336-1345");   // 허준이 허준내과 병원을 개원함
		hjClinic.output("\n  ** 병원 개원 완료 **\n\n  * 허준 개원한 병원 - ");
		hj.goToWork();
		hj.output("\n  * 의사 허준 - ");
		
		Doctor ljm = Doctor.thereIsDoctor("이제마", 32, 20100002, "내과");  // 나이 32세,내과 전문의인 의사 이제마 있음
        Clinic ljmClinic = ljm.openClinic("이제마내과", 20100120, "02)3465-1133");   // 이제마가 이제마내과 병원을 개원함
        ljmClinic.output("\n  ** 병원 개원 완료 **\n\n  * " + ljm.name + " 개원한 병원 - ");
		ljm.goToWork();
		ljm.output("\n  * 의사 " +  ljm.name + " - ");
		
		Patient sc = Patient.thereIsPatient("심청", 19971203);
		sc.goToClinic(hjClinic);
		hjClinic.doctor.treats(sc,  "감기로 인한 몸살로 기침, 가래 있음", "타이래놀 1알 하루 3회 3일치 처방", 15);
		hjClinic.doctor.treats(sc,  "감기로 인한 몸살이 심해져 기침 심하고 가래 많음", "테라풀루 1알 하루 3회 3일치 처방", 15);
		
		sc.goToClinic(ljmClinic);
		ljmClinic.doctor.treats(sc, "감기로 인한 독감으로 증세 심함", "테미풀루 2알 하루 3회 3일치 처방 ", 10);
		ljmClinic.doctor.treats(sc, "독감 증세 완화되어 기침과 가래 줄어듬", "테미풀루 1알 하루 3회 3일치 처방", 10);
		
		sc.output("\n\n  ** 환자 정보 및 진료정보 **\n\n");	
		
	}
}

/*
 * [ 프로그램의 이해 및 실행 ]
 *
 *   1) 주어진 프로그램을 살펴보고 프로그램의 구조를 파악하라.
 *
 *   2) 자신을 환자로 생각하여 환자정보와 진료정보를 입력하여 결과를 확인하라.
 */
