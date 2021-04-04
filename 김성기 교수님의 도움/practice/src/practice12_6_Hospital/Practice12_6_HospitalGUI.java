package practice12_6_Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 * [ 12장 실습문제 6번 모범 답안 중 일부 - main() 메소드 부분]
 * 
 *   6. 병원 GUI 이벤트 처리하기
 *   
 *      외래환자와 입원환자 등록, 환자 진료, 환자 퇴원, 병원비 정산 등 5가지 병원 업무를 위한 GUI는 
 *      HospitalFrame 클래스로 작성되었다. 
 *      
 *      HospitalFrame 클래스에서 미완성 부분 중 주어진 부분을 완성하라.
 *      
 */

public class Practice12_6_HospitalGUI {
	public static void main(String[] args) {
		HospitalSystem bestHospital = new HospitalSystem("베스트 병원");
		bestHospital.initializeHospital();
		
		new HospitalFrame(bestHospital, "베스트 병원 업무 시스템");
	}
}
