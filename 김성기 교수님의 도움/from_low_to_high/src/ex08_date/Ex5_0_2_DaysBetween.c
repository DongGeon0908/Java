#include <stdio.h>		// C���� �����ϴ� ǥ�� ����� �Լ��� ���� ��� ���� ����
#include "SkScanner.h"  // �輺�� ������ �ۼ��� getString(), getInt(), getDouble() ���� ���� ��� ���� ����#include <stdio.h>		// C���� �����ϴ� ǥ�� ����� �Լ��� ���� ��� ���� ����

/*
 * [ DaysBetween ]: �� ��¥ ������ ���� ���ϱ� 
 *   
 *   o ���α׷��� ��Ÿ��
 *     1) main() �Լ��θ� ����
 *     2) �ܼ������� �迭���� ����, ����, ��, ���� �Է��Ͽ� ������ ����
 *     3) �Էµ� ��¥ ������ ���� ���� ��� 
 *  
 */ 

int main(void)  {
	printf("\n\n\n  **** ��¥ ������ ���� ���Ͽ� ����ϱ� ****\n\n");

    /*
	 *	���� ��¥�� ���� ��¥�� �⵵, ��, �Ϸ� �Է��Ͽ� ������ ���� 
	*/ 
    int yearFirst, monthFirst, dayFirst; // ���� �⵵, ��, ���� �Է��Ͽ� ������ ���� 
    int yearLast, monthLast, dayLast;    // ���� �⵵, ��, ���� �Է��Ͽ� ������ ���� 

	printf("  o ���� ��¥�� ���� > ");  // ������ �Է��ϱ� ���� ������Ʈ �޽��� ���
	yearFirst = getInt();		

	printf("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
	monthFirst = getInt();

	printf("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
	dayFirst = getInt();
		
	printf("\n  o ���� ��¥�� ���� > ");  // ������ �Է��ϱ� ���� ������Ʈ �޽��� ���
	yearLast = getInt();		

	printf("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
	monthLast = getInt();

	printf("  o      ��¥�� ��   > ");  // ���� �Է��ϱ� ���� ������Ʈ �޽��� ���
	dayLast = getInt();
		
    /*
	 *	���� 1�� 1�� 1�Ϻ��� �Էµ� ��¥������ ������ ����
	 *   1�� 365�ϰ� ���� ȸ���� �̿��Ͽ� ���⵵������ ������ ���ϰ�
	 *   �Է� �⵵�� �����̰� ���� 3�� �����̸� ���� 2�� 29���� �������Ƿ� 1�� ������ 
	*/ 		
	int yearMinus1 = yearFirst - 1;
	int monthMinus1 = monthFirst - 1;
	
	// �� �޺��� ���� �ޱ����� ������ �Ի��Ͽ� �����ϴ� �迭 
	int daysUntilMonths[] = { 
	     0,  31,  31+28,  31+28+31, // 
	     31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		 31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};
	
	int daysFirstFrom00010101; // 1�� 1�� 1�Ϻ��� ���� ��¥������ ������ ���Ͽ� �����ϴ� ���� 
	
	printf("\n\n  <for debug>  ���� ��¥: %d�� %d�� %d��\n", yearFirst, monthFirst, dayFirst);
	daysFirstFrom00010101 = yearMinus1 * 365 + daysUntilMonths[monthMinus1] + dayFirst - 1;
	printf("\n\n  <for debug>  ���� 1�� 1�� 1�Ϻ����� �⺻ ���� daysFirstFrom00010101 = %d��\n", daysFirstFrom00010101);	
	
	// yearMinus1���� ���� ȸ����ŭ ������ ������	
	// << yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400 >>�� ���� 1����� yearMinus1������ ���� ȸ���� ���ϴ� ������ 
	int cntLeapYear =  yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400;
	printf("  <for debug>  ���� ȸ�� cntLeapYear = %d��\n", cntLeapYear);	

	daysFirstFrom00010101 += cntLeapYear;  // ���� ���� ȸ���� ���� 
	printf("  <for debug>  ����ȸ�� ���� �� daysFirstFrom00010101 = %d��\n", daysFirstFrom00010101);	
	
	// ���� ��¥�� ������ �����ΰ��� Ȯ��: ������ 4�� ����̸�� 100�� ����� �ƴ� ��� �Ǵ� 400�� ����� ��� 
	int isLeapYear = (yearFirst % 4 == 0) && (yearFirst % 100 != 0) || (yearFirst % 400 == 0);
	printf("  <for debug>  �Է��� �⵵�� ���� ���� isLeapYear = %d\n", isLeapYear);	

	// ���� ��¥�� ���� 3�� �̻��̰� �⵵�� �����̸� ������ 2�� 29���� �������Ƿ� 1�� ������ 
	daysFirstFrom00010101 = (monthFirst >= 3  && isLeapYear == 1) ? daysFirstFrom00010101 + 1 : daysFirstFrom00010101;
	printf("  <for debug>  �Է� ������ ���� ���� �� daysFirstFrom00010101 = %d��\n", daysFirstFrom00010101);	
	
 
 	int daysLastFrom00010101; // 1�� 1�� 1�Ϻ��� ���� ��¥������ ������ ���Ͽ� �����ϴ� ���� 
	yearMinus1 = yearLast - 1;
	monthMinus1 = monthLast - 1;

	printf("\n\n  <for debug>  ���� ��¥: %d�� %d�� %d��\n", yearFirst, monthFirst, dayFirst);
	daysLastFrom00010101 = yearMinus1 * 365 + daysUntilMonths[monthMinus1] + dayLast  - 1;
	printf("  <for debug>  ���� 1�� 1�� 1�Ϻ����� �⺻ ���� daysLastFrom00010101 = %d��\n", daysLastFrom00010101);	
	
	// yearMinus1���� ���� ȸ����ŭ ������ ������	
	// << yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400 >>�� ���� 1����� yearMinus1������ ���� ȸ���� ���ϴ� ������ 
	cntLeapYear =  yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400;
	printf("  <for debug>  ���� ȸ�� cntLeapYear = %d��\n", cntLeapYear);	

	daysLastFrom00010101 += cntLeapYear;  // ���� ���� ȸ���� ���� 
	printf("  <for debug>  ����ȸ�� ���� �� daysLastFrom00010101 = %dȸ\n", daysLastFrom00010101);	
	
	// ���� ��¥�� ������ �����ΰ��� Ȯ��: ������ 4�� ����̸�� 100�� ����� �ƴ� ��� �Ǵ� 400�� ����� ��� 
	isLeapYear = (yearLast % 4 == 0) && (yearLast % 100 != 0) || (yearLast % 400 == 0);
	printf("  <for debug>  �Է��� �⵵�� ���� ���� isLeapYear = %d\n", isLeapYear);	

	// ���� ��¥�� ���� 3�� �̻��̰� �⵵�� �����̸� ������ 2�� 29���� �������Ƿ� 1�� ������ 
	daysLastFrom00010101 = (monthLast >= 3  && isLeapYear == 1) ? daysLastFrom00010101 + 1 : daysLastFrom00010101;
	printf("  <for debug>  �Է� ������ ���� ���� �� daysLastFrom00010101 = %d��\n", daysLastFrom00010101);	
	

    /*
	 *	���ᳯ¥�� �������� ���� ��¥�� ������ �� �� ��¥���� ���� ���Ͽ� ��� 
	*/ 

	// �Է��� ��¥ ������ ������ ���	 
	printf("\n\n  ** �Է��� ��¥ ������ ���� **\n\n");
	printf("  * ���� ��¥: %d�� %d�� %d��\n", yearFirst, monthFirst, dayFirst);
	printf("  * ���� ��¥: %d�� %d�� %d��\n", yearLast, monthLast, dayLast);
	printf("  * ���� ��¥�� ���� ��¥ ������ ����: %d \n\n", daysLastFrom00010101 - daysFirstFrom00010101);  // ���� = ���� ��¥�� ���� - ���� ��¥�� ���� 


	printf("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // �� ������ ���α׷��� ���Ḧ ��Ÿ���� ������
	
	main();
	
	return 0;
}
 
