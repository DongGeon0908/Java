package ex10_1_class_reference;

/**
 * [ DateCalendarUsingImportPackageMember 클래스 ]: 
 *       패키지 멤버 import하고 클래스 이름만으로 참조
 * 
 *   o 패키지에 포함되는 클래스 참조하기
 *     1) 정규화된 이름으로 패키지 멤버 참조: 패키지 멤버를 << 패키지이름.클래스이름 >>과 같이 
 *        패키지 이름과 클래스 이름을 도트로 연결시킨 정규화된 이름으로 표시하여 참조
 *     2) 패키지 멤버 import하고 클래스 이름으로 참조: 패키지 멤버를 정규화된 이름으로 import하고 
 *        클래스 이름만 표시하여 참조
 *     3) 패키지 전체 import하고 클래스 이름으로 참조: 패키지 멤버가 포함된 패키지 전체를 import하고 
 *        클래스 이름만 표시하여 참조
 *        
 *   o  패키지 멤버 import하고 클래스 이름으로 참조하기
 *     - Date 클래스와 Calendar 클래스를 참조하기 위해 패키지 멤버 import하고 클래스 이름만으로 참조
 *     - << import java.util.Date; >>, << import java.util.Calendar; >>로 사용할 클래스를 import
 *     - 패키지 이름은 생략하고 클래스 이름만으로 클래스를 참조 가능
 *   
 *   o Date와 Calendar 클래스 이용하여 현재 날짜와 시간 출력
 *     - java.util 패키지의 Date 클래스와 Calendar 클래스는 날짜와 시간 다루기 위한 클래스
 *     - 날짜와 시간 다루기 위해 Calendar 클래스가 Date 클래스보다 더 많은 메소드 제공
 *     - 최근에는 Date 클래스는 사용하지 않은 추세
 */

import java.util.Date;       // java.util 패키지의 Date 클래스를 import
import java.util.Calendar;   // java.util 패키지의 Calendar 클래스를 import

class Ex10_1_3_DateCalendar_UsingImportPackageMember {  
	public static void main(String[] args) {

		// java.util.Date import했으므로 클래스 이름 Date만으로 참조 가능함
		Date nowDate = new Date(); // Date() 객체 생성하여 nowDate에 저장

		System.out.println("\n  * 현재 날짜와 시간: " + nowDate);  // nowDate 출력

		// java.util.Calendar import했으므로 클래스 이름 Calendar만으로 참조 가능함
		Calendar nowCal = Calendar.getInstance();  // Calendar 객체 생성하여 nowCal에 저장

		System.out.println("\n  * 현재 날짜와 시간: "
				+ nowCal.get(Calendar.YEAR) + "년 " 
				+ (nowCal.get(Calendar.MONTH) + 1) + "월 " 
				+ nowCal.get(Calendar.DATE) + "일 " 
				+ nowCal.get(Calendar.HOUR_OF_DAY) + "시 " 
				+ nowCal.get(Calendar.MINUTE) + "분 "
				+ nowCal.get(Calendar.SECOND) + "초 " );
	}
}

/*
 * [ 프로그램 이해 및 실행 ]
 * 
 *   1) 이 프로그램은 Date 객체와 Calendar 객체를 생성하여 객체 참조변수에 저장한 후 
 *      년도, 월, 일, 시, 분, 초를 출력
 *   
 *      o import 문장에서 Date 클래스와 Calendar 클래스의 패키지가 명시됨
 *      
 *      o 이들 클래스를 참조할 때에는 패키지 이름을 생략해도 됨
 *      
 *      o 그 결과, 프로그램이 보다 간결하게 작성됨
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.
 *      수행할 때마다 시, 분, 초가 변화됨을 반드시 확인하라. 
 *      
 *   
 * [ 실습 과제 ]
 * 
 *   1) 대한민국의 광복절 날짜와  시간인 1945년 8월 15일 오후 12시 0분 0초를 저장하고 이를 출력하려 한다.
 *   
 *      o Calendar 클래스의 객체에 날짜와 시간을 저장하기 위한 메소드는 set()
 *      
 *        - 다음의 set() 메소드는  Calendar 객체  now에 월과 일을 8과 15로 저장     
 *           now.set(Calendar.MONTH, 8-1); // 월은 실제 월보다 1 작은 값을 저장
 *           now.set(Calendar.DATE, 15);   // 일은 실제 일의 값을 저장
 *        
 *        - 월, 일뿐 아니라 년, 월, 시, 분, 초도 set() 메소드를 이용하여 저장 가능
 *      
 *      o Calendar 클래스의 객체에서 날짜와 시간을 가져오기 위한 메소드는 get()
 *      
 *        - 다음의 get() 메소드는  Calendar 객체  now에 저장된 월과 일을 가져옴
 *           int month = now.get(Calendar.MONTH); // 월은 실제 월보다 1 작은 값이 저장되어 있음
 *           int date = now.get(Calendar.DATE);   // 일은 실제 일의 값 저장되어 있음
 *                  
 *        -  월, 일뿐 아니라 년, 월, 시, 분, 초도 get() 메소드를 이용하여 가져올 수 있음
 *      
 *      (1) 독립일과 시간을 저장하기 위한  Calendar 객체를 생성하고 
 *         이를  Calendar 객체참조변수 indepandenceDate에 저장하라.
 *          
 *      (2) indepandenceDate에 독립 날짜와 독립 시간을 저장한 후 이를 출력하는 코드를 추가로 작성하라. 
 *      
 *     
 *   2) java.util 패키지에는 난수(random number)를 생성할 수 있는 Random 클래스가 있다.
 *   
 *      o Random 클래스의 Random()은 객체 생성자이며, 객체 메소드 double nextDouble()은 
 *        0과 1 사이의 실수 난수를 반환하는 메소드이다.
 *       
 *      (1) Random 클래스를 import하기 위한 import 문을 작성하라.
 *      
 *      (2) Random 클래스의 객체를 생성하여 객체참조변수 rd에 저장하는 문장을 작성하라.
 *        
 *      (3) for 문을 이용하여 rd 객체에서 20개의 0과 1 사이의 난수를 생성하여 출력하는 코드를 작성하라.      
 */
