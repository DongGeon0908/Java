#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정
#include "SkScanner.h"  // 김성기 교수가 작성한 getString(), getInt(), getDouble() 등을 위한 헤더 파일 지정#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정

/*
 * [ DaysBetween ]: 두 날짜 사이의 날수 구하기 
 *   
 *   o 프로그래밍 스타일
 *     1) main() 함수로만 구성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 입력된 날짜 사이의 날수 구해 출력 
 *  
 */ 

int main(void)  {
	printf("\n\n\n  **** 날짜 사이의 날수 구하여 출력하기 ****\n\n");

    /*
	 *	시작 날짜와 종료 날짜를 년도, 월, 일로 입력하여 변수에 저장 
	*/ 
    int yearFirst, monthFirst, dayFirst; // 시작 년도, 월, 일을 입력하여 저장할 변수 
    int yearLast, monthLast, dayLast;    // 종료 년도, 월, 일을 입력하여 저장할 변수 

	printf("  o 시작 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
	yearFirst = getInt();		

	printf("  o      날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
	monthFirst = getInt();

	printf("  o      날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
	dayFirst = getInt();
		
	printf("\n  o 종료 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
	yearLast = getInt();		

	printf("  o      날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
	monthLast = getInt();

	printf("  o      날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
	dayLast = getInt();
		
    /*
	 *	서기 1년 1월 1일부터 입력된 날짜까지의 날수를 구함
	 *   1년 365일과 윤년 회수를 이용하여 전년도까지의 날수를 구하고
	 *   입력 년도가 윤년이고 월이 3월 이후이면 윤달 2월 29일이 지났으므로 1을 더해줌 
	*/ 		
	int yearMinus1 = yearFirst - 1;
	int monthMinus1 = monthFirst - 1;
	
	// 각 달별로 이전 달까지의 날수를 게산하여 저장하는 배열 
	int daysUntilMonths[] = { 
	     0,  31,  31+28,  31+28+31, // 
	     31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		 31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};
	
	int daysFirstFrom00010101; // 1년 1월 1일부터 시작 날짜까지의 날수를 구하여 저장하는 변수 
	
	printf("\n\n  <for debug>  시작 날짜: %d년 %d월 %d일\n", yearFirst, monthFirst, dayFirst);
	daysFirstFrom00010101 = yearMinus1 * 365 + daysUntilMonths[monthMinus1] + dayFirst - 1;
	printf("\n\n  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysFirstFrom00010101 = %d일\n", daysFirstFrom00010101);	
	
	// yearMinus1까지 윤년 회수만큼 날수를 더해줌	
	// << yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400 >>은 서기 1년부터 yearMinus1까지의 윤년 회수를 구하는 수식임 
	int cntLeapYear =  yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400;
	printf("  <for debug>  윤년 회수 cntLeapYear = %d일\n", cntLeapYear);	

	daysFirstFrom00010101 += cntLeapYear;  // 구한 윤년 회수를 더함 
	printf("  <for debug>  윤년회수 더한 후 daysFirstFrom00010101 = %d일\n", daysFirstFrom00010101);	
	
	// 시작 날짜의 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
	int isLeapYear = (yearFirst % 4 == 0) && (yearFirst % 100 != 0) || (yearFirst % 400 == 0);
	printf("  <for debug>  입력한 년도의 윤년 여부 isLeapYear = %d\n", isLeapYear);	

	// 시작 날짜의 달이 3월 이상이고 년도가 윤년이면 윤달인 2월 29일을 지났으므로 1을 더해줌 
	daysFirstFrom00010101 = (monthFirst >= 3  && isLeapYear == 1) ? daysFirstFrom00010101 + 1 : daysFirstFrom00010101;
	printf("  <for debug>  입력 연도의 윤년 보정 후 daysFirstFrom00010101 = %d일\n", daysFirstFrom00010101);	
	
 
 	int daysLastFrom00010101; // 1년 1월 1일부터 종료 날짜까지의 날수를 구하여 저장하는 변수 
	yearMinus1 = yearLast - 1;
	monthMinus1 = monthLast - 1;

	printf("\n\n  <for debug>  종료 날짜: %d년 %d월 %d일\n", yearFirst, monthFirst, dayFirst);
	daysLastFrom00010101 = yearMinus1 * 365 + daysUntilMonths[monthMinus1] + dayLast  - 1;
	printf("  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysLastFrom00010101 = %d일\n", daysLastFrom00010101);	
	
	// yearMinus1까지 윤년 회수만큼 날수를 더해줌	
	// << yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400 >>은 서기 1년부터 yearMinus1까지의 윤년 회수를 구하는 수식임 
	cntLeapYear =  yearMinus1 / 4 - yearMinus1 / 100 + yearMinus1 / 400;
	printf("  <for debug>  윤년 회수 cntLeapYear = %d일\n", cntLeapYear);	

	daysLastFrom00010101 += cntLeapYear;  // 구한 윤년 회수를 더함 
	printf("  <for debug>  윤년회수 더한 후 daysLastFrom00010101 = %d회\n", daysLastFrom00010101);	
	
	// 종료 날짜의 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
	isLeapYear = (yearLast % 4 == 0) && (yearLast % 100 != 0) || (yearLast % 400 == 0);
	printf("  <for debug>  입력한 년도의 윤년 여부 isLeapYear = %d\n", isLeapYear);	

	// 종료 날짜의 달이 3월 이상이고 년도가 윤년이면 윤달인 2월 29일을 지났으므로 1을 더해줌 
	daysLastFrom00010101 = (monthLast >= 3  && isLeapYear == 1) ? daysLastFrom00010101 + 1 : daysLastFrom00010101;
	printf("  <for debug>  입력 연도의 윤년 보정 후 daysLastFrom00010101 = %d일\n", daysLastFrom00010101);	
	

    /*
	 *	종료날짜의 날수에서 시작 날짜의 날수를 빼 두 날짜간의 날수 구하여 출력 
	*/ 

	// 입력한 날짜 사이의 날수를 출력	 
	printf("\n\n  ** 입력한 날짜 사이의 날수 **\n\n");
	printf("  * 시작 날짜: %d년 %d월 %d일\n", yearFirst, monthFirst, dayFirst);
	printf("  * 종료 날짜: %d년 %d월 %d일\n", yearLast, monthLast, dayLast);
	printf("  * 시작 날짜와 종료 날짜 사이의 날수: %d \n\n", daysLastFrom00010101 - daysFirstFrom00010101);  // 날수 = 종료 날짜의 날수 - 시작 날짜의 날수 


	printf("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	
	main();
	
	return 0;
}
 
