package ex10_1_class_reference;

/**
 * [ DateCalendarUsingImportAllPackageMembers 클래스 ]: 
 *        패키지 멤버 전체 import하고 클래스 이름으로 참조
 * 
 *   o 패키지에 포함되는 클래스 참조하기
 *     1) 정규화된 이름으로 패키지 멤버 참조: 패키지 멤버를 << 패키지이름.클래스이름 >>과 같이 
 *        패키지 이름과 클래스 이름을 도트로 연결시킨 정규화된 이름으로 표시하여 참조
 *     2) 패키지 멤버 import하고 클래스 이름으로 참조: 패키지 멤버를 정규화된 이름으로 import하고 
 *        클래스 이름만 표시하여 참조
 *     3) 패키지 전체 import하고 클래스 이름으로 참조: 패키지 멤버가 포함된 패키지 전체를 import하고 
 *        클래스 이름만 표시하여 참조
 *        
 *   o 패키지 전체 import하고 클래스 이름으로 참조하기
 *     - << import 패키지.*; >>로 import하면 
 *       한 패키지의 모든 멤버를 클래스 이름만으로 사용 가능
 *       
 *     - Date 클래스와 Calendar 클래스 참조하기 위해 java.util 패키지의 모든 멤버 import
 *     - << import java.util.*; >>로 import하면 
 *       java.util 패키지의 모든 클래스를 클래스 이름만으로 참조 가능
 *       
 *   o Date와 Calendar 클래스 이용하여 현재 날짜와 시간 출력
 *     - java.util 패키지의 Date 클래스와 Calendar 클래스는 날짜와 시간 다루기 위한 클래스
 *     - 날짜와 시간 다루기 위해 Calendar 클래스가 Date 클래스보다 더 많은 메소드 제공
 *     - 최근에는 Date 클래스는 사용하지 않은 추세
 */

import java.util.*;  // java.util 패키지의 멤버 클래스 전체를 import

class Ex10_1_4_DateCalendar_UsingImportAllPackageMembers {  
   public static void main(String[] args) {

     // java.util.* import했으므로 클래스 이름 Date만으로 참조 가능함
     Date nowDate = new Date(); // Date() 객체 생성하여 now에 저장
	
     System.out.println("\n  * 현재 날짜와 시간: " + nowDate);  // nowDate 출력

     // java.util.* import했으므로 클래스 이름 Calendar만으로 참조 가능함
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
 *   1) 이 프로그램은 Date 객체와 Calendar 객체를 생성하여 객체 참조변수에 저장한 후 년도, 월, 일, 시, 분, 초를 출력
 *   
 *      o import 문장 << import java.util.*; >>에서 java.util 패키지를 모든 클래스가 import되게 함
 *      
 *      o java.util 패키지를 참조할 때에는 패키지 이름을 생략해도 됨
 *      
 *      o 그 결과, 프로그램이 보다 간결하게 작성됨
 *      
 *   2) 프로그램을 실행하여 출력 결과를 확인하라.
 *      수행할 때마다 시, 분, 초가 변화됨을 반드시 확인하라.        
 *      
 *      
 * [ 실습 과제 ]
 * 
 *   1) java.util 패키지에는 난수(random number)를 생성할 수 있는 Random 클래스가  있다.
 *   
 *      o Random()은 Random 클래스의 객체 생성자이며, 객체 메소드 double nextDouble()은 
 *        0과 1 사이의 실수 난수를 반환하는 메소드이다.
 *       
 *      (1) Random 클래스의 객체를 생성하여 객체참조변수 rd에 저장하는 문장을 작성하라.
 *          이 때  Random 클래스를 import하는 import 문은 생략해도 됨을 확인하라.
 *        
 *      (2) for 문을 이용하여 rd 객체에서 20개의 0과 1 사이의 난수를 생성하여 출력하고 
 *          평균을 구하여 출력하는 코드를 작성하라.      
 *      
 *   2) java.awt 패키지에는 버튼을 생성할 수 있는 Button 클래스가  있다.
 *   
 *      Button 클래스의 Button(String label)은 주어진 문자열을 버튼 객체의 레이블로 저장하는 객체 생성자이며, 
 *      객체 메소드 String getLabel()은 객체 생성 시 저장된 레이블을 반환한다. 

 *              
 *      (1) 20개의 Button 객체를 원소로 저장하는 배열객체를 생성하여 배열변수 buttons에 저장하라. 
 *          이 때 Button 클래스를 import하는 import 문은 생략하면 오류가 발생함을 확인하라.
 *       
 *      (2) 20개의 Button 객체를 생성하면서 레이블로 "Button-1", "Button-2" 등을 차례로 저장하고, 
 *          객체를 배열변수 buttons에 원소로 저장하는 코드를 작성하라.
 *          
 *      (3) 배열변수 buttons의 원소들에 대해 getLabel() 메소드를 호출하여 레이블들을 차례로 출력하는 
 *          코드를 작성하라.   
 */