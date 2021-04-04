#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정
#include "SkScanner.h"  // 김성기 교수가 작성한 getString(), getInt(), getDouble() 등을 위한 헤더 파일 지정#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정

/*
 * [ Weekday.c ]: 년월일을 입력하여 그 날짜의 요일을 출력하기
 *   
 *   o 프로그래밍 스타일
 *     1) main() 함수로만 구성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 입력된 날짜의 요일을 구해 출력 
 *  
 */ 

int main(void)  {
	printf("\n\n\n  **** 날짜 입력하여 그 날짜의 요일 출력하기 ****\n\n");

    /*
	 *	날짜를 년도, 월, 일로 입력하여 변수에 저장 
	*/ 
    int year, month, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 
    
	printf("  o 요일 구할 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
	year = getInt();		

	printf("  o           날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
	month = getInt();

	printf("  o           날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
	day = getInt();
		
    /*
	 *	서기 1년 1월 1일부터 입력된 날짜까지의 날수를 구함
	 *   1년 365일과 윤년 회수를 이용하여 전년도까지의 날수를 구하고
	 *   입력 년도가 윤년이고 월이 3월 이후이면 윤달 2월 29일이 지났으므로 1을 더해줌 
	*/ 		
	int lastYear = year - 1;
	int lastMonth = month - 1;
	
	// 각 달별로 그 달까지의 날수를 게산하여 저장하는 배열 
	int daysUntilMonth[] = { 
	     0,  31,  31+28,  31+28+31, // 
	     31+28+31+30, 31+28+31+30+31, 31+28+31+30+31+30, 31+28+31+30+31+30+31,       
		 31+28+31+30+31+30+31+31, 31+28+31+30+31+30+31+31+30, 31+28+31+30+31+30+31+31+30+31, 31+28+31+30+31+30+31+31+30+31+30                
	};
	
	int daysFrom00010101; // 1년 1월 1일부터 입력된 날짜까지의 날수를 구하여 저장하는 변수 
	

	daysFrom00010101 = lastYear * 365 + daysUntilMonth[lastMonth] + day - 1;
	printf("\n\n  <for debug>  서기 1년 1월 1일부터의 기본 날수 daysFrom00010101 = %d일\n", daysFrom00010101);	
	
	// lastYear까지 윤년 회수만큼 날수를 더해줌	
	// << lastYear / 4 - lastYear / 100 + lastYear / 400 >>은 서기 1년부터 lastYear까지의 윤년 회수를 구하는 수식임 
	int cntLeapYear =  lastYear / 4 - lastYear / 100 + lastYear / 400;
	printf("  <for debug>  윤년 회수 cntLeapYear = %d일\n", cntLeapYear);	

	daysFrom00010101 += cntLeapYear;  // 구한 윤년 회수를 더함 
	printf("  <for debug>  윤년회수 더한 후 daysFrom00010101 = %d일\n", daysFrom00010101);	
	
	// 날짜의 연도가 윤년인가를 확인: 윤년은 4의 배수이면수 100의 배수가 아니 경우 또는 400의 배수인 경우 
	int isLeapYear = (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
	printf("  <for debug>  입력한 년도의 윤년 여부 isLeapYear = %d\n", isLeapYear);	

	// 입력한 날짜의 달이 3월 이상이고 년도가 윤년이면 윤달인 2월 29일을 지났으므로 1을 더해줌 
	daysFrom00010101 = (month >= 3  && isLeapYear == 1) ? daysFrom00010101 + 1 : daysFrom00010101;
	printf("  <for debug>  입력 연도의 윤년 보정 후 daysFrom00010101 = %d일\n", daysFrom00010101);	
	
    /*
	 *	구한 날수를 7로 나눈 나머지를 이용하여 요일을 구하여 출력 
	 *   - 서기 1년 1월 1일은 월요일
	 *   - 1월 1일 이후 날수의 7로 나눈 나머지가 요일을 구하는  중요한 단서임 
	*/ 
    String weekdayNames[] = {"월", "화", "수", "목", "금", "토", "일"};
    

	// 1년 1월 1일부터 입력된 날짜까지의 날수를 7로 나눈 나머지를 구함 
	//   이값이 0이면 월, 1이면 화, 2이면 수, 3이면 목, 4이면 금, 5이면 토, 6이면 일요일임 
	int weekdayIndex = daysFrom00010101 % 7;
	printf("  <for debug>  날 수를 7로 나눈 나머지 weekdayIndex = %d\n", weekdayIndex);	
	
	// 입력한 날짜의 구한 요일을 출력	 
	printf("\n\n  ** 입력한 날짜의 요일 **\n\n");
	printf("  * 날짜: %d년 %d월 %d일\n", year, month, day);
	printf("  * 요일: %s \n\n", weekdayNames[weekdayIndex]);  // 날짜를 요일을 나타내는 weekdayNames[weekdayIndex] 출력


	printf("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	
	main();
	
	return 0;
}
 
