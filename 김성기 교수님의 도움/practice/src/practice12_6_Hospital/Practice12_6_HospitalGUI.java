package practice12_6_Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 * [ 12�� �ǽ����� 6�� ��� ��� �� �Ϻ� - main() �޼ҵ� �κ�]
 * 
 *   6. ���� GUI �̺�Ʈ ó���ϱ�
 *   
 *      �ܷ�ȯ�ڿ� �Կ�ȯ�� ���, ȯ�� ����, ȯ�� ���, ������ ���� �� 5���� ���� ������ ���� GUI�� 
 *      HospitalFrame Ŭ������ �ۼ��Ǿ���. 
 *      
 *      HospitalFrame Ŭ�������� �̿ϼ� �κ� �� �־��� �κ��� �ϼ��϶�.
 *      
 */

public class Practice12_6_HospitalGUI {
	public static void main(String[] args) {
		HospitalSystem bestHospital = new HospitalSystem("����Ʈ ����");
		bestHospital.initializeHospital();
		
		new HospitalFrame(bestHospital, "����Ʈ ���� ���� �ý���");
	}
}
