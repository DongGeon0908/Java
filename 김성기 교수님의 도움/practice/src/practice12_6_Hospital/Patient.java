package practice12_6_Hospital;

import java.util.*;

/**
 *  * [ 12장 실습문제 6번 모범 답안 중 일부 - Patient, OutPatient, InPatient ] : 
 * 
 *   o 외래 환자와 입원 환자를 치료하는 병원의 상황은 다음과 같다.
 *     - 환자는 외래 환자와 입원 환자로 구분됨 
 *     - 외래 환자는 진료시간에 의해 병원비를 지불하며, 입원 환자는 진료시간과 입원일수에 의해 병원비를 지불함
 *     - 병원에서는 외래 환자와 입원환자를 환자 전체의 관점에서도 다루어야하며, 서로 분리된 환자로도 다룰 수 있어야 함
 *     
 *   o 클래스 구성
 *     - 이러한 상황에서 환자를 위한 Patient 클래스, 하위 클래스들인 외래환자 outPatient 클래스와  
 *       입원환자 inPatient 클래스로 구성
 *       
 *   o Patient 클래스
 *     - 상위 클래스이며, abstract 클래스로 구성하여 객체 생성하지 않음
 *     - 일반 환자를 위한 필드와 메소드 선언
 *     - 병원비를 계산하는 getPayFee() 메소드를 abstract 메소드로 작성
 *     - 하위 클래스인 OutPatient와 InPatient는 상위 클래스의 getPayFee() 메소드를 반드시 구현해야 함 
 *     
 *   o OutPatient 클래스 
 *     - 외래 환자를 위한 필드와 메소드를 추가로 갖는 하위 클래스   
 *        
 *   o InPatient 클래스 
 *     - 입원 환자를 위한 필드와 메소드를 추가로 갖는 하위 클래스     
 *     
 *   o 참고사항
 *     - 외래환자와 입원환자의 실제 병원비 계산은 초진, 재진, 진료과, 병실 등급, 투약 및 처치 등에 따라 다름
 *     - 여기에서는 간단한 방법으로 외래 환자와 입원 환자의 병원비를 계산함 
 */

/*
 *  Patient 클래스: 외래환자와 입원환자 등 하위 클래스의 공통적인 정보를 가지는 abstract 클래스 
 */

abstract class Patient {
	int pno; String name;  int age;  int minutesTreat;  // 환자번호, 이름, 나이, 진료시간

	// 객체 생성자
	Patient(int pno, String name, int age) {
		this.pno = pno; this.name = name; this.age = age; 
	}

	// 주어진 진료시간  minutes를 minutesTreat 필드에 누적하는 메소드
	void takeTreat(int minutes) {  
		this.minutesTreat += minutes;
	} 

	// 병원비를 계산하여 반환하는 abstract 메소드	
	//   실제 병원비는 외래환자 또는 입원환자 등 하위 클래스의 객체에 대해 계산되므로 
	//   이 클래스에서는 abstract 메소드로 작성함
	abstract int getPayFee(); 

	// 환자 정보를 문자열로 구성하여 반환하는 메소드
	public String toString() {
		return "pno:" + pno + ", name:" + name +
				", age:" + age + ", minutes of treat:" + minutesTreat;
	}

	//  환자 정보를 출력하는 메소드
	void output(String msg) {
		System.out.println(msg + toString());
	}
}

/*
 *  OutPatient 클래스: Patient 클래스의 하위  클래스로  abstract 메소드인 getPayFee()를 구현하는  클래스 
 */
class OutPatient extends Patient { // Patient 클래스의 하위 클래스
	Date dateTreatment; // (치료날짜) 

	OutPatient(int pno, String name, int age, Date dateTreatment) {
		super(pno, name, age);
		this.dateTreatment = dateTreatment;
	}

	// Patient 클래스의 abstract 메소드를 구현한 메소드로 병원비를 계산하여 반환
	//    외래 환자 병원비 = 기본진료비(6000원) + 분당진료비(500원) * 진료시간
	int getPayFee() { 
		return 6000 + minutesTreat * 500; 
	}

	public String toString() {
		return super.toString() + ", date of Treatment:" + dateTreatment + 
				", pay fee:" + getPayFee();
	}
}

/*
 *  InPatient 클래스: Patient 클래스의 하위  클래스로 abstract 메소드인 getPayFee()를 구현하는  클래스 
 */
class InPatient extends Patient { // Patient 클래스의 하위 클래스

	Date dateHospitalization; // (입원날짜)
	int roomNo; 				// (입원실 번호)
	int daysHospitalization; 	// (입원일수) 필드를 추가로 가짐

	InPatient(int pno, String name, int age, Date dateHospitalization, int roomNo) {
		super(pno, name, age);
		this.dateHospitalization = dateHospitalization;
		this.roomNo = roomNo;
	}
	

	// 퇴원을 처리하기 위해 주어진 days를 daysHospitalization 필드에 저장하는 메소드
	void leaveHospitalAfter(int days) { 
		daysHospitalization = days;
	}

	// Patient 클래스의 abstract 메소드를 구현한 메소드로 병원비를 계산하여 반환
	//    입원환자 병원비 = 기본진료비(1만원) + 분당진료비(500원) * 진료시간  + 입원일수 * 1일 입원료(2만원)
	int getPayFee() { 
		return 10000 + minutesTreat * 500 + daysHospitalization * 20000 ;
	}

	public String toString() {
		return super.toString() + ", date of hospitalization:" + dateHospitalization +
				", room No:" + roomNo + ", days of Hospitalization:" +
				daysHospitalization + ", pay fee:" + getPayFee();
	}
}
