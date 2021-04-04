#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정
#include "SkScanner.h"  // 김성기 교수가 작성한 getString(), getInt(), getDouble() 등을 위한 헤더 파일 지정#include <stdio.h>		// C에서 제공하는 표준 입출력 함수를 위한 헤더 파일 지정

/*
 * [ DayAfter.c ]: 날짜를 입력한 후 그 날짜 이후 주어진 날수 후의 날짜 구하여 출력하기
 *   
 *   o 프로그래밍 스타일
 *     1) main() 함수로만 구성
 *     2) 단순변수와 배열변수 선언, 연도, 월, 일을 입력하여 변수에 저장
 *     3) 입력된 날짜의 요일을 구해 출력 
 *  
 */ 

int main(void)  {
	printf("\n\n\n  **** 날짜와 날수를 입력하여 날수 후의 날짜 출력하기 ****\n\n");

    /*
	 *	날짜를 년도, 월, 일로 입력하여 변수에 저장 
	*/ 
    int year0, year, month0, month, day0, day; // 입력받은 날짜에서 년도, 월, 일을 구하여 저장할 변수 
    int days; // 날수를 입력하여 저장할 변수 
    
	printf("  o 시작 날짜의 연도 > ");  // 연도를 입력하기 위한 프롬프트 메시지 출력
	year0 = year = getInt();		

	printf("  o      날짜의 월   > ");  // 월을 입력하기 위한 프롬프트 메시지 출력
	month0 = month = getInt();

	printf("  o      날짜의 일   > ");  // 일을 입력하기 위한 프롬프트 메시지 출력
	day0 = day = getInt();
		
 	printf("\n  o       날수   > ");  // 날수를 입력하기 위한 프롬프트 메시지 출력
	days = getInt();
		
    /*
    *  날짜의 일에 날수를 더한 일이 해당 달의 일수보다 적을 때까지 month를 1씩  더하고 
	*   날수를 달의 일수만큼 차감함
	*   달이 13이ehlaus year를 1 증가하고 month를 1로 재설정하여 다시 반복함
	*/
	 
	
	// 각 달의 날 수를 저장하는 배열 
	int daysOfMonths[] = { 
	     0,  
		 31,  28,  31,  30,  31,  30, 
		 31,  31,  30,  31,  30,  31               
	};
	
	day = day + days; // 날짜의 일에 날수를 더함	
	
	while(1) {
		int daysOfThisMonth = daysOfMonths[month];
		
		if (month == 2 && ( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) )
		   daysOfThisMonth++;  // 달이 2월이면서 그 해가 윤년이면 달의 일수를 1 증가 시킴
		    
		if (day <= daysOfThisMonth)
			break;
			
		day = day - daysOfThisMonth;  // 그 달의 일수만큼 일수를 차감 
		
		month++;              // 달을 1 증가시킴 
		if (month > 12)  {    // 달이 13이되면 
			month = 1;        //     달을 1로 변경한고 
			year++;           //      년을 증가시킴 
		}
	}
	
	
	// 입력한 날짜의 구한 요일을 출력	 
	printf("\n\n  ** 입력한 날짜부터 날수 후의 날짜 **\n\n");
	printf("  * 날짜: %d년 %d월 %d일\n", year0, month0, day0);
	printf("  * %d일 후의 날짜: %d년 %d월 %d일\n", days, year, month, day);


	printf("\n\n  ^^ Well done! Have a good time!!! ^^\n"); // 이 문장은 프로그램의 종료를 나타내는 문장임
	
	main();
	
	return 0;
}
 
