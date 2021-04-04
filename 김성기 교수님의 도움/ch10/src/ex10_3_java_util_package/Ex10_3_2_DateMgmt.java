package ex10_3_java_util_package;

import java.util.Date;              // Date Ŭ������ ����ϱ� ���� import
import java.text.SimpleDateFormat;  // ��¥�� �ð��� ���ϴ� ������� ����ϱ� ���� import

/**
 * [ DateMgmt Ŭ����  ]: 
 *        java.util.Date Ŭ������ �޼ҵ� ����Ͽ� ��¥ �� �ð� ó��
 *  
 *   o java.util ��Ű���� Date Ŭ����
 *     - Java �ʱ⿡ �⵵, ��, ��, ��, ��, �� ���� ��¥ �� �ð� ������ �����ϰ� ó���ϱ� ���� Ŭ����
 *     - �׷��� Date Ŭ������ �޼ҵ���� ����ȭ�� �������� �ʾұ� ������ Date Ŭ������ JDK 1.1 �������� 
 *       Calendar Ŭ������ ���� ���� Ŭ������ ��ü��
 *     - Date Ŭ������ ���� �޼ҵ���� ������� �ʵ��� �ǰ�Ǵ�(deprecated) �޼ҵ�
 *     
 *   o Date ��ü�� ��¥�� �ð��� ���ϴ� ������� ����ϱ�
 *     - java.text ��Ű���� SimpleDateFormat Ŭ���� �̿�
 *     - SimpleDateFormat: Date ��ü�� ���ϴ� ������� ����ϱ� ���� �����ý�Ű�� Ŭ����
 *     - ��¥�� �ð� ���� ���ڿ�(date and time pattern string) �̿��Ͽ� ���ϴ� ������� 
 *       Date ��ü �������� ���ڿ� ���� 
 *     - ���� ���ڿ��� ��¥ ��� �Ǵ� �ð� ��� �����ϱ� ���� ���� ���ڰ� ���
 *         Y, y: �⵵        M: ��                d: ��
 *         E: ����              a: ����/����      
 *         H:0���� 23������ ��                     h: 1���� 12������ ��
 *         m: ��                s: ��
 *             
 *     - ���� ���ڿ��� ���� ������ ���(Date ��ü�� ��¥ �ð�: 2016�� 8�� 5�� 20�� 0�� 0���� ��)
 *        "y-M-d H:m:s"        ==> "2016-8-5 20:0:0" 
 *        "y/MM/dd HH:mm:ss"   ==> "2016/08/05 20:00:00" 
 *        "y-M-d(E) a h:m:s"   ==> "2016-8-5(��) ���� 8:0:0" 
 *        "y�� M�� d�� a h�� m��"  ==> "2016�� 8�� 5�� ���� 8�� 0��"      
 */

public class Ex10_3_2_DateMgmt {
	public static void main(String[] args) {

		Date now = new Date();         // ���� ��¥�� �ð��� ���� Date ��ü ����
		System.out.println("\n  * ���� ��¥�� �ð�: " + now); // �⺻�� ������� ���

		// ����� �ð����� 1900�� 1�� 1�� 0�� 0�� 0�� ���� milliseconds�� ����
		long msNow = now.getTime(); 
		System.out.println("  * ������ �и��� = " + msNow);  // ������ �и��� ���

		long ms24H = 24 * 60 * 60 * 1000;           // �Ϸ� 24�ð��� �и���
   
		long msAfter24H = msNow + ms24H;            // ������� 24�ð� ���� �и��� ���ϱ�
		Date dAfter24H = new Date(msAfter24H);      // 24�ð� �� Date ��ü ����
		System.out.println("\n  * 24�ð� �� ��¥�� �ð�: " + dAfter24H);
		System.out.println("  * 24�ð� �� �и��� = " + msAfter24H);

		long msAfter1000D = msNow + 1000 * ms24H;   // 1000�� ���� �и��� ���ϱ�
		Date dAfter1000D = new Date(msAfter1000D);  // 1000�� �� Date ��ü ����
		System.out.println("\n  * 1000�� �� ��¥�� �ð�: " + dAfter1000D);
		System.out.println("  * 1000�� �� �и��� = " + msAfter1000D);

		long msBefore100D = msNow - 100 * ms24H;    // 100�� ���� �и��� ���ϱ�
		Date dBefore100D = new Date(msBefore100D);  // 100�� �� Date ��ü ����
		System.out.println("\n  * 100�� �� ��¥�� �ð�: " + dBefore100D);
		System.out.println("  * 100�� �� �и��� = " + msBefore100D);

		// now�� dBefore100D�� ���� ���踦 ���
		if (now.compareTo(dBefore100D) < 0)
			System.out.println("\n  * " + now + ": " + dBefore100D + " ������");
		else
			System.out.println("\n  * " + now + ": " + dBefore100D + " ������");

		// ���� ���� ���ڿ��� �����ϴ� SimpleDateFormat ��ü �����Ͽ�
		// ����� ������� now ���
		SimpleDateFormat sdf =  
				new SimpleDateFormat("Y�� M�� d�� a h�� m��");
		String nowString = sdf.format(now);    // now�� �������� ���ڿ� ��ȯ
		System.out.println("\n  * ���� ��¥�� �ð�: " + nowString); 
	}
}

/*
 * [ ���α׷� ���� �� ���� ]
 * 
 *   1) �� ���α׷��� ���� Date ��ü�� �����Ͽ� ����Ѵ�.
 *      
 *   2) ���α׷��� �����Ͽ� ��� ����� Ȯ���϶�.           
 */