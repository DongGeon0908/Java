package example12_2_bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;
import java.text.*;         // DateFormat Ŭ������ ���Ͽ� import

/**
 * o GUI ȯ�濡�� ��������� ó���ϴ� Java ���α׷�
 *   - ������� �޴���ư�� ���� ��������� �����ϰ�
 *     ������ �ʿ��� �ڷḦ �Է��� �� Ȯ�ι�ư�� Ŭ���ϸ� Ư�� ���� ����
 *    
 *   - ������ ó���ϱ� ���� ���� ȭ���� 3���� Ÿ���� �ϳ��� �����ϰ� ����
 *     (�̴� PanelMgmt Ŭ������ ���� �޼ҵ带 �̿��ϸ� GUI ȭ�� ������ ���� �������� �����ֱ� ����)
 */

public class BankMainUsingGUI  {

	// ���� �߿��� main() �޼ҵ�
	public static void main(String [] args) {
		BankSystem.initializeBank();  // �̸� ���¸� �����ϰ� ������� �����ϴ� �ʱ�ȭ �޼ҵ� ȣ��

		BankFrame bf = new BankFrame();
	}	
} 

