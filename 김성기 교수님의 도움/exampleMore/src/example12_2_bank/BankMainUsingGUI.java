package example12_2_bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.text.*;         // DateFormat 클래스를 위하여 import

/**
 * o GUI 환경에서 은행업무를 처리하는 Java 프로그램
 *   - 은행업무 메뉴버튼을 통해 은행업무를 선택하고
 *     업무별 필요한 자료를 입력한 후 확인버튼을 클릭하면 특정 업무 수행
 *    
 *   - 업무를 처리하기 위한 메인 화면은 3가지 타입중 하나가 랜덤하게 선택
 *     (이는 PanelMgmt 클래스의 여러 메소드를 이용하면 GUI 화면 구성이 아주 용이함을 보여주기 위함)
 */

public class BankMainUsingGUI  {

	// 가장 중요한 main() 메소드
	public static void main(String [] args) {
		BankSystem.initializeBank();  // 미리 계좌를 생성하고 입출금을 수행하는 초기화 메소드 호출

		BankFrame bf = new BankFrame();
	}	
} 

